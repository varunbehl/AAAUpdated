package com.aaa.e2e.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CR_DI extends LoginLib
{
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];
    public static String date;

    //Declarations
    CommonLib commonLib=new CommonLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHomeLib = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    DISearchCallsLib diSearchCallsLib = new DISearchCallsLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CRDIEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRDI", TestData, "e2eCRDI");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    			    //Open the browser in each iteration
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount=intCounter;
                    Hashtable<String, String> data=TestUtil.getDataByRowNo("CRDI", TestData, "e2eCRDI",intCounter);
                    TestEngineWeb.reporter.initTestCaseDescription("CR DI End to End"+ " From Iteration " + StartRow + " to " + EndRow );
                    reporter.SuccessReport("<font color='#0819F1'><b>Iteration Number : </b></font>","<font color='#0819F1'>**************Iteration Number::  "+ intCounter+"   **************</font>");
                    reporter.SuccessReport("<font color='#0819F1'><b>Iteration Details : </b></font>","<font color='#0819F1'><b>**************Member Type::  "+ data.get("MemberType")+" -- Member Level:: "+ data.get("MemberStatus")+" -- Member Entitlement Status:: "+data.get("MemberEntitlementStatus")+" -- Member Search:: "+data.get("MemberTypeSearch")+"************** </b></font>");

                    //Call Receiving Login
                    commonLib.callReceivingLogin(data.get("CRLoginName"),data.get("CRPassword"),data.get("LoginRoleCallReceiving"),data.get("CR-Role"));

                    //Entering Member details
                    commonLib.crMemberSearchTab(data.get("Member"),data.get("Membersearch"),data.get("dbServer"),data.get("dbqueryFileName"), data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"));

                    //Entering Location details
                    commonLib.crLocationsTab(data.get("BreakdownSearch"),data.get("BreakdownType"),data.get("crossStreet"),data.get("secondCrossStreet"),data.get("LandMark"),data.get("Address"));

                    //Entering Vehicle details and select pacesetter code
                    commonLib.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("VehicleType"),data.get("ProblemTriage"),data.get("ProblemType"));

                    //Entering tow destination details
                    commonLib.crTowDestinationTab(data.get("WillThisCallBeATow"),data.get("TowDestination"),data.get("RSPReferral"),data.get("TowAddress"));

                    //Entering service tab details
                    crServiceTab(data);

                    //Goto dispatch applicaion , if we create call successfully
                    if (data.get( "CompleteCall").equalsIgnoreCase("save")) {

                        //Navigate to Dispatch Application
                        navigateToApplication("DI");

                        //Dispatch Login
                        commonLib.dispatchLogin(data.get("DILoginName"), data.get("DIPassword"), data.get("LoginRoleDispatch"), data.get("DI-RoleinDispatch"));

                        //Clearing a call created in Call Receiving
                        diCallClearProcess(data);
                    }
		                System.out.println("Test completed");
		            
		    		}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
                reporter.failureReport("Execption Occured","Execption Occured",driver);
                reporter.warningReport("Error Description",e.getMessage());
			}
			    ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR_DI","7777",ReportStatus.strMethodName,intCounter,browser);

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


    /**
     * param :: Hashtable with String inputs
     * return :: String
     * throws :: throwable
     * methodName :: crServiceTab
     * description ::
     * date :: 27-Mar-2017
     * author :: Abhiram Vajrapu
     */

    public void crServiceTab(Hashtable<String, String> data) throws Throwable
    {
        crServiceLib.clickOnServiceTab();
        crServiceLib.errorAlertHandlingBeforeEnterMandatoryFields();

        //Entering priority details
        crServiceLib.enterpriority(data.get( "Priority"),data.get("PriorityRequired"));

        //Entering credit card details
        crServiceLib.enterCreditCardDetails(data.get("CreditCard"),data.get("Amount"),data.get("CCNumber"),data.get("CVC"),data.get("CCMonth"),data.get("CCYear"));

        //Entering Appointment details
        crServiceLib.enterAppointment(data.get("Appointment"),data.get( "Hold"));

        //Select Redflag
        crServiceLib.clickRedFlag(data.get( "RedFlag"));

        //Enter Policy details
        crServiceLib.enterPolicy(data.get( "Policy"),data.get( "PolicyValue"));

        //Entering call back details
        crServiceLib.callBack(data.get( "CallBack"),data.get( "CallBackMinutes"),data.get( "CallBackReqType"));

        //Get Auto spot facility details
        crServiceLib.spot(data.get("Spot"),data.get("ResoptFacilityID"),data.get("ManualSoptFacilityID"),data.get("ManualSoptFacilityIDNew"));

        //Saving call
        completeCall(data.get( "CompleteCall"));


        if (data.get( "CompleteCall").equalsIgnoreCase("save")) {

            //Release appointment call
            commonLib.releaseAppointmentCall(data.get("Appointment"),callandfacilityId[0],data.get("AptReason"),data.get("ManualSoptFacilityID"));
        }

        //Call Receiving Logout
        commonLib.callReceivingLogout();
    }

    /**
     * param :: String inputs
     * return :: String
     * throws :: throwable
     * methodName :: diCallClearProcess
     * description :: Clearing call
     * date :: 27-Mar-2017
     * author :: Abhiram Vajrapu
     */

    public void diCallClearProcess(Hashtable<String, String> data) throws Throwable
    {
    	if (data.get( "CompleteCall").equalsIgnoreCase("save")) {
    		 callFlow(data);

            //Change auto spot facility
            spotDispatch(data.get("SpotDispatch"),data.get("ResoptFacilityID"),data.get("SPEnterReason"),data.get("ResoptFacilityIDNew") );

            //Entering Additional Services
            dimcdLib.enterAPDServices(data.get("APDService"), data.get("ServiceType"), data.get("Cost"), data.get("CashCollected"));

            //verify sp status
   	        dimcdLib.statusUpdateAsSP(data.get("StatusUpdateSP"));

            //verify assign status
            dimcdLib.statusUpdateAsAS(data.get("StatusUpdateAS"));

            //verify dispatch status
            dimcdLib.statusUpdateAsDI(data.get("StatusUpdateDI"));

            //verify enroute status
            dimcdLib.statusUpdateAsER(data.get("StatusUpdateER"));
   	        dimcdLib.statusUpdateAsETA(data.get("StatusUpdateETA"));

   	        //verify on-location status
   	        dimcdLib.statusUpdateAsOL(data.get("StatusUpdateOL"));

            //verify tow status
   	        dimcdLib.statusUpdateAsTW(data.get("StatusUpdateTW"));

            //Click on CL button on MCD window to clear the call
   	        dimcdLib.statusUpdateAsCL(data.get("StatusUpdateCL"));
   	        dimcdLib.resolutionCode(data.get("ResolutionCode"),data.get("Reason"),data.get("BatteryInfo"),data.get("ResolutionCode"),data.get("StatusUpdateCL"));
   	        dimcdLib.towConfirmation(data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("StatusUpdateCL"));
   	        dimcdLib.batteyInfo(data.get("BatteryInfo"),data.get("ODOMeterreading"),data.get("BatteryComments"),data.get("StatusUpdateCL"));
   	        dimcdLib.clickonSubmitandVerifyClearCallLabel(data.get("StatusUpdateCL"));
   	        dimcdLib.verifyCallCleared();
   	        commonLib.dispatchlogout(data.get("CallFlow"));
    	}
       
    }

    /**
     * param :: String inputs
     * return :: String
     * throws :: throwable
     * methodName :: completeCall
     * description :: Save call and return CallID , CallDate and SpotID
     * date :: 27-Mar-2017
     * author :: Abhiram Vajrapu
     */

    public String[] completeCall(String CompleteCall) throws Throwable {
        switch (CompleteCall) {
            case "Save":
            	crHomeLib.messageDialogBoxClose();
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                Thread.sleep(4000);
                callIDCreated = crServiceLib.getCallId();
                spotIDCreated = crServiceLib.getSpotFacilityId();
                callDateCreated=crServiceLib.getCallDate();
                crServiceLib.closeCall();
                break;
            case "Cancel":
                crHomeLib.cancelButton();
                //below function will click on Yes on confirmation window
                crHomeLib.allErrorAlerts();
                crHomeLib.clickOnContinueButtonOnKillCallPopup();
                break;
            default:
                break;
        }
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;
        return callandfacilityId;
    }

    /**
     * param :: Hash table with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: callFlow
     * description :: Select call using Searchcall , profile or Truckload
     * date :: 27-Mar-2017
     * author :: Abhiram Vajrapu
     */

    public void callFlow(Hashtable<String, String> data) throws Throwable {
        //crHomeLib.messageDialogBoxClose();
        switch (data.get("CallFlow") ){
            case "Profile" :
                diHomeLib.clickOnProfile();
                commonLib.resetProfileSettings();
                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
                diHomeLib.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                break;
            case "MCD" :
                diHomeLib.clickOnSearchCallsInDispatch();
                date= callandfacilityId[2].substring(5,7) + "/" + callandfacilityId[2].substring(8,10)+ "/" + callandfacilityId[2].substring(0,4);//02/13/2018
                diSearchCallsLib.enterStartDate(date);
                commonLib.tabout();
                diSearchCallsLib.enterEndDate(date);
                commonLib.tabout();
                diHomeLib.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
                diHomeLib.clickOnSearchInSearchCalls();
                diHomeLib.clickOnCallDateOrIDLink();
                break;
            case "Truckload" :
                diHomeLib.clickOnTruckLoad();
                diHomeLib.enterSpotFacilityIDInfoOnTruckLoad(callandfacilityId[1]); //spotIDCreated
                //diHomeLib.clickOnSpotFacilityOntruckLoadTextBox();
                Thread.sleep(5000);
                diHomeLib.dateDecendingOrder();
                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
                diHomeLib.searchAndClickOnCallIdOnTruckloadWindow(callIDAndDateCombined);
                break;
            default :
                break;
        }
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: spotDispatch
     * description :: Change autospot facility id
     * date :: 27-Mar-2017
     * author :: Abhiram Vajrapu
     */

    public void spotDispatch(String SpotDispatch, String ResoptFacilityID, String SPEnterReason, String ResoptFacilityIDNew ) throws Throwable {
        Thread.sleep(3000);
    	switch (SpotDispatch){
            case "Respot" :
                dimcdLib.clickOnServiceTabInMCDWindow();
                if(callandfacilityId[1]!=ResoptFacilityID) //spotIDCreated
                {
                    dimcdLib.verifyFacilityAndEnterReasonAndReSpot(SPEnterReason, ResoptFacilityID);
                }
                else
                {
                    dimcdLib.verifyFacilityAndEnterReasonAndReSpot(SPEnterReason, ResoptFacilityIDNew);
                }
                break;
            default :
                break;
        }
    }
}