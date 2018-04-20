package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.LoginPage;
import org.openqa.selenium.WebElement;
import java.util.List;
public class LoginLib extends ActionEngine {
	int count;

	List<WebElement> locationsItems = null;

/**
 * param :: String inputs
 * return ::void
 * throws :: throwable
 * methodName :: Login
 * description :: This is for Login into the application
 * date :: 05-Dec-2017
 * author :: Chandu Dendukuri
 */
    public void login(String userName,String password) throws Throwable {
    enterUserName(userName);
    enterPassword(password);
    clickOnLoginButton();

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: LoginValidation
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
    public String loginValidation(String userName,String password) throws Throwable {
        login(userName,password);
        String  errorMessage=errorLoginMessage();
        return errorMessage;
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: changePasswordVerification
     * description :: This is to change password and verify change password
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
    public void changePasswordVerification(String newPassword,String confirmPassword,String passwordChangeAlert,String userName, String password) throws Throwable {
        enterUserName(userName);
        enterPassword(password);
        changePasswordButton();
        errorLoginMessage();
        verifyChangePassword(newPassword,confirmPassword,passwordChangeAlert);
        errorLoginMessage();
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sessionInNewTabverification
     * description :: This is for Login into the application
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
    public void sessionInNewTabverification(String userName,String password) throws Throwable {
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginButton();
        /*homepage.sessionInNewTab();*/
    }
    /**
 * param :: String inputs
 * return ::void
 * throws :: throwable
 * methodName :: UserID
 * description :: UserIDTextField
 * date :: 05-Dec-2017
 * author :: Chandu Dendukuri
 */

    public void enterUserName(String userName) throws Throwable {
        waitForVisibilityOfElement(LoginPage.txtLoginName,"User Name Text Field");
        type(LoginPage.txtLoginName,userName,"User Name");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Password
     * description :: passwordField
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */

    public void enterPassword(String password) throws Throwable {
        waitForVisibilityOfElement(LoginPage.txtLoginPassword,"Login password Text Field");
        type(LoginPage.txtLoginPassword,password,"Password text field");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: LoginButton
     * description :: LoginButton
     * date :: 05-Dec-2017
     * author ::Chandu Dendukuri
     */
    public void clickOnLoginButton() throws Throwable {
        waitForVisibilityOfElement(LoginPage.btnLogin,"Login button");
        click(LoginPage.btnLogin,"Login Button");
        Thread.sleep(5000);
        clickOnPartialCallCloseButton();
    }


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: Login
	 * description :: This is for Login into the application
	 * date ::
	 * author ::
	 */

    public void enterLoginDetails(String UserName, String password) throws Throwable {
        enterUserName(UserName);
        enterPassword(password);
        clickOnLoginButton();
    }

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: errorLoginMessage
	 * description :: errorLoginMessage
	 * date :: 05-Dec-2017
	 * author ::Chandu Dendukuri
	 */
	public String errorLoginMessage() throws Throwable {
		waitForVisibilityOfElement(LoginPage.alertInvalidLogin,"Invalid Login");
		String error = getText(LoginPage.alertInvalidLogin,"Invalid Login");
		click(LoginPage.btnOkOnErrorAlert,"Error alert OK button Appeared for :: "+error);
		return error;
	}

	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: changePasswordButton
     * description :: changePasswordButton
     * date :: 05-Dec-2017
     * author ::Chandu Dendukuri
     */
    public void changePasswordButton() throws Throwable {

        waitForVisibilityOfElement(LoginPage.btnChangePassword, "Change Password");
        click(LoginPage.btnChangePassword, "Change password");
        if(isElementPresent(LoginPage.btnOkOnErrorAlert,"InActive Account"))
           {
            	click(LoginPage.btnOkOnErrorAlert, "Change password");
           }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyChangePassword
     * description :: changePassword
     * date :: 05-Dec-2017
     * author ::Chandu Dendukuri
     */
    public void verifyChangePassword(String newPassword,String confirmPassword,String passwordChangeAlert) throws Throwable {

		waitForInVisibilityOfElement(LoginPage.txtChangePassword,"changePassword");
		click(LoginPage.txtChangePassword,"Change password text box");
		type(LoginPage.txtChangePassword, newPassword, "NewPassword");
		type(LoginPage.txtConfirmPassword, confirmPassword, "Confirm password");
		boolean charcount = isVisibleOnly(LoginPage.iconPwdCharCounTure, "Password character count");
		assertTrue(charcount, "You entered Valid password character count");
		/*if(charcount) {
			assertTrue(charcount, "You entered Valid password character count");
		}else {
			assertFalse(charcount, "Password length should be in 8-10 characters");
		}*/
		boolean specialChar = isVisibleOnly(LoginPage.iconPwdSpelCounTrue, "Special characters");
		assertTrue(specialChar, "You entered password with given special characters ");
		/*if(specialChar){
			assertTrue(specialChar, "You entered password with given special characters ");
		}else
		{
			assertFalse(specialChar,"Special character (number or punctuation)");
		}*/
		boolean passwdMatch = isVisibleOnly(LoginPage.iconPwdMatchTrue, "New password and Confirm password Not matched");
		assertTrue(passwdMatch, "New password and Confirm password Not matched");
		/*if (passwdMatch) {
			assertTrue(passwdMatch, "New password and Confirm password Not matched");
		}else
		{
			assertFalse(passwdMatch,"Passwords must match");
		}*/
		boolean passChangeBtn = isVisibleOnly(LoginPage.btnChangePasswordChangeButton, "Password change button Enabled");
		assertTrue(passChangeBtn,"Password change button is Enabled");
		if(passChangeBtn){
			//assertTrue(passChangeBtn,"Password change button is Enabled");

            click(LoginPage.btnCancel,"Cancel button");
			waitForInVisibilityOfElement(LoginPage.alertChangePassword,"Alert");
			String alert = getText(LoginPage.alertChangePassword,"Change password success message");
			assertTrue(alert.contains(passwordChangeAlert),"Successfully updated");

		}else {
			//assertFalse(passChangeBtn, "Password change button is disabled");
			click(LoginPage.btnCancel,"Cancel button");
		}
    }
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: multipleLoginAttempts
	 * description :: To Verify multiple login attempts
	 * date :: 05-Dec-2017
	 * author ::Chandu Dendukuri
	 */
	public void mulipleLoginAttemps(String userName,String password,String attempts) throws Throwable {

		for (int i = 0; i <Integer.parseInt(attempts); i++) {
			enterUserName(userName);
			enterPassword(password);
		    clickOnLoginButton();
			errorLoginMessage();
		}
	}


	/**
	 * param ::
	 * return :: void
	 * throws :: throwable
	 * methodName :: waitcloseAllBusyIcons
	 * description :: Application loading wait
	 * date :: 28-Nov-2017
	 * author :: chandu
	 */
	protected void waitcloseAllBusyIcons() throws Throwable {
		int iCounter = 0, loading;
		boolean status = true;
		do {
			iCounter++;
			loading = getElementsSize(CRMemberSearchPage.loadingspinner);
			if (loading == 0) {
				status = true;
				break;
			}
			else{
				status=false;
				//LOG.info("iCounter appearStatus " + iCounter);
			}
			if (iCounter > 1000) {
				status = false;
				break;
			}
		}
		while (iCounter <= 1000);
		if (status) {
			LOG.info("All spinners are closed");
		}else{
			LOG.info("All spinners are not closed");
		}
	}

	/**
	 * param ::
	 * return :: void
	 * throws :: throwable
	 * methodName :: waitcloseAllBusyIconsResults
	 * description :: Application loading wait for memberseatch results
	 * date :: 29-Nov-2017
	 * author :: chandu
	 */
	public void waitcloseAllBusyIconsResults() throws Throwable {
		int iCounter = 0, loading;
		boolean status = true;
		do {
			iCounter++;
			loading = getElementsSize(CRMemberSearchPage.iconResultLoadingSpinner);
			if (loading == 0) {
				status = true;
				break;
			}
			else{
				status=false;
				/*LOG.info("iCounter appearStatus " + iCounter);*/
			}
			if (iCounter > 400) {
				status = false;
				break;
			}
		}
		while (iCounter <= 400);
		if (status) {
			LOG.info("All spinners are closed");
		}else{
			LOG.info("All spinners are not closed");
		}
	}

	/**
	 * param ::
	 * return :: String
	 * throws :: throwable
	 * methodName :: getLocationName
	 * description :: to get the location details
	 * date ::
	 * author :: Cigniti
	 */

	public String getLocationName() throws Throwable {
		waitForVisibilityOfElement(LoginPage.ddnLocation,"Location Drop Down");
		String location = getText(LoginPage.ddnLocation,"Location Drop Down");
		return location;
	}

	/**
	 * param ::
	 * return :: void
	 * throws :: throwable
	 * methodName :: clickOnPartialCallCloseButton
	 * description :: to click on partial call close button
	 * date ::
	 * author :: Cigniti
	 */

	public void clickOnPartialCallCloseButton() throws Throwable {
        boolean partialCall = isVisibleOnly(CRMemberSearchPage.partialCall, "Partial Call Close Icon");
        if (partialCall) {
            click(CRMemberSearchPage.closeIconOnPartialCall, "Partial Call close icon");
        }
    }

	/**
	 * param ::
	 * return :: void
	 * throws :: throwable
	 * methodName :: GetLocationsFromLogin
	 * description :: to get the location from login
	 * date ::
	 * author :: Cigniti
	 */


	public String GetLocationsFromLogin() throws Throwable {

		locationsItems = getWebElementList(LoginPage.ddnLocation, "Location Items");
		String locationsAll = null;
		if (locationsItems != null) {
			for (int i = 0; i <= locationsItems.size()-1; i++) {
				String locations = locationsItems.get(i).getText().trim();
				locationsAll = locationsAll + locations;
				System.out.println(locations);
			}
		}
		return locationsAll;
	}

	/**
	 * param :: NA
	 * return :: void
	 * throws :: throwable
	 * methodName :: clickOnDownArrowLocationField
	 * description :: This function clicks on Down Arrow button for Location Field
	 * date ::
	 * author :: Sachin
	 */

	public void clickOnDownArrowLocationField() throws Throwable {
		waitForVisibilityOfElement(LoginPage.LocationDropDownButton,"Down Arrow Button Location Field");
		click(LoginPage.LocationDropDownButton,"Down Arrow Button Location Field");
	}

	/**
	 * param :: NA
	 * return :: void
	 * throws :: throwable
	 * methodName :: clickOnDownArrowRolesField
	 * description :: This function clicks on Down Arrow button for Roles Field
	 * date ::
	 * author :: Sachin
	 */

	public void clickOnDownArrowRolesField() throws Throwable {
		waitForVisibilityOfElement(LoginPage.RolesDropDownButton,"Down Arrow Button Roles Field");
		click(LoginPage.RolesDropDownButton,"Down Arrow Button Roles Field");
	}
}





