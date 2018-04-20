package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDManualCallOut extends DILoginLib {
    public static String callID;
    public static String callDateCreated;
    public static String callIDAndDateCombined;

    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void mcdManualCallOut(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIMCDManualCallOut", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMCDManualCallOut", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("2047: DI MCD MANUAL Call Out" + " From Iteration " + StartRow + " to " + EndRow);
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
                    DIProfileLib diProfileLib = new DIProfileLib();
                    CommonLib common = new CommonLib();


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


                    //enter prime phone type cellular
                    memeber.membContInfoEnterPrimPhoneTypeCellular();
                    //enter prime phone radio button
                    memeber.clickPrimRadioBtnRowOne();
                    memeber.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("Primaryphonenum1"));
                    //Enter breakdown location
                    locations.clickOnLocationTab();
                    locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
                    vehicle.clickOnVehicleTriageTab();

                    //Enter vehicle details and pacesetter code
                    vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
                    Thread.sleep(2000);
                    vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    towdestination.clickOnTowDestinationTab();

                    //Enter Tow destination
                    towdestination.enterTowDestinationLocationFields(data.get("TowAddress"));
                    service.clickOnServiceTab();

                    //Enter facility
                    service.enterManualSpotDetails(data.get("facilityNumber"));
                    towdestination.errorAlertHandlingBeforeEnterMandatoryFields();

                    //save call
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

                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID);

                    //click on call out
                    diMCD.cickOnCallOutButtonOnMCDWindow();
                    diMCD.cickOnLiveCallOutButtonOnMCDWindow();

                    //verifying for call out occur by checking phone icon is appeared or not
                    assertTrue(diMCD.verifyPhoneIconOnMCD(), "Phone Icon Is Appeared On MCD");
                    diMCD.clickOnMCDCloseWindow();

                    //Opening profile window
                    diHome.clickOnProfile();
                    diHome.clickOnGearIconOfProfileWindow();
                    diHome.clickOnResetDefaultSettingOnProfileTab();
                    // diHome.clickOnArrowButtonOfDate();
                    diProfileLib.clickOnDateArrowButton();

                    //sorting on  profile window to verify call out occurs on profile window
                    diHome.selectPriority("1");
                    diHome.selectOrder("Descending");
                    diHome.clickOnSaveButtonOfIDAndDateOnProfileWindow();
                    //diHome.clickOnArrowButtonOfID();
                    diProfileLib.clickOnIDArrowButton();
                    diHome.selectPriority("2");
                    diHome.selectOrder("Descending");
                    diHome.clickOnSaveButtonOfIDAndDateOnProfileWindow();
                    diHome.clickOnSaveSettingsButtonOfProfileWindow();
                    home.allErrorAlerts();
                    callIDAndDateCombined = callDateCreated.replaceAll("-", "");

                    //verifying for call out occured on profile window
                    assertTrue(diProfileLib.verifyCallOutIconOnProfileWindow(callID, callIDAndDateCombined), "Call Out ICon Appeared on Profile window");
                    diProfileLib.CLoseProfileWindow();
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.searchAndSelectCallIDInDI(callID);

                    //verifying for status update CO on StatusHistoryTab
                    diMCD.clickOnStatusHistoryLinkOnMCDWindow();
                    diMCD.clickOnDateHeaderToSortDate();
                    assertTrue(diMCD.getUpdateCodeOnStatusHistory().equalsIgnoreCase("CO"), "CO update is appeared on Status History");
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    System.out.println("Test completed");
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "2047", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }


}
