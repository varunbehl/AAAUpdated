package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.DISearchCallsPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CREntitlements extends ActionEngine {
    public static String callID;
    public static int currentCallsBeforeCallCreatedInInt;
    public static int currentCallsAfterCallCreatedInInt;
	public static int ChargeableCallsBeforeCallCreatedInInt;
	public static int ChargeableCallsAfterCallClearedInInt;
	public static int callsRemainingInInt;
	public static String membershipNumber;

    CommonLib cLib = new CommonLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    DIMCDLib dimcdLib = new DIMCDLib();


	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: entitlementsCallClearGOA
	 * description :: Create and clear call using GOA(Gone On Arrival)
	 * date :: 18-Dec-2017
	 * author :: Abhiram Vajrapu - E004118
	 */

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void entitlementsCallClearGOA(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "entitlementsCallClearGOA", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {

					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("entitlementsCallClearGOA", TestData, "D3CallRecieving",intCounter);
					this.reporter.initTestCaseDescription("1983:TS-CR Entitlements "+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					createCallAndClearCall(data);
					if(callsRemainingInInt>0) {

						boolean errorMessage = false;

						//Click on No Service Render and Select exit code
						dimcdLib.clickOnNoService();
						dimcdLib.selectExitCode();

						//Enter Reason coode G1 - GOne On Arrival and click on continue button
						dimcdLib.enterReason(data.get("Reason"));
						dimcdLib.clickOnContinue();
						Thread.sleep(3000);

						//After click on continue button checking for error message
						//If member have sufficient entitlements call will cleared successfully
						//Else we showld clear call by using cash call (Reason code for cash call - 03)
						errorMessage = dimcdLib.verifyErrorMessageAtReasonInMCDWindow();
						if (errorMessage) {
							dimcdLib.closeErrorAlert();
							clearData(DIMCDPage.txtReason);

							//Enter reason code for cash calls - 03
							dimcdLib.enterReason(data.get("ReenterReason"));
							dimcdLib.clickOnSubmit();
							dimcdLib.clickOnSubmit();

							//Verify call cleared status
							dimcdLib.labelCallCleared(data.get("DIStatusCL"));
						} else {

							//Verify call cleared status
							dimcdLib.clickonSubmitandVerifyClearCallLabel(data.get("DIStatusCL"));
						}

						dimcdLib.clickOnMCDCloseWindow();
						diHome.logOut();

						navigateToApplication("CR");
						cLib.callReceivingLogin(data.get("LoginName"), data.get("Password"));
						crHomeLib.memberSearchTextBox(membershipNumber);
						crMemberSearchLib.memberNumClick();
						crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

						//Chargeable calls after call cleared cleared
						ChargeableCallsAfterCallClearedInInt = Integer.parseInt(crMemberSearchLib.memberChargeableCallsInMemberDetailsSection());


						assertTrue(ChargeableCallsBeforeCallCreatedInInt + 1 == ChargeableCallsAfterCallClearedInInt, "<b> Chargeable calls before call created " + ChargeableCallsBeforeCallCreatedInInt + "  ::After call Cleared the Chargeable calls are changed to " + ChargeableCallsAfterCallClearedInInt + "</b>");
					}
					System.out.println("Test completed");

				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);

				//To close the browser after each iteration
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

	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: entitlementsCallClear
	 * description :: Create and clear call
	 * date :: 18-Dec-2017
	 * author :: Abhiram Vajrapu - E004118
	 */

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void entitlementsCallClear(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "entitlements", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("entitlements", TestData, "D3CallRecieving",intCounter);
					this.reporter.initTestCaseDescription("1983:TS-CR Entitlements "+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					boolean errorMessage = false;
					createCallAndClearCall(data);


					if(callsRemainingInInt>0)
					{
						//Select Exir code and click on continue button
						dimcdLib.selectExitCode();
						dimcdLib.clickOnContinue();
						Thread.sleep(3000);

						//After click on continue button checking for error message
						//If member have sufficient entitlements call will cleared successfully
						//Else we showld clear call by using cash call (Reason code for cash call - 03)
						errorMessage = dimcdLib.verifyErrorMessageAtReasonInMCDWindow();
						if (errorMessage) {
							dimcdLib.closeErrorAlert();
							clearData(DIMCDPage.txtReason);

							//Enter reason code for cash calls - 03
							dimcdLib.enterReason(data.get("Reason"));
							dimcdLib.clickOnSubmit();
							dimcdLib.clickOnSubmit();

							//Verify call cleared status
							dimcdLib.labelCallCleared(data.get("DIStatusCL"));
						} else {

							//Verify call cleared status
							dimcdLib.clickonSubmitandVerifyClearCallLabel(data.get("DIStatusCL"));
						}
						dimcdLib.clickOnMCDCloseWindow();
						diHome.logOut();
					}

					System.out.println("Test completed");
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);

				//To close the browser after each iteration
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




	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: entitlements
	 * description :: entitlements
	 * date :: 18-Dec-2017
	 * author :: Abhiram Vajrapu - E004118
	 */

	public int createCallAndClearCall(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")) {
				this.reporter.initTestCaseDescription("1983:TS-CR Entitlements");

				cLib.callReceivingLogin(data.get("LoginName"), data.get("Password"));
				String Member = "";
				if (data.get("Member").equals("db")) {
					//fetch member details from db
					//generating a random number everytime to fetch a new record everytime
					int rownum = IntRandomNumberGenerator(50, 1000);
					//member from db
					Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
					System.out.println("member : " + Member);
				}
				if (Member.isEmpty()) {
					Member = data.get("Membersearch");
				}

				//Searching Member Number
				crHomeLib.memberSearchTextBox(Member);
				crMemberSearchLib.memberNumClick();
				crMemberSearchLib.clickPrimRadioBtnRowOne();
				crMemberSearchLib.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("PrimaryPhone"));
				crMemberSearchLib.membContInfoEnterPrimPhoneTypeCellular();
				crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

				//Classreamin
				callsRemainingInInt = Integer.parseInt(crMemberSearchLib.memberCallsRemainingInMemberDetailsSection());


				//Sometimes DB query returning returning entitlements with Zero
				//So we are checking with condtion 0 , if etitlemets less than zero script will not execute
				//We are returning this value
				if (callsRemainingInInt > 0) {

					//Capture Membership Number
					membershipNumber = crMemberSearchLib.labelMemberShipNumberInMemberDetailsSection();

					//Cureent calls  before call created
					currentCallsBeforeCallCreatedInInt = Integer.parseInt(crMemberSearchLib.memberCurrentCallsInMemberDetailsSection());

					//Chargable calls before call created
					ChargeableCallsBeforeCallCreatedInInt = Integer.parseInt(crMemberSearchLib.memberChargeableCallsInMemberDetailsSection());

					//Entering the breakdown location
					crLocationsLib.clickOnLocationTab();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));

					//Vehicle details and traige
					crVehicleTriageLib.clickOnVehicleTriageTab();
					crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));

					crVehicleTriageLib.clickOnFuel();
					crVehicleTriageLib.clickOnOutOfGas();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.scriptErrorHandle();

					//Saving the call and validating the call id is not null in getCallId method
					crHomeLib.saveButton();
					crHomeLib.allErrorAlerts();
					callID = services.getCallId();
					services.clickOnRemainInCall();

					//Click on Member Tab to validate the Calls again
					crMemberSearchLib.clickOnMemberTab();

					//Current calls entitlemts after call created and current value will be incremented by "1"
					currentCallsAfterCallCreatedInInt = Integer.parseInt(crMemberSearchLib.memberCurrentCallsInMemberDetailsSection());

					//Validation for currents calls for before call created and after call created
					assertTrue(currentCallsBeforeCallCreatedInInt + 1 == currentCallsAfterCallCreatedInInt, "<b>Current calls before call created" + currentCallsBeforeCallCreatedInInt + "  ::After call created the Current calls are changed to " + currentCallsAfterCallCreatedInInt + "</b>");

					//ClickOnLogout
					crHomeLib.logout();

					//navigating to Dispatch Application to clear the call
					navigateToApplication("DI");
					diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
					role.clickOnProceedBtnInDispatchRoleLogin();
					diLoginLib.waitcloseAllBusyIcons();
					diHome.clickOnCloseIconOnQueueSelection();

					//Click on Search call window
					diHome.clickOnSearchCallsInDispatch();

					//Enter call id and click on that call id
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();

					//Click on AS button in MCD window and select facility
					dimcdLib.clickOnAssign();
					dimcdLib.selectFacility();

					//Verify AS status
					dimcdLib.lblCallAssignedStatus("AS");

					//Click on DI button in MCD window
					dimcdLib.selectDispatch();

					//Verify DI status
					dimcdLib.lblCallDispatchedStatus("DI");

					//Click on ER button in MCD window and selct ER Time
					dimcdLib.selectEnroute();
					dimcdLib.selectEnrouteTime();

					//Verify ER status
					dimcdLib.lblCallENRouteStatus("ER");

					//Click on OL button in MCD window
					dimcdLib.selectOnLocation();

					//Verify OL status
					dimcdLib.lblCallOnLocationStatus("OL");

					//Click on CL button in MCD window
					dimcdLib.selectClearCall();
				}

				else
				{
					reporter.failureReport("Calls Remaing Value","Call Remaining value is Zero",driver);
					crHomeLib.logout();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			reporter.failureReport("Execption Occured","Execption Occured",driver);
			reporter.warningReport("Error Description",e.getMessage());
		}
		return callsRemainingInInt;
	}
}
