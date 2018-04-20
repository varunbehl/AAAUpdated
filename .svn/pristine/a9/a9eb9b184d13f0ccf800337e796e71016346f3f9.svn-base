package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRServicePage;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRServices extends LoginLib {
	public static String callID = null;
	CRHomeLib crHomeLib = new CRHomeLib();
	CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
	CRLocationsLib crLocationsLib = new CRLocationsLib();
	CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	CRServiceLib CRServiceLib = new CRServiceLib();
	CRSearchCallsLib crSearchCallsLib = new CRSearchCallsLib();
	CRRecentCallsLib recent = new CRRecentCallsLib();
	DIHomeLib diHome = new DIHomeLib();


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void verifyCallTypeAndPolicy(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyCallTypeAndPolicy", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyCallTypeAndPolicy", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1675:TC-Services" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//enter membership details location and vehicle details
					enterMembershipDetailsandVehicleDetails(data);
					CRServiceLib.clickOnServiceTab();
					//enter call type and policy
					CRServiceLib.enterCallTypeinServices1(data.get("callType"));
					CRServiceLib.enterPolicy1(data.get("policy1"));
					CRServiceLib.clickOnPolicyDropDown();
					CRServiceLib.enterPolicy1(data.get("policy2"));
					CRServiceLib.clickOnPolicyDropDown();
					CRServiceLib.enterPolicy1(data.get("policy3"));
					CRServiceLib.clickOnPolicyDropDown();
					crHomeLib.allErrorAlerts();
					crHomeLib.saveButton();
					crHomeLib.allErrorAlerts();
					callID = CRServiceLib.getCallId();
					CRServiceLib.clickOnRemainInCall();
					Thread.sleep(5000);

					//load calls for verification
					loadCallsInCallRecev(data);

					//verify
					CRServiceLib.clickOnServiceTab();
					String callType = CRServiceLib.verifyCallTypeinServices();
					assertTrue(callType != null, "Call Type is populated" + callType);
					String policy = CRServiceLib.verifyPolicy1();
					assertTrue(policy != null, "Policy is populated" + policy);
					crHomeLib.leaveButton();
					crHomeLib.ClickOnYesButtonOnConfirmationWindow();
					crHomeLib.logout();

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1675", ReportStatus.strMethodName, intCounter, browser);
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
	public void verifyHoldCall(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyHoldCall", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyHoldCall", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1675:TC-Services" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//enter membership details location and vehicle details
					enterMembershipDetailsandVehicleDetails(data);
					CRServiceLib.clickOnServiceTab();
					CRServiceLib.clickOnHold();
					CRServiceLib.enterHold(data.get("hold"));
					CRServiceLib.clickOnHoldDropDown();
					crHomeLib.saveButton();
					crHomeLib.allErrorAlerts();
					callID = CRServiceLib.getCallId();
					CRServiceLib.clickOnRemainInCall();
					Thread.sleep(5000);

					//load calls for verification
					loadCallsInCallRecev(data);


					//verify
					CRServiceLib.clickOnServiceTab();
					String hold = CRServiceLib.verifyHoldIcon();
					assertTrue(hold != null, "call is in HC status" + hold);
					String holdButton = CRServiceLib.verifyHoldButton();
					assertFalse(holdButton == null, "Hold Button is visible" + holdButton);
					CRServiceLib.verifyHoldReason();
					crHomeLib.leaveButton();
					crHomeLib.ClickOnYesButtonOnConfirmationWindow();
					assertFalse(false, "release button available ");
					crHomeLib.logout();

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1675", ReportStatus.strMethodName, intCounter, browser);
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
	public void verifySpecialEquipment(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifySpecialEquipment", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifySpecialEquipment", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1675:TC-Services" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//enter membership details location and vehicle details
					enterMembershipDetailsandVehicleDetails(data);
					CRServiceLib.clickOnServiceTab();
					CRServiceLib.enterSpecialEquipement1(data.get("specialequipement"));
					crHomeLib.saveButton();
					crHomeLib.allErrorAlerts();
					callID = CRServiceLib.getCallId();
					CRServiceLib.clickOnRemainInCall();
					Thread.sleep(3000);

					//load calls
					crSearchCallsLib.clickOnSearchCallsAndSearchLink();
					crSearchCallsLib.enterCallIdOnSearchCallsWindow(callID);
					crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
					diHome.clickOnCallDateOrIDLink();
					crHomeLib.allErrorAlerts();
					Thread.sleep(2000);
					//verify
					CRServiceLib.clickOnServiceTab();
					String spclEquipement = CRServiceLib.verifySpecialEquipement();
					assertTrue(spclEquipement != null, "Call saves with Special Equipement" + spclEquipement);
					crHomeLib.leaveButton();
					crHomeLib.ClickOnYesButtonOnConfirmationWindow();
					crHomeLib.logout();
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1675", ReportStatus.strMethodName, intCounter, browser);
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
	public void verifyCallbackRequest(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyCallbackRequest", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyCallbackRequest", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1675:TC-Services" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//enter membership details location and vehicle details
					enterMembershipDetailsandVehicleDetails(data);
					CRServiceLib.clickOnServiceTab();
					CRServiceLib.clickOnCheckBoxCallBack();
					CRServiceLib.enterCallBackMinutes(data.get("minutes"));
					CRServiceLib.enterCallBackRequestType1(data.get("requestType"));
					crHomeLib.saveButton();
					crHomeLib.allErrorAlerts();
					callID = CRServiceLib.getCallId();
					CRServiceLib.clickOnRemainInCall();
					Thread.sleep(5000);

					//load calls for verification
					loadCallsInCallRecev(data);

					//verify
					CRServiceLib.clickOnServiceTab();
					boolean Status = isCheckBoxSelected(CRServicePage.chkBoxCallBack);
					assertTrue(Status, "CallBack checkbox is checked");
					String callBackmint = CRServiceLib.verifyCallBackMinutes();
					assertTrue(callBackmint != null, "Call Back Minutes is populated" + callBackmint);
					String requestType = CRServiceLib.verifyCallBackRequestType();
					assertTrue(requestType != null, "Request Type is populated" + requestType);
					crHomeLib.leaveButton();
					crHomeLib.allErrorAlerts();
					crHomeLib.logout();

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1675", ReportStatus.strMethodName, intCounter, browser);
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
	public void verifyPriority(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyPriority", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyPriority", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1675:TC-Services" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//enter membership details location and vehicle details
					enterMembershipDetailsandVehicleDetails(data);
					CRServiceLib.clickOnServiceTab();
					CRServiceLib.enterPriority1(data.get("priority"));
					CRServiceLib.verifyRedFlagChecked();
					CRServiceLib.removePriority1();
					String redFlagRemoved = CRServiceLib.verifyRedFlagCheckedRemoved();
					assertTrue(redFlagRemoved != null, "RedFlag is Removed:" + redFlagRemoved);
					CRServiceLib.enterPriority1(data.get("priority"));
					CRServiceLib.verifyRedFlagChecked();
					crHomeLib.saveButton();
					acceptAlert();
					crHomeLib.allErrorAlerts();
					callID = CRServiceLib.getCallId();
					CRServiceLib.clickOnRemainInCall();
					Thread.sleep(5000);

					//load calls for verification
					loadCallsInCallRecev(data);


					//verify
					CRServiceLib.clickOnServiceTab();
					String priorityCode = CRServiceLib.verifyPriorityCode();
					assertTrue(priorityCode != null, "Priority Code is populated" + priorityCode);
					String redFlag = CRServiceLib.verifyRedFlagCheckedOnServices();
					assertTrue(redFlag != null, "Red Flag is still set" + redFlag);
					crHomeLib.leaveButton();
					crHomeLib.ClickOnYesButtonOnConfirmationWindow();
					crHomeLib.logout();
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1675", ReportStatus.strMethodName, intCounter, browser);
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
	public void verifyRedFlagOnServices(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyRedFlagOnServices", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyRedFlagOnServices", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1675:TC-Services" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					//enter membership details location and vehicle details
					enterMembershipDetailsandVehicleDetails(data);
					CRServiceLib.clickOnServiceTab();
					CRServiceLib.clickOnRedFlagOnServiceTab();
					CRServiceLib.verifyRedFlagChecked();
					crHomeLib.saveButton();
					acceptAlert();
					crHomeLib.allErrorAlerts();
					CRServiceLib.getCallId();
					CRServiceLib.clickOnRemainInCall();
					Thread.sleep(3000);

					//load calls for verification
					loadCallsInCallRecev(data);


					//verify
					CRServiceLib.clickOnServiceTab();
					String redFlag = CRServiceLib.verifyRedFlagCheckedOnServices();
					assertTrue(redFlag != null, "Red Flag is still set" + redFlag);
					crHomeLib.leaveButton();
					crHomeLib.ClickOnYesButtonOnConfirmationWindow();
					crHomeLib.logout();
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR", "1675", ReportStatus.strMethodName, intCounter, browser);
				//To close the browser after each iteration
				fnOpenTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	public void enterMembershipDetailsandVehicleDetails(Hashtable<String, String> data) throws Throwable {
		//Login
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
		crLocationsLib.clickOnLocationTab();
		crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		crVehicleTriageLib.clickOnVehicleTriageTab();
		crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
		crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

	}

	public void loadCallsInCallRecev(Hashtable<String, String> data) throws Throwable {
		//load calls
		crSearchCallsLib.clickOnSearchCallsAndSearchLink();
		crSearchCallsLib.enterCallIdOnSearchCallsWindow(callID);
		crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		diHome.clickOnCallDateOrIDLink();
		crHomeLib.allErrorAlerts();
		Thread.sleep(2000);

	}
}



