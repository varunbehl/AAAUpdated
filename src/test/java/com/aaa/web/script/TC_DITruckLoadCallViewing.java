package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by e002222 on 14-02-2018.
 */
public class TC_DITruckLoadCallViewing extends DILoginLib {

    String[] facilityId=new String[3];
    String[] newCallId=new String[3];
    String[] callDateCreated=new String[3];
    String[] callDateStr=new String[3];


    public static String autoFacility;
    public static String Popoutvalue;



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

    public void verifyTruckLoadCallViewing(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTruckLoadCallViewing", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyTruckLoadCallViewing", TestData, "D3Dispatch", intCounter);

					this.reporter.initTestCaseDescription("1834: DI Truck Load Call Viewing" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");


					CRHomeLib home = new CRHomeLib();
					LoginRoleLib role = new LoginRoleLib();
					DIHomeLib diHome = new DIHomeLib();
					CRHomeLib crHomeLib = new CRHomeLib();
					DITruckLoadDeafultViewLib DITruckload = new DITruckLoadDeafultViewLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CRTowDestinationLib tow = new CRTowDestinationLib();
					CR_DI crDI = new CR_DI();
					CommonLib commonLib = new CommonLib();

					DIMCDLib diMCD = new DIMCDLib();
					String winHandleBefore = driver.getWindowHandle();
			                /*navigateToApplication("DI");
			                waitcloseAllBusyIcons();
			                login(data.get("DILoginName"), data.get("DIPassword"));
			                role.clickOnProceedBtnInDispatchRoleLogin();
			                waitcloseAllBusyIcons();
			                Thread.sleep(10000);
			                diHome.clickOnCloseButtonOnQueueWindow();
			
			                String winHandleBefore = driver.getWindowHandle();
			                diHome.clickOnTruckLoad();
			                 Popoutvalue = data.get("Screen");
			                switch (Popoutvalue) {
			                    case "Popout":
			
			                        click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
			                        Thread.sleep(5000);
			                        for (String handle : driver.getWindowHandles()) {
			
			                            driver.switchTo().window(handle);
			                        }
			                        break;
			                    default:
			                        break;
			
			                }
			
			                Thread.sleep(5000);
			
			                diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("facilityNumber"));
			
			                String allCallsCounter= DITruckload.verifyandGetAllCallsCounter();
			                int allCallsCounterBefore=Integer.parseInt(allCallsCounter);
			
			                String unassignedCallsCounter= DITruckload.verifyandGetUnassignedCallsCounter();
			                int unassignedCallsCounterBefore=Integer.parseInt(unassignedCallsCounter);
			
			
			
			                diHome.logOut();
			                Thread.sleep(5000);
			                acceptAlert();
			                acceptAlert();
			                acceptAlert();*/


					navigateToApplication("CR");
					login(data.get("CRLoginName"), data.get("Password"));
					member.clickOnPartialCallCloseButton();
					waitcloseAllBusyIcons();
					home.messageDialogBoxClose();
			
			
			/*
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
			                }*/


					int i = 0;
					while (i < 3) {
						crHomeLib.memberSearchTextBox(data.get("Membersearch"));
						member.memberNumClick();

						locations.clickOnLocationTab();
						locations.enterBreakDownAddressOmniBarSearch(data.get("Address"));

						Thread.sleep(5000);
						crVehicleTriageLib.clickOnVehicleTriageTab();
						String VehicleDet[] = data.get("Vehiclemodel").split("#");
						crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
						crVehicleTriageLib.clickOnTheVehicleSearchIcon();
						crVehicleTriageLib.clickOnTheVehicleSearch();
						crVehicleTriageLib.vehicleColor(VehicleDet[1]);
						String combineKeys3 = Keys.chord(Keys.TAB);
						sendKeys(combineKeys3, "Tab");
						crVehicleTriageLib.clickOnFuel();
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
						crVehicleTriageLib.clickOnOutOfGas();

						Thread.sleep(3000);
						crVehicleTriageLib.scriptErrorHandle();
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
						services.clickOnServiceTab();
						autoFacility = services.validateFacilityAutospotID();
						services.validateFacilityAutospotAddress();
						crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
						services.enterManualFacilityNumber(data.get("facilityNumber"));
						Thread.sleep(4000);
						services.clickOnSpotInServicePage();
						Thread.sleep(5000);
						crVehicleTriageLib.scriptErrorHandle();


						home.saveButton();
						crHomeLib.allErrorAlerts();
						Thread.sleep(3000);
						facilityId[i] = services.getSpotFacilityId();
						newCallId[i] = services.getCallId();

						callDateCreated[i] = services.getCallDate();
						Thread.sleep(2000);
						callDateStr[i] = callDateCreated[i].replaceAll("-", "");
						services.closeCall();

						Thread.sleep(2000);
						System.out.println("Call creation " + i);
						i++;

					}


					diHome.logOut();
					Thread.sleep(5000);
					acceptAlert();
					acceptAlert();
					acceptAlert();


					navigateToApplication("DI");
					waitcloseAllBusyIcons();
					login(data.get("DILoginName"), data.get("DIPassword"));
					role.clickOnProceedBtnInDispatchRoleLogin();
					waitcloseAllBusyIcons();
					Thread.sleep(10000);
					diHome.clickOnCloseButtonOnQueueWindow();
					diHome.clickOnTruckLoad();
					Popoutvalue = data.get("Screen");
					switch (Popoutvalue) {
						case "Popout":

							click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
							Thread.sleep(5000);
							for (String handle : driver.getWindowHandles()) {

								driver.switchTo().window(handle);
							}
							break;
						default:
							break;

					}

					Thread.sleep(5000);
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("facilityNumber"));
					Thread.sleep(2000);

