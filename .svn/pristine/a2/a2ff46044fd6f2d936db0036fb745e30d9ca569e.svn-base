package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.rspweb.pages.RSPHomePage;
import com.aaa.utilities.TestUtil;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

public class TC_RSPUserAdministration extends RSPCommonLib {

	RSPLoginLib login = new RSPLoginLib();
	RSPHomeLib home = new RSPHomeLib();
	RSPManageUserLib managerUser = new RSPManageUserLib();
	
	
	/*********************************************************************************
     * *******************************************************************************
     * *************************STEP SKIPPED******************************************
     * Steps 1,2,3,4 :DB verification
     * Step 8 :Can access reports for any managed shop (as per Jira/CQA-309 comment its a defect)
     * *******************************************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */
	@Parameters({ "StartRow", "EndRow", "nextTestJoin" })
	@Test()
	public void RSPUserAdministration(int StartRow, String EndRow, boolean nextTestJoin)throws Throwable {
		try {
			int intStartRow = StartRow;
			int intEndRow = ReportControl.fnGetEndRowCunt(EndRow,"RSPUserAdministration", TestData, "RSPWeb");
			for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPUserAdministration", TestData, "RSPWeb",intCounter);
					this.reporter.initTestCaseDescription("RSPUserAdministration"+ " From Iteration " + StartRow + " to "+ EndRow);
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  " + intCounter+ "   **************");
					// Navigating to RSP
					navigateToApplication("RSP");
					login.loginToRSP(data.get("LoginName"),data.get("Password"));
					home.validateUserCanManageClubsOrShops(data.get("UserType"));
					home.validateUserCanManagePromotions(data.get("UserType"));
					home.validateUserCanManageClubSettings(data.get("UserType"));
					home.validateUserCanViewDashBoards(data.get("UserType"));
					home.validateUserCanCreateNewUsers(data.get("UserType"));
					home.clickOnSignOut();
					acceptAlert();
				} catch (Exception e) {
					ReportStatus.blnStatus = false;
					reporter.failureReport("Failed due to", e.getMessage(),
							driver);
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("RSP", "1854",ReportStatus.strMethodName, intCounter, browser);
				fnCloseTest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}
}