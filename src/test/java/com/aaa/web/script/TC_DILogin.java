package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by E001133 on 27-11-2017.
 */
public class TC_DILogin extends DILoginLib {
	public org.openqa.selenium.WebDriver WebDriver = null;
	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithValidUserNameAndInvalidPassword
     * description :: valdUsernamewithInvalidPassword
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
	/************************************************************************
	* Script Name :-
	* Method Name :-
	* Module	  :- DI 
	* Test Case ID:-
	* Script Date :- 
	* Author      :- 
	* @param StartRow
	* @param EndRow
	* @param nextTestJoin
	* @throws Throwable
	*************************************************************************/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIDiffrentUserLoginErrorMessages(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIDiffrentUserLoginErrorMessages", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIDiffrentUserLoginErrorMessages", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1726:DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                //reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" For:: "+data.get("LoginName")+" ::and:: "+data.get("Password")+" To Validate::"+data.get("errorMessage") +"  **************");
		                navigateToApplication("DI");
		                DIHomeLib diHome = new DIHomeLib();
		                String errorMessage=loginValidation(data.get("LoginName"),data.get("Password"));
						assertTrue(errorMessage.contains(data.get("error")),"Invalid credentials For Following Reason :: "+errorMessage);
		                System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1726",ReportStatus.strMethodName,intCounter,browser);
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
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIloginWithInactiveUser(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIloginWithInactiveUser", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIloginWithInactiveUser", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1726:DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                loginValidation(data.get("LoginName"),data.get("Password"));
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
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
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIsuccessLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISuccessLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISuccessLogin", TestData, "D3Dispatch",intCounter);
    	

		                this.reporter.initTestCaseDescription("1726:DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                login(data.get("LoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.logOut();
		                /*home.allErrorAlerts();*/
		                System.out.println("Test completed");            	
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1726",ReportStatus.strMethodName,intCounter,browser);
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
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   /* @DataProvider
    public Object[][] getTestDataFor_ChangePassword() {
        return TestUtil.getData("Changepassword", TestData, "D3Dispatch");
    }
    @Test(dataProvider = "getTestDataFor_ChangePassword")

    public void changePassword(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("DI Login");
                CRHomeLib home=new CRHomeLib();
                navigateToApplication("DI");
                enterUserName(data.get("LoginName"));
                enterPassword(data.get("Password"));
                changePasswordButton();
                verifyChangePassword(data.get("NewPassword"),data.get("Confirm password"),data.get("PasswordChangeAlert"));
                home.allErrorAlerts();
                System.out.println("Test completed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }*/
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sessionTest
     * description :: Session testing
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIsessionTest(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISessionTest", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISessionTest", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1726:DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

						System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_32Bit.exe");
		                WebDriver driver1 = null;

		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                navigateToApplication("DI");
		                login(data.get("LoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.sessionInNewTab();
						waitcloseAllBusyIcons();
						closeWindow();
						switchToWindow();
						acceptAlert();
						boolean menuItemVisibilityInFirstWindow=diHome.verifyMenuItem();
						assertTrue(menuItemVisibilityInFirstWindow,"Session continues in first browser");
						String currentUrl = driver.getCurrentUrl();
						reporter.SuccessReport("<b>Opening New browser</b>","<b>Opening New Browser</b>");
						driver1 = new ChromeDriver();
						driver1.get(currentUrl);
						boolean menuItemVisibility = false;
						try{
							menuItemVisibility=driver1.findElement(By.id("user-login")).isDisplayed();
						}
						catch(Exception ex){

						}
						finally{
							if(!menuItemVisibility){
								reporter.SuccessReport("Menu  is Visible","Session continues in new browser & Menu  is Visible");
							}else{
								reporter.failureReport("Menu  is Not Visible", "Session Not continues in new browser & Menu is Not Visible", new EventFiringWebDriver(driver1));
							}
							driver1.quit();
						}
						diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: SelectROle
     * description :: SelectRole
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DISelectRole(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISelectRole", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISelectRole", TestData, "D3Dispatch",intCounter);
		                this.reporter.initTestCaseDescription("1726:DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                navigateToApplication("DI");
		                login(data.get("LoginName"),data.get("Password"));
		                //validating Roles list
						boolean rolesMatched=role.validateRolesList(data.get("selectRole"));
						assertTrue(rolesMatched, "Expected List  :: and Actual List :: Both are same");
						role.getLocaitonList();
						//Selecting roles form dropdown
		                role.roleSelection(data.get("RoleinDispatch"));
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
						//getting logged in user name and comparing with selected role
						home.clickOnloggedinUserName();
						String loggedInRole=diHome.getLoggedInUserRoleFromUserProfileWindow();
						diHome.closeUserProfileWindow();
					assertTrue(loggedInRole.contains(data.get("roleSelected"))," ::Selected user role is:: "+data.get("RoleinDispatch")+" ::User is logged in with selected role:: "+loggedInRole);

					diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: multiLoingAttemptsValidation
     * description :: multiple login attempts
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DImultiLoginAttemptsValidation(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMAX_PSWD_TRIES", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMAX_PSWD_TRIES", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1726:DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                mulipleLoginAttemps(data.get("LoginName"),data.get("Password"),data.get("attempts"));
		                System.out.println("Test Completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
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
