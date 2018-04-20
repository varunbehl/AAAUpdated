package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E002734 on 2/13/2018.
 */
public class
TC_CRDispatcherUpdateStatus extends CRDispatcherUpdateLib {

	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();
	CRDispatcherUpdateLib dispatcherUpdate=new CRDispatcherUpdateLib();
	CommonLib common=new CommonLib();

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void crDispatcherUpdateCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crDispatcherUpdateCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crDispatcherUpdateCalls", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1963: TC-CR Dispatcher Update Status"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					login.login(data.get("CRLoginName"), data.get("CRPassword"));
					member.clickOnPartialCallCloseButton();
					home.messageDialogBoxClose();
					member.currentCallClose();

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdateNotPresent();

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
					home.memberSearchTextBox(Member);
					home.memberSearchTextBox(data.get("Membersearch"));
					member.memberNumClick();
					member.currentCallClose();
					member.clickPrimRadioBtnSecondRow();
					location.clickOnLocationTab();
					location.enterBreakDownAddressOmniBarSearch(data.get("Address"));
					vehicle.clickOnVehicleTriageTab();
					vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
					vehicle.enterPaceSetterCodeManually(data.get("pacesettercode"));
					Thread.sleep(3000);
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					vehicle.scriptErrorHandle();
					service.clickOnServiceTab();
					vehicle.scriptErrorHandle();
					service.validateFacilityAutospot();
					Thread.sleep(3000);
					home.saveButton();
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					services.clickOnRemainInCall();
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					Thread.sleep(3000);

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.getTextOfDispatcherUpdateStatusTitle();
					dispatcherUpdate.getTextOfStatus();
					dispatcherUpdate.getTextOfBoldStatus();
					dispatcherUpdate.getTextOfResonForStatus();
					dispatcherUpdate.getTextOfBoldDispatchingInformation();
					dispatcherUpdate.getTextOfFacility();
					dispatcherUpdate.getTextOfTruck();
					dispatcherUpdate.getTextOfTechnician();
					dispatcherUpdate.getTextOfTimeStampOverride();
					dispatcherUpdate.getTextOfDate();
					dispatcherUpdate.getTextOfTime();
					dispatcherUpdate.getTextOfComments();
					dispatcherUpdate.clickOnStatusDrpdwnAndGetAllData();


					//Status updates AK ,AS ,DI ,ER ,OL

					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("AK"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					Thread.sleep(2000);
					String updateCodeAk=services.getTextUpdateCode();
					String statusAK = data.get("AK");
					assertTrue(updateCodeAk.equalsIgnoreCase(statusAK),"AK Value Matched");
					services.clickOnCallStatusButton();


					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("AS"));
					dispatcherUpdate.enterInReasonForStatus(data.get("01"));
					dispatcherUpdate.enterTruckId(data.get("A"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					services.getTextCallStatusButton();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					Thread.sleep(2000);
					String updateCodeAs=services.getTextUpdateCode();
					String statusAS = data.get("AS");
					assertTrue(updateCodeAs.equalsIgnoreCase(statusAS),"AS Value Matched");
					String reasonCode01=services.getTextReasonCode();
					String reason01 = data.get("01");
					assertTrue(reasonCode01.equalsIgnoreCase(reason01),"reason  Value Matched");
					String facilityTruckA=services.getTextFacilityTruck();
					String TruckA = data.get("A");
					assertTrue(facilityTruckA.contains(TruckA),"facility/truck Value Matched");
					services.clickOnCallStatusButton();


					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("DI"));
					dispatcherUpdate.enterInReasonForStatus(data.get("01"));
					dispatcherUpdate.enterTruckId(data.get("H"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnCancel();
					Thread.sleep(2000);
					services.getTextCallStatusButton();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					Thread.sleep(2000);
					String updateCodeDI=services.getTextUpdateCode();
					String statusDI = data.get("DI");
					assertTrue(updateCodeDI.equalsIgnoreCase(statusDI),"Status and UpdateCode Value Matched");
					services.clickOnCallStatusButton();


					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("ER"));
					dispatcherUpdate.enterTruckId(data.get("Z"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					services.getTextCallStatusButton();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					String updateCodeER=services.getTextUpdateCode();
					String statusER = data.get("ER");
					assertTrue(updateCodeER.equalsIgnoreCase(statusER),"Status and UpdateCode  Value Matched");
					services.clickOnCallStatusButton();


					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("OL"));
					dispatcherUpdate.enterTruckId(data.get("A"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					services.getTextCallStatusButton();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					Thread.sleep(2000);
					String updateCodeOL=services.getTextUpdateCode();
					String statusOL = data.get("OL");
					assertTrue(updateCodeOL.equalsIgnoreCase(statusOL),"Status and UpdateCode  Value Matched");
					services.clickOnCallStatusButton();


					//Status update missing reason code, Red flag

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("RF"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.getTextOfErrorUpdateCode();
					dispatcherUpdate.clickOnCancel();

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("RF"));
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInReasonForStatus(data.get("ON"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					//service.clickOnServiceTab();
					//vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("TC"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.getTextOfErrorUpdateCode();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterInStatus(data.get("TC"));
					dispatcherUpdate.enterInReasonForStatus(data.get("1A"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					Thread.sleep(2000);
					String updateCodeTC=services.getTextUpdateCode();
					String statusTC = data.get("TC");
					assertTrue(updateCodeTC.equalsIgnoreCase(statusTC),"Status and UpdateCode Value Matched");
					String reasonCode1A=services.getTextReasonCode();
					String reasn1A = data.get("1A");
					assertTrue(reasonCode1A.equalsIgnoreCase(reasn1A),"reason  Value Matched");
					services.clickOnCallStatusButton();



					//SP status

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.clearTruck();
					dispatcherUpdate.enterFacilityNotEditable();
					dispatcherUpdate.enterInStatus(data.get("SP"));
					dispatcherUpdate.enterFacility(data.get("EnterFacility"));
					dispatcherUpdate.enterInReasonForStatus(data.get("AR"));
					dispatcherUpdate.clickOnUpdate();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					vehicle.handleScriptErrorInVehicleTriagePage();
					home.allErrorAlerts();
					services.clickOnCallStatusButton();
					home.allErrorAlerts();
					services.clickOnDateToArrange();
					Thread.sleep(2000);
					//services.getTextFacilityTruck();
					String updateCodeSP=services.getTextUpdateCode();
					String statusSP = data.get("SP");
					assertTrue(updateCodeSP.equalsIgnoreCase(statusSP),"Status and UpdateCode Value Matched");

					String enterFacility=services.getTextFacilityTruck();
					String facilityA = data.get("EnterFacility");
					assertTrue(enterFacility.contains(facilityA),"facility/truck Value Matched");

					String reasonCodeAR=services.getTextReasonCode();
					String reasonAR = data.get("AR");
					assertTrue(reasonCodeAR.equalsIgnoreCase(reasonAR),"reason code  Value Matched");
					services.clickOnCallStatusButton();



					//TimeStamp Override

					home.clickOnCurrentCall();
					home.verifyDispatchStatusUpdatePresentAndClick();
					dispatcherUpdate.enterInStatus(data.get("UP"));
					dispatcherUpdate.enterDate(data.get("Date"));
					Thread.sleep(3000);
					dispatcherUpdate.enterTime(data.get("Time"));
					dispatcherUpdate.enterInComments(data.get("Comment"));
					dispatcherUpdate.enterInReasonForStatus(data.get("01"));
					dispatcherUpdate.clickOnUpdate();
					vehicle.clickOnCommentButton();
					vehicle.getDateAndTime();
					vehicle.getCommentedValue();
					vehicle.clickOnCommentButton();
					dispatcherUpdate.clickOnOK();
					dispatcherUpdate.clickOnCancel();
					home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				dispatcherUpdate.clickOnOK();
    				dispatcherUpdate.clickOnCancel();
    				home.logout();

    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1963",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
}

