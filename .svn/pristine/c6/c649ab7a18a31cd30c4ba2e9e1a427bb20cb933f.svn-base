package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRMemberSearchPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 18-12-2017.
 */
public class TC_CRScratchPad extends LoginLib {


    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void scratchPad(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "scratchPad", TestData, "D3CallRecieving");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("scratchPad", TestData, "D3CallRecieving", intCounter);

                    this.reporter.initTestCaseDescription("1933: TC-CR Scratch Pad" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    navigateToApplication("CR");
                    home.verifyandClickLogout();
                    login(data.get("LoginName"), data.get("Password"));
                    home.verifyHomeScreen();
                    home.messageDialogBoxClose();
                    memeber.currentCallClose();
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

                    //verify scratch pad is displayed
                    memeber.verifyScratchPad();

                    //enter BreakdownLocation address in scratch pad
                    String enteredText = memeber.enterTextInScratchPad(data.get("BreakdownAddress"));

                    //verify eneterd text before in scratch pad is matched with after entering into scratch pad
                    assertTrue(enteredText.equalsIgnoreCase(memeber.getTextFromScratchPad().trim()), "Text in Scratchpad matched with text entered");
                    locations.clickOnLocationTab();

                    //drag and drop breakdown address from scratch pad to Breakdownlocation omnisearch bar
                    dragAndDropFromScratchPad();
                    click(CRMemberSearchPage.iconScratchPadClose,"Scrach Pad Close icon");

                    //As drag and drop is not working here .so,we have entered Break down address manually
                    locations.enterBreakDownAddressOmniBarSearch(data.get("Address"));

                    //enter vehicle details and pacesetter code
                    vehicle.vehicletriageTabsel();
                    vehicle.enterVehicleDetailsinSearchBar(data.get("vehicle"));
                    vehicle.clickOnFuel();
                    vehicle.clickOnOutOfGas();
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    vehicle.scriptErrorHandle();
                    Thread.sleep(3000);
                    service.clickOnServiceTab();

                    //save call
                    home.saveButton();
                    Thread.sleep(3000);
                    String callID = service.getCallId();
                    service.closeCall();

                    //verify scratched pad is cleared from text
                    click(CRMemberSearchPage.iconScratchPad, "Scratch Pad Icon");
                    assertTrue(memeber.getTextFromScratchPad().equalsIgnoreCase(""),"scratch pad is cleared of any text");
                    home.clickOnSearchCallDroupDown();
                    home.clickOnSearchCallsLink();

                    //searching for call id in search call menu
                    home.enterCallIdForSearch(callID);
                    home.clickOnSearchButtonOnSearchCalls();
                    home.clickOnCallIdOnSearchCalls();
                    Thread.sleep(10000);

                    //verify text before saving is loaded into scratch pad
                    assertTrue(memeber.getTextFromScratchPad().contains(data.get("BreakdownAddress")),"Text before saving is loaded into scratch pad");
                    home.logout();
                    System.out.println("Test completed");
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("CR", "1933", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public void dragAndDropFromScratchPad() throws Throwable {
        CRLocationsLib locations = new CRLocationsLib();
        //Below draganddropfunction is not working
        dragAndDrop(CRMemberSearchPage.txtScratchPad, CRLocationsPage.txtBrkDowLocSrch, "BreakdownLocation search bar");

    }
}

