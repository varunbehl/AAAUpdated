package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Hashtable;


public class TC_DICallClearingLocksmith extends DILoginLib {
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

    public void clearCallLockSmith(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCallLockSmith", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCallLockSmith", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2001: TC-DI Call Clearing Locksmith"+ " From Iteration " + StartRow + " to " + EndRow );
                        reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" for Member Type:: "+data.get("dbqueryFileName")+" ::and Member Number is:: "+data.get("Member") +" ::And Pacesetter Code is:: "+data.get("ProblemType")+"   **************");
		
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
		                CommonLib common=new CommonLib();

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

					/*
					if(data.get("Member").equals("db")&&Member==""){
                        Member = data.get("Membersearch");
                    }*/
					boolean visibilityOfMessageBox = home.verifyMessageDialogBoxClose();
					if (visibilityOfMessageBox == true) {
						home.closeMessageDialogBoxClose();
					}
					if (Member == null) {
						home.logout();
						assertTrue(Member == null, data.get("dbqueryFileName") + " ::Query not return Member number");
					} else {
                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        locations.getLatitudeValue();
                        locations.getLongitudeValue();
                        common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();
                        //Getting TroubleCode value from summary section
                        home.clickOnCallSummaryButton();
                        String TroubleCode = home.getTroubleCodeValueFromCallDetailsPopup();
                        home.closeCallSummaryPopupWindow();
                        //Validating anc working onTOw Destination
                        common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        services.clickOnServiceTab();
                        services.enterManualSpotDetails(data.get("facilityNumber"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.saveButton();
                        home.allErrorAlerts();
                        callID = services.getCallId();
                        services.closeCall();
                        home.logout();

                        //Login into DI
                        navigateToApplication("DI");
                        waitcloseAllBusyIcons();
                        login(data.get("DILoginName"), data.get("Password"));
                        common.clickOnProceedBtnForDispatchSPPLogin();
                        diHome.clickOnSearchCallsLink();
                        //Searching for a call
                        String currentDate = common.getCurrentDate();
                        String startDate = common.getPreviousDate(currentDate);
                        diHome.enterStartDateOnSearchCallsWindow(startDate);
                        diHome.enterCallIDInfo(callID);
                        diHome.enterMemberNumberInfo(Member);
                        diHome.clickOnSearchInSearchCalls();
                        diHome.clickOnCallDateOrIDLink();
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
                        diMCD.paymentForRAPCall(data.get("cost"), data.get("cashCollected"), data.get("serviceType"), data.get("towServiceType"));
                        //Clearing the call
                        boolean statusUpdateButtonsAvailablity = diMCD.visibilityOfStatusUpdateButtons();
                        if (statusUpdateButtonsAvailablity) {
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
                            if (data.get("clearType").equalsIgnoreCase("NOGO")) {
                                diMCD.clickOnNoGo();
                            }

                            diMCD.selectExitCode();
                            //Checking and entering the reason code
                            boolean reasonCodeTextBoxAvailability = diMCD.validateDisaleReasonCodeTextBoxForEdit();
                            if (!reasonCodeTextBoxAvailability) {
                                diMCD.enterReason(data.get("reason"));
                                diMCD.clickOnContinue();

                            } else {
                                assertTrue(reasonCodeTextBoxAvailability, "<b>ReasonCode text box is not editable</b>");
                                diMCD.clickOnContinue();
                            }
                            boolean errorMessageExists = diMCD.verifyE213ErrorMessageAvailablity();
                            if (errorMessageExists) {
                                diMCD.getE213ErrorMessage();
                                diMCD.clickOnE213OkayButton();
                            }
                            //Checking for Orignial Tow destination
                            if (data.get("clearType").equalsIgnoreCase("NOGO")) {
                                boolean TowDestinationVisibility = diMCD.verifyOriginalTowDestination();
                                if (TowDestinationVisibility == true) {
                                    if (data.get("TowConfirmation").equalsIgnoreCase("Original")) {
                                        boolean visibilityOfOriginalTowButton = diMCD.verifyOriginalTowDestination();
                                        if (visibilityOfOriginalTowButton == true) {
                                            diMCD.clickOnOriginalTowDestination();
                                            diMCD.clickOnSubmit();
                                            diMCD.clickOnSubmit();

                                        } else {
                                            assertTrue(visibilityOfOriginalTowButton != true, "<b>Original Tow Destination Button is not available </b>");
                                            diMCD.clickOnNoTowPerformed();
                                            diMCD.clickOnSubmit();
                                            diMCD.clickOnSubmit();
                                        }
                                    } else {
                                        diMCD.clickOnSubmit();
                                    }
                                } else {
                                    boolean noTow = diMCD.visibilityOfNoTowPerformed();
                                    if (noTow)
                                        diMCD.clickOnNoTowPerformed();
                                    //diMCD.clickOnSubmit();
                                }
                            }
                            diMCD.clickOnSubmit();
                            //Entering Values in APD Window
                            boolean visibilityOfAPDWindow = diMCD.visibilityOfAPDHeader();
                            if (visibilityOfAPDWindow) {
                                diMCD.enterServiceAndChargesOnMCDWindow(data.get("serviceType"));
                                diMCD.enterCostInServiceAndChargesInMCDWindow(data.get("cost"));
                                diMCD.enterCashCollectedInServiceAndChargesInMCDWindow(data.get("cashCollected"));
                                diMCD.clickOnSubmit();
                            }
                            String spotStatus = diMCD.getCallStatusOnMCDwindow();
                            assertTrue(spotStatus.equalsIgnoreCase("CL - Cleared"), "<b>The currrent Status is:: " + spotStatus + " Selected cash call Cleared Successfully </b>");
                            diMCD.clickOnMCDCloseWindow();
                            diHome.logOut();
                        }else{
                            assertTrue(statusUpdateButtonsAvailablity,"Status Update buttons are visible");
                            diMCD.clickOnMCDCloseWindow();
                            diHome.logOut();
                        }
                    }

					diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2001",ReportStatus.strMethodName,intCounter,browser);
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