package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.accelerators.ActionEngine;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRServicePage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRUpdateCalls extends ActionEngine {
	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();
	DIMCDLib mcd = new DIMCDLib();




	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void crUpdateCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crUpdateCalls", TestData, "D3CallRecieving");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    				fnOpenTest();
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crUpdateCalls", TestData, "D3CallRecieving",intCounter);
	    	
						this.reporter.initTestCaseDescription("1713: TC-Update Calls"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						login.login(data.get("LoginName"), data.get("Password"));
						member.clickOnPartialCallCloseButton();
						home.messageDialogBoxClose();
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
						home.memberSearchTextBox(Member);
						//home.memberSearchTextBox(data.get("Membersearch"));
						member.memberNumClick();
						member.currentCallClose();
						member.clickPrimRadioBtnSecondRow();
						location.clickOnLocationTab();
						location.enterBreakDownAddressOmniBarSearch(data.get("address"));
						vehicle.clickOnVehicleTriageTab();
						vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
						vehicle.enterPaceSetterCodeManually(data.get("pacesettercode"));
						Thread.sleep(3000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						vehicle.scriptErrorHandle();
						service.clickOnServiceTab();
						Thread.sleep(3000);
						service.validateNoFacilityAutoSpot();
						Thread.sleep(2000);
						home.saveButton();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						Thread.sleep(2000);
						home.allErrorAlerts();

						services.clickOnCallStatusButton();
						services.clickOnDateToArrange();
						home.allErrorAlerts();
						services.verifyToGetCallStatus(data.get("CallStatusForRE"));
						services.getTextOfStatusValue();
						services.getTextOfResonValue();
						services.getTextOfUserNameValue();
						services.getTextOfRoleNameValue();
						services.clickOnCallStatusButton();

						service.clickOnServiceTab();
						services.enterManualFacilityNumber(data.get("facilityNumber"));
						services.clickOnSpotInServicePage();
						Thread.sleep(5000);
						home.allErrorAlerts();
						Thread.sleep(2000);
						services.getTextCallStatusButton();
						home.saveButton();
						Thread.sleep(2000);
						services.getTextAndClickOnYesInSpStatusPopup();
						Thread.sleep(2000);
						services.verifyUpdateCallStatus();
						services.verifyUpdateIsNotClikable();
						services.enterInCommentStatus(data.get("commentStatusUpdate1"));
						Thread.sleep(2000);
						services.verifyUpdateIsNotClikable();
						Thread.sleep(2000);
						services.enterInResonForStatusStatus(data.get("statusReason1"));
						services.clickOnComment();
						services.verifyUpdateIsNowClikable();
						Thread.sleep(2000);
						home.allErrorAlerts();
						services.clickUpdateButton();
						Thread.sleep(2000);
						services.clickOnRemainInCall();
						home.allErrorAlerts();

						services.getTextCallStatus();
						services.clickOnCallStatusButton();
						services.clickOnDateToArrange();
						home.allErrorAlerts();
						services.getTextStatusValueInCallStatus();
						Thread.sleep(2000);
						services.getTextFacilityValueInCallStatus();
						home.clickOnExpandAllCommentsInStausHistoryWindow();
						home.clickOnCloseIconOnStatusHistoryPage();
						home.saveButton();

						services.verifyUpdateCallStatus();
						services.verifyAuditStatusCode();
						services.enterInCommentStatus(data.get("commentStatusUpdate2"));
						services.enterInResonForStatusStatus(data.get("statusReason2"));
						services.clickOnComment();
						services.verifyUpdateIsNowClikable();
						Thread.sleep(2000);
						services.clickUpdateButton();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						home.allErrorAlerts();
						services.statusValueIsStillSpButNotUp();
						home.allErrorAlerts();

						location.clickOnLocationTab();
						Thread.sleep(5000);
						location.clickOnManualEntryLinkInLocation();
						Thread.sleep(3000);
						location.enterTxtinBrkDowLocSrch(data.get("AddressLookup"));
						Thread.sleep(3000);
						location.brkDowLocSrchBtn();
						Thread.sleep(3000);
						location.getNumberOfRecordsInResultsGrid();
						Thread.sleep(3000);
						location.clickOnLocationResultsLink();
						Thread.sleep(3000);
						location.acceptAddressDifferenceAlert();
						Thread.sleep(3000);
						location.enterBlockRange(data.get("StreetNumber2"));
						String StreetNumber2=getAttributeByValue(CRLocationsPage.txtStreetNumber,"street number 2");
						Thread.sleep(3000);
						location.enterBKDownStreetAddress(data.get("StreetAddress2"));
						String StreetAddress2=getAttributeByValue(CRLocationsPage.txtStreetAddressInput,"street address 2");
						Thread.sleep(3000);
						location.enterBKDownCityLocation(data.get("City2"));
						String city2=getAttributeByValue(CRLocationsPage.txtLocCity,"city 2");
						Thread.sleep(3000);
						location.enterBKDownState(data.get("State2"));
						String State2=getAttributeByValue(CRLocationsPage.txtLocState,"State 2");
						Thread.sleep(3000);
						location.enterBKDownLocCode(data.get("LocationCode2"));
						getAttributeByValue(CRLocationsPage.txtLocCode,"location code2");
						Thread.sleep(3000);
						vehicle.clickOnVehicleTriageTab();
						Thread.sleep(3000);
						vehicle.clickOnManualEntryLinkOnVehicle();
						Thread.sleep(3000);
						vehicle.selectExistingVehicleModel();
						Thread.sleep(3000);
						vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
						Thread.sleep(3000);
						vehicle.problemTriage(data.get("ProblemTriage"),data.get("ProblemType"));
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.scriptErrorHandle();
						getAttributeByValue(CRVehicleTriagePage.txtSelectedPaceSetterCodes,"paceSetterCode 2");
						Thread.sleep(7000);
						service.clickOnServiceTab();
						home.allErrorAlerts();
						services.enterManualFacilityNumber(data.get("facilityNumber2"));
						services.clickOnSpotInServicePage();
						Thread.sleep(3000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						String facilityNumber=getText(CRServicePage.txtSpotFacilityLabel,"Fcaility 2");
						service.clickOnRedFlagOnServiceTab();
						service.verifyRedFlagIcon();
						Thread.sleep(3000);
						home.saveButton();
						home.allErrorAlerts();

						services.verifyUpdateCallStatus();
						Thread.sleep(3000);
						services.verifyAuditStatusCode();
						Thread.sleep(3000);
						services.enterInCommentStatus(data.get("commentStatusUpdate2"));
						services.enterInResonForStatusStatus(data.get("statusReason1"));
						services.clickOnComment();
						services.verifyUpdateIsNowClikable();
						Thread.sleep(2000);
						services.clickUpdateButton();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						home.allErrorAlerts();
						vehicle.handleScriptErrorInVehicleTriagePage();
		
						location.clickOnLocationTab();
						vehicle.handleScriptErrorInVehicleTriagePage();
						Thread.sleep(5000);
						location.clickOnManualEntryLinkInLocation();
						Thread.sleep(3000);
						assertTextStringMatching(StreetNumber2,data.get("StreetNumber2"));
						Thread.sleep(2000);
						assertTextStringMatching(StreetAddress2,data.get("StreetAddress2"));
						Thread.sleep(2000);
						assertTextStringMatching(city2,data.get("City2"));
						Thread.sleep(2000);
						assertTextStringMatching(State2,data.get("State2"));
						Thread.sleep(2000);
						Thread.sleep(2000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.clickOnVehicleTriageTab();
						Thread.sleep(3000);
						assertTrue(getText(CRVehicleTriagePage.selectPacesetterCode,"pacesetter").contains(data.get("ProblemTriage")),"pacesetter code saved/updated without issue");
						Thread.sleep(3000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						service.clickOnServiceTab();
						home.allErrorAlerts();
						assertTrue(data.get("facilityNumber2").contains(facilityNumber),"facility changes saved/updated without issue");
						home.allErrorAlerts();
						Thread.sleep(5000);
						assertTrue(service.verifyRedFlagIcon(),"call flagged is red");
						home.saveButton();
						home.allErrorAlerts();
						service.clickOnCancel();
						home.allErrorAlerts();
						home.logout();


	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("CR","1713",ReportStatus.strMethodName,intCounter,browser);
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