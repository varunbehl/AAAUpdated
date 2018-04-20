package com.aaa.web.script;


import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class TC_DIArchivedCallSearch extends ActionEngine {


    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()

    public void diArchivedCallSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIArchivedCallSearch", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIArchivedCallSearch", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1748: TC-DI Archived Call Search" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    CRHomeLib home = new CRHomeLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRTowDestinationLib tow = new CRTowDestinationLib();
                    CRServiceLib services = new CRServiceLib();
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    DILoginLib diLogin = new DILoginLib();
                    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
                    LoginLib login = new LoginLib();
                    LoginRoleLib loginRole = new LoginRoleLib();

                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnSearchCallsInDispatch();
                    //Enter search start date and end date in search call window to get Archived call
                    diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    String startdate = diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
                    String enddate = diSearchCalls.enterEndDate(data.get("ArchivedEnddate"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();

                    //Getting a Call Date and Call Id from search call window
                    String callidAndDate = diSearchCalls.getFirstCallIdAndDateInSearchCallsTable();
                    String actualdate = diSearchCalls.getDateFromFirstRecordInInSearchCallsTable();

                    //Parsing String to Date format
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date startDate = sdf.parse(startdate);
                    Date endDate = sdf.parse(enddate);
                    Date actualDate = sdf.parse(actualdate);

                    //Verify given date is with the date range provided
                    assertTrue(((actualDate.after(startDate) && (actualDate.before(endDate))) || actualDate.equals(startDate)) || actualDate.equals(endDate), "Date is within the correct date range");
                    diSearchCalls.clickOnFirstCallIdInSearchCallsTable();

                    //verify call found in MCD Window
                    assertTrue(callidAndDate.contains(diMCD.getCallIdFromMcdWindow()), "Call found in MCD Window");
                    diMCD.clickOnMCDCloseWindow();

                    //Select the start date is greater than end date
                    diHome.clickOnSearchCallsInDispatch();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    String currentDay = getCurrentDate();
                    String nextDay = getNextDay(currentDay);
                    diSearchCalls.enterStartDate(nextDay);
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    //verify invalid search criteria for start date is greater than end date
                    assertTrue(diSearchCalls.verifyInvalidSearchCriteriaForDate().contains("Invalid Search Criteria"), "Start date must be before End Date");

                    //click and verify  OK Message for invalid search criteria
                    home.allErrorAlerts();
                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();

                    //Getting a valid Archived call from Archived call table
                    String validCallId = diSearchCalls.getValidArchivedCallId();
                    String callIdAndDate = diSearchCalls.getFirstCallIdAndDateInSearchCallsTable();
                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();

                    //Search for a call in search results by entering valid callid,Commcenter and date for a archived call
                    diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    diSearchCalls.clickAndEnterCallIDInfo(validCallId);
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    diSearchCalls.clickOnFirstCallIdInSearchCallsTable();
                    //verify call matches with the call which is found in archived table
                    assertTrue(callIdAndDate.contains(diMCD.getCallIdFromMcdWindow()), "Call matches with the call looked up");
                    diMCD.clickOnMCDCloseWindow();

                    //Enter invalid CallID
                    diHome.clickOnSearchCallsInDispatch();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    diSearchCalls.clickAndEnterCallIDInfo(data.get("InvalidCallId"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    //verify No matching records found for invalid call id
                    assertTrue(diSearchCalls.verifyNoRecordFoundForSearchResults().contains("No matching records found"), "Verified No matching records found");

                    //Enter facility and verify result
                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
                    diSearchCalls.enterFacilityOnSearchCallsWindow(data.get("Facility"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    boolean facility = diSearchCalls.verifyResultsWithFacility(data.get("Facility"));
                    //verify the correct calls for the facility are displayed
                    assertTrue(facility, "Facility Entered are Displayed");

                    //Enter clubcode and verify result
                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    diSearchCalls.enterClubNumberOnSearchCallsWindow(data.get("ClubCode"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    boolean clubcode = diSearchCalls.verifyResultsWithClubCode(data.get("ClubCode"));
                    //verify specified club code is  displayed
                    assertTrue(clubcode, "Clubcode entered is displayed");

                    //Enter Member first name and last name and verify result
                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    diSearchCalls.enterMemberLastNameSearchOnSearchCallsWindow(data.get("MemberLastName"));
                    diSearchCalls.enterMemberFirstNameSearchOnSearchCallsWindow(data.get("MemberFirstName"));
                    diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    //verify MemberName entered is matched
                    boolean lastName = diSearchCalls.verifyFirstNameLastNameInArchivedCall(data.get("MemberLastName"));
                    assertTrue(lastName, "Member LastName Entered is Displayed");

                    //Enter Member number and verify result
                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    diSearchCalls.enterMemberNumberInSearchCallDispatch(data.get("MemberNumber"));
                    diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    boolean memberNumber = diSearchCalls.verifyResultsWithMemberNumber(data.get("MemberNumber"));
                    //verify membership number displayed is matched
                    assertTrue(memberNumber, "Entered MemberNumber is Displayed");

                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    //select LiveCallType
                    diSearchCalls.enterCallType(data.get("LiveCallType"));
                    diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
                    diSearchCalls.enterEndDate(data.get("ArchivedEnddate"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    //verify no matching records found for LivecallType
                    assertTrue(diSearchCalls.verifyNoRecordFoundForSearchResults().contains("No matching records found, try refining your search"), "Archived calls does not display results");

                    diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                    diSearchCalls.clickOnClearbuttonInSearchCalls();
                    //select LiveAndArchivedCallType
                    diSearchCalls.enterCallType(data.get("LiveAndArchivedCallType"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    //verify  matching records are displayed
                    assertTrue(diSearchCalls.verifySearchResultsInArchivedCalls(), "Archived call Displayed in search results");
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1748", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public String getNextDay(String curDate) throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }

    public String getCurrentDate() {
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate = sdf.format(date);
        return currentdate;
    }
}
