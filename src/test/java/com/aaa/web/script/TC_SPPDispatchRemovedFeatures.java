package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_SPPDispatchRemovedFeatures extends DILoginLib {
    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void sppDispatchRemovedFeatures(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "SPPDispatchRemovedFeatures", TestData, "SPPDispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("SPPDispatchRemovedFeatures", TestData, "SPPDispatch", intCounter);
                    this.reporter.initTestCaseDescription("1902: SPP Dispatch Removed Features" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    DISearchCallsLib diSearchCalls=new DISearchCallsLib();

                    navigateToApplication("DI");
                    login.login(data.get("SppLoginName"), data.get("SppPassword"));
                    waitcloseAllBusyIcons();
                    //verify queue selection model is not appeared
                    assertTrue(!diHome.verifyQueueSelectionModelAfterLogin(),"Queue Selection Model is not Appeared");
                    //verify Facility  PTA window is Displayed
                    assertTrue(diHome.verifyFacilityPTAWinow(),"Facility PTA Window displayed");
                    diHome.clickOnCloseIconOnFacilityPTA();
                    diHome.selectUserProfileMenuItem();
                    //verify Dispatch Queue is not appeared
                    assertTrue(!diHome.verifyDispatchQueueSectionOnUserProfile(),"Dispatch Queue Section is not Appeared");
                    diHome.closeUserProfileWindow();
                    diHome.clickOnSearchCallsInDispatch();
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    diHome.clickOnFirstCallIdInSearchCallsTable();
                    //verify Gear Icon is not Displayed
                    assertTrue(!diMCD.verifyGearIconOnMCD(),"Gear Icon On MCD not Displayed");
                    diMCD.clickOnMCDCloseWindow();
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("SPP", "1902", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
}
