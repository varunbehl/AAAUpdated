package com.aaa.web.lib;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRServicePage;
import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.LoginPage;
import com.aaa.accelerators.ActionEngine;

import org.apache.bcel.generic.GOTO;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DIMCDLib extends ActionEngine {
    List<WebElement> CommentsMCDWindow = new ArrayList<WebElement>();
    List<WebElement> cannedCommentsList = new ArrayList<WebElement>();
    String spotStatus;
    String assignStatus;
    String facilityStatus;
    String dispatchStatus;
    String enrouteStatus;
    String locationStatus;
    String clearStatus;
    boolean emptryRecords;
    boolean recordsPanelNotFund;
    String towDestinationAddress;
    String city;
    String State;
    String Zip;
    List<WebElement> allRepairShops = null;
    List<WebElement> records = null;

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAssign
     * description :: This is used to click on assign option in right side panel
     * date :: 05-Nov-2017
     * author :: cigniti
     */
    public void clickOnAssign() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
        click(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateAssign
     * description :: This is used to Validate assign option in right side panel
     * date :: 05-Nov-2017
     * author ::Cigniti
     */
    public boolean validateAssign() throws Throwable {
        Thread.sleep(3000);
        boolean visibility = isVisibleOnly(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
        return visibility;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacility
     * description :: This is used to select Facility after clicking on the assign button in the left panel in MCDWindow
     * date :: 05-Nov-2017
     * author :: Abhiram Vajrapu
     */
    public void selectFacility() throws Throwable {
        Thread.sleep(3000);
        boolean isFacilityBVisible = isVisibleOnly(DIMCDPage.selectFacility, "Select Facility");
        if (isFacilityBVisible) {
            click(DIMCDPage.selectFacility, "Select facility");
        }
        boolean isFacilityZVisible = isVisibleOnly(DIMCDPage.selectFacilityZ, "Select Facility");
        if (isFacilityZVisible) {
            click(DIMCDPage.selectFacilityZ, "Select facility");
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectDispatch
     * description :: This Method is used to select Dispatch button in MCD window while performing cancel call
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectDispatch() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnDispatchUpdateinMCD, "Dispatch Update");
        click(DIMCDPage.btnDispatchUpdateinMCD, "Select Dispatch");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectEnroute
     * description :: This Method is used to select Enroute button in MCD window while performing cancel call
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectEnroute() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnEnrouteUpdateinMCD, "Enroute Update");
        click(DIMCDPage.btnEnrouteUpdateinMCD, "Select btnEnrouteUpdateinMCD");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectEnrouteTime
     * description :: This method is used to select the enroute Time after clicking on the Enroute Button in MCD window
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectEnrouteTime() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selEnrouteTimeinMCD, "Enroute Time");
        click(DIMCDPage.selEnrouteTimeinMCD, "Select enroute Time");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectOnLocation
     * description :: This method is used to click on the location tab in MCD window
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectOnLocation() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnOnLocationUpdateinMCD, "On Location Update");
        click(DIMCDPage.btnOnLocationUpdateinMCD, "Select On Location");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectClearCall
     * description :: This method is used to click on Clear call while performing Clear call in MCD window
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectClearCall() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnClearCallUpdateinMCD, "Clear call Update");
        click(DIMCDPage.btnClearCallUpdateinMCD, "Select clear call");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectCancelinClearCall
     * description :: Click on cancel button in MCD window while performing clear call
     * date ::
     * author ::
     */
    public void selectCancelinClearCall() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.cancelinMCDClearCall, "Select Cancel");
        click(DIMCDPage.cancelinMCDClearCall, "Select Cancel");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectServiceNotEnroute
     * description :: This method is used to cancel the service to not to enroute
     * date ::
     * author ::
     */
    public void selectServiceNotEnroute() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.cancelCallServiceNotEnroute, "Cancel Service Not EnRoute");
        click(DIMCDPage.cancelCallServiceNotEnroute, "Cancel Service Not EnRoute");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectExitCode
     * description :: This method is used to select Jump statr exit code in MCD Window
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectExitCode() throws Throwable {
//        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectPacesetterCodeJumpStart, "enter Pace setter code information");
        click(DIMCDPage.selectPacesetterCodeJumpStart, "Select Pacesetter Code Jump Start");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContinue
     * description :: click on continue call clearing button
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnContinue() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.continueButton, "continue call clearing");
        click(DIMCDPage.continueButton, "click on continue call clearing");
        Thread.sleep(6000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyContinueButton
     * description :: returning status of Continue button
     * date ::
     * author ::cigniti
     */
    public boolean verifyContinueButton() throws Throwable {

        boolean continueButton = isVisibleOnly(DIMCDPage.continueButton, "click on continue call clearing");
        return continueButton;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickAndEnterBatteryTestedInformation
     * description :: This method is used to enter the battery tested information
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickAndEnterBatteryTestedInformation(String odoMeterReading, String comments) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.batteryTestedYes, "battery tested yes");
        click(DIMCDPage.batteryTestedYes, "click on battery tested yes");
        click(DIMCDPage.batteryFailedTestNo, "click on battery failed test NO");
        type(DIMCDPage.odometerReading, odoMeterReading, "ODOMETER Reading");
        type(DIMCDPage.enterComments, comments, "Done a Jump Start");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSubmit
     * description :: This method is used to check for the visibility of continue and submit button and click in MCD Window
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnSubmit() throws Throwable {
        Thread.sleep(3000);
        boolean continueButtonVisible = isVisibleOnly(DIMCDPage.continueButton, "Continue Button");
        if (continueButtonVisible) {
            click(DIMCDPage.continueButton, "click on Continue Button");
            // waitForVisibilityOfElement(DIMCDPage.enterComments, "Cancelled call QA ");
            //type(DIMCDPage.enterComments, "Cancelled call QA ", "Cancelled call QA ");
            boolean comments = isVisibleOnly(DIMCDPage.enterComments, "Cancelled call QA ");
            if (comments == true) {
                type(DIMCDPage.enterComments, "Cancelled call QA ", "Cancelled call QA ");
            }
        }
        boolean submitButtonVisible = isVisibleOnly(DIMCDPage.submitButton, "submit Button");
        if (submitButtonVisible) {
            //waitForVisibilityOfElement(DIMCDPage.submitButton, "submit Button");
            click(DIMCDPage.submitButton, "click on submit Button");
            Thread.sleep(10000);
            if (isVisibleOnly(LoginPage.errorAlertOK, "Okay Button")) {
                click(LoginPage.errorAlertOK, "Okay Button");
            }
        }


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: capturePaceCodeInDispatch
     * description :: This method is used to capture pacesetter code in Dispatch
     * date :: 05-Nov-2017
     * author ::
     */
    public void capturePaceCodeInDispatch(String paceSetterCode) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterCodeInMCD, "Pacesetter code in dispatch");
        String pacecodeindispatch = getText(DIMCDPage.lblPaceSetterCodeInMCD, "Pacesetter code in dispatch");
        String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        String getPaceCode = paceSetterCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseCallButton
     * description :: This method is used to close call button in mcd widnow
     * date :: 19-Dec-2017
     * author ::Abhiram Vajrapu
     */
    public void clickOnCloseCallButton() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnCloseCall, "Close Call");
        click(DIMCDPage.btnCloseCall, "Close Call");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPaceSetterResolutionCode
     * description :: This method is used to pacesetter resolution code in mcd window while performing clear call
     * date :: 19-Dec-2017
     * author ::Abhiram Vajrapu
     */
    public void clickOnPaceSetterResolutionCode() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selPaceSetterResolutionCode, "Select PaceSetter Resolution Code");
        click(DIMCDPage.selPaceSetterResolutionCode, "Select PaceSetter Resolution Code");
    }

    /**
     * param :: String input
     * return ::void
     * throws :: throwable
     * methodName :: labelCallCleared
     * description :: This method is used to validate clear call status in MCD Window and it will return the status
     * date :: 19-Dec-2017
     * author ::Abhiram Vajrapu
     */
    public String labelCallCleared(String StatusUpdateCL) throws Throwable {
        Thread.sleep(7000);
        if (isVisibleOnly(DIMCDPage.lblCallClearedStatus, "Call Cleared")) {
            if (StatusUpdateCL.equalsIgnoreCase("CL")) {
                waitForVisibilityOfElement(DIMCDPage.lblCallClearedStatus, "Call Cleared");
                String callClearedStatus = getText(DIMCDPage.lblCallClearedStatus, "Call Cleared");
                if (callClearedStatus.contains("CL")) {
                    reporter.SuccessReport("Call Cleared Status:", "<b>Call Cleared Status Verified</b>");
                } else {
                    reporter.failureReport("Call Cleared Status:", "<b>Call Cleared Status Not Verified</b>");
                }
            }
        }
        return StatusUpdateCL;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterReason
     * description :: This method is used to enter the reason in mcd window while performing clear call
     * date :: 20-Dec-2017
     * author ::
     */
    public void enterReason(String reason) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.txtReason, "Enter Reason");
        type(DIMCDPage.txtReason, reason, "Enter Reason");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMCDCloseWindow
     * description :: This method is used to close the opened MCD window
     * date :: 20-Dec-2017
     * author ::
     */
    public void clickOnMCDCloseWindow() throws Throwable {
        Thread.sleep(3000);
        isVisibleOnly(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
        waitForVisibilityOfElement(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
        click(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnUpdate
     * description :: This method is used to click on the update Tab
     * date :: 29-Dec-2017
     * author ::Nidhi
     */
    public void clickOnUpdate() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnUpdateOnStatusUpdate, "Status Update Tab");
        click(DIMCDPage.btnUpdateOnStatusUpdate, "Status Update Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterReasonOnStatusUpdateTab
     * description ::This is used to enter the values in Reasons field which is in Status update Tab
     * date :: 29-Dec-2017
     * author ::Nidhi
     */
    public void enterReasonOnStatusUpdateTab(String Class) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOnStatusUpdate, "reason on status update tab");
        Thread.sleep(3000);
        type(DIMCDPage.txtReasonOnStatusUpdate, Class, "reason on status update tab");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStatusOnStatusUpdateTab
     * description ::This is used to enter the values in Status field which is in Status update Tab
     * date :: 29-Dec-2017
     * author ::Nidhi
     */

    public void enterStatusOnStatusUpdateTab(String Class) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtStatusOfStatusUpdateInMCD, "reason on status update tab");
        type(DIMCDPage.txtStatusOfStatusUpdateInMCD, Class, "reason on status update tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnStatusUpdateTab
     * description :: This method is used to click on status update
     * date :: 29-Dec-2017
     * author ::Nidhi
     */
    public void clickOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.tabStatusUpdateInMCD, "Status update button");
        click(DIMCDPage.tabStatusUpdateInMCD, "Status update button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnETAButtonOnMCDWindow
     * description ::TO click on ETA button On MCD Window
     * date :: 29-Dec-2017
     * author: Madhukar
     */
    public void clickOnETAButtonOnMCDWindow() throws Throwable {
        boolean ETA = isVisibleOnly(DIMCDPage.btnETAinMCD, "ETA Button");
        if (ETA) {
            click(DIMCDPage.btnETAinMCD, "ETA Button");
        }
    }

    /**
     * * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTimeForETA
     * description ::To set the time for ETA
     * date :: 29-Dec-2017
     * <p>
     * author: Madhukar
     */
    public void setTimeForETA() throws Throwable {
        boolean setTime = isVisibleOnly(DIMCDPage.setTimeForETA, "Set time for ETA");
        if (setTime) {
            click(DIMCDPage.setTimeForETA, "Set time for ETA");
        }
    }

    /**
     * * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnStatusUpdateTabOnMCDWindow
     * description ::To click on status update Tab on MCD Window
     * date :: 29-Dec-2017
     * author: Madhukar
     */
    public void clickOnStatusUpdateTabOnMCDWindow() throws Throwable {
        boolean statusUpdateTab = isVisibleOnly(DIMCDPage.tabStatusUpdateInMCD, "Status Update Tab");
        if (statusUpdateTab) {
            click(DIMCDPage.tabStatusUpdateInMCD, "Status Update Tab");
        }
    }

    /**
     * * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterStatusInStatusUpdateTab
     * description ::This method is used to enter the value in status
     * date :: 29-Dec-2017
     * author: Madhukar
     */
    public void enterStatusInStatusUpdateTab(String statusForStatusUpdate) throws Throwable {
        boolean statusupdate = isVisibleOnly(DIMCDPage.txtStatusOfStatusUpdateInMCD, "status Text box");
        if (statusupdate) {
            click(DIMCDPage.txtStatusOfStatusUpdateInMCD, "status Text box");
            type(DIMCDPage.txtStatusOfStatusUpdateInMCD, statusForStatusUpdate, "Update status in StatusUpdate Tab");
        }
    }

    /**
     * * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterReasonInStatusUpdateTab
     * description ::This method is used To enter Reason in status update tab on MCD Window
     * date :: 29-Dec-2017
     * author: Madhukar
     */
    public void enterReasonInStatusUpdateTab(String reasonForStatusUpdate) throws Throwable {
        boolean reason = isVisibleOnly(DIMCDPage.txtReasonOfStatusUpdateInMCD, "status Text box");
        if (reason) {
            Thread.sleep(4000);
            click(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason in StatusUpdate Tab");
            Thread.sleep(2000);
            type(DIMCDPage.txtReasonOfStatusUpdateInMCD, reasonForStatusUpdate, "Reason in StatusUpdate Tab");
            Thread.sleep(4000);

        }
    }

    /**
     * * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnUpdateButtonInStatusUpdateTab
     * description ::This method is used to verify and click on the update button
     * date :: 29-Dec-2017
     * author: Madhukar
     */
    public boolean clickOnUpdateButtonInStatusUpdateTab() throws Throwable {
        boolean update = isVisibleOnly(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button");
        if (update) {
            click(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button");
        }
        return update;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityOnAssignTabInMCD
     * description :: This method is used to select facility value while selecting assign tab
     * date :: 01-Jan-2018
     * author ::Nidhi
     */
    public boolean selectFacilityOnAssignTabInMCD() throws Throwable {
        Thread.sleep(3000);
        boolean status = false;
        if (isVisibleOnly(DIMCDPage.selectFacilityOnAssignTabInMCD, "Select Facility")) {
            status = click(DIMCDPage.selectFacilityOnAssignTabInMCD, "Select facility");
        }
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectTruckFacilityOnAssignTabInMCD
     * description :: This method is used to select facility value while selecting assign tab
     * date :: 01-Jan-2018
     * author ::Nidhi
     */
    public void selectTruckFacilityOnAssignTabInMCD(String TruckID) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectFacilityOnAssignInMCD(TruckID), "Select Facility" + TruckID);
        click(DIMCDPage.selectFacilityOnAssignInMCD(TruckID), "Select facility" + TruckID);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectSecondFacilityOnAssignTabInMCD
     * description :: This method is used to select second facility on Assign tab
     * date :: 03-01-2018
     * author ::Madhukar
     */
    public void selectSecondFacilityOnAssignTabInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectSecondFacilityOnAssignTabInMCD, "select facility");
        boolean facility = isVisibleOnly(DIMCDPage.selectSecondFacilityOnAssignTabInMCD, "select facility");
        if (facility) {
            click(DIMCDPage.selectSecondFacilityOnAssignTabInMCD, "select facility");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectSecondFacilityOnDispatchTabInMCD
     * description :: This method is used to select second facility on Dispatch tab
     * date :: 03-01-2018
     * author ::Madhukar
     */
    public boolean selectSecondFacilityOnDispatchTabInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectSecondFacilityOnDispatchTabInMCD, "select facility");
        boolean facility = isVisibleOnly(DIMCDPage.selectSecondFacilityOnDispatchTabInMCD, "select facility");
        if (facility) {
            click(DIMCDPage.selectSecondFacilityOnDispatchTabInMCD, "select facility");
        } else {
            assertTrue(facility, "facility is available");
        }
        return facility;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectSecondFacilityOnDispatchTabInMCD
     * description :: To enter Reason in status update tab on MCD Window
     * date :: 03-01-2018
     * author ::Nidhi
     */
    public boolean enterReasonForRedFlagInStatusUpdateTab(String reasonForRedFlagStatusUpdate) throws Throwable {
        boolean reason = isVisibleOnly(DIMCDPage.txtReasonOfStatusUpdateInMCD, "status Text box");
        if (reason) {
            click(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason in StatusUpdate Tab");
            type(DIMCDPage.txtReasonOfStatusUpdateInMCD, reasonForRedFlagStatusUpdate, "Reason in StatusUpdate Tab");
        } else {
            assertTrue(reason, "able to enter status");
        }
        return reason;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberFirstNameOnSummaryTab
     * description :: This method is used to verify Member first Name On Summary tab in MCD window
     * date ::
     * author ::Chandra
     */
    public boolean verifyMemberFirstNameOnSummaryTab() throws Throwable {
        boolean firstName = isVisibleOnly(DIMCDPage.lblMemberFirstNameOnSummaryTabinMCD, "Member First Name");
        return firstName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberLastNameOnSummaryTab
     * description :: This method is used to verify Member last name on summary tab in mcd window
     * date ::
     * author ::Chandra
     */
    public boolean verifyMemberLastNameOnSummaryTab() throws Throwable {
        boolean lastName = isVisibleOnly(DIMCDPage.lblMemberLastNameOnSummaryTabinMCD, "Member Last Name");
        return lastName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberNumberOnSummaryTab
     * description ::This method is used to verify Member Number name on summary tab in mcd window
     * date ::
     * author ::Chandra
     */
    public boolean verifyMemberNumberOnSummaryTab() throws Throwable {
        boolean memberNumber = isVisibleOnly(DIMCDPage.lblMemberNumberOnSummaryTabinMCD, "Member Number");
        return memberNumber;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberAddressOnSummaryTab
     * description ::This method is used to verify Member Address On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberAddressOnSummaryTab() throws Throwable {
        boolean memberAddress = isVisibleOnly(DIMCDPage.lblMemberAddressOnSummaryTabinMCD, "Member Address");
        return memberAddress;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberCityOnSummaryTab
     * description ::This method is used to verify Member City On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberCityOnSummaryTab() throws Throwable {
        boolean memberCity = isVisibleOnly(DIMCDPage.lblMemberCityOnSummaryTabinMCD, "Member City");
        return memberCity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberStateOnSummaryTab
     * description ::This method is used to verify Member state On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberStateOnSummaryTab() throws Throwable {
        boolean memberState = isVisibleOnly(DIMCDPage.lblMemberStateOnSummaryTabinMCD, "Member State");
        return memberState;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberZipOnSummaryTab
     * description ::This method is used to verify Member Zip On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberZipOnSummaryTab() throws Throwable {
        boolean memberZip = isVisibleOnly(DIMCDPage.lblMemberZipOnSummaryTabinMCD, "Member Zip");
        return memberZip;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownLocationOnSummaryTab
     * description ::This method is used to verify Member location On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyBreakDownLocationOnSummaryTab() throws Throwable {
        boolean breakdwnLoc = isVisibleOnly(DIMCDPage.lblBreakdownAddressLocationOnSummaryTabinMCD, "BreakDown Location");
        return breakdwnLoc;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleYearOnSummaryTab
     * description ::This method is used to verify Vehicle Year On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyVehicleYearOnSummaryTab() throws Throwable {
        boolean year = isVisibleOnly(DIMCDPage.lblVehicleYearOnSummaryTabinMCD, "Vehicle year");
        return year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleMakeOnSummaryTab
     * description ::This method is used to verify vehicle Make On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyVehicleMakeOnSummaryTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleMakeOnSummaryTabinMCD, "Vehicle Make");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleModelOnSummaryTab
     * description ::This method is used to verify vehicle Model On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyVehicleModelOnSummaryTab() throws Throwable {
        boolean model = isVisibleOnly(DIMCDPage.lblVehicleModelOnSummaryTabinMCD, "Vehicle Model");
        return model;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleColorOnSummaryTab
     * description ::This method is used to verify Vehicle color On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyVehicleColorOnSummaryTab() throws Throwable {
        boolean color = isVisibleOnly(DIMCDPage.lblVehicleColorOnSummaryTabinMCD, "Vehicle Color");
        return color;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleColorOnSummaryTab
     * description ::This method is used to verify Vehicle color On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyPaceSetterCodeOnSummaryTab() throws Throwable {
        boolean pacesetter = isVisibleOnly(DIMCDPage.lblPaceSetterCodeOnSummaryTabinMCD, "Pacesetter Code");
        return pacesetter;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTroubleCodeOnSummaryTab
     * description ::This method is used to verify Trouble code On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyTroubleCodeOnSummaryTab() throws Throwable {
        boolean troubleCode = isVisibleOnly(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble Code");
        return troubleCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFunctionCodeOnSummaryTab
     * description ::This method is used to verify Function Code On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyFunctionCodeOnSummaryTab() throws Throwable {
        boolean functionCode = isVisibleOnly(DIMCDPage.lblFunctionCodeOnSummaryTabinMCD, "Function Code");
        return functionCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFaclityIdandNameOnSummaryTab
     * description ::This method is used to verify facility id and Name On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyFaclityIdandNameOnSummaryTab() throws Throwable {
        boolean faclity = isVisibleOnly(DIMCDPage.lblFacilityIdAndNameOnSummaryTabinMCD, "facility name and id");
        return faclity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckLoadButtonOnSummaryTab
     * description ::This method is used to verify truck load button On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */

    public boolean verifyTruckLoadButtonOnSummaryTab() throws Throwable {
        boolean truckLoad = isVisibleOnly(DIMCDPage.btnTruckLoadOnSummaryTabinMCD, "truck load button");
        return truckLoad;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMemberTabInMCDWindow
     * description ::This method is used to click on member tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean clickOnMemberTabInMCDWindow() throws Throwable {
        boolean memberTab = isVisibleOnly(DIMCDPage.lnkMemberTabinMCD, "Member Tab");
        if (memberTab) {
            click(DIMCDPage.lnkMemberTabinMCD, "Member Tab");
        } else {
            assertTrue(memberTab, "member tab is found");
        }
        return memberTab;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberNumberOnMemberTab
     * description ::This method is used to verify member number on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberNumberOnMemberTab() throws Throwable {
        boolean memberNumber = isVisibleOnly(DIMCDPage.lblMemberNumberOnMemberTabinMCD, "Member Number");
        return memberNumber;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberFirstNameOnMemberTab
     * description ::This method is used to verify first name on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberFirstNameOnMemberTab() throws Throwable {
        boolean firstName = isVisibleOnly(DIMCDPage.lblMemberFirstNameOnMemberTabinMCD, "Member First Name");
        return firstName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberLastNameOnMemberTab
     * description ::This method is used to verify Last name on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberLastNameOnMemberTab() throws Throwable {
        boolean lastName = isVisibleOnly(DIMCDPage.lblMemberLastNameOnMemberTabinMCD, "Member Last Name");
        return lastName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberAddressOnMemberTab
     * description ::This method is used to verify address on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberAddressOnMemberTab() throws Throwable {
        boolean address = isVisibleOnly(DIMCDPage.lblMemberAddressOnMemberTabinMCD, "Member Address");
        return address;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberLevelOnMemberTab
     * description ::This method is used to verify Member Level on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberLevelOnMemberTab() throws Throwable {
        boolean level = isVisibleOnly(DIMCDPage.lblMemberLevelOnMemberTabinMCD, "Level");
        return level;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberStatusOnMemberTab
     * description ::This method is used to verify Member status on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberStatusOnMemberTab() throws Throwable {
        boolean status = isVisibleOnly(DIMCDPage.lblMemberStatusOnMemberTabinMCD, "Status");
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberExpirationOnMemberTab
     * description ::This method is used to verify Member expiration date on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberExpirationOnMemberTab() throws Throwable {
        boolean expiration = isVisibleOnly(DIMCDPage.lblMemberExpirationDateOnMemberTabinMCD, "Expiration");
        return expiration;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberCallsUsedOnMemberTab
     * description ::This method is used to verify Member calls used on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberCallsUsedOnMemberTab() throws Throwable {
        boolean callsUsed = isVisibleOnly(DIMCDPage.lblMemberCallsUsedOnMemberTabinMCD, "Calls Used");
        return callsUsed;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberCallsAllowedOnMemberTab
     * description ::This method is used to verify Member calls allowed on member tab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public boolean verifyMemberCallsAllowedOnMemberTab() throws Throwable {
        boolean callsAllowed = isVisibleOnly(DIMCDPage.lblMemberCallsAllowedOnMemberTabinMCD, "Calls Allowed");
        return callsAllowed;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyLongTowAllowedOnMemberTab
     * description ::This method is used to verify long tow allowed on member tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean verifyLongTowAllowedOnMemberTab() throws Throwable {
        boolean towAllowed = isVisibleOnly(DIMCDPage.lblLongTowAllowedOnMemberTabinMCD, "Long Tow Allowed");
        return towAllowed;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberPhoneNumberOnMemberTab
     * description ::This method is used to verify member phone number on member tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean verifyMemberPhoneNumberOnMemberTab() throws Throwable {
        boolean phoneNo = isVisibleOnly(DIMCDPage.lblMemberPhoneNumberOnMemberTabinMCD, "Phone Number");
        return phoneNo;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnServiceTabInMCDWindow
     * description ::This method is used to click on service on member tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean clickOnServiceTabInMCDWindow() throws Throwable {
        boolean serviceTab = isVisibleOnly(DIMCDPage.lnkServiceTabinMCD, "Service Tab");
        if (serviceTab) {
            click(DIMCDPage.lnkServiceTabinMCD, "Service Tab");
        } else {
            assertTrue(serviceTab, "Service tab is found");
        }
        return serviceTab;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyPacesetterCodeOnServiceTab
     * description ::This method is used to verify pacesetter code on service tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean verifyPacesetterCodeOnServiceTab() throws Throwable {
        boolean pacesetterCode = isVisibleOnly(DIMCDPage.lblPaceSetterCodeOnServiceTabinMCD, "Pacesetter Code");
        return pacesetterCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTroubleCodeOnServiceTab
     * description ::This method is used to verify trouble code on service tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean verifyTroubleCodeOnServiceTab() throws Throwable {
        boolean troubleCode = isVisibleOnly(DIMCDPage.lblTroubleCodeOnServiceTabinMCD, "Trouble Code");
        return troubleCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyServiceTypeinfoOnServiceTab
     * description ::This method is used to verify Service type on service tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean verifyServiceTypeinfoOnServiceTab() throws Throwable {
        boolean serviceType = isVisibleOnly(DIMCDPage.lblServiceTypeInfoOnServiceTabinMCD, "Sevice Type Info");
        return serviceType;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFacilityNameAndnumberOnServiceTab
     * description ::This method is used to verify facility name and number on service tab
     * date ::11-Jan-2018
     * author ::
     */
    public boolean verifyFacilityNameAndnumberOnServiceTab() throws Throwable {
        boolean facilityNameAndNumber = isVisibleOnly(DIMCDPage.lblFacilityNameAndNumberOnServiceTabinMCD, "Facility Name And Number");
        return facilityNameAndNumber;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyShowBatteryServiceHistoryButtonOnServiceTab
     * description ::This method is used to verify show battery information on service tab
     * date ::
     * author ::
     */
    public boolean verifyShowBatteryServiceHistoryButtonOnServiceTab() throws Throwable {
        boolean batteryService = isVisibleOnly(DIMCDPage.btnShowBatteryServiceHistory, "Battery Service history button");
        return batteryService;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationsTabInMCDWindow
     * description ::This method is used to click on locations tab in MCD window
     * date ::
     * author ::
     */
    public boolean clickOnLocationsTabInMCDWindow() throws Throwable {
        boolean locationsTab = isVisibleOnly(DIMCDPage.lnkLocationsTabinMCD, "Locations Tab");
        if (locationsTab) {
            click(DIMCDPage.lnkLocationsTabinMCD, "Locations Tab");
        } else {
            assertFalse(locationsTab, "Locations tab is not found");
        }
        return locationsTab;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownLocationOnLocationsTab
     * description ::This method is used to verify breakdown location on locations tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyBreakDownLocationOnLocationsTab() throws Throwable {
        boolean breakDownLoc = isVisibleOnly(DIMCDPage.lblBreakDownLocationOnLocationsTabinMCD, "BreakDown Location");
        return breakDownLoc;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowDestinationOnLocationsTab
     * description ::This method is used to verify Tow destination tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyTowDestinationOnLocationsTab() throws Throwable {
        boolean towdestination = isVisibleOnly(DIMCDPage.lblTowDestinationOnLocationsTabinMCD, "Tow Destination ");
        return towdestination;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicleTabInMCDWindow
     * description ::This method is used to click on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public boolean clickOnVehicleTabInMCDWindow() throws Throwable {
        boolean vehicleTab = isVisibleOnly(DIMCDPage.lnkVehicleTabinMCD, "Vehicle Tab");
        if (vehicleTab) {
            click(DIMCDPage.lnkVehicleTabinMCD, "Vehicle Tab");
        } else {
            assertTrue(vehicleTab, "Vehicle tab is found");
        }
        return vehicleTab;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleTypeOnVehicleTab
     * description ::This method is used to verify vehicle type on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyVehicleTypeOnVehicleTab() throws Throwable {
        boolean type = isVisibleOnly(DIMCDPage.lblVehicleTypeOnVehicleTabinMCD, "Vehicle Type");
        return type;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleYearOnVehicleTab
     * description ::This method is used to verify vehicle year on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyVehicleYearOnVehicleTab() throws Throwable {
        boolean year = isVisibleOnly(DIMCDPage.lblVehicleYearOnVehicleTabinMCD, "Vehicle year");
        return year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleMakeOnVehicleTab
     * description ::This method is used to verify vehicle make on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyVehicleMakeOnVehicleTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleMakeOnVehicleTabinMCD, "Vehicle make");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleModelOnVehicleTab
     * description ::This method is used to verify vehicle model on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyVehicleModelOnVehicleTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleModelOnVehicleTabinMCD, "Vehicle model");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleColorOnVehicleTab
     * description ::This method is used to verify vehicle color on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public boolean verifyVehicleColorOnVehicleTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleColorOnVehicleTabinMCD, "Vehicle Color");
        return make;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSP
     * description :: This method is used to click on Spotted button in MCD window
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnSP() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnSPOnMCDWindow, "Clicked on SP button");
        click(DIMCDPage.btnSPOnMCDWindow, "Clicked on SP button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTW
     * description :: this method is used to click on tow button in mcd window
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnTW() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnTWOnMCDWindow, "Clicked on TW button");
        click(DIMCDPage.btnTWOnMCDWindow, "Clicked on TW button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMemberHome
     * description :: This method is used to click on member home button
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnMemberHome() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnMemberHomeOnMCDWindow, "Clicked on Member Home button");
        click(DIMCDPage.btnMemberHomeOnMCDWindow, "Clicked on Member Home button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoTowPerformed
     * description :: this method is used to click on no tow performed link in mcd window
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnNoTowPerformed() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnNoTowPerformedOnMCDWindow, "Clicked on No Tow Performed button");
        click(DIMCDPage.btnNoTowPerformedOnMCDWindow, "Clicked on No Tow Performed button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairFacility
     * description :: this method is used to click on repair facility button in mcd window
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnRepairFacility() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnRepairFacilityOnMCDWindow, "Clicked on Repair Facility button");
        click(DIMCDPage.btnRepairFacilityOnMCDWindow, "Clicked on Repair Facility button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOtherLocation
     * description :: This method is used to click on other locations
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnOtherLocation() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnOtherLocationOnMCDWindow, "Clicked on Other Location button");
        click(DIMCDPage.btnOtherLocationOnMCDWindow, "Clicked on Other Location button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOriginalTowDestination
     * description :: this method is used to click on Original tow destination button
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnOriginalTowDestination() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnOriginalTowDestinationOnMCDWindow, "<b>is Visible Original Tow Destination button</b>");
        click(DIMCDPage.btnOriginalTowDestinationOnMCDWindow, "<b>Clicked on Original Tow Destination button</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoGo
     * description :: This method is used to select no go option while trying to cancel the call
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnNoGo() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnNOGOOnMCDWindow, "Clearing Screen");
        click(DIMCDPage.btnNOGOOnMCDWindow, "<b>Clicked on No Go button</b>");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoService
     * description :: This method is used to click on no service option
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnNoService() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnNOServiceOnMCDWindow, "Clicked on No Service button");
        click(DIMCDPage.btnNOServiceOnMCDWindow, "Clicked on No Service button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSubmitButton
     * description :: this method is used to click on submit button
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnSubmitButton() throws Throwable {
        Thread.sleep(3000);
        //waitForVisibilityOfElement(DIMCDPage.submitButton, "submit Button");
        if (isVisibleOnly(DIMCDPage.submitButton, "submit Button")) {
            click(DIMCDPage.submitButton, "click on submit Button");
        }

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsOnMCDWindow
     * description :: this method is used to enter values in comments text box
     * date :: 12-Jan-2018
     * author ::
     */

    public void enterCommentsOnMCDWindow(String comments) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCommentOnMCDWindow, "Comments entered");
        type(DIMCDPage.txtCommentOnMCDWindow, comments, "Comments entered");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressOnMCDWindow
     * description :: this method is used to enter address in address text box
     * date :: 12-Jan-2018
     * author ::
     */


    public void enterAddressOnMCDWindow(String address) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddressOnMCDWindow, "Address entered");
        type(DIMCDPage.txtAddressOnMCDWindow, address, "Address entered");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchIcon
     * description :: THis method is used to click on search iCon in mcd window
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnSearchIcon() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.iconSearchAddressOnMCDWindow, "Clicked on Search Icon");
        click(DIMCDPage.iconSearchAddressOnMCDWindow, "Clicked on Search Icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstLinkOnAddress
     * description :: this method is used to click on address first link
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnFirstLinkOnAddress() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.lnkClickOnFirstLink, "Clicked on First Link");
        mouseDoubleClick(DIMCDPage.lnkClickOnFirstLink, "Clicked on First Link");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSpottedStatus
     * description :: this method is used to get the spotted status in mcd window
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallSpottedStatus() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallSpottedStatus, "Call Spotted Status is available");
        String spottedStatus = getText(DIMCDPage.lblCallSpottedStatus, "Call Spotted Status is available");
        if (spottedStatus.contains("SP")) {
            reporter.SuccessReport("Spotted Status:", "<b>Spotted Status Verified</b>");
        } else {
            reporter.failureReport("Spotted Status:", "<b>Spotted Status Not Verified</b>", driver);
        }
        return spottedStatus;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallAssignedStatus
     * description :: this method is used to get the call assign status in mcd window
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallAssignedStatus(String StatusUpdateAS) throws Throwable {
        Thread.sleep(3000);
        if (StatusUpdateAS.equalsIgnoreCase("AS")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallAssignedStatus, "Call Assigned Status is available");
            String assignStatus = getText(DIMCDPage.lblCallAssignedStatus, "Call Assigned Status is available");
            if (assignStatus.contains("AS")) {
                reporter.SuccessReport("Assign Status:", "<b>Assign Status Verified</b>");
            } else {
                reporter.failureReport("Assign Status:", "<b>Assign Status Not Verified</b>", driver);
            }
        }
        return StatusUpdateAS;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallDispatchedStatus
     * description :: This method is used to get the call dispatch status in mcd window
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallDispatchedStatus(String StatusUpdateDI) throws Throwable {
        Thread.sleep(3000);
        if (StatusUpdateDI.equalsIgnoreCase("DI")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallDispatchedStatus, "Call Dispatched Status is available");
            String dispatchedStatus = getText(DIMCDPage.lblCallDispatchedStatus, "Call Dispatched Status is available");
            if (dispatchedStatus.contains("DI")) {
                reporter.SuccessReport("Dispatched Status:", "<b>Dispatched Status Verified</b>");
            } else {
                reporter.failureReport("Dispatched Status:", "<b>Dispatched Status Not Verified</b>", driver);
            }
        }
        return StatusUpdateDI;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallENRouteStatus
     * description ::This method is used to get the call Enroute status in mcd window
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallENRouteStatus(String StatusUpdateER) throws Throwable {
        Thread.sleep(3000);
        if (StatusUpdateER.equalsIgnoreCase("ER")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallENRouteStatus, "Call EN-Route Status is available");
            String enRouteStatus = getText(DIMCDPage.lblCallENRouteStatus, "Call EN-Route Status is available");
            if (enRouteStatus.contains("ER")) {
                reporter.SuccessReport("En Route Status:", "<b>En Route Status Verified</b>");
            } else {
                reporter.failureReport("En Route Status:", "<b>En Route Status Not Verified</b>");
            }
        }
        return StatusUpdateER;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallOnLocationStatus
     * description ::This method is used to verify On location status
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */

    public String lblCallOnLocationStatus(String StatusUpdateOL) throws Throwable {
        Thread.sleep(3000);
        if (StatusUpdateOL.equalsIgnoreCase("OL")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallOnLocationStatus, "Call On-Location Status is available");
            String onLocationStatus = getText(DIMCDPage.lblCallOnLocationStatus, "Call On-Location Status is available");
            if (onLocationStatus.contains("OL")) {
                reporter.SuccessReport("On Location Status:", "<b>On Location Status Verified</b>");
            } else {
                reporter.failureReport("On Location Status:", "<b>On Location Status Not Verified</b>", driver);
            }
        }
        return StatusUpdateOL;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallTowStatus
     * description :: This method is used to verify tow call status
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallTowStatus(String StatusUpdateTW) throws Throwable {
        Thread.sleep(4000);
        if (StatusUpdateTW.equalsIgnoreCase("TW")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallTowStatus, "Call Tow Status is available");
            String towStatus = getText(DIMCDPage.lblCallTowStatus, "Call Tow Status is available");
            if (towStatus.contains("TW")) {
                reporter.SuccessReport("Tow Status:", "<b>Tow Status Verified</b>");
            } else {
                reporter.failureReport("Tow Status:", "<b>Tow Status Not Verified</b>", driver);
            }
        }
        return StatusUpdateTW;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterfacilityOnStatusUpdateWindow
     * description :: this methid is used to enter value in spot facility
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void enterfacilityOnStatusUpdateWindow(String reSpotFacilityID) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtFacilityInStautusUpdateWindow, "Spot Facility entered");
        type(DIMCDPage.txtFacilityInStautusUpdateWindow, reSpotFacilityID, "Spot Facility entered");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropDownOnFacilityOnStatusUpdateWindow
     * description :: this method is used to click on dropdown on facility in Status update window
     * date :: 17-Jan-2018
     * author ::Abhiram
     */
    public void clickOnDropDownOnFacilityOnStatusUpdateWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.dropDownFacilityInStautusUpdateWindow, "Clicked on Facility");
        click(DIMCDPage.dropDownFacilityInStautusUpdateWindow, "Clicked on Facility");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: dropDownReasonInStautusUpdateWindow
     * description :: This method is used to select reason from reason field in status update window
     * date :: 17-Jan-2018
     * author ::Abhiram
     */
    public void dropDownReasonInStautusUpdateWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.dropDownReasonInStautusUpdateWindow, "Clicked on Reason");
        click(DIMCDPage.dropDownReasonInStautusUpdateWindow, "Clicked on Reason");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFunctionCodeOnServiceTab
     * Description:This method is used to verify Function Code On ServiceTab
     * date ::  18-Jan-2018
     * author :Madhukar
     */

    public boolean verifyFunctionCodeOnServiceTab() throws Throwable {
        boolean functionCode = isVisibleOnly(DIMCDPage.lblFunctionCodeOnServiceTabinMCD, "FunctionCode");
        return functionCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckLoadButtonOnServiceTab
     * Description:This method is used to verify truck load button in ServiceTab
     * date ::  18-Jan-2018
     * author :Madhukar
     */
    public boolean verifyTruckLoadButtonOnServiceTab() throws Throwable {
        boolean truckLoadButton = isVisibleOnly(DIMCDPage.btnTruckLoadOnServiceTabinMCD, "Truck Load Button");
        return truckLoadButton;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyLongTowUsedOnMemberTab
     * Description:This method is used to verify long tow used status availablity in member tab
     * date ::  18-Jan-2018
     * author :Madhukar
     */
    public boolean verifyLongTowUsedOnMemberTab() throws Throwable {
        boolean longTowUsed = isVisibleOnly(DIMCDPage.lblLongTowUsedOnMemberTabinMCD, "LongTowUsed");
        return longTowUsed;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDOBOnMemberTab
     * Description:This method is used to verify DOB  in member tab
     * date ::  18-Jan-2018
     * author :Madhukar
     */
    public boolean verifyDOBOnMemberTab() throws Throwable {
        boolean dOB = isVisibleOnly(DIMCDPage.lblDOBOnMemberTabinMCD, "DOB On MemberTab");
        return dOB;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: splitFacilityNameAndNumberOnServiceTabinDIMCD
     * description :: This method is used to split
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String splitFacilityNameAndNumberOnServiceTabinDIMCD() throws Throwable {

        String facilityNameAndFacilityNumber = getText(DIMCDPage.lblFacilityNameAndNumberOnServiceTabinDIMCD, "Facility Name and ID is available");
        String currentPaceCode[] = facilityNameAndFacilityNumber.split("-");
        String facilityName = currentPaceCode[0]; //facilityname
        String facilityNumber = currentPaceCode[1]; //facilitynumber
        return facilityNumber;
    }

    /**
     * Description:This method is used to verify Language preference on Member tab
     * date ::  18-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyLanguagepreferenceOnMemberTab() throws Throwable {
        boolean languagePreference = isVisibleOnly(DIMCDPage.lblLanguagePreferenceOnMemberTabinMCD, "Language preference");
        return languagePreference;
    }

    /**
     * Description:This method is used to verify ETA Time on MCD window
     * Date:19-01-2018
     *
     * @return
     * @throws Throwable
     */
    public String verifyETATimeOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
        String etaTimeAndDate = getText(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
        String etaTime = etaTimeAndDate.substring(11, 16);
        return etaTime;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInMCDWindow
     * description :: This method validates the comments in MCD wndow
     * date :: 20-Dec-2018
     * author :: Sachin
     */

    public void validateComentsInMCDWindow(String comments) throws Throwable {
        CommentsMCDWindow = getWebElementList(DIMCDPage.lblCommentsInMCDWindow, "Comments MCD Window");
        String commentsColUpdated = null;
        if (CommentsMCDWindow != null) {
            boolean flow = true;
            String commentsCol = "";
            for (int i = 0; i <= CommentsMCDWindow.size() - 1; i++) {
                commentsCol = CommentsMCDWindow.get(i).getText().toString().trim();
                commentsColUpdated = commentsCol.substring(commentsCol.lastIndexOf(':') + 1).trim();
                boolean existsVal = commentsColUpdated.equalsIgnoreCase(comments);

                if (existsVal) {
                    assertTrue(commentsColUpdated.equalsIgnoreCase(comments), "Comments entered displayed in MCD window:" + commentsColUpdated);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments entered not displayed in MCD window" + commentsColUpdated);
            }
        }
    }

    /**
     * Description:This method is used to verify Member Level on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberTypeOnMemberTab() throws Throwable {
        boolean type = isVisibleOnly(DIMCDPage.lblMemberTypeOnMemberTabinMCD, "Type");
        return type;
    }

    /**
     * * param :: NA
     * * return ::boolean
     * * throws :: throwable
     * * methodName :: verifyAddressAvailableInTowDestination
     * * description ::
     * * retrivedTime :: 22-Jan-2018
     * * author :: Abhiram
     */
    public boolean verifyAddressAvailableForOtherLocationInMCDWindow() throws Throwable {
        //waitForVisibilityOfElement(DIMCDPage.txtMessageNoDataAvailableForOtherLocationInMCDWindow, "Existing Address are Not Visible in MCD Window");
        boolean mcdWindowAddressAvailable = isVisibleOnly(DIMCDPage.txtMessageNoDataAvailableForOtherLocationInMCDWindow, "Existing Address are Not Visible in MCD Window");
        return mcdWindowAddressAvailable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEnterAddressManuallyForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author ::Abhiram
     */
    public void clickOnEnterAddressManuallyForOtherLocationInMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.linkEnterAddreddManuallyForOttherLocationInMCDWindow, "Clicked on Enter Address Manually");
        click(DIMCDPage.linkEnterAddreddManuallyForOttherLocationInMCDWindow, "Clicked on Enter Address Manually");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCrossStreet1ForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterCrossStreet1ForOtherLocationInMCDWindow(String crossStreet1) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterCrossStreeet1ForOtherLocationInMCDWindow, "cross Street 1 entered");
        type(DIMCDPage.txtEnterCrossStreeet1ForOtherLocationInMCDWindow, crossStreet1, "cross Street 1 entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCrossStreet2ForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterCrossStreet2ForOtherLocationInMCDWindow(String crossStreet2) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterCrossStreeet2ForOtherLocationInMCDWindow, "cross Street 2 entered");
        type(DIMCDPage.txtEnterCrossStreeet2ForOtherLocationInMCDWindow, crossStreet2, "cross Street 2 entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterLocationForOtherLocationInMCDWindow(String location) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterLocationForOtherLocationInMCDWindow, "Location entered");
        type(DIMCDPage.txtEnterLocationForOtherLocationInMCDWindow, location, "Location entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterCityForOtherLocationInMCDWindow(String city) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterCityForOtherLocationInMCDWindow, "City entered");
        type(DIMCDPage.txtEnterCityForOtherLocationInMCDWindow, city, "City entered");
    }

    /**
     * Description:This method is used to verify vehicle color on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyBatteryQuestionnaireInMCDWindow() throws Throwable {
        boolean batteryQuestionnaire = isVisibleOnly(DIMCDPage.lblBatteryQuestionnaireInMCDWindow, "Battery Questionnaire");
        return batteryQuestionnaire;
    }

    /**
     * Description:This method is used to verify Status update dropdown on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyDropDownButtonOfStatusOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Drop Down On Status Update Tab");
        boolean statusDropDown = isVisibleOnly(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Drop Down On Status Update Tab");
        return statusDropDown;
    }

    /**
     * Description:This method is used to verify Reason textbox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyReasonTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason On Status Update Tab");
        boolean reason = isVisibleOnly(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason On Status Update Tab");
        return reason;
    }

    /**
     * Description:This method is used to verify Facility TextBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyFacilityTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtFacilityInStautusUpdateWindow, "Facility On Status Update Tab");
        boolean Facility = isVisibleOnly(DIMCDPage.txtFacilityInStautusUpdateWindow, "Facility On Status Update Tab");
        return Facility;
    }

    /**
     * Description:This method is used to verify truck textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyTruckTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTruckInStautusUpdateTab, "Truck On Status Update Tab");
        boolean Truck = isVisibleOnly(DIMCDPage.txtTruckInStautusUpdateTab, "Truck On Status Update Tab");
        return Truck;
    }

    /**
     * Description:This method is used to verify Zone textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyZoneTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtZoneInStautusUpdateTab, "Zone On Status Update Tab");
        boolean Zone = isVisibleOnly(DIMCDPage.txtZoneInStautusUpdateTab, "Zone On Status Update Tab");
        return Zone;
    }

    /**
     * Description:This method is used to verify Tech textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyTechTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTechInStautusUpdateTab, "Tech On Status Update Tab");
        boolean Tech = isVisibleOnly(DIMCDPage.txtTechInStautusUpdateTab, "Tech On Status Update Tab");
        return Tech;
    }

    /**
     * Description:This method is used to verify ETA textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyETATextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtETAInStautusUpdateTab, "ETA On Status Update Tab");
        boolean ETA = isVisibleOnly(DIMCDPage.txtETAInStautusUpdateTab, "ETA On Status Update Tab");
        return ETA;
    }

    /**
     * Description:This method is used to verify Date textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyDateTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtDateInStautusUpdateTab, "Date Field On Status Update Tab");
        boolean Date = isVisibleOnly(DIMCDPage.txtDateInStautusUpdateTab, "Date Field Status Update Tab");
        return Date;
    }

    /**
     * Description:This method is used to verify Time textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyTimeTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTimeInStautusUpdateTab, "Time On Status Update Tab");
        boolean time = isVisibleOnly(DIMCDPage.txtTimeInStautusUpdateTab, "Time On Status Update Tab");
        return time;
    }

    /**
     * Description:This method is used to verify comments field on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyCommentsOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCommentsInStautusUpdateTab, "Comments On Status Update Tab");
        boolean comments = isVisibleOnly(DIMCDPage.txtCommentsInStautusUpdateTab, "Comments On Status Update Tab");
        return comments;
    }

    /**
     * Description:This method is used to verify cancel button on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyCancelButtoOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCancelOfStatusUpdateTabInMCD, "Cancel Button On Status Update Tab");
        boolean cancelButton = isVisibleOnly(DIMCDPage.btnCancelOfStatusUpdateTabInMCD, "Cancel Button On Status Update Tab");
        return cancelButton;
    }

    /**
     * Description:This method is used to verify update button on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyUpdateButtoOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button On Status Update Tab");
        boolean Update = isVisibleOnly(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button On Status Update Tab");
        return Update;
    }

    /**
     * Description:This method is used to click on status dropdown on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnStatusDropdownOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Dropdown Button and List Of Status Update Codes are available");
        click(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Dropdown Button and List Of Status Update Codes are available");
    }

    /**
     * Description:This method is used to click on Reason dropdown on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnReasonDropdownOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOnStatusUpdate, "Reason TextBox");
        click(DIMCDPage.txtReasonOnStatusUpdate, "Reason TextBox");
        click(DIMCDPage.drpdwnReasonOnStatusUpdateTabInMCDWindow, "Reason Dropdown and List of Reason Codes are available");
    }

    /**
     * Description:This method is used to get call status on MCD window
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String getCallStatusOnMCDwindow() throws Throwable {
        // waitForVisibilityOfElement(DIMCDPage.lblCallStatusOnMCDWindow, "Call Status");
        Thread.sleep(1000);
        String status = getText(DIMCDPage.lblCallStatusOnMCDWindow, "Call Status");
        return status;
    }

    /**
     * Description:This method is used to  verify No Truck Error Message on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String verifyNoTruckErrorMessage() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.noTruckErrorText, "No Truck Error Message");
        String error = getText(DIMCDPage.noTruckErrorText, "No Truck Error Message");
        click(DIMCDPage.btnOKForNoTruckError, "OK Button For No Truck Error Message");
        return error;
    }

    /**
     * Description:This method is used to enter TruckID on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void enterTruckIDOnStatusUpdateTab(String truckID) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTruckInStautusUpdateTab, "Truck ID");
        type(DIMCDPage.txtTruckInStautusUpdateTab, truckID, "Truck ID");
    }

    /**
     * Description:This method is used to verify reason dropdown is grayed out on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyReasonDropdownIsGrayedOutOnStatusTab() throws Throwable {
        click(DIMCDPage.txtReasonOnStatusUpdate, "Reason TextBox");
        boolean reasonDrpDwn = isElementPresent(DIMCDPage.drpdwnReasonGrayedOnStatusUpdateTabInMCDWindow, "Reason dropdown is Grayed out");
        return reasonDrpDwn;
    }

    /**
     * Description:This method is used to verify ETA Alert text on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyETAAlertOnStatusTab() throws Throwable {
        boolean etaAlert = isElementPresent(DIMCDPage.txtETAFieldAlert, "ETA Mandatory Field Alert");
        return etaAlert;
    }

    /**
     * Description:This method is used to enter ETA time on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void enterETATimeOnStatusUpdateTab(String eta) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtETAInStautusUpdateTab, "ETA On Status Update Tab");
        type(DIMCDPage.txtETAInStautusUpdateTab, eta, "ETA On Status Update Tab");

    }

    /**
     * Description:This method is used to verify whether ETA Time is Updated on MCD Window
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void verifyETAIsUpdatedOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
        getText(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
    }

    public boolean verifyReasonTextBoxIsGrayedOutStatusTab() throws Throwable {
        boolean reason = isElementPresent(DIMCDPage.txtReasonGrayedout, "Reason Textbox is grayed out ");
        return reason;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPaymentButtonOnOCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnPaymentButtonOnOCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnPaymentOnMCDWindow, "Payment Button");
        mouseHover(DIMCDPage.btnPaymentOnMCDWindow, "Hover on Payment Button");
        mouseDoubleClick(DIMCDPage.btnPaymentOnMCDWindow, "Hover on Payment Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void enterServiceAndChargesOnMCDWindow(String serviceType) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.drpDwnServicesAndChargesInMCDWindow, "Enter Serivice");
        type(DIMCDPage.drpDwnServicesAndChargesInMCDWindow, serviceType, "Enter Serivice");
        Thread.sleep(3000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropDownValueServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnDropDownValueServiceAndChargesOnMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.drpDwnServicesAndChargesValueOnMCDWindow, "Click Value Payment Charges");
        click(DIMCDPage.drpDwnServicesAndChargesValueOnMCDWindow, "Click Value Payment Charges");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonInServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnSaveButtonInServiceAndChargesOnMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnSaveInServiceAndChargesInMCDWindow, "Click Save Button On Service And Charges");
        click(DIMCDPage.btnSaveInServiceAndChargesInMCDWindow, "Click Save Button On Service And Charges");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCostInServiceAndChargesInMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */

    public void enterCostInServiceAndChargesInMCDWindow(String cost) throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(DIMCDPage.txtCostInServiceAndChargesInMCDWindow, "Enter Cost");
        type(DIMCDPage.txtCostInServiceAndChargesInMCDWindow, cost, "Enter Cost");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCostInServiceAndChargesInMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */

    public void enterCashCollectedInServiceAndChargesInMCDWindow(String cashCollected) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCashCollectedInServiceAndChargesInMCDWindow, "Enter Cash Collected");
        type(DIMCDPage.txtCashCollectedInServiceAndChargesInMCDWindow, cashCollected, "Enter Cash Collected");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonInServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnCloseButtonInServiceAndChargesOnMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnCloseInSericeAndChargesInMCDWindow, "Click Close Button On Service And Charges");
        click(DIMCDPage.btnCloseInSericeAndChargesInMCDWindow, "Click Close Button On Service And Charges");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyErrorMessageAtReasonInMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public boolean verifyErrorMessageAtReasonInMCDWindow() throws Throwable {
        boolean errorMessage = isVisibleOnly(DIMCDPage.errorMessageAtEnterReasonOnMCDWindow, "Error");
        return errorMessage;
    }

    /**
     * Description:This method is used to get Pacesetter code  On SummaryTab
     * date ::  29-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public String getPaceSetterCodeOnSummaryTab() throws Throwable {
        String pacesetter = getText(DIMCDPage.lblPaceSetterCodeOnSummaryTabinMCD, "Pacesetter Code");
        return pacesetter;
    }

    /**
     * Description:This method is used to get Pacesetter code  On SummaryTab
     * date ::  29-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public String getTroubleCodeOnSummaryTab() throws Throwable {
        String troubleCode = getText(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble Code");
        return troubleCode;
    }

    /**
     * Description:This method is used to verify Member Level on Member getMemberLevelOnMemberTabtab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public String getMemberLevelOnMemberTab() throws Throwable {
        String level = getText(DIMCDPage.lblMemberLevelOnMemberTabinMCD, "Level");
        return level;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressDetailsManuallyinMCD
     * description ::
     * date ::
     * author :: cigniti
     */
    public void enterAddressDetailsManuallyinMCD(String address, String crossStreet, String secondCrossStreet, String city) throws Throwable {
        clickOnEnterAddressManuallyForOtherLocationInMCDWindow();
        enterLocationForOtherLocationInMCDWindow(address);
        enterCrossStreet1ForOtherLocationInMCDWindow(crossStreet);
        enterCrossStreet2ForOtherLocationInMCDWindow(secondCrossStreet);
        enterCityForOtherLocationInMCDWindow(city);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickonSubmitandVerifyClearCallLabel
     * description ::
     * date ::
     * author :: cigniti
     */
    public void clickonSubmitandVerifyClearCallLabel(String StatusUpdateCL) throws Throwable {

        clickOnSubmit();
        Thread.sleep(5000);
        labelCallCleared(StatusUpdateCL);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeErrorAlert
     * description ::
     * date ::
     * author :: cigniti
     */
    public void closeErrorAlert() throws Throwable {
        waitForVisibilityOfElement(LoginPage.errorAlertOK, "OK Button");
        if (isVisibleOnly(LoginPage.errorAlertOK, "OK Button")) {
            assertTrue(isVisibleOnly(LoginPage.errorAlertOK, "Error alert"), ":OK Button");
            click(LoginPage.errorAlertOK, "Error alert OK button");
        } else {
            assertTrue(isVisibleOnly(LoginPage.errorAlertOK, "Error alert"), ":OK Button");
        }
    }

    public boolean selectExitCodeandEnterReasonandClickonContinue(String reason, String goResolutionCode, String StatusUpdateCL) throws Throwable {
        boolean errorMessage = false;
        boolean reasonCodeTextBoxAvailability = false;
        selectExitCode();
        clickOnContinue();
        Thread.sleep(3000);
        errorMessage = verifyErrorMessageAtReasonInMCDWindow();
        if (errorMessage) {
            closeErrorAlert();
            reasonCodeTextBoxAvailability = validateDisaleReasonCodeTextBoxForEdit();
            if (reasonCodeTextBoxAvailability) {
                //clickOnMCDCloseWindow();
                reporter.failureReport("Unable to clear call.", "Unable to clear call due to Reason Dropdown is Disabled", driver);
            } else {
                clearData(DIMCDPage.txtReason);
                enterReason(reason);
                clickOnContinue();
            }
        } else {
            if (goResolutionCode.equalsIgnoreCase("GO")) {
                boolean batteryQuestionsAvailable = verifyBatteryQuestionnaireInMCDWindow();
                if (batteryQuestionsAvailable == false) {
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                }
            }
        }
        return reasonCodeTextBoxAvailability;
    }

    public void batteyInfo(String batteryInfo, String odometerReading, String Comments, String StatusUpdateCL) throws Throwable {
        if (batteryInfo.equalsIgnoreCase("Info Input")) {
            boolean batteryQuestionAvailable = verifyBatteryQuestionnaireInMCDWindow();
            if (batteryQuestionAvailable) {
                if (batteryInfo.equalsIgnoreCase("Info Input")) {
                    clickAndEnterBatteryTestedInformation(odometerReading, Comments);
                    Thread.sleep(5000);
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                }
            } else {
                //clickonSubmitandVerifyClearCallLabel();
                labelCallCleared(StatusUpdateCL);
            }
        }
    }

    public void towConfirmation(String TowConfirmation, String TowConfComment, String TowConfEnterAddress, String MCDLocationAddress, String MCDcrossStreet, String MCDsecondCrossStreet, String MCDCity, String TowConfEnterOtherAddress, String StatusUpdateCL) throws Throwable {
        boolean verifyAddressAvailableForOtherLocationInMCDWindow = false;
        switch (TowConfirmation) {
            case "NoTowPerform":
                clickOnNoTowPerformed();
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            case "Original":
                clickOnOriginalTowDestination();
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            case "MemberHome":
                boolean memberHomeAvailability = verifyMemberHome();
                if (memberHomeAvailability) {
                    clickOnMemberHome();
                    enterCommentsOnMCDWindow(TowConfComment);
                    Thread.sleep(5000);
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                } else {
                    clickOnNoTowPerformed();
                    Thread.sleep(5000);
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                }
                break;
            case "RepairFacility":
                clickOnRepairFacility();
                enterAddressOnMCDWindow(TowConfEnterAddress);
                clickOnSearchIcon();
                Thread.sleep(4000);
                verifyAddressAvailableForOtherLocationInMCDWindow = verifyAddressAvailableForOtherLocationInMCDWindow();
                if (verifyAddressAvailableForOtherLocationInMCDWindow) {

                    enterAddressDetailsManuallyinMCD(MCDLocationAddress, MCDcrossStreet, MCDsecondCrossStreet, MCDCity);
                } else {
                    clickOnFirstLinkOnAddress();
                }
                enterCommentsOnMCDWindow(TowConfComment);
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            case "Other":
                clickOnOtherLocation();
                enterAddressOnMCDWindow(TowConfEnterOtherAddress);
                clickOnSearchIcon();
                Thread.sleep(4000);
                verifyAddressAvailableForOtherLocationInMCDWindow = verifyAddressAvailableForOtherLocationInMCDWindow();
                if (verifyAddressAvailableForOtherLocationInMCDWindow) {
                    enterAddressDetailsManuallyinMCD(MCDLocationAddress, MCDcrossStreet, MCDsecondCrossStreet, MCDCity);

                } else {
                    clickOnFirstLinkOnAddress();
                }
                enterCommentsOnMCDWindow(TowConfComment);
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            default:
                break;
        }
    }

    public boolean resolutionCode(String ResolutionCode, String Reason, String batteryInfo, String goResolutionCode, String StatusUpdateCL) throws Throwable {
        boolean reasonCodeTextBoxAvailability = false;
        switch (ResolutionCode) {
            case "Go":
                reasonCodeTextBoxAvailability = selectExitCodeandEnterReasonandClickonContinue(Reason, goResolutionCode, StatusUpdateCL);
                labelCallCleared(StatusUpdateCL);
                break;
            case "NoGo":
                clickOnNoGo();
                reasonCodeTextBoxAvailability = selectExitCodeandEnterReasonandClickonContinue(Reason, goResolutionCode, StatusUpdateCL);
                break;
            case "NoService":
                clickOnNoService();
                reasonCodeTextBoxAvailability = selectExitCodeandEnterReasonandClickonContinue(Reason, goResolutionCode, StatusUpdateCL);
                if (batteryInfo.isEmpty()) {
                    labelCallCleared(StatusUpdateCL);
                }

                break;
            default:
                break;
        }
        return reasonCodeTextBoxAvailability;
    }

    public void statusUpdateAsCL(String StatusUpdateCL) throws Throwable {
        if (StatusUpdateCL.equalsIgnoreCase("CL")) {
            Thread.sleep(2000);
            selectClearCall();
        }
    }

    public boolean verifyOkErrorAlert() throws Throwable {
        boolean okErrorAlertAvailable = isVisibleOnly(LoginPage.btnErrorAlertOK, "Existing Vehicles are Not Visible");
        return okErrorAlertAvailable;
    }

    public void closeErrorAlertOKButton() throws Throwable {
        if (isVisibleOnly(LoginPage.btnErrorAlertOK, "OK Button")) {
            click(LoginPage.btnErrorAlertOK, "Error alert OK button");
        }
    }

    public void statusUpdateAsTW(String StatusUpdateTW) throws Throwable {
        if (StatusUpdateTW.equalsIgnoreCase("TW")) {
            clickOnTW();
            Thread.sleep(2000);
            boolean noTowLableAvailable = verifyOkErrorAlert();
            if (!noTowLableAvailable) {
                lblCallTowStatus(StatusUpdateTW);
            } else {
                closeErrorAlertOKButton();
            }
        }
    }

    public void statusUpdateAsOL(String StatusUpdateOL) throws Throwable {
        if (StatusUpdateOL.equalsIgnoreCase("OL")) {
            selectOnLocation();
            Thread.sleep(2000);
            lblCallOnLocationStatus(StatusUpdateOL);
        }
    }

    public void statusUpdateAsETA(String StatusUpdateETA) throws Throwable {
        if (StatusUpdateETA.equalsIgnoreCase("ETA")) {
            clickOnETAButtonOnMCDWindow();
            setTimeForETA();
        }
    }

    public void statusUpdateAsER(String StatusUpdateER) throws Throwable {
        if (StatusUpdateER.equalsIgnoreCase("ER")) {
            selectEnroute();
            selectEnrouteTime();
            Thread.sleep(2000);
            lblCallENRouteStatus(StatusUpdateER);
        }
    }

    public void statusUpdateAsDI(String StatusUpdateDI) throws Throwable {
        if (StatusUpdateDI.equalsIgnoreCase("DI")) {
            selectDispatch();
            Thread.sleep(2000);
            lblCallDispatchedStatus(StatusUpdateDI);
        }
    }

    public void statusUpdateAsAS(String StatusUpdateAS) throws Throwable {
        if (StatusUpdateAS.equalsIgnoreCase("AS")) {
            clickOnAssign();
            selectFacility();
            Thread.sleep(2000);
            lblCallAssignedStatus(StatusUpdateAS);
        }
    }

    public void statusUpdateAsSP(String StatusUpdateSP) throws Throwable {
        switch (StatusUpdateSP) {
            case "SP":
                lblCallSpottedStatus();
                break;
            default:
                break;
        }
    }

    public void verifyFacilityAndEnterReasonAndReSpot(String SPEnterReason, String FacilityID) throws Throwable {
	    	/*String facilityNumberBeforeReport = splitFacilityNameAndNumberOnServiceTabinDIMCD();
            reporter.failureReport("Facility Number Before Respot","Facility Number Before Respot is:: " + facilityNumberBeforeReport);*/
        clickOnSP();
        enterReasonOnStatusUpdateTab(SPEnterReason);
        enterfacilityOnStatusUpdateWindow(FacilityID);
        clickOnUpdate();
        Thread.sleep(5000);
            /*splitFacilityNameAndNumberOnServiceTabinDIMCD();
            String facilityNumberAfterReport = splitFacilityNameAndNumberOnServiceTabinDIMCD();
            reporter.failureReport("Facility Number After Respot","Facility Number After Respot is:: " + facilityNumberAfterReport);*/
        lblCallSpottedStatus();
    }

    public void paymentForRAPCall(String cost, String cashCollected, String serviceType, String towServiceType) throws Throwable {
        Thread.sleep(4000);
        clickOnPaymentButtonOnOCDWindow();
        enterServiceAndChargesOnMCDWindow(serviceType);
        Thread.sleep(2000);
        //enterSecondServiceAndChargesOnMCDWindow(towServiceType);
        //clickOnDropDownValueServiceAndChargesOnMCDWindow();
        enterCostInServiceAndChargesInMCDWindow(cost);
        enterCashCollectedInServiceAndChargesInMCDWindow(cashCollected);
        clickOnSaveButtonInServiceAndChargesOnMCDWindow();
        clickOnCloseButtonInServiceAndChargesOnMCDWindow();

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: captureTroubleCodeInDispatch
     * description ::
     * date :: 29-jan-2018
     * author ::Varun
     */
    public String captureTroubleCodeInDispatch() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble code in Summary");
        String troubleCodeindispatch = getText(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble code in Summary");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return troubleCodeindispatch;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: captureTroubleCodeInDropdownDispatch
     * description ::
     * date :: 29-jan-2018
     * author ::Varun
     */
    public String captureTroubleCodeInDropdownDispatch() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTroubleCodeDropdown, "Trouble code in dispatch dropdown");
        String troubleCodeDrpdwndispatch = getAttributeByValue(DIMCDPage.txtTroubleCodeDropdown, "Trouble code in dispatch dropdown ");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return troubleCodeDrpdwndispatch;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: capturePaceSetterCodeDispatchSummary
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public String capturePaceSetterCodeDispatchSummary() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtPaceSetterCodeSummaryTab, "PaceSetter code in Summary");
        String paceSetterCode = getText(DIMCDPage.txtPaceSetterCodeSummaryTab, "PaceSetter code in Summary ");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return paceSetterCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: captureReasonDispatchDrpDwn
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public String captureReasonDispatchDrpDwn() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReason, "Reason in dropdown");
        String reasonCode = getText(DIMCDPage.txtReason, "Reason in dropdown ");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return reasonCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.iconPaymentOnMCDWindow, "Payment icon");
        click(DIMCDPage.iconPaymentOnMCDWindow, "Payment Icon");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectServicesDrpDwnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void selectServicesDrpDwnOnPaymentonAPD(String services) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.drpdwnServicesOnPaymentOfMCD, "Services Dropdown");
        click(DIMCDPage.drpdwnServicesOnPaymentOfMCD, "Services Dropdown");
        type(DIMCDPage.drpdwnServicesOnPaymentOfMCD, services, "Services and Charges dropdown");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterCashCollectedOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void enterCashCollectedOnPaymentonAPD(String CashCollected) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCashCollectedAPD, "Cash Collected");
        click(DIMCDPage.txtCashCollectedAPD, "Cash Collected");
        type(DIMCDPage.txtCashCollectedAPD, CashCollected, "Cash Collected");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceCostOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void enterServiceCostOnPaymentonAPD(String services) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCostAPD, "Service Cost");
        click(DIMCDPage.txtCostAPD, "Service Cost");
        type(DIMCDPage.txtCostAPD, services, "Service Cost");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSaveBtnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickSaveBtnOnPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAPDSave, "Save");
        click(DIMCDPage.btnAPDSave, "Save");


    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickCloseBtnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickCloseBtnOnPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCloseAPD, "Close");
        click(DIMCDPage.btnCloseAPD, "Close");


    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSubmitBtnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickSubmitBtnOnPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSubmitAPD, "Submit");
        click(DIMCDPage.btnSubmitAPD, "Submit");


    }

    /**
     * Description:This method is used to enter comments in status update tab.
     * Date:30-01-2018
     *
     * @param comments
     * @throws Throwable
     * @Author : Madhukar
     */

    public void enterCommentsOnStatusUpdateTab(String comments) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCommentsInStautusUpdateTab, "Comments Field");
        type(DIMCDPage.txtCommentsInStautusUpdateTab, comments, "Comments Field");
    }

    /**
     * Description:This method is used to click on status history link on MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnStatusHistoryLinkOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkStatusHistory, "Status History Link");
        click(DIMCDPage.lnkStatusHistory, "Status History Link");
    }

    /**
     * Description:This method is used to get the call status from status history tab on MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public String getStatusFromStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblStatusOnStatusHistoryTab, "Update Status");
        String upStatus = getText(DIMCDPage.lblStatusOnStatusHistoryTab, "Update Status");
        return upStatus;

    }

    /**
     * Description:This method is used to get the reason from status history tab on MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public String getReasonFromStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblReasonOnStatusHistoryTab, "Reason");
        String reason = getText(DIMCDPage.lblReasonOnStatusHistoryTab, "Reason");
        return reason;
    }

    /**
     * Description:This method is used to click plus icon to view comments on status history tab
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnPlusIconInStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkPlusIconForCommentsOnStatusHistoryTab, "Plus Icon");
        click(DIMCDPage.lnkPlusIconForCommentsOnStatusHistoryTab, "Plus Icon");
    }

    /**
     * Description:This method is used to view and verify comments on status history tab
     * Date:30-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String verifyCommentsFromStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPlusIconForCommentsSectionOnStatusHistoryTab, "Comments");
        String comments = getText(DIMCDPage.lblPlusIconForCommentsSectionOnStatusHistoryTab, "Comments");
        return comments;
    }

    /**
     * Description:This method is used to get Facility ID And Name On Summary Tab Of MCD Window
     * Date:30-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String getFacilityIDAndNameOnSummaryTabOfMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityIdAndNameOnSummaryTabinMCD, "FacilityIdAndName");
        String facilityNameAndID = getText(DIMCDPage.lblFacilityIdAndNameOnSummaryTabinMCD, "FacilityIdAndName");
        return facilityNameAndID;
    }

    /**
     * Description:This method is used to maximize MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void maximizeMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkMaximizeMCDWindow, "PoppedOut Window");
        click(DIMCDPage.lnkMaximizeMCDWindow, "PoppedOut Window");
    }

    /**
     * Description:This method is used to minimize MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void minimizeMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkMinimizeMCDWindow, "Pop in Window");
        click(DIMCDPage.lnkMinimizeMCDWindow, "Pop in Window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearCallID
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public String clearCallID(String clearType, String TowConfirmation, String TowConfComment, String TowConfEnterAddress, String MCDLocationAddress, String MCDcrossStreet, String MCDsecondCrossStreet, String MCDCity, String TowConfEnterOtherAddress, String reason) throws Throwable {
        String troubleCode = null;
        switch (clearType) {
            case "GO":
                spotStatus = getCallStatusOnMCDwindow();
                //getCallStatusOnMCDwindow();
                clickOnAssign();
                Thread.sleep(1000);
                assignStatus = getCallStatusOnMCDwindow();
                assertTrue(spotStatus != assignStatus, "Status changed from   " + spotStatus + " To " + assignStatus);
                selectFacility();
                Thread.sleep(1000);
                facilityStatus = getCallStatusOnMCDwindow();
                assertTrue(facilityStatus != assignStatus, "Status changed from   " + assignStatus + " To " + facilityStatus);
                selectDispatch();
                Thread.sleep(1000);
                dispatchStatus = getCallStatusOnMCDwindow();
                assertTrue(facilityStatus != dispatchStatus, "Status changed from  " + facilityStatus + " To " + dispatchStatus);
                selectEnroute();
                selectEnrouteTime();
                Thread.sleep(1000);
                enrouteStatus = getCallStatusOnMCDwindow();
                assertTrue(enrouteStatus != dispatchStatus, "Status changed from  " + dispatchStatus + " To " + enrouteStatus);
                selectOnLocation();
                Thread.sleep(1000);
                locationStatus = getCallStatusOnMCDwindow();
                assertTrue(locationStatus != enrouteStatus, "Status changed from  " + enrouteStatus + " To " + locationStatus);
                Thread.sleep(1000);
                selectClearCall();
                selectExitCode();
                boolean reasonCodeTextBoxAvailability = validateDisaleReasonCodeTextBoxForEdit();
                if (!reasonCodeTextBoxAvailability) {
                    troubleCode = getTroubleCodeFromClearingScreen();
                    //enterReason(reason);

                    clickOnContinue();
                    boolean errorMessageExists = verifyE213ErrorMessageAvailablity();
                    if (errorMessageExists) {
                        getE213ErrorMessage();
                        clickOnE213OkayButton();
                        enterReason(reason);
                        clickOnContinue();
                    }

                } else {
                    troubleCode = getTroubleCodeFromClearingScreen();
                    assertTrue(reasonCodeTextBoxAvailability, "<b>ReasonCode text box is not editable</b>");
                    clickOnContinue();
                }
                // clickOnContinue();
                boolean errorMessageExists = verifyE213ErrorMessageAvailablity();
                if (errorMessageExists) {
                    getE213ErrorMessage();
                    clickOnE213OkayButton();
                }


                boolean TowDestinationVisibility = verifyOriginalTowDestination();
                if (TowDestinationVisibility == true) {
                    if (TowConfirmation.equalsIgnoreCase("Original")) {
                        boolean visibilityOfOriginalTowButton = verifyOriginalTowDestination();
                        if (visibilityOfOriginalTowButton == true) {
                            clickOnOriginalTowDestination();
                        } else {
                            assertTrue(visibilityOfOriginalTowButton != true, "<b>Original Tow Destination Button is not available for GO Option</b>");
                        }
                    } else {
                        clickOnSubmit();
                        clearStatus = getCallStatusOnMCDwindow();
                        assertTrue(locationStatus != clearStatus, "<b>Status changed from  " + locationStatus + " To " + clearStatus + " Call Cleared Successfully</b>");
                    }
                }
                //clickOnNoTowPerformed();
                clickOnSubmit();

                if (errorMessageExists) {
                    getE213ErrorMessage();
                    clickOnE213OkayButton();
                }
                clearStatus = getCallStatusOnMCDwindow();
                assertTrue(locationStatus != clearStatus, "<b>Status changed from  " + locationStatus + " To " + clearStatus + " Call Cleared Successfully</b>");


                Thread.sleep(2000);
                break;
            case "NoGo":
                spotStatus = getCallStatusOnMCDwindow();
                //getCallStatusOnMCDwindow();
                clickOnAssign();
                Thread.sleep(1000);

                selectFacility();
                assignStatus = getCallStatusOnMCDwindow();
                assertTrue(spotStatus != assignStatus, "Status changed from   " + spotStatus + " To " + assignStatus);
                Thread.sleep(1000);
                facilityStatus = getCallStatusOnMCDwindow();
                assertTrue(facilityStatus != assignStatus, "Status changed from   " + assignStatus + " To " + facilityStatus);
                selectDispatch();
                Thread.sleep(1000);
                dispatchStatus = getCallStatusOnMCDwindow();
                assertTrue(facilityStatus != dispatchStatus, "Status changed from  " + facilityStatus + " To " + dispatchStatus);
                selectEnroute();
                selectEnrouteTime();
                Thread.sleep(1000);
                enrouteStatus = getCallStatusOnMCDwindow();
                assertTrue(enrouteStatus != facilityStatus, "Status changed from  " + dispatchStatus + " To " + enrouteStatus);
                selectOnLocation();
                Thread.sleep(1000);
                locationStatus = getCallStatusOnMCDwindow();
                assertTrue(locationStatus != enrouteStatus, "Status changed from  " + enrouteStatus + " To " + locationStatus);
                selectClearCall();
                // selectClearCall();
                clickOnNoGo();
                selectExitCode();

                boolean reasonCodeTextBoxAvailabilityNoGo = validateDisaleReasonCodeTextBoxForEdit();
                if (!reasonCodeTextBoxAvailabilityNoGo) {
                    troubleCode = getTroubleCodeFromClearingScreen();
                    //enterReason(reason);
                    clickOnContinue();
                    //Newly added
                    boolean errorMessageExistsNoGO = verifyE213ErrorMessageAvailablity();
                    if (errorMessageExistsNoGO) {
                        getE213ErrorMessage();
                        clickOnE213OkayButton();
                        enterReason(reason);
                        clickOnContinue();
                    }

                    boolean TowDestinationVisibilityNoGO = verifyOriginalTowDestination();
                    if (TowDestinationVisibilityNoGO == true) {
                        if (TowConfirmation.equalsIgnoreCase("Original")) {
                            boolean visibilityOfOriginalTowButton = verifyOriginalTowDestination();
                            if (visibilityOfOriginalTowButton == true) {
                                clickOnOriginalTowDestination();
                            } else {
                                clickOnNoTowPerformed();
                            }
                        } else {
                            clickOnSubmit();
                            clearStatus = getCallStatusOnMCDwindow();
                            assertTrue(locationStatus != clearStatus, "<b>Status changed from  " + locationStatus + " To " + clearStatus + " Call Cleared Successfully</b>");
                        }
                    }
                    // clickOnNoTowPerformed();
                    clickOnSubmit();

                    clearStatus = getCallStatusOnMCDwindow();
                    assertTrue(locationStatus != clearStatus, "<b>Status changed from  " + locationStatus + " To " + clearStatus + " Call Cleared Successfully</b>");
                    Thread.sleep(2000);

                } else {
                    troubleCode = getTroubleCodeFromClearingScreen();
                    assertTrue(reasonCodeTextBoxAvailabilityNoGo, "<b>ReasonCode text box is not editable</b>");
                    clickOnContinue();
                }
                boolean errorMessageExistsNoGO = verifyE213ErrorMessageAvailablity();
                if (errorMessageExistsNoGO) {
                    getE213ErrorMessage();
                    clickOnE213OkayButton();
                }


                break;

            default:
                break;
        }
        return troubleCode;
    }


    /**
     * Description:This method is used to verify Member Level on Member getMemberLevelOnSummaryTabtab
     * date ::  30-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public String getMemberLevelOnSummaryTab() throws Throwable {
        Thread.sleep(1000);
        String memberLevel = getText(DIMCDPage.lblMemberLevelOnSummaryTab, "Member Level on Summary Tab");
        return memberLevel;
    }


    public String getCallTakerName() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCallTaker, "Call Taker Name");
        String callTaker = getText(DIMCDPage.txtCallTaker, "Call Taker Name");
        return callTaker;
    }

    public String getphoneNumberFromMCD(String phoneNumber) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.phoneNumberValue(phoneNumber), "Phone Number");
        String phoneNumber1 = getText(DIMCDPage.phoneNumberValue(phoneNumber), "Phone Number");
        String phoneNum[] = phoneNumber.split(" ");
        String phone1 = phoneNum[0].substring(1, 4);
        String phone2[] = phoneNum[1].split("-");
        String phone3 = phone2[0];
        String phone4 = phone2[1];

    /*String phoneString1=getText(DIMCDPage.phoneNumberONMCD,"Phone Number").substring(1,3);
    String phoneString2=getText(DIMCDPage.phoneNumberONMCD,"Phone Number").substring(6,8);
    String phoneString3=getText(DIMCDPage.phoneNumberONMCD,"Phone Number").substring(10,13);*/
        Thread.sleep(3000);
        String phoneNumberFromResults = phone1 + phone3 + phone4;
        return phoneNumberFromResults;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: mousehoverAndClickOnPencil
     * description ::
     * date :: 29-Jan-2018
     * author ::
     */
    public void mousehoverAndClickOnPencil() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
   /* mouseHoverByJavaScript(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
    getText(DIMCDPage.editIconOnPencilIcon, "edit icon on Pencil icon in MCD Window");
    Thread.sleep(1000);*/
        mouseDoubleClick(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");

        // clickUntilElementNotVisiable(DIMCDPage.imgPencilIcon,DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddButton
     * description ::
     * date :: 31-Jan-2018
     * author ::Ravi
     */
    public void clickOnAddButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAdd, "Click on add button");
        click(DIMCDPage.btnAdd, "click on add button ");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAddCommentAndSave
     * description ::
     * date :: 31-Jan-2018
     * author ::Ravi
     */
    public boolean enterAddCommentAndSave(String AddComment) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddComment, "wait for txt Add Comment");
        boolean addComment = type(DIMCDPage.txtAddComment, AddComment, "Add Comment from testdata");
        Thread.sleep(2000);
        click(DIMCDPage.btnSave, "save button");
        return addComment;

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCommentedData
     * description ::
     * date :: 31-Jan-2018
     * author ::Ravi
     */
    public void clickOnCommentedData() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.commentedData, "Click on commented data");
        getText(DIMCDPage.commentedData, "click on commented Data ");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStatusOnCurrentButton
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public String getStatusOnCurrentButton() throws Throwable {
        String currentStatus = getAttributeByClass(DIMCDPage.btnHighlightedStatus, "Highlighted status    ");
        return currentStatus;
    }

    /**
     * param ::
     * return ::Param
     * throws :: throwable
     * methodName :: getStatusOnNextButton
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public String getStatusOnNextButton() throws Throwable {
        String nextStatus = getAttributeByClass(DIMCDPage.btnNextSelected, "Next status     ");
        return nextStatus;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheStatusChange
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public boolean verifyTheStatusChange(String currentStatus, String nextStatus, String currentStatusData, String nextStatusData) throws Throwable {
        boolean statusFlag = false;
        if (currentStatus.contains(currentStatusData) && nextStatus.contains(nextStatusData)) {
            statusFlag = true;
        }
        return statusFlag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyClearingTabOnSPPMCDWindow
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public boolean verifyClearingTabOnSPPMCDWindow() throws Throwable {

        waitForVisibilityOfElement(DIMCDPage.lblClearingTab, "Clearing Tab on MCD Window");
        boolean clearingWindow = isVisibleOnly(DIMCDPage.lblClearingTab, "Clearing Tab on MCD Window");
        return clearingWindow;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCallTakerFromMCDWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Lakshmi
     */
    public String getCallTakerFromMCDWindow() throws Throwable

    {
        waitForVisibilityOfElement(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
        isVisibleOnly(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
        String callTakerOnMCDWindow = getText(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
        return callTakerOnMCDWindow;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: closeFacilityPTAWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Lakshmi
     */
    public void closeFacilityPTAWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnPtaClose, "Facility PTA close button");
        click(DIMCDPage.btnPtaClose, "Facility PTA close button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void enterSecondServiceAndChargesOnMCDWindow(String towServiceType) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.drpDwnAddSecondServicesAndChargesInMCDWindow, "Enter Service");
        type(DIMCDPage.drpDwnAddSecondServicesAndChargesInMCDWindow, towServiceType, "Enter Service");
        Thread.sleep(3000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnBidCallButton
     * description ::
     * date :: 03-Jan-2018
     * author ::Lakshmi
     */
    public void clickOnBidCallButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnBidCallInMCD, "Bid Call Button");
        click(DIMCDPage.btnBidCallInMCD, "Bid Call Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTruckIdFromMCDWindow
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */

    public String getTruckIdFromMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblTruckIDOnMCDSummaryScreen, "Truck ID");
        String truckId = getText(DIMCDPage.lblTruckIDOnMCDSummaryScreen, "Truck ID");
        //String truckid = truckId.substring(0,1);
        //String truck = truckid[0];
        return truckId;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDeclineButton
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */

    public void clickOnDeclineButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnDeclainCallinMCD, "Decline Button");
        click(DIMCDPage.btnDeclainCallinMCD, "Decline Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButton
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */
    public void clickOnPoppedOutButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnPopOutInMCD, "PoppedOut Button");
        isVisibleOnly(DIMCDPage.btnPopOutInMCD, "PoppedOut Button");
        click(DIMCDPage.btnPopOutInMCD, "PoppedOut Button");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyPoppedOutWindow
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */
    public boolean verifyPoppedOutWindow() throws Throwable {
        boolean poppedIn = isVisibleOnly(DIMCDPage.lnkMinimizeMCDWindow, "PoppedIn");
        return poppedIn;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnPoppedInButton
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */
    public void clickOnPoppedInButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkMinimizeMCDWindow, "PoppedIn Button");
        click(DIMCDPage.lnkMinimizeMCDWindow, "PoppedIn Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getResaonCodeForClearedCallInMCDWindow
     * description ::
     * date :: 05-Feb-2018
     * author ::Chandra
     */
    public String getResaonCodeForClearedCallInMCDWindow() throws Throwable {
        String reasonCode = getText(DIMCDPage.lblReasonCodeOnMCDHisotryWindow, "Cleared call Reason Code");
        return reasonCode;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnCloseIconOnHistoryStatus
     * description ::
     * date :: 05-Feb-2018
     * author ::Chandra
     */
    public void clickOnCloseIconOnHistoryStatus() throws Throwable {
        click(DIMCDPage.iconCloseOnStatusHistoryTabInMCDWindow, "Close History Icon");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPacesetterValue
     * description ::
     * date :: 05-Jan-2018
     * author ::Ravi
     */
    public String getPacesetterValue() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterValueInMCD, "Paceseter value");
        String pacesetterValue = getText(DIMCDPage.lblPaceSetterValueInMCD, "pacesetter value");
        return pacesetterValue;
    }

    /**
     * Description:To enter details on Battery service tab
     *
     * @param odoMeterReading
     * @param comments
     * @param testCode
     * @param batteryType
     * @param batteryPrice
     * @throws Throwable
     */
    public void clickAndEnterBatteryInformation(String odoMeterReading, String comments, String testCode, String batteryType, String batteryPrice) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.batteryTestedYes, "battery tested yes");
        click(DIMCDPage.batteryTestedYes, "click on battery tested yes");
        type(DIMCDPage.txtTestCodeBattery, testCode, "Test Code");
        click(DIMCDPage.batteryFailedTestYes, "click on battery failed test Yes");
        click(DIMCDPage.batteryChargeYes, "Battery Charge Yes");
        click(DIMCDPage.batteryWarrantyYes, "Battery Warranty Yes");
        type(DIMCDPage.txtBatteryType, batteryType, "Battery Type");
        type(DIMCDPage.txtBatteryPrice, batteryPrice, "Battery Price");
        type(DIMCDPage.odometerReading, odoMeterReading, "ODOMETER Reading");
        type(DIMCDPage.enterComments, comments, "Done a Jump Start");

    }

    /**
     * Description:To verify Address Verified Icon on original Tow destination Tab.
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyAddressverifiedIconOnOriginalTowDestinationTab() throws Throwable {
        boolean addressVerified = isVisibleOnly(DIMCDPage.iconAddressverifiedOnOriginalTowDestinaton, "Address verified ");
        return addressVerified;
    }

    public boolean verifyOriginalTowDestination() throws Throwable {
        Thread.sleep(3000);
        boolean originalTowdestination = isVisibleOnly(DIMCDPage.btnOriginalTowDestinationOnMCDWindow, "Original Tow Destination button");
        return originalTowdestination;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallBDStatus
     * description ::
     * date :: 05-Feb-2018
     * author ::Varun
     */
    public void lblCallBDStatus() throws Throwable {
        getText(DIMCDPage.lblCallBDStatus, "<b>Call BD Status is available</b>");
    }


    public void selectBDStatus() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnBDUpdateinMCD, "BD status Update");
        click(DIMCDPage.btnBDUpdateinMCD, "Select BD");
    }

    public void statusUpdateAsBD(String StatusUpdateBD) throws Throwable {
        if (StatusUpdateBD.equalsIgnoreCase("BD")) {
            selectBDStatus();
            Thread.sleep(2000);
            lblCallBDStatus();
        }
    }

    public String lblCallCAStatus() throws Throwable {
        String Status = getText(DIMCDPage.lblCallCAStatus, "<b>Call CA Status is available</b>");
        return Status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPencilIcon
     * description ::
     * date :: 6-feb-2018
     * author ::
     */
    public void clickOnPencilIcon() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
        mouseDoubleClick(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnMCDMinimiseIcon
     * description ::
     * date :: 06-Feb-2018
     * author ::varun
     */
    public void clickOnMCDMinimiseIcon() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.linkMinimizeMCDwindow, "MCD minimise");
        click(DIMCDPage.linkMinimizeMCDwindow, "MCD minimise");

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickAckOnMCDwindow
     * description ::
     * date :: 06-Feb-2018
     * author ::varun
     */
    public void clickAckOnMCDwindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAcknowledgeMCD, "ACK button");
        click(DIMCDPage.btnAcknowledgeMCD, "ACK button");

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnDuplicateCallButton
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void clickOnDuplicateCallIcon() throws Throwable {
        isVisibleOnly(DIMCDPage.btnDupeCallOnMCD, "Duplicate Call Icon");
        click(DIMCDPage.btnDupeCallOnMCD, "Duplicate Call Icon");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyDuplicateCallButton
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyDuplicateCallButton() throws Throwable {

        String dupeCallButtonText = null;

        boolean dupecallIcon = isVisibleOnly(DIMCDPage.btnDupeCallOnMCD, "Duplicate Call Icon");
        if (dupecallIcon) {
            mouseHover(DIMCDPage.btnDupeCallOnMCD, "Duplicate Call Icon");
            Thread.sleep(2000);
            //Validation for dupe call button Tool Tip
            boolean dupeCallToolTip = isVisibleOnly(DIMCDPage.btnDupeCallPopUpNameOnMCD, "Duplicate Call Icon name");
            if (dupeCallToolTip) {
                dupeCallButtonText = getText(DIMCDPage.btnDupeCallPopUpNameOnMCD, "Duplicate Call Name");
                assertTrue(dupecallIcon, "<b>Verified the Duplicate call button and Duplicate Call button is available on the MCD window. Button name is   ::  </b>" + dupeCallButtonText);
            } else {
                reporter.failureReport("Dupe call Tool Top Availability.", "Dupe call Tool tip is not available..", driver);
            }
        } else {
            assertTrue(dupecallIcon, "Dupe call Icon Is not visible In SPP Dispatch");
        }
        return dupecallIcon;

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyDulicateThisCallTab
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyDulicateThisCallTab() throws Throwable {
        String duplicateCallTab = getText(DIMCDPage.txtDuplicateCallTab, "Duplicate Tab");
        return duplicateCallTab;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyCurrentCallInfoOption
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyCurrentCallInfoOption() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCurrentCallOption, "Current Call On DuplicateCall Tab");
        String currentCallInfo = getText(DIMCDPage.lblCurrentCallOption, "Current Call On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Current Call option , Option name on the Duplicate Call Tab  is   ",currentCallInfo);
        return currentCallInfo;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifryCallIdOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    //verifyCurrentCallInfoOption
    public String verifryCallIdOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallIDOnDuplicateCallTab, "Call ID Option On DuplicateCall Tab");
        String callID = getText(DIMCDPage.lblCallIDOnDuplicateCallTab, "Call ID Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Call ID option , Option name on the Duplicate Call Tab is   ",callID);
        return callID;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifryFacilityOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifryFacilityOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityOnDuplicateCallTab, "Facility Option On DuplicateCall Tab");
        String facility = getText(DIMCDPage.lblFacilityOnDuplicateCallTab, "Facility Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Facility Option  , Option name on the Duplicate Call Tab is   ",facility);
        return facility;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyTruckOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyTruckOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblTruckOnDuplicateCallTab, "Truck Option On DuplicateCall Tab");
        String truck = getText(DIMCDPage.lblTruckOnDuplicateCallTab, "Truck Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Truck Option  , Option name on the Duplicate Call Tab is   ",truck);
        return truck;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyPaceSetterCodeOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyPaceSetterCodeOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterOnDuplicateCallTab, "PaceSetter Code Option On DuplicateCall Tab");
        String paceSetterCode = getText(DIMCDPage.lblPaceSetterOnDuplicateCallTab, "PaceSetter Code Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the PaceSetter Code Option  , Option name on the Duplicate Call Tab is   ",paceSetterCode);
        return paceSetterCode;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyStatusOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyStatusOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblStatusOnDuplicateCallTab, "Status  Option On DuplicateCall Tab");
        String status = getText(DIMCDPage.lblPaceSetterOnDuplicateCallTab, "Status Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Status Option  , Option name on the Duplicate Call Tab is   ",status);
        return status;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyNewDuplicateCallInfoOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyNewDuplicateCallInfoOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblNewDulicateCallInformationOnDuplicateCallTab, "New Duplicate Call Info Option On DuplicateCall Tab");
        String newDulicateCall = getText(DIMCDPage.lblNewDulicateCallInformationOnDuplicateCallTab, "New Duplicate Call Info Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the New Duplicate Call Info Option  , Option name on the Duplicate Call Tab is   ",newDulicateCall);
        return newDulicateCall;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifySpotToFacilityDrpDwnOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifySpotToFacilityDrpDwnOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblSpotToFacilityOnDuplicateCallTab, "Spot To Facility Drop-Down  On DuplicateCall Tab");
        String spotToFacility = getText(DIMCDPage.lblSpotToFacilityOnDuplicateCallTab, "Spot To Facility Drop-Down  On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Spot To Facility Drop-Down    , Option name on the Duplicate Call Tab is   ",spotToFacility);
        return spotToFacility;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyPaceSetterDrpDwnOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyPaceSetterDrpDwnOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterCodeDrpDwnOnDuplicateCallTab, "PaceSetter Code Drop-Down  On DuplicateCall Tab");
        String paceSetterDrpDwn = getText(DIMCDPage.lblPaceSetterCodeDrpDwnOnDuplicateCallTab, "PaceSetter Code Drop-Down On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the PaceSetter Code Drop-Down   , Option name on the Duplicate Call Tab is   ",paceSetterDrpDwn);return
        return paceSetterDrpDwn;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyReasonDrpDwnOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyReasonDrpDwnOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblReasonDrpDwnOnDuplicateCallTab, "Reason Drop-Down  On DuplicateCall Tab");
        String reason = getText(DIMCDPage.lblReasonDrpDwnOnDuplicateCallTab, "Reason Drop-Down On DuplicateCall Tab");
        return reason;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyCommentsOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyCommentsOnDuplicateThisCallTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCommentsDrpDwnOnDuplicateCallTab, "Comments  On DuplicateCall Tab");
        String comments = getText(DIMCDPage.lblCommentsDrpDwnOnDuplicateCallTab, "Comments On DuplicateCall Tab");
        return comments;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnDuplicateCallButton
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void clickOnDuplicateCallButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnDuplicateCallOnDuplicateCallTab, "Duplicate Call Button On Duplicate This Call Tab");
        click(DIMCDPage.btnDuplicateCallOnDuplicateCallTab, "Duplicate Call Button On Duplicate This Call Tab");

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyErrorMessageForMandatoryFields
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyErrorMessageForMandatoryFields() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.errMsgForMandatoryFieldsOnDuplicateCallTab, "Error Message for Mandatory Fields On Duplicate This Call Tab");
        isVisibleOnly(DIMCDPage.errMsgForMandatoryFieldsOnDuplicateCallTab, "Error Message for Mandatory Fields On Duplicate This Call Tab");
        String erroMsg = getText(DIMCDPage.errMsgForMandatoryFieldsOnDuplicateCallTab, "Error Message for Mandatory Fields On Duplicate This Call Tab");
        Thread.sleep(3000);
        //click(DIMCDPage.btnErrorMsgOkOnDuplicateCallTab,"Click On Error alrert Ok Button");
        return erroMsg;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterFacilityToSpotOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterFacilityToSpotOnDuplicateCallTab(String facility) throws Throwable {
        isVisibleOnly(DIMCDPage.txtSpotFacility, "Facility to spot");
        type(DIMCDPage.txtSpotFacility, facility, "Facility to spot");
        click(DIMCDPage.lnkToSelectFacilityOnNewDuplicateCall, "Select Facility From Droup Down");
        Thread.sleep(2000);
        click(DIMCDPage.txtAreaForComments, "Click On Comments");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getSelectedFacility
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getSelectedFacility() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtSpotFacility, "Facility to spot");
        String facility = getAttributeByValue(DIMCDPage.txtSpotFacility, "Facility to spot");
        return facility;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterPaceSetterCodeOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterPaceSetterCodeOnDuplicateCallTab(String paceSetterCode) throws Throwable {
        isVisibleOnly(DIMCDPage.txtPaceSetterCode, "PaceSetter Code");
        type(DIMCDPage.txtPaceSetterCode, paceSetterCode, "PaceSetter Code");
        click(DIMCDPage.lnkToSelectPacesetterCode, "Select PaceSetterCode");
        Thread.sleep(2000);
        click(DIMCDPage.txtAreaForComments, "Click On Comments");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getSelectedPaceSetterCode
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getSelectedPaceSetterCode() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtPaceSetterCode, "Selected PaceSetter Code");
        String paceSetterCode = getAttributeByValue(DIMCDPage.txtPaceSetterCode, "Selected PaceSetter Code");
        return paceSetterCode;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterReasonOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterReasonOnDuplicateCallTab(String reason) throws Throwable {
        isVisibleOnly(DIMCDPage.txtReasonOnDuplicateCallTab, "Reason on Duplicate Call Tab");
        type(DIMCDPage.txtReasonOnDuplicateCallTab, reason, "Reason on Duplicate Call Tab");
        click(DIMCDPage.lnkSelectReasonOnNewDuplicateCall, "Select Reason Duplicate Call Tab");
        Thread.sleep(2000);
        click(DIMCDPage.txtAreaForComments, "Click On Comments");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getSelectedReason
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getSelectedReason() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOnDuplicateCallTab, "Reason on Duplicate Call Tab");
        String reason = getAttributeByValue(DIMCDPage.txtReasonOnDuplicateCallTab, "Reason on Duplicate Call Tab ");
        return reason;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterCommentsOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterCommentsOnDuplicateCallTab(String comments) throws Throwable {
        isVisibleOnly(DIMCDPage.txtAreaForComments, "Comments On Duplicate call Tab");
        type(DIMCDPage.txtAreaForComments, comments, "Comments On Duplicate call Tab");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getEnteredComments
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getEnteredComments() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAreaForComments, "Comments On Duplicate call Tab");
        String comments = getAttributeByValue(DIMCDPage.txtAreaForComments, "Comments On Duplicate call Tab");
        return comments;
    }

    public boolean compareTwoValues(String getValue, String inputValue) throws Throwable {
        boolean comparedValues = getValue.contains(inputValue);
        return comparedValues;
    }

    public void clickOnErrorAlrertOkButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnErrorMsgOkOnDuplicateCallTab, "Click On Error alrert Ok Button");
        click(DIMCDPage.btnErrorMsgOkOnDuplicateCallTab, "Click On Error alrert Ok Button");
    }

    public void clickOnAdditionalInfoLinkInMCDServiceTab() throws Throwable {
        click(DIMCDPage.lnkEditAdditionalInfo, "Additional Info Link");
    }

    public String enterSpecialEquipmentInMCDServiceTab(String specialEqupementInMCD) throws Throwable {
        type(DIMCDPage.txtSpecialEquipementInMCDServiceTab, specialEqupementInMCD, "Special Equipement value");
        return specialEqupementInMCD;
    }

    public String enterReasonForStatus(String reasonForStatus) throws Throwable {
        type(DIMCDPage.txtReasonCodeInUpdateStatus, reasonForStatus, "Reason For Status value");
        return reasonForStatus;
    }

    public String enterCommentsInUpdateCallStatus(String comments) throws Throwable {
        type(DIMCDPage.txtCommentsInUpdateStatus, comments, "Comments For Status value");
        return comments;
    }

    public void clickOnUpdateButtonInUpdateStatus() throws Throwable {
        click(DIMCDPage.btnUpdatebuttonOnUpdateStatusPopup, "Update button in update status");
    }

    public void clickOnSaveButtonInSpecialEquiptmentSection() throws Throwable {
        click(DIMCDPage.btnSpecialEquipementSaveButton, "Save button");
    }

    public String getSpecialEquipmentValueInMCDServiceTab() throws Throwable {
        String specialEquipmentValue = getText(DIMCDPage.lblSpecialEquipmentInMCDServiceTab, "Special equipment value");
        return specialEquipmentValue;
    }

    public String getlblLatestCommentsInMCDWindow() throws Throwable {
        String savedComments = getText(DIMCDPage.lblLatestCommentsInMCDWindow, "Comments");
        return savedComments;
    }

    public void clickOnDateHeaderToSortDate() throws Throwable {
        click(DIMCDPage.sortdateInHisotrywindow, "Date wise sort");

    }

    public String getStatusInHistoryStatusScreenInMCDWindow() throws Throwable {
        String historyStatus = getText(DIMCDPage.lblStatusInHistoryStatus, "Status In History Status");
        return historyStatus;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberHome
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public boolean verifyMemberHome() throws Throwable {
        boolean MemberHomeAvailable = isVisibleOnly(DIMCDPage.btnMemberHomeOnMCDWindow, "Member Home button");
        return MemberHomeAvailable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdFromMcdWindow
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public String getCallIdFromMcdWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallIdOnMcdWindow, "Call Id From MCD Window");
        String callid = getText(DIMCDPage.lblCallIdOnMcdWindow, "Get Call Id From MCD Window");
        return callid;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPaceSetterCodeFromSummary
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public String getPaceSetterCodeFromSummary() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterCodeInMCD, "PaceSetter Code In Summary");
        String paceSetterCode = getText(DIMCDPage.lblPaceSetterCodeInMCD, "PaceSetter Code In Summary");
        String currentPaceCode[] = paceSetterCode.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        return PaceCodeValue;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFacilityFromFacilitySummary
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public String getFacilityFromFacilitySummary() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary");
        Thread.sleep(2000);
        String facility = getText(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary");
        //String facilityFromSummary[] = facility.split(":");
        //String facilityValue = facilityFromSummary[1];
        return facility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeTheOpendCallInMCD
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public void closeTheOpendCallInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkToCloseTheOpendCallInMCD, "Close The opened call");
        click(DIMCDPage.lnkToCloseTheOpendCallInMCD, "Close The opened call");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStarStatusByClassName
     * description ::
     * date :: 12-Feb-2018
     * author ::
     */
    public String getStarStatusOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblStarColor, "Getting the Star Status");
        String starStatus = getAttributeByClass(DIMCDPage.lblStarColor, "Getting the Star Status By Class Name");
        //String starStatus = getCssValue(DIMCDPage.lblStarColor,"4px solid yellow");
        return starStatus;
    }

    /**
     * Validate datapoints on MCD Window
     **/
    public boolean verifyShowBatteryServiceHistoryButtonForRAPCall() throws Throwable {
        boolean showBatteryServiceHistory = isVisibleOnly(DIMCDPage.btnShowBatteryServiceHistoryForRAP, "Show Battery Service History");
        return showBatteryServiceHistory;
    }

    public boolean verifyShowDuplicateCallHistoryButtonForRAPCall() throws Throwable {
        boolean showDuplicateCallHistory = isVisibleOnly(DIMCDPage.btnShowDuplicateCallHistoryForRAP, "Show Duplicate Call History");
        return showDuplicateCallHistory;
    }

    public boolean verifyVehicleVinOnServiceTabForRAPCall() throws Throwable {
        boolean VehicleVin = isVisibleOnly(DIMCDPage.lblvehiclevinOnServiceTabOfMCD, "Vehicle Vin");
        return VehicleVin;
    }

    public boolean verifyVehicleOdometerOnServiceTabForRAPCall() throws Throwable {
        boolean odometer = isVisibleOnly(DIMCDPage.lblvehicleOdometerOnServiceTabOfMCD, "Odometer");
        return odometer;
    }

    public boolean verifyVehicleIsRAPOnlyOnServiceTabForRAPCall() throws Throwable {
        boolean isRAP = isVisibleOnly(DIMCDPage.lblvehicleIsRAPCallOnServiceTabOfMCD, "Is RAP Call");
        return isRAP;
    }

    public boolean verifyVehicleRAPEDSNumberOnServiceTabForRAPCall() throws Throwable {
        boolean rapEDSCallNumber = isVisibleOnly(DIMCDPage.lblvehicleRAPEDSCallNumberOnServiceTabOfMCD, "RAP EDS Call Number");
        return rapEDSCallNumber;
    }

    public boolean verifyRAPIconOnServiceTabForRAPCall() throws Throwable {
        boolean rapICON = isVisibleOnly(DIMCDPage.iconRAPCall, "RAP Icon");
        return rapICON;
    }

    public boolean verifyUpdatePanelContainerVisibility() throws Throwable {
        boolean updatePanelVisibility = isVisibleOnly(DIMCDPage.btnBidCallInMCD, "Visibility of Update Panel Container");
        return updatePanelVisibility;
    }

    public boolean verifyEditCallButtonOnMCDWindow() throws Throwable {
        boolean editCall = isVisibleOnly(DIMCDPage.btnEditOnMCD, "Edit Call button");
        return editCall;
    }

    public boolean verifyDuplicateCallButtonOnMCDWindow() throws Throwable {
        boolean duplicateCall = isVisibleOnly(DIMCDPage.btnDupeCallOnMCD, "Duplicate Call button");
        return duplicateCall;
    }

    public boolean verifyPrintCallButtonOnMCDWindow() throws Throwable {
        boolean printCall = isVisibleOnly(DIMCDPage.btnPrintCallOnMCD, "Print Call button");
        return printCall;
    }

    public boolean verifyPaymentButtonOnMCDWindow() throws Throwable {
        boolean paymentButton = isVisibleOnly(DIMCDPage.iconPaymentOnMCDWindow, "Payment button");
        return paymentButton;
    }

    public boolean verifyCreditCardButtonOnMCDWindow() throws Throwable {
        boolean creditCard = isVisibleOnly(DIMCDPage.btnCrediCardOnMCD, "Payment button");
        return creditCard;
    }

    public void clickOnOkayButtonInErrorAlert() throws Throwable {
        click(DIMCDPage.unDefinedError, "Okay button");
    }

    public String selectBatterlyResolutionCodeInMCDClearWindow() throws Throwable {
        Thread.sleep(2000);
        //mouseDoubleClick(DIMCDPage.lblBatteryResoultionCodeOnClearingCall,"G306 Pace settercode selected");
        click(DIMCDPage.lblBatteryResoultionCodeOnClearingCall, "G306 Pace settercode selected");
        String paceSetterCode = getText(DIMCDPage.lblBatteryResoultionCodeOnClearingCall, "G306 Pace settercode selected");
        return paceSetterCode;
    }

    public void clearCallProcess() throws Throwable {

        spotStatus = getCallStatusOnMCDwindow();
        //getCallStatusOnMCDwindow();
        clickOnAssign();
        Thread.sleep(1000);
        assignStatus = getCallStatusOnMCDwindow();
        assertTrue(spotStatus != assignStatus, "Status changed from   " + spotStatus + " To " + assignStatus);
        selectFacility();
        Thread.sleep(1000);
        facilityStatus = getCallStatusOnMCDwindow();
        assertTrue(facilityStatus != assignStatus, "Status changed from   " + assignStatus + " To " + facilityStatus);
        selectDispatch();
        Thread.sleep(1000);
        dispatchStatus = getCallStatusOnMCDwindow();
        assertTrue(facilityStatus != dispatchStatus, "Status changed from  " + facilityStatus + " To " + dispatchStatus);
        selectEnroute();
        selectEnrouteTime();
        Thread.sleep(1000);
        enrouteStatus = getCallStatusOnMCDwindow();
        assertTrue(enrouteStatus != dispatchStatus, "Status changed from  " + dispatchStatus + " To " + enrouteStatus);
        selectOnLocation();
        Thread.sleep(1000);
        locationStatus = getCallStatusOnMCDwindow();
        assertTrue(locationStatus != enrouteStatus, "Status changed from  " + enrouteStatus + " To " + locationStatus);
        Thread.sleep(1000);
        selectClearCall();
        //clickOnContinue();

    }

    //Show Battery Services Buttons and its screen values
    public void clickOnShowBatteryServiceHistory() throws Throwable {
        click(DIMCDPage.btnShowBatteryServiceHistoryForRAP, "Show Battery Service History Button");
    }

    public boolean verifyShowBatteryServiceHisotryTabAvailablity() throws Throwable {
        boolean tabAvailablity = isVisibleOnly(DIMCDPage.iconCloseBatteryInformationTab, "Battery Information Tab");
        return tabAvailablity;
    }

    public String getDateAndCallIdInShowBatteryHistory() throws Throwable {
        String dateAndCallId = getText(DIMCDPage.lblDateAndCallIdInShowBatteryHistory, "Call ID and date of the battery call");
        return dateAndCallId;
    }

    public String getResoultionCodeLableInShowBatteryHistory() throws Throwable {
        String resolutionLabel = getText(DIMCDPage.lblResoultionCodeLableInShowBatteryHistory, "Resolution Code Lable");
        return resolutionLabel;
    }

    public String getResoultionCodeValueInShowBatteryHistory() throws Throwable {
        String resolutionValue = getText(DIMCDPage.lblResoultionCodeValueInShowBatteryHistory, "Resolution Code Value");
        return resolutionValue;
    }

    public String getTestCodeLabelInShowBatteryHistory() throws Throwable {
        String testCodeLabel = getText(DIMCDPage.lblTestCodeLabelInShowBatteryHistory, "Test Code Label");
        return testCodeLabel;
    }

    public String getTestCodeValueInShowBatteryHistory() throws Throwable {
        String testCodeValue = getText(DIMCDPage.lblTestCodeValueInShowBatteryHistory, "Test Code Value");
        return testCodeValue;
    }

    public String getlblFacilityLabelInShowBatteryHistory() throws Throwable {
        String facilityLabel = getText(DIMCDPage.lblFacilityLabelInShowBatteryHistory, "Facility Label");
        return facilityLabel;
    }

    public String getlblFacilityValueInShowBatteryHistory() throws Throwable {
        String facilityValue = getText(DIMCDPage.lblFacilityValueInShowBatteryHistory, "Facility Value");
        return facilityValue;
    }

    public String getVehicleLableInShowBatteryHistory() throws Throwable {
        String vehicleLabel = getText(DIMCDPage.lblVehicleLableInShowBatteryHistory, "Vehicle Label");
        return vehicleLabel;
    }

    public String getFacilityValueInShowBatteryHistory() throws Throwable {
        String vehicleValue = getText(DIMCDPage.lblVehicleValueInShowBatteryHisotry, "Vehicle Value");
        return vehicleValue;
    }

    public void clickOnBatteryInformationCloseIcon() throws Throwable {
        click(DIMCDPage.iconCloseBatteryInformationTab, "Close Battery Information Tab");
    }

    public void clickOnDateAndCallIdInShowBatteryHistory() throws Throwable {
        click(DIMCDPage.lblDateAndCallIdInShowBatteryHistory, "Call ID and date of the battery call");
    }

    public boolean verifyPrintButton() throws Throwable {
        boolean buttonVisibility = isVisibleOnly(DIMCDPage.btnPrintInBatteryServiceHistory, "Print Button in Battery service history");
        return buttonVisibility;
    }

    public String getMemberNumberOnSummaryTab() throws Throwable {
        String memberNumber = getText(DIMCDPage.lblMemberNumberOnSummaryTabinMCD, "Member Number");
        return memberNumber;
    }

    public void verifyPopedUpOrPopedInMCDWindow(String popedinStatus) throws Throwable {
        switch (popedinStatus) {
            case "Yes":
                clickOnPoppedOutButton();
                break;
            default:
                break;
        }
    }

    public void verifyPopedUpOrPopedOutMCDWindow(String popedOutStatus) throws Throwable {
        switch (popedOutStatus) {
            case "Yes":
                clickOnPoppedInButton();
                break;
            default:
                break;
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityOnAssignTabForDataUpdate
     * description ::
     * date :: 12-Feb-2018
     * author ::Nidhi
     */
    public void selectFacilityOnAssignTabForDataUpdate() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select Facility");
        click(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select facility");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEditLinkOfMemberSummaryInMCDWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::chandra
     */
    public void clickOnEditLinkOfMemberSummaryInMCDWindow() throws Throwable {
        click(DIMCDPage.lnkEditInMemberSummaryInMCDWindow, "Edit Link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddCommentsButton
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void clickOnAddCommentsButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAddInMCDWindow, "Add Comments Button");
        click(DIMCDPage.btnAddInMCDWindow, "Click On Add Comments Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCannedCommentsDroupDownLink
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void clickOnCannedCommentsDroupDownLink() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkCannedCommentsDroupDown, "Canned Comments Droup Down");
        click(DIMCDPage.lnkCannedCommentsDroupDown, "Canned Comments Droup Down");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectCannedComment
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void selectCannedComment(String CannedComment) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectCannedComment(CannedComment), "Canned Comment");
        click(DIMCDPage.selectCannedComment(CannedComment), "Select Canned Comment");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButton
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void clickOnSaveButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSaveCannedComments, "Save  button");
        click(DIMCDPage.btnSaveCannedComments, "Canned Comments Save button");
    }

    public boolean commentVerification(String verificationText) throws Throwable {
        boolean flag = true;
        String selectedComment = getText(DIMCDPage.lblCommentsInMCDWindow, "selected Comment From Comments Section");
        if (selectedComment.equalsIgnoreCase(verificationText) || selectedComment.equals(" ")) {
            flag = false;
        }
        return flag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: currentTime
     * description ::To get system Time
     * date :: 14-Feb-2018
     * author ::
     */
    public String currentTime() {
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("hh:mm a");
        String time = df.format(today);
        return time;
    }

    public List<String> getCannedCommentsList() throws Throwable {
        List<String> commentsList = new ArrayList<>();
        String comments;
        waitForVisibilityOfElement(DIMCDPage.listCannedComments, "Canned commentsList");
        cannedCommentsList = getWebElementList(DIMCDPage.listCannedComments, "Canned Comments List");
        if (cannedCommentsList != null) {
            for (int i = 0; i < cannedCommentsList.size(); i++) {
                comments = cannedCommentsList.get(i).getText();
                commentsList.add(comments);
            }

        }

        return commentsList;
    }

    public boolean verifyCannedCommentsInList(String cannedComment1, String cannedComment2, List<String> cannedCommentList) throws Throwable {
        boolean commentsFlag = false;
        boolean cannedcommentsFlag = (cannedCommentList.contains(cannedComment1) && cannedCommentList.contains(cannedComment2));
        if (cannedcommentsFlag) {
            commentsFlag = true;
        }
        return commentsFlag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityOnAssignTabForDataUpdate
     * description ::
     * date :: 12-Feb-2018
     * author ::Nidhi
     *//*
    public void selectFacilityOnAssignTabForDataUpdate() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select Facility");
        click(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select facility");
    }*/
    public String getStatusUpdateValueInMCDWindow() throws Throwable {
        String updateStatus = getText(DIMCDPage.txtUpdateStatus, "Update status");
        return updateStatus;
    }


    public void selectExitCodeandChangeReasonandClickonContinue(String reason) throws Throwable {
        boolean errorMessage = false;
        selectExitCode();
        clickOnContinue();
        Thread.sleep(3000);
        errorMessage = verifyErrorMessageAtReasonInMCDWindow();
        if (errorMessage) {
            closeErrorAlert();
            clearData(DIMCDPage.txtReason);
            enterReason(reason);
            clickOnContinue();
        }

    }


    /**
     * Description:This method is used to verify Tow Destination Field on MCD for a RAP call.
     * Date:14-02-2018
     *
     * @return
     * @throws Throwable
     * @author :Madhukar
     */
    public boolean verifyTowDestinationForRAPCall() throws Throwable {
        boolean towDestination = isVisibleOnly(DIMCDPage.lblTowDestinationOnLocationsForRAPTabinMCD, "Tow Destination");
        return towDestination;
    }

    /**
     * Description:This method is used to verify Member ClubCode Field on MCD for a RAP call.
     * Date:14-02-2018
     *
     * @return
     * @throws Throwable
     * @author :Madhukar
     */
    public boolean verifyMemberClubCodeForRAPCall() throws Throwable {
        boolean clubCode = isVisibleOnly(DIMCDPage.lblMemberClubCodeOnMemberTabinMCD, "Member Club Code");
        return clubCode;
    }

    /**
     * Description:This method is used to get Call Date From MCD Window
     * Date:14-02-2018
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public String getCallDateFromMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallDateInMCD, "CallID Date");
        String callDate = getText(DIMCDPage.lblCallDateInMCD, "CallID Date");
        return callDate;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: labelCallCleared
     * description ::
     * date :: 15-Feb-2018
     * author ::Nidhi
     */
    public void getLabelCallCleared() throws Throwable {
        if (waitForVisibilityOfElement(DIMCDPage.lblCallCAStatus, "Call Cleared")) {
            getText(DIMCDPage.lblCallCAStatus, "Call Cleared");
            reporter.SuccessReport("The status of the call", "changed to CA");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallStatusInMCD
     * description ::
     * date :: 15-Feb-2018
     * author ::Nidhi
     */
    public String getCallStatusInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallStatusOnMCDWindow, "status");
        String status = getText(DIMCDPage.lblCallStatusOnMCDWindow, "status");
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAalphabeticalOrderOfCannedComments
     * description ::
     * date :: 12-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyAlphabeticalOrderOfCannedComments(List cannedCommentList) throws Throwable {
        List<String> ordered = new ArrayList<>(cannedCommentList);
        Collections.sort(ordered);
        boolean inOrder = ordered.equals(cannedCommentList);
        return inOrder;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyPoppedOutButtonOnMCD
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public boolean verifyPoppedOutButtonOnMCD() throws Throwable {
        boolean poppedOutFlag = isVisibleOnly(DIMCDPage.lnkMaximizeMCDWindow, "Popped Out Button Is Visible");
        return poppedOutFlag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddButtonName
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getAddButtonName() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAdd, "Add button");
        String addButtonName = getText(DIMCDPage.btnAdd, "Add button");
        return addButtonName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheAddCommentScreen
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String verifyTheAddCommentScreen() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblAddCommentsScreen, "Add comment Screen name");
        String AddCommentsScreen = getText(DIMCDPage.lblAddCommentsScreen, "Get Add comment Screen name");
        return AddCommentsScreen;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheAddCommentsScreenAsModal
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public boolean verifyTheAddCommentsScreenAsModal() throws Throwable {
        boolean isScreenModal = false;
        boolean cliclable = setFocusAndClick(DIMCDPage.btnAsignCallinMCD, "Click On Assign Button");
        return cliclable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelButtonOnAddCommentsScreen
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void clickOnCancelButtonOnAddCommentsScreen() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCancelOnAddComments, "Cancel Button On Add Comments Screen");
        click(DIMCDPage.btnCancelOnAddComments, "Cancel Button On Add Comments Screen");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAddCommentsWindowCloses
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public boolean verifyAddCommentsWindowCloses() throws Throwable {
        boolean isAddcommentsWindowvisible = isVisibleOnly(DIMCDPage.lnkCannedCommentsDroupDown, "Verifing the Canned Comments DroupDown");
        return isAddcommentsWindowvisible;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCommentCountOnCommentSection
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getCommentCountOnCommentSection() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.commentCountValueOnCommentSection, "Comments count ");
        String commentsCount = getText(DIMCDPage.commentCountValueOnCommentSection, "Get Comments count from Comments Section");
        return commentsCount;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterComments
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void enterComments(String comment) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddComment, "wait for txt Add Comment");
        type(DIMCDPage.txtAddComment, comment, "Add Comment from testdata");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEnteredCommentsInTextArea
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getEnteredCommentsInTextArea() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddComment, "Get Added Comment");
        String comment = getAttributeByValue(DIMCDPage.txtAddComment, "Get Added Comments");
        return comment;
    }

    public String getCommentsFromCommentsSection() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCommentsInMCDWindow, "Comment From Comments Section");
        String selectedComment = getText(DIMCDPage.lblCommentsInMCDWindow, "Get selected Comment From Comments Section");
        return selectedComment;
    }

    public void editTheComments() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCommentsInMCDWindow, "Double click On Comments");
        mouseJSDoubleClick(DIMCDPage.lblCommentsInMCDWindow, "Double click On Comments");
    }

    public String verifyEditCommentScreen() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblEditComment, "Edit comment Lable");
        String editComment = getText(DIMCDPage.lblEditComment, "Edit comment Lable Name");
        return editComment;
    }

    public void clickOnCanceButtonOnEditCall() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCancelOnEditComment, "Cancel Button On Comments Edit Screen");
        click(DIMCDPage.btnCancelOnEditComment, "Cancel Button On Comments Edit Screen");
    }

    public boolean visibilityOfAddButtonOnCommentsSection() throws Throwable {
        boolean isAddButtonVisible = isVisibleOnly(DIMCDPage.btnAdd, "Add Button On Comments Section");
        return isAddButtonVisible;
    }

    public void changeTheStatusOfCommentsFromVisibleToHidden() throws Throwable {
        selectByIndex(DIMCDPage.statusHiddenOrVisible, 1, "Status Changed To Hidden");
    }

    public void clickOnSaveButtonOnEditCommentScreen() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSaveOnEditCommentScreen, "Save Button");
        click(DIMCDPage.btnSaveOnEditCommentScreen, "Save Button");
    }

    public String hiddenCommentStatus(String callIdAndDate) throws Throwable {
        isVisibleOnly(DIMCDPage.hiddenCommentStatus(callIdAndDate), "Status Of Comment after Hiding ");
        String status = getText(DIMCDPage.hiddenCommentStatus(callIdAndDate), "Status Of Comment after Hiding ");
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFieldsToDisplayInPacesetter
     * description ::getFields To Display In Pacesetter
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getFieldsToDisplayInPacesetter() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFirstPacesetterValue, "first pacesetter value");
        getText(DIMCDPage.lblFirstPacesetterValue, "first pacesetter value");
        getText(DIMCDPage.lblSecondPacesetterValue, "second pacesetter value");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEditAndClick
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getEditAndClick() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.editLink, "edit link");
        getText(DIMCDPage.editLink, "get edit icon");
        dynamicWaitByLocator(DIMCDPage.editLink, 3);
        click(DIMCDPage.editLink, "click on edit icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEditDropdownSection
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void verifyEditDropdownSection() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.editLink, "edit link");
        getText(DIMCDPage.editLink, "get edit icon");
        dynamicWaitByLocator(DIMCDPage.editLink, 3);
        click(DIMCDPage.editLink, "click on edit icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getEditDropdownSelection() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSaveInService, "wait for save button");

        isVisibleOnly(DIMCDPage.drpDwnPacesetterCode1, "pacesetter code 1 is visible");
        isVisibleOnly(DIMCDPage.drpDwnPaceseterCode2, "pacesetter code 2 is visible");
        getText(DIMCDPage.btnSaveInService, "get save ");
        getText(DIMCDPage.btnCancelInService, "get cancel");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButtonInActionRequiredTab
     * description ::
     * date :: 16-Feb-2018
     * author ::Nidhi
     */
    public void clickOnPoppedOutButtonInActionRequiredTab() throws Throwable {
        if (waitForVisibilityOfElement(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button")) {
            isVisibleOnly(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            click(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
            Thread.sleep(3000);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickToClosePoppedOutButtonInActionRequiredTab
     * description ::
     * date :: 16-Feb-2018
     * author ::Nidhi
     */
    public void clickToClosePoppedOutButtonInActionRequiredTab() throws Throwable {
        if (waitForVisibilityOfElement(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button")) {
            isVisibleOnly(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            click(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowDestinationEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnTowDestinationEditLinkInMCD() throws Throwable {
        click(DIMCDPage.lnkEditTowDestinationInServicesTabInMCDWindow, "Tow destination Edit");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBreakDownLocationsEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnBreakDownLocationsEditLinkInMCD() throws Throwable {
        click(DIMCDPage.lnkEditBreakDownLocationInServicesTabInMCDWindow, "BreakDown Locations Edit");
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetNumber
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterStreetNumberInMCD(String streetNumber) throws Throwable {
        type(DIMCDPage.txtStreetNumberInServicesTabInMCDWindow, streetNumber, "Street Number");
        return streetNumber;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetNumber
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterStreetNameInMCD(String streetName) throws Throwable {
        type(DIMCDPage.txtStreetNameInServicesTabInMCDWindow, streetName, "Street Name");
        return streetName;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterFirstCrossStreet
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterFirstCrossStreetInMCD(String crossstreet) throws Throwable {
        type(DIMCDPage.txtCrossStreet1InServicesTabInMCDWindow, crossstreet, "first Cross Street ");
        return crossstreet;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondCrossStreet
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterSecondCrossStreetInMCD(String secondcrossstreet) throws Throwable {
        type(DIMCDPage.txtCrossStreet2InServicesTabInMCDWindow, secondcrossstreet, "Second Cross Street ");
        return secondcrossstreet;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterCity
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterCityInMCD(String city) throws Throwable {
        type(DIMCDPage.txtCityInServicesTabInMCDWindow, city, "City ");
        return city;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterStateInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterStateInMCD(String state) throws Throwable {
        type(DIMCDPage.txtStateInServicesTabInMCDWindow, state, "State ");
        return state;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterZipInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterZipInMCD(String zip) throws Throwable {
        type(DIMCDPage.txtZipInServicesTabInMCDWindow, zip, "Zip ");
        return zip;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLandMarkInMCD(String landMark) throws Throwable {
        type(DIMCDPage.txtLandMarkInServicesTabInMCDWindow, landMark, "LandMark ");
        return landMark;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterLatitudeInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLatitudeInMCD(String Latitude) throws Throwable {
        type(DIMCDPage.txtLatitudeInServicesTabInMCDWindow, Latitude, "Latitude ");
        return Latitude;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterLongitudeInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLongitudeInMCD(String Longitude) throws Throwable {
        type(DIMCDPage.txtLongitudeInServicesTabInMCDWindow, Longitude, "Longitude ");
        return Longitude;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressVerifiedInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public boolean getAddressVerifiedInMCD() throws Throwable {
        boolean addressVerified = isVisibleOnly(DIMCDPage.lblAddressVerifiedInServicesTabInMCDWindow, "Address Verified");
        return addressVerified;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterUpdateReasonInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterUpdateReasonInMCD(String updateReason) throws Throwable {
        type(DIMCDPage.txtUpdateReasonInServicesTabInMCDWindow, updateReason, "Update Reason");
        return updateReason;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnSaveButtonInMCDWindow() throws Throwable {
        click(DIMCDPage.btnSaveButtonInServicesTabInMCDWindow, "Save Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelButtonInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnCancelButtonInMCDWindow() throws Throwable {
        click(DIMCDPage.btnCancelButtonInServicesTabInMCDWindow, "Cancel Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownLoactionsTabInMCDWIndow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public boolean verifyBreakDownLoactionsTabInMCDWIndow() throws Throwable {
        boolean breakDownlocation = isVisibleOnly(DIMCDPage.btnCancelButtonInServicesTabInMCDWindow, "Breakdown location Tab");
        return breakDownlocation;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownLoactionsTabInMCDWIndow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void closeBreakDownLoactionsTabInMCDWIndow() throws Throwable {
        click(DIMCDPage.btnCancelButtonInServicesTabInMCDWindow, "BreakDown locations Tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressInSearvicesInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterAddressInSearvicesInMCDWindow(String addressSearch) throws Throwable {
        type(DIMCDPage.txtAddressSearchInServicesInMCDWindow, addressSearch, "AddressSearch");
        return addressSearch;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButtonInServicesInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnSearchButtonInServicesInMCDWindow() throws Throwable {
        click(DIMCDPage.btnSearchButtonInServicesInMCDWindow, "Search button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualAddressEntryInServicesInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnManualAddressEntryInServicesInMCDWindow() throws Throwable {
        click(DIMCDPage.lnkManualAddressEntryInTowDestinationInMCDWindow, "Manual Address Entry ");
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationNameInTowDestinationInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLocationNameInTowDestinationInMCDWindow(String towLocationName) throws Throwable {
        type(DIMCDPage.txtLocationNameInTowDestinationInMCDWindow, towLocationName, "Locaiton Name ");
        return towLocationName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTowDestinationAddressFromResults
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getTowDestinationAddressFromResults() throws Throwable {
        boolean emptryRecords = getEmptryRecordErrorMessageInMCD();
        boolean recordsPanelNotFund = verifySearchResultsGridAvailablity();
        if (!emptryRecords || !recordsPanelNotFund) {
            towDestinationAddress = getText(DIMCDPage.lnkSelectFirstRowInSearchResultsInBreakDownLoaciton, "Tow Destination Address");
            city = getText(DIMCDPage.lblCityInTowDestinationSearchResultsGridInServicesInMCD, "City Value");
            State = getText(DIMCDPage.lblStateInTowDestinationSearchResultsGridInServicesInMCD, "State Value");
            Zip = getText(DIMCDPage.lblZipInTowDestinationSearchResultsGridInServicesInMCD, "Zip Value");


        } else {
            assertFalse(emptryRecords, "Recrods not found");
        }
        String searchedAddress = towDestinationAddress + " " + city + " " + State + " " + Zip;
        return searchedAddress;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowDestinationAddressInResultsGrid
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public void clickOnTowDestinationAddressInResultsGrid() throws Throwable {
        boolean emptryRecords = getEmptryRecordErrorMessageInMCD();
        if (emptryRecords) {
            assertFalse(emptryRecords, "Records not found");
        } else {
            mouseDoubleClick(DIMCDPage.lnkSelectFirstRowInSearchResultsInBreakDownLoaciton, "Tow Destination Address");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfStreetNumberInMCDWindow
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfStreetNumberInMCDWindow() throws Throwable {
        String streetNumber = getAttributeByValue(DIMCDPage.txtStreetNumberInServicesTabInMCDWindow, "StreetNumber value");
        return streetNumber;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfStreetNameInMCDWindow
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfStreetNameInMCDWindow() throws Throwable {
        String streetName = getAttributeByValue(DIMCDPage.txtStreetNameInServicesTabInMCDWindow, "Street Name");
        return streetName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfFirstCrossStreetInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfFirstCrossStreetInMCD() throws Throwable {
        String crossStreet = getAttributeByValue(DIMCDPage.txtCrossStreet1InServicesTabInMCDWindow, "first Cross Street ");
        return crossStreet;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfSecondCrossStreetInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfSecondCrossStreetInMCD() throws Throwable {
        String secondcrossstreet = getAttributeByValue(DIMCDPage.txtCrossStreet2InServicesTabInMCDWindow, "Second Cross Street ");
        return secondcrossstreet;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfCityInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String getValueOfCityInMCD() throws Throwable {
        String city = getAttributeByValue(DIMCDPage.txtCityInServicesTabInMCDWindow, "City ");
        return city;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfStateInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfStateInMCD() throws Throwable {
        String state = getAttributeByValue(DIMCDPage.txtStateInServicesTabInMCDWindow, "State ");
        return state;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfZipInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfZipInMCD() throws Throwable {
        String zip = getAttributeByValue(DIMCDPage.txtZipInServicesTabInMCDWindow, "Zip ");
        return zip;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfLandMarkInMCD() throws Throwable {
        String landMark = getAttributeByValue(DIMCDPage.txtLandMarkInServicesTabInMCDWindow, "LandMark ");
        return landMark;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfLatitudeInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfLatitudeInMCD() throws Throwable {
        String Latitude = getAttributeByValue(DIMCDPage.txtLatitudeInServicesTabInMCDWindow, "Latitude ");
        return Latitude;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfLongitudeInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfLongitudeInMCD() throws Throwable {
        String Longitude = getAttributeByValue(DIMCDPage.txtLongitudeInServicesTabInMCDWindow, "Longitude ");
        return Longitude;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEmptryRecordErrorMessageInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public boolean getEmptryRecordErrorMessageInMCD() throws Throwable {
        boolean emptryRecords = isVisibleOnly(DIMCDPage.lblEmptyResultsRowInSearchResultsInMCDWIndow, "Emptry Records ");
        return emptryRecords;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsInTowDestinationAndLocationsTabsInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterCommentsInTowDestinationAndLocationsTabsInMCDWindow(String comments) throws Throwable {
        type(DIMCDPage.txtCommentsInEditLocationsAndTowDestinationsTabs, comments, "comments");
        return comments;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsInTowDestinationAndLocationsTabsInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String validateErrorMessage() throws Throwable {
        String errorMessage = getText(DIMCDPage.lblErrorMessageOnAlert, "Error Message");
        return errorMessage;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnErrorOkayButtonInMCDWindow
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public void clickOnErrorOkayButtonInMCDWindow() throws Throwable {
        click(DIMCDPage.btnOkayOnErrorMessage, "Okay Button");
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnGetCoOrdinatesInMCD
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public void clickOnGetCoOrdinatesInMCD() throws Throwable {
        click(DIMCDPage.btnGetAddressCoordinatesInMCDWindow, "Get Address Coordinates");
    }

    public boolean verifySearchResultsGridAvailablity() throws Throwable {
        boolean resultsVisibiltiy = isVisibleOnly(DIMCDPage.resultsGridVerifications, "Results Grid");
        return resultsVisibiltiy;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressFromResults
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public String getAddressFromResults() throws Throwable {
        towDestinationAddress = getText(DIMCDPage.lnkSelectFirstRowInSearchResultsInBreakDownLoaciton, "Tow Destination Address");
        city = getText(DIMCDPage.lblCityInTowDestinationSearchResultsGridInServicesInMCD, "City Value");
        State = getText(DIMCDPage.lblStateInTowDestinationSearchResultsGridInServicesInMCD, "State Value");
        Zip = getText(DIMCDPage.lblZipInTowDestinationSearchResultsGridInServicesInMCD, "Zip Value");
        String searchedAddress = towDestinationAddress + " " + city + " " + State + " " + Zip;
        return searchedAddress;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyErrorMessageAvailability
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public boolean verifyErrorMessageAvailability() throws Throwable {
        boolean errorMessageAvailability = isVisibleOnly(DIMCDPage.lblErrorMessageOnAlert, "Error Message");
        return errorMessageAvailability;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: closeBreakDownLocaitonTabInMCD
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public void closeBreakDownLocaitonTabInMCD() throws Throwable {
        click(DIMCDPage.iconBreakDownLocationsCloseInMCDWindow, "Breakdown location tab");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyETAlblBackgroundColorInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::
     */
    public String verifyETAvlblBackgroundColorInMCD() throws Throwable {
        String lblETABackgroundColor = getCssValue(DIMCDPage.lblETAvTimeOnMcdWindow, "background-color");
        return lblETABackgroundColor;
    }


    public void setTimeForETAForTenMins() throws Throwable {
        boolean setTime = isVisibleOnly(DIMCDPage.setTimeForETATwo, "Set time for ETA");
        if (setTime) {
            click(DIMCDPage.setTimeForETATwo, "Set time for ETA");
        } else {
            assertTrue(setTime, "set time for eta is not found");
        }
    }

    public void ClickOnstillWorkingOnCallButton() throws Throwable {
        boolean btnMCDYes = isVisibleOnly(DIMCDPage.btnMCDYesContinue, "MCD window yes continue");
        if (btnMCDYes) {
            click(DIMCDPage.btnMCDYesContinue, "Clicked on yes continue");
        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnFacilityLinkOnSummaryTab
     * description :: Clicks Facility Link on Summary tab
     * date :: 16-Feb-2018
     * author ::Sachin
     */
    public void ClickOnFacilityLinkOnSummaryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary Tab");
        click(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary Tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getSecondRowCommentsInCommentsSectionInMCDWindow
     * description :: getSecondRowCommentsInCommentsSectionInMCDWindow
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public String getSecondRowCommentsInCommentsSectionInMCDWindow() throws Throwable {
        String secondRowComments = getText(DIMCDPage.lblCommentsForSecondRecordInCommentsSectionInMCDWIndow, "Second Row Comments");
        return secondRowComments;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLocationValueInTowDestinationResultsInMCDWindow
     * description :: getLocationValueInTowDestinationResultsInMCDWindow
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public String getLocationValueInTowDestinationResultsInMCDWindow() throws Throwable {
        String towDestinationAddress = getText(DIMCDPage.lblTowDestinationLocationsSearchResultsInTowDestinationTabInMCDWindow, "Tow Destination Address");
        return towDestinationAddress;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationValueInTowDestinationResultsInMCDWindow
     * description :: clickOnLocationValueInTowDestinationResultsInMCDWindow
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public void clickOnLocationValueInTowDestinationResultsInMCDWindow() throws Throwable {
        mouseDoubleClick(DIMCDPage.lblTowDestinationLocationsSearchResultsInTowDestinationTabInMCDWindow, "Tow Destination Address");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEmptryRecordErrorMessageInTowDestinationInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public boolean getEmptryRecordErrorMessageInTowDestinationInMCD() throws Throwable {
        boolean emptryRecordsInTow = isVisibleOnly(DIMCDPage.lblEmptyResultsRowInSearchResultsInTowDestinationInMCDWIndow, "Emptry Records ");
        return emptryRecordsInTow;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: validateInsufficientInformationError
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public boolean validateInsufficientInformationError() throws Throwable {
        boolean insufficentInformation = isVisibleOnly(DIMCDPage.lbl306ErrorPopup, "insufficent information ");
        return insufficentInformation;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOn306ErrorOkayButton
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public void clickOn306ErrorOkayButton() throws Throwable {
        click(DIMCDPage.btn306ErrorPopupOkayButton, "insufficent information Okay button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getInsufficientInformationError
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public String getInsufficientInformationError() throws Throwable {
        String insufficentInformation = getText(DIMCDPage.lbl306ErrorPopup, "insufficent information ");
        return insufficentInformation;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterStatusReasonsInTowDestionation
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public String enterStatusReasonsInTowDestionation(String updateReason) throws Throwable {
        type(DIMCDPage.txtStatusReasonInTowDestinationInMCDWindow, updateReason, "Status Reason");
        return updateReason;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsInTowDestinationTabInMCDWindow
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public String enterCommentsInTowDestinationTabInMCDWindow(String comments) throws Throwable {
        type(DIMCDPage.txtCommentsInTowDestinationInMCDWindow, comments, "comments");
        return comments;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressVerifiedInTowInMCD
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public boolean getAddressVerifiedInTowInMCD() throws Throwable {
        boolean addressVerified = isVisibleOnly(DIMCDPage.lblAddressVerifiedInTowDestination, "Address Verified");
        return addressVerified;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressVerifiedInTowInMCD
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public void clickOnSumbitButton() throws Throwable {
        click(DIMCDPage.btnSubmitInTowDestinationInMCD, "Submit Button");
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: ValidatedOnErrorOkayButtonInMCDWindow
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public boolean ValidatedOnErrorOkayButtonInMCDWindow() throws Throwable {
        boolean errorMessage = isVisibleOnly(DIMCDPage.btnOkayOnErrorMessage, "Validate error message");
        return errorMessage;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: getErrorMessageOnAlertInManualEntryInOthersTab
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public String getErrorMessageOnAlertInManualEntryInOthersTab() throws Throwable {
        String errorMessageForManualEntry = getText(DIMCDPage.lblErrorMessageOnAlertInOthersTabForManualEntry, "Validate error message");
        return errorMessageForManualEntry;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickToClosePoppedOutButtonInActionRequiredTab
     * description ::
     * date :: 18-Feb-2018
     * author ::Nidhi
     */
    public void clickToClosePoppedOutButtonInTruckloadTab() throws Throwable {
        if (waitForVisibilityOfElement(DIMCDPage.btnPopOutInTruckloadTab, "PoppedOut Button")) {
            isVisibleOnly(DIMCDPage.btnPopOutInTruckloadTab, "PoppedOut Button");
            click(DIMCDPage.btnPopOutInTruckloadTab, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButtonInActionRequiredTab
     * description ::
     * date :: 18-Feb-2018
     * author ::Nidhi
     */

    public String labelCallCancelled(String StatusUpdateCA) throws Throwable {
        Thread.sleep(7000);
        if (StatusUpdateCA.equalsIgnoreCase("CA")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallCAStatus, "Call Cancelled");
            String callCancelledStatus = getText(DIMCDPage.lblCallCAStatus, "Call Cancelled");
            if (callCancelledStatus.contains("CA")) {
                reporter.SuccessReport("Call Cancelled Status:", "Call Cancelled Status Verified");
            } else {
                reporter.failureReport("Call Cancelled Status:", "Call Cancelled Status Not Verified");
            }
        }
        return StatusUpdateCA;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getListOfPacesetterCode1Dropdown
     * description ::
     * date :: 19-Feb-2018
     * author ::Ravi
     */
    public void getListOfPacesetterCode1Dropdown() throws Throwable {
        if (isVisibleOnly(DIMCDPage.drpDwnPacesetterCode1, "pacesetter code 1 is visible")) {
            setFocusAndClick(DIMCDPage.drpDwnPacesetterCode1, "pacesetter code 1 is visible");

            Thread.sleep(3000);
            List<WebElement> pacesetterCode1List = driver.findElements(DIMCDPage.lstPacesetterCode1);
            int totalCount = pacesetterCode1List.size();
            int counter = 1;
            if (totalCount > 1) {
                //this.reporter.SuccessReport("List of status item  ", "  Total status items :  " + totalCount);
                for (int i = 1; i < pacesetterCode1List.size(); i++) {
                    this.reporter.SuccessReport("Pacesetter Code", +counter + "is " + pacesetterCode1List.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.SuccessReport("No list  found", +totalCount + "is Empty");
                //k++;
            }
        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterTroubleCode1
     * description :: enter Trouble Code1
     * date :: 19-Feb-2018
     * author ::Ravi
     */
    public void enterTroubleCode1(String TroubleCode1) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lstPacesetterCode2, "trouble code1");
        type(DIMCDPage.txtTroubleCode1, TroubleCode1, "txt Trouble Code1");
        Thread.sleep(3000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");


      /*  if (isVisibleOnly(DIMCDPage.drpDwnPaceseterCode2, "pacesetter code 2 is visible")) {
            setFocusAndClick(DIMCDPage.drpDwnPaceseterCode2, "pacesetter code 2 is visible");
            Thread.sleep(3000);
            List<WebElement> pacesetterCode2List = driver.findElements(DIMCDPage.lstPacesetterCode2);
            int totalCount = pacesetterCode2List.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 1; i < pacesetterCode2List.size(); i++) {

                    if (isVisibleOnly(DIMCDPage.lbltroubleCode, "trouble code1")) {
                        click(DIMCDPage.lbltroubleCode, "trouble code2");
                        break;
                    }
                    counter++;
                }
            }
        }*/
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveInService
     * description :: click On Save In Service
     * date :: 19-Feb-2018
     * author ::Ravi
     */
    public void clickOnSaveInService() throws Throwable {
        dynamicWaitByLocator(DIMCDPage.btnSave, 3);
        setFocusAndClick(DIMCDPage.btnSave, "save button");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: highLightedValueInPacesetterCode1
     * description :: highLighted Value In Pacesetter Code1
     * date :: 19-Feb-2018
     * author ::Ravi
     */
    public void highLightedValueInPacesetterCode1() throws Throwable {

        waitForVisibilityOfElement(DIMCDPage.highlightedFieldChanged, "field changed");
        getText(DIMCDPage.highlightedFieldChanged, "field changed");
        {
            reporter.SuccessReport("successfully Highlighted", "T6 Tow");
        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: moveTheCallTroughStatus
     * description :: move The Call Trough the Status
     * date :: 19-Feb-2018
     * author ::Ravi
     */
    public void moveTheCallTroughTwStatus() throws Throwable {
        spotStatus = getCallStatusOnMCDwindow();
        //getCallStatusOnMCDwindow();
        clickOnAssign();
        Thread.sleep(1000);
        assignStatus = getCallStatusOnMCDwindow();
        reporter.SuccessReport("Current Status", "Status changed from   " + spotStatus + " To " + assignStatus);
        selectFacility();
        Thread.sleep(1000);
        facilityStatus = getCallStatusOnMCDwindow();
        reporter.SuccessReport("Current Status", "Status changed from   " + assignStatus + " To " + facilityStatus);
        selectDispatch();
        Thread.sleep(1000);
        dispatchStatus = getCallStatusOnMCDwindow();
        reporter.SuccessReport("Current Status", "Status changed from  " + facilityStatus + " To " + dispatchStatus);
        selectEnroute();
        selectEnrouteTime();
        Thread.sleep(1000);
        enrouteStatus = getCallStatusOnMCDwindow();
        reporter.SuccessReport("Current Status", "Status changed from  " + dispatchStatus + " To " + enrouteStatus);
        selectOnLocation();
        Thread.sleep(1000);
        locationStatus = getCallStatusOnMCDwindow();
        reporter.SuccessReport("Current Status", "Status changed from  " + enrouteStatus + " To " + locationStatus);
        clickOnTowTabInCancelCallSection();
        String TowStatus = getCallStatusOnMCDwindow();
        reporter.SuccessReport("Current Status", "Status changed from  " + locationStatus + " To " + TowStatus);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelInService
     * description :: click On Cancel In Service
     * date :: 19-Feb-2018
     * author ::Ravi
     */
    public void clickOnCancelInService() throws Throwable {

        waitForVisibilityOfElement(DIMCDPage.btnCancelInService, "get cancel");
        click(DIMCDPage.btnCancelInService, "get cancel");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVerifyButtonInMemberHome
     * description ::
     * date :: 19-Feb-2018
     * author ::Chandu
     */
    public void clickOnVerifyButtonInMemberHome() throws Throwable {
        click(DIMCDPage.btnVerifyInManualHomeTabInMCDWindow, "Verify Button");
    }

    /**
     * Description:This method is used to get the status code on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public String getStatusCodeOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblStatusCodeOnStatusHistory, "StatusCodeOnStatusHistory");
        String statusCode = getText(DIMCDPage.lblStatusCodeOnStatusHistory, "StatusCode On StatusHistory Displayed");
        return statusCode;
    }

    /**
     * Description:This method is used to get the date on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getDateOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblDateOnStatusHistory, "Date On StatusHistory");
        getText(DIMCDPage.lblDateOnStatusHistory, "Date On StatusHistory Displayed");
    }

    /**
     * param:
     * Description:This method is used to get the update code on status history tab
     * Date:20-02-2018
     * return:String
     * method name: getUpdateCodeOnStatusHistory
     *
     * @throws Throwable
     */
    public String getUpdateCodeOnStatusHistory() throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIMCDPage.lblUpdateCodeOnStatusHistory, "UpdateCode On StatusHistory");
        String updateCode = getText(DIMCDPage.lblUpdateCodeOnStatusHistory, "UpdateCode On StatusHistory Displayed");
        return updateCode;
    }

    /**
     * Description:This method is used to get the reason code on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public String getReasonCodeOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblReasonCodeOnStatusHistory, "ReasonCode On StatusHistory");
        String reasonCode = getText(DIMCDPage.lblReasonCodeOnStatusHistory, "ReasonCode On StatusHistory Displayed");
        return reasonCode;
    }

    /**
     * Description:This method is used to get the FacilityAndTruckId on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getFacilityAndTruckIdOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityAndTruckIdOnStatusHistory, "FacilityAndTruckId On StatusHistory");
        getText(DIMCDPage.lblFacilityAndTruckIdOnStatusHistory, "FacilityAndTruckId On StatusHistory Displayed");
    }

    /**
     * Description:This method is used to get the user name on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getUserOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblUserOnStatusHistory, "User On StatusHistory");
        getText(DIMCDPage.lblUserOnStatusHistory, "User On StatusHistory Displayed");
    }

    /**
     * Description:This method is used to get the role on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getRoleOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblRoleOnStatusHistory, "Role On StatusHistory");
        getText(DIMCDPage.lblRoleOnStatusHistory, "Role On StatusHistory Displayed");
    }

    /**
     * Description:This method is used to get the App name on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getAppOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblAppOnStatusHistory, "App On StatusHistory");
        getText(DIMCDPage.lblAppOnStatusHistory, "App On StatusHistory Displayed");
    }

    /**
     * Description:This method is used to get the Location on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getLocationOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblLocationOnStatusHistory, "Location On StatusHistory");
        getText(DIMCDPage.lblLocationOnStatusHistory, "Location On StatusHistory Displayed");
    }

    /**
     * Description:This method is used to get the ETA value on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void getETAOnStatusHistory() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblETAOnStatusHistory, "ETA On StatusHistory");
        getText(DIMCDPage.lblETAOnStatusHistory, "ETA On StatusHistory Displayed");
    }

    /**
     * Description:This method is used to click on plus button on status history tab
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void clickOnPlusButtonOnStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnplusForCommentsInStatusHistory, "Comments Section");
        click(DIMCDPage.btnplusForCommentsInStatusHistory, "Comments Section");
    }

    /**
     * Description:This method is used to click on Decline button with comments
     * Date:20-02-2018
     *
     * @throws Throwable
     */
    public void clickOnCommentsRequiredFordeclineCallOnMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectCommentsRequiredForDeclineCall, "Decline Comments ");
        click(DIMCDPage.selectCommentsRequiredForDeclineCall, "Decline Comments ");
    }

    /**
     * Description:This method is used to check if MCD window exists
     * Date:
     *
     * @throws Throwable
     */
    public boolean IsMCDWindowExist() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.MCDWindow, "MCD Window");
        boolean bMcdWindow = isVisible(DIMCDPage.MCDWindow, "MCD Window");
        return bMcdWindow;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnActionButton
     * description :: This function is used to click on Action Buttons(ETA,CM,UP,ACK)
     * date ::
     * author ::Sachin
     */
    public void ClickOnActionButton(String ButtonName) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCalldetailsUpdateActionButtons(ButtonName), "" + ButtonName);
        click(DIMCDPage.btnCalldetailsUpdateActionButtons(ButtonName), "" + ButtonName);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnActionButton
     * description :: This function is used to click on Action Buttons(ETA,CM,UP,ACK)
     * date ::
     * author ::Sachin
     */
    public void ClickOnActionButtonItemMembers(String MemberName) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblActionButtobsItemMembers(MemberName), "" + MemberName);
        click(DIMCDPage.lblActionButtobsItemMembers(MemberName), "" + MemberName);
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInStreetNumberInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterValueInStreetNumberInMCDWindow(String streetNumber) throws Throwable {
        type(DIMCDPage.txtStreetNumberInServicesTabInMCDWindow, streetNumber, "Street number");
        return streetNumber;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInStreetNameInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterValueInStreetNameInMCDWindow(String streetName) throws Throwable {
        type(DIMCDPage.txtStreetNameInServicesTabInMCDWindow, streetName, "Street Name");
        return streetName;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInStateInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterValueInStateInMCDWindow(String state) throws Throwable {
        type(DIMCDPage.txtStateInServicesTabInMCDWindow, state, "State Name");
        return state;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInZipInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterValueInZipInMCDWindow(String Zip) throws Throwable {
        type(DIMCDPage.txtZipInServicesTabInMCDWindow, Zip, "Zip ");
        return Zip;
    }

    public boolean VerifyPhoneIconExistsOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.iconPhone, "Phone Icon MCD Window");
        boolean phoneicon = isVisible(DIMCDPage.iconPhone, "Phone Icon MCD Window");
        return phoneicon;
    }

    public void ClickMinimizeIcon() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.linkMinimizeMCDwindow, "Minimize MCD Window");
        click(DIMCDPage.linkMinimizeMCDwindow, "Minimize MCD Window");
    }


    public void CloseMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
        click(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterLandMarkInMCDWindow(String landMark) throws Throwable {
        type(DIMCDPage.txtLandMarkInServicesTabInMCDWindow, landMark, "LandMark");
        return landMark;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLatitudeInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterLatitudeInMCDWindow(String latitude) throws Throwable {
        type(DIMCDPage.txtLatitudeInServicesTabInMCDWindow, latitude, "latitude");
        return latitude;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLongitudeInMCDWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterLongitudeInMCDWindow(String logitude) throws Throwable {
        type(DIMCDPage.txtLongitudeInServicesTabInMCDWindow, logitude, "Longitude");
        return logitude;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: changeReasonandClickonContinue
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public void changeReasonandClickonContinue(String reason) throws Throwable {
        boolean errorMessage = false;
        clickOnContinue();
        Thread.sleep(3000);
        errorMessage = verifyErrorMessageAtReasonInMCDWindow();
        if (errorMessage) {
            closeErrorAlert();
            clearData(DIMCDPage.txtReason);
            enterReason(reason);
            clickOnContinue();
        }

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: validateDateAndCallIdInShowBatteryHistory
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public boolean validateDateAndCallIdInShowBatteryHistory() throws Throwable {
        boolean dateAndCallId = isVisibleOnly(DIMCDPage.lblDateAndCallIdInShowBatteryHistory, "Call ID and date of the battery call");
        return dateAndCallId;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPacesetterCode1InServicesTabInMCD
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterPacesetterCode1InServicesTabInMCD(String paceSetterCode1) throws Throwable {
        type(DIMCDPage.txtPaceSetterCode1InServiceTabInMCD, paceSetterCode1, "pacesetterCode");
        //click(DIMCDPage.selectPaceSetterCodeFromDropDownlist(paceSetterCode1),"PaceSetter Code 1");
        return paceSetterCode1;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPacesetterCode2InServicesTabInMCD
     * description :: Entering values in pacesetter code second field under service tab in MCD window
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public String enterPacesetterCode2InServicesTabInMCD(String paceSetterCode2) throws Throwable {
        type(DIMCDPage.txtPaceSetterCode2InServicesTabInMCD, paceSetterCode2, "PaceSetter Code 2");

        return paceSetterCode2;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateTroubleCode1BGColor
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public boolean validateTroubleCode1BGColor() throws Throwable {
        boolean bgColorOrange = isVisibleOnly(DIMCDPage.lblTroubleCode1WithBGColorInServicesTabInMCD, "Trouble Code 1 Orange Color");
        return bgColorOrange;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateTroubleCode2BGColor
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandu
     */
    public boolean validateTroubleCode2BGColor() throws Throwable {
        boolean bgColorOrange = isVisibleOnly(DIMCDPage.lblTroubleCode2WithBGColorInServicesTabInMCD, "Trouble Code 2 Orange Color");
        return bgColorOrange;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButtonInTruckloadTab
     * description ::
     * date :: 20-Feb-2018
     * author ::Nidhi
     */
    public void clickOnPoppedOutButtonInTruckloadTab() throws Throwable {
        Thread.sleep(4000);
        if (isVisibleOnly(DIMCDPage.btnPopOutInTruckloadTab, "PoppedOut Button")) {
            click(DIMCDPage.btnPopOutInTruckloadTab, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
            Thread.sleep(3000);
        } else {
            switchToWindow();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButtonInMCDTabInSpp
     * description ::
     * date :: 20-Feb-2018
     * author ::Nidhi
     */
    public void clickOnPoppedOutButtonInMCDTabInSpp() throws Throwable {
        Thread.sleep(4000);
        if (isVisibleOnly(DIMCDPage.btnPopOutInMCDTabInSpp, "PoppedOut Button")) {
            click(DIMCDPage.btnPopOutInMCDTabInSpp, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
            Thread.sleep(3000);
        } else {
            switchToWindow();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButtonInTruckloadTabInDispatch
     * description ::
     * date :: 20-Feb-2018
     * author ::Nidhi
     */
    public void clickOnPoppedOutButtonInTruckloadTabInDispatch() throws Throwable {
        Thread.sleep(4000);
        if (isVisibleOnly(DIMCDPage.btnPopOutInTruckloadTabInDispatch, "PoppedOut Button")) {
            click(DIMCDPage.btnPopOutInTruckloadTabInDispatch, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
            Thread.sleep(3000);
        } else {
            switchToWindow();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getE213ErrorMessage
     * description :: get E213 error message from error popup window while trying to cancel the call with SPP user
     * date :: 20-Feb-2018
     * author ::Chandra
     */
    public String getE213ErrorMessage() throws Throwable {
        String e213ErrorMessage = getText(DIMCDPage.lblE213ErrorMessage, "Error message appeared");
        return e213ErrorMessage;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnE213OkayButton
     * description :: click ok button on E213 error message from error popup window while trying to cancel the call with SPP user
     * date :: 20-Feb-2018
     * author ::Chandra
     */
    public void clickOnE213OkayButton() throws Throwable {
        click(DIMCDPage.btnE213ErrorPopUpErrorOkayButton, "Error message Okay button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: validateDisaleReasonCodeTextBoxForEdit
     * description :: checking for reason code text bos is editable or not
     * date :: 20-Feb-2018
     * author ::Chandra
     */
    public boolean validateDisaleReasonCodeTextBoxForEdit() throws Throwable {
        boolean visibilityOfDisableReason = isVisibleOnly(DIMCDPage.txtValidateReasonCodeDisable, "Reason code is not in editable mode");
        return visibilityOfDisableReason;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyE213ErrorMessageAvailablity
     * description :: click ok button on E213 error message from error popup window while trying to cancel the call with SPP user
     * date :: 20-Feb-2018
     * author ::Chandra
     */
    public boolean verifyE213ErrorMessageAvailablity() throws Throwable {
        boolean errorAvailablity = isVisibleOnly(DIMCDPage.btnE213ErrorPopUpErrorOkayButton, "Error message Okay button");
        return errorAvailablity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyResolutionGridAvailablity
     * description :: verifyResolutionGridAvailablity
     * date :: 20-Feb-2018
     * author ::Chandra
     */
    public boolean verifyResolutionGridAvailablity() throws Throwable {
        boolean grid = isVisibleOnly(DIMCDPage.gridResodeTable, "Resolution Grid");
        return grid;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallOnREStatus
     * description ::
     * date :: 05-03-2018
     * author ::Nidhi
     */
    public String lblCallOnREStatus(String StatusUpdateRE) throws Throwable {
        if (StatusUpdateRE.equalsIgnoreCase("RE")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallREStatus, "Call RE Status is available");
            String onREStatus = getText(DIMCDPage.lblCallREStatus, "Call RE Status is available");
            if (onREStatus.contains("RE")) {
                reporter.SuccessReport("RE Status:", "<b>On RE Verified</b>");
            } else {
                reporter.failureReport("RE Status:", "<b>On RE Not Verified</b>");
            }
        }
        return StatusUpdateRE;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallOnBDStatus
     * description ::
     * date :: 05-03-2018
     * author ::Nidhi
     */
    public String lblCallOnBDStatus(String StatusUpdateBD) throws Throwable {
        if (StatusUpdateBD.equalsIgnoreCase("BD")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallBDStatus, "Call BD Status is available");
            String onBDStatus = getText(DIMCDPage.lblCallBDStatus, "Call BD Status is available");
            if (onBDStatus.contains("BD")) {
                reporter.SuccessReport("BD Status:", "<b>On BD Verified</b>");
            } else {
                reporter.failureReport("BD Status:", "<b>On BD Not Verified</b>");
            }
        }
        return StatusUpdateBD;
    }

    /**
     * param :: String input
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallCleared
     * description :: This method is used to verify clear call status in MCD Window
     * date :: 14-March-2018
     * author ::Sri Harish Mukthavi
     */
    public void verifyCallCleared() throws Throwable {
        if (isVisibleOnly(DIMCDPage.lblCallClearedStatus, "Call Cleared")) {
            reporter.SuccessReport("Call Cleared Status:", "<b>Call Cleared Status Verified</b>");
        } else {
            reporter.failureReport("Call Cleared Status:", "<b>Call Cleared Status Not Verified</b>", driver);
        }
        closeErrorAlertOKButton();
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAPDServices
     * description :: This method is used to enter APD Services in MCD Window
     * date :: 16-March-2018
     * author ::Chandra
     */
    public void enterAPDServices(String services, String serviceType, String cost, String cashCollected) throws Throwable {

        if (services.equalsIgnoreCase("AddServices")) {
            clickOnPaymentButtonOnOCDWindow();
            enterServiceAndChargesOnMCDWindow(serviceType);
            Thread.sleep(2000);
            //enterSecondServiceAndChargesOnMCDWindow(towServiceType);
            //clickOnDropDownValueServiceAndChargesOnMCDWindow();
            enterCostInServiceAndChargesInMCDWindow(cost);
            enterCashCollectedInServiceAndChargesInMCDWindow(cashCollected);
            clickOnSaveButtonInServiceAndChargesOnMCDWindow();
            clickOnCloseButtonInServiceAndChargesOnMCDWindow();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: visibilityOfAPDHeader
     * description :: This method is used to verify APDHeader in MCDWIndow
     * date :: 16-March-2018
     * author ::Chandra
     */
    public boolean visibilityOfAPDHeader() throws Throwable {
        boolean visibilityOFHeader = isVisibleOnly(DIMCDPage.lblAPDHeader, "APD Header Visibility");
        return visibilityOFHeader;
    }

    /**
     * param :: String input
     * return ::void
     * throws :: throwable
     * methodName :: getCommentsFromCommentsWindow
     * description :: This method is used to get Comments
     * date :: 16-March-2018
     * author ::Chandra
     */
    public String getCommentsFromCommentsWindow(String verificationText) throws Throwable {

        String selectedComment = getText(DIMCDPage.getCommentsFromMCDWindow(verificationText), "selected Comment From Comments Section");
        return selectedComment;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyPencilIconInMCD
     * description ::
     * date :: 29-Jan-2018
     * author ::
     */
    public boolean verifyPencilIconInMCD() throws Throwable {
        boolean iconPresent = waitForVisibilityOfElement(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
        return iconPresent;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMouseHoverTextOnPencilIconInMCD
     * description ::
     * date :: 29-Jan-2018
     * author ::
     */
    public String verifyMouseHoverTextOnPencilIconInMCD() throws Throwable {
        mouseHover(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
        String mouseHoverText = getText(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
        return mouseHoverText;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowDestinationResultsList
     * description :: verifyTowDestinationResultsList
     * date :: 17-03-2018
     * author :: Chandra
     */
    public int verifyTowDestinationResultsList() throws Throwable {

        int towDestinationResultsCount = 0;
        boolean repairShops = isVisibleOnly(DIMCDPage.txtMessageNoRecordsAvailableForOtherLocationInMCDWindow, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(DIMCDPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            towDestinationResultsCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Tow Destination:: '" + towDestinationResults + "'");
            }
        }
        return towDestinationResultsCount;
    }

    public void clickOnShowSearchCriteriaLink() throws Throwable {
        click(DIMCDPage.lnkShowSearchCriteriaLinkInTowDestinationInMCD, "<b>Show Search Criteria Link</b>");
    }

    public void clickOnHideSearchCriteriaLink() throws Throwable {
        click(DIMCDPage.lnkHideSearchCriteriaLinkInTowDestinationInMCD, "<b>Hide Search Criteria</b>");
    }

    public String getValueOfMilesFromSearchCriteriaInRepairTab() throws Throwable {
        String milesValue = getAttributeByValue(DIMCDPage.txtMilesTextBoxInTowDestinationInMCD, "<b>Miles Value</b>");
        return milesValue;
    }

    public String enterValueOfMilesFromSearchCriteriaInRepairTab(String miles) throws Throwable {
        type(DIMCDPage.txtMilesTextBoxInTowDestinationInMCD, miles, "<b>Miles Value</b>");
        return miles;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForBasicLevellessThanGivenMiles
     * description :: To verify Tow Miles For Basic Level lessThan given Miles
     * date :: 18-08-2018
     * author :: Chandra
     */
    public double verifyTowMilesForBasicLevellessThanGivenMiles(String allowedMilsForBasedOnLevel) throws Throwable {
        double noOfMileFromResult = 0.0;
        Thread.sleep(2000);
        boolean repairShops = isVisibleOnly(DIMCDPage.txtMessageNoRecordsAvailableForOtherLocationInMCDWindow, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "<b>No Tow Destinations Available in Table</b>");
        } else {
            allRepairShops = getWebElementList(DIMCDPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {

                String MileFromResult = getText(DIMCDPage.getMilesList(i + 1), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    reporter.SuccessReport("Miles Results value", "<b>Miles return value is:: " + MileFromResult + " </b>");
                } else {
                    int noOfAllowedMilesForBasicMemberInteger = Integer.parseInt(allowedMilsForBasedOnLevel);
                    noOfMileFromResult = Double.parseDouble(MileFromResult);
                    //Below code is used to click On Results Location Link that is less Than 5 Miles
                    if (noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger) {
                        reporter.SuccessReport("<b>Comparing Both Input value and return Value of Miles</b>", "<b>Results miles are with in the radius</b>");
                    } else {
                        reporter.failureReport("<b>Comparing Both Input value and return Value of Miles</b>", "<b>Results miles are out of givne radius</b>");
                        break;
                    }
                }
            }

        }
        return noOfMileFromResult;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyFacilityTypeInRepairFacilityTabInTowDestination
     * description :: To verify Tow facility Type
     * date :: 18-08-2018
     * author :: Chandra
     */
    public void verifyFacilityTypeInRepairFacilityTabInTowDestination(String searchAddress) throws Throwable {
        Thread.sleep(2000);
        boolean repairShops = isVisibleOnly(DIMCDPage.txtMessageNoRecordsAvailableForOtherLocationInMCDWindow, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "<b>No Tow Destinations Available in Table</b>");
        } else {
            allRepairShops = getWebElementList(DIMCDPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {

                String failityTypeFromResults = getText(DIMCDPage.getFacilityType(i + 1), "AAR From results");
                if (failityTypeFromResults.contains(searchAddress)) {
                    reporter.SuccessReport("Facility type Results value", "<b>Facility return value is:: " + failityTypeFromResults + " and Given Facility Type is " + searchAddress + " Both are same</b>");
                } else {
                    reporter.failureReport("<b>Comparing Both Input value and return Value of Miles</b>", "<b>Results miles are out of givne radius</b>");
                    break;
                }
            }
        }
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTRCResultsInRepairFacilityInTowDestinationTba
     * description :: verifyTRCResultsInRepairFacilityInTowDestinationTba
     * date :: 19-08-2018
     * author :: Chandra
     */
    public boolean verifyTRCResultsInRepairFacilityInTowDestinationTba() throws Throwable {
        boolean trcIcon = isVisibleOnly(DIMCDPage.iconTRCInRepairFacilityResultsGridInTowDestination, "TRC Results");
        return trcIcon;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectTRCCheckBox
     * description :: selectTRCCheckBox
     * date :: 19-08-2018
     * author :: Chandra
     */
    public void selectTRCCheckBox() throws Throwable {
        click(DIMCDPage.chkBoxTRCInRepairFacility, "TRC check box");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectAARCheckBox
     * description :: selectAARCheckBox
     * date :: 19-08-2018
     * author :: Chandra
     */
    public void selectAARCheckBox() throws Throwable {
        click(DIMCDPage.chkBoxAARInRepairFacility, "AAR check box");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTRCRecordsInReapirFacilityResultsInTowDestionation
     * description :: To verify Tow facility Type
     * date :: 18-08-2018
     * author :: Chandra
     */
    public void verifyTRCRecordsInReapirFacilityResultsInTowDestionation() throws Throwable {
        Thread.sleep(2000);
        boolean repairShops = isVisibleOnly(DIMCDPage.txtMessageNoRecordsAvailableForOtherLocationInMCDWindow, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "<b>No Tow Destinations Available in Table</b>");
        } else {
            allRepairShops = getWebElementList(DIMCDPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                String facilityTypeExpected = getAttributeByClass(DIMCDPage.iconTRCInRepairFacilityResultsGridInTowDestination, "TRC Icon");
                String facilityTypeActual = getAttributeByClass(DIMCDPage.getFacilityTypeIcon(i + 1), "Acutal Value");
                if (facilityTypeExpected.equalsIgnoreCase(facilityTypeActual)) {
                    reporter.SuccessReport("TRC Facility type Results value", "<b>Search restults returns AAR records are :: " + facilityTypeActual + " And expected result is " + facilityTypeExpected + " </b>");
                } else {
                    reporter.failureReport("TRC Facility type Results value", "<b>Search restults returns AAR records are :: " + facilityTypeActual + " And expected result is " + facilityTypeExpected + "</b>");
                }
            }
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyAARRecordsInReapirFacilityResultsInTowDestionation
     * description :: To verify Tow facility Type
     * date :: 18-08-2018
     * author :: Chandra
     */
    public void verifyAARRecordsInReapirFacilityResultsInTowDestionation() throws Throwable {
        Thread.sleep(2000);
        boolean repairShops = isVisibleOnly(DIMCDPage.txtMessageNoRecordsAvailableForOtherLocationInMCDWindow, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "<b>No Tow Destinations Available in Table</b>");
        } else {
            allRepairShops = getWebElementList(DIMCDPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                String facilityTypeExpected = getAttributeByClass(DIMCDPage.iconAARInRepairFacilityResultsGridInTowDestination, "AAR Icon");
                String facilityTypeActual = getAttributeByClass(DIMCDPage.getFacilityTypeIcon(i + 1), "AAR Icon Acutal Value");
                if (facilityTypeExpected.equalsIgnoreCase(facilityTypeActual)) {
                    reporter.SuccessReport("AAR Facility type Results value", "<b>Search restults returns AAR records are :: " + facilityTypeActual + " And expected result is " + facilityTypeExpected + "</b>");
                } else {
                    reporter.failureReport("AAR Facility type Results value", "<b>Search restults returns AAR records are :: " + facilityTypeActual + " And expected result is " + facilityTypeExpected + "</b>");
                }
            }
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectITUDriver
     * description :: This is used to select Driver used for ITU Automation
     * date :: 20-March-2018
     * author :: Sri Harish Mukthavi
     */
    public void selectITUDriver(String Truck) throws Throwable {
        Thread.sleep(3000);
        click(DIMCDPage.selectTruck(Truck), "Select Truck:" + Truck);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyBatteryQuestionarierInMCDWindow
     * description :: Check for the battery questionairs page
     * date :: 20-08-2018
     * author :: Chandra
     */
    public boolean verifyBatteryQuestionarierInMCDWindow() throws Throwable {
        boolean visibilityOfBatteryQUestionaier = isVisibleOnly(DIMCDPage.batteryTestedYes, "Battery Questionairs");
        return visibilityOfBatteryQUestionaier;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyE250ErrorMessageAvailablity
     * description ::
     * date :: 20-Mar-2018
     * author ::Abhiram
     */
    public boolean verifyE250ErrorMessageAvailablity() throws Throwable {
        boolean errormsg250Availablity = isVisibleOnly(DIMCDPage.btnE250ErrorPopUpErrorOkayButton, "Error 250 message Okay button");
        return errormsg250Availablity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getE250ErrorMessage
     * description ::
     * date :: 20-Mar-2018
     * author ::Abhiram
     */
    public String getE250ErrorMessage() throws Throwable {
        String e250ErrorMessage = getText(DIMCDPage.lblE250ErrorMessage, "Error 250 message appeared-Credit Card");
        return e250ErrorMessage;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnE250OkayButton
     * description ::
     * date :: 20-Feb-2018
     * author ::Chandra
     */
    public void clickOnE250OKButton() throws Throwable {
        click(DIMCDPage.btnE250ErrorPopUpErrorOkayButton, "Error 250 message Okay button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonOnPoppedOutWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Lakshmi
     */
    public void clickOnSaveButtonOnPoppedOutWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSaveCannedCommentsPoppedOut, "Save  button");
        click(DIMCDPage.btnSaveCannedCommentsPoppedOut, "Canned Comments Save button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonOnPoppedOutWindow
     * description ::
     * date :: 20-Feb-2018
     * author ::Lakshmi
     */
    public boolean commentVerificationWithTime(Date verificationTime, Date verifyTimeInbetween, String verificationText) throws Throwable {
        SimpleDateFormat hourIn24 = new SimpleDateFormat("HH:mm");
        boolean flag = false;
        String timeForFind = null;
        Thread.sleep(2000);
        String selectedComment = getText(DIMCDPage.getCommentsFromMCDWindow(verificationText), "selected Comment From Comments Section");
        Thread.sleep(3000);
        String _12hr = "12:00:00";
        Date _12hrs = hourIn24.parse(_12hr);
        //Checking the date format 24 Hours /12 Hours.Based on the date,below functionality is used to split the date
        if (_12hrs.after(verificationTime)) {
            String time[] = verificationTime.toString().split(" ");
            String timestamp[] = time[3].split(":");
            timeForFind = timestamp[0].substring(1, 2) + ":" + timestamp[1].substring(0, 1);
        } else {
            String time[] = verificationTime.toString().split(" ");
            String timestamp[] = time[3].split(":");
            timeForFind = timestamp[0] + ":" + timestamp[1].substring(0, 1);
        }

        String timeInComments = getText(DIMCDPage.getESTTimeFromComments(timeForFind), "Get Time From Comments Section");

        Date dateFormatInComments = hourIn24.parse(timeInComments);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss a z");
        Date dateTime = format.parse(timeInComments);
        boolean commentSaveDtimeFlag = (verificationTime.before(dateFormatInComments) || dateFormatInComments.before(verifyTimeInbetween));
        if (commentSaveDtimeFlag && (selectedComment.contains(verificationText))) {
            flag = true;
        }
        return flag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMinimizeOrMaximizeIcon
     * description ::
     * date :: 19-Feb-2018
     * author ::Lakshmi
     */
    public void clickOnMinimizeOrMaximizeIcon() throws Throwable {
        isVisibleOnly(DIMCDPage.iconMinimizeOrMaximize, "Minimize Or Maximize");
        mouseClick(DIMCDPage.iconMinimizeOrMaximize, "Click On Minimize Or Maximize");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: visibilityOfNoTowPerformed
     * description :: this method is used to verify on no tow performed link in mcd window
     * date :: 22-Mar-2018
     * author ::Chandra
     */
    public boolean visibilityOfNoTowPerformed() throws Throwable {
        Thread.sleep(3000);
        boolean noTow = isVisibleOnly(DIMCDPage.btnNoTowPerformedOnMCDWindow, "No Tow Performed button");
        return noTow;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: visibilityOfStatusUpdateButtons
     * description :: this method is used to verify on Status update buttons in mcd window
     * date :: 22-Mar-2018
     * author ::Chandra
     */
    public boolean visibilityOfStatusUpdateButtons() throws Throwable {
        boolean buttonAvailable = isVisibleOnly(DIMCDPage.btnAvailablityOfStatusButtons, "Status Update buttons are available");
        return buttonAvailable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPacesetterLabelInMCD
     * description ::
     * date :: 21-March-2018
     * author ::Nidhi
     */
    public String getPacesetterLabelInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtOfPacesetterInMCD, "Pacesetter");
        String txt = getText(DIMCDPage.txtOfPacesetterInMCD, "Pacesetter");
        return txt;
    }

    public void selectDropDownItem() throws Throwable {
        click(DIMCDPage.selectDropDownItem, "Select list item");
    }

    public void clickOnFirstPacesetterCodeDropDown(String paceSetterCode1) throws Throwable {
        click(DIMCDPage.btndropdownFoFirstPacesettercode, "Select Dropdown");
        enterPacesetterCode1InServicesTabInMCD(paceSetterCode1);

    }

    public void clickOnSecondPacesetterCodeDropDown() throws Throwable {
        click(DIMCDPage.btndropdownFoSecondPacesettercode, "Select Dropdown");
    }

    public void clickOnSaveButtonInServiceTabInMCDWindow() throws Throwable {
        click(DIMCDPage.btnSaveInService, "Save button");
    }

    public void clickOnTowTabInCancelCallSection() throws Throwable {
        click(DIMCDPage.btnTowInCancelButtons, "Tow button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMemberNumberOnMemberTab
     * description ::This method is used to verify member number on member tab
     * date ::26-Mar-2018
     * author ::Chandra
     */
    public String getMemberNumberOnMemberTab() throws Throwable {
        String memberNumber = getText(DIMCDPage.lblMemberNumberOnMemberTabinMCD, "Member number");
        return memberNumber;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberFirstNameOnMemberTab
     * description ::This method is used to verify first name on member tab
     * date ::26-Mar-2018
     * author ::Chandra
     */
    public String getMemberFirstNameOnMemberTab() throws Throwable {
        String FirstName = getText(DIMCDPage.lblMemberFirstNameOnMemberTabinMCD, "Member First Name");
        return FirstName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberFirstNameOnMemberTab
     * description ::This method is used to verify first name on member tab
     * date ::26-Mar-2018
     * author ::Chandra
     */
    public String getMemberLastNameOnMemberTab() throws Throwable {
        String LastName = getText(DIMCDPage.lblMemberLastNameOnMemberTabinMCD, "Member Last Name");
        return LastName;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPrintCallButtonOnMCDWindow
     * description ::This method is used to verify first name on member tab
     * date ::26-Mar-2018
     * author ::Chandra
     */

    public void clickOnPrintCallButtonOnMCDWindow() throws Throwable {
        click(DIMCDPage.btnPrintCallOnMCD, "Print Call button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMemberStateOnMemberTab
     * description ::This method is used to verify Member City
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public String getMemberStateOnMemberTab() throws Throwable {
        String memberState = getText(DIMCDPage.lblMemberStateOnSummaryTabinMCD, "Member State");
        return memberState;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMemberCityOnMemberTab
     * description ::This method is used to verify Member State
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public String getMemberCityOnMemberTab() throws Throwable {
        String memberCity = getText(DIMCDPage.lblMemberCityOnSummaryTabinMCD, "Member City");
        return memberCity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleTypeOnVehicleTab
     * description ::This method is used to verify vehicle type on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public String getVehicleTypeOnVehicleTab() throws Throwable {
        String type = getText(DIMCDPage.lblVehicleTypeOnVehicleTabinMCD, "Vehicle Type");
        return type;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleYearOnVehicleTab
     * description ::This method is used to verify vehicle year on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public String getVehicleYearOnVehicleTab() throws Throwable {
        String year = getText(DIMCDPage.lblVehicleYearOnVehicleTabinMCD, "Vehicle year");
        return year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleMakeOnVehicleTab
     * description ::This method is used to verify vehicle make on vehicle tab in MCD window
     * date ::
     * author ::Chandra
     */
    public String getVehicleMakeOnVehicleTab() throws Throwable {
        String make = getText(DIMCDPage.lblVehicleMakeOnVehicleTabinMCD, "Vehicle make");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleModelOnVehicleTab
     * description ::This method is used to verify vehicle model on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public String getVehicleModelOnVehicleTab() throws Throwable {
        String make = getText(DIMCDPage.lblVehicleModelOnVehicleTabinMCD, "Vehicle model");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleColorOnVehicleTab
     * description ::This method is used to verify vehicle color on vehicle tab in MCD window
     * date ::
     * author ::
     */
    public String getVehicleColorOnVehicleTab() throws Throwable {
        String make = getText(DIMCDPage.lblVehicleColorOnVehicleTabinMCD, "Vehicle Color");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnReturnToPanelOnMCDWindow
     * description ::This method clicks on ReturnToPane in MCD window
     * date ::
     * author ::Sachin
     */

    public void clickOnReturnToPanelOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkReturnToPanel, "REturn To Panel");
        click(DIMCDPage.lnkReturnToPanel, "REturn To Panel");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDispatchInfo
     * description ::This method is used to get dispatch info
     * date ::
     * author ::
     */
    public String getDispatchInfo() throws Throwable {
        String dispatch = getText(DIMCDPage.lblDispatchInfo, "Dispatch info ");
        return dispatch;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMemberClibCode
     * description ::This method is used to get dispatch info
     * date ::
     * author ::
     */
    public String getMemberClibCode() throws Throwable {
        String club = getText(DIMCDPage.lblMemberClubCodeOnMemberTabinMCD, "Club code");
        return club;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMemberStatusOnMemberTab
     * description ::This method is used to get status info
     * date ::
     * author ::
     */
    public String getMemberStatusOnMemberTab() throws Throwable {
        String status = getText(DIMCDPage.lblMemberStatusOnMemberTabinMCD, "Status code");
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMemberExpirationOnMemberTab
     * description ::This method is used to get status info
     * date ::
     * author ::
     */
    public String getMemberExpirationOnMemberTab() throws Throwable {
        String expdDate = getText(DIMCDPage.lblMemberExpirationDateOnMemberTabinMCD, "Expiration date");
        return expdDate;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDOBOnMemberTab
     * description ::This method is used to get status info
     * date ::
     * author ::
     */
    public String getDOBOnMemberTab() throws Throwable {
        String DOB = getText(DIMCDPage.lblDOBOnMemberTabinMCD, "DOB date");
        return DOB;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getMemberPhoneNumberOnMemberTab
     * description ::This method is used to get phone number
     * date ::
     * author ::Cigniti
     */
    public String getMemberPhoneNumberOnMemberTab() throws Throwable {
        String phone = getText(DIMCDPage.lblMemberPhoneNumberOnMemberTabinMCD, "Phone date");
        return phone;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTowDestinationForRAPCall
     * description ::This method is used to get tow destination for a rap call
     * date ::
     * author ::Cigniti
     */
    public String getTowDestinationForRAPCall() throws Throwable {
        String towDestination = getText(DIMCDPage.lblTowDestinationOnLocationsForRAPTabinMCD, "Tow Destination");
        return towDestination;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: cickOnCallOutButtonOnMCDWindow
     * description ::This method is used to click on Call out button on mcd
     * date ::29/03/2018
     * author ::Madhukar
     */
    public void cickOnCallOutButtonOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCallOut, "Call Out Button");
        click(DIMCDPage.btnCallOut, "Call Out Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: cickOnLiveCallOutButtonOnMCDWindow
     * description ::This method is used to click on Live Call out button on mcd
     * date ::29/03/2018
     * author ::Madhukar
     */
    public void cickOnLiveCallOutButtonOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnLiveCallOut, "Live Call Out Button");
        click(DIMCDPage.btnLiveCallOut, "Live Call Out Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyCallOutOccured
     * description ::This method is used to verify call out occured
     * date ::29/03/2018
     * author ::Madhukar
     */
    public boolean verifyCallOutOccured() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.calloutHighlighted, "Call Out Occured");
        boolean callOutOccured = isVisibleOnly(DIMCDPage.calloutHighlighted, "Call Out Occured");
        return callOutOccured;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyPhoneIconOnMCD
     * description ::This method is used to verify Phone icon on MCD
     * date ::29/03/2018
     * author ::Madhukar
     */
    public boolean verifyPhoneIconOnMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.phoneIcononMCD, "Phone Icon");
        boolean phoneIcon = isVisibleOnly(DIMCDPage.phoneIcononMCD, "Phone Icon");
        return phoneIcon;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRightHandBar
     * description :: verify right hand bar in MCD is clickable or not.
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public String verifyRightHandBar() throws Throwable {
        isVisibleOnly(DIMCDPage.rightHandBarInMcd, "right Hand Bar In Mcd window");
        String classVal = getAttributeValue(DIMCDPage.assignInRightHandBarInMCD,"class");

        return classVal;
    }

    /**
     * param :NA
     * return ::String
     * throws :: throwable
     * methodName :: getUsernameForLockedCall
     * description :: get the username txt for locked user in MCD window.
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public String getUsernameForLockedCall() throws Throwable {
        isVisibleOnly(DIMCDPage.lockedUsernameMCD, "right Hand Bar In Mcd window");
        String getName = getText(DIMCDPage.lockedUsernameMCD, "username");
        return getName;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCancelInStatusUpdateTab
     * description :: verify cancel button is enable or disable in Status update tab
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public String verifyCancelInStatusUpdateTab() throws Throwable {
        isVisibleOnly(DIMCDPage.cancelVisibilityInStatusUpdateTab, "Cancel Button On Status Update Tab");
        String cancelButton = getAttributeByValue(DIMCDPage.cancelVisibilityInStatusUpdateTab, "Cancel Button On Status Update Tab");
        return cancelButton;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCancelInStatusUpdateTab
     * description :: verify update button is enable or disable in Status update tab
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public String verifyUpdateInStatusUpdateTab() throws Throwable {
        isVisibleOnly(DIMCDPage.updateVisibilityInStatusUpdateTab, "Update Button On Status Update Tab");
        String updateButton = getAttributeByValue(DIMCDPage.updateVisibilityInStatusUpdateTab, "Update Button On Status Update Tab");
        return updateButton;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnEditOnTroubleSummary
     * description :: click on edit button on Trouble Summary In MCD window
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public boolean clickOnEditOnTroubleSummary() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkEditInTroubleSummaryInMCDWindow, "edit");
        boolean editbutton = click(DIMCDPage.lnkEditInTroubleSummaryInMCDWindow, "edit");
        return editbutton;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnSaveOnTroubleSummary
     * description :: click on save button on Trouble Summary In MCD window
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public boolean clickOnSaveOnTroubleSummary() throws Throwable {
        boolean savebutton = false;
        if (isVisibleOnly(DIMCDPage.btnSaveForTroubleSummaryInMCDWindow, "save")) {
            savebutton = click(DIMCDPage.btnSaveForTroubleSummaryInMCDWindow, "save");
        }

        return savebutton;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnPacesetterOnTroubleSummary
     * description :: click on pacesetter on Trouble Summary In MCD window
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public void clickOnPacesetterOnTroubleSummary(String pacesetter) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPacesetterFieldInTroubleSummary, "pacesetter");
        type(DIMCDPage.lblPacesetterFieldInTroubleSummary, pacesetter, "pacesetter");
    }

    /**
     * param :NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyMouseHoverTextOLocedIconInMCD
     * description :: verify text on locked icon in mcd window
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public String verifyMouseHoverTextOLocedIconInMCD() throws Throwable {
        mouseHover(DIMCDPage.lockedCallIcon, "Locked Icon");
        String mouseHoverText = getText(DIMCDPage.lockedCallIcon, "Locked Icon text");
        return mouseHoverText;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLockIcon
     * description :: verify lock icon visibility in mcd window
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public boolean verifyLockIcon() throws Throwable {
        boolean lockIcon = waitForVisibilityOfElement(DIMCDPage.lockedCallIcon, "Locked Icon visibility");
        return lockIcon;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyInactiveMCD
     * description :: verify Inactive MCD window
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public boolean verifyInactiveMCD() throws Throwable {
        Thread.sleep(3000);
        boolean window = isVisible(DIMCDPage.mcdInactiveWindow, "Inactive MCD Window");
        return window;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyClosedMCDWindow
     * description :: verify MCD window is closed
     * date :: 29-MAR-2018
     * author ::Nidhi
     */
    public boolean verifyClosedMCDWindow() throws Throwable {
        boolean window = isVisibleOnly(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
        return window;
    }

    /**
     * param :NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyListOfStatusOnMCD
     * description :: verify List Of Status on Status update tab Of MCD
     * date :: 29-MAR-2018
     * author ::Madhukar
     */

    public void verifyListOfStatusOnMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.listOfStatusInMCD, "List of Status");
        List<WebElement> statusWebList = getWebElementList(DIMCDPage.listOfStatusInMCD, "List of Status");
        if (statusWebList.size() != 0) {
            List<String> statusList = new ArrayList<>();
            for (int i = 0; i < statusWebList.size(); ++i) {
                statusList.add(statusWebList.get(i).getText());
            }
            System.out.println(statusList);
            reporter.SuccessReport("List Of Status", "" + statusList);
        }
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyListOfReasonsOnMCD
     * description :: verify List Of Status on Reasons update tab Of MCD
     * date :: 29-MAR-2018
     * author ::Madhukar
     */
    public void verifyListOfReasonsOnMCD() throws Throwable {
        List<WebElement> reasonsWebList = getWebElementList(DIMCDPage.listOfStatusInMCD, "List of Reasons");
        if (reasonsWebList.size() != 0) {
            List<String> reasonList = new ArrayList<>();
            for (int i = 0; i < reasonsWebList.size(); ++i) {
                reasonList.add(reasonsWebList.get(i).getText());
            }
            System.out.println(reasonList);
            reporter.SuccessReport("List Of Reasons", "" + reasonList);
        }
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: getPtaTimeFromMCDWindow
     * description :: To get Pta time from MCD window
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    public String getPtaTimeFromMCDWindow() throws Throwable {
        String ptaDateTime = getText(DIMCDPage.lblPTATime, "get PTA Time");
        return ptaDateTime;
    }

    /**
     * param :NA
     * return ::String
     * throws :: throwable
     * methodName :: getCompletedreakDownLoctionInSummaryTab
     * description :: getCompletedreakDownLoctionInSummaryTab
     * date :: 02-APR-2018
     * author ::
     */
    public String getCompletedreakDownLoctionInSummaryTab() throws Throwable {
        String address = getText(DIMCDPage.lblCompleteBreakdownAddressLocationOnSummaryTabinMCD, "Break Down location");
        return address;
    }

    /**
     * param :NA
     * return ::String
     * throws :: throwable
     * methodName :: getUserName
     * description :: getUserName
     * date :: 02-APR-2018
     * author ::
     */
    public String getUserName() throws Throwable {
        String userName = getText(DIMCDPage.lblUserName, "User Name");
        return userName;
    }

    /**
     * param :NA
     * return ::String
     * throws :: throwable
     * methodName :: getPTAValue
     * description :: getPTAValue
     * date :: 02-APR-2018
     * author ::
     */
    public String getPTAValue() throws Throwable {
        String pta = getText(DIMCDPage.lblPTADate, "PTA Date");
        return pta;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberAddressOnSummaryTab
     * description ::This method is used to verify Member Address On SummaryTab
     * date ::11-Jan-2018
     * author ::Chandra
     */
    public String getMemberAddressOnSummaryTab() throws Throwable {
        String memberAddress = getText(DIMCDPage.lblMemberAddressOnSummaryTabinMCD, "Member Address");
        return memberAddress;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTroubleCodeFromClearingScreen
     * description ::getTroubleCodeFromClearingScreen
     * date ::04-apr-2018
     * author ::Chandra
     */
    public String getTroubleCodeFromClearingScreen() throws Throwable {
        String troubleCode = getAttributeByValue(DIMCDPage.txtTroubleCodeDropdown, "Trouble Code");
        return troubleCode;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: getOLTimeStampFromMCDWindow
     * description :: To get OL time from MCD window
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    public String getOLTimeStampFromMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblOLTimeStamp, "OL TimeStamp");
        String lblOLTimeStamp = getText(DIMCDPage.lblOLTimeStamp, "get OL TimeStamp");
        //Spliting date and time
        String splitTimeAndDate[] = lblOLTimeStamp.split(" ");
        String oLTime = splitTimeAndDate[1];
        return oLTime;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: selectCurrentDateOnOverRideTimeStampSection
     * description :: To select Current Date On OverRide TimeStamp Section
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    public void selectCurrentDateOnOverRideTimeStampSection(String currentDate) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtDateInStautusUpdateTab, "Select currentDate");
        type(DIMCDPage.txtDateInStautusUpdateTab, currentDate, "Select currentDate");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "TAB");

    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: enterOLTimeONOverRideTimeStampSection
     * description :: To enter OL Time ONOverRide TimeStamp Section
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    public void enterOLTimeONOverRideTimeStampSection(String twoMinutesOverOlTime) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTimeInStautusUpdateTab, "Enter OL Time ");

        type(DIMCDPage.txtTimeInStautusUpdateTab, twoMinutesOverOlTime, "Enter two minutes over original OL Time ");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "TAB");
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnPlusIconOfOLTimeOnStatusHistoty
     * description :: To click On PlusIcon Of OLTime On StatusHistoty
     * date :: 02-April-2018
     * author ::Lakshmi
     */

    public void clickOnPlusIconOfOLTimeOnStatusHistoty(String oLTimeStampInDateFormat)throws  Throwable{
        try {
            boolean isPlusisIconVisible = isVisibleOnly(DIMCDPage.clickOnPlusIconOFOverrideTimeStampOnStatusHistory(oLTimeStampInDateFormat), "Click On Plus Icon Of OL Time Stamp");
            if (isPlusisIconVisible) {
                click(DIMCDPage.clickOnPlusIconOFOverrideTimeStampOnStatusHistory(oLTimeStampInDateFormat), "Click On Plus Icon Of OL Time Stamp");
            }else{
                reporter.failureReport("Plus Icon for Override TimeStamp On StatusHistory Is Not Visible","No Plus Icon visible for updated time stamp",driver);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: getCommentOfOLTimeOnstatusHistory
     * description :: To get Comment OfOL Time On statusHistory
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    
    public String getCommentOfOLTimeOnstatusHistory()throws Throwable{
        try {
            String commentsForOL = null;
            boolean isCommentAvailable = isVisibleOnly(DIMCDPage.txtCommentForOverRideTimeOnStatusHistory, " comment from Status History for Override OL Time Stamp");
            if (isCommentAvailable) {
                commentsForOL = getText(DIMCDPage.txtCommentForOverRideTimeOnStatusHistory, "get comment from Status History for Override OL Time Stamp");
            }
            else {
                reporter.failureReport("comment from Status History for Override OL Time Stamp","comment from Status History for Override OL Time Stamp",driver);
            }
            return commentsForOL;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: getTextFromErroMessage
     * description :: To get Text From ErroMessage
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    public String getTextFromErroMessage() throws Throwable {
        String erroMessage = null;
        boolean errorFlag = isVisibleOnly(DIMCDPage.txtErrorE268, "Error message ");
        if (errorFlag) {
            erroMessage = getText(DIMCDPage.txtErrorE268, "Error message for time stamp, should not be earlier to Call received time");
        } else {
            reporter.failureReport("Expected :: The app should not let the user enter an OL override time before the call received time. ", "But application allows to update the OL Time", driver);
        }
        return erroMessage;
    }

    public boolean getTextFromErrorForValidOLTimeStamUpdate() throws Throwable {

        boolean errorFlag = isVisibleOnly(DIMCDPage.txtErrorForValidOLTimeStamUpdate, "Error message ");
        return errorFlag;
    }

    /**
     * param :NA
     * return ::boolean
     * throws :: throwable
     * methodName :: getCallStatusFromStatusUpdateTab
     * description :: To get CallStatus From StatusUpdateTab
     * date :: 02-April-2018
     * author ::Lakshmi
     */
    public String getCallStatusFromStatusUpdateTab() throws Throwable {
        String status = null;
        boolean isStatusVisible = isVisibleOnly(DIMCDPage.txtStatusOfStatusUpdateInMCD, "Get Status From Status Update Tab");
        if (isStatusVisible) {
            status = getAttributeByValue(DIMCDPage.txtStatusOfStatusUpdateInMCD, "Get Status From Status Update Tab");
        } else {
            reporter.failureReport("The MCD window should open and auto populates the OL status and the date is in focus", "With SPP User MCD window Is not opened as expected,And MCD Window Is minimized ,and appears behind the Profile window,Script is failing to get the status", driver);
        }
        return status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClosestTruck
     * description ::This method is used to click on closest truck icon
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnClosestTruck() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.imgClosestTruck, "closest truck");
        click(DIMCDPage.imgClosestTruck, "closest truck");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnViewSearchCriteria
     * description ::This method clicks On View Search Criteria
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnViewSearchCriteria() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblViewSearchCriteria, "view search criteria");
        click(DIMCDPage.lblViewSearchCriteria, "view search criteria");
    }


    /**
     * param ::columnName1,columnName2,columnName3,columnName4,columnName5,columnName6,columnName7
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfTableListOfClosestTrucks
     * description ::This method get Text Of Table List Of Closest Trucks
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void getTextOfTableListOfClosestTrucks(String columnName1,String columnName2,String columnName3,String columnName4,String columnName5,String columnName6,String columnName7) throws Throwable {
        try {
            waitForVisibilityOfElement(DIMCDPage.lblViewSearchCriteria, "View search criteria");
            if (isVisibleOnly(DIMCDPage.lblViewSearchCriteria, "View search criteria")) {
                DIMCDPage.listNameOfClosestTrucks("columnName1");
                String truckName1 = getText(DIMCDPage.listNameOfClosestTrucks(columnName1), "truck name");
                assertTrue(truckName1.contains("Truck"), "column1 matched with Truck");

                DIMCDPage.listNameOfClosestTrucks("columnName2");
                String driverName = getText(DIMCDPage.listNameOfClosestTrucks(columnName2), "Driver name");
                assertTrue(driverName.contains("Driver"), "column2 matched with Driver");

                DIMCDPage.listNameOfClosestTrucks("columnName3");
                String truckType = getText(DIMCDPage.listNameOfClosestTrucks(columnName3), "truck Type");
                assertTrue(truckType.contains("Truck Type"), "column3 matched with Truck type");

                DIMCDPage.listNameOfClosestTrucks("columnName4");
                String status = getText(DIMCDPage.listNameOfClosestTrucks(columnName4), "status");
                assertTrue(status.contains("Status"), "column4 matched with status");

                DIMCDPage.listNameOfClosestTrucks("columnName5");
                String battery = getText(DIMCDPage.listNameOfClosestTrucks(columnName5), "battery");
                assertTrue(battery.contains("Battery"), "column5 matched with Battery");

                DIMCDPage.listNameOfClosestTrucks("columnName6");
                String distance = getText(DIMCDPage.listNameOfClosestTrucks(columnName6), "Distance");
                assertTrue(distance.contains("Distance"), "column6 matched with Distance");

                DIMCDPage.listNameOfClosestTrucks("columnName7");
                String calls = getText(DIMCDPage.listNameOfClosestTrucks(columnName7), "calls");
                assertTrue(battery.contains("Calls"), "column7 matched with Calls");


            } else {
                reporter.failureReport("view search criteria:", " failed to view search criteria");
            }
        }

        catch (Throwable exp) {
            exp.printStackTrace();

        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickInactiveFilter
     * description ::This method clicks On Inactive Filter
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickInactiveFilter() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblInactive, "inactive filter");
        click(DIMCDPage.lblInactive, "inactive filter");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickInSearch
     * description ::This method clicks On search
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickInSearch() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblInactive, "inactive filter");
        click(DIMCDPage.lblInactive, "inactive filter");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckStatus
     * description ::This method verify Truck Status
     * date :: 3 -april-2018
     * author ::Ravi
     */
    public void verifyTruckStatus() throws Throwable {
        List<WebElement> statusList = driver.findElements(DIMCDPage.lstTruckStatus);
        int totalCount = statusList.size();
        ArrayList<String> status = new ArrayList<String>();
        int counter = 1;
        if (totalCount > 0) {
            for (int i = 0; i < totalCount; i++) {
                status.add(statusList.get(i).getText());
            }
            if (statusList.contains("AC")) {
                this.reporter.SuccessReport("validate AC", "Successfully verified Status as AC");
            } else {
                this.reporter.failureReport("unable to validate AC", " status AC is not present");
            }

            if (statusList.contains("IN")) {
                this.reporter.SuccessReport("validate IN", "Successfully verified Status as IN");
            } else {
                this.reporter.failureReport("Unable to validate IN", "Status IN is not present");
            }

           /* this.reporter.SuccessReport("List of status item  ", "  Total status items :  " + totalCount);
            for (int i = 1; i < statusList.size(); i++) {
                this.reporter.SuccessReport("Total list of Truck status", +counter + "is " + statusList.get(i).getText());
                counter++;
            }*/

        } else {
            this.reporter.failureReport("Truck Status list is ", +totalCount + "Failed to display AC or IN status");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBackup
     * description :: This is used to click on backup option in right side panel
     * date ::
     * author :: Nidhi
     */
    public void clickOnBackupInMCD() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnBackupinMCD, "Backup button");
        click(DIMCDPage.btnBackupinMCD, "Backup button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAddAll
     * date ::
     * author :: Nidhi
     */
    public boolean verifyAddAllInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnAddAllInFacilityBackup, "add all button");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyRemoveAll
     * date ::
     * author :: Nidhi
     */
    public boolean verifyRemoveAllInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnRemoveAllInFacilityBackup, "remove all button");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyResetForm
     * date ::
     * author :: Nidhi
     */
    public boolean verifyResetFormInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnResetFormInFacilityBackup, "reset form button");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFindBackup
     * date ::
     * author :: Nidhi
     */
    public boolean verifyFindBackupInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnFindBackupButtonInFacilityBackup, "find Backup button");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFindBackup
     * date ::
     * author :: Nidhi
     */
    public void clickFindBackupInBackupFacilityTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnFindBackupButtonInFacilityBackup, "find Backup button");
        click(DIMCDPage.btnFindBackupButtonInFacilityBackup, "find Backup button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifySpotToFacility
     * date ::
     * author :: Nidhi
     */
    public boolean verifySpotToFacilityInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnSpotToFacilityInFacilityBackup, "spot to facility button");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSpotToFacilityInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public void clickSpotToFacilityInBackupFacilityTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSpotToFacilityInFacilityBackup, "spot to facility button");
        click(DIMCDPage.btnSpotToFacilityInFacilityBackup, "spot to facility button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyContinueAndClickInFacilityBackup
     * date ::
     * author :: Nidhi
     */
    public String verifyContinueAndClickInFacilityBackup() throws Throwable {
        String text = "";
        boolean visibilityOfContinueButton = isVisibleOnly(CRServicePage.btnContinueOnPreferFacility, "Continue button on Prefer Facility");
        if (visibilityOfContinueButton) {
            click(CRServicePage.btnContinueOnPreferFacility, "Continue Button");
            waitForVisibilityOfElement(DIMCDPage.selectotherFacilityFromFacilityTableInBackupFacilityTab, "other facility");
            text = getText(DIMCDPage.selectotherFacilityFromFacilityTableInBackupFacilityTab, "other facility");
            click(DIMCDPage.selectotherFacilityFromFacilityTableInBackupFacilityTab, "other facility");
            clickSpotToFacilityInBackupFacilityTab();
        } else {
            text = getText(DIMCDPage.selectFacilityFromFacilityTableInBackupFacilityTab, "facility");
        }
        return text;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCancelButton
     * date ::
     * author :: Nidhi
     */
    public boolean verifyCancelButtonInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnCancelInFacilityBackup, "cancel button");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyReasonInBackupFacility
     * date ::
     * author :: Nidhi
     */
    public boolean verifyReasonInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.dropdownReasonInFacilityBackup, "reason dropdown");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyReasonInBackupFacility
     * date ::
     * author :: Nidhi
     */
    public boolean verifyCommentInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.txtFieldCommentsInFacilityBackup, "comment section");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFacilityTableInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public boolean verifyFacilityTableInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.btnFacilityTableInFacilityBackup, "comment section");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyServiceCodeInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public boolean verifyServiceCodeInBackupFacilityTab() throws Throwable {
        boolean visibility = waitForVisibilityOfElement(DIMCDPage.serviceCodeTableInFacilityBackup, "comment section");
        return visibility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectReasonInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public void selectReasonInBackupFacilityTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnReasonDropdownInFacilityBackup, "reason dropdown");
        mouseDoubleClick(DIMCDPage.btnReasonDropdownInFacilityBackup, "reason dropdown");
        Thread.sleep(2000);
        waitForVisibilityOfElement(DIMCDPage.selectReasonFromDropdownInFacilityBackup, "reason dropdown option");
        click(DIMCDPage.selectReasonFromDropdownInFacilityBackup, "reason dropdown option");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getSelectedReasonInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public String getSelectedFacilityInBackupFacilityTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectFacilityFromFacilityTableInBackupFacilityTab, "facility");
        String text = getText(DIMCDPage.selectFacilityFromFacilityTableInBackupFacilityTab, "facility");
        return text;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public String selectFacilityInBackupFacilityTab() throws Throwable {
       /* waitForVisibilityOfElement(DIMCDPage.selectFacilityFromFacilityTableInBackupFacilityTab, "facility");
        click(DIMCDPage.selectFacilityFromFacilityTableInBackupFacilityTab, "facility");*/
        List<WebElement> allFacility = getWebElementList(DIMCDPage.FacilityInFacilityBackup, "facility List");
        String facility = "";
        for (int i = 0; i < allFacility.size(); i++) {

            if (!allFacility.get(i).equals(allFacility.get(0))) {
                facility = allFacility.get(i).getText();
                allFacility.get(i).click();
                clickSpotToFacilityInBackupFacilityTab();
                boolean visibilityOfContinueButton = isVisibleOnly(CRServicePage.btnContinueOnPreferFacility, "Continue button on Prefer Facility");
                if (visibilityOfContinueButton) {
                    click(CRServicePage.btnContinueOnPreferFacility, "Continue Button");
                    facility = allFacility.get(i + 1).getText();
                    allFacility.get(i + 1).click();
                    clickSpotToFacilityInBackupFacilityTab();
                } else {
                    break;
                }
            }
        }
        return facility;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public void clickOnServiceCode() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.serviceCodeInFacilityBackup, "service code");
        click(DIMCDPage.serviceCodeInFacilityBackup, "service code");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityInBackupFacilityTab
     * date ::
     * author :: Nidhi
     */
    public String verifyMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCallDetailsInMCD, "MCD WINDOW");
        String mcd = getText(DIMCDPage.txtCallDetailsInMCD, "MCD WINDOW");
        return mcd;
    }

    public boolean verifyDateAndCallIdVisibilityInShowBatteryHistory() throws Throwable {
        boolean dateAndCallId = isVisibleOnly(DIMCDPage.lblDateAndCallIdInShowBatteryHistory, "Call ID and date of the battery call");
        return dateAndCallId;
    }

    public void clickOnDoneButtonInBatteryInformationWindow() throws Throwable {
        click(DIMCDPage.btnDoneInBatteryInformationScreen, "Done Button");
    }

    public boolean verifyNoDataMessage() throws Throwable {
        boolean nodata = isVisibleOnly(DIMCDPage.lblNoDataAvailableInPrintPage, "nodata ");
        return nodata;
    }

    public String getNoDataMessage() throws Throwable {
        String nodatamessage = getText(DIMCDPage.lblNoDataAvailableInPrintPage, "No data message");
        return nodatamessage;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyStatusHistoryScreen
     * Description:: This method is used to verify status screen on MCD
     * date ::04-04-2018
     * author :: Madhukar
     */
    public boolean verifyStatusHistoryScreen() throws Throwable {
        boolean statusHistoryScreen = isVisibleOnly(DIMCDPage.statusHistoryScreen, "Status History Screen");
        return statusHistoryScreen;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEditAndClick
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public boolean verifyEditLinkAvailablity() throws Throwable {
        boolean editLinkAvailablity = isVisibleOnly(DIMCDPage.editLink, "Edit Link Availablity ");
        return editLinkAvailablity;
    }


    public void verifyBatteryHisotryInformation(String callid) throws Throwable {

        records = getWebElementList(DIMCDPage.lblDateAndCallIdInShowBatteryHistory, "Call id date in show BatteryHistory screen");
        List<WebElement> dataAndCallId = null;
        List<WebElement> resolutionCode = null;
        List<WebElement> testCodeValue = null;
        List<WebElement> facilityValue = null;
        List<WebElement> vehicleValue = null;
        String DateandCallId;
        boolean callIDExistInList = false;
        dataAndCallId = getWebElementList(DIMCDPage.lblDateAndCallIdInShowBatteryHistory, "Date and Call ID");
        resolutionCode = getWebElementList(DIMCDPage.lblResoultionCodeValueInShowBatteryHistory, "Resoultion code");
        testCodeValue = getWebElementList(DIMCDPage.lblTestCodeValueInShowBatteryHistory, "Test Code Value");
        facilityValue = getWebElementList(DIMCDPage.lblFacilityValueInShowBatteryHistory, "Facility Value");
        vehicleValue = getWebElementList(DIMCDPage.lblVehicleValueInShowBatteryHisotry, "vehicle Value");
        for (int j = 0; j < dataAndCallId.size(); j++) {
            DateandCallId = dataAndCallId.get(j).getText();
            if (DateandCallId.contains(callid)) {
                reporter.SuccessReport("Call id exist", "New call id exist in the history list");
                callIDExistInList = true;

               /* for (int i = 0; i < dataAndCallId.size(); i++)
                    String DateandCallId = dataAndCallId.get(i).getText();*/

                String ResoulutionCode = resolutionCode.get(j).getText();
                String TestCode = testCodeValue.get(j).getText();
                String FacilityValue = facilityValue.get(j).getText();
                String VehicleValue = vehicleValue.get(j).getText();
                reporter.SuccessReport("<b>Date and CallId " + DateandCallId + "</b>", "Date And Call id is " + DateandCallId);
                reporter.SuccessReport("<b>ResoulutionCode </b>", "Resoultion code value is  " + ResoulutionCode);
                reporter.SuccessReport("<b>Test Code <b>", "Test Code value is   " + TestCode);
                reporter.SuccessReport("<b>Facility Code </b>", "Facility code Value is  " + FacilityValue);
                reporter.SuccessReport("<b>Vehicle Value  ", "Vehicle Value is  " + VehicleValue);
                break;
            }
        }
        if (callIDExistInList == false) {
            reporter.failureReport("Availablity of Newly Created Call id", "Newly created call id is not available" + callid, driver);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyFindBackup
     * date ::
     * author :: Nidhi
     */
    public void listOfBackupFacility() throws Throwable {
        Thread.sleep(2000);
        List<WebElement> allBackup = getWebElementList(DIMCDPage.backuplevelInFacilityBackup, "Backup List");
        List<WebElement> allFacility = getWebElementList(DIMCDPage.FacilityInFacilityBackup, "facility List");
        for (int i = 0; i < allBackup.size(); i++) {

            if (allBackup.get(i).equals(allBackup.get(0))) {
                String allFacilityItems = allFacility.get(i).getText();
                assertTrue(true, "<b>Primary Facility is </b>" + allFacilityItems);

            } else {
                String allFacilityItems = allFacility.get(i).getText();
                assertTrue(true, "<b>Backup Facility is </b>" + allFacilityItems);
            }

        }
    }

    public boolean verifyDoneButtonInBatteryInformationWindow() throws Throwable {
        boolean available = isVisibleOnly(DIMCDPage.btnDoneInBatteryInformationScreen, "Done Button");
        return available;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfFacility
     * description :: getTextOfFacility
     * date :: 4-april-2018
     * author ::ravi
     */
    public void getTextOfFacility() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary Tab");
        getText(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary Tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckActiveList
     * description ::This method verify Truck Active List
     * date :: 5 -april-2018
     * author ::Ravi
     */
    public void verifyTruckActiveList() throws Throwable {
        try {
            Thread.sleep(2000);
            List<WebElement> activeTrucksInFacility = driver.findElements(DIMCDPage.lblActiveTrucks);
            int totalCount = activeTrucksInFacility.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 0; i < activeTrucksInFacility.size(); i++) {
                    this.reporter.SuccessReport("Active trucks in facility 5140 are", +counter + "is " + activeTrucksInFacility.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.failureReport("No list active list found", +totalCount + "is Empty");
            }
        } catch (Throwable exp) {
            exp.printStackTrace();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyListOfClosestTrucksIncludesLoadedAndUnloadedTrucks
     * description ::This method verifys List Of Closest Trucks Includes Loaded And UnloadedTrucks
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void verifyListOfClosestTrucksIncludesLoadedTrucks() throws Throwable {
        try{
            //waitForVisibilityOfElement(DIMCDPage., "wait for status in DUS");
            Thread.sleep(5000);
            List<WebElement> loadedTruckList = driver.findElements(DIMCDPage.lstLoadedTrucks);
            int totalCount = loadedTruckList.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 1; i < loadedTruckList.size(); i++) {
                    this.reporter.SuccessReport("loaded truck", +counter + "is " + loadedTruckList.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.failureReport("No list  found", +totalCount + "is Empty");
            }
        }
        catch (Throwable exp) {
            exp.printStackTrace();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyListOfClosestTrucksIncludesLoadedAndUnloadedTrucks
     * description ::This method verifys List Of Closest Trucks Includes Loaded And UnloadedTrucks
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void verifyListOfClosestTrucksIncludesUnLoadedTrucks() throws Throwable {
        try {
            Thread.sleep(2000);
            List<WebElement> unloadedTruckList = driver.findElements(DIMCDPage.lstUnloadedTrucks);
            int totalCount = unloadedTruckList.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 1; i < unloadedTruckList.size(); i++) {
                    this.reporter.SuccessReport("unloaded truck is", +counter + "is " + unloadedTruckList.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.failureReport("No list  found", +totalCount + "is Empty");
            }
        } catch (Throwable exp) {
            exp.printStackTrace();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyListOfFacilityTrucks
     * description ::This method verifys List Of Facility Trucks
     * date :: 5 -april-2018
     * author ::Ravi
     */
    public void verifyListOfFacilityTrucks() throws Throwable {
        try {
            Thread.sleep(2000);
            List<WebElement> facilityTruckNamesList = driver.findElements(DIMCDPage.facilitTruckNames);
            int totalCount = facilityTruckNamesList.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 1; i < facilityTruckNamesList.size(); i++) {
                    this.reporter.SuccessReport("facility Truck names are ", +counter + "is " + facilityTruckNamesList.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.failureReport("No list  found", +totalCount + "is Empty");
            }
        } catch (Throwable exp) {
            exp.printStackTrace();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyListOfBatteryTrucksFromCurrentFacility
     * description ::This method verify List Of Battery Trucks From Current Facility
     * date :: 5 -april-2018
     * author ::Ravi
     */
    public void verifyListOfBatteryTrucksFromCurrentFacility() throws Throwable {
        try {
            Thread.sleep(2000);
            List<WebElement> listOfBatteryTrucksFromCurrentFacility = driver.findElements(DIMCDPage.batteryListFromCurrentFacility);
            int totalCount = listOfBatteryTrucksFromCurrentFacility.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 1; i < listOfBatteryTrucksFromCurrentFacility.size(); i++) {
                    this.reporter.SuccessReport("list of battery trucks from current facility 5140 are", +counter + "is " + listOfBatteryTrucksFromCurrentFacility.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.failureReport("No list  found", +totalCount + "is Empty");
            }
        } catch (Throwable exp) {
            exp.printStackTrace();
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstTruckWhichContainsDriver
     * description ::This method click On FirstTruck Which Contains Driver
     * date :: 3 -april-2018
     * author ::Ravi
     */
    public void clickOnFirstTruckWhichContainsDriver() throws Throwable {
        try{
            waitForVisibilityOfElement(DIMCDPage.btnFirstLoadedTrucks, "first loaded truck");
            click(DIMCDPage.btnFirstLoadedTrucks, "first loaded truck");
        }
        catch (Throwable exp) {
            exp.printStackTrace();
        }
    }

    public boolean verifyOnShowBatteryServiceHistory() throws Throwable {
        boolean ShowBatteryButtonavailablity = isVisibleOnly(DIMCDPage.btnShowBatteryServiceHistoryForRAP, "Show Battery Service History Button");
        return ShowBatteryButtonavailablity;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyGearIconOnMCD
     * description ::verify Gear Icon On MCD
     * date :: 6 -april-2018
     * author ::Madhukar
     */
    public boolean verifyGearIconOnMCD() throws Throwable {
        boolean gearIcon = isVisibleOnly(DIMCDPage.iconGearOnMCDWindow, "Gear Icon");
        return gearIcon;
    }

    /**
     * param ::String
     * return ::NA
     * throws :: throwable
     * methodName :: enterETATime
     * description ::Thisn function selects the ETA time
     * date :: 6 -april-2018
     * author ::Sachin
     */
    public void enterETATime(String ETATime) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.SelectTimeFromETAList(ETATime), "ETA Time" + ETATime);
        click(DIMCDPage.SelectTimeFromETAList(ETATime), "ETA Time" + ETATime);
    }

    /**
     * param ::String
     * return ::NA
     * throws :: throwable
     * methodName :: verifyAdditionalInfoLinkInMCDServiceTab
     * description ::verifyAdditionalInfoLinkInMCDServiceTab
     * date :: 9 -april-2018
     * author ::Chandra
     */
    public boolean verifyAdditionalInfoLinkInMCDServiceTab() throws Throwable {
        boolean editAdditionalInfoLink = isVisibleOnly(DIMCDPage.lnkEditAdditionalInfo, "Additional Info Link");
        return editAdditionalInfoLink;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAssaignTruck
     * description ::This method clicks On assaign truck
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnAssaignTruck() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAssignTruck, "assign truck");
        click(DIMCDPage.btnAssignTruck, "assign truck");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstLoadedTruck
     * description ::This method clicks On first loaded truck
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnFirstLoadedTruck() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnFirstLoadedTrucks, "first loaded truck");
        click(DIMCDPage.btnFirstLoadedTrucks, "first loaded truck");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckInActiveList
     * description ::This method verify Truck In InActive List
     * date :: 5 -april-2018
     * author ::Ravi
     */
    public void verifyTruckInActiveList() throws Throwable {
        try{
            Thread.sleep(2000);
            List<WebElement> inActiveTrucksInFacility = driver.findElements(DIMCDPage.lblInActiveTrucks);
            int totalCount = inActiveTrucksInFacility.size();
            int counter = 1;
            if (totalCount > 1) {
                for (int i = 0; i < inActiveTrucksInFacility.size(); i++) {
                    this.reporter.SuccessReport("InActive trucks in facility 5140 are", +counter + "is " + inActiveTrucksInFacility.get(i).getText());
                    counter++;
                }
            } else {
                this.reporter.failureReport("No list active list found", +totalCount + "is Empty");
            }
        }
        catch (Throwable exp) {
            exp.printStackTrace();

        }
    }
    public boolean verifyTheSavedComment(String comment)throws Throwable{
        boolean isCommentSaved=false;
       waitForVisibilityOfElement(DIMCDPage.getCommentsFromMCDWindow(comment), "selected Comment From Comments Section");
       String selectedComment = getText(DIMCDPage.getCommentsFromMCDWindow(comment), "selected Comment From Comments Section");
       if(selectedComment.contains(comment)){
           isCommentSaved=true;
       }
       return isCommentSaved;
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
        mouseClick(DIMCDPage.lnkUseMemberShipDataOnBillingInfoInCreditCardTab, "Click on Use Membership data link");
        Thread.sleep(3000);
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
        click(DIMCDPage.btnContinueOnBillingInfoInCreditCardTab, "Click on Continue Button");
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
        type(DIMCDPage.txtAmountOnBillingInfoInCreditCardTab, amount, "Enter Amount on Billing Info page");
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
        type(DIMCDPage.txtCreditCardNumberOnCreditCardInfoInCreditCardTab, creditCardNumber, "Enter Credit Card Number in Credit Card Info page");
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
        type(DIMCDPage.txtCVCNumberOnCreditCardInfoInCreditCardTab, cvc, "Enter CVC Number in Credit Card Info page");
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
        click(DIMCDPage.btnContinueOnCreditCardInfoInCreditCardTab, "Click on Continue Button");
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
        click(DIMCDPage.drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab, "Month");
        waitForVisibilityOfElement(DIMCDPage.drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab, "Month");
        selectByVisibleText(DIMCDPage.drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab, month, "Month");
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
        click(DIMCDPage.drpdwnExpirationYearOnCreditCardInfoInCreditCardTab, "year");
        waitForVisibilityOfElement(DIMCDPage.drpdwnExpirationYearOnCreditCardInfoInCreditCardTab, "year");
        selectByVisibleText(DIMCDPage.drpdwnExpirationYearOnCreditCardInfoInCreditCardTab, year, "year");
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
        click(DIMCDPage.btnCloseOnCreditCard, "Click on Close Button");
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
    public void clickOnCreditCardButtonOnMCDWindow() throws Throwable {
        click(DIMCDPage.btnCrediCardOnMCD, "Credit Card Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyCreditCardInfoTab
     * description :: verifyCreditCardInfoTab
     * date :: 16-Apr-2018
     * author :: Abhiram
     */
    public boolean verifyCreditCardInfoTab() throws Throwable {
        boolean creditcardInfo = isVisibleOnly(DIMCDPage.lblEnterCreditInformation, "Credit Card Info Tab");
        return creditcardInfo;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyTransactionInfoTab
     * description :: verifyTransactionInfoTab
     * date :: 16-Apr-2018
     * author :: Abhiram
     */
    public boolean verifyTransactionInfoTab() throws Throwable {
        Thread.sleep(5000);
        boolean tabTransactionInfo = isVisibleOnly(DIMCDPage.tabTransactionInfo, "Credit Card Info Tab");
        return tabTransactionInfo;
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
        waitForVisibilityOfElement(DIMCDPage.creditCardInTransactioHistory, "Credit card ");
        String Info = getText(DIMCDPage.creditCardInTransactioHistory, "Credit card ");
        return Info;
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnVoidAuthorization
     * description :: click On VoidAuthorization on Credit card info page
     * date ::16-Apr-2018
     * author :: Abhiram
     */
    public void clickOnVoidAuthorization() throws Throwable {
        click(DIMCDPage.btnVoidAuthorization, "Void Authorization Button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: VerifyAvailablityOfEditLinkInServicesTab
     * description ::
     * date :: 16-Apr-2018
     * author ::Chandu
     */
    public boolean VerifyAvailablityOfEditLinkInServicesTab() throws Throwable {
        return isVisibleOnly(DIMCDPage.lnkEditTowDestinationInServicesTabInMCDWindow, "Tow destination Edit");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: VerifyTransactionTypeOnTransactionHistory
     * description ::
     * date :: 16-Apr-2018
     * author ::Madhukar
     */
    public boolean VerifyTransactionTypeOnTransactionHistory() throws Throwable {
        return isVisibleOnly(DIMCDPage.lblTransactionType, "TransactionType");
    }
     /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnInactive
     * description ::This method click On Inactive
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnInactive() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblInactive,"verified inactive");
        mouseClick(DIMCDPage.lblInactive,"verified inactive");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButton
     * description ::This method clickOnSearchButton
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnSearchButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSearch,"click on Search");
        mouseDoubleClick(DIMCDPage.btnSearch,"click on Search");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButton
     * description ::This method clickOnSearchButton
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnLoaded() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblLoaded,"clicked loaded");
        mouseDoubleClick(DIMCDPage.lblLoaded,"clicked loaded");
    }




    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFromOtherFacilities
     * description ::This method clickOnFromOtherFacilities
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnFromOtherFacilities() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFromOtherFaciilties,"clicked from other facilities");
        mouseDoubleClick(DIMCDPage.lblFromOtherFaciilties,"clicked from other facilities");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnShowBatteryTruckOnly
     * description ::This method clickOnShowBatteryTruckOnly
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnShowBatteryTruckOnly() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblShowBatteryTrucksOnly,"clicked show battery trucks only");
        mouseDoubleClick(DIMCDPage.lblShowBatteryTrucksOnly,"clicked show battery trucks only");
    }




    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCrossButtonInTruckTypes
     * description ::This method clickOnCrossButtonInTruckTypes
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnCrossButtonInTruckTypes() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.imgCrossButtonInTruckTypes,"Remove all filters and click search");
        mouseDoubleClick(DIMCDPage.imgCrossButtonInTruckTypes,"Remove all filters and click search");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCrossButtonInTruckTypes
     * description ::This method clickOnCrossButtonInTruckTypes
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnViewSearchCriterias() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblViewSearchCriteria,"clicked view search criteria");
        mouseClick(DIMCDPage.lblViewSearchCriteria,"clicked view search criteria");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCrossButtonInTruckTypes
     * description ::This method clickOnCrossButtonInTruckTypes
     * date :: 4 -april-2018
     * author ::Ravi
     */
    public void clickOnAssaignTruckOnList() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAssignTruck,"Assign  truck");
        mouseClick(DIMCDPage.btnAssignTruck,"clicked Assign truck");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: VerifyTransactionRoutingIdOnTransactionHistory
     * description ::
     * date :: 16-Apr-2018
     * author ::Madhukar
     */
    public boolean VerifyTransactionRoutingIdOnTransactionHistory() throws Throwable {
        return isVisibleOnly(DIMCDPage.lblTransactionRoutingId, "TransactionRoutingId");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: VerifyTransactionAmountOnTransactionHistory
     * description ::
     * date :: 16-Apr-2018
     * author ::Madhukar
     */
    public boolean VerifyTransactionAmountOnTransactionHistory() throws Throwable {
        return isVisibleOnly(DIMCDPage.lblTransactionAmount, "TransactionAmount");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: VerifyTransactionCodeOnTransactionHistory
     * description ::
     * date :: 16-Apr-2018
     * author ::Madhukar
     */
    public boolean VerifyTransactionCodeOnTransactionHistory() throws Throwable {
        return isVisibleOnly(DIMCDPage.lblTransactionCode, "TransactionCode");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: VerifyInvalidCreditCardDetailsForPayment
     * description ::
     * date :: 16-Apr-2018
     * author ::Madhukar
     */
    public boolean VerifyInvalidCreditCardDetailsForPayment() throws Throwable {
        return isVisibleOnly(DIMCDPage.lblErrorMessageForInvalidCard, "ErrorMessageForInvalidCard");
    }
    /* param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyManualAddressEntryInServicesInMCDWindow
     * description :: Manual entry link is visible or not
     * date :: 17-Apr-2018
     * author ::Jagadish Pola
     */
    public boolean verifyManualAddressEntryInServicesInMCDWindow() throws Throwable {
        dynamicWaitByLocator(DIMCDPage.lnkManualAddressEntryInTowDestinationInMCDWindow,60);
        return isVisibleOnly(DIMCDPage.lnkManualAddressEntryInTowDestinationInMCDWindow, "Manual Address Entry ");
    }}