package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

public class TC_SPPTruckLoadFacilityFiltering extends ActionEngine{
    public static String callIDForFacility;
    public static String spotedFacilify;
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callDateStrForFacility;
    public  String [] callandfacilityId = new String[3];
    LoginLib login = new LoginLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    CRServiceLib services = new CRServiceLib();
    CRHomeLib home = new CRHomeLib();
    DIProfileLib profileLib =  new DIProfileLib();
    DIMCDLib mcdLib = new DIMCDLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DITruckLoadDeafultViewLib truckLoad = new DITruckLoadDeafultViewLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRServiceLib service = new CRServiceLib();
    CommonLib commonLib = new CommonLib();
    DIHomePage diHomePage = new DIHomePage();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(enabled = true)
    public void sppTruckLoadFacilityFiltering(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "SPPTruckLoadFacilityFiltering", TestData, "SPPDispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();

                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("SPPTruckLoadFacilityFiltering", TestData, "SPPDispatch", intCounter);
                    this.reporter.initTestCaseDescription("1828 : SPP TruckLoad Facility Filtering" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //Calling the common function for call creation
                    createCallForFacilitySearchInTruckLoad(data);
                    service.clickOnServiceTab();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    service.enterManualSpotDetails(data.get("FacilityToSpot"));
                    crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
                    spotedFacilify = service.validateFacilityAutospot();
                    crHomeLib.saveButton();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    callIDForFacility = service.getCallId();
                    //Get Call ID And Date  After call Created

                    callDateCreated = services.getCallDate();
                    Thread.sleep(2000);
                    callDateStrForFacility = callDateCreated.replaceAll("-", "");
                    service.closeCall();
                    crHomeLib.logout();
                    //Navigate TO Dispatch
                    navigateToApplication("DI");
                    //Thread.sleep(3000);
                    diLogin.login(data.get("SppLoginName"), data.get("SppPassword"));
                    crHomeLib.waitCloseAllBusyIconsResults();
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnTruckLoadTab();
                    truckLoad.clickSPPdefaultTruckView();
                    home.waitCloseAllBusyIconsResults();
                   //Calling common functionalit when Truck Load window In PoppedIn Mode
                    commonFunctionalityToValidateFacility(data);
                    reporter.SuccessReport("Verification of TruckLoad facility Filtering On TruckLoad PopOut mode","Verification of TruckLoad facility Filtering On TruckLoad PopOut mode");
                    boolean popOutFlag = data.get("PopOut").equalsIgnoreCase("YES");
                    if(popOutFlag){
                        truckLoad.clickOnPoppedOutModeInTruckLoadDefaultViewWindow();
                        home.waitCloseAllBusyIconsResults();
                        switchToWindow();
                        Thread.sleep(2000);
                        //Calling common functionalit when Truck Load window In PoppedIn Mode
                        commonFunctionalityToValidateFacility(data);
                        truckLoad.clickOnPopInButton();
                        home.waitCloseAllBusyIconsResults();
                        switchToWindow();
                        Thread.sleep(2000);
                        assertTrue(popOutFlag,"The expected results in popout mode are same as when the truckload window was popped-in");
                    }
                    diHome.logOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description"," "+e.toString());

                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI","1828",ReportStatus.strMethodName,intCounter,browser);
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

    //Common Functionality to create a call
    public void createCallForFacilitySearchInTruckLoad(Hashtable<String, String> data)throws  Throwable{
        navigateToApplication("CR");
        Thread.sleep(4000);
        login.login(data.get("LoginName"), data.get("Password"));
        crHomeLib.waitCloseAllBusyIconsResults();
        crHomeLib.messageDialogBoxClose();
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

        crHomeLib.memberSearchTextBox(Member);

        crMemberSearchLib.memberNumClick();
        //crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
        //crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
        Thread.sleep(2000);
        crLocationsLib.breakdownLocTabSel();
        //Enter Location Mandatory Fields
        crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
        //To enter Vehicle Information
        commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "", data.get("ProblemTriage"), data.get("ProblemType"));
        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
        crHomeLib.allErrorAlerts();
        Thread.sleep(2000);
        tow.clickOnTowDestinationTab();
        crHomeLib.waitCloseAllBusyIconsResults();
        crVehicleTriageLib.scriptErrorHandle();
        crHomeLib.allErrorAlerts();
        Thread.sleep(3000);
        tow.clickOnAARTowDetinationLink();
        //tow.clickOnManualEntryLinkOnTowDestination();
        tow.enterTowPassengers(data.get("TowPassengers"));
        Thread.sleep(2000);
    }

    public void commonFunctionalityToValidateFacility(Hashtable<String,String> data) throws Throwable {

        List<String> facilityList = truckLoad.getFacilitiesListRelatedToSPMG();
        //To verify Only the facilities that are part of the SPMG.
        boolean isListContainsFacility=false;
        for(int i=0;i<facilityList.size();i++){
            String facility = facilityList.get(i);
            if(facility.contains(data.get("FacilityTo5001")) || facility.contains(data.get("FacilityTo5140")) || facility.contains(data.get("FacilityTo5145")));
            {
                isListContainsFacility=true;
            }
        }
        assertTrue(isListContainsFacility,"Verified the facilities In the truck Load, contains only the facilities that are part of the SPMG");
        String defaultSelectedFacility = truckLoad.getHeadingLabelTxtOfSelectedFaciltyData();
        String facilityArray[]= defaultSelectedFacility.split(" ");
        String selectedFacility = facilityArray[1];
        String facilityExpected = data.get("DefaultSelectedFacility");
        assertTrue(selectedFacility.equals(facilityExpected),"Verified the facilities side panel as first one on the list selected ,Selected Facility is "+selectedFacility);
        /*Not automatable to verify all calls and Trucks related to facility,because of stale element exception.
          Insted of this verifing facility with Hedding facility Lable*/
        assertTrue(selectedFacility.equals(facilityExpected),"Verified the defaultly selected facility ,and all calls are related to facility"+selectedFacility);
        //Getting default facility count to validate 7th step
        int numberOfFacilitiesBefore = facilityList.size();
        /*Not automatable to verify all calls and Trucks related to facility,because of stale element exception.
          Insted of verifing all calls,Verifing with one created call related to facility*/
        //Select Facility 5145
        truckLoad.clickOnFacilityOnDefaultTruck(spotedFacilify);
        home.waitCloseAllBusyIconsResults();
        boolean verifyCallIsRelatedToFacility = truckLoad.verifyCallIdOnTruckDefaultViewPage(callIDForFacility, callDateStrForFacility);
        assertTrue(verifyCallIsRelatedToFacility, "Verified with created call, Call is related to selected facility : "+spotedFacilify);
        //Enter and search for the facility 5140
        if(spotedFacilify.equals(data.get("FacilityTo5140"))) {
            diHome.enterSpotFacilityIDInfoOnTruckLoad(spotedFacilify);
            home.waitCloseAllBusyIconsResults();
        /*Not automatable to verify all calls and Trucks related to facility,because of stale element exception.
           Insted of verifing all calls,Verifing with one created call related to facility*/
            boolean isFacilityAvailable = truckLoad.verifyCallIdOnTruckDefaultViewPage(callIDForFacility, callDateStrForFacility);
            assertTrue(isFacilityAvailable, "The Truckload displayed the trucks and calls for the facility that was entered in the input filter field.Entered Facility is " + spotedFacilify);
            diHome.clickOnCloseiconOnSpotfacilityOnTruckLoad();
            home.waitCloseAllBusyIconsResults();
            Thread.sleep(4000);
            List<String> listOfFacilitiesOnTruckLoad = truckLoad.getFacilitiesListRelatedToSPMG();
            //To verify Only the facilities that are part of the SPMG.
            boolean facilitiesFlag = false;
            for (int i = 0; i < listOfFacilitiesOnTruckLoad.size(); i++) {
                String facility = listOfFacilitiesOnTruckLoad.get(i);
                if (facility.contains(data.get("FacilityTo5001")) || facility.contains(data.get("FacilityTo5140")) || facility.contains(data.get("FacilityTo5145")))
                    ;
                {
                    facilitiesFlag = true;
                }
            }
            assertTrue(facilitiesFlag, "The Truckload is display the rest of the facilities");
        }
        // Enter facility that is not related to SPMG
        diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("FacilityNotRelatedToSPMG"));
        home.waitCloseAllBusyIconsResults();
        List<String> allFacilitiesInSppUser = truckLoad.getFacilitiesListRelatedToSPMG();
        int numberOfFacilitiesAfter = allFacilitiesInSppUser.size();
        assertTrue(numberOfFacilitiesBefore == numberOfFacilitiesAfter,"Nothing  happen. The input filter not  recognized the  facilities that are NOT part of the SPMG ");
        Thread.sleep(3000);
       // truckLoad.clickOnCloseIcon();

    }
}