					String allCallsCounterafterCallCreation = DITruckload.verifyandGetAllCallsCounter();
					int allCallsCounterAfter = Integer.parseInt(allCallsCounterafterCallCreation);
					Thread.sleep(2000);
					String unassignedCallsCounterafterCallCreation = DITruckload.verifyandGetUnassignedCallsCounter();
					int unassignedCallsCounterAfter = Integer.parseInt(unassignedCallsCounterafterCallCreation);

					Thread.sleep(2000);

					Boolean veriFyCallInTruckPage = DITruckload.verifyCallIdOnTruckDefaultViewPage(newCallId[0], callDateStr[0]);
					assertTrue(veriFyCallInTruckPage, "Call created" + newCallId[0] + "is in Truck default view page");

					Thread.sleep(2000);

					Popoutvalue = data.get("Screen");
					switch (Popoutvalue) {
						case "Popout":

							driver.manage().window().maximize();
							Thread.sleep(5000);
							for (String handle : driver.getWindowHandles()) {

								driver.switchTo().window(handle);
							}
							break;
						default:
							break;

					}

					Thread.sleep(7000);


					DITruckload.rightClickCallIdOnTruckDefaultViewPage(newCallId[0], callDateStr[0]);
					DITruckload.mouseHoverOnCallStatusDefaultTruckLoad();
					DITruckload.mouseHoverOnAssignStatusDefaultTruckLoad();
					DITruckload.clickOnAssignStatusTruckDefaultTruckLoad();
					DITruckload.clickLayersOnRightPane();

					String allCallsCounterafterStatusChange = DITruckload.verifyandGetAllCallsCounter();
					int allCallsCounterAfterStatusChange = Integer.parseInt(allCallsCounterafterStatusChange);
					Thread.sleep(3000);
					String unassignedCallsCounterafteStatusChange = DITruckload.verifyandGetUnassignedCallsCounter();
					int unassignedCallsCounterAfterStatusChaneg = Integer.parseInt(unassignedCallsCounterafteStatusChange);
					Thread.sleep(3000);
					int finalUnassignedCount = unassignedCallsCounterAfter - 1;
					//int finalUnassignedCount=unassignedCallsCounterAfterStatusChaneg-1;
					Thread.sleep(3000);

