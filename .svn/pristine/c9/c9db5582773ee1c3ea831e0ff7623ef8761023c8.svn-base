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


public class TC_DILiveCallSearch extends ActionEngine {
    String callId;
    public static long rapNumber;
    String startDate;
    String endDate;
    String facility;
    String memberNumber;
    String lastName;
    String phoneNumber;

    DIHomeLib diHome = new DIHomeLib();
    LoginLib login = new LoginLib();
    DILoginLib diLogin = new DILoginLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DIMCDLib mcdlib = new DIMCDLib();
    CRServiceLib service = new CRServiceLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CommonLib commonLib = new CommonLib();

    //Common Functionality To Login and Into Dispatch and SPP Dispatch
    public void diLiveCallSearch(Hashtable<String, String> data) throws Throwable {

		commonLib.loginToDIAndClickOnSearchCalls(data.get("LoginName"), data.get("Password"),data.get("SPPOrDI"));
        Thread.sleep(2000);
        startDate = diSearchCalls.getStartDate();
        endDate = diSearchCalls.getEndDate();
        Thread.sleep(3000);
    }



	//Call Saving for LiveCal Search,For callsID,FacilityId,PhoneNumber,Member Number
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveCallForLiveCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearch", TestData, "D3CallRecieving",intCounter);
    	
    					this.reporter.initTestCaseDescription("1747: DILive Call Search "+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
    					
			            navigateToApplication("CR");
			            Thread.sleep(4000);
			            login.login(data.get("LoginName"), data.get("Password"));
			            crMemberSearchLib.clickOnPartialCallCloseButton();
			            crHomeLib.verifyHomeScreen();
			                String Member = "";
			                if (data.get("Member").equals("db")){
			                    //fetch member details from db
			                    //generating a random number everytime to fetch a new record everytime
			                    int rownum = IntRandomNumberGenerator(50,1000);
			                    //member from db
			                    Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);

			                }
			                else
			                {
			                    Member = data.get("Membersearch");
			                }
			            crHomeLib.memberSearchTextBox(Member);
			            crMemberSearchLib.memberNumClick();
			            memberNumber=crMemberSearchLib.labelMemberShipNumberInMemberDetailsSection();
			            lastName = crMemberSearchLib.memberLastNameVerification();
			            crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
			            Thread.sleep(2000);
						crLocationsLib.breakdownLocTabSel();
						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
						//To enter Vehicle Information
						commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "",data.get("ProblemTriage"), data.get("ProblemType"));
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
						crHomeLib.allErrorAlerts();
			            Thread.sleep(2000);
						service.clickOnServiceTab();
						crHomeLib.waitCloseAllBusyIconsResults();
						service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
			            facility = service.validateFacilityAutospot();
			            Thread.sleep(3000);
			            phoneNumber = crMemberSearchLib.getPhoneNumberFromCallerInfo();
			            crVehicleTriageLib.scriptErrorHandle();
			            crHomeLib.saveButton();
			            crHomeLib.waitCloseAllBusyIconsResults();
			            Thread.sleep(3000);
			            callId = service.getCallId();
			            service.closeCall();
			            crHomeLib.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
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


