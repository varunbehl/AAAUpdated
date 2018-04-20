package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


public class TC_DIPrintCall extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;
    public static String callIDAndDateCombined;
    public static String StatusInPrint;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void DIPrintCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "DIPrintCall", TestData, "D3Dispatch");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    //Open the browser in each iteration
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIPrintCall", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("2021: TC-DI Print Call" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib role = new LoginRoleLib();
                    DIHomeLib diHome = new DIHomeLib();
                    CRHomeLib crHomeLib = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
                    CRServiceLib services = new CRServiceLib();
                    CRTowDestinationLib tow = new CRTowDestinationLib();
                    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
                    DIMCDLib dimcd = new DIMCDLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DILoginLib diLogin = new DILoginLib();
                    CommonLib common = new CommonLib();
                    LoginLib login = new LoginLib();
                    DIPrintCallLib print = new DIPrintCallLib();

                        navigateToApplication("DI");
                        login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                        common.clickOnProceedBtnForDispatchSPPLogin();

                        diLogin.waitcloseAllBusyIcons();

                        diHome.clickOnSearchCallsLink();
                        String currentDate = common.getCurrentDate();
                        String startDate = common.getPreviousDate(currentDate);
                        diHome.enterStartDateOnSearchCallsWindow(startDate);
                        diHome.clickOnSearchInSearchCalls();
                        diHome.clickOnCallDateOrIDLink();
                        //getAllvalues from MCD
                        String callIDMCD=dimcd.getCallIdFromMcdWindow();
                        String dateMCD=dimcd.getCallDateFromMCD();
                        //String pta=dimcd.verifyETATimeOnMCDWindow();;

                        String memberStateMCD=dimcd.getMemberStateOnMemberTab();
                        String memberCityMCD=dimcd.getMemberCityOnMemberTab();
                        String pacesetterCodeMCD=dimcd.getPaceSetterCodeOnSummaryTab();
                        String troubleCode=dimcd.getTroubleCodeOnSummaryTab();
                        String facilityMCD=dimcd.getFacilityIDAndNameOnSummaryTabOfMCDWindow();
                        String BreakDownMCD=dimcd.getCompletedreakDownLoctionInSummaryTab();
                        String userName=dimcd.getUserName();
                        String ptaMCD=dimcd.getPTAValue();
                        String ptaDateMCd[]=ptaMCD.split(" ");
                        String ptaDateinMCDWIndow=ptaDateMCd[0];
                        String addressMCD=dimcd.getMemberAddressOnSummaryTab();

                        dimcd.clickOnMemberTabInMCDWindow();
                        String memberNumberMCD=dimcd.getMemberNumberOnMemberTab();
                        String meberFirstName=dimcd.getMemberFirstNameOnMemberTab();
                        String meberSecondName=dimcd.getMemberLastNameOnMemberTab();
                        String contactNameMCD= meberFirstName+ " "+meberSecondName;
                        String levelMCD=dimcd.getMemberLevelOnMemberTab();
                        String clubMCD=dimcd.getMemberClibCode();
                        String statusMCD=dimcd.getMemberStatusOnMemberTab();

                        String expriationMCD=dimcd.getMemberExpirationOnMemberTab();

                        //Services
                        dimcd.clickOnServiceTabInMCDWindow();
                        String dispatchMCD =dimcd.getDispatchInfo();

                        //Vehicle information
                        dimcd.clickOnVehicleTabInMCDWindow();
                        String VehicleTypeMCD =dimcd.getVehicleTypeOnVehicleTab();
                        String VehicleYearMCD =dimcd.getVehicleYearOnVehicleTab();
                        String VehicleMakeMCD =dimcd.getVehicleMakeOnVehicleTab();
                        String VehicleModelMCD =dimcd.getVehicleModelOnVehicleTab();
                        String VehicleColorMCD =dimcd.getVehicleColorOnVehicleTab();

                        //Locations
                        dimcd.clickOnServiceTabInMCDWindow();
                        String towMCD=dimcd.getTowDestinationForRAPCall();

                        //Get all Values from Print screen
                        boolean printButton=dimcd.verifyPrintCallButtonOnMCDWindow();
                        assertTrue(printButton,"Print Button is available");
                        dimcd.clickOnPrintCallButtonOnMCDWindow();
                        switchToWindow();
                        Thread.sleep(5000);
                        String MemberNumberPrint=print.getMemberShipNumber();
                        String memberContactNamePrint=print.getMemberContactName();
                        String memberCityPrint=print.getMemberCityName();
                        String memberStatePrint=print.getMemberStateName();
                        String levlePrint=print.getMemberLevel();
                        String VehicleTypePrint=print.getVehicleType();
                        String VehicleYearPrint=print.getVehicleYear();
                        String VehicleMakePrint=print.getVehicleMake();
                        String VehicleModelPrint=print.getVehicleModel();
                        String VehicleColorPrint=print.getVehicleColor();
                        String pacesetterCodePrint=print.getpacesetterCode();
                        String troubleCodePrint=print.getTroubleCode();

                        String callIDPrint=print.getCallID();
                        String CallDatePrint=print.getCallDate();
                        String clubPrint=print.getClub();
                        String userPrint=print.getD3User();
                        String statusPrint=print.getStatus();
                        String ExpPrint=print.getExpiration();
                        String addPrint=print.getAddress();
                        String bdLocationPrint=print.getBreakDownLocation();
                        String bdCityPrint=print.getBreakDownCity();
                        String bdPTAPrint=print.getBreakDownPta();
                        String ptaDatePrint[]=bdPTAPrint.split(" ");
                        String ptaDateinPrintWIndow=ptaDatePrint[0];
                        String bdStatePrint=print.getBreakDownState();
                        String FacilityPrint=print.getFacility();
                        String bdDispatchRegionPrint=print.getDispatchRegion();
                        String towDestionationPrint=print.getTowDestionation();

                        if(statusPrint.equals("A")) {
                            StatusInPrint = "Active";
                        }
                        //
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date ExpirePrint = new SimpleDateFormat("MM/dd/yyyy").parse(ExpPrint);
                        String expDatePrint = dateFormat.format(ExpirePrint).toString();
                        //Compare Both MCD and Print values
                        assertTrue(expDatePrint.equalsIgnoreCase(expriationMCD),expDatePrint+" :: Print page Member number Exp date is same as MCD "+expriationMCD);
                        assertTrue(MemberNumberPrint.equalsIgnoreCase(memberNumberMCD),MemberNumberPrint+" :: Print page Member number is same as MCD "+memberNumberMCD);
                        assertTrue(contactNameMCD.equalsIgnoreCase(memberContactNamePrint),memberContactNamePrint+" :: Print page Member Name is same as MCD "+contactNameMCD);
                        assertTrue(memberCityMCD.contains(memberCityPrint),memberCityPrint+" :: Print page Member City is same as MCD "+memberCityMCD);
                        assertTrue(memberStateMCD.equalsIgnoreCase(memberStatePrint),memberStatePrint+" :: Print page Member State is same as MCD "+memberStateMCD);
                        assertTrue(levelMCD.equalsIgnoreCase(levlePrint),levlePrint+" :: Print page Member Level is same as MCD "+levelMCD);
                        assertTrue(VehicleTypeMCD.contains(VehicleTypePrint),VehicleTypeMCD+" :: Print page Vehicle Type is same as MCD "+VehicleTypePrint);
                        assertTrue(VehicleYearMCD.equalsIgnoreCase(VehicleYearPrint),VehicleYearPrint+" :: Print page Vehicle Year is same as MCD "+VehicleYearMCD);
                        assertTrue(VehicleMakeMCD.equalsIgnoreCase(VehicleMakePrint),VehicleMakePrint+" :: Print page Vehicle Make is same as MCD "+VehicleMakeMCD);
                        assertTrue(VehicleModelMCD.equalsIgnoreCase(VehicleModelPrint),VehicleModelPrint+" :: Print page Vehicle Model is same as MCD "+VehicleModelMCD);
                        assertTrue(VehicleColorMCD.equalsIgnoreCase(VehicleColorPrint),VehicleColorPrint+" :: Print page Vehicle color is same as MCD "+VehicleColorMCD);
                        assertTrue(pacesetterCodeMCD.contains(pacesetterCodePrint),pacesetterCodePrint+" :: Print page pacesetter code is same as MCD "+pacesetterCodeMCD);
                        assertTrue(troubleCode.contains(troubleCodePrint),troubleCodePrint+" :: Print page Trouble Code is same as MCD "+troubleCode);
                        assertTrue(dispatchMCD.contains(bdDispatchRegionPrint),bdDispatchRegionPrint+" :: Print page dispatch is same as MCD "+dispatchMCD);
                        assertTrue(callIDPrint.contains(callIDMCD),callIDPrint+" :: Print page call id is same as MCD "+callIDMCD);
                        assertTrue(clubPrint.equalsIgnoreCase(clubMCD),clubPrint+" :: Print page club Code is same as MCD "+clubMCD);
                        assertTrue(towDestionationPrint.contains(towMCD),towDestionationPrint+" :: Print page tow Code is same as MCD "+towMCD);
                        assertTrue(facilityMCD.contains(FacilityPrint),FacilityPrint+" :: Print page Facility Code is same as MCD "+facilityMCD);
                        assertTrue(statusMCD.equalsIgnoreCase(StatusInPrint),StatusInPrint+" :: Print page Status Code is same as MCD "+statusMCD);
                        assertTrue(dateMCD.equalsIgnoreCase(CallDatePrint),CallDatePrint+" :: Print page date is same as MCD "+dateMCD);
                        assertTrue(BreakDownMCD.contains(bdLocationPrint),bdLocationPrint+" :: Print page break downloaction is same as MCD "+BreakDownMCD);
                        assertTrue(BreakDownMCD.contains(bdCityPrint),bdCityPrint+" :: Print page break downloaction city is same as MCD "+BreakDownMCD);
                        assertTrue(BreakDownMCD.contains(bdStatePrint),bdStatePrint+" :: Print page break downloaction state is same as MCD "+BreakDownMCD);
                        assertTrue(userName.equalsIgnoreCase(userPrint),userPrint+" :: Print page User name is same as MCD "+userName);
                        assertTrue(ptaDateinMCDWIndow.contains(ptaDateinPrintWIndow),ptaDateinPrintWIndow+" :: Print page PTA Date is same as MCD "+ptaDateinMCDWIndow);
                        assertTrue(addressMCD.contains(addPrint),addPrint+" :: Print page address is same as MCD "+addressMCD);
                   System.out.println("Test completed");
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();

                //updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
                ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);

                //To close the browser after each iteration
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
}
