package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DILockedCalls extends LoginLib {

	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();
	DIMCDLib dimcdLib = new DIMCDLib();
	DIHomeLib diHome = new DIHomeLib();
	DILoginLib diLoginLib = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	public static String callID;
	String callDateCreated;
	String callDateStr;

	/************************************************************************
	 * Script Name :-LockedCalls
	 * Method Name :-
	 * Module	  :- DI
	 * Test Case ID:-1990
	 * Script Date :-
	 * Author      :-Nidhi
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
	 *************************************************************************/
	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyLockedCallStatus(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyLockedCallStatus", TestData, "D3Dispatch");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyLockedCallStatus", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("1999:TC_DI Locked Calls" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
					System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_32Bit.exe");
					EventFiringWebDriver driver1 = null;
					//create a call
					loginD3CreateCall(data);
					//login with a user
					navigateToApplication("DI");
					diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
					role.selectRoleInDispatch(data.get("RoleDispatch"));
					role.clickOnProceedBtnInDispatchRoleLogin();
					diLoginLib.waitcloseAllBusyIcons();
					diHome.clickOnCloseIconOnQueueSelection();

					//open a new tab
					String currentUrl = driver.getCurrentUrl();
					reporter.SuccessReport("<b>Opening New browser</b>","<b>Opening New Browser</b>");
					driver1 = new EventFiringWebDriver(new ChromeDriver());
					driver1.manage().window().maximize();
					driver1.get(currentUrl);

					//login with second user
					waitForVisibilityOfElement(LoginPage.txtLoginName, "User Name Text Field",driver1);
					type(LoginPage.txtLoginName, data.get("DI2LoginName"), "User Name",driver1);
					waitForVisibilityOfElement(LoginPage.txtLoginPassword, "Password Text Field",driver1);
					type(LoginPage.txtLoginPassword, data.get("DI2Password"), "Password",driver1);
					waitForVisibilityOfElement(LoginPage.btnLogin, "Login Button",driver1);
					click(LoginPage.btnLogin,"Login",driver1);
					waitForVisibilityOfElement(LoginRolePage.btnProceedLogin, "Proceed to Login",driver1);
					click(LoginRolePage.btnProceedLogin,"Proceed button",driver1);
					Thread.sleep(3000);
					waitForVisibilityOfElement(DIHomePage.iconCloseOnQueueSelection, "Close Button is Available",driver1);
					click(DIHomePage.iconCloseOnQueueSelection, "Close Button is Available",driver1);

					//search a created call
					waitForVisibilityOfElement(DIHomePage.btnSearchCalls, "Search calls Link",driver1);
					click(DIHomePage.btnSearchCalls, "Search calls Link",driver1);

					waitForVisibilityOfElement(DIHomePage.txtStartDate, "Start Date text field",driver1);
					type(DIHomePage.txtStartDate,data.get("StartDate"), "Start Date text field",driver1);

					waitForVisibilityOfElement(DIHomePage.txtSearchCallID, "Click on CallID Field",driver1);
					type(DIHomePage.txtSearchCallID,callID, "CallID Field",driver1);
					waitForVisibilityOfElement(DIHomePage.SearchButton, "Search Button",driver1);
					click(DIHomePage.SearchButton, "Search Button",driver1);
					//click and open MCD window
					waitForVisibilityOfElement(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link",driver1);
					click(DIHomePage.clickOnCallIdLinkInDI, "CallIdOrDate Link",driver1);
					Thread.sleep(4000);

					//searcha created call with user
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("StartDate"));
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					//click and open MCD window
					diHome.clickOnCallDateOrIDLink();

					//verify right hand bar is grayed out. We are checking with the button is disabled or not by getting the class value
					String classVal = getAttributeValue(DIMCDPage.assignInRightHandBarInMCD,"class");
					assertTrue(classVal.contains("disabled"),"Right hand bar is disabled");

					//verify lock icon on mcd window
					boolean icon = dimcdLib.verifyLockIcon();
					assertTrue(icon, "<b>lock icon in the top right bar is displayed:</b>");
					//capture user of locked call
					String name = dimcdLib.getUsernameForLockedCall();
					assertTrue(!name.equalsIgnoreCase(null), "<b>User who has the call locked is displayed :</b>"+name);
					//verify comment is added
					dimcdLib.clickOnAddButton();
					boolean comment =dimcdLib.enterAddCommentAndSave(data.get("comment"));
					dimcdLib.validateComentsInMCDWindow(data.get("comment"));
					assertTrue(comment, "<b>Able to generate a comment on a locked call</b>");
					//clicked on status tab
					dimcdLib.clickOnStatusUpdateTab();
					//enter status ,reason and facility
					dimcdLib.enterStatusInStatusUpdateTab(data.get("status"));
					dimcdLib.enterReasonInStatusUpdateTab(data.get("reason"));
					dimcdLib.enterfacilityOnStatusUpdateWindow(data.get("facility"));
					Thread.sleep(5000);

					//verify update and cancel is grayed out. We are checking with the button is disabled or not by getting the class value
					String classValu = getAttributeValue(DIMCDPage.updateVisibilityInStatusUpdateTab,"class");
					assertTrue(classValu.contains("disabled"),"Update button is disabled");
					String classValue = getAttributeValue(DIMCDPage.cancelVisibilityInStatusUpdateTab,"class");
					assertTrue(classValue.contains("disabled"),"Cancel button is disabled");
					dimcdLib.clickOnStatusUpdateTab();

					//verify edit pacesetter code gets a error msg
					dimcdLib.clickOnEditOnTroubleSummary();
					dimcdLib.clickOnPacesetterOnTroubleSummary(data.get("pacesetterdata"));
					dimcdLib.clickOnSaveOnTroubleSummary();
					String erropoprmsg = dimcdLib.getE213ErrorMessage();
					assertTrue(!erropoprmsg.equalsIgnoreCase(null), "<b>Error msg is displayed</b>"+erropoprmsg);
					dimcdLib.clickOnE213OkayButton();

					//verify call is locked
					String callStatus[] =erropoprmsg.split(":");
					assertTrue(!callStatus[2].equalsIgnoreCase(null), "<b>Call Status is displayed as:</b>"+callStatus[2]);

					//click on ack btn gets a error msg
					dimcdLib.clickAckOnMCDwindow();
					String errormsg = dimcdLib.getE213ErrorMessage();
					assertTrue(!errormsg.equalsIgnoreCase(null), "<b>Error msg is displayed</b>"+errormsg);
					dimcdLib.clickOnE213OkayButton();
					//verify call is locked
					String callStatusAck[] =errormsg.split(":");
					assertTrue(!callStatusAck[2].equalsIgnoreCase(null), "<b>Call Status is displayed as:</b>"+callStatusAck[2]);


					//Thread.sleep(240000);
					boolean windowStatus=dimcdLib.verifyInactiveMCD();
					assertTrue(windowStatus, "<b>The MCD working timer expires and automatically closes the MCD</b>");

					Thread.sleep(15000);

					//again search call
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();

					//verfy lock icon
					boolean iconAfterCloseMCD = dimcdLib.verifyLockIcon();
					assertTrue(iconAfterCloseMCD, "<b>lock icon in the top right bar is displayed:</b>");
					//verify call is no longer locked by that user
					String nameAfterCloseMCD = dimcdLib.getUsernameForLockedCall();
					assertTrue(!nameAfterCloseMCD.equalsIgnoreCase(name), "<b>Call is no longer locked by that user :</b>"+nameAfterCloseMCD);

					diHome.logOut();
					driver1.close();

				} catch (Exception e) {
					System.err.println(e.getMessage());
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI", "1999", ReportStatus.strMethodName, intCounter, browser);
				//To close the browser after each iteration
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}
	public void loginD3CreateCall(Hashtable<String, String> data) throws Throwable
	{
		navigateToApplication("CR");
		login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
		home.messageDialogBoxClose();
		String Member1 = "";
		if (data.get("Member").equals("db")) {
			//fetch member details from db
			//generating a random number everytime to fetch a new record everytime
			int rownum = IntRandomNumberGenerator(50, 1000);
			//member from db
			Member1 = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
			System.out.println("member : " + Member1);
		} else {
			Member1 = data.get("Membersearch");
		}
		home.memberSearchTextBox(Member1);
		//crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		member.memberNumClick();
		member.labelMemberLevelInMemberDetailsSection();
		location.clickOnLocationTab();
		location.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		vehicle.clickOnVehicleTriageTab();
		vehicle.selectExistingVehicleModel();
		boolean messageAlert=home.verifyMessageDialogBoxClose();
		if(messageAlert){
			home.closeMessageDialogBoxClose();
		}
		vehicle.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		vehicle.handleScriptErrorInVehicleTriagePage();
		vehicle.handleScriptErrorInVehicleTriagePage();
		vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		home.saveButton();
		home.allErrorAlerts();
		Thread.sleep(10000);
		callID = service.getCallId();
		callDateCreated = service.getCallDate();
		callDateStr = callDateCreated.replaceAll("-", "");
		service.clickOnRemainInCall();
		Thread.sleep(5000);
		vehicle.handleScriptErrorInVehicleTriagePage();
		vehicle.handleScriptErrorInVehicleTriagePage();
		home.logout();

	}

}
