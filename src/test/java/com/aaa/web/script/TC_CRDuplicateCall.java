package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.CRServicePage;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by e002222 on 16-01-2018.
 */
public class TC_CRDuplicateCall extends ActionEngine {
    public String callid;
    public String callIdOnMemberTab;
	public String callIdOnMemberTabAfterNo;
    public static long ran;
    public int Num;
    public String RandomNum;
   
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void DuplicateCallFromSearchResult(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DuplicateCallFromSearchResult", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DuplicateCallFromSearchResult", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a Call from search call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
						CRVehicleTriageLib crCommonError = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                Thread.sleep(2000);
		                crSearchCall.enterCallsTypeInSearchCalls(data.get("Calls"));
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                //crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();

		                String CallIdDate=crSearchCall.getCallIdAndDate();
		
		                String splitStr[] = CallIdDate.split("\n");
		                String startDateValue= splitStr[0];
		
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		                Date CurrentCallIdDate = dateFormat.parse(startDateValue);
		
		                System.out.println("CurrentCallIdDate is ++++++++++++++++++++ " +CurrentCallIdDate);
		
		                int oldCallId = Integer.parseInt(callid);
		                //crSearchCall.clickCallIDwithoutRAPSearCallWindow();
					 	 crSearchCall.clickDuplicateIconOnSearchResultWindow();

						//crCommonError.crCommonErrorHandler();
					 // home.duplicateButton();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                Thread.sleep(4000);
		                member.currentCallClose();

						crCommonError.crCommonErrorHandler();
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertTrue(!callIdOnMemberTab.contains(callid), "Call id should not present");

						Pattern p = Pattern.compile("([0-9])");
						Matcher m = p.matcher(callIdOnMemberTab);

						if(m.find()){
							System.out.println("CallID is "+m.find());
							assertTrue(false, "Call id"+m.find()+" should not present");
						}
		                crLocationsLib.clickOnLocationTab();
						click(CRLocationsPage.linkManualEntryOnLocationTab,"Enter Address Manually");
						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crCommonError.crCommonErrorHandler();
						crHomeLib.clickOnAutospotFailMsgOk();
						Thread.sleep(2000);
						crVehicleTriageLib.clickOnVehicleTriageTab();
						crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crCommonError.crCommonErrorHandler();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						crCommonError.crCommonErrorHandler();
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");

						Thread.sleep(3000);
						crCommonError.crCommonErrorHandler();
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
						Thread.sleep(3000);
		                Date callDate=service.getCallDateAfterCallSaveInDateForma();
		                System.out.println("callDate is ++++++++++++++++++++ " +callDate);
		                String CDate=service.getCurrentDate();
		
		                String splitStr1[] = CDate.split("\n");
		                String currentdateValue1= splitStr1[0];
		
		                SimpleDateFormat dateFormat11 = new SimpleDateFormat("MM/dd/yyyy");
		                Date CyrrentDte = dateFormat11.parse(currentdateValue1);
		
		                System.out.println("currentDate is ++++++++++++++++++++ " +CyrrentDte);
		
		                if(CurrentCallIdDate.before(CyrrentDte)){
		                 assertTrue(callDate.equals(CyrrentDte),"Call date should be equal to current date i.e. " + CyrrentDte+"\b");
		                }
		                else if(CurrentCallIdDate.equals(CyrrentDte)) {
		                    assertTrue(callDate.equals(CyrrentDte), "Call date is equal to todays date");
		                }
		
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(newCallId !=null, "New Call Id "+newCallId+ "is Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void cancelDuplicateCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "cancelDuplicateCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("cancelDuplicateCall", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1640: Cancel a duplicate Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
						CRVehicleTriageLib crCommonError = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterCallsTypeInSearchCalls(data.get("Calls"));
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		                int oldCallId = Integer.parseInt(callid);


						callid = crSearchCall.getCallIdOnSearCallWindow();
						//crSearchCall.searchAndSelectCallIDOnSearCallWindow(data);
						crSearchCall.clickCallIDwithoutRAPSearCallWindow();
						Thread.sleep(3000);


						crCommonError.crCommonErrorHandler();
						callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();

                        crCommonError.crCommonErrorHandler();
						home.duplicateButton();
						crSearchCall.clickDuplicateCallIDConfNo();
						boolean verifyDuplicateMsgPopUP= crSearchCall.verifyCallDuplicateMsgPopWindow();
						assertTrue(!verifyDuplicateMsgPopUP, "CallID duplicate msg pop up should not appear");

					  	callIdOnMemberTabAfterNo = crSearchCall.getCallIdFromMemberTab();
						assertTrue(callIdOnMemberTab.equalsIgnoreCase(callIdOnMemberTabAfterNo), "Call id should be same after clicking NO for duplicate call");
						member.currentCallClose();
						home.allErrorAlertsNoButton();
						home.messageDialogBoxClose();
						Thread.sleep(4000);
						crCommonError.crCommonErrorHandler();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void duplicateAnArchivedCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "duplicateAnArchivedCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("duplicateAnArchivedCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: Duplicate an Archived call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
						CRVehicleTriageLib crCommonError = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
		                crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
		                //crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		
		
		                String CallIdDate=crSearchCall.getCallIdAndDate();
		
		                String splitStr[] = CallIdDate.split("\n");
		                String startDateValue= splitStr[0];
		
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		                Date CurrentCallIdDate = dateFormat.parse(startDateValue);
		
		                System.out.println("CurrentCallIdDate is ++++++++++++++++++++ " +CurrentCallIdDate);


						crSearchCall.clickCallIDwithoutRAPSearCallWindow();
						crCommonError.crCommonErrorHandler();
						home.duplicateButton();
						crSearchCall.clickDuplicateCallIDConfYes();
						member.currentCallClose();
						home.allErrorAlertsNoButton();
						home.messageDialogBoxClose();
						Thread.sleep(4000);


						crCommonError.crCommonErrorHandler();
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertTrue(!callIdOnMemberTab.contains(callid), "Call id should not present");

						Pattern p = Pattern.compile("([0-9])");
						Matcher m = p.matcher(callIdOnMemberTab);

						if(m.find()){
							System.out.println("CallID is "+m.find());
							assertTrue(false, "Call id"+m.find()+" should not present");
						}
		                crLocationsLib.clickOnLocationTab();
						click(CRLocationsPage.linkManualEntryOnLocationTab,"Enter Address Manually");
						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crCommonError.crCommonErrorHandler();
						crVehicleTriageLib.clickOnVehicleTriageTab();
						crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crCommonError.crCommonErrorHandler();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						crCommonError.crCommonErrorHandler();
						Thread.sleep(3000);
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");
						Thread.sleep(3000);
					crCommonError.crCommonErrorHandler();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
						Thread.sleep(4000);
		                Date callDate=service.getCallDateAfterCallSaveInDateForma();
		                System.out.println("callDate is ++++++++++++++++++++ " +callDate);
		                String CDate=service.getCurrentDate();
		
		                String splitStr1[] = CDate.split("\n");
		                String currentdateValue1= splitStr1[0];
		
		                SimpleDateFormat dateFormat11 = new SimpleDateFormat("MM/dd/yyyy");
		                Date CyrrentDte = dateFormat11.parse(currentdateValue1);
		
		                System.out.println("currentDate is ++++++++++++++++++++ " +CyrrentDte);
		                if(CurrentCallIdDate.before(CyrrentDte)){
		                    assertTrue(callDate.equals(CyrrentDte),"Call date should be equal to current date i.e. " + CyrrentDte);
		                }
		                else if(CurrentCallIdDate.equals(CyrrentDte)) {
		                    assertTrue(callDate.equals(CyrrentDte), "Call date is equal to todays date");
		                }
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(newCallId !=null, "New Call Id "+CallIdNew+ "is Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void DuplicateLiveCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DuplicateLiveCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DuplicateLiveCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a Live Call "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
						CRVehicleTriageLib crCommonError = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                Thread.sleep(2000);
		                crSearchCall.enterCallsTypeInSearchCalls(data.get("Calls"));
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		               // crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                callid = crSearchCall.getCallIdOnSearCallWindow();

		                int oldCallId = Integer.parseInt(callid);
					    crSearchCall.clickCallIDwithoutRAPSearCallWindow();

							crCommonError.crCommonErrorHandler();
						crCommonError.crCommonErrorHandler();
		                home.duplicateButton();
		                crSearchCall.clickDuplicateCallIDConfYes();
						 member.currentCallClose();
		                home.allErrorAlertsNoButton();
		                home.messageDialogBoxClose();
		                Thread.sleep(4000);
						crCommonError.crCommonErrorHandler();
		                Thread.sleep(4000);
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		                assertTrue(!callIdOnMemberTab.contains(callid), "Call id should not present");

						Pattern p = Pattern.compile("([0-9])");
						Matcher m = p.matcher(callIdOnMemberTab);

						if(m.find()){
							System.out.println("CallID is "+m.find());
							assertTrue(false, "Call id"+m.find()+" should not present");
						}



		                crLocationsLib.clickOnLocationTab();
						click(CRLocationsPage.linkManualEntryOnLocationTab,"Enter Address Manually");

						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crCommonError.crCommonErrorHandler();
						crVehicleTriageLib.clickOnVehicleTriageTab();
						crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						Thread.sleep(2000);
					crCommonError.crCommonErrorHandler();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
					crCommonError.crCommonErrorHandler();
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");
						Thread.sleep(3000);

					crCommonError.crCommonErrorHandler();
		               // crVehicleTriageLib.clickOnVehicleTriageTab();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		
		                Thread.sleep(4000);
		                String newCallId = service.getCallId();
		                Thread.sleep(3000);
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(newCallId !=null, "New Call Id "+CallIdNew+ "is Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void duplicateAnArchivedRAPCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "duplicateAnArchivedRAPCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("duplicateAnArchivedRAPCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a Live Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
						CRVehicleTriageLib crCommonError = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
		                crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
		                //ran=generateRandomNumber();
		
		                 Num = (int) (Math.random() * 90000000) + 10000000;
		                // use this String wherever you want
		
		                RandomNum = Integer.toString(Num);
		
		               // ordNameValue = ScheduleOrdName + RandomNum;
		                System.out.println(RandomNum);
		                crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		                int oldCallId = Integer.parseInt(callid);
		                crSearchCall.clickDuplicateIconForRAPCallOnSearCallWindow();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                Thread.sleep(4000);
		                member.currentCallClose();

						crCommonError.crCommonErrorHandler();
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertTrue(!callIdOnMemberTab.contains(callid), "Call id should not present");

						Pattern p = Pattern.compile("([0-9])");
						Matcher m = p.matcher(callIdOnMemberTab);

						if(m.find()){
							System.out.println("CallID is "+m.find());
							assertTrue(false, "Call id"+m.find()+" should not present");
						}
		
		                member.enterRAPonMemberTab(RandomNum);
		                member.enterSecondPhoneNumber(data.get("SecondPhoneNumber"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crLocationsLib.clickOnLocationTab();
						click(CRLocationsPage.linkManualEntryOnLocationTab,"Enter Address Manually");

						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						crVehicleTriageLib.clickOnVehicleTriageTab();
						crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						crCommonError.crCommonErrorHandler();
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");
						crCommonError.crCommonErrorHandler();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		                Thread.sleep(4000);
		
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(newCallId !=null, "New Call Id "+CallIdNew+ "is Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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


    // Commenting out the below duplicateFacilityCall as its Out of scope now as per jira comment in CQA-547

    /*@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void duplicateFacilityCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "duplicateFacilityCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("duplicateFacilityCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a  Facility Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		               // crSearchCall.enterFacilityOnSearchCallsWindow(data.get("Facility"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                // crSearchCall.searchAndSelectRAPOnSearCallWindow(data);

						callid = crSearchCall.getCallIdOnSearCallWindow();
						int oldCallId = Integer.parseInt(callid);

						crSearchCall.clickCallIDwithoutRAPSearCallWindow();
					    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
						String FacilityBefore=crHomeLib.getfacilityTextFromTopLable();

						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

						home.duplicateButton();
					    String FacilityAfterDuplicateClicked=crSearchCall.clickDuplicateCallIDConfYesForFacilityDuplicate();
					 	//String FacilityAfterDuplicateClicked=crHomeLib.getfacilityTextFromTopLable();

//					Commenting out the below validation as per the comments mentioned in jira that facility text is being removed for just fractions of seconds
					//assertTrue(FacilityAfterDuplicateClicked.equalsIgnoreCase("N/A"), "Facility got Cleared as N/A");
						member.currentCallClose();
						home.allErrorAlertsNoButton();
						home.messageDialogBoxClose();
						String FacilityAfter=crHomeLib.getfacilityTextFromTopLable();
						assertTrue(FacilityAfter!=null, "Facility got respot to "+ FacilityAfter);

		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
    			fnCloseTest();
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }*/
}