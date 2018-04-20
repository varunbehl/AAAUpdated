package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMCDStatusUpdatesButtons extends ActionEngine {
	String callId1;
	String currentStatus;
	String nextStatus;
	String spotStatus;
	String assignStatus;
	String currentStatusData;
	String nextStatusData;
	String dispatchStatus;
	String enrouteStatus;
	String onLocationStatus;
	String towStatus;
	String clearStatus;
	String bidStatus;

	DIHomeLib diHome = new DIHomeLib();
	LoginLib login = new LoginLib();
	DILoginLib diLogin = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	DIMCDLib mcdlib = new DIMCDLib();
	CRServiceLib service = new CRServiceLib();
	CRTowDestinationLib tow = new CRTowDestinationLib();
	CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
	CRHomeLib crHomeLib = new CRHomeLib();
	CRLocationsLib crLocationsLib = new CRLocationsLib();
	CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CommonLib commonLib = new CommonLib();

	//Common method for creating the call
	public void createCallForDIMCDStatusUpdate(Hashtable<String,String> data)throws  Throwable {
		try {
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

			//Searching Member Number
			crHomeLib.memberSearchTextBox(Member);
			crMemberSearchLib.memberNumClick();
			crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
			Thread.sleep(2000);

			//Entering the breakdown location
			crLocationsLib.breakdownLocTabSel();
			crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));

			//To enter Vehicle Information
			commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "",data.get("ProblemTriage"), data.get("ProblemType"));
			crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			crHomeLib.allErrorAlerts();
			Thread.sleep(2000);
			tow.clickOnTowDestinationTab();
			crHomeLib.waitCloseAllBusyIconsResults();
			crVehicleTriageLib.scriptErrorHandle();
			crHomeLib.allErrorAlerts();
			Thread.sleep(3000);

			//Click on TowDetination Link and enter tow passengers
			tow.clickOnAARTowDetinationLink();
			tow.enterTowPassengers(data.get("TowPassengers"));
			Thread.sleep(2000);

			//Click on service tab and spot manually
			service.clickOnServiceTab();
			crHomeLib.waitCloseAllBusyIconsResults();
			service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
			crVehicleTriageLib.scriptErrorHandle();
			crHomeLib.saveButton();
			crHomeLib.waitCloseAllBusyIconsResults();
			Thread.sleep(3000);

			//Saving the call and validating the call id is not null in getCallId method
			callId1 = service.getCallId();
			service.closeCall();
			crHomeLib.logout();


		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

