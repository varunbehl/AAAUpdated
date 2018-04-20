

package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.Hashtable;

public class TC_DIAutoBidCalls extends ActionEngine {

	String callId ="";
	String callIdDate;

  
    /************************************************************************
    * Script Name :- TC_DIAutoBidCalls
    * Method Name :- ValidateAutoBidCallsDisplayedOnProfileMCDTruckloadWindows
    * Module	  :- DI
    * Test Case ID:- 1941
    * Script Date :- 2-Apr-2018
    * Author      :- Sachin
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    *************************************************************************/


	@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateAutoBidCallsDisplayedOnProfileMCDTruckloadWindows(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIAutobidcalls", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIAutobidcalls", TestData, "D3Dispatch",intCounter);
		                this.reporter.initTestCaseDescription("1941:TC_DIAutobidcalls"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

		                // Creating Library Objects
						DIHomeLib diHome = new DIHomeLib();
						DIProfileLib diProfile = new DIProfileLib();
						DILoginLib  diLogin = new DILoginLib();
						DISearchCallsLib diSearchCalls =new DISearchCallsLib();
						DIMCDLib DIMcd = new DIMCDLib();
						DITruckLoadDeafultViewLib diTruckLoad = new DITruckLoadDeafultViewLib();

						// Call is created only once
						if(callId == ""){
							CreateCallAutoBid(data);
						}
						// Navigating to DI Application
						LoginToDIApplication(data);

						// Creating Handle
						String parentHandle = driver.getWindowHandle();

							// Loading the dispatch queues for the facility that is set to Auto Bid
							diHome.clickOnDispatchTab();
							diHome.clickOnRemoveAll();
							diHome.clickOnSelectAllLinkOnQueueWindow();
							diHome.clickOnAddButtonOnQueueWindow();
							diHome.clickOnSpotTab();
							diHome.clickOnSelectAllLinkOnSpotQueueWindow();
							diHome.clickOnAddButtonOnQueueWindow();
							diHome.clickOnContinueQueuesInDispatch();
							diLogin.waitcloseAllBusyIcons();

							// Step 3
							//Click on Profiles Item in Menu items
							waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
							click(DIHomePage.tabDiProfile, "Profile Menu Item");

							//Click on Profiles Name on Profiles List
							click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
							//  Waiting for the visibility of Table column header- Sts.
							waitForVisibilityOfElement(DIProfilePage.lblStsColumnHeaderInProfileWindow,"Column Header: Sts");
							// Waiting for Profile Window
							waitForVisibilityOfElement(DIProfilePage.DialogprofileWindow,"Profile Window");
							Thread.sleep(3000);

							// Changing Profile Window Settings
							resetProfileSettings();

							// Opening Profile Window in Popped out mode
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
								diProfile.clickOnArrowPopTheProfile();
								switchToWindow();
								Thread.sleep(8000);
							}

							// Getting Call Status from Profile window All Calls tab
							String strCallIdStatusAllCallsTab = diProfile.getStatusForCallIDOnAllCallsTab(callId,callIdDate);

							//Validating Call Status on Profile Window
							assertTrue(strCallIdStatusAllCallsTab.equalsIgnoreCase("BD"),"Expected status of the callID "+callId+" is BD,Actual status is "+strCallIdStatusAllCallsTab+" on All Calls Tab on Profile window");

