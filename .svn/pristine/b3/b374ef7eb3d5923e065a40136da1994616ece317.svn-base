package com.aaa.web.script;

import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRServicePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;

import java.util.Hashtable;


public class TC_DICallClearingLightService extends DILoginLib {
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String level;
    public static String levelMCD;
    public static int totalnumberOfSpecialEquipment;


    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void clearCallLightServices(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCallLightServices", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCallLightServices", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2094: TS-DI Call Clearing Light Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" for Member Type "+data.get("dbqueryFileName")+"and Member Number is"+data.get("Member") +"   **************");
		
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
					if (data.get("Member").equals("db")){
						//fetch member details from db
						//generating a random number everytime to fetch a new record everytime
						int rownum = IntRandomNumberGenerator(50,1000);
						//member from db
						Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
						System.out.println("member : "+Member);
					}
					else
					{
						Member = data.get("Membersearch");
					}

                    boolean visibilityOfMessageBox = home.verifyMessageDialogBoxClose();
                    if(visibilityOfMessageBox==true) {
                        home.closeMessageDialogBoxClose();
                    }
					if(Member==null) {
                        home.logout();
                        assertTrue(Member == null, data.get("dbqueryFileName") + " ::Query not return Member number");
                    }else{

                        //Creating a new call
					home.memberSearchTextBox(Member);
					member.memberNumClick();
					locations.breakdownLocTabSel();
					locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
					locations.getLatitudeValue();
					locations.getLongitudeValue();
					common.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("vehicleType"),data.get("ProblemTriage"),data.get("ProblemType"));
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();

                    home.clickOnCallSummaryButton();
                    String TroubleCode= home.getTroubleCodeValueFromCallDetailsPopup();
                    home.closeCallSummaryPopupWindow();

                    common.crTowDestinationTab(data.get("WillThisCallBeATow"),data.get("TowDestination"),data.get("RSPReferral"),data.get("TowAddress"));
                        services.clickOnServiceTab();
                            services.enterManualSpotDetails(data.get("facilityNumber"));
                            vehicle.handleScriptErrorInVehicleTriagePage();


		                home.saveButton();
                        waitcloseAllBusyIcons();
		                home.allErrorAlerts();
		                callID=services.getCallId();
		                services.closeCall();
		                home.logout();
		            //Naviagte into Dispatch application
		                navigateToApplication("DI");
		                waitcloseAllBusyIcons();
		                login(data.get("DILoginName"),data.get("Password"));
                        boolean visibilityOfProceedButton=role.verifyVisibilityOProceedBtnInDispatchRoleLogin();
                        if(visibilityOfProceedButton)
                        {
                            role.selectRoleInDispatch("DI - Dispatcher");
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
		                pacesetterCode = diMCD.getPaceSetterCodeOnSummaryTab();
		                //Adding Payment
						//diMCD.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));

					// Thread.sleep(3000);
		                String currentPaceCode[] = pacesetterCode.split("-");
		                String paceSetterCode = currentPaceCode[0]; //facilityname
                        //Comparing Call receiving and MCD window Pacesetter code
		                assertTrue(data.get("ProblemType").contains(paceSetterCode),"<b>pacesetter code that we  selected populates the reason code based on the mapping</b>");
		                //COmpaing trouble Code
		                troubleCode=diMCD.getTroubleCodeOnSummaryTab();
		                String troubleC[]=troubleCode.split("- ");
		                String troubleCodeValue=troubleC[1];
		                assertTrue(TroubleCode.contains(troubleCodeValue),"<b> trouble code displays in MCD Window::  "+troubleCodeValue+"  ::based on the mapping in Call Receiving "+TroubleCode+"</b>");
		                //clear call
		               	String troubleCodeInClearCallScreen= diMCD.clearCallID(data.get("clearType"),data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("reason"));

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
    			ReportStatus.fnUpdateResultStatus("DI","2094",ReportStatus.strMethodName,intCounter,browser);
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