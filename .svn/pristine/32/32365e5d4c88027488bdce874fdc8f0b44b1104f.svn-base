package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRFieldAuditPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRFieldAudit extends DILoginLib {
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

    public void fieldAudit(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "fieldAudit", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("fieldAudit", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1948: CRFieldAudit " + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + " and this validation is for  "  +data.get("ValidationFor")+" and pacesetter Code is  "+data.get("ProblemType")+"  **************");
					CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CommonLib common = new CommonLib();
					CRSearchCallsLib searchcall=new CRSearchCallsLib();
					CRFieldAuditLib field=new CRFieldAuditLib();

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
                        /*vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();*/

                        common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        services.clickOnServiceTab();
                        home.saveButton();
                        home.allErrorAlerts();
                        callID = services.getCallId();
                        //Remain in call to update the call details to view the field audit
                        services.clickOnRemainInCall();
                        services.clickOnServiceTab();
                        services.clickOnCashOnServiceTab();
                        //Selecting RedFalg
                        services.clickOnRedFlagOnServiceTab();
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.saveButton();
                        home.allErrorAlerts();
                        //Entering Status update comments
						services.enterInResonForStatusStatus(data.get("reason"));
						common.tabout();
						String comments=getRandomString(15);
						services.enterInCommentStatus(comments);
						services.clickOnUpdateButtonOnCallStatusWindow();
						//Validating error alerts , if any error occures it will close the alert and exit from the next steps
                        boolean errorMessage=services.verifyE268ErrorMessageAvailablity();
                        if(!errorMessage) {
                            services.getCallId();
                            services.clickOnRemainInCall();
                            Thread.sleep(1000);
                            //Opening Field Audit window
                            searchcall.clickOnCurrentCallsDropDown();
                            field.selectFieldAuditPage();
                            //Validating field audit results grid
                            field.getFieldAuditValues();
                            field.clickOnCloseInFieldAudit();
                            home.logout();
                        }else{
                            String error=services.getE268ErrorMessage();
                            assertTrue(!errorMessage,"Call Updated:: ");
                            reporter.failureReport("call not updated","Call not Updated because of:: "+error,driver);
                            services.clickOnE268OKButton();
                            home.logout();
                        }
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