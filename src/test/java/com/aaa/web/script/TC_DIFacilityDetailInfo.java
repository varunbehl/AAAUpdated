

package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.File;
import java.util.Hashtable;

public class TC_DIFacilityDetailInfo extends ActionEngine {

	String callId;
	String callIdDate;



	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void CreateCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "FacilityDetailInfo", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("FacilityDetailInfo", TestData, "D3Dispatch",intCounter);
					this.reporter.initTestCaseDescription("1962:FacilityDetailInfo"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

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
					else
					{
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
					crServiceLib.enterManualSpotDetails(data.get("SPPFacilitySpot"));
					vehicle.handleScriptErrorInVehicleTriagePage();
					//vehicle.scriptErrorHandle();
					home.saveButton();
					callId = crServiceLib.getCallId();
					callIdDate = getText(CRServicePage.dateInCallInformationWindow,"Call Date");
					crServiceLib.closeCall();
					home.logout();
				}
					catch(Exception e)
					{
						ReportStatus.blnStatus=false;
					}
					ReportControl.fnEnableJoin();
					ReportStatus.fnUpdateResultStatus("CR","1962",ReportStatus.strMethodName,intCounter,browser);
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

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void FacilityDetailsWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"FacilityDetailInfo", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("FacilityDetailInfo", TestData, "D3Dispatch",intCounter);
					this.reporter.initTestCaseDescription("1962:FacilityDetailInfo"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					this.reporter.initTestCaseDescription("1962:FacilityDetailInfo");

					DIHomeLib diHome = new DIHomeLib();
					DILoginLib diLogin = new DILoginLib();
					DITruckLoadDeafultViewLib diTruckLoad =new DITruckLoadDeafultViewLib();
					DIFacilityDetailInformationLib diFacilityInfo = new DIFacilityDetailInformationLib();
					DISearchCallsLib diSearchCalls = new DISearchCallsLib();
					DIMCDLib diMCD = new DIMCDLib();

					LoginToDIApplication(data);
					String parentHandle = driver.getWindowHandle();
					diHome.clickOnTruckLoadTab();
					if (data.get("SPPUser").equalsIgnoreCase("No")) {
						diHome. clickOnTruckLoadDefaultOption();
					}else{
						diHome.clickOnTruckLoadDefaultOptionSPP();
					}

					if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
						diTruckLoad.clickOnPoppedOutModeInTruckLoadDefaultViewWindow();
						switchToWindow();
					}
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("FacilityNumber"));
					diTruckLoad.DbClickOnFacilityOnDefaultTruck(data.get("FacilityNumber"));

					if(data.get("PoppedMode").equalsIgnoreCase("Yes")) {
						click(DITruckLoadDefaultViewPage.iconMinimizeTruckloadDefaultWindow, "Click on Minimize window");
						switchToWindow(parentHandle);
					}

					boolean bFacilityInfoScreen = diFacilityInfo.IsExistsFacilityDetailInformationScreen();
					assertTrue(bFacilityInfoScreen,"Facility Information screen comes up by double clicking on a truck and facility");
					diFacilityInfo.ClickOnCloseButton();


					diHome.clickOnSearchCallsInSPPDispatch();
					//diSearchCalls.clickAndEnterCallIDInfo("20055"); // --------------------------------------------------------------------------
					diSearchCalls.clickAndEnterCallIDInfo(callId);
					diSearchCalls.clickOnSearchButtonInSearchCallDispatch();

					diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
					diLogin.waitcloseAllBusyIcons();


