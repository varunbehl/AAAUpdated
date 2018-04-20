package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by e002222 on 13-02-2018.
 */
public class TC_DITruckLoadTruckStatusUpdates extends DILoginLib {




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

    public void verifyTruckStatusUpdateOnTruckLoad(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTruckStatusUpdateOnTruckLoad", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTruckStatusUpdateOnTruckLoad", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1809: TS-DI TruckLoad Truck Status Updates"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                DITruckLoadDeafultViewLib DITruckload= new DITruckLoadDeafultViewLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CR_DI crDI = new CR_DI();
		                CommonLib commonLib = new CommonLib();
		                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
		                DIMCDLib diMCD = new DIMCDLib();
		                navigateToApplication("DI");
		                waitcloseAllBusyIcons();
		                login(data.get("DILoginName"),data.get("DIPassword"));

				// Below lines of code is for the user type login

					commonLib.clickOnProceedBtnForDispatchSPPLogin();
					if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
						diHome.clickOnTruckLoad();
					} else {
						diHome.clickOnTruckLoadTab();
						DITruckload.clickSPPdefaultTruckView();
					}

					Thread.sleep(3000);
		                String winHandleBefore = driver.getWindowHandle();

					// Below lines of code is for the screen pop in pop out mode
		                String Popoutvalue=data.get("Screen");
		                switch(Popoutvalue){
		                    case "Popout":
		
		                        click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView,"Pop Out clicked");
		                        Thread.sleep(5000);
		                        for (String handle : driver.getWindowHandles()) {
		
		                            driver.switchTo().window(handle);}
		                        break;
		                    default :
		                        break;
		
		                }
		
		                Thread.sleep(5000);

						// Below lines of code is to enter teh facility
		
		                diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("Facility"));

		                // Below lines of code is to verify teh Active truck records
		
		                boolean verifyActiveTruck=DITruckload.verifyActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyActiveTruck, "verify active truck record");

						// Below lines of code is to verify the Active truck records
		                boolean verifyInActiveTruck=DITruckload.verifyInActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyInActiveTruck, "verify Inactive truck record");
		
		                DITruckload.clickActiveBtnOnDefaultTruckLoad();
						// Below lines of code is to verify all Active truck records.
		                boolean verifyAllActiveRecords= DITruckload.verifyAllActiveTrucksOnDefaultTruckLoad();
		                assertTrue(verifyAllActiveRecords, "Verify all Active truck records");

						// Below lines of code is to verify No  Active truck records are there
						boolean verifyNoInactiveTruck=DITruckload.verifyNoInActiveTruckOnDefaultTruckLoad();
						assertTrue(!verifyNoInactiveTruck, "verify No Inactive truck is there");

						// Below lines of code is to Toggle off Active button
		                DITruckload.clickActiveBtnOnDefaultTruckLoad();


						// Below lines of code is to verify the Active truck records again
		                boolean verifyActiveTruck1=DITruckload.verifyActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyActiveTruck1, "verify active truck record again");


						// Below lines of code is to verify the InActive truck records again
		                boolean verifyInActiveTruck1=DITruckload.verifyInActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyInActiveTruck1, "verify Inactive truck record again");

						// Below lines of code is to set truck to inactive
		                DITruckload.rightClickActiveSpecificTruckOnDefaultTruckLoad(data.get("ActiveTruckID"));
		                DITruckload.clickSetTruckToInactive();

						// Below lines of code is to verify the Status change to inactive
		                boolean verifyActiveToInactive=DITruckload.verifyIconChangeToInactive(data.get("ActiveTruckID"));
		                assertTrue(verifyActiveToInactive, "Status change to inactive");

						// Below lines of code is to set truck to Active
		                DITruckload.rightClickInActiveSpecificTruckOnDefaultTruckLoad(data.get("InActiveTruckID"));
		                DITruckload.clickSetTruckToActive();
						// Below lines of code is to verify the Status change to Active
		                boolean verifyInActiveToActive=DITruckload.verifyIconChangeToActive(data.get("ActiveTruckID"));
		                assertTrue(verifyInActiveToActive, "Status change to Active");




		
		
		
		                switch(Popoutvalue){
		                    case "Popout":
		                        // click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView,"Pop Out clicked");
		                        Thread.sleep(5000);
		                        driver.close();
		
		                        break;
		                    default :
		                        break;
		
		                }
		
		
		
		
		                driver.switchTo().window(winHandleBefore);
		
		
		
		                //driver.switchTo().defaultContent();
		
		
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description"," "+e.toString());
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1809",ReportStatus.strMethodName,intCounter,browser);
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
