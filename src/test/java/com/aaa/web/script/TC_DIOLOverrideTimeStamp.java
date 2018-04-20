package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class TC_DIOLOverrideTimeStamp extends ActionEngine {

    public static String callID;
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public String[] callandfacilityId = new String[3];
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


    //LogIn In to Dispatch
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void oLOverRideTimeStamp(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIOLOverrideTimeStamp", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIOLOverrideTimeStamp", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1760 : DI OL OverRideTimeStamp" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //NaviGate TO Dispatch
                    navigateToApplication("DI");
                    //Thread.sleep(3000);
                    diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                    crHomeLib.waitCloseAllBusyIconsResults();
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnSearchCallsInDispatch();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    //Search for OL Status Call
                    diSearchCalls.selectCallStatus(data.get("OLStatus"));
                    diHome.clickOnSearchInSearchCalls();
                    home.waitCloseAllBusyIconsResults();
                    boolean noRecordsFlag = diSearchCalls.visibilityOfRecordsOnSearchCalls();
                    if (!noRecordsFlag) {
                        diHome.clickOnCallDateOrIDLink();
                        crHomeLib.waitCloseAllBusyIconsResults();
                    } else {
                        //If No records found with OL status, This functionality will search for spotted call again and move the SP call status to OL.
                        diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
                        home.waitCloseAllBusyIconsResults();
                        diSearchCalls.selectCallStatus(data.get("SPStatus"));
                        diHome.clickOnSearchInSearchCalls();
                        home.waitCloseAllBusyIconsResults();
                        diHome.clickOnCallDateOrIDLink();
                        crHomeLib.waitCloseAllBusyIconsResults();
                        mcdLib.clickOnAssign();
                        mcdLib.selectSecondFacilityOnAssignTabInMCD();
                        mcdLib.selectDispatch();
                        mcdLib.selectEnroute();
                        mcdLib.selectEnroute();
                        mcdLib.selectEnrouteTime();
                        mcdLib.selectOnLocation();
                        home.waitCloseAllBusyIconsResults();
                    }

                    //Calling the common Functionality to verify OL Time Stamp On MCD Window
                    commonFunctionalityToVerifyOlTimeStampOnMCD(data);
                    boolean poppedOutButtonFlag = mcdLib.verifyPoppedOutButtonOnMCD();
                    //Verify the Ol Time Stamp In Popped Out MCD Window
                    if (poppedOutButtonFlag) {
                        mcdLib.maximizeMCDWindow();
                        Thread.sleep(5000);
                        switchToWindow();
                        reporter.SuccessReport("OL override time stamp In Popped Out Mode", "Verify the Ol override time stamp In Popped Out Mode");
                        commonFunctionalityToVerifyOlTimeStampOnMCD(data);
                        mcdLib.minimizeMCDWindow();
                        switchToWindow();
                    }
                    assertTrue(poppedOutButtonFlag, "Verified the results in MCD Popped out and PoppedIn Window & Results are same");
                    mcdLib.clickOnMCDCloseWindow();

                    //Verification On Profile Window
                    diHome.clickOnProfileMenu();
                    diHome.clickOnProfileName(data.get("ProfileName"));
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(7000);
                    String parentWindow = getWindowHandle();
                    //Before right click On Call Id Changing the setting on profile window to get recent calls on profile window
                    commonLib.resetProfileSettings();
                    profileLib.rightClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                    profileLib.selectFromContextMenu(callIDAndDateCombined, data.get("CallStatus"));
                    profileLib.selectFromContextMenu(data.get("ONLocation"));
                    profileLib.selectOverrideWithmenuItem();
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    String status = mcdLib.getCallStatusFromStatusUpdateTab();
                    if (status != null) {
                        assertTrue(status.contains(data.get("Status")), "The MCD window opened and auto populates the OL status ");
                        reporter.SuccessReport("The MCD window should open and auto populates the OL status and the date is in focus", "As discussed In the call,'date field is in focus' validation skipped In Step number 9");
                        mcdLib.closeTheOpendCallInMCD();

                        //Verification On Profile window popped out mode
                        profileLib.clickOnArrowPopTheProfile();
                        home.waitCloseAllBusyIconsResults();
                        switchToWindow();
                        //From the call track menu select call status > On Location > With Override Time
                        profileLib.rightClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                        profileLib.selectFromContextMenu(callIDAndDateCombined, data.get("CallStatus"));
                        profileLib.selectFromContextMenu(data.get("ONLocation"));
                        profileLib.selectOverrideWithmenuItem();
                        home.waitCloseAllBusyIconsResults();
                        profileLib.clickOnArrowPopTheProfile();
                        Thread.sleep(3000);
                        switchToWindow(parentWindow);
                        diHome.clickToCloseProfileWindow();
                        home.waitCloseAllBusyIconsResults();
                        String olStatus = mcdLib.getCallStatusFromStatusUpdateTab();
                        assertTrue(olStatus.contains(data.get("Status")), "The MCD window opened and auto populates the OL status ");
                        assertTrue(olStatus.contains(status), "Verified the results in profile window Popped out and PoppedIn Window & Results are same");
                        reporter.SuccessReport("The MCD window should open and auto populates the OL status and the date is in focus", "As discussed In the call,date is in focus validation skipped In Step number 9");
                        diHome.logOut();
                    }
                    diHome.logOut();
                }
                catch(Exception e)
                {
                        ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description"," "+e.toString());
                }
                    ReportControl.fnEnableJoin();
                    ReportStatus.fnUpdateResultStatus("DI","1760",ReportStatus.strMethodName,intCounter,browser);
                    fnCloseTest();
                    }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                        }
                        ReportControl.fnNextTestJoin(nextTestJoin);
        }


    public void commonFunctionalityToVerifyOlTimeStampOnMCD(Hashtable < String, String > data)throws  Throwable {

        //get PTA Time
        String ptaDateTime = mcdLib.getPtaTimeFromMCDWindow();
        //Spliting date and time
        String timeAndDate[] = ptaDateTime.split(" ");
        String ptaTime = timeAndDate[1];
        String callDate = timeAndDate[0];
        //get OL Time from mcd window
        String olTimeStamp = mcdLib.getOLTimeStampFromMCDWindow();
        //Converting OL Time stamp from String to Date
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
        Date olTimeInDateFormat = _12HourSDF.parse(olTimeStamp);
        //Adding one minutes to actual OL Time Stamp
        Date oLTimeStampInDateFormatafter = DateUtils.addMinutes(olTimeInDateFormat, 1);
        //Convert date format to String
        String twoMinutesOverOlTimeStamp = _12HourSDF.format(oLTimeStampInDateFormatafter);
        home.waitCloseAllBusyIconsResults();
        mcdLib.clickOnStatusUpdateTabOnMCDWindow();
        home.waitCloseAllBusyIconsResults();
        Thread.sleep(3000);
        //Enter OL Status ,Date And Time On StatusUpdate Tab On MCD
        mcdLib.enterStatusInStatusUpdateTab(data.get("OLStatus"));
        mcdLib.selectCurrentDateOnOverRideTimeStampSection(callDate);
        //To enter two minutes over actual OL Time Stamp
        mcdLib.enterOLTimeONOverRideTimeStampSection(twoMinutesOverOlTimeStamp);
        home.waitCloseAllBusyIconsResults();
        boolean isButtonVisible = mcdLib.clickOnUpdateButtonInStatusUpdateTab();
        home.waitCloseAllBusyIconsResults();
        if (isButtonVisible) {

            //Get OL Timestamp from MCD Window
            String newOLTimeStamp = mcdLib.getOLTimeStampFromMCDWindow();
            Date updatedOLTime = _12HourSDF.parse(newOLTimeStamp);

            assertTrue(olTimeInDateFormat.before(updatedOLTime), "Verified the OL Time On MCD Window after updating the time, The call received the new OL time stamp,  Old OL Time is ::   " + olTimeInDateFormat + " ,Updated OL Time is ::" + oLTimeStampInDateFormatafter);

            //Open status Historty Tab
            mcdLib.clickOnStatusHistoryLinkOnMCDWindow();
            home.waitCloseAllBusyIconsResults();
            mcdLib.clickOnPlusIconOfOLTimeOnStatusHistoty(twoMinutesOverOlTimeStamp);
            String actualComment = mcdLib.getCommentOfOLTimeOnstatusHistory();
            String expectedComment = data.get("OLTimeComment");
            assertTrue(actualComment.contains(expectedComment), "The new OL override time stamp is present along with a comment indicating that it was an override OL time ");

            //Close statusHistory Tab
            mcdLib.clickOnCloseIconOnHistoryStatus();
            home.waitCloseAllBusyIconsResults();

            //Repeting the above steps for timestamp before the call receving time
            mcdLib.clickOnStatusUpdateTabOnMCDWindow();
            home.waitCloseAllBusyIconsResults();
            home.waitCloseAllBusyIconsResults();
            Thread.sleep(3000);
            //enter OL Status
            mcdLib.enterStatusInStatusUpdateTab(data.get("OLStatus"));
            //To select  date
            String PTATimeAfterUpdate = commonLib.getPreviousDate(callDate);
            mcdLib.selectCurrentDateOnOverRideTimeStampSection(PTATimeAfterUpdate);


            //Convert PTA time in to Daye Formate
            Date ptaTimeInDateFormat = _12HourSDF.parse(ptaTime);
            //To get Callreceving before time
            Date PTATime = DateUtils.addMinutes(ptaTimeInDateFormat, -3);
            String OneMinutLessOfPTAStamp = _12HourSDF.format(PTATime);

            //To enter two minutes to actual OL Time Stamp
            mcdLib.enterOLTimeONOverRideTimeStampSection(OneMinutLessOfPTAStamp);
            home.waitCloseAllBusyIconsResults();
            mcdLib.clickOnUpdateButtonInStatusUpdateTab();
            home.waitCloseAllBusyIconsResults();
            String actualErrorMessage = service.getE268ErrorMessage();
            String expectedErrorMsg = data.get("ErrorMessageForOLTimeStampUpdate");
            assertTrue(actualErrorMessage.contains(expectedErrorMsg), "The Application Is  not allowing to enter an OL override time before the call received time. Showing the error message  : " + actualErrorMessage);
            mcdLib.clickOnErrorOkayButtonInMCDWindow();
        }else{
            reporter.failureReport("Update button should be visible to Override the timeStamp","Update button Is disabled On StatusUpdate Tab when login with SPP user ",driver);
        }
        //Get Call Date and CallId From MCD Window
                String CallDate = mcdLib.getCallDateFromMCD();
                String callDateArray[] = CallDate.split("/");
                String callMonth = callDateArray[0];
                String callDay = callDateArray[1];
                String callYear = callDateArray[2];
                String callIDateCombined = callYear + callMonth + callDay;
                String callID = mcdLib.getCallIdFromMcdWindow();
                callIDAndDateCombined = callIDateCombined + "-" + callID;



    }

}

