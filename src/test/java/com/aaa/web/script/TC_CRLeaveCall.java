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

public class TC_CRLeaveCall extends ActionEngine {
    String callId;
    String phoneNumber;
    String phoneNum;
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void leaveCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "leaveCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					//Open the browser in each iteration
    				fnOpenTest();
    				ReportStatus.fnDefaultReportStatus();
    				ReportControl.intRowCount=intCounter;
    				Hashtable<String, String> data=TestUtil.getDataByRowNo("leaveCall", TestData, "D3CallRecieving",intCounter);

    				this.reporter.initTestCaseDescription("1913:Leave Call"+ " From Iteration " + StartRow + " to " + EndRow );
    				reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//Object Creations
					LoginLib login = new LoginLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRLocationsLib location = new CRLocationsLib();
					CRTowDestinationLib towdestination = new CRTowDestinationLib();
					CRHomeLib home = new CRHomeLib();
					CRServiceLib service = new CRServiceLib();
					CRSearchCallsLib crSearchCallsLib=new CRSearchCallsLib();

					//Login to D3 call receving
					login.login(data.get("LoginName"),data.get("Password"));
					home.messageDialogBoxClose();

					//click on leave button
					home.leaveButton();
					String msgForLeaveCall = home.messageForLeaveCall();
					String msgForLeaveCallexcel=data.get("MsgForLeaveCallexcel");
					assertTrue(msgForLeaveCall.equalsIgnoreCase(msgForLeaveCallexcel),"<b>Message for leave call verified,Displayed Message is ::</b> "+msgForLeaveCall);
					home.allErrorAlerts();

					//verifying there is no call created
					 boolean callIdVisibilityFlag = member.verifyInVisibilityOfCallIDInMemberTab();
					assertTrue(callIdVisibilityFlag,"<b>No call is saved into the live call system</b>");

					//Load the LiveOnly calls,capture the ID and click
					home.clickOnSearchCallDroupDown();
					home.clickOnSearchCallsLink();
					crSearchCallsLib.enterCallTypeAsLiveOnly(data.get("LiveOnly"));
					crSearchCallsLib.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
					home.enterCallStatus(data.get("CallStatus"));
					home.clickOnSearchButtonOnSearchCalls();
					home.waitCloseAllBusyIconsResults();
					String callId = home.getTextCallIdOnSearchCalls();
					String searchCallID[] = callId.split("#");
					String CallIdAfterSplit = searchCallID[1];
					home.clickOnCallIdOnSearchCalls();
					home.waitCloseAllBusyIconsResults();
					vehicle.errorAlertHandlingBeforeEnterMandatoryFields();


					//edit the phone number and leave the call
					 member.enterPhoneNumber(data.get("PhoneNumber_Different"));
					home.leaveButton();
					String secondMsgForLeaveCall = home.messageForLeaveCall();
					String secondMsgForLeaveCallexcel=data.get("SecondMsgForLeaveCallexcel");

					//Validating if the confirmation message for leave call is displayed or not
					assertTrue(secondMsgForLeaveCall.equalsIgnoreCase(secondMsgForLeaveCallexcel),"<b>Message for leave call Is verified after few edits ,displayed message is :: </b>"+secondMsgForLeaveCall);
					home.allErrorAlerts();

					//Loading the same call again to see of the Phone number is updated or not. Expected is not saved.
					home.clickOnSearchCallDroupDown();
					home.clickOnSearchCallsLink();
					home.enterCallIdForSearch(CallIdAfterSplit);
					home.clickOnSearchButtonOnSearchCalls();
					home.clickOnCallIdOnSearchCalls();
					Thread.sleep(5000);
					vehicle.errorAlertHandlingBeforeEnterMandatoryFields();

					//verify edited phone number is not saved.

					boolean phoneNumberFlag = member.verifyEditedPhoneNumberSavesInCallsList(data.get("PhoneNumber_Different"));
					assertTrue(phoneNumberFlag,"<b>Verified with Phone Number, none of your changes were saved</b>");

					//logout
					home.logout();
					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
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
}
