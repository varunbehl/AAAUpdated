package com.aaa.mobile.script;

import java.util.Hashtable;

import com.aaa.mobile.page.HomePage;
import com.aaa.mobile.page.LaunchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.mobile.lib.ClubSelectionLib;
import com.aaa.mobile.lib.HomeLib;
import com.aaa.mobile.lib.LaunchLib;
import com.aaa.mobile.lib.MembershipInfoLib;
import com.aaa.mobile.lib.NotificationsLib;
import com.aaa.mobile.page.NotificationsPage;
import com.aaa.utilities.TestUtil;


/**
 * Created by E002734 on 12/12/2017.
 */
public class TC_MemberNumberLogin  extends ClubSelectionLib {
	//Object Creation for LaunchLib
	LaunchLib launch = new LaunchLib();
	NotificationsLib notifications = new NotificationsLib();
	MembershipInfoLib membershipinfo =new MembershipInfoLib();
	ClubSelectionLib club=new ClubSelectionLib();
	NotificationsLib popup=new NotificationsLib();
	HomeLib home=new HomeLib();


	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Throwable {
		this.appiumDriver.resetApp();
		super.afterMethod();
	}
	public static final int WAITTIME = 50000;
	/**
	 * param testContext
	 * param data
	 * throws Throwable
	 * description: 1705 : TC - AAA Mobile - Member Number Login
	 * author :Ravi
	 */

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void MemberNumberLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MemberNumberLogin", TestData, "RSOMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MemberNumberLogin", TestData, "RSOMobile",intCounter);
		
    					this.reporter.initTestCaseDescription("1705 TC - AAA Mobile - Member Number Login"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						if (!isVisibleOnly(LaunchPage.continueButton, "launch page continue btn")) {
							click(NotificationsPage.allowButton,"Allow Permissions");
						}
						
						if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
						{
							home.clickLogin();
						}
						launch.enterZIPCodeandselectContinue(data.get("ZIPCode"));
						club.verifySelectedClubName();
						//select club
						club.clickOnSelectedClub();
						if(waitForVisibilityOfElement(NotificationsPage.allowButton,"Allow Permissions"))
						{
							click(NotificationsPage.allowButton,"Allow Permissions");
							Thread.sleep(1000);
						}
						if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
						{
							home.clickLogin();
							//select club
							club.clickOnSelectedClub();
						}
		
						//skip Membership
						membershipinfo.clickOnskip();
						home.verifyRoadSideAssistanceExistence();
						//humburger
						home.clickhamburgerButton();
						//login
						home.clickLogin();
						//select club
						clickOnSelectedClub();
						//enter membership
						membershipinfo.enterMembershipNumberAndContinue(data.get("MemberNumber"));
						popup.yesPushNotificationsLabel();
						home.verifyRoadSideAssistanceExistence();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("NA","1705",ReportStatus.strMethodName,intCounter,platformNameMobile);
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