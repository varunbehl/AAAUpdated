package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 12-01-2018.
 */
public class TC_SPPMCDDataPoints extends DILoginLib {
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
    public void TC_SPPMCDDataPoints(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "SPPMCDDataPoints", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("SPPMCDDataPoints", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1793: SPP MCD Data Points" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
                    CRServiceLib services = new CRServiceLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRLocationsLib location = new CRLocationsLib();
                    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
                    CRTowDestinationLib tow = new CRTowDestinationLib();

                    home.verifyandClickLogout();
                    navigateToApplication("CR");
                    login(dataBean.getValue(data, "CrLogin"), dataBean.getValue(data, "CrPassword"));
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
                    //home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
                    member.memberNumClick();
                    //Enter primary phone number
                    member.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "phoneNumber"));
                    //enter prime phone type
                    member.membContInfoEnterPrimPhoneTypeCellular();
                    //enter prime phone radio button
                    member.clickPrimRadioBtnRowOne();

                    //Enter breakdown location address
                    location.clickOnLocationTab();
                    location.enterBreakDownAddressOmniBarSearch(data.get("address"));

                    //Enter vehicle model and pacesetter code
                    crVehicleTriageLib.clickOnVehicleTriageTab();
                    crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType7"));
                    crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
                    crVehicleTriageLib.scriptErrorHandle();
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

                    //Enter the tow destination
                    tow.clickOnTowDestinationTab();
                    crVehicleTriageLib.scriptErrorHandle();
                    tow.clickOnManualEntryLinkOnTowDestination();
                    tow.enterTowLocationName(data.get("TDLocationAddress"));
                    tow.enterStreetAddressNo(data.get("TDAddress1"));
                    tow.enterStreetAddressName(data.get("TDAddress2"));
                    tow.enterFirstCrossStreet(data.get("TDcrossStreet"));
                    tow.enterSecondCrossStreet(data.get("TDsecondCrossStreet"));
                    tow.enterCityCodeInTow(data.get("TDCity"));
                    tow.enterStateInTow(data.get("TDState"));
                    tow.enterLandMarkInTow(data.get("TDLandMark"));
                    tow.enterTowPassengers(data.get("TowPassangers"));


                    //Enter facility number
                    services.clickOnServiceTab();
                    services.enterManualSpotDetails(data.get("facilityNumber"));
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    home.saveButton();
                    String callID = services.getCallId();

                    //Login to SPP Dispatch
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnFacilityPTA();

                    //Search for CallID
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.enterStartDate(data.get("StartSearchDate"));
                    diHome.enterCallIDInfo(callID);
                    diHome.clickOnSearchInSearchCalls();
                    diHome.clickOnFirstCallIdInSearchCallsTable();

