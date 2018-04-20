package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.*;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CRHomeLib extends ActionEngine {
    List<WebElement> tableColumnData = null;
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: logOut
     * description :: logOut
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public boolean logout() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "logOut link");

        Thread.sleep(3000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        if (checkForLogout) {
            waitCloseAllBusyIconsResults();
            click(CRHomePage.lnkLogout, "logOut link");
            Thread.sleep(2000);
            waitForVisibilityOfElement(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
            switchToWindow();
            CloseLogoutAlert();
        } else {
            assertFalse(checkForLogout, "Logout link not appeared");
        }
        Thread.sleep(5000);
        return checkForLogout;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyLogout
     * description :: verifyandclickLogout
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void verifyandClickLogout() throws Throwable {
        Thread.sleep(3000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        if (checkForLogout) {
            waitCloseAllBusyIconsResults();
            click(CRHomePage.lnkLogout, "logOut link");
            Thread.sleep(2000);
            waitForVisibilityOfElement(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: VerifyHomeScreen
     * description :: Verifying Home screen by checking logOut link
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void verifyHomeScreen() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "logOut");
        Thread.sleep(3000);
        boolean closeMessagesPresent = isVisibleOnly(CRHomePage.closeMessages, "close Messages");
        if (closeMessagesPresent) {
            click(CRHomePage.closeMessages, "close Messages");
        }
        boolean flag = isVisibleOnly(CRHomePage.lnkLogout, "logOut");
        if (flag) {
            reporter.SuccessReport("Logout", "You are logged into Call receiving Home Page");
        } else
        	reporter.failureReport("Logout", "Your login attempts is failed");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberSearchTextBox
     * description :: To enter member number in member search
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void memberSearchTextBox(String Membersearch) throws Throwable {
        click(CRHomePage.txtSearchMemberText, "Member Search box");
        type(CRHomePage.txtSearchMemberText, Membersearch, "Search Value");
        Thread.sleep(2000);
        System.out.println("Wrong" + Membersearch);
        click(CRHomePage.btnSearchButton, "Search Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearMemberSearchTextBox
     * description :: To clear member search text box
     * date :: 16-APR-2018
     * author :: jagadish pola
     */
    public void clearMemberSearchTextBox() throws Throwable {
        dynamicWaitByLocator(CRHomePage.txtSearchMemberText,60);
        clearData(CRHomePage.txtSearchMemberText);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: saveButton
     * description :: Call Receiving Save button
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void saveButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberSave, "Member Save button");
        click(CRHomePage.btnMemberSave, "Member Save button");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: CancelButton
     * description :: Call Receiving cancel button
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void cancelButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberCancel, "Member Cancel button");
        click(CRHomePage.btnMemberCancel, "Member Cancel button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: LeaveButton
     * description :: Call Receiving Leave button
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
    public void leaveButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberLeave, "Member leave button");
        click(CRHomePage.btnMemberLeave, "Member Leave button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: DuplicateButton
     * description :: Call Receiving Duplicate button
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void duplicateButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberDuplicate, "Member Duplicate button");
        click(CRHomePage.btnMemberDuplicate, "Member Duplicate button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: allErrorAlerts
     * description :: To handle all types of errors
     * date :: 05-Nov-2017
     * author :: Laskhmi Prasana
     */
    public void allErrorAlerts() throws Throwable {
        Thread.sleep(3000);
        //This condition is to handle confirmation message for save/Cancel/Leave/Logout button alerts
        boolean isErrorOccured = isVisibleOnly(CRHomePage.alertConfirmation, ": Confirmation alert");
        if (isErrorOccured) {
            click(CRHomePage.alertConfirmationYesButton, ": Confirmation alert Yes button");
        } 
        boolean isUndefinedError = isVisibleOnly(CRHomePage.unDefinedError, "Undefined Error");
        if (isUndefinedError) {
            click(CRHomePage.unDefinedError, "Undefined error");
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: memPageManualEntry
     * description :: Member page manual entry link
     * date :: 05-Nov-2017
     * author :: chandrasekhar Dendukuri
     */
    public void memPageManualEntry() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.memberPageManualEntry, "Member page manual entry link");
        click(CRHomePage.memberPageManualEntry, "Member Page Manual entry link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLink
     * description :: Click the Manual Entry link on Tabs
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasana
     */
//    public void clickOnManualEntryLink(String tabName) throws  Throwable{
//
//        if(tabName.equalsIgnoreCase("member")) {
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonMem, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryOnMem, "Manual Entry Link");
//                click(CRMemberSearchPage.lnkManualEntryOnMem, "Manual Entry");
//            }
//        }
//        else if(tabName.equalsIgnoreCase("location")){
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonLoc, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryonLoc, "Manual Entry Link");
//
//                click(CRHomePage.lnkManualEntryonLoc, "Manual Entry");
//            }
//
//        }else if(tabName.equalsIgnoreCase("vehicle")){
//
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonVehic, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryonVehic, "Manual Entry Link");
//                click(CRHomePage.lnkManualEntryonVehic, "Manual Entry");
//            }
//        } else if(tabName.equalsIgnoreCase("tow")) {
//
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonTow, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryonTow, "Manual Entry Link");
//                click(CRHomePage.lnkManualEntryonTow, "Manual Entry");
//            }
//        }
//    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: sessionInNewTab
     * description :: Using this method we can open the session in new tab
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
    public void sessionInNewTab() throws Throwable {
        String currentUrl = driver.getCurrentUrl();
        String currentSessionID[] = currentUrl.split("=");
        String sessionID = currentSessionID[1];
        openURLInNewWindow(currentUrl);
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "LogoutLink");
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "logOut link");
        boolean flag = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        assertTrue(flag, "User logged in successfully");
        String newCurrentUrl = driver.getCurrentUrl();
        String newCurrentSessionID[] = newCurrentUrl.split("=");
        String newSessionID = newCurrentSessionID[1];
        assertTrue(sessionID.equalsIgnoreCase(newSessionID), "Same session continued in the new tab");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: waitcloseAllBusyIconsResults
     * description :: Application loading wait for memberseatch results
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public void waitCloseAllBusyIconsResults() throws Throwable {
        int iCounter = 0, loading;
        boolean status = true;
        do {
            iCounter++;
            loading = getElementsSize(CRMemberSearchPage.iconResultLoadingSpinner);
            if (loading == 0) {
                status = true;
                break;
            } else {
                status = false;
                //LOG.info("iCounter appearStatus " + iCounter);
            }
            if (iCounter > 100) {
                status = false;
                break;
            }
        }
        while (iCounter <= 100);
        if (status) {
            LOG.info("All spinners are closed");
        } else {
            LOG.info("All spinners are not closed");
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyLoggedInUserRole
     * description :: This is to validate login functionality with difference combinations
     * date :: 08-Dec-2017
     * author :: Chandu Dendukuri
     */
    /*public String verifyLoggedInUserRole() throws Throwable {
        rolevalue = getText(CRHomePage.lblHeaderUserName, "Logged in user Role");
        boolean verifyLoggedInUserRole = isVisibleOnly(CRHomePage.lblheaderUsername, "Logged in user Role");
        if (verifyLoggedInUserRole) {
            assertTrue(verifyLoggedInUserRole, "User logged into the application with selected user id/role");
        } else {
            assertFalse(verifyLoggedInUserRole, "User Not logged in with selected user id/role");
        }
        return rolevalue;
    }*/

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: workFlowSelectionForHistory
     * description ::This method is used to click on workflow dropdown button and select only for History workflow
     * date ::
     * author ::Madhukar
     */
    public void workFlowSelectionForHistory() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.workFlowDropDown, "WorkFlow dropdown");
        click(CRHomePage.workFlowDropDown, "Workflow dropdown");
        click(CRHomePage.historyWorkFlow, "historyWorkFlow");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnWorkFlowDropdown
     * description ::This method is used to click on drop down button for workflow selection like Accident,Member,
     * History,Public Agency,RAP
     * date ::
     * author ::Madhukar
     */
    public void clickOnWorkFlowDropdown() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.workFlowDropDown, "WorkFlow dropdown");
        click(CRHomePage.workFlowDropDown, "Workflow dropdown");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::messageDialogBoxClose
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean messageDialogBoxClose() throws Throwable {
        boolean messageCloseIcon = isVisibleOnly(CRHomePage.iconMsgClose, "Message Alert Close");
        if (messageCloseIcon) {
            //assertTrue(messageCloseIcon, "Message Dialog window appeared ");
            click(CRHomePage.iconMsgClose, "Message Alert Close");
        }

        return messageCloseIcon;
    }

    public boolean verifyMessageDialogBoxClose() throws Throwable {
        boolean messageCloseIcon = isVisibleOnly(CRHomePage.iconMsgClose, "Message Alert Close");
        return messageCloseIcon;
    }
    public void closeMessageDialogBoxClose() throws Throwable {
        click(CRHomePage.iconMsgClose, "Message Alert Close");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnSearchCallsLink
     * description::To click on search calls Link
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnSearchCallsLink() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.searchCallsLink, "SearchCall Link");
        click(CRHomePage.searchCallsLink, "SearchCall Link");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnCallIdOnSearchCalls
     * description::To click on callID on search calls Link
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnCallIdOnSearchCalls() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.linkCallIdOnSearchCalls, "Click on CallId Link");
        click(CRHomePage.linkCallIdOnSearchCalls, "Click on CallId Link");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::clickOnSearchButtonOnSearchCalls
     * description::To click on search button on search calls Link
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnSearchButtonOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.searchButtonForCallSearch, "Click on Search Button On Search Calls");
        click(CRHomePage.searchButtonForCallSearch, "Click on Search Button On Search Calls");
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::enterCallIdForSearch
     * description::To enter callID for serach
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void enterCallIdForSearch(String callID) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtSearchCallID, "Click on CallID Field");
        click(CRHomePage.txtSearchCallID, "Click on CallID Field");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.txtSearchCallID, "Type CallID");
        type(CRHomePage.txtSearchCallID, callID, "Type CallID");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::clickOnSearchCallDroupDown
     * description::To click on search call dropdown
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnSearchCallDroupDown() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.drpdwnSearchCalls, "SearchCall DropDown");
        click(CRHomePage.drpdwnSearchCalls, "SearchCall DropDown");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::verifyPhoneNumbersForUpdation
     * description::To verify Phone number  for updation
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyPhoneNumbersForUpdation(String oldPhoneNumber, String updatedPhoneNumber) throws Throwable {
        boolean verifyPhoneNumbers = oldPhoneNumber.equals(updatedPhoneNumber);
        if (verifyPhoneNumbers) {
            assertTrue(verifyPhoneNumbers, "Changes are Updated after Leave the Call");
        } else {
            assertTrue(!verifyPhoneNumbers, "Changes are Not Updated after Leave the Call");
        }
        return  verifyPhoneNumbers;

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::getPhoneNumberFromMemberDetailsInSearchCalls
     * description::To get Phone Number From Member Details In Search Calls
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String getPhoneNumberFromMemberDetailsInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.memberDetailsOnSearchCalls, "Getting PhoneNumber From Member Details");
        String memdetails = getText(CRHomePage.memberDetailsOnSearchCalls, "Getting PhoneNumber From Member Details");
        String splitStr[] = memdetails.split("\\n");
        String phoneNumber = splitStr[1].substring(0, 9);
        return phoneNumber;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::messageForLeaveCall
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String messageForLeaveCall() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.leaveCallMessage, "Message after leave the call");
        String leavemsg = getText(CRHomePage.leaveCallMessage, "Message after leave the call");
        return  leavemsg;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::clickOnContinueButtonOnKillCallPopup
     * description::To click On Continue Button On Kill Call Popup
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean clickOnContinueButtonOnKillCallPopup() throws Throwable {
        boolean killCallContinueButton = isVisibleOnly(CRHomePage.btnKillCallContinue, "Kill call button");
        assertTrue(killCallContinueButton, "Kill Call button Appeared");
        if (killCallContinueButton) {
            click(CRHomePage.btnKillCallContinue, "Kill Call button");
        }
        return killCallContinueButton;
    }

    /**
     * param ::String inputs
     * return ::void
     * throws :: throwable
     * methodName ::validateDispatchCodeInSearchCallsPoPUpWindow
     * description::To validate Dispatch Code In Search Calls PoPUp Window
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean validateDispatchCodeInSearchCallsPoPUpWindow(String dispatchCode) throws Throwable {
        boolean DispatchCode = isVisibleOnly(CRHomePage.lblDispatchCodeInSearchCallWindow, "Dispatch Code");
        if (DispatchCode) {
            String dispatchCodes = getText(CRHomePage.lblDispatchCodeInSearchCallWindow, "Dispatch Code");
            assertTrue(dispatchCode.equalsIgnoreCase(dispatchCodes), "Trouble code on the call maps to the pacesetter code ");
        }
        return DispatchCode;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnSearchCallsWindow
     * description :: This function clicks on Close Icon on Search Calls PopUp window
     * date :: 2-Jan-2018
     * author :: Sachin
     */

    public void clickOnCloseIconOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconClickOnCloseIconOnSearchCalls, "Close Icon");
        click(CRHomePage.iconClickOnCloseIconOnSearchCalls, "Close Icon");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::getErrorFoundForGeoCode
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */

    public boolean getErrorFoundForGeoCode() throws Throwable {
        boolean errorGeoCode = isVisibleOnly(CRHomePage.unDefinedError, "GeoCode is not there for Provided address");
        if (errorGeoCode) {
            assertFalse(errorGeoCode, "Failed to GeoCode the provided  Address error alert found");
            click(CRHomePage.unDefinedError, "Clicked on GeoCode OK Button");
        } else {
            assertTrue(!errorGeoCode, "Failed to GeoCode the provided  Address error alert NOT found");
        }
        return errorGeoCode;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: allErrorAlertsNoButton
     * description :: This function clicks on No button on Pop Up
     * date :: 8-Jan-2018
     * author :: Sachin
     */

    public boolean allErrorAlertsNoButton() throws Throwable {

        //This condition is to handle confirmation message for save/Cancel/Leave/Logout button alerts
        boolean isErrorOccured = isVisibleOnly(CRHomePage.alertConfirmation, ": Confirmation alert");
        if (isErrorOccured) {
            reporter.SuccessReport("Error message occured", "Error message occured");
            click(CRHomePage.alertConfirmationNoButton, ": Confirmation alert No button");
        }
        boolean isUndefinedError = isVisibleOnly(CRHomePage.unDefinedError, "Undefined Error");
        if (isUndefinedError) {
            click(CRHomePage.unDefinedError, "Undefined error");
        }
        return  isErrorOccured;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnInternalIcon
     * description :: This function clicks on Iternal Icon
     * date :: 11-Jan-2018
     * author :: Sachin
     */
    public void clickOnInternalIcon() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconInernal, "Inernal Icon");
        click(CRHomePage.iconInernal, "Inernal Icon");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyPTAFlag
     * description :: This method is used to verify whether PTA flag is Available
     * date :: 16-01-2018
     * author ::Cigniti
     */
    public boolean verifyPTAFlag() throws Throwable {
        boolean ptaFlag = isVisibleOnly(CRHomePage.iconPTAFalg, "PTA FLAG");
        return ptaFlag;
    }

    /**
     * param :: String
     * return ::String
     * throws :: throwable
     * methodName :: verifyPTAValue
     * description :: This method is used to get the PTA Value and Time based on the option parameter. Returns time if Parameter is 'Time'
     * else returns 'value'
     * date :: 16-01-2018
     * author ::Cigniti
     */
    public String verifyPTAValue(String option) throws Throwable {
        String value="";
        String time="";
        String ptaValue = getText(CRHomePage.lblPTAvalue, "PTA Value");
        String Totalvalue[]= ptaValue.split(",");
        value=Totalvalue[0];
        time=Totalvalue[1];
        if(option.equalsIgnoreCase("Value")){
            return value;
        }else {
            String splitTime[]=time.trim().split(" ");
            return splitTime[0];
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ValidateConfirmationPopUpWindow
     * description :: This function to validate if confirmatin Pop Up window displays
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public boolean ValidateConfirmationPopUpWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.confirmationPopUp, "Confirmation Pop Up Window");
        boolean isExists = isVisibleOnly(CRHomePage.confirmationPopUp, "Confirmation Pop Up Window");
        assertTrue(isExists, "Confirmation Pop Up Window displays");
        return  isExists;
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: SetCommentsConfirmationWindow
     * description :: This function to enter comments in Confirmation Window Text area
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public void SetCommentsConfirmationWindow(String comments) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtAreaComments, "Comments text area");
        type(CRHomePage.txtAreaComments, comments, "Comments text area");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: GetCommentsConfirmationWindow
     * description :: This function to get the text from comments text area in Confirmation Window
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public String GetCommentsConfirmationWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtAreaComments, "Comments text area");
        String comments = getAttributeByValue(CRHomePage.txtAreaComments, "Comments text area");
        return comments;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnYesButtonOnConfirmationWindow
     * description :: This function to click on Yes Button on Confirmation Window
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public void ClickOnYesButtonOnConfirmationWindow() throws Throwable {
    	if (isVisibleOnly(CRHomePage.alertConfirmationYesButton, "Yes Button")) {
    		waitForVisibilityOfElement(CRHomePage.alertConfirmationYesButton, "Yes Button");
            click(CRHomePage.alertConfirmationYesButton, "Yes Button");
    	}
        
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnConfirmationAlert
     * description :: clickOnConfirmationAlert
     * date :: 16-Jan-2018
     * author :: Chandra
     */
    public boolean clickOnConfirmationAlert() throws Throwable {

        boolean isErrorOccured = isVisibleOnly(CRHomePage.alertConfirmation, ": Confirmation alert");
        assertTrue(isErrorOccured, "Confirmation alert Yes button");
        click(CRHomePage.alertConfirmationYesButton, ": Confirmation alert Yes button");
        return  isErrorOccured;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getTextD3CallReceivingText
     * description :: To get text of D3 Call Receiving
     * date :: 16-jan-2017
     * author :: Ravi
     */
    public String getTextD3CallReceivingText() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.d3CallReceivingTxt, "wait for d3 call receiving text");
        String d3call= getText(CRHomePage.d3CallReceivingTxt, "get text of d3  call receving text");
        return d3call;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyPopupMessageForETAUpdate
     * description :: This method is used to verify ETA update message
     * date :: 17-01-2018
     * author ::Cigniti
     */
    public String verifyPopupMessageForETAUpdate() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.notificationMessage, "ETA Updated Message Popup");
        String message=getText(CRHomePage.notificationMessage, "ETA Updated Message Popup");
        return message;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyETATime
     * description :: This method is used to verify ETA time
     * date :: 17-01-2018
     * author ::Cigniti
     */
    public String verifyETATime() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.etaTime, "ETA Time");
        String etaTime = getText(CRHomePage.etaTime, "ETA Time");
        String eta=etaTime.substring(0,5);
        return etaTime;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyETATime
     * description :: This method is used to click on workflow dropdown button and select only for RAP workflow
     * date :: 17-01-2018
     * author ::Chandu
     */
    public void workFlowSelectionForRAP() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.workFlowDropDown, "WorkFlow dropdown");
        click(CRHomePage.workFlowDropDown, "Workflow dropdown");
        click(CRHomePage.menuRapCallSelction, "RAP workflow selection");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: GetCallElapsedTime
     * description :: This function gets the elapsed time of the call
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public String GetCallElapsedTime() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblElapsedTime, "Elapsed Time");
        String elapsedTime = getText(CRHomePage.lblElapsedTime, "Elapsed Time");
        return elapsedTime;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonOnRecentCallsWindow
     * description :: This function clicks on Close Button on Recent Calls PopUp window
     * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnCloseButtonOnRecentCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnCloseOnRecentCallsWindow, "Close Icon");
        click(CRHomePage.btnCloseOnRecentCallsWindow, "Close Icon");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContinueButtonOnWarningWindow
     * description :: This function clicks on Continue button on Warning Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnContinueButtonOnWarningWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnKillCallContinue, "Continue Button");
        click(CRHomePage.btnKillCallContinue, "Continue Button");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExpandAllCommentsInStausHistoryWindow
     * description :: This function clicks Expand All Comments link on Status History Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnExpandAllCommentsInStausHistoryWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.linkExpandAllComments, "Expand All Comments");
        click(CRHomePage.linkExpandAllComments, "Expand All Comments");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: GetCommentsFromStatusHistoryWindow
     * description :: This function gets the comments frm Status History Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public String GetCommentsFromStatusHistoryWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtCommentsStatusHistoryWindow, "Comments");
        String comments = getText(CRHomePage.txtCommentsStatusHistoryWindow, "Comments");
        return comments;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallSummaryButton
     * description :: This function clicks on Call Summary BUtton
     * * date :: 18-Jan-2018
     * author :: Sachin
     */

    public void clickOnCallSummaryButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconCallSummary, "Call Summary");
        click(CRHomePage.iconCallSummary, "Call Summary");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: saveButton
     * description :: This function clicks on Save button
     * date :: 05-Nov-2017
     * author :: Cigniti
     */
    public void savButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnSaveArchCall, "Save button");
        click(CRHomePage.btnSaveArchCall, "Save button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnStatusHistoryPage
     * description :: This function clicks on Close Icon on Status History Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnCloseIconOnStatusHistoryPage() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconCloseOnStatusHostoryWindow, "Close Icon");
        click(CRHomePage.iconCloseOnStatusHostoryWindow, "Close Icon");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAutospotFailMsgOk
     * description ::To click on Ok on Autospot Fail Msg popup
     * * date :: 22-Jan-2018
     * author :: Nidhi
     */

    public void clickOnAutospotFailMsgOk() throws Throwable {
        if(isVisibleOnly(CRHomePage.autospotFailMsgOk, "ok button"))
        {
            click(CRHomePage.autospotFailMsgOk, "ok button");
        }
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::getErrorMessageTextFromAlert
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void getErrorMessageTextFromAlert() throws Throwable {
        if(isVisibleOnly(CRHomePage.lblErrorMessage, "Error message button"))
        {
            String err = getText(CRHomePage.lblErrorMessage, "error message button");
            click(CRHomePage.unDefinedError, "Closed Error message");
        }
        else
            reporter.SuccessReport("Status", "Saved successful");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::CloseLogoutAlert
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void CloseLogoutAlert()  throws Throwable{
        boolean exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
        int counter = 0;
        while (!exist){
            acceptAlert();
            Thread.sleep(5000);
            exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
            if (exist){
                break;
            }
            if(counter > 10){
                break;
            }
            counter = counter + 1;
        }
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::verifyErrorMessageVisibility
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public boolean verifyErrorMessageVisibility() throws Throwable{
        boolean errorMessageVisibility = isVisibleOnly(CRHomePage.lblErrorMessageOnUndefinedError,"Error message");
        return errorMessageVisibility;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName ::getErrorMessageFromPopup
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public String getErrorMessageFromPopup() throws Throwable{
        String errorMessage = getText(CRHomePage.lblErrorMessageOnUndefinedError,"Error message");
        return errorMessage;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::clickOnOkayButtonInErrorAlert
     * description::
     * date :: 23-Feb2017
     * author :: cigniti
     */
    public void clickOnOkayButtonInErrorAlert() throws Throwable{
        click(CRHomePage.unDefinedError,"Okay button");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCurrentCall
     * description :: click On CurrentCall
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void clickOnCurrentCall() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblCurrentCall, "Current call");
        click(CRHomePage.lblCurrentCall, "Current call");
        Thread.sleep(5000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDispatchStatusUpdate
     * description :: click On Dispatch Status Update
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void clickOnDispatchStatusUpdate() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher update status ");
        click(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        Thread.sleep(5000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyDispatchStatusUpdateNotPresent
     * description :: verifyDispatchStatusUpdateNotPresent
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void verifyDispatchStatusUpdateNotPresent() throws Throwable {
        Thread.sleep(3000);
        isElementNotPresent(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        {
            reporter.SuccessReport("Dispatcher Update status", "window not displays");
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyDispatchStatusUpdatePresent
     * description :: verifyDispatchStatusUpdatePresent
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void verifyDispatchStatusUpdatePresentAndClick() throws Throwable {
        Thread.sleep(3000);
        isVisibleOnly(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        click(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        {
            reporter.SuccessReport("Dispatcher Update status", "window displays");
        }
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verify Add phone number
     * description :: verify Add phone number
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void verifyAddPhoneNumber() throws Throwable {
        Thread.sleep(3000);
        getText(CRHomePage.lblAddPhone,"Add phone number text");

    }

    public void enterCallStatus(String callStatus) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtCallStatus, "Call Status");
        type(CRHomePage.txtCallStatus, callStatus, "Call Status");
    }

    public String getTextCallIdOnSearchCalls() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.linkCallIdOnSearchCalls, "Click on CallId Link");
        String callId = getText(CRHomePage.linkCallIdOnSearchCalls, "Click on CallId Link");
        return  callId;
    }

    public void clickOnSearchButton() throws Throwable {
    	if (isVisibleOnly(CRHomePage.searchCallButton, "Search Call Button")){
    		click(CRHomePage.searchCallButton, "Search Call Button");
    	}
    }
    public String getTroubleCodeValueFromCallDetailsPopup() throws Throwable{
        String troubleCode=getText(CRHomePage.lblTroubleCodeSummaryOnCallSummaryPopup,"Trouble Code value is:");
        return troubleCode;
    }
    public void closeCallSummaryPopupWindow() throws Throwable{
        click(CRHomePage.icnCLoseCallSummaryPopUpWindow,"Close call Summary Popup window");
    }    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: leave call
     * description :: clicks on leave call and accepts alert pop ups
     * date :: 08-March-2018
     * author :: Sri Harish Mukthavi
     */
    public void leavecall() throws Throwable {
    	leaveButton();
        allErrorAlerts();
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getcallStatus
     * description ::get text of call status
     * date :: 13-March-2018
     * author :: nidhi
     */
    public String getcallStatus() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblCallStatus, "status");
        String status = getText(CRHomePage.lblCallStatus, "status");
        return status;
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
        waitForVisibilityOfElement(CRHomePage.lblFacilityOnTopBar, "facility label");
        String facility_label = getText(CRHomePage.lblFacilityOnTopBar, "facility label");
        return facility_label;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectCannedComment
     * description :: This function selects a Canned Comment.
     * date :: 0
     * author ::
     */
    public void selectCannedComment(String comment) throws Throwable {
        click(CRHomePage.ddnselCannedComments(comment),""+comment);
    }



    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickMmbSplEntitlementLink
     * description ::Click on spl entitlement link on members tab for premium member
     * date :: 19-March-2018
     * author :: Varun
     */
    public void clickMmbSplEntitlementLink() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lnkMemberSplEntitlements, "Special entitlement");
        click(CRHomePage.lnkMemberSplEntitlements,"Special entitlement");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectHLOCKMmbSplEntitlementLinkChkBox
     * description ::Select HLOCK check box on spl entitlement link on members tab for premium member
     * date :: 19-March-2018
     * author :: Varun
     */
    public void selectHLOCKMmbSplEntitlementLinkChkBox() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.chkBoxMmrSplEntitlements, "HLOCK Special entitlement checkbox");
        click(CRHomePage.chkBoxMmrSplEntitlements,"HLOCK Special entitlement checkbox");

    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickHLOCKMmbSplEntitlementSaveBtn
     * description ::Click save button on spl entitlement on members tab for premium member
     * date :: 19-March-2018
     * author :: Varun
     */
    public void clickHLOCKMmbSplEntitlementSaveBtn() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnSplEntitlementsSave, "Save Button");
        click(CRHomePage.btnSplEntitlementsSave,"Save Button");

    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getTxtOfSplEntitlementCODEMmrTab
     * description ::get text and verify  spl entitlement Code on members tab for premium member
     * date :: 19-March-2018
     * author :: Varun
     */
    public String getTxtOfSplEntitlementCODEMmrTab() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtSplEntitlementCODE, "Special Entitlement Code");
        String splEntitlementCode= getText(CRHomePage.txtSplEntitlementCODE, "Special Entitlement Code");
        return splEntitlementCode;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallComments
     * description :: To enter call comments in comments text field
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void enterCallComments(String callComments) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtCallComments, "Call comments");
        type(CRHomePage.txtCallComments, callComments, "Call comments entered");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallCommentsAddButton
     * description :: Click on call comments add button
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnCallCommentsAddButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnCallsAdd, "Call comments Add button");
        click(CRHomePage.btnCallsAdd, "Call comments Add button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallCommentsButton
     * description :: To click On CallComments Button
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnCallCommentsButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnViewComments, "Call comments View button");
        click(CRHomePage.btnViewComments, "Call comments View button");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 29-Dec-2017
     * author :: Sachin
     */

    public void validateComentsInCommentPopUp(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRHomePage.txtCommentsCol, "Comments Column data");
        if (tableColumnData != null) {
            boolean commentDoesNotExist = true;
            // looping through all the comments in Comments window and coming out if the expected comment is found.
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                //assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in Comment PopUp window");
                if (existsVal) {
                    assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in Comment PopUp window");
                    commentDoesNotExist = false;
                    break;
                }
            }
            if (commentDoesNotExist) {
                assertTrue(false, "Comments entered not displayed in Comment PopUp window");
            }
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickIconMessageWindowClose
     * description :: To click On Icon-Close On MessageWindow
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickIconMessageWindowClose() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconMessageWindowClose, "Icon window close");
        click(CRHomePage.iconMessageWindowClose, "Icon window close");
    }

    public void clickOnloggedinUserName() throws Throwable{
        click(LoginPage.lblloggedinUserRole,"Logged in user role");
    }
    public String getUserRoleFromUserPopup() throws Throwable{
        String userRole=getText(CRHomePage.lblUserRole,"User role");
        return userRole;
    }
    public void clickOnUsersUnderHelpmenu() throws Throwable{
        click(CRHomePage.dropDwnHelp,"User help");
        click(CRHomePage.menuItemHelp,"Userhelp menuitem");
    }
    public void clickOnCloseButtonInUserInfoPopup() throws Throwable{
        click(CRHomePage.btnuserInfoClose,"Close Userinfo");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAPDButton
     * description :: To click On APD Window
     * date :: 11-Feb-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnAPDButton() throws Throwable {
        click(CRHomePage.btnAPD, "APD Button Is clickable");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAPDButton
     * description :: verifyAPDButton
     * date :: 11-Feb-2018
     * author :: Chandrasekhar Dendukuri
     */

    public boolean verifyAPDButton() throws Throwable {
        boolean apdButton=isVisibleOnly(CRHomePage.btnAPD, "APD Button");
        return apdButton;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAPDGrayButton
     * description :: verifyAPDGrayButton
     * date :: 11-Feb-2018
     * author :: Chandrasekhar Dendukuri
     */

    public boolean verifyAPDGrayButton() throws Throwable {
        boolean apdButtonDisabled=isVisibleOnly(CRHomePage.btnAPDDisabled, "APD Grayed out/Disabled");
        return apdButtonDisabled;
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterDataInOmniSearchBarOnHomePage
     * description :: To enter member number in member search
     * date :: 18-Apr-2018
     * author :: Madhukar
     */
    public void enterDataInOmniSearchBarOnHomePage(String Membersearch) throws Throwable {
        click(CRHomePage.txtSearchMemberText, "OmniSearchBar On HomePage");
        type(CRHomePage.txtSearchMemberText, Membersearch, "OmniSearchBar On HomePage");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButtonOfOmniSearchBarOnHomePage
     * description :: clickOnSearchButtonOfOmniSearchBarOnHomePage
     * date :: 18-Apr-2018
     * author :: Madhukar
     */
    public void clickOnSearchButtonOfOmniSearchBarOnHomePage() throws Throwable {
        click(CRHomePage.btnSearchButton, "Search Button");

    }

}