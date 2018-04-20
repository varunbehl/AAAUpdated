package com.aaa.web.script;

import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DISearchCallsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DITruckLoadDataUpdateWebPart1 extends LoginLib {
    public static String callID;
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();
    LoginRoleLib role = new LoginRoleLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHome = new DIHomeLib();
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    DITruckLoadDeafultViewLib DITruckload= new DITruckLoadDeafultViewLib();

    @DataProvider
    public Object[][] getTestDataFor_verifyDITruckLoadDataUpdate() {
        return TestUtil.getData("verifyDITruckLoadDataUpdate", TestData, "D3Dispatch");
    }

    @Test(dataProvider = "getTestDataFor_verifyDITruckLoadDataUpdate")
    public void verifyDITruckLoadDataUpdateWeb(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("1806:TC_DI Truck Load Data Update");

                navigateToApplication("DI");
                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
                Thread.sleep(5000);
                role.clickOnProceedBtnInDispatchRoleLogin();
                diLoginLib.waitcloseAllBusyIcons();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnTruckLoadTab();
                diHome.clickOnTruckLoadDefaultOption();
                diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
                DITruckload.setTruckAtoInactive();
                Thread.sleep(2000);
                diHome.logOut();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
        @Test(dataProvider = "getTestDataFor_verifyDITruckLoadDataUpdate")
        public void verifyDITruckLoadDataUpdateWebInPopOut(Hashtable<String, String> data) throws Throwable {
            try {
                if (data.get("RunMode").equals("Y")) {
                    this.reporter.initTestCaseDescription("1806:TC_DI Truck Load Data Update");

                    navigateToApplication("DI");
                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
                    Thread.sleep(5000);
                    role.clickOnProceedBtnInDispatchRoleLogin();
                    diLoginLib.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickOnTruckLoadTab();
                    diHome.clickOnTruckLoadDefaultOption();
                    dimcdLib.clickOnPoppedOutButtonInTruckloadTab();
                    diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
                    DITruckload.setTruckAtoInactive();
                    Thread.sleep(2000);
                    driver.close();
                    Thread.sleep(3000);
                    switchToWindow();
                    Thread.sleep(1000);
                    diHome.logOut();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

    }
}
