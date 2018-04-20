package com.aaa.e2e.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class RAP_SPP_ITU_DI_ClearCallE2EWeb extends LoginLib
{
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];
    public static long ranRAPID;
    public static String date;

    CRLocationsLib crLocationsLib =new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRTowDestinationLib crTowDestinationLib = new CRTowDestinationLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHomeLib = new DIHomeLib();
    CommonLib commonLib=new CommonLib();
    DISearchCallsLib diSearchCallsLib = new DISearchCallsLib();
    RAP_SPP_ITU_DI_E2EWeb rap_spp_itu_di_e2EWeb=new RAP_SPP_ITU_DI_E2EWeb();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void RAPSPPITUDICallClearingEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "RAPSPPITUDIWeb", TestData, "e2eRAPSPPITUDIWeb");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    //Open the browser in each iteration
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("RAPSPPITUDIWeb", TestData, "e2eRAPSPPITUDIWeb",intCounter);
                    TestEngineWeb.reporter.initTestCaseDescription("RAP SPP ITU DI End to End"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("<font color='#0819F1'><b>Iteration Number : </b></font>","<font color='#0819F1'><b>**************Iteration Number::  "+ intCounter+"   **************</b></font>");

                    //Navigate to Dispatch Application
                    navigateToApplication("DI");

                    //Diaptach Login
                    commonLib.dispatchLogin(data.get("DILoginName"),data.get("DIPassword"),data.get("LoginRoleDispatch"),data.get("DI-RoleinDispatch"));

                    diHomeLib.clickOnSearchCallsInDispatch();
                    diHomeLib.enterCallIDInfo(ReportControl.callID);
                    //diHomeLib.enterCallIDInfo("20134");
                    commonLib.tabout();
                    diHomeLib.clickOnSearchInSearchCalls();
                    diHomeLib.clickOnCallDateOrIDLink();

                    //Click on CL button on MCD window to clear the call
                    dimcdLib.statusUpdateAsCL(data.get("StatusUpdateCL"));
                    dimcdLib.resolutionCode(data.get("ResolutionCode"),data.get("Reason"),data.get("BatteryInfo"),data.get("ResolutionCode"),data.get("StatusUpdateCL"));
                    dimcdLib.towConfirmation(data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("StatusUpdateCL"));
                    dimcdLib.batteyInfo(data.get("BatteryInfo"),data.get("ODOMeterreading"),data.get("BatteryComments"),data.get("StatusUpdateCL"));
                    dimcdLib.clickonSubmitandVerifyClearCallLabel(data.get("StatusUpdateCL"));
                    commonLib.dispatchlogout(data.get("CallFlow"));
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description",e.getMessage());
                }
                ReportControl.fnEnableJoin();

                //updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
                ReportStatus.fnUpdateResultStatus("RAP_SPP_ITU_DIWeb","7777",ReportStatus.strMethodName,intCounter,browser);

                //Switch to mobile
                //To close the browser after each iteration
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