                    //Verify datapoints on SummaryTab of MCD window
                    boolean firstNameOnSummaryTab = diMCD.verifyMemberFirstNameOnSummaryTab();
                    assertTrue(firstNameOnSummaryTab, "Member First Name is Listed");
                    boolean lastNameOnSummaryTab = diMCD.verifyMemberLastNameOnSummaryTab();
                    assertTrue(lastNameOnSummaryTab, "Member Last Name is Listed");
                    boolean memberNumberOnSummaryTab = diMCD.verifyMemberNumberOnSummaryTab();
                    assertTrue(memberNumberOnSummaryTab, "Member Number is Listed");
                    boolean memberAddressOnSummaryTab = diMCD.verifyMemberAddressOnSummaryTab();
                    assertTrue(memberAddressOnSummaryTab, "Member Address is Listed");
                    boolean memberCityOnSummaryTab = diMCD.verifyMemberCityOnSummaryTab();
                    assertTrue(memberCityOnSummaryTab, "Member City is Listed");
                    boolean memberStateOnSummaryTab = diMCD.verifyMemberStateOnSummaryTab();
                    assertTrue(memberStateOnSummaryTab, "Member State is Listed");
                    boolean memberZipOnSummaryTab = diMCD.verifyMemberZipOnSummaryTab();
                    assertTrue(memberZipOnSummaryTab, "Member Zip is Listed");
                    boolean breakdownLocationOnSummaryTab = diMCD.verifyBreakDownLocationOnSummaryTab();
                    assertTrue(breakdownLocationOnSummaryTab, "BreakDown Location is Listed");
                    boolean vehicleYearOnSummaryTab = diMCD.verifyVehicleYearOnSummaryTab();
                    assertTrue(vehicleYearOnSummaryTab, "Vehicle year is Listed");
                    boolean vehicleMakeOnSummaryTab = diMCD.verifyVehicleMakeOnSummaryTab();
                    assertTrue(vehicleMakeOnSummaryTab, "Vehicle Make is Listed");
                    boolean vehicleModelOnSummaryTab = diMCD.verifyVehicleModelOnSummaryTab();
                    assertTrue(vehicleModelOnSummaryTab, "Vehicle Model is Listed");
                    boolean vehicleColorOnSummaryTab = diMCD.verifyVehicleColorOnSummaryTab();
                    assertTrue(vehicleColorOnSummaryTab, "Vehicle color is Listed");
                    boolean pacesetterCodeOnSummaryTab = diMCD.verifyPaceSetterCodeOnSummaryTab();
                    assertTrue(pacesetterCodeOnSummaryTab, "Pacesettercode is Listed");
                    boolean troubleCodeOnSummaryTab = diMCD.verifyTroubleCodeOnSummaryTab();
                    assertTrue(troubleCodeOnSummaryTab, "Trouble code is Listed");
                    boolean functioCodeOnSummaryTab = diMCD.verifyFunctionCodeOnSummaryTab();
                    assertTrue(functioCodeOnSummaryTab, "FunctionCode is Listed");
                    boolean facilityIdAndNameOnSummaryTab = diMCD.verifyFaclityIdandNameOnSummaryTab();
                    assertTrue(facilityIdAndNameOnSummaryTab, "Facility Id and Name is Listed");
                    boolean truckLoadButtonOnSummaryTab = diMCD.verifyTruckLoadButtonOnSummaryTab();
                    assertTrue(truckLoadButtonOnSummaryTab, "truck load button is Listed");

                    //Verify datapoints on MemberTab of MCD window
                    diMCD.clickOnMemberTabInMCDWindow();
                    boolean memberNumberOnmemberTab = diMCD.verifyMemberNumberOnMemberTab();
                    assertTrue(memberNumberOnmemberTab, "Member Number is Listed");
                    boolean memberFirstNameOnmemberTab = diMCD.verifyMemberFirstNameOnMemberTab();
                    assertTrue(memberFirstNameOnmemberTab, "Member First Name is Listed");
                    boolean memberLastNameOnmemberTab = diMCD.verifyMemberLastNameOnMemberTab();
                    assertTrue(memberLastNameOnmemberTab, "Member Last Name is Listed");
                    boolean memberAddressOnmemberTab = diMCD.verifyMemberAddressOnMemberTab();
                    assertTrue(memberAddressOnmemberTab, "Member Address is Listed");
                    boolean memberLevelOnmemberTab = diMCD.verifyMemberLevelOnMemberTab();
                    assertTrue(memberLevelOnmemberTab, "Member Level is Listed");
                    boolean memberTypeOnmemberTab = diMCD.verifyMemberTypeOnMemberTab();
                    assertTrue(memberTypeOnmemberTab, "Member Type is Listed");
                    boolean memberStatusOnmemberTab = diMCD.verifyMemberStatusOnMemberTab();
                    assertTrue(memberStatusOnmemberTab, "Member Status is Listed");
                    boolean memberExpirationOnmemberTab = diMCD.verifyMemberExpirationOnMemberTab();
                    assertTrue(memberExpirationOnmemberTab, "Member Expiration is Listed");
                    boolean memberCallsUsedOnmemberTab = diMCD.verifyMemberCallsUsedOnMemberTab();
                    assertTrue(memberCallsUsedOnmemberTab, "Member Calls Used is Listed");
                    boolean memberCallsAllowedOnmemberTab = diMCD.verifyMemberCallsAllowedOnMemberTab();
                    assertTrue(memberCallsAllowedOnmemberTab, "Member Calls Allowed is Listed");
                    boolean longTowAllowedOnmemberTab = diMCD.verifyLongTowAllowedOnMemberTab();
                    assertTrue(longTowAllowedOnmemberTab, "Long Tow Allowed is Listed");
                    boolean memberPhoneNumberOnmemberTab = diMCD.verifyMemberPhoneNumberOnMemberTab();
                    assertTrue(memberPhoneNumberOnmemberTab, "Member Phone Number is Listed");
                    boolean LanguagePreferenceOnmemberTab = diMCD.verifyLanguagepreferenceOnMemberTab();
                    assertTrue(LanguagePreferenceOnmemberTab, "Language Preference is Listed");
                    boolean LongTowUsedOnmemberTab = diMCD.verifyLongTowUsedOnMemberTab();
                    assertTrue(LongTowUsedOnmemberTab, "LongTowUsed On memberTab is Listed");
                    boolean DOBOnmemberTab = diMCD.verifyDOBOnMemberTab();
                    assertTrue(DOBOnmemberTab, "DOB On memberTab is Listed");

