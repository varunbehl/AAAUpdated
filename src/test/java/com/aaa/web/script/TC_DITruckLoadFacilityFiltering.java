package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DITruckLoadFacilityFiltering extends DILoginLib {


    String[] facilityId=new String[3];
    String[] newCallId=new String[3];
    String[] callDateCreated=new String[3];
    String[] callDateStr=new String[3];
    String queueFirstValue;
    String selectedFirstValue;
    String spotQueueFirstValue;
    String spotSelectedQueueFirstValue;
    int records;
    int recordsVerify;
    String queueFirstValueNotAdded;

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

    public void verifyTruckLoadFacilityFiltering(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "verifyTruckLoadFacilityFiltering", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("verifyTruckLoadFacilityFiltering", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1824: TC-DI TruckLoad Facility Filtering" + " From Iteration " + StartRow + " to " + EndRow);
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


                   navigateToApplication("CR");
                    login(data.get("LoginName"), data.get("Password"));
                    member.clickOnPartialCallCloseButton();
                    waitcloseAllBusyIcons();
                    home.messageDialogBoxClose();

                    // Below code is to create 2 calls with 5140 and 5145 facilities respectively.
                    int j = 0;
                    while (j < 2) {
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
                        services.validateFacilityAutospotAddress();
                        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

                        if (j == 0) {
                            services.enterManualSpotDetails(data.get("FacilityOption1"));
                        } else if (j == 1) {
                            services.enterManualSpotDetails(data.get("FacilityOption2"));
                        }


                        crVehicleTriageLib.scriptErrorHandle();


                        home.saveButton();
                        crHomeLib.allErrorAlerts();
                        Thread.sleep(3000);
                        facilityId[j] = services.getSpotFacilityId();
                        newCallId[j] = services.getCallId();

                        callDateCreated[j] = services.getCallDate();
                        Thread.sleep(2000);
                        callDateStr[j] = callDateCreated[i].replaceAll("-", "");
                        services.closeCall();

                        Thread.sleep(2000);
                        System.out.println("Call creation " + j);
                        j++;

                    }


                    diHome.logOut();
                    Thread.sleep(5000);
                    acceptAlert();
                    acceptAlert();
                    acceptAlert();


                    navigateToApplication("DI");
                    waitcloseAllBusyIcons();
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));

                    commonLib.clickOnProceedBtnForDispatchSPPLogin();



                    if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                        diHome.clickOnTruckLoad();
                    } else {
                        diHome.clickOnTruckLoadTab();
                        DITruckload.clickSPPdefaultTruckView();
                    }

                    Thread.sleep(3000);
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

                    //below code is to verify the default facility on left is displayed on right
                    String facilityDefaultHeadingTxt=DITruckload.getHeadingLabelTxtOfSelectedFaciltyData();
                    assertTrue(facilityDefaultHeadingTxt.contains(data.get("FacilityOption1")), "Verify default facility selected is dispalyed");

                    //Below code is to verify the facility selected is displayed on right side
                    diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("FacilityOption1"));
                    String facility1HeadingTxt=DITruckload.getHeadingLabelTxtOfSelectedFaciltyData();
                    assertTrue(facility1HeadingTxt.contains(data.get("FacilityOption1")), "Verify facility " +data.get("FacilityOption1")+" selected is dispalyed");
                    Thread.sleep(3000);





                    //Below code is to verify the call with 5140 is displayed which was created

                    Boolean veriFyFirstFacilityCallInTruckPage = DITruckload.verifyCallIdOnTruckDefaultViewPage(newCallId[0], callDateStr[0]);
                   assertTrue(veriFyFirstFacilityCallInTruckPage, "Verify Call created" + newCallId[0] + "with facility "+data.get("FacilityOption1")+"is in Truck default view page");


                    Thread.sleep(2000);

                    //DITruckload.verifyandGetAllCallsCounter();
                    DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
                    Thread.sleep(3000);

                    //Below code is to verify the call with 5145 is displayed which was created
                    DITruckload.Selectfacility(data.get("FacilityOption2"));
                    Thread.sleep(3000);
                    Boolean veriFySecondfacilityCallInTruckPage = DITruckload.verifyCallIdOnTruckDefaultViewPage(newCallId[1], callDateStr[1]);
                    assertTrue(veriFySecondfacilityCallInTruckPage, "Verify Call created" + newCallId[1] + "with facility "+data.get("FacilityOption2")+"is in Truck default view page");
                    String facility2HeadingTxt=DITruckload.getHeadingLabelTxtOfSelectedFaciltyData();
                    assertTrue(facility2HeadingTxt.contains(data.get("FacilityOption2")), "Verify facility "+data.get("FacilityOption2")+" selected is dispalyed");

                    DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
                    Thread.sleep(3000);
                    //Below code is to select 5140 facility through dropdown and check it displayed to right
                    diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("FacilityOption1"));
                    assertTrue(facility1HeadingTxt.contains(data.get("FacilityOption1")), "Verify facility selected through dropdown "+data.get("FacilityOption1")+"is dispalyed");
                    Thread.sleep(3000);
                    Boolean veriFyFirstfacilityCallInTruckPage = DITruckload.verifyCallIdOnTruckDefaultViewPage(newCallId[0], callDateStr[0]);
                    assertTrue(veriFyFirstfacilityCallInTruckPage, "Verify Call created" + newCallId[0] + "with facility "+data.get("FacilityOption1")+"is in Truck default view page");
                    Thread.sleep(3000);
                    Boolean veriFyNoSecondfacilityCallInTruckPage = DITruckload.verifyNoCallIdDisplayedOnTruckDefaultViewPage(newCallId[1], callDateStr[1]);
                    assertTrue(!veriFyNoSecondfacilityCallInTruckPage, "Verify Call created" + newCallId[1] + "with facility "+data.get("FacilityOption2")+"is not displayed in Truck default view page");

                    String facilitytext2= DITruckload.verifyAndgetTextSelectedFaciltyData(data.get("FacilityOption1"));
                    assertTrue(facilitytext2.contains(data.get("FacilityOption1")), "Verify facility selected is dispalyed");

                    int allfacilitiesBefore= DITruckload.verifyAllfacilityDisplayed();

                    //Below code is to remove the selected facilities

                    DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
                    Thread.sleep(3000);
                    int allfacilitiesAfter= DITruckload.verifyAllfacilityDisplayed();
                    assertTrue(allfacilitiesAfter>allfacilitiesBefore, "Verify all facilities are displayed");

                    Popoutvalue = data.get("Screen");
                    switch (Popoutvalue) {
                        case "Popout":
                            driver.close();
                            driver.switchTo().window(winHandleBefore);
                            //click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                            Thread.sleep(5000);
                            /*for (String handle : driver.getWindowHandles()) {

                                driver.switchTo().window(handle);
                            }*/
                            break;
                        default:
                            break;

                    }

                    //Below code is to open the queues and remove the D3A1 for 5140 facility

                    diHome.selectChangeSetQueueMenuItem();
                    boolean queue= diHome.getQueueSelectionLable();
                    if(queue) {
                        assertTrue(queue, "Queue selection popup appeared");



                        //Searching the for the D3A1 and removing it
                        diHome.enterValueInQueueFilterSelected(data.get("QueueValue1"));
                        diHome.getQueueFieldFirstItemInSelected();
                        diHome.clickOnRemoveButtonOnQueueWindow();
                        diHome.clickOnContinueQueuesInDispatch();
                        Thread.sleep(3000);

                        if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                            diHome.clickOnTruckLoad();
                        } else {
                            diHome.clickOnTruckLoadTab();
                            DITruckload.clickSPPdefaultTruckView();
                        }

                        Thread.sleep(3000);
                        Popoutvalue = data.get("Screen");
                        switch (Popoutvalue) {
                            case "Popout":

                               // click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                                Thread.sleep(5000);
                                for (String handle : driver.getWindowHandles()) {

                                    driver.switchTo().window(handle);
                                }
                                break;
                            default:
                                break;

                        }


                        //Below code is to verify the removed facility from truck load page
                        Boolean removedQue=DITruckload.verifyremovedfacilityOnTruckLoadPage(data.get("FacilityOption1"));
                        assertTrue(!removedQue, "Removed Queue "+data.get("FacilityOption1")+" should not be visible");


                        Popoutvalue = data.get("Screen");
                        switch (Popoutvalue) {
                            case "Popout":
                                driver.close();
                                driver.switchTo().window(winHandleBefore);
                                //click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                                Thread.sleep(5000);
                            /*for (String handle : driver.getWindowHandles()) {

                                driver.switchTo().window(handle);
                            }*/
                                break;
                            default:
                                break;

                        }


                        //Below code is to remove all the queues from queue page
                        diHome.selectChangeSetQueueMenuItem();
                        diHome.clickOnDispatchTab();
                        diHome.clickOnRemoveAll();
                        diHome.clickOnContinueQueuesInDispatch();
                        Thread.sleep(3000);
                        if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                            diHome.clickOnTruckLoad();
                        } else {
                            diHome.clickOnTruckLoadTab();
                            DITruckload.clickSPPdefaultTruckView();
                        }

                        Thread.sleep(3000);
                        Popoutvalue = data.get("Screen");
                        switch (Popoutvalue) {
                            case "Popout":

                                //click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                                Thread.sleep(5000);
                                for (String handle : driver.getWindowHandles()) {

                                    driver.switchTo().window(handle);
                                }
                                break;
                            default:
                                break;

                        }

                        DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();


                        //Below code is to verify all facilities are removed
                        int allfacilitiesRemoved= DITruckload.verifyAllfacilityDisplayed();
                        assertTrue(allfacilitiesRemoved==0, "Verify all facilities are removed");

                        //Below code is to verify the facilities are loaded even no queues are there
                        diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("FacilityOption1"));
                        diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("FacilityOption2"));
                        String facilityHeadinggetTxt=DITruckload.getHeadingLabelTxtOfSelectedFaciltyData();
                        assertTrue(facilityHeadinggetTxt.contains(data.get("FacilityOption1")), "Verify facility selected is dispalyed");

                        //Below code is to remove the selected facilities
                        DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
                        Popoutvalue = data.get("Screen");
                        switch (Popoutvalue) {
                            case "Popout":
                                driver.close();
                                driver.switchTo().window(winHandleBefore);
                                //click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                                Thread.sleep(5000);
                            /*for (String handle : driver.getWindowHandles()) {

                                driver.switchTo().window(handle);
                            }*/
                                break;
                            default:
                                break;

                        }


                        diHome.selectChangeSetQueueMenuItem();
                        diHome.clickOnDispatchTab();


                        //Below code is to add the quesues D3A1 D3A2 from queues page
                        diHome.enterValueInQueueFilterDispatch(data.get("QueueValue1"));
                        diHome.getDispatchQueueFirstFieldValue();
                        diHome.clickOnAddButtonOnQueueWindow();
                        diHome.enterValueInQueueFilterDispatch(data.get("QueueValue2"));
                        diHome.getDispatchQueueFirstFieldValue();
                        diHome.clickOnAddButtonOnQueueWindow();
                        diHome.clickOnContinueQueuesInDispatch();
                        Thread.sleep(3000);

                        if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                            diHome.clickOnTruckLoad();
                        } else {
                            diHome.clickOnTruckLoadTab();
                            DITruckload.clickSPPdefaultTruckView();
                        }

                        Thread.sleep(3000);
                        Popoutvalue = data.get("Screen");
                        switch (Popoutvalue) {
                            case "Popout":

                               // click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                                Thread.sleep(5000);
                                for (String handle : driver.getWindowHandles()) {

                                    driver.switchTo().window(handle);
                                }
                                break;
                            default:
                                break;

                        }
                        DITruckload.clickAllCrossIconOfCallIdofFacilityWindow();
                        Thread.sleep(5000);

                        //Below is the code to add the D3A1 queue
                        diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("QueueValue1"));


                        // Below is the code to verify the selected queue is displayed on right
                        String queueFacilitytext= DITruckload.getHeadingLabelTxtOfSelectedFaciltyData();
                        assertTrue(queueFacilitytext.contains(data.get("FacilityOption1")), "Verify queue selected facility  is dispalyed");
                        Thread.sleep(3000);
                        Boolean veriFyNoSecondQueueCallInTruckPage = DITruckload.verifyNoCallIdDisplayedOnTruckDefaultViewPage(newCallId[1], callDateStr[1]);
                        assertTrue(!veriFyNoSecondQueueCallInTruckPage, "Verify Call created" + newCallId[1] + "with facility "+data.get("FacilityOption2")+"is in Truck default view page");
                        Popoutvalue = data.get("Screen");
                        switch (Popoutvalue) {
                            case "Popout":
                                driver.close();
                                driver.switchTo().window(winHandleBefore);
                                //click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Pop Out clicked");
                                Thread.sleep(5000);
                            /*for (String handle : driver.getWindowHandles()) {

                                driver.switchTo().window(handle);
                            }*/
                                break;
                            default:
                                break;

                        }

                        //click on logout link to logout from the application
                        diHome.logOut();
                        Thread.sleep(5000);
                        acceptAlert();
                        acceptAlert();
                    }else{
                        reporter.failureReport("DI Queue Selection window","Window not appeared");
                        diHome.logOut();
                    }
                    System.out.println("Test completed");
                }
                    catch(Exception e)
                    {
                        ReportStatus.blnStatus=false;
                        reporter.failureReport("Execption Occured","Execption Occured",driver);
                        reporter.warningReport("Error Description"," "+e.toString());
                    }
                    ReportControl.fnEnableJoin();
                    ReportStatus.fnUpdateResultStatus("DI","1824",ReportStatus.strMethodName,intCounter,browser);
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

