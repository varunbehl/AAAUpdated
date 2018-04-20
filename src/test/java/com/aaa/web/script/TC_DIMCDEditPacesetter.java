package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDEditPacesetter extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;
    public static String callIDAndDateCombined;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void DIMCDEditPacesetter(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "DIMCDEditPacesetter", TestData, "D3Dispatch");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    //Open the browser in each iteration
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMCDEditPacesetter", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("2032: TC-DI MCD Edit Pacesetter" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    // reporter.SuccessReport("Iteration Number","******IterationNumber::"+data.get("iterationnumber"));
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
                    CR_DI crDI = new CR_DI();
                    DIMCDLib dimcd = new DIMCDLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DILoginLib diLogin = new DILoginLib();
                    CommonLib common = new CommonLib();
                    LoginLib login = new LoginLib();

                    navigateToApplication("CR");
                    login.login(data.get("LoginName"), data.get("Password"));
                    member.clickOnPartialCallCloseButton();
                    crHomeLib.messageDialogBoxClose();
                    String Member = "";

                    //Getting member from DB based on the input
                    if (data.get("Member").equals("db")) {
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    }
                    if (Member.isEmpty()) {
                        Member = data.get("Membersearch");
                    }

                    //Searching Member number
                    crHomeLib.memberSearchTextBox(Member);
                    member.memberNumClick();
                    member.labelMemberLevelInMemberDetailsSection();

                    //Entering the breakdown location
                    locations.clickOnLocationTab();
                    locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
                    //common.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("vehicleType"),data.get("ProblemTriage"),data.get("ProblemType"));
                    crVehicleTriageLib.clickOnVehicleTriageTab();
                    crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    crVehicleTriageLib.enterPaceSetterCodeManually(data.get("ProblemType"));
                    crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
                    crHomeLib.allErrorAlerts();
                    Thread.sleep(5000);

                    //crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    //crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    //crHomeLib.allErrorAlerts();
                    common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                    services.clickOnServiceTab();
                    services.enterManualSpotDetails(data.get("facilityNumber"));
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    crVehicleTriageLib.clickOnVehicleTriageTab();
                    boolean secondPacesetterCode = crVehicleTriageLib.validatePacesetterSecondButton();
                    if (secondPacesetterCode) {
                        crVehicleTriageLib.clickOnPacesetterSecondButton();
                        crVehicleTriageLib.enterPaceSetterCodeManually(data.get("pacesetterCode2"));
                        home.saveButton();
                        crHomeLib.allErrorAlerts();
                        String date = services.getCallDate();
                        callID = services.getCallId();

                        services.closeCall();
                        home.logout();

                        navigateToApplication("DI");
                        login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                        /*boolean proceedButton = role.verifyVisibilityOProceedBtnInDispatchRoleLogin();
                        //if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                        if (proceedButton) {
                            loginRole.clickOnProceedBtnInDispatchRoleLogin();
                            diLogin.waitcloseAllBusyIcons();
                            diHome.clickOnCloseIconOnQueueSelection();
                        } else {
                            diLogin.waitcloseAllBusyIcons();
                            diHome.closeFacilityWindow();
                        }*/
                        common.clickOnProceedBtnForDispatchSPPLogin();
                        diLogin.waitcloseAllBusyIcons();

                        diHome.clickOnSearchCallsLink();
                        String currentDate = common.getCurrentDate();
                        String startDate = common.getPreviousDate(currentDate);
                        diHome.enterStartDateOnSearchCallsWindow(startDate);
                        diHome.enterCallIDInfo(callID);
                        diHome.enterMemberNumberInfo(Member);
                        diHome.clickOnSearchInSearchCalls();
                        diHome.clickOnCallDateOrIDLink();
                        dimcd.clickOnServiceTabInMCDWindow();
                        boolean grayBGTroubleCode1 = dimcd.validateTroubleCode1BGColor();
                        assertTrue(!grayBGTroubleCode1, "Back Ground color is Gray");
                        boolean grayBGTroubleCode2 = dimcd.validateTroubleCode2BGColor();
                        assertTrue(!grayBGTroubleCode2, "Back Ground color is Gray");
                        boolean verifyEditLinkAvailablity = dimcd.verifyEditLinkAvailablity();
                        if (verifyEditLinkAvailablity) {
                            dimcd.getEditAndClick();

                            dimcd.enterPacesetterCode1InServicesTabInMCD(data.get("paceSettercode"));
                            String combineKeys = Keys.chord(Keys.TAB);
                            sendKeys(combineKeys, "Tab");

                            String paceSetterCode2 = dimcd.enterPacesetterCode2InServicesTabInMCD(data.get("pacesetterCode1"));
                        /*String combineKeys3 = Keys.chord(Keys.TAB);
                        sendKeys(combineKeys3, "Tab");*/
                            sendKeys(combineKeys, "Tab");

                            dimcd.clickOnSaveButtonInServiceTabInMCDWindow();
                            Thread.sleep(5000);
                            boolean grayBGOrangeColorTroubleCode1 = dimcd.validateTroubleCode1BGColor();
                            assertTrue(grayBGOrangeColorTroubleCode1, "Back Ground color is Orange");
                            boolean grayBGOrangeColorTroubleCode2 = dimcd.validateTroubleCode2BGColor();
                            assertTrue(grayBGOrangeColorTroubleCode2, "Back Ground color is Orange");
                            String troubleCode1 = dimcd.getlblLatestCommentsInMCDWindow();

                            if (!troubleCode1.contains(data.get("ExpectedCommentText"))) {
                                reporter.failureReport("Trouble code updation in comments section", troubleCode1 + " ::Occured becuase of application issue", driver);
                            }else{
                                reporter.SuccessReport("Pacesettercode change","Expected "+data.get("ExpectedCommentText")+"  and Actual Commnets are same "+troubleCode1);
                            }
                            dimcd.clickOnAssign();
                            dimcd.selectFacility();
                            Thread.sleep(1000);
                            dimcd.selectDispatch();
                            Thread.sleep(1000);
                            dimcd.selectEnroute();
                            dimcd.selectEnrouteTime();
                            Thread.sleep(1000);
                            dimcd.selectOnLocation();
                            Thread.sleep(1000);
                            dimcd.selectClearCall();
                            dimcd.selectExitCode();
                            //Checking and entering the reason code
                            boolean reasonCodeTextBoxAvailability = dimcd.validateDisaleReasonCodeTextBoxForEdit();
                            if (!reasonCodeTextBoxAvailability) {
                                dimcd.enterReason(data.get("reason"));
                                dimcd.clickOnContinue();

                            } else {
                                assertTrue(reasonCodeTextBoxAvailability, "<b>ReasonCode text box is not editable</b>");
                                dimcd.clickOnContinue();
                            }
                            // clickOnContinue();
                            boolean errorMessageExists = dimcd.verifyE213ErrorMessageAvailablity();
                            if (errorMessageExists) {
                                dimcd.getE213ErrorMessage();
                                dimcd.clickOnE213OkayButton();
                                dimcd.clickOnMCDCloseWindow();
                                callIDAndDateCombined = date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10) + date.substring(4, 5) + callID;
                                diHome.clickOnSelectedProfileUnderProfileMenu(data.get("profileName"));
                                String pacesetterCodeInProfile = diHome.gettextforTCL1(callIDAndDateCombined);
                                assertTrue(data.get("paceSettercode").equalsIgnoreCase(pacesetterCodeInProfile), "Changes reflected based on the mapping");
                                assertTrue(data.get("paceSettercode").contains(pacesetterCodeInProfile), "Changes reflected based on the mapping");
                                diHome.clickToCloseProfileWindow();
                                diHome.logOut();

                            } else {
                                //Entering Values in APD Window
                                boolean visibilityOfAPDWindow = dimcd.visibilityOfAPDHeader();
                                if (visibilityOfAPDWindow) {
                                    dimcd.enterServiceAndChargesOnMCDWindow(data.get("serviceType"));
                                    dimcd.enterCostInServiceAndChargesInMCDWindow(data.get("cost"));
                                    dimcd.enterCashCollectedInServiceAndChargesInMCDWindow(data.get("cashCollected"));
                                    dimcd.clickOnSubmit();
                                }
                                String spotStatus = dimcd.getCallStatusOnMCDwindow();
                                assertTrue(spotStatus.equalsIgnoreCase("CL - Cleared"), "<b>The currrent Status is:: " + spotStatus + " Selected cash call Cleared Successfully </b>");
                                dimcd.clickOnMCDCloseWindow();
                                callIDAndDateCombined = date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10) + date.substring(4, 5) + callID;
                                diHome.clickOnSelectedProfileUnderProfileMenu(data.get("profileName"));
                                String pacesetterCodeInProfile = diHome.gettextforTCL1(callIDAndDateCombined);
                                assertTrue(data.get("paceSettercode").equalsIgnoreCase(pacesetterCodeInProfile), "Changes reflected based on the mapping");
                                assertTrue(data.get("paceSettercode").contains(pacesetterCodeInProfile), "Changes reflected based on the mapping");
                                diHome.clickToCloseProfileWindow();
                                diHome.logOut();
                            }
                        }
                        else {
                            reporter.failureReport("Edit Link", "Edit link is not available to change the pacesetter code", driver);
                            dimcd.clickOnMCDCloseWindow();
                            diHome.logOut();
                        }
                        } else {
                            reporter.failureReport("<b>Second Pacesetter code Button</b>", "Second pacesetter Button is not visible or not clickable", driver);
                            crHomeLib.leaveButton();
                            crHomeLib.allErrorAlerts();
                            diHome.logOut();
                        }



                    System.out.println("Test completed");
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();

                //updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
                ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);

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
