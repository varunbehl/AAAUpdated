package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;
import com.aaa.web.page.CRVehicleTriagePage;

public class PacesetterResolutionLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void clickOnProblemDescription(String ProblemDescription) throws Throwable{
    	 click(PacesetterResolutionPage.lnkProblemTypesDescription(ProblemDescription), ""+ProblemDescription);
    }
    
    public void clickonPacesetterResolution(String PacesetterResolution) throws Throwable {
    	String paceSetterResolution[] = PacesetterResolution.split("#");
    	for (int i = 0; i < paceSetterResolution.length; i++) {
    		//appiumDriver.scrollTo(paceSetterResolution[i]);
    		click(PacesetterResolutionPage.lnkProblemTypesDescription(paceSetterResolution[i]),"click on pacesetter resolution :"+paceSetterResolution[i]);
        	Thread.sleep(3000);
        }

    }
    
}


