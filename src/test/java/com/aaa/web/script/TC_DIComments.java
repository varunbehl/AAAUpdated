
package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;

public class TC_DIComments extends ActionEngine {
    int i=0;
    public static String callID;
    public static String facilify;
    //public static String verificationTime;
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public  String [] callandfacilityId = new String[3];
    LoginLib login = new LoginLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    CRServiceLib services = new CRServiceLib();
    CRHomeLib home = new CRHomeLib();
    DIProfileLib profileLib =  new DIProfileLib();
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

    //Create call to verify Comments
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void SaveCallForCommentsOnDispatch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
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
                //crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
                //crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
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
                //service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
                crHomeLib.allErrorAlerts();
                facilify = service.validateFacilityAutospot();
                crHomeLib.saveButton();
                crHomeLib.waitCloseAllBusyIconsResults();
                Thread.sleep(3000);
                getCallIDAndDate();
                callID = service.getCallId();
                service.closeCall();
                crHomeLib.logout();
                }
                catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "2025", ReportStatus.strMethodName, intCounter, browser);
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

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void commentsOnPoppedInAndPoppedOutMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //Navigate TO Dispatch
                    navigateToApplication("DI");
                    Thread.sleep(4000);
                    diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                    crHomeLib.waitCloseAllBusyIconsResults();
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnSearchCallsInDispatch();
                    //diHome.enterCallIDInfo("20109");
                    diHome.enterCallIDInfo(callID);
                    diHome.clickOnSearchInSearchCalls();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnCallDateOrIDLink();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    //Call Common Functionality To veryfy Added Canned Comments In popped In MCD Window
                    commonFunctionToVerifyAddedCannedComments(data);
                    boolean poppedOutButtonFlag = mcdLib.verifyPoppedOutButtonOnMCD();
                    //Verify Comments In Popped Out MCD Window
                    if (poppedOutButtonFlag) {
                        mcdLib.maximizeMCDWindow();
                        Thread.sleep(5000);
                        switchToWindow();
                        assertTrue(poppedOutButtonFlag, "MCD Window is PoppedOut");
                        assertTrue(poppedOutButtonFlag, "Verification Of Canned Comments in Popped Out MCD Window");
                        commonFunctionToVerifyAddedCannedComments(data);
                        assertTrue(poppedOutButtonFlag, "Verified the results in MCD Popped out and PoppedIn Window & Results are same");
                        mcdLib.minimizeMCDWindow();
                        //mcdLib.closeTheOpendCallInMCD();
                        switchToWindow();
                    }
                    diHome.logOut();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "2025", ReportStatus.strMethodName, intCounter, browser);
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

