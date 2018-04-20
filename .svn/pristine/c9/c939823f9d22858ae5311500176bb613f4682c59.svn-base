package com.aaa.web.script;


import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRWorkFlowScript extends CRHomeLib {
	boolean errorMessage;
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void workFlows(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"workFlow", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("workFlow", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1679:TC-CR-WorkFlows"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					LoginLib login = new LoginLib();
					CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRLocationsLib location = new CRLocationsLib();
					CRTowDestinationLib tow = new CRTowDestinationLib();
					CRServiceLib service = new CRServiceLib();
					home.verifyandClickLogout();
					login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
					home.messageDialogBoxClose();
					CRSearchCallsLib searchCalls = new CRSearchCallsLib();
                   String Member = "";
                if (data.get("Member").equals("db")){
        	        //fetch member details from db
        	        //generating a random number everytime to fetch a new record everytime
        	        int rownum = IntRandomNumberGenerator(50,1000);
        	        //member from db
        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
        	        System.out.println("member : "+Member);
                }
                if(Member.isEmpty())
                {
                	Member = data.get("Membersearch");
                }
                home.memberSearchTextBox(Member);
                member.memberNumClick();
                member.currentCallClose();
                //Tring to save the call with all required fields Blank
					service.clickOnSaveBtn();
					boolean errorForRequiredField  = member.errorNotificationPresence();
					assertTrue(errorForRequiredField,"<b>Unable to save the call with required fields blank.</b>");
					assertTrue(errorForRequiredField,"<b> System throw an error to the user and directed  to the required field</b>");
					member.clickOnMemberTab();
					member.clickOnManualEntryLinkInMember();
					//Verify required fields on Member  Tab ,based on class name contains "required" .
					member.memFieldsVerification();

					vehicle.clickOnVehicleTriageTab();
					vehicle.clickOnManualEntryLinkOnVehicle();
					//Verify required fields on Vehicle triage Tab ,based on class name contains "required" .
					vehicle.vehicleFieldVerification();

					location.clickOnLocationTab();
					home.waitCloseAllBusyIconsResults();
					location.clickOnManualEntryLinkInLocation();
					//Verify required fields on Location  Tab ,based on class name contains "required" .
					location.locationFieldsVerification();
					tow.clickOnTowDestinationTab();
					tow.clickOnManualEntryLinkOnTowDestination();
					tow.verifyTowPassengers();


					//Click on save button and enter pacesetter code In redirected field
					service.clickOnSaveBtn();
					boolean errorMessageForPaceSetterCode =service.errorMsgForPacesetterCodeEntry();
					if(errorMessageForPaceSetterCode) {
						reporter.SuccessReport("Enter required Field","Enter paceSetter Code In redirected field");
						vehicle.selectpaceSettercode(data.get("pacesetterCode"));
						vehicle.scriptErrorHandle();
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}

					//Click On Save Button and Enter Vehicle Color In Redirected Field
					service.clickOnSaveBtn();
					 errorMessage = service.errorMessageForRequiredField();
					if(errorMessage){
						reporter.SuccessReport("Enter required Field","Enter Vehicle Color In redirected field");
						vehicle.enterVehicleColor(data.get("VehicleColor"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}

					//Click On Save Button and enter Vehicel make In Redirected field
					service.clickOnSaveBtn();
					 errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter Vehicle Make In redirected field");
						vehicle.enterVehicleMake(data.get("VehicleMake"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}
					//Click On Save Button and enter vehicle Model In redirected Field
					service.clickOnSaveBtn();
					errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter Vehicle model In redirected field");
						vehicle.enterVehicleModel(data.get("VehicleModel"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}
					//Click On Save and Enter Vehicle Type In Redirected Field
					service.clickOnSaveBtn();
					errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter Vehicle Type In redirected field");
						vehicle.enterVehicleType(data.get("VehicleType"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}
					//click On save buttton and Enter Vehicle Year In Redirected Field
					service.clickOnSaveBtn();
					errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter Vehicle Year In redirected field");
						vehicle.enterVehicleYear(data.get("VehicleYear"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}
					//Click On save  and enter tow Passengers In redirected Field
					service.clickOnSaveBtn();
					tow.enterTowPassengers(data.get("TowPassengers"));

					//click On save and Enter Street address In Redirected Field
					service.clickOnSaveBtn();
					errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter StreetAddress In redirected field");
						location.enterBKDownStreetAddress(data.get("BKDownStreetAddress"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}
					//Click on save button and Enter city in redirected field
					service.clickOnSaveBtn();
					errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter City name  In redirected field");
						location.enterBKDownCityLocation(data.get("BKDownCityLocation"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ",driver);
					}
					//Click On save and Enter Location code In Redirected Field
					service.clickOnSaveBtn();
					errorMessage = service.errorMessageForRequiredField();
					if(errorMessage) {
						reporter.SuccessReport("Enter required Field","Enter Location Code In redirected field");
						location.enterBKDownLocCode(data.get("BKDownLocCode"));
					}else{
						reporter.failureReport("Enter required Field","Not Redirected to required field ");
					}
					//Click On Save to create call after filling all mandatory fields
					service.clickOnSaveBtn();
					home.waitCloseAllBusyIconsResults();
					String callId = service.getCallId();
					service.closeCallWindow();

					//go to recent calls window to verify create call Id Is Unique or not
					home.clickOnSearchCallDroupDown();
					home.clickOnSearchCallsLink();
					home.enterCallIdForSearch(callId);
					home.clickOnSearchButtonOnSearchCalls();
					home.waitCloseAllBusyIconsResults();

					//Verification of  Unique call ID generation Fron Search Calls by searching the call id with today's date returns only 1 record.
					int isCallIdUnique = searchCalls.getCallIdListFromSearchCallsPage();
					assertTrue(isCallIdUnique==1,"<b>Call saved without error and receives a unique call ID</b>");
					searchCalls.clickOnCloseButton();
					home.logout();


					System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1679",ReportStatus.strMethodName,intCounter,browser);
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


