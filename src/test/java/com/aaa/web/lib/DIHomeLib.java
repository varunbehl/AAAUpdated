package com.aaa.web.lib;

import com.aaa.web.page.*;
import com.aaa.accelerators.ActionEngine;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.thread.graph.IThreadWorkerFactory;

import java.util.ArrayList;
import java.util.List;

public class DIHomeLib extends ActionEngine {
    List<WebElement> allCallIds = null;

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContinueQueuesInDispatch
     * description ::To click On Continue button in Queues selection In Dispatch
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void clickOnContinueQueuesInDispatch() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnContinueOnQueueSelection, "dispatch continue queue");
        Thread.sleep(3000);
        click(DIHomePage.btnContinueOnQueueSelection, "dispatch continue queue");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCallsInDispatch
     * description ::To click On Search Calls In Dispatch
     * date :: 05-Nov-2017
     * author ::Cigniti
     */
    public void clickOnSearchCallsInDispatch() throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIHomePage.btnSearchCalls, "Search calls Link");
        click(DIHomePage.btnSearchCalls, "Search calls Link");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnSearchCallsLink
     * description::To click on Search calls link
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnSearchCallsLink() throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIHomePage.lnkSearchCalls, "Search calls Link");
        click(DIHomePage.lnkSearchCalls, "Search calls Link");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: logOut
     * description :: logOut
     * date :: 05-Nov-2017
     * author ::Cigniti
     */
    public void logOut() throws Throwable {
        Thread.sleep(2000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        if (checkForLogout) {
            click(CRHomePage.lnkLogout, "logOut link");
            waitForVisibilityOfElement(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
            CloseLogoutAlert();
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: logOut
     * description :: logOut
     * date :: 05-Nov-2017
     * author ::Cigniti
     */
    public void verifyandlogOut() throws Throwable {
        Thread.sleep(2000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        if (checkForLogout) {
            click(CRHomePage.lnkLogout, "logOut link");
            isVisibleOnly(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
            acceptAlert();
            CloseLogoutAlert();
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchandSelectCallID
     * description :: To search with selected callID
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void searchAndSelectCallIDInDI(String CallID) throws Throwable {
        enterCallIDInfo(CallID);
        clickOnSearchInSearchCalls();
        clickOnCallDateOrIDLink();
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::searchAndSelectCallIDInSPPDI
     * description::searchAndSelectCallID In SPPDI
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void searchAndSelectCallIDInSPPDI(String CallID) throws Throwable {
        enterCallIDInfo(CallID);
        clickOnSearchInSearchCalls();
        clickOnCallDateOrIDLink();
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::verifyPhoneTypeOnDIMCD
     * description::To verify Phone Type On MCD window in DI
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String verifyPhoneTypeOnDIMCD() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        //assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Verified The Phone Type Expected Phone Type is displayed in Dispatch MCD");
        Thread.sleep(3000);
        closeMcd();
        return phoneTypeInDI;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::closeMcd
     * description::To click on close button in MCD window
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void closeMcd() throws Throwable {
        click(DIHomePage.btnMCDwindowClose, "Close MCD Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallIDInfo
     * description :: To enter CallID in textBox
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterCallIDInfo(String callID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtSearchCallID, "Click on CallID Field");
        click(DIHomePage.txtSearchCallID, "Click on CallID Field");
        waitForVisibilityOfElement(DIHomePage.txtSearchCallID, "Type CallID");
        System.out.println(callID);
        type(DIHomePage.txtSearchCallID, callID, "Type CallID");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickonSearchinSearchCalls
     * description :: To Click search Button in serach calls
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnSearchInSearchCalls() throws Throwable {
        click(DIHomePage.SearchButton, "Search Button");


    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallDateOrIDLink
     * description :: To Click on CallIDOrDate Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnCallDateOrIDLink() throws Throwable {
        boolean flagCallIdLink = isElementPresent(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link");
        if (flagCallIdLink) {
            waitForVisibilityOfElement(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link");
            click(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link");
        } else {
            assertTrue(flagCallIdLink, "No Calls avilable for CallID");
        }
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallDateOrIDLink
     * description :: To Click on CallIDOrDate Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnProfile() throws Throwable {
        clickOnProfileMenu();
        clickOnProfile1UnderProfileMenu();
        Thread.sleep(22000);
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnProfile1UnderProfileMenu
     * description::To click On Profile1 Under Profile Menu
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnProfile1UnderProfileMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.linkProfile1InProfileMenu, "Click Profile under Profile Menu");
        click(DIHomePage.linkProfile1InProfileMenu, "Click Profile under Profile Menu");
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnProfileMenu
     * description::To click On +Profile Menu
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnProfileMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
        click(DIHomePage.tabDiProfile, "Profile Tab");
    }

    //Double click on Call Id

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::searchAndSelectCallIDOnProfile
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void searchAndSelectCallIDOnProfile(String CallID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callIdInProfileMenu, "CallId in Profile");
        allCallIds = getWebElementList(DIHomePage.lblCallIDInProfileResultsWindow, "CallId in Profile");
        if (allCallIds != null) {
            for (int i = 0; i <= allCallIds.size(); i++) {
                String callIdFromList = allCallIds.get(i).getText();
                if (CallID.equals(callIdFromList)) {
                    Actions action = new Actions(driver);
                    action.doubleClick(allCallIds.get(i)).build().perform();
                }
            }
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPhoneTypeOnProfile
     * description :: To verify the PhoneType On Profile
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyPhoneTypeOnProfile(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch Profile");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckLoad
     * description :: To click On Truck Load Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnTruckLoad() throws Throwable {
        clickOnTruckLoadTab();
        clickOnTruckLoadDefaultOption();
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnTruckLoadTab
     * description::clickOnTruckLoadTab
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnTruckLoadTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.tabTruckLoad, "TruckLoad Tab");
        click(DIHomePage.tabTruckLoad, "TruckLoad Tab");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnTruckLoadDefaultOption
     * description::clickOnTruckLoadDefaultOption
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnTruckLoadDefaultOption() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckLoadDefaultView, "Default View On TruckLoad");
        click(DIHomePage.truckLoadDefaultView, "Default View On TruckLoad");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPhoneTypeOnTruckLoad
     * description :: To verify the PhoneType On MCD
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyPhoneTypeOnTruckLoad(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch MCD");
        closeMcd();
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickForSearchCallID
     * description::clickForSearchCallID
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickForSearchCallID() throws Throwable {
        closeFacilityWindow();
        clickOnSearchCallsInDispatch();
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::closeFacilityWindow
     * description::closeFacilityWindow
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean closeFacilityWindow() throws Throwable {
        boolean facilityPTA = isVisibleOnly(DIHomePage.closeFacilityWindow, "close Facility window");
        if (facilityPTA) {
            click(DIHomePage.closeFacilityWindow, "close Facility window");
        }
        return facilityPTA;
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::verifyPhoneTypeOnSPPDIMCD
     * description::verifyPhoneTypeOnSPPDIMCD
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void verifyPhoneTypeOnSPPDIMCD(String PhoneType) throws Throwable {

        boolean emptyResults = isVisibleOnly(DIHomePage.emptyResultsForCallID, "Empty Results");
        if (emptyResults) {
            assertTrue(emptyResults, "No Records found with the give search criteria");
        } else {
            waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
            String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
            assertTrue(phoneTypeInDI.equalsIgnoreCase(PhoneType), "Expected Phone Type is displayed in SPPDispatch MCD");
        }
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::verifyPhoneTypeInSPPTruckLoadDefault
     * description::verifyPhoneTypeInSPPTruckLoadDefault
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void verifyPhoneTypeInSPPTruckLoadDefault(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.phoneTypeOnDefaultViewTruckLoad, "get Phone Type");
        String phoneTypeInSppDI = getText(DIHomePage.phoneTypeOnDefaultViewTruckLoad, "get Phone Type");
        assertTrue(!(phoneTypeInSppDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in SPPDispatch TruckLoad");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnProfileInSPPDI
     * description::clickOnProfileInSPPDI
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnProfileInSPPDI() throws Throwable {
        clickOnProfileMenuSPPDI();
        clickOnProfile1UnderProfileMenuSPPDI();
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnProfile1UnderProfileMenuSPPDI
     * description::clickOnProfile1UnderProfileMenuSPPDI
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnProfile1UnderProfileMenuSPPDI() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.linkProfile1InProfileMenu, "Profile1 under Profile Menu");
        click(DIHomePage.linkProfile1InProfileMenu, "Profile1 under Profile Menu");
        Thread.sleep(10000);
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnProfileMenuSPPDI
     * description::clickOnProfileMenuSPPDI
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnProfileMenuSPPDI() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.profile1SPPDI, "Profile Tab");
        click(DIHomePage.profile1SPPDI, "Profile Tab");
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::verifyPhoneTypeOnProfileInSPPDI
     * description::verifyPhoneTypeOnProfileInSPPDI
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void verifyPhoneTypeOnProfileInSPPDI(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch Profile");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnQueueSelection
     * description :: clicking On Close icon On Queue Selection popup
     * date :: 18-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnCloseIconOnQueueSelection() throws Throwable {


        boolean closeIconOnQueueSelection = isVisibleOnly(DIHomePage.iconCloseOnQueueSelection, "Close icon is Available");
        if (closeIconOnQueueSelection) {
            click(DIHomePage.iconCloseOnQueueSelection, "Close Icon Queue Selection");
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: sessionInNewTab
     * description :: Using this method we can open the session in new tab
     * date :: 18-Nov-2017
     * author :: Chandu Dendukuri
     */
    public String sessionInNewTab() throws Throwable {
        String currentUrl = driver.getCurrentUrl();
        openURLInNewWindow(currentUrl);
        clickOnCloseIconOnQueueSelection();
        boolean menuItem = verifyMenuItem();
        if (menuItem)
            reporter.SuccessReport("Session Validation in New Page", "<b>Menu Item is visible:: " + menuItem);

        return currentUrl;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDate
     * description :: Entering Start date on Search callas window
     * date :: 20-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterStartDate(String startDate) throws Throwable {
        click(DIHomePage.txtStartDate, "Start Date text field");
        clearData(DIHomePage.txtStartDate);
        type(DIHomePage.txtStartDate, startDate, "Start Date text field");


    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getPTATimeZone
     * description ::To get PTA time zone
     * date :: 20-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getPTATimeZone() throws Throwable {

        String pstTimeZone = getText(DIHomePage.lblMCDPTATimeZone, "Verifying PTA Time Zone");
        return pstTimeZone;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: compareTimeZonesInCRDI
     * description :: to compare time zone in CR AND DI
     * date :: 20-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean compareTimeZonesInCRDI(String pstTimeZone, String newZone) throws Throwable {
        boolean compareingTimeZones = pstTimeZone.equalsIgnoreCase(newZone);
        assertTrue(compareingTimeZones, "Breakdown location TIme Zone " + newZone + " " + " and MCD window Time Zone " + pstTimeZone + " are equal");
        return compareingTimeZones;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDispatchTab
     * description :: Clicking on Dispatch Tab
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnDispatchTab() throws Throwable {
        click(DIHomePage.btnDispatchTab, "Dispatch Tab");

    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: getDispatchQueueFirstFieldValue
     * description :: Retriving Dispatch Queue First Field Value
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getDispatchQueueFirstFieldValue() throws Throwable {
        String queueFirstValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Items");
        if (dispatchQueue) {
            queueFirstValue = getText(DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            click(DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
        } else {
            assertTrue(dispatchQueue, "Dispatch Field Value are empty");
        }
        return queueFirstValue;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: getDispatchQueueSecondFieldValue
     * description :: Retriving Dispatch Queue Second Field Value
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getDispatchQueueSecondFieldValue() throws Throwable {

        String queueSecondValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblQueueFieldSecondItem, "Dispatch field Items");
        if (dispatchQueue) {
            queueSecondValue = getText(DIHomePage.lblQueueFieldSecondItem, "Dispatch Field Value");
            click(DIHomePage.lblQueueFieldSecondItem, "Dispatch Field Value");
        } else {
            assertTrue(dispatchQueue, "Dispatch Field Value are empty");
        }
        return queueSecondValue;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddButtonOnQueueWindow
     * description :: clicking On Add Button On Queue Window
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnAddButtonOnQueueWindow() throws Throwable {
        click(DIHomePage.btnAddOnQueueWindow, "Add Button on dispatch window");

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveButtonOnQueueWindow
     * description :: clicking On Remove Button On Queue Window
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnRemoveButtonOnQueueWindow() throws Throwable {
        clickUntil(DIHomePage.btnRemoveOnQueueWindow, DIHomePage.btnRemoveOnQueueWindow, "Remove Button on dispatch window");
        click(DIHomePage.btnRemoveOnQueueWindow, "Remove Button on dispatch window");
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInQueueFilterDispatch
     * description :: Entering value in Queue Filter Dispatch
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean enterValueInQueueFilterDispatch(String fieldValue) throws Throwable {


        boolean dispatchQueueFilter = isVisibleOnly(DIHomePage.txtQueueFilterDispatch, "Dispatch Queue Filter");
        if (dispatchQueueFilter) {
            type(DIHomePage.txtQueueFilterDispatch, fieldValue, "Dispatch Queue Filter ");
        } else {
            assertTrue(dispatchQueueFilter, "Dispatch filter is appeared");
        }
        return dispatchQueueFilter;

    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInQueueFilterSelected
     * description :: Entering value in Queue Filter Selected
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterValueInQueueFilterSelected(String fieldValue) throws Throwable {

        waitForVisibilityOfElement(DIHomePage.txtQueueFilterSelected, "Selected Queue Filter");
        boolean selectedQueueFilter = isVisibleOnly(DIHomePage.txtQueueFilterSelected, "Selected Queue Filter");
        if (selectedQueueFilter) {
            type(DIHomePage.txtQueueFilterSelected, fieldValue, "Selected Queue Filter ");
        }
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectAllLinkOnQueueWindow
     * description :: click on Select All link
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnSelectAllLinkOnQueueWindow() throws Throwable {
        click(DIHomePage.lnkSelectAll, "Select All");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: getFieldItemHighlightStatusCount
     * description :: Getting the size of highlighted field values
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void getFieldItemHighlightStatusCount() throws Throwable {
        int records = getElementsSize(DIHomePage.lblHighlightedFieldValue);
        assertTrue(records != 0, records + " records are highlighted");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInDispatch
     * description :: Verify no records found in dispatch queue
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInDispatch() throws Throwable {

        int records = getElementsSize(DIHomePage.lblQueueFieldFirstItem);
        assertTrue(records == 0, records + " records are Available in Dispatch Queue hence all records are moved into Selected Queue");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInDispatch
     * description :: Verify no records found in dispatch queue
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInSelected() throws Throwable {

        int records = getElementsSize(DIHomePage.lblQueueFieldFirstItemInSelected);
        boolean record = (records == 0);
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInQueueFilterSpot
     * description :: Entering value in Queue Filter Spot
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean enterValueInQueueFilterSpot(String fieldValue) throws Throwable {


        boolean spotQueueFilter = isVisibleOnly(DIHomePage.txtqueueFilterSpot, "Spot Queue Filter");
        if (spotQueueFilter) {

            typeUntil(DIHomePage.txtqueueFilterSpot, fieldValue, "Spot Queue Filter ");
        } else {
            assertTrue(spotQueueFilter, "Spot filter is appeared");
        }
        return spotQueueFilter;
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInSelectedFilterSpot
     * description :: Entering value in Queue Filter Spot
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean enterValueInSelectedFilterSpot(String fieldValue) throws Throwable {


        boolean spotQueueFilter = isVisibleOnly(DIHomePage.txtQueueFilterSelected, "Spot Selected Filter");
        if (spotQueueFilter) {

            typeUntil(DIHomePage.txtQueueFilterSelected, fieldValue, "Spot Selected Filter ");
        } else {
            assertTrue(spotQueueFilter, "Spot filter is appeared");
        }
        return spotQueueFilter;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonOnQueueWindow
     * description :: clickOnCloseButtonOnQueueWindow
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnCloseButtonOnQueueWindow() throws Throwable {
        click(DIHomePage.btnCloseOnQueueWindow, "Close button");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectChangeSetQueueMenuItem
     * description :: selectChangeSetQueueMenuItem
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void selectChangeSetQueueMenuItem() throws Throwable {
        mouseClick(DIHomePage.lnkApplicationMenu, "Application Menu");
        click(DIHomePage.lnkChangeSetQueueSelection, "Change Set Queue Selection ");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnChangeEditQueueSelection
     * description :: clickOnChangeEditQueueSelection
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean clickOnChangeEditQueueSelection() throws Throwable {
        boolean changeEditQueu = isVisibleOnly(DIHomePage.btnChangeEditQueueSelection, "Change Edit Button");
        assertTrue(changeEditQueu, "Change Edit Queue window appeared");
        if (changeEditQueu) {
            click(DIHomePage.btnChangeEditQueueSelection, "Change Edit Button");
        }
        return changeEditQueu;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyUserProfilePopupWindow
     * description :: verifyUserProfilePopupWindow
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean verifyUserProfilePopupWindow() throws Throwable {
        boolean userProfileWindow = isVisibleOnly(DIHomePage.btnChangeEditQueueSelection, "Change Edit Button");
        assertTrue(userProfileWindow, "User Profile window appeared");
        return userProfileWindow;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHiddenTabsDropdown
     * description ::To click on Hidden tabs dropdown of profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickOnHiddenTabsDropdown() throws Throwable {
        boolean hiddenTabs = isVisibleOnly(DIHomePage.drpdwnHiddenTabs, "Hidden Tabs");
        if (hiddenTabs) {
            click(DIHomePage.drpdwnHiddenTabs, "Hidden Tabs");
        } else {
            assertTrue(hiddenTabs, "Hidden tabs is visible");
        }
        return hiddenTabs;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectTabFromHiddenTabsDropDown
     * description ::To select an Tab  from a HiddenTabs DropDown
     * date ::29-12-2017
     * author ::madhukar
     */
    public void selectTabFromHiddenTabsDropDown(String tabName) throws Throwable {
        List<WebElement> allTabs = getWebElementList(DIHomePage.listOfHiddenTabs, "Hidden Tabs List");
        for (int i = 0; i < allTabs.size(); i++) {
            String tabItems = allTabs.get(i).getText();
            if (tabItems.equalsIgnoreCase(tabName)) {
                Actions action = new Actions(driver);

                action.click(allTabs.get(i));
            }
        }

    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTabPlusButton
     * description ::To click on Tab plus button on Profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickOnTabPlusButton() throws Throwable {
        boolean hiddenTabs = isVisibleOnly(DIHomePage.linkTabPlusButton, "Hidden Tabs");
        if (hiddenTabs) {
            click(DIHomePage.linkTabPlusButton, "Hidden Tabs");
        } else {
            assertTrue(hiddenTabs, "Hidden tabs is visible");
        }
        return hiddenTabs;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectTabFromPlusButton
     * description ::To select a tab from Plus Button on Profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public void selectTabFromPlusButton(String tabName) throws Throwable {
        List<WebElement> allTabs = getWebElementList(DIHomePage.listOfHiddenTabsInPlusButton, "Hidden Tabs List");
        for (int i = 0; i < allTabs.size(); i++) {
            String tabItems = allTabs.get(i).getText();
            if (tabItems.equalsIgnoreCase(tabName)) {
                Actions action = new Actions(driver);

                action.click(allTabs.get(i));
            }
        }

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyStatusinBeyondETATab
     * description ::To verify which status is available on Beyond ETA Tab
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean verifyStatusinBeyondETATab(String etaStatus) throws Throwable {
        boolean status = isVisibleOnly(DIHomePage.statusInBeyondETATabOnProfileWindow, "Status In BeyondETATab");
        if (status) {
            String statusInETA = getText(DIHomePage.statusInBeyondETATabOnProfileWindow, "Status");
            assertTrue(etaStatus.equalsIgnoreCase(statusInETA), etaStatus + "is found");
        } else {
            assertTrue(status, "Status in BeyondETATab is available");
        }
        return status;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickToMinimizeProfileWindow
     * description ::To minimize the Profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickToMinimizeProfileWindow() throws Throwable {
        boolean minimize = isVisibleOnly(DIHomePage.linkMinimizeProfileWindow, "minimize Button");
        if (minimize) {
            click(DIHomePage.linkMinimizeProfileWindow, "minimize Button");
        } else {
            assertTrue(minimize, "minimize Button visible");
        }
        return minimize;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickToOpenPoppedOutWindow
     * description ::To open popped out Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickToOpenPoppedOutWindow() throws Throwable {
        boolean poppedWindow = isVisibleOnly(DIHomePage.linkProfileWindowPoppedOut, "Poppedout Window");
        if (poppedWindow) {
            click(DIHomePage.linkProfileWindowPoppedOut, "Poppedout Window");
        } else {
            assertTrue(poppedWindow, "Poppedout window visible");
        }
        return poppedWindow;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnGearIconOfProfileWindow
     * description ::To click on gear Icon On profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickOnGearIconOfProfileWindow() throws Throwable {
        boolean gearIcon = isVisibleOnly(DIHomePage.linkSettingsGearIconOnProfileWindow, "Gear Icon");
        if (gearIcon) {
            click(DIHomePage.linkSettingsGearIconOnProfileWindow, "Gear Icon");
        } else {
            assertTrue(gearIcon, "Gear Icon Is visible");
        }
        return gearIcon;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnArrowButtonOfID
     * description ::To click on Arrow button of ID
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickOnArrowButtonOfID() throws Throwable {
        boolean idArrow = isVisibleOnly(DIHomePage.btnIDArrowOfProfileWindow, "Id Arrow Button");
        if (idArrow) {
            click(DIHomePage.btnIDArrowOfProfileWindow, "Id Arrow Button");
        } else {
            assertTrue(idArrow, "ID Arrow button is visible");
        }
        return idArrow;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectFasdfProfileMenuItem
     * description ::To click on fasdf profile in profile Menu
     * date :: 29-12-2017
     * author :: Nidhi
     */
    public boolean selectFasdfProfileMenuItem() throws Throwable {
        click(DIHomePage.lnkUserProfile, "User Profile");
        boolean idArrow = isVisibleOnly(DIHomePage.lnkFasdfProfileOnProfilesMenu, "FasdfProfile");
        if (idArrow) {
            click(DIHomePage.lnkFasdfProfileOnProfilesMenu, "FasdfProfile");
        } else {
            assertTrue(idArrow, "FasdfProfile is visible");
        }
        return idArrow;
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnParamProfileMenuItem
     * description ::To click on param profile in profile Menu
     * date :: 29-12-2017
     * author :: Nidhi
     */
    public boolean clickOnParamProfileMenuItem() throws Throwable {
        click(DIHomePage.lnkUserProfile, "User Profile");
        boolean idArrow = isVisibleOnly(DIHomePage.lnkParamProfileOnProfilesMenu, "Param Profile");
        if (idArrow) {
            click(DIHomePage.lnkParamProfileOnProfilesMenu, "Param Profile");
        } else {
            assertTrue(idArrow, "Param Profile is visible");
        }
        return idArrow;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnQaautoTwoMenuItem
     * description ::To click on qaautotwo profile in profile Menu
     * date :: 29-12-2017
     * author :: Nidhi
     */
    public boolean clickOnQaautoTwoMenuItem() throws Throwable {
        click(DIHomePage.lnkUserProfile, "User Profile");
        boolean idArrow = isVisibleOnly(DIHomePage.lnkQAAutoTwoProfileOnProfilesMenu, "QAAuto2 Profile");
        if (idArrow) {
            click(DIHomePage.lnkQAAutoTwoProfileOnProfilesMenu, "QAAuto2 Profile");
        } else {
            assertTrue(idArrow, "QAAuto2 Profile is visible");
        }
        return idArrow;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveAll
     * description :: clickOnRemoveAll
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnRemoveAll() throws Throwable {
        click(DIHomePage.lnkRemoveAll, "Remove all");

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: getQueueFieldFirstItemInSelected
     * description :: Verify no records found in dispatch queue
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getQueueFieldFirstItemInSelected() throws Throwable {

        String selectedFirstValue = null;
        boolean selectedQueue = isVisibleOnly(DIHomePage.lblQueueFieldFirstItemInSelected, "Dispatch Field Items");
        if (selectedQueue) {
            selectedFirstValue = getText(DIHomePage.lblQueueFieldFirstItemInSelected, "Dispatch Field Value");
            mouseClick(DIHomePage.lblQueueFieldFirstItemInSelected, "Dispatch Field Value");
        } else {
            assertTrue(selectedQueue, "Dispatch Field Value are empty");
        }
        return selectedFirstValue;
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName :: compareDispatchAndSelectedValues
     * description :: Verify no records found in dispatch queue
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public boolean compareDispatchAndSelectedValues(String dispatch, String selected, String source, String Destination) throws Throwable {


        boolean results = dispatch.equalsIgnoreCase(selected);
        assertTrue(results, "The " + source + " value" + dispatch + "is moved to " + Destination + " queue");
        return results;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyDragDropFunctionalityForDispatch
     * description :: verifyDragDropFunctionalityForDispatch
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyDragDropFunctionalityForDispatch() throws Throwable {
        dragAndDrop(DIHomePage.lblQueueFieldFirstItem, DIHomePage.areaSelectedResultsGrid, "Queue Field Item was moved into Selected field");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSpotTab
     * description :: verifyDragDropFunctionalityForDispatch
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnSpotTab() throws Throwable {
        click(DIHomePage.btnSpotTab, "Spot Tab");
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: getSpotQueueFirstFieldValue
     * description :: Retriving Spot Queue First Field Value
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getSpotQueueFirstFieldValue() throws Throwable {
        String spotQueueFirstValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblQueueFirstItemInSpotContainer, "Spot Field Items");
        if (dispatchQueue) {
            spotQueueFirstValue = getText(DIHomePage.lblQueueFirstItemInSpotContainer, "Spot Field Value");
            //clickUntil(DIHomePage.lblQueueFieldFirstItem,DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            click(DIHomePage.lblQueueFirstItemInSpotContainer, "Spot Field Value");
        } else {
            assertTrue(dispatchQueue, "Spot Field Value are empty");
        }
        return spotQueueFirstValue;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: getSpotSelectedQueueFirstFieldValue
     * description :: Retriving Spot Slected Queue First Field Value
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getSpotSelectedQueueFirstFieldValue() throws Throwable {
        String spotSelectedQueueFirstValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblSelectedQueueFirstItemInSpotContainer, "Spot Field Items");
        if (dispatchQueue) {
            spotSelectedQueueFirstValue = getText(DIHomePage.lblSelectedQueueFirstItemInSpotContainer, "Spot Field Value");
            click(DIHomePage.lblSelectedQueueFirstItemInSpotContainer, "Spot Field Value");
        } else {
            assertTrue(dispatchQueue, "Spot Field Value are empty");
        }
        return spotSelectedQueueFirstValue;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: getFieldItemHighlightStatusCountInSpot
     * description :: Getting the size of highlighted field values in Spot
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void getFieldItemHighlightStatusCountInSpot() throws Throwable {
        int records = getElementsSize(DIHomePage.lblHighlightedFieldValueSpot);
        assertTrue(records != 0, records + " records are highlighted");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectAllLinkOnSpotQueueWindow
     * description :: click on Select All link
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnSelectAllLinkOnSpotQueueWindow() throws Throwable {
        click(DIHomePage.lnkSelectAllSpot, "Select All");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInSpot
     * description :: Verify no records found in Spot queue
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInSpotSelected() throws Throwable {

        int records = getElementsSize(DIHomePage.lblSelectedQueueFirstItemInSpotContainer);
        assertTrue(records == 0, records + " records are Available in Selected Queue hence all records are moved into Spot Queue");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInSpot
     * description :: Verify no records found in Spot queue
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInSpotQueue() throws Throwable {

        int records = getElementsSize(DIHomePage.lblQueueFirstItemInSpotContainer);
        assertTrue(records == 0, records + " records are Available in Spot Queue hence all records are moved into Selected Queue");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyDragDropFunctionalityForSpot
     * description :: verifyDragDropFunctionalityForSpot
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyDragDropFunctionalityForSpot() throws Throwable {
        dragAndDrop(DIHomePage.lblQueueFirstItemInSpotContainer, DIHomePage.areaSelectedResultsGrid, "Queue Field Item was moved into Selected field");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyRecordsCountInSpotSelected
     * description :: verifyRecordsCountInSpotSelected
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public int verifyRecordsCountInSpotSelected() throws Throwable {

        int records = getElementsSize(DIHomePage.lstSelectedQueueFields);
        assertTrue(records != 0, records + " records are added into selected Queue");
        return records;
    }

    /**
     * param :: int inputs
     * return ::void
     * throws :: throwable
     * methodName :: compareSavedRecordsSize
     * description :: compareSavedRecordsSize
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void compareSavedRecordsSize(int records, int recordsVerify) throws Throwable {

        assertTrue(records == recordsVerify, "Records are saved successfully");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: escapeSendKeys
     * description :: escapeSendKeys
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void escapeSendKeys() throws Throwable {
        String combineKeys1 = Keys.chord(Keys.ESCAPE);
        sendKeys(combineKeys1, "Esc");

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDispatchQueuePopup
     * description :: clickOnDispatchQueuePopup
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnDispatchQueuePopup() throws Throwable {
        click(DIHomePage.dispatchQueuePopup, "Highlighted Dispatch popup");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnArrowButtonOfDate
     * description ::To click on Arrow button of Date on Profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean clickOnArrowButtonOfDate() throws Throwable {
        boolean dateArrow = isVisibleOnly(DIHomePage.btnDateArrowOfProfileWindow, "Date Arrow Button");
        if (dateArrow) {
            click(DIHomePage.btnDateArrowOfProfileWindow, "Date Arrow Button");
        } else {
            assertTrue(dateArrow, "Date Arrow button is visible");
        }
        return dateArrow;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyLabelPriorityOfIDOnProfileWindow
     * description ::To verify priority label of ID on profile window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean verifyLabelPriorityOfIDOnProfileWindow() throws Throwable {
        boolean priority = isVisibleOnly(DIHomePage.lblPriorityOfIDOnProfileWindow, "Priority label");
        assertTrue(priority, "Priority label is visible");
        return priority;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyLabelOrderOfIDOnProfileWindow
     * description ::To verify priority label of ID on profile window
     * date ::29-12-2017
     * author ::madhukar
     */
    public boolean verifyLabelOrderOfIDOnProfileWindow() throws Throwable {
        boolean order = isVisibleOnly(DIHomePage.lblOrderOfIDOnProfileWindow, "Priority label");
        assertTrue(order, "Order label is visible");
        return order;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectPriority
     * description ::To select priority from ID on Profile Window
     * date ::29-12-2017
     * author ::madhukar
     */
    public void selectPriority(String priority) throws Throwable {
        mouseClick(DIHomePage.drpdwnPriority, "Select priority");
        selectByValue(DIHomePage.drpdwnPriority, priority, "Select priority");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectOrder
     * description ::To select Order from ID on Profile Window
     * date ::29-12-2017
     * author ::Madhukar
     */
    public void selectOrder(String order) throws Throwable {
        mouseClick(DIHomePage.drpdwnOrder, "Select order");
        selectByVisibleText(DIHomePage.drpdwnOrder, order, "Select order");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonOfIDAndDateOnProfileWindow
     * description ::
     * date ::29-12-2017
     * author ::Madhukar
     */
    public boolean clickOnSaveButtonOfIDAndDateOnProfileWindow() throws Throwable {
        boolean save = isVisibleOnly(DIHomePage.btnSaveOfIDAndDateOnProfileWindow, "Save button of ID and Date");
        if (save) {
            click(DIHomePage.btnSaveOfIDAndDateOnProfileWindow, "Save button of ID and date");
        } else {
            assertTrue(save, "Save button of ID is visible");
        }
        return save;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectDescendingOrderFromDate
     * description ::To select Descending Order from date in Profile Window
     * date ::
     * author ::
     */
    public void selectDescendingOrderFromDate(String descOrder) throws Throwable {
        selectByVisibleText(DIHomePage.drpdwnDescendindOrder, descOrder, "Select priority");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateIdPriorityOrder
     * description :: This method validates wether ID displays with a "1" next to it to indicate it's priority order
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateIdPriorityOrder(String columnname) throws Throwable {
        String priorityNumber;
        if (columnname == "ID") {
            priorityNumber = getText(DIHomePage.txtIDvalue, "ID Priority Number");
        } else {
            priorityNumber = getText(DIHomePage.txtDateValue, "Date Priority Number");
        }
        assertTrue(priorityNumber == "1", columnname + " now displays with a '1' next to it to indicate it's priority order");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateAscendingDescendingIcons
     * description :: To validate ascending descending icon
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public boolean validateAscendingDescendingIcons() throws Throwable {
        boolean iconAscending = isElementPresent(DIHomePage.iconSortAscensing, "Click On CallIdOrDate Link");
        boolean iconDescending = isElementPresent(DIHomePage.iconSortDescending, "Click On CallIdOrDate Link");
        assertTrue((iconAscending && iconDescending), "Profile window columns have tiny triangles to indicate ascending and descending sorting");
        return iconAscending;

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnActionRequiredTabInProfileWindow
     * description :: To click on Action Required tab in profilr window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void clickOnActionRequiredTabInProfileWindow() throws Throwable {
        clickUntil(DIHomePage.tabActionRequired, DIHomePage.tabActionRequired, "Action Required Tab");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateAscendingOrderofColumn
     * description :: This function validate Ascending order in Profile window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public boolean validateAscendingOrderofColumn() throws Throwable {
        boolean iconAescending = isElementPresent(DIHomePage.iconSortAscensingInProfileWindow, "Ascending Order icon in ID column of Profile window");
        assertTrue(iconAescending, "Ascending order is verified");
        return iconAescending;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateDescendingOrderofColumn
     * description :: This function validate descending order  in Profile window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public boolean validateDescendingOrderofColumn() throws Throwable {
        boolean iconDescending = isVisibleOnly(DIHomePage.iconSortDescendingInProfileWindow, "Ascending Order icon in ID column of Profile window");
        if (iconDescending) {
            click(DIHomePage.callIdInProfileMenu, "ID Column In profile Window");
        }
        assertTrue(!iconDescending, "Descending order is verified");
        return iconDescending;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateDescendingOrderofColumn
     * description :: This function validate sorting removed in Profile window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public boolean validateSortingIsRemoved() throws Throwable {
        boolean iconAescending = isVisibleOnly(DIHomePage.iconSortAscensingInProfileWindow, "iCon Sorting");
        assertTrue(iconAescending, "Sorting is removed from the column ");
        return iconAescending;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveSettingsButtonOfProfileWindow
     * description ::To click on save settings button on Profile window
     * date :: 01-01-2018
     * author :: Madhukar
     */
    public boolean clickOnSaveSettingsButtonOfProfileWindow() throws Throwable {
        boolean saveSettings = isVisibleOnly(DIHomePage.btnSaveSettingsInProfileWindow, "Save Settings Button");
        if (saveSettings) {
            click(DIHomePage.btnSaveSettingsInProfileWindow, "Save Settings Button");
        } else {
            assertTrue(saveSettings, "Save Settings button is visible");
        }
        return saveSettings;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallIDColumnOfProfileWindow
     * description :: To click on Call ID Column Of Profile Window
     * date :: 01-01-2018
     * author ::Madhukar
     */
    public boolean clickOnCallIDColumnOfProfileWindow() throws Throwable {
        boolean callIdColumn = isVisibleOnly(DIHomePage.iconSortDescendingInProfileWindow, "ID Column In profile Window");
        if (callIdColumn) {
            click(DIHomePage.callIdInProfileMenu, "ID Column In profile Window");
        }
        return callIdColumn;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectUserProfileMenuItem
     * description :: selectUserProfileMenuItem
     * date :: 01-01-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void selectUserProfileMenuItem() throws Throwable {
        mouseClick(DIHomePage.lnkApplicationMenu, "Application Menu");
        click(DIHomePage.lnkUserProfile, "User Selection Selection ");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonOnUserProfileWindow
     * description :: clickOnCloseButtonOnUserProfileWindow
     * date :: 01-01-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnCloseButtonOnUserProfileWindow() throws Throwable {

        click(DIHomePage.btnCloseOnUserProfile, "Close button ");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAllCallsTab
     * description :: To click on All Calls Tab Of Profile Window
     * date ::01-01-2018
     * author ::Madhukar
     */
    public void clickOnAllCallsTab() throws Throwable {
        boolean allCallsTab = isVisibleOnly(DIHomePage.tabAllCalls, "AllCalls Tab");
        click(DIHomePage.tabAllCalls, "AllCalls Tab");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyIdTextOnprofileWindow
     * description :: To verify ID text on profile window
     * date ::02-02-2018
     * author ::Cigniti
     */

    public void verifyIdTextOnprofileWindow(String txt_id) throws Throwable {
        boolean idText = isVisibleOnly(DIHomePage.txtIDvalue, "ID Text");
        String idValue = getText(DIHomePage.txtIDvalue, "ID Text");
        assertTrue(idValue.equalsIgnoreCase(txt_id), "ID Priority Order is Verified");


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyDateTextOnprofileWindow
     * description :: To verify Date text on profile window
     * date ::02-02-2018
     * author ::Cigniti
     */
    public void verifyDateTextOnprofileWindow(String txt_date) throws Throwable {
        boolean dateText = isVisibleOnly(DIHomePage.txtDateValue, "Date Text");
        String dateValue = getText(DIHomePage.txtDateValue, "Date Text");
        assertTrue(dateValue.equalsIgnoreCase(txt_date), "Date Priority Order is Verified");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumberInfo
     * description :: To enter member number in textBox
     * date ::02-02-2018
     * author :: Nidhi
     */
    public void enterMemberNumberInfo(String MemberNumber) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtSearchMemberNumber, "Click on Member Number Field");
        click(DIHomePage.txtSearchMemberNumber, "Click on Member Number Field");
        waitForVisibilityOfElement(DIHomePage.txtSearchMemberNumber, "Type MemberNumber");
        System.out.println(MemberNumber);
        type(DIHomePage.txtSearchMemberNumber, MemberNumber, "Type MemberNumber");
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyStatusinRedFlagTab
     * description :: To verify which status is available on Red Flag Tab
     * date ::02-02-2018
     * author :: Nidhi
     */
    public boolean verifyStatusinRedFlagTab() throws Throwable {
        boolean status = isVisibleOnly(DIHomePage.statusInRedFlagTabOnProfileWindow, "Status In RedFlagcallTab");
        if (status) {
            String statusInRedFlag = getText(DIHomePage.statusInRedFlagTabOnProfileWindow, "Status");
            assertTrue(status, statusInRedFlag + "is Found");
        } else {
            assertTrue(status, "Status in RedFlagcallTab is available");

        }
        return status;
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRedFlagCalls
     * description :: :To select an Tab  from a click On RedFlagCalls
     * date ::02-02-2018
     * author :: Nidhi
     */
    public void clickOnRedFlagCalls() throws Throwable {
        click(DIHomePage.lnkRedFlagInHiddenTabOne, "RedFlag Calls Link");
    }


    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectAllDispatchCallsAddAndContinueInQueueSelection
     * description :: To select all dispatch items in Quesue selection popup,click on add and continue.
     * date :: 01-Jan-2018
     * author :: Nidhi
     */
    public void selectAllDispatchCallsAddAndContinueInQueueSelection() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.dispatch, "click on dispatch");
        click(DIHomePage.dispatch, "click on dispatch");

        waitForVisibilityOfElement(DIHomePage.selectAll, "click on selectAll");
        click(DIHomePage.selectAll, "click on selectAll");

        waitForVisibilityOfElement(DIHomePage.add, "click on add");
        click(DIHomePage.add, "click on add");

        waitForVisibilityOfElement(DIHomePage.btnContinue, "click on continue");
        click(DIHomePage.btnContinue, "click on continue");
        Thread.sleep(4000);

    }


    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyRedFlagCallID
     * description :: To verify Red Flag CallId in RedflagCall Tab in Profile window
     * date :: 03-Jan-2018
     * author :: Nidhi
     */

    public void verifyRedFlagCallID(String callIDWithRedFlag) throws Throwable {
        Thread.sleep(2000);
        click(DIHomePage.idInRedFlagTabInProfileWindow, "RedFlagCallHiddenTab");
        List<WebElement> allID = getWebElementList(DIHomePage.idInRedFlagTabInProfileWindow, "CallID List");
        for (int i = 0; i < allID.size(); i++) {

            String CallIDItems = allID.get(i).getText();
            Thread.sleep(2000);

            if (CallIDItems.equalsIgnoreCase(callIDWithRedFlag)) {
                assertTrue(true, "<b>Red Flag Call is Located. Call ID is " + CallIDItems);
            }
        }

    }


    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyNonRedFlagCallID
     * description ::  To verify Non Red Flag CallId in RedflagCall Tab in Profile window
     * date :: 03-Jan-2018
     * author :: Nidhi
     */

    public void verifyNonRedFlagCallID(String callID) throws Throwable {
        List<WebElement> allID = getWebElementList(DIHomePage.idInRedFlagTabInProfileWindow, "CallID List");
        for (int i = 0; i < allID.size(); i++) {
            String CallIDItems = allID.get(i).getText();
            assertFalse(CallIDItems.equalsIgnoreCase(callID), "Call is Located" + callID);
        }
        Thread.sleep(2000);
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectRedFlagCallTabOnHiddenTab
     * description :: To select RedFlag Call On Hidden Tab
     * date :: 03-Jan-2018
     * author :: Nidhi
     */

    public void selectRedFlagCallTabOnHiddenTab() throws Throwable {
        boolean RedFlagCallHiddenTab = isVisibleOnly(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallTab");
        if (RedFlagCallHiddenTab) {
            click(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallHiddenTab");
        } else {
            clickOnTabPlusButton();
            selectRedFlagCallTabOnPlusIcon();
        }

    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectRedFlagCallTabOnPlusIcon
     * description :: To select RedFlag Call on Plus Tab in Profile window
     * date :: 03-Jan-2018
     * author :: Nidhi
     */
    public void selectRedFlagCallTabOnPlusIcon() throws Throwable {
        boolean RedFlagCallPlusIcon = isVisibleOnly(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallTab");
        if (RedFlagCallPlusIcon) {
            click(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallHiddenTab");
        }
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnTabNextToAllCallsInProfileWindow
     * description::This method is used to click on tab next to all calls tab
     * date ::03-01-2017
     * author :: Madhukar
     */
    public boolean clickOnTabNextToAllCallsInProfileWindow() throws Throwable {
        boolean nextTab = isVisibleOnly(DIHomePage.tabNextToAllCallsTab, "Action Required Tab");
        if (nextTab) {
            click(DIHomePage.tabNextToAllCallsTab, "Action Required Tab");
        } else {
            assertTrue(nextTab, "Action Required Tab is visible");
        }
        return nextTab;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyTinyPointerPointingUp
     * description::This method is used to verify pointer in call is pointing up in tab next to all call Tab
     * date ::03-01-2017
     * author :: Madhukar
     */
    public boolean verifyTinyPointerPointingUp() throws Throwable {
        boolean pointingUp = isVisibleOnly(DIHomePage.iconSortAscensing, "Icon pointing up");
        assertTrue(pointingUp, "Verified Icon Pointing Up");
        return pointingUp;
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectBeyonETATabOnPlusIcon
     * description::This method is used to select BeyondETA Tab from hidden Tabs
     * date ::03-01-2017
     * author :: Madhukar
     */
    public void selectBeyonETATabOnHiddenTab() throws Throwable {
        boolean ETAHiddenTab = isVisibleOnly(DIHomePage.lnkBeyondETAUnderHiddenTab, "ETA Tab");
        if (ETAHiddenTab) {
            click(DIHomePage.lnkBeyondETAUnderHiddenTab, "ETA Tab in Hidden");
        } else {
            clickOnTabPlusButton();
            selectBeyonETATabOnPlusIcon();
        }

    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectBeyonETATabOnPlusIcon
     * description::This method is used to select BeyondETA Tab from plus button icon
     * date ::03-01-2017
     * author :: Madhukar
     */
    public boolean selectBeyonETATabOnPlusIcon() throws Throwable {
        boolean ETAPlusIcon = isVisibleOnly(DIHomePage.lnkBeyodETAUnderAddMenuIcon, "ETA Tab");
        if (ETAPlusIcon) {
            click(DIHomePage.lnkBeyodETAUnderAddMenuIcon, "ETA Tab in Plus Icon");
        } else {
            assertTrue(false, "ETA Tab Found");
        }
        return ETAPlusIcon;

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnParamUnderProfileMenu
     * description::This method is used to click on param profile under profile dropdown
     * date ::04-01-2017
     * author :: Madhukar
     */
    public boolean clickOnParamUnderProfileMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkParamProfileOnProfilesMenu, "Param under Profile Menu");
        boolean param = isVisibleOnly(DIHomePage.lnkParamProfileOnProfilesMenu, "Param under Profile Menu");
        if (param) {
            click(DIHomePage.lnkParamProfileOnProfilesMenu, "Param under Profile Menu");
        } else {
            assertTrue(param, "param is found");
        }
        return param;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnParamWindow
     * description::This method is used to click on param window
     * date ::04-01-2017
     * author :: cigniti
     */
    public boolean clickOnParamWindow() throws Throwable {
        boolean paramWindow = isVisibleOnly(DIHomePage.paramWindow, "param window");
        if (paramWindow) {
            click(DIHomePage.paramWindow, "param window");
        } else {
            assertTrue(paramWindow, "param window is found");
        }
        return paramWindow;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickToCloseProfileWindow
     * description::This method is used to Close Profile Window
     * date ::04-01-2017
     * author :: cigniti
     */
    public boolean clickToCloseProfileWindow() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkcloseProfileWindow, "close profile");
        boolean close = isVisibleOnly(DIHomePage.lnkcloseProfileWindow, "close profile");
        if (close) {
            click(DIHomePage.lnkcloseProfileWindow, "close profile");
        } else {
            assertTrue(close, "close button is found");
        }
        return close;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectQueuesandClickOnSearchCall
     * description::selectQueuesandClickOnSearchCall
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void selectQueuesandClickOnSearchCall() throws Throwable {
        clickOnContinueQueuesInDispatch();
        clickOnSearchCallsInDispatch();
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnFacilityPTA
     * description ::This method is used to close facility PTA pop up
     * date :: 12-01-2018
     * author :: Cigniti
     */
    public boolean clickOnCloseIconOnFacilityPTA() throws Throwable {

        waitForVisibilityOfElement(DIHomePage.iconCloseOnFacilityPTA, "Cancel Button is Available");

        boolean closeIconOnQueueSelection = isVisibleOnly(DIHomePage.iconCloseOnFacilityPTA, "Close icon is Available");
        if (closeIconOnQueueSelection) {

            click(DIHomePage.iconCloseOnFacilityPTA, "Close Icon Queue Selection");
        } else {
            assertTrue(closeIconOnQueueSelection, "Close Icon is appeared");
        }
        return closeIconOnQueueSelection;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstCallIdInSearchCallsTable
     * description ::This method is used to select an first  callId from search call table
     * date :: 12-01-2018
     * author :: Cigniti
     */
    public boolean clickOnFirstCallIdInSearchCallsTable() throws Throwable {
        boolean callId = isVisibleOnly(DIHomePage.lnkFirstCallIdInDI, "First Call Id Link");
        if (callId) {
            click(DIHomePage.lnkFirstCallIdInDI, "First Call Id Link");
        } else {
            assertTrue(callId, "call id link found");
        }
        return callId;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyHyperLinkOnMessagePopup
     * description ::This method is used to verify Hyper link on Message popup
     * date :: 17-01-2018
     * author :: Cigniti
     */
    public boolean verifyHyperLinkOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
        boolean messagePopup = isVisibleOnly(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
        return messagePopup;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHyperLinkOfMessagePopup
     * description ::This method is used to click on hyper link on call id in message popup
     * date :: 17-01-2018
     * author :: Cigniti
     */
    public void clickOnHyperLinkOfMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
        click(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpotFacilityIDInfo
     * description :: To eter spot facility Id info on truckload
     * date :: 16-Jan-2018
     * author :: Abhiram
     */
    public void enterSpotFacilityIDInfoOnTruckLoad(String spotFacilityID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        click(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Type Spot Facility ID");
        System.out.println(spotFacilityID);
        type(DIHomePage.txtFacilityIDOnTruckLoad, spotFacilityID, "Type SpotfacilityID");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSpotFacilityOntruckLoadTextBox
     * description ::To click On Spot Facility On truckLoad TextBox
     * date :: 16-Jan-2018
     * author :: Abhiram
     */

    public void clickOnSpotFacilityOntruckLoadTextBox() throws Throwable {
        click(DIHomePage.lnkFacilityIDOnTruckLoad, "Spot Facility ID");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectCallIDOnTruckLoad
     * description ::To search And Select CallID On TruckLoad
     * date :: 16-Jan-2018
     * author :: Abhiram
     */
//Double click on Call Id
    public void searchAndSelectCallIDOnTruckLoad(String CallID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callIdInTruckLoadMenu, "CallId in TruckLoad");
        allCallIds = getWebElementList(DIHomePage.lblCallIDResultsInTruckLoadWindow, "CallId in TruckLoad");
        if (allCallIds != null) {
            for (int i = 0; i <= allCallIds.size(); i++) {
                String callIdFromList = allCallIds.get(i).getText();
                if (CallID.equals(callIdFromList)) {
                    Actions action = new Actions(driver);
                    action.doubleClick(allCallIds.get(i)).build().perform();
                }
                allCallIds = getWebElementList(DIHomePage.lblCallIDResultsInTruckLoadWindow, "CallId in TruckLoad");
            }
        }
    }

    /* *
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMessagePopUpButton
     * description ::This method is used to verify ET status on Message popup
     * date :: 17-01-2018
     * author :: Madhukar
     */
    public String verifyETStatusOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblETStatusOnMessagePopup, "ET Status");
        String et = getText(DIHomePage.lblETStatusOnMessagePopup, "ET Status");
        return et;

    }

    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMessagePopUpButton
     * description ::This method is used to click on call ID In Message Popup
     * date :: 27-feb-2018
     * author :: Cigniti
     */
    public void clickOnCallIDOfMessagePopUp(String callId) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.linkCallIDOnMessagePopUp(callId), "" + callId);
        click(DIHomePage.linkCallIDOnMessagePopUp(callId), "" + callId);
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMessagePopUpButton
     * description ::To click On Message PopUp Button
     * date :: 27-feb-2018
     * author :: Cigniti
     */
    public void clickOnMessagePopUpButton() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkMessagePopup, "message popup window");
        click(DIHomePage.lnkMessagePopup, "message popup window");
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clearAllMessagesInMessagepopup
     * description ::This method is used to clear all messages In Message Popup
     * date :: 27-feb-2018
     * author :: Cigniti
     */
    public void clearAllMessagesInMessagepopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.chkBoxMessagesInMessagepopup, "Message Popup Checkbox");
        click(DIHomePage.chkBoxMessagesInMessagepopup, "Message Popup Checkbox");
        click(DIHomePage.btnAcknowledgeOnMesssagepopup, "Acknowledge button");
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: searchAndClickOnCallIdOnProfileWindow
     * description ::This is used to sort the data in decending order
     * date :: 19-01-2018
     * author :: Cigniti
     */
    public void dateDecendingOrder() throws Throwable {
        clickUntil(DIHomePage.lblDateHeaderInTruckLoad, DIHomePage.iconDesendingOrderForDate, "Date Decending Order");
    }

    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchAndClickOnCallIdOnProfileWindow
     * description ::To search And Click On CallId On Profile Window
     * date :: 19-01-2018
     * author :: Cigniti
     */
    public void searchAndClickOnCallIdOnProfileWindow(String callIDAndDate) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callIDInProfileTab(callIDAndDate), "Click On CallId On Profile Tab");
        mouseJSDoubleClick(DIHomePage.callIDInProfileTab(callIDAndDate), "Click On CallId On Profile Tab");
    }

    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchAndClickOnCallIdOnTruckloadWindow
     * description ::To  search And Click On CallId On Truckload Window
     * date :: 19-01-2018
     * author :: Cigniti
     */
    public void searchAndClickOnCallIdOnTruckloadWindow(String callIDAndDate) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callIDInTruckLoadTab(callIDAndDate), "Click On CallId On TruckLoad Tab");
        mouseJSDoubleClick(DIHomePage.callIDInTruckLoadTab(callIDAndDate), "Click On CallId On TruckLoad Tab");
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseiconOnSpotfacilityOnTruckLoad
     * description ::To click On Close icon On Spot facility On TruckLoad
     * date :: 27-feb-2018
     * author :: Cigniti
     */
    public void clickOnCloseiconOnSpotfacilityOnTruckLoad() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkCloseSpotFacilityOnTruckLoad, "Close on Spot facility");
        click(DIHomePage.lnkCloseSpotFacilityOnTruckLoad, "Close on Spot facility");
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckLoadCloseWindow
     * description ::To click On TruckLoad Close Window
     * date :: 27-feb-2018
     * author :: Cigniti
     */

    public void clickOnTruckLoadCloseWindow() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkCloseIconOnTruckLoad, "Close on Close TruckLoad Window");
        click(DIHomePage.lnkCloseIconOnTruckLoad, "Close on Close TruckLoad Window");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnOpenNewProfile
     * description::To click On Open New Profile
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnOpenNewProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtOpenNewProfile, "Open New Profile");
        click(DIHomePage.txtOpenNewProfile, "Open New Profile");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveOnlyInDispatch
     * description ::To enter Call Type As Live Only In Dispatch
     * date :: 29-jan-2017
     * author ::Ravi
     */
    public void enterCallTypeAsLiveOnlyInDispatch(String LiveOnly) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.selectCallsType, "select Calls as live calls");
        type(DIHomePage.selectCallsType, LiveOnly, "Search Calls live calls");
        Thread.sleep(2000);
        getText(DIHomePage.selectCallsType, "Search Calls live calls");
        Thread.sleep(1000);
    }

    public void clickonCloseInTruckLoad() throws Throwable {
        clickOnCloseiconOnSpotfacilityOnTruckLoad();
        clickOnTruckLoadCloseWindow();
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: openDiApplication
     * description :: To open Di Application
     * date :: 29-jan-2017
     * author ::Ravi
     */
    public void openDiApplication() throws Throwable {
        if (isVisibleOnly(DIHomePage.lblOkeyAfterLogout, "lblOkeyAfterLogout")) {
            click(DIHomePage.lblOkeyAfterLogout, "lblOkeyAfterLogout");
            openURLInNewTab("https://qaautoap1.national.aaa.com:8443/D3Dispatch/login.jsp");
        } else {
            openURLInNewTab("https://qaautoap1.national.aaa.com:8443/D3Dispatch/login.jsp");
        }


    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::clickOnProfileName
     * description::To clcik on profile name
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnProfileName(String profile) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.profileNameInProfileList(profile), "select Calls as live calls");
        click(DIHomePage.profileNameInProfileList(profile), "Profile");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyActionReqTabOnProfile
     * description::To verify Action Req Tab On Profile
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void verifyActionReqTabOnProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelActionReqTab, "Action Required Tab");

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickActionReqTabOnProfile
     * description::To click ActionReq Tab On Profile
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickActionReqTabOnProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelActionReqTab, "Action Required Tab");
        click(DIHomePage.labelActionReqTab, "Action Required Tab");
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::verifyCallIdOnProfileWindow
     * description::To verify CallId On Profile Window
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public Boolean verifyCallIdOnProfileWindow(String callID, String calldate) throws Throwable {
        Boolean callDisplayOnReqActionTab = waitForVisibilityOfElement(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
        return callDisplayOnReqActionTab;
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::clickCallIdOnProfileWindow
     * description::To click CallId On Profile Window
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickCallIdOnProfileWindow(String callID, String calldate) throws Throwable {

        if (waitForVisibilityOfElement(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab")) {
            mouseJSDoubleClick(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
        }
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::getCallIdStatusOnProfileWindowOfActionReqTab
     * description::To get CallId Status On Profile Window Of ActionReq Tab
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String getCallIdStatusOnProfileWindowOfActionReqTab(String callID, String calldate) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.getcallIDStatusInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
        String status = getText(DIHomePage.getcallIDStatusInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
        return status;
    }


    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::verifyCallIdIsNotOnProfileWindow
     * description::To verify CallId Is Not On ProfileWindow
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public Boolean verifyCallIdIsNotOnProfileWindow(String callID, String calldate) throws Throwable {
        Boolean callDisplayOnReqActionTab = waitForInVisibilityOfElement(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
        return callDisplayOnReqActionTab;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getTextDispatchTitle
     * description ::To get Text Dispatch Title
     * date :: 5-feb-2017
     * author ::Ravi
     */
    public String getTextDispatchTitle() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblDispathTitle, "dispatch title");
        String dispatchLogin = getText(DIHomePage.lblDispathTitle, "Dispatch title");
        /*{
            reporter.SuccessReport("Successfully Navigated to ","Dispatch page");
        }
        Thread.sleep(1000);*/
        return dispatchLogin;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDateOnSearchCallsWindow
     * description ::To enter Start Date On Search Calls Window
     * date :: 06-feb-2018
     * author ::Ravi
     */
    public void enterStartDateOnSearchCallsWindow(String StartDate) throws Throwable {

        waitForVisibilityOfElement(DIHomePage.txtStartDateOnSearchCallWindow, "Search Calls Window Start date");
        type(DIHomePage.txtStartDateOnSearchCallWindow, StartDate, "Search Calls Window Start date");
        Thread.sleep(3000);

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndDateOnSearchCallsWindow
     * description ::To enter EndDate On Search Calls Window
     * date :: 06-feb-2018
     * author ::Ravi
     */
    public void enterEndDateOnSearchCallsWindow(String EndDate) throws Throwable {

        waitForVisibilityOfElement(DIHomePage.txtEndDateInSearchCallWindow, "Search Calls Window End date");
        type(DIHomePage.txtEndDateInSearchCallWindow, EndDate, "Search Calls Window End date");
        Thread.sleep(3000);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnResetDefaultSettingOnProfileTab
     * description ::clickOnResetDefaultSettingOnProfileTab
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnResetDefaultSettingOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkResetSetting, "Reset Settings");
        click(DIHomePage.lnkResetSetting, "Reset Settings");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyMessagePopUpOnDispatchHomepage
     * description:: verifyMessagePopUpOnDispatchHomepage
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickMessagePopUpOnDispatchHomepage() throws Throwable {
        if (isVisibleOnly(DIHomePage.lnkMessagesTabOnMessagePopUp, "Message PopUp")) {
        } else {
            click(DIHomePage.lnkMessagePopup, "Message popup link");
        }
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::popOutAndPopInMessagePopUpWindow
     * description::popOutAndPopInMessagePopUpWindow
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void popOutAndPopInMessagePopUpWindow() throws Throwable {
        isVisibleOnly(DIHomePage.lnkPopoutForMessagePopUp, "Message Popin and Popout");
        click(DIHomePage.lnkPopoutForMessagePopUp, "Message Popin and Popout");

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnNewMessageTab
     * description::clickOnNewMessageTab
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnNewMessageTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkNewMessageTabOnMessagePopUp, "New Message Tab");
        click(DIHomePage.lnkNewMessageTabOnMessagePopUp, "New Message Tab");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnAddressBookTab
     * description::To click on address book tab
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnAddressBookTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.addressBookTabOnMessagePopUp, "Address Book Tab");
        click(DIHomePage.addressBookTabOnMessagePopUp, "Address Book Tab");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyListOfUsersOnAddressBook
     * description::verifyListOfUsersOnAddressBook
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyListOfUsersOnAddressBook() throws Throwable {
        boolean listOfUsers = isVisibleOnly(DIHomePage.listOfUsersOnAddressBookOnMessagepopup, "List of Users and groups");
        List<WebElement> allUsers = getWebElementList(DIHomePage.listOfUsersOnAddressBookOnMessagepopup, "List of Users and groups ");
        if (allUsers.size() != 0) {
            List<String> webList = new ArrayList<>();
            for (int i = 0; i < allUsers.size(); ++i) {
                webList.add(allUsers.get(i).getText());
            }
            System.out.println(webList);
            reporter.SuccessReport("List Of Users and groups", "" + webList);
        }

        return listOfUsers;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyUserButtonIsHighligted
     * description::verifyUserButtonIsHighligted
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyUserButtonIsHighligted() throws Throwable {
        boolean userbutton = isElementPresent(DIHomePage.rdbtnUserButtonHighlighted, "User Button is Highlighted");
        return userbutton;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectCallTakerUserFromMessagePopup
     * description::select CallTaker User From Message Popup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void selectCallTakerUserFromMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callTakerUserOnMessagePopUp, " Call Taker user");
        click(DIHomePage.callTakerUserOnMessagePopUp, "Call Taker user");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnAddRecipientButtonOnMessagePopup
     * description::click On Add Recipient Button On Message Popup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnAddRecipientButtonOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnAddRecipientOnMessagePopUp, "Add Recipient button");
        click(DIHomePage.btnAddRecipientOnMessagePopUp, "Add Recipient button");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnSendButtonOnMessagePopup
     * description::click On SendButton On Message Popup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnSendButtonOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnSendMessage, "Send button");
        click(DIHomePage.btnSendMessage, "Send button");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyMessageTextFieldturnsRed
     * description::verifyMessageTextFieldturnsRed
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyMessageTextFieldturnsRed() throws Throwable {
        boolean txtError = isVisibleOnly(DIHomePage.lblMessageTextBoxError, "Text Turns Red");
        getText(DIHomePage.lblMessageTextBoxError, "Text Turns Red");
        return txtError;
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::enterMessageInMessageTextBox
     * description::enterMessageInMessageTextBox
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void enterMessageInMessageTextBox(String message) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtMessageTextBox, "Message Text Box");
        click(DIHomePage.txtMessageTextBox, "Message Text Box");
        type(DIHomePage.txtMessageTextBox, message, "Message Text Box");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::getCharacterslimitCount
     * description::getCharacterslimitCount
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String getCharacterslimitCount() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblCharactersRemaining, "Characters limit");
        String count = getText(DIHomePage.lblCharactersRemaining, "Characters limit");
        return count;

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyMessageTextBoxCharacterslimit
     * description::verifyMessageTextBoxCharacterslimit
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void verifyMessageTextBoxCharacterslimit() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblCharactersRemaining, "Characters limit");
        getText(DIHomePage.lblCharactersRemaining, "Characters limit");

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyNewMessageWindowClosedAndMessageWindowInFocus
     * description::verifyNewMessageWindowClosedAndMessageWindowInFocus
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyNewMessageWindowClosedAndMessageWindowInFocus() throws Throwable {
        boolean messageTab = isVisibleOnly(DIHomePage.lnkMessagesTabOnMessagePopUp, "Message Window");
        return messageTab;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectDispatchUserFromMessagePopup
     * description::selectDispatchUserFromMessagePopup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void selectDispatchUserFromMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");
        click(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyMessageSentAndViewedByRecipient
     * description::verifyMessageSentAndViewedByRecipient
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String verifyMessageSentAndViewedByRecipient() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblMessageOnMessagePopUp, "Message Received");
        String message = getText(DIHomePage.lblMessageOnMessagePopUp, "Message Received");
        return message;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnGropsRadioButtonOnMessagePopup
     * description::clickOnGropsRadioButtonOnMessagePopup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnGropsRadioButtonOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.rdbtnGroupOnMessagePopUp, "Groups Radio button");
        click(DIHomePage.rdbtnGroupOnMessagePopUp, "Groups Radio button");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectGroupFromMessagePopup
     * description::selectGroupFromMessagePopup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String selectGroupFromMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.recipientGroupOnMessagePopUp, "Recipient from Group");
        String recipient = getText(DIHomePage.lblARISECRGroupOnMessagePopup, "Recipient from Group");
        click(DIHomePage.recipientGroupOnMessagePopUp, "Recipient from Group");
        return recipient;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyGroupAddedToRecipient
     * description::verifyGroupAddedToRecipient
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String verifyGroupAddedToRecipient() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblRecipientOnNewmessageTab, "Recipient from Group");
        String recipient = getText(DIHomePage.lblRecipientOnNewmessageTab, "Recipient from Group");
        return recipient;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnCheckForReplyingMessage
     * description::clickOnCheckForReplyingMessage
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnCheckForReplyingMessage() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.chkboxFirstMessageInMessagePopUp, "Message Check box");
        click(DIHomePage.chkboxFirstMessageInMessagePopUp, "Message Check box");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnreplybuttonOnMessagePopup
     * description::clickOnreplybuttonOnMessagePopup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnreplybuttonOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnReplyOnMessagePopUp, "Reply Button");
        click(DIHomePage.btnReplyOnMessagePopUp, "Reply Button");
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyNoMessagesOnMessagePopup
     * description::verifyNoMessagesOnMessagePopup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyNoMessagesOnMessagePopup() throws Throwable {
        boolean messages = isVisibleOnly(DIHomePage.lblNoMessageFound, "Messages on Message Popup");
        getText(DIHomePage.lblNoMessageFound, "Messages on Message Popup");
        return messages;
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveAllOnPrifileTab
     * description ::clickOnRemoveAllOnProfileTab
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnRemoveAllOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkRemoveAllProfileWindow, "Remove All");
        click(DIHomePage.lnkRemoveAllProfileWindow, "Remove All");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnZoneOnProfileTab
     * description ::clickOnZoneOnProfileTab
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnZoneOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkZoneProfileWindow, "Zone On Profile Tab");
        click(DIHomePage.lnkZoneProfileWindow, "Zone On Profile Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFilterInProfileWindow
     * description ::enterFilterInProfileWindow
     * date :: 06-feb-2018
     * author ::cigniti
     */
    public void enterFilterInProfileWindow(String filter) throws Throwable {

        waitForVisibilityOfElement(DIHomePage.txtFilterInProfileWindow, "Filter");
        type(DIHomePage.txtFilterInProfileWindow, filter, "Filter");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnZoneOnProfileTab
     * description ::clickOnIDOnProfileTab
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnIDOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkIDInUnselectedProfileWindow, "ID On Profile Tab");
        click(DIHomePage.lnkIDInUnselectedProfileWindow, "ID On Profile Tab");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnZoneOnProfileTab
     * description ::clickOnDateOnProfileTab
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnDateOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkDateInUnselectedProfileWindow, "Date On Profile Tab");
        click(DIHomePage.lnkDateInUnselectedProfileWindow, "Date On Profile Tab");
    }


    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddOnProfileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnAddOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnAddInProfileWindow, "Add On Profile Tab");
        click(DIHomePage.btnAddInProfileWindow, "Add On Profile Tab");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnExpandOptionFromGroup
     * description::clickOnExpandOptionFromGroup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnExpandOptionFromGroup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.iconPlusOnGroupsOnMessagepopup, "Plus Icon");
        click(DIHomePage.iconPlusOnGroupsOnMessagepopup, "Plus Icon");
        Thread.sleep(2000);
       /* String user = getText(DIHomePage.lblDispatchUserOnMessagePopup, "Dispatch User");
        click(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");*/
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::removeRecipientFormMessagePopUp
     * description::removeRecipientFormMessagePopUp
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void removeRecipientFormMessagePopUp() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkRemoveRecipient, "Remove Recipient");
        click(DIHomePage.lnkRemoveRecipient, "Remove Recipient");
    }

    public void CloseLogoutAlert() throws Throwable {
        boolean exist = isVisibleOnly(LoginPage.txtLoginName, "Login User Name");
        int counter = 0;
        while (!exist) {
            acceptAlert();
            Thread.sleep(5000);
            exist = isVisibleOnly(LoginPage.txtLoginName, "Login User Name");
            if (exist) {
                break;
            }
            if (counter > 10) {
                break;
            }
            counter = counter + 1;
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectedQueue
     * description ::clickOnSelectedQueue
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnSelectedQueue() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.deleteSelectedQueues, "Select Queue from Selected Queues");
        click(DIHomePage.deleteSelectedQueues, "Select Queue from Selected Queues");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyFavoriteCallFromProfileMenu
     * description ::verifyFavoriteCallFromProfileMenu
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public boolean verifyFavoriteCallFromProfileMenu(String callIdAndDate) throws Throwable {
        boolean favoriteFlag;
        boolean favoritesFlag = isVisibleOnly(DIHomePage.nofavoriteCalls, "No Favorites Calls");
        if (favoritesFlag) {
            assertTrue(favoritesFlag, "No Favorites Calls");
            favoriteFlag = false;
        } else {
            boolean favoriteCallFlag = isVisibleOnly(DIHomePage.favoriteCallsList(callIdAndDate), "Favorite Calls List");
            favoriteFlag = true;
        }
        return favoriteFlag;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectQueueFromFavorites
     * description ::selectQueueFromFavorites
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void selectQueueFromFavorites() throws Throwable {
        boolean queueInfavorites = isVisibleOnly(DIHomePage.btnQueueInFavorites, "Select Queue from favorites");
        if (queueInfavorites) {
            click(DIHomePage.btnQueueInFavorites, "Select Queue from favorites");
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getQueueSelectionLable
     * description ::To get queue selection lable
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public boolean getQueueSelectionLable() throws Throwable {
        boolean queue = isVisibleOnly(DIHomePage.btnRemoveOnQueueWindow, "Queue selection popup avaialble");
        return queue;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFavoritesInQueSelection
     * description ::To click on favorites in queue selection
     * date :: 05-Nov-2017
     * author ::cigniti
     */
    public void clickOnFavoritesInQueSelection() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.linkClickOnFavorites, "Click On Favorites in QueSelection");
        click(DIHomePage.linkClickOnFavorites, "Click On Favorites in QueSelection");
    }

    /* *
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectRedFlagCallOnTabOnPlusIcon
     * description :: To select RedFlag Calls in Plus Icon On Profile Tab In MCD
     * date :: 03-Jan-2018
     * author :: Nidhi
     */
    public void selectRedFlagCallOnTabOnPlusIcon() throws Throwable {
        click(DIHomePage.linkTabPlusButton, "Click on Plus Button");
        boolean RedFlagCallPlusIcon = isVisibleOnly(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallTab");
        if (RedFlagCallPlusIcon) {
            click(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallPlusTab");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyNonRedFlagCallID
     * description ::To select RedFlag Calls in Hidden Tab On Profile Tab In MCD
     * date :: 03-Jan-2018
     * author :: Nidhi
     */
    public void selectRedFlagCallOnHiddenTab() throws Throwable {
        click(DIHomePage.drpdwnHiddenTabs, "Click on Hidden Button");
        boolean RedFlagCallHiddenIcon = isVisibleOnly(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallTab");
        if (RedFlagCallHiddenIcon) {
            click(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallHiddenTab");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectRedFlagCallOnProfileTab
     * description ::To select RedFlag Calls On Profile Tab In MCD
     * date :: 03-Jan-2018
     * author :: Nidhi
     */
    public void selectRedFlagCallOnProfileTab() throws Throwable {
        boolean RedFlagCallProfileTab = isVisibleOnly(DIHomePage.lnkRedFlagUnderProfileTab, "RedFlagCallTab");
        if (RedFlagCallProfileTab) {
            click(DIHomePage.lnkRedFlagUnderProfileTab, "RedFlagCallProfileTab");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectRedFlagCall
     * description ::To select RedFlag Calls On Profile Tab In MCD
     * date :: 03-Jan-2018
     * author :: Nidhi
     */
    public void selectRedflagCall() throws Throwable {
        selectRedFlagCallOnTabOnPlusIcon();
        selectRedFlagCallOnHiddenTab();
        selectRedFlagCallOnProfileTab();
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckLoadDefaultOptionSPP
     * description :: To click on TruckloadDefault option in spp
     * date ::03-Jan-2018
     * author ::cigniti
     */
    public void clickOnTruckLoadDefaultOptionSPP() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckLoadDefaultViewSSP, "Default View On TruckLoad");
        click(DIHomePage.truckLoadDefaultViewSSP, "Default View On TruckLoad");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: SelectProfileNameFromProfileMenu
     * description :: To select profile name under profile menu
     * date ::03-Jan-2018
     * author ::cigniti
     */

    public void SelectProfileNameFromProfileMenu(String ProfileName) throws Throwable {
        waitForVisibilityOfElement(DIProfilePage.lblProfileNameInProfileMenuItems(ProfileName), "Profile Name in Profile Menu Items " + ProfileName);
        click(DIProfilePage.lblProfileNameInProfileMenuItems(ProfileName), "Profile Name in Profile Menu Items " + ProfileName);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCallsInDispatch
     * description ::To click on serach calls in spp Dispatch
     * date ::03-Jan-2018
     * author ::cigniti
     */
    public void clickOnSearchCallsInSPPDispatch() throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIHomePage.btnSearchCallsForSPP, "Search calls Link");
        click(DIHomePage.btnSearchCallsForSPP, "Search calls Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndEnterSpotFacilityIDInfoOnTruckLoad
     * description ::To verify Spot Facility is selected,if not enter spot facility ID in Truckload
     * date :: 20-feb-2018
     * author :: Nidhi
     */
    public void verifyAndEnterSpotFacilityIDInfoOnTruckLoad(String spotFacilityID) throws Throwable {
        Thread.sleep(2000);
        if (isVisibleOnly(DIHomePage.closeIconOnFacilitySelectedOnTruckload, "close icon")) {
            click(DIHomePage.closeIconOnFacilitySelectedOnTruckload, "close icon");
        }
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        click(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Type Spot Facility ID");
        System.out.println(spotFacilityID);
        type(DIHomePage.txtFacilityIDOnTruckLoad, spotFacilityID, "Type SpotfacilityID");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckLoadDefaultOptionInSpp
     * description ::
     * date :: 20-feb-2018
     * author :: Cigniti
     */
    public void clickOnTruckLoadDefaultOptionInSpp() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckLoadDefaultViewinSPP, "Default View On TruckLoad");
        click(DIHomePage.truckLoadDefaultViewinSPP, "Default View On TruckLoad");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchAndClickOnCallIdOnTruckloadWindow1
     * description :: To search and click on callId On Truckload Window In dispatch
     * date :: 20-feb-2018
     * author :: Nidhi
     */
    public void searchAndClickOnCallIdOnTruckloadWindow1(String callIDAndDate) throws Throwable {
        Thread.sleep(4000);
        if (isVisibleOnly(DIHomePage.callIDInTruckLoadTab(callIDAndDate), "CallId On TruckLoad Tab")) {
            mouseJSDoubleClick(DIHomePage.callIDInTruckLoadTab(callIDAndDate), "Click On CallId On TruckLoad Tab");

        } else {
            reporter.SuccessReport("call is not present", "Successfully call is removed");
        }
    }


    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnGearIconOfProfileWindowAndSettings
     * description :: To make settings of descending order in all tabs in profile window
     * date :: 20-feb-2018
     * author :: Nidhi
     */
    public boolean clickOnGearIconOfProfileWindowAndSettings() throws Throwable {
        boolean gearIcon = isVisibleOnly(DIHomePage.linkSettingsGearIconOnProfileWindow, "Gear Icon");
        if (gearIcon) {
            click(DIHomePage.linkSettingsGearIconOnProfileWindow, "Gear Icon");
            if (waitForVisibilityOfElement(DIHomePage.lnkDateArrowInSettingsTab, "date link")) {
                click(DIHomePage.lnkDateArrowInSettingsTab, "date link");
                waitForVisibilityOfElement(DIHomePage.lnkPriorityInSettingsTab, "priority link");
                click(DIHomePage.lnkPriorityInSettingsTab, "priority link");
                Thread.sleep(2000);
                click(DIHomePage.lnkPriorityOptionInSettingsTab, "priority option");
                waitForVisibilityOfElement(DIHomePage.lnkOrderInSettingsTab, "order link");
                click(DIHomePage.lnkOrderInSettingsTab, "order link");
                Thread.sleep(2000);
                click(DIHomePage.lnkOrderOptionInSettingsTab, "order option");
                Thread.sleep(2000);
                click(DIHomePage.lnkSaveInSettingsTab, "save option");
            }
            if (waitForVisibilityOfElement(DIHomePage.lnkIdArrowInSettingsTab, "id link")) {
                click(DIHomePage.lnkDateArrowInSettingsTab, "date link");
                waitForVisibilityOfElement(DIHomePage.lnkPriorityInSettingsTab, "priority link");
                click(DIHomePage.lnkPriorityInSettingsTab, "priority link");
                Thread.sleep(2000);
                click(DIHomePage.lnkPriorityOptionInSettingsTab, "priority option");
                waitForVisibilityOfElement(DIHomePage.lnkOrderInSettingsTab, "order link");
                click(DIHomePage.lnkOrderInSettingsTab, "order link");
                Thread.sleep(2000);
                click(DIHomePage.lnkOrderOptionInSettingsTab, "order option");
                Thread.sleep(2000);
                click(DIHomePage.lnkSaveInSettingsTab, "save option");
            }
        } else {
            assertTrue(gearIcon, "Gear Icon Is visible");
        }
        return gearIcon;
    }

    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPTACallIdOnProfileWindow
     * description :: To verify PTA callId in profile window in Dispatch
     * date :: 20-feb-2018
     * author :: Nidhi
     */
    public Boolean verifyPTACallIdOnProfileWindow(String callID, String calldate) throws Throwable {
        Boolean callDisplayOnBeyondPTA = (waitForInVisibilityOfElement(DIHomePage.callIDInBeyondPTAProfileTab(callID, calldate), "CallId On Profile Tab"));
        return callDisplayOnBeyondPTA;

    }
    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallIdOnBeyondPTAProfileWindow
     * description ::To verify PTA callId in profile window in Dispatch
     * date :: 20-feb-2018
     * author :: Nidhi
     */

    public Boolean verifyCallIdOnBeyondPTAProfileWindow(String callID, String calldate) throws Throwable {
        Boolean callDisplayOnBeyondPTA1 = waitForVisibilityOfElement(DIHomePage.callIDInBeyondPTAProfileTab(callID, calldate), "CallId On Profile Tab");
        return callDisplayOnBeyondPTA1;
    }
    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickCallIdOnBeyondPTAProfileWindow
     * description ::To click on PTA callId in profile window in Dispatch
     * date :: 20-feb-2018
     * author :: Nidhi
     */

    public void clickCallIdOnBeyondPTAProfileWindow(String callID, String calldate) throws Throwable {
        if (waitForVisibilityOfElement(DIHomePage.callIDInBeyondPTAProfileTab(callID, calldate), "CallId On Profile Tab")) {
            mouseJSDoubleClick(DIHomePage.callIDInBeyondPTAProfileTab(callID, calldate), "CallId On Profile Tab");
        }
    }

    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickBeyondPTATabOnProfile
     * description ::To click on PTA Tab in profile window in Dispatch
     * date :: 20-feb-2018
     * author :: Nidhi
     */
    public void clickBeyondPTATabOnProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelBeyondPTATab, "PTA Tab");
        click(DIHomePage.labelBeyondPTATab, "PTA Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckLoadDefaultOptionInSpp
     * description ::To select options in TruckLoad Default In SPP Dispatch
     * date :: 20-feb-2018
     * author :: Nidhi
     */
    public void clickOnTruckLoadDefaultOptioninSPP() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckLoadDefaultViewinSPP, "Default View On TruckLoad");
        click(DIHomePage.truckLoadDefaultViewinSPP, "Default View On TruckLoad");
    }

    public boolean verifyPhoneTypeOnDIMCDForTDDAndNoPhoneTypes() throws Throwable {
        boolean invisibilityOfPhoneType = waitForInVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "Phone Type");

        return invisibilityOfPhoneType;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getPTATimeZone
     * description ::To get PTA time zone
     * date :: 07-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getPTACallCreatedDate() throws Throwable {

        String pstCallCreatedDate = getText(DIHomePage.lblMCDPTACallCreatedDate, "Verifying PTA Date ");
        return pstCallCreatedDate;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getPTATimeZone
     * description ::To get PTA time zone
     * date :: 07-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public boolean verifyUserProfileTableListing() throws Throwable {

        boolean tableListing = isVisibleOnly(DIHomePage.lblUsersProfileResultsTableGrid, "User Profile Table listing  ");
        return tableListing;
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondPTACall
     * description ::To select BeyondPTA Calls On Profile Tab In MCD
     * date :: 06-03-2018
     * author :: Nidhi
     */
    public void selectBeyondPTACall() throws Throwable {
        boolean tabStatus = selectBeyondPTACallOnProfileTab();
        if (!tabStatus) {
            selectBeyondPTACallOnTabOnPlusIcon();
            selectBeyondPTACallOnHiddenTab();
        }
    }

    /* *
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondPTACallOnTabOnPlusIcon
     * description :: To select BeyondPTA Calls in Plus Icon On Profile Tab In MCD
     * date ::  06-03-2018
     * author :: Nidhi
     */
    public void selectBeyondPTACallOnTabOnPlusIcon() throws Throwable {
        click(DIHomePage.linkTabPlusButton, "Click on Plus Button");
        boolean BeyondPTACallPlusIcon = isVisibleOnly(DIHomePage.lnkBeyondPTAUnderAddMenuIcon, "BeyondPTACallTab");
        if (BeyondPTACallPlusIcon) {
            click(DIHomePage.lnkBeyondPTAUnderAddMenuIcon, "BeyondPTACallPlusTab");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondPTACallOnHiddenTab
     * description ::To select BeyondPTA Calls in Hidden Tab On Profile Tab In MCD
     * date ::  06-03-2018
     * author :: Nidhi
     */
    public boolean selectBeyondPTACallOnHiddenTab() throws Throwable {
        click(DIHomePage.drpdwnHiddenTabs, "Click on Hidden Button");
        boolean BeyondPTACallHiddenIcon = isVisibleOnly(DIHomePage.lnkBeyondPTAUnderHiddenTab, "BeyondPTACallTab");
        if (BeyondPTACallHiddenIcon) {
            click(DIHomePage.lnkBeyondPTAUnderHiddenTab, "BeyondPTACallHiddenTab");
        }
        return BeyondPTACallHiddenIcon;
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondPTACallOnProfileTab
     * description ::To select BeyondPTA Calls On Profile Tab In MCD
     * date ::  06-03-2018
     * author :: Nidhi
     */
    public boolean selectBeyondPTACallOnProfileTab() throws Throwable {
        boolean BeyondPTACallProfileTab = isVisibleOnly(DIHomePage.labelBeyondPTATab, "BeyondPTACallTab");
        if (BeyondPTACallProfileTab) {
            click(DIHomePage.labelBeyondPTATab, "BeyondPTACallProfileTab");
        }
        return BeyondPTACallProfileTab;
    }
    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallOnRedFlagTab
     * description ::  To verify Non Red Flag CallId in RedflagCall Tab in Profile window
     * date :: 03-Jan-2018
     * author :: Nidhi
     */

    public Boolean verifyCallOnRedFlagTab(String callID, String calldate) throws Throwable {
        Boolean callDisplayOnRedFlag = (!isVisibleOnly(DIHomePage.callIDInRedFlagProfileTab(callID, calldate), "CallId On Profile Tab"));
        if (!callDisplayOnRedFlag) {
            click(DIHomePage.callIDInRedFlagProfileTab(callID, calldate), "CallId On Profile Tab");
        }
        return callDisplayOnRedFlag;
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallIDOnRedFlagTab
     * description :: To verify Red Flag CallId in RedflagCall Tab in Profile window
     * date :: 03-Jan-2018
     * author :: Nidhi
     */
    public Boolean verifyCallIDOnRedFlagTab(String callID, String calldate) throws Throwable {
        Boolean callDisplayOnRedFlag = (isVisibleOnly(DIHomePage.callIDInRedFlagProfileTab(callID, calldate), "CallId On Profile Tab"));
        if (callDisplayOnRedFlag) {
            click(DIHomePage.callIDInRedFlagProfileTab(callID, calldate), "CallId On Profile Tab");
        }
        return callDisplayOnRedFlag;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: VerifySPPDispatchPageIsVisible
     * description :: This function verifies if SPPDispatch page is visbble or not.
     * date :: 0
     * author ::
     */
    public boolean VerifySPPDispatchPageIsVisible() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblSPPDisplatch, "SPP Dispatch");
        boolean SPPDispatch = isVisible(DIHomePage.lblSPPDisplatch, "SPP Dispatch");
        return SPPDispatch;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterRAPIDInfo
     * description :: To enter RAP id in textBox
     * date :: 21-Mar-2018
     * author :: Chandra
     */
    public String enterRAPIDInfo(String rap) throws Throwable {

        type(DIHomePage.txtRAPNumberFieldInSearchWindow, rap, "Type rap");
        return rap;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: visibilityOfQueueInfavorites
     * description :: This function check for  visibility of Everithing Queue  In favorites
     * date :: 0
     * author ::
     */
    public boolean visibilityOfQueueInfavorites() throws Throwable {
        boolean visibilityOfQueue = isVisibleOnly(DIHomePage.btnQueueInFavorites, "Select Queue from favorites");
        return visibilityOfQueue;

    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectAllLinkOnFavouriteQueueWindow
     * description :: click on Select All link
     * date :: 21-Mar-2018
     * author :: Abhiram
     */
    public void clickOnSelectAllLinkOnFavouriteQueueWindow() throws Throwable {
        click(DIHomePage.lnkSelectAllFavourite, "Favourites Select All");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyMenuItem
     * description :: VerifyMenuItem
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean verifyMenuItem() throws Throwable {
        boolean applicationMenu = isVisibleOnly(DIHomePage.lnkApplicationMenu, "Application Menu");
        return applicationMenu;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectedProfileUnderProfileMenu
     * description :: clickOnSelectedProfileUnderProfileMenu
     * date :: 24-Mar-2018
     * author :: Chandra
     */
    public void clickOnSelectedProfileUnderProfileMenu(String profileName) throws Throwable {
        clickOnProfileMenu();
        selectProfileMenuItem(profileName);
        Thread.sleep(22000);
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectedProfileUnderProfileMenu
     * description :: clickOnSelectedProfileUnderProfileMenu
     * date :: 24-Mar-2018
     * author :: Chandra
     */
    public void selectProfileMenuItem(String profileName) throws Throwable {
        click(DIHomePage.profileNameInProfileList(profileName), "ProfileMenu Item" + profileName);
    }

    public String gettextforTCL1(String tcl1value) throws Throwable {
        String tcl1 = getText(DIHomePage.lblTCL1ValueonProfileTab(tcl1value), "TCL1 Value");
        return tcl1;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnArrowLinkOfDate
     * description :: clickOnArrowLinkOfDate
     * date :: 24-Mar-2018
     * author :: Lakshmi
     */
    public boolean clickOnArrowLinkOfDate() throws Throwable {
        boolean dateArrow = isVisibleOnly(DIHomePage.btnDateLink, "Date Arrow Button");
        if (dateArrow) {
            click(DIHomePage.btnDateLink, "Date Arrow Button");
        } else {
            assertTrue(dateArrow, "Date Arrow button is visible");
        }
        return dateArrow;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnArrowLinkOfID
     * description :: clickOnArrowLinkOfID
     * date :: 24-Mar-2018
     * author :: Lakshmi
     */
    public boolean clickOnArrowLinkOfID() throws Throwable {
        boolean idArrow = isVisibleOnly(DIHomePage.btnCallIdLink, "Id Arrow Button");
        if (idArrow) {
            click(DIHomePage.btnCallIdLink, "Id Arrow Button");
        } else {
            assertTrue(idArrow, "ID Arrow button is visible");
        }
        return idArrow;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAppliationListInMenu
     * description :: This function clicks on Application List on Menu item
     * date :: 29-Mar-2018
     * author :: Sachin
     */
    public void clickOnAppliationListInMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkApplicationMenu, "Application");
        click(DIHomePage.lnkApplicationMenu, "Application");
    }

    public String getLoggedInUserRoleFromUserProfileWindow() throws Throwable {
        String userRole = getText(LoginPage.lblroleInUserProfileWindow, "User role");
        return userRole;
    }

    public void closeUserProfileWindow() throws Throwable {
        click(DIHomePage.btnCloseOnUserProfileWindow, "Close user profile window");
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: selectGroupFromExpandedOptionsOnMessagePopup
     * description :: This function select a group from a expanded options on message popup
     * date :: 03-Apr-2018
     * author :: Madhukar
     */
    public String selectGroupFromExpandedOptionsOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblDispatchUserOnMessagePopup, "Dispatch User");
        String user = getText(DIHomePage.lblDispatchUserOnMessagePopup, "Dispatch User");
        click(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");
        return user;
    }

    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::verifyPopOutInMessagePopUpWindow
     * description::verifyPopOutInMessagePopUpWindow
     * date :: 05-04-2018
     * author :: Madhukar
     */
    public boolean verifyPopOutInMessagePopUpWindow() throws Throwable {
        boolean popout = isVisibleOnly(DIHomePage.lnkPopoutForMessagePopUp, "Message Popin and Popout");
        return popout;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::getUserProfileScreenName
     * description::To get User Profile ScreenName
     * date :: 08-04-2018
     * author :: Lakshmi
     */
    public String getUserProfileScreenName() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblUserProfileScreen, "User Profile screen name");
        String userProfileScreenName = getText(DIHomePage.lblUserProfileScreen, "User Profile screen name");
        return userProfileScreenName;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::clickOnUserSettingsTabOnUserProfileScreen
     * description::To click On UserSettings Tab On UserProfile Screen
     * date :: 08-04-2018
     * author :: Lakshmi
     */
    public void clickOnUserSettingsTabOnUserProfileScreen() throws Throwable {
        click(DIHomePage.lblUserSettings, "Click on user settings tab");
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::getGeneralSettingLabelName
     * description::To get General Setting LabelName
     * date :: 08-04-2018
     * author :: Lakshmi
     */
    public String getGeneralSettingLabelName() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblGeneralSettingsOnUsePfofile, "General Setting Label Name On User Profile Screen");
        String generalSettingsLableName = getText(DIHomePage.lblGeneralSettingsOnUsePfofile, "General Setting Label Name On User Profile Screen");
        return generalSettingsLableName;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::verifyQueueSelectionModelAfterLogin
     * description::To check queue selection model is appeared
     * date :: 05-04-2018
     * author :: Madhukar
     */
    public boolean verifyQueueSelectionModelAfterLogin() throws Throwable {
        boolean queueselection = isVisibleOnly(DIHomePage.lblQueueSelection, "Queue Selection Model is Available");
        return queueselection;
    }

    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::verifyFacilityPTAWinow
     * description::To check Facility PTA Window is Appeared
     * date :: 05-04-2018
     * author :: Madhukar
     */
    public boolean verifyFacilityPTAWinow() throws Throwable {
        boolean ptaWindow = isVisibleOnly(DIHomePage.lblFacilityPTAWindow, "Facility PTA Window is Available");
        return ptaWindow;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::verifyDispatchQueueSectionOnUserProfile
     * description::To check Dispatch Queue Section On UserProfile
     * date :: 05-04-2018
     * author :: Madhukar
     */
    public boolean verifyDispatchQueueSectionOnUserProfile() throws Throwable {
        boolean dispatchQueueSection = isVisibleOnly(DIHomePage.lnkDispatchQueueSection, "Dispatch Queue Section is Available");
        return dispatchQueueSection;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::quickCommentsCheckBoxIsChecked
     * description::To check quickComments CheckBox Is Checked or not
     * date :: 08-04-2018
     * author :: Lakshmi
     */


    public boolean quickCommentsCheckBoxIsChecked()throws Throwable{
        boolean isQuickCommentsSelected = isCheckBoxSelected(DIHomePage.chkBoxQuickComments);
        return isQuickCommentsSelected;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::quickETACheckBoxIsChecked
     * description::To check quick ETA CheckBox Is Checked or  not
     * date :: 08-04-2018
     * author :: Lakshmi
     */
   
    public boolean quickETACheckBoxIsChecked()throws Throwable{
        boolean isQuickETASelected = isCheckBoxSelected(DIHomePage.chkBoxQuickETA);
        return isQuickETASelected;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::quickTruckAssignmentCheckBoxIsChecked
     * description::To check quickTruckAssignment CheckBox Is Checked or   not
     * date :: 08-04-2018
     * author :: Lakshmi
     */
  
    public boolean quickTruckAssignmentCheckBoxIsChecked()throws Throwable{
        boolean isQuickTruckAssignmentSelected = isCheckBoxSelected(DIHomePage.chkBoxQuickTruckAssignment);
        return isQuickTruckAssignmentSelected;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::quickTruckMessagingCheckBoxIsChecked
     * description::To check quickTruckMessaging CheckBox Is Checked or   not
     * date :: 08-04-2018
     * author :: Lakshmi
     */
   
    public boolean quickTruckMessagingCheckBoxIsChecked()throws Throwable{
        boolean isQuickTruckMessagingSelected = isCheckBoxSelected(DIHomePage.chkBoxQuickTruckAssignment);
        return isQuickTruckMessagingSelected;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::mouseHoverToQuickCommentsInfoIcon
     * description::mouse Hover To Quick CommentsInfoIcon
     * date :: 08-04-2018
     * author :: Lakshmi
     */
   
    public String mouseHoverToQuickCommentsInfoIcon()throws Throwable{
        mouseHover(DIHomePage.infoIconOfQuickComments,"Mouse Hover to Quick Comments Info Icon");
        //waitForVisibilityOfElement(DIHomePage.infoIconOfQuickComments,"Quick Comments Info Icon");
        String quickCommentsInfotext = driver.findElement(DIHomePage.infoIconOfQuickComments).getAttribute("title");
       return quickCommentsInfotext;
    }

    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::mouseHoverToQuickETAInfoIcon
     * description::mouse Hover To QuickETAInfoIcon
     * date :: 08-04-2018
     * author :: Lakshmi
     */
    
    public String mouseHoverToQuickETAInfoIcon()throws Throwable{
        mouseHover(DIHomePage.infoIconOfQuickETA,"Mouse Hover to quick ETA Info Icon");
        //waitForVisibilityOfElement(DIHomePage.infoIconOfQuickETA,"Quick ETA Info Icon");
        String quickETAInfoIconText = driver.findElement(DIHomePage.infoIconOfQuickETA).getAttribute("title");
        return  quickETAInfoIconText;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::mouseHoverToQuickTruckAssignmentInfoIcon
     * description::mouse Hover To QuickTruckAssignmentInfoIcon
     * date :: 08-04-2018
     * author :: Lakshmi
     */
    
    public String mouseHoverToQuickTruckAssignmentInfoIcon()throws Throwable{
        mouseHover(DIHomePage.infoIconOfQuickTruckAssignment,"Mouse hover to quickTruck assignment");
        //waitForVisibilityOfElement(DIHomePage.infoIconOfQuickTruckAssignment,"Quick Truck assignment")
        String quickTruckAssignmentText = driver.findElement(DIHomePage.infoIconOfQuickTruckAssignment).getAttribute("title");
        return quickTruckAssignmentText;
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::mouseHoverToQuickTruckMessagingInfoIcon
     * description::mouse Hover To QuickTruckMessagingInfoIcon
     * date :: 08-04-2018
     * author :: Lakshmi
     */
   
    public String mouseHoverToQuickTruckMessagingInfoIcon()throws Throwable{
        mouseHover(DIHomePage.infoIconOfQuickTruckMessaging,"Mouse hover to quickTruck Messaging");
        //waitForVisibilityOfElement(DIHomePage.infoIconOfQuickTruckMessaging,"Quick Truck Messaging"
        String quickTruckMessagingText = driver.findElement(DIHomePage.infoIconOfQuickTruckMessaging).getAttribute("title");
        return quickTruckMessagingText;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnAddressBookTab
     * description::To click on truck tab
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public void clickOnTruckTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckOnMessagePopUp, "Truck Tab");
        click(DIHomePage.truckOnMessagePopUp, "Truck Tab");
    }
    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::clickOnUserProfile
     * description::To click On UserProfile
     * date :: 03-04-2018
     * author :: Lakshmi
     */
    public void clickOnUserProfile()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lnkUserProfileUnderApplication,"Click On User Profile Link Under Application Tab");
        click(DIHomePage.lnkUserProfileUnderApplication,"Click On User Profile Link Under Application Tab");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::enterFacilityInFacilityText
     * description::enterFacilityInFacilityText
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public void enterFacilityInFacilityText(String facility) throws Throwable {
        click(DIHomePage.truckFacilityOnMessagePopUp, "Facility text field");
        clearData(DIHomePage.truckFacilityOnMessagePopUp);
        type(DIHomePage.truckFacilityOnMessagePopUp, facility, "Facility text field");
        String combineKeys3 = Keys.chord(Keys.ENTER);
        sendKeys(combineKeys3, "ENTER");

    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyMessageReceviedByUser
     * description::verifyMessageReceviedByUser
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public boolean verifyMessageReceviedByUser(String msg) throws Throwable {
       boolean msgRecev= waitForVisibilityOfElement(DIHomePage.LblMessageOnMessagePopUp(msg), "Message Received");
        click(DIHomePage.LblMessageOnMessagePopUp(msg), "Message Received");
        return msgRecev;
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::ClickOnPlusIconOnFacilityInMessagePopup
     * description::ClickOnPlusIconOnFacilityInMessagePopup
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public void ClickOnPlusIconOnFacilityInMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.plusIconOnFacilityInMessagePopup, "Plus Icon");
        click(DIHomePage.plusIconOnFacilityInMessagePopup, "Plus Icon");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::ClickOnTruckUserInMessagePopup
     * description::ClickOnTruckUserInMessagePopup
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public void clickOnTruckUserInMessagePopup(String truck) throws Throwable {
         waitForVisibilityOfElement(DIHomePage.selectTruckForUserInFacilityInMessagepOpup(truck), "Truck");
         click(DIHomePage.selectTruckForUserInFacilityInMessagepOpup(truck), "Truck");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::ClickOnTruckUserInMessagePopup
     * description::ClickOnTruckUserInMessagePopup
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public void clickOnFacilityInMessagePopup(String facility) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.selectFacilityInFacilityInMessagepOpup(facility), "Facility");
        click(DIHomePage.selectFacilityInFacilityInMessagepOpup(facility), "Facility");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::ClickOnTruckUserInMessagePopup
     * description::ClickOnTruckUserInMessagePopup
     * date :: 13-Apr-2018
     * author :: Nidhi
     */
    public boolean verifyRecepientIsAdded(String recep) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.recepientIsAddedInNewMessageTab(recep), "Recepient is added");
        boolean recepientVisibility =isVisibleOnly(DIHomePage.recepientIsAddedInNewMessageTab(recep), "Recepient is added");
        return recepientVisibility;

    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::selectCallTakerUserFromMessagePopup
     * description::select CallTaker User From Message Popup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void selectSPPUserFromMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.dispatchSPPUserOnMessagePopUp, " SPP user");
        click(DIHomePage.dispatchSPPUserOnMessagePopUp, "SPP user");
    }

    /**
     * param ::NA
     * return ::boolean
     * throws :: throwable
     * methodName ::isQueueSelectionWindowExists
     * description:: This function checks for the presense of Queue Selection window
     * date :: 17-04-2018
     * author :: Sachin
     */
    public boolean isQueueSelectionWindowExists()throws Throwable{

        waitForVisibilityOfElement(DIHomePage.windowQueueSelection,"Queue Selection window");
        boolean window = isElementPresent(DIHomePage.windowQueueSelection,"Queue Selection window");
        return window;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnFacilityPTA
     * description ::This method is used to close facility PTA pop up
     * date :: 12-01-2018
     * author :: Cigniti
     */
    public void clickOnCloseOnFacilityPTA() throws Throwable {
        boolean closeIconOnQueueSelection = isVisibleOnly(DIHomePage.iconCloseOnFacilityPTA, "Close icon is Available");
        if (closeIconOnQueueSelection) {
            click(DIHomePage.iconCloseOnFacilityPTA, "Close Icon Queue Selection");
        }
    }
}








