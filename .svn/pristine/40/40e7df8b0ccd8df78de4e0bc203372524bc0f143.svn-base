package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDEditPacesetterCode extends ActionEngine {

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
	DIHomeLib diHome = new DIHomeLib();
	DILoginLib diLogin = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	DIMCDLib mcdlib = new DIMCDLib();
	DILoginLib diLoginLib = new DILoginLib();
	String callID;
	CRHomeLib crHomeLib = new CRHomeLib();
	DIMCDLib diMCD = new DIMCDLib();



/***********************************************************************
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
	************************************************************************/

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void diMcdEditPacesetterCode(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "diMcdEditPacesetterCode", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    			    fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("diMcdEditPacesetterCode", TestData, "D3Dispatch",intCounter);
                        org.openqa.selenium.WebDriver driver1 = null;
						this.reporter.initTestCaseDescription("1823: TC-DI MCD Edit Pacesetter Code"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					login.login(data.get("CRLoginName"), data.get("CRPassword"));
					member.clickOnPartialCallCloseButton();
					home.messageDialogBoxClose();
					member.currentCallClose();
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
					member.memberNumClick();
					member.currentCallClose();
					home.clickOnCallSummaryButton();
                    String defaultTroubleCode = home.getTroubleCodeValueFromCallDetailsPopup();
                    home.closeCallSummaryPopupWindow();
                    if(!defaultTroubleCode.contains("T1")) {
                        assertTrue(!defaultTroubleCode.contains("T1"), "DataBase not Return Member with Trouble code T1, Hence creating a new call with T1 trouble code");
                        member.clickPrimRadioBtnSecondRow();
                        location.clickOnLocationTab();
                        location.enterBreakDownAddressOmniBarSearch(data.get("Address"));
                        vehicle.clickOnVehicleTriageTab();
                        vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                        vehicle.enterPaceSetterCodeManually(data.get("pacesettercode"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();
                        vehicle.scriptErrorHandle();
                        service.clickOnServiceTab();
                        services.enterManualSpotDetails(data.get("facilityNumber"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        vehicle.scriptErrorHandle();
                        service.validateFacilityAutospot();
                        home.clickOnCallSummaryButton();
                        String TroubleCode = home.getTroubleCodeValueFromCallDetailsPopup();
                        home.closeCallSummaryPopupWindow();
                        assertTrue(TroubleCode.contains("T1"), "Trouble code T1");
                        home.saveButton();
                        callID = service.getCallId();
                        service.closeCall();
                        crHomeLib.logout();
                        acceptAlert();
                        Thread.sleep(2000);
                        acceptAlert();
                    }else
                    {
                        home.leavecall();
                        home.logout();
                        reporter.SuccessReport("T1 Trouble Code member Number","Database  return T1 trouble code member number is :: "+Member);;
                    }
					//Navigating to DI dispatch
					navigateToApplication("DI");
					diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                    common.clickOnProceedBtnForDispatchSPPLogin();
					diHome.clickOnSearchCallsLink();
                    String currentDate = common.getCurrentDate();
                    String startDate = common.getPreviousDate(currentDate);
                    diHome.enterStartDateOnSearchCallsWindow(startDate);
					if(callID!=null) {
                        diHome.enterCallIDInfo(callID);
                    }
					diHome.enterMemberNumberInfo(Member);
                    diHome.clickOnSearchInSearchCalls();
					crHomeLib.waitCloseAllBusyIconsResults();
					diHome.clickOnCallDateOrIDLink();
					crHomeLib.waitCloseAllBusyIconsResults();

					diMCD.clickOnServiceTabInMCDWindow();
					diMCD.getFieldsToDisplayInPacesetter();
					boolean verifyEditLinkAvailablity = diMCD.verifyEditLinkAvailablity();
					if (verifyEditLinkAvailablity) {
						diMCD.getEditAndClick();
						diMCD.getEditDropdownSelection();
						diMCD.getListOfPacesetterCode1Dropdown();
						diMCD.enterPacesetterCode1InServicesTabInMCD(data.get("paceSettercode1"));
						String combineKeys = Keys.chord(Keys.TAB);
						sendKeys(combineKeys, "Tab");
						diMCD.clickOnSaveButtonInServiceTabInMCDWindow();
						diMCD.highLightedValueInPacesetterCode1();
						String comments=diMCD.getlblLatestCommentsInMCDWindow();
						if(comments.contains(data.get("ExpectedCommentText"))){
							reporter.SuccessReport("Pacesettercode change","Expected "+data.get("ExpectedCommentText")+"  and Actual Commnets are same "+comments);
						}else{
							reporter.failureReport("Trouble code updation in comments section", comments + " ::Comments are not saved", driver);
						}
						diMCD.moveTheCallTroughTwStatus();
						acceptAlert();
						diMCD.clickOnMCDCloseWindow();
						diHome.sessionInNewTab();
						diHome.clickOnSearchCallsLink();
						diHome.enterStartDateOnSearchCallsWindow(startDate);
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						crHomeLib.waitCloseAllBusyIconsResults();
						diHome.clickOnCallDateOrIDLink();
						crHomeLib.waitCloseAllBusyIconsResults();

						diMCD.clickOnServiceTabInMCDWindow();
						diMCD.getEditAndClick();
						diMCD.getEditDropdownSelection();
						diMCD.enterPacesetterCode1InServicesTabInMCD(data.get("paceSettercode2"));
						sendKeys(combineKeys, "Tab");
						diMCD.clickOnCancelInService();
						String canceledComments = diMCD.getlblLatestCommentsInMCDWindow();
						assertTrue(!canceledComments.contains(data.get("paceSettercode2")), "Changed data is not reflected");
						diMCD.clickOnMCDCloseWindow();
						diHome.logOut();
						sendKeys(combineKeys, "Esc");
					}else{
						reporter.failureReport("Edit Link", "Edit link is not available to change the pacesetter code", driver);
						diMCD.clickOnMCDCloseWindow();
						diHome.logOut();
						String combineKeys = Keys.chord(Keys.ESCAPE);
						sendKeys(combineKeys, "Esc");
					}
    			}
    			catch(Exception e)
    			{
                    fnCloseTest();
    				ReportStatus.blnStatus=false;
    			}
    			finally{
                    reporter.SuccessReport("Completed","Test completed");

    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1823",ReportStatus.strMethodName,intCounter,browser);
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

