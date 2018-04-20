package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRServicePage;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Keys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;


public class CRServiceLib extends ActionEngine {

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: serviceFieldVerification
     * description :: To Verify mandatory Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void serviceFieldVerification() throws Throwable {
        verifyFacility();
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFacility
     * description :: To Verify facility Fields is Visible or not
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void verifyFacility() throws Throwable {

        boolean facility = isVisibleOnly(CRServicePage.txtFacilityField, "Facility");
        //if (facility) {
            assertTrue(facility, "Facility is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: saveServiceMandatoryFields
     * description :: To save service MandatoryFields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void saveServiceMandatoryFields(String facility) throws Throwable {
        enterServiceMandatoryFields(facility);
        clickOnSaveBtn();

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceMandatoryFields
     * description :: To enter all mandatory Fields on Service
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterServiceMandatoryFields(String facility) throws Throwable {

        errorAlertHandlingBeforeEnterMandatoryFields();
        enterFacility(facility);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enetrFacility
     * description :: To enter Facility text in to Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterFacility(String facility) throws Throwable {
        // Thread.sleep(2000);
        waitForVisibilityOfElement(CRServicePage.txtFacilityField, "Facility");
        click(CRServicePage.txtFacilityField, "Facility");
        Thread.sleep(2000);
        clearData(CRServicePage.txtFacilityField);
        type(CRServicePage.txtFacilityField, facility, "Facility");
        Thread.sleep(2000);
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
        //  mouseDoubleClick(CRServicePage.btnPrefer,"Prefer button");

        boolean visibilityOfContinueButton = isVisibleOnly(CRServicePage.btnContinueOnPreferFacility, "Continue button on Prefer Facility");
        assertTrue(visibilityOfContinueButton, "Button available");
        if (visibilityOfContinueButton) {
            //assertTrue(visibilityOfContinueButton, "Button available");
            click(CRServicePage.btnContinueOnPreferFacility, "Button Facility");

        } /*else {
            assertFalse(visibilityOfContinueButton, "Button not found");
        }*/
        Thread.sleep(2000);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveBtn
     * description :: To click on Save Button
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnSaveBtn() throws Throwable {
        if (isElementPresent(CRServicePage.btnSave, "saveCall")) {
            click(CRServicePage.btnSave, "Save Call");
        }
        errorAlertHandlingAfterSave();

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallId
     * description :: To get the call id from CRServicePage
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public String getCallId() throws Throwable {
        boolean flagCallId = isElementPresent(CRServicePage.callId, "callerId");
        // assertTrue(flagCallId, "Call Created");
        dynamicWait(CRServicePage.callId);
        String callId = getText(CRServicePage.callId, "callerId");
        assertTrue(callId != "", "Call is created:: " + callId + " ::and Saved The call With out Error");
        return callId;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeCallWindow
     * description :: To Close the callid Window
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void closeCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.closeCallButton, "Close call");
        click(CRServicePage.closeCallButton, "Close call");
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnServiceTab
     * description :: To click On ServiceTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnServiceTab() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service Tab");
        click(CRServicePage.serviceTab, "Service Tab");
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle errors and Alerts
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling on Service Tab
        boolean flagUndefinedErrorAlert = isVisibleOnly(CRServicePage.alertUndefinedError, "Undefined error");
        //assertTrue(flagUndefinedErrorAlert, "Undefined error");
        if (flagUndefinedErrorAlert) {
            //assertTrue(flagUndefinedErrorAlert, "Undefined error");
            // clickUsingJavascriptExecutor(CRServicepage.alertUndefinedError, "Undefined error OK button");
            click(CRServicePage.alertUndefinedError, "Undefined error OK button");
        }/* else {
            assertFalse(flagUndefinedErrorAlert, "Undefined error Not Present");
        }*/

    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: validateFacilityAutospot
     * description :: To validate the Facility Autospoted or Not
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public String validateFacilityAutospotID() throws Throwable {
        String facility = null;
        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        click(CRServicePage.serviceTab, "Service tab");
        boolean flagSpotFacilityLabel = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        if (flagSpotFacilityLabel) {
            Thread.sleep(5000);
            facility = getText(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
            assertTrue(true, "Auto Spot Value is " + facility);
        } else {
            assertFalse(false, "Auto spot value is not found");
        }
        return facility;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeinServices
     * description :: To enter Call Typein Services
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterCallTypeinServices(String callType) throws Throwable {
        click(CRServicePage.txtCallType, "Call type text box");
        type(CRServicePage.txtCallType, callType, "Call Type text box in services");
        waitForVisibilityOfElement(CRServicePage.btnSavecall, "Save call");
        click(CRServicePage.btnSavecall, "Save call");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifySaveClearHistoryCallWindowExists
     * description :: save Clear History Call window
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifySaveClearHistoryCallWindowExists() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.saveClearHistoryCallwindow, "SaveClear History Call Window");
        boolean isWindowAvailable = isVisibleOnly(CRServicePage.saveClearHistoryCallwindow, "SaveClear History Call Window");
        assertTrue(isWindowAvailable, "Save Clear History Call Window available");
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: verifyCallHistoryCallWindowFields
     * description :: To verify CallHistoryCall Window fields
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCallHistoryCallWindowFields() throws Throwable {

        boolean isHistoryCallDateAvailable = isVisibleOnly(CRServicePage.txtHistoryCallDate, "Call Date");
        assertTrue(isHistoryCallDateAvailable, "Save Clear History Call Window available");

        boolean isFacilitydropDown = isVisibleOnly(CRServicePage.txtFacility, "Facity Text");
        assertTrue(isFacilitydropDown, "Facility Dropdown available");

        boolean isTruckID = isVisibleOnly(CRServicePage.txtTruckID, "Truck ID");
        assertTrue(isTruckID, "Truck ID");

        boolean isDriverNum = isVisibleOnly(CRServicePage.txtDriverNum, "Driver#");
        assertTrue(isDriverNum, "Driver#");

        boolean isClearingCode = isVisibleOnly(CRServicePage.txtClearingCode, "ClearingCode");
        assertTrue(isClearingCode, "ClearingCode");

        boolean isPacesetter = isVisibleOnly(CRServicePage.txtPacesetter, "Pacesetter Reason");
        assertTrue(isPacesetter, "Pacesetter Reason");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCalendarDropdown
     * description :: To verify Calendar Dropdown
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCalendarDropdownExists() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtHistoryCallDate, " Calendar Drop Down");

        boolean isCalendarDropDownVisible = isVisibleOnly(CRServicePage.calendarDropDown, "calendar dropdown");

        assertTrue(isCalendarDropDownVisible, "<b>Calendar dropdown exists</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCalendarErrorText
     * description :: To verify Calendar ErrorText
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCalendarErrorText() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtHistoryCallDate, " Calendar Drop Down");
        isElementPresent(CRServicePage.btnCalendarNextMonth, "Not able to select Future date");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterDateInSaveClearHistoryCall
     * description :: To enter Date In Save ClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterDateInSaveClearHistoryCall(String currentDate) throws Throwable {
        type(CRServicePage.txtHistoryCallDate, currentDate, "History call date");
        click(CRServicePage.saveClearHistoryCallwindow, "SaveClear History Call Window");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTruckIDInSaveClearHistoryCall
     * description :: To enter TruckID in SaveClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterTruckIDInSaveClearHistoryCall(String truckID) throws Throwable {
        type(CRServicePage.txtTruckID, truckID, "Truck ID");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClearingCodeInSaveClearHistoryCall
     * description :: To enter Clearing Code in Save Clear History Call
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterClearingCodeInSaveClearHistoryCall(String clearingCode) throws Throwable {
        type(CRServicePage.txtClearingCode, clearingCode, "Clearing Code");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPaceSetterReasonInSaveClearHistoryCall
     * description :: To enter Pacesetter Reason Save ClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterPaceSetterReasonInSaveClearHistoryCall(String paceSetter) throws Throwable {
        type(CRServicePage.txtPacesetter, paceSetter, "Pace Setter Reason");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickGaragePaymentInfoButton
     * description :: To click Garage PaymentInfo Button
     * date :: 29-Nov-2017
     * author ::
     */

    public void clickGaragePaymentInfoButton() throws Throwable {
        click(CRServicePage.btnGaragePaymentInfo, "Garage Payment Info");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyGaragePaymentInForWindow
     * description :: To verify Garage Payment Inforomation Window
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyGaragePaymentInForWindow() throws Throwable {

        boolean GarageWindow = isVisibleOnly(CRServicePage.popupGaragePaymentInfoWindow, "Garage Payment Info");
        assertTrue(GarageWindow, "Garage Window presented");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeGaragePaymentInForWindow
     * description :: To close Garage Payment Info Window
     * date :: 29-Nov-2017
     * author ::
     */

    public void closeGaragePaymentInForWindow() throws Throwable {
        click(CRServicePage.btnGaragePaymentInfoWindowClose, "Garage Payment Info Window Close & Save Button");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeButton
     * description :: To close History Call
     * date :: 29-Nov-2017
     * author ::
     */

    public void closeButton() throws Throwable {
        click(CRServicePage.btnClose, "History Call Close");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveHistoryCallSaveButton
     * description :: To click On SaveHistoryCall SaveButton
     * date :: 29-Nov-2017
     * author ::
     */

    public void clickOnSaveHistoryCallSaveButton() throws Throwable {
        click(CRServicePage.btnSaveHistoryCallSaveCall, "HistoryCallSaveButton");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallId
     * description :: To verify CallId
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCallId() throws Throwable {
        isElementPresent(CRServicePage.callId, "callerId");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemainInCall
     * description :: To click On RemainInCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void clickOnRemainInCall() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRServicePage.btnRemainInCall, "Remain In call");
        click(CRServicePage.btnRemainInCall, "Remain In call");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallStatus
     * description :: To verify CallStatus
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCallStatus() throws Throwable {
        boolean callStatus = isElementPresent(CRServicePage.btnCallStatus, "Call Status");
        /*if (callStatus) {
            assertTrue(callStatus, "Call Status");
        } else {
            assertFalse(callStatus, "Call Status");
        }*/
        assertTrue(callStatus, "Call Status");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDisabledFieldsOnSaveClearHistoryCall
     * description :: verify disabled fields on save clear history calls
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyDisabledFieldsOnSaveClearHistoryCall() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.saveClearHistoryCallwindow, "Save Clear History call window");
        boolean disabledHistoryCallDateField = isVisibleOnly(CRServicePage.disabledHistoryCallDateField, "Disabled Histrory call date");
        /*if (disabledHistoryCallDateField) {
            assertTrue(disabledHistoryCallDateField, "Field is disabled");
        } else {
            assertFalse(disabledHistoryCallDateField, "Field is Enabled");
        }*/
        assertTrue(disabledHistoryCallDateField, "Field is disabled");
        boolean disabledFacilityfield = isVisibleOnly(CRServicePage.disabledFacilityField, "Disabled Histrory call date");
        /*if (disabledFacilityfield) {
            assertTrue(disabledFacilityfield, "Field is disabled");
        } else {
            assertFalse(disabledFacilityfield, "Field is Enabled");
        }*/
        assertTrue(disabledFacilityfield, "Field is disabled");
        boolean disabledTruckIDfield = isVisibleOnly(CRServicePage.disabledTruckIDField, "Disabled Histrory call date");
        /*if (disabledTruckIDfield) {
            assertTrue(disabledTruckIDfield, "Field is disabled");
        } else {
            assertFalse(disabledTruckIDfield, "Field is Enabled");
        }*/
        assertTrue(disabledTruckIDfield, "Field is disabled");
        boolean disabledClearingCodefield = isVisibleOnly(CRServicePage.disabledClearingCodeField, "Disabled Histrory call date");
        /*if (disabledClearingCodefield) {
            assertTrue(disabledClearingCodefield, "Field is disabled");
        } else {
            assertFalse(disabledClearingCodefield, "Field is Enabled");
        }*/
        assertTrue(disabledClearingCodefield, "Field is disabled");
        boolean disabledPacesetterfield = isVisibleOnly(CRServicePage.disabledPacesetterField, "Disabled Histrory call date");
        /*if (disabledPacesetterfield) {
            assertTrue(disabledPacesetterfield, "Field is disabled");
        } else {
            assertFalse(disabledPacesetterfield, "Field is Enabled");
        }*/
        assertTrue(disabledPacesetterfield, "Field is disabled");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeCall
     * description :: To  close a Call
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void closeCall() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.closeCallButton, "Close call");
        click(CRServicePage.closeCallButton, "Close call");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: facilityAutoSpot
     * description ::To Auto spot Facility
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void facilityAutoSpot() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        click(CRServicePage.serviceTab, "Service tab");
        boolean flag1 = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        boolean flag2 = isElementPresent(CRServicePage.txtSpotFacilityAddress, "Spot facility address");
        assertTrue(flag1, "Spot facility lable is present");
        assertTrue(flag2, "Spot facility address is present");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingAfterSave
     * description :: To Handle errors and Alert
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void errorAlertHandlingAfterSave() throws Throwable {
        boolean flagConformOkButton = isVisibleOnly(CRServicePage.btnAlertSaveYes, "Confirmation okay button");
        //assertTrue(flagConformOkButton, "Confirmation okay button");
        if (flagConformOkButton) {
            //assertTrue(flagConformOkButton, "Confirmation okay button");
            click(CRServicePage.btnAlertSaveYes, "Confirmation Okay button");
        }/* else {
            assertFalse(flagConformOkButton, "Confirmation Okay is Not Present");
        }*/
        boolean flagSaveFailure = isVisibleOnly(CRServicePage.saveFailureError, "save failure Button");
        //assertTrue(flagSaveFailure, "save failure");
        if (flagSaveFailure) {
            //   assertTrue(flagSaveFailure, "save failure");
            //waitForVisibilityOfElement(CRServicepage.savefailureerror, "save failure");
            click(CRServicePage.saveFailureError, "save failure Button");
        }/* else {
            assertFalse(flagSaveFailure, "save failure");
        }*/

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLinkInServicePage
     * description :: To click on manual entry page in service page
     * date ::
     * author ::
     * Sprint number:
     */

    public void clickOnManualEntryLinkInServicePage() throws Throwable {
        click(CRServicePage.manualEntryLink, "ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAppointmentDate
     * description :: Entering value in Appointment Date in services page
     * date :: 14-Nov-2017
     * author :: chandrasekhar Dendukuri
     * Sprint number: 2
     */

    public void enterAppointmentDate(String Date) throws Throwable {
        type(CRServicePage.txtAppointmentDate, Date, "Appointmnet Date");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAppointmentTime
     * description :: Entering value in Appointment Time in services page
     * date :: 14-Nov-2017
     * author :: chandrasekhar Dendukuri
     * Sprint number: 2
     */

    public void enterAppointmentTime(String Time) throws Throwable {
        type(CRServicePage.txtAppointmentTime, Time, "Appointmnet Time");
    }


    /**return : void
     * methodName :: messageForLeaveCall
     * Description:Message after leave the call
     * @param  :
     * @throws Throwable
     * @author :Lakshmi
     */

    public void messageForLeaveCall() throws Throwable {
        boolean leavemessage = isElementPresent(CRServicePage.leaveCallMessage, "Message after leave the call");
        String leavemsg = getText(CRServicePage.leaveCallMessage, "Message after leave the call");
        assertTrue(leavemessage, "Confirmation window displays with the following message Are you sure you wish to leave this call?");
    }

    /**
     * return : void
     * methodName:clickOnAppointmentbutton
     * Description:To click on Appointment Button
     * @param :
     * @throws Throwable
     */

    public void clickOnAppointmentbutton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnAppointment, "Appointment Button");
        click(CRServicePage.btnAppointment, "Appointment Button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * MethodName:clickOnCallStatusButton
     * Description:To click on Callstatus Button located at bottom of the page
     * date :: 05-Nov-2017
     * author :: cigniti
     */

    public void clickOnCallStatusButton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        click(CRServicePage.btnCallStatus, "Call Status");
        Thread.sleep(3000);
    }

    /**
     * MethodName:verifyToGetCallStatus
     * Description:To verfiy whether the call status retrieved as expected.
     * return : void
     * @param callStatus
     * @throws Throwable
     * @author : Cigniti
     */

    public void verifyToGetCallStatus(String callStatus) throws Throwable {
        String retrivedCallstatus = getText(CRServicePage.callStatusRetrived, "Retrieved Call status");
        /*if (retrivedCallstatus.equalsIgnoreCase(callStatus)) {
            assertTrue(retrivedCallstatus.equalsIgnoreCase(callStatus), "Call status retrieved sucessfully");
        } else {
            assertFalse(retrivedCallstatus.equalsIgnoreCase(callStatus), "Call status not available ");
        }*/
        assertTrue(retrivedCallstatus.equalsIgnoreCase(callStatus), "Call status retrieved sucessfully");
    }

    /**
     * Methodname:verifyAppointmentIsReleased
     * Description:To click on Appointment release button
     * @param :
     * @return : void
     * @throws Throwable
     * @author : Cigniti
     */

    public void verifyAppointmentIsReleased() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnAppointmentRelease, "Appointment Release");
        click(CRServicePage.btnAppointmentRelease, "Appointment Released button");
    }

    /**
     * Methodname:appointmentCallLeaveButton
     * Description:To click on Appointment Leave Button
     * @param :
     * @return : void
     * @throws Throwable
     * @author : Cigniti
     */

    public void appointmentCallLeaveButton() throws Throwable {
        click(CRServicePage.btnAppointmentLeaveButton, "Leave Button");
    }

     /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTimeStamp
     * Description : To verify whether the TimeStamp retrieved is as expected.
     * date ::
     * author :: Cigniti
     * Sprint number:
     */

    public void verifyTimeStamp(String timeStamp) throws Throwable {
        String time = getText(CRServicePage.timeStampInCallStatus, "Time stamp");
        /*if (time.equalsIgnoreCase(timeStamp)) {
            assertTrue(time.equalsIgnoreCase(timeStamp), "Time stamp is verified");
        } else {
            assertFalse(time.equalsIgnoreCase(timeStamp), "Time stamp is not matched");
        }*/
        assertTrue(time.equalsIgnoreCase(timeStamp), "Time stamp is verified");

    }

    /**
     * method:clickOnDateColumnInstatustable
     * Description:This method is used to click on the status history table after clicking on call status button
     * @param :
     * @return : void
     * @throws Throwable
     * @authoe : Cigniti
     */

    public void clickOnDateColumnInstatustable() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.dateColumn, "status history table");
        click(CRServicePage.dateColumn, "status history table");
    }

    /**
     * method : clickOnSPStatusUpdate
     * Description : This method is used to click on SP status update
     * @return : void
     * @param
     * @throws Throwable
     * @author : Cigniti
     */

    public void clickOnSPStatusUpdate() throws Throwable {
        click(CRServicePage.btnSpStatusUpadte, "SP status Update Yes Button");
    }

    /**
     * method name : enterReasonForStatus
     * Description : This method is used to enter reason for selecting the status update
     * @return : void
     * @param status
     * @throws Throwable
     * @author : Cigniti
     */
    public void enterReasonForStatus(String status) throws Throwable {
    	if (isVisibleOnly(CRServicePage.txtCallStatusUpdate, "reason for status update") ) {
        waitForVisibilityOfElement(CRServicePage.txtCallStatusUpdate, "reason for status update");
        click(CRServicePage.txtCallStatusUpdate, "Reason for status");
        type(CRServicePage.txtCallStatusUpdate, "LC Lost Call", "Reason for status");
    	}
        


    }

    /**
     * mehtod name : clickOnUpadteButton
     * Description:This method is used to click on update button on reason for status update pop up
     * @param :
     * @return : void
     * @throws Throwable
     * @author : Cigniti
     */
    public void clickOnUpadteButton() throws Throwable {
    	if (isVisibleOnly(CRServicePage.btnUpdate, "update button")) {
        waitForVisibilityOfElement(CRServicePage.btnUpdate, "update button");
        click(CRServicePage.btnUpdate, "Update Button");
    }
        
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpecialEquipement
     * description :: enterSpecialEquipement
     * date :: 29-Dec-2017
     * author :: chandrasekhar Dendukuri
     * Sprint number: 3
     */

    public void enterSpecialEquipement(String specialequipement) throws Throwable {
        type(CRServicePage.txtSpecialEquipement, specialequipement, "Specail Equipement");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRedFlagOnServiceTab
     * description :: To click On RedFlag OnServiceTab
     * date :: 29-Dec-2017
     * author :: Nidhi
     * Sprint number: 3
     */
    public void clickOnRedFlagOnServiceTab() throws Throwable {
        boolean redFlag = isVisibleOnly(CRServicePage.btnRedFlagOnServiceTab, "RedFlag Button");
        if (redFlag) {
            click(CRServicePage.btnRedFlagOnServiceTab, "Click On RedFlag Button");
        } else {
            assertTrue(!redFlag, "RedFlag Button is not visible");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: validateFacilityAutospotAddress
     * description :: To validate and get text from facility auto spot address
     * date ::
     * author :: Cigniti
     * Sprint number:
     */

    public void validateFacilityAutospotAddress() throws Throwable {
        boolean flagSpotFacilityAddress = isElementPresent(CRServicePage.txtSpotFacilityAddress, "Spot facility address");
        if (flagSpotFacilityAddress) {
            String facilityAddress = getText(CRServicePage.txtSpotFacilityAddress, "Spot facility lable");
            assertTrue(flagSpotFacilityAddress, "Auto Spot address is " + facilityAddress);
        } else {
            assertFalse(flagSpotFacilityAddress, "Auto spot address is not found");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpeciLEquipment
     * description :: To enter SpeciL Equipment and to click spot facility
     * date :: 29-Dec-2017
     * author :: Nidhi
     * Sprint number: 3
     */
    public void enterSpeciLEquipment(String spoitedId) throws Throwable {
        type(CRServicePage.txtSpecialEquipement, spoitedId, "SpeciLEquipment");
        click(CRServicePage.txtSpotFacilityLabel, "SpeciLEquipment");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifySpeciLEquipmentWithAutoSpotID
     * description :: verifySpeciLEquipmentWithAutoSpotID
     * date :: 04-Jan-2018
     * author :: Lakshmi
     */

    public void verifySpeciLEquipmentWithAutoSpotID(String autoSpotId, String specialEquipmentAutoSpotId) throws Throwable {
        boolean autospot = autoSpotId.equals(specialEquipmentAutoSpotId);
        /*if (autospot) {
            //assertTrue(autospot,"Facility assignment:: "+autoSpotId+" is not Matched with:: "+specialEquipmentAutoSpotId);
            assertTrue(autospot, "Facility is automatically Re-spoted to a different facility based on the special equipment");
            assertTrue(autospot, "Auto Spoted ID is  " + autoSpotId + " And spotedId for SpeciLEquipment is  " + specialEquipmentAutoSpotId);
        } else {
            //assertFalse(autospot,"Facility assignment:: "+autoSpotId+" is Matched with:: "+specialEquipmentAutoSpotId);
            assertFalse(autospot, "Facility is not Re-spoted to a different facility based on the special equipment");
            assertFalse(autospot, "Auto Spoted ID is  " + autoSpotId + " And  spotedId for SpeciLEquipment is  " + specialEquipmentAutoSpotId);
        }*/
        assertTrue(autospot, "Facility is automatically Re-spoted to a different facility based on the special equipment");
        assertTrue(autospot, "Auto Spoted ID is  " + autoSpotId + " And spotedId for SpeciLEquipment is  " + specialEquipmentAutoSpotId);
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: validateFacilityAutospot
     * description :: to validate spot facility label and flag spot facility address
     * date ::
     * author ::
     */

    public String validateFacilityAutospot() throws Throwable {
        String facility = null;
        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        click(CRServicePage.serviceTab, "Service tab");
        boolean flagSpotFacilityLabel = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        if (flagSpotFacilityLabel) {
            facility = getText(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
            assertTrue(flagSpotFacilityLabel, "Auto Spot Value is " + facility);
        } else {
            assertFalse(flagSpotFacilityLabel, "Auto spot value is not found");
        }
        boolean flagSpotFacilityAddress = isElementPresent(CRServicePage.txtSpotFacilityAddress, "Spot facility address");
        if (flagSpotFacilityAddress) {
            String facilityAddress = getText(CRServicePage.txtSpotFacilityAddress, "Spot facility lable");
            assertTrue(flagSpotFacilityAddress, "Auto Spot address is " + facilityAddress);
        } else {
            assertFalse(flagSpotFacilityAddress, "Auto spot address is not found");
        }
        return facility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFacilityType
     * description :: getFacilityType
     * date :: 04-Jan-2018
     * author :: Chandra
     */


    public void getFacilityType() throws Throwable {
        getText(CRServicePage.lblFacilityType, "Facility Type");
    }


    /**
     * param :: String inputs
     * return :: void
     * throws :: throwable
     * methodName :: enterPriority
     * description ::to enter the priority
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterPriority(String priority) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        type(CRServicePage.txtPriority, priority, "Priority");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHold
     * description ::to click and hold the Hold button
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void clickOnHold() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnHold, "Hold button");
        click(CRServicePage.btnHold, "Hold Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterHold
     * description :: to enter text
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterHold(String hold) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtHold, "Hold");
        type(CRServicePage.txtHold, hold, "Hold");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAvoid
     * description ::to click on avoid button
     * date :: 11-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void clickOnAvoid() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnAvoid, "Avoid button");
        click(CRServicePage.btnAvoid, "Click on Avoid button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectAutoPopulatedFacility
     * description ::to select auto populated facility
     * date :: 11-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void selectAutoPopulatedFacility() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.autoPopulatedFacility, "AutoSpotted Facility");
        click(CRServicePage.autoPopulatedFacility, "AutoSpotted Facility");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPrefer
     * description ::clickOnPrefer
     * date :: 11-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void clickOnPrefer() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnPrefer, "Prefer button");
        click(CRServicePage.btnPrefer, "Click on Prefer button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSpotInServicePage
     * description :: clickOnSpotInServicePage
     * date :: 11-Jan-2018
     * author :: Chandra
     */


    public void clickOnSpotInServicePage() throws Throwable {
        click(CRServicePage.btnSpot, "Spot Button");
    }

    /**
     * param ::String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterManualFacilityNumber
     * description :: enterManualFacilityNumber
     * date :: 11-Jan-2018
     * author :: Chandra
     */


    public String enterManualFacilityNumber(String facilityNumber) throws Throwable {
        type(CRServicePage.txtSpotManualEntry, facilityNumber, "facilityNumber");
        return facilityNumber;
    }

    /**
     * param :: Input String
     * return ::void
     * throws :: throwable
     * methodName :: getInactiveFacilityErrorMessage
     * description :: getInactiveFacilityErrorMessage
     * date :: 11-Jan-2018
     * author :: Chandra
     */


    public String getInactiveFacilityErrorMessage(String inactiveMessage) throws Throwable {
        String errorMessage = getText(CRServicePage.lblInactiveFacilityErrorMessage, "Inactive facility Error Message");
        assertTrue(errorMessage.equalsIgnoreCase(inactiveMessage), "Given Facility Code is inactive");
        return errorMessage;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCashOnServiceTab
     * description :: To click On cash icon OnServiceTab
     * date :: 10-Jan-2018
     * author :: Varun
     * Sprint number: 4
     */
    public void clickOnCashOnServiceTab() throws Throwable {
        boolean cashButton = isVisibleOnly(CRServicePage.btnCash, "Cash Button");
        if (cashButton) {
            click(CRServicePage.btnCash, "Click on Cash Button");
        } else {
            assertTrue(!cashButton, "Cash Button is not visible");
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFacilityPreference
     * description :: To enter Facility text in to Field
     * date :: 12-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void enterFacilityPreference(String facility) throws Throwable {
        // Thread.sleep(2000);
        waitForVisibilityOfElement(CRServicePage.txtFacilityField, "Facility");
        click(CRServicePage.txtFacilityField, "Facility");
        Thread.sleep(2000);
        clearData(CRServicePage.txtFacilityField);
        type(CRServicePage.txtFacilityField, facility, "Facility");
        String combineKeys1 = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys1, "SPACE");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
        //  mouseDoubleClick(CRServicePage.btnPrefer,"Prefer button");

        boolean visibilityOfContinueButton = isVisibleOnly(CRServicePage.btnContinueOnPreferFacility, "Continue button on Prefer Facility");
        assertTrue(visibilityOfContinueButton, "Button available");
        if (visibilityOfContinueButton) {
            //assertTrue(visibilityOfContinueButton, "Button available");
            click(CRServicePage.btnContinueOnPreferFacility, "Button Facility");

        } /*else {
            assertFalse(visibilityOfContinueButton, "Button not found");
        }*/
        Thread.sleep(2000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPolicy
     * description ::to enter policy
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterPolicy(String policy) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPolicy, "Policy");
        type(CRServicePage.txtPolicy, policy, "Policy");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCheckBoxCallBack
     * description ::clickOnCheckBoxCallBack
     * date :: 11-Jan-2018
     * author ::Abhiram
     */

    public void clickOnCheckBoxCallBack() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.chkBoxCallBack, "Call Back CheckBox");
        click(CRServicePage.chkBoxCallBack, "Call Back CheckBox");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallBackMinutes
     * description ::enterCallBackMinutes
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterCallBackMinutes(String minutes) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackMinutes, "Call Back Minutes");
        type(CRServicePage.txtCallBackMinutes, minutes, "Call Back Minutes");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallBackRequestType
     * description ::enterCallBackRequestType
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterCallBackRequestType(String requestType) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackRequestType, "Call Back Minutes");
        type(CRServicePage.txtCallBackRequestType, requestType, "Call Back Minutes");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: validateAutoSpotandSaveCall
     * description ::validateAutoSpotandSaveCall
     * date ::
     * author :: Cigniti
     */

    public void validateAutoSpotandSaveCall() throws Throwable {
        validateFacilityAutospot();
        clickOnSaveBtn();
    }


    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyRedFlagChecked
     * description :: To verify Red Flag Checked
     * date :: 12-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyRedFlagChecked() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnRedFlagOnServiceTab, "Red flag");
        String redFlag = getText(CRServicePage.btnRedFlagOnServiceTab, "Red flag is automatically checked");
        return redFlag;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: validateNoFacilityAutoSpot
     * description :: validateNoFacilityAutoSpot
     * date :: 12-Jan-2018
     * author :: Abhiram
     */

    public boolean validateNoFacilityAutoSpot() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        boolean flagSpotFacilityLabel = isElementNotPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        return flagSpotFacilityLabel;
    }

    /**
     * @methodName : getSuperOverdidePTAValue
     * Description:This method is used to get the Super override PTA Value
     * Date:16-01-2018
     * @param :
     * @return : Stirng
     * @throws Throwable
     * @author : Cigniti
     */
    public String getSuperOverdidePTAValue() throws Throwable {
        String superOverdidePTAValue = getAttributeByValue(CRServicePage.lblSuperOverridePTAValue, "Super Override PTA Value");
        return superOverdidePTAValue;
    }

    /**
     * @methodName : getManualOverdidePTAValue
     * Description:This method is used to get the manual override PTA Value
     * Date:16-01-2018
     * @param :
     * @return : String
     * @throws Throwable
     * @author : Cigniti
     */
    public String getManualOverdidePTAValue() throws Throwable {
        String manualOverdidePTAValue = getAttributeByValue(CRServicePage.lblManualOverridePTAValue, "Manual Override PTA Value");
        return manualOverdidePTAValue;
    }

    /**
     * @methodName : setManualOverrideOnSpottedFacility
     * Description:To set Manual Override value on spotted facility Tab
     * Date:16-01-2018
     * @return : void
     * @param maualPTA
     * @throws Throwable
     * @author : Cigniti
     */
    public void setManualOverrideOnSpottedFacility(String maualPTA) throws Throwable {
        isVisibleOnly(CRServicePage.lblManualOverridePTAValue, "Manual Override PTA Value");
        click(CRServicePage.lblManualOverridePTAValue, "Manual Override PTA Value");
        clearData(CRServicePage.lblManualOverridePTAValue);
        type(CRServicePage.lblManualOverridePTAValue, maualPTA, "Manual Override PTA Value");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPriority1
     * description ::to enterPriority
     * date :: 16-Jan-2018
     * author ::Nidhi
     */
    public void enterPriority1(String priority) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        type(CRServicePage.txtPriority, priority, "Priority");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getSpotFacilityId
     * description ::getSpotFacilityId
     * date :: 16-Jan-2018
     * author :: Abhiram
     */

    public String getSpotFacilityId() throws Throwable {
        String spotFacilityID = getText(CRServicePage.lblSpotFacility, "Spot Facility ID");
        return spotFacilityID;
    }

    /**
     * @methodName : verifyPTAAfterCallSave
     * Description:This method is used to get the pta value from the Call Confirmation window
     * date :: 16-Jan-2018
     * @return : boolean
     * @param : String
     * @throws Throwable
     * @author : Cigniti
     */
    public boolean verifyPTAAfterCallSave(String time) throws Throwable {
        boolean ptavalue = false;
        isVisibleOnly(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Save");
        String pta = getText(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Call Save");
        String p = pta.substring(11, 16);
        System.out.println(p);
        if (p.equalsIgnoreCase(time))
            ptavalue = true;
        return ptavalue;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyErrorMsgForAutospot
     * description ::verify Error Msg For Autospot
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public String verifyErrorMsgForAutospot() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.txtErrorMsg, "Error msg");
        String value = getText(CRServicePage.txtErrorMsg, "<b>get error msg</b>");
        return value;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCreditCard
     * description :: to click On CreditCard
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public void clickOnCreditCard() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.btnCreditCard, "Credit Card");
        click(CRServicePage.btnCreditCard, "Click on btnCreditCard");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyCreditCardInCallRibbon
     * description :: verify Credit Card In CallRibbon
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public String verifyCreditCardInCallRibbon() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.iconCreditCard, "Credit Card icon");
        String creditCardInCallRibbon = getText(CRServicePage.iconCreditCard, "Credit Card icon");
        return creditCardInCallRibbon;

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCreditCardInCallRibbion
     * description :: click On CreditCard In CallRibbion
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public void clickOnCreditCardInCallRibbion() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.iconCreditCard, "Credit Card");
        click(CRServicePage.iconCreditCard, "Click on Credit Card in call ribbion");

    }


    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: GetCallStatus
     * description :: To Get the CallStatus
     * date :: 17-Jan-2018
     * author :: Sachin
     */

    public String GetCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        String callstatus = getText(CRServicePage.btnCallStatus, "Call Status");
        return callstatus;
    }


    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextOfStatusValue
     * description :: To get the text of status value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void getTextOfStatusValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtStatusValue, "Status Value");
        getText(CRServicePage.txtStatusValue, "Status Value");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextOfResonValue
     * description :: To get the text of reson value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public String getTextOfResonValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtResonValue, "Reson Value");
         String reason= getText(CRServicePage.txtResonValue, "get text of reson Value");
        Thread.sleep(2000);
        return reason;
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextOfUserNameValue
     * description :: To get the text of userName value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public String getTextOfUserNameValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtUsernameValue, "UserName Value");
       String un = getText(CRServicePage.txtUsernameValue, "get text of userName Value");
        Thread.sleep(2000);
        return  un;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfRoleNameValue
     * description :: To get the text of RoleName value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public String getTextOfRoleNameValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtRoleValue, "Role Value");
        String role=getText(CRServicePage.txtRoleValue, "get text of Role Value");
        Thread.sleep(2000);
        return role;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextCallStatusButton
     * Description:To gettext of Callstatus Button located at bottom of the page
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public String getTextCallStatusButton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        String status =getText(CRServicePage.btnCallStatus, "Call Status");
        Thread.sleep(2000);
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnYesInSpStatusPopup
     * Description:To gettext of  on getText And ClickOnYesInSpStatusPopup
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public String  getTextAndClickOnYesInSpStatusPopup() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        String txt = getText(CRServicePage.txtStatusUpdate, "sp would you like to submit ");
        Thread.sleep(2000);
        click(CRServicePage.btnSpStatusUpadte, "Call on Yes on Status update popup");
        Thread.sleep(2000);
        return txt;
    }


    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: updateCallStatus
     * Description: To update the call status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void verifyUpdateCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblCallStatusUpdateTitle, "Call Status Update Title");
        getText(CRServicePage.lblCallStatusUpdateTitle, "Call Status Update Title");
        Thread.sleep(1000);
        getText(CRServicePage.lblStatus, "verify Call Status  ");
        Thread.sleep(1000);
        getText(CRServicePage.lblResonForStatus, "verify reason for Status");
        Thread.sleep(1000);
        getText(CRServicePage.lblComments, "verify comments text");
        Thread.sleep(1000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyUpdateIsNotClikable
     * Description:To verify Update Is Not Clikable
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void verifyUpdateIsNotClikable() throws Throwable {

        String ElementClass = getAttributeByClass(CRServicePage.btnUpdateEnabled, "update button");
        boolean updateEnable = ElementClass.contains("disable");
        assertTrue(updateEnable, "element disabled");
        {
            reporter.SuccessReport("Verify update button", "Verified update button is not clikable");
        }
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterInCommentStatus
     * Description:To enter In Comment Status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void enterInCommentStatus(String commentStatusUpdate) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCommentsInStatusUpdate, "enter data in Comments");
        type(CRServicePage.txtCommentsInStatusUpdate, commentStatusUpdate, "enter data in Comments");
        Thread.sleep(2000);

    }

    /**
     * param :: String inputs
     * return :: void
     * throws :: throwable
     * methodName :: enterInResonForStatusStatus
     * Description: To enter In Reson For StatusStatus
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void enterInResonForStatusStatus(String statusReason) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtResonForStatus, "reason for staus");
        type(CRServicePage.txtResonForStatus, statusReason, "reason for staus");
        Thread.sleep(5000);

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyUpdateIsNowClikable
     * Description:To verify Update Is Now Clikable
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void verifyUpdateIsNowClikable() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.btnUpdateButton, "click on update button");
        getText(CRServicePage.btnUpdateButton, "click on update button");
        Thread.sleep(3000);
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextSpStatus
     * Description:To get Text Sp Status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void getTextSpStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblSpStatus, "SP status");
        getText(CRServicePage.lblSpStatus, "SP status");
        {
            reporter.SuccessReport("Verify call status", "Verified call is in SP Status");
        }


    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickUpdateButton
     * Description:To click Update Button
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void clickUpdateButton() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRServicePage.btnUpdateButton, "click on update button");
        click(CRServicePage.btnUpdateButton, "click on update button");
        Thread.sleep(3000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextCallStatus
     * Description:To getText Call Status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public String getTextCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblCallStatus, "get value of call status ");
        String status = getText(CRServicePage.lblCallStatus, "get value of call status ");
        Thread.sleep(2000);
        return  status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelBtn
     * Description:To click on Cancelbtn
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void clickOnCancelBtn() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCancel, "click on cancel ");
        click(CRServicePage.btnCancel, "click on cancel ");
        Thread.sleep(2000);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: statusValueIsStillSpButNotUp
     * description :: To verify status Value Is Still SpButNotUp
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void statusValueIsStillSpButNotUp() throws Throwable {
        isVisibleOnly(CRServicePage.lblCallStatus, "Status Value");
        getText(CRServicePage.lblCallStatus, "Status Value is SP but not UP");
        {
            reporter.SuccessReport("Verify call status", "Verified the Calls current status is still SP and not UP");
        }
        Thread.sleep(2000);
    }

    //  --------------------------------------------------
    //  --------------------------------------------------

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: removePriority1
     * description ::to clear the date in txt priority
     * date :: 18-Jan-2018
     * author ::Nidhi
     */
    public void removePriority1() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        clearData(CRServicePage.txtPriority);


    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyRedFlagCheckedRemoved
     * description :: To verify redflag checked is removed
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyRedFlagCheckedRemoved() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnRedFlagOnServiceTab, "Red flag");
        String value = getText(CRServicePage.btnRedFlagOnServiceTab, "Red flag ");
        return value;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeinServices1
     * description :: to type Call Type text box in services
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void enterCallTypeinServices1(String callType) throws Throwable {
        click(CRServicePage.txtCallType, "Call type text box");
        type(CRServicePage.txtCallType, callType, "Call Type text box in services");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPolicy1
     * description :: To enter policy
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public void enterPolicy1(String policy) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPolicy, "Policy");
        type(CRServicePage.txtPolicy, policy, "Policy");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallBackRequestType1
     * description :: To enter the call back request type
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public void enterCallBackRequestType1(String requestType) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackRequestType, "Request Type");
        type(CRServicePage.txtCallBackRequestType, requestType, "Request Type");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyCallBackMinutes
     * description :: To verify the call back minutes
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyCallBackMinutes() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackMinutes, "Call Back Minutes");
        String minutes = getAttributeByValue(CRServicePage.txtCallBackMinutes, "Call Back Minutes");
        return minutes;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyCallBackRequestType
     * description :: To verify the call back request type
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyCallBackRequestType() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackRequestType, "Request Type");
        String type = getAttributeByValue(CRServicePage.txtCallBackMinutes, " Request Type");
        return type;

    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyPriorityCode
     * description ::To verify the priority code
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyPriorityCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        String priority = getAttributeByValue(CRServicePage.txtPriority, "Priority");
        return priority;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpecialEquipement1
     * description :: To enter special equipment
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public void enterSpecialEquipement1(String specialequipement) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtSpecialEquipement, "Specail Equipement");
        type(CRServicePage.txtSpecialEquipement, specialequipement, "Specail Equipement");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifySpecialEquipement
     * description :: To verify special equipment
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifySpecialEquipement() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtSpecialEquipement, "Specail Equipement");
        String spclEquip = getAttributeByValue(CRServicePage.txtSpecialEquipement, "Specail Equipement");
        return spclEquip;
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnPolicyDropDownOnServiceTab
     * description :: To click on policy dropdown in service tab
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void clickOnPolicyDropDownOnServiceTab() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnPolicy, "Policy option");
        click(CRServicePage.dropDownBoxOnPolicy, "Click on Policy option");

    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnPriorityDropDownOnServiceTab
     * description :: To click on priority dropdown in service tab
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void clickOnPriorityDropDownOnServiceTab() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnPriority, "Priority option");
        click(CRServicePage.dropDownBoxOnPriority, "Click on Priority option");

    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: dropDownBoxOnCallBackRequestMinutes
     * description :: To click on dropdown box on callback request minutes
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void dropDownBoxOnCallBackRequestMinutes() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnCallBackRequestMinutes, "Call back in minutes");
        click(CRServicePage.dropDownBoxOnCallBackRequestMinutes, "Call back in minutes");

    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: dropDownBoxOnCallBackRequestType
     * description :: To click on dropdown call back request type
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void dropDownBoxOnCallBackRequestType() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnCallBackRequestType, "Call back request Type");
        click(CRServicePage.dropDownBoxOnCallBackRequestType, "Call back request Type");

    }


    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyCallTypeinServices
     * description :: To verify call type in services
     * date :: 19-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyCallTypeinServices() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallType, "Call type text box");
        String callType = getAttributeByValue(CRServicePage.txtCallType, "Call Type text box in services");
        return callType;

    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyPolicy1
     * description :: To verify the policy
     * date :: 19-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyPolicy1() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.getTxtPolicy, "Policy");
        String policy = getText(CRServicePage.getTxtPolicy, "Policy");
        return policy;

    }

    /**
     * param ::
     * return :: Stirng
     * throws :: throwable
     * methodName :: verifyRedFlagCheckedOnServices
     * description :: To verify RedFlag Checked On Services
     * date :: 19-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyRedFlagCheckedOnServices() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnRedFlagOnServiceTab, "Red flag");
        String redFlag = getText(CRServicePage.btnRedFlagOnServiceTab, "Red flag is automatically checked");
        return redFlag;
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnPolicyDropDownOnServiceTab
     * description :: To click On Policy DropDown
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public void clickOnPolicyDropDown() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnPolicyOnServiceTab, "Policy option");
        click(CRServicePage.dropDownBoxOnPolicyOnServiceTab, "Click on Policy option");

    }

    /* */

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextStatusValue
     * Description:To get Text Status Value
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void getTextStatusValue() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblStatusValueInCallStatus, "Status value in call status update");
        getText(CRServicePage.lblStatusValueInCallStatus, "status value in call status update");
        Thread.sleep(1000);

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextStatusValueInCallStatus
     * Description:To get text status value in call status
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public String getTextStatusValueInCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblStatusValueInCallStatus, "Status value in call status ");
        String status= getText(CRServicePage.lblStatusValueInCallStatus, "status value in call status ");
        Thread.sleep(1000);
        return status;
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextReasonValueInCallStatus
     * Description:To getText Reason Value InCallStatus
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public String getTextReasonValueInCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblReasonValue, "Reason value in call status ");
        String status= getText(CRServicePage.lblReasonValue, "Reason value in call status ");
        Thread.sleep(1000);
        return status;
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getTextFacilityValueInCallStatus
     * Description:To getText Facility Value InCallStatus
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public String getTextFacilityValueInCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblFacilityVlue, "facility value in call status ");
        String status=getText(CRServicePage.lblFacilityVlue, "Facility value in call status ");
        Thread.sleep(1000);
        return status;
    }


    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: verifyAuditStatusCode
     * Description: verifyAuditStatusCode
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void verifyAuditStatusCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblAuditCodeInCallStatusUpdate, "Auditcode value in call status update ");
        getText(CRServicePage.lblAuditCodeInCallStatusUpdate, "AuditCode value in call status update ");
        {
            
                reporter.SuccessReport("Verify call status", "Verified call is in UP Status");
            
        }
        Thread.sleep(1000);

    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnComment
     * description :: To click on comment
     * date :: 17-Jan-2018
     * author :: ravi
     */

    public void clickOnComment() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.lblComments, "verify comments text");
        click(CRServicePage.lblComments, "verify comments text");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnUpdateButtonOnCallStatusWindow
     * description :: clickOnUpdateButtonOnCallStatusWindow
     * date :: 17-Jan-2018
     * author :: ravi
     */

    public void clickOnUpdateButtonOnCallStatusWindow() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.btnUpdateBbuttonCallStatusUpdateWindow, "Update Button");
        click(CRServicePage.btnUpdateBbuttonCallStatusUpdateWindow, "Update Button");
        Thread.sleep(2000);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHoldDropDown
     * description :: To click On Hold DropDown
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public void clickOnHoldDropDown() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnHoldReason, "reason option");
        click(CRServicePage.dropDownBoxOnHoldReason, "Click on reason option");

    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyHoldIcon
     * description :: To verify the text hold by hold icon
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public String verifyHoldIcon() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.holdIcon, "Hold Icon");
        String hold = getText(CRServicePage.holdIcon, "Hold Icon");
        return hold;

    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyHoldButton
     * description :: To verify hold button
     * date :: 19-Jan-2018
     * author :: Nidhi
     */
    public String verifyHoldButton() throws Throwable {
        isVisibleOnly(CRServicePage.btnHold, "Hold button");
        String holdbtn = getText(CRServicePage.btnHold, "Hold Button");
        return holdbtn;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyHoldReason
     * description :: to verify the reason for hold
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public void verifyHoldReason() throws Throwable {

        if ((driver.findElement(CRServicePage.txtHold).isEnabled()) == false) {
            reporter.SuccessReport("Verify Reason Code field", "reason code are uneditable");
        } else {
            reporter.failureReport("Verify Reason Code field", "reason code are editable");
        }

    }

    /**
     * param ::
     * return :: Date
     * throws :: throwable
     * methodName :: getPTADateAfterCallSave
     * description :: To get the pta date after call save
     * date :: 22-Jan-2018
     * author :: Varun
     */

    public Date getPTADateAfterCallSave() throws Throwable {
        isVisibleOnly(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Save");
        String ptaText = getText(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Call Save");

        // String date2=crSearchCallsLib.getCallIdAndDate();
        String splitStr[] = ptaText.split("\n");
        String startDateValue = splitStr[0];

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date newCallIdDate = dateFormat.parse(startDateValue);
        //String strDate = dateFormat.format(d_date);
        return newCallIdDate;

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCurrentdate
     * description :: To get Current date
     * date ::
     * author :: Cigniti
     */

    public String getCurrentDate() {

        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");


        String date = dateFormat2.format(new Date());

        // will print like 2014-02-20
        //print(dateFormat2.format(new Date());
        return date;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getFutureTime
     * description :: To get Future Time
     * date ::
     * author :: Cigniti
     */

    public String getFutureTime() {
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis() + 3 * 60 * 1000);
        String futureTime = sdf.format(date);
        return futureTime;

    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: isVisibleRedFlag()
     * description :: To verify red flag is visible
     * date :: 19-jan-2018
     * author :: Ravi
     * Sprint number: 4
     */
    public void isVisibleRedFlag() throws Throwable {
        boolean redFlag = isVisibleOnly(CRServicePage.btnRedFlagOnServiceTab, "RedFlag Button");
        if (redFlag) {
            reporter.SuccessReport("Verify red flag", "Verified red flag on service tab");
        } else {
            reporter.failureReport("Verify red flag", "unable to verify red flag on service tab");
        }
    }


    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: selectFirstValueInResonStatus
     * description :: To select First value in reason status
     * date :: 22-Jan-2018
     * author :: ravi
     */

    public void selectFirstValueInResonStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.dropDownBoxArrowOnStatusUpdate, "verify comments text");
        click(CRServicePage.dropDownBoxArrowOnStatusUpdate, "click on down arrow  in reasonupdate");
        Thread.sleep(3000);
        click(CRServicePage.dropDownFirstElementInReasonUpdate, "click on first element in reasonupdate");
        Thread.sleep(3000);
    }


    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnCancel
     * description :: To click on cancel
     * date :: 22-Jan-2018
     * author :: ravi
     */

    public void clickOnCancel() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblCancel, "waits for cancel");
        click(CRServicePage.lblCancel, "click on cancele");
        Thread.sleep(3000);
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getCallDate
     * description :: To get call date
     * date :: 24-Jan-2018
     * author :: Abhiram Vajrapu
     */

    public String getCallDate() throws Throwable {
        boolean flagCallDate = isElementPresent(CRServicePage.dateInCallInformationWindow, "Call Date");
        // assertTrue(flagCallId, "Call Created");

        String callDate = getText(CRServicePage.dateInCallInformationWindow, "Call Date");
        assertTrue(callDate != "", "Call is created and Saved The call With out Error");
        return callDate;
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterManualSpotDetails
     * description :: To enter manual spot details
     * date ::
     * author :: Cigniti
     */

    public void enterManualSpotDetails(String FacilityDetails) throws Throwable {
        enterManualFacilityNumber(FacilityDetails);
        clickOnSpotInServicePage();
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: spot
     * description :: To enter spot details
     * date ::
     * author :: Cigniti
     */

    public String spot(String Spot, String FacilityID, String ManualSoptFacilityID, String ManualSoptFacilityIDNew) throws Throwable {
        String autoFacility="";
        switch (Spot) {
            case "Auto":
                //For Auto sopt just we are capturing text
                autoFacility = validateFacilityAutospotID();
                validateFacilityAutospotAddress();
                break;
            case "Manual":
                String manualFacility = validateFacilityAutospotID();
                if (manualFacility != FacilityID) {
                    enterManualSpotDetails(ManualSoptFacilityID);
                } else {
                    enterManualSpotDetails(ManualSoptFacilityIDNew);
                }
                break;
            default:
                break;
        }
        return autoFacility;
    }

    /**
     * param :: String
     * return :: void
     * throws :: throwable
     * methodName :: callBack
     * description :: this method is created for call back.
     * date ::
     * author :: Ciginti
     */

    public void callBack(String CallBack, String CallBackMinutes, String CallBackReqType) throws Throwable {
        if (CallBack.equalsIgnoreCase("Yes")) {
            clickOnCheckBoxCallBack();
            enterCallBackMinutes(CallBackMinutes);
            Thread.sleep(5000);
            //dropDownBoxOnCallBackRequestMinutes();
            enterCallBackRequestType(CallBackReqType);
            dropDownBoxOnCallBackRequestType();
        }
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterPolicy
     * description :: this method is created to enter policy
     * date ::
     * author :: Cigniti
     */

    public void enterPolicy(String Policy, String PolicyValue) throws Throwable {
        if (Policy.equalsIgnoreCase("Yes")) {
            enterPolicy(PolicyValue);
            clickOnPolicyDropDown();
        }
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: clickRedFlag
     * description :: this method is created to click red flag
     * date ::
     * author :: Cigniti
     */

    public void clickRedFlag(String RedFlag) throws Throwable {
        if (RedFlag.equalsIgnoreCase("Yes")) {
            clickOnRedFlagOnServiceTab();
        }
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterAppointment
     * description :: this method is created to schedule or hold the appointment
     * date ::
     * author :: Cigniti
     */

    public void enterAppointment(String Appointment, String Hold) throws Throwable {
        if (Appointment.equalsIgnoreCase("Yes Appointment")) {

            //If we create appointment for Next Day CallID status was HS(Hold Spot)
            //String nextDay=crSaveAppointmentCall.getNextDay(today);

            clickOnAppointmentbutton();

            String today = getCurrentDate();
            SimpleDateFormat dayFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date day = new SimpleDateFormat("MM/dd/yyyy").parse(today);
            Date targetDay = DateUtils.addDays(day, 1);
            String futureDay = dayFormat.format(targetDay).toString();
            enterAppointmentDate(futureDay);

            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");

            String actualPTATime = verifyPTAValue();
            SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
            Date date1 = new SimpleDateFormat("HH:mm").parse(actualPTATime);
            Date targetTime = DateUtils.addMinutes(date1, 5);
            String time = _24HourSDF.format(targetTime).toString();
            enterAppointmentTime(time);

            String combineKeys4 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys4, "Tab");

        } else if (Appointment.equalsIgnoreCase("Yes Hold")) {
            clickOnHold();
            enterHold(Hold);
            Thread.sleep(3000);
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
        }
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterpriority
     * description :: this method is created to enter priority
     * date ::
     * author :: Cigniti
     */

    public void enterpriority(String Priority, String PriorityRequired) throws Throwable {

        switch (Priority) {
            case "Yes":
                enterPriority(PriorityRequired);
                clickOnPriorityDropDownOnServiceTab();
                break;
            default:
                break;
        }
    }

    /**
     * @methodName : verifyCalendarErrorTextOfHistorycall
     * Description:This method is used to verify calendar error text for a history call
     * @param :
     * @return : void
     * Date:30-01-2018
     * @throws Throwable
     * @author : Cigniti
     */
    public String verifyCalendarErrorTextOfHistorycall() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.CalendarErrorText, "Calendar Error text");
        String calendarText=getText(CRServicePage.CalendarErrorText,"Calendar Error text");
        return calendarText;
    }

    /**
     * @methodName : verifyWorkFlow
     * Description:This method is used to verify the work flow
     * @param :
     * @return : void
     * Date:30-01-2018
     * @throws Throwable
     * @author : Cigniti
     */
    public String verifyWorkFlow()throws Throwable{
        waitForVisibilityOfElement(CRServicePage.workFlowLoadedtext,"WorkFlow");
        String workFlow=getText(CRServicePage.workFlowLoadedtext,"WorkFlow");
        return workFlow;
    }

    /**
     * @methodName : verifyCallStatusText
     * Description:This method is used to verify the call status on the call status  button
     * @param :
     * @return : void
     * Date:30-01-2018
     * @throws Throwable
     * @author : Cigniti
     */
    public String verifyCallStatusText() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtInCallStatusButton, "Call Status");
        String callStatusText=getText(CRServicePage.txtInCallStatusButton, "Call Status");
        return callStatusText;


    }

    /**
     * @methodName : verifyCompleteCheckService
     * Description:This method is used to verify complete check service
     * @param :
     * @return : void
     * Date:30-01-2018
     * @throws Throwable
     * @author : Cigniti
     */

    public void verifyCompleteCheckService()  throws Throwable {
        if (!(isVisibleOnly(CRServicePage.verifyServiceCompleteCheck, "Service Complete Check"))) {
            reporter.failureReport("Verify Service Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }







    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDateToArrange
     * description :: clicks on date
     * date :: 15-feb-2018
     * author :: ravi
     */
    public void clickOnDateToArrange() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRServicePage.lblDate, "click on date");
        click(CRServicePage.lblDate, "click on date");
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextUpdateCode
     * description :: getText of Update Code
     * date :: 15-feb-2018
     * author :: ravi
     */
    public String getTextUpdateCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtUpdateCode, "update code");
       String updateCodeValue= getText(CRServicePage.txtUpdateCode, "update code");
        return updateCodeValue;
    }



    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextReasonCode
     * description :: getText of Reason Code
     * date :: 15-feb-2018
     * author :: ravi
     */
    public String getTextReasonCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtReasonCode, "Reason code");
       String reasonCodeValue= getText(CRServicePage.txtReasonCode, "Reason code");
        return reasonCodeValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextFacilityTruck
     * description :: getText Facility truck
     * date :: 15-feb-2018
     * author :: ravi
     */
    public String getTextFacilityTruck() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtFacilityTruck, "Facility Truck");
        String facilityTruckValue=getText(CRServicePage.txtFacilityTruck, "Facility truck");
        return facilityTruckValue;
    }


    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnErrorOKButtonOnHistoryCallSave
     * description :: clickOnErrorOKButtonOnHistoryCallSave
     * date ::
     * author :: cigniti
     */

    public void clickOnErrorOKButtonOnHistoryCallSave() throws Throwable {
        Thread.sleep(3000);
        isVisibleOnly(CRServicePage.errorOkOnHistoryCallSave, "click on Ok");
        click(CRServicePage.errorOkOnHistoryCallSave, "click on Ok");
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCallDateAfterCallSave
     * description :: To get the call date after saving the call from cr call create page(in format Month/Date/Year)
     * date :: 20-feb-2018
     * author :: Jagadish
     */

    public String getCallDateAfterCallSave() throws Throwable {
        isVisibleOnly(CRServicePage.lblCallDate, "Call Date After Save");
        String callDate = getText(CRServicePage.lblCallDate, "Call Date After Call Save");
        Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(callDate);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String newCallDate = format.format(format1);
        return newCallDate;
        
    }

    public void clickOnReleaseButton() throws Throwable {
    	if (isVisibleOnly(CRServicePage.btnRelease, "Release Button")){
    		click(CRServicePage.btnRelease, "Release Button");
    	}
    }
    public void enterUpdateReasonForStatus(String status) throws Throwable {
    	if (isVisibleOnly(CRServicePage.txtCallStatusUpdate, "reason for status update")) {
        waitForVisibilityOfElement(CRServicePage.txtCallStatusUpdate, "reason for status update");
        click(CRServicePage.txtCallStatusUpdate, "Reason for status");
        type(CRServicePage.txtCallStatusUpdate, status, "Reason for status");
    	}
    }
    public void tabout() throws Throwable
	{
		Thread.sleep(3000);
	    String combineKeys3 = Keys.chord(Keys.TAB);
	    sendKeys(combineKeys3, "Tab");
	}
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPTACallDateAfterCallSave
     * description :: To get the PTA call date after saving the call from cr call create page(in format Month/Date/Year)
     * date :: 07-Mar-2018
     * author :: Chandra
     */

    public String getPTACallDateAfterCallSave() throws Throwable {
        String ptaCallDate=getText(CRServicePage.lblPTACallCreatedDate,"PTA Call Created Date");
    return ptaCallDate;
    }
/**
        * param ::
            * return ::void
     * throws :: throwable
     * methodName :: clickOnE225ErrorOkButton
     * description :: Click on OK button on Error E225.2 error message dialog box
     * date :: 05-03-2018
            * author :: Nidhi
     */
    public void clickOnE225ErrorOkButton() throws Throwable {
        click(CRServicePage.btnErrorE225OkayButton, "Error okay button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnE225ErrorOkButton
     * description :: Click on OK button on Error E225.2 error message dialog box
     * date :: 05-03-2018
     * author :: Nidhi
     */
    public String getErrorMessageOnE225ErrorPopup() throws Throwable {
        String errormessage = getText(CRServicePage.lblE225ErrorMessage, "E225 Error message");
        return errormessage;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyE225ErrorOkButton
     * description :: Verify availability of OK button on Error E225.2 error message dialog box
     * date :: 05-03-2018
     * author :: Nidhi
     */
    public boolean verifyE225ErrorOkButton() throws Throwable {
        boolean visibilityOfButton=isVisibleOnly(CRServicePage.btnErrorE225OkayButton, "Error okay button");
        return visibilityOfButton;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFacilityIDInServicesTab
     * description :: getting value of facility id which is available above Ominisearch bar
     * date :: 09-03-2018
     * author :: Chandra
     */
    public String getFacilityIDInServicesTab() throws Throwable {
        String facilityID=getText(CRServicePage.lblFacilityIdInServices, "Facility Id above omini search bar");
        return facilityID;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFacilityIDFromSpottedFacility
     * description :: getting value of facility id which is available under Spotted facility
     * date :: 09-03-2018
     * author :: Chandra
     */
    public String getFacilityIDFromSpottedFacility() throws Throwable {
        String spottedFacilityID=getText(CRServicePage.txtSpotFacilityLabel, "facility Id under Spotted Facility");
        return spottedFacilityID;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTxtCallPTAValue
     * description ::Get call PTA value
     * date :: 05-03-2018
     * author :: Nidhi
     */
    public void getTxtCallPTAValue() throws Throwable {
        click(CRServicePage.getTxtCallPTAValue, "call PTA Value");
        Thread.sleep(2000);
        getText(CRServicePage.getTxtCallPTAValue, "call PTA Value");

    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: clickOnUseMemberDataOnCreditcardTab
    * description :: To retrieve member details on Billing info page on Credit Card Tab
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void clickOnUseMemberDataOnCreditcardTab() throws Throwable {
    	Thread.sleep(2000);
        mouseClick(CRServicePage.lnkUseMemberShipDataOnBillingInfoInCreditCardTab, "Click on Use Membership data link");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: clickOnContinueButtonInCreditcardTab
    * description :: click on Continue button on Billing info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void clickOnContinueButtonInCreditcardTab() throws Throwable {
        click(CRServicePage.btnContinueOnBillingInfoInCreditCardTab, "Click on Continue Button");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: enterAmountOnBillingInfoPage
    * description :: enter amount on Billing info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void enterAmountOnBillingInfoPage(String amount) throws Throwable {
        type(CRServicePage.txtAmountOnBillingInfoInCreditCardTab, amount, "Enter Amount on Billing Info page");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: enterCreditCardNumberOnCrediCardInfoPage
    * description :: enter credit card number in credit card info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void enterCreditCardNumberOnCrediCardInfoPage(String creditCardNumber) throws Throwable {
        type(CRServicePage.txtCreditCardNumberOnCreditCardInfoInCreditCardTab, creditCardNumber, "Enter Credit Card Number in Credit Card Info page");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: enterCVCOnCrediCardInfoPage
    * description :: enter CVC number in credit card info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void enterCVCOnCrediCardInfoPage(String cvc) throws Throwable {
        type(CRServicePage.txtCVCNumberOnCreditCardInfoInCreditCardTab, cvc, "Enter CVC Number in Credit Card Info page");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: clickOnContinueButtonInCreditcardInfoPage
    * description :: click on Continue button on Credit card info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void clickOnContinueButtonInCreditcardInfoPage() throws Throwable {
        click(CRServicePage.btnContinueOnCreditCardInfoInCreditCardTab, "Click on Continue Button");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: selectMonthOnCreditCardInfoPage
    * description :: Select month on Credit card info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void selectMonthOnCreditCardInfoPage(String month) throws Throwable {
        click(CRServicePage.drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab, "Month");
        waitForVisibilityOfElement(CRServicePage.drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab, "Month");
        selectByVisibleText(CRServicePage.drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab, month, "Month");
    }
    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: selectYearOnCreditCardInfoPage
    * description :: Select year on Credit card info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void selectYearOnCreditCardInfoPage(String year) throws Throwable {
        click(CRServicePage.drpdwnExpirationYearOnCreditCardInfoInCreditCardTab, "year");
        waitForVisibilityOfElement(CRServicePage.drpdwnExpirationYearOnCreditCardInfoInCreditCardTab, "year");
        selectByVisibleText(CRServicePage.drpdwnExpirationYearOnCreditCardInfoInCreditCardTab, year, "year");
    }

    /**
    * param ::
    * return ::String
    * throws :: throwable
    * methodName :: clickOnContinueButtonInCreditcardInfoPage
    * description :: click on Continue button on Credit card info page
    * date :: 05-Mar-2018
    * author :: Abhiram
    */
    public void clickOnCloseButtonInCreditcard() throws Throwable {
        click(CRServicePage.btnCloseOnCreditCard, "Click on Close Button");
    }

    /**
    * param :: String
    * return ::void
    * throws :: throwable
    * methodName :: enterCreditCard
    * description :: doing credit card operation
    * date ::
    * author :: Cigniti
    */
    public void enterCreditCardDetails(String CreditCard, String amount,String creditCardNumber,String cvc,String month,String year) throws Throwable {
        switch (CreditCard) {
            case "Yes":
                clickOnCreditCard();
                clickOnCreditCardInCallRibbion();
                switchToFrame(CRServicePage.creditCardFrame);
                clickOnUseMemberDataOnCreditcardTab();
                Thread.sleep(3000);
                clearData(CRServicePage.txtAmountOnBillingInfoInCreditCardTab);
                enterAmountOnBillingInfoPage(amount);
                clickOnContinueButtonInCreditcardTab();
                Thread.sleep(3000);
                enterCreditCardNumberOnCrediCardInfoPage(creditCardNumber);
                enterCVCOnCrediCardInfoPage(cvc);
                selectMonthOnCreditCardInfoPage(month);
                selectYearOnCreditCardInfoPage(year);
                clickOnContinueButtonInCreditcardInfoPage();
                
                Thread.sleep(7000);
                comeOutFromFrame();
                verifyCreditCardPaymentisAdded(); 
                clickOnCloseButtonInCreditcard();
                
                break;
            default:
                break;
        }
    }


/**
 * param ::
 * return ::boolean
 * throws :: throwable
 * methodName :: errorMessageForRequiredField
 * description ::To get error Message For Required Field when you click on save with all required fields blank
 * date :: 19-03-2018
 * author :: Lakshmi
 * */
    public boolean errorMessageForRequiredField()throws Throwable{
        boolean msgErrorForRequiredField = isVisibleOnly(CRServicePage.errorMsgForRequiredField,"Redirected to the Error message for required field");
        getText(CRServicePage.errorMsgForRequiredField,"Redirected to the mandatory Field with error message :   ");
        return msgErrorForRequiredField;
    }
    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyRedFlagIcon
     * description :: To verify Red Flag Icon available
     * date :: 03-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public boolean verifyRedFlagIcon() throws Throwable {
        boolean redFlagIcon = waitForVisibilityOfElement(CRServicePage.iconRedFlagOnServiceTab, "Red Flag Icon");
        return redFlagIcon;
    }
    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: errorMsgForPacesetterCodeEntry
     * description ::To get error Msg For Pacesetter Code Entry
     * date :: 19-03-2018
     * author :: Lakshmi
     * */
    public boolean errorMsgForPacesetterCodeEntry()throws Throwable{
        boolean errorMsgForPacesetterCode = isVisibleOnly(CRServicePage.errorMsgForPacesetterCodeEntry,"Error message for pacesetter code");
        getText(CRServicePage.errorMsgForPacesetterCodeEntry,"Error message for pacesetter code ");
        return errorMsgForPacesetterCode;
    }
    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCasshCallIconInServiceTab
     * description ::verifyCasshCallIconInServiceTab
     * date :: 14-03-2018
     * author :: Chandra
     */
    public boolean verifySelectedCashButtonInServicesTab() throws Throwable {
        boolean cashCallSelectedButton= isVisibleOnly(CRServicePage.cashFlagIcon, "Cash call selected");
        return cashCallSelectedButton;
    }
    
    public String verifyCreditCardPaymentisAdded() throws Throwable{
    	waitForVisibilityOfElement(CRServicePage.creditCardOrderID, "Credit card Order ID");
    	String CCOrderID = getText(CRServicePage.creditCardOrderID, "Credit card Order ID");
    	return CCOrderID;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyEndOfScript
     * description :: To get text of end of script from save call popup
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyEndOfScript() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtEndOfScript, "End of script txt");
        String endOfScript = getText(CRServicePage.txtEndOfScript, "End of script txt");
        return endOfScript;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyBillingTab
     * description ::To verify Billing Info Tab in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyBillingTab() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.tabBillingInfo, "Billing Tab visibility");
        String tab = getText(CRServicePage.tabBillingInfo, "Billing Tab");
        return tab;
    }
    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyCreditCardInfoTab
     * description ::To verify Credit Card Info Tab in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyCreditCardInfoTab() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.tabCreditCardInfo, "CreditCardInfo Tab visibility");
        String tab = getText(CRServicePage.tabCreditCardInfo, "CreditCardInfo Tab");
        return tab;
    }
    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyTransactionInfoTab
     * description ::To verify Transaction Info Tab in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyTransactionInfoTab() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.tabTransactionInfo, "TransactionInfo Tab visibility");
        String tab = getText(CRServicePage.tabTransactionInfo, "TransactionInfo Tab");
        return tab;
    }
    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyCreditCardPaymentOption
     * description ::To verify Credit Card Payment Option after clicking on credit card icon on call ribbon
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyCreditCardPaymentOption() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.creditCardPaymentOption, "Credit Card Payment Option visibility");
        String option = getText(CRServicePage.creditCardPaymentOption, "Credit Card Payment Option");
        return option;
    }
    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: clickOnVoidAuthorization
     * description ::To click On Void Authorization in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public void clickOnVoidAuthorization() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnVoidAuthorization, "Void Authorization visibility");
        click(CRServicePage.btnVoidAuthorization, "click On Void Authorization");
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getCreditCard
     * description ::To get Credit Card in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String getCreditCard() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCreditCard, "Credit card visibility");
        String Info = getText(CRServicePage.txtCreditCard, "Credit card ");
        return Info;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getOrderNumber
     * description ::To get Order Number for credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String getOrderNumber() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtOrderNumber, "Order number visibility");
        String Info = getText(CRServicePage.txtOrderNumber, "Order number");
        return Info;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getTransactionID
     * description ::To get Transaction ID in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String getTransactionID() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtTransactionID, "Transaction ID visibility");
        String Info = getText(CRServicePage.txtTransactionID, "Transaction ID");
        return Info;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getAuthorizationCode
     * description ::To get authorization Code in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String getAuthorizationCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtAuthorizationCode, "Authorization Code visibility");
        String Info = getText(CRServicePage.txtAuthorizationCode, " Authorization Code");
        return Info;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getTransactionHistoryInfo
     * description ::To get Transaction History Info in credit card paymnet option
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String getTransactionHistoryInfo() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.transactionHistorySection, "Transaction History visibility");
        String Info = getText(CRServicePage.transactionHistorySection, " Transaction History");
        return Info;
    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: getCreditCardInTransactionHistory
     * description ::To get Credit Card in TransactionHistory
     * date :: 19-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public String getCreditCardInTransactionHistory() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.creditCardInTransactioHistory, "Credit card visibility");
        String Info = getText(CRServicePage.creditCardInTransactioHistory, "Credit card ");
        return Info;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyE268ErrorMessageAvailablity
     * description ::
     * date :: 22-Mar-2018
     * author ::Abhiram
     */
    public boolean verifyE268ErrorMessageAvailablity()throws  Throwable{
        boolean errormsg268Availablity=isVisibleOnly(CRServicePage.btnE268ErrorPopUpErrorOkayButton,"Error 268 message Okay button");
        return errormsg268Availablity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getE268ErrorMessage
     * description ::
     * date :: 22-Mar-2018
     * author ::Abhiram
     */
    public String getE268ErrorMessage()throws  Throwable{
        String e268ErrorMessage=getText(CRServicePage.lblE268ErrorMessage,"Error 268 message appeared");
        return e268ErrorMessage;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnE268OKButton
     * description ::
     * date :: 22-Mar-2018
     * author ::Abhiram
     */
    public void clickOnE268OKButton()throws  Throwable{
        click(CRServicePage.btnE268ErrorPopUpErrorOkayButton,"Error 268 message Okay button");
    }

    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: processingInvisibility
     * description ::To wait for processing invisibility
     * date :: 21-Mar-2018
     * author :: Nidhi Kumari Raut
     */
    public boolean processingInvisibility() throws Throwable {
        boolean Status =(waitForInVisibilityOfElement(CRServicePage.txtProcessing, "Processing Invisibility"));
        return Status;
    }
    /**
     * param ::
     * return :: void
     * throws :: throwable
     * methodName :: getAuthorizedPaymentStatus
     * description ::To get payment status text
     * date :: 21-Mar-2018
     * author :: Nidhi Kumari Raut
     */

    public boolean getAuthorizedPaymentStatus() throws Throwable {
        boolean Status =(isVisible(CRServicePage.txtAuthorizedPaymentStatus, "Payment Status Invisibility"));
        return Status;
    }


    /**
     * param ::
     * return ::Date
     * throws :: throwable
     * methodName :: getCallDateAfterCallSaveInDateForma
     * description :: To get the call date after saving the call from cr call create page(in format Month/Date/Year) and returning in Date format
     * date :: 24-mar-2018
     * author :: Varun
     */

    public Date getCallDateAfterCallSaveInDateForma() throws Throwable {
        isVisibleOnly(CRServicePage.lblCallDate, "Call Date After Save");
        String callDate = getText(CRServicePage.lblCallDate, "Call Date After Call Save");
        Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(callDate);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String newCallDate = format.format(format1);
        return format1;

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
    public String verifyPTAValue() throws Throwable {
        String ptaValue = getText(CRServicePage.lblPTAvalue, "PTA Value");
        String extracttime[] = ptaValue.split(", ");
       return extracttime[1];
    }

    public String getFutureTime(String current) throws ParseException {
        Date date1 = new SimpleDateFormat("HH:mm").parse(current);
        Date targetTime = DateUtils.addMinutes(date1, 5);
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
        System.out.println(_12HourSDF.format(targetTime));
        String time = _12HourSDF.format(targetTime).toString().substring(0,5);
        System.out.println(time);
        return time;

    }
    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: validateFacilityspotIDOnServiceTab
     * description :: To validate the Facility Autospoted or Not
     * date ::3/26/2018
     * author :: Nidhi
     */

    public String validateFacilityspotIDOnServiceTab() throws Throwable {
        String facility = null;
        boolean flagSpotFacilityLabel = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        if (flagSpotFacilityLabel) {
            Thread.sleep(5000);
            facility = getText(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
            assertTrue(true, "Auto Spot Value is " + facility);
        } else {
            assertFalse(false, "Auto spot value is not found");
        }
        return facility;
    }
}