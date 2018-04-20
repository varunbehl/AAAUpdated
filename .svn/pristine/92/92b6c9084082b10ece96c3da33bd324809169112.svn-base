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

public class TC_CRManualEnterMembershipSave extends ActionEngine {
    String callId;
    String callsAllowedBeforeMemberCall;
    String callsAllowedAfterMemberCall;
    int callsRemaining;

	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	String Member = "";
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void memberFieldsSaveByManualEntry(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MemberFieldsSave", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MemberFieldsSave", TestData, "D3CallRecieving",intCounter);

		                this.reporter.initTestCaseDescription("1936:Manual Enter Membership Save"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					Thread.sleep(5000);
					login.login(data.get("LoginName"),data.get("Password"));
					home.messageDialogBoxClose();


					if(data.get("MemberFromDBORWrongMember").equalsIgnoreCase("NO")) {

						/* Below steps used Inorder to get entitlement count before creating call By Manual Entry
						 * These steps are required to verify 7th step  :: Entitlements Count -- Verify the call was counted against the member as an entitlement
						 * This is for 1st Iteration of test Data (Existing Member from DB)
						 * */
						if (data.get("Member").equals("db")) {
							//fetch member details from db
							//generating a random number everytime to fetch a new record everytime
							int rownum = IntRandomNumberGenerator(50, 1000);
							//member from db
							Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
							System.out.println("member : " + Member);
						}
						if (Member.isEmpty()) {
							Member = data.get("Membersearch");
						}
						home.memberSearchTextBox(Member);
						member.memberNumClick();


						callsAllowedBeforeMemberCall = member.memberCallsRemainingInMemberDetailsSection();
						System.out.println("callsAllowedBeforeMemberCall" + callsAllowedBeforeMemberCall);

						callsRemaining = Integer.parseInt(callsAllowedBeforeMemberCall);

						if (callsRemaining > 0) {
							/*Actual Tests Steps are Started From Here */
							//Verification Of Manual entry Link
							boolean manualEntryLink = member.verifyManualEntryLink();
							assertTrue(manualEntryLink, "<b>Verified the Manual Entry link on the bottom of the page after LogIn in to CallReceiving</b>");
							Thread.sleep(4000);
							member.clickOnManualEntryLinkInMember();
							boolean manualEntryFields = member.verifyManualEntryFields();
							assertTrue(manualEntryFields, "<b>Verified all Fields For manual Entry </b>");
							Thread.sleep(5000);

							//enter mandatory fields on member Tab
							member.enterMemberMandatoryFields(data.get("FirstName"), data.get("LastName"), data.get("Address"), data.get("City"),
									data.get("State"), data.get("Zip"), data.get("Email"), data.get("PhoneNumber"),
									data.get("PhoneType"), Member,
									data.get("MemberLevel"), data.get("Expiration"), data.get("Status"));
							createCallByEnterFieldsManually(data);
							//Load the call with same member number
							home.memberSearchTextBox(Member);
							member.ClickonMemberNumberLink();
							home.waitCloseAllBusyIconsResults();
							//Verify the created call once member loads
							boolean loadedCallFlag = member.verifyTheCreatedCallOnceMemberLoads(callId);
							assertTrue(loadedCallFlag, "<b>verified the call after membership loads, Found a record for the created call  </b>" + callId + "<b> on the page</b>");
							member.closeTheLoadedCall();
							home.waitCloseAllBusyIconsResults();
							callsAllowedAfterMemberCall = member.memberCallsRemainingInMemberDetailsSection();

							boolean entitlementCountFlag = member.veryfyCallCountForMemberAsEntitleMent(callsAllowedBeforeMemberCall, callsAllowedAfterMemberCall);
							assertTrue(entitlementCountFlag, "<b>Verified the call ,Call was counted against the member as an entitlement </b>");
						}
						else
						{
							//Sometimes DB query is returning the wrong dat. If the entitlements are not available, test will fail for wrong data
							assertFalse(callsRemaining == 0,"<b>Member Should have Entitlements greater than 0 for this test case,Test should pass If the member have Entitlement count greater than 0 .</b>");
						}
					}
					//This is to verify for member who is not available in DB
					else {
						//Verification Of Manual entry Link with memberNumber That is not in DB
						boolean manualEntryLink = member.verifyManualEntryLink();
						assertTrue(manualEntryLink, "<b>Verified the Manual Entry link on the bottom of the page after LogIn In to CallReceving</b>");
						Thread.sleep(4000);
						member.clickOnManualEntryLinkInMember();
						boolean manualEntryFields = member.verifyManualEntryFields();
						assertTrue(manualEntryFields, "<b>Verified all Fields For manual Entry </b>");
						Thread.sleep(5000);
							member.enterMemberMandatoryFields(data.get("FirstName"), data.get("LastName"), data.get("Address"), data.get("City"),
									data.get("State"), data.get("Zip"), data.get("Email"), data.get("PhoneNumber"),
									data.get("PhoneType"), data.get("Membersearch_wrongId"),
									data.get("MemberLevel"), data.get("Expiration"), data.get("Status"));
							createCallByEnterFieldsManually(data);
						home.clickOnSearchCallDroupDown();
						home.clickOnSearchCallsLink();
						home.enterCallIdForSearch(callId);
						home.clickOnSearchButtonOnSearchCalls();
						String callidFronSearchCalls = member.verifyTheCreatedCall();
						//Below assert confirms that the call is created and returned in search calls
						assertTrue(callidFronSearchCalls.equals(callId), "<b>verified the call  loads, && Able to save a manual entry call with a membership number that is not in the database</b>");
						member.closeSearchCallsWindow();

						}

						home.logout();
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

    public void createCallByEnterFieldsManually(Hashtable < String, String > data)throws  Throwable{

		location.clickOnLocationTab();
		Thread.sleep(4000);
		location.clickOnManualEntryLinkInLocation();
		location.enterAndSaveLocationMandatoryFields(data.get("BKDownStreetAddress"), data.get("BKDownCityLocation"), data.get("BKDownState"), data.get("BKDownLocCode"));
		vehicle.clickOnVehicleTriageTab();
		Thread.sleep(4000);
		vehicle.clickOnManualEntryLinkOnVehicle();
		vehicle.enterandSaveVehicleMandatoryFields(data.get("VehicleType"),data.get("VehicleYear"),data.get("VehicleMake"),data.get("VehicleModel"),data.get("VehicleColor"),data.get("PaceSettercode"));
		vehicle.handleScriptErrorInVehicleTriagePage();
		towdestination.clickOnTowDestinationTab();
		login.waitcloseAllBusyIconsResults();
		acceptAlert();
		vehicle.handleScriptErrorInVehicleTriagePage();
		home.allErrorAlerts();
		Thread.sleep(4000);
		towdestination.clickOnManualEntryLinkOnTowDestination();
		towdestination.enterTowDestinationMandatoryFields(data.get("TowPassengers"));
		service.clickOnServiceTab();
		service.enterManualSpotDetails(data.get("Facility"));
		home.waitCloseAllBusyIconsResults();
		Thread.sleep(3000);
		home.saveButton();
		home.waitCloseAllBusyIconsResults();
		home.allErrorAlerts();
		Thread.sleep(2000);
		callId = service.getCallId();
		service.closeCallWindow();
		home.waitCloseAllBusyIconsResults();
	}
}



