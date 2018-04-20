package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.rspweb.pages.RSPHomePage;
import com.aaa.rspweb.pages.RSPLoginPage;
import com.aaa.utilities.TestUtil;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_RSPAuditUserLogin extends RSPCommonLib {
	
	/*********************************************************************************
     * *******************************************************************************
     * *************************STEP SKIPPED******************************************
     * Step 9:Verify Date/Time of logout in the database
     * *******************************************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

	RSPLoginLib login=new RSPLoginLib();
	RSPHomeLib homeLib=new RSPHomeLib();
	RSPManageUserLib manageUserLib=new RSPManageUserLib();
	RSPUserDetailsLib userDetailsLib=new RSPUserDetailsLib();
	RSPCommonLib commonLib = new RSPCommonLib();

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void RSPAuditUserLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "RSPLoginAudit", TestData, "RSPWeb");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPLoginAudit", TestData, "RSPWeb", intCounter);
					this.reporter.initTestCaseDescription("RSPLoginAudit" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
					navigateToApplication("RSP");
					//Login to RSP
					login.loginToRSP(data.get("AdminUserName"), data.get("AdminPassword"));
					//Check If User Priority Pop up is displayed
					homeLib.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
					//Admin - Navigate to Manager Users Page
					homeLib.clickOnMenuDropdown();
					homeLib.clickOnManageUser();
					scrollBottom();
					//Validate Number of Logins Displayed in ManageUsers Page 
					manageUserLib.validateLoginRecords();
					//Open A User Profile
					manageUserLib.clickOnUserProfile(data.get("ClubUserName"));
					userDetailsLib.validateUserDetailsPage(data.get("ClubUserName"));
					//Create a driver instance for ShopUser
					EventFiringWebDriver drUser = new EventFiringWebDriver(new ChromeDriver());
					drUser.get(RSP_URL);
					Thread.sleep(5000);
					//Read Application Version
					String appVersion=login.getRspVersion(drUser);
					//Login User
					drUser.findElement(RSPLoginPage.txtUserName).sendKeys(data.get("ClubUserName"));
					drUser.findElement(RSPLoginPage.txtPassword).sendKeys(data.get("ClubUserPassword"));
					drUser.findElement(RSPLoginPage.btnSignIn).click();
					String format="MM/dd/yyyy h:mm aa z";
					String timeZone="EST5EDT";
					String userLoginSystemTime= commonLib.getCurrentSystemTime(format,timeZone);
					//Compare Login time taken from Machine and Application are equal
					userDetailsLib.validateUserLastLoginTime(userLoginSystemTime);
					//Validate that the logout for a currently logged in User is N/A
					userDetailsLib.validateUserLastLogoutTime("N/A");		
					//AdminUser Sorting newest to oldest
					userDetailsLib.validateSortOrderUserLoginTimes(userDetailsLib.getUserLoginTimes());
					//Validate Audit User Log
					userDetailsLib.validateUserAuditLog(appVersion);
					//Logout User
					drUser.findElement(RSPHomePage.btnSignOut).click();
					//drUser.
					acceptAlert(drUser);
					String userLogoutSystemTime= commonLib.getCurrentSystemTime(format,timeZone);
					//Refresh the ClubAdmin User Details Page
					refreshPage();
					acceptAlert();
					//Validate the Date and Time is Recorded
					userDetailsLib.validateUserLastLogoutTime(userLogoutSystemTime);
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Failed due to",e.getMessage(),driver);
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("RSP","1845",ReportStatus.strMethodName,intCounter,browser);
				fnCloseTest();
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
