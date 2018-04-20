package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by E003999 on 16-01-2018.
 */
public class TC_CRPTAScript extends LoginLib {


    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void pta(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "PTA", TestData, "D3CallRecieving");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("PTA", TestData, "D3CallRecieving", intCounter);

                    this.reporter.initTestCaseDescription("1724:CR_PTA" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRServiceLib service = new CRServiceLib();
                    CRSearchCallsLib searchCall = new CRSearchCallsLib();
                    LoginRoleLib loginRole = new LoginRoleLib();

                    home.verifyandClickLogout();
                    login(data.get("LoginName"), data.get("Password"));
                    home.verifyHomeScreen();
                    home.messageDialogBoxClose();
                    member.currentCallClose();
                    boolean ptaFlag = home.verifyPTAFlag();
                    assertTrue(ptaFlag, "PTA Flag appears with value of default PTA");
                    home.verifyPTAValue("Y");
                    String Member = "";

                    //Getting data from DB
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 100);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    }
                    if (Member.isEmpty()) {
                        Member = data.get("MemberSearch");
                    }

                    //Creating a new call to change the PTA Time
                    home.memberSearchTextBox(Member);
                    member.memberNumClick();
                    locations.clickOnLocationTab();
                    enterBreakDownLocation(data);
                    vehicle.selectVehicleModel();
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    service.clickOnServiceTab();

                    //Validating the Superoveride value with the PTA beside the PTA Flag
                    String superOverride = service.getSuperOverdidePTAValue();
                    assertTrue(superOverride.equalsIgnoreCase(home.verifyPTAValue("Value")), "Verified Super Override value");

                    //Validating if manual overide is 60 or not
                    String manualoverride = service.getManualOverdidePTAValue();
                    assertTrue(manualoverride.equalsIgnoreCase("60"), "Manual Override value is set to 60");

                    //Setting the manual overide value (currently 45 from data table)
                    service.setManualOverrideOnSpottedFacility(data.get("ManualOverrideValue"));
                    String combineKeys = Keys.chord(Keys.TAB);
                    sendKeys(combineKeys, "Tab");
                    assertTrue(home.verifyPTAValue("Value").equalsIgnoreCase(data.get("ManualOverrideValue")), "PTA is updated based on recalculated PTA");

                    home.saveButton();
                    service.clickOnRemainInCall();

                    //validating Pta on next screen has the PTA  minutes ahead from D3 callcreation time
                    String callCreationTimeFromD3 = searchCall.getTimeInSearchCall();
                    int timeAhead = Integer.parseInt(data.get("TimeAhead"));
                    String expectedPTATime = getFutureTime(callCreationTimeFromD3, timeAhead);
                    String actualPTATime = home.verifyPTAValue("Time");
                    assertTrue(expectedPTATime.contains(actualPTATime), "PTA on the next screen has the PTA 45 minutes from the time the call is saved");
                    home.logout();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("CR", "1724", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public void enterBreakDownLocation(Hashtable<String, String> data) throws Throwable {
        CRLocationsLib locations = new CRLocationsLib();
        locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
    }

    public String getFutureTime(String current, int timeAhead) throws ParseException {
        Date date1 = new SimpleDateFormat("HH:mm").parse(current);
        int addMinuteTime = timeAhead;
        Date targetTime = DateUtils.addMinutes(date1, addMinuteTime);
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
        System.out.println(_12HourSDF.format(targetTime));
        String time = _12HourSDF.format(targetTime).toString().substring(0,5);
        System.out.println(time);
        return time;

    }

}
