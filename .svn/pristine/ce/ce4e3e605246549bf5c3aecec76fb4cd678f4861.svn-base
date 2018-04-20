package com.aaa.rspweb.lib;

import com.aaa.mobile.page.HomePage;
import com.aaa.rspweb.pages.RSPClubSettingsPage;
import com.aaa.rspweb.pages.RSPHomePage;
import com.aaa.rspweb.pages.RSPLoginPage;
import com.aaa.rspweb.pages.RSPShopSettingsPage;
import com.aaa.web.page.LoginRolePage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RSPHomeLib extends RSPCommonLib {

    private static final String ShopSettings = null;

	/**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: alertStatusReminder
     * description :: verify status reminder is visible or not
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean alertStatusReminder() throws Throwable {
        boolean flag = false;
        dynamicWaitByLocator(RSPHomePage.tabStatusReminder,30);
        flag = isVisibleOnly(RSPHomePage.tabStatusReminder, "Status reminder is visible");
        return flag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkNoNotAtThisTime
     * description :: To click on no not at this time
     * date :: 03/04/2018
     * author :: Jagadish Pola
     */

    public void clickOnLinkNoNotAtThisTime() throws Throwable {
            dynamicWaitByLocator(RSPHomePage.lnkNoNotAtThisTime, 60);
            click(RSPHomePage.lnkNoNotAtThisTime, "No not at this time");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndclickOnLinkNoNotAtThisTime
     * description :: verifies alert status reminder is visible or not and clicks on no not at this time
     * date :: 03/04/2018
     * author :: Jagadish Pola
     */

    public void verifyAndClickOnLinkNoNotAtThisTime() throws Throwable {
        if (alertStatusReminder()) {
            clickOnLinkNoNotAtThisTime();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkYesSetMyStatusToPriorityService
     * description :: To click on no not at this time
     * date :: 03/04/2018
     * author :: Jagadish Pola
     */

    public void clickOnLinkYesSetMyStatusToPriorityService() throws Throwable {
            dynamicWaitByLocator(RSPHomePage.btnYesSetMyStatusToPriorityService, 60);
            click(RSPHomePage.btnYesSetMyStatusToPriorityService, "Yes set status to priority");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndclickOnLinkYesSetMyStatusToPriorityService
     * description :: verifies alert status reminder is visible or not and clicks on Yes set my status to priority
     * date :: 03/04/2018
     * author :: Jagadish Pola
     */

    public void verifyAndClickOnLinkYesSetMyStatusToPriorityService() throws Throwable {
        if (alertStatusReminder()) {
            clickOnLinkYesSetMyStatusToPriorityService();
        }
    }

    /**
     * param ::
     * return ::List
     * throws :: throwable
     * methodName :: getTableHeaderInRSPHome
     * description :: To get all the table headers available with out null and empty values
     * date :: 
     * author :: Jagadish Pola
     */


    //Headers
    public List getTableHeaderInRSPHome() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.tableHeader,60);
        List tableHeaders = getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.tableHeader, "Table headers");
        return tableHeaders;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAAAParksLincoln
     * description :: To click on AAA Parks Lincoln
     * date :: 
     * author :: Jagadish Pola
     */
    //Menubar top
    public void clickOnAAAParksLincoln() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnAAAParksLincoln, 60);
        click(RSPHomePage.btnAAAParksLincoln, "AAA Park's Lincoln button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearch
     * description :: To click on search button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnSearch() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnSearch, 60);
        click(RSPHomePage.btnSearch, "Search button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHelp
     * description :: click on helptab
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnHelp() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnHelp, 60);
        click(RSPHomePage.btnHelp, "Help button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMenuDropdown
     * description :: clicks on menu dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnMenuDropdown() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnMenuDropdown, 60);
        click(RSPHomePage.btnMenuDropdown, "Menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownPriorityServices
     * description :: clicks on priority setting dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnDropdownPriorityServices() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblDropdownPriorityServices, 60);
        click(RSPHomePage.lblDropdownPriorityServices, "Dropdown priority service");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectPriorityServiceFromDropdown
     * description :: selects priority from service dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void selectPriorityServiceFromDropdown() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.menuSelectPriority, 60);
        click(RSPHomePage.menuSelectPriority, "select priority");
    }
    
    public void selectClubSettingsfromDropDown() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblClubSettings, 60);
        click(RSPHomePage.lblClubSettings, "select clubSettings");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSignOut
     * description :: clicks and verifies logout is successful or not
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnSignOut() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnSignOut, 60);
        click(RSPHomePage.btnSignOut, "Signout button");
        acceptAlert();
        if (!isVisibleOnly(RSPLoginPage.txtUserName, "User name visibility")) {
            acceptAlert();
        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHideComment
     * description :: clicks on hide button
     * date :: 
     * author :: Jagadish Pola
     */
    //Right frame buttons and links
    public void clickOnHideComment() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnHideComment, 60);
        click(RSPHomePage.btnHideComment, "Hide comment button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNewOrder
     * description :: clicks on new order button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnNewOrder() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnNewOrder, 60);
        click(RSPHomePage.btnNewOrder, "New order button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterTextInAppointmentsSearch
     * description :: enters text in appointment search
     * date :: 
     * author :: Jagadish Pola
     */
    //based on callid
    public void enterTextInAppointmentsSearch(String callId) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.txtAppointmentsSearch, 60);
        type(RSPHomePage.txtAppointmentsSearch, callId, "Appointment search");
    }

    /**
     * param :: String,String
     * return ::void
     * throws :: throwable
     * methodName :: getCallStatus
     * description :: gets the call status for newly created order
     * date :: 
     * author :: Jagadish Pola
     */
    public String getCallStatus(String callId, String date) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.callStatus(callId, date), 60);
        return getText(RSPHomePage.callStatus(callId, date), "Call status");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickToSetNumberOfOrdersPerPage
     * description :: sets number of order's per page
     * date :: 
     * author :: Jagadish Pola
     */
    //bottom page
    public void clickToSetNumberOfOrdersPerPage() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.clickToSetOrdersPerPage, 60);
        clickOnly(RSPHomePage.clickToSetOrdersPerPage, "Click to set number of orders per page");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterTextInTotalOrdersPerPage
     * description :: enter text and sets total orders per page
     * date :: 
     * author :: Jagadish Pola
     */
    public void enterTextAndSetTotalOrdersPerPage(String ordersPerPage) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.txtOrdersPerPage, 60);
        clearData(RSPHomePage.txtOrdersPerPage);
        type(RSPHomePage.txtOrdersPerPage, ordersPerPage, "Orders per page");
        clickToSetNumberOfOrdersPerPage();
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAriaLabelNext
     * description :: click on next page button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnAriaLabelNext() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnAriaLabelNext, 60);
        click(RSPHomePage.btnAriaLabelNext, "Button aria label next");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAriaLabelPrevious
     * description :: click on previous page button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnAriaLabelPrevious() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnAriaLabelPrevious, 60);
        click(RSPHomePage.btnAriaLabelPrevious, "Button aria label previous");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAriaLabelFirstPage
     * description :: click on button tahat navigates to first page
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnAriaLabelFirstPage() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnAriaLabelFirstPage, 60);
        click(RSPHomePage.btnAriaLabelFirstPage, "Button aria label first page");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAriaLabelLastPage
     * description :: click on button tahat navigates to last page
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnAriaLabelLastPage() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.btnAriaLabelLastPage, 60);
        click(RSPHomePage.btnAriaLabelLastPage, "Button aria label last page");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getTotalOrders
     * description :: returns the total orders
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalOrders() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblTotalOrders, 60);
        return getText(RSPHomePage.lblTotalOrders, "Total Orders");
    }

    /**
     * param ::string,String,String
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyOrderCreated
     * description :: verifies the new order is created or not
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean findOrderInHomePage(String firstName, String lastName, String lastUpdateTime) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.findCallByMemberNameTime(firstName.toUpperCase(), lastName.toUpperCase(), lastUpdateTime), 10);
        return isVisibleOnly(RSPHomePage.findCallByMemberNameTime(firstName.toUpperCase(), lastName.toUpperCase(), lastUpdateTime), "Order created is displayed on main page");
    }


    /**
     * param ::string,String,String
     * return ::boolean
     * throws :: throwable
     * methodName :: findOrderInHomePageUsingTimeCreated
     * description :: verifies the new order is created or not using time created
     * date ::
     * author :: Jagadish Pola
     */
    public boolean findOrderInHomePageUsingTimeCreated(String firstName, String lastName, String timeCreated) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.findCallByMemberNameTimeCreated(firstName.toUpperCase(), lastName.toUpperCase(), timeCreated), 10);
        return isVisibleOnly(RSPHomePage.findCallByMemberNameTimeCreated(firstName.toUpperCase(), lastName.toUpperCase(), timeCreated), "Order created is displayed on main page");
    }

    /**
     * param :: string,String,String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOrder
     * description :: clicks on the new order that is created with the help of new order button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnOrder(String firstName, String lastName, String lastUpdateTime) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.findCallByMemberNameTime(firstName, lastName, lastUpdateTime), 10);
        mouseHover(RSPHomePage.findCallByMemberNameTime(firstName.toUpperCase(), lastName.toUpperCase(), lastUpdateTime), "Order created is displayed on main page");
        mouseClick(RSPHomePage.findCallByMemberNameTime(firstName.toUpperCase(), lastName.toUpperCase(), lastUpdateTime), "Order created is displayed on main page");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getStatusOfParticularCall
     * description :: gets the new order status that is created with the help of new order button
     * date :: 
     * author :: Jagadish Pola
     */
    public String getStatusOfParticularCall(String firstName, String lastName, String lastUpdateTime) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.verifyCallStatusByMemberNameTime(firstName.toUpperCase(), lastName.toUpperCase(), lastUpdateTime), 10);
        return getText(RSPHomePage.verifyCallStatusByMemberNameTime(firstName.toUpperCase(), lastName.toUpperCase(), lastUpdateTime), "Call status is::");
    }


    //label Menu dropdown

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAppointments
     * description :: clicks on appointment button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnAppointments() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblAppointments, 60);
        click(RSPHomePage.lblAppointments, "Appointments in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnReporting
     * description :: clicks on reporting
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnReporting() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblReporting, 60);
        click(RSPHomePage.lblReporting, "Reporting in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBlankInspectionForm
     * description :: clicks on blank inspection form
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnBlankInspectionForm() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblBlankInspectionForm, 60);
        click(RSPHomePage.lblBlankInspectionForm, "Blank inspection form in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnShopSettings
     * description :: clicks on shop settings in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnShopSettings() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblShopSettings, 60);
        click(RSPHomePage.lblShopSettings, "Shop settings in menu dropdown");
    }
    
    public void clickOnClubSettings() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblClubSettings, 60);
        click(RSPHomePage.lblClubSettings, "Club settings in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManageUser
     * description :: clicks on manage user in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnManageUser() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblManageUsers, 60);
        click(RSPHomePage.lblManageUsers, "Manage user in menu dropdown");
    }
    
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManageShops
     * description :: clicks on manage shops in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnManageShops() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblManageShops, 60);
        click(RSPHomePage.lblManageShops, "Manage Shops in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDocument
     * description :: clicks on document in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnDocument() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblDocuments, 60);
        click(RSPHomePage.lblDocuments, "Document in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPromotions
     * description :: clicks on promotions in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnPromotions() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblPromotions, 60);
        click(RSPHomePage.lblPromotions, "Promotions in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCoupons
     * description :: clicks on coupons in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCoupons() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblCoupons, 60);
        click(RSPHomePage.lblCoupons, "Coupons in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMyProfile
     * description :: clicks on profile in dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnMyProfile() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblMyProfile, 60);
        click(RSPHomePage.lblMyProfile, "My profile in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnChangePassword
     * description :: click on change password
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnChangePassword() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblChangePassword, 60);
        click(RSPHomePage.lblChangePassword, "Change password in menu dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSignOutInMenuDropdown
     * description :: clicks on signout in menu dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnSignOutInMenuDropdown() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblSignout, 60);
        click(RSPHomePage.lblSignout, "Signout button in menu dropdown");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: alertSuccessNotification
     * description :: sucess notification verification available in common lib also
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean alertSuccessNotification() throws Throwable {
        //dynamicWaitByLocator(RSPHomePage.successNotification, 60);
        return isVisible(RSPHomePage.successNotification, "Success notification");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: findCallIdInQueue
     * description :: helps to find the call which is created new using D3Call
     * date :: 
     * author :: Jagadish Pola
     */
    //dynamic method for findin a call in Rsp using call id
    public boolean findCallIdInQueue(String callId, String callDate) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.findingCallId(callId, callDate), 60);
        return isVisible(RSPHomePage.findingCallId(callId, callDate), "Finding callId");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallId
     * description :: helps to click on the call which is created new using D3Call
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCallId(String callId, String callDate) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.findingCallId(callId, callDate), 60);
        mouseHover(RSPHomePage.findingCallId(callId, callDate), "Mouse on over to callid");
        mouseDoubleClick(RSPHomePage.findingCallId(callId, callDate), "Click on callid");
    }

    /**
     * param ::
     * return ::void
     * throws :: boolean
     * methodName :: verifyingCallId
     * description :: helps to find the call which is created new using D3Call
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean verifyingCallId(String callId, String callDate) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.findingCallId(callId, callDate), 20);
        return isVisibleOnly(RSPHomePage.findingCallId(callId, callDate), "Call id");
    }

    //dynamic method for getting column values from table

    /**
     * param ::
     * return ::List
     * throws :: throwable
     * methodName :: getTableValuesRSPHome
     * description :: gets table values from table based on call id and date
     * date :: 
     * author :: Jagadish Pola
     */
    public List getTableValuesRSPHome(String callId, String date) throws Throwable {
        List tableData = getTableDataByRow(RSPHomePage.gettingTableValues(callId, date), "Table data");
        return tableData;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectMonth
     * description :: clicks on select month dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnSelectMonth(String month) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.drpdwnMonth, 60);
        click(RSPHomePage.drpdwnMonth, "Click on select month dropdown");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectMonthFromDropdown
     * description :: selects month from dropdown pass the value displayed in the application
     * date :: 
     * author :: Jagadish Pola
     */
    public void selectMonthFromDropdown(String month) throws Throwable {
        clickOnSelectMonth(month);
        dynamicWaitByLocator(RSPHomePage.selectMonthFromDropdown(month), 60);
        selectByValue(RSPHomePage.selectMonthFromDropdown(month), month, "Select month from dropdown");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectYear
     * description ::clicking on year dropdown pass the default value displayed in the application
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnSelectYear(int year) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.clickOnYearDropdown(year), 60);
        click(RSPHomePage.clickOnYearDropdown(year), "Click on select year dropdown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectYearFromDropdown
     * description :: pass the value you want to select
     * date :: 
     * author :: Jagadish Pola
     */
    public void selectYearFromDropdown(int year) throws Throwable {
        clickOnSelectYear(year);
        dynamicWaitByLocator(RSPHomePage.selectYearFromDropdown(year), 60);
        selectByValue(RSPHomePage.selectYearFromDropdown(year), Integer.toString(year), "Select year from dropdown");
    }

    /**
     * param :: String,String
     * return ::void
     * throws :: throwable
     * methodName :: findAndGetCallStatus
     * description :: clicks and returns newly created call using D3 status
     * date :: 
     * author :: Jagadish Pola
     */
    public String findAndGetCallStatus(String callId, String callDate) throws Throwable {
        findCallIdInQueue(callId, callDate);
        String status = getCallStatus(callId, callDate);
        return status;
    }

    /**
     * param ::int
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnNextPageNumber
     * description :: Helps to click on next page number
     * date :: 03/Mar/2018
     * author :: Jagadish Pola
     */
    public boolean clickOnNextPageNumber(int pageNumber) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.clickOnNumberButtonAvailable(pageNumber), 10);
        if (isVisibleOnly(RSPHomePage.clickOnNumberButtonAvailable(pageNumber), "Next page number is clicked")) {
            clickOnly(RSPHomePage.clickOnNumberButtonAvailable(pageNumber), "Next page number is clicked::" + pageNumber);
        }
        return isVisibleOnly(RSPHomePage.clickOnNumberButtonAvailable(pageNumber), "Next page number is clicked");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyNewRepairOrderWindow
     * description :: verifies new order window is displayed or not
     * date :: 03/Mar/2018
     * author :: Jagadish Pola
     */

    public boolean verifyNewRepairOrderWindow() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.windowNewRepairOrder, 60);
        return isVisible(RSPHomePage.windowNewRepairOrder, "New repair order window::");
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verificationOfErrorNotification
     * description :: verifies error notification is visible or not available in commoon lib also
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean verificationOfErrorNotification() throws Throwable {
        return isVisible(RSPHomePage.errorNotification, "Error notification visibile");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnColumn
     * description :: clicks on column header which helps to sort the columns
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnColumn(String headerName) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.clickOnTableHeader(headerName), 60);
        click(RSPHomePage.clickOnTableHeader(headerName), "Clicked on time created");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyingSortingOrder
     * description :: sorting order verification
     * date :: 
     * author :: Jagadish Pola
     */

    public String verifyingSortingOrder(List records, String sortingColumnName) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.getArrowIconDirection(sortingColumnName), 60);
        if (getAttributeByClass(RSPHomePage.getArrowIconDirection(sortingColumnName), "Arrow direction").toLowerCase().contains("down")) {
            if (verificationOfRecordsSortingInDecendingOrder(records, sortingColumnName)) {
                return "decending order";
            }
        } else if (getAttributeByClass(RSPHomePage.getArrowIconDirection(sortingColumnName), "Arrow direction").toLowerCase().contains("up")) {
            if (verificationOfRecordsSortingInAscendingOrder(records, sortingColumnName)) {
                return "ascending order";
            }
        }
            return "Failed to verify sorting order";
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDataRecords
     * description :: return the records available in column based on column name
     * date :: 
     * author :: Jagadish Pola
     */

    public List getDataRecords(String columnName) throws Throwable {
        List list = new ArrayList();
        if (columnName.equalsIgnoreCase("Time Created")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(2), columnName);
        }
        if (columnName.equalsIgnoreCase("Last Updated")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(3), columnName);
        }
        if (columnName.equalsIgnoreCase("Customer Name")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(4), columnName);
        }
        if (columnName.equalsIgnoreCase("Make")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(6), columnName);
        }
        if (columnName.equalsIgnoreCase("Model")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(7), columnName);
        }
        if (columnName.equalsIgnoreCase("Type")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(9), columnName);
        }
        if (columnName.equalsIgnoreCase("Status")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(12), columnName);
        }
        if (columnName.equalsIgnoreCase("Year")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(5), columnName);
        }
        if (columnName.equalsIgnoreCase("SVO #")) {
            return getTableDataByRowWithOutNullOrEmptyValues(RSPHomePage.getColumnData(8), columnName);
        }
        return list;
    }

    /**
     * param ::list,String
     * return ::boolean
     * throws :: throwable
     * methodName :: verificationOfRecordsSortingInDecendingOrder
     * description :: verifies records is in decending order
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verificationOfRecordsSortingInDecendingOrder(List verificationList, String columnName) throws Throwable {
        boolean flag = false;
        if (columnName.equalsIgnoreCase("Time Created") || columnName.equalsIgnoreCase("Last Updated")) {
            return verifyRecordsAreInDecendingOrderForDate(verificationList);
        }
        if (columnName.equalsIgnoreCase("Customer Name") || columnName.equalsIgnoreCase("Make") || columnName.equalsIgnoreCase("Model") || columnName.equalsIgnoreCase("Type") || columnName.equalsIgnoreCase("Status")) {
            return compareTwoStringsFromOneListInDecendingOrder(verificationList);
        }
        if (columnName.equalsIgnoreCase("Year") || columnName.equalsIgnoreCase("SVO #")) {
            return verifyRecordsAreInDecendingOrderForIntegerField(verificationList);
        }
        return flag;
    }

    /**
     * param :: list,String
     * return ::boolean
     * throws :: throwable
     * methodName :: verificationOfRecordsSortingInAscendingOrder
     * description :: verifies records is in ascending order
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verificationOfRecordsSortingInAscendingOrder(List verificationList, String columnName) throws Throwable {
        boolean flag = false;
        if (columnName.equalsIgnoreCase("Time Created") || columnName.equalsIgnoreCase("Last Updated")) {
            return verifyRecordsAreInAscendingOrderForDate(verificationList);
        }
        if (columnName.equalsIgnoreCase("Customer Name") || columnName.equalsIgnoreCase("Make") || columnName.equalsIgnoreCase("Model") || columnName.equalsIgnoreCase("Type") || columnName.equalsIgnoreCase("Status")) {
            return compareTwoStringsFromOneListInAscendingOrder(verificationList);
        }
        if (columnName.equalsIgnoreCase("Year") || columnName.equalsIgnoreCase("SVO #")) {
            return verifyRecordsAreInAscendingOrderForIntegerField(verificationList);
        }
        return flag;
    }

    /**
     * param :: String,String
     * return ::void
     * throws :: throwable
     * methodName :: searchingACall
     * description :: searches for a newly created D3 call in each page until it found
     * date ::
     * author :: Jagadish Pola
     */

    public boolean searchingACall(String callId, String callDate) throws Throwable {
        boolean flag=false;
        for (int pageNumber = 2; pageNumber > 0; pageNumber++) {
            if (verifyingCallId(callId, callDate)) {
                flag=true;
                break;
            } else if (!clickOnNextPageNumber(pageNumber)) {
                break;
            }
        }
        return flag;
    }

    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExistingCall
     * description :: clicks on existing order based on row number
     * date ::
     * author :: Jagadish Pola
     */

    public void clickOnExistingCall(int rowNumber) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.clickOnExistingCall(Integer.toString(rowNumber+2)),60);
        mouseHover(RSPHomePage.clickOnExistingCall(Integer.toString(rowNumber+2)), "Selecting an existing call");
        mouseClick(RSPHomePage.clickOnExistingCall(Integer.toString(rowNumber+2)), "Selecting an existing call");
    }

    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: verifyRecordsAreAvailable
     * description :: verifies records available in the home page to select the existing call
     * date ::
     * author :: Jagadish Pola
     */

    public int verifyRecordsAreAvailable() throws Throwable {
        Thread.sleep(15000);
        dynamicWaitByLocator(RSPHomePage.totalTableRows,60);
        int totalRowsAvailable = getTableDataByRowWithOutReport(RSPHomePage.totalTableRows, "All rows data").size();
        return totalRowsAvailable;
    }

    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallStatus
     * description :: verifies existing order status
     * date ::
     * author :: Jagadish Pola
     */

    public String verifyCallStatus(int rowNumber) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.gettingStatusOfExistingCall(Integer.toString(rowNumber)),60);
        return getText(RSPHomePage.gettingStatusOfExistingCall(Integer.toString(rowNumber+1)),"Call status ");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectPrirityFromDropdown
     * description :: Selects priority from dropdown
     * date ::05-Apr-2018
     * author :: Jagadish Pola
     */
    //param value::No Priority Service,Priority Service

    public void selectPriorityFromDropdown(String priority) throws Throwable {
        dynamicWaitByLocator(RSPHomePage.selectPriority(priority),60);
        mouseHover(RSPHomePage.selectPriority(priority),priority);
        click(RSPHomePage.selectPriority(priority),"Selected "+priority);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: selectedPriorityService
     * description :: Selects priority Service
     * date ::05-Apr-2018
     * author :: Jagadish Pola
     */

    public String selectedPriorityService() throws Throwable {
        dynamicWaitByLocator(RSPHomePage.lblSelectedPriorityService,60);
        return getText(RSPHomePage.lblSelectedPriorityService,"Selected priority service");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyingAndSettingPriorityStatus
     * description :: Verifying and setting the shop priority status.
     * date ::11-Apr-2018
     * author :: Jagadish Pola
     */

    public String verifyingAndSettingPriorityStatus(String priorityServiceType) throws Throwable {
        String priorityService=selectedPriorityService().replaceAll(" ", "");
        if (!priorityService.toLowerCase().equals("priorityservice")&&!priorityService.toLowerCase().equals("shopclosed")&&!priorityService.toLowerCase().equals("shopclosingsoon")) {
            //if priority service is not selected then clicks on dropdown to select service
            clickOnDropdownPriorityServices();
            //Selects priority service
            selectPriorityFromDropdown(priorityServiceType);
        }
        return selectedPriorityService();
    }
    
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: validateUserCanManageClubsOrShops
     * description ::Validating how many Clubs or Shops user can manage
     * date ::19-Apr-2018
     * author :: AGurijala
     */
//manage one or more clubs/shops 
	public void validateUserCanManageClubsOrShops(String userType) throws Throwable {
		switch(userType){
			case "Club Admin":
				validateManageShopsPage();
				break;
			case "Club User":
				validateManageShopsPage();
				break;
			case "Shop Admin":
				break;
			case "Shop User":
				break;
			default:
					break;
		}
	}
	 /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: validateUserCanManageClubsOrShops
     * description ::Validating how many Clubs or Shops user can manage
     * date ::19-Apr-2018
     * author :: AGurijala
     */
	private void validateManageShopsPage() throws Throwable{
		clickOnMenuDropdown();
		clickOnManageShops();
		Thread.sleep(3000);
		String pageUrl=getCurrentUrl();
		String shopsUrl="manage-shops";
		if(pageUrl.toLowerCase().contains(shopsUrl.toLowerCase())){
			reporter.SuccessReport("Validate manage-shops Page", shopsUrl+"  page is displayed");
		}
		else{
			reporter.failureReport("Validate manage-shops Page", shopsUrl+" Page is not displayed, displayed page is "+pageUrl);
		}
	}
	
	/**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: validateUserCanManagePromotions
     * description ::Validating Promotions for different Type of Users
     * date ::19-Apr-2018
     * author :: AGurijala
     */
     public void validateUserCanManagePromotions(String userType ) throws Throwable {
    	 switch(userType){
    	 case "Club Admin":
    		 validateMangePromotions();
    		 break;
    	 case "Club User":
    		 validateMangePromotions();
    		 break;
    	 case "Shop Admin":
    		 break;
    	 case "Shop User":
    		 break;
    	 default:
    		 break;
    	 }
     }
     /**
      * param ::
      * return ::String
      * throws :: throwable
      * methodName :: validateMangePromotions
      * description ::Validating promotions
      * date ::19-Apr-2018
      * author :: AGurijala
      */
     private void validateMangePromotions() throws Throwable {
    	 clickOnMenuDropdown();
 		clickOnPromotions();
 		Thread.sleep(3000);
 		String pageUrl=getCurrentUrl();
 		String promotionsUrl="Promotions";
 		click(RSPHomePage.lblPromotions, "Promotions");
		if(pageUrl.toLowerCase().contains(promotionsUrl.toLowerCase())){
			reporter.SuccessReport("Validate Promotions Page", promotionsUrl+"  page is displayed");
		}
		else{
			reporter.failureReport("Validate Promotions Page", promotionsUrl+" Page is not displayed, displayed page is "+pageUrl);
		}
		}
     /**
      * param ::
      * return ::String
      * throws :: throwable
      * methodName :: validateUserCanManageClubSettings
      * description ::Validating club settings for different type of Users
      * date ::19-Apr-2018
      * author :: AGurijala
      */
     public void validateUserCanManageClubSettings(String userType ) throws Throwable {
    	switch(userType){
		case "Club Admin":
			validateClubSettingsPage();
			break;
		case "Club User":
			break;
		case "Shop Admin":
			break;
		case "Shop User":
			break;
		default:
				break;
    	}
     }
     
     /**
      * param ::
      * return ::String
      * throws :: throwable
      * methodName :: validateClubSettingsPage
      * description ::Validating Club Settings
      * date ::19-Apr-2018
      * author :: AGurijala
      */
     public void validateClubSettingsPage() throws Throwable{
    	    clickOnMenuDropdown();
			clickOnClubSettings();
			Thread.sleep(3000);
			String pageUrl=getCurrentUrl();
			String clubSettings="settings/club";
			if(pageUrl.toLowerCase().contains(clubSettings.toLowerCase())){
				reporter.SuccessReport("Validate club Settings Page", clubSettings+"  page is displayed");
			}
			else{
				reporter.failureReport("Validate club Settings Page", clubSettings+" Page is not displayed, displayed page is "+pageUrl);
			}
		}
	
     /**
      * param ::
      * return ::String
      * throws :: throwable
      * methodName :: validateUserCanManageShopSettings
      * description ::Validating Shop Settings for different Type of Users
      * date ::19-Apr-2018
      * author :: AGurijala
      */
	   public void validateUserCanManageShopSettings(String userType ) throws Throwable {
	    	clickOnMenuDropdown();
	    	switch(userType){
			case "Club Admin":
				validateShopSettingsPage();
				break;
			case "Club User":
				validateShopSettingsPage();
				break;
			case "Shop Admin":
				validateShopSettingsPage();
				break;
			case "Shop User":
				validateShopSettingsPage();
				break;
			default:
					break;
	    	}
	     }
	   /**
	      * param ::
	      * return ::String
	      * throws :: throwable
	      * methodName :: validateShopSettingsPage
	      * description ::Validating Shop Settings
	      * date ::19-Apr-2018
	      * author :: AGurijala
	      */
	   public void validateShopSettingsPage() throws Throwable{
			clickOnShopSettings();
			Thread.sleep(3000);
			String pageUrl=getCurrentUrl();
			String shopSettings="settings/shop";
			if(pageUrl.toLowerCase().contains(shopSettings.toLowerCase())){
				reporter.SuccessReport("Validate Shop Settings Page", shopSettings+"  page is displayed");
			}
			else{
				reporter.failureReport("Validate Shop Settings Page", shopSettings+" Page is not displayed, displayed page is "+pageUrl);
			}
			if(isElementPresent(RSPShopSettingsPage.actveTabShopSettings, "Active Shop Settings")){
				reporter.SuccessReport("Validate Shop Settings tab is active", "Shop Settings tab is active");
			}
			else{
				reporter.failureReport("Validate Shop Settings tab is active", "Shop Settings tab is not active");
			}
		}

	public void validateUserCanViewDashBoards(String userType) throws Throwable {
		clickOnDashBoardTab();
    	switch(userType){
		case "Club Admin":
			validateCanViewMultipleShops("Club");
			break;
		case "Club User":
			validateShopSettingsPage();
			break;
		case "Shop Admin":
			validateShopSettingsPage();
			break;
		case "Shop User":
			validateShopSettingsPage();
			break;
		default:
			break;
    	}
		
	}

	private void clickOnDashBoardTab() throws Throwable {
		dynamicWaitByLocator(RSPHomePage.tabDashBoard, 60);
        click(RSPHomePage.tabDashBoard, "Dash Board");
	}

	private void validateCanViewMultipleShops(String type) throws Throwable {
		selectByValue(RSPHomePage.drpdwnSelectSearchType, type, "SearchType");
		click(RSPHomePage.lnkMultiSelectSearchType,"Multi Select Search Type");
		List<WebElement> availableOptions=getWebElementList(RSPHomePage.lstValuesMultiSelectSearchType, "Available Options");
		for(WebElement option:availableOptions){
			String name=getAttributeValue(option, "title");
			if(name.length()>0){
				reporter.SuccessReport("Print the available dropdown option", "Available option :"+name);
			}
			else{
				reporter.failureReport("Print the available dropdown option", "Available option does not have any text");
			}
		}
	}
	
	public void validateUserCanCreateNewUsers(String userType) throws Throwable{
		RSPManageUserLib managerUser = new RSPManageUserLib();
		RSPCreateUserDetailsLib createUserDetails = new RSPCreateUserDetailsLib();
		// Can Create Users
		clickOnMenuDropdown();
		if (!userType.equals("Shop User")) {
			clickOnManageUser();
			managerUser.clickOnNewUser();
			createUserDetails.validateCreatableUserRoles(userType);
		} else {
			if (isElementNotPresent(RSPHomePage.lblManageUsers,"Manage Users")) {
				reporter.SuccessReport("Manage users menu item should not be displayed","Manage users menu item is not displayed");
			} else {
				reporter.failureReport("Manage users menu item should not be displayed","Manage users menu item is displayed",driver);
			}
		}
	}

	
}