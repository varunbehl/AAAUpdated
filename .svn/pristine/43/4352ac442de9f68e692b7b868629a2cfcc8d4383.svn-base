package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CRMemberSearchLib;
import com.aaa.web.lib.CommonDb;
import com.aaa.web.lib.LoginLib;
import com.aaa.web.lib.LoginRoleLib;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E001133 on 27-11-2017.
 */

public class TC_CRLocalMemberLookup extends CRMemberSearchLib {
	CRHomeLib home = new CRHomeLib();
	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();


	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: membnumSearch
	 * description :: This is to validate login functionality with difference combinations
	 * date :: 05-Dec-2017
	 * author :: Chandu Dendukuri
	 */


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void membnumSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "memnumSearch", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("memnumSearch", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");


					navigateToApplication("CR");
					home.verifyandClickLogout();
					login.login(data.get("LoginName"), data.get("Password"));
					home.verifyHomeScreen();
					home.memberSearchTextBox(data.get("Membersearch"));
					memberNumberCol(data.get("Membersearch"));
					home.leaveButton();
					home.allErrorAlerts();

					home.memberSearchTextBox(data.get("MembersearchInvalid"));
					member.emptySearchResults();

					home.logout();
					System.out.println("Test completed");

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR", "1600", ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: membemailSearch
	 * description :: This is to validate login functionality with difference combinations
	 * date :: 05-Dec-2017
	 * author :: Chandu Dendukuri
	 */


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void memberEmailSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "memberEmailSearch", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("memberEmailSearch", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					navigateToApplication("CR");
					home.verifyandClickLogout();
					login.login(data.get("LoginName"), data.get("Password"));
					home.verifyHomeScreen();
					home.memberSearchTextBox(data.get("Membersearch"));
					verifyMemberEmailCol(data.get("Membersearch"));
					home.leaveButton();
					home.allErrorAlerts();

					home.memberSearchTextBox(data.get("MembersearchInvalid"));
					member.emptySearchResults();
					//Error Scenario
					home.logout();
					System.out.println("Test completed");

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR", "1600", ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: membnameSearch
	 * description :: This is to validate login functionality with difference combinations
	 * date :: 05-Dec-2017
	 * author :: Chandu Dendukuri
	 */


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()
	public void memnamesearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "memnamesearch", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("memnamesearch", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

					navigateToApplication("CR");
					home.verifyandClickLogout();
					login.login(data.get("LoginName"), data.get("Password"));
					home.verifyHomeScreen();
					//home.messageDialogBoxClose();
					home.memberSearchTextBox(data.get("Membersearch"));
					memberNameCol(data.get("Membersearch"));
					home.leaveButton();
					home.allErrorAlerts();

					home.memberSearchTextBox(data.get("MembersearchInvalid"));
					member.emptySearchResults();

					home.logout();
					System.out.println("Test completed");



				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR", "1600", ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: nineDigitMemberSearch
	 * description :: This is to validate login functionality with difference combinations
	 * date :: 05-Dec-2017
	 * author :: Chandu Dendukuri
	 */


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()

	public void nineDigitMemberSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "nineDigitMemberSearch", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("nineDigitMemberSearch", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");


					navigateToApplication("CR");
					home.verifyandClickLogout();
					login.login(data.get("LoginName"), data.get("Password"));
					home.verifyHomeScreen();
					//home.messageDialogBoxClose();
					home.memberSearchTextBox(data.get("Membersearch"));
					emptySearchResults();
					home.leaveButton();
					home.allErrorAlerts();
					home.logout();
					System.out.println("Test completed");
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR", "1600", ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: membnameaddressSearch
	 * description :: This is to validate login functionality with difference combinations
	 * date :: 05-Dec-2017
	 * author :: Chandu Dendukuri
	 */


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()

	public void memnameaddressSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "memnameaddressSearch", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("memnameaddressSearch", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");


					navigateToApplication("CR");
					home.verifyandClickLogout();
					login.login(data.get("LoginName"), data.get("Password"));
					home.verifyHomeScreen();
					//home.messageDialogBoxClose();
					home.memberSearchTextBox(data.get("Membersearch"));
					membernameaddressCol(data.get("Membersearch"));
					home.leaveButton();
					home.allErrorAlerts();
					home.logout();
					System.out.println("Test completed");

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR", "1600", ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	/**
	 * param :: Hashtable with string inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: membPhoneSearch
	 * description :: This is to validate login functionality with difference combinations
	 * date :: 05-Dec-2017
	 * author :: Chandu Dendukuri
	 */


	@Parameters({"StartRow", "EndRow", "nextTestJoin"})
	@Test()

	public void memphoneSearch(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "memphoneSearch", TestData, "D3CallRecieving");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("memphoneSearch", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup" + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");


					navigateToApplication("CR");
					home.verifyandClickLogout();
					login.login(data.get("LoginName"), data.get("Password"));
					home.verifyHomeScreen();
					//home.messageDialogBoxClose();
					home.memberSearchTextBox(data.get("Membersearch"));
					verifyMemberPhoneCol(data.get("Membersearch"));
					home.leaveButton();
					home.allErrorAlerts();
					home.logout();
					System.out.println("Test completed");

				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("CR", "1600", ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

}

    /* *//**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: HistorySearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 07-Dec-2017
     * author :: Chandu Dendukuri
     *//*
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void historySearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "memHistorySearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("memHistorySearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1600:CR_LocalMember_Lookup"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                LoginRoleLib role = new LoginRoleLib();
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                //home.messageDialogBoxClose();
		                //role.RoleSelection(data);
		                home.workFlowSelectionForHistory();
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
		                member.memberNumClick();
		                //emptySearchResults();
		                member.clickOnManualEntryLinkInMember();
		                //home.clickOnManualEntryLink("member");
		                //memberNumberValidation();
		
		           *//* memberPhoneCol(data);*//*
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
		                System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1600",ReportStatus.strMethodName,intCounter,browser);
    			fnCloseTest();
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }*/