					if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
						diMCD.maximizeMCDWindow();
						switchToWindow();
					}


					diMCD.ClickOnFacilityLinkOnSummaryTab();
					if(data.get("PoppedMode").equalsIgnoreCase("Yes")){
						diMCD.clickOnReturnToPanelOnMCDWindow();
						diLogin.waitcloseAllBusyIcons();
						switchToWindow(parentHandle);
					}

					bFacilityInfoScreen = diFacilityInfo.IsExistsFacilityDetailInformationScreen();
					assertTrue(bFacilityInfoScreen,"Facility Information screen comes up by after clicking on Facility link on Summary Tab");
					//Step 7
					// Validating TextFields are editable
					for(int i=1; i<=6 ;i++){
						if(i == 6 ) {

							if (data.get("SPPUser").equalsIgnoreCase("No")) {
								boolean textFieldStatus = diFacilityInfo.IsPrimaryContactTextFiledEditableInDispatch(data.get("NameField"+i));
								assertTrue(!textFieldStatus, "Facility Information screen has " + data.get("NameField"+i) + " Field and is not editable");
							} else{
								boolean textFieldStatus = diFacilityInfo.IsPrimaryContactTextFiledEditableInSPPDispatch(data.get("NameField"+i));
								assertTrue(!textFieldStatus, "Facility Information screen has " + data.get("NameField"+i) + " Field and is not editable");
							}

						} else {
							boolean textFieldStatus = diFacilityInfo.IsTextFiledEditable(data.get("NameField"+i));
							assertTrue(!textFieldStatus, "Facility Information screen has " + data.get("NameField" + i) + " Field and is not editable");

						}
					}

					// Validating Comments text Area Field is editable
					boolean bTextFieldStatus = diFacilityInfo.IsCommentsTextFiledEditable(data.get("Comments"));
					assertTrue(!bTextFieldStatus, "Facility Information screen has " + data.get("Comments") + " Field and is not editable");

					// Validating Checkboxes are editable or not
					for(int i=1; i<=3 ;i++) {
						boolean bCheckBoxField = diFacilityInfo.IsCheckBoxFieldEnabledInDetailsTab(data.get("CheckBoxField" + i));
						assertTrue(!bCheckBoxField, "Facility Information screen has " + data.get("CheckBoxField" + i) + " checkbox field and is not editable");
					}

					//Checking the availability of Text Fields
					for(int i=1; i<=6 ;i++){
						if(i == 6){

							if (data.get("SPPUser").equalsIgnoreCase("Yes")) {
								boolean	bNameField = diFacilityInfo.IsPrimaryContactTextFieldExistsInDetailsTabSPPUser(data.get("NameField"+i));
								assertTrue(bNameField,"Facility Information screen has "+data.get("NameField"+i)+" Text field available");
							}else{
								boolean	bNameField = diFacilityInfo.IsPrimaryContactTextFieldExistsInDetailsTabDispatchUser(data.get("NameField"+i));
								assertTrue(bNameField,"Facility Information screen has "+data.get("NameField"+i)+" Text field available");
							}

						}else{
							boolean	bNameField = diFacilityInfo.IsTextFieldExistsInDetailsTab(data.get("NameField"+i));
							assertTrue(bNameField,"Facility Information screen has "+data.get("NameField"+i)+" Text field available");
						}
					}

					// Validating Comments Field exist
					boolean	bCommentsField = diFacilityInfo.IsCommentsTextAreaFieldExistsInDetailsTab(data.get("Comments"));
					assertTrue(bCommentsField,"Facility Information screen has "+data.get("Comments")+" Text field available");

					// Validating ID Field exist
					boolean	bIDField = diFacilityInfo.IsIDFieldExistsInDetailsTab(data.get("IDField"));
					assertTrue(bIDField,"Facility Information screen has "+data.get("IDField")+" Text field available");

					// Checkbox Field Exists
					for(int i=1; i<=3 ;i++) {
						boolean bCheckBoxField = diFacilityInfo.IsCheckBoxFieldExistsInDetailsTab(data.get("CheckBoxField" + i));
						assertTrue(bCheckBoxField, "Facility Information screen has " + data.get("CheckBoxField" + i) + " checkbox field available");
					}

					//Step 8
					diFacilityInfo.SelectTabs(data.get("TabNameContacts"));
					// Field Rep Validaiton
					boolean bFiledRep = diFacilityInfo.IsFieldRepFieldInContactsTabEditable(data.get("FieldRep"));
					assertTrue(!bFiledRep,"'Filed Rep' Field is non editable");
					//Table Validation
					boolean bCellEdit = diFacilityInfo.ClickOnTelephoneTableCells(Integer.parseInt(data.get("TableRow1")),Integer.parseInt(data.get("TableCol3")));
					assertTrue(!bCellEdit,"Telephones table in Contacts tab is non editable");

					// Step 9
					diFacilityInfo.SelectTabs(data.get("TabNamePTAs"));

					boolean bPTAEditButton = diFacilityInfo.IsButtonExistsInPTATab(data.get("PTAEditButton"));
					assertTrue(bPTAEditButton,"EDIT PTA button exists");

					bPTAEditButton = diFacilityInfo.IsButtonExistsInPTATab(data.get("PTAEditDefaultButton"));
					assertTrue(bPTAEditButton,"EDIT Default PTA button exists");

					// Step 10
					diFacilityInfo.ClickButtonOnPTAsTab(data.get("PTAEditButton"));
					boolean  bFacilityWindow = diFacilityInfo.VerifyFacilityWindowExist();
					assertTrue(bFacilityWindow,"The facility PTA window is in view");

					// Step 11

					diHome.closeFacilityWindow();
					diMCD.ClickOnFacilityLinkOnSummaryTab();
					diFacilityInfo.SelectTabs(data.get("TabNamePTAs"));
					diFacilityInfo.ClickButtonOnPTAsTab(data.get("PTAEditDefaultButton"));

					// Step 12
					boolean bMinutes = diFacilityInfo.VerifyMinutesButtonExistInEditDefaultPTAWindow();
					assertTrue(bMinutes,"Minutes Text Field Exists on Edit Default PTA window");

					boolean bSave = diFacilityInfo.VerifySaveButtonExistsInDefaultPTAWindow();
					assertTrue(bSave,"Save Button Exists on Edit Default PTA window");

					boolean bClose = diFacilityInfo.VerifyCloseButtonExistsInDefaultPTAWindow();
					assertTrue(bClose,"Close Button Exists on Edit Default PTA window");
					diFacilityInfo.ClickOnCloseButtonOnEditDefaultPTAWindow();

					// Step 13
					diFacilityInfo.SelectTabs(data.get("TabNameGrids"));

					boolean bTableGrid = diFacilityInfo.VerifyGridTableExistsInGridsTab();
					assertTrue(bTableGrid,"A table view of the assigned grids is displayed");

					boolean bViewGridButton = diFacilityInfo.VerifyViewGridsOnMapButtonExists();
					assertTrue(bViewGridButton,"View Grids on MAP button is displayed");

					// Step 14
						diFacilityInfo.ClickOnTruckListButton();
						boolean bTruckListWindow = diFacilityInfo.VerifyTruckListWindow();
						assertTrue(bTruckListWindow,"The Truck List screen is in view");
					//Step 15
						diFacilityInfo.CloseTruckListWindow();

					// Step 16
					diMCD.ClickOnFacilityLinkOnSummaryTab();
					diFacilityInfo.SelectTabs(data.get("TabNamePTAs"));
					diFacilityInfo.ClickOnViewTruckLoadButton();
					diLogin.waitcloseAllBusyIcons();
					boolean bTruckLoadWindow = diFacilityInfo.VerifyViewTruckLoadWindowExists();
					assertTrue(bTruckLoadWindow,"The TruckLoad window screen is in view");
					//diFacilityInfo.CloseTruckLoadWindow();
					//diHome.logOut();

						// Working on IE
					DesiredCapabilities capab = null;
					capab = DesiredCapabilities.internetExplorer();
					File file = new File("Drivers\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
					// To disable popup blocker.
					capab.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
					// to enable protected mode settings
					capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

					// to get window focus
					capab.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					// to set zoom level is set to 100% so that the native mouse events
					// can be set to the correct coordinates.
					capab.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					capab.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
					capab.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
					Process p = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
					p.waitFor();

					WebDriver IEdriver = new InternetExplorerDriver();
					IEdriver.manage().window().maximize();
					//navigateToIEApplication("DI");
					IEdriver.get(DISPATCH_URL);
					Thread.sleep(6000);

					//Entering User Name and updating report
					waitForVisibilityOfElementIE(LoginPage.txtLoginName, "User Name Text Field", IEdriver);
					boolean bLoginName = typeIE(LoginPage.txtLoginName, data.get("SPPDILoginName"), "User Name",IEdriver);
					if (bLoginName){
						reporter.SuccessReport("Enter text in :: " + "Login Name", "Successfully Entered value" + data.get("SPPDILoginName"));
					}else{
						reporter.failureReport("Enter text in :: " + "Login Name", "Unable To Type On"  + data.get("SPPDILoginName"), driver);
					}

					// Entering Password and updating report
					boolean bPassword = typeIE(LoginPage.txtLoginPassword, data.get("Password"), "Password text field",IEdriver);
					if (bPassword){
						reporter.SuccessReport("Enter text in :: " + "Password", "Successfully Entered value" + data.get("Password"));
					}else{
						reporter.failureReport("Enter text in :: " + "Password", "Unable To Type On"  + data.get("Password"), driver);
					}

					//Clicking on Login Button
					boolean  bLoginButton = clickIE(LoginPage.btnLogin, "Login Button",IEdriver);
					if (bLoginButton){
						reporter.SuccessReport("Click : " + "Login In", "Successfully Clicked On " + "Login In");
					}else{
						reporter.failureReport("Click : " + "Login In", "Unable to click on " + "Login In", driver);
					}

					// Closing Facility Window
					waitForVisibilityOfElementIE(DIHomePage.closeFacilityWindow, "close Facility window",IEdriver);
					boolean bCloseButton = clickIE(DIHomePage.closeFacilityWindow, "close Facility window",IEdriver);
					if (bCloseButton){
						reporter.SuccessReport("Click : " + "Close", "Successfully Clicked On " + "Close");
					}else{
						reporter.failureReport("Click : " + "Close", "Unable to click on " + "Close", driver);
					}

					// CLick on Truck Load menu
					waitForVisibilityOfElementIE(DIHomePage.tabTruckLoad, "TruckLoad Tab",IEdriver);
					boolean bTruckLoad = clickIE(DIHomePage.tabTruckLoad, "TruckLoad Tab",IEdriver);
					if (bTruckLoad){
						reporter.SuccessReport("Click : " + "TruckLoad Tab", "Successfully Clicked On " + "TruckLoad Tab");
					}else{
						reporter.failureReport("Click : " + "TruckLoad Tab", "Unable to click on " + "TruckLoad Tab", driver);
					}
					//Click on Default View on Truck Load menu
					waitForVisibilityOfElementIE(DIHomePage.truckLoadDefaultViewSSP, "Default View On TruckLoad",IEdriver);
					boolean bDefaultView = clickIE(DIHomePage.truckLoadDefaultViewSSP, "Default View On TruckLoad",IEdriver);
					if (bDefaultView){
						reporter.SuccessReport("Click : " + "Default View On TruckLoad", "Successfully Clicked On " + "Default View On TruckLoad");
					}else{
						reporter.failureReport("Click : " + "Default View On TruckLoad", "Unable to click on " + "Default View On TruckLoad", driver);
					}

					//Clicking on facilities text box
					waitForVisibilityOfElementIE(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field",IEdriver);
					boolean bSpotFacility = clickIE(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field",IEdriver);
					if (bSpotFacility){
						reporter.SuccessReport("Click : " + "Click on Spot Facility ID Field", "Successfully Clicked On " + "Click on Spot Facility ID Field");
					}else{
						reporter.failureReport("Click : " + "Click on Spot Facility ID Field", "Unable to click on " + "Click on Spot Facility ID Field", driver);
					}
					//Entering Data on Facilities Text Box
					waitForVisibilityOfElementIE(DIHomePage.txtFacilityIDOnTruckLoad, "Type Spot Facility ID",IEdriver);
					boolean bFacilitySpot = typeIE(DIHomePage.txtFacilityIDOnTruckLoad, data.get("SPPFacilitySpot"), "Type SpotfacilityID",IEdriver);
					if (bFacilitySpot){
						reporter.SuccessReport("Enter text in :: " + "Type SpotfacilityID", "Successfully Entered value" + data.get("SPPFacilitySpot"));
					}else{
						reporter.failureReport("Enter text in :: " + "Type SpotfacilityID", "Unable To Type On"  + data.get("SPPFacilitySpot"), driver);
					}

					Thread.sleep(2000);
					String combineKeys3 = Keys.chord(Keys.TAB);
					sendKeys(combineKeys3, "Tab");
					Thread.sleep(3000);
					// Double clicking on Facility
					Actions action = new Actions(IEdriver);

					action.doubleClick(IEdriver.findElement(DITruckLoadDefaultViewPage.selectFacility(data.get("SPPFacilitySpot")))).perform();
					Thread.sleep(6000);
					/*waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
					mouseDoubleClick(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");*/

					/*// Clicking on Search Calls button in Menu
					waitForVisibilityOfElementIE(DIHomePage.btnSearchCallsForSPP, "Search calls Link",IEdriver);
					boolean bSearchcalls =clickIE(DIHomePage.btnSearchCallsForSPP, "Search calls Link",IEdriver);
					if (bSearchcalls){
						reporter.SuccessReport("Click : " + "Search Calls", "Successfully Clicked On " + "Search Calls");
					}else{
						reporter.failureReport("Click : " + "Search Calls", "Unable to click on " + "Search Calls", driver);
					}
					// Entering CallID
					//boolean bSearchMember = typeIE(DISearchCallsPage.btnCallIDinSearchCall, callId ,"Search Member Text Box",IEdriver);//-----------------------Add Call ID
					boolean bSearchMember = typeIE(DISearchCallsPage.btnCallIDinSearchCall, "20047" ,"Search Member Text Box",IEdriver);//-----------------------Add Call ID
					if (bSearchMember){
						reporter.SuccessReport("Enter text in :: " + "Search Member Text Box", "Successfully Entered value" + callId);
					}else{
						reporter.failureReport("Enter text in :: " + "Search Member Text Box", "Unable To Type On"  + callId, driver);
					}

					// Clicking on Search Button in Search Calls window
					boolean bSearchButton = clickIE(DISearchCallsPage.btnSearchinSearchCall, "Search Button in Search Calls Window",IEdriver);
					if (bSearchButton){
						reporter.SuccessReport("Click : " + "Search Calls", "Successfully Clicked On " + "Search Button in Search Calls Window");
					}else{
						reporter.failureReport("Click : " + "Search Calls", "Unable to click on " + "Search Button in Search Calls Window", driver);
					}

					// Clicking on Call ID on Search Call Window
					waitForVisibilityOfElementIE(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date",IEdriver);
					boolean bCallIdDate = clickIE(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date",IEdriver);
					if (bCallIdDate){
						reporter.SuccessReport("Click : " + "Search Calls", "Successfully Clicked On " + "Call Id and Date");
					}else{
						reporter.failureReport("Click : " + "Search Calls", "Unable to click on " + "Call Id and Date", driver);
					}

					// Clicking on Facility Link on Summary Tab in MCD window
					waitForVisibilityOfElementIE(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary Tab",IEdriver);
					boolean bFacilityLink = clickIE(DIMCDPage.lblFacilityOnFacilitySummary, "Facility In Summary Tab",IEdriver);
					if (bFacilityLink){
						reporter.SuccessReport("Click : " + "Search Calls", "Successfully Clicked On " + "Facility In Summary Tab");
					}else{
						reporter.failureReport("Click : " + "Search Calls", "Unable to click on " + "Facility In Summary Tab", driver);
					}*/

					// Validating SPP Status
					String SPPLogin = getTextIE(DIFacilityDetailInformationPage.lblSPPLogin,"SPP Login",IEdriver);
					assertTrue(SPPLogin.equalsIgnoreCase("SPP Online"),"The SPP status should say logged in");


				}
					catch(Exception e)
					{
						ReportStatus.blnStatus=false;
						reporter.warningReport("Exception Occured", e.getMessage());
						reporter.failureReport("Exception Occured", "Snap Shot", driver);
					}
					ReportControl.fnEnableJoin();
					ReportStatus.fnUpdateResultStatus("CR","1962",ReportStatus.strMethodName,intCounter,browser);
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




	public void LoginToCRApplication(Hashtable<String, String> data) throws Throwable {
		LoginLib login = new LoginLib();
		CRHomeLib home = new CRHomeLib();
		// Logging into the application
		navigateToApplication("CR");
		login.login(data.get("LoginName"), data.get("Password"));
		// Need to handle spinner image here
		//Thread.sleep(5000);
		home.allErrorAlertsNoButton();
		home.messageDialogBoxClose();
	}

	public void LoginToDIApplication(Hashtable<String, String> data) throws Throwable {

		DILoginLib diLogin = new DILoginLib();
		DIHomeLib diHome = new DIHomeLib();
		LoginRoleLib loginRole=new LoginRoleLib();
		navigateToApplication("DI");
		diLogin.login(data.get("DILoginName"), data.get("SPPDIPassword"));
		diLogin.waitcloseAllBusyIcons();
		if (data.get("SPPUser").equalsIgnoreCase("No")){
			loginRole.clickOnProceedBtnInDispatchRoleLogin();
		}

		if (data.get("SPPUser").equalsIgnoreCase("No")) {
			diHome.clickOnDispatchTab();
			diHome.clickOnRemoveAll();
			diHome.clickOnSelectAllLinkOnQueueWindow();
			diHome.clickOnAddButtonOnQueueWindow();
			diHome.clickOnContinueQueuesInDispatch();
			diLogin.waitcloseAllBusyIcons();
		}
		if (data.get("SPPUser").equalsIgnoreCase("Yes")) {
			diHome.closeFacilityWindow();
		}
	}




	/**
	 * waitForVisibilityOfElementIE
	 *
	 * @param by          of (By)
	 * @param locatorName of (String)
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	public boolean waitForVisibilityOfElementIE(By by, String locatorName,WebDriver IEdriver) throws Throwable {
		boolean flag = false;
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
		//LOG.info("Method : " + getCallerMethodName() + "  ::  Locator : " + locatorName);
		WebDriverWait wait = new WebDriverWait(IEdriver, 25);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
			//LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return true;
		} catch (Exception e) {
			//LOG.info("++++++++++++++++++++++++++++Catch Block Start+++++++++++++++++++++++++++++++++++++++++++");
			//LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());

			//LOG.info("++++++++++++++++++++++++++++Catch Block End+++++++++++++++++++++++++++++++++++++++++++");
			return false;
		} finally {
			if (!flag) {
				//reporter.failureReport("Visible of element is false :: ", "Element :: " + locatorName + " is not visible", driver);
			} else {
				//reporter.failureReport("Click : " + locatorName, msgClickFailure + locatorName, driver);
			}
		}
	}

	/**
	 * type
	 *
	 * @param locator     of (By)
	 * @param testData    of (String)
	 * @param locatorName of (String)
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	public boolean typeIE(By locator, String testData, String locatorName, WebDriver IEdriver) throws Throwable {
		boolean status = false;
		try {
			/*LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			LOG.info("Class name : " + getCallerClassName() + "Method name : " + getCallerMethodName());
			LOG.info("Method : Type  ::  Locator : " + locatorName + " :: Data :" + testData);*/
			//WebDriverWait wait = new WebDriverWait(IEdriver, 30);
			//LOG.info("Waiting for element :");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			//LOG.info("Locator is Visible :: " + locator);
//
			IEdriver.findElement(locator).clear();
			//LOG.info("Cleared the existing Locator data : ");
			//WebElement webElement = (WebElement)driver.findElement(locator);
			IEdriver.findElement(locator).sendKeys(testData);
			//LOG.info("Typed the Locator data :: " + testData);
			//LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			status = true;
		} catch (Exception e) {
			status = false;
			//LOG.info(e.getMessage());
		} finally {
			if (!status) {
				if (reportIndicator) {
					//LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					//reporter.failureReport("Enter text in :: " + locatorName, "Unable To Type On"  + testData, driver);
				}
			} else {
				//LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				//reporter.SuccessReport("Enter text in :: " + locatorName, "Successfully Entered value" + testData);
			}
			//reportIndicator = true;
		}
		return status;
	}

	/**
	 * click
	 *
	 * @param locator     of (By)
	 * @param locatorName of (String)
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	public boolean clickIE(By locator, String locatorName,WebDriver IEdriver) throws Throwable {
		boolean status = false;
		//isElementPresent(locator, locatorName);
		try {
			/*LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
			LOG.info("Method : click  ::  Locator : " + locatorName);*/
			WebDriverWait wait = new WebDriverWait(IEdriver, 30);
			//internalServerErrorHandler();
			//LOG.info("Waiting for element");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			//LOG.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			//LOG.info("Clicked on the Locator");
			IEdriver.findElement(locator).click();
			//LOG.info("identified the element :: " + locator);
			//LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			status = true;
		} catch (Exception e) {
			status = false;
			//LOG.info(e.getMessage());
			//reporter.failureReport("Click : " + locatorName, msgClickFailure + locatorName, driver);
		} finally {
			if (!status) {
				if (reportIndicator) {
					//reporter.failureReport("Click : " + locatorName, msgClickFailure + locatorName, driver);
				}
			} else {
				//reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
			}
			reportIndicator = true;
		}
		return status;
	}


	/**
	 * getText
	 *
	 * @param locator     of (By)
	 * @param locatorName of (String)
	 * @return String
	 * @throws Throwable the throwable
	 */
	public String getTextIE(By locator, String locatorName, WebDriver IEdriver) throws Throwable {
		String text = "";
		boolean flag = false;
		//LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
		//LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
		try {
			//waitTime();
			boolean value = isVisibleOnly(locator, locatorName);
			if (value) {
				text = IEdriver.findElement(locator).getText();
				//LOG.info("Locator is Visible and text is retrieved :: " + text);
				flag = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (!flag) {
				//reporter.warningReport("GetText :: ", "Unable to get Text from :: " + locatorName);
				//LOG.info("GetText :: Unable to get Text from :: " + locatorName);
			} else {
				//reporter.SuccessReport("GetText :: " + locatorName, "" + locatorName + " is :" + text);
				//LOG.info("Locator is Visible and text is retrieved :: " + text);
			}
		}
		return text;
	}





}