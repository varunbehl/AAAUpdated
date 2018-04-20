package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DISpotToBackup extends LoginLib {
	public static String autoSpotId1 = null;
	public static String autoSpotId2 = null;
	CRHomeLib crHomeLib = new CRHomeLib();
	CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
	CRLocationsLib crLocationsLib = new CRLocationsLib();
	CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CRServiceLib CRServiceLib = new CRServiceLib();
	DILoginLib diLoginLib = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	DIHomeLib diHome = new DIHomeLib();
	DIMCDLib dimcdLib = new DIMCDLib();
	String newCallId="";
	String newCallId1="";

	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyFacilityBackupTab(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyFacilityBackupTab", TestData, "D3Dispatch");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyFacilityBackupTab", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("2010:TC_DI Spot To Backup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//call creation with tow service
					callWithFullService(data);
					//call creation with light service
					callWithLightService(data);
					//login to dispatch and click on profile
					loginToDIAndClickOnProfile(data);
					//search call
					diHome.clickOnSearchCallsInDispatch();
					//click on callid
					diHome.searchAndSelectCallIDInDI(newCallId);
					//click on backup button in MCD
					dimcdLib.clickOnBackupInMCD();
					//verify the Backup screen comes up
					boolean visibility=dimcdLib.verifyServiceCodeInBackupFacilityTab();
					assertTrue(visibility, "<b>Facility Backups screen comes up with service code section</b>");
					boolean visibility1=dimcdLib.verifyAddAllInBackupFacilityTab();
					assertTrue(visibility1, "<b>Facility Backups screen comes up with add all button</b>");
					boolean visibility2=dimcdLib.verifyRemoveAllInBackupFacilityTab();
					assertTrue(visibility2, "<b>Facility Backups screen comes up with remove all button</b>");
					boolean visibility3=dimcdLib.verifyResetFormInBackupFacilityTab();
					assertTrue(visibility3, "<b>Facility Backups screen comes up with reset form button</b>");
					boolean visibility4=dimcdLib.verifyFindBackupInBackupFacilityTab();
					assertTrue(visibility4, "<b>Facility Backups screen comes up with find backup button</b>");
					boolean visibility5=dimcdLib.verifyFacilityTableInBackupFacilityTab();
					assertTrue(visibility5, "<b>Facility Backups screen comes up with facility backup section</b>");
					boolean visibility6=dimcdLib.verifyReasonInBackupFacilityTab();
					assertTrue(visibility6, "<b>Facility Backups screen comes up with reason code</b>");
					boolean visibility7=dimcdLib.verifyCommentInBackupFacilityTab();
					assertTrue(visibility7, "<b>Facility Backups screen comes up with comment</b>");
					boolean visibility8=dimcdLib.verifySpotToFacilityInBackupFacilityTab();
					assertTrue(visibility8, "<b>Facility Backups screen comes up with spottofacility button</b>");
					boolean visibility9=dimcdLib.verifyCancelButtonInBackupFacilityTab();
					assertTrue(visibility9, "<b>Facility Backups screen comes up with cancel button</b>");

					//click on service code
					dimcdLib.clickOnServiceCode();
					//click on find backup button
					dimcdLib.clickFindBackupInBackupFacilityTab();
					//Verify that table displays primary and backup facilities
					dimcdLib.listOfBackupFacility();
					//select facility and click on spot facility
					Thread.sleep(12000);
					String facility = dimcdLib.selectFacilityInBackupFacilityTab();
					//get the error msg
					dimcdLib.getE213ErrorMessage();
					dimcdLib.clickOnE213OkayButton();
					//select a reason
					dimcdLib.selectReasonInBackupFacilityTab();
					//click on spot facility button
					dimcdLib.clickSpotToFacilityInBackupFacilityTab();
					//verify the error msg comes regarding d3 integration problems
					boolean msg =CRServiceLib.verifyE268ErrorMessageAvailablity();
					if(msg)
					{
						String errormsg=CRServiceLib.getE268ErrorMessage();
						CRServiceLib.clickOnE268OKButton();
						reporter.warningReport("Call:","Unable to proceed because "+errormsg);
					}
					else
					{
						//verify MCD window,Backup facility screen auto closes and the MCD window is showing.
						String mcd = dimcdLib.verifyMCDWindow();
						assertTrue(!mcd.equalsIgnoreCase(null), "<b>Backup facility screen auto closes and the MCD window is showing</b>"+mcd);
						Thread.sleep(4000);
						//get facility  from facility summary to verify selected backup facility is now spotted to the call.
						String facilityNumber[]=facility.split(" ");
						String facility1[]=(dimcdLib.getFacilityFromFacilitySummary()).split("-");
						String secondFacility=facility1[1].trim();
						assertTrue(facilityNumber[0].equalsIgnoreCase(secondFacility), "Expected:"+facilityNumber[0]+" and "+"Actual:"+secondFacility+"<b> The selected backup facility is now spotted to the call</b>");

					}
					diHome.logOut();
					acceptAlert();

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI", "2010", ReportStatus.strMethodName, intCounter, browser);

				//To close the browser after each iteration
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}
	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyFacilityBackupTabInPoppedout(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyFacilityBackupTab", TestData, "D3Dispatch");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyFacilityBackupTab", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("2010:TC_DI Spot To Backup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
					//call creation with tow service
					callWithFullService(data);
					//call creation with light service
					callWithLightService(data);
					//login to dispatch and click on profile
					loginToDIAndClickOnProfile(data);
					//search call
					diHome.clickOnSearchCallsInDispatch();
					//click on callid
					diHome.searchAndSelectCallIDInDI(newCallId);
					//click on popped out button
					dimcdLib.clickOnPoppedOutButton();
					Thread.sleep(7000);
					switchToWindow();
					Thread.sleep(5000);

					//click on backup button in MCD
					dimcdLib.clickOnBackupInMCD();
					//verify the Backup screen comes up
					boolean visibility=dimcdLib.verifyServiceCodeInBackupFacilityTab();
					assertTrue(visibility, "<b>Facility Backups screen comes up with service code section</b>");
					boolean visibility1=dimcdLib.verifyAddAllInBackupFacilityTab();
					assertTrue(visibility1, "<b>Facility Backups screen comes up with add all button</b>");
					boolean visibility2=dimcdLib.verifyRemoveAllInBackupFacilityTab();
					assertTrue(visibility2, "<b>Facility Backups screen comes up with remove all button</b>");
					boolean visibility3=dimcdLib.verifyResetFormInBackupFacilityTab();
					assertTrue(visibility3, "<b>Facility Backups screen comes up with reset form button</b>");
					boolean visibility4=dimcdLib.verifyFindBackupInBackupFacilityTab();
					assertTrue(visibility4, "<b>Facility Backups screen comes up with find backup button</b>");
					boolean visibility5=dimcdLib.verifyFacilityTableInBackupFacilityTab();
					assertTrue(visibility5, "<b>Facility Backups screen comes up with facility backup section</b>");
					boolean visibility6=dimcdLib.verifyReasonInBackupFacilityTab();
					assertTrue(visibility6, "<b>Facility Backups screen comes up with reason code</b>");
					boolean visibility7=dimcdLib.verifyCommentInBackupFacilityTab();
					assertTrue(visibility7, "<b>Facility Backups screen comes up with comment</b>");
					boolean visibility8=dimcdLib.verifySpotToFacilityInBackupFacilityTab();
					assertTrue(visibility8, "<b>Facility Backups screen comes up with spottofacility button</b>");
					boolean visibility9=dimcdLib.verifyCancelButtonInBackupFacilityTab();
					assertTrue(visibility9, "<b>Facility Backups screen comes up with cancel button</b>");

					//click on service code
					dimcdLib.clickOnServiceCode();
					//click on find backup button
					dimcdLib.clickFindBackupInBackupFacilityTab();
					//Verify that table displays primary and backup facilities
					dimcdLib.listOfBackupFacility();
					//select facility and click on spot facility
					Thread.sleep(12000);
					String facility = dimcdLib.selectFacilityInBackupFacilityTab();
					//get the error msg
					dimcdLib.getE213ErrorMessage();
					dimcdLib.clickOnE213OkayButton();
					//select a reason
					dimcdLib.selectReasonInBackupFacilityTab();
					//click on spot facility button
					dimcdLib.clickSpotToFacilityInBackupFacilityTab();
					//verify the error msg comes regarding d3 integration problems
					boolean msg =CRServiceLib.verifyE268ErrorMessageAvailablity();
					if(msg)
					{
						String errormsg=CRServiceLib.getE268ErrorMessage();
						CRServiceLib.clickOnE268OKButton();
						reporter.warningReport("Call:","Unable to proceed because "+errormsg);
					}
					else
					{
						//verify MCD window,Backup facility screen auto closes and the MCD window is showing.
						String mcd = dimcdLib.verifyMCDWindow();
						assertTrue(!mcd.equalsIgnoreCase(null), "<b>Backup facility screen auto closes and the MCD window is showing</b>"+mcd);
						Thread.sleep(4000);
						//get facility  from facility summary to verify selected backup facility is now spotted to the call.
						String facilityNumber[]=facility.split(" ");
						String facility1[]=(dimcdLib.getFacilityFromFacilitySummary()).split("-");
						String secondFacility=facility1[1].trim();
						assertTrue(facilityNumber[0].equalsIgnoreCase(secondFacility), "Expected:"+facilityNumber[0]+" and "+"Actual:"+secondFacility+"<b> The selected backup facility is now spotted to the call</b>");

					}
					driver.close();
					switchToWindow();
					diHome.logOut();
					acceptAlert();
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI", "2010", ReportStatus.strMethodName, intCounter, browser);

				//To close the browser after each iteration
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	public String callWithLightService(Hashtable<String, String> data) throws Throwable {

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

		//entering vehicle details
		crVehicleTriageLib.clickOnVehicleTriageTab();
		crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
		//light service
		crVehicleTriageLib.clickOnFuel();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.clickOnOutOfGas();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//Capturing autospot id
		CRServiceLib.clickOnServiceTab();
		CRServiceLib.enterManualFacilityNumber(data.get("Facility"));
		CRServiceLib.clickOnSpotInServicePage();
		autoSpotId1 = CRServiceLib.validateFacilityspotIDOnServiceTab();
		System.out.println(autoSpotId1);
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crHomeLib.saveButton();
		Thread.sleep(10000);
		newCallId = CRServiceLib.getCallId();
		CRServiceLib.clickOnRemainInCall();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		reporter.SuccessReport("<b>Call with light service</b> ","is created"+" "+newCallId);
		crHomeLib.logout();
		acceptAlert();
		return newCallId;
	}
	public String callWithFullService(Hashtable<String, String> data) throws Throwable {

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

		//entering vehicle details
		crVehicleTriageLib.clickOnVehicleTriageTab();
		crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
		//Full service
		crVehicleTriageLib.enterPaceSetterCode(data.get("PaceSetterCode"));
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		//Capturing autospot id
		CRServiceLib.clickOnServiceTab();
		CRServiceLib.enterManualFacilityNumber(data.get("Facility"));
		CRServiceLib.clickOnSpotInServicePage();
		autoSpotId2 = CRServiceLib.validateFacilityspotIDOnServiceTab();
		System.out.println(autoSpotId2);
		crHomeLib.saveButton();
		Thread.sleep(10000);
		newCallId1 = CRServiceLib.getCallId();
		CRServiceLib.clickOnRemainInCall();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		reporter.SuccessReport("<b>Call with Full Service </b>","is created"+" "+newCallId1);
		crHomeLib.logout();
		return newCallId1;
	}
	public void   loginToDIAndClickOnProfile(Hashtable<String, String> data) throws Throwable {
		navigateToApplication("DI");
		diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		role.selectRoleInDispatch(data.get("RoleDispatch"));
		Thread.sleep(5000);
		role.clickOnProceedBtnInDispatchRoleLogin();
		diLoginLib.waitcloseAllBusyIcons();
		diHome.clickOnCloseIconOnQueueSelection();
	}
}