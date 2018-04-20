package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.DIHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class CRSearchCallsLib extends ActionEngine {

    public List<WebElement> allCallIds;
    public List<WebElement> MemberLastName, allClubNumbers, allMemberNumber, allLocation, allCity, allVehicleYear, allVehicleMake, allVehicleModel, allRAP, memberPhoneNumber, allTruckID, allFacility;
    public String callIdFromList, MemberLastNameFromList, ClubNumbersFromList, MemberNumberFromList, allLocationFromList, allCityFromList, vehicleYearFromList, vehicleMakeFromList, vehicleModelFromList, RAPFromList, truckIDFromList, facilityFromList;
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
    public List<WebElement> allDates;

    Boolean callIDFlag, lastNameFlag, ClubNoFlag, MemberNumberFlag, locationFlag, CityFlag, vehicleYearFlag, vehicleMakeFlag, vehicleModelFlag, RAPFlag, memberPhoneFlag, truckIDFlag, FacilityFlag;

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterRAPNumberOnSearchCallsWindow
     * description :: This function is used to enter RPA number.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterRAPNumberOnSearchCallsWindow(String RAPNumber) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtRAPNumber, "RAPNumber on Search Calls Window");
        type(CRSearchCallsPage.txtRAPNumber, RAPNumber, "RAPNumber on Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFacilityOnSearchCallsWindow
     * description :: This function is used to enter Facility.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterFacilityOnSearchCallsWindow(String facility) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtFacility, "Facility Search Calls Window");
        type(CRSearchCallsPage.txtFacility, facility, "Facility Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTruckOnSearchCallsWindow
     * description :: This function is used to enter Truck.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterTruckOnSearchCallsWindow(String truck) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtTruck, "Truck on Search Calls Window");
        type(CRSearchCallsPage.txtTruck, truck, "Truck on Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTakerOnSearchCallsWindow
     * description :: This function is used to enter calltaker.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCallTakerOnSearchCallsWindow(String callTaker) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCallTaker, "Search Calls Window callTaker");
        type(CRSearchCallsPage.txtCallTaker, callTaker, "Search Calls Window callTaker");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDateOnSearchCallsWindow
     * description :: This function is used to enter startdate.
     * date :: 04-Jan-2018
     * author ::Abhiram
     */
    public String enterStartDateOnSearchCallsWindow(String StartDate) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtStartDateOnSearchCallWindow, "Start date search Calls Window");
        type(CRSearchCallsPage.txtStartDateOnSearchCallWindow, StartDate, "Start date on search Calls Window");
        return StartDate;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPhoneNumberOnSearchCallsWindow
     * description :: This function is used to enter phone number.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterPhoneNumberOnSearchCallsWindow(String phoneNumber) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtPhoneNumber, "Phone Number on Search Calls Window");
        type(CRSearchCallsPage.txtPhoneNumber, phoneNumber, "Phone Number on Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClubNumberOnSearchCallsWindow
     * description :: This function is used to enter club member.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterClubNumberOnSearchCallsWindow(String clubNumber) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtClubSearch, "ClubNumber on Search Calls Window.");
        type(CRSearchCallsPage.txtClubSearch, clubNumber, "ClubNumber on Search Calls Window.");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberLastNameSearchOnSearchCallsWindow
     * description :: This function is used to enter Member last name.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterMemberLastNameSearchOnSearchCallsWindow(String memberLastName) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberLastNameSearch, "Member Last Name Search Calls Window");
        type(CRSearchCallsPage.txtMemberLastNameSearch, memberLastName, "Member Last Name Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumberOnSearchCallsWindow
     * description :: This function is used to enter member number.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterMemberNumberOnSearchCallsWindow(String memberNumber) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberNumberSearch, "Member Number on Search Calls Window");
        type(CRSearchCallsPage.txtMemberNumberSearch, memberNumber, "Member Number on Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterYearVehicleInforationOnSearchCallsWindow
     * description :: This function is used to enter year of the vehicle.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterYearVehicleInforationOnSearchCallsWindow(String vehicleYear) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtYearVehicleInformation, "Vehicle Year on Search Calls Window");
        type(CRSearchCallsPage.txtYearVehicleInformation, vehicleYear, "Vehicle Year on Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMakeVehicleInforationOnSearchCallsWindow
     * description :: This function is used to enter Make of vehicle.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterMakeVehicleInforationOnSearchCallsWindow(String vehicleMake) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMakeVehicleInformation, "Vehicle Make on Search Calls Window");
        type(CRSearchCallsPage.txtMakeVehicleInformation, vehicleMake, "Vehicle Make on Search Calls Window");
        click(CRSearchCallsPage.txtCity, "city text box");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterModelVehicleInforationOnSearchCallsWindow
     * description :: This function is used to enter Model of the vehicle.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterModelVehicleInforationOnSearchCallsWindow(String vehicleModel) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtModelVehicleInformation, "Vehicle ModelSearch Calls Window");
        type(CRSearchCallsPage.txtModelVehicleInformation, vehicleModel, "Vehicle ModelSearch Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationOnSearchCallsWindow
     * description :: This function is used to enter location.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterLocationOnSearchCallsWindow(String location) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtLocation, "Location on Search Calls Window");
        type(CRSearchCallsPage.txtLocation, location, "Location on Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityOnSearchCallsWindow
     * description :: This function is used to enter City.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCityOnSearchCallsWindow(String city) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCity, "City Search Calls Window");
        type(CRSearchCallsPage.txtCity, city, "City Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallIdOnSearchCallsWindow
     * description :: This function is used to enter CallId.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCallIdOnSearchCallsWindow(String callid) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCallId, "Search Calls Window callid");
        type(CRSearchCallsPage.txtCallId, callid, "Search Calls Window callid");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartTimeOnSearchCallsWindow
     * description :: This function is used to enter Start time.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterStartTimeOnSearchCallsWindow(String startTime) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtStartTime, "Start Time Search Calls Window ");
        type(CRSearchCallsPage.txtStartTime, startTime, "Start Time Search Calls Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndTimeOnSearchCallsWindow
     * description :: This function is used to enter End  time.
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterEndTimeOnSearchCallsWindow(String endTime) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtEndTime, "End Time Search Calls Window");
        type(CRSearchCallsPage.txtEndTime, endTime, "End Time Search Calls Window");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCalls
     * description :: This function is used to click on search calls drop down and then click on search calls link which opens the search window.
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void clickOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        click(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        Thread.sleep(2000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCalls
     * description ::
     * date :: 01-Jan-2018
     * author ::Nidhi
     */
    public void clickOnSearchCallsAndSearchLink() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        if (isVisibleOnly(CRSearchCallsPage.linkSearchCalls, "Search Calls")) {
            click(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        } else {
            click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
            click(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearOnSearchCallsWindow
     * description :: This function is used to click on clear button.
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void clickOnClearOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnClear, "Clear");
        click(CRSearchCallsPage.btnClear, "Clear");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchBtnOnSearchCallsWindow
     * description :: This function is used to click on search button on search calls window.
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void clickOnSearchBtnOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnSearch, "Search Button");
        click(CRSearchCallsPage.btnSearch, "Search Button");
        Thread.sleep(10000);
        boolean searchResult = false;
        searchResult = isVisibleOnly(CRHomePage.memberDetailsOnSearchCalls, "Results found");
        assertTrue(searchResult, "Results Found After Search");
        Thread.sleep(2000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickSearchAgainOnSearchCalls
     * description :: This function is used to click on Search again button.
     * date :: 01-Jan-2018
     * author ::Cigniti
     */
    public void clickSearchAgainOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnSearchAgain, "Search Again Button");
        click(CRSearchCallsPage.btnSearchAgain, "Search Again Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallIDOnSearCallWindow
     * description :: This function validates the call ID is available in the search window list with the call id that we have sent as a parameter.
     * date :: 03-Jan-2018
     * Updated date :: 29-Jan-2018
     * author ::Abhiram/Varun
     */
    public void verifyCallIDOnSearCallWindow(String CallID) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Call ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allCallIds = getWebElementList(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");

            for (int i = 0; i < allCallIds.size(); i++) {
                callIdFromList = allCallIds.get(i).getText();
                String callIdFromExcel = CallID;
                if (callIdFromList.contains(callIdFromExcel)) {
                    callIDFlag = true;
                } else {
                    callIDFlag = false;
                    break;
                }
            }
            assertTrue(callIDFlag, "Call Id " + CallID + "Exists in Selected List");
        }
        Thread.sleep(4000);
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberLastNameOnSearCallWindow
     * description :: This function validates the member last name is available in the search window list with the member last name that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyMemberLastNameOnSearCallWindow(String MemberLastNameData) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Last Name in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            MemberLastName = getWebElementList(CRSearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Last Name in Search Call Window");

            for (int i = 0; i < MemberLastName.size(); i++) {
                MemberLastNameFromList = MemberLastName.get(i).getText();
                String LastnameFromExcel = MemberLastNameData;
                if (MemberLastNameFromList.contains(LastnameFromExcel)) {
                    lastNameFlag = true;
                } else {
                    lastNameFlag = false;
                    break;
                }
            }
            assertTrue(lastNameFlag, "Member Last Name " + MemberLastNameData + "Exists in Selected List");
        }
        Thread.sleep(4000);
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyClubNumberOnSearCallWindow
     * description :: This function validates the club number is available in the search window list with the club number that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyClubNumberOnSearCallWindow(String ClubNumber) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Club Number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allClubNumbers = getWebElementList(CRSearchCallsPage.ClubNumberOnSearchCallsInSearclCallWindow, "Club Number in Search Call Window");

            for (int i = 0; i < allClubNumbers.size(); i++) {
                ClubNumbersFromList = allClubNumbers.get(i).getText();
                String ClubNumberFromExcel = ClubNumber;
                if (ClubNumbersFromList.contains(ClubNumberFromExcel)) {
                    ClubNoFlag = true;

                } else {
                    ClubNoFlag = false;
                    break;

                }
            }
            assertTrue(ClubNoFlag, "Club Number " + ClubNumber + "Exists in Selected List");

        }
        Thread.sleep(4000);
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberNumberOnSearCallWindow
     * description :: This function validates the MemberNumber is available in the search window list with the MemberNumber that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyMemberNumberOnSearCallWindow(String MemberNumber) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Member Number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allMemberNumber = getWebElementList(CRSearchCallsPage.MemberNumberOnSearchCallsInSearclCallWindow, "Member Number in Search Call Window");

            for (int i = 0; i < allMemberNumber.size(); i++) {
                MemberNumberFromList = allMemberNumber.get(i).getText();
                String memberNumberFromExcel = MemberNumber;
                if (MemberNumberFromList.contains(memberNumberFromExcel)) {
                    MemberNumberFlag = true;
                } else {
                    MemberNumberFlag = false;
                    break;
                }
            }
            assertTrue(MemberNumberFlag, "Member Number " + MemberNumber + "Exists in Selected List");
        }
        Thread.sleep(4000);
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyLocationOnSearCallWindow
     * description :: This function validates the location is available in the search window list with the Location that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyLocationOnSearCallWindow(String BKDownStreetAddress) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Location in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allLocation = getWebElementList(CRSearchCallsPage.LocationOnSearchCallsInSearclCallWindow, "Location in Search Call Window");

            for (int i = 0; i < allLocation.size(); i++) {
                allLocationFromList = allLocation.get(i).getText();
                String allLocationFromListFromExcel = BKDownStreetAddress;
                if (allLocationFromList.contains(allLocationFromListFromExcel)) {
                    locationFlag = true;
                } else {
                    locationFlag = false;
                    break;
                }
            }
            assertTrue(locationFlag, "Location " + BKDownStreetAddress + "Exists in Selected List");

        }
        Thread.sleep(4000);

    }

    /**
     * param ::String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyCityOnSearCallWindow
     * description :: This function validates the City is available in the search window list with the City that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyCityOnSearCallWindow(String BKDownCityLocation) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "City in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allCity = getWebElementList(CRSearchCallsPage.CityOnSearchCallsInSearclCallWindow, "City in Search Call Window");

            for (int i = 0; i < allCity.size(); i++) {
                allCityFromList = allCity.get(i).getText();
                String cityFromExcel = BKDownCityLocation;
                if (allCityFromList.contains(cityFromExcel)) {
                    CityFlag = true;
                } else {
                    CityFlag = false;
                    break;
                }
            }
            assertTrue(CityFlag, "City " + BKDownCityLocation + "Exists in Selected List");

        }
        Thread.sleep(4000);
    }

    /**
     * param ::String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleYearOnSearCallWindow
     * description :: This function validates the Vehicle Year  is available in the search window list with the Vehicle Year that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehicleYearOnSearCallWindow(String VehicleYear) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Year in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search for year");
        } else {
            allVehicleYear = getWebElementList(CRSearchCallsPage.VehicleYearOnSearchCallsInSearclCallWindow, "Vehicle Year in Search Call Window");

            for (int i = 0; i < allVehicleYear.size(); i++) {
                vehicleYearFromList = allVehicleYear.get(i).getText();
                String vehicleYearFromExcel = VehicleYear;
                if (vehicleYearFromList.contains(vehicleYearFromExcel)) {
                    vehicleYearFlag = true;
                } else {
                    vehicleYearFlag = false;
                    break;
                }
            }
            assertTrue(vehicleYearFlag, "Vehicle Year " + VehicleYear + "Exists in Selected List");
        }
        Thread.sleep(4000);

    }

    /**
     * param ::String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleMakeOnSearCallWindow
     * description :: This function validates the Vehicle Make  is available in the search window list with the Vehicle Make that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehicleMakeOnSearCallWindow(String VehicleMake) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Make in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search for Make");
        } else {
            allVehicleMake = getWebElementList(CRSearchCallsPage.VehicleMakeOnSearchCallsInSearclCallWindow, "Vehicle Make in Search Call Window");

            for (int i = 0; i < allVehicleMake.size(); i++) {
                vehicleMakeFromList = allVehicleMake.get(i).getText();
                String vehicleMakeFromExcel = VehicleMake;
                if (vehicleMakeFromList.contains(vehicleMakeFromExcel)) {
                    vehicleMakeFlag = true;

                } else {
                    vehicleMakeFlag = false;
                    break;

                }
            }
            assertTrue(vehicleMakeFlag, "Vehicle Make " + VehicleMake + "Exists in Selected List");

        }
        Thread.sleep(4000);

    }

    /**
     * param ::String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleModelOnSearCallWindow
     * description :: This function validates the Vehicle Model  is available in the search window list with the Vehicle Model that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehicleModelOnSearCallWindow(String VehicleModel) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Model in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search for model");
        } else {
            allVehicleModel = getWebElementList(CRSearchCallsPage.VehicleModelOnSearchCallsInSearclCallWindow, "Vehicle Model in Search Call Window");

            for (int i = 0; i < allVehicleModel.size(); i++) {
                vehicleModelFromList = allVehicleModel.get(i).getText();
                String vehicleModelFromExcel = VehicleModel;
                if (vehicleModelFromList.contains(vehicleModelFromExcel)) {
                    vehicleModelFlag = true;

                } else {
                    vehicleModelFlag = false;
                    break;

                }
            }
            assertTrue(vehicleModelFlag, "Vehicle Model " + VehicleModel + "Exists in Selected List");

        }
        Thread.sleep(4000);
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyRAPOnSearCallWindow
     * description :: This function validates the RAP  is available in the search window list with the RAP that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyRAPOnSearCallWindow(String RAP) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "RAP in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allRAP = getWebElementList(CRSearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAP in Search Call Window");

            for (int i = 0; i < allRAP.size(); i++) {
                RAPFromList = allRAP.get(i).getText();
                String RAPFromExcel = RAP;
                if (RAPFromList.contains(RAPFromExcel)) {
                    RAPFlag = true;
                } else {
                    RAPFlag = false;
                    break;
                }
            }
            assertTrue(RAPFlag, "RAP " + RAP + "Exists in Selected List");
        }
        Thread.sleep(4000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickCallIDLinkOnSearchCallsWindow
     * description :: This function clicks the call id link.
     * date :: 04-jan-2017
     * author ::Abhiram
     */
    public void clickCallIDLinkOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.linkCallDateOnSearchCallsInSearclCallWindow, "Call ID link");
        click(CRSearchCallsPage.linkCallDateOnSearchCallsInSearclCallWindow, "Call ID link");
    }


    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndVerifyPhoneNumberOnMembersPage
     * description :: This function validates the phone numbers  is available in the search window list with the phone number that we have sent as a parameter.
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void verifyPhoneNumberOnMembersPage(Hashtable<String, String> data) throws Throwable {

        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Phone number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            memberPhoneNumber = getWebElementList(CRSearchCallsPage.phoneNumbersListOnSearchCallsInSearclCallWindow, "Phone number in Search Call Window");

            for (int i = 0; i < memberPhoneNumber.size(); i++) {
                String PhoneNumberFromList = memberPhoneNumber.get(i).getAttribute("value");
                String abc1 = PhoneNumberFromList.substring(1, 4);
                String abc2 = PhoneNumberFromList.substring(6, 8);
                String abc3 = PhoneNumberFromList.substring(10, 13);
                String memberPhone = abc1 + abc2 + abc3;
                String PhoneNumberFromExcel = data.get("PhoneNumber");
                if (memberPhone.contains(PhoneNumberFromExcel)) {
                    memberPhoneFlag = true;
                } else {
                    memberPhoneFlag = false;
                    break;
                }
            }
            assertTrue(memberPhoneFlag, "Phone Number " + data.get("PhoneNumber") + "Exists in Selected List");

        }
        Thread.sleep(4000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndclickCallSummaryIconOnMemberspage
     * description :: This function is used to click on Call Summary Icon on Home page.
     * date :: 04-jan-2017
     * author ::Abhiram
     */
    public void verifyAndclickCallSummaryIconOnMemberspage(String PhoneNumber) throws Throwable {

        waitForVisibilityOfElement(CRSearchCallsPage.linkCallSummaryIconOnMemberspage, "Call Summary icon");

        click(CRSearchCallsPage.linkCallSummaryIconOnMemberspage, "Call Summary icon");
        waitForVisibilityOfElement(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Summary Pop Up");
        Thread.sleep(3000);
        String phoneString1 = getText(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(8, 11);
        String phoneString2 = getText(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(13, 16);
        String phoneString3 = getText(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(17, 21);

        String phone = phoneString1 + phoneString2 + phoneString3;

        String callIdFromExcel = PhoneNumber;
        assertTrue(phone.equalsIgnoreCase(callIdFromExcel), "Phone Number is matching");
        /*if (phoneNumber.equalsIgnoreCase(callIdFromExcel)) {
            assertTrue(true,"Phone Number is matching");
        }
        else {
            assertFalse(false,"Phone Number is not matching");
        }*/
        Thread.sleep(2000);
    }

    /**
     * param ::String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckIDOnSearCallWindow
     * description :: This function validates the TruckID  is available in the search window list with the TruckID that we have sent as a parameter.
     * date :: 04-Jan-2018
     * author ::Abhiram
     */
    public void verifyTruckIDOnSearCallWindow(String TruckID) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allTruckID = getWebElementList(CRSearchCallsPage.TruckIDDetailsOnSearchCallsInSearclCallWindow, "Truck ID in Search Call Window");

            for (int i = 0; i < allTruckID.size(); i++) {
                truckIDFromList = allTruckID.get(i).getText();
                String truckIDFromExcel = TruckID;
                if (truckIDFromList.contains(truckIDFromExcel)) {
                    truckIDFlag = true;
                } else {
                    truckIDFlag = false;
                    break;
                }
            }
            assertTrue(truckIDFlag, "Truck ID " + TruckID + "Exists in Selected List");
        }
        Thread.sleep(4000);
    }


    /**
     * param ::String Input
     * return ::void
     * throws :: throwable
     * methodName :: verifyFacilityOnSearCallWindow
     * description ::
     * date :: 04-Jan-2018
     * author ::Abhiram
     */
    public void verifyFacilityOnSearCallWindow(String facility) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Facility in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            allFacility = getWebElementList(CRSearchCallsPage.FacilityDetailsOnSearchCallsInSearclCallWindow, "Facility in Search Call Window");

            for (int i = 0; i < allFacility.size(); i++) {
                facilityFromList = allFacility.get(i).getText();
                String facilityFromExcel = facility;
                if (facilityFromList.contains(facilityFromExcel)) {
                    FacilityFlag = true;

                } else {
                    FacilityFlag = false;
                    break;

                }
            }
            assertTrue(FacilityFlag, "Facility " + facility + "Exists in Selected List");

        }
        Thread.sleep(4000);
    }

    /**
     * param ::String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndGetDateFromMemberPageandChangeFormat
     * description :: Function gets the data from page and chnage the format.
     * retrivedTime :: 03-Jan-2018
     * author ::Abhiram
     */

    public void verifyAndGetDateFromMemberPageandChangeFormat(String startTime, String EndTime) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Click On Call ID");
        click(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Click On Call ID");
        Thread.sleep(5000);
        waitForVisibilityOfElement(CRSearchCallsPage.lblDateInMemberPage, "Getting Date From Member Tab");
        String dateDetails = getText(CRSearchCallsPage.lblDateInMemberPage, "Getting Date From Member Tab");
        String splitStr[] = dateDetails.split(",");
        String dateSplitted = splitStr[1];
        displayFormat = new SimpleDateFormat("HH:mm");
        parseFormat = new SimpleDateFormat("hh:mm a");
        date = parseFormat.parse(splitStr[1]);

        time = displayFormat.format(date);
        String splittime[] = time.split(":");
        String callTimeSplittedInHours = splittime[0];
        String callTimeSplittedInMinutes = splittime[1];
        callTimeInHours = Integer.parseInt(callTimeSplittedInHours);
        callTimeInMinutes = Integer.parseInt(callTimeSplittedInMinutes);

        startTimeInSearch = startTime;
        String splitstartTimeInSearch[] = startTimeInSearch.split(":");
        String startTimeSplittedInHours = splitstartTimeInSearch[0];
        String startTimeSplittedInMinute = splitstartTimeInSearch[1];
        startTimeInHours = Integer.parseInt(startTimeSplittedInHours);
        startTimeInMinutes = Integer.parseInt(startTimeSplittedInMinute);

        endTimeInSearch = EndTime;
        String splitEndTimeInExcel[] = endTimeInSearch.split(":");
        String endTimeSplittedInHours = splitEndTimeInExcel[0];
        String endTimeSplittedInMinutes = splitEndTimeInExcel[1];
        endTimeInHours = Integer.parseInt(endTimeSplittedInHours);
        endTimeInMinutes = Integer.parseInt(endTimeSplittedInMinutes);

        assertTrue((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours), "The Call Time:: " + time + " is between:: " + startTimeInSearch + " start and End Time:: " + endTimeInSearch);
        /*if(callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours){
            //if(timeInIntInMinute>stimeInIntInminute && timeInIntInMinute<etimeInIntInMinute){
            assertTrue(true,"The Call Time:: "+time +" is between:: "+startTimeInSearch+" start and End Time:: "+endTimeInSearch);
        }else{
            assertFalse(false,"The Call Time "+time +" is not between "+startTimeInSearch+" start and End Time"+endTimeInSearch);
        }*/
        Thread.sleep(2000);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getStartDateSearchDetails
     * description :: Get start date from search calls page.
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     */
    public String getStartDateSearchDetails() throws Throwable {
        startDateInSearchDetails = getAttributeByValue(CRSearchCallsPage.txtStartDateInSearchCall, "Start date in Search Calls");
        return startDateInSearchDetails;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdAndDate
     * description :: This function gets callid and date from search calls list.
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     */
    public String getCallIdAndDate() throws Throwable {
        boolean visibilityOfCallIdAndDate = isVisibleOnly(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, " Call Id and Date is avaiable");
        assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
        String startDate = getText(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call Id and Date");
        return startDate;
    }

    /**
     * methodName :: convertDateFormatToAnotherDateFormat, Function to convert one date format to another date format.
     *
     * @param actualDate        of (String), Actual date (e.g: Dec 5, 2017)
     * @param sourceFormat      of (String), format of actualDate (e.g: MM dd, yyyy)
     * @param destinationFormat of (String), Format what we required (e.g: dd/MM/yyyy)
     * @return : String
     * throws :: throwable
     * description :: This function converts a date format to another date format.
     * retrivedTime ::
     * author ::Cigniti
     */
    protected String convertDateFormatToAnotherDateFormat(String actualDate, String sourceFormat, String destinationFormat) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sourceFormat);
        SimpleDateFormat sdf = new SimpleDateFormat(destinationFormat);
        Date date = simpleDateFormat.parse(actualDate);
        return sdf.format(date);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyStartAndEndDateOnSearchCallWindow
     * description :: This function validates start date is same as end date.
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     */

    public void verifyStartAndEndDateOnSearchCallWindow(String expectedStartDate) throws Throwable {
        String date2 = getCallIdAndDate();
        String splitStr[] = date2.split("\n");
        String startDateValue = splitStr[0];
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date d_date = dateFormat.parse(startDateValue);
        String strDate = dateFormat.format(d_date);
        assertTrue(true, strDate + "Date");
        boolean dateComparision = strDate.equalsIgnoreCase(expectedStartDate);
        assertTrue(dateComparision, "Start date:: " + strDate + " is same as expected:: " + expectedStartDate);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: convertDate
     * description :: This function converts given date to date format MM/dd/YYYY.
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     */

    public void convertDate() throws Throwable {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date d_date = dateFormat.parse(startDateValue);

        String strDate = dateFormat.format(d_date);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberFirstNameAndLastNameOnSearchCallsWindow
     * description :: This function enters First Name and Last Name
     * date :: 11-jan-2017
     * author :: Ravi
     */
    public void enterMemberFirstNameAndLastNameOnSearchCallsWindow(String MemberFirstName, String memberLastName) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberLastNameSearch, "Search Calls Window memberLastName");
        type(CRSearchCallsPage.txtMemberFirstNameSearch, MemberFirstName, "Search Calls Window member first Name");
        firstNameInSearch = getText(CRSearchCallsPage.txtMemberFirstNameSearch, "Search Calls Window memberLastName");
        type(CRSearchCallsPage.txtMemberLastNameSearch, memberLastName, "Search Calls Window memberLastName");
        lastNameInSearch = getText(CRSearchCallsPage.txtMemberLastNameSearch, "Search Calls Window memberLastName");
    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectMemberLastNameOnSearCallWindow
     * description :: This functions searches and selects the first name and last name in search calls window.
     * date :: 11-Jan-2018
     * author ::Ravi
     */
    public void searchAndSelectMemberFirstandLastNameOnSearCallWindow(Hashtable<String, String> data) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Member Last Name in Search Call Window");
        MemberLastName = getWebElementList(CRSearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Member Last Name in Search Call Window");
        boolean verification = true;

        boolean membersFirstName = true;
        boolean membersLstNaame = true;
        if (MemberLastName != null) {
            for (int i = 1; i < MemberLastName.size(); i++) {
                String MemberLastNameList = getText(CRSearchCallsPage.getFirstNameAndLastName(i), "Member Name");
                membersFirstName = MemberLastNameList.contains(data.get("MemberFirstName"));
                membersLstNaame = MemberLastNameList.contains(data.get("MemberLastName"));
                if (!membersFirstName && membersLstNaame)
                    verification = false;
                break;
            }
            assertTrue(verification, "verified first name and Last Name");
            Thread.sleep(2000);
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndDateOnSearchCallsWindow
     * description :: This function is used to enter end date in search call window.
     * date :: 11-Jan-2018
     * author ::Ravi
     */
    public String enterEndDateOnSearchCallsWindow(String EndDate) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtEndDateInSearchCall, "Search Calls Window End date");
        type(CRSearchCallsPage.txtEndDateInSearchCall, EndDate, "Search Calls Window End date");
        return EndDate;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommCenterOnSearchCallsWindow
     * description :: This function is used to enter comm center in search calls window.
     * date :: 11-Jan-2017
     * author ::Ravi
     */
    public String enterCommCenterOnSearchCallsWindow(String commCenter) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCommCenter, "Search Calls Window callTaker");
        type(CRSearchCallsPage.txtCommCenter, commCenter, "Search Calls Window callTaker");
        return commCenter;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstRowInSearchCalls
     * description ::click On First Row In Search Calls
     * date :: 11-Jan-2017
     * author ::Ravi
     */
    public void clickOnFirstRowInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.searchResultFound, "First Row Search Calls Window");
        click(CRSearchCallsPage.searchResultFound, "First Row Search Calls Window");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnOkOnInvalidErrorPopup
     * description ::gets the text of invalid error and clicks on ok
     * date :: 12-Jan-2017
     * author ::Ravi
     */
    public String verifyInvalidSearchCriteriaForInvalidDate() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.invalidSearchCriteriaError, "Invalid search criteria Error popup");
       String invalidDate= getText(CRSearchCallsPage.invalidSearchCriteriaError, "Invalid search criteria Error popup");
        return invalidDate;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstRowInSearchCall
     * description ::clicks On FirstRow In SearchCall
     * date :: 12-Jan-2017
     * author ::Ravi
     */
    public void clickOnFirstRowInSearchCall() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.searchResultFound, "Invalid search criteria Error popup");
        click(CRSearchCallsPage.searchResultFound, "Invalid search criteria Error popup");
        Thread.sleep(2000);
    }


    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectDatesOnSearCallWindow
     * description :: This function is used to search for searching and selecting the dates passed as a parameter.
     * date :: 12-Jan-2018
     * author ::Ravi
     */
    public void searchAndSelectDatesOnSearCallWindow(Hashtable<String, String> data) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dateInSearchCallsInSearclCallWindow, "Date in Search Call Window");
        allDates = getWebElementList(CRSearchCallsPage.dateInSearchCallsInSearclCallWindow, "Date in Search Call Window");
        if (allDates != null) {
            for (int i = 0; i < allDates.size(); i++) {
                String dateFromList = allDates.get(i).getText();
                String endDateArchiveFromExcel = data.get("EndDateArchive");
                /* if (dateFromList.contains(endDateArchiveFromExcel)) {
                    assertTrue(true,"Date Exists in Selected List");
                }
                else {
                    assertFalse(false,"Date Not Exists in selected List");
                }*/
                assertTrue(dateFromList.contains(endDateArchiveFromExcel), "Date Exists in Selected List");

                // assertTrue(dateFromList.contains(endDateArchiveFromExcel),"Date Exists in Selected List");
            }
        }
        Thread.sleep(2000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfNoMatchingRecords
     * description ::getText Of No Matching Records
     * date :: 12-Jan-2017
     * author ::Ravi
     */
    public String getTextOfNoMatchingRecords() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtNoMatchingRecords, "No matching records found");
       String noRecords= getText(CRSearchCallsPage.txtNoMatchingRecords, "No matching records found");
        return noRecords;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveOnly
     * description ::
     * date :: 12-jan-2017
     * author ::Ravi
     */
    public void enterCallTypeAsLiveOnly(String LiveOnly) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.selectCallsType, "select Calls as live calls");
        type(CRSearchCallsPage.selectCallsType, LiveOnly, "Search Calls live calls");
        Thread.sleep(2000);
        getText(CRSearchCallsPage.selectCallsType, "Search Calls live calls");
        Thread.sleep(1000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveAndArchived
     * description ::
     * date :: 12-jan-2017
     * author ::Ravi
     */
    public void enterCallTypeAsLiveAndArchived(String LiveAndArchived) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.selectCallsType, "select Calls as live calls");
        type(CRSearchCallsPage.selectCallsType, LiveAndArchived, "Search Calls live calls");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfCallType
     * description ::
     * date :: 12-jan-2017
     * author ::Ravi
     */
    public void getTextOfCallType() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.selectCallsType, "select Calls as live and archived");
        getText(CRSearchCallsPage.selectCallsType, "Search Calls live and archived");
        Thread.sleep(1000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnOkOnInvalidErrorPopupLiveOnly
     * description ::gets the text of invalid error on liveonly and clicks on ok
     * date :: 16-Jan-2017
     * author ::Ravi
     */
    public void getTextAndClickOnOkOnInvalidErrorPopupLiveOnly() throws Throwable {
        getText(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveOnly, "Invalid search criteria Error popup on live only");
        click(CRSearchCallsPage.okOnInvalidError, "Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnOkOnInvalidErrorPopupLiveAndArchived
     * description ::gets the text of invalid error on live and archived and clicks on ok
     * date :: 16-Jan-2017
     * author ::Ravi
     */
    public void getTextAndClickOnOkOnInvalidErrorPopupLiveAndArchived() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveAndArchive, "Invalid search criteria Error popup on live and archived");
        getText(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveAndArchive, "Invalid search criteria Error popup on live and archived");
        Thread.sleep(2000);
        click(CRSearchCallsPage.okOnInvalidError, "Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallsTypeInSearchCalls
     * description ::enter calls type in search calls window
     * date :: 16-Jan-2017
     * author ::Varun
     */
    public void enterCallsTypeInSearchCalls(String callType) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCallsInSearchCalls, "Calls type");
        //type(CRSearchCallsPage.txtCallsInSearchCalls, callType, "Calls type");
        click(CRSearchCallsPage.callSearchTypeDropdonArrow, "Call Type dropdown");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.ARROW_DOWN);
        sendKeys(combineKeys3, "DownKey");
        String combineKeys4 = Keys.chord(Keys.ENTER);
        sendKeys(combineKeys4, "EnterKey");

    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdOnSearCallWindow
     * description :: This function returns the call id from search calls window list.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public String getCallIdOnSearCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");
        allCallIds = getWebElementList(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");
        String callIdFromList = allCallIds.get(0).getText();
        System.out.println("call id is" + callIdFromList);
        String abc1 = callIdFromList.substring(callIdFromList.lastIndexOf("#") + 1);
        Thread.sleep(2000);
        return abc1;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateIconOnSearCallWindow
     * description :: This function is used to click on Duplicate Icon on Search call window.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickCallIDwithoutRAPSearCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.duplicateCallsIconInSearchCallWindow, "CallID");
        click(CRSearchCallsPage.duplicateCallsIconInSearchCallWindow, "CallID");
        Thread.sleep(4000);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdFromMemberTab
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public String getCallIdFromMemberTab() throws Throwable {
        String callIdFromMemberTab = getText(CRMemberSearchPage.lblMemberCallId, "Get text for Call ID and member name on Member Tab");
        System.out.println("call id is" + callIdFromMemberTab);
        Thread.sleep(2000);
        return callIdFromMemberTab;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCurrentCallsDropDown
     * description ::This method is used to click on current calls dropdown
     * date :: 17-Jan-2018
     * author :: cigniti
     */

    public void clickOnCurrentCallsDropDown() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.drpdwnCurrentCall, "Current Calls Menu");
        click(CRSearchCallsPage.drpdwnCurrentCall, "Current Calls Menu");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCurrentCallsDropDown
     * description ::This method is used to click on Send ETA Request under Current calls dropdown
     * date :: 17-Jan-2018
     * author :: cigniti
     */
    public void clickOnSendETARequestLink() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkSendETARequest, "Send ETA Request");
        click(CRSearchCallsPage.lnkSendETARequest, "Send ETA Request");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRecentCallsInSearchCalls
     * description :: This function is used to click on Recent Calls Link in Search Calls Drop Down
     * date :: 17-Jan-2018
     * author ::Sachin
     */
    public void clickOnRecentCallsInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRSearchCallsPage.linkRecentCalls, "Recent Calls");
        click(CRSearchCallsPage.linkRecentCalls, "Search Calls");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdAndDateFromRecentCalls
     * description :: This function is used to get the Call Id and Date from Recent calls window
     * retrivedTime :: 017-Jan-2018
     * author ::Sachin
     */
    public String getCallIdAndDateFromRecentCalls() throws Throwable {
        boolean visibilityOfCallIdAndDate = isVisibleOnly(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, " Call Id and Date is avaiable");
        String startDate = getText(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, "Call Id and Date is avaiable");
        assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
        return startDate;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnCallIdOnRecentCallsWindow
     * description :: This function is used to click on CallID in recent calls window.
     * retrivedTime :: 17-Jan-2018
     * author ::Sachin
     */
    public void ClickOnCallIdOnRecentCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, "Call Id and Date");
        click(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, "Call Id and Date");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateCallIDConfYes
     * description :: This function is used to click on Yes button on Confirmation Pop Up Window.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateCallIDConfYes() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnDuplicateYes, "Message prompted to duplicate the current call");
        click(CRSearchCallsPage.btnDuplicateYes, "Yes");
        Thread.sleep(6000);


    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateCallIDConfNo
     * description :: This function is used to click on No button on Confirmation Pop Up Window.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateCallIDConfNo() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnDuplicateNo, "Message prompted to duplicate the current call");
        click(CRSearchCallsPage.btnDuplicateNo, "No");
        Thread.sleep(4000);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickCloseBtnOnSearchCallwindow
     * description :: This function is used to click on Close button on Search Calls window.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickCloseBtnOnSearchCallwindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnCloseSearchCalWindow, "Close");
        click(CRSearchCallsPage.btnCloseSearchCalWindow, "Close");
        Thread.sleep(4000);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRecentCallsOnSearchCalls
     * description :: This function is used to click on Recent Calls Link in Search Calls Drop Down
     * date :: 17-Jan-2018
     * author ::Varun
     */
    public void clickOnRecentCallsOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRSearchCallsPage.linkRecentCalls, "Recent Calls");
        click(CRSearchCallsPage.linkRecentCalls, "Recent Calls");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdOnRecentCallWindow
     * description :: This function is used to get Call ID on Recent Calls Window.
     * date :: 17-Jan-2018
     * author ::Varun
     */
    public String getCallIdOnRecentCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.callIDDetailsOnRecentCallsInSearclCallWindow, "Call ID in Search Call Window");
        allCallIds = getWebElementList(CRSearchCallsPage.callIDDetailsOnRecentCallsInSearclCallWindow, "Call ID in Search Call Window");
        String callIdFromList = allCallIds.get(0).getText();
        System.out.println("call id is" + callIdFromList);
        String abc1 = callIdFromList.substring(callIdFromList.lastIndexOf("#") + 1);
        Thread.sleep(2000);
        return abc1;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateIconOnRecentCallWindow
     * description :: This function is used to click on Duplicate Icon on Recent call window.
     * date :: 17-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateIconOnRecentCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.duplicateCallsOnRecentCallsInSearclCallWindow, "Duplicate Icon");
        click(CRSearchCallsPage.duplicateCallsOnRecentCallsInSearclCallWindow, "Duplicate icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButton
     * description :: This function is used to click on Close window in search calls window.
     * date :: 17-Jan-2018
     * author ::Ravi
     */
    public void clickOnCloseButton() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnCloseSearchCall, "Duplicate Icon");
        click(CRSearchCallsPage.btnCloseSearchCall, "Duplicate icon");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButton
     * description :: This method is used to click on the call ID&Date on search call window.
     * date :: 18-01-2018
     * author ::madhuakar
     */
    public void clickOnCallIdDateOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkCallIDOnSearchCalls, "Call ID And Date Link");
        click(CRSearchCallsPage.lnkCallIDOnSearchCalls, "Call ID And Date Link");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnCallIdOnSearchCallsWindow
     * description :: This function is used to click on Call ID on search window.
     * retrivedTime :: 18-Jan-2018
     * author ::Sachin
     */
    public void ClickOnCallIdOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id");
        click(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextNoMatchingRecords
     * description ::
     * date :: 16-Jan-2017
     * author ::Ravi
     */
    public void getTextNoMatchingRecords() throws Throwable {
        getText(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveOnly, "Invalid search criteria Error popup on live only");
        click(CRSearchCallsPage.okOnInvalidError, "Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdInSearchCall
     * description ::getCallIdInSearchCall
     * date :: 31-Jan-2017
     * author ::Ravi
     */
    public String getCallIdInSearchCall() throws Throwable {
        getText(CRSearchCallsPage.lblDateInMemberPage, "call id and time");
        String callIdAndDate = getText(CRSearchCallsPage.lblDateInMemberPage, "Getting Date From Member Tab");
        String splitStr[] = callIdAndDate.split("-");
        String callIdAndDateSplit[] = splitStr[1].split(",");
        return callIdAndDateSplit[0].trim();
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStatusOnSearchCallsWindow
     * description :: This function is used to enter Status on search calls window.
     * date :: 06-Feb-2017
     * author ::Varun
     */
    public void enterStatusOnSearchCallsWindow(String Status) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtCallStatus, "Search Calls Window RAPNumber");
        type(CRHomePage.txtCallStatus, Status, "Search Calls Window RAPNumber");
    }

    public void clickonSearchinSearchCalls() throws Throwable {
        if (isVisibleOnly(CRSearchCallsPage.searchButtoninSearch, "Search Button in Search Window")) {
            click(CRSearchCallsPage.searchButtoninSearch, "Search Button in Search Window");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallIDLink
     * description :: To Click on CallIDOrDate Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnCallIDLink() throws Throwable {
        boolean flagCallIdLink = isElementPresent(CRSearchCallsPage.clickOnCallIdLink, "Click On CallIdOrDate Link");
        if (flagCallIdLink) {
            waitForVisibilityOfElement(CRSearchCallsPage.clickOnCallIdLink, "Click On CallIdOrDate Link");
            click(CRSearchCallsPage.clickOnCallIdLink, "Click On CallIdOrDate Link");
        } else {
            assertTrue(flagCallIdLink, "No Calls avilable for CallID");
        }
    }

    public int getCallIdListFromSearchCallsPage() throws Throwable {
        int callIdsInList = 0;
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Call ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults, "No Record found after search");
        } else {
            List<WebElement> callIdsList = getWebElementList(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");
            callIdsInList = callIdsList.size();

        }
        return callIdsInList;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTimeInSearchCall
     * description :: To get Time from call search on member search page
     * date :: 14-03-2018
     * author :: Madhukar
     */
    public String getTimeInSearchCall() throws Throwable {
        getText(CRSearchCallsPage.lblDateInMemberPage, "call id and time");
        String callIdAndDate = getText(CRSearchCallsPage.lblDateInMemberPage, "Getting Date From Member Tab");
        String splitStr[] = callIdAndDate.split(",");
        String time = splitStr[1];
        String splitTime[] = time.trim().split(" ");
        return splitTime[0];
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateIconForRAPCallOnSearCallWindow
     * description :: This function is used to click on Duplicate Icon for RAP call on Search call window.
     * date :: 15-Mar-2018
     * author ::Varun
     */
    public void clickDuplicateIconForRAPCallOnSearCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.duplicateCallsIconRAPCallInSearchCallWindow, "Duplicate Icon");
        click(CRSearchCallsPage.duplicateCallsIconRAPCallInSearchCallWindow, "Duplicate icon");
        Thread.sleep(4000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateCallIDConfYes
     * description :: This function is used to click on Yes button on Confirmation Pop Up Window.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public String clickDuplicateCallIDConfYesForFacilityDuplicate() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnDuplicateYes, "Message prompted to duplicate the current call");
        click(CRSearchCallsPage.btnDuplicateYes, "Yes");
        Thread.sleep(1000);
        String facility_label = getfacilityTextFromTopLable();
        Thread.sleep(6000);
        return facility_label;

    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getfacilityTextFromTopLable
     * description ::get facility Text From Top bar
     * date :: 16-March-2018
     * author :: Varun
     */
    public String getfacilityTextFromTopLable() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.lblFacilityOnTopBar, "facility label");
        String facility_label = getText(CRHomePage.lblFacilityOnTopBar, "facility label");
        return facility_label;
    }

    /**
     * param :: NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyCallDuplicateMsgPopWindow
     * description :: This function is used to verify the duplicate callID msg pop up.
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public Boolean verifyCallDuplicateMsgPopWindow() throws Throwable {
        Boolean DuplicateMsgPopUp = isVisibleOnly(CRSearchCallsPage.btnDuplicateNo, "Pop up message to duplicate the call");
        return DuplicateMsgPopUp;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateIconOnSearchResultWindow
     * description :: This function is used to click on Duplicate Icon on Search call window.
     * date :: 23-Mar-2018
     * author ::Varun
     */
    public void clickDuplicateIconOnSearchResultWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.duplicateCallsIconInSearchCallResultWindow, "CallID duplicate icon");
        click(CRSearchCallsPage.duplicateCallsIconInSearchCallResultWindow, "CallID duplicate icon");
        Thread.sleep(4000);
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFirstCallIdAndDateInSearchCallsTable
     * Description: This function  is used to get on first callid/Date on search calls table.
     * Date:26-03-2018
     * author ::Madhukar
     */
    public String getFirstCallIdAndDateInSearchCallsTable() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callIdAndDate = getText(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "CallId And Date From search Results:");
        return callIdAndDate;
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getDateFromFirstRecordInInSearchCallsTable
     * Description: This function  is used to get first callDate on search calls table.
     * Date:26-03-2018
     * author ::Madhukar
     */
    public String getDateFromFirstRecordInInSearchCallsTable() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callIdAndDate = getText(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "CallId And Date From search Results:");
        String splitIdandDate[]= callIdAndDate.split("#");
        String date=splitIdandDate[0];
        return date.trim();
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstCallIdInSearchCallsTable
     * Description: This method is used to select an first  callId from search call table
     * Date:26-03-2018
     * author ::Madhukar
     */

    public void clickOnFirstCallIdInSearchCallsTable() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "CallIdAndDate");
        click(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "CallIdAndDate");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getValidArchivedCall
     * Description: This method is used to get a callid from a search results
     * Date:26-03-2018
     * author ::Madhukar
     */

    public String getValidArchivedCallId() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callIDAndDate = getText(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        String callid = callIDAndDate.substring(11, 16);
        return callid;
    }
    /**
     * param :: String Input
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyFirstNameLastNameInArchivedCall
     * Description: This method is used to verify FirstName and LastName  from a search criteria
     * Date: 26-03-2018
     * author ::Cigniti
     */

    public boolean verifyFirstNameLastNameInArchivedCall(String firstNameLastName) throws Throwable {
        boolean firstAndLast = false;
        waitForVisibilityOfElement(CRSearchCallsPage.lblMemberAndClubCodeOnSearchCallsTable, "MemberName MemberNumber And ClubCode");
        String memberNameMemberNumberAndClubCode = getText(CRSearchCallsPage.lblMemberAndClubCodeOnSearchCallsTable, "MemberName MemberNumber And ClubCode");
        if (memberNameMemberNumberAndClubCode.contains(firstNameLastName)) {
            firstAndLast = true;
        } else {
            firstAndLast = false;
        }
        return firstAndLast;
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallType
     * description ::This method is used to click on CallType Dropdown and select LIVE ONLY and LIVE AND ARCHIVED type
     * date ::26-03-2018
     * author ::Cigniti
     */

    public void enterCallType(String calltype) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.drpdwnCallType, "Call Type Dropdown");
        click(CRSearchCallsPage.drpdwnCallType, "Call Type Dropdown");
        click(CRSearchCallsPage.selectCallType(calltype), "select" + calltype + "call type");
    }

    /**
     * param :: String Input
     * return ::String
     * throws :: throwable
     * methodName :: verifyNoRecordFoundForSearchResults
     * Description: This method is used to verify no record found for a search criteria
     * Date: 26-03-2018
     * author ::Madhukar
     */
    public String verifyNoRecordFoundForSearchResults() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");
        String noRecordFound = getText(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");
        return noRecordFound;
    }

    /**
     * param ::
     * methodName :: verifySearchResultsInArchivedCalls
     * description :: To verify search results shown in archived table
     * @return boolean
     * @throws Throwable
     * @author Madhukar
     * Date:26-03-2018
     */
    public boolean verifySearchResultsInArchivedCalls() throws Throwable {
        boolean callIDAndDate=waitForVisibilityOfElement(CRSearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
        return callIDAndDate;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchBtnOnSearchCallsWindow
     * description :: This function is used to click on search button on search calls window.
     * date :: 27-Mar-2018
     * author ::Madhukar
     */
    public void clickOnSearchButtonOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnSearch, "Search Button");
        click(CRSearchCallsPage.btnSearch, "Search Button");
    }



}