/************************************************************************
    * Script Name :-
    * Method Name :-saveRAPCallsForDiLivaCallSearch
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************
*/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void saveRAPCallsForDiLivaCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveRAPCallsForDiLivaCallSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveRAPCallsForDiLivaCallSearch", TestData, "D3CallRecieving",intCounter);
    	
			                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                CRHomeLib home = new CRHomeLib();
			                LoginLib login = new LoginLib();
			                CRLocationsLib locations = new CRLocationsLib();
			                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
			                CRMemberSearchLib member = new CRMemberSearchLib();
			                CRTowDestinationLib tow = new CRTowDestinationLib();
			                CRServiceLib services = new CRServiceLib();
			
			                home.verifyandClickLogout();
			                navigateToApplication("CR");
			                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
			                crMemberSearchLib.clickOnPartialCallCloseButton();
			                home.verifyHomeScreen();
			                home.workFlowSelectionForRAP();
			                member.verifyIsRapWorkFlowSet();
			                home.waitCloseAllBusyIconsResults();
			                member.enterDataInClubCode(data.get("clubCode"));
			                //To generate Random Number,Random number Id used as Rap ID
			                rapNumber=generateRandomNumber();
			                //To enter Member mandatory fields
			                member.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),rapNumber,data.get("paymentCode"));
			                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
			                Thread.sleep(2000);
			                member.selectType(data.get("phoneType"));
			                Thread.sleep(2000);
			                member.clickPrimRadioBtnRowOne();
			                locations.clickOnLocationTab();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                locations.clickOnManualEntryLinkInLocation();
			                //To enter mandatory Fields in Location Tab
			                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
			                crVehicleTriageLib.clickOnVehicleTriageTab();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                //Thread.sleep(2000);
			                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
			                Thread.sleep(1000);
			                //To enter Mandatory field on VehiceleTriageTab
			                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
			                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
			                Thread.sleep(3000);
			                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
			                Thread.sleep(2000);
			                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
			                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
			                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
			                Thread.sleep(3000);
			                //To enter Proble Type on vehicle Triage Tab
							crVehicleTriageLib.problemTriage(data.get("ProblemTriage"), data.get("ProblemType"));
			                crHomeLib.waitCloseAllBusyIconsResults();
			                crHomeLib.allErrorAlerts();
			                tow.clickOnTowDestinationTab();
			                home.waitCloseAllBusyIconsResults();
			                crVehicleTriageLib.scriptErrorHandle();
			                crHomeLib.allErrorAlerts();
			                Thread.sleep(3000);
			                tow.clickOnManualEntryLinkOnTowDestination();
			                tow.enterTowPassengers(data.get("Towpassengers"));
			                Thread.sleep(2000);
			                services.clickOnServiceTab();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                //To Spot facility manually
			                service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
			                home.waitCloseAllBusyIconsResults();
			                home.saveButton();
			                crHomeLib.allErrorAlerts();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                services.getCallId();
			                services.closeCall();
			                home.waitCloseAllBusyIconsResults();
			                Thread.sleep(4000);
			                home.logout();

			                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1924",ReportStatus.strMethodName,intCounter,browser);
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


   //dateRange Search
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************
*/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void dateRangeSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithDateRange", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithDateRange", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                //To enter startDate and End date On SearchCalls
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                String currentDate = diSearchCalls.getStartDate();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                //Verify Results in Grid after Live call Search with currentDate
		                boolean currentDateFlag = diSearchCalls.verifyResultsWithCurrentDate(currentDate);
		                assertTrue(currentDateFlag, "<b>Verified the results returned & all results are for the current day </b>  "+currentDate);
		                //To close the search calls results window
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();


    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

    // Search With CallID
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************
*/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void callIdSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithCallID", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithCallID", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		             //Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                //To enter callId In Search Calls Window
		                diSearchCalls.clickAndEnterCallIDInfo(callId);
		                String callId= diSearchCalls.getCallID();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                //Verify the callId is having results in Results Grid
		                boolean callIdFlag = diSearchCalls.verifyResultsWithCallID(callId);
		                assertTrue(callIdFlag, "<b>Verified the results returned & one call is returned for the call ID    </b>" + callId);
		                //close The Search Calls Window
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();


    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

