package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DICashCalClearing extends DILoginLib {
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String level;
    public static String levelMCD;
    public static String reasonCode;
    public static Boolean towAvailablity;
    public static int totalnumberOfSpecialEquipment;



    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void clearCashCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCashCall", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("clearCashCall", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("2015: TC-DI Cash Call Clearing" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib role = new LoginRoleLib();
                    DIHomeLib diHome = new DIHomeLib();
                    CRHomeLib crHomeLib = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib services = new CRServiceLib();
                    CRTowDestinationLib tow = new CRTowDestinationLib();
                    CR_DI crDI = new CR_DI();
                    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    CommonLib common = new CommonLib();
                    String rolevalue="DI - Dispatcher";

                    navigateToApplication("CR");
                    login(data.get("CRLoginName"), data.get("Password"));
                    waitcloseAllBusyIcons();
                    //home.messageDialogBoxClose();
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

                    boolean visibilityOfMessageBox = home.verifyMessageDialogBoxClose();
                    if (visibilityOfMessageBox == true) {
                        home.closeMessageDialogBoxClose();
                    }
                    if (Member == null) {
                        home.logout();
                        assertTrue(Member == null, data.get("dbqueryFileName") + " ::Query not return Member number");
                    } else {

                        //Creating a new call
                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        member.labelMemberLevelInMemberDetailsSection();
                        String callsAllowedBeforeMemberCall = member.memberCallsRemainingInMemberDetailsSection();

                        //Checking for Entitlements
                        int callsRemaining = Integer.parseInt(callsAllowedBeforeMemberCall);
                        //The given Query is not returning member number which are having CallRemining > 0, if you want to test the flow change the condition to callremaining>=0
                        if (callsRemaining == 0) {


                            locations.breakdownLocTabSel();
                            locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                            locations.getLatitudeValue();
                            locations.getLongitudeValue();
                            common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"));
                            vehicle.handleScriptErrorInVehicleTriagePage();
                            home.allErrorAlerts();

                            home.clickOnCallSummaryButton();
                            String TroubleCode = home.getTroubleCodeValueFromCallDetailsPopup();
                            home.closeCallSummaryPopupWindow();
                            //Verifying the Cash icon
                            services.clickOnServiceTab();
                            boolean cashIcon = services.verifySelectedCashButtonInServicesTab();
                            if (!cashIcon) {
                                services.clickOnCashOnServiceTab();
                            }
                            services.enterManualSpotDetails(data.get("facilityNumber"));
                            vehicle.handleScriptErrorInVehicleTriagePage();


                            home.saveButton();
                            waitcloseAllBusyIcons();
                            home.allErrorAlerts();
                            callID = services.getCallId();
                            services.closeCall();
                            home.logout();
                            //Naviagte into Dispatch application
                            navigateToApplication("DI");
                            waitcloseAllBusyIcons();
                            login(data.get("DILoginName"), data.get("Password"));
                            boolean visibilityOfProceedButton=role.verifyVisibilityOProceedBtnInDispatchRoleLogin();
                            if(visibilityOfProceedButton)
                            {
                                role.selectRoleInDispatch(rolevalue);
                            }
                            common.clickOnProceedBtnForDispatchSPPLogin();
                            diHome.clickOnSearchCallsLink();
                            //Searching for a call
                            String currentDate=common.getCurrentDate();
                            String startDate=common.getPreviousDate(currentDate);
                            diHome.enterStartDateOnSearchCallsWindow(startDate);
                            diHome.enterCallIDInfo(callID);
                            diHome.enterMemberNumberInfo(Member);
                            diHome.clickOnSearchInSearchCalls();
                            diSearchCalls.selectSPStatusRowInSearchCallDispatch();
                            //Validating Pacesettercode between CR and DI
                            pacesetterCode = diMCD.getPaceSetterCodeOnSummaryTab();
                            String currentPaceCode[] = pacesetterCode.split("-");
                            String paceSetterCode = currentPaceCode[0]; //facilityname
                            //Comparing Call receiving and MCD window Pacesetter code
                            assertTrue(data.get("ProblemType").contains(paceSetterCode), "<b>pacesetter code that we  selected populates the reason code based on the mapping</b>");
                            //COmpaing trouble Code
                            troubleCode = diMCD.getTroubleCodeOnSummaryTab();
                            String troubleC[] = troubleCode.split("- ");
                            String troubleCodeValue = troubleC[1];
                            assertTrue(TroubleCode.contains(troubleCodeValue), "<b> trouble code displays in MCD Window::  " + troubleCodeValue + "  ::based on the mapping in Call Receiving " + TroubleCode + "</b>");
                            //Clearing the call
                            diMCD.clickOnAssign();
                            diMCD.selectFacility();
                            Thread.sleep(1000);
                            diMCD.selectDispatch();
                            Thread.sleep(1000);
                            diMCD.selectEnroute();
                            diMCD.selectEnrouteTime();
                            Thread.sleep(1000);
                            diMCD.selectOnLocation();
                            Thread.sleep(1000);
                            diMCD.selectClearCall();
                            diMCD.selectExitCode();
                            //Checking and entering the reason code
                            String troubleCodeInClearCallScreen= diMCD.getTroubleCodeFromClearingScreen();
                            String troubleCodeExit[]=troubleCodeInClearCallScreen.split("- ");
                            String troubleCodeValueInExit=troubleCodeExit[1];
                            assertTrue(TroubleCode.contains(troubleCodeValueInExit),"<b> trouble code displays in MCD Window::  "+troubleCodeInClearCallScreen+"  ::based on the mapping in Call Receiving "+TroubleCode+"</b>");
                            boolean reasonCodeTextBoxAvailability = diMCD.validateDisaleReasonCodeTextBoxForEdit();
                            if (!reasonCodeTextBoxAvailability) {
                                diMCD.enterReason(data.get("reason"));
                                diMCD.clickOnContinue();

                            }else{
                                reporter.failureReport("<b>Reason Code</b>", "<b>ReasonCode text box is not editable</b>",driver);
                                diMCD.clickOnContinue();
                            }
                            // clickOnContinue();
                            boolean errorMessageExists=diMCD.verifyE213ErrorMessageAvailablity();
                            if(errorMessageExists) {
                                diMCD.getE213ErrorMessage();
                                diMCD.clickOnE213OkayButton();
                            }
                            //Entering Values in APD Window
                            boolean visibilityOfAPDWindow=diMCD.visibilityOfAPDHeader();
                            if(visibilityOfAPDWindow){
                                diMCD.enterServiceAndChargesOnMCDWindow(data.get("serviceType"));
                                diMCD.enterCostInServiceAndChargesInMCDWindow(data.get("cost"));
                                diMCD.enterCashCollectedInServiceAndChargesInMCDWindow(data.get("cashCollected"));
                                diMCD.clickOnSubmit();
                            }
                            String spotStatus = diMCD.getCallStatusOnMCDwindow();
                            assertTrue(spotStatus.equalsIgnoreCase("CL - Cleared"),"<b>The currrent Status is:: "+spotStatus+" Selected cash call Cleared Successfully </b>");
                            diMCD.clickOnMCDCloseWindow();
                        }
                        else{
                            reporter.failureReport("Entitlements are over","<b>:: "+Member+"  :: Entitlements are more than 0 which is not sutable for this test case</b>",driver);
                        }

                        diHome.logOut();
                    }
                }
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2015",ReportStatus.strMethodName,intCounter,browser);
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