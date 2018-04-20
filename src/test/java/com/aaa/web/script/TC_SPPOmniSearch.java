package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.sun.jndi.cosnaming.IiopUrl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TC_SPPOmniSearch extends ActionEngine {

 /*   CRHomeLib home = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRMemberSearchLib memeber = new CRMemberSearchLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    DIHomeLib diHome = new DIHomeLib();
    DILoginLib diLogin = new DILoginLib();
    DIMCDLib mcdlib = new DIMCDLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DIMCDLib dimcd = new DIMCDLib();
    LoginLib login = new LoginLib();
    DISearchCallsLib searchCall=new DISearchCallsLib();

    public static List<String> callId = new ArrayList<>();
    public static String call;
    public static String newDate;
    public static int iteration = 0;
    public static String spot=" ";
    int size=0;
    boolean noResultFound;
    boolean condition;

    *//************************************************************************
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
     *************************************************************************//*

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test(int StartRow,String EndRow,boolean nextTestJoin)
    public void createCallForOmniBarSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SPPOmnibar", TestData, "SPPOmnibar");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("SPPOmnibar", TestData, "SPPOmnibar",intCounter);
                    this.reporter.initTestCaseDescription("1979:TC-SPPOmniSearch"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
                // Logging into the application
                navigateToApplication("CR");
                login.login(data.get("CRLoginName"), data.get("CRPassword"));
                Thread.sleep(5000);
                home.allErrorAlertsNoButton();
                home.messageDialogBoxClose();

                String Member = "";
                if (data.get("Member").equals("db")) {
                    //fetch member details from db
                    //generating a random number everytime to fetch a new record everytime
                    int rownum = IntRandomNumberGenerator(50, 1000);
                    //member from db
                    Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                    System.out.println("member : " + Member);
                }
                if (Member.isEmpty()) {
                    Member = data.get("MemberNumber");
                }
                home.memberSearchTextBox(Member);
                memeber.memberNumClick();
                //memeber.currentCallClose();
                memeber.ClickPrimRadioBtnInRowTwo();
                // Locations Page Starts
                crLocationsLib.clickOnLocationTab();
                //Entering Location Details
                crLocationsLib.clickOnLocationTab();
                crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));

                Thread.sleep(3000);
                //locations.clickOnSecondKownBrkDowLocation();
                Thread.sleep(3000);
                // Vehicle Triage Page Starts here
                crVehicleTriageLib.clickOnVehicleTriageTab();
                String VehicleDet[] = data.get("Vehiclemodel").split("#");
                crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
                crVehicleTriageLib.clickOnTheVehicleSearchIcon();
                crVehicleTriageLib.clickOnTheVehicleSearch();
                crVehicleTriageLib.vehicleColor(VehicleDet[1]);
                crVehicleTriageLib.clickonProblemTypeButton(data.get("TriageType"));
                Thread.sleep(2000);
                crVehicleTriageLib.clickonProblemTypeOptions(data.get("TriageOption"));
                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                crServiceLib.clickOnServiceTab();
                home.waitCloseAllBusyIconsResults();
                if(spot.equalsIgnoreCase("spot")) {
                    crServiceLib.enterManualSpotDetails(data.get("SPPFacilitySpot"));
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                }
                home.saveButton();
                callId.add(crServiceLib.getCallId());
                newDate = crServiceLib.getCallDateAfterCallSave();
                crServiceLib.closeCall();
                home.logout();

                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("SPP","1794",ReportStatus.strMethodName,intCounter,browser);
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
    @Test(int StartRow,String EndRow,boolean nextTestJoin)
    public void DIOmnibarSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SPPOmnibar", TestData, "SPPOmnibar");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("SPPOmnibar", TestData, "SPPOmnibar",intCounter);
                    this.reporter.initTestCaseDescription("1979:TC-SPPOmniSearch"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
                //logging in DISpp

                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("SPPDILoginName"), data.get("SPPDIPassword"));

                if (data.get("SPPDILoginName").contains("di")) {
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    Thread.sleep(5000);
                    diHome.clickOnCloseIconOnQueueSelection();
                } else {
                    mcdlib.closeFacilityPTAWindow();
                }
                crHomeLib.waitCloseAllBusyIconsResults();

                //Search calls entering call id and searching
                call = callId.get(iteration);
                //newDate=crServiceLib.getCallDateAfterCallSave();
                diHome.verifySearchTips();
                Thread.sleep(1000);
                boolean searchTips = diHome.verifySearchTips();
                assertTrue(searchTips, "Search tips found");
                diHome.txtOmniBarSearch(newDate + " " + call);
                diHome.clickOmniBarSearch();
                noResultFound = diHome.verificationOfNoSearchFoundNotification();
                Thread.sleep(2000);
                assertTrue(noResultFound, "No result found Notification is appeared");
                diHome.logOut();
                acceptAlert();
                Thread.sleep(2000);
                acceptAlert();
                if (noResultFound) {
                    navigateToApplication("DI");
                    Thread.sleep(4000);
                    diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    Thread.sleep(5000);
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnSearchCallsInDispatch();
                    diHome.enterCallIDInfo(call);
                    diHome.clickOnSearchInSearchCalls();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnCallDateOrIDLink();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    dimcd.clickOnStatusUpdateTab();
                    dimcd.enterStatusInStatusUpdateTab(data.get("Status"));
                    dimcd.enterReasonInStatusUpdateTab(data.get("Reason"));
                    dimcd.enterfacilityOnStatusUpdateWindow(data.get("Facility"));
                    dimcd.clickOnUpdate();
                    dimcd.enterTruckIDOnStatusUpdateTab(data.get("TruckID"));
                    diHome.logOut();
                    acceptAlert();
                    Thread.sleep(2000);
                    acceptAlert();
                }
                navigateToApplication("DI");
                Thread.sleep(4000);
                diLogin.login(data.get("SPPDILoginName"), data.get("SPPDIPassword"));
                mcdlib.closeFacilityPTAWindow();
                crHomeLib.waitCloseAllBusyIconsResults();
                //Search calls entering call id and searching
                call = callId.get(iteration);
                diHome.txtOmniBarSearch(newDate + " " + call);
                diHome.clickOmniBarSearch();
                size=diHome.searchResult().size();
                assertTrue(size!=0,"Search results found is"+size+"");
                diHome.clickSearchResultCloseIcon();
                Thread.sleep(1000);
                diHome.logOut();
                acceptAlert();
                Thread.sleep(2000);
                acceptAlert();

                diLogin.login(data.get("SPMGDILoginName"), data.get("SPMGDIPassword"));
                mcdlib.closeFacilityPTAWindow();
                crHomeLib.waitCloseAllBusyIconsResults();
                //Search calls entering call id and searching
                call = callId.get(iteration);
                diHome.txtOmniBarSearch(newDate + " " + call);
                diHome.clickOmniBarSearch();
                size=diHome.searchResult().size();
                assertTrue(size!=0,"Search results found is"+size+"");
                diHome.clickSearchResultCloseIcon();
                Thread.sleep(1000);
                diHome.logOut();
                acceptAlert();
                Thread.sleep(2000);
                acceptAlert();

                if (data.get("MultipleCall").equalsIgnoreCase("yes")) {
                    navigateToApplication("DI");
                    Thread.sleep(4000);
                    diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    Thread.sleep(5000);
                    diHome.clickOnCloseIconOnQueueSelection();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search calls entering call id and searching
                    call = callId.get(iteration);
                    diHome.enterCallIDInfo(call);
                    //searchCall.selectCallStatus(data.get("CallStatus"));
                    diHome.clickOnSearchInSearchCalls();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.clickOnCallDateOrIDLink();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    mcdlib.clickOnAssign();
                    Thread.sleep(5000);
                    mcdlib.selectSecondFacilityOnAssignTabInMCD();
                    Thread.sleep(2000);
                    mcdlib.clickOnDuplicateCallIcon();
                    mcdlib.enterFacilityToSpotOnDuplicateCallTab(data.get("Facility"));
                    mcdlib.enterPaceSetterCodeOnDuplicateCallTab(data.get("PaceSetterCode"));
                    mcdlib.enterReasonOnDuplicateCallTab(data.get("Reason"));
                    //Thread.sleep(2000);
                    mcdlib.clickOnDuplicateCallButton();
                    Thread.sleep(2000);
                    mcdlib.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    Thread.sleep(2000);
                    acceptAlert();


                    navigateToApplication("DI");
                    Thread.sleep(4000);
                    diLogin.login(data.get("SPMGDILoginName"), data.get("SPMGDIPassword"));
                    mcdlib.closeFacilityPTAWindow();
                    crHomeLib.waitCloseAllBusyIconsResults();
                    diHome.txtOmniBarSearch(call);
                    diHome.clickOmniBarSearch();
                    //noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    Thread.sleep(2000);
                    //noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    size = diHome.searchResult().size();
                    assertTrue(size != 0, "Search results found are" + size + "");
                    //noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    diHome.txtOmniBarSearch(data.get("CallStatus"));
                    diHome.clickOmniBarSearch();
                    condition = diHome.callStatus(data.get("CallStatus"));
                    assertTrue(condition, "Call status of calls is matching"+data.get("CallStatus")+"");
                    diHome.txtOmniBarSearch(data.get("PaceSetterCode"));
                    diHome.clickOmniBarSearch();
                    condition = diHome.paceSetter(data.get("PaceSetterCode"));
                    assertTrue(condition, "All calls pace setter code is matching"+data.get("paceSetterCode")+"");
                    Thread.sleep(3000);
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    diHome.txtOmniBarSearch(data.get("Facility"));
                    diHome.clickOmniBarSearch();
                    noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    if(!noResultFound) {
                    size = diHome.searchResult().size();
                    assertTrue(size != 0, "All trucks and calls under"+data.get("Facility")+"is returned");
                }
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    diHome.txtOmniBarSearch(data.get("TruckId"));
                    diHome.clickOmniBarSearch();
                    noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    if(!noResultFound) {
                    size = diHome.searchResult().size();
                    assertTrue(size != 0, "All trucks and calls under"+data.get("TruckId")+"is returned");
                }
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    diHome.txtOmniBarSearch(data.get("PlaceName"));
                    diHome.clickOmniBarSearch();
                    noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    if(!noResultFound) {
                    size = diHome.searchResult().size();
                    assertTrue(size != 0, "Search results found is" + size + "");
                }
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    diHome.txtOmniBarSearch(data.get("PlaceAndCityName"));
                    diHome.clickOmniBarSearch();
                    noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    if(!noResultFound) {
                    //condition=diHome.placeAndCityVerification(data.get("PlaceAndCityName"));
                    assertTrue(diHome.placeAndCityVerification(data.get("PlaceAndCityName")), "Search result found for Place and City");
                }
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    String address = diHome.addressForDIOmniBarSearch(data.get("Address"));
                    diHome.txtOmniBarSearch(data.get(address));
                    diHome.clickOmniBarSearch();
                    noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    if(!noResultFound) {
                    assertTrue(diHome.addressVerification(data.get("Address")), "Address Found in search result");
                }
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    diHome.txtOmniBarSearch(data.get("CityAndStatus"));
                    diHome.clickOmniBarSearch();
                    noResultFound = diHome.verificationOfNoSearchFoundNotification();
                    if(!noResultFound) {
                        assertTrue(diHome.cityAndStatusVerification(data.get("CityAndStatus")), "City and status in search result");
                    }
                    diHome.clickSearchResultCloseIcon();
                    Thread.sleep(1000);
                    //if (!noResultFound) {
                        diHome.logOut();
                        acceptAlert();
                        Thread.sleep(2000);
                        acceptAlert();
                    //}
                }
                iteration++;
            }
                catch(Exception e)
            {
                ReportStatus.blnStatus=false;
            }
            ReportControl.fnEnableJoin();
            ReportStatus.fnUpdateResultStatus("SPP","1794",ReportStatus.strMethodName,intCounter,browser);
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
