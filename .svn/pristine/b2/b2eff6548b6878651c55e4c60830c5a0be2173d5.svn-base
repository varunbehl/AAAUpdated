package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRMemberSearchPage;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRFacilityPreference extends LoginLib {
	public static String autoSpotId = null;
	public static String autoSpotId1 = null;
	public static String autoSpotId2 = null;
	public static String autoSpotId3 = null;
	public static String autoSpotId4 = null;
	public static String autoSpotIdFl = null;
	CRHomeLib crHomeLib = new CRHomeLib();
	CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
	CRLocationsLib crLocationsLib = new CRLocationsLib();
	CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CRServiceLib CRServiceLib = new CRServiceLib();


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyPostCondition(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyPostCondition", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyPostCondition", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1653:TC-Facility Preference" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//login to CR
					navigateToApplication("CR");
					login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(5000);
					crMemberSearchLib.clickOnPartialCallCloseButton();
					crHomeLib.messageDialogBoxClose();
					Thread.sleep(5000);

					//Entering Membership number
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
					crHomeLib.memberSearchTextBox(Member);
					//crHomeLib.memberSearchTextBox(data.get("Membersearch"));
					crMemberSearchLib.memberNumClick();
					crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

					//entering location address
					crLocationsLib.clickOnLocationTab();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));

					//emtering vehicle details
					crVehicleTriageLib.clickOnVehicleTriageTab();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					//crVehicleTriageLib.selectExistingVehicleModel();
					crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.clickOnFuel();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.clickOnOutOfGas();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

					//capturing autospot ID
					CRServiceLib.clickOnServiceTab();
					Thread.sleep(3000);
					autoSpotId = CRServiceLib.validateFacilityspotIDOnServiceTab();
					System.out.println(autoSpotId);

					//entering facility and click on avoid
					CRServiceLib.enterFacilityPreference(autoSpotId);
					CRServiceLib.clickOnAvoid();

					//capturing autospot ID after click on avoid
					autoSpotId1 = CRServiceLib.validateFacilityspotIDOnServiceTab();
					System.out.println(autoSpotId1);
					Thread.sleep(2000);

					//verifying facility is removed
					boolean spotIdCompare = !(autoSpotId.equalsIgnoreCase(autoSpotId1));
					assertTrue(spotIdCompare, "<b>Expected::" + autoSpotId + "::Value and Actual value::" + autoSpotId1 + "::not matched::" + "::Facility is removed</b>");
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

					//click on prefer
					CRServiceLib.clickOnPrefer();

					//capturing autospot ID
					autoSpotId2 = CRServiceLib.validateFacilityspotIDOnServiceTab();
					Thread.sleep(2000);

					//verifying Facility is set to the location
					boolean spotIdCompare1 = (autoSpotId.equalsIgnoreCase(autoSpotId2));
					assertTrue(spotIdCompare1, "<b>Expected::" + autoSpotId + "::Value and Actual value::" + autoSpotId2 + "::matched::" + "::Facility is set to the locatio</b>n");

					//leaving the call
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crHomeLib.leaveButton();
					crHomeLib.allErrorAlerts();

					//To capture Invalid autospot ID by giving invalid location
					crMemberSearchLib.clickOnPartialCallCloseButton();
					crHomeLib.messageDialogBoxClose();
					Thread.sleep(5000);
					crHomeLib.memberSearchTextBox(Member);
					crMemberSearchLib.memberNumClick();
					crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
					crLocationsLib.clickOnLocationTab();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddressInvalid"));
					crVehicleTriageLib.clickOnVehicleTriageTab();
					crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.clickOnFuel();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.clickOnOutOfGas();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					CRServiceLib.clickOnServiceTab();
					Thread.sleep(3000);
					autoSpotIdFl = CRServiceLib.validateFacilityspotIDOnServiceTab();
					crHomeLib.leaveButton();
					crHomeLib.allErrorAlerts();

					//To validate error msg by using invalid autospot ID
					crMemberSearchLib.clickOnPartialCallCloseButton();
					crHomeLib.messageDialogBoxClose();
					Thread.sleep(5000);
					crHomeLib.memberSearchTextBox(Member);
					crMemberSearchLib.memberNumClick();
					crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
					crLocationsLib.clickOnLocationTab();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
					crVehicleTriageLib.clickOnVehicleTriageTab();
					crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.clickOnFuel();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.clickOnOutOfGas();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					//entering spot id and click on prefer
					CRServiceLib.clickOnServiceTab();
					Thread.sleep(3000);
					CRServiceLib.enterFacilityPreference(autoSpotIdFl);
					CRServiceLib.clickOnPrefer();
					CRServiceLib.clickOnPrefer();

					//verify error msg
					CRServiceLib.verifyErrorMsgForAutospot();
					Thread.sleep(1000);

					//click on ok button on error popup
					crHomeLib.clickOnAutospotFailMsgOk();
					Thread.sleep(2000);
					/*crHomeLib.clickOnAutospotFailMsgOk();
					Thread.sleep(2000);*/
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					Thread.sleep(2000);
					crHomeLib.clickOnAutospotFailMsgOk();

					//leaving call
					crHomeLib.leaveButton();
					crHomeLib.allErrorAlerts();
					crHomeLib.logout();

					//Verifying Precondition Steps
					verifyPrecondition(data);

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1653", ReportStatus.strMethodName, intCounter, browser);

				//To close the browser after each iteration
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	public void verifyPrecondition(Hashtable<String, String> data) throws Throwable {

		reporter.SuccessReport("Verifying Precondition Steps : ", "<b>****************</b>");
		//login to CR
		navigateToApplication("CR");
		login(data.get("LoginName"), data.get("Password"));
		Thread.sleep(5000);
		crMemberSearchLib.clickOnPartialCallCloseButton();
		crHomeLib.messageDialogBoxClose();
		Thread.sleep(5000);

		//entering membership number
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
		crHomeLib.memberSearchTextBox(Member);
		crMemberSearchLib.memberNumClick();
		crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

		//entering location address
		crLocationsLib.clickOnLocationTab();
		crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//entering spot id in service tab
		CRServiceLib.clickOnServiceTab();
		CRServiceLib.enterFacilityPreference(autoSpotId);

		//click on avoid
		CRServiceLib.clickOnAvoid();

		//entering vehicle details
		crVehicleTriageLib.clickOnVehicleTriageTab();
		crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
		crVehicleTriageLib.clickOnFuel();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.clickOnOutOfGas();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//Capturing autospot id
		CRServiceLib.clickOnServiceTab();
		autoSpotId3 = CRServiceLib.validateFacilityspotIDOnServiceTab();
		System.out.println(autoSpotId3);

		//verifying Call is not auto spotted to the facility
		boolean spotIdCompare3 = !(autoSpotId.equalsIgnoreCase(autoSpotId3));
		assertTrue(spotIdCompare3, "<b>Expected::" + autoSpotId + "::Value and Actual value::" + autoSpotId3 + "::not matched::" + "::Call is not auto spotted to the facility</b>");
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//leaving call
		crHomeLib.leaveButton();
		crHomeLib.allErrorAlerts();

		//enetring membership number
		crHomeLib.memberSearchTextBox(Member);
		crMemberSearchLib.memberNumClick();
		crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

		//entering location address
		crLocationsLib.clickOnLocationTab();
		crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//entering facility and click on prefer
		CRServiceLib.clickOnServiceTab();
		CRServiceLib.enterFacilityPreference(autoSpotId);
		CRServiceLib.clickOnPrefer();

		//entering vehicle details
		crVehicleTriageLib.clickOnVehicleTriageTab();
		crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
		crVehicleTriageLib.clickOnFuel();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.clickOnOutOfGas();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//capturing the spot it
		CRServiceLib.clickOnServiceTab();
		autoSpotId4 = CRServiceLib.validateFacilityspotIDOnServiceTab();
		System.out.println(autoSpotId4);

		//verifying call is auto spotted to the facility
		boolean spotIdCompare4 = (autoSpotId.equalsIgnoreCase(autoSpotId4));
		assertTrue(spotIdCompare4, "<b>Expected::" + autoSpotId + "::Value and Actual value::" + autoSpotId4 + "::matched::" + "::call is auto spotted to the facility</b>");
		crHomeLib.allErrorAlerts();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//leaving the call
		crHomeLib.leaveButton();
		crHomeLib.allErrorAlerts();
		crHomeLib.logout();
	}
}