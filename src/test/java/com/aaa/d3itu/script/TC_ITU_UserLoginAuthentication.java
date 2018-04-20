package com.aaa.d3itu.script;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.d3itu.lib.AssignTruckLib;
import com.aaa.d3itu.lib.CallsLib;
import com.aaa.d3itu.lib.DeliveryConfirmationLib;
import com.aaa.d3itu.lib.ETALib;
import com.aaa.d3itu.lib.LaunchITULib;
import com.aaa.d3itu.lib.LoginITULib;
import com.aaa.d3itu.lib.PacesetterResolutionLib;
import com.aaa.d3itu.lib.ServicesLib;
import com.aaa.d3itu.lib.VehicleLookupLib;
import com.aaa.d3itu.lib.facilityandTruckSelectionLib;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CRServiceLib;
import com.aaa.web.lib.CommonLib;
import com.aaa.web.lib.DIHomeLib;
import com.aaa.web.lib.DIMCDLib;

public class TC_ITU_UserLoginAuthentication extends LaunchITULib{

	LoginITULib loginITU =new LoginITULib();
/*	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Throwable {
		this.appiumDriver.resetApp();
		super.afterMethod();
	}
	public static final int WAITTIME = 50000;*/
	//*** Main FLow
	   @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void TC_ITU_UserLoginAuthentication(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "UserPasswordAuthentication", TestData, "InTruckUltra");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest(); 
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("UserPasswordAuthentication", TestData, "InTruckUltra",intCounter);
					reporter.initTestCaseDescription("CR DI ITU End to End"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					selectEnvironment(data.get("ITUEnvironment"));
					loginITU.enterLoginDetails(data.get("UserName"),data.get("Password"));
					String expectedResultType=data.get("Authenticate");
					String expectedResultValidation=data.get("Message");
					loginITU.validateLogin(expectedResultType, expectedResultValidation);
				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
				}
				ReportControl.fnEnableJoin();
				ReportStatus.fnUpdateResultStatus("ITU_UserPasswordAuthentication","1594",ReportStatus.strMethodName,intCounter,"MobileApp");
				ReportControl.fnSwitchToMobile();
				//fnCloseTest();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}
}

