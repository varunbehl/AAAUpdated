
package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Hashtable;


public class TC_DISPPLogin extends DILoginLib {



/************************************************************************
	* Script Name :- DISPPLogin
	* Method Name :- ActiveUserValidUserNameAndValidPassword
	* Module	  :- DI 
	* Test Case ID:- 1769
	* Script Date :- 
	* Author      :- Sachin
	* @param StartRow
	* @param EndRow
	* @param nextTestJoin
	* @throws Throwable
	*************************************************************************/

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()

	public void ActiveUserValidUserNameAndValidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
						this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						// Navigating to Application
						navigateToApplication("DI");
						DIHomeLib diHome = new DIHomeLib();
						LoginRoleLib loginRole = new LoginRoleLib();
						// Entering User Name
						enterUserName(data.get("ActiveManagerPNE"));
						// Entering Password
						enterPassword(data.get("DIPassword"));
						loginButton();
						Thread.sleep(5000);
						waitcloseAllBusyIcons();
						diHome.closeFacilityWindow();
						// Validating successful Login to the application
						boolean SPPDispatch = diHome.VerifySPPDispatchPageIsVisible();
						assertTrue(SPPDispatch,"Logged into the application without any errors");
						diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
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
	

/************************************************************************
	* Script Name :- DISPPLogin
	* Method Name :- ActiveUserValidUserNameAndInvalidPassword
	* Module	  :- DI 
	* Test Case ID:- 1769
	* Script Date :- 
	* Author      :-  Sachin
	* @param StartRow
	* @param EndRow
	* @param nextTestJoin
	* @throws Throwable
	*************************************************************************/

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()

	public void ActiveUserValidUserNameAndInvalidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
						this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						DILoginLib diLogin = new DILoginLib();
						// Navigating to Application
						navigateToApplication("DI");
						// Entering User Name
						enterUserName(data.get("ActiveManagerPNE"));
						// Entering Password
						enterPassword(data.get("DIInvalidPassword"));
						loginButton();
						Thread.sleep(5000);
						// Validating Error message
						String errorMEssage =  diLogin.GetErrorMessageFromErrorsAlert();
						assertTrue(errorMEssage.equalsIgnoreCase(data.get("ErrorInvalidUserNamePassword")),"Error displays Invalid UserName/Password Combination");
						click(LoginPage.btnErrorAlertOK,"OK");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
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


	/************************************************************************
	 * Script Name :- DISPPLogin
	 * Method Name :- InActiveUserValidUserNameAndValidPassword
	 * Module	  :- DI
	 * Test Case ID:- 1769
	 * Script Date :-
	 * Author      :-  Sachin
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
		*************************************************************************/


	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()

	public void InActiveUserValidUserNameAndValidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
						this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						// Navigating to application
						navigateToApplication("DI");
						DIHomeLib diHome = new DIHomeLib();
						// Entering User Name
						enterUserName(data.get("InActiveUserManagerPNE"));
						// Entering Password
						enterPassword(data.get("DIPassword"));
						DILoginLib diLogin = new DILoginLib();
						loginButton();
						Thread.sleep(5000);
						String errorMEssage = diLogin.GetErrorMessageFromErrorsAlert();
						// Validating error message
						assertTrue(errorMEssage.equalsIgnoreCase(data.get("ErrorInactiveUser")),"Error displays Invalid UserName/Password Combination");
						click(LoginPage.btnErrorAlertOK,"OK");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
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



	/************************************************************************
	 * Script Name :- DISPPLogin
	 * Method Name :- MultipleRoles
	 * Module	  :- DI
	 * Test Case ID:- 1769
	 * Script Date :-
	 * Author      :-  Sachin
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
	*************************************************************************/

	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()

	public void MultipleRoles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
							fnOpenTest();
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
							this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							// Validating Multi user login for Role P3 - SPP Manager
							MultiUserLogin(data,data.get("UserRole1"));
							// Validating Multi user login for Role PP - Service Provider Portal
							MultiUserLogin(data,data.get("UserRole2"));

	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
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



/************************************************************************
	 * Script Name :- DISPPLogin
	 * Method Name :- NoSPPAccessUserValidUserNameAndValidPassword
	 * Module	  :- DI
	 * Test Case ID:- 1769
	 * Script Date :-
	 * Author      :-  Sachin
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
	 *************************************************************************/


	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()

