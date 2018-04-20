package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRRecentCalls extends ActionEngine {
   String callID;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void recentCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "RecentCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("RecentCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1912_Recent Calls"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRRecentCallsLib recent = new CRRecentCallsLib();
		                CommonLib commonLib = new CommonLib();

		                navigateToApplication("CR");
		                Thread.sleep(1000);
		                login.login(data.get("LoginName"),data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
					String Member = "";
					if (data.get("Member").equals("db")) {
						//fetch member details from db
						//generating a random number everytime to fetch a new record everytime
						int rownum = IntRandomNumberGenerator(50, 1000);
						//member from db
						Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
						System.out.println("member : " + Member);
					} else {
						Member = data.get("Membersearch");
					}

					home.memberSearchTextBox(Member);
					member.memberNumClick();
					//entering breakdown location
					location.breakdownLocTabSel();
					location.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
					//To enter Vehicle Information
					commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "",data.get("ProblemTriage"), data.get("ProblemType"));
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					service.clickOnServiceTab();
					//To manualSpot the facility
					service.enterManualSpotDetails(data.get("Facility"));
					home.waitCloseAllBusyIconsResults();
					Thread.sleep(3000);
					home.saveButton();
					home.waitCloseAllBusyIconsResults();
					home.allErrorAlerts();
					Thread.sleep(3000);
					callID = service.getCallId();
					service.closeCallWindow();

					//Recent Calls verification ubder SearchCalls drop down
		                home.clickOnSearchCallDroupDown();
		                recent.clickOnRecentCallsFromDropDownMenu();
		                String actualRecentCallsLabelNameFromApp = recent.verifyRecentCallsOptionName();
		                String expectedRecentCallsOption = data.get("RecentCallsOptionName");
		                //Verifing the RecentCall option Under searchCalls dropDown
						assertTrue(actualRecentCallsLabelNameFromApp.equalsIgnoreCase(expectedRecentCallsOption),"<b>Verified the RecentCalls Option & Displayed with the name   :: </b>"+actualRecentCallsLabelNameFromApp);
		                String actualMostRecentlyAssociateCallsWindowLabel =  recent.verifyMostRecentlyAssociatedCallsWindow();
					    String expectedRecentlyAssociateCallsWindowName = data.get("RecentlyAssociateCallsWindowName");
					    //Verifing RecentlyAssociateCallsWindowName in Recent Calls Section
						assertTrue(actualMostRecentlyAssociateCallsWindowLabel.equalsIgnoreCase(expectedRecentlyAssociateCallsWindowName),"<b>Verified the MostRecentlyAssociateCallsWindow & Window displays with Name  :: </b>"+actualMostRecentlyAssociateCallsWindowLabel);

						String actualCallIdandDateLabelName = recent.getCallDateIDLabel();
						String expectedCallAnddateLabelName =data.get("CallAnddateLabel");
						//Verifing CallAndDateLabel Name under Recent Calls section
					    assertTrue(actualCallIdandDateLabelName.equalsIgnoreCase(expectedCallAnddateLabelName),"<b>Verified the displayed Call Date ID label, Label name ::    </b>"+actualCallIdandDateLabelName);
		                String actualContactInfolabelName = recent.getContactInformationLabel();
		                String expectedContactInfoLabelName = data.get("ContactInfoLabelName");
		                //Verifing ContactInfoLabelName under Recent Calls section
					    assertTrue(actualContactInfolabelName.equalsIgnoreCase(expectedContactInfoLabelName),"<b>Verified the displayed Contact Inforamtion Label,Label Name ::    </b>"+actualContactInfolabelName);
		                String actualVehicleInfoLabelName = recent.getVehicleInformationLabel();
		                String expectedVehicleInfoLabelName = data.get("vehicleInfoLabelName");
		                //Verifing vehicleInfoLabelName under RecentCalls section
					    assertTrue(actualVehicleInfoLabelName.equalsIgnoreCase(expectedVehicleInfoLabelName),"<b>Verified the displayed Vehicle Inforamtion Label ,Label Name ::      </b>"+actualVehicleInfoLabelName);
		                String actualActionLabelName =recent.getActionLabel();
		                String expectedActionLabelName = data.get("ActionLabelName");
		                //Verifing ActionLabelName under RecentCalls section
		                assertTrue(actualActionLabelName.equalsIgnoreCase(expectedActionLabelName),"<b>Verified the displayed Actions Label,Label name ::     </b>"+actualActionLabelName);
		                String memberNumberFromRecentCalls=recent.getMemberNumberfromRecentCallSearch(callID);
		                String savedCallId = recent.searchAndSelectCallIDOnSearCallWindow(callID);
		                assertTrue(savedCallId.contains(callID),"Verified the call & call saved, displayed in the list  "+callID);
		                home.waitCloseAllBusyIconsResults();
		                String callIdFroMemberSearchPage = member.verifyLiveCallIDInMemberTab();
		                //To verify the Current call Loaded or not.Verifing with member Number
		                assertTrue(callIdFroMemberSearchPage.contains(callID),"<b>Verified the loaded callId ::</b>"+callID+ "<b> In member Tab, Call loaded into Call Receiving without error</b>");
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(4000);

		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1912",ReportStatus.strMethodName,intCounter,browser);
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
