package com.aaa.e2e.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.d3itu.lib.*;
import com.aaa.d3itu.page.LaunchPage;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CR_SPP_ITU_E2EMobile extends LaunchITULib
{

    PacesetterResolutionLib pacesetterResolutionlib =new PacesetterResolutionLib();
    VehicleLookupLib vehicleLookuplib = new VehicleLookupLib();
    ServicesLib serviceslib =new ServicesLib();
    DeliveryConfirmationLib deliveryConfirmationlib =new DeliveryConfirmationLib();
    AssignTruckLib assignTrucklib = new AssignTruckLib();
    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
    CallsLib calllib=new CallsLib();
    ETALib etalib =new ETALib();
    TowDestinationLib towDestinationLib =new TowDestinationLib();

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Throwable {
        //logOut();
        this.appiumDriver.resetApp();
        super.afterMethod();
    }
    public static final int WAITTIME = 50000;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CRSPPITUMobileEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRSPPITUMobile", TestData, "e2eCRSPPITUMobile");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("CRSPPITUMobile", TestData, "e2eCRSPPITUMobile",intCounter);
                    fnOpenTest();
                    //loginITU.waitforSync(15);
                    reporter.initTestCaseDescription("CR SPP ITU End to End"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
                    if(data.get("StatusupdateAS").equalsIgnoreCase("AS")) {
                        selectEnvironment(data.get("ITUEnvironment"));
                        loginITU.enterLoginDetails(data.get("UserName"), data.get("Password"));
                        facilityandTruckSelectionlib.getFacility();
                        facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
                        calllib.sortAllCallsInDescendingOrder();
                        //calllib.clickOnCall("20116");
                        calllib.clickOnCall(ReportControl.callID);
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

                        if(data.get("Assignment").equalsIgnoreCase("accept") && data.get("LoginRoleITU").equalsIgnoreCase("LD"))
                        {
                            calllib.clickOnAssignCallToTruck();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            assignTrucklib.clickOnAssignTruck(data.get("FacilityTruck"));
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            Thread.sleep(15000);
                            calllib.clickOkOnNewCallPopup();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            calllib.clickOnAssignTruckAccept();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            //calllib.getAssignStatus();
                        }

                        else if(data.get("Assignment").equalsIgnoreCase("accept") && data.get("LoginRoleITU").equalsIgnoreCase("IT"))
                        {
                            calllib.clickOnAssignTruckAccept();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            //calllib.getAssignStatus();
                        }

                        else if(data.get("Assignment").equalsIgnoreCase("decline") && data.get("LoginRoleITU").equalsIgnoreCase("IT"))
                        {
                            calllib.clickOnAssignTruckDecline();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            calllib.clickOnDeclineCallComment();
                            calllib.clickOnCall(ReportControl.callID);
                            reporter.failureReport("Checking for Accept button","Accept button is not available",appiumDriver);
                            throw new Exception("For IT Driver after decline Accept button will not show.");
                        }

                        else if(data.get("Assignment").equalsIgnoreCase("decline") && data.get("LoginRoleITU").equalsIgnoreCase("LD"))
                        {
                            calllib.clickOnAssignTruckDecline();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            calllib.clickOnDeclineCallComment();
                            calllib.clickOnCall(ReportControl.callID);
                            calllib.clickOnAssignCallToTruck();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            assignTrucklib.clickOnAssignTruck(data.get("FacilityTruck"));
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            Thread.sleep(15000);
                            calllib.clickOkOnNewCallPopup();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            calllib.clickOnAssignTruckAccept();
                            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                            //calllib.getAssignStatus();
                        }
                        calllib.statusUpdateDI(data.get("statusupdatediitu"));
                        Thread.sleep(5000);
                        etalib.statusUpdateETA(data.get("updatecalletaitu"));
                        Thread.sleep(5000);
                        //calllib.statusUpdateER(data.get("statusupdateeritu"));
                        Thread.sleep(5000);
                        calllib.statusUpdateOL(data.get("statusupdateolitu"));
                        Thread.sleep(5000);
                        calllib.statusUpdateTW(data.get("statusupdatetwitu"));
                        calllib.statusUpdateCL(data.get("statusupdateclitu"));
                        pacesetterResolutionlib.clickonPacesetterResolution(data.get("PacesetterResolution"));
                        towDestinationLib.selectTipAndTowDestination(data.get("TowDestinationConfirmation"),data.get("Address"));
                        clearcall(data.get("AddServiceDesc"), data.get("Unit"), data.get("Cost"));
                        System.out.println("Test completed");
                    }
                    else
                    {
                        System.out.println("Test completed");
                    }
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description"," "+e.toString());

                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("CR_SPP_ITUMobile","7777",ReportStatus.strMethodName,intCounter,"EE");
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

    public void clearcall(String AddService, String Unit, String Cost) throws Throwable {
        vehicleLookuplib.clickOnContinue();
        deliveryConfirmationlib.clickOnContinue();
        serviceslib.addService(AddService, Unit, Cost);
        serviceslib.verifyAddService(AddService);
        serviceslib.clickOnSave();
        Thread.sleep(2000);
        //deliveryConfirmationlib.getStatusUpdate();
    }

}
