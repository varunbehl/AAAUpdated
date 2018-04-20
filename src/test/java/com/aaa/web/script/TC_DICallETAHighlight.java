/*
package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_DICallETAHighlight extends ActionEngine {
	
	CRHomeLib home = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRMemberSearchLib memeber = new CRMemberSearchLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    DIHomeLib diHome = new DIHomeLib();
    DILoginLib diLogin = new DILoginLib();
    DIMCDLib mcdlib = new DIMCDLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole=new LoginRoleLib();
    DISearchCallsLib searchCall=new DISearchCallsLib();
    DIMCDLib dimcd=new DIMCDLib();
    LoginLib login = new LoginLib();
    
    public static List<String> callId=new ArrayList<>();
    public static String onLocationStatus;
    public static String call;
    public static String lblEtavTime;
    public static int iteration=0;
    public static String initialColor;
    public static String colorChange;
    
    
    @DataProvider
    public Object[][] getTestDataFor_DICallETAHighlight() {
        return TestUtil.getData("ETAHighlight", TestData, "DICallETAHighlight");
    }

    @Test(dataProvider = "getTestDataFor_DICallETAHighlight")
    public void createCallForETA(Hashtable<String, String> data) throws Throwable { 
            	  try {
            	        if (data.get("RunMode").equals("Y")) {
            	            this.reporter.initTestCaseDescription("1906:TC-DICallETAHighlight");
            	            // Logging into the application
            	            navigateToApplication("CR");
            	            login.login(data.get("CRLoginName"), data.get("CRPassword"));
            	            Thread.sleep(5000);
            	            home.allErrorAlertsNoButton();
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
            	            if(Member.isEmpty())
            	            {
            	                Member = data.get("MemberNumber");
            	            }
            	            home.memberSearchTextBox(Member);
            	            memeber.memberNumClick();
            	          //memeber.currentCallClose();
            	            memeber.ClickPrimRadioBtnInRowTwo();
            	            // Locations Page Starts
            	            crLocationsLib.clickOnLocationTab();
            	            //Entering Location Details
            	            crLocationsLib.clickOnLocationTab();
            	            crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
            	            
            	            Thread.sleep(3000);
            	            //locations.clickOnSecondKownBrkDowLocation();
            	            Thread.sleep(3000);
            	            // Vehicle Triage Page Starts here
            	            crVehicleTriageLib.clickOnVehicleTriageTab();
            	            String VehicleDet[] = data.get("Vehiclemodel").split("#");
            	            crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
            	            crVehicleTriageLib.clickOnTheVehicleSearchIcon();
            	            crVehicleTriageLib.clickOnTheVehicleSearch();
            	            crVehicleTriageLib.vehicleColor(VehicleDet[1]);
            	            crVehicleTriageLib.clickonProblemTypeButton(data.get("TriageType"));
            	            Thread.sleep(2000);
            	            crVehicleTriageLib.clickonProblemTypeOptions(data.get("TriageOption"));
            	            crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
            	            crServiceLib.clickOnServiceTab();
            	            home.waitCloseAllBusyIconsResults();
            	            crServiceLib.enterManualSpotDetails(data.get("SPPFacilitySpot"));
            	            //crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
            	            home.saveButton();
            	            callId.add(crServiceLib.getCallId());
            	            crServiceLib.closeCall();
            	            home.logout();
            	        }
            	        }
            	     catch (Exception e) {
            	        e.printStackTrace();
            	        }
                        }
    
    
    
    
    @Test(dataProvider = "getTestDataFor_DICallETAHighlight")
    public void DICallETAHighlight(Hashtable<String, String> data) throws Throwable
    {
    	try {
	    if (data.get("RunMode").equals("Y")) {
	    this.reporter.initTestCaseDescription("1906:TC-DICallETAHighlight");
	    
	    //logging in DISpp
	    
    	navigateToApplication("DI");
        Thread.sleep(4000);
        diLogin.login(data.get("SPPDILoginName"), data.get("SPPDIPassword"));
        
        if (data.get("SPPDILoginName").contains("di")){
            loginRole.clickOnProceedBtnInDispatchRoleLogin();
            Thread.sleep(5000);
            diHome.clickOnCloseIconOnQueueSelection();
            }
        else
        {
            	mcdlib.closeFacilityPTAWindow();
            }
        
        crHomeLib.waitCloseAllBusyIconsResults();
        diHome.clickOnSearchCallsInDispatch();
        
        //Search calls entering call id and searching
        call=callId.get(iteration);
        diHome.enterCallIDInfo(call);
        searchCall.selectCallStatus(data.get("CallStatus"));        
        diHome.clickOnSearchInSearchCalls();
        crHomeLib.waitCloseAllBusyIconsResults();
        diHome.clickOnCallDateOrIDLink();
        crHomeLib.waitCloseAllBusyIconsResults();
        	
		dimcd.clickOnETAButtonOnMCDWindow();
		dimcd.setTimeForETAForTenMins();
		initialColor=dimcd.verifyETAvlblBackgroundColorInMCD();
        TimeUnit.MINUTES.sleep(5);
        mcdlib.ClickOnstillWorkingOnCallButton();
        Thread.sleep(1000);
        //lblEtavTime=dimcd.verifyETAvlblTimeInMCD();
        colorChange=dimcd.verifyETAvlblBackgroundColorInMCD();
        assertTrue(!colorChange.equals(initialColor), "ETA bakground color changed to Yellow");
        initialColor=colorChange;
        TimeUnit.MINUTES.sleep(5);
        mcdlib.ClickOnstillWorkingOnCallButton();
        Thread.sleep(10000);
        colorChange=dimcd.verifyETAvlblBackgroundColorInMCD();
        assertTrue(!colorChange.equals(initialColor), "ETA color changed to Red");
		Thread.sleep(3000);
        mcdlib.clickOnAssign();
        Thread.sleep(5000);
        mcdlib.selectSecondFacilityOnAssignTabInMCD();
        Thread.sleep(2000);
        mcdlib.selectDispatch();
        //Thread.sleep(2000);
		Thread.sleep(2000);
		initialColor = dimcd.verifyETAvlblBackgroundColorInMCD();
        assertTrue(!initialColor.equals(colorChange), "ETA background color changed to empty");
        mcdlib.selectOnLocation();
        Thread.sleep(2000);
        onLocationStatus = mcdlib.getCallStatusOnMCDwindow();
        mcdlib.clickOnMCDCloseWindow();
        diHome.logOut();
        acceptAlert();
        Thread.sleep(2000);
        acceptAlert();
        iteration++;
    }
    }
        catch (Exception e) {
	        e.printStackTrace();
	        }
}
}
*/