					assertTrue(unassignedCallsCounterAfter - 1 == finalUnassignedCount, "unassigned calls count reduced by 1");
					assertTrue(allCallsCounterAfter == allCallsCounterAfterStatusChange, "All call counts should be same");
					Thread.sleep(3000);
					String truckID = DITruckload.getTruckIDOfCallIDDefaultTruckLoad(newCallId[0], callDateStr[0]);
					Thread.sleep(2000);
					DITruckload.clickTruckIDOfCallID(truckID);
					//DITruckload.verifyAllTruckIDsOfCalls(truckID);
					Thread.sleep(3000);

					Boolean veriFyCallInTruckPageAfterFilter = DITruckload.verifyCallIdOnTruckDefaultViewPage(newCallId[0], callDateStr[0]);
					assertTrue(veriFyCallInTruckPageAfterFilter, "Call created" + newCallId[0] + "Verify Call ID is on Truck default view page");


					Thread.sleep(3000);

					DITruckload.doubleClickOnCallIdOnTruckWindow(newCallId[0], callDateStr[0]);


					Thread.sleep(2000);

					Popoutvalue = data.get("Screen");
					switch (Popoutvalue) {
						case "Popout":

							driver.switchTo().window(winHandleBefore);
							Thread.sleep(5000);
                       /* for (String handle : driver.getWindowHandles()) {

                            driver.switchTo().window(handle);
                        }*/
							break;
						default:
							break;

					}

					Thread.sleep(5000);


					diMCD.verifyFacilityAndEnterReasonAndReSpot(data.get("SPEnterReason"), data.get("ResoptFacilityIDNew"));

					if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
						diHome.clickOnTruckLoad();
					} else {
						diHome.clickOnTruckLoadTab();
						DITruckload.clickSPPdefaultTruckView();
					}

					Thread.sleep(3000);
              /*  Popoutvalue = data.get("Screen");
                switch (Popoutvalue) {
                    case "Popout":

                        click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                        Thread.sleep(5000);
                        for (String handle : driver.getWindowHandles()) {

                            driver.switchTo().window(handle);
                        }
                        break;
                    default:
                        break;

                }*/

					Popoutvalue = data.get("Screen");
					switch (Popoutvalue) {
						case "Popout":


							Thread.sleep(5000);
							for (String handle : driver.getWindowHandles()) {

								driver.switchTo().window(handle);
							}
							break;
						default:
							break;

					}

					Thread.sleep(5000);

					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("facilityNumber"));

					String allCallsCounterAfterfacilityChange = DITruckload.verifyandGetAllCallsCounter();
					int allCallsCounterAfterFacilityChange = Integer.parseInt(allCallsCounterAfterfacilityChange);

					String unassignedCallsCounterAfterFacilityChange = DITruckload.verifyandGetUnassignedCallsCounter();
					int unassignedCallsCounterAfterfacilityChange = Integer.parseInt(unassignedCallsCounterAfterFacilityChange);


					assertTrue(finalUnassignedCount == unassignedCallsCounterAfterfacilityChange, "unassigned calls counts should be reduced by 1");
					assertTrue(allCallsCounterAfterStatusChange - 1 == allCallsCounterAfterFacilityChange, "All call counts should be reduced by 1");
					DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
					diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("ResoptFacilityIDNew"));
					Boolean veriFyCallInNewFacilty = DITruckload.verifyCallIdOnTruckDefaultViewPage(newCallId[0], callDateStr[0]);
					assertTrue(veriFyCallInNewFacilty, "Verify Call ID " + newCallId[0] + "is in new facility of truck load");

					Popoutvalue = data.get("Screen");
					switch (Popoutvalue) {
						case "Popout":
							// click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView,"Pop Out clicked");
							Thread.sleep(5000);
							driver.close();

							break;
						default:
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
    			ReportStatus.fnUpdateResultStatus("DI","1834",ReportStatus.strMethodName,intCounter,browser);
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






