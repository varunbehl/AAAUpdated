package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






import java.util.Hashtable;

public class TC_CRERSBattery extends LoginLib
{
	String callId;
	//declarations
	CRVehicleTriageLib vehicle=new CRVehicleTriageLib();
	CRServiceLib service=new CRServiceLib();
	CRMemberSearchLib member=new CRMemberSearchLib();
	CRLocationsLib location=new CRLocationsLib();
	CRHomeLib home = new CRHomeLib();
	LoginRoleLib role = new LoginRoleLib();
	DIHomeLib dihome = new DIHomeLib();
	DISearchCallsLib disearch = new DISearchCallsLib();
	CRHomeLib crhome = new CRHomeLib();
	DIMCDLib mcd = new DIMCDLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ERSBatteryJumpStart(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ERSBatteryJumpStart", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ERSBatteryJumpStart", TestData, "D3CallRecieving",intCounter);
    	
		                TestEngineWeb.reporter.initTestCaseDescription("1605:TC_CR ERS Battery"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						//enter membership details
						enterMembershipDetailsandVehicleDetails(data);
						//select problem
						vehicle.selectJumpStartFromBattery();
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.scriptErrorHandle();
						//validate pacesettercode
						String pacesettercode = vehicle.GetSelectedPaceSetterCode();
						assertTrue(pacesettercode.contains("Jump Start"), "<b>Call receives the Pacesetter code L301 No Crank - Jump Start</b>"+" "+pacesettercode);
						//validate auto spot and call is saved
						service.validateFacilityAutospot();
						service.clickOnSaveBtn();
						callId = service.getCallId();
						assertTrue(!callId.equalsIgnoreCase(null), "<b>Call is saved successfully</b>");
						service.closeCallWindow();
						crhome.logout();

						//dispatch verification for selected paceseter is listed
						navigateToApplication("DI");
						enterLoginDetails(data.get("DILoginName"), data.get("DIPassword"));
						role.selectRoleAndProceed(dataBean.getValue(data, "RoleinDispatch"));
						dihome.clickOnContinueQueuesInDispatch();
						dihome.clickOnSearchCallsInDispatch();
						disearch.searchAndSelectCallID(callId);
						Thread.sleep(3000);
						String txt=mcd.getPacesetterLabelInMCD();
						assertTrue(txt.contains("Jump Start"),"Service type on a battery call is listed as Battery"+txt);
						dihome.logOut();

					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
    			}
    			ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
    			ReportStatus.fnUpdateResultStatus("CR","1605",ReportStatus.strMethodName,intCounter,browser);
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
    
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ERSBatteryTruck(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ERSBatteryTruck", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ERSBatteryTruck", TestData, "D3CallRecieving",intCounter);
    	
		                TestEngineWeb.reporter.initTestCaseDescription("1605:TC_CR ERS Battery"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

						enterMembershipDetailsandVehicleDetails(data);
						Thread.sleep(3000);
						vehicle.enterPacesetterCodeBattery(dataBean.getValue(data,"Pacesettercode"));
						Thread.sleep(5000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.scriptErrorHandle();
						//validate pacesettercode
						String pacesettercode = vehicle.GetSelectedPaceSetterCode();
						assertTrue(pacesettercode.contains("Battery"), "<b>Call receives the Pacesetter code L302 No Crank - Bat Svc (non-AAA Bat)</b>"+" "+pacesettercode);
						service.validateFacilityAutospot();
						service.clickOnSaveBtn();
						callId = service.getCallId();
						assertTrue(!callId.equalsIgnoreCase(null), "<b>Call is saved successfully</b>");
						service.closeCallWindow();
						crhome.logout();

						//dispatch verification for selected paceseter is listed
						navigateToApplication("DI");
						enterLoginDetails(data.get("DILoginName"), data.get("DIPassword"));
						role.selectRoleAndProceed(dataBean.getValue(data, "RoleinDispatch"));
						dihome.clickOnContinueQueuesInDispatch();
						dihome.clickOnSearchCallsInDispatch();
						disearch.searchAndSelectCallID(callId);
						Thread.sleep(3000);
						String txt=mcd.getPacesetterLabelInMCD();
						assertTrue(txt.contains("Battery"),"Service type on a battery call is listed as Battery"+txt);
						dihome.logOut();
						System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
    			}
    			ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
    			ReportStatus.fnUpdateResultStatus("CR","1605",ReportStatus.strMethodName,intCounter,browser);
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



	public void enterMembershipDetailsandVehicleDetails(Hashtable<String, String> data) throws Throwable {

		home.verifyandClickLogout();
		//launch application
		navigateToApplication("CR");
		//login to Application
		login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		home.verifyHomeScreen();
		//enter and search member
		String Member = "";
		if (data.get("Member").equals("db")){
			//fetch member details from db
			//generating a random number everytime to fetch a new record everytime
			int rownum = IntRandomNumberGenerator(50,1000);
			//member from db
			Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
			System.out.println("member : "+Member);
		}
		if (Member.isEmpty())
		{
			Member = data.get("Membersearch");
		}
		home.memberSearchTextBox(Member);
		//home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		//search and close alert member
		member.memberNumClick();
		//Enter primary phone number
		member.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "Primaryphonenum"));
		//enter prime phone type cellular
		member.membContInfoEnterPrimPhoneTypeCellular();
		//enter prime phone radio button
		member.clickPrimRadioBtnRowOne();
		//enter breakdown location
		location.breakdownLocTabSel();
		location.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		//enter vehicle information
		vehicle.vehicletriageTabsel();
		String VehicleDet[] = data.get("Vehiclemodel").split("#");
		vehicle.enterVehicleSearch(VehicleDet[0]);
		vehicle.clickOnTheVehicleSearchIcon();
		vehicle.clickOnTheVehicleSearch();
		vehicle.vehicleColor(VehicleDet[1]);
	}

}