package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIDupeCall extends ActionEngine {

    public static  String callId;
    DIHomeLib diHome = new DIHomeLib();
    LoginLib login = new LoginLib();
    DILoginLib diLogin = new DILoginLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DIMCDLib mcdlib = new DIMCDLib();
    CRServiceLib service = new CRServiceLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CommonLib commonLib = new CommonLib();
    //Create Call

    
/************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    *************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveCallForDIDupeCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForDIDupeCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForDIDupeCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("2024_DIDupe Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                Thread.sleep(4000);
		                login.login(data.get("LoginName"), data.get("Password"));
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.verifyHomeScreen();
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
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
		                Thread.sleep(2000);
						crLocationsLib.breakdownLocTabSel();
						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
						//To enter Vehicle Information
						commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "",data.get("ProblemTriage"), data.get("ProblemType"));
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
						crHomeLib.allErrorAlerts();
						Thread.sleep(2000);
						service.clickOnServiceTab();
						crHomeLib.waitCloseAllBusyIconsResults();
						service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
						Thread.sleep(3000);
						crHomeLib.saveButton();
						crHomeLib.waitCloseAllBusyIconsResults();
						Thread.sleep(3000);
						callId = service.getCallId();
						service.closeCall();
						crHomeLib.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2024",ReportStatus.strMethodName,intCounter,browser);
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

   /* Verify dupeCall Info Verification On Dispatch MCD Window popped in popped out mode
    Test case will fail in SPP Dispatch because Dupecall button is not visible*//*
    *//************************************************************************
    * Script Name :-
    * Method Name :-dupeCallInfoVerificationInPoppedInAnDPoppedOutMCDWindow
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 

    * @throws Throwable
    *************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void dupeCallInfoVerificationInPoppedInAnDPoppedOutMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIDupeCall", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIDupeCall", TestData, "D3Dispatch",intCounter);
    	
			            this.reporter.initTestCaseDescription("2024_DIDupe Call"+ " From Iteration " + StartRow + " to " + EndRow );
			            reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			            //Calling the Common Function to go to MCD Window
			            commonFunToGoToMCDWindow(data);
			            //Calling common Function to Verify Duplicall Information
			            verificationOfDuplicatiteCall(data);
			            mcdlib.closeTheOpendCallInMCD();
			            Thread.sleep(2000);
			            switchToWindow();
					    //Verify poppedOut arrow available or Not.If arrow is available then Click on the arrow and Verifing duplicate call Information In Popped Out MCD Window
                        boolean poppedOutButtonFlag = mcdlib.verifyPoppedOutButtonOnMCD();
                        if (poppedOutButtonFlag) {
						mcdlib.maximizeMCDWindow();
						crHomeLib.waitCloseAllBusyIconsResults();
						switchToWindow();
						assertTrue(poppedOutButtonFlag, "<b>MCD Window is PoppedOut</b>");
						assertTrue(poppedOutButtonFlag, "<b>Verification Of dupecall Information On Popped Out MCD Window</b>");
						//Calling common Function to Verify Duplicall Information
						verificationOfDuplicatiteCall(data);
						mcdlib.minimizeMCDWindow();
						switchToWindow();
						mcdlib.closeTheOpendCallInMCD();

					}
					crHomeLib.logout();


    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2024",ReportStatus.strMethodName,intCounter,browser);
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

    //Common Functionality to go to MCD Window In Dispatch and SPP Dispatch
    public void commonFunToGoToMCDWindow(Hashtable<String,String> data) throws Throwable{
		commonLib.loginToDIAndClickOnSearchCalls(data.get("LoginName"), data.get("Password"),data.get("SPPOrDI"));
        diSearchCalls.clickAndEnterCallIDInfo(callId);
        diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
        crHomeLib.waitCloseAllBusyIconsResults();
        diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
        Thread.sleep(2000);
    }
    //Common Functionality for validating the  Duplicate call
    public void verificationOfDuplicatiteCall(Hashtable<String,  String> data)throws  Throwable{
        boolean duplicateCallButtonVisible =  mcdlib.verifyDuplicateCallButton();
        if(duplicateCallButtonVisible) {
            //Get Callid , Facility, PaceSetter Code Comments and Reason Before clicking On DupeCall icon
            String callIdBeforeDupeCall = mcdlib.getCallIdFromMcdWindow();
            String paceSetterCodeFromSummary = mcdlib.getPaceSetterCodeFromSummary();
            crHomeLib.waitCloseAllBusyIconsResults();
            String facilityValue = mcdlib.getFacilityFromFacilitySummary();

            mcdlib.clickOnDuplicateCallIcon();
            //verify DulicateThisCall Tab
            String duplicateCallTab = mcdlib.verifyDulicateThisCallTab();
            boolean dupeCallTabFlag = duplicateCallTab != null;
            assertTrue(dupeCallTabFlag, "<b>Verified the Duplicate Call Tab & </b>" + duplicateCallTab + "<b> is opened</b>");
            //verify Current Call option
            String currentCallInfoOption = mcdlib.verifyCurrentCallInfoOption();
            boolean currentCallFlag = currentCallInfoOption != null;
            assertTrue(currentCallFlag, "<b>Verified the Current Call option , Option name on the Duplicate Call Tab  is   ::</b>" + currentCallInfoOption);
            //Verify Call Id Option
            String callIdOption = mcdlib.verifryCallIdOnDuplicateThisCallTab();
            boolean callIdOptionFlag = callIdOption != null;
            assertTrue(callIdOptionFlag, "<b>Verified the Call ID option , Option name on the Duplicate Call Tab is   :: </b> " + callIdOption);
            //verify Facility
            String facilityOption = mcdlib.verifryFacilityOnDuplicateThisCallTab();
            boolean facilityOptionFlag = facilityOption != null;
            assertTrue(facilityOptionFlag, "<b>Verified the Facility Option  , Option name on the Duplicate Call Tab is   ::  </b>" + facilityOption);
            //VerifyTruckId
            String truckOption = mcdlib.verifyTruckOnDuplicateThisCallTab();
            boolean truckIdFlag = truckOption != null;
            assertTrue(truckIdFlag, "<b>Verified the Truck Option  , Option name on the Duplicate Call Tab is   ::  </b>" + truckOption);
            //verify PaceSetterCode
            String paceSetterCode = mcdlib.verifyPaceSetterCodeOnDuplicateThisCallTab();
            boolean paceSetterCodeFlag = paceSetterCode != null;
            assertTrue(paceSetterCodeFlag, "<b>Verified the PaceSetter Code Option  , Option name on the Duplicate Call Tab is    ::  </b>" + paceSetterCode);
            //Verify Status option
            String status = mcdlib.verifyStatusOnDuplicateThisCallTab();
            boolean statusFlag = status != null;
            assertTrue(statusFlag, "<b>Verified the Status Option  , Option name on the Duplicate Call Tab is    ::  </b>" + status);
            //Verify New Duplicate Call Info
            String newDuplicateCallInfo = mcdlib.verifyNewDuplicateCallInfoOnDuplicateThisCallTab();
            boolean newDuplicateCallFlag = newDuplicateCallInfo != null;
            assertTrue(newDuplicateCallFlag, "<b>Verified the New Duplicate Call Info Option  , Option name on the Duplicate Call Tab is   ::  </b>" + newDuplicateCallInfo);
            //verify Spot To facility Drop Dwn
            String spotTofacility = mcdlib.verifySpotToFacilityDrpDwnOnDuplicateThisCallTab();
            boolean spotTofacilityFlag = spotTofacility != null;
            assertTrue(spotTofacilityFlag, "<b>Verified the Spot To Facility Drop-Down    , Option name on the Duplicate Call Tab is   ::  </b>" + spotTofacility);
            //Verify PaceSetter Code rp Dwn
            String paceSettercode = mcdlib.verifyPaceSetterDrpDwnOnDuplicateThisCallTab();
            boolean paceSetterFlag = paceSettercode != null;
            assertTrue(paceSetterFlag, "<b>Verified the PaceSetter Code Drop-Down    , Option name on the Duplicate Call Tab is   ::  </b>" + paceSettercode);

            //Verify Reason Drop Dwn
            String reason = mcdlib.verifyReasonDrpDwnOnDuplicateThisCallTab();
            boolean reasonFlag = reason != null;
            assertTrue(reasonFlag, "<b>Verified the Reason Drop-Down   , Option name on the Duplicate Call Tab is   :: </b>" + reason);
            //Verify Comments
            String cooments = mcdlib.verifyCommentsOnDuplicateThisCallTab();
            boolean commentsFlag = cooments != null;
            assertTrue(commentsFlag, "<b>Verified the Comments , Option name on the Duplicate Call Tab is   ::  </b>" + cooments);
            mcdlib.clickOnDuplicateCallButton();
            String errorMsgFromMCD = mcdlib.verifyErrorMessageForMandatoryFields();
            boolean errorMsgFromMCDFlag = errorMsgFromMCD != null;
            //Verifing the error message
            assertTrue(errorMsgFromMCDFlag, "<b>Verified the error message,  The Errror Message is    ::  </b>" + errorMsgFromMCD);
            mcdlib.clickOnErrorAlrertOkButton();
            mcdlib.enterFacilityToSpotOnDuplicateCallTab(data.get("Facility"));
            String facility = data.get("Facility");
            String selectedFacility = mcdlib.getSelectedFacility();
            boolean fecilityFlag = (selectedFacility.contains(facility));
            //Verify able to select facility
            assertTrue(fecilityFlag, "<b>Verified the facility Field & able to select a Facility ,Selected Facility is   :: </b>" + selectedFacility);
            mcdlib.enterPaceSetterCodeOnDuplicateCallTab(data.get("PaceSetterCode"));
            String paceSetterCodeValue = data.get("PaceSetterCode");
            String selectedPaceSetterCode = mcdlib.getSelectedPaceSetterCode();
            boolean paceSetterCodeFlag1 = selectedPaceSetterCode.contains((paceSetterCodeValue));
            //Verify able to select Pacesetter code
            assertTrue(paceSetterCodeFlag1, "<b>Verified the PaceSetter Code Field & able to select a PaceSetter Code ,Selected PaceSetter Code is   :: </b>" + selectedPaceSetterCode);
            mcdlib.enterReasonOnDuplicateCallTab(data.get("Reason"));
            String reasonValue = data.get("Reason");
            String selectedReason = mcdlib.getSelectedReason();
            boolean reasonFlag1 = selectedReason.contains(reasonValue);
            //verify able to select Reason
            assertTrue(reasonFlag1, "<b>Verified the Reason Field & able to select a Reason,Selected Reason is   ::</b> " + selectedReason);
            mcdlib.enterCommentsOnDuplicateCallTab(data.get("Comments"));
            String commentsValue = data.get("Comments");
            String enteredComments = mcdlib.getEnteredComments();
            boolean commentsFlag1 = (enteredComments.contains(commentsValue));
            //Verify able to enter comments
            assertTrue(commentsFlag1, "<b>Verified the Comments & able to enter Comments, Entered Comment is   :: </b>" + enteredComments);
            Thread.sleep(2000);

            mcdlib.clickOnDuplicateCallButton();
            crHomeLib.waitCloseAllBusyIconsResults();
            switchToWindow();
            //Get Callid , Facility, PaceSetter Code Comments and Reason After clicking On DupeCall icon
            Thread.sleep(3000);
            String callIdInDupeCall = mcdlib.getCallIdFromMcdWindow();
            //Verify new MCD Window Opened and CallId Duplicated or Not
            assertTrue(callIdInDupeCall != callIdBeforeDupeCall, "<b>New MCD Window Is Opened ,Call Id is Duplicated & Duplicated CallId   is  ::  </b>" + callIdInDupeCall);
            Thread.sleep(3000);
            String paceSetterCodeInDupeCall = mcdlib.getPaceSetterCodeFromSummary();
            boolean paceSettrCodeFlag = !paceSetterCodeInDupeCall.contains(paceSetterCodeFromSummary);
            //Verify New Mcd window Opened  and PaceSetter code Duplicated or Not
            assertTrue(paceSettrCodeFlag, "<b>New MCD Window Is Opened ,PaceSetter Code is Duplicated & Duplicated PaceSetter Code   is  :: </b> " + paceSetterCodeInDupeCall);
            Thread.sleep(3000);
            String facilityValueInDupecall = mcdlib.getFacilityFromFacilitySummary();
            boolean facilityFlag = !facilityValueInDupecall.contains(facilityValue);
            //Verify new Mcd Window opened and Facility is duplicated or Not
            assertTrue(facilityFlag, "<b>New MCD Window Is Opened,Facility is Duplicated &  Duplicated Facility  is ::  </b>" + facilityValueInDupecall);
            //Verify Entered comments are saved or Not
            mcdlib.validateComentsInMCDWindow(enteredComments);
            switchToWindow();
        }else{
            assertTrue(duplicateCallButtonVisible, "Dupe call Icon Is not visible In SPP Dispatch.So test case fails Here");
        }

    }
}
