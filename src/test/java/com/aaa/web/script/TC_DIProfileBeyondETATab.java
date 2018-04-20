package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRServicePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 02-01-2018.
 */
public class TC_DIProfileBeyondETATab extends DILoginLib {
    public static String callID;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public String[] callandfacilityId = new String[3];
    public static String callIDCreated;
    public static String spotIDCreated;
    CRServiceLib services = new CRServiceLib();

    /************************************************************************
     * Script Name :-
     * Method Name :-
     * Module	  :- DI
     * Test Case ID:-
     * Script Date :-
     * Author      :-
     * @param StartRow
     * @param EndRow
     * @param nextTestJoin
     * @throws Throwable
     *************************************************************************/
    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void profileBeyondETATab(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "ProfileBeyondETATab", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {

                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("ProfileBeyondETATab", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1768: DI Profile Beyond ETA Tab" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DIProfileLib diProfileLib = new DIProfileLib();

                    //Selecting Profile Beyond ETA in Profile window
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Create an RE status Call
                    navigateToApplication("CR");
                    login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
                    home.messageDialogBoxClose();
                    String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("MemberNumber");
                    }
                    home.memberSearchTextBox(Member);
                    //home.memberSearchTextBox(data.get("MemberNumber"));
                    memeber.memberNumClick();
                    locations.clickOnLocationTab();
                    locations.enterTxtinBrkDowLocSrch(data.get("NoFacilityAddress"));
                    locations.brkDowLocSrchBtn();
                    locations.clickOnLocationResultsLink();
                    locations.enterBKDownLocCode(data.get("LocationCode"));
                    vehicle.selectVehicleModel();
                    vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
                    service.clickOnServiceTab();
                    home.saveButton();
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    //getCallIDAndDate();
                    callID = service.getCallId();
                    callDateCreated = service.getCallDate();
                    service.closeCall();
                    home.logout();
                    acceptAlert();
                    acceptAlert();

                    //DI
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    String callIDAndDateCombined = callDateCreated.replaceAll("-", "");
                    String statusForRE = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify RE Status not shown
                    assertTrue(!statusForRE.equalsIgnoreCase("RE"), "RE status call not shown in BeyondETA");
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Create a SP status Call
                    navigateToApplication("CR");
                    login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
                    home.messageDialogBoxClose();
                    home.memberSearchTextBox(Member);
                    memeber.memberNumClick();
                    locations.clickOnLocationTab();
                    locations.enterTxtinBrkDowLocSrch(data.get("BreakDownLocation"));
                    locations.brkDowLocSrchBtn();
                    locations.clickOnLocationResultsLink();
                    locations.enterBKDownLocCode(data.get("LocationCode"));
                    vehicle.selectVehicleModel();
                    vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
                    service.clickOnServiceTab();
                    home.saveButton();
                    callID = service.getCallId();
                    callDateCreated = service.getCallDate();
                    service.closeCall();
                    home.logout();
                    acceptAlert();
                    acceptAlert();

                    //DI
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    callIDAndDateCombined = callDateCreated.replaceAll("-", "");
                    String statusForSP = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify SP Status not shown
                    assertTrue(!statusForSP.equalsIgnoreCase("SP"), "SP status call not shown in BeyondETA");
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //set ETA time
                    diMCD.clickOnETAButtonOnMCDWindow();
                    diMCD.setTimeForETA();
                    //waiting for five  minutes
                    Thread.sleep(300000);
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    String statusAfterWait = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify SP Status not shown
                    assertTrue(!statusAfterWait.equalsIgnoreCase("SP"), "SP status call not shown in BeyondETA");
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //Changing call status to AS
                    diMCD.clickOnAssign();
                    diMCD.selectSecondFacilityOnAssignTabInMCD();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    String statusForAs = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify AS Status shown
                    //The data is not reflected here after clicking on assign button.Here,the step will be failed
                    assertTrue(statusForAs.equalsIgnoreCase("AS"), "AS status call shown in BeyondETA");
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //Changing call status to DI
                    diMCD.selectDispatch();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    String statusForDI = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify DI Status shown
                    //The data is not reflected here after clicking on Dispatch button.Here,the step will be failed
                    assertTrue(statusForDI.equalsIgnoreCase("DI"), "DI status call shown in BeyondETA");
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //select Enroute time
                    diMCD.selectEnroute();
                    diMCD.selectEnrouteTime();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    //verify ER Status not shown
                    assertTrue(diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined).equalsIgnoreCase(""), "Call should not show in BeyondETA");
                    //wait for six minutes
                    Thread.sleep(360000);
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    //verify ER Status shown
                    //The data is not reflected here also
                    assertTrue(diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined).equalsIgnoreCase("ER"), "ER status call shown in BeyondETA");
                    diHome.searchAndSelectCallIDInDI(callID);
                    //Changing call status to Decline(DC)
                    diMCD.clickOnStatusUpdateTabOnMCDWindow();
                    diMCD.enterStatusOnStatusUpdateTab(data.get("Status"));
                    diMCD.enterReasonOnStatusUpdateTab(data.get("Reason"));
                    diMCD.clickOnUpdate();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diProfileLib.BeyondETA();
                    //verify call not shown
                    assertTrue(diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined).equalsIgnoreCase(""), "Call should not show in BeyondETA");
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1768", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

    /************************************************************************
     * Script Name :-
     * Method Name :-
     * Module	  :- DI
     * Test Case ID:-
     * Script Date :-
     * Author      :-
     * @param StartRow
     * @param EndRow
     * @param nextTestJoin
     * @throws Throwable
     *************************************************************************/
    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void profileBeyondETATabOnPoppedOutWindow(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "ProfileBeyondETATab", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("ProfileBeyondETATab", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1768: DI Profile Beyond ETA Tab" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DIProfileLib diProfileLib = new DIProfileLib();

                    //Selecting Profile Beyond ETA in Profile window
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    diHome.clickToOpenPoppedOutWindow();
                    Thread.sleep(2000);
                    switchToWindow();
                    diProfileLib.CLoseProfileWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Create an RE status Call
                    navigateToApplication("CR");
                    login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
                    home.messageDialogBoxClose();
                    String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("MemberNumber");
                    }
                    home.memberSearchTextBox(Member);
                    //home.memberSearchTextBox(data.get("MemberNumber"));
                    memeber.memberNumClick();
                    locations.clickOnLocationTab();
                    locations.enterTxtinBrkDowLocSrch(data.get("NoFacilityAddress"));
                    locations.brkDowLocSrchBtn();
                    locations.clickOnLocationResultsLink();
                    locations.enterBKDownLocCode(data.get("LocationCode"));
                    vehicle.selectVehicleModel();
                    vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
                    service.clickOnServiceTab();
                    home.saveButton();
                    home.waitCloseAllBusyIconsResults();
                    callID = service.getCallId();
                    callDateCreated = service.getCallDate();
                    service.closeCall();
                    home.logout();
                    acceptAlert();
                    acceptAlert();

                    //DI
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    String callIDAndDateCombined = callDateCreated.replaceAll("-", "");
                    String statusForRE = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify RE Status not shown
                    assertTrue(!statusForRE.equalsIgnoreCase("RE"), "RE status call not shown in BeyondETA");
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diProfileLib.CLoseProfileWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Create a SP status Call
                    navigateToApplication("CR");
                    login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
                    home.messageDialogBoxClose();
                    home.memberSearchTextBox(Member);
                    memeber.memberNumClick();
                    locations.clickOnLocationTab();
                    locations.enterTxtinBrkDowLocSrch(data.get("BreakDownLocation"));
                    locations.brkDowLocSrchBtn();
                    locations.clickOnLocationResultsLink();
                    locations.enterBKDownLocCode(data.get("LocationCode"));
                    vehicle.selectVehicleModel();
                    vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
                    service.clickOnServiceTab();
                    home.saveButton();
                    callID = service.getCallId();
                    callDateCreated = service.getCallDate();
                    service.closeCall();
                    home.logout();
                    acceptAlert();
                    acceptAlert();

                    //DI
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    callIDAndDateCombined = callDateCreated.replaceAll("-", "");
                    String statusForSP = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify SP Status not shown
                    assertTrue(!statusForSP.equalsIgnoreCase("SP"), "SP status call not shown in BeyondETA");
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diProfileLib.CLoseProfileWindow();
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //set ETA time
                    diMCD.clickOnETAButtonOnMCDWindow();
                    diMCD.setTimeForETA();
                    //waiting for five  minutes
                    Thread.sleep(300000);
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    String statusAfterWait = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify SP Status not shown
                    assertTrue(!statusAfterWait.equalsIgnoreCase("SP"), "SP status call not shown in BeyondETA");
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //Changing call status to AS
                    diMCD.clickOnAssign();
                    diMCD.selectSecondFacilityOnAssignTabInMCD();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    String statusForAs = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify AS Status shown
                    assertTrue(statusForAs.equalsIgnoreCase("AS"), "AS status call shown in BeyondETA");
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //Changing call status to DI
                    diMCD.selectDispatch();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    String statusForDI = diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined);
                    //verify DI Status shown
                    assertTrue(statusForDI.equalsIgnoreCase("DI"), "DI status call shown in BeyondETA");

                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //select Enroute time
                    diMCD.selectEnroute();
                    diMCD.selectEnrouteTime();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    //verify ER Status not shown
                    assertTrue(diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined).equalsIgnoreCase(""), "Call should not show in BeyondETA");
                    //wait for six minutes
                    Thread.sleep(360000);
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    //verify ER Status shown
                    assertTrue(diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined).equalsIgnoreCase("ER"), "ER status call shown in BeyondETA");
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);
                    //Changing call status to Decline(DC)
                    diMCD.clickOnStatusUpdateTabOnMCDWindow();
                    diMCD.enterStatusOnStatusUpdateTab(data.get("Status"));
                    diMCD.enterReasonOnStatusUpdateTab(data.get("Reason"));
                    diMCD.clickOnUpdate();
                    diHome.clickOnProfileMenu();
                    diHome.clickOnParamUnderProfileMenu();
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.BeyondETA();
                    //verify call not shown
                    assertTrue(diProfileLib.getStatusForCallIDOnProfileBeyondETA(callID, callIDAndDateCombined).equalsIgnoreCase(""), "Call should not show in BeyondETA");
                    diHome.clickToOpenPoppedOutWindow();
                    switchToWindow();
                    diProfileLib.CLoseProfileWindow();
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();


                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1768", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }


}
