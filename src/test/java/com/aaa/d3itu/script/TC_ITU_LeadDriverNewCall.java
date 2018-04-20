package com.aaa.d3itu.script;
import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.d3itu.lib.CallsLib;
import com.aaa.d3itu.lib.LaunchITULib;
import com.aaa.d3itu.lib.LoginITULib;
import com.aaa.d3itu.lib.facilityandTruckSelectionLib;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_ITU_LeadDriverNewCall extends LoginLib
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
    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    //*** Main FLow
    @Test()
    public void TC_ITU_NewCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ITU_NewCall", TestData, "InTruckUltra");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					fnOpenTest(); 
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ITU_NewCall", TestData, "InTruckUltra",intCounter);
    					TestEngineWeb.reporter.initTestCaseDescription("ITU_NewCall"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
	    		        boolean isNewInstance;
						launchITU(isNewInstance=true);
						LaunchITULib launchITULib = new LaunchITULib();
						launchITULib.selectEnvironment(data.get("ITUEnvironment"));
		                loginITU.enterLoginDetails(data.get("ITUUserName"),data.get("ITUPassword"));
		                facilityandTruckSelectionlib.getFacility();
		                facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
		                
    					//Login to Call Receiving
    					commonLib.callReceivingLogin(data.get("CRLoginName"),data.get("CRPassword"),data.get("LoginRoleCallReceiving"),data.get("CR-Role"));
		                //Search member
    					commonLib.crMemberSearchTab(data.get("Member"),data.get("Membersearch"),data.get("dbServer"),data.get("dbqueryFileName"), data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"));
		                //Enter breakdown location details
    					commonLib.crLocationsTab(data.get("BreakdownSearch"),data.get("BreakdownType"),data.get("crossStreet"),data.get("secondCrossStreet"),data.get("LandMark"),data.get("Address"));
		                commonLib.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("VehicleType"),data.get( "ProblemTriage"),data.get("ProblemType"));
		                commonLib.crTowDestinationTab(data.get("WillThisCallBeATow"),data.get("TowDestination"),data.get("RSPReferral"),data.get("TowAddress"));
		                //Go to services tab and spot it to a facility
		                crServiceLib.clickOnServiceTab();
		                crServiceLib.spot(data.get("Spot"),data.get("ResoptFacilityID"),data.get("ManualSoptFacilityID"),data.get("ManualSoptFacilityIDNew"));
		                completeCall(data.get( "CompleteCall"));
		               //Login to Dispatch
		                navigateToApplication("DI");
		                commonLib.dispatchLogin(data.get("DILoginName"),data.get("DIPassword"),data.get("LoginRoleDispatch"),data.get("DI-RoleinDispatch"));
		                //Search the Call using CallId
		                diHomeLib.clickOnSearchCallsInDispatch();
		                diHomeLib.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                diHomeLib.clickOnSearchInSearchCalls();
		                diHomeLib.clickOnCallDateOrIDLink();
	                    //click on Assign and Assign to facility
	                    dimcdLib.clickOnAssign();
	                    dimcdLib.selectITUDriver(data.get("TruckID"));
	                    //-----------Need to add code for SPP Login adn Call Assign---------------//
	                    //On the ITU device Click Ok to accept the new call
	                    CallsLib calllib=new CallsLib();
	                    calllib.selectAnOptionForNewCall(data.get("OptionForNewCall"));
	                    calllib.scrollCallIntoView(callandfacilityId[0]);
	                    calllib.validateCallStatus(callandfacilityId[0], data.get("CallStatus"));
                        System.out.println("Test completed");
    			}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("ITU_UserPasswordAuthentication","1594",ReportStatus.strMethodName,intCounter,"MobileApp");
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

}
