package com.aaa.d3itu.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.d3itu.lib.*;
import com.aaa.d3itu.page.LaunchPage;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_ITU_ManualVehicleEditMobile extends LaunchITULib
{

    public static String spotIDCreated;
    public static String [] callandfacilityId = new String[2];

    AssignTruckLib assignTrucklib = new AssignTruckLib();
    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
    CallsLib calllib=new CallsLib();
    ETALib etalib =new ETALib();
    CallsDetailsLib callDetail=new CallsDetailsLib();
    UpdateVehicleLib updateVehicle=new UpdateVehicleLib();
    TC_ITU_ManualVehicleEditWeb tc_itu_manualVehicleEditWeb=new TC_ITU_ManualVehicleEditWeb();


    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Throwable {
        //logOut();
        this.appiumDriver.resetApp();
        super.afterMethod();
    }
    public static final int WAITTIME = 50000;


    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyManualVehiclEditMobile(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyManualVehiclEditMobile", TestData, "InTruckUltra");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyManualVehiclEditMobile", TestData, "InTruckUltra",intCounter);
                    fnOpenTest();
                    reporter.initTestCaseDescription("TC_ITU Manual Vehicle Edit mobile"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
                    selectEnvironment(data.get("ITUEnvironment"));
                    loginITU.enterLoginDetails(data.get("UserName"),data.get("Password"));
                    facilityandTruckSelectionlib.getFacility();
                    facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
                    calllib.sortAllCallsInDescendingOrder();
                    calllib.clickOnCall(data.get("StatusupdateAS"));
                    calllib.clickOnCall(ReportControl.callID);
                    //calllib.clickOnCall("20121");
                    calllib.clickOnAssignCallToTruck();
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                    assignTrucklib.clickOnAssignTruck(data.get("FacilityTruck"));
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                    Thread.sleep(10000);
                    calllib.clickOkOnNewCallPopup();
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                    calllib.clickOnAssignTruckAccept();
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                    calllib.getAssignStatus();
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");


                    calllib.clickCallDetails();
                    callDetail.clickVehiclePencilIcon();
                    updateVehicle.getTextOfType();
                    updateVehicle.getTextOfYear();
                    updateVehicle.getTextOfMake();
                    updateVehicle.getTextOfModel();
                    updateVehicle.getTextOfTrim();
                    updateVehicle.getTextOfColor();
                    updateVehicle.getTextOfState();
                    updateVehicle.getTextOfTag();
                    updateVehicle.getTextOfNotes();
                    updateVehicle.getTextOfOdometer();
                    updateVehicle.getTextOfVin();
                    updateVehicle.clickOnType();
                    updateVehicle.clickOnYear();
                    updateVehicle.enterMake(data.get("Make"));
                    updateVehicle.enterModel(data.get("Model"));
                    updateVehicle.enterTrim(data.get("Trim"));
                    updateVehicle.enterColor(data.get("Color"));
                    updateVehicle.enterState(data.get("State"));
                    updateVehicle.enterTag(data.get("Tag"));
                    updateVehicle.enterNotes(data.get("Notes"));
                    updateVehicle.enterOdometer(data.get("Odometer"));
                    updateVehicle.enterVin(data.get("VIN"));
                    updateVehicle.clickOnSave();
                    updateVehicle.clickOnYesInConformationPopup();
                    updateVehicle.clickOnNoInConformationPopup();

                  appiumDriver.navigate().back();
                    appiumDriver.navigate().back();
                    calllib.clickOnComments();
                    //verify comments


                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description",e.getMessage());

                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("TC_ITU_ManualVehicleEditMobile","7777",ReportStatus.strMethodName,intCounter,"verifyManualVehiclEditMobile");
                ReportControl.fnSwitchToWeb();
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
