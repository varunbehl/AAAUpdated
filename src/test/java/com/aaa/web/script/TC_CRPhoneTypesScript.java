
package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRPhoneTypesScript extends CRHomeLib{
    String callId;
    String spotID;
    String callDate;
    String callIDAndDateCombined;

   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void phoneTypeverification(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "validatePhoneTypes", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
						ReportStatus.fnDefaultReportStatus();
						ReportControl.intRowCount = intCounter;
						Hashtable<String, String> data = TestUtil.getDataByRowNo("validatePhoneTypes", TestData, "D3CallRecieving", intCounter);

						this.reporter.initTestCaseDescription("2247:CR Phone Types" + " From Iteration " + StartRow + " to " + EndRow);
						reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
						LoginLib login = new LoginLib();
						CRHomeLib crhome = new CRHomeLib();
						DIHomeLib dihome = new DIHomeLib();
						LoginRoleLib loginrole = new LoginRoleLib();
						CRMemberSearchLib member = new CRMemberSearchLib();
						CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
						CRLocationsLib location = new CRLocationsLib();
						CRTowDestinationLib tow = new CRTowDestinationLib();
						CRServiceLib service = new CRServiceLib();
						DIMCDLib dimcdLib = new DIMCDLib();
						CommonLib commonLib = new CommonLib();
						navigateToApplication("CR");
						login.login(dataBean.getValue(data, "LoginName"), dataBean.getValue(data, "Password"));
						crhome.verifyHomeScreen();
						String Member = "";
						if (data.get("Member").equals("db")) {
							//fetch member details from db
							//generating a random number everytime to fetch a new record everytime
							int rownum = IntRandomNumberGenerator(50, 1000);
							//member from db
							Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
							System.out.println("member : " + Member);
						} else {
							Member = data.get("Membersearch");
						}

						crhome.memberSearchTextBox(Member);
						member.memberNumClick();
						member.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "Primaryphonenum"));
						String phoneTypeInMemberSearch = member.selectPhoneType(data.get("PhoneType"));
						member.clickPrimRadioBtnRowOne();
						//Verify Information on Screen
						assertTrue(phoneTypeInMemberSearch.contains(data.get("PhoneType")), "<b>Verified Information On Screen & Selected PhoneType is </b> " + phoneTypeInMemberSearch);
						Thread.sleep(5000);
						String phoneNumber = member.getPhoneNumberFromCallerInfo();
						Thread.sleep(2000);
						assertTrue(phoneNumber != null, "<b>Verified Information On Screen & Phone Number is  </b>" + phoneNumber);

						//entering breakdown location
						location.breakdownLocTabSel();
						location.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
						commonLib.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), "",data.get("ProblemTriage"), data.get("ProblemType"));
						vehicle.handleScriptErrorInVehicleTriagePage();
						crhome.allErrorAlerts();
						service.clickOnServiceTab();
						service.enterManualSpotDetails(data.get("Facility"));

						crhome.saveButton();
						crhome.waitCloseAllBusyIconsResults();
						crhome.allErrorAlerts();
						callId = service.getCallId();
						service.closeCall();
						Thread.sleep(4000);
						crhome.logout();


						//Login In to DI Dispatch
						commonLib.loginToDIAndClickOnSearchCalls(data.get("DILoginName"), data.get("DIPassword"),"NO");
						dihome.searchAndSelectCallIDInDI(callId);
						crhome.waitCloseAllBusyIconsResults();
						Thread.sleep(5000);
						dimcdLib.clickOnMemberTabInMCDWindow();

						//For No Phone Type and TDD the element should not be displayed and for others the Type should match
						if(phoneTypeInMemberSearch.equalsIgnoreCase("No Phone") || (phoneTypeInMemberSearch.equalsIgnoreCase("TDD")))
						{
							boolean inVisibilityOfPhoneType = dihome.verifyPhoneTypeOnDIMCDForTDDAndNoPhoneTypes();
							assertTrue(inVisibilityOfPhoneType, "<b>Verified the phone Type on Dispatch MCD Window , PhoneType is not visible for   </b>"+phoneTypeInMemberSearch);
						} else {
							String phoneTypeONMCD = dihome.verifyPhoneTypeOnDIMCD();
							assertTrue(phoneTypeONMCD.contains(phoneTypeInMemberSearch), "<b>Verified the PhoneType on Dispatch MCD Window ,displayed  Phone Type Is matched with selected phone type In CallReceiving :Phone Type is   </b> " + phoneTypeONMCD);
						}

						//LogOut DI Application
						crhome.logout();


						//Navigate To SPP and Login With SPP Login Credentials
						commonLib.loginToDIAndClickOnSearchCalls(data.get("sppLogin"), data.get("sppPassword"),"Yes");
						dihome.searchAndSelectCallIDInDI(callId);
						crhome.waitCloseAllBusyIconsResults();
						Thread.sleep(5000);
						dimcdLib.clickOnMemberTabInMCDWindow();

						if(phoneTypeInMemberSearch.equalsIgnoreCase("No Phone") || (phoneTypeInMemberSearch.equalsIgnoreCase("TDD")))
						{
							boolean inVisibilityOfPhoneType = dihome.verifyPhoneTypeOnDIMCDForTDDAndNoPhoneTypes();
							assertTrue(inVisibilityOfPhoneType, "<b>Verified the PhoneType on SPPDispatch MCD Window , PhoneType is not visible for   </b>"+phoneTypeInMemberSearch);
						} else {
							String phoneTypeONSPPMCD = dihome.verifyPhoneTypeOnDIMCD();
							assertTrue(phoneTypeONSPPMCD.contains(phoneTypeInMemberSearch), "<b>Verified the PhoneType on SPPDispatch MCD Window ,displayed  Phone Type Is matched with selected phone type In CallReceiving :Phone Type is    </b>" + phoneTypeONSPPMCD);
						}


						crhome.logout();
						System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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

