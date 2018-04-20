package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.syntax.jedit.InputHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.aaa.d3itu.page.LoginPage.login;

public class TC_CREpost extends ActionEngine {
	LoginLib login = new LoginLib();
	public static String Member = "";
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRHomeLib home = new CRHomeLib();
	CREpostLib ePost=new CREpostLib();
	DIHomeLib diHome = new DIHomeLib();




	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void navigationInEpost(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "navigationInEpost", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("navigationInEpost", TestData, "D3CallRecieving",intCounter);
    	
					this.reporter.initTestCaseDescription("1960: TC-CR Epost"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					login.login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(10000);
					home.messageDialogBoxClose();

					//Click on Help and select Epost
					ePost.clickOnDrpdwnHelp();
					ePost.clickOnEpost();
					ePost.verifyElectronicPost();
					ePost.getNumberOfMenuItemsPopulated();

					//Select menu item
					ePost.selectMenuItem();
					ePost.getNumberOfCategoriesItemsPopulated();
					ePost.selectCategoriesItem();
					ePost.getNumberOfDetailsDiscriptionData();
					ePost.clickOnAnotherMenuItems();
					ePost.getNumberOfDetailsDiscriptionData();
					ePost.getNumberOfCategoriesItemsPopulated();
					ePost.clickOnClearButton();
					Thread.sleep(5000);
					ePost.getNumberOfMenuItemsPopulated();
					Thread.sleep(5000);
					ePost.getNumberOfCategoriesItemsPopulated();
					ePost.getNumberOfDetailsDiscriptionData();
					ePost.clickOnCloseIcon();
					diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				ePost.clickOnCloseIcon();
    				diHome.logOut();
    			}
    			ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR","1960",ReportStatus.strMethodName,intCounter,browser);

				//To close the browser after each iteration
				fnCloseTest();
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
	
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void basicSearchInEpost(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "basicSearchInEpost", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("basicSearchInEpost", TestData, "D3CallRecieving",intCounter);
    	
					this.reporter.initTestCaseDescription("1960: TC-CR Epost"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					login.login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(10000);
					home.messageDialogBoxClose();

					//Click on Help and select Epost
					ePost.clickOnDrpdwnHelp();
					ePost.clickOnEpost();
					ePost.verifyElectronicPost();

					//enter keyword in searchbox and click on search button and select Highlighted keyword menu amd sub menu
					ePost.enterDataInKeyboard(data.get("KeyboardData"));
					ePost.clickOnSearchButton();
					ePost.getNumberOfMenuItemsPopulated();
					ePost.clickOnHighlightednameInMenuAndCatergories();
					ePost.clickOnHighlightednameInCategories();
					Thread.sleep(3000);

					//Click on clear button
					ePost.clickOnClearButton();
					Thread.sleep(3000);

					//retrieve details dscription and categories and click on hilighted menu categories
					ePost.getNumberOfDetailsDiscriptionData();
					ePost.getNumberOfCategoriesItemsPopulated();
					ePost.clickOnHighlightednameInMenuAndCatergories();
					ePost.clickOnCloseIcon();
					diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				ePost.clickOnCloseIcon();
    				diHome.logOut();
    			}
    			ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR","1960",ReportStatus.strMethodName,intCounter,browser);

				//To close the browser after each iteration
				fnCloseTest();
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void filteredSearchInEpost(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "filteredSearchInEpost", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					//Open the browser in each iteration
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("filteredSearchInEpost", TestData, "D3CallRecieving",intCounter);
    	
					this.reporter.initTestCaseDescription("1960: TC-CR Epost"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					login.login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(10000);
					home.messageDialogBoxClose();


					//Click on Help and select Epost
					ePost.clickOnDrpdwnHelp();
					ePost.clickOnEpost();
					ePost.verifyElectronicPost();
					ePost.clickOnMenuCheckbox();
					ePost.clickOnCategoriesCheckbox();
					ePost.clickOnDetatilsCheckbox();

					//enter keyword in searchbox and click on search button and select Highlighted keyword menu amd sub menu
					ePost.enterDataInKeyboard(data.get("KeyboardData"));
					ePost.clickOnSearchButton();
					ePost.clickOnHighlightednameInMenuAndCatergories();
					ePost.clickOnHighlightednameInMenuAndCatergories();
					ePost.getNumberOfCategoriesItemsPopulated();
					ePost.clickOnSearchButton();
					ePost.clickOnHighlightednameInMenuAndCatergories();
					Thread.sleep(5000);
					ePost.verifyDetailedInfoByCategoriesItemsPopulated();

					//click on popout
					ePost.clickOnPopout();
					switchToWindow();
					ePost.selectMenuItem();

					//click on popin
					ePost.clickOnPopIn();
					switchToWindow();
					ePost.clickOnCloseIcon();
					diHome.logOut();
					}
					catch(Exception e)
					{
						ReportStatus.blnStatus=false;
					}
					finally
				    {
						ePost.clickOnPopIn();
						ePost.clickOnCloseIcon();
						diHome.logOut();
					}

				ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1960",ReportStatus.strMethodName,intCounter,browser);
				fnCloseTest();
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

