package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDStatusHistory extends ActionEngine {

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
    public void mcdStatusHistory(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIMCDStatusHistory", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMCDStatusHistory", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1816: DI MCD STATUS History" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRTowDestinationLib towdestination = new CRTowDestinationLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    CommonLib commonLib=new CommonLib();


                    navigateToApplication("CR");
                    login.login(data.get("LoginName"), data.get("Password"));
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
                        Member = data.get("Membersearch");
                    }
                    home.memberSearchTextBox(Member);
                    memeber.memberNumClick();

                    //enter prime phone type cellular
                    memeber.membContInfoEnterPrimPhoneTypeCellular();
                    //enter prime phone radio button
                    memeber.clickPrimRadioBtnRowOne();
                    memeber.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("Primaryphonenum1"));
                    locations.clickOnLocationTab();

                    //Enter break down location code
                    locations.enterBreakDownAddressOmniBarSearch(data.get("Address"));
                    vehicle.clickOnVehicleTriageTab();

                    //Enter vehicle details and pacesetter code
                    vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
                    vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    towdestination.clickOnTowDestinationTab();

                    //Enter tow destination address
                    towdestination.enterTowDestinationLocationFields(data.get("TowAddress"));
                    service.clickOnServiceTab();

                    //Enter facility and save call
                    service.enterManualSpotDetails(data.get("facilityNumber"));
                    towdestination.errorAlertHandlingBeforeEnterMandatoryFields();
                    home.saveButton();
                    home.allErrorAlerts();
                    String callID = service.getCallId();
                    service.closeCall();
                    home.logout();

                    //login to Dispatch
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    commonLib.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //search for a call id
                    diHome.searchAndSelectCallIDInDI(callID);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();

                    //verify status history screen is appeared
                    assertTrue(diMCD.verifyStatusHistoryScreen(),"Status History Screen Appeared");
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectBDStatus();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for BD status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("BD"), "Status update BD is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickOnStatusUpdateTab();
                    diMCD.clickOnStatusDropdownOnStatusUpdateTab();
                    diMCD.enterStatusOnStatusUpdateTab(data.get("SPStatus"));
                    diMCD.clickOnReasonDropdownOnStatusUpdateTab();
                    diMCD.enterReasonOnStatusUpdateTab(data.get("FSReason"));
                    diMCD.enterfacilityOnStatusUpdateWindow(data.get("NewFacilityID"));
                    diMCD.clickOnUpdate();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for SP status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("SP"), "Status update SP Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickOnStatusUpdateTab();
                    diMCD.enterStatusOnStatusUpdateTab(data.get("ASStatus"));
                    diMCD.clickOnReasonDropdownOnStatusUpdateTab();
                    diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
                    diMCD.enterTruckIDOnStatusUpdateTab(data.get("TruckID"));
                    diMCD.clickOnUpdate();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for AS status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("AS"), "Status update AS Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectDispatch();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for DI status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("DI"), "Status update DI Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();

                    //set ETA time
                    diMCD.selectEnroute();
                    diMCD.selectEnrouteTime();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for ER status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("ER"), "Status update ER Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.getETAOnStatusHistory();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectOnLocation();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for OL status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("OL"), "Status update OL Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickOnTW();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for TW status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("TW"), "Status update TW Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();

                    //clear the call
                    diMCD.selectClearCall();
                    diMCD.selectExitCode();
                    diMCD.enterReason(data.get("Reason"));
                    String combineKeys = Keys.chord(Keys.TAB);
                    sendKeys(combineKeys, "Tab");
                    diMCD.clickOnSubmitButton();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for CL status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("CL"), "Status update CL Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);
                    diMCD.clickOnETAButtonOnMCDWindow();
                    diMCD.setTimeForETA();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();
                    diMCD.getDateOnStatusHistory();

                    //verifying for ET update code and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("ET"),"Update for ET is shown");
                    diMCD.getUserOnStatusHistory();
                    diMCD.getRoleOnStatusHistory();
                    diMCD.getAppOnStatusHistory();
                    diMCD.getLocationOnStatusHistory();
                    diMCD.getETAOnStatusHistory();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusUpdateTab();

                    //select UP status and enter comments
                    diMCD.enterStatusOnStatusUpdateTab(data.get("UPStatus"));
                    diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
                    diMCD.enterCommentsOnStatusUpdateTab(data.get("Comments"));
                    diMCD.clickOnUpdate();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for UP update code and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("UP"),"Update for UP is shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnPlusButtonOnStatusHistoryTab();
                    String comments = diMCD.verifyCommentsFromStatusHistoryTab();
                    //verify comments are displayed
                    assertTrue(comments.equalsIgnoreCase(data.get("Comments")), "Comments Entered");
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);
                    diMCD.selectClearCall();

                    //cancel call with no service
                    diMCD.selectCancelinClearCall();
                    diMCD.selectServiceNotEnroute();
                    diMCD.clickOnSubmitButton();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();


                    //verifying for CL update code and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("CL"),"Update for Cancel is shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickAckOnMCDwindow();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for ACK update code and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("AK"),"Update for ACK is shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(4000);

                    //Decline the call
                    diMCD.clickOnDeclineButton();
                    diMCD.clickOnCommentsRequiredFordeclineCallOnMCD();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();


                    //verifying for DC update code and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("DC"), "Status update DC Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1818", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }


    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void mcdStatusHistoryOnPoppedOutWindow(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIMCDStatusHistory", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMCDStatusHistory", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1816: DI MCD STATUS History" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");


                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRTowDestinationLib towdestination = new CRTowDestinationLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    CommonLib commonLib=new CommonLib();


                    navigateToApplication("CR");
                    login.login(data.get("LoginName"), data.get("Password"));
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
                        Member = data.get("Membersearch");
                    }
                    home.memberSearchTextBox(Member);
                    memeber.memberNumClick();

                    //enter prime phone type cellular
                    memeber.membContInfoEnterPrimPhoneTypeCellular();
                    //enter prime phone radio button
                    memeber.clickPrimRadioBtnRowOne();
                    memeber.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("Primaryphonenum1"));
                    locations.clickOnLocationTab();

                    //Enter break down location
                    locations.enterBreakDownAddressOmniBarSearch(data.get("Address"));
                    vehicle.clickOnVehicleTriageTab();

                    //Enter vehicle details and pacesetter code
                    vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
                    vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    towdestination.clickOnTowDestinationTab();

                    //Enter tow destination address
                    towdestination.enterTowDestinationLocationFields(data.get("TowAddress"));
                    service.clickOnServiceTab();

                    //Enter facility and save the call
                    service.enterManualSpotDetails(data.get("facilityNumber"));
                    towdestination.errorAlertHandlingBeforeEnterMandatoryFields();
                    home.saveButton();
                    home.allErrorAlerts();
                    String callID = service.getCallId();
                    service.closeCall();
                    home.logout();

                    //Login to Dispatch
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    commonLib.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //search for  a call id
                    diHome.searchAndSelectCallIDInDI(callID);
                    diMCD.maximizeMCDWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();

                    //verify status history screen is appeared
                    assertTrue(diMCD.verifyStatusHistoryScreen(),"Status History Screen Appeared");
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectBDStatus();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for BD status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("BD"), "Status update BD Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickOnStatusUpdateTab();
                    diMCD.clickOnStatusDropdownOnStatusUpdateTab();
                    diMCD.enterStatusOnStatusUpdateTab(data.get("SPStatus"));
                    diMCD.clickOnReasonDropdownOnStatusUpdateTab();
                    diMCD.enterReasonOnStatusUpdateTab(data.get("FSReason"));
                    diMCD.enterfacilityOnStatusUpdateWindow(data.get("NewFacilityID"));
                    diMCD.clickOnUpdate();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for SP status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("SP"), "Status update SP Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickOnStatusUpdateTab();
                    diMCD.enterStatusOnStatusUpdateTab(data.get("ASStatus"));
                    diMCD.clickOnReasonDropdownOnStatusUpdateTab();
                    diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
                    diMCD.enterTruckIDOnStatusUpdateTab(data.get("TruckID"));
                    diMCD.clickOnUpdate();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for AS status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("AS"), "Status update AS Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectDispatch();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for DI status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("DI"), "Status update DI Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectEnroute();
                    diMCD.selectEnrouteTime();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for ER status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("ER"), "Status update ER Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.getETAOnStatusHistory();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectOnLocation();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for OL status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("OL"), "Status update OL Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.clickOnTW();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for TW status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("TW"), "Status update TW Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    diMCD.selectClearCall();
                    diMCD.selectExitCode();
                    diMCD.enterReason(data.get("Reason"));
                    String combineKeys = Keys.chord(Keys.TAB);
                    sendKeys(combineKeys, "Tab");
                    diMCD.clickOnSubmitButton();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for CL status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("CL"), "Status update CL Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);

                    //set ETA time
                    diMCD.clickOnETAButtonOnMCDWindow();
                    diMCD.setTimeForETA();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for ET update code and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("ET"),"Update for ET is shown");
                    diMCD.getDateOnStatusHistory();
                    diMCD.getUpdateCodeOnStatusHistory();
                    diMCD.getUserOnStatusHistory();
                    diMCD.getRoleOnStatusHistory();
                    diMCD.getAppOnStatusHistory();
                    diMCD.getLocationOnStatusHistory();
                    diMCD.getETAOnStatusHistory();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);
                    diMCD.clickOnStatusUpdateTab();

                    //Entering UP update with comments
                    diMCD.enterStatusOnStatusUpdateTab(data.get("UPStatus"));
                    diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
                    diMCD.enterCommentsOnStatusUpdateTab(data.get("Comments"));
                    diMCD.clickOnUpdate();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();

                    //verifying for UP status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("UP"),"Update for UP is shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnPlusButtonOnStatusHistoryTab();
                    String comments = diMCD.verifyCommentsFromStatusHistoryTab();
                    assertTrue(comments.equalsIgnoreCase(data.get("Comments")), "Comments Entered");
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);
                    diMCD.selectClearCall();

                    //cancelling a call without any service
                    diMCD.selectCancelinClearCall();
                    diMCD.selectServiceNotEnroute();
                    diMCD.clickOnSubmitButton();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();


                    //verifying for CL status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("CL"),"Update for Cancel is shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);
                    diMCD.clickAckOnMCDwindow();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();


                    //verifying for ACK status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("AK"),"Update for ACK is shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.clickOnCloseIconOnHistoryStatus();
                    Thread.sleep(3000);

                    //Decling a call
                    diMCD.clickOnDeclineButton();
                    diMCD.clickOnCommentsRequiredFordeclineCallOnMCD();
                    Thread.sleep(4000);
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();


                    //verifying for DC status update and all the other feilds are dispalyed on status history screen
                    assertTrue(diMCD.getStatusCodeOnStatusHistory().equalsIgnoreCase("DC"), "Status update DC Is Shown");
                    verifyStatusHistoryScreenUpdates();
                    diMCD.minimizeMCDWindow();
                    switchToWindow();
                    Thread.sleep(5000);
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();


                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1818", ReportStatus.strMethodName, intCounter, browser);
            fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public void verifyStatusHistoryScreenUpdates() throws Throwable {
        DIMCDLib diMCD = new DIMCDLib();
        diMCD.getDateOnStatusHistory();
        diMCD.getUpdateCodeOnStatusHistory();
        diMCD.getReasonCodeOnStatusHistory();
        diMCD.getFacilityAndTruckIdOnStatusHistory();
        diMCD.getUserOnStatusHistory();
        diMCD.getRoleOnStatusHistory();
        diMCD.getAppOnStatusHistory();
        diMCD.getLocationOnStatusHistory();
    }
}
