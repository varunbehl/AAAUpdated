package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;

import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRLiveCallSearch extends ActionEngine{

   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void liveCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "liveCallSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("liveCallSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1703: TS-Live Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib= new CRVehicleTriageLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(10000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(10000);

		                //Below lines of code is for the search with current date

		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		               String expectedStrDate= crSearchCall.getStartDateSearchDetails();
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyStartAndEndDateOnSearchCallWindow(expectedStrDate);
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with callID

		                crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyCallIDOnSearCallWindow(data.get("CallID"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Time range

		                crSearchCall.enterStartTimeOnSearchCallsWindow(data.get("StartTime"));
		                crSearchCall.enterEndTimeOnSearchCallsWindow(data.get("EndTime"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyAndGetDateFromMemberPageandChangeFormat(data.get("StartTime"),data.get("EndTime"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.allErrorAlerts();
		                Thread.sleep(3000);
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.allErrorAlerts();
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();


					    //Below lines of code is for the search with RAP

		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(4000);
		                crSearchCall.verifyRAPOnSearCallWindow(data.get("RAP"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Call Taker

		                crSearchCall.enterCallTakerOnSearchCallsWindow(data.get("CallTaker"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();


					    //Below lines of code is for the search with Facility

		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterFacilityOnSearchCallsWindow(data.get("Facility"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyFacilityOnSearCallWindow(data.get("Facility"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with TruckID

		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterTruckOnSearchCallsWindow(data.get("TruckID"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyTruckIDOnSearCallWindow(data.get("TruckID"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Phone Number

		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterPhoneNumberOnSearchCallsWindow(data.get("PhoneNumber"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
						Thread.sleep(10000);
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crSearchCall.verifyAndclickCallSummaryIconOnMemberspage(data.get("PhoneNumber"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crSearchCall.clickOnSearchCalls();

					    //Below lines of code is for the search with Club Number

		                crSearchCall.enterClubNumberOnSearchCallsWindow(data.get("ClubNumber"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyClubNumberOnSearCallWindow(data.get("ClubNumber"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Member Last Name

		                crSearchCall.enterMemberLastNameSearchOnSearchCallsWindow(data.get("MemberLastName"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyMemberLastNameOnSearCallWindow(data.get("MemberLastName"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Member Number

		                crSearchCall.enterMemberNumberOnSearchCallsWindow(data.get("MemberNumber"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyMemberNumberOnSearCallWindow(data.get("MemberNumber"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Vehicle Year, Make and Model

		                crSearchCall.enterYearVehicleInforationOnSearchCallsWindow(data.get("VehicleYear"));
		                crSearchCall.enterMakeVehicleInforationOnSearchCallsWindow(data.get("VehicleMake"));
		                Thread.sleep(3000);
		                crSearchCall.enterModelVehicleInforationOnSearchCallsWindow(data.get("VehicleModel"));
		                Thread.sleep(3000);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyVehicleYearOnSearCallWindow(data.get("VehicleYear"));
		                crSearchCall.verifyVehicleMakeOnSearCallWindow(data.get("VehicleMake"));
		                crSearchCall.verifyVehicleModelOnSearCallWindow(data.get("VehicleModel"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();

					    //Below lines of code is for the search with Location

		                crSearchCall.enterLocationOnSearchCallsWindow(data.get("BKDownStreetAddress"));
		                crSearchCall.enterCityOnSearchCallsWindow(data.get("BKDownCityLocation"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.verifyLocationOnSearCallWindow(data.get("BKDownStreetAddress"));
		                crSearchCall.verifyCityOnSearCallWindow(data.get("BKDownCityLocation"));
		                crSearchCall.clickSearchAgainOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		                crSearchCall.clickCloseBtnOnSearchCallwindow();
		                acceptAlert();
		                crHomeLib.logout();
		                acceptAlert();
		
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1703",ReportStatus.strMethodName,intCounter,browser);
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