	public void NoSPPAccessUserValidUserNameAndValidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
							fnOpenTest();
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
							this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							// Navigating to application
							navigateToApplication("DI");
							DIHomeLib diHome = new DIHomeLib();
							// Entering user name
							enterUserName(data.get("NoSPPAccessUser"));
							// Entering Password
							enterPassword(data.get("DIPassword"));
							loginButton();
							Thread.sleep(5000);
							waitForVisibilityOfElement(LoginPage.errorMessageOnErrorAlert,"Access Denied. Your Role is Not Authorized to Use this Module.");
							String errorMEssage =getText(LoginPage.errorMessageOnErrorAlert,"Access Denied. Your Role is Not Authorized to Use this Module.").trim();
							//Validating Error Message
							assertTrue(errorMEssage.equalsIgnoreCase(data.get("NoSPPAccessError")),"Error displays:Access Denied. Your Role is Not Authorized to Use this Module.");
							click(LoginPage.btnErrorAlertOK,"OK");
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
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
	 
	public void MultiUserLogin(Hashtable<String, String> data, String Role) throws Throwable{
					// Navigating to the application
					navigateToApplication("DI");
					DIHomeLib diHome = new DIHomeLib();
					DILoginLib diLoginLib = new DILoginLib();
					// Entering User Name
					enterUserName(data.get("MultipleRolesUserName"));
					// Entering Password
					enterPassword(data.get("DIPassword"));
					loginButton();
					Thread.sleep(10000);

					boolean roleField = diLoginLib.VerifyRoleFieldIsDisplayed();
					assertTrue(roleField," login screen displays the Role field");

					boolean locationField = diLoginLib.VerifyLocationFieldIsDisplayed();
					assertTrue(locationField,"login screen displays Location Field");
					// Clicking on Down Arrow for Role field
					diLoginLib.ClickOnRoleDownArrowButton();

					int rolesCount = diLoginLib.GetRoleCountFromRoleField();
					assertTrue(rolesCount == Integer.parseInt(data.get("RoleCount")),"They are two roles to select from.");

					String RoleNamesList =diLoginLib.GetRoleNamesFromRoleField();
					assertTrue(RoleNamesList.contains(data.get("Role1SPPManager")),"Role available, User Role 1 is: P3 - SPP Manager");
					assertTrue(RoleNamesList.contains(data.get("Role2PPServiceProviderPortal")),"Role available, User Role 2 is: PP - Service Provider Portal");
					// Selecting Role from Role Dropdown
					click(LoginPage.lblSelectRoleFromRoleDropDown(Role),"Role Selected "+Role);
					Thread.sleep(2000);
					// Clicking on Down Arrow for Location field
					click(LoginPage.LocationDropDownButton,"Location Drop Down");
					Thread.sleep(5000);
					// Validating any locations set to the member display
					int locationCount = diLoginLib.GetLocationCountFromLocationField();
					assertTrue(locationCount >=1,"Locations is set");

					click(LoginPage.lblSelectLocationFromLocationDropDown(data.get("Location")),"Selecting Location "+data.get("Location"));
					Thread.sleep(2000);
					// Validating Back to Login Button is displayed
					boolean backToLogin = diLoginLib.VerifyBackToLoginButtonExists();
					assertTrue(backToLogin,"Back to Login Button exist");
					// Validating Proceed Button is displayed
					boolean ProceedButton = diLoginLib.VerifyProceedButtonExists();
					assertTrue(ProceedButton,"Proceed Button exist");
					// Clicking on Proceed Button
					diLoginLib.ClickOnProceedButton();
					waitcloseAllBusyIcons();
					diHome.closeFacilityWindow();
					boolean SPPDispatch = diHome.VerifySPPDispatchPageIsVisible();
					// Validating login to application successfully
					assertTrue(SPPDispatch,"Logged into the application without any errors");
					diHome.logOut();

	}

}

