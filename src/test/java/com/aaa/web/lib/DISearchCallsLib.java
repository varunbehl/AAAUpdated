package com.aaa.web.lib;


import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.DISearchCallsPage;
import com.aaa.accelerators.ActionEngine;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class DISearchCallsLib extends ActionEngine {
    List<WebElement> allCallIdAndDates = null;
    List<WebElement> status = null;
    public static SimpleDateFormat displayFormat;
    public static SimpleDateFormat parseFormat;
    public static Date date;
    public static String time;
    public static String startTimeInSearch;
    public static String endTimeInSearch;
    public static String startDateInSearchDetails;
    public static int callTimeInHours;
    public static int callTimeInMinutes;
    public static int startTimeInHours;
    public static int startTimeInMinutes;
    public static int endTimeInHours;
    public static int endTimeInMinutes;
    public static String startDateValue;
    public static String firstNameInSearch;
    public static String lastNameInSearch;
    public static String firstName;
    public static String lastName;
    public static String RAPID;
    public List<WebElement> allDates;
    public List<WebElement> allFacility;
    public List<WebElement> allTruckID;
    public List<WebElement> allClubNumbers;
    public List<WebElement> memberLastName;
    public List<WebElement> allMemberNumber;
    public List<WebElement> vehicleInfoList;
    public List<WebElement> allCity;


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumberInSearchCallDispatch
     * description :: This function enters member number in search calls window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void enterMemberNumberInSearchCallDispatch(String memberNumber) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMemberNumberinSearchCall, "Search Member in Dispatch Queue");
        type(DISearchCallsPage.txtMemberNumberinSearchCall, memberNumber, "Search Member");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButtonInSearchCallDispatch
     * description :: This function clicks on Search Button in search calls window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void clickOnSearchButtonInSearchCallDispatch() throws Throwable {
        click(DISearchCallsPage.btnSearchinSearchCall, "Search Button in Dispatch Queue");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectSPStatusRowInSearchCallDispatch
     * description :: This function clicks row with SP status in search calls window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void selectSPStatusRowInSearchCallDispatch() throws Throwable {
        isElementPresent(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in Dispatch search results");
        waitForVisibilityOfElement(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in sesarch results");
        //click(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in Dispatch Queue");
        //mouseDoubleClick(DISearchCallsPage.SelectRowsFromSearchCallTable, "open details of the member");
        click(DISearchCallsPage.selectSPStatusRow, "open details of the member");
        Thread.sleep(3000);
        mouseDoubleClick(DISearchCallsPage.selectSPStatusRow, "open details of the member");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchandSelectMemberNumber
     * description :: This function is used to click on member number text box, enter member and click on search button.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void searchandSelectMemberNumber(String memberNumber) throws Throwable {
        clickAndEnterMemberNumber(memberNumber);
        clickOnSearchInSearchCalls();
        selectRow();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickAndEnterCallIDInfo
     * description :: This function is used to click on search member text box and enter call id on search member text box.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void clickAndEnterCallIDInfo(String callID) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.btnCallIDinSearchCall, "Search Member Text Box");
        click(DISearchCallsPage.btnCallIDinSearchCall, "Search Member Text Box");
        type(DISearchCallsPage.btnCallIDinSearchCall, callID, "Search Member Text Box");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectCallID
     * description :: This functions enters call id on search member text box then clicks on search button and clicks on the entered call id.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void searchAndSelectCallID(String CallID) throws Throwable {
        clickAndEnterCallIDInfo(CallID);
        clickOnSearchInSearchCalls();
        selectSPStatusRowInSearchCallDispatch();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickAndEnterMemberNumber
     * description :: Thic function clicks on member number text field in search calls window and enters member number
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void clickAndEnterMemberNumber(String memberNumber) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMemberNumberinSearchCall, "Search Member Text Box");
        click(DISearchCallsPage.txtMemberNumberinSearchCall, "Search Member Text Box");
        type(DISearchCallsPage.txtMemberNumberinSearchCall, memberNumber, "Search Member Text Box");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchInSearchCalls
     * description ::
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void clickOnSearchInSearchCalls() throws Throwable {
        click(DISearchCallsPage.btnSearchinSearchCall, "Search Button");
        Thread.sleep(3000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectRow
     * description :: This function clicks on first row in search window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void selectRow() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.SelectFirstRow, "Search Member Result");
        mouseDoubleClick(DISearchCallsPage.SelectFirstRow, "Search Member Result");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectCallStatus
     * description :: This function enters call status.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */

    public void selectCallStatus(String status) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DISearchCallsPage.selectCallStatus, "select Call Status");
        type(DISearchCallsPage.selectCallStatus, status, "select Call Status");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDate
     * description :: This function enters start date in search window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */

    public String enterStartDate(String Date) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.startDate, "Start date");
        type(DISearchCallsPage.startDate, Date, "Start date");
        return Date;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndDate
     * description :: This function enters End date in search window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */

    public String enterEndDate(String Date) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DISearchCallsPage.endDate, "End Date");
        type(DISearchCallsPage.endDate, Date, "End Date");
        return Date;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectOddRow
     * description :: This function is used to click on callID on odd row in search calls window.
     * date :: 05-Nov-2017
     * author :: Cigniti
     */


    public void selectOddRow() throws Throwable {
        isElementPresent(DISearchCallsPage.selectOddRow, "select Member in Dispatch Queue");
        waitForVisibilityOfElement(DISearchCallsPage.selectOddRow, "select Member in Dispatch Queue");
        click(DISearchCallsPage.selectOddRow, "open details of the member");
        mouseDoubleClick(DISearchCallsPage.selectOddRow, "open details of the member");
    }

    /**
     * param :: NA
     * return ::voidAA
     * throws :: throwable
     * methodName :: getStartDate
     * description :: This function is used to get first date from search window.
     * date :: 26/01/18
     * author :: Cigniti
     */

    public String getStartDate() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.startDate, "Get start date");
        String startDate = getAttributeByValue(DISearchCallsPage.startDate, "Get start date");
        return startDate;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getEndDate
     * description :: This function is used to get end date from search window.
     * date :: 26/01/18
     * author :: Cigniti
     */

    public String getEndDate() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.endDate, "Get end date");
        String endDate = getAttributeByValue(DISearchCallsPage.endDate, "Get end date");
        return endDate;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallID
     * description :: This function is used to get call id from search window.
     * date :: 26/01/18
     * author :: Cigniti
     */
    public String getCallID() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.btnCallIDinSearchCall, "CallID");
        String callID = getAttributeByValue(DISearchCallsPage.btnCallIDinSearchCall, "CallID");
        return callID;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyResultsWithCurrentDate
     * description :: This function searches for callid availability for current date.
     * date :: 26/01/18
     * author ::Cigniti
     */
    public boolean verifyResultsWithCurrentDate(String currentDate) throws Throwable {
        boolean flagDate = false;
        int a = 0;
        boolean flagForNorecords = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Records Fornd");
        if (flagForNorecords) {
            assertTrue(flagForNorecords, "No Results are available for Current Date");
        } else {
            allCallIdAndDates = getWebElementList(DISearchCallsPage.callIDAndDateInSearclCallWindow, "CallId in Search Call Window");
            if (allCallIdAndDates != null) {
                for (int i = 0; i < allCallIdAndDates.size(); i++) {
                    String callIdAndDateFromList = allCallIdAndDates.get(i).getText();
                    String callIDAndDate[] = callIdAndDateFromList.split("\n");
                    String dateFromList = callIDAndDate[0];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date d_date = dateFormat.parse(dateFromList);
                    String strDate = dateFormat.format(d_date);

                    if (currentDate.contains(strDate)) {
                        flagDate = true;
                    }
                }
            }
        }
        return flagDate;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyResultsWithCallID
     * description :: This function searches for callid that is passed as a parameter is available in Search calls window.
     * date :: 26/01/18
     * author :: Cigniti
     */
    public boolean verifyResultsWithCallID(String callId) throws Throwable {
        boolean flagId = false;
        boolean flagForNorecords = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Records Found");
        if (flagForNorecords) {
            assertTrue(flagForNorecords, "No Results are available with CallID  " + callId);
        } else {
            String callIdAndDate = getText(DISearchCallsPage.callIDAndDateInSearclCallWindow, "CallId in Search Call Window");
            if (callIdAndDate != null) {
                String callIDAndDate[] = callIdAndDate.split("\n");
                String callIDFromList = callIDAndDate[1];
                String callIdList[] = callIDFromList.split("#");
                String callIDInList = callIdList[1];
                if (callIDInList.contains(callId)) {
                    flagId = true;
                    //assertTrue((callIDInList.equals(callId)), "Verified the results returned & one call is returned for the call ID    " + callId);
                }
            }

        }
        return flagId;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartTimeOnSearchCallsWindow
     * description :: This function is used to enter start time on search calls window.
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterStartTimeOnSearchCallsWindow(String startTime) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtStartTime, "Search Calls Window startTime");
        type(DISearchCallsPage.txtStartTime, startTime, "Search Calls Window startTime");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickCloseBtnOnSearchCallwindow
     * description :: This function clicks on close button on search calls window.
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */

    public void clickCloseBtnOnSearchCallwindow() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.btnCloseSearchCallsWindow, "Close Button");
        click(DISearchCallsPage.btnCloseSearchCallsWindow, "Close Button");
        Thread.sleep(4000);


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndTimeOnSearchCallsWindow
     * description :: This function is used to enter end time on search calls window.
     * date :: 29-jan-2018
     * author ::Abhiram
     */
    public void enterEndTimeOnSearchCallsWindow(String endTime) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtEndTime, "Search Calls Window endTime");
        type(DISearchCallsPage.txtEndTime, endTime, "Search Calls Window endTime");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterRAPNumberOnSearchCallsWindow
     * description :: This function is used to enter RAP number on search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterRAPNumberOnSearchCallsWindow(String RAPNumber) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtRAPNumber, "Search Calls Window RAPNumber");
        type(DISearchCallsPage.txtRAPNumber, RAPNumber, "Search Calls Window RAPNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheTimeRange
     * description :: This function verifies the time range for the call id.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */

    public boolean verifyTheTimeRange(String startTime, String endTime) throws Throwable {
        boolean timeRangeFlag = false;
        waitForVisibilityOfElement(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Click On Call ID");
        click(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Click On Call ID");
        Thread.sleep(5000);
        waitForVisibilityOfElement(DISearchCallsPage.lblDateandTimeInMemberPage, "Date and Time From Member Tab");
        String dateDetails = getText(DISearchCallsPage.lblDateandTimeInMemberPage, "Date and Time From Member Tab");
        String splitStr[] = dateDetails.split(" ");
        String timeFormat = splitStr[1];
        String splittime[] = timeFormat.split(":");
        String callTimeSplittedInHours = splittime[0];
        String callTimeSplittedInMinutes = splittime[1];
        callTimeInHours = Integer.parseInt(callTimeSplittedInHours);
        callTimeInMinutes = Integer.parseInt(callTimeSplittedInMinutes);

        //startTimeInSearch = data.get("StartTime");
        String splitstartTimeInSearch[] = startTime.split(":");
        String startTimeSplittedInHours = splitstartTimeInSearch[0];
        String startTimeSplittedInMinute = splitstartTimeInSearch[1];
        startTimeInHours = Integer.parseInt(startTimeSplittedInHours);
        startTimeInMinutes = Integer.parseInt(startTimeSplittedInMinute);

        //endTimeInSearch =data.get("EndTime");
        String splitEndTimeInExcel[] = endTime.split(":");
        String endTimeSplittedInHours = splitEndTimeInExcel[0];
        String endTimeSplittedInMinutes = splitEndTimeInExcel[1];
        endTimeInHours = Integer.parseInt(endTimeSplittedInHours);
        endTimeInMinutes = Integer.parseInt(endTimeSplittedInMinutes);
        if ((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours)) {
            timeRangeFlag = true;
        }
        assertTrue((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours), "<b>The Call Time:: </b>" + timeFormat + "<b> is between::  Start time </b>" + startTime + "<b> and End Time:: </b>" + endTime);
        Thread.sleep(2000);
        return timeRangeFlag;
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: getRapNumber
     * description :: This funciton is used to get RAP number from search window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getRapNumber() throws Throwable {
        String rapNumber = getAttributeByValue(DISearchCallsPage.txtRAPNumber, "RAP Number");
        return rapNumber;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTruckOnSearchCallsWindow
     * description :: This function is used to enter Truck in Search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterTruckOnSearchCallsWindow(String truck) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtTruck, "Search Calls Window truck");
        type(DISearchCallsPage.txtTruck, truck, "Search Calls Window truck");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTruckFromSearchCallsWindow
     * description :: This function is used to get the truck from search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getTruckFromSearchCallsWindow() throws Throwable {
        String truck = getAttributeByValue(DISearchCallsPage.txtTruck, "Search Calls Window truck   ");
        return truck;
    }


    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithRapId
     * description :: This function verifies if RAP number is present on search calls winodw or not.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithRAPId(String rapNumber) throws Throwable {
        boolean rapIdFlag = false;
        boolean flagForNoRecords = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Records Found");
        if (flagForNoRecords) {
            assertTrue(flagForNoRecords, "No Results are available wirh RapNumber  ");
        } else {
            String rapNum = getText(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAP Number in Search Call Window");
            if (rapNum != null) {
                if (rapNumber.contains(rapNum)) {
                    //assertTrue(rapNumber.contains(rapNum), "Verified the results returned & RAP call is returned in the search results    " + rapNumber);
                    rapIdFlag = true;
                }
            }
        }
        return rapIdFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFacilityOnSearchCallsWindow
     * description :: This function is used to enter facility on search call window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterFacilityOnSearchCallsWindow(String facility) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtFacility, "Search Calls Window facility");
        type(DISearchCallsPage.txtFacility, facility, "Search Calls Window facility");
        Thread.sleep(2000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getFacility
     * description :: This function is used to get the facility from search calls window
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getFacility() throws Throwable {
        String facility = getAttributeByValue(DISearchCallsPage.txtFacility, "get Facility");
        return facility;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithFacility
     * description :: This function is used to verify facility which is passes as aparameter exists in search window List.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithFacility(String facility) throws Throwable {
        String facilityFromList = null;
        boolean facilityFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Facility in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found with search Criteria");
        } else {
            allFacility = getWebElementList(DISearchCallsPage.FacilityDetailsOnSearchCallsInSearclCallWindow, "Facility in Search Call Window");

            for (int i = 0; i < allFacility.size(); i++) {
                facilityFromList = allFacility.get(i).getText();
                if (facilityFromList.contains(facility)) {
                    facilityFlag = true;
                }
            }
            //assertTrue(facilityFlag, " Results matched the criteria :: Facility " + facility + "Exists in Selected List");

        }
        Thread.sleep(4000);
        return facilityFlag;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithTruckId
     * description :: This function is used to verify truck which is passes as aparameter exists in search window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithTruckId(String truck) throws Throwable {
        boolean truckIDFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found for Truck Id search");
        } else {
            Thread.sleep(3000);
            allTruckID = getWebElementList(DISearchCallsPage.TruckIDDetailsOnSearchCallsInSearclCallWindow, "Truck ID in Search Call Window");
            for (int i = 0; i < allTruckID.size(); i++) {
                String truckIDFromList = allTruckID.get(i).getText();
                if (truckIDFromList.contains(truck)) {
                    truckIDFlag = true;
                }
            }
            //assertTrue(truckIDFlag, " Call is Serviced by the Truck,Truck Id is     " +truck);
        }
        Thread.sleep(4000);
        return truckIDFlag;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTakerOnSearchCallsWindow
     * description :: This function is used to enter the callid on search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterUserIDOnSearchCallsWindow(String callTaker) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtCallTaker, "Search Calls Window callTaker");
        type(DISearchCallsPage.txtCallTaker, callTaker, "Search Calls Window callTaker");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPhoneNumberOnSearchCallsWindow
     * description :: This function is used to enter the phone number on search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterPhoneNumberOnSearchCallsWindow(String phoneNumber) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtPhoneNumber, "Search Calls Window phoneNumber");
        type(DISearchCallsPage.txtPhoneNumber, phoneNumber, "Search Calls Window phoneNumber");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPhoneNumberOnSearchCallsWindow
     * description :: This function is used to enter the phone number on search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getPhoneNumber() throws Throwable {
        String phoneNumber = getAttributeByValue(DISearchCallsPage.txtPhoneNumber, "PhoneNumber");
        return phoneNumber;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnCallIdOnSearchCallsWindow
     * description :: This function is used to click on callID on search calls window.
     * retrivedTime :: 18-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void ClickOnCallIdOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date");
        click(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getUserId
     * description :: This function is used to get call id from search window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getUserId() throws Throwable {
        String userId = getAttributeByValue(DISearchCallsPage.txtCallTaker, "User ID");
        return userId;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyResultsWithCallTakerID
     * description :: This function is used to Verifing the returned results with CallTakerID(Application logged in UserName)
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithCallTakerID(String CallTaker, String callTakerFromMcd) throws Throwable {
        boolean callTakerFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found for CallTaker search");
        } else {
            Thread.sleep(2000);
            //String callTakerOnMCDWindow = getText(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
            Thread.sleep(2000);
            if (CallTaker.equalsIgnoreCase(callTakerFromMcd)) {
                callTakerFlag = true;
                //assertTrue(CallTaker.equalsIgnoreCase(callTakerOnMCDWindow), "calls are returned based on the user id   " + CallTaker);
            }
        }
        return callTakerFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyResultsWithphoneNumber
     * description :: This function is used to verfiy phone number which is passed as a parameter exists in seatch result window list.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithphoneNumber(String phoneNum) throws Throwable {
        boolean phoneNumberFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found for phone Number search");
        } else {
            String phoneNumber2 = phoneNum.substring(6, 10);
            waitForVisibilityOfElement(DIMCDPage.phoneNumberValue(phoneNumber2), "Phone Number");
            String phoneNumber1 = getText(DIMCDPage.phoneNumberValue(phoneNumber2), "Phone Number");
            String phonenum[] = phoneNumber1.split(" ");
            String phone1 = phonenum[0].substring(1, 4);
            String phone2[] = phonenum[1].split("-");
            String phone3 = phone2[0];
            String phone4 = phone2[1];
            Thread.sleep(3000);
            String phoneNumber = phone1 + phone3 + phone4;
            if (phoneNum.contains(phoneNumber)) {
                phoneNumberFlag = true;
                //assertTrue(phoneNumberFromResults.equals(phoneNumber),"Verified the results returned & call is returned for that specific member  ");
            }
            Thread.sleep(2000);
        }
        return phoneNumberFlag;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClubNumberOnSearchCallsWindow
     * description :: This function is used to enter club number in search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterClubNumberOnSearchCallsWindow(String clubNumber) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtClubCode, "Search Calls Window clubNumber");
        type(DISearchCallsPage.txtClubCode, clubNumber, "Search Calls Window clubNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getClubCode
     * description :: This function is used to get club number from search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getClubCode() throws Throwable {
        String clubCode = getAttributeByValue(DISearchCallsPage.txtClubCode, "Search Calls Window clubNumber");
        return clubCode;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyResultsWithClubCode
     * description :: This widnow is used to verify the club number which is passed as parameter is exists in search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithClubCode(String clubCode) throws Throwable {
        boolean clubNoFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Club Number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No matching records found, try refining your search");
        } else {
            allClubNumbers = getWebElementList(DISearchCallsPage.ClubNumberOnSearchCallsInSearclCallWindow, "Club Number in Search Call Window");

            for (int i = 0; i < allClubNumbers.size(); i++) {
                String ClubNumbersFromList = allClubNumbers.get(i).getText();
                if (ClubNumbersFromList.contains(clubCode)) {
                    clubNoFlag = true;

                }
            }
            //assertTrue(clubNoFlag, "Verified the calls & Call is returned with club Code    "+clubCode);
        }
        Thread.sleep(4000);
        return clubNoFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberLastNameSearchOnSearchCallsWindow
     * description :: This function is used to enter on last name on search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterMemberLastNameSearchOnSearchCallsWindow(String memberLastName) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMemberLastNameSearch, "Search Calls Window member LastName");
        type(DISearchCallsPage.txtMemberLastNameSearch, memberLastName, "Search Calls Window member LastName");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getLaseName
     * description :: This function is used to get last name from search calls window.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */

    public String getLaseNameFromSearchCallsWindow() throws Throwable {
        String lastName = getAttributeByValue(DISearchCallsPage.txtMemberLastNameSearch, "Search Calls Window member LastName");
        return lastName;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithLastName
     * description :: This function is used to verify last name which is passed as a parameter is available in search window or not.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */

    public boolean verifyResultsWithLastName(String lastName) throws Throwable {
        boolean lastNameFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Last Name in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found for Last name Search ");
        } else {
            memberLastName = getWebElementList(DISearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Last Name in Search Call Window");

            for (int i = 0; i < memberLastName.size(); i++) {
                String memberLastNameFromList = memberLastName.get(i).getText();
                String lastNameLowerCase = memberLastNameFromList.toLowerCase();
                if (lastNameLowerCase.contains(lastName)) {
                    lastNameFlag = true;
                }
            }
            //assertTrue(lastNameFlag, "Verified the results & call(s) is returned matching the last name    "+lastName);
        }
        Thread.sleep(4000);
        return lastNameFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumberOnSearchCallsWindow
     * description :: This function is used to enter member number on search calls window.
     * date :: 29-Dec-2017
     * author ::Lakshmi Prasanna
     */
    public void enterMemberNumberOnSearchCallsWindow(String memberNumber) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMemberNumberSearch, "MemberNumber on Search Calls Window");
        type(DISearchCallsPage.txtMemberNumberSearch, memberNumber, "MemberNumber on Search Calls Window");
        Thread.sleep(2000);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getMemberNumberFromSearCalls
     * description :: This function is used to get the member number from search calls window.
     * date :: 29-Dec-2017
     * author ::Lakshmi Prasanna
     */
    public String getMemberNumberFromSearCalls() throws Throwable {
        String memNumber = getAttributeByValue(DISearchCallsPage.txtMemberNumberSearch, "Member Number");
        return memNumber;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithMemberNumber
     * description :: This function is used to verify member number which is passed as a parameter is available in search window or not.
     * date :: 29-Dec-2017
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithMemberNumber(String memNumber) throws Throwable {
        boolean memberNumberFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Member Number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found for Member Number Search");
        } else {
            allMemberNumber = getWebElementList(DISearchCallsPage.MemberNumberOnSearchCallsInSearclCallWindow, "Member Number in Search Call Window");

            for (int i = 0; i < allMemberNumber.size(); i++) {
                String memberNumberFromList = allMemberNumber.get(i).getText();
                if (memberNumberFromList.contains(memNumber)) {
                    memberNumberFlag = true;

                }
            }
            //assertTrue(memberNumberFlag, "Verified the results & Call record is returned for the member    "+memNumber);
        }
        Thread.sleep(4000);
        return memberNumberFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterYearVehicleInforationOnSearchCallsWindow
     * description :: This function is used to enter vehicle year on search calls window
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterYearVehicleInforationOnSearchCallsWindow(String vehicleYear) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtYearVehicleInformation, "vehicle Year on Search Call");
        type(DISearchCallsPage.txtYearVehicleInformation, vehicleYear, "vehicle Year on Search Call");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMakeVehicleInforationOnSearchCallsWindow
     * description :: This function is used to enter vehicle make on search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterMakeVehicleInforationOnSearchCallsWindow(String vehicleMake) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMakeVehicleInformation, "Search Calls Window vehicle Make");
        type(DISearchCallsPage.txtMakeVehicleInformation, vehicleMake, "Search Calls Window vehicle Make");
        click(DISearchCallsPage.txtCity, "city text box");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterModelVehicleInforationOnSearchCallsWindow
     * description :: This function is used to enter vehicle model on search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterModelVehicleInforationOnSearchCallsWindow(String vehicleModel) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtModelVehicleInformation, "Search Calls Window vehicle Model");
        type(DISearchCallsPage.txtModelVehicleInformation, vehicleModel, "Search Calls Window vehicle Model");
    }


    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleYearFromSearCalls
     * description :: This function is used to get vehicle year from search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getVehicleYearFromSearCalls() throws Throwable {
        String year = getAttributeByValue(DISearchCallsPage.txtYearVehicleInformation, "vehicle Year on Search Call");
        return year;
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleMakeFromSearCalls
     * description :: This function is used to get vehicle make from search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getVehicleMakeFromSearCalls() throws Throwable {
        String make = getAttributeByValue(DISearchCallsPage.txtMakeVehicleInformation, "vehicle Make on Search Call");
        return make;
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleModelFromSearCalls
     * description :: This function is used to get vehicle model from search calls window
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getVehicleModelFromSearCalls() throws Throwable {
        String model = getAttributeByValue(DISearchCallsPage.txtModelVehicleInformation, "vehicle Model on Search Call");
        return model;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithVehicle
     * description :: This function verifies call is returned with specific year and model of the vehicle passed as parameters.
     * date :: 29-jan-2018
     * author ::Lakshmi Prasanna
     */

    public boolean verifyResultsWithVehicle(String year, String make, String model) throws Throwable {
        boolean vehicleYearFlag = false;
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Year in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            vehicleInfoList = getWebElementList(DISearchCallsPage.VehicleInfoOnSearchCallsInSearclCallWindow, "Vehicle Year in Search Call Window");

            for (int i = 0; i < vehicleInfoList.size(); i++) {
                String vehicleInfoFromList = vehicleInfoList.get(i).getText();
                String vehicleDetails[] = vehicleInfoFromList.split(" ");
                String yearDetails = vehicleDetails[0];
                String makeDetails = vehicleDetails[1];
                String modelDetails = vehicleDetails[2];
                if (yearDetails.equalsIgnoreCase(year) && makeDetails.equalsIgnoreCase(make) && modelDetails.equalsIgnoreCase(model)) {
                    vehicleYearFlag = true;
                }
            }
            //assertTrue(vehicleYearFlag, "Verified the result & Call is returned for  Vehicle Search  with     "+year+"   "+make+"   "+model);
        }
        Thread.sleep(4000);
        return vehicleYearFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationOnSearchCallsWindow
     * description :: This function is used to enter location on search calls window
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterLocationOnSearchCallsWindow(String location) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtLocation, "Location on Search Calls Window ");
        type(DISearchCallsPage.txtLocation, location, "Location on Search Calls Window");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getStreetAddressFromSearCalls
     * description :: This function is used to get street address from search calls window
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getStreetAddressFromSearCalls() throws Throwable {
        String breakDwnLocation = getAttributeByValue(DISearchCallsPage.txtLocation, "Location on Search Calls Window");
        return breakDwnLocation;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityOnSearchCallsWindow
     * description :: This function is used to enter city on search calls window
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void enterCityOnSearchCallsWindow(String city) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtCity, "City on Search Calls Window");
        type(DISearchCallsPage.txtCity, city, "City on Search Calls Window");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getCityLocationFromSearCalls
     * description :: This function is used to get locations from search calls window
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getCityLocationFromSearCalls() throws Throwable {
        String breakdDwnCity = getAttributeByValue(DISearchCallsPage.txtCity, "City on Search Calls Window");
        return breakdDwnCity;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyResultsWithBreakdownLocation
     * description :: This function verifies Call is returned for Breakdown location Search  with the parameters passed.
     * date :: 29-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyResultsWithBreakdownLocation(String bkDwnStreetAddress, String bkDownCity) throws Throwable {
        boolean cityFlag = false;
        boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "City in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allCity = getWebElementList(DISearchCallsPage.CityOnSearchCallsInSearclCallWindow, "City in Search Call Window");

            for (int i = 0; i < allCity.size(); i++) {
                String allCityFromList = allCity.get(i).getText();
                if (allCityFromList.contains(bkDwnStreetAddress) && allCityFromList.contains(bkDownCity)) {
                    cityFlag = true;
                }
            }
            //assertTrue(cityFlag, "Verified the result & Call is returned for Breakdown location Search  with     "+bkDwnStreetAddress+"   "+bkDownCity);
        }
        Thread.sleep(4000);

        return cityFlag;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyMatchingRecordsOnMCD
     * description :: This function validates if no mathcing records text is returned or not
     * date :: 04-feb-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyMatchingRecordsOnMCD() throws Throwable {
        boolean noRecords = isVisibleOnly(DISearchCallsPage.txtNoRecordsfoundOnSearchCalls, "No Matching Records");
        return noRecords;
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: enterValueInStatusTextBonInSearchCalls
     * description :: This function is used to enter status on search calls window
     * date :: 04-feb-2018
     * author ::Lakshmi Prasanna
     */

    public String enterValueInStatusTextBonInSearchCalls(String status) throws Throwable {
        type(DISearchCallsPage.txtStatusInSearchCalls, status, "Status Value");
        return status;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectClearedCallsFromSearchResults
     * description :: This functin is used to select and click on call with cleared call status.
     * date :: 04-feb-2018
     * author ::Cigniti
     */

    public void selectClearedCallsFromSearchResults() throws Throwable {

        status = getWebElementList((DISearchCallsPage.lblClearedCallRow), "Cleared calls");
        if (status != null) {
            allCallIdAndDates = getWebElementList(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAPID");

            for (int i = 0; i < allCallIdAndDates.size(); i++) {
                if (allCallIdAndDates != null) {
                    mouseDoubleClick(DISearchCallsPage.lblClearedCallRow, "Cleared calls");
                    break;
                }
            }
        }
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyRAPIDsOnMCD
     * description :: This function returns the RAP Number from Search calls window.
     * date :: 04-feb-2018
     * author ::Cigniti
     */

    public String verifyRAPIDsOnMCD() throws Throwable {
        RAPID = getText(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "No Matching Records");
        return RAPID;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectClearCallRow
     * description :: This function selects call id with status Cleared.
     * date :: 04-feb-2018
     * author ::Cigniti
     */

    public void selectClearCallRow() throws Throwable {
        mouseClick(DISearchCallsPage.selectClearCallStatusRow, "Clear call row");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommCenterOnSearchCallsWindow
     * description ::This method is used to enter comm center on search calls
     * date :: 14-02-2018
     * author ::Cigniti
     */
    public void enterCommCenterOnSearchCallsWindow(String commCenter) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtCommCenter, "Search Calls Window callTaker");
        type(DISearchCallsPage.txtCommCenter, commCenter, "Search Calls Window callTaker");
        Thread.sleep(2000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstCallIdInSearchCallsTable
     * Description: This method is used to select an first  callId from search call table
     * Date:
     * author ::Cigniti
     */

    public void clickOnFirstCallIdInSearchCallsTable() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallIdAndDate");
        click(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallIdAndDate");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getFirstCallIdAndDateInSearchCallsTable
     * Description: This function  is used to get on first callid/Date on search calls table.
     * Date:
     * author ::Cigniti
     */
    public String getFirstCallIdAndDateInSearchCallsTable() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callIdAndDate = getText(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallId And Date From search Results:");
        return callIdAndDate;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearbuttonInSearchCalls
     * Description: This method is used to click on clear button on search calls
     * Date:
     * author ::Cigniti
     */

    public void clickOnClearbuttonInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.btnClearOnSearchCalls, "Clear");
        click(DISearchCallsPage.btnClearOnSearchCalls, "Clear");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyInvalidSearchCriteriaForDate
     * Description: This method is to verify invalide search criteria for invalid date  search calls
     * Date:
     * author ::Cigniti
     */

    public String verifyInvalidSearchCriteriaForDate() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.lblInvalidSearchCriteriaErrorForDate, "");
        String errorInvalid = getText(DISearchCallsPage.lblInvalidSearchCriteriaErrorForDate, "Invalid Search Criteria Error For Date");
        return errorInvalid;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchAgainbuttonInSearchCalls
     * Description: This method is used to click on Search Again button  on search calls
     * Date:
     * author ::Cigniti
     */

    public void clickOnSearchAgainbuttonInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.btnSearchAgain, "Search Again");
        click(DISearchCallsPage.btnSearchAgain, "Search Again");
    }


    /**
     * param :: String Input
     * return ::String
     * throws :: throwable
     * methodName :: getValidArchivedCall
     * Description: This method is used to get a callid from a search results
     * Date:
     * author ::Cigniti
     */

    public String getValidArchivedCallId() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callIDAndDate = getText(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callid = callIDAndDate.substring(11, 16);
        return callid;
    }

    /**
     * param :: String Input
     * return ::String
     * throws :: throwable
     * methodName :: getValidArchivedCall
     * Description: This method is used to verify no record found for a search criteria
     * Date: 1
     * author ::Cigniti
     */
    public String verifyNoRecordFoundForSearchResults() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");
        String noRecordFound = getText(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");
        return noRecordFound;
    }

    /**
     * param :: String Input
     * return ::boolean
     * throws :: throwable
     * methodName :: getValidArchivedCall
     * Description: This method is used to verify FirstName and LastName  from a search criteria
     * Date: 14-01-2018
     * author ::Cigniti
     */

    public boolean verifyFirstNameLastNameInArchivedCall(String firstNameLastName) throws Throwable {
        boolean firstAndLast = false;
        waitForVisibilityOfElement(DISearchCallsPage.lblMemberAndClubCodeOnSearchCallsTable, "MemberName MemberNumber And ClubCode");
        String memberNameMemberNumberAndClubCode = getText(DISearchCallsPage.lblMemberAndClubCodeOnSearchCallsTable, "MemberName MemberNumber And ClubCode");
        if (memberNameMemberNumberAndClubCode.contains(firstNameLastName)) {
            firstAndLast = true;
        } else {
            firstAndLast = true;
        }
        return firstAndLast;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberFirstNameSearchOnSearchCallsWindow
     * description ::This method is used to enter first name on search calls window
     * date ::
     * author ::Cigniti
     */
    public void enterMemberFirstNameSearchOnSearchCallsWindow(String memberFirstName) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.txtMemberFirstNameSearch, "Search Calls Window MemberFirstName");
        type(DISearchCallsPage.txtMemberFirstNameSearch, memberFirstName, "Search Calls Window MemberFirstName");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallType
     * description ::This method is used to click on CallType Dropdown and select LIVE ONLY and LIVE AND ARCHIVED type
     * date ::
     * author ::Cigniti
     */

    public void enterCallType(String calltype) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.drpdwnCallType, "Call Type Dropdown");
        click(DISearchCallsPage.drpdwnCallType, "Call Type Dropdown");
        click(DISearchCallsPage.selectCallType(calltype), "select" + calltype + "call type");
    }

    /**
     * param ::
     * methodName :: verifySearchResultsInArchivedCalls
     * description :: To verify search results shown in archived table
     * @return boolean
     * @throws Throwable
     * @author Madhukar
     * Date:21-03-2018
     */
    public boolean verifySearchResultsInArchivedCalls() throws Throwable {
        boolean callIDAndDate=waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        return callIDAndDate;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getDateFromFirstRecordInInSearchCallsTable
     * Description: This function  is used to get on first callDate on search calls table.
     * Date:
     * author ::Cigniti
     */
    public String getDateFromFirstRecordInInSearchCallsTable() throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callIdAndDate = getText(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallId And Date From search Results:");
        String splitIdandDate[]= callIdAndDate.split("#");
        String date=splitIdandDate[0];
        return date.trim();
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: visibilityOfRecordsOnSearchCalls
     * Description: This function  is used to get on first callDate on search calls table.
     * Date:
     * author ::Cigniti
     */
    public boolean visibilityOfRecordsOnSearchCalls() throws Throwable {
        boolean isRecordFound = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");
        return isRecordFound;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSecondCallIDOnSearchCalls
     * Description: This function  is used to click On Second CallID On SearchCalls
     * Date:
     * author ::Cigniti
     */
    public void clickOnSecondCallIDOnSearchCalls()throws Throwable{
        boolean flagCallIdLink = isVisibleOnly(DISearchCallsPage.lnkSecondcallId,"Second callId In Search calls results");
        if (flagCallIdLink) {
            click(DISearchCallsPage.lnkSecondcallId,"Second callId In Search calls results");
        } else {
            assertTrue(flagCallIdLink, "No Calls avilable for CallID");
        }
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clearSelectCallStatus
     * Description: This function  is used to clear Select CallStatus On search calls Window
     * Date:
     * author ::Cigniti
     */
    public void clearCallStatus( ) throws Throwable {
        waitForVisibilityOfElement(DISearchCallsPage.selectCallStatus, "clear Call Status");
        clearData(DISearchCallsPage.selectCallStatus);
    }
    public void clickOnFourthCallIDOnSearchCalls()throws Throwable{
        boolean flagCallIdLink = isVisibleOnly(DISearchCallsPage.lnkFourthCallID,"Fourth callId In Search calls results");
        if (flagCallIdLink) {
            click(DISearchCallsPage.lnkFourthCallID,"Fourth callId In Search calls results");
        } else {
            assertTrue(flagCallIdLink, "No Calls avilable for CallID");
        }
    }
}


