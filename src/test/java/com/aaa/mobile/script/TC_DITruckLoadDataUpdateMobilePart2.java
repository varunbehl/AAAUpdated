package com.aaa.mobile.script;

import com.aaa.d3itu.lib.*;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DITruckLoadDataUpdateMobilePart2 extends LaunchITULib
{
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String [] callandfacilityId = new String[2];
    public static boolean verifyAddressAvailableForOtherLocationInMCDWindow;

    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
    CallsLib calllib=new CallsLib();
    PacesetterResolutionLib pacesetterResolutionlib = new PacesetterResolutionLib();
    ETALib etalib =new ETALib();
    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Throwable {
        //logOut();
        this.appiumDriver.resetApp();
        super.afterMethod();
    }
    public static final int WAITTIME = 50000;

    @DataProvider
    public Object[][] getTestDataFor_verifyDITruckLoadDataUpdate() {
        return TestUtil.getData("verifyDITruckLoadDataUpdate", TestData, "D3Dispatch");
    }
    @Test(dataProvider = "getTestDataFor_verifyDITruckLoadDataUpdate")
    public void verifyDITruckLoadDataUpdateMobile(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                reporter.initTestCaseDescription("CR DI ITU End to End");
                selectEnvironment(data.get("ITUEnvironment"));
                loginITU.enterLoginDetails(data.get("UserName"),data.get("Password"));
                facilityandTruckSelectionlib.getFacility();
                facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
                System.out.println("Test completed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}