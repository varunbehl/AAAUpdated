package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Hashtable;

/**
 * Created by E002734 on 1/29/2018.
 */
public class TC_DIEditCallInCallReceiving extends ActionEngine {




	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();
	DIMCDLib dimcdLib = new DIMCDLib();
	DIHomeLib diHome = new DIHomeLib();
	DILoginLib diLoginLib = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	public static String callID;
	String callDateCreated;
	String callDateStr;

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
	public void diEditCallInCallRecevingLiveOnly(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "diEditCallInCallRecevingLiveOnly", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("diEditCallInCallRecevingLiveOnly", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1745: TC-DI_Edit Call In Call Receving"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//Login to d3 ,create a call, navigate to di and search the call
					loginD3CreateCallAndSearchCallInDispatch(data);

					//search live call in dispatch
					diHome.enterCallTypeAsLiveOnlyInDispatch(data.get("LiveOnly"));
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();


					boolean pencilIconStatus=dimcdLib.verifyPencilIconInMCD();
					assertTrue(pencilIconStatus, "<b>MCD window has a Pencil Icon</b>");
					String pencilIconText = dimcdLib.verifyMouseHoverTextOnPencilIconInMCD();
					reporter.SuccessReport("<b>Pencil Icon has Edit as the helper text</b>", "Text:"+pencilIconText);

					////click on pencil icon in dispatch to navigate to d3
					dimcdLib.clickOnPencilIcon();
					Thread.sleep(8000);
					switchToWindow();

					String autoLoginToD3home =home.getTextD3CallReceivingText();
					reporter.SuccessReport("<b>A new tab opens and automatically logged into Call Receiving</b>", "Text:"+autoLoginToD3home);

					String loadedCallInD3Call[]=member.verifyLiveCallIDInMemberTab().split(",");
					assertTrue(callID.equalsIgnoreCase(loadedCallInD3Call[0]), "<b>Call clicked on to edit is automatically loaded into Call Receiving</b>"+callID+  "::Value and Actual value::" +loadedCallInD3Call[0]+ "::are matched");

					//entering vehicle details
					vehicle.handleScriptErrorInVehicleTriagePage();
					vehicle.handleScriptErrorInVehicleTriagePage();
					vehicle.clickOnVehicleTriageTab();
					vehicle.handleScriptErrorInVehicleTriagePage();
					vehicle.clickOnManualEntryLinkOnVehicle();
					vehicle.selectExistingVehicleModel();
					vehicle.handleScriptErrorInVehicleTriagePage();
					Thread.sleep(3000);
					//enter pacesetter details
					vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
					Thread.sleep(3000);
					vehicle.handleScriptErrorInVehicleTriagePage();
					Thread.sleep(3000);
					vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
					Thread.sleep(2000);
					vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
					Thread.sleep(3000);
					// vehicle.enterPaceSetterCodeManually(data.get("paceSettercode2"));
					String changePacesettervALUE = vehicle.validateSelectedPaceSetterCode();
					service.clickOnServiceTab();
					Thread.sleep(3000);

					//verifying spot id
					service.validateNoFacilityAutoSpot();
					Thread.sleep(2000);
					home.saveButton();
					service.clickOnCancel();
					home.allErrorAlerts();
					driver.close();
					switchToWindow();
					String  stillLoggedInOnD3Dispatch =  diHome.getTextDispatchTitle();
					reporter.SuccessReport("<b>Still logged in on D3 Dispatch</b>", "Text:"+stillLoggedInOnD3Dispatch);


					dimcdLib.clickOnMCDCloseWindow();
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterCallTypeAsLiveOnlyInDispatch(data.get("LiveOnly"));
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					String pacesetterValue = dimcdLib.getPacesetterValue();
					assertTrue(!(pacesetterValue.equalsIgnoreCase(changePacesettervALUE)), "<b>Edit made is saved successfully</b>"+"Expected::" +pacesetterValue+  "::Value and Actual value::" +changePacesettervALUE+ "::are matched");
					dimcdLib.clickOnMCDCloseWindow();
					diHome.logOut();
					acceptAlert();
					acceptAlert();
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1745",ReportStatus.strMethodName,intCounter,browser);
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
	public void diEditCallInCallRecevingArchivedCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "diEditCallInCallRecevingArchivedCall", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("diEditCallInCallRecevingArchivedCall", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1745: TC-DI_Edit Call In Call Receving"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//Login to d3 ,create a call, navigate to di and search the call
					loginD3CreateCallAndSearchCallInDispatch(data);

					//search archived call in dispatch
					diHome.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
					diHome.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();

					//click on pencil icon in dispatch to navigate to d3
					dimcdLib.clickOnPencilIcon();
					Thread.sleep(10000);
					switchToWindow();
					Thread.sleep(3000);
					//verifying the login in d3
					String autoLoginToD3home =home.getTextD3CallReceivingText();
					reporter.SuccessReport("<b>Automatically logged into Call Receiving</b>", "Text:"+autoLoginToD3home);

					String loadedCallInD3CallSplit[]=member.verifyLiveCallIDInMemberTab().split(" ");
					String loadedCallInD3Call= loadedCallInD3CallSplit[2].replaceAll(",","");
					assertTrue(callID.equalsIgnoreCase(loadedCallInD3Call), "<b>Call clicked on to edit is automatically loaded into Call Receiving</b>"+"Expected::" +callID+  "::Value and Actual value::" +loadedCallInD3Call+ "::are matched");
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.logout();
					acceptAlert();
					acceptAlert();
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1745",ReportStatus.strMethodName,intCounter,browser);
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
	public void openCallReceivingSession(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "openCallReceivingSession", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("openCallReceivingSession", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1745: TC-DI_Edit Call In Call Receving"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//Login to d3 ,create a call, navigate to di and search the call
					loginD3CreateCallAndSearchCallInDispatch(data);

					//search live call in dispatch
					diHome.enterCallTypeAsLiveOnlyInDispatch(data.get("LiveOnly"));
					diHome.enterCallIDInfo(callID);
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();

					//click on pencil icon in dispatch to navigate to d3
					dimcdLib.clickOnPencilIcon();
					Thread.sleep(8000);

					//verifying the login in d3
					switchToWindow();
					String autoLoginToD3home =home.getTextD3CallReceivingText();
					reporter.SuccessReport("<b>Automatically logged into Call Receiving</b>", "Text:"+autoLoginToD3home);

					String loadedCallInD3Call[]=member.verifyLiveCallIDInMemberTab().split(",");
					assertTrue(callID.equalsIgnoreCase(loadedCallInD3Call[0]), "<b>Call clicked on to edit is automatically loaded into Call Receiving</b>"+"Expected::" +callID+  "::Value and Actual value::" +loadedCallInD3Call[0]+ "::are matched");
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					home.logout();
					acceptAlert();
					acceptAlert();
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1745",ReportStatus.strMethodName,intCounter,browser);
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


	public void loginD3CreateCallAndSearchCallInDispatch(Hashtable<String, String> data) throws Throwable
	{
		navigateToApplication("CR");
		login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
		home.messageDialogBoxClose();
		String Member1 = "";
		if (data.get("Member").equals("db")) {
			//fetch member details from db
			//generating a random number everytime to fetch a new record everytime
			int rownum = IntRandomNumberGenerator(50, 1000);
			//member from db
			Member1 = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
			System.out.println("member : " + Member1);
		} else {
			Member1 = data.get("MemberNumber");
		}
		home.memberSearchTextBox(Member1);
		//crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		member.memberNumClick();
		member.labelMemberLevelInMemberDetailsSection();
		location.clickOnLocationTab();
		location.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		vehicle.clickOnVehicleTriageTab();
		vehicle.selectExistingVehicleModel();
		boolean messageAlert=home.verifyMessageDialogBoxClose();
		if(messageAlert){
			home.closeMessageDialogBoxClose();
		}
		vehicle.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		vehicle.handleScriptErrorInVehicleTriagePage();
		vehicle.handleScriptErrorInVehicleTriagePage();
		vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		home.saveButton();
		home.allErrorAlerts();
		Thread.sleep(10000);
		callID = service.getCallId();
		callDateCreated = service.getCallDate();
		callDateStr = callDateCreated.replaceAll("-", "");
		service.clickOnRemainInCall();
		Thread.sleep(5000);
		vehicle.handleScriptErrorInVehicleTriagePage();
		vehicle.handleScriptErrorInVehicleTriagePage();
		home.logout();

		//navigating to dispatch
		navigateToApplication("DI");
		diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
		role.clickOnProceedBtnInDispatchRoleLogin();
		diLoginLib.waitcloseAllBusyIcons();
		diHome.clickOnCloseIconOnQueueSelection();
		diHome.clickOnSearchCallsInDispatch();
	}

}
