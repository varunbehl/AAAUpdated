package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DISearchCallsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DITruckLoadDataUpdate extends LoginLib {
	public static String callID;
	LoginLib login = new LoginLib();
	CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
	CRHomeLib crHomeLib = new CRHomeLib();
	CRLocationsLib crLocationsLib = new CRLocationsLib();
	CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CRServiceLib services = new CRServiceLib();
	DILoginLib diLoginLib = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	DIHomeLib diHome = new DIHomeLib();
	DIMCDLib dimcdLib = new DIMCDLib();
	DISearchCallsPage diSearchCallsPage = new DISearchCallsPage();
	public static String callIDCreated;
	public static String spotIDCreated;
	public static String callDateCreated;
	public static String callIDAndDateCombined;
	public static String[] callandfacilityId = new String[4];
	CRSearchCallsLib crSearchCallsLib = new CRSearchCallsLib();
	DITruckLoadDeafultViewLib DITruckload = new DITruckLoadDeafultViewLib();

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
	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyDITruckLoadDataUpdate(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyDITruckLoadDataUpdate", TestData, "D3Dispatch");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyDITruckLoadDataUpdate", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("1806:TC_DI Truck Load Data Update" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					/*//d3 dispatch truckload//truck to Inacive
                	loginToDI(data);
                	diHome.clickOnTruckLoadTab();
               	 	diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.rightClickActiveSpecificTruckOnDefaultTruckLoad(data.get("TruckID"));
					DITruckload.clickSetTruckToInactive();
					DITruckload.verifyIconChangeToInactive(data.get("TruckID"));
                	diHome.logOut();*/

					//D3 CALL RECEV.//NEW CALL CREATED
					createCall(data);

					/*//d3 dispatch truckload//truck to acive
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.rightClickActiveSpecificTruckOnDefaultTruckLoad(data.get("TruckID"));
					DITruckload.clickSetTruckToActive();
					DITruckload.verifyIconChangeToActive(data.get("TruckID"));
					diHome.logOut();*/


					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickOnUnassignedCalls();
					callFlow(data);
					String callPresent=dimcdLib.lblCallSpottedStatus();
					assertTrue(!callPresent.equalsIgnoreCase("null"), "<b>Call ID with status SP in available</b>");
					diHome.logOut();

					//D3 SPP DISPTACH//assign driver
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					Thread.sleep(2000);
					dimcdLib.clickOnAssign();
					dimcdLib.selectFacilityOnAssignTabForDataUpdate();  //assign to B
					diHome.logOut();


					//d3 dispatch truckload//verify assign Status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					dimcdLib.lblCallAssignedStatus(data.get("StatusupdateAS"));
					diHome.logOut();


					//D3 SPP DISPTACH//select dispatch
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.selectDispatch();
					diHome.logOut();

					//d3 dispatch truckload//verify dispatch status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					dimcdLib.lblCallDispatchedStatus(data.get("StatusupdateDI"));
					diHome.logOut();

					//D3 SPP DISPTACH//select enrout
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.selectEnroute();
					dimcdLib.selectEnrouteTime();
					diHome.logOut();


					//d3 dispatch truckload// verify enroute status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					Thread.sleep(3000);
					dimcdLib.lblCallENRouteStatus(data.get("StatusupdateER"));
					diHome.logOut();


					//D3 SPP DISPTACH//select location
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.selectOnLocation();
					diHome.logOut();


					//d3 dispatch truckload//verify location status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					dimcdLib.lblCallOnLocationStatus(data.get("StatusupdateOL"));
					diHome.logOut();

					//d3 call receiving//cancel call
					navigateToApplication("CR");
					login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(5000);
					crMemberSearchLib.clickOnPartialCallCloseButton();
					crHomeLib.messageDialogBoxClose();
					Thread.sleep(5000);
					crSearchCallsLib.clickOnSearchCalls();
					diHome.enterStartDate(data.get("startDate"));
					crSearchCallsLib.enterCallIdOnSearchCallsWindow(callandfacilityId[0]);
					crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
					diHome.clickOnCallDateOrIDLink();
					Thread.sleep(5000);
					crHomeLib.cancelButton();
					crHomeLib.allErrorAlerts();
					crHomeLib.clickOnContinueButtonOnKillCallPopup();
					crHomeLib.logout();


					//d3 dispatch truckload//verify call clear
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					Thread.sleep(2000);
					dimcdLib.labelCallCancelled(data.get("StatusUpdateCA"));
					diHome.logOut();


					//D3 SPP DISPTACH//clear and submit
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.selectClearCall();
					Thread.sleep(3000);
					dimcdLib.selectCancelinClearCall();
					dimcdLib.selectServiceNotEnroute();
					dimcdLib.clickOnSubmit();
					diHome.logOut();

					//d3 dispatch truckload//verify call is not present or removed
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					diHome.logOut();


					//D3 SPP DISPTACH//out of vehicle
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.setTruckBToOutOfVehicle();
					diHome.logOut();

					//d3 dispatch truckload//verify out of vehicle
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyTruckBStatusOutOfVehicle();
					diHome.logOut();

					//D3 SPP DISPTACH//in vehicle
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.setTruckBToInVehicle();
					diHome.logOut();

					//d3 dispatch truckload//verify in vehicle
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyTruckBStatusInVehicle();
					diHome.logOut();

					//D3 SPP DISPTACH//add comments
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					//DITruckload.clickOnTruckBToAddComment();
					DITruckload.rightClickActiveSpecificTruckOnDefaultTruckLoad(data.get("truckID"));
					DITruckload.mouseHoverOnDefaultTruckLoad();
					DITruckload.clickSetDriverCommentDefaultTruckLoad();
					DITruckload.typeDrivercomment(data.get("DriverComment"));
					DITruckload.clickDrivercommentSaveBtn();
					diHome.logOut();

					//d3 dispatch truckload//verify comment
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyDriverComment();
					diHome.logOut();

					//D3 SPP DISPTACH//remocve comments
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					//DITruckload.clickOnTruckBToAddComment();
					DITruckload.rightClickActiveSpecificTruckOnDefaultTruckLoad(data.get("truckID"));
					DITruckload.mouseHoverOnDefaultTruckLoad();
					DITruckload.clickClearDriverCommentDefaultTruckLoad();
					diHome.logOut();

					//d3 dispatch truckload//verify remove comment
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyDriverCommentClear();
					diHome.logOut();

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI", "1806", ReportStatus.strMethodName, intCounter, browser);
				//To close the browser after each iteration
				fnCloseTest();
			}
		} catch (Exception e) {
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

	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyDITruckLoadDataUpdateInPopOut(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyDITruckLoadDataUpdate", TestData, "D3Dispatch");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyDITruckLoadDataUpdate", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("1806:TC_DI Truck Load Data Update" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					/*//d3 dispatch truckload//truck to Inacive
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
                    DITruckload.verifyTruckAAndsettoInactive();
                    diHome.logOut();*/

					//D3 CALL RECEV.//NEW CALL CREATED
					createCall(data);

					/*//d3 dispatch truckload//truck to acive
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.setTruckBtoActive();
					DITruckload.verifyIconChangeToActive(data.get("TruckBactive"));
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();*/


					//D3 SPP DISPTACH//assign driver
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.clickOnPoppedOutButtonInMCDTabInSpp();
					dimcdLib.clickOnAssign();
					dimcdLib.selectFacilityOnAssignTabForDataUpdate();  //assign to B
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();


					//d3 dispatch truckload//verify assign Status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					dimcdLib.lblCallAssignedStatus(data.get("StatusupdateAS"));
					diHome.logOut();


					//D3 SPP DISPTACH//select dispatch
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					dimcdLib.selectDispatch();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//d3 dispatch truckload//verify dispatch status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					dimcdLib.lblCallDispatchedStatus(data.get("StatusupdateDI"));
					diHome.logOut();

					//D3 SPP DISPTACH//select enrout
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					dimcdLib.selectEnroute();
					dimcdLib.selectEnrouteTime();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();


					//d3 dispatch truckload// verify enroute status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					dimcdLib.lblCallENRouteStatus(data.get("StatusupdateER"));
					diHome.logOut();


					//D3 SPP DISPTACH//select location
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					dimcdLib.selectOnLocation();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();


					//d3 dispatch truckload//verify location status
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					dimcdLib.lblCallOnLocationStatus(data.get("StatusupdateOL"));
					diHome.logOut();

					//d3 call receiving//cancel call
					navigateToApplication("CR");
					login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(5000);
					crMemberSearchLib.clickOnPartialCallCloseButton();
					crHomeLib.messageDialogBoxClose();
					Thread.sleep(5000);
					crSearchCallsLib.clickOnSearchCalls();
					diHome.enterStartDate(data.get("startDate"));
					crSearchCallsLib.enterCallIdOnSearchCallsWindow(callandfacilityId[0]);
					crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
					diHome.clickOnCallDateOrIDLink();
					Thread.sleep(5000);
					crHomeLib.cancelButton();
					crHomeLib.allErrorAlerts();
					crHomeLib.clickOnContinueButtonOnKillCallPopup();
					crHomeLib.logout();


					//d3 dispatch truckload//verify call clear
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					dimcdLib.labelCallCancelled(data.get("StatusUpdateCA"));
					diHome.logOut();


					//D3 SPP DISPTACH//clear and submit
					loginToSPPDI(data);
					diHome.clickOnSearchCallsInDispatch();
					diHome.enterStartDate(data.get("startDate"));
					diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
					diHome.clickOnSearchInSearchCalls();
					diHome.clickOnCallDateOrIDLink();
					dimcdLib.clickOnPoppedOutButtonInMCDTabInSpp();
					dimcdLib.selectClearCall();
					Thread.sleep(3000);
					dimcdLib.selectCancelinClearCall();
					dimcdLib.selectServiceNotEnroute();
					dimcdLib.clickOnSubmit();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//d3 dispatch truckload//verify call is not present or removed
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTabInDispatch();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					Thread.sleep(4000);
					DITruckload.clickTruckIDOfCallID(data.get("truckID"));
					callFlow(data);
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();


					//D3 SPP DISPTACH//out of vehicle
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.setTruckBToOutOfVehicle();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//d3 dispatch truckload//verify out of vehicle
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTabInDispatch();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyTruckBStatusOutOfVehicle();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//D3 SPP DISPTACH//in vehicle
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.setTruckBToInVehicle();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//d3 dispatch truckload//verify in vehicle
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTabInDispatch();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyTruckBStatusInVehicle();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//D3 SPP DISPTACH//add comments
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.clickOnTruckBToAddComment();
					DITruckload.mouseHoverOnDefaultTruckLoad();
					DITruckload.clickSetDriverCommentDefaultTruckLoad();
					DITruckload.typeDrivercomment(data.get("DriverComment"));
					DITruckload.clickDrivercommentSaveBtn();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//d3 dispatch truckload//verify comment
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTabInDispatch();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyDriverComment();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();
					//D3 SPP DISPTACH//remocve comments
					loginToSPPDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOptionInSpp();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.clickOnTruckBToAddComment();
					DITruckload.mouseHoverOnDefaultTruckLoad();
					DITruckload.clickClearDriverCommentDefaultTruckLoad();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();

					//d3 dispatch truckload//verify remove comment
					loginToDI(data);
					diHome.clickOnTruckLoadTab();
					diHome.clickOnTruckLoadDefaultOption();
					dimcdLib.clickOnPoppedOutButtonInTruckloadTabInDispatch();
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
					DITruckload.verifyDriverCommentClear();
					driver.close();
					Thread.sleep(3000);
					switchToWindow();
					Thread.sleep(1000);
					diHome.logOut();


				} catch (Exception e) {
					ReportStatus.blnStatus = false;
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI", "1806", ReportStatus.strMethodName, intCounter, browser);
				//To close the browser after each iteration
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}


	public void callFlow(Hashtable<String, String> data) throws Throwable {
		//Map is out of scope
		crHomeLib.messageDialogBoxClose();
		switch (data.get("CallFlow")) {
			case "Profile":
				diHome.clickOnProfile();
				callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
				diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
				break;
			case "MCD":
				diHome.clickOnSearchCallsInDispatch();
				diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
				diHome.clickOnSearchInSearchCalls();
				diHome.clickOnCallDateOrIDLink();
				break;
			case "Truckload":
               /* diHome.clickOnTruckLoad();
                diHome.enterSpotFacilityIDInfoOnTruckLoad(callandfacilityId[1]); //spotIDCreated
                diHome.clickOnSpotFacilityOntruckLoadTextBox();
                Thread.sleep(5000);
                diHome.dateDecendingOrder();*/
				callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
				diHome.searchAndClickOnCallIdOnTruckloadWindow1(callIDAndDateCombined);
				break;
			default:
				break;
		}
	}

	public String[] completeCall(String CompleteCall) throws Throwable {
		switch (CompleteCall) {
			case "Save":
				crHomeLib.saveButton();
				crHomeLib.allErrorAlerts();
				callIDCreated = services.getCallId();
				spotIDCreated = services.getSpotFacilityId();
				callDateCreated = services.getCallDate();
				services.closeCall();
				break;
			case "Cancel":
				crHomeLib.cancelButton();
				//below function will click on Yes on confirmation window
				crHomeLib.allErrorAlerts();
				break;
			default:
				break;
		}
		callandfacilityId[0] = callIDCreated;
		callandfacilityId[1] = spotIDCreated;
		callandfacilityId[2] = callDateCreated;
		return callandfacilityId;
	}

	public void createCall(Hashtable<String, String> data) throws Throwable {
		//new call//d3 call recev.
		navigateToApplication("CR");
		login(data.get("LoginName"), data.get("Password"));
		Thread.sleep(5000);
		crMemberSearchLib.clickOnPartialCallCloseButton();
		crHomeLib.messageDialogBoxClose();
		Thread.sleep(5000);
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
		services.clickOnServiceTab();
		services.enterManualFacilityNumber(data.get("spotFacilityID"));
		services.clickOnSpotInServicePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		completeCall(data.get("CompleteCall"));
		crHomeLib.logout();
	}

	public void loginToDI(Hashtable<String, String> data) throws Throwable {
		//d3 dispatch truckload//truck to acive
		navigateToApplication("DI");
		diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		Thread.sleep(2000);
		role.selectRoleInDispatch(data.get("RoleDispatch"));
		Thread.sleep(5000);
		role.clickOnProceedBtnInDispatchRoleLogin();
		diLoginLib.waitcloseAllBusyIcons();
		diHome.clickOnCloseIconOnQueueSelection();

	}
	public void loginToSPPDI(Hashtable<String, String> data) throws Throwable {
		navigateToApplication("DI");
		diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		Thread.sleep(5000);
		diLoginLib.waitcloseAllBusyIcons();
		diHome.clickOnCloseIconOnFacilityPTA();

	}
}