                    //Verify datapoints on ServiceTab of MCD window
                    diMCD.clickOnServiceTabInMCDWindow();
                    boolean pacesetterCodeOnServiceTab = diMCD.verifyPacesetterCodeOnServiceTab();
                    assertTrue(pacesetterCodeOnServiceTab, "Pacesetter Code is Listed");
                    boolean troubleCodeOnServiceTab = diMCD.verifyTroubleCodeOnServiceTab();
                    assertTrue(troubleCodeOnServiceTab, "Trouble Code is Listed");
                    boolean serviceTypeOnServiceTab = diMCD.verifyServiceTypeinfoOnServiceTab();
                    assertTrue(serviceTypeOnServiceTab, "Service type info is Listed");
                    boolean facilityNameAndnumberOnServiceTabOnServiceTab = diMCD.verifyFacilityNameAndnumberOnServiceTab();
                    assertTrue(facilityNameAndnumberOnServiceTabOnServiceTab, "Facility Name And Number is Listed");
                    boolean batteryServiceHistoryButtonOnServiceTab = diMCD.verifyShowBatteryServiceHistoryButtonOnServiceTab();
                    assertFalse(batteryServiceHistoryButtonOnServiceTab, "Show Battery Service History Button is Listed");
                    boolean FunctionCodeOnServiceTab = diMCD.verifyFunctionCodeOnServiceTab();
                    assertTrue(FunctionCodeOnServiceTab, "FunctionCode On Service Tab is Listed");
                    boolean TruckLoadButtonOnServiceTab = diMCD.verifyTruckLoadButtonOnServiceTab();
                    assertTrue(TruckLoadButtonOnServiceTab, "TruckLoadButton On Service Tab is Listed");

                    //Verify datapoints on LocationsTab of MCD window
                    diMCD.clickOnLocationsTabInMCDWindow();
                    boolean breakDownLocationOnLocationsTab = diMCD.verifyBreakDownLocationOnLocationsTab();
                    assertTrue(breakDownLocationOnLocationsTab, "BreakDown Location Address is Listed");
                    boolean towDestinationOnLocationsTab = diMCD.verifyTowDestinationOnLocationsTab();
                    assertTrue(towDestinationOnLocationsTab, "Tow Destination is Listed");

                    //Verify datapoints on VehicleTab of MCD window
                    diMCD.clickOnVehicleTabInMCDWindow();
                    boolean vehicleYearOnVehicleTab = diMCD.verifyVehicleYearOnVehicleTab();
                    assertTrue(vehicleYearOnVehicleTab, "Vehicle Year is Listed");
                    boolean vehicleMakeOnVehicleTab = diMCD.verifyVehicleMakeOnVehicleTab();
                    assertTrue(vehicleMakeOnVehicleTab, "Vehicle Make is Listed");
                    boolean vehicleModelOnVehicleTab = diMCD.verifyVehicleModelOnVehicleTab();
                    assertTrue(vehicleModelOnVehicleTab, "Vehicle Model is Listed");
                    boolean vehicleColorOnVehicleTab = diMCD.verifyVehicleColorOnVehicleTab();
                    assertTrue(vehicleColorOnVehicleTab, "Vehicle Color is Listed");
                    boolean vehicleTypeOnVehicleTab = diMCD.verifyVehicleTypeOnVehicleTab();
                    assertTrue(vehicleTypeOnVehicleTab, "Vehicle Type is Listed");
                    diHome.logOut();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("SPP", "1793", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
}
