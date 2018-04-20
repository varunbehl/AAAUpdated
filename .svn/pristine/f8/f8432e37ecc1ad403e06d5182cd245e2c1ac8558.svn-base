package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDEditBreakDownLocation extends DILoginLib {

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

    public void DIMCDEditBreakDownlocation(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDEditBreakDownlocation", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDEditBreakDownlocations", TestData, "D3Dispatch",intCounter);
    	
			                this.reporter.initTestCaseDescription("2293: TS-DI MCD Edit BreakDown Location"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                CRHomeLib home = new CRHomeLib();
			                LoginRoleLib role = new LoginRoleLib();
			                DIHomeLib diHome = new DIHomeLib();
			                CRHomeLib crHomeLib = new CRHomeLib();
			                CRMemberSearchLib member = new CRMemberSearchLib();
			                CRLocationsLib locations = new CRLocationsLib();
			                //CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
			                CRServiceLib services = new CRServiceLib();
			                //CRTowDestinationLib tow = new CRTowDestinationLib();
			                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
			                CR_DI crDI = new CR_DI();
			                DIMCDLib dimcd = new DIMCDLib();
			                LoginRoleLib loginRole=new LoginRoleLib();
			                DILoginLib diLogin = new DILoginLib();
			                CommonLib common = new CommonLib();
			
			                navigateToApplication("DI");
			                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
							common.clickOnProceedBtnForDispatchSPPLogin();
			                diHome.clickOnSearchCallsLink();
			
			//entering values in searchcalls
                            String currentDate=common.getCurrentDate();
                            String endDate=common.getPreviousDate(currentDate);
			                diSearchCalls.enterStartDate(data.get("startDate"));
			                diSearchCalls.enterEndDate(endDate);
			                diSearchCalls.enterValueInStatusTextBonInSearchCalls(data.get("status"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diHome.clickOnCallDateOrIDLink();
			                dimcd.clickOnLocationsTabInMCDWindow();
			                dimcd.clickOnBreakDownLocationsEditLinkInMCD();
			                dimcd.enterAddressInSearvicesInMCDWindow(data.get("addressSearch"));
			                dimcd.clickOnSearchButtonInServicesInMCDWindow();
			                boolean emptryRecords= dimcd.getEmptryRecordErrorMessageInMCD();
			                boolean recordsPanelNotFund = dimcd.verifySearchResultsGridAvailablity();
							boolean insufficetData = dimcd.validateInsufficientInformationError();
                    		if(insufficetData==false) {
			                if(emptryRecords==true || recordsPanelNotFund==true)  {
			                    String searchedAddress =dimcd.getAddressFromResults();
			                    dimcd.clickOnTowDestinationAddressInResultsGrid();
			                    dimcd.getValueOfStreetNumberInMCDWindow();
			                    dimcd.getValueOfStreetNameInMCDWindow();
			                    dimcd.getValueOfCityInMCD();
			                    dimcd.getValueOfFirstCrossStreetInMCD();
			                    dimcd.getValueOfSecondCrossStreetInMCD();
			                    dimcd.getValueOfStateInMCD();
			                    dimcd.getValueOfZipInMCD();
			                    dimcd.getValueOfLandMarkInMCD();
			                    dimcd.getValueOfLatitudeInMCD();
			                    dimcd.getValueOfLongitudeInMCD();
			                    if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
			                        dimcd.getAddressVerifiedInMCD();
			                    }else{
			                        //dimcd.clickOnGetCoOrdinatesInMCD();
			                        dimcd.getAddressVerifiedInMCD();
			                    }
                                String random = getRandomString(15);
                                String comments = dimcd.enterCommentsInTowDestinationAndLocationsTabsInMCDWindow(random);
			                    dimcd.enterUpdateReasonInMCD(data.get("reasonForStatus"));
			               /* String reasonForStatus = dimcd.enterReasonForStatus(data.get("reasonForStatus"));
			                String comments = dimcd.enterCommentsInUpdateCallStatus(data.get("comments"));
			               */
			
			                    dimcd.clickOnSaveButtonInMCDWindow();

			                    boolean errorAvailability=dimcd.verifyErrorMessageAvailability();
			                    if(errorAvailability)
			                    {
			                    dimcd.validateErrorMessage();
			                    //crHomeLib.getErrorMessageTextFromAlert();
			                    dimcd.clickOnErrorOkayButtonInMCDWindow();

			                    }else{

                                    String commentsFromCommentsSection=dimcd.getCommentsFromCommentsWindow(comments);
                                    assertTrue(commentsFromCommentsSection.equalsIgnoreCase(comments),"<b>Both entered comments:: "+comments+" ::and Saved comments:: "+commentsFromCommentsSection+" ::are same</b>");

			                        /*if ((data.get("sppUser").equalsIgnoreCase("Yes"))) {
                                        String latestComments= dimcd.getCommentsFromCommentsWindow(comments);
                                    //String latestComments = dimcd.getlblLatestCommentsInMCDWindow();
                                    Boolean resultsForComments = dimcd.compareTwoValues(latestComments, comments);
                                    assertTrue(resultsForComments, "Comments are saved in comments section--- You are in first conditon");
                                } else {
                                    String latestComments = dimcd.getSecondRowCommentsInCommentsSectionInMCDWindow();
                                    Boolean resultsForComments = latestComments.equalsIgnoreCase(comments);

                                    if (resultsForComments == false) {
                                        String latestCommentsFirstrow = dimcd.getlblLatestCommentsInMCDWindow();
                                        Boolean resultsForCommentsFirstRow = latestCommentsFirstrow.equalsIgnoreCase(comments);
                                        assertTrue(resultsForCommentsFirstRow, "Comments are saved in comments section");
                                    }
                                    assertTrue(resultsForComments, "Comments are saved in comments section");
                                }*/
			                        dimcd.clickOnStatusHistoryLinkOnMCDWindow();
			                        dimcd.clickOnDateHeaderToSortDate();
			                        dimcd.getStatusInHistoryStatusScreenInMCDWindow();
			
			                    }
			                }else
			                {
			                    assertTrue(emptryRecords|| recordsPanelNotFund," Records found");
			
			                }
                    }else
                    {
                        dimcd.getInsufficientInformationError();
                        assertTrue(insufficetData, " insufficent data entered");
                        dimcd.clickOn306ErrorOkayButton();
                    }
			
			
			
			                dimcd.clickOnMCDCloseWindow();
			                diHome.logOut();
			
			                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2293",ReportStatus.strMethodName,intCounter,browser);
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
