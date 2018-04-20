package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRServicePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRPhoneTempDelete extends LoginLib {


	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void memberContactInfoSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "phoneTempDelete",TestData,"D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {

					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("phoneTempDelete",TestData,"D3CallRecieving",intCounter);

					this.reporter.initTestCaseDescription("1905:phoneTempDelete"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

					//Creating objects
					CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib crLocationsLib=new CRLocationsLib();
					CRVehicleTriageLib crVehicletriageLib=new CRVehicleTriageLib();
					CRServiceLib crServiceLib =new CRServiceLib();

					navigateToApplication("CR");
					home.verifyandClickLogout();
					login(data.get("LoginName"),data.get("Password"));
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

					//Searching Member number
					home.memberSearchTextBox(Member);
					member.memberNumClick();
					String phonenumber = member.getPhoneNumberFirstRecord();
					assertTrue(!phonenumber.isEmpty(),"Phone number available in Member Contact Information Section"+phonenumber);


					//Check delete check box , click on Add Phone button , Enter new phone number , click on temp check box and click on prim radio btn
					member.tempDelete(data.get("PhoneNumber"));


					//Entering the breakdown location
					crLocationsLib.breakdownLocTabSel();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));

					//enter vehicle information
					crVehicletriageLib.vehicletriageTabsel();
					crVehicletriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
					crVehicletriageLib.clickOnFuel();
					crVehicletriageLib.clickOnOutOfGas();
					crVehicletriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicletriageLib.scriptErrorHandle();
					Thread.sleep(3000);

					//Saving the call and validating the call id is not null in getCallId method
					home.saveButton();
					crServiceLib.closeCall();
					home.memberSearchTextBox(data.get("Membersearch"));
					member.memberNumClick();

					//Validating phone number deletion
					member.verifyPhoneNumberDeleted(phonenumber,data.get("NewPhoneNumber"));

					//Logout
					home.logout();
					System.out.println("Test completed");
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR","1905",ReportStatus.strMethodName,intCounter,browser);

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