							//Restoring Profile window to Pop In Mode/Restore Profile to Application Panel
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
								switchToWindow();
								diProfile.clickOnArrowPopTheProfile();
								Thread.sleep(3000);
								switchToWindow(parentHandle);
							}

							// Closing Profile window
							//diProfile.CLoseProfileWindow();

							// Step 5 -- Opening MCD window for the call
							diHome.clickOnSearchCallsInSPPDispatch();
							diSearchCalls.clickAndEnterCallIDInfo(callId);
							diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
							diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
							diLogin.waitcloseAllBusyIcons();

							// Opening MCD Window in Popped out mode
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
								DIMcd.maximizeMCDWindow();
								Thread.sleep(5000);
								switchToWindow();
							}

							// Getting the status of the call from MCD window
							String strMCDStatus = DIMcd.getCallStatusOnMCDwindow();

							// Validating Call Status on MCD Window
							assertTrue(strMCDStatus.equalsIgnoreCase("BD - Bid"),"Expected status of the call is BD- Bid "+"Actual status is "+strMCDStatus);

							//Restoring MCD window to Pop In Mode/Restore MCD to Application Panel
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
								Thread.sleep(2000);
								DIMcd.clickOnReturnToPanelOnMCDWindow();
								switchToWindow(parentHandle);
								diLogin.waitcloseAllBusyIcons();
							}
							// Closing MCD window
							DIMcd.CloseMCDWindow();

							// Step 6  --Open the truckload window and load the facility
							diHome.clickOnTruckLoadTab();
							diHome. clickOnTruckLoadDefaultOption();
							Thread.sleep(3000);

							// Opening TruckLoad Default View Window in Popped out mode
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
								diTruckLoad.clickOnPoppedOutModeInTruckLoadDefaultViewWindow();
								switchToWindow();
							}

							// Entering and Selecting Facility on TruckLoad Default View Window
							diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("SPPFacilitySpot"));
							Thread.sleep(3000);
							diTruckLoad.clickOnFacilityOnDefaultTruck(data.get("SPPFacilitySpot"));
							Thread.sleep(3000);

							//Step 7
							// Click on View All Calls
							diTruckLoad.clickOnViewAllCalls();

							//Getting the status of call from truck load window
							String strCallStatus = diTruckLoad.GetCallIDStatus(callId,callIdDate);

							// Validating call status  on truck load window
							assertTrue(strCallStatus.equalsIgnoreCase("BD"),"Expected callID " +callId+" status is BD, Actual status is "+strCallStatus+" on View All Calls filter on truckload window");

							// Clicking on Unassigned Calls
							diTruckLoad.clickOnUnassignedCalls();

							// Getting the status of call from truck load window
							strCallStatus = diTruckLoad.GetCallIDStatus(callId,callIdDate);

							// Validating call status on truck load window
							assertTrue(strCallStatus.equalsIgnoreCase("BD"),"Expected callID " +callId+" status is BD, Actual status is "+strCallStatus+" on Unassigned Calls filter on truckload window");

							//Restoring TruckView window to Pop In Mode/Restore TruckView to Application Panel
							Thread.sleep(2000);
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")) {

								click(DITruckLoadDefaultViewPage.iconMinimizeTruckloadDefaultWindow, "Click on Minimize window");
								Thread.sleep(2000);
								switchToWindow(parentHandle);
							}
							//Closing TruckLoad Default View Window
							diTruckLoad.clickOnCloseIcon();


							// Step 8 --Go back to the MCD window and re-spot the call to a different facility that is not an Auto Bid facility
							// Navigating to MCD window
							diHome.clickOnSearchCallsInSPPDispatch();
							diSearchCalls.clickAndEnterCallIDInfo(callId);
							diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
							diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
							diLogin.waitcloseAllBusyIcons();

							// Opening MCD Window in Popped out mode
							if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
								DIMcd.maximizeMCDWindow();
								switchToWindow();
							}

							// Clicking on StatusUpdate  Tab on MCD window
							DIMcd.clickOnStatusUpdateTab();

							// Entering Status
							DIMcd.enterStatusOnStatusUpdateTab(data.get("Status"));
							Thread.sleep(1000);

							//Entering Reason
							DIMcd.enterReasonInStatusUpdateTab(data.get("Reason"));
							Thread.sleep(1000);

							//Entering Facility
							DIMcd.enterfacilityOnStatusUpdateWindow(data.get("FacilityIdealTowing"));
							Thread.sleep(1000);

							// Clicking on Update Button
							DIMcd.clickOnUpdateButtonInStatusUpdateTab();
							Thread.sleep(3000);

							// Getting the status of the call from MCD window
							strMCDStatus = DIMcd.getCallStatusOnMCDwindow();

							// Validating call status on MCD Window
							assertTrue(strMCDStatus.equalsIgnoreCase("SP - Spotted"),"Expected status of the callID "+callId+" is SP, Actual status is "+strMCDStatus+" on the MCD window");
							Thread.sleep(2000);

							// Step 9 --Re-spot the call again back to the Auto Bid facility
							// Clicking on StatusUpdate  Tab on MCD window
							DIMcd.clickOnStatusUpdateTab();

							//Entering Status
							DIMcd.enterStatusOnStatusUpdateTab(data.get("Status"));

							//Entering Reason
							Thread.sleep(1000);

							// Entering Reason
							DIMcd.enterReasonInStatusUpdateTab(data.get("Reason"));
							Thread.sleep(1000);

							// Entering Facility
							DIMcd.enterfacilityOnStatusUpdateWindow(data.get("FacilityAutoBid"));
							Thread.sleep(1000);

							// Clicking on Update button
							DIMcd.clickOnUpdateButtonInStatusUpdateTab();
							Thread.sleep(3000);

							// Getting the status of the call from MCD window
							strMCDStatus = DIMcd.getCallStatusOnMCDwindow();
							assertTrue(strMCDStatus.equalsIgnoreCase("BD - Bid"),"Expected status of the callID "+callId+" is BD, Actual status is "+strMCDStatus+" on the MCD window");
							diHome.logOut();




    			}
    			catch(Exception e)
    			{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());

				}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1941",ReportStatus.strMethodName,intCounter,browser);
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

	// This functions Logginns to DI Application
    public void LoginToDIApplication(Hashtable<String, String> data) throws Throwable {
		DILoginLib diLogin = new DILoginLib();
		DIHomeLib diHome = new DIHomeLib();
		LoginRoleLib loginRole=new LoginRoleLib();
		navigateToApplication("DI");
		diLogin.login(data.get("DISPPLoginName"), data.get("SPPDIPassword"));
		diLogin.waitcloseAllBusyIcons();
		diLogin.ClickOnProceedButton();
		diLogin.waitcloseAllBusyIcons();
	}

	// This functions Logginns to CR Application
	public void LoginToCRApplication(Hashtable<String, String> data) throws Throwable {
		LoginLib login = new LoginLib();
		CRHomeLib home = new CRHomeLib();
		navigateToApplication("CR");
		login.login(data.get("LoginName"), data.get("Password"));
		home.allErrorAlertsNoButton();
		home.messageDialogBoxClose();
	}


	// This functions sets the priority and order(Ascending/Descending) for Date and ID columns on Profile window
	public void resetProfileSettings() throws Throwable
	{
		DIHomeLib diHomeLib = new DIHomeLib();
		diHomeLib.clickOnGearIconOfProfileWindow();
		DIHomePage diHomePage = new DIHomePage();
		CRHomeLib crHomeLib = new CRHomeLib();
		CRHomeLib home = new CRHomeLib();
		diHomeLib.clickOnResetDefaultSettingOnProfileTab();

		dragAndDrop(diHomePage.lnkStsOnProfileWindow, diHomePage.lnkZoneProfileWindow, "Drag and drop");
		diHomeLib.clickOnRemoveAllOnProfileTab();

		diHomeLib.enterFilterInProfileWindow("ID");
		diHomeLib.clickOnIDOnProfileTab();
		diHomeLib.clickOnAddOnProfileTab();

		clearData(diHomePage.txtFilterInProfileWindow);
		diHomeLib.enterFilterInProfileWindow("Date");
		diHomeLib.clickOnDateOnProfileTab();
		diHomeLib.clickOnAddOnProfileTab();

		diHomeLib.clickOnArrowButtonOfDate();
		diHomeLib.selectPriority("1");
		diHomeLib.selectOrder("Descending");
		diHomeLib.clickOnSaveButtonOfIDAndDateOnProfileWindow();

		diHomeLib.clickOnArrowButtonOfID();
		diHomeLib.selectPriority("2");
		diHomeLib.selectOrder("Descending");
		diHomeLib.clickOnSaveButtonOfIDAndDateOnProfileWindow();

		clearData(diHomePage.txtFilterInProfileWindow);
		diHomeLib.enterFilterInProfileWindow("Sts");
		click(DIProfilePage.lblAvailableSectionColumnName("Sts"),"Available Section Column Sts");
		diHomeLib.clickOnAddOnProfileTab();

		diHomeLib.clickOnSaveSettingsButtonOfProfileWindow();
		//Waiting for the visibility of Table column header- Sts.
		waitForVisibilityOfElement(DIProfilePage.lblStsColumnHeaderInProfileWindow,"Column Header: Sts");
		crHomeLib.allErrorAlerts();
		home.waitCloseAllBusyIconsResults();
	}

	// This functions creates a Auto Bid call with status BD
	public void CreateCallAutoBid(Hashtable<String, String> data) throws Throwable {
		CRHomeLib home = new CRHomeLib();
		CRLocationsLib locations = new CRLocationsLib();
		CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		CRMemberSearchLib memeber = new CRMemberSearchLib();
		CRServiceLib crServiceLib = new CRServiceLib();

		// Logging into the application
		LoginToCRApplication(data);

		String Member = "";
		if (data.get("Member").equals("db")){
			//fetch member details from db
			//generating a random number everytime to fetch a new record everytime
			int rownum = IntRandomNumberGenerator(50,1000);
			//member from db
			Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
			System.out.println("member : "+Member);
		}
		else{
			Member = data.get("MemberNumber");
		}
		home.memberSearchTextBox(Member);
		memeber.memberNumClick();
		//memeber.currentCallClose();
		memeber.ClickPrimRadioBtnInRowTwo();

		// Locations Page Starts
		locations.breakdownLocTabSel();
		locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));

		// Vehicle Triage Page Starts here
		vehicle.clickOnVehicleTriageTab();
		Thread.sleep(1000);
		vehicle.clickOnManualEntryLinkOnVehicle();
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
		vehicle.clickonProblemTypeButton(data.get("TriageType"));
		Thread.sleep(2000);
		vehicle.clickonProblemTypeOptions(data.get("TriageOption"));
		vehicle.handleScriptErrorInVehicleTriagePage();

		// Navigating to services tab
		crServiceLib.clickOnServiceTab();
		home.waitCloseAllBusyIconsResults();
		crServiceLib.enterManualFacilityNumber(data.get("FacilityAutoBid"));
		Thread.sleep(3000);
		crServiceLib. clickOnSpotInServicePage();
		Thread.sleep(3000);
		vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		//vehicle.scriptErrorHandle();
		home.saveButton();
		callId = crServiceLib.getCallId();
		callIdDate = getText(CRServicePage.dateInCallInformationWindow,"Call Date");
		callIdDate = callIdDate.replace("-", "");
		crServiceLib.closeCall();
		home.logout();
	}

}