package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by E003999 on 17-01-2018.
 */
public class TC_CRETA extends LoginLib {

    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void eta(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "ETA", TestData, "D3CallRecieving");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("ETA", TestData, "D3CallRecieving", intCounter);

                    this.reporter.initTestCaseDescription("1725:CR_ETA" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
                    navigateToApplication("CR");
                    home.verifyandClickLogout();
                    login(data.get("LoginName"), data.get("Password"));
                    home.verifyHomeScreen();
                    home.messageDialogBoxClose();
                    member.currentCallClose();
                    String Member = "";
                    //Getting data from DB
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("MemberSearch");
                    }
                    //Creating a new call to send a ETA Request
                    home.memberSearchTextBox(Member);
                    member.memberNumClick();
                    locations.clickOnLocationTab();
                    locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
                    //enterBreakDownLocation(data);
                    vehicle.selectVehicleModel();
                    service.clickOnServiceTab();
                    home.saveButton();
                    Thread.sleep(3000);
                    String callID = service.getCallId();
                    service.closeCall();
                    home.verifyandClickLogout();
                    login(data.get("LoginName"), data.get("Password"));
                    home.messageDialogBoxClose();
                    member.clickOnPartialCallCloseButton();

                    //Searching for callid in call search window
                    crSearchCall.clickOnSearchCalls();
                    crSearchCall.clickOnClearOnSearchCallsWindow();
                    crSearchCall.enterCallIdOnSearchCallsWindow(callID);
                    crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
                    crSearchCall.clickOnCallIdDateOnSearchCallsWindow();
                    Thread.sleep(10000);
                    crSearchCall.clickOnCurrentCallsDropDown();
                    Thread.sleep(10000);
                    crSearchCall.clickOnSendETARequestLink();
                    openURLInNewWindow("https://qaautoap1.national.aaa.com:8443/D3Dispatch/login.jsp");
                    switchToWindow();

                    //Login to D3 Dispatch
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();

                    //Verifying message popup requesting for ETA
                    boolean messagePopup = diHome.verifyHyperLinkOnMessagePopup();
                    assertTrue(messagePopup, "Message popup Requesting ETA is Appeared");

                    //Verfiying for ET status
                    assertTrue(diHome.verifyETStatusOnMessagePopup().equalsIgnoreCase("ET"), "Call Status Changed to ET");
                    diHome.clickOnCallIDOfMessagePopUp(callID);
                    diMCD.clickOnETAButtonOnMCDWindow();

                    //setting time for ETA
                    diMCD.setTimeForETA();
                    String etaOnMCD = diMCD.verifyETATimeOnMCDWindow();
                    diHome.clickOnMessagePopUpButton();
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    diHome.logOut();
                    closeWindow();
                    switchToWindow();

                    //verifying the call's ETA has been updated on message popup
                    assertTrue(home.verifyPopupMessageForETAUpdate().contains("The call's ETA has been updated"), "Messsage Popup Says the ETA has been updated");
                    String etaOnCRHome = home.verifyETATime();
                    //Here converting etaOnCRHome from 12Hrs format to 24Hrs format
                    SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
                    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
                    Date date = parseFormat.parse(etaOnCRHome);
                    String twentyFourHrsFormatFromCrHome=displayFormat.format(date);

                    //verifying whether ETA time updated on Call Receiving
                    assertTrue(twentyFourHrsFormatFromCrHome.contains(etaOnMCD), "ETA Time is updated");
                    home.verifyandClickLogout();

                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("CR", "1725", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

}