//comments Verification On Profile Window
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void dispatchCommentsOnProfileWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                        //NaviGate TO Dispatch
                        navigateToApplication("DI");
                        Thread.sleep(4000);
                        diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                        crHomeLib.waitCloseAllBusyIconsResults();
                        loginRole.clickOnProceedBtnInDispatchRoleLogin();
                        diHome.clickOnCloseIconOnQueueSelection();
                        //Canned Comments: Profile AND Truck
                        diHome.clickOnProfileMenu();
                        diHome.clickOnProfileName(data.get("ProfileName"));
                        //Thread.sleep(2000);
                        crHomeLib.waitCloseAllBusyIconsResults();
                        //callIDAndDateCombined="20180327-20070";

                        callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                        crHomeLib.waitCloseAllBusyIconsResults();
                        Thread.sleep(3000);
                        profileLib.rightClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                        crHomeLib.waitCloseAllBusyIconsResults();
                        profileLib.mouseHoverOnToComments(callIDAndDateCombined, data.get("Comments"));
                        profileLib.mouseHoverOntoAutoComment();
                        List listOfComments = profileLib.getCommentsListFromProfile();
                        Thread.sleep(2000);

                        crHomeLib.waitCloseAllBusyIconsResults();
                        String cannedComment1 = data.get("CannedComment1");
                        String cannedComment2 = data.get("CannedComment2");
                        boolean cannedCommentsFlag = mcdLib.verifyCannedCommentsInList(cannedComment1, cannedComment2, listOfComments);
                        assertTrue(cannedCommentsFlag, "Verified the comments OnProfile  & Comments matches with   " + cannedComment1 + "  " + cannedComment2);
                        profileLib.selectComment(data.get("CannedCommentOnProfile"));
                    String verificationTime = mcdLib.currentTime();
                    //callIDAndDateCombined="20180327-20109";
                    SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
                    Date timeFromSystem = _12HourSDF.parse(verificationTime);
                    Date targetTime = DateUtils.addMinutes(timeFromSystem, 2);
                    diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                    home.waitCloseAllBusyIconsResults();
                        boolean commentsFlag = mcdLib.commentVerificationWithTime(timeFromSystem,targetTime, data.get("CannedCommentOnProfile"));
                        assertTrue(commentsFlag, "Verified the comment & Canned Comment get inserted into the call with correct timestamp");
                        mcdLib.closeTheOpendCallInMCD();
                        diHome.logOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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

    //DI Comments On Truck
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void dispatchCommentsOnTruckLoad(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                            //NaviGate TO Dispatch
                            navigateToApplication("DI");
                            Thread.sleep(4000);
                            diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                            crHomeLib.waitCloseAllBusyIconsResults();
                            loginRole.clickOnProceedBtnInDispatchRoleLogin();
                            diHome.clickOnCloseIconOnQueueSelection();
                            diHome.clickOnTruckLoadTab();
                            diHome.clickOnTruckLoadDefaultOption();
                            crHomeLib.waitCloseAllBusyIconsResults();
                            diHome.enterSpotFacilityIDInfoOnTruckLoad(facilify);
                            //diHome.enterSpotFacilityIDInfoOnTruckLoad("5520");
                            //truckLoad.clickOnFacilityOnDefaultTruck("5520");
                            truckLoad.clickOnFacilityOnDefaultTruck(facilify);
                            crHomeLib.waitCloseAllBusyIconsResults();
                            //callIDAndDateCombined="20180327-20070";
                            callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                            diHome.dateDecendingOrder();
                            truckLoad.rightClickOnCallIDOnTruckLoad(callIDAndDateCombined);
                            //Thread.sleep(2000);
                            truckLoad.mouseHoverToCommentsOnTruckLoad(callIDAndDateCombined);
                            truckLoad.mouseHoverOntoAutoComment();
                            List listOfCommentsFroTruck = truckLoad.getCommentsListFromTruckLoad();
                            String cannedComment3 = data.get("CannedComment1");
                            String cannedComment4 = data.get("CannedComment2");
                            boolean truckcannedCommentsFlag = mcdLib.verifyCannedCommentsInList(cannedComment3, cannedComment4, listOfCommentsFroTruck);
                            assertTrue(truckcannedCommentsFlag, "Verified the comments "+cannedComment3+"  And  "+cannedComment4+" on TruckLoad, & Comments are available In CommentsList In Truck Load");
                            truckLoad.selectComment(data.get("CannedCommentTruck"));
                            String verificationTime = mcdLib.currentTime();
                            diHome.clickOnSearchCallsInDispatch();
                            diHome.enterCallIDInfo(callID);
                            //diHome.enterCallIDInfo("20070");
                            diHome.clickOnSearchInSearchCalls();
                            crHomeLib.waitCloseAllBusyIconsResults();
                            diHome.clickOnCallDateOrIDLink();
                            crHomeLib.waitCloseAllBusyIconsResults();
                    SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
                    Date timeFromSystem = _12HourSDF.parse(verificationTime);
                    Date targetTime = DateUtils.addMinutes(timeFromSystem, 2);
                            boolean truckcommentsFlag = mcdLib.commentVerificationWithTime(timeFromSystem,targetTime, data.get("CannedCommentTruck"));
                            assertTrue(truckcommentsFlag, "Verified the comment & Canned Comment get inserted into the call with correct timestamp");
                            mcdLib.closeTheOpendCallInMCD();
                            //diHome.logOut();
                            crHomeLib.logout();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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



    //Comments Manual Entry Cancel
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void manualEntryCancel(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                //NaviGate TO Dispatch
                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                crHomeLib.waitCloseAllBusyIconsResults();
                loginRole.clickOnProceedBtnInDispatchRoleLogin();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnSearchCallsInDispatch();
                diHome.enterCallIDInfo(callID);
                //diHome.enterCallIDInfo("20070");
                diHome.clickOnSearchInSearchCalls();
                crHomeLib.waitCloseAllBusyIconsResults();
                diHome.clickOnCallDateOrIDLink();
                crHomeLib.waitCloseAllBusyIconsResults();

                String addButtonName = mcdLib.getAddButtonName();
                String commentCountBeforeAddingComment = mcdLib.getCommentCountOnCommentSection();
                assertTrue(addButtonName!=null,"Verified the Add Button In Comments section,Button Name is  "+addButtonName);
                mcdLib.clickOnAddCommentsButton();
                String addCommentsScreenName = mcdLib.verifyTheAddCommentScreen();
                assertTrue(addCommentsScreenName!=null,"Veried the Add Comment screen,& Screen Name  is   "+addCommentsScreenName);
                boolean isAddCommentsScreenModal = mcdLib.verifyTheAddCommentsScreenAsModal();
                assertTrue(isAddCommentsScreenModal,"Verified the Add Comment screen ,Add Comment screen acts as modal (cannot edit any screens behind it).");

               // mcdLib.clickOnAddCommentsButton();
                mcdLib.enterComments(data.get("CommentsToTextArea"));
                mcdLib.clickOnCancelButtonOnAddCommentsScreen();
                String commentCountAfterAddingComment = mcdLib.getCommentCountOnCommentSection();
                boolean commentsCount = (commentCountBeforeAddingComment.equals(commentCountAfterAddingComment));
                assertTrue(commentsCount,"Verified the Comment Count, Count is not Incremented   ,::Count Before add Comment  is"+commentCountBeforeAddingComment+"    ::Count After Cancel the comment is  "+commentCountAfterAddingComment);
                boolean isAddCommentsWindowCloses = mcdLib.verifyAddCommentsWindowCloses();
                assertTrue(!isAddCommentsWindowCloses,"Verified the Add Comment window closes & Window closed after clicking on Cancel Button");
                //callIDAndDateCombined="20180220-20032";
                //callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                boolean commentsFlag = mcdLib.commentVerification(data.get("CommentsToTextArea"));
                assertTrue(commentsFlag, "Verified the Manually Entered comment &  Comment Not added in the Comments Section");
                mcdLib.closeTheOpendCallInMCD();
                diHome.logOut();

                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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


//ManualEntry Save
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void manualEntrySave(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                //NaviGate TO Dispatch
                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                crHomeLib.waitCloseAllBusyIconsResults();
                loginRole.clickOnProceedBtnInDispatchRoleLogin();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnSearchCallsInDispatch();
                diHome.enterCallIDInfo(callID);
                //diHome.enterCallIDInfo("20070");
                diHome.clickOnSearchInSearchCalls();
                crHomeLib.waitCloseAllBusyIconsResults();
                diHome.clickOnCallDateOrIDLink();
                crHomeLib.waitCloseAllBusyIconsResults();
                String commentCountBeforeAddingComment = mcdLib.getCommentCountOnCommentSection();
                mcdLib.clickOnAddCommentsButton();
                mcdLib.enterComments(data.get("CommentsToTextArea"));
                //String verificationTime = mcdLib.currentTime();
                mcdLib.clickOnSaveButton(); Thread.sleep(2000);
                String verificationTime = mcdLib.currentTime();
                boolean isAddCommentsWindowCloses = mcdLib.verifyAddCommentsWindowCloses();
                assertTrue(!isAddCommentsWindowCloses,"Verified the Add Comment window closes & Window closed after clicking on save Button");
                    SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
                    Date timeFromSystem = _12HourSDF.parse(verificationTime);
                    Date targetTime = DateUtils.addMinutes(timeFromSystem, 2);
                boolean commentsFlag = mcdLib.commentVerificationWithTime(timeFromSystem,targetTime, data.get("CommentsToTextArea"));
                assertTrue(commentsFlag, "Verified the comment & Comment added to the Comment Section");
                String commentCountAfterAddingComment = mcdLib.getCommentCountOnCommentSection();
                boolean commentsCount = (commentCountBeforeAddingComment.equals(commentCountAfterAddingComment));
                assertFalse(commentsCount,"Verified the Comment Count, Count is  Incremented by 1  ,::Count Before add Comment  is"+commentCountBeforeAddingComment+"    ::Count After Cancel the comment is  "+commentCountAfterAddingComment);
                assertTrue(commentsFlag, "Verified the Comment & Canned Comment get inserted into the call with correct Date And Time"+verificationTime);
                diHome.logOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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


    //Comments Length GreaterThan  250 Char
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void commentsOther(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                //NaviGate TO Dispatch
                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                crHomeLib.waitCloseAllBusyIconsResults();
                loginRole.clickOnProceedBtnInDispatchRoleLogin();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnSearchCallsInDispatch();
                diHome.enterCallIDInfo(callID);
                //diHome.enterCallIDInfo("20070");
                diHome.clickOnSearchInSearchCalls();
                crHomeLib.waitCloseAllBusyIconsResults();
                diHome.clickOnCallDateOrIDLink();
                crHomeLib.waitCloseAllBusyIconsResults();
                mcdLib.clickOnAddCommentsButton();
                mcdLib.enterComments(data.get("CommentsLengthGreaterThan250Char"));
                String commentsData = data.get("CommentsLengthGreaterThan250Char");
                String enteredComments = mcdLib.getEnteredCommentsInTextArea();
                boolean compareEnteredString  = !(enteredComments.length()==commentsData.length());
                assertTrue(compareEnteredString,"Verified The entered 250 characters,  System Didn't not allow to type any further after entering 250 characters.");
                mcdLib.clickOnSaveButton();
                Thread.sleep(2000);
                //Verification of Saved comments from MCD Comments Section
                String commntsFromCommentsSection = mcdLib.getCommentsFromCommentsSection();
                boolean commentslength = enteredComments.length()==commntsFromCommentsSection.length();
                assertTrue(commentslength,"verified  the Saved Comment , Comment contains 250 characters &Comments length is   :: "+enteredComments.length());
                mcdLib.closeTheOpendCallInMCD();
                diHome.logOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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

//Comments for VisibilityAndDelete
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void commentsForVisibilityAndDelete(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                //NaviGate TO Dispatch
                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                crHomeLib.waitCloseAllBusyIconsResults();
                loginRole.clickOnProceedBtnInDispatchRoleLogin();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnSearchCallsInDispatch();
                diHome.enterCallIDInfo(callID);
                //diHome.enterCallIDInfo("20070");
                diHome.clickOnSearchInSearchCalls();
                crHomeLib.waitCloseAllBusyIconsResults();
                diHome.clickOnCallDateOrIDLink();
                crHomeLib.waitCloseAllBusyIconsResults();
                mcdLib.editTheComments();
                String editComment = mcdLib.verifyEditCommentScreen();
                assertTrue(editComment!=null,"Verified the Edit Comment screen, :: Screen name is  "+editComment);
                mcdLib.clickOnCanceButtonOnEditCall();
                boolean iscancelButtonClose = mcdLib.visibilityOfAddButtonOnCommentsSection();
                assertTrue(iscancelButtonClose,"Edit screen Is Closed after Clicking on Cancel Button");
                mcdLib.editTheComments();
                mcdLib.changeTheStatusOfCommentsFromVisibleToHidden();
                mcdLib.clickOnSaveButtonOnEditCommentScreen();
                mcdLib.clickOnMinimizeOrMaximizeIcon();
                //callIDAndDateCombined="20180327-20070";
                callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                String hiddenStatus = mcdLib.hiddenCommentStatus(callIDAndDateCombined);
                assertTrue(hiddenStatus!=null,"Verified The Saved Comment And Comment is Hidden");
                mcdLib.closeTheOpendCallInMCD();

                diHome.logOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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

    //comments For ArchivedCall
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void commentsForArchivedCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                //NaviGate TO Dispatch
                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                crHomeLib.waitCloseAllBusyIconsResults();
                loginRole.clickOnProceedBtnInDispatchRoleLogin();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnSearchCallsInDispatch();
                crHomeLib.waitCloseAllBusyIconsResults();
                diSearchCalls.enterStartDate(data.get("StartDateOld"));
                String combineKeys2 = Keys.chord(Keys.TAB);
                sendKeys(combineKeys2, "Tab");
                diSearchCalls.enterEndDate(data.get("EndDateOld"));
                String combineKeys3 = Keys.chord(Keys.TAB);
                sendKeys(combineKeys3, "Tab");
                diHome.clickOnSearchInSearchCalls();
                crHomeLib.waitCloseAllBusyIconsResults();
                diHome.clickOnCallDateOrIDLink();
                crHomeLib.waitCloseAllBusyIconsResults();
                mcdLib.clickOnAddCommentsButton();
                mcdLib.clickOnCannedCommentsDroupDownLink();
                mcdLib.selectCannedComment(data.get("CannedCommentOnMCD"));
                String enteredComments = mcdLib.getEnteredCommentsInTextArea();
                mcdLib.clickOnSaveButton();
                    String verificationTime = mcdLib.currentTime();
                    //callIDAndDateCombined="20180213-20122";
                    SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
                    Date timeFromSystem = _12HourSDF.parse(verificationTime);
                    Date targetTime = DateUtils.addMinutes(timeFromSystem, 2);
                    boolean commentsFlag = mcdLib.commentVerificationWithTime(timeFromSystem,targetTime, data.get("CannedCommentOnMCD"));

                assertTrue(commentsFlag,"Verified the entered Comment & able to save comment to the Archived call");
                mcdLib.closeTheOpendCallInMCD();
                diHome.logOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
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

    public String[] getCallIDAndDate() throws Throwable {
            callIDCreated = services.getCallId();
            spotIDCreated = services.getSpotFacilityId();
            callDateCreated = services.getCallDate();
            callandfacilityId[0] = callIDCreated;
            callandfacilityId[1] = spotIDCreated;
            callandfacilityId[2] = callDateCreated;

            return callandfacilityId;
        }
            //Common function to verify the saved comments
            public void commonFunctionToVerifyAddedCannedComments (Hashtable < String, String > data)throws Throwable {

                mcdLib.clickOnAddCommentsButton();
                mcdLib.clickOnCannedCommentsDroupDownLink();
                List<String> cannedCommentList = mcdLib.getCannedCommentsList();
                String cannedComment1 = data.get("CannedComment1");
                String cannedComment2 = data.get("CannedComment2");
                boolean cannedCommentsFlag = mcdLib.verifyCannedCommentsInList(cannedComment1, cannedComment2, cannedCommentList);
                assertTrue(cannedCommentsFlag, "Verified the comments showing on the drop-down list & Comments matches with   " + cannedComment1 + " AND  " + cannedComment2);
                boolean alphabeticalOrder = mcdLib.verifyAlphabeticalOrderOfCannedComments(cannedCommentList);
                assertTrue(!alphabeticalOrder, "Verified the comments & Canned Comments are listed in alphabetical order");
                //mcdLib.clickOnCannedCommentsDroupDownLink();
                //Thread.sleep(2000);
                mcdLib.selectCannedComment(data.get("CannedCommentOnMCD"));
                Thread.sleep(3000);

                //Verify Comments In Popped Out MCD Window
                //Save button  locator is changing on page,so I am In first Iteration clickOnSaveButton() method works,In second Iteration clickOnSaveButtonOnPoppedOutWindow() will work
                if (i==0) {
                    mcdLib.clickOnSaveButton();
                }
                else{
                    mcdLib.clickOnSaveButtonOnPoppedOutWindow();
                }
                i++;
                String verificationTime = mcdLib.currentTime();
               // callIDAndDateCombined="20180327-20109";
                callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                SimpleDateFormat _12HourSDF = new SimpleDateFormat("HH:mm");
                Date timeFromSystem = _12HourSDF.parse(verificationTime);
                Date targetTime = DateUtils.addMinutes(timeFromSystem, 2);
                //String verifyTimeInbetween = targetTime.toString();
                boolean commentsFlag = mcdLib.commentVerificationWithTime(timeFromSystem,targetTime, data.get("CannedCommentOnMCD"));
                assertTrue(commentsFlag, "Verified the comment & Canned Comment get inserted into the call with correct timestamp");
            }
}


