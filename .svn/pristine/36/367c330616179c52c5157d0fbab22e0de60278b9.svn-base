package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRVehicleTriagePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRTriage extends ActionEngine {

	boolean validateCommentsAndEnteredManualPaceSetterCode = true;


	/************************************************************************
	 * Script Name :- TC_CRTriage
	 * Method Name :- ValidateTriageDetails
	 * Module	  :- DI
	 * Test Case ID:- 1620
	 * Script Date :-
	 * Author      :- Sachin
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
	 *************************************************************************/

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void ValidateTriageDetails(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"crTriage", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);

					this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					// Logging into the application
					LoginToApplication(data);
					// Validating comments and Pacesetter code
					if (validateCommentsAndEnteredManualPaceSetterCode){
						ValidateCommentsAndEnteredManualPaceSetterCode(data);
					}
					// Below function adds the Membership, Location and Vehicle Details
					addingMemberShipLocationVehicleDetails(data);
					// Validating Triage options and Codes for different Problem types
					validateTriageOptions(data.get("problemType"),data.get("question"),data.get("answer"),data.get("expectedCode"),data.get("problemName"),data.get("towRequired"));


				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.warningReport("Exception Occured", e.getMessage());
					reporter.failureReport("Exception Occured", "Snap Shot", driver);
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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


	public void SaveAndValidateCallId(String code)throws Throwable{

		CRHomeLib home = new CRHomeLib();
		CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		CRServiceLib service = new CRServiceLib();
		CRSearchCallsLib servicecalls = new CRSearchCallsLib();


		home.saveButton();
		Thread.sleep(6000);
		home.allErrorAlerts();
		vehicle.handleScriptErrorInVehicleTriagePage();
		String callID = service.getCallId();
		service.closeCallWindow();
		servicecalls.clickOnSearchCalls();
		Thread.sleep(3000);
		home.enterCallIdForSearch(callID);
		home.clickOnSearchButtonOnSearchCalls();
		Thread.sleep(5000);
		// Verifying the trouble code on the call maps to the pacesetter code you entered
		home.validateDispatchCodeInSearchCallsPoPUpWindow(code);
		home.clickOnCloseIconOnSearchCallsWindow();
		home.logout();
	}

	public void addingMemberShipLocationVehicleDetails(Hashtable<String, String> data) throws Throwable{

		CRHomeLib home = new CRHomeLib();
		CRMemberSearchLib memeber = new CRMemberSearchLib();
		CRLocationsLib locations = new CRLocationsLib();
		CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		CommonLib common = new CommonLib();
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
			Member = data.get("MemberNumber");
		}
		home.memberSearchTextBox(Member);
		memeber.memberNumClick();
		memeber.currentCallClose();
		memeber.ClickPrimRadioBtnInRowThree();

		// Locations Page Starts
		//Entering Location Details

		locations.breakdownLocTabSel();
		locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));

		// Vehicle Triage Page Starts here

		vehicle.clickOnVehicleTriageTab();
		/*vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		vehicle.enterVehicleDetails(data.get("VehicleSearch"),data.get("VehicleDetails"));*/

		Thread.sleep(3000);

		vehicle.clickOnManualEntryLinkOnVehicle();
		// Entering Vehicle details - Type, Year, Make, Model, Color

		vehicle.enterVehicleType(data.get("VehicleType"));
		Thread.sleep(1000);
		vehicle.enterVehicleYear(data.get("VehicleYear"));
		Thread.sleep(1000);
		vehicle.enterVehicleMake(data.get("VehicleMake"));
		Thread.sleep(1000);
		vehicle.enterVehicleModel(data.get("VehicleModel"));
		Thread.sleep(1000);
		vehicle.enterVehicleColor(data.get("VehicleColor"));
		Thread.sleep(1000);
		vehicle.clickTag();
	}

	public void LoginToApplication(Hashtable<String, String> data) throws Throwable {
		LoginLib login = new LoginLib();
		CRHomeLib home = new CRHomeLib();
		DILoginLib diLogin = new DILoginLib();
		// Logging into the application
		navigateToApplication("CR");
		login.login(data.get("LoginName"), data.get("Password"));
		diLogin.waitcloseAllBusyIcons();
		home.allErrorAlertsNoButton();
		home.messageDialogBoxClose();
	}

	public void validateTriageOptions(String problemAndTriageType, String question, String answer, String expectedCode,String ProblemName,String towRequired) throws Throwable{

		CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		CRTowDestinationLib towdestination = new CRTowDestinationLib();
		//vehicle.enterVehicleType(vehicleType);
		//vehicle.clickTag();
		Thread.sleep(2000);
		vehicle.selectProblem(problemAndTriageType);
		Thread.sleep(2000);

		//Validate the question only if it is not equal to ""
		if(!question.equalsIgnoreCase("")){
			vehicle.validateQuestionDisplayedInTriageSection(question);
			Thread.sleep(2000);
			vehicle.clickonProblemTypeOptions(answer);
			Thread.sleep(2000);
		}
		vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		String triageCodeDisplayed = vehicle.GetSelectedPaceSetterCode();
		//Validating if the required code is displayed
		assertTrue(expectedCode.equalsIgnoreCase(triageCodeDisplayed), "Triage Code Validated. Expected: "+ expectedCode + "   Actual: " + triageCodeDisplayed);
		String code = vehicle.getCodeNumberFromSelectedPaceSetterCode();

		if (towRequired.equalsIgnoreCase("Yes")) {
			// Navigating to Tow Destination Tab
			towdestination.clickOnTowDestinationTab();
			Thread.sleep(3000);
			vehicle.handleScriptErrorInVehicleTriagePage();
			Thread.sleep(3000);
			towdestination.clickOnManualEntryLinkOnTowDestination();
			Thread.sleep(3000);
			towdestination.enterTowPassengers("2");
		}

		SaveAndValidateCallId(code);
	}

	public void ValidateCommentsAndEnteredManualPaceSetterCode(Hashtable<String, String> data) throws Throwable{
		validateCommentsAndEnteredManualPaceSetterCode = false;
		CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		CRMemberSearchLib member = new CRMemberSearchLib();
		CRLocationsLib locations = new CRLocationsLib();

		// Navigating to Vehicle Triage Page and Validating Manual Entry of Pacesetter Code(Step 11)
		vehicle.clickOnVehicleTriageTab();
		vehicle.selectpaceSettercode(data.get("PaceSetterCode"));
		// Validating the call receives a pacesetter code
		String paceSetterCode = vehicle.GetSelectedPaceSetterCode();
		// Validating the call receives a pacesetter code
		assertTrue(paceSetterCode.equalsIgnoreCase(data.get("PaceSetterCode")),"Selected triage option Pacesetter code matches with the selected pacesetter code");

		Thread.sleep(5000);
		// Clicking on the "X" to remove the pacesetter code
		vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		// Validating the call no longer has that pacesetter code
		vehicle.validateNoPacesetterCodeAssigned(data.get("MessageNoPaceSetterSelected"));

		// Implemented review comments for Step 13 To 18.
		vehicle.selectProblem(data.get("AdditionalCommentsOpptions"));

		vehicle.clickOnAddButtonTriageSection();
		String errMessage = vehicle.getTextInvalidCommentProvided();
		// Validating error displays "Invalid comment provided."
		assertTrue(errMessage.equalsIgnoreCase(data.get("InvalidCommentProvided")),"Error displays-Invalid Comment Provided");
		vehicle.EnterTextCommentTriageSection(data.get("FuelLeakComments"));
		vehicle.clickOnAddButtonTriageSection();

		//Validating the call receives a pacesetter code
		paceSetterCode = vehicle.GetSelectedPaceSetterCode();
		// Validating the call receives a pacesetter code
		assertTrue(paceSetterCode.equalsIgnoreCase(data.get("FuelMemberRequestTowCode")),"Selected triage option Pacesetter code matches with the selected pacesetter code");

		locations.clickOnCallCommentsButton();
		String strSelectedPaceSetterCode = vehicle.GetSelectedPaceSetterCode();
		String commentsFromCommentWindow = locations.GetComentsFromCommentWindow();
		// Validating there is a comment for Triage Selection
		assertTrue(commentsFromCommentWindow.contains(strSelectedPaceSetterCode) && commentsFromCommentWindow.contains(data.get("FuelLeakComments")),"There is a comment for Triage Selection");

		locations.clickOnCallCommentsButton();
		locations.enterCallComments(data.get("Comments"));
		locations.clickOnCallCommentsAddButton();
		locations.clickOnCallCommentsButton();
		// Validating the comment you entered displays in the comment window
		locations.validateComentsInCommentPopUp(data.get("Comments"));
		locations.clickOnCallCommentsButton();
		// Clicking on the "X" to remove the pacesetter code
		vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		member.clickOnMemberTab();
		//home.logout();

	}
}


