package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRD3ProportionalSpotCity extends DILoginLib {
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String level;
    public static String levelMCD;
    public static int totalnumberOfSpecialEquipment;


  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void CRD3ProportionalSpotCity(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRD3ProportionalSpotCity", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("CRD3ProportionalSpotCity", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1712: TS-CR D3 Proportional Spot City" + " From Iteration " + StartRow + " to " + EndRow);
					//reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" for Member Type "+data.get("dbqueryFileName")+"and Member Number is"+data.get("Member") +"   **************");

					CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CommonLib common = new CommonLib();

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
						//services.clickOnServiceTab();
						home.saveButton();
						home.allErrorAlerts();
						callID = services.getCallId();
						services.closeCall();
						home.logout();
						reporter.SuccessReport("Call Created number : ","<b>**************::  "+ intCounter+" Call(s) Created **************</b>");
					}
				}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1712",ReportStatus.strMethodName,intCounter,browser);
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