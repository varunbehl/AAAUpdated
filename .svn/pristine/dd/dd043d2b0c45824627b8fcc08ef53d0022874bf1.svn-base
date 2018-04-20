package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRSaveRAPCall extends CRMemberSearchLib {
    public static long ran;


   //save Call For RAPCalls LightService
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void saveRAPCallsLightService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveRapCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveRapCalls", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1924-Save RAP Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                home.workFlowSelectionForRAP();
		                boolean workFlowFlag = member.verifyIsRapWorkFlowSet();
		                //To Verify Work Flow is set to RAP Or Not
					    assertTrue(workFlowFlag, "<b>Verified the step,WorkFlow is set to RAP</b>");
		                member.enterDataInClubCode(data.get("clubCode"));
		                Thread.sleep(2000);
		                //To get Randomly generated RAP Number
		                ran=generateRandomNumber();
		                //Enter All Fields InOrder to save Rap Call
		                member.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),ran,data.get("paymentCode"));
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
		                member.selectType(data.get("phoneType"));
		                member.clickPrimRadioBtnRowOne();
		                locations.clickOnLocationTab();
					    String combineKeys = Keys.chord(Keys.END);
					    sendKeys(combineKeys, "END");
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                //In Batch execution page is Moving up,Because of this ManualEnty link is Not clickable.Below code is used to move the page Down
						String combineKeys1 = Keys.chord(Keys.END);
						sendKeys(combineKeys1, "END");
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
						String combineKeys2 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys2, "HOME");
		                Thread.sleep(3000);
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
						crVehicleTriageLib.problemTriage(data.get("ProblemTriage"), data.get("ProblemType"));
		                Thread.sleep(5000);
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(1000);
						String combineKeys3 = Keys.chord(Keys.END);
						sendKeys(combineKeys3, "END");
		                tow.clickOnManualEntryLinkOnTowDestination();
		                Thread.sleep(2000);
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                home.waitCloseAllBusyIconsResults();
						String combineKeys4 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys4, "HOME");
		                home.saveButton();
		                Thread.sleep(3000);
		                home.waitCloseAllBusyIconsResults();
					//Validating if call ID is created or not in below method
		                services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
		                System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1924",ReportStatus.strMethodName,intCounter,browser);
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
 

    //Save call For RAPCalls FullService
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void saveRAPCallsForFullService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveRapCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveRapCalls", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1924-Save RAP Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                home.workFlowSelectionForRAP();
						boolean workFlowFlag = member.verifyIsRapWorkFlowSet();
						//To Verify Work Flow is set to RAP Or Not
						assertTrue(workFlowFlag, "<b>Verified the step,WorkFlow is set to RAP</b>");
		                member.enterDataInClubCode(data.get("clubCode"));
		                //To Get randomely generated RAP Number
		                ran=generateRandomNumber();
		                member.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),ran,data.get("paymentCode"));
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
		                member.selectType(data.get("phoneType"));
		                member.clickPrimRadioBtnRowOne();
		                locations.clickOnLocationTab();
						String combineKeys1 = Keys.chord(Keys.END);
						sendKeys(combineKeys1, "END");
						Thread.sleep(3000);
		                locations.clickOnManualEntryLinkInLocation();
		                Thread.sleep(3000);
						String combineKeys2 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys2, "HOME");
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                crVehicleTriageLib.clickOnVehicleTriageTab();
						String combineKeys3 = Keys.chord(Keys.END);
						sendKeys(combineKeys3, "END");
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(3000);
						String combineKeys4 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys4, "HOME");
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnTow();
		                crVehicleTriageLib.clickOnBrakeFailurOnTow();
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(1000);
		                tow.clickOnTowDestinationTab();
						//In Batch execution page is Moving up,Because of this ManualEnty link is Not clickable.Below code is used to move the page Down
						String combineKey5 = Keys.chord(Keys.END);
						sendKeys(combineKey5, "END");
		                home.waitCloseAllBusyIconsResults();
		                crVehicleTriageLib.scriptErrorHandle();
		                tow.clickOnAARTowDetinationLink();
		                home.waitCloseAllBusyIconsResults();
		               // tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(3000);
						home.waitCloseAllBusyIconsResults();
		                //Validating if call ID is created or not in below method
		                services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1924",ReportStatus.strMethodName,intCounter,browser);
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

    //Save Call For RAPCalls LockOutServices
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void saveRAPCallsForLockOutServices(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveRapCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveRapCalls", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1924-Save RAP Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		
		
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                home.workFlowSelectionForRAP();
						boolean workFlowFlag = member.verifyIsRapWorkFlowSet();
						//To Verify Work Flow is set to RAP Or Not
						assertTrue(workFlowFlag, "<b>Verified the step,WorkFlow is set to RAP</b>");
		                member.enterDataInClubCode(data.get("clubCode"));
		                //Generate Random Number for Rap ID
		                ran=generateRandomNumber();
		                member.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),ran,data.get("paymentCode"));
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
		                member.selectType(data.get("phoneType"));
		                member.clickPrimRadioBtnRowOne();
		                //Click On Locatiopn tab
		                locations.clickOnLocationTab();
						String combineKeys1 = Keys.chord(Keys.END);
						sendKeys(combineKeys1, "END");
		                locations.clickOnManualEntryLinkInLocation();
						String combineKeys3 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys3, "HOME");
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		               //Click On VehicelTriage Tab
		                crVehicleTriageLib.clickOnVehicleTriageTab();
						String combineKeys2 = Keys.chord(Keys.END);
						sendKeys(combineKeys2, "END");
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(2000);
						String combineKeys4 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys4, "HOME");
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
						crVehicleTriageLib.problemTriage(data.get("ProblemTriage"), data.get("ProblemType"));
		                Thread.sleep(5000);
		                //ClickOn Tow Destination Tab
		                tow.clickOnTowDestinationTab();
						//In Batch execution page is Moving up,Because of this ManualEnty link is Not clickable.Below code is used to move the page Down
						String combineKeys5 = Keys.chord(Keys.END);
						sendKeys(combineKeys5, "END");
		                crVehicleTriageLib.scriptErrorHandle();
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                services.clickOnServiceTab();
		                //services.getFacilityType();
						home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
						String combineKeys6 = Keys.chord(Keys.HOME);
						sendKeys(combineKeys6, "HOME");
		                home.saveButton();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(3000);
					//Validating if call ID is created or not in below method
		                services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1924",ReportStatus.strMethodName,intCounter,browser);
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
}