//Time Range Search
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************
*/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void timeRangeSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithTimeRange", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithTimeRange", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                diSearchCalls.enterStartTimeOnSearchCallsWindow(data.get("StartTime"));
		                diSearchCalls.enterEndTimeOnSearchCallsWindow(data.get("EndTime"));
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                //Verifing the Results, If Grid is Not Having No matching records
		                boolean noRecordsFlag=diSearchCalls.verifyMatchingRecordsOnMCD();
		                if(noRecordsFlag){
		                    assertFalse(noRecordsFlag,"<b>No matching Records Found </b>");
		                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                }else {
		                	//verifing the results with TimeRange search
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    boolean timeRangeFlag = diSearchCalls.verifyTheTimeRange(data.get("StartTime"), data.get("EndTime"));
		                    assertTrue(timeRangeFlag,"<b>Verified the call In results Grid With Time Range Search</b>");
		                    //To close the MCD Window
		                    mcdlib.clickOnMCDCloseWindow();
		                }
		                Thread.sleep(2000);
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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
//RapId search
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************
*/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void rapNumberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithRapNumber", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithRapNumber", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(data.get("RAPStartDate"));
		                String rapId = String.valueOf(rapNumber);
		                //Enter RapNumber On Search Calls Window
		                diSearchCalls.enterRAPNumberOnSearchCallsWindow(rapId);
		                String rapNumberFronList = diSearchCalls.getRapNumber();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                //Verify Results With RapID search
		                boolean rapIdFlag = diSearchCalls.verifyResultsWithRAPId(rapNumberFronList);
		                assertTrue(rapIdFlag, "<b>Verified the results returned & RAP call is returned in the search results    </b>" + rapNumber);
		                crHomeLib.waitCloseAllBusyIconsResults();
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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
    //facility Search
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************
*/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void facilitySearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithFacility", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithFacility", TestData, "D3Dispatch",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                //Enter Facility In Search Calls Window
		                diSearchCalls.enterFacilityOnSearchCallsWindow(facility);
		                String facilityFromSearch = diSearchCalls.getFacility();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean facilityFlag = diSearchCalls.verifyResultsWithFacility(facilityFromSearch);
		                //Verifing the results with Facility Id
		                assertTrue(facilityFlag, " <b>Results matched the criteria :: Facility </b>" + facilityFromSearch + "<b>Exists in Selected List</b>");
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

    //TruckSearch
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void truckSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithTruckId", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithTruckId", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.clickAndEnterCallIDInfo(callId);
		                //String callId= diSearchCalls.getCallID();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                Thread.sleep(2000);
		                crHomeLib.waitCloseAllBusyIconsResults();
		                mcdlib.clickOnAssign();
		                Thread.sleep(3000);
		                crHomeLib.waitCloseAllBusyIconsResults();
					    mcdlib.selectSecondFacilityOnAssignTabInMCD();
		                //For TruckId Search - First Getting assigned truck From MCD Window  based on callID
						Thread.sleep(3000);
		                String truckId = mcdlib.getTruckIdFromMCDWindow();
		                Thread.sleep(3000);

		                mcdlib.clickOnMCDCloseWindow();
		                diHome.clickOnSearchCallsInDispatch();
		                Thread.sleep(2000);
		                //Enter Truck ID In SearchCalls Window
		                diSearchCalls.enterTruckOnSearchCallsWindow(truckId);
		                String truck1 = diSearchCalls.getTruckFromSearchCallsWindow();
		                //String callId= diSearchCalls.getCallID();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                //diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                boolean truckIdFlag = diSearchCalls.verifyResultsWithTruckId(truck1);
		                //Verifing the Results with Truck Id
		                assertTrue(truckIdFlag, "<b> Call is Serviced by the Truck,Truck Id is    </b> " +truck1);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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
   //Call Taker Search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void callTakerSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithCallTaker", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithCallTaker", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterUserIDOnSearchCallsWindow(data.get("CallTaker"));
		                String userId = diSearchCalls.getUserId();
		                Thread.sleep(2000);
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean noRecordsFlag=diSearchCalls.verifyMatchingRecordsOnMCD();
		                //If the Results Grid having No Records
		                if(noRecordsFlag){
		                    assertFalse(noRecordsFlag,"<b>No matching Records Found </b>");
		                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                }else {
		                    diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    Thread.sleep(5000);
		                    String callTakerFromMcd = mcdlib.getCallTakerFromMCDWindow();
		                    boolean callTakerFlag = diSearchCalls.verifyResultsWithCallTakerID(userId, callTakerFromMcd);
		                    Thread.sleep(2000);
		                    //Verifing the results with User ID -"autodi1"/"autospp1"
		                    assertTrue(callTakerFlag, "<b>calls are returned based on the user id   </b>" + userId);
		                    mcdlib.clickOnMCDCloseWindow();
		                }
		                Thread.sleep(2000);
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

    //Phone Number search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void phoneNumberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithPhoneNumber", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithPhoneNumber", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                //Enter PhoneNumber in Search Calls Window
		                diSearchCalls.enterPhoneNumberOnSearchCallsWindow(phoneNumber);
		               // diSearchCalls.enterPhoneNumberOnSearchCallsWindow(data.get("PhoneNumber"));
		                String phoneNumber = diSearchCalls.getPhoneNumber();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean noRecordsFlag=diSearchCalls.verifyMatchingRecordsOnMCD();
		                if(noRecordsFlag){
		                    assertFalse(noRecordsFlag,"<b>No matching Records Found </b>");
		                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                }else {
		                    diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    mcdlib.clickOnMemberTabInMCDWindow();
		                    //String phoneNumFromMCD = mcdlib.getphoneNumberFromMCD(phoneNumber);
		                    boolean phoneNumberFlag = diSearchCalls.verifyResultsWithphoneNumber(phoneNumber);
		                    //Verifing the results with Phone Number
		                    assertTrue(phoneNumberFlag, "<b>Verified the results returned & call is returned for that specific member </b> " + phoneNumber);
		                    mcdlib.clickOnMCDCloseWindow();
		                }
		                Thread.sleep(2000);
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

   //Club search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void clubSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithClubCode", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithClubCode", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterClubNumberOnSearchCallsWindow(data.get("ClubNumber"));
		                String clubCode = diSearchCalls.getClubCode();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean clubCodeFlag = diSearchCalls.verifyResultsWithClubCode(clubCode);
		                //Verifing the results with club code
		                assertTrue(clubCodeFlag, "<b>Verified the calls & Call is returned with club Code    </b>"+clubCode);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

    //Last name Search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
        @Test()
        public void lastNameSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithLastNamesearch", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithLastNamesearch", TestData, "D3Dispatch",intCounter);
    	
	                    this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
	                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
	                    diLiveCallSearch(data);
	                    String lastNameLowecase = lastName.toLowerCase();
	                    diSearchCalls.enterMemberLastNameSearchOnSearchCallsWindow(lastNameLowecase);
	                    String lastName = diSearchCalls.getLaseNameFromSearchCallsWindow();
	                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
	                    crHomeLib.waitCloseAllBusyIconsResults();
	                    boolean lastnameFlag = diSearchCalls.verifyResultsWithLastName(lastName);
	                    //Verifing the results with Last Name
	                    assertTrue(lastnameFlag, "<b>Verified the results & call(s) is returned matching the last name    </b>"+lastName);
	                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
	                    diHome.logOut();

    			
    		}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
			}
			ReportControl.fnEnableJoin();
			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

    //Member Number Search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void memberNumberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithMemNumber", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithMemNumber", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterMemberNumberOnSearchCallsWindow(memberNumber);
		                String memNumber = diSearchCalls.getMemberNumberFromSearCalls();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean memberFlag = diSearchCalls.verifyResultsWithMemberNumber(memNumber);
		                //Verifing the results with member number
		                assertTrue(memberFlag, "<b>Verified the results & Call record is returned for the member   </b> "+memNumber);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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
    //vehicle Search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void vehicleSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithVehicle", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithVehicle", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                diSearchCalls.enterYearVehicleInforationOnSearchCallsWindow(data.get("VehicleYear"));
		                diSearchCalls.enterMakeVehicleInforationOnSearchCallsWindow(data.get("VehicleMake"));
		                Thread.sleep(3000);
		                diSearchCalls.enterModelVehicleInforationOnSearchCallsWindow(data.get("VehicleModel"));
		                Thread.sleep(3000);
		                String year = diSearchCalls.getVehicleYearFromSearCalls();
		                String make = diSearchCalls.getVehicleMakeFromSearCalls();
		                String model = diSearchCalls.getVehicleModelFromSearCalls();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean vehicleFlag = diSearchCalls.verifyResultsWithVehicle(year,make,model);
		               //Verifing the results with Year,Make,model
		                assertTrue(vehicleFlag, "<b>Verified the result & Call is returned for  Vehicle Search  with     </b>"+year+"   "+make+"   "+model);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

