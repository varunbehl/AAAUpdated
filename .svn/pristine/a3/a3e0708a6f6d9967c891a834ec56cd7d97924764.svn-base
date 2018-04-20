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


public class RAP_SPP_ITU_DI_E2EMobile extends LaunchITULib
{
    AssignTruckLib assignTrucklib = new AssignTruckLib();
    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
    CallsLib calllib=new CallsLib();
    ETALib etalib =new ETALib();
    RAP_SPP_ITU_DI_E2EWeb rap_spp_itu_di_e2EWeb=new RAP_SPP_ITU_DI_E2EWeb();

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Throwable {
        //logOut();
        this.appiumDriver.resetApp();
        super.afterMethod();
    }
    public static final int WAITTIME = 50000;


    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void RAPSPPITUMobileEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "RAPSPPITUDIMobile", TestData, "e2eRAPSPPITUDIMobile");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("RAPSPPITUDIMobile", TestData, "e2eRAPSPPITUDIMobile",intCounter);
                    fnOpenTest();
                    reporter.initTestCaseDescription("RAP SPP ITU DI End to End"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
                    selectEnvironment(data.get("ITUEnvironment"));
                    loginITU.enterLoginDetails(data.get("UserName"),data.get("Password"));
                    facilityandTruckSelectionlib.getFacility();
                    facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
                    calllib.sortAllCallsInDescendingOrder();
                    calllib.clickOnCall(ReportControl.callID);
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

                    if(data.get("Assignment").equalsIgnoreCase("accept") && data.get("LoginRoleITU").equalsIgnoreCase("LD"))
                    {
                        calllib.clickOnAssignCallToTruck();
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        assignTrucklib.clickOnAssignTruck(data.get("FacilityTruck"));
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        Thread.sleep(10000);
                        calllib.clickOkOnNewCallPopup();
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        calllib.clickOnAssignTruckAccept();
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        //calllib.getAssignStatus();
                    }

                    if(data.get("Assignment").equalsIgnoreCase("accept") && data.get("LoginRoleITU").equalsIgnoreCase("IT"))
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
                        calllib.clickOnCall(callIDCreated);
                        reporter.failureReport("Checking for Accept button","Accept button is not available",appiumDriver);
                        throw new Exception("Accept button not exists");
                    }

                    else if(data.get("Assignment").equalsIgnoreCase("decline") && data.get("LoginRoleITU").equalsIgnoreCase("LD"))
                    {
                        calllib.clickOnAssignTruckDecline();
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        calllib.clickOnDeclineCallComment();
                        calllib.clickOnCall(callIDCreated);
                        calllib.clickOnAssignCallToTruck();
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        assignTrucklib.clickOnAssignTruck(data.get("FacilityTruck"));
                        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                        Thread.sleep(80000);
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
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description",e.getMessage());

                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("RAP_SPP_ITU_DIMobile","7777",ReportStatus.strMethodName,intCounter,"EE");
                fnCloseTest();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
        //ReportControl.fnSwitchToWeb();
    }

}
