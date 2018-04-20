package com.aaa.rspweb.lib;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aaa.accelerators.ActionEngine;
import com.aaa.rspweb.pages.RSPLoginPage;

public class RSPLoginLib extends RSPCommonLib {


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterUserName
     * description :: To Enter user Name
     * date :: 09-Mar-2018
     * author :: Jagadish
     */

    public void enterUserName(String userName) throws Throwable {
        waitForVisibilityOfElement(RSPLoginPage.txtUserName, "User Name Text Field");
        type(RSPLoginPage.txtUserName, userName, "User Name");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPassword
     * description :: To Enter Password
     * date :: 09-Mar-2018
     * author :: Jagadish
     */

    public void enterPassword(String userName) throws Throwable {
        waitForVisibilityOfElement(RSPLoginPage.txtPassword, "Password Text Field");
        type(RSPLoginPage.txtPassword, userName, "Password");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSignInButton
     * description :: To click on signin button
     * date :: 09-Mar-2018
     * author :: Jagadish
     */

    public void clickOnSignInButton() throws Throwable {
        waitForVisibilityOfElement(RSPLoginPage.btnSignIn, "User Name Text Field");
        click(RSPLoginPage.btnSignIn, "Clicked on signin button");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginToRSP
     * description :: Login to application
     * date :: 09-Mar-2018
     * author :: Jagadish
     */

    public void loginToRSP(String userName,String Password) throws Throwable {
        enterUserName(userName);
        enterPassword(Password);
        clickOnSignInButton();
    }
    
    /**
	 * * param :: By  String
	 * return ::String
	 * throws :: throwable
	 * methodName :: getRspVersion
	 * description :: to Validate the Application Logout Time and UserLastLogout Times are equal
	 * date :: 17-Apr-2018
	 * author ::
	 * added by :: Amulya Gurijala
	 */
    public String getRspVersion(EventFiringWebDriver driver) throws Throwable {
    	String appVersion=null;
    	appVersion=driver.findElement(RSPLoginPage.lblVersion).getText();
    	if(appVersion.length()>0){
    		appVersion=	appVersion.split(":")[1].trim();
    		reporter.SuccessReport("Read the application version", "The application version is"+appVersion);
		}
		else{
			reporter.failureReport("Read the application version", "Failed to read the application version");
		}
    	return appVersion;
    }
}
