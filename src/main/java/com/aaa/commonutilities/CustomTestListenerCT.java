package com.aaa.commonutilities;

import com.aaa.accelerators.TestEngineWeb;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class CustomTestListenerCT extends TestListenerAdapter {
	private static final String ROOT = System.getProperty("user.dir");
	private static final String SEPARATOR = File.separator;
	private static ExtentReports extent = ExtentManager.getInstance();
	private static final Logger LOGGER = LogManager.getLogger(CustomTestListenerCT.class);

	/**
	 * Override method to implement
	 * to some custom logging and ExtentReport
	 */

	@Override
	public synchronized void onStart(ITestContext context) {
		super.onStart(context);
		String testSuite = context.getSuite().getName();
		LOGGER.info("[Test Suite START (Thread=" + Thread.currentThread().getId() + ")] " + testSuite);
		//set test suite
		extent.setSystemInfo("SuiteExecuted", context.getSuite().getParameter("suiteExecuted"));
		extent.setSystemInfo("SuiteExecutionType", context.getSuite().getParameter("executionType"));
		extent.setSystemInfo("OS", context.getCurrentXmlTest().getParameter("platformName"));
		extent.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		extent.setSystemInfo("BrowserVersion", context.getCurrentXmlTest().getParameter("browserVersion"));
		extent.setSystemInfo("AutomationEnv", context.getCurrentXmlTest().getParameter("environment"));
		extent.setSystemInfo("AutomationName", context.getCurrentXmlTest().getParameter("automationName"));
		extent.setSystemInfo("SeleniumGridUrl", context.getCurrentXmlTest().getParameter("seleniumgridurl"));
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		super.onFinish(context);
		LOGGER.info("[Test Suite Finish (Thread=" + Thread.currentThread().getId() + ")] " + context.getSuite().getName());
		ExtentManager.getInstance().flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		super.onTestStart(result);
		String testClass = result.getTestClass().getName().replaceAll(".+\\.", "");
		String testMethod = result.getMethod().getMethodName();
		String[] testGroups = result.getMethod().getGroups();
		String testStart = "[TEST START (Thread=" + Thread.currentThread().getId() + ")] " + testClass + " - " + testMethod;
		LOGGER.info(testStart);
		//set test child and group
		//test is set @BeforeClass in TestEngineWeb.java
		ExtentReportThread.startChildTest(testClass + "." + testMethod).assignCategory(testGroups);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		String testName = tr.getTestClass().getName().replaceAll(".+\\.", "") + " - " + tr.getMethod().getMethodName();
		String testPass = "[***TEST PASS (Thread=" + Thread.currentThread().getId() + ")***] " + testName;
		LOGGER.info(testPass);
		Markup m = MarkupHelper.createLabel(testPass, ExtentColor.GREEN);
		ExtentReportThread.getChildTest().pass(m);
	}

	@Override
	public synchronized void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		Object currentClass = tr.getInstance();
		WebDriver driver = ((TestEngineWeb) currentClass).driver;
		if (TestEngineWeb.Environment.equalsIgnoreCase("cloudSauceLabs")) {
			((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
		}
		//Timestamp the screen shot
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
		Calendar calendar = Calendar.getInstance();
		String timeStamp = simpleDateFormat.format(calendar.getTime());
		String baseDir = ROOT + SEPARATOR + "results" + SEPARATOR + "test-output";
		File scrFile;
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = tr.getMethod().getMethodName() + "_" + timeStamp + "_TestFAILED.png";
		File destination = new File(baseDir + SEPARATOR + fileName);
		// adding screenshots to log
		try {
			FileUtils.copyFile(scrFile, destination);
			ExtentReportThread.getChildTest().addScreenCaptureFromPath(fileName);
		} catch (IOException e) {
			ExtentReportThread.getChildTest().fail(e);
		}
		String errHeader = " [***TEST FAIL (Thread=" + Thread.currentThread().getId() + ")***] " + tr.getTestClass().getName().replaceAll(".+\\.", "") + " - " + tr.getMethod().getMethodName();
		String errMsg = errHeader + "\r\n" + tr.getThrowable().getMessage() + "\r\n\t" +
				Arrays.toString(tr.getThrowable().getStackTrace()).replaceAll(",", "\r\n\t");
		LOGGER.error(errMsg);
		Markup m;
		String jiraId;
		if (tr.getMethod().getConstructorOrMethod().getMethod().getAnnotation(KnownBugs.class) != null) {
			String[] bugList = tr.getMethod().getConstructorOrMethod().getMethod().getAnnotation(KnownBugs.class).jiraIds();
			if (bugList.length != 0) {
				for (String bug : bugList) {
					jiraId = bug.toUpperCase();
					m = MarkupHelper.createLabel("[OPEN DEFECT]: <a target=\"_blank\" href=\"http://jira.pure.local/browse/" + jiraId +
							"\">" + jiraId + "</a>", ExtentColor.PURPLE);
					ExtentReportThread.getTest().warning(m);
					ExtentReportThread.getChildTest().warning(m);
				}
			}
		}
		m = MarkupHelper.createLabel(errHeader, ExtentColor.RED);
		ExtentReportThread.getChildTest().fail(m);
		ExtentReportThread.getChildTest().fail(tr.getThrowable());
	}

	@Override
	public synchronized void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		String skipErr = " [TEST SKIP (Thread=" + Thread.currentThread().getId() + ")] " + tr.getTestClass().getName().replaceAll(".+\\.", "") + " - " + tr.getMethod().getMethodName();
		LOGGER.info(skipErr);
		Markup m = MarkupHelper.createLabel(skipErr, ExtentColor.RED);
		ExtentReportThread.getChildTest().skip(m);
		ExtentReportThread.getChildTest().skip(tr.getThrowable());
	}

	@Override
	public synchronized void onConfigurationFailure(ITestResult tr) {
		super.onConfigurationFailure(tr);
		String testClass = tr.getTestClass().getName().replaceAll(".+\\.", "");
		String testMethod = tr.getMethod().getMethodName();
		Object currentClass = tr.getInstance();
		String errHeader = " [TEST CONFIG FAIL (Thread=" + Thread.currentThread().getId() + ")] " + testClass + " - " + testMethod;
		WebDriver driver = ((TestEngineWeb) currentClass).driver;
		AppiumDriver ad=((TestEngineWeb)currentClass).appiumDriver;
	/*	if (TestEngineWeb.Environment.equalsIgnoreCase("cloudSauceLabs")) {
			((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
		}*/
		//Timestamp the screen shot
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
		Calendar calendar = Calendar.getInstance();
		String timeStamp = simpleDateFormat.format(calendar.getTime());
		String baseDir = ROOT + SEPARATOR + "results" + SEPARATOR + "test-output";
		File scrFile=null;
		if(driver!=null)
		{
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
		}
		else if(ad!=null)
		{
			scrFile = ((TakesScreenshot) ad).getScreenshotAs(OutputType.FILE);
			System.out.println(scrFile.getAbsolutePath());
		}
		String fileName = testMethod + "_ConfigFail_" + timeStamp + ".png";
		File destination = new File(baseDir + SEPARATOR + fileName);
		// adding screenshots to log
		try {
			FileUtils.copyFile(scrFile, destination);
			ExtentReportThread.getChildTest().addScreenCaptureFromPath(fileName);
		} catch (IOException e) {
			ExtentReportThread.getChildTest().fail(e);
		}
		String err = errHeader + "\r\n" + tr.getThrowable().getMessage() + "\r\n\t" +
				Arrays.toString(tr.getThrowable().getStackTrace()).replaceAll(",", "\r\n\t");
		LOGGER.error(err);
		Markup m = MarkupHelper.createLabel(errHeader, ExtentColor.RED);
		ExtentReportThread.getChildTest().fail(m);
		ExtentReportThread.getChildTest().fail(tr.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
}