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

/**
 * Created by E002734 on 1/11/2018.
 */
public class TC_CRArchivedCallSearchScript extends ActionEngine {


    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void archivedCallSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "archivedCallSearch", TestData, "D3CallRecieving");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("archivedCallSearch", TestData, "D3CallRecieving", intCounter);
                    this.reporter.initTestCaseDescription("1685: TC-CR Archived Call Search" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    LoginLib login = new LoginLib();
                    CRHomeLib crHomeLib = new CRHomeLib();
                    CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
                    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
                    CRVehicleTriageLib vehicleTriageLib = new CRVehicleTriageLib();

                    navigateToApplication("CR");
                    crHomeLib.verifyandClickLogout();
                    login.login(data.get("LoginName"), data.get("Password"));
                    crHomeLib.verifyHomeScreen();
                    crHomeLib.messageDialogBoxClose();
                    crMemberSearchLib.currentCallClose();
                    crSearchCall.clickOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    //Enter search start date and end date in search call window to get Archived call
                    crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    String startdate = crSearchCall.enterStartDateOnSearchCallsWindow(data.get("ArchivedStartdate"));
                    String enddate = crSearchCall.enterEndDateOnSearchCallsWindow(data.get("ArchivedEnddate"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();

                    //Getting a Call Date and Call Id from search call window
                    String callidAndDate = crSearchCall.getFirstCallIdAndDateInSearchCallsTable();
                    String actualdate = crSearchCall.getDateFromFirstRecordInInSearchCallsTable();

                    //Parsing String to Date format
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date startDate = sdf.parse(startdate);
                    Date endDate = sdf.parse(enddate);
                    Date actualDate = sdf.parse(actualdate);

                    //Verify given date is with the date range provided
                    assertTrue(((actualDate.after(startDate) && (actualDate.before(endDate))) || actualDate.equals(startDate)) || actualDate.equals(endDate), "Date is within the correct date range");
                    crSearchCall.clickOnFirstCallIdInSearchCallsTable();
                    crHomeLib.allErrorAlerts();

                    //verify call found in D3CallReceiving
                    assertTrue(callidAndDate.contains(crSearchCall.getCallIdInSearchCall()), "Call Id found in D3CallReceiving ");

                    //Select the start date is greater than end date
                    crSearchCall.clickOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    String currentDay = getCurrentDate();
                    String nextDay = getNextDay(currentDay);
                    crSearchCall.enterStartDateOnSearchCallsWindow(nextDay);
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify invalid search criteria for start date is greater than end date
                    assertTrue(crSearchCall.verifyInvalidSearchCriteriaForInvalidDate().contains("Invalid Search Criteria"), "Start date must be before End Date");
                    //click and verify  OK Message for invalid search criteria
                    crHomeLib.allErrorAlerts();

                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    //Getting a valid Archived call from Archived call table
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    String validCallId = crSearchCall.getValidArchivedCallId();
                    String callIdAndDate = crSearchCall.getFirstCallIdAndDateInSearchCallsTable();
                    crSearchCall.clickSearchAgainOnSearchCalls();

                    //Search for a call in search results by entering valid callid,Commcenter and date for a archived call
                    crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    crSearchCall.enterCallIdOnSearchCallsWindow(validCallId);
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    crSearchCall.clickOnFirstCallIdInSearchCallsTable();
                    crHomeLib.ClickOnYesButtonOnConfirmationWindow();
                    Thread.sleep(5000);
                    vehicleTriageLib.scriptErrorHandle();
                    //verify call matches with the call which is found in archived table
                    assertTrue(callIdAndDate.contains(crMemberSearchLib.getCallIdInMemberSearch()), "Call matches with the call looked up");

                    //Enter invalid CallID
                    crSearchCall.clickOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    crSearchCall.enterCallIdOnSearchCallsWindow(data.get("InvalidCallId"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify No matching records found for invalid call id
                    assertTrue(crSearchCall.getTextOfNoMatchingRecords().contains("No matching records found"), "Verified No matching records found");

                    //Enter facility and verify result
                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    crSearchCall.enterStartDateOnSearchCallsWindow(data.get("ArchivedStartdate"));
                    crSearchCall.enterFacilityOnSearchCallsWindow(data.get("Facility"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify the correct calls for the facility are displayed
                    crSearchCall.verifyFacilityOnSearCallWindow(data.get("Facility"));

                    //Enter clubcode and verify result
                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
                    crSearchCall.enterClubNumberOnSearchCallsWindow(data.get("ClubCode"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify specified club code is  displayed
                    crSearchCall.verifyClubNumberOnSearCallWindow(data.get("ClubCode"));

                    //Enter Member first name and last name and verify result
                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    crSearchCall.enterMemberFirstNameAndLastNameOnSearchCallsWindow(data.get("MemberFirstName"), data.get("MemberLastName"));
                    crSearchCall.enterStartDateOnSearchCallsWindow(data.get("ArchivedStartdate"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    boolean lastName = crSearchCall.verifyFirstNameLastNameInArchivedCall(data.get("MemberLastName"));
                    //verify MemberName entered is matched
                    assertTrue(lastName, "Member LastName Entered is Displayed");

                    //Enter Member number and verify result
                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    crSearchCall.enterMemberNumberOnSearchCallsWindow(data.get("MemberNumber"));
                    crSearchCall.enterStartDateOnSearchCallsWindow(data.get("ArchivedStartdate"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify Member number entered is matched
                    crSearchCall.verifyMemberNumberOnSearCallWindow(data.get("MemberNumber"));

                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    //select LiveCallType
                    crSearchCall.enterCallType(data.get("LiveCallType"));
                    crSearchCall.enterStartDateOnSearchCallsWindow(data.get("ArchivedStartdate"));
                    crSearchCall.enterEndDateOnSearchCallsWindow(data.get("ArchivedEnddate"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify no matching records found for LivecallType
                    assertTrue(crSearchCall.verifyNoRecordFoundForSearchResults().contains("No matching records found, try refining your search"), "Archived calls does not display results");


                    crSearchCall.clickSearchAgainOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    //select LiveAndArchivedCallType
                    crSearchCall.enterCallType(data.get("LiveAndArchivedCallType"));
                    crSearchCall.clickOnSearchButtonOnSearchCallsWindow();
                    //verify  matching records are displayed
                    assertTrue(crSearchCall.verifySearchResultsInArchivedCalls(), "Archived call Displayed in search results");

                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("CR", "1685", ReportStatus.strMethodName, intCounter, browser);
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