//This method is for creating call to validate 1 to 14 test steps In :: 1788 SPP Status Update Buttons
	/************************************************************************
	 * Script Name :saveCallForStatusUpdateButton
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
	public void saveCallForStatusUpdateButton(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving",intCounter);

					this.reporter.initTestCaseDescription("1788: TC-DI MCD Status Updates (Buttons)"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling the common method to create a call
					createCallForDIMCDStatusUpdate(data);
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);

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

	/*Verifing the statusUpdate buttons on DI MCD Window.
	This method is validating 2 - 14 Test Steps*/
	// SSP MCD Window
	/************************************************************************
	 * Script Name :-
	 * Method Name :-statusUpdatesOnSPPMCDWindow
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
	public void statusUpdatesOnDIMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDWindowStatusUpdates", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDWindowStatusUpdates", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1788: TC-DI MCD Status Updates (Buttons)"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//Navigate to Dispatch application
					navigateToApplication("DI");
					Thread.sleep(4000);
					diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
					role.clickOnProceedBtnInDispatchRoleLogin();
					diLogin.waitcloseAllBusyIcons();
					diHome.clickOnCloseIconOnQueueSelection();
					diHome.clickOnSearchCallsInDispatch();

					//Enter created call id in Search calls page
					diHome.enterCallIDInfo(callId1);
					diHome.clickOnSearchInSearchCalls();
					crHomeLib.waitCloseAllBusyIconsResults();
					diHome.clickOnCallDateOrIDLink();
					crHomeLib.waitCloseAllBusyIconsResults();
					currentStatus = mcdlib.getStatusOnCurrentButton();
					nextStatus = mcdlib.getStatusOnNextButton();
					spotStatus = mcdlib.getCallStatusOnMCDwindow();

					currentStatusData = data.get("CurrentStatus");
					nextStatusData = data.get("NextStatus");


					//Checking call statutes
					boolean statusFlag1 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
					assertTrue(statusFlag1, "<b>SP button is highlighted and the AS button  is marked as the next status</b>");
					mcdlib.clickOnAssign();
					mcdlib.selectSecondFacilityOnAssignTabInMCD();

					Thread.sleep(3000);
					assignStatus = mcdlib.getCallStatusOnMCDwindow();
					assertTrue(spotStatus != assignStatus, "<b>Truck list Opened , Verified the Status & Status changed from  SP  To AS </b>");

					currentStatus = mcdlib.getStatusOnCurrentButton();
					nextStatus = mcdlib.getStatusOnNextButton();
					//spotStatus = mcdlib.getCallStatusOnMCDwindow();

					boolean statusFlag2 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
					assertTrue(statusFlag2, "<b> AS button is highlighted and the DI status button is marked as the next status</b>");
					mcdlib.selectDispatch();
					Thread.sleep(2000);
					dispatchStatus = mcdlib.getCallStatusOnMCDwindow();
					assertTrue(assignStatus != dispatchStatus, "<b>Verified the Status & Status changed from  AS To DI</b> " );

					currentStatus = mcdlib.getStatusOnCurrentButton();
					nextStatus = mcdlib.getStatusOnNextButton();
					boolean statusFlag3 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
					assertTrue(statusFlag3, "<b>DI button is highlighted and the ER status button  is marked as the next status</b>");

					mcdlib.selectEnroute();
					mcdlib.selectEnrouteTime();
					Thread.sleep(2000);

					enrouteStatus = mcdlib.getCallStatusOnMCDwindow();
					assertTrue(dispatchStatus != enrouteStatus, "<b>Verified the Status & Status changed from   DI To ER </b>");
					currentStatus = mcdlib.getStatusOnCurrentButton();
					nextStatus = mcdlib.getStatusOnNextButton();
					boolean statusFlag4 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
					assertTrue(statusFlag4, "<b> ER button is highlighted and the OL status button  is marked as the next status</b>");

					mcdlib.selectOnLocation();
					Thread.sleep(2000);
					onLocationStatus = mcdlib.getCallStatusOnMCDwindow();
					assertTrue(enrouteStatus != onLocationStatus, "<b>Verified the Status & Status changed from  ER To OL </b>");

					currentStatus = mcdlib.getStatusOnCurrentButton();
					nextStatus = mcdlib.getStatusOnNextButton();
					boolean statusFlag5 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
					assertTrue(statusFlag5, "<b>OL button is highlighted and the TW status button is marked as the next status</b>");

					mcdlib.clickOnTW();
					Thread.sleep(2000);
					towStatus = mcdlib.getCallStatusOnMCDwindow();
					assertTrue(onLocationStatus != towStatus, "<b>Verified the Status & Status changed from  OL To TW </b>");
					currentStatus = mcdlib.getStatusOnCurrentButton();
					nextStatus = mcdlib.getStatusOnNextButton();
					boolean statusFlag6 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
					assertTrue(statusFlag6, "<b>TW button is highlighted and the CL status button is marked as the next status</b>");
					//Payment
					mcdlib.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));


					mcdlib.selectClearCall();


					Thread.sleep(3000);
					boolean clearingTabFlag = mcdlib.verifyClearingTabOnSPPMCDWindow();
					assertTrue(clearingTabFlag, "<b>Clearing tab is Visible on MCD Window after click On call</b>");

					mcdlib.clickOnNoGo();
					mcdlib.selectExitCode();
					mcdlib.enterReason(data.get("Reason"));
					mcdlib.clickOnContinue();
					Thread.sleep(3000);
					mcdlib.clickOnNoTowPerformed();
					Thread.sleep(5000);
					mcdlib.clickOnSubmit();
					mcdlib.clickOnSubmit();
					Thread.sleep(3000);
					clearStatus = mcdlib.getCallStatusOnMCDwindow();
					assertTrue(towStatus != clearStatus, "<b>Verified the Status & The status of the call changed to CL </b> ");
					mcdlib.clickOnMCDCloseWindow();
					diHome.logOut();

				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);

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
	/*This method is for creating call for Bid status verification
	 * This call creation is used for validating 15 - 20 Test Steps In MCD Window PoppedIn Mode*/
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
	public void saveCallForPoppedInWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving",intCounter);

					this.reporter.initTestCaseDescription("1788: TC-DI MCD Status Updates (Buttons)"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//Calling common method to create a call.
					createCallForDIMCDStatusUpdate(data);

				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);

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
	/*This method Is for  Bid status Button verification On MCD PoppedIn Mode.
	 * Validating 15 -20 steps*/
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
	public void buttonStatusUpdatesOnMCDPoppedInWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDWindowStatusUpdates", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {

					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDWindowStatusUpdates", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1788: TC-DI MCD Status Updates (Buttons)"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					navigateToApplication("DI");
					Thread.sleep(4000);
					diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
					role.clickOnProceedBtnInDispatchRoleLogin();
					diLogin.waitcloseAllBusyIcons();
					diHome.clickOnCloseIconOnQueueSelection();
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterCallIDInfo(callId1);
					diHome.clickOnSearchInSearchCalls();
					crHomeLib.waitCloseAllBusyIconsResults();
					diHome.clickOnCallDateOrIDLink();
					crHomeLib.waitCloseAllBusyIconsResults();

					//Calling the common method for verifing BID functionality
					bidStatusverificationOnMCD(data);
					mcdlib.clickOnMCDCloseWindow();
					diHome.logOut();
					acceptAlert();
					Thread.sleep(2000);
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
				ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);

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
	public void saveCallForPoppedOutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving",intCounter);

					this.reporter.initTestCaseDescription("1788: TC-DI MCD Status Updates (Buttons)"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					createCallForDIMCDStatusUpdate(data);
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);

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
	public void buttonStatusUpdatesOnMCDPoppedOutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDWindowStatusUpdates", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDWindowStatusUpdates", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1788: TC-DI MCD Status Updates (Buttons)"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					navigateToApplication("DI");
					Thread.sleep(2000);
					diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
					role.clickOnProceedBtnInDispatchRoleLogin();
					diLogin.waitcloseAllBusyIcons();
					diHome.clickOnCloseIconOnQueueSelection();
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterCallIDInfo(callId1);
					diHome.clickOnSearchInSearchCalls();
					crHomeLib.waitCloseAllBusyIconsResults();
					diHome.clickOnCallDateOrIDLink();
					crHomeLib.waitCloseAllBusyIconsResults();

					mcdlib.clickOnPoppedOutButton();
					crHomeLib.waitCloseAllBusyIconsResults();
					switchToWindow();
					Thread.sleep(3000);
					boolean poppedoutFlag = mcdlib.verifyPoppedOutWindow();
					assertTrue(poppedoutFlag, "<b>Switched To PoppedOut MCD window </b>");
					bidStatusverificationOnMCD(data);
					assertTrue(poppedoutFlag, "<b>The expected results are same in both PoppedOut MCD and PoppedIn MCD </b>");
					mcdlib.clickOnPoppedInButton();
					//Calling method To swicth back to MCD window In PoppedIn Mode
					switchToWindow();
					Thread.sleep(3000);
					mcdlib.clickOnMCDCloseWindow();
					diHome.logOut();
					acceptAlert();
					Thread.sleep(2000);
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
				ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);

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


	public void bidStatusverificationOnMCD(Hashtable<String, String> data) throws Throwable {
		try {
			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			spotStatus = mcdlib.getCallStatusOnMCDwindow();
			currentStatusData = data.get("CurrentStatus");
			nextStatusData = data.get("NextStatus");

			boolean statusFlag1 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag1, "<b>SP button is highlighted and the AS button  is marked as the next status</b>");

			mcdlib.clickOnBidCallButton();
			bidStatus = mcdlib.getCallStatusOnMCDwindow();
			assertTrue(spotStatus != assignStatus, "<b>Verified the Status & Status changed from  SP To BD </b>");

			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			//spotStatus = mcdlib.getCallStatusOnMCDwindow();

			boolean statusFlag2 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag2, "<b> The BD button highlighted and the AS button should be marked as the next status</b>");
			mcdlib.clickOnAssign();
			Thread.sleep(3000);
			mcdlib.selectSecondFacilityOnAssignTabInMCD();
			String asStatus = mcdlib.getCallStatusOnMCDwindow();
			assertTrue(bidStatus != asStatus, "<b>Verified the Status & Status changed from  BD To AS </b>");
			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			//spotStatus = mcdlib.getCallStatusOnMCDwindow();

			boolean statusFlag3 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag3, "<b> AS button is highlighted with the DI button marked as the next status</b>");

			mcdlib.clickOnDeclineButton();
			String declineBtnStatus = mcdlib.getCallStatusOnMCDwindow();
			assertTrue(asStatus != declineBtnStatus, "<b>Verified the Status & Status changed from AS TO DC  </b>");
			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			//spotStatus = mcdlib.getCallStatusOnMCDwindow();

			boolean statusFlag4 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag4, "<b> DC button is highlighted and  AS button is marked as the next status</b>");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
