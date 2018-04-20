
package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import com.sun.glass.ui.Robot;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import static org.openqa.selenium.Keys.NUMPAD8;

public class TC_DIQuickKeyboardActions extends ActionEngine {
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombinedFromCr;
    public static String callID;
    public static String secondCallIdAnddate;
    public static String  secondCallID;
    public  String [] callandfacilityId = new String[3];
    public static String facilityFromCR;
    LoginLib login = new LoginLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    CRServiceLib services = new CRServiceLib();
    CRHomeLib home = new CRHomeLib();
    DIProfileLib profileLib = new DIProfileLib();
    DIMCDLib mcdLib = new DIMCDLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DITruckLoadDeafultViewLib truckLoad = new DITruckLoadDeafultViewLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRServiceLib service = new CRServiceLib();
    CommonLib commonLib = new CommonLib();
    DIHomePage diHomePage = new DIHomePage();
    public static String callIDAndDateCombined;

    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test(enabled = true)
    public void quickKeyboardActions(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIQuickKeyboardActions", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIQuickKeyboardActions", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1903: TC-DI Quick Keyboard Actions" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //Calling common function to create call
                    createCall(data);
                    //Navigate TO Dispatch
                    navigateToApplication("DI");
                    //Thread.sleep(3000);
                    diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                    crHomeLib.waitCloseAllBusyIconsResults();
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnAppliationListInMenu();
                    home.waitCloseAllBusyIconsResults();
                    diHome.clickOnUserProfile();
                    home.waitCloseAllBusyIconsResults();
                    String actualScreenName = diHome.getUserProfileScreenName();
                    String expectedScreenName = data.get("UserProfileScreenName");
                    assertTrue(actualScreenName.contains(expectedScreenName), "The user profile screen is in view");
                    diHome.clickOnUserSettingsTabOnUserProfileScreen();
                    home.waitCloseAllBusyIconsResults();
                    String generalSettingsLabelName = diHome.getGeneralSettingLabelName();
                    //The following  should be toggled on by default on the General Settings section:
                    boolean isCommentsSelected = diHome.quickCommentsCheckBoxIsChecked();
                    assertTrue(isCommentsSelected, "Quick Comments Is selected by default On  " + generalSettingsLabelName);
                    boolean isquickETASelected = diHome.quickETACheckBoxIsChecked();
                    assertTrue(isquickETASelected, "Quick ETA Is selected by default on  " + generalSettingsLabelName);
                    boolean isQuickTruckAssignmentSelected = diHome.quickTruckAssignmentCheckBoxIsChecked();
                    assertTrue(isQuickTruckAssignmentSelected, "Quick Truck Assignment Is selected by default on  " + generalSettingsLabelName);
                    boolean isTruckMessagingSelected = diHome.quickTruckMessagingCheckBoxIsChecked();
                    assertTrue(isTruckMessagingSelected, "Quick Truck Messaging is Selected by default on  " + generalSettingsLabelName);
                    //Description of the settings should come up during hover for each.
                    String quickCommentsInfoIconName = diHome.mouseHoverToQuickCommentsInfoIcon();
                    String quickCommentsExpectedName = data.get("QuickComments");
                    assertTrue(quickCommentsExpectedName.contains(quickCommentsExpectedName), "Quick Comments Info Icon Name is  " + quickCommentsInfoIconName);
                    String quickETAInfoIconName = diHome.mouseHoverToQuickETAInfoIcon();
                    String quickETAExpectedName = data.get("QuickETAInfoIcon");
                    assertTrue(quickETAInfoIconName.contains(quickETAExpectedName), "Quick ETA Info Icon Name is  " + quickETAInfoIconName);
                    String quickTruckAssignmentInfoIconName = diHome.mouseHoverToQuickTruckAssignmentInfoIcon();
                    String quickTruckAssignmenExpectedName = data.get("QuickTruckAssignment");
                    assertTrue(quickTruckAssignmentInfoIconName.contains(quickTruckAssignmenExpectedName), "TruckAssignment Info Icon name is  " + quickTruckAssignmentInfoIconName);
                    String quickTruckMessagingInfoIconName = diHome.mouseHoverToQuickTruckMessagingInfoIcon();
                    String quickTruckMessagingExpectedName = data.get("QuickTruckMessaging");
                    assertTrue(quickTruckMessagingInfoIconName.contains(quickTruckMessagingExpectedName), "Truck Messaging Info Icon Name is  " + quickTruckMessagingInfoIconName);
                    diHome.clickOnCloseButtonOnUserProfileWindow();
                    home.waitCloseAllBusyIconsResults();
                    //Go to MCD Window
                    //Quick Comments

                    //Go to the profile window
                    diHome.clickOnProfileMenu();
                    diHome.clickOnProfileName(data.get("ProfileName"));
                    home.waitCloseAllBusyIconsResults();
                    //change the profile settings
                    commonLib.resetProfileSettings();
                    //Select the call and perform keyboard action
                    profileLib.selectACallOnProfileTab(callIDAndDateCombinedFromCr);
                    home.waitCloseAllBusyIconsResults();
                    Actions actions = new Actions(driver);
                    //actions.sendKeys(String.valueOf('\u0061')).perform();
                    String combineKeys2 = Keys.chord("a");
                    sendKeys(combineKeys2, "a");
                    //String frameUrl="";
                    //openURLInNewTab();
                    String comments = data.get("CommentForQuickKeyBoardAction");
                    //Enter Comments In AddCommentsWindow On Profile Window
                    profileLib.enterCommentsInAddCommentsWindow(comments);
                    home.waitCloseAllBusyIconsResults();
                    profileLib.clickOnSaveButtonToSaveComments();
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(2000);

                    diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombinedFromCr);
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(2000);
                    //boolean commentsFlag = mcdLib.commentVerificationWithTime(timeFromSystem,targetTime, comments);
                    boolean isCommentSaved = mcdLib.verifyTheSavedComment(comments);
                    assertTrue(isCommentSaved, "Verified the quick comment,Comment saved for callId  " + callIDAndDateCombinedFromCr);
                    mcdLib.closeTheOpendCallInMCD();

