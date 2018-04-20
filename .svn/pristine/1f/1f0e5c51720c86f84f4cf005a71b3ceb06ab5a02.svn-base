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


public class TC_DICallClearingFullService extends DILoginLib {
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String level;
    public static String levelMCD;
    public static int totalnumberOfSpecialEquipment;


  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void clearCallFullServices(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCallFullServices", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("clearCallFullServices", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("2097: TS-DI Call Clearing Full Service" + " From Iteration " + StartRow + " to " + EndRow);
					//reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" for Member Type "+data.get("dbqueryFileName")+"and Member Number is"+data.get("Member") +"   **************");

					CRHomeLib home = new CRHomeLib();
					LoginRoleLib role = new LoginRoleLib();
					DIHomeLib diHome = new DIHomeLib();
					//CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CRTowDestinationLib tow = new CRTowDestinationLib();
					CR_DI crDI = new CR_DI();
					CommonLib common = new CommonLib();
					DISearchCallsLib diSearchCalls = new DISearchCallsLib();
					DIMCDLib diMCD = new DIMCDLib();

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

						home.clickOnCallSummaryButton();
						String TroubleCode = home.getTroubleCodeValueFromCallDetailsPopup();
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

						navigateToApplication("DI");
						waitcloseAllBusyIcons();
						login(data.get("DILoginName"), data.get("Password"));
						common.clickOnProceedBtnForDispatchSPPLogin();
						/*if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
							role.clickOnProceedBtnInDispatchRoleLogin();
							waitcloseAllBusyIcons();
							diHome.clickOnCloseIconOnQueueSelection();
						}else {
							waitcloseAllBusyIcons();
							diHome.closeFacilityWindow();
						}
*/
						diHome.clickOnSearchCallsLink();
						String currentDate=common.getCurrentDate();
						String startDate=common.getPreviousDate(currentDate);
						diHome.enterStartDateOnSearchCallsWindow(startDate);
						diHome.enterCallIDInfo(callID);
						diHome.enterMemberNumberInfo(Member);
						diHome.clickOnSearchInSearchCalls();
						diSearchCalls.selectSPStatusRowInSearchCallDispatch();
						pacesetterCode = diMCD.getPaceSetterCodeOnSummaryTab();
						//diMCD.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
						String currentPaceCode[] = pacesetterCode.split("-");
						String paceSetterCode = currentPaceCode[0]; //facilityname
						assertTrue(data.get("ProblemType").contains(paceSetterCode),"<b>pacesetter code that we  selected populates the reason code based on the mapping</b>");
						troubleCode=diMCD.getTroubleCodeOnSummaryTab();
						String troubleC[]=troubleCode.split("- ");
						String troubleCodeValue=troubleC[1];
						assertTrue(TroubleCode.contains(troubleCodeValue),"<b> trouble code displays in MCD Window::  "+troubleCodeValue+"  ::based on the mapping in Call Receiving "+TroubleCode+"</b>");
						String troubleCodeInClearCallScreen=diMCD.clearCallID(data.get("clearType"), data.get("TowConfirmation"), data.get("DITowConfComments"), data.get("DITowConfEnterAddress"), data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"), data.get("DITowConfEnterOtherAddress"), data.get("reason"));
						String troubleCodeExit[]=troubleCodeInClearCallScreen.split("- ");
						String troubleCodeValueInExit=troubleCodeExit[1];
						assertTrue(TroubleCode.contains(troubleCodeValueInExit),"<b> trouble code displays in MCD Window::  "+troubleCodeInClearCallScreen+"  ::based on the mapping in Call Receiving "+TroubleCode+"</b>");

						diMCD.clickOnMCDCloseWindow();
						diHome.logOut();
					}
				}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2097",ReportStatus.strMethodName,intCounter,browser);
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