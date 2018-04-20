package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRD3AutoSpotgrid extends DILoginLib {
    public static String callID;
    public static String pstTimeZone;
    public static String newZone;
    public static String autoSpotId;
    public static String numberOfSpecialEquipment;
    public static int totalnumberOfSpecialEquipment;


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: autoSpotGridForFullService
     * description :: autoSpotGridForFullService
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGrid(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification " + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + " and this validation is for  "  +data.get("ValidationFor")+" and pacesetter Code is  "+data.get("ProblemType")+"  **************");
					CRHomeLib home = new CRHomeLib();
					LoginRoleLib role = new LoginRoleLib();
					DIHomeLib diHome = new DIHomeLib();
					CRHomeLib crHomeLib = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CRTowDestinationLib tow = new CRTowDestinationLib();
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
						vehicle.clickOnVehicleTriageTab();
                        vehicle.enterVehicleDetailsManually(data.get("VehicleDetails"));
						vehicle.enterPaceSetterCodeManually(data.get("ProblemType"));
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.scriptErrorHandle();
						services.clickOnServiceTab();
						String autoID=services.getFacilityIDInServicesTab();
						services.validateFacilityAutospotID();
						services.getFacilityType();
						common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        if(data.get("WillThisCallBeATow").equals("Yes")) {
                            tow.getLatLongValue();
                            services.clickOnServiceTab();

                        }
                        if(data.get("specialEqupmentAvailablity").equals("Yes")){
                            numberOfSpecialEquipment = data.get("count");
                            totalnumberOfSpecialEquipment = Integer.parseInt(numberOfSpecialEquipment);
                            for (int i = 1; i <= totalnumberOfSpecialEquipment; i++) {
                                services.enterSpeciLEquipment(data.get("SpecialEquipment" + i));
                                home.allErrorAlerts();
                                Thread.sleep(6000);
                                home.waitCloseAllBusyIconsResults();
                                String specialEquipmentAutoSpotId = services.getFacilityIDInServicesTab();
                                assertTrue(!specialEquipmentAutoSpotId.equals(autoID),"Both Auto spot "+autoID+" and Special Equipment facility "+specialEquipmentAutoSpotId+" are different");
                            }
                        }

						home.saveButton();
						home.allErrorAlerts();
						callID = services.getCallId();
						services.closeCall();
						home.logout();
					}
				}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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