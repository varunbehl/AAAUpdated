package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRSaveERSCallLightService extends ActionEngine{

    //Object Creations
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: basicMemberCallLightServiceForFuelTrouble
     * description :: basicMemberCallLightServiceForFuelTrouble
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSLightService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveERSLightService", TestData, "D3CallRecieving");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {

                    //Open the browser in each iteration
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("saveERSLightService", TestData, "D3CallRecieving",intCounter);
                    this.reporter.initTestCaseDescription("1628: TC-Save ERS Call Light Service "+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
                    login.login(data.get("LoginName"),data.get("Password"));
                    Thread.sleep(12000);
                    crHomeLib.messageDialogBoxClose();
                    Thread.sleep(16000);
                    String Member = "";

                    //Getting member from DB based on the input
                    if (data.get("Member").equals("db")){
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50,1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
                        System.out.println("member : "+Member);
                    }
                    if(Member.isEmpty()){
                        Member = data.get("Membersearch");
                    }

                    //Searching Member number
                    crHomeLib.memberSearchTextBox(Member);
                    crMemberSearchLib.memberNumClick();
                    crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

                    //Entering the breakdown location
                    crLocationsLib.clickOnLocationTab();
                    crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));

                    //Vehicle details and traige
                    crVehicleTriageLib.clickOnVehicleTriageTab();
                    String VehicleDet[] = data.get("Vehiclemodel").split("#");
                    crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
                    crVehicleTriageLib.clickOnTheVehicleSearchIcon();
                    crVehicleTriageLib.clickOnTheVehicleSearch();
                    crVehicleTriageLib.vehicleColor(VehicleDet[1]);
                    crVehicleTriageLib.enterPaceSetterCodeManually(data.get("PacesetterCode"));
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    crVehicleTriageLib.scriptErrorHandle();

                    //Saving the call and validating the call id is not null in getCallId method
                    Thread.sleep(5000);
                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                    crHomeLib.saveButton();
                    String callId = services.getCallId();
                    assertTrue(!callId.equalsIgnoreCase(null), "<b>Call is saved successfully</b>");
                    Thread.sleep(5000);
                    crHomeLib.allErrorAlerts();
                    services.closeCallWindow();
                    crHomeLib.logout();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();

                //updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
                ReportStatus.fnUpdateResultStatus("CR","1628",ReportStatus.strMethodName,intCounter,browser);

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