package com.aaa.d3itu.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CallCreation extends  LoginLib {

    public static String callID;

    //Declarations
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CommonLib commonLib=new CommonLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRTowDestinationLib crTowDestinationLib=new CRTowDestinationLib();
    DILoginLib diLoginLib = new DILoginLib();
    DIHomeLib diHome = new DIHomeLib();
    CRServiceLib services = new CRServiceLib();
    DIHomeLib diHomeLib=new DIHomeLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CreateCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "CreateCall", TestData, "InTruckUltra");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            {
                try {
                    //Open the browser in each iteration
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data= TestUtil.getDataByRowNo("CreateCall", TestData, "InTruckUltra",intCounter);
                    TestEngineWeb.reporter.initTestCaseDescription("Create Call"+ " From Iteration " + StartRow + " to " + EndRow );

                    commonLib.callReceivingLogin(data.get("LoginName"), data.get("Password"));
                    String Member = "";
                    if (data.get("Member").equals("db"))
                    {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    }
                    if (Member==null)
                    {
                        Member = data.get("Membersearch");
                    }

                    //Searching Member Number
                    crHomeLib.memberSearchTextBox(Member);
                    crMemberSearchLib.memberNumClick();

                    //Entering the breakdown location
                    crLocationsLib.clickOnLocationTab();
                    crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));

                    //Vehicle details and traige
                    crVehicleTriageLib.clickOnVehicleTriageTab();
                    crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    crServiceLib.errorAlertHandlingBeforeEnterMandatoryFields();
                    crVehicleTriageLib.selectProblem(data.get("ProblemTriage"));
                    crServiceLib.errorAlertHandlingBeforeEnterMandatoryFields();

                    //Tow Destination
                    boolean towDestinationTabAvailability = crTowDestinationLib.verifyTowDestinationTabAvailablity();
                    if (towDestinationTabAvailability) {
                        crTowDestinationLib.clickOnTowDestinationTab();
                        crTowDestinationLib.handleScriptError();
                        crTowDestinationLib.enterTowDestinationLocationFields(data.get("TowAddress"));
                    }

                    //Service Tab
                    crServiceLib.clickOnServiceTab();
                    crServiceLib.errorAlertHandlingBeforeEnterMandatoryFields();
                    crServiceLib.enterManualSpotDetails(data.get("ManualSoptFacilityID"));
                    crServiceLib.errorAlertHandlingBeforeEnterMandatoryFields();
                    crHomeLib.saveButton();
                    crHomeLib.allErrorAlerts();
                    callID = services.getCallId();
                    services.closeCallWindow();
                    crHomeLib.logout();

                    //Navigate to dispatch Application
                    navigateToApplication("DI");
                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
                    diLoginLib.waitcloseAllBusyIcons();
                    diHomeLib.clickOnCloseIconOnFacilityPTA();

                    //Click on Search call window
                    diHome.clickOnSearchCallsInDispatch();

                    //Enter call id and click on that call id
                    diHome.enterCallIDInfo(callID);
                    diHome.clickOnSearchInSearchCalls();
                    diHome.clickOnCallDateOrIDLink();

                    //Click on AS button in MCD window and select facility
                    dimcdLib.clickOnAssign();
                    dimcdLib.selectITUDriver(data.get("TruckID"));

                    //Verify AS status
                    dimcdLib.lblCallAssignedStatus("AS");


                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Execption Occured","Execption Occured",driver);
                    reporter.warningReport("Error Description",e.getMessage());
                }

                ReportControl.fnEnableJoin();

                //updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
                ReportStatus.fnUpdateResultStatus("CreateCall","7777",ReportStatus.strMethodName,intCounter,browser);

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
