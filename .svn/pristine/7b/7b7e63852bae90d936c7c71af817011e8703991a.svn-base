package com.aaa.d3itu.lib;
import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LaunchPage;
import com.aaa.d3itu.page.LoginPage;
import com.aaa.d3itu.page.facilityandTruckSelectionPage;

public class LoginITULib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;

	}

	public void enterUserName(String UserName) throws Throwable {
		waitForVisibilityOfElement(LoginPage.userName, "User Name");
		type(LoginPage.userName, UserName, "User Name");
	}

	public void enterPassword(String Password) throws Throwable {
		waitForVisibilityOfElement(LoginPage.password, "Password");
		type(LoginPage.password, Password+"\n", "Password");
	}

	public void clickLoginButton() throws Throwable {
		waitForVisibilityOfElement(LoginPage.login, "click on Login");
		click(LoginPage.login, "click on Login");
		//type(LaunchPage.environment, environment, "Environment");		
	}

	public void enterLoginDetails(String UserName, String Password) throws Throwable {
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
			//Thread.sleep(20000);
				enterUserName(UserName);
				enterPassword(Password);
				clickLoginButton();
			}
	
	/**
	 * @Desc - This method validates the login error or success messages
	 * @param Authenticate - Error/ Login success
	 * @param Message - Error message or Facility Selection page header
	 * @throws Throwable
	 */
	public void validateLogin(String Authenticate, String Message) throws Throwable {
		boolean isLoginError=isElementPresent(LoginPage.error,"Login Error Dialog");
		String message;
		if(isLoginError){
			message = getText(LoginPage.errorDialogText, "Error Dialog Text");
		}else{
			waitForVisibilityOfElement(facilityandTruckSelectionPage.facilityAndTruckSelectionHeader,"Facility And Truck Selection Header");
			boolean isLoginSuccess=isElementPresent(facilityandTruckSelectionPage.facilityAndTruckSelectionHeader,"Facility And Truck Selection Header");
			message = getText(facilityandTruckSelectionPage.facilityAndTruckSelectionHeader, "Facility And Truck Selection Header");
		}
		if(message.trim().equalsIgnoreCase(Message.trim())){
			this.reporter.SuccessReport("Validate Login " + Authenticate, message);
		} else{
			this.reporter.failureReport("Validate Login " + Authenticate,"Expected message : "+Message +" but found "+message, this.appiumDriver);
		}
	}
	
	public void waitforSync(int wait) throws Throwable {
		Thread.sleep(wait*1000);
	}

}


