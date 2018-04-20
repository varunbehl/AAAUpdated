package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class TC_SPPAddingServiceTicket extends DILoginLib {

    Boolean memberNoCallsMsg=true;

    String ticketNumber;
    public int Num;

   // public static long ticketNumber;


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

    public void verifySPPAddingServiceTicket(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "verifySPPAddingServiceTicket", TestData, "D3Dispatch");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("verifySPPAddingServiceTicket", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("2055: SPP Adding Service Ticket" + " From Iteration " + StartRow + " to " + EndRow);
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
                    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    SPPServiceTicketLib serviceTicket = new SPPServiceTicketLib();


                    //Login to SPP Dispatch
                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnFacilityPTA();

                    serviceTicket.selectApplicationMenuItem();
                    serviceTicket.selectServiceTicketsUnderAPPAplicationMenuItem();


                    //Below code is to verify thet service ticket window is visible
                    serviceTicket.verifyServiceTicketWindowIsInView();
                    serviceTicket.clickServiceNewButton();

                   /* String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("Membersearch");
                    }*/

                    //Below code is to enter the membership number
                    /*serviceTicket.enterMembershipNumber(Member);
                    serviceTicket.clickVerifyMemberBtn();*/
                    //boolean verifyAlertMsg=serviceTicket.verifyMemberNoCallsMsg();

                    for (int i = 0; i < 10; i++) {
                        // while(serviceTicket.verifyMemberNoCallsMsg()){

                        if (memberNoCallsMsg) {


                             String Member = "";
                            if (data.get("Member").equals("db")) {
                                //fetch member details from db
                                //generating a random number everytime to fetch a new record everytime
                                int rownum = IntRandomNumberGenerator(50, 1000);
                                //member from db
                                Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                                System.out.println("member : " + Member);
                            } else {
                                Member = data.get("Membersearch");
                            }

                            //Below code is to enter the membership number
                            serviceTicket.enterMembershipNumber(Member);
                            serviceTicket.clickVerifyMemberBtn();
                            memberNoCallsMsg=serviceTicket.verifyMemberNoCallsMsg();
                            if(memberNoCallsMsg) {
                                serviceTicket.verifyMemberNoCallsMsgAndClickOkBtn();
                            }
                            //serviceTicket.verifyMemberNoCallsMsgAndClickOkBtn();
                        } else {

                            break;
                        }
                    }


                    if(!memberNoCallsMsg) {

                        //Below code is to verify member name auto populated
                        String memFirstName = serviceTicket.verifyAndGetMemberNamePopulate();

                        assertTrue(!memFirstName.isEmpty(), "Verify member name populated automatically");

                        //Below code is to verify club code is auto populated
                        String clbCode = serviceTicket.verifyAndGetClubCodePopulate();
                        assertTrue(!clbCode.isEmpty(), "Verify Club Code populated automatically");
                        //Below code is to enter ticket and validate field is populated

                        Num = (int) (Math.random() * 90000000) + 10000000;
                        // use this String wherever you want

                        ticketNumber = Integer.toString(Num);

                        // ordNameValue = ScheduleOrdName + RandomNum;
                        // System.out.println(ticketNumber);


                        serviceTicket.enterServiceTicketNumber(ticketNumber);
                        String getTicketValue = serviceTicket.getTicketValue();
                        assertTrue(getTicketValue.equalsIgnoreCase(ticketNumber), "Verify Ticket number field is populated");

                        //Below code is to enter service date and validate field is populated
                        String currentDate = getCurrentDate().replaceAll("/", "-");
                        //String finalDate=currentDate.replaceAll("/", "-");
                        String ServiceDate = serviceTicket.enterServiceCallDate(currentDate);
                        String getServiceDateValue = serviceTicket.getServiceCallDateValue();
                        assertTrue(getServiceDateValue.equalsIgnoreCase(currentDate), "Validate service date field is auto populated");

                        //Below code is to enter vehicle details and verify fields get populated
                        serviceTicket.clickVehicleTab();
                        String vehicleYear = serviceTicket.enterServiceVehicleYear(data.get("vehicleYear"));
                        String vehicleMake = serviceTicket.enterServiceVehicleMake(data.get("vehicleMake"));
                        String vehicleModel = serviceTicket.enterServiceVehicleModel(data.get("vehicleModel"));
                        String vehicleTag = serviceTicket.enterServiceVehicleTag(data.get("vehicleTag"));
                        String vehicleState = serviceTicket.enterServiceVehicleState(data.get("vehicleState"));


                        String getServicevehicleYearValue = serviceTicket.getServiceVehicleYear();
                        assertTrue(getServicevehicleYearValue.equalsIgnoreCase(data.get("vehicleYear")), "Validate vehicle Year field is auto populated");
                        String getServicevehicleMakeValue = serviceTicket.getServiceVehicleMake();
                        assertTrue(getServicevehicleMakeValue.equalsIgnoreCase(data.get("vehicleMake")), "Validate vehicle Make field is auto populated");
                        String getServicevehicleModelValue = serviceTicket.getServiceVehicleModel();
                        assertTrue(getServicevehicleModelValue.equalsIgnoreCase(data.get("vehicleModel")), "Validate vehicle Model field is auto populated");
                        String getServicevehicletagValue = serviceTicket.getServiceVehicleTag();
                        assertTrue(getServicevehicletagValue.equalsIgnoreCase(data.get("vehicleTag")), "Validate vehicle Tag field is auto populated");
                        String getServicevehicleStateValue = serviceTicket.getServiceVehicleState();
                        assertTrue(getServicevehicleStateValue.equalsIgnoreCase(data.get("vehicleState")), "Validate vehicle State field is auto populated");

                        //Below code is to click breakdown tab, search for location and validate the fields are populated

                        serviceTicket.clickBreakdownTab();
                        serviceTicket.enterTxtinServiceBrkDowLocSrch(data.get("BreakdownLocation"));
                        serviceTicket.verifyAddressVerifiedIndicator();


                        //Below code is to enter address in Tow tab and validate fields get populated
                        serviceTicket.clickTowTab();
                        //serviceTicket.enterServiceTowLocation(data.get("TowBreakdownLocation"));
                        serviceTicket.enterTxtinServiceTowLocSrch(data.get("TowBreakdownLocation"));

                        serviceTicket.verifyTowAddressVerifiedIndicator();
                        serviceTicket.enterLocationFieldInTowLocation(data.get("TowLocField"));
                        serviceTicket.clickTowTabVerifyItBtn();


                        //Below Code is to review and verify the mileage section

                        String mileageCost = serviceTicket.verifyNGetMileageTowCost();
                        String towMileage = serviceTicket.verifyNGetTowMileage();
                        String mileageEnroute = serviceTicket.verifyNGetMileageEnroute();
                        String enrouteCost = serviceTicket.verifyNGetMileageEnrouteCost();

                        assertTrue(!mileageCost.equalsIgnoreCase("N/A"), "Validate mileage Cost field is auto populated");
                        assertTrue(!towMileage.equalsIgnoreCase("N/A"), "Validate tow Mileage field is auto populated");
                        assertTrue(!mileageEnroute.equalsIgnoreCase("N/A"), "Validate mileage Enroute field is auto populated");
                        assertTrue(!enrouteCost.equalsIgnoreCase("N/A"), "Validate enroute Cost field is auto populated");

                        //Below code is to enter data in service tab and validate fields get populated

                        serviceTicket.clickServicesTab();
                        String timeRecieved = serviceTicket.enterServiceTimeReceived(data.get("TimeRecieved"));
                        String timeOnLocation = serviceTicket.enterServiceTimeOnLocaion(data.get("TimeOnLocation"));
                        String timeCleared = serviceTicket.enterServiceTimeCleared(data.get("TimeCleared"));
                        String timeFacility = serviceTicket.enterServiceFacility(data.get("TimeFacility"));
                        String PaceSetterCode1 = serviceTicket.enterServicePaceSetterCode1(data.get("PaceSetterCode1"));
                        String clearingCode = serviceTicket.enterServiceClearingCode(data.get("ClearingCode"));
                        String TLCreason = serviceTicket.enterServiceTLCReason(data.get("TLCReason"));
                        //String TroubleCode1=serviceTicket.enterServiceTroubleCode1(data.get("TroubleCode1"));

                        String getServiceTimeRecieved = serviceTicket.getServiceTimeRecieved();
                        assertTrue(getServiceTimeRecieved.equalsIgnoreCase(data.get("TimeRecieved")), "Validate time Recieved field is  populated");
                        String getServiceTimeOnLocation = serviceTicket.getServiceTimeOnLocaion();
                        assertTrue(getServiceTimeOnLocation.equalsIgnoreCase(data.get("TimeOnLocation")), "Validate time OnLocation field is  populated");
                        String getServiceTimeCleared = serviceTicket.getServiceTimeCleared();
                        assertTrue(getServiceTimeCleared.equalsIgnoreCase(data.get("TimeCleared")), "Validate time Cleared field is  populated");
                        String getServiceTimeFacility = serviceTicket.getServiceFacility();
                        assertTrue(getServiceTimeFacility.equalsIgnoreCase(data.get("TimeFacility")), "Validate time Facility field is  populated");
                        String getServicePaceSetterCode1 = serviceTicket.getServicePaceSetterCode1();
                        assertTrue(getServicePaceSetterCode1.equalsIgnoreCase(data.get("PaceSetterCode1")), "Validate PaceSetterCode 1 field is  populated");
                        String getServiceClearingCode = serviceTicket.getServiceClearingCode();
                        assertTrue(getServiceClearingCode.equalsIgnoreCase(data.get("ClearingCode")), "Validate clearing Code field is  populated");
                        String getServiceTLCreason = serviceTicket.getServiceTLCReason();
                        assertTrue(getServiceTLCreason.equalsIgnoreCase(data.get("TLCReason")), "Validate TLC Reason field is  populated");
                        String getServiceTroubleCode1 = serviceTicket.getServiceTroubleCode1();
                        assertTrue(!getServiceTroubleCode1.isEmpty(), "Validate TroubleCode 1 field is auto populated");


                        serviceTicket.clickAddComment();
                        serviceTicket.enterServiceComments(data.get("ServiceComment"));
                        serviceTicket.verifyAndClickAddCommentSaveBtn();
                        serviceTicket.clickServiceSaveBtn();
                        serviceTicket.verifyConfMsgAndClickYes();
                        if(serviceTicket.verifyDuplicateServiceScreen()){

                           serviceTicket.clickDiscardBtn();
                            serviceTicket.clickDiscardYesBtn();
                        }
                        serviceTicket.verifyConfMsgAfterClickingYesAndClickContinue();
                        serviceTicket.verifyServiceTicketWindowIsInView();

                        //Bellow code is to verify the service ticket header section

                        String serviceHeaderID = serviceTicket.verifyServiceTicketHeaderServiceID();
                        assertTrue(serviceHeaderID != null, "Verify Service ID is available in header");

                        String serviceCost = serviceTicket.verifyServiceTicketHeaderCost();
                        assertTrue(serviceCost != null, "Verify Service Cost is available in header");

                        String serviceCallId = serviceTicket.verifyServiceTicketHeaderCallId();
                        assertTrue(serviceCallId != null, "Verify Service Call ID is available in header");

                        String serviceFacility = serviceTicket.verifyServiceTicketHeaderFacility();
                        assertTrue(serviceFacility != null, "Verify Service Facility is available in header");

                        String serviceStatus = serviceTicket.verifyServiceTicketHeaderStatus();
                        assertTrue(serviceStatus.equalsIgnoreCase("Pending"), "Verify Service Status is available in header");

                        //Below code is the validate the mileage and service charge in payment
                        serviceTicket.clickPaymentBtn();
                        String totMileage = serviceTicket.VerifyServiceTotalMileage();
                        serviceTicket.VerifyServiceCharge();
                        serviceTicket.clickPaymentCloseBtn();
                        serviceTicket.verifyServiceTicketWindowIsInView();

                        String winHandleBefore = driver.getWindowHandle();
                        serviceTicket.clickPrint();


                        for (String handle : driver.getWindowHandles()) {

                            driver.switchTo().window(handle);
                        }


                        //Below code is the validate thedata in preview

                        String memNamePreview = serviceTicket.verifyAndGetMemberNameInPreview();
                        assertTrue(memNamePreview.contains(memFirstName), "Verify Member name in preview");
                        String breakdwnLoc = serviceTicket.verifyAndGetBreakdownLocInPreview();
                        assertTrue(data.get("BreakdownLocation").contains(breakdwnLoc), "Verify breakdown location in preview");

                        String towFullLoc = serviceTicket.verifyAndGetTowLocInPreview();

                        String[] towLoc = towFullLoc.split("\\,"); // String array, each element is text between dots

                        String towLocation = towLoc[0].replace("\n", " ");


                        assertTrue(data.get("TowBreakdownLocation").contains(towLocation), "Verify Tow location in preview");
                        String vehicleYearPreview = serviceTicket.verifyAndGetVehicleYearInPreview();
                        assertTrue(vehicleYearPreview.contains(vehicleYear), "Verify vehicle Year in preview");
                        String vehicleMakePreview = serviceTicket.verifyAndGetVehicleMakeInPreview();
                        assertTrue(vehicleMakePreview.contains(vehicleMake), "Verify vehicle Make in preview");

                        String vehicleModelPreview = serviceTicket.verifyAndGetVehicleModelInPreview();
                        assertTrue(vehicleModelPreview.contains(vehicleModel), "Verify vehicle Model in preview");

                        String totalMileagePreview = serviceTicket.verifyAndGetOnLocInPreview();
                        assertTrue(totalMileagePreview.contains(mileageEnroute), "Verify On Location in preview");
                        String totalCostPreview = serviceTicket.verifyAndGetTotalCostInPreview();
                        assertTrue(totalCostPreview.contains(serviceCost), "Verify Total cost in preview");
                        serviceTicket.verifyPreviewPrintBtn();
                        driver.close();
                        driver.switchTo().window(winHandleBefore);

                        //Below code is to close the service window
                        serviceTicket.clickServiceWindowCrossIcon();

                        serviceTicket.selectApplicationMenuItem();
                        serviceTicket.selectServiceTicketsUnderAPPAplicationMenuItem();

                        //Below code is to search the Service ticket created

                        serviceTicket.enterServiceTicketNymberForSearch(ticketNumber);
                        serviceTicket.clickServiceSearchFindBtn();
                        serviceTicket.verifyServiceTicketOnSearching(ticketNumber);
                    }else{
                        reporter.failureReport("Search for member in database", "No Member found after 10 iteration from database", driver);
                    }
                    diHome.logOut();
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
                    ReportStatus.fnUpdateResultStatus("SPP","2055",ReportStatus.strMethodName,intCounter,browser);
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

    public String getCurrentDate(){
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String currentdate=sdf.format(date);
        return currentdate;
    }


}
