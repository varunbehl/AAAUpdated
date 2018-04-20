package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMCDStatusUpdatesManual extends ActionEngine {
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
    public void mcdStatusUpdate(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIMCDStatusUpdateManual", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMCDStatusUpdateManual", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1796: DI MCD STATUS UPDATE MANUAL" + " From Iteration " + StartRow + " to " + EndRow);
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

                    //Getting an callId from call receiving for updating status on popped-in mode
                    String callID1 = enterIntoNewTowCall(data);
                    navigateToApplication("DI");

                    //Login to D3 Dispatch
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    commonLib.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID1);

                    //updating status on popped in mode
                    enterStatusUpdatesManually(data);
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Getting an callId from call receiving for cancelling call popped-in mode
                    String callID2 = enterIntoNewTowCall(data);
                    navigateToApplication("DI");

                    //Login to D3 Dispatch
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    commonLib.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID2);

                    //cancelling call popped-in mode
                    verifyCancelCall(data);
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Getting an callId from call receiving for updating status on popped-out mode
                    String callID3 = enterIntoNewTowCall(data);
                    navigateToApplication("DI");

                    //Login to D3 Dispatch
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    commonLib.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID3);
                    diMCD.maximizeMCDWindow();
                    Thread.sleep(5000);
                    switchToWindow();

                    //updating status on popped-out mode
                    enterStatusUpdatesManually(data);
                    diMCD.minimizeMCDWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //Getting an callId from call receiving for cancelling call popped-out mode
                    String callID4 = enterIntoNewTowCall(data);
                    navigateToApplication("DI");

                    //Login to D3 Dispatch
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    commonLib.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();


                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID4);
                    diMCD.maximizeMCDWindow();
                    Thread.sleep(5000);
                    switchToWindow();

                    //cancelling call popped-out mode
                    verifyCancelCall(data);
                    diMCD.minimizeMCDWindow();
                    switchToWindow();
                    Thread.sleep(5000);
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();
                    System.out.println("Test completed");
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1796", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }


    public void enterStatusUpdatesManually(Hashtable<String, String> data) throws Throwable {
        DIHomeLib diHome = new DIHomeLib();
        DIMCDLib diMCD = new DIMCDLib();
        DILoginLib diLogin = new DILoginLib();

        //verify call status in SP
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("SP"), "Call Status is SP");
        Thread.sleep(3000);
        String facilityBefore = diMCD.getFacilityIDAndNameOnSummaryTabOfMCDWindow();
        diMCD.clickOnStatusUpdateTab();

        //verify all fields on status update tab are displayed
        boolean statusDropDown = diMCD.verifyDropDownButtonOfStatusOnStatusUpdateTab();
        assertTrue(statusDropDown, "Status dropdown is available");
        boolean reason = diMCD.verifyReasonTextBoxOnStatusUpdateTab();
        assertTrue(reason, "Reason Field is available");
        boolean facility = diMCD.verifyFacilityTextBoxOnStatusUpdateTab();
        assertTrue(facility, "Facility Field is available");
        boolean truck = diMCD.verifyTruckTextBoxOnStatusUpdateTab();
        assertTrue(truck, "Truck Field is available");
        boolean zone = diMCD.verifyZoneTextBoxOnStatusUpdateTab();
        assertTrue(zone, "Zone Field is available");
        boolean tech = diMCD.verifyTechTextBoxOnStatusUpdateTab();
        assertTrue(tech, "Tech Field is available");
        boolean eta = diMCD.verifyETATextBoxOnStatusUpdateTab();
        assertTrue(eta, "eta Field is available");
        boolean date = diMCD.verifyDateTextBoxOnStatusUpdateTab();
        assertTrue(date, "Date Field is available");
        boolean time = diMCD.verifyTimeTextBoxOnStatusUpdateTab();
        assertTrue(time, "Time Field is available");
        boolean Comments = diMCD.verifyCommentsOnStatusUpdateTab();
        assertTrue(Comments, "Comments Field is available");
        boolean update = diMCD.verifyUpdateButtoOnStatusUpdateTab();
        assertTrue(update, "update buttonis available");
        boolean cancel = diMCD.verifyCancelButtoOnStatusUpdateTab();
        assertTrue(cancel, "Cancel button is available");

        //click and select SP
        diMCD.clickOnStatusDropdownOnStatusUpdateTab();
        diMCD.verifyListOfStatusOnMCD();
        diMCD.enterStatusOnStatusUpdateTab(data.get("SPStatus"));

        //click and select FS
        diMCD.clickOnReasonDropdownOnStatusUpdateTab();
        diMCD.verifyListOfReasonsOnMCD();
        diMCD.enterReasonOnStatusUpdateTab(data.get("FSReason"));

        //update new facility
        diMCD.enterfacilityOnStatusUpdateWindow(data.get("NewFacilityID"));
        diMCD.clickOnUpdate();
        Thread.sleep(3000);

        //step to verify new facility entered
        String facilityAfter = diMCD.getFacilityIDAndNameOnSummaryTabOfMCDWindow();
        assertTrue(facilityBefore != facilityAfter, "New Facility is Updated");
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("SP"), "Call status stayed in SP");
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();

        //select AS status
        diMCD.enterStatusOnStatusUpdateTab(data.get("ASStatus"));
        diMCD.clickOnReasonDropdownOnStatusUpdateTab();
        diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
        diMCD.clickOnUpdate();

        //verify no truck error message
        assertTrue(diMCD.verifyNoTruckErrorMessage().contains("truck are required"), "Verify truck update is required");
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("SP"), "Call status stayed in SP");

        //enter truck id
        diMCD.enterTruckIDOnStatusUpdateTab(data.get("TruckID"));
        diMCD.clickOnUpdate();
        Thread.sleep(3000);

        //verify call status for AS
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("AS"), "Call status is in AS");
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();

        //select DI status
        diMCD.enterStatusOnStatusUpdateTab(data.get("DIStatus"));
        diMCD.clickOnReasonDropdownOnStatusUpdateTab();
        diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
        diMCD.clickOnUpdate();
        Thread.sleep(3000);
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("DI"), "Call status is in DI");
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();

        //select DI status
        diMCD.enterStatusOnStatusUpdateTab(data.get("ERStatus"));

        //verify Reason dropdown is grayed out
        boolean reasonDrpdwnForER = diMCD.verifyReasonDropdownIsGrayedOutOnStatusTab();
        assertTrue(reasonDrpdwnForER, "Reason Dropdown is grayed out For ER");
        diMCD.clickOnUpdate();

        //verify ETA mandatory field alert
        boolean etaAlert = diMCD.verifyETAAlertOnStatusTab();
        assertTrue(etaAlert, "ETA Mandatory Field Alert");

        //Enter ETA
        diMCD.enterETATimeOnStatusUpdateTab(data.get("ETATime"));
        diMCD.clickOnUpdate();
        Thread.sleep(3000);
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("ER"), "Call status is in ER");
        diMCD.verifyETAIsUpdatedOnMCDWindow();
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();

        //select OL status
        diMCD.enterStatusOnStatusUpdateTab(data.get("OLStatus"));
        Thread.sleep(3000);
        boolean reasonTextBoxForOL = diMCD.verifyReasonDropdownIsGrayedOutOnStatusTab();
        assertTrue(reasonTextBoxForOL, "Reason is grayed out For OL");
        diMCD.clickOnUpdate();
        Thread.sleep(3000);
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("OL"), "Call status is in OL");
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();

        //select TW status
        diMCD.enterStatusOnStatusUpdateTab(data.get("TWStatus"));
        Thread.sleep(3000);
        boolean reasonTextBoxForTW = diMCD.verifyReasonDropdownIsGrayedOutOnStatusTab();
        assertTrue(reasonTextBoxForTW, "Reason is grayed out For TW");
        diMCD.clickOnUpdate();
        Thread.sleep(3000);
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("TW"), "Call status is in TW");
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();

        //select CL status
        diMCD.enterStatusOnStatusUpdateTab(data.get("CLStatus"));
        diMCD.clickOnReasonDropdownOnStatusUpdateTab();
        diMCD.enterReasonOnStatusUpdateTab(data.get("01Reason"));
        diMCD.clickOnUpdate();
        diMCD.clickOnNoGo();
        diMCD.selectExitCode();
        diMCD.clickOnContinue();
        diMCD.clickOnOriginalTowDestination();
        diMCD.clickOnContinue();
        Thread.sleep(5000);
        diMCD.clickOnSubmitButton();
        Thread.sleep(3000);
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("CL"), "Call status is in CL");

    }

    //This method is used to cancel a call
    public void verifyCancelCall(Hashtable<String, String> data) throws Throwable {
        DIHomeLib diHome = new DIHomeLib();
        DIMCDLib diMCD = new DIMCDLib();
        DILoginLib diLogin = new DILoginLib();
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("SP"), "Call status is in SP");
        Thread.sleep(3000);
        diMCD.clickOnStatusUpdateTab();
        diMCD.enterStatusOnStatusUpdateTab(data.get("UPStatus"));
        diMCD.enterReasonOnStatusUpdateTab(data.get("X1Reason"));
        diMCD.enterCommentsOnStatusUpdateTab(data.get("Comments"));
        Thread.sleep(2000);
        diMCD.clickOnUpdate();
        Thread.sleep(5000);

        //verify call status is in CA
        assertTrue(diMCD.getCallStatusOnMCDwindow().contains("CA"), "Call status is in CA");
        Thread.sleep(3000);
        diMCD.clickOnStatusHistoryLinkOnMCDWindow();

        //verify status for UP
        assertTrue(diMCD.getStatusFromStatusHistoryTab().contains("UP"), "updated status is UP");
        assertTrue(diMCD.getReasonFromStatusHistoryTab().contains("X1"), "Reason is X1");
        diMCD.clickOnPlusIconInStatusHistoryTab();
        String comments = diMCD.verifyCommentsFromStatusHistoryTab();

        //verify comments
        assertTrue(comments.equalsIgnoreCase(data.get("Comments")), "Comments Entered");

    }


    //This method is used to create a call with tow in call receiving
    public String enterIntoNewTowCall(Hashtable<String, String> data) throws Throwable {

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

        navigateToApplication("CR");
        home.verifyandClickLogout();
        login.login(data.get("LoginName"), data.get("Password"));
        home.verifyHomeScreen();
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
        memeber.memberNumClick();

        memeber.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("Primaryphonenum1"));
        //enter prime phone type cellular
        memeber.membContInfoEnterPrimPhoneTypeCellular();
        //enter prime phone radio button
        memeber.clickPrimRadioBtnRowOne();

        locations.clickOnLocationTab();
        locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
        enterVehicleDetailsInVehicleTraige(data);
        vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
        Thread.sleep(2000);
        vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
        vehicle.handleScriptErrorInVehicleTriagePage();
        towdestination.clickOnTowDestinationTab();
        towdestination.enterTowDestinationLocationFields(data.get("TowAddress"));
        service.clickOnServiceTab();

        //Enter facility
        service.enterManualSpotDetails(data.get("facilityNumber"));
        towdestination.errorAlertHandlingBeforeEnterMandatoryFields();
        home.saveButton();
        home.waitCloseAllBusyIconsResults();
        //home.allErrorAlerts();
        Thread.sleep(5000);
        String callIDTow = service.getCallId();
        service.closeCall();
        home.logout();
        return callIDTow;
    }

    public void enterVehicleDetailsInVehicleTraige(Hashtable<String, String> data) throws Throwable {
        CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
        vehicle.clickOnVehicleTriageTab();
        vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
    }

}
