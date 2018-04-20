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

public class CR_DI_ITU_E2EMobile extends LaunchITULib
{
    
    public static String spotIDCreated;
    public static String [] callandfacilityId = new String[2];
    public static boolean verifyAddressAvailableForOtherLocationInMCDWindow;
    PacesetterResolutionLib pacesetterResolutionlib =new PacesetterResolutionLib();
    VehicleLookupLib vehicleLookuplib = new VehicleLookupLib();
    ServicesLib serviceslib =new ServicesLib();
    DeliveryConfirmationLib deliveryConfirmationlib =new DeliveryConfirmationLib();
    AssignTruckLib assignTrucklib = new AssignTruckLib();    
    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
    CallsLib calllib=new CallsLib();
    ETALib etalib =new ETALib();
	TowDestinationLib towDestinationLib=new TowDestinationLib();
    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Throwable {
        //logOut();
        this.appiumDriver.resetApp();
        super.afterMethod();
    }
    public static final int WAITTIME = 50000;

    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CRDIITUMobileEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRDIITUMobile", TestData, "e2eCRDIITUMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CRDIITUMobile", TestData, "e2eCRDIITUMobile",intCounter);
    					fnOpenTest(); 
    					//loginITU.waitforSync(15);
    					reporter.initTestCaseDescription("CR DI ITU End to End"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
	    		        selectEnvironment(data.get("ITUEnvironment"));
	    		        //loginITU.waitforSync(15);
		                loginITU.enterLoginDetails(data.get("UserName"),data.get("Password"));
		                facilityandTruckSelectionlib.getFacility();
		                //loginITU.waitforSync(15);
		                facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
		                //loginITU.waitforSync(15);
		                //calllib.clickOnCall(data.get("StatusupdateAS"));
		                calllib.clickOnCall(callIDCreated);
		                //calllib.clickOnAssignTruckAccept();
		                assignTruck(data.get("LoginRoleITU"),data.get("FacilityTruck"));
		                calllib.statusUpdateAsAssignment(data.get("Assignment"));
		                calllib.statusUpdateDI(data.get("statusupdatediitu"));
		                etalib.statusUpdateETA(data.get("updatecalletaitu"));
		                calllib.statusUpdateER(data.get("statusupdateeritu"));
		                calllib.statusUpdateOL(data.get("statusupdateolitu"));
		                calllib.statusUpdateTW(data.get("statusupdatetwitu"));
		                calllib.statusUpdateCL(data.get("statusupdateclitu"));
		                pacesetterResolutionlib.clickonPacesetterResolution(data.get("PacesetterResolution"));
						towDestinationLib.selectTipAndTowDestination(data.get("TowDestinationConfirmation"),data.get("Address"));
		                clearcall(data.get("AddServiceDesc"),data.get("Unit"),data.get("Cost"));
		                System.out.println("Test completed");
		    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR_DI_ITUMobile","7777",ReportStatus.strMethodName,intCounter,"EE");
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
    public void assignTruck(String TruckRole, String FacilityTruck) throws Throwable {
        if (waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner")) {
            //if (StatusUpdateAs.equalsIgnoreCase("AS")) {
        		calllib.clickOkOnNewCallPopup();
                Thread.sleep(2000);
                if (TruckRole.equalsIgnoreCase("LD")) {
                	calllib.clickOnAssignCallToTruck();
                    assignTrucklib.clickOnAssignTruck(FacilityTruck);
                    calllib.waitforCallAlertPopup();
                }
                Thread.sleep(5000);
                calllib.clickOkOnNewCallPopup();
                calllib.getAssignStatus();
            //}
        }
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