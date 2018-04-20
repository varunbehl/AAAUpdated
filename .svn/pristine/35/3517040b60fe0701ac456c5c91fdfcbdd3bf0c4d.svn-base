package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DICancelCallsUpdate extends LoginLib {
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
	CRSearchCallsLib crSearchCallsLib = new CRSearchCallsLib();

	String newCallId;
	String callDateCreated;
	String callDateStr;

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void verifyDICancelCallsUpdate(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyDICancelCallsUpdate", TestData, "D3Dispatch");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyDICancelCallsUpdate", TestData, "D3Dispatch",intCounter);

					this.reporter.initTestCaseDescription("1803:TC_DI Cancel Calls Update"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//D3 CALL RECEV.//NEW CALL CREATED
					String spCall =createSPCall(data);
					//checking if call id is not null
					if(!spCall.equalsIgnoreCase(null))
					{
						//D3 DISPATCH //VERIFY above call
						loginToDIAndClickOnProfile(data);
						diHome.clickActionReqTabOnProfile();
						Thread.sleep(10000);
						Boolean veriFyCallInActionReq = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
						assertTrue(veriFyCallInActionReq, "<b>Call ID with status SP in Required Profile Tab</b>");
						diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
						Thread.sleep(10000);
						diHome.logOut();

						//D3 CALL RECEV.//CANCEL the above call
						navigateToApplication("CR");
						login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
						Thread.sleep(5000);
						crMemberSearchLib.clickOnPartialCallCloseButton();
						crHomeLib.messageDialogBoxClose();
						Thread.sleep(5000);
						crSearchCallsLib.clickOnSearchCalls();
						//diHome.enterStartDate(data.get("startDate"));
						crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
						crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
						diHome.clickOnCallDateOrIDLink();
						Thread.sleep(10000);
						crHomeLib.cancelButton();
						crHomeLib.allErrorAlerts();
						Thread.sleep(5000);
						crHomeLib.clickOnContinueButtonOnKillCallPopup();

						//Load the call to get the status
						crSearchCallsLib.clickOnSearchCalls();
						crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
						crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
						diHome.clickOnCallDateOrIDLink();
						Thread.sleep(10000);
						String callStausIncallRecev[]=crHomeLib.getcallStatus().split(" ");
						crHomeLib.logout();

						//D3 DISPATCH //VERIFY call is canceled
						loginToDIAndClickOnProfile(data);
						diHome.clickActionReqTabOnProfile();
						Thread.sleep(10000);
						Boolean veriFyCallInActionReq1 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
						assertTrue(veriFyCallInActionReq1, "<b>Call ID is available in Required Profile Tab<b>");
						diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
						Thread.sleep(2000);
						String callStatusInMCD[]=dimcdLib.getCallStatusInMCD().split(" ");
						boolean CallStatusOfCall=callStausIncallRecev[2].equalsIgnoreCase(callStatusInMCD[0]);
						assertTrue(CallStatusOfCall,"Expected::" +callStausIncallRecev[2]+  "::Value and Actual value::" +callStatusInMCD[0]+ "::<b>are matched</b>");
						Thread.sleep(10000);
						diHome.logOut();

					}
					else
					{
						reporter.failureReport("<b>spCall:</b>","Unable tp proceed because call ID is null");
					}

					//D3 CALL RECEV.//NEW CALL CREATED
					String spcall1=createSPCall(data);
					//checking if call id is not null
					if(!spcall1.equalsIgnoreCase(null))
					{
						//D3 DISPATCH //VERIFY above call in actionReq. tab
						loginToDIAndClickOnProfile(data);
						diHome.clickActionReqTabOnProfile();
						Thread.sleep(10000);
						Boolean veriFyCallInActionReq2 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
						assertTrue(veriFyCallInActionReq2, "<b>Call ID with status SP in Required Profile Tab</b>");
						diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
						Thread.sleep(10000);
						diHome.logOut();

						//D3 CALL RECEV.//LOAD above call and update
						navigateToApplication("CR");
						login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
						Thread.sleep(5000);
						crMemberSearchLib.clickOnPartialCallCloseButton();
						crHomeLib.messageDialogBoxClose();
						Thread.sleep(5000);
						crSearchCallsLib.clickOnSearchCalls();
						diHome.enterStartDate(data.get("startDate"));
						crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
						crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
						diHome.clickOnCallDateOrIDLink();
						Thread.sleep(5000);
						crHomeLib.saveButton();
						Thread.sleep(5000);
						services.enterInResonForStatusStatus(data.get("statusReason"));
						services.enterInCommentStatus(data.get("commentStatusUpdate"));
						services.clickOnUpdateButtonOnCallStatusWindow();
						boolean statusVisibility = services.verifyE268ErrorMessageAvailablity();
						if(!statusVisibility)
						{
							services.closeCall();
							//Load th call to get the status
							crSearchCallsLib.clickOnSearchCalls();
							crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
							crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
							diHome.clickOnCallDateOrIDLink();
							Thread.sleep(10000);
							String callStausIncallRecev[]=crHomeLib.getcallStatus().split(" ");
							crHomeLib.logout();


							//D3 DISPATCH //VERIFY above call is canceled
							loginToDIAndClickOnProfile(data);
							diHome.clickActionReqTabOnProfile();
							Thread.sleep(10000);
							Boolean veriFyCallInActionReq3 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
							assertTrue(veriFyCallInActionReq3, "<b>Call ID is available in Required Profile Tab</b>");
							Thread.sleep(2000);
							diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
							Thread.sleep(2000);
							String callStatusInMCD[]=dimcdLib.getCallStatusInMCD().split(" ");;
							boolean CallStatusOfCall=callStausIncallRecev[2].equalsIgnoreCase(callStatusInMCD[0]);
							assertTrue(CallStatusOfCall,"Expected::" +callStausIncallRecev[2]+  "::Value and Actual value::" +callStatusInMCD[0]+ "<b>::are matched</b>");
							Thread.sleep(10000);
							diHome.logOut();
						}
						else
						{
							services.getE268ErrorMessage();
							services.clickOnE268OKButton();
							reporter.failureReport("<bCall:</b>","Unable to proceed because E268: Unknown error occurred with the D3 Integration Service.");
						}

						}
					else
					{
						reporter.failureReport("<b>spCall:</b>","Unable tp proceed because call ID is null");
					}
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI","1803",ReportStatus.strMethodName,intCounter,browser);
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

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void verifyDICancelCallsUpdateOnPoppedoutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyDICancelCallsUpdate", TestData, "D3Dispatch");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyDICancelCallsUpdate", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("1803:TC_DI Cancel Calls Update" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//D3 CALL RECEV.//NEW CALL CREATED
					String spcall = createSPCall(data);
					//checking if call id is not null
					if (!spcall.equalsIgnoreCase(null)) {
						//D3 DISPATCH //VERIFY above call
						loginToDIAndClickOnProfile(data);
						dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
						diHome.clickActionReqTabOnProfile();
						Thread.sleep(10000);
						Boolean veriFyCallInActionReq = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
						assertTrue(veriFyCallInActionReq, "<b>Call ID with status SP in Required Profile Tab</b>");
						Thread.sleep(5000);
						diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
						Thread.sleep(5000);
						dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
						diHome.clickToMinimizeProfileWindow();
						Thread.sleep(10000);
						diHome.logOut();

						//D3 CALL RECEV.//CANCEL above call
						navigateToApplication("CR");
						login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
						Thread.sleep(5000);
						crMemberSearchLib.clickOnPartialCallCloseButton();
						crHomeLib.messageDialogBoxClose();
						Thread.sleep(5000);
						crSearchCallsLib.clickOnSearchCalls();
						//diHome.enterStartDate(data.get("startDate"));
						crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
						crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
						diHome.clickOnCallDateOrIDLink();
						Thread.sleep(5000);
						crHomeLib.cancelButton();
						crHomeLib.allErrorAlerts();
						Thread.sleep(5000);
						crHomeLib.clickOnContinueButtonOnKillCallPopup();

						//Load the call to get the status
						crSearchCallsLib.clickOnSearchCalls();
						crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
						crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
						diHome.clickOnCallDateOrIDLink();
						Thread.sleep(7000);
						String callStausIncallRecev[] = crHomeLib.getcallStatus().split(" ");
						crHomeLib.logout();

						//D3 DISPATCH //VERIFY above call is canceled
						loginToDIAndClickOnProfile(data);
						dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
						diHome.clickActionReqTabOnProfile();
						Thread.sleep(10000);
						Boolean veriFyCallInActionReq1 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
						assertTrue(veriFyCallInActionReq1, "<b>Call ID is available in Required Profile Tab</b>");
						diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
						Thread.sleep(5000);
						dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
						diHome.clickToMinimizeProfileWindow();
						String callStatusInMCD[] = dimcdLib.getCallStatusInMCD().split(" ");
						boolean CallStatusOfCall = callStausIncallRecev[2].equalsIgnoreCase(callStatusInMCD[0]);
						assertTrue(CallStatusOfCall, "Expected::" + callStausIncallRecev[2] + "::Value and Actual value::" + callStatusInMCD[0] + "::<b>are matched</b>");
						Thread.sleep(10000);
						diHome.logOut();
					} else {
						reporter.failureReport("spCall:", "Unable tp proceed because call ID is null");
					}


					//D3 CALL RECEV.//NEW CALL CREATED
					String spcall1 = createSPCall(data);
					//checking if call id is not null
					if (!spcall1.equalsIgnoreCase(null)) {

						//D3 Dispatach //verify call
						loginToDIAndClickOnProfile(data);
						dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
						diHome.clickActionReqTabOnProfile();
						Thread.sleep(10000);
						Boolean veriFyCallInActionReq2 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
						assertTrue(veriFyCallInActionReq2, "<b>Call ID with status SP in Required Profile Tab</b>");
						diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
						Thread.sleep(5000);
						dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
						diHome.clickToMinimizeProfileWindow();
						Thread.sleep(10000);
						diHome.logOut();

						//D3 CALL RECEV.//LOAD above call and update
						navigateToApplication("CR");
						login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
						Thread.sleep(5000);
						crMemberSearchLib.clickOnPartialCallCloseButton();
						crHomeLib.messageDialogBoxClose();
						Thread.sleep(5000);
						crSearchCallsLib.clickOnSearchCalls();
						diHome.enterStartDate(data.get("startDate"));
						crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
						crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
						diHome.clickOnCallDateOrIDLink();
						Thread.sleep(5000);
						crHomeLib.saveButton();
						Thread.sleep(5000);
						services.enterInResonForStatusStatus(data.get("statusReason"));
						services.enterInCommentStatus(data.get("commentStatusUpdate"));
						services.clickOnUpdateButtonOnCallStatusWindow();
						boolean statusVisibility = services.verifyE268ErrorMessageAvailablity();
						if(!statusVisibility)
						{
							services.closeCall();
							//Load th call to get the status
							crSearchCallsLib.clickOnSearchCalls();
							crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
							crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
							diHome.clickOnCallDateOrIDLink();
							Thread.sleep(7000);
							String callStausIncallRecev[] = crHomeLib.getcallStatus().split(" ");
							crHomeLib.logout();


							//D3 Dispatach //verify call is canceled
							loginToDIAndClickOnProfile(data);
							dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
							diHome.clickActionReqTabOnProfile();
							Thread.sleep(10000);
							Boolean veriFyCallInActionReq3 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
							assertTrue(veriFyCallInActionReq3, "<b>Call ID is available in Required Profile Tab</b>");
							Thread.sleep(2000);
							diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
							Thread.sleep(5000);
							dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
							diHome.clickToMinimizeProfileWindow();
							String callStatusInMCD[] = dimcdLib.getCallStatusInMCD().split(" ");
							boolean CallStatusOfCall = callStausIncallRecev[2].equalsIgnoreCase(callStatusInMCD[0]);
							assertTrue(CallStatusOfCall, "Expected::" + callStausIncallRecev[2] + "::Value and Actual value::" + callStatusInMCD[0] + "::<b>are matched</b>");
							Thread.sleep(10000);
							diHome.logOut();
						}
						else {
							services.getE268ErrorMessage();
							services.clickOnE268OKButton();
							reporter.failureReport("<bCall:</b>","Unable to proceed because E268: Unknown error occurred with the D3 Integration Service.");
						}
					}
					else
					{
						reporter.failureReport("spCall:", "Unable tp proceed because call ID is null");
					}
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("DI", "1803", ReportStatus.strMethodName, intCounter, browser);
				//To close the browser after each iteration
				fnCloseTest();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}
	public void loginToDIAndClickOnProfile(Hashtable<String, String> data) throws Throwable {
		CommonLib commonLib =new CommonLib();
		navigateToApplication("DI");
		diHome.verifyandlogOut();
		diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		role.selectRoleInDispatch(data.get("RoleDispatch"));
		commonLib.clickOnProceedBtnForDispatchSPPLogin();
		diHome.clickOnProfile();
		Thread.sleep(5000);
	}
	public String createSPCall(Hashtable<String, String> data) throws Throwable {
		navigateToApplication("CR");
		login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
		crHomeLib.messageDialogBoxClose();
		String Member = "";
		if (data.get("Member").equals("db")) {
			//fetch member details from db
			//generating a random number everytime to fetch a new record everytime
			int rownum = IntRandomNumberGenerator(50, 1000);
			//member from db
			Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
			System.out.println("member : " + Member);
		} else {
			Member = data.get("MemberNumber");
		}
		crHomeLib.memberSearchTextBox(Member);
		//crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		crMemberSearchLib.memberNumClick();
		Thread.sleep(2000);
		crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		crLocationsLib.clickOnLocationTab();
		crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		crVehicleTriageLib.clickOnVehicleTriageTab();
		crVehicleTriageLib.selectExistingVehicleModel();
		boolean messageAlert=crHomeLib.verifyMessageDialogBoxClose();
		if(messageAlert){
			crHomeLib.closeMessageDialogBoxClose();
		}
		crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
		services.clickOnServiceTab();
		if(messageAlert){
			crHomeLib.closeMessageDialogBoxClose();
		}
		services.enterManualFacilityNumber(data.get("spotFacilityID"));
		services.clickOnSpotInServicePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		crHomeLib.saveButton();
		Thread.sleep(2000);
		crHomeLib.allErrorAlerts();
		Thread.sleep(7000);
		newCallId = services.getCallId();
		callDateCreated = services.getCallDate();
		callDateStr = callDateCreated.replaceAll("-", "");
		services.clickOnRemainInCall();
		crHomeLib.logout();
		return newCallId;
	}
}

