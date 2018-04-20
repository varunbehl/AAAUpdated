package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

public class ServicesLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void clickOnSave() throws Throwable {
        if(isVisibleOnly(ServicesPage.crossOnTechAssistError, "Cross Mark"))
        {
            click(ServicesPage.crossOnTechAssistError, "Click on Cross Mark");
        }
        waitForVisibilityOfElement(ServicesPage.btnSave, "click on save");
        click(ServicesPage.btnSave, "click on save");
    }
    
    public void addService(String AddService, String Unit, String Cost) throws Throwable {
    	//click on Add service
    	waitForVisibilityOfElement(ServicesPage.AddService, "click on Add Service");
    	click(ServicesPage.AddService, "click on Add Service");
    	//select Additional service
    	waitForVisibilityOfElement(ServicesPage.lnkAddService(AddService), "click on Additional Service: "+AddService);
        click(ServicesPage.lnkAddService(AddService), "click on Additional Service: "+AddService);
        Thread.sleep(8000);
        waitForVisibilityOfElement(ServicesPage.Unit, "Unit");
        type(ServicesPage.Unit,Unit,"Entered Unit"+Unit);
        if(isVisibleOnly(ServicesPage.Cost, "Cost"))
        type(ServicesPage.Cost,Cost,"Entered Cost"+Cost);
        //click on done
        click(ServicesPage.done, "Done");       
    }
    public void verifyAddService(String AddService) throws Throwable{
    	waitForVisibilityOfElement(ServicesPage.lnkAddService(AddService), "Verify Service is added");
    	if (isVisibleOnly(ServicesPage.lnkAddService(AddService), "Verify Service is Added :"+AddService)){
    		reporter.SuccessReport("verify ADD Service ", "Verify Service is Added :"+AddService);
    	}
    	else{
    		reporter.failureReport("verify ADD Service ", "Service is not added"+AddService);
    		}	
    	}
    }

