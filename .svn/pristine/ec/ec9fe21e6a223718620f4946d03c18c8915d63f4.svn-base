package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDArchivedCalls extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;

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

    public void DIMCDArchivedCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDArchivedCalls", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDArchivedCalls", TestData, "D3Dispatch",intCounter);

		                this.reporter.initTestCaseDescription("2009: TS-DI MCD Archived Calls"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" User Role:" +data.get("LoginNameForDI")+"  **************");

		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		                CommonLib common = new CommonLib();
		//Login into the Application with Either DI Dispatch or SPP Dispatch
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
						common.clickOnProceedBtnForDispatchSPPLogin();
		                diHome.clickOnSearchCallsLink();

		                //entering values in searchcalls
		                diSearchCalls.enterStartDate(data.get("startDate"));
		                diSearchCalls.enterEndDate(data.get("endDate"));
		                diSearchCalls.enterValueInStatusTextBonInSearchCalls(data.get("status"));
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                diSearchCalls.selectClearCallRow();
		                //Selecting Archived calls
                        //Validating Update Pannel and bottom 5 buttons

		                boolean updatePanelVisibility = dimcd.validateAssign();
		                assertTrue(!updatePanelVisibility,"<b>Update Panel Container is not available</b>");
		                //Validating for Edit call and Duplicate call, For SPP users this feature is not visiable
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    boolean editCallButton = dimcd.verifyEditCallButtonOnMCDWindow();
		                    assertTrue(editCallButton, "<b>Edit call button is visible</b>");

		                    boolean duplicateCallButton = dimcd.verifyDuplicateCallButtonOnMCDWindow();
		                    assertTrue(duplicateCallButton, "<b>Duplicate Call button is visible</b>");
		                }
		                Thread.sleep(2000);
		                boolean printCallButton = dimcd.verifyPrintCallButtonOnMCDWindow();
		                assertTrue(printCallButton,"<b>Print button is visible</b>");
		                boolean paymentButton = dimcd.verifyPaymentButtonOnMCDWindow();
		                assertTrue(paymentButton,"<b>Payment Button is visible</b>");
		                //For SPP User Credit card button is not visible
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    boolean creditCardButton = dimcd.verifyCreditCardButtonOnMCDWindow();
		                    assertTrue(creditCardButton, "<b>Credit card Button is visible</b>");
		                }

		                dimcd.clickOnServiceTabInMCDWindow();
		                //Trying to edit values for Archived calls
					boolean availablityOfEditLink=dimcd.verifyAdditionalInfoLinkInMCDServiceTab();
					if(availablityOfEditLink) {
						dimcd.clickOnAdditionalInfoLinkInMCDServiceTab();
						dimcd.enterSpecialEquipmentInMCDServiceTab(data.get("specialEqupementInMCD"));
						dimcd.clickOnSaveButtonInSpecialEquiptmentSection();
						Thread.sleep(2000);
						dimcd.enterReasonForStatus(data.get("reasonForStatus"));
						dimcd.enterCommentsInUpdateCallStatus(data.get("comments"));
						dimcd.clickOnUpdateButtonInUpdateStatus();
						//Capturing error message
						crHomeLib.getErrorMessageTextFromAlert();
						dimcd.clickOnMCDCloseWindow();
						diHome.logOut();
					}else{
						reporter.failureReport("<b>Edit Link Visiblility ","<b>This user is not having edit functiaonlity to edit the fields",driver);
						dimcd.clickOnMCDCloseWindow();
						diHome.logOut();
					}
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2009",ReportStatus.strMethodName,intCounter,browser);
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
