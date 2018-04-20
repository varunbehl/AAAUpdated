package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.ITestContext;

import com.aaa.d3itu.page.LoginPage;

    public class AssignTruckLib extends ActionEngineMobile {
        public ITestContext testcontext;

        public void setTestContext(ITestContext testContext) {
            this.testcontext = testContext;

        }

        public void clickOnAssignTruck(String facilityAndTruck) throws Throwable { 
            Thread.sleep(3000);
            //scrollAndClick(facilityAndTruck);
            //appiumDriver.scrollToExact("5145/P - Ituleaddriver automation");
            //SwipeBottom(AssignTruckPage.lnkAssignTruck(facilityAndTruck));
            //appiumDriver.scrollTo(facilityAndTruck);
            Thread.sleep(3000);
            //appiumDriver.scrollTo(facilityAndTruck);
            scrollAndClick(AssignTruckPage.lnkAssignTruck(facilityAndTruck));
            /*if (isVisibleOnly(AssignTruckPage.assignTruckP, "click on assign truck"))
            click(AssignTruckPage.lnkAssignTruck(facilityAndTruck), "click on assign truck");*/
        }
        
        
        
       
       
    }
