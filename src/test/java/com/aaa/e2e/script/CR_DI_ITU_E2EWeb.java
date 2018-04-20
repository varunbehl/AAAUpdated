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

public class CR_DI_ITU_E2EWeb extends LoginLib
{
    
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];
    public static boolean verifyAddressAvailableForOtherLocationInMCDWindow;
    public static boolean errorMessage;

    //Declarations
    CommonLib commonLib=new CommonLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHomeLib = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    //*** Main FLow
    @Test()
    public void CRDIITUWebEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRDIITUWeb", TestData, "e2eCRDIITUWeb");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					fnOpenTest(); 
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CRDIITUWeb", TestData, "e2eCRDIITUWeb",intCounter);
    					TestEngineWeb.reporter.initTestCaseDescription("CR DI ITU End to End"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
	    		        commonLib.callReceivingLogin(data.get("CRLoginName"),data.get("CRPassword"),data.get("LoginRoleCallReceiving"),data.get("CR-Role"));
		                commonLib.crMemberSearchTab(data.get("Member"),data.get("Membersearch"),data.get("dbServer"),data.get("dbqueryFileName"), data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"));
		                commonLib.crLocationsTab(data.get("BreakdownSearch"),data.get("BreakdownType"),data.get("crossStreet"),data.get("secondCrossStreet"),data.get("LandMark"),data.get("Address"));
		                commonLib.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("VehicleType"),data.get( "ProblemTriage"),data.get("ProblemType"));
		                commonLib.crTowDestinationTab(data.get("WillThisCallBeATow"),data.get("TowDestination"),data.get("RSPReferral"),data.get("TowAddress"));
		                crServiceTab(data);
		                navigateToApplication("DI");
		                commonLib.dispatchLogin(data.get("DILoginName"),data.get("DIPassword"),data.get("LoginRoleDispatch"),data.get("DI-RoleinDispatch"));
                    callFlow(data);
                    spotDispatch(data.get("SpotDispatch"),data.get("ResoptFacilityID"),data.get("SPEnterReason"),data.get("ResoptFacilityIDNew") );
                    if(data.get("StatusUpdateSP").equalsIgnoreCase("SP")) {
                        dimcdLib.statusUpdateAsSP(data.get("StatusUpdateSP"));
                    }
                    //click on Assign and Assign to facility
                    dimcdLib.clickOnAssign();
                    dimcdLib.selectITUDriver(data.get("TruckID"));
                    
                    Thread.sleep(2000);
                    //verify assign status
                    if(data.get("StatusupdateAS").equalsIgnoreCase("AS")) {
                        dimcdLib.lblCallAssignedStatus(data.get("StatusupdateAS"));
                    }
                    /*//verify dispatch status
                    if(data.get("StatusUpdateDI").equalsIgnoreCase("DI")) {
                        dimcdLib.lblCallDispatchedStatus(data.get("StatusUpdateDI"));
                    }
                    //verify enroute status
                    if(data.get("StatusUpdateER").equalsIgnoreCase("ER")) {
                        dimcdLib.lblCallENRouteStatus(data.get("StatusUpdateER"));
                    }
                    //verify onlocation
                    if(data.get("StatusUpdateOL").equalsIgnoreCase("OL")) {
                        dimcdLib.lblCallOnLocationStatus(data.get("StatusUpdateOL"));
                    }
                    //verify towstatus
                    if(data.get("StatusUpdateTW").equalsIgnoreCase("TW")) {
                        dimcdLib.lblCallTowStatus(data.get("StatusUpdateTW"));
                    }
                    //verify clearcall
                    if(data.get("StatusUpdateCL").equalsIgnoreCase("CL")) {
                        dimcdLib.labelCallCleared(data.get("StatusUpdateCL"));
                    }*/
                    //logout
                    diHomeLib.logOut();
                    System.out.println("Test completed");
		            
    		}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
			}
			ReportControl.fnEnableJoin();
			ReportStatus.fnUpdateResultStatus("CR_DI_ITUWeb","7777",ReportStatus.strMethodName,intCounter,"EE");
			ReportControl.fnSwitchToMobile();
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



    public void crServiceTab(Hashtable<String, String> data) throws Throwable
    {
        crServiceLib.clickOnServiceTab();
        crServiceLib.enterpriority(data.get( "Priority"),data.get("PriorityRequired"));
        crServiceLib.enterAppointment(data.get("Appointment"),data.get( "Hold"));
        crServiceLib.clickRedFlag(data.get( "RedFlag"));
        crServiceLib.enterPolicy(data.get( "Policy"),data.get( "PolicyValue"));
        crServiceLib.callBack(data.get( "CallBack"),data.get( "CallBackMinutes"),data.get( "CallBackReqType"));
        crServiceLib.spot(data.get("Spot"),data.get("ResoptFacilityID"),data.get("ManualSoptFacilityID"),data.get("ManualSoptFacilityIDNew"));
        completeCall(data.get( "CompleteCall"));
        commonLib.callReceivingLogout();
    }

    public void diCallClearProcess(Hashtable<String, String> data) throws Throwable
    {
        callFlow(data);
        spotDispatch(data.get("SpotDispatch"),data.get("ResoptFacilityID"),data.get("SPEnterReason"),data.get("ResoptFacilityIDNew") );
        dimcdLib.statusUpdateAsSP(data.get("StatusUpdateSP"));
        dimcdLib.statusUpdateAsAS(data.get("StatusUpdateAS"));
        dimcdLib.statusUpdateAsDI(data.get("StatusUpdateDI"));
        dimcdLib.statusUpdateAsER(data.get("StatusUpdateER"));
        dimcdLib.statusUpdateAsETA(data.get("StatusUpdateETA"));
        dimcdLib.statusUpdateAsOL(data.get("StatusUpdateOL"));
        dimcdLib.statusUpdateAsTW(data.get("StatusUpdateTW"));
        dimcdLib.statusUpdateAsCL(data.get("StatusUpdateCL"));
        dimcdLib.resolutionCode(data.get("ResolutionCode"),data.get("Reason"),data.get("BatteryInfo"),data.get("ResolutionCode"),data.get("StatusUpdateCL"));
        dimcdLib.towConfirmation(data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("StatusUpdateCL"));
        dimcdLib.batteyInfo(data.get("BatteryInfo"),data.get("ODOMeterreading"),data.get("BatteryComments"),data.get("StatusUpdateCL"));
        commonLib.dispatchlogout(data.get("CallFlow"));
    }

    public String[] completeCall(String CompleteCall) throws Throwable {
        switch (CompleteCall) {
            case "Save":
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                callIDCreated = crServiceLib.getCallId();
                spotIDCreated = crServiceLib.getSpotFacilityId();
                callDateCreated=crServiceLib.getCallDate();
                crServiceLib.closeCall();
                break;
            case "Cancel":
                crHomeLib.cancelButton();
                //below function will click on Yes on confirmation window
                crHomeLib.allErrorAlerts();
                break;
            default:
                break;
        }
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;
        return callandfacilityId;
    }

    public void callFlow(Hashtable<String, String> data) throws Throwable {
        //Map is out of scope
        //crHomeLib.messageDialogBoxClose();
        switch (data.get("CallFlow") ){
            case "Profile" :
                diHomeLib.clickOnProfile();
                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
                diHomeLib.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                break;
            case "MCD" :
                diHomeLib.clickOnSearchCallsInDispatch();
                diHomeLib.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
                diHomeLib.clickOnSearchInSearchCalls();
                diHomeLib.clickOnCallDateOrIDLink();
                break;
            case "Truckload" :
                diHomeLib.clickOnTruckLoad();
                diHomeLib.enterSpotFacilityIDInfoOnTruckLoad(callandfacilityId[1]); //spotIDCreated
                diHomeLib.clickOnSpotFacilityOntruckLoadTextBox();
                Thread.sleep(5000);
                diHomeLib.dateDecendingOrder();
                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
                diHomeLib.searchAndClickOnCallIdOnTruckloadWindow(callIDAndDateCombined);
                break;
            default :
                break;
        }
    }

    public void spotDispatch(String SpotDispatch, String ResoptFacilityID, String SPEnterReason, String ResoptFacilityIDNew ) throws Throwable {
        switch (SpotDispatch){
            case "Respot" :
                dimcdLib.clickOnServiceTabInMCDWindow();
                if(callandfacilityId[1]!=ResoptFacilityID) //spotIDCreated
                {
                    Thread.sleep(30000);
                    dimcdLib.verifyFacilityAndEnterReasonAndReSpot(SPEnterReason, ResoptFacilityID);
                }
                else
                {
                    Thread.sleep(30000);
                    dimcdLib.verifyFacilityAndEnterReasonAndReSpot(SPEnterReason, ResoptFacilityIDNew);
                }
                break;
            default :
                break;
        }
    }
}
