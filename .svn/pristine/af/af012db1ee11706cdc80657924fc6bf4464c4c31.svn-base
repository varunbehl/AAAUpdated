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


public class TC_DIMCDBatteryServiceHistory extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;
    public static String memberNumber;
    CRHomeLib home = new CRHomeLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib member = new CRMemberSearchLib();
    CRLocationsLib locations = new CRLocationsLib();
    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    CR_DI crDI = new CR_DI();
    DIMCDLib dimcd = new DIMCDLib();
    LoginRoleLib loginRole=new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    boolean visibilityOfBatteryQuestionaier;
    DIMCDLib diMCD = new DIMCDLib();

    boolean reasonCodeTextBoxAvailability;
    boolean errorMessageExists;
    boolean visibilityOfAPDWindow;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void MCDBatteryServiceHistory(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MCDBatteryServiceHistory", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MCDBatteryServiceHistory", TestData, "D3Dispatch",intCounter);
    	
			                this.reporter.initTestCaseDescription("1940: TC-DI MCD Battery Service History"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

                    String currentDate=common.getCurrentDate();
                    String startDate=common.getPreviousDate(currentDate);

                    //CREATING A NEW CALL *************************************************

                   /* String Member=common.createCallWithManualPacesetterAndManualSpot(data.get("CRLoginName"), data.get("Password"),data.get("Member"),
                   data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"),
                            data.get("Membersearch"),data.get("OmniBarAddress"),data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"),
                            data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"),data.get("facilityNumber"));
*/

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

					if(data.get("Member").equals("db")&&Member==""){
                        Member = data.get("Membersearch");
                    }

                    boolean visibilityOfMessageBox = home.verifyMessageDialogBoxClose();
                    if (visibilityOfMessageBox) {
                        home.closeMessageDialogBoxClose();
                    }
                    if (Member.isEmpty()) {
                        home.logout();
                        assertTrue(Member.isEmpty(), data.get("dbqueryFileName") + " ::Query not return Member number");
                    } else {
                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();

                        home.clickOnCallSummaryButton();
                        home.getTroubleCodeValueFromCallDetailsPopup();
                        home.closeCallSummaryPopupWindow();

                        common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        services.clickOnServiceTab();
                        services.enterManualSpotDetails(data.get("facilityNumber"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.saveButton();
                        home.allErrorAlerts();
                        callID = services.getCallId();
                        services.closeCall();
                        home.logout();



                        //Naviagte into Dispatch application
                        navigateToApplication("DI");
                        waitcloseAllBusyIcons();
                        login(data.get("DILoginName"), data.get("Password"));
                        common.clickOnProceedBtnForDispatchSPPLogin();
                        diHome.clickOnSearchCallsLink();
                        //Searching for a call

                        diHome.enterStartDateOnSearchCallsWindow(startDate);
                        diHome.enterCallIDInfo(callID);
                        diHome.enterMemberNumberInfo(Member);
                        diHome.clickOnSearchInSearchCalls();
                        //diSearchCalls.selectSPStatusRowInSearchCallDispatch();
                        diHome.clickOnCallDateOrIDLink();
                        if(data.get("popout").equals("Yes")){
                            diMCD.maximizeMCDWindow();
                            switchToWindow();
                        }
                        diMCD.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
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

                        dimcd.selectBatterlyResolutionCodeInMCDClearWindow();
                        //Checking and entering the reason code
                         reasonCodeTextBoxAvailability = diMCD.validateDisaleReasonCodeTextBoxForEdit();
                        if (!reasonCodeTextBoxAvailability) {
                            diMCD.enterReason(data.get("reason"));
                            diMCD.clickOnContinue();

                        }else{
                            assertTrue(reasonCodeTextBoxAvailability, "<b>ReasonCode text box is not editable</b>");
                            diMCD.clickOnContinue();
                        }
                        errorMessageExists=diMCD.verifyE213ErrorMessageAvailablity();

                        if(!errorMessageExists) {

                            //Checking for Orignial Tow destination
                            if (data.get("clearType").equalsIgnoreCase("NOGO")) {
                                boolean TowDestinationVisibility = diMCD.verifyOriginalTowDestination();
                                if (TowDestinationVisibility) {
                                    if (data.get("TowConfirmation").equalsIgnoreCase("Original")) {
                                        boolean visibilityOfOriginalTowButton = diMCD.verifyOriginalTowDestination();
                                        if (visibilityOfOriginalTowButton) {
                                            diMCD.clickOnOriginalTowDestination();
                                            diMCD.clickOnSubmit();
                                            diMCD.clickOnSubmit();

                                        } else {
                                            assertTrue(!visibilityOfOriginalTowButton, "<b>Original Tow Destination Button is not available </b>");
                                            diMCD.clickOnNoTowPerformed();
                                            diMCD.clickOnSubmit();
                                            diMCD.clickOnSubmit();
                                        }
                                    } else {
                                        Thread.sleep(5000);
                                        diMCD.clickOnSubmit();
                                    }
                                }
                            }
                            //Checking for Battery questionaires
                            boolean visibilityOfBatteryQuestionaier = diMCD.verifyBatteryQuestionarierInMCDWindow();
                            if (visibilityOfBatteryQuestionaier) {
                                diMCD.clickAndEnterBatteryInformation(data.get("ODOMeterreading"), data.get("BatteryComments"), data.get("TestCode"), data.get("BatteryType"), data.get("BatteryPrice"));
                            } else {
                                reporter.failureReport("Questinaries page availablity ", "Questionaries page is not available");
                            }
                            diMCD.clickOnSubmit();
                            //Entering Values in APD Window
                             visibilityOfAPDWindow = diMCD.visibilityOfAPDHeader();
                            if (visibilityOfAPDWindow) {
                                diMCD.enterServiceAndChargesOnMCDWindow(data.get("serviceType"));
                                diMCD.enterCostInServiceAndChargesInMCDWindow(data.get("cost"));
                                diMCD.enterCashCollectedInServiceAndChargesInMCDWindow(data.get("cashCollected"));
                                Thread.sleep(5000);

                                diMCD.clickOnSubmit();
                            }
                            String spotStatus = diMCD.getCallStatusOnMCDwindow();
                            assertTrue(spotStatus.equalsIgnoreCase("CL - Cleared"), "<b>The currrent Status is:: " + spotStatus + " Selected Battery call Cleared Successfully </b>");
                            dimcd.clickOnMemberTabInMCDWindow();
                            dimcd.clickOnShowBatteryServiceHistory();
                            boolean availablityOfShowHisotryButton=diMCD.verifyOnShowBatteryServiceHistory();
                            if(availablityOfShowHisotryButton){
                                diMCD.clickOnShowBatteryServiceHistory();
                            }

                            boolean tabAvailability1 = dimcd.verifyShowBatteryServiceHisotryTabAvailablity();

                            if (tabAvailability1) {
                                assertTrue(tabAvailability1, "Battery information Tab opened");
                                boolean dateAndCallLinkVisibility = dimcd.verifyDateAndCallIdVisibilityInShowBatteryHistory();
                                if (dateAndCallLinkVisibility) {
                                    diMCD.verifyBatteryHisotryInformation(callID);
                                    dimcd.clickOnDateAndCallIdInShowBatteryHistory();
                                    waitcloseAllBusyIcons();
                                    switchToWindow();
                                    boolean printButton1 = dimcd.verifyPrintButton();
                                    assertTrue(printButton1, "Print Page opened");
                                    boolean nodata = dimcd.verifyNoDataMessage();
                                    if (nodata) {
                                        String dataNotavailable = dimcd.getNoDataMessage();
                                        reporter.failureReport("A Print Call Detail view screen should come up with the Battery Service History call details", "Data Not available " + dataNotavailable);
                                    }
                                    switchToWindow();
                                    closeWindow();
                                    switchToWindow();
                                    boolean availablityOfDoneButton=diMCD.verifyDoneButtonInBatteryInformationWindow();
                                    if(availablityOfDoneButton) {
                                        dimcd.clickOnDoneButtonInBatteryInformationWindow();
                                    }
                                } else {
                                    reporter.failureReport("Show Battery History details", "Show Battery History details are not visible", driver);
                                }
                            } else {
                                reporter.failureReport("Show Battery History Tab", "Show Battery History Tab not visible", driver);
                            }

                        }else {
                            String error=diMCD.getE213ErrorMessage();
                            reporter.failureReport("Clear Call", "User is not able to clear the call because of this error "+error);
                            diMCD.clickOnE213OkayButton();
                        }
                        if(data.get("popout").equals("Yes")){
                            diMCD.minimizeMCDWindow();
                            switchToWindow();
                        }
                        diMCD.clickOnMCDCloseWindow();
                        diHome.logOut();

                        //Creating Second Call with same member number
                        navigateToApplication("CR");
                        login(data.get("CRLoginName"), data.get("Password"));
                        waitcloseAllBusyIcons();

                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemTypeNew"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();


                        common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        services.clickOnServiceTab();
                        services.enterManualSpotDetails(data.get("facilityNumber"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.saveButton();
                        home.allErrorAlerts();
                        String callIDNew = services.getCallId();
                        services.closeCall();
                        home.logout();

                        navigateToApplication("DI");
                        waitcloseAllBusyIcons();
                        login(data.get("DILoginName"), data.get("Password"));
                        common.clickOnProceedBtnForDispatchSPPLogin();
                        diHome.clickOnSearchCallsLink();
                        //Searching for a call
                        diHome.enterStartDateOnSearchCallsWindow(startDate);
                        diHome.enterCallIDInfo(callIDNew);
                        diHome.enterMemberNumberInfo(Member);
                        diHome.clickOnSearchInSearchCalls();
                        //diSearchCalls.selectSPStatusRowInSearchCallDispatch();
                        diHome.clickOnCallDateOrIDLink();
                        if(data.get("popout").equals("Yes")){
                            diMCD.maximizeMCDWindow();
                            switchToWindow();
                        }
                        diMCD.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
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

                        dimcd.selectExitCode();
                        //Checking and entering the reason code
                        //boolean reasonCodeTextBoxAvailability = diMCD.validateDisaleReasonCodeTextBoxForEdit();
                        if (!reasonCodeTextBoxAvailability) {
                            diMCD.enterReason(data.get("reason"));
                            diMCD.clickOnContinue();

                        }else{
                            assertTrue(reasonCodeTextBoxAvailability, "<b>ReasonCode text box is not editable</b>");
                            diMCD.clickOnContinue();
                        }
                        //boolean errorMessageExists=diMCD.verifyE213ErrorMessageAvailablity();
                        if(!errorMessageExists) {

                            //Checking for Orignial Tow destination
                            if (data.get("clearType").equalsIgnoreCase("NOGO")) {
                                boolean TowDestinationVisibility = diMCD.verifyOriginalTowDestination();
                                if (TowDestinationVisibility) {
                                    if (data.get("TowConfirmation").equalsIgnoreCase("Original")) {
                                        boolean visibilityOfOriginalTowButton = diMCD.verifyOriginalTowDestination();
                                        if (visibilityOfOriginalTowButton) {
                                            diMCD.clickOnOriginalTowDestination();
                                            diMCD.clickOnSubmit();
                                            diMCD.clickOnSubmit();

                                        } else {
                                            //assertTrue(visibilityOfOriginalTowButton != true, "<b>Original Tow Destination Button is not available </b>");
                                            assertTrue(!visibilityOfOriginalTowButton , "<b>Original Tow Destination Button is not available </b>");
                                            diMCD.clickOnNoTowPerformed();
                                            diMCD.clickOnSubmit();
                                            diMCD.clickOnSubmit();
                                        }
                                    } else {
                                        Thread.sleep(5000);

                                        diMCD.clickOnSubmit();
                                    }
                                }
                            }
                            //diMCD.clickOnSubmit();
                            //Checking for Battery questionaires
                            boolean visibilityOfBatteryQuestionaier1=diMCD.verifyBatteryQuestionarierInMCDWindow();
                            if (visibilityOfBatteryQuestionaier1) {
                                diMCD.clickAndEnterBatteryInformation(data.get("ODOMeterreading"), data.get("BatteryComments"), data.get("TestCode"), data.get("BatteryType"), data.get("BatteryPrice"));
                            } else {
                                reporter.failureReport("Questinaries page availablity ", "Questionaries page is not available");
                            }
                            diMCD.clickOnSubmit();
                            //Entering Values in APD Window
                            boolean visibilityOfAPDWindow=diMCD.visibilityOfAPDHeader();
                            if (visibilityOfAPDWindow) {
                                diMCD.enterServiceAndChargesOnMCDWindow(data.get("serviceType"));
                                diMCD.enterCostInServiceAndChargesInMCDWindow(data.get("cost"));
                                diMCD.enterCashCollectedInServiceAndChargesInMCDWindow(data.get("cashCollected"));
                                Thread.sleep(5000);
                                diMCD.clickOnSubmit();
                            }
                            String spotStatus1 = diMCD.getCallStatusOnMCDwindow();
                            assertTrue(spotStatus1.equalsIgnoreCase("CL - Cleared"), "<b>The currrent Status is:: " + spotStatus1 + " Selected Battery call Cleared Successfully </b>");
                            diMCD.clickOnMemberTabInMCDWindow();
                            diMCD.clickOnShowBatteryServiceHistory();
                            boolean availablityOfShowHisotryButton=diMCD.verifyOnShowBatteryServiceHistory();
                            if(availablityOfShowHisotryButton){
                                diMCD.clickOnShowBatteryServiceHistory();
                            }

                            boolean tabAvailability2 = dimcd.verifyShowBatteryServiceHisotryTabAvailablity();

                            if (tabAvailability2) {
                                assertTrue(tabAvailability2, "Battery information Tab opened");
                                boolean dateAndCallLinkVisibility = dimcd.verifyDateAndCallIdVisibilityInShowBatteryHistory();
                                if (dateAndCallLinkVisibility) {
                                    reporter.SuccessReport("Call id's","First call id is '"+callID+"' second call id is '"+callIDNew+"'");
                                    diMCD.verifyBatteryHisotryInformation(callID);
                                    diMCD.verifyBatteryHisotryInformation(callIDNew);
                                    dimcd.clickOnDateAndCallIdInShowBatteryHistory();
                                    waitcloseAllBusyIcons();
                                    switchToWindow();
                                    boolean printButton1 = dimcd.verifyPrintButton();
                                    assertTrue(printButton1, "Print Page opened");
                                    boolean nodata = dimcd.verifyNoDataMessage();
                                    if (nodata) {
                                        dimcd.getNoDataMessage();
                                        reporter.failureReport("A Print Call Detail view screen should come up with the Battery Service History call details", "Data Not available " + nodata);
                                    }
                                    switchToWindow();
                                    closeWindow();
                                    switchToWindow();
                                    boolean visibilityOfClosIcon=diMCD.verifyClosedMCDWindow();
                                    if(visibilityOfClosIcon) {
                                        diMCD.clickOnMCDCloseWindow();
                                        //dimcd.clickOnDoneButtonInBatteryInformationWindow();
                                    }
                                } else {
                                    reporter.failureReport("Show Battery History details", "Show Battery History details are not visible", driver);
                                }
                            } else {
                                reporter.failureReport("Show Battery History Tab", "Show Battery History details are not visible", driver);
                            }

                            boolean availablityOfDoneButton=diMCD.verifyDoneButtonInBatteryInformationWindow();
                            if(availablityOfDoneButton) {
                                dimcd.clickOnDoneButtonInBatteryInformationWindow();
                            }
                        } else{
                            String error=diMCD.getE213ErrorMessage();
                            reporter.failureReport("Clear Call", "User is not able to clear the call because of this error "+error);
                            diMCD.clickOnE213OkayButton();
                            //diMCD.clickOnMCDCloseWindow();
                        }
                        if(data.get("popout").equals("Yes")){
                            diMCD.minimizeMCDWindow();
                            switchToWindow();
                            //
                           /* driver.close();
                            switchToWindow();*/
                        }
                        //diMCD.clickOnMCDCloseWindow();
                        diHome.logOut();

                    } //enable thisif weare not using commoncallcreationmethod

			                    System.out.println("Test completed");
			                }
			    			catch(Exception e)
			    			{
			    				ReportStatus.blnStatus=false;
                                reporter.failureReport("Exception Occured","Exception Occured",driver);
                                reporter.warningReport("Error Description"," "+e.toString());
                            }
			    			fnCloseTest();
			    			ReportControl.fnEnableJoin();
			    			ReportStatus.fnUpdateResultStatus("DI","1940",ReportStatus.strMethodName,intCounter,browser);
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
