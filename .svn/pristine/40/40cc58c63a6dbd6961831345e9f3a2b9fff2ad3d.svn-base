package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.LoginLib;
import com.aaa.web.lib.LoginRoleLib;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRLoginScript extends LoginLib {

	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithValidUserNameAndInvalidPassword
     * description :: valdUsernamewithInvalidPassword
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void CRDiffrentUserLoginErrorMessages(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRDiffrentUserLoginErrorMessages", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest(); 
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CRDiffrentUserLoginErrorMessages", TestData, "D3CallRecieving",intCounter);
    					this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" For:: "+data.get("LoginName")+" ::and:: "+data.get("Password")+" To Validate::"+data.get("errorMessage") +"  **************");
					CRHomeLib home = new CRHomeLib();
					home.verifyandClickLogout();
					String errorMessage=loginValidation(data.get("LoginName"),data.get("Password"));
					assertTrue(errorMessage.contains(data.get("error")),"Invalid credentials For Following Reason :: "+errorMessage);
					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: loginWithInactiveUser
     * description :: Validation for inactive user details
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void loginWithInactiveUser(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "loginWithInactiveUser", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("loginWithInactiveUser", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					loginValidation(data.get("LoginName"),data.get("Password"));
					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: sucessLogin
     * description :: successful login functionality
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void successLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SuccessLogin", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SuccessLogin", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" For:: "+data.get("LoginName")+" ::and:: "+data.get("Password")+"   **************");
					CRHomeLib home = new CRHomeLib();
					home.verifyandClickLogout();
					login(data.get("LoginName"),data.get("Password"));
					home.messageDialogBoxClose();
					home.logout();
                /*home.allErrorAlerts();*/
					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: sucessLogin
     * description :: successful login functionality
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void changePassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "Changepassword", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("Changepassword", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					CRHomeLib home = new CRHomeLib();
					home.verifyandClickLogout();
					enterUserName(data.get("LoginName"));
					enterPassword(data.get("Password"));
					changePasswordButton();
					verifyChangePassword(data.get("NewPassword"),data.get("Confirm password"),data.get("PasswordChangeAlert"));
					home.allErrorAlerts();
					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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

    public void sessionTest(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"SessionTest", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SessionTest", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					CRHomeLib home = new CRHomeLib();
					home.verifyandClickLogout();
					sessionInNewTabverification(data.get("LoginName"),data.get("Password"));
					home.messageDialogBoxClose();
					home.sessionInNewTab();
					home.messageDialogBoxClose();
					acceptAlert();
					home.verifyandClickLogout();
                    fnCloseTest();
					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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

    public void SelectRole(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SelectRole", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SelectRole", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					CRHomeLib home = new CRHomeLib();
					LoginRoleLib role = new LoginRoleLib();
					home.verifyandClickLogout();
					login(data.get("LoginName"),data.get("Password"));
					//Validating expected and actual roles
                    boolean rolesMatched=role.validateRolesList(data.get("selectRole"));
                    assertTrue(rolesMatched, "Expected List  ::and Actual List:: Both are same");

                    role.getLocaitonList();
					//Selecting the role
                    role.roleSelection(data.get("Role"));
					home.verifyHomeScreen();
					//getting logged in role
                    home.clickOnUsersUnderHelpmenu();
                    String loggedInRole=home.getUserRoleFromUserPopup();
                    home.clickOnCloseButtonInUserInfoPopup();
                    //String loggedInRole=home.getLoggedInUserRole();
                    assertTrue(loggedInRole.contains(data.get("roleSelected"))," ::Selected user role is:: "+data.get("Role")+" ::User is logged in with selected role:: "+loggedInRole);
                    home.logout();

					System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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

    public void maxPasswordAttempts(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"MAX_PSWD_TRIES", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MAX_PSWD_TRIES", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1895:CR Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					CRHomeLib home = new CRHomeLib();
					home.verifyandClickLogout();
					mulipleLoginAttemps(data.get("LoginName"),data.get("Password"),data.get("attempts"));
					System.out.println("Test Completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1895",ReportStatus.strMethodName,intCounter,browser);
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
