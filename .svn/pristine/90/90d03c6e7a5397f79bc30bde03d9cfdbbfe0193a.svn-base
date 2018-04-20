package com.aaa.web.lib;


import com.aaa.web.page.LoginRolePage;
import com.aaa.accelerators.ActionEngine;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginRoleLib extends ActionEngine {

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectRoleInDispatch
	 * description :: This is used to select the role from dropdown
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

    public void selectRoleInDispatch(String role) throws Throwable {
    	//wait for Login Role to be displayed
		if(isVisibleOnly(LoginRolePage.txtLoginRole, "Login Role")){
			//enter Login Role details
			type(LoginRolePage.txtLoginRole,role, "Role in Dispatch");
		}

	}
	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnProceedBtnInDispatchRoleLogin
	 * description :: This is used to click on proceed button
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean clickOnProceedBtnInDispatchRoleLogin() throws Throwable {
		//click on proceed login button
		boolean proceedButton=isVisibleOnly(LoginRolePage.btnProceedLogin, "Proceed to Login");
		//click(LoginRolePage.btnProceedLogin, "Proceed button ");
		if(proceedButton){
			click(LoginRolePage.btnProceedLogin, "Proceed button ");
		}
		return proceedButton;
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectRoleAndProceed
	 * description :: This is used to complete role section
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */
	public void selectRoleAndProceed(String role) throws Throwable {
		selectRoleInDispatch(role);
		clickOnProceedBtnInDispatchRoleLogin();
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: roleSelection Method
	 * description :: roleSelection Method
	 * date :: 07-Dec-2017
	 * author :: Chandu Dendukuri
	 */

	public void roleSelection(String role) throws Throwable {
		selectRoleInDispatch(role);
        verifyLocationField();
        verifyBackToLoginButton();
        clickOnProceedBtnInDispatchRoleLogin();
        clickOnProceedBtnInDispatchRoleLogin();
        clickOnProceedBtnInDispatchRoleLogin();
	}

	 /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyLocationField
     * description :: to verify location field availablity
     * date :: 07-Dec-2017
     * author :: Chandu Dendukuri*/

    public void verifyLocationField() throws Throwable {
        boolean locationPresence = isVisibleOnly(LoginRolePage.txtLocation, "Login Role");
/*        if (locationPresence) {
            assertTrue(locationPresence, "Role field is available");

        } else {
            assertFalse(locationPresence, "Role Field is not available");
        }*/
        assertTrue(locationPresence, "Role field is available");
    }

   /* *
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBackToLoginButton
     * description :: verifyBackToLoginButton
     * date :: 07-Dec-2017
     * author :: Chandu Dendukuri
*/
    public void verifyBackToLoginButton() throws Throwable {
        //wait for proceed login button to be displayed
       boolean backToLogin = isVisibleOnly(LoginRolePage.btnBackToLogin, "Back to Login button");

/*        if(backToLogin)
        {
            assertTrue(backToLogin,"Back to Login Button available");

        }else
        {
            assertFalse(backToLogin,"Back to Login button is not available");
        }*/
       assertTrue(backToLogin,"Back to Login Button available");
    }
	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyVisibilityOProceedBtnInDispatchRoleLogin
	 * description :: This is used to verify on proceed button
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyVisibilityOProceedBtnInDispatchRoleLogin() throws Throwable {
		boolean processedButton=isVisibleOnly(LoginRolePage.btnProceedLogin, "Proceed button ");
		return processedButton;
	}

	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: getRolesList
	 * description :: This is used to verify on proceed button
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean validateRolesList(String role) throws Throwable {
		click(LoginRolePage.btnRoleDropDown, "Login role dropdown");
		String[] str;
		boolean rolesMatched;
		rolesMatched=false;
		List<WebElement> allRoles = getWebElementList(LoginRolePage.listofRole, "List of Roles");
		//checking for null values from dropdown list
		if (allRoles.size() != 0) {
			if (role.equals("AD")) {
				//Storring all the roles which are available for Admin user into str there are expected
				str = new String[]{"DI - Dispatcher", "AD - Administrator", "CR - Call Taker", "CV - Carver"};
			} else {
				//Storring all the roles which are available for CR user into str
				str = new String[]{"DI - Dispatcher", "CR - Call Taker"};
			}
			List<String> strList = Arrays.asList(str);
			//Getting all the list from application these are actual values
			List<String> webList = new ArrayList<>();
			for (int i = 0; i < allRoles.size(); ++i) {
				webList.add(allRoles.get(i).getText());
			}
			//Comparing both actuals and Expected values
			rolesMatched = strList.containsAll(webList);

			if(rolesMatched){
				reporter.SuccessReport("Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same","Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same");
			}else {
				reporter.failureReport("Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same","Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same");
			}

			reporter.SuccessReport("Available Roles are:: ", "No Of Roles Available :: " + allRoles.size());
		} else {
			reporter.failureReport("Available Roles are:: ", "No Of Roles Available are :: " + allRoles.size());
		}
		return rolesMatched;
	}

	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: getLocaitonList
	 * description :: getLocaitonList
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

	public void getLocaitonList() throws Throwable {
		click(LoginRolePage.btnlocationDropdown,"Login location dropdown");

		List<WebElement> allLocations = getWebElementList(LoginRolePage.listOfLocations, "list of locations");
		if(allLocations.size()!=0) {
			reporter.SuccessReport("Available Locations are:: ", "No Of Locations Available :: " + allLocations.size());
			for (WebElement locationsList : allLocations) {
				reporter.SuccessReport("Locaiton Lists are: ", "Available locations are " + locationsList.getText());
			}
		}
		else
		{
			reporter.failureReport("Available Locations are:: ", "No Of Locations Available :: " + allLocations.size());
		}
	}
}