//Breakdown location search
/***********************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    ************************************************************************/

@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void breakdownLocationSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
	try
	{
		int intStartRow=StartRow;
		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithBreakdownLocation", TestData, "D3Dispatch");
		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
		{
			try {
				fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithBreakdownLocation", TestData, "D3Dispatch",intCounter);
	
			                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
			                diLiveCallSearch(data);
			                diSearchCalls.enterLocationOnSearchCallsWindow(data.get("BKDownStreetAddress"));
			                diSearchCalls.enterCityOnSearchCallsWindow(data.get("BKDownCityLocation"));
			                String bkDwnStreetAddress = diSearchCalls.getStreetAddressFromSearCalls();
			                String bkDownCity = diSearchCalls.getCityLocationFromSearCalls();
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                boolean locationFlag = diSearchCalls.verifyResultsWithBreakdownLocation(bkDwnStreetAddress,bkDownCity);
			                //Verifing the results with BreakDown Address and City
			                assertTrue(locationFlag, "<b>Verified the result & Call is returned for Breakdown location Search  with    </b> "+bkDwnStreetAddress+"   "+bkDownCity);
			                diSearchCalls.clickCloseBtnOnSearchCallwindow();
			                diHome.logOut();

			}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
			}
			ReportControl.fnEnableJoin();
			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

    //Wrong clubcode search
/***********************************************************************
* Script Name :-
* Method Name :-
* Module	  :- DI 
* Test Case ID:-
* Script Date :- 
* Author      :- 
* @param StartRow
* @param EndRow
* @param nextTestJoin
* @throws Throwable
************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void errorScenario(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithWrongInfo", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithWrongInfo", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common Functionality To logIn In To Dispatch OR SPP Dispatch and To open SearchCalls Window
		                diLiveCallSearch(data);
		                //Enter the wrong club Code
		                diSearchCalls.enterClubNumberOnSearchCallsWindow(data.get("WrongClubCode"));
		                String wrongClubCode = diSearchCalls.getClubCode();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean clubCodeFlag = diSearchCalls.verifyResultsWithClubCode(wrongClubCode);
		                //verify the results with wrong Club Code
		                assertFalse(clubCodeFlag, "<b>Verified the results &  Error displayed In the search results as No matching records found,try refining your search </b>"+wrongClubCode);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