                    //To enter comments by selecting two calls
                    // go to search calls to get second call.First call crated by code
                    diHome.clickOnSearchCallsInDispatch();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diSearchCalls.selectCallStatus(data.get("SPStatus"));
                    diHome.clickOnSearchInSearchCalls();
                    home.waitCloseAllBusyIconsResults();
                    diSearchCalls.clickOnSecondCallIDOnSearchCalls();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    secondCallIdAnddate = getCallIDAndDateFroMCDWindow();
                    secondCallID = mcdLib.getCallIdFromMcdWindow();
                    if (secondCallID.contains(callID)) {
                        mcdLib.closeTheOpendCallInMCD();
                        diHome.clickOnSearchCallsInDispatch();
                        crHomeLib.waitCloseAllBusyIconsResults();
                        diSearchCalls.selectCallStatus(data.get("SPStatus"));
                        diHome.clickOnSearchInSearchCalls();
                        home.waitCloseAllBusyIconsResults();
                        diSearchCalls.clickOnFourthCallIDOnSearchCalls();
                        crHomeLib.waitCloseAllBusyIconsResults();
                        secondCallIdAnddate = getCallIDAndDateFroMCDWindow();
                        secondCallID = mcdLib.getCallIdFromMcdWindow();
                    }
                    mcdLib.closeTheOpendCallInMCD();
                    //Go to the profile window
                    diHome.clickOnProfileMenu();
                    diHome.clickOnProfileName(data.get("ProfileName"));
                    home.waitCloseAllBusyIconsResults();
                    //Select the call and perform keyboard action
                    profileLib.selectMultipleCalls(callIDAndDateCombinedFromCr, secondCallIdAnddate);
                    home.waitCloseAllBusyIconsResults();
                    //Actions action = new Actions(driver);
                    //actions.sendKeys(String.valueOf('\u0061')).build().perform();
                    String combineKeys3 = Keys.chord("a");
                    sendKeys(combineKeys3, "a");
                    String commentWhenTwoCallsSelected = data.get("CommentWhenTwoCallsSelected");
                    //Enter Comments In AddCommentsWindow On Profile Window
                    profileLib.enterCommentsInAddCommentsWindow(commentWhenTwoCallsSelected);
                    profileLib.clickOnSaveButtonToSaveComments();
                    home.waitCloseAllBusyIconsResults();
                    diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombinedFromCr);
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(2000);
                    boolean commentsFlag = mcdLib.verifyTheSavedComment(comments);
                    assertTrue(commentsFlag, "Verified the quick comment,Comment saved for the call " + callIDAndDateCombinedFromCr);
                    mcdLib.closeTheOpendCallInMCD();
                    home.waitCloseAllBusyIconsResults();
                    //Comment verification In Second  call that is selected when entering the comments
                    diHome.searchAndClickOnCallIdOnProfileWindow(secondCallIdAnddate);
                    home.waitCloseAllBusyIconsResults();
                    //boolean is///CommentAdded = mcdLib.commentVerificationWithTime(systemTime,timeOverSysTime, commentWhenTwoCallsSelected);
                    boolean isCommentAdded = mcdLib.verifyTheSavedComment(comments);
                    assertTrue(isCommentAdded, "Verified the quick comment,Comment saved for the call  " + secondCallIdAnddate);
                    mcdLib.closeTheOpendCallInMCD();


                    //Quick ETA:
                    diHome.clickOnSearchCallsInDispatch();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    //change the status of a call from SP to DI
                    diSearchCalls.clickAndEnterCallIDInfo(secondCallID);
                    diSearchCalls.clearCallStatus();
                    diHome.clickOnSearchInSearchCalls();
                    home.waitCloseAllBusyIconsResults();
                    diHome.clickOnCallDateOrIDLink();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    mcdLib.clickOnAssign();
                    mcdLib.selectSecondFacilityOnAssignTabInMCD();

                    mcdLib.selectDispatch();
                    home.waitCloseAllBusyIconsResults();
                    mcdLib.closeTheOpendCallInMCD();
                    diHome.clickToCloseProfileWindow();
                    //Go to the profile window
                    //Select the call and perform keyboard action
                    diHome.clickOnProfileMenu();
                    home.waitCloseAllBusyIconsResults();
                    diHome.clickOnProfileName(data.get("ProfileName"));
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    profileLib.selectACallOnProfileTab(secondCallIdAnddate);
                    // actions.keyDown(Keys.SHIFT).sendKeys(Keys.chord("8")).keyUp(Keys.SHIFT).perform();
                    String combineKeys = Keys.chord(Keys.SHIFT, "8");
                    sendKeys(combineKeys, "Shift + 8");
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(2000);
                    String etaWindowName = profileLib.getETAWindowNameOnProfileTab();
                    String expectedEtawindowName = data.get("ETAWindowName");
                    assertTrue(etaWindowName.contains(expectedEtawindowName), "Verified  the ETA window comes up after pressing number on call");
                    //Enter ETA time On Update ETA window
                    String expectedMinutes = data.get("ETAMinutes");
                    profileLib.enterETAMinutesOnETAUpdateWindow(expectedMinutes);
                    Thread.sleep(2000);
                    profileLib.clickOnContinueButtonOnETAUpdateWindow();
                    home.waitCloseAllBusyIconsResults();
                    diHome.searchAndClickOnCallIdOnProfileWindow(secondCallIdAnddate);
                    home.waitCloseAllBusyIconsResults();
                    //Some times  ETA Time populated only call is In ER Status on MCD Window. As discussed in call I am verifing this step with not equal to null.
                    String etaTimeFromMCDWindow = mcdLib.verifyETATimeOnMCDWindow();
                    // Expected failure,In Application ETA Time Is Not updated as expected,as discussed in call,Failing the step
                    //assertFalse(etaTimeFromMCDWindow!=null,"A.");
                    if (etaTimeFromMCDWindow != null)
                        reporter.failureReport("Verify call has been updated with entered ETA", "Verified that the call has not updated with entered ETA time", driver);

                    //Quick Truck Assignment
                    mcdLib.closeTheOpendCallInMCD();

                    //Go to the profile window
                    diHome.clickOnProfileMenu();
                    diHome.clickOnProfileName(data.get("ProfileName"));
                    home.waitCloseAllBusyIconsResults();
                    /*In Quick Truck Assignment: 19,20,21 steps skipped as discussed In call
                     *After Press a numeric key on RE call in Profile window ,expecting the below validation.But It is not performing as expected
                     * --Verify that the MCD status update panel opens with SP status populated and the numeric value that was entered shows on the Fac: fiel--.*/
                    //Select the call and perform keyboard action
                    profileLib.selectACallOnProfileTab(callIDAndDateCombinedFromCr);
                    //Actions action1 = new Actions(driver);
                    //profileLib.pressNumericKeyOnCallID(callIDAndDateCombinedFromCr);
                    //actions.keyDown(Keys.SHIFT).sendKeys(Keys.chord("8")).keyUp(Keys.SHIFT).perform();
                    //action.keyDown(Keys.SHIFT).sendKeys(NUMPAD8).keyUp(Keys.SHIFT).build().perform();
                    String combineKeys1 = Keys.chord(Keys.SHIFT, "8");
                    sendKeys(combineKeys1, "Shift + 8");
                    home.waitCloseAllBusyIconsResults();
                    List<String> truckList = profileLib.getTruckLoadList(callIDAndDateCombinedFromCr);
                    assertTrue(truckList != null, "Verified the truck List ,available trucks come up within the profile window.");
                    profileLib.selectTruckOnProfileWindow(callIDAndDateCombinedFromCr);
                    diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombinedFromCr);
                    home.waitCloseAllBusyIconsResults();
                    String actualAssignStatus = mcdLib.getCallStatusOnMCDwindow();
                    Thread.sleep(3000);
                    String truckID = mcdLib.getTruckIdFromMCDWindow();
                    Thread.sleep(2000);
                    String expectedAssignStatus = data.get("ASStatus");
                    assertTrue(actualAssignStatus.contains(expectedAssignStatus), "Verified the Status on MCD Widow & Status changed from  SP  To AS ");
                    mcdLib.closeTheOpendCallInMCD();
                    //Quick Truck Messaging:
                    diHome.clickOnTruckLoadTab();
                    if (data.get("DILoginName").contains("autospp1")) {
                        truckLoad.clickSPPdefaultTruckView();
                    } else {
                        diHome.clickOnTruckLoadDefaultOption();
                    }
                    home.waitCloseAllBusyIconsResults();
                    diHome.enterSpotFacilityIDInfoOnTruckLoad(facilityFromCR);
                    home.waitCloseAllBusyIconsResults();
                    truckLoad.clickTruckIDOfCallID(truckID);
                    //actions.sendKeys(String.valueOf('\u0061')).build().perform();
                    String combineKeys4 = Keys.chord("a");
                    sendKeys(combineKeys4,"a");
                    home.waitCloseAllBusyIconsResults();
                    String messageWindowName =truckLoad.getMessageWindowName();
                    String trucIdOnRecipientField = truckLoad.getTruckIDOnRecipientField();
                    assertTrue(trucIdOnRecipientField.equals(truckID),"Verify that the "+messageWindowName+"window comes up and the selected truck is on the recipient field.Selected truck is  "+trucIdOnRecipientField);




                    diHome.logOut();




                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                    reporter.failureReport("Execption Occured", "Execption Occured", driver);
                    reporter.warningReport("Error Description", " " + e.toString());

                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1828", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
    public String getCallIDAndDateFroMCDWindow()throws Throwable {
        Thread.sleep(3000);
        String CallDate = mcdLib.getCallDateFromMCD();
        String callDateArray[] = CallDate.split("/");
        String callMonth = callDateArray[0];
        String callDay = callDateArray[1];
        String callYear = callDateArray[2];
        String callIDateCombined = callYear + callMonth + callDay;
        String callID = mcdLib.getCallIdFromMcdWindow();
        callIDAndDateCombined = callIDateCombined + "-" + callID;
        return callIDAndDateCombined;
    }
    public Date getSystemTime()throws Throwable{
        String verificationTime = mcdLib.currentTime();
        //callIDAndDateCombined="20180327-20109";
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
        Date timeFromSystem = _12HourSDF.parse(verificationTime);
        return timeFromSystem;
    }
        public String[] getCallIDAndDate() throws Throwable {
            callIDCreated = services.getCallId();
            spotIDCreated = services.getSpotFacilityId();
            callDateCreated = services.getCallDate();
            callandfacilityId[0] = callIDCreated;
            callandfacilityId[1] = spotIDCreated;
            callandfacilityId[2] = callDateCreated;

            return callandfacilityId;
        }

    //Create call to verify Comments

    public void createCall(Hashtable<String,String > data) throws Throwable {
        try {
                    navigateToApplication("CR");
                    Thread.sleep(4000);
                    login.login(data.get("LoginName"), data.get("Password"));
                    crHomeLib.waitCloseAllBusyIconsResults();
                    crHomeLib.messageDialogBoxClose();
                    String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("Membersearch");
                    }

                    crHomeLib.memberSearchTextBox(Member);

                    crMemberSearchLib.memberNumClick();
                    Thread.sleep(2000);
                    crLocationsLib.breakdownLocTabSel();
                    //Enter Location Mandatory Fields
                    crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                    //To enter Vehicle Information
                    commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "", data.get("ProblemTriage"), data.get("ProblemType"));
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    crHomeLib.allErrorAlerts();
                    Thread.sleep(2000);
                    tow.clickOnTowDestinationTab();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    crVehicleTriageLib.scriptErrorHandle();
                    crHomeLib.allErrorAlerts();
                    Thread.sleep(3000);
                    tow.clickOnAARTowDetinationLink();
                    //tow.clickOnManualEntryLinkOnTowDestination();
                    tow.enterTowPassengers(data.get("TowPassengers"));
                    Thread.sleep(2000);
                    service.clickOnServiceTab();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    crHomeLib.allErrorAlerts();
                    service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
                    crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
                    facilityFromCR = service.validateFacilityAutospot();
                    crHomeLib.saveButton();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    getCallIDAndDate();
                    callID = service.getCallId();
                    callIDAndDateCombinedFromCr= callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                    service.closeCall();
                    crHomeLib.logout();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }

            }
        }
