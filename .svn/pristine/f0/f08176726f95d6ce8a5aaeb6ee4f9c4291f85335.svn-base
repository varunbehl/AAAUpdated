package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRServicePage;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by e002222 on 10-01-2018.
 */
public class TC_CRCashCallService extends ActionEngine {

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void cashCallService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "cashCallService", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("cashCallService", TestData, "D3CallRecieving",intCounter);
    	                this.reporter.initTestCaseDescription("1645: TC-Cash Call Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib= new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRHomeLib home = new CRHomeLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(10000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                member.currentCallClose();
		
		                crHomeLib.allErrorAlerts();
		                Boolean cashFlagNotVisible=isVisibleOnly(CRServicePage.cashFlagIcon, "Cash Flag");
		                assertTrue(!cashFlagNotVisible, "<b>Cash Flag icon should not be visible");
		
		                Boolean visibilityOfCallsRemaining = isVisibleOnly(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining");
		                assertTrue(visibilityOfCallsRemaining, "Calls Remaining is available in member details Section");
		
		                int CallRemaining=member.CallsRemainingInMemberDetailsSection();
		                Boolean callRe=CallRemaining>0;
		                assertTrue(callRe, "<b>Calls Remaining is greater than 0 in member details Section");
		
		                crLocationsLib.clickOnLocationTab();

						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crVehicleTriageLib.clickOnVehicleTriageTab();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");

		                vehicle.clickonProblemTypeButton(data.get("ProblemType4"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option1"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		                service.clickOnCashOnServiceTab();
		
		                Boolean cashFlagVisible=isVisibleOnly(CRServicePage.cashFlagIcon, "Cash Flag");
		                assertTrue(cashFlagVisible, "<b>Cash Flag icon should be visible");
		                crHomeLib.saveButton();
		                home.allErrorAlerts();
		                service.closeCallWindow();
		
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                member.currentCallClose();
		
		                Boolean visibilityOfCallsRemainingafterCashCall = isVisibleOnly(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining");
		                assertTrue(visibilityOfCallsRemainingafterCashCall, "Calls Remaining is available in member details Section");
		                int CallRemainingAfterCashCall=member.CallsRemainingInMemberDetailsSection();
		                CallRemaining=CallRemainingAfterCashCall;
		                assertTrue(CallRemaining == CallRemainingAfterCashCall, "<b>Expected::" +CallRemaining+  "::Value and Actual value::" +CallRemainingAfterCashCall+ "::are matched");
		                home.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1645",ReportStatus.strMethodName,intCounter,browser);
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



    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void cashCallServiceZeroEntitlements(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "cashCallServiceZeroEntitlements", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("cashCallServiceZeroEntitlements", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1645: TC-Cash Call Service with Zero Entitlements"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib= new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(10000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                member.currentCallClose();
		                crHomeLib.allErrorAlerts();
		
		                Boolean visibilityOfCallsRemaining = isVisibleOnly(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining");
		                assertTrue(visibilityOfCallsRemaining, "Calls Remaining is available in member details Section");
		                int CallRemaining=member.CallsRemainingInMemberDetailsSection();
		                Boolean callRe=CallRemaining==0;
		                assertTrue(callRe, "<b>Calls Remaining is 0 in member details Section");
		                Boolean cashFlagVisible=isVisibleOnly(CRServicePage.cashFlagIcon, "Cash Flag");
		                assertTrue(cashFlagVisible, "<b>Cash Flag icon should be visible");
		                crLocationsLib.clickOnLocationTab();

						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crVehicleTriageLib.clickOnVehicleTriageTab();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");

		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
					    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		                service.closeCallWindow();
		                crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                member.currentCallClose();
		                crHomeLib.allErrorAlerts();
		                Boolean visibilityOfCallsRemainingafterCashCall = isVisibleOnly(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining");
		                assertTrue(visibilityOfCallsRemainingafterCashCall, "Calls Remaining is available in member details Section");
		                int CallRemainingAfterCashCall=member.CallsRemainingInMemberDetailsSection();
		                CallRemaining=CallRemainingAfterCashCall;
		                assertTrue(CallRemaining == CallRemainingAfterCashCall, "<b>Expected::" +CallRemaining+  "::Value and Actual value::" +CallRemainingAfterCashCall+ "::are matched");
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1645",ReportStatus.strMethodName,intCounter,browser);
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

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void cashCallServiceCanceledEntitlements(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "cashCallServiceCanceledEntitlements", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("cashCallServiceCanceledEntitlements", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1645: TC-Cash Call Service with Canceled Entitlements"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib= new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRHomeLib home = new CRHomeLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(10000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crHomeLib.allErrorAlerts();
		                Thread.sleep(5000);
		                member.currentCallClose();
		                crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		
		                boolean flagMembershipRenewAlert = isVisibleOnly(CRMemberSearchPage.membershipRenewAlert, "Membership Renew Alert");
		                assertTrue(flagMembershipRenewAlert, "Membership Renew Alert");
		                member.membershipRenewAlertNo();
						member.currentCallClose();
		                Boolean cashFlagVisible=isVisibleOnly(CRServicePage.cashFlagIcon, "Cash Flag");
		                assertTrue(cashFlagVisible, "<b>Cash Flag icon should be visible");
		
		                crLocationsLib.clickOnLocationTab();

						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crVehicleTriageLib.clickOnVehicleTriageTab();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");
		                crVehicleTriageLib.clickOnFuel();
		                boolean flagMembershipRenewAlert1 = isVisibleOnly(CRMemberSearchPage.membershipRenewAlert, "Membership Renew Alert");
		                assertTrue(flagMembershipRenewAlert1, "<b>Membership Renew Alert");
		                member.membershipRenewAlertNo();
		                crVehicleTriageLib.clickOnOutOfGas();
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		
		                crHomeLib.allErrorAlerts();
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                Thread.sleep(4000);
		                service.closeCallWindow();
		                crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                member.currentCallClose();
		
		                boolean flagMembershipRenewAlert2 = isVisibleOnly(CRMemberSearchPage.membershipRenewAlert, "Membership Renew Alert");
		                assertTrue(flagMembershipRenewAlert2, "Membership Renew Alert");
		                member.membershipRenewAlertYes();
		
		                Boolean cashFlagNotVisible=isVisibleOnly(CRServicePage.cashFlagIcon, "Cash Flag");
		                assertTrue(!cashFlagNotVisible, "<b>Cash Flag icon should not be visible");
		                home.logout();
		
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1645",ReportStatus.strMethodName,intCounter,browser);
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
