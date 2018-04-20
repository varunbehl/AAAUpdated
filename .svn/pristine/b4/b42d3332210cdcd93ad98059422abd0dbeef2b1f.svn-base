package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRManualSpot extends DILoginLib {
        public static String callID;
        public static String autoFacility;
        public static String manualFacility;
        public static String autoSpotId;
        public static String numberOfSpecialEquipment;
        public static int totalnumberOfSpecialEquipment;
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: activeManualSpot
     * description :: activeManualSpot
     * date :: 11-01-2018
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void activeManualSpot(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "activeManualSpot", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("activeManualSpot", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("2202: TS-CR Manual Spot "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                CommonLib common =new CommonLib();
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
                        home.messageDialogBoxClose();
		                member.memberNumClick();
						locations.breakdownLocTabSel();
						//Entering Breadk down location and Vehicle details in omni search bar
						locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
						locations.getLatitudeValue();
						locations.getLongitudeValue();
						common.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("vehicleType"),data.get("ProblemTriage"),data.get("ProblemType"));
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
		                services.clickOnServiceTab();
		                //GETTING AUTO SPOT FACILITY ID at ABOVE THE OMINISEARCH BAR
		                String autoFacilityIDAboveOminiBar=services.getFacilityIDInServicesTab();
		                //GETTING AUTO FACILITY ID FROM SPOTTED FACILITY SECTION
		                String autoFacilityIDUnderTheSpottedFacility= services.getFacilityIDFromSpottedFacility();
		                //COMPARING BOTH ABOVE OMNI SEARCH AND SPOTTEDfACILITY SECTION
		                assertTrue(autoFacilityIDAboveOminiBar.equalsIgnoreCase(autoFacilityIDUnderTheSpottedFacility),"<b>Facility id above the Omini search:: "+autoFacilityIDAboveOminiBar +"  ::And Facility id under spotted Facility:  "+autoFacilityIDUnderTheSpottedFacility+"  are same</b>");
						//ENTERING MANUAL FACILITY
		                String facilityNumber=services.enterManualFacilityNumber(data.get("facilityNumber"));
		                services.clickOnSpotInServicePage();
		                vehicle.scriptErrorHandle();
		                //CHECKING MANUAL FACILITY CODE FROM BOTH OMNI SEARCH AND SPOTTED FACILITY
						String manualFacilityIDAboveOminiBar=services.getFacilityIDInServicesTab();
						String manualFacilityIDUnderTheSpottedFacility= services.getFacilityIDFromSpottedFacility();
						//COMPARING BOTH VALUES
						assertTrue(facilityNumber.contains(manualFacilityIDAboveOminiBar),"<b>Both manual Facility "+facilityNumber+"  and Manual Spotted facility:: "+manualFacilityIDAboveOminiBar+" are Same</b>");
						assertTrue(manualFacilityIDAboveOminiBar.equalsIgnoreCase(manualFacilityIDUnderTheSpottedFacility),"<b>Facility id above the Omini search:: "+manualFacilityIDAboveOminiBar +" ::And Facility id under spotted Facility::  "+manualFacilityIDUnderTheSpottedFacility+"  are same</b>");
		                vehicle.scriptErrorHandle();
		                //COMPARING BOTH MANUAL SPOTTED AND AUTOSPOTTED VALUES
		                assertTrue(autoFacilityIDAboveOminiBar!=manualFacilityIDAboveOminiBar,"<b>Manual Facility::  "+manualFacilityIDAboveOminiBar+ "<b> ::and Auto facility:: </b>"+autoFacilityIDAboveOminiBar+"<b> ::both are DIFFERENT and call is spotted regardless of business rule</b>");
		                home.leaveButton();
		                home.clickOnConfirmationAlert();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","2202",ReportStatus.strMethodName,intCounter,browser);
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
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: inActiveManualSpot
     * description :: inActiveManualSpot
     * date :: 11-01-2018
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void inActiveManualSpot(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "inactiveManualSpot", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("inactiveManualSpot", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("2202: TS-CR Manual Spot "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                CommonLib common = new CommonLib();
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
                        home.messageDialogBoxClose();
		                member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        locations.getLatitudeValue();
                        locations.getLongitudeValue();
                        common.crVehicleTriageTab(data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("vehicleType"),data.get("ProblemTriage"),data.get("ProblemType"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();
                        services.clickOnServiceTab();
                          //GETTING AUTO SPOT FACILITY ID at ABOVE THE OMINISEARCH BAR
                        String autoFacilityIDAboveOminiBar=services.getFacilityIDInServicesTab();
                        //GETTING AUTO FACILITY ID FROM SPOTTED FACILITY SECTION
                        String autoFacilityIDUnderTheSpottedFacility= services.getFacilityIDFromSpottedFacility();
                        //COMPARING BOTH ABOVE OMNI SEARCH AND SPOTTEDfACILITY SECTION
                        assertTrue(autoFacilityIDAboveOminiBar.equalsIgnoreCase(autoFacilityIDUnderTheSpottedFacility),"<b>Facility id above the Omini search:: "+autoFacilityIDAboveOminiBar +"  ::And Facility id under spotted Facility"+autoFacilityIDUnderTheSpottedFacility+"  are same</b>");
		                services.enterManualFacilityNumber(data.get("facilityNumber"));
		                services.clickOnSpotInServicePage();
		               String errorMessage= services.getInactiveFacilityErrorMessage(data.get("inactiveErrorMesage"));
		                reporter.SuccessReport("Inactive error Message","<b>Inactive error Message::"+errorMessage+" </b>");
		                home.allErrorAlerts();
		                home.leaveButton();
		                home.clickOnConfirmationAlert();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","2202",ReportStatus.strMethodName,intCounter,browser);
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
