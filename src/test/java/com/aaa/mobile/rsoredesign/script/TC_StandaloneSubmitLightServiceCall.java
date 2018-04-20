package com.aaa.mobile.rsoredesign.script;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.mobile.rsoredesign.lib.StandaloneLoginLib;
import com.aaa.mobile.rsoredesign.lib.StandaloneMenuBarLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignSetBreakdownLocationLib;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.mobile.rsoredesign.lib.RSORedesignBreakdownSubPageLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignSelectVehicleLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignSelectVehicleSubPageLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignTriageLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignContactInfoLib;
import com.aaa.utilities.TestUtil;

/**
 * Class: TC_StandaloneSubmitLightServiceCall
 * Test Cases included
 * Login: RQM 1708 TC - AAA Mobile - RSO Standalone Login
 * 
 * @author neilmccormick
 * Description: This test case is 
 * 
 */
public class TC_StandaloneSubmitLightServiceCall extends StandaloneLoginLib {
	public static final int WAITTIME = 50000;
	
	/**
	 * Method Name: afterMethod
	 * Description: Cleans up after the test has run.
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Throwable {
		appiumDriver.resetApp();
		super.afterMethod();
	}
	
	/**
	 * Method Name: getTestDataFor_standalonRSOAppLightServiceCall
	 * Description Returns a hash table of the data for this test set.
	 * @return
	 */
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void standaloneSubmitLightServiceCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "liteServiceRequest", TestData, "RSOMobileRedesign");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("liteServiceRequest", TestData, "RSOMobileRedesign",intCounter);
						reporter.initTestCaseDescription("1708 TC - RSO Standalone - Login RSO Standalone"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			    		
						this.loginRSOStandalone(data); // Logs into the RSO Standalone app. 
						//Thread.sleep(5000); //Allows 5 seconds for app to load the RSO Component and it make the calls to the server.
						
						//Set the breakdown location and continue.  Step 1.
						RSORedesignSetBreakdownLocationLib blPage = new RSORedesignSetBreakdownLocationLib();
						blPage.setPlatform(this.platform);
						blPage.setBreakdownLocationAndContinue(data);
						//
						
						//Checks the container standalone app menu bar for several items.
						StandaloneMenuBarLib menuBar = new StandaloneMenuBarLib();
						menuBar.setPlatform(this.platform);
						menuBar.validateMenuBar();
						
						//Validates the B/L sub page only once, assumes the data persists throughout the test suite.  Can be run again.
						RSORedesignBreakdownSubPageLib blSubPage = new RSORedesignBreakdownSubPageLib();
						blSubPage.setPlatform(this.platform);
						blSubPage.validatePage(data);
						
						//Select Car.  Step 2
						RSORedesignSelectVehicleLib selectVehicle = new RSORedesignSelectVehicleLib();
						selectVehicle.setPlatform(this.platform);
						selectVehicle.selectVehicleAndContinue(data);
						
						RSORedesignSelectVehicleSubPageLib selectedVehicleSubPage = new RSORedesignSelectVehicleSubPageLib();
						selectedVehicleSubPage.setPlatform(this.platform);
						selectedVehicleSubPage.validatePage(data);
						
						//Set the problem/triage descriptions of the issue. Step 3
						RSORedesignTriageLib triagePage = new RSORedesignTriageLib();
						triagePage.setPlatform(this.platform);
						triagePage.selectTriageItems(data);
						
						//Set the contact information.
						RSORedesignContactInfoLib contactInfo = new RSORedesignContactInfoLib();
						contactInfo.setPlatform(this.platform);
						contactInfo.verifyContactSubmitRequest(data);		
								
		    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("RSO","1708",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
}
