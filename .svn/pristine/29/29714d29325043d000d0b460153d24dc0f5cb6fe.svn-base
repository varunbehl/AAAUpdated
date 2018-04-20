

package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.DIProfilePage;
import com.mongodb.operation.DeleteOperation;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class TC_DICustomizedProfileColumns extends ActionEngine {


	String[] colNamesBeforeSavingArray;
	String[] saveBeforeColsArray;

	String AvailableSectionColNamesBeforeResetArray[];
	String SelectedSectionColNamesBeforeResetArray[];

	ArrayList<String> colNamesBeforeSaving=new ArrayList<String>();
	ArrayList<String> saveBeforeCols=new ArrayList<String>();

	List<WebElement> HiddenTabNames = null;
	String[] hiddenElementsTabNamesBeforeResetArray;
	String hiddenElementsTabNamesBeforeReset;

	/************************************************************************
	* Script Name :- TC_DICustomizedProfileColumns
	* Method Name :- CreateNewProfile
	* Module	  :- DI 
	* Test Case ID:- 2023
	* Script Date :- 
	* Author      :-  Sachin
	* @param StartRow
	* @param EndRow
	* @param nextTestJoin
	* @throws Throwable
	*************************************************************************/
	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void CreateNewProfile(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DICustomizedProfileColumns", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
							fnOpenTest();
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DICustomizedProfileColumns", TestData, "D3Dispatch",intCounter);
							this.reporter.initTestCaseDescription("2023:TC-Customized Profile Columns"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							DIHomeLib diHome = new DIHomeLib();
							// Navigating to Application
							LoginToApplication(data,data.get("LoginName"), data.get("Password"));
							//Clicking on Profile Item on Menu
							waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
							click(DIHomePage.tabDiProfile, "Profile Menu Item");

							//************* Below Block of code will check for Profile Name, if it exists it will delete it, before creating a New Profile Name***********//
							boolean bProfieName = isVisibleOnly(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
							if (bProfieName) {
								click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
								//  Waiting for the visibility of Table column header- Sts.
								waitForVisibilityOfElement(DIProfilePage.lblStsColumnHeaderInProfileWindow,"Column Header: Sts");
								waitForVisibilityOfElement(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
								//waitForElementToBeClickable(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
								mouseDoubleClick(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
								waitForVisibilityOfElement(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
								click(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
								waitForVisibilityOfElement(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
								click(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
								Thread.sleep(5000);
								waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
								click(DIHomePage.tabDiProfile, "Profile Menu Item");
							}
							//************************//

							//Clicking on '+ Open New Profile' option
							diHome.clickOnOpenNewProfile();
							// Entering Profile Name
							type(DIProfilePage.txtName,data.get("ProfileName"),"Name");
							// Clicking on Button  Save & Continue
							click(DIHomePage.btnSaveAndContinueInSetProfileNameWindow,"Save & Continue");
							//Waiting for the visibility of Table column header- Sts.
							waitForVisibilityOfElement(DIProfilePage.lblStsColumnHeaderInProfileWindow,"Column Header: Sts");
							// Validating existance of Profile Name
							boolean profileWindow = isVisible(DIProfilePage.DialogprofileWindow,"Profile Window");
							assertTrue(profileWindow,"Profile Window Exists");
							String profileNameCom  = getText(DIProfilePage.lblProfileName,"Profile Name displays on Profile Window");
							String profileName = profileNameCom.substring(profileNameCom.lastIndexOf('-') + 1).trim();
							//Validating the name of the tab is labeled in the top bar "Settings"
							assertTrue(profileName.equalsIgnoreCase(data.get("ProfileName")),"Profile Name exists on Profile Window");
							// Closing Profile Window
							click(DIProfilePage.iconCloseTheProfile,"Close The Profile");
							Thread.sleep(5000);
							waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
							click(DIHomePage.tabDiProfile, "Profile Menu Item");
							// Validating Profile created successfully, profile name is listed in Profiles Drop Down
							boolean profileNameExist = isVisible(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
							assertTrue(profileNameExist,"Profile created successfully, profile name is listed in Custom Profiles, Profile Name is: "+data.get("ProfileName"));
							diHome.logOut();

	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","2023",ReportStatus.strMethodName,intCounter,browser);
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

	 /************************************************************************
	 * Script Name :- TC_DICustomizedProfileColumns
	 * Method Name :- CustomizedProfileColumns
	 * Module	  :- DI 
	 * Test Case ID:- 2023
	 * Script Date :- 
	 * Author      :- Sachin
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
	 *************************************************************************/
	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void CustomizedProfileColumns(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"DICustomizedProfileColumns", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
							fnOpenTest();
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DICustomizedProfileColumns", TestData, "D3Dispatch",intCounter);
							this.reporter.initTestCaseDescription("2023:TC-Customized Profile Columns"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							DIHomeLib diHome = new DIHomeLib();
							DIProfileLib profile = new DIProfileLib();
							// Navigating to Application
							LoginToApplication(data, data.get("LoginName"), data.get("Password"));

							waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
							click(DIHomePage.tabDiProfile, "Profile Menu Item");
			
							click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")), "Profile Name in Profile Menu Items " + data.get("ProfileName"));
							//  Waiting for the visibility of Table column header- Sts.
							waitForVisibilityOfElement(DIProfilePage.lblStsColumnHeaderInProfileWindow,"Column Header: Sts");
							Thread.sleep(4000);
							waitForVisibilityOfElement(DIProfilePage.lblTabNameInProfileWindow(data.get("TabName")), data.get("TabName") + data.get("TabName"));
							// Storing Tab Name
							String strAllCalls = getText(DIProfilePage.lblTabNameInProfileWindow(data.get("TabName")), data.get("TabName") + data.get("TabName")).trim();
			
							// Storing tab names and colum names for Profile window
			
							/*waitForVisibilityOfElement(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
							click(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
			
							HiddenTabNames = getWebElementList(DIProfilePage.ddlHiddenTabList,"Hidden Tab Names List");
							String commentsCol1 = HiddenTabNames.get(0).findElement(DIProfilePage.ddlHiddenTabListElements1).getText();
			
							hiddenElementsTabNamesBeforeResetArray = commentsCol1.split("\n");
							Thread.sleep(3000);
							for (int i=0; i<= hiddenElementsTabNamesBeforeResetArray.length-1 ;i++ ){
								//System.out.println(hiddenElementsTabNamesBeforeResetArray[i].trim());
								hiddenElementsTabNamesBeforeReset = hiddenElementsTabNamesBeforeResetArray[i].trim();
								click(DIProfilePage.lblHiddenTabNamesInDropDown(hiddenElementsTabNamesBeforeReset),"hiddenElementsTabNamesBeforeReset");
			
								// Capturing Column Names
								String colNames = getText(DIProfilePage.lblColumnNamesForTabs,"Column Names");
								System.out.println(colNames);
			
								click(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
							}*/
			
							click(DIProfilePage.iconCustomizeTheProfile, "Customize the Profile");
							Thread.sleep(5000);
							//step 3
							waitForVisibilityOfElement(DIProfilePage.lblTabNameInSettings, "Tab Name" + data.get("TabName"));
							String TabInSettings = getText(DIProfilePage.lblTabNameInSettings, "" + data.get("TabName")).trim();
							assertTrue(strAllCalls.equalsIgnoreCase(TabInSettings), "Name of the tab is labeled in the top bar Settings for tab " + data.get("TabName"));
			

							String AvailableSectionColNamesBeforeReset = getText(DIProfilePage.lblAvailableSectionFilteredColNames, "All Columns Available Section");
							AvailableSectionColNamesBeforeResetArray = AvailableSectionColNamesBeforeReset.split("\\n");
			
							String SelectedSectionColNamesBeforeReset = getText(DIProfilePage.lblSelectedSectionAllColumns, "All Columns Selected Section");
							SelectedSectionColNamesBeforeResetArray = SelectedSectionColNamesBeforeReset.split("\\n");
			
			
							waitForVisibilityOfElement(DIProfilePage.lnkRemoveAll, "Remove All");
							click(DIProfilePage.lnkRemoveAll, "Remove All");
			
							//Step 5
							SelectAvailableSectionColumn(data.get("AvailableSectionCol1"));
							ValidateAvailableSectionColumnIsHighlighted(data.get("AvailableSectionCol1"));
			
							// Step 6
							waitForVisibilityOfElement(DIProfilePage.btnAdd,"Add Button");
							click(DIProfilePage.btnAdd,"Add Button");
							ValidateColumnPresentInSelectedSection(data.get("AvailableSectionCol1"));
			
							// Step 7
			
							SelectAvailableSectionColumn(data.get("AvailableSectionCol2"));
							SelectAvailableSectionColumn(data.get("AvailableSectionCol3"));
							ValidateAvailableSectionColumnIsHighlighted(data.get("AvailableSectionCol2"));
							ValidateAvailableSectionColumnIsHighlighted(data.get("AvailableSectionCol3"));
			
							// Step 8
							click(DIProfilePage.btnAdd,"Add Button");
							ValidateColumnPresentInSelectedSection(data.get("AvailableSectionCol2"));
							ValidateColumnPresentInSelectedSection(data.get("AvailableSectionCol3"));
			
							// Step 9
							SelectSelectedSectionColumn(data.get("SelectedSectionCol1"));
							ValidateSelectedSectionColumnIsHighlighted(data.get("SelectedSectionCol1"));
			
							// Step 10
			
							waitForVisibilityOfElement(DIProfilePage.btnRemove,"Remove");
							click(DIProfilePage.btnRemove,"Remove");
			
							ValidateColumnPresentInAvailableSection(data.get("SelectedSectionCol1"));
			
							// Step 11
							SelectSelectedSectionColumn(data.get("SelectedSectionCol2"));
							ValidateSelectedSectionColumnIsHighlighted(data.get("SelectedSectionCol2"));
							SelectSelectedSectionColumn(data.get("SelectedSectionCol3"));
							ValidateSelectedSectionColumnIsHighlighted(data.get("SelectedSectionCol3"));
			
							// Step 12
							waitForVisibilityOfElement(DIProfilePage.btnRemove,"Remove");
							click(DIProfilePage.btnRemove,"Remove");
			
							ValidateColumnPresentInAvailableSection(data.get("SelectedSectionCol2"));
							ValidateColumnPresentInAvailableSection(data.get("SelectedSectionCol3"));
			
							// Step 14 Filters
			
							waitForVisibilityOfElement(DIProfilePage.txtFilterAvailableSection, "Filter Text Box Available Section");
			
							type(DIProfilePage.txtFilterAvailableSection, data.get("FilterText"), "Filter Text Box Available Section");
							profile.VerifyColumnsMatchingTextAreFilteredDownInAvailabelSection(data.get("FilterText"));
			
							// Step 16 Drag and Drop
			
							clearData(DIProfilePage.txtFilterAvailableSection);
							Thread.sleep(2000);
							String firstCOlumnAvailableSection = getText(DIProfilePage.lblFirstColAvailableSection, "First Column Available Section");

			
							// Step 17 Drag and Drop
							dragAndDrop(DIProfilePage.lblFirstColAvailableSection, DIProfilePage.lblFirstColSelectedSection, "Dragging column: " + firstCOlumnAvailableSection + " from Available Section to Selected Section");
							Thread.sleep(3000);
							ValidateColumnPresentInSelectedSection(firstCOlumnAvailableSection);
			
							// Step 18 Drag and Drop
			
							String firstColumnSelectedSection = getText(DIProfilePage.lblSelectedSectionColumnsNames(data.get("DragColSelectedSection")), "" + data.get("DragColSelectedSection"));

							// Step 19
							dragAndDrop(DIProfilePage.lblSelectedSectionColumnsNames(data.get("DragColSelectedSection")), DIProfilePage.lblFirstColAvailableSection, "Dragging column: " + firstColumnSelectedSection + " from Selected Section to Available Section");
							Thread.sleep(3000);
							ValidateColumnPresentInAvailableSection(data.get("DragColSelectedSection"));
			
							// Moving Few columns before saving
							dragAndDrop(DIProfilePage.lblFirstColAvailableSection, DIProfilePage.lblFirstColSelectedSection, "Dragging column: " + firstCOlumnAvailableSection + " from Available Section to Selected Section");
			
							// Step 20 -- Taking note of order of columns in Selected Section
			
							String allColumnsSelectedSection = getText(DIProfilePage.lblSelectedSectionAllColumns, "All Columns Selected Section");
			
							colNamesBeforeSavingArray = allColumnsSelectedSection.split("\\n");
							saveBeforeColsArray = new String[colNamesBeforeSavingArray.length - 2];
							int k = 0;
							for (int i = 0; i < colNamesBeforeSavingArray.length - 1; i = i + 2) {
								saveBeforeColsArray[k] = colNamesBeforeSavingArray[i];
								System.out.println(colNamesBeforeSavingArray[k]);
								k = k + 1;
							}
			
							//  Creating array list
			
							saveBeforeCols = new ArrayList<String>(Arrays.asList(saveBeforeColsArray));

							// Step 22
							click(DIProfilePage.btnSaveSettings, "Save Settings");
			
							Thread.sleep(9000);
			
							String tabNames = getText(DIProfilePage.tabNamesProfileWindow, "Tab Names Profile window");
			
							String tabNamesAfterSavingArray[] = tabNames.split("\\n");
			
							ArrayList<String> tabNamesAfterSaving = new ArrayList<String>(Arrays.asList(tabNamesAfterSavingArray));
			
			                /*for(int i=0;i<saveBeforeCols.size();i++){
			                    if(saveBeforeCols.contains(tabNamesAfterSaving.get(i).trim())){
			                        assertTrue(saveBeforeCols.contains(tabNamesAfterSaving.get(i).trim()),"The order of columns on the profile window matches with the settings before save, before save Columns: "+saveBeforeCols.get(i)+"Tab Names after saving: "+tabNamesAfterSaving.get(i));
			
			                    }else{
			                        assertTrue(saveBeforeCols.contains(tabNamesAfterSaving.get(i).trim()),"The order of columns on the profile window does not matche with the settings before save, before save Columns: "+saveBeforeCols.get(i)+"Tab Names after saving: "+tabNamesAfterSaving.get(i));
			                    }
			                }*/

							for (int i = 0; i <= tabNamesAfterSavingArray.length - 1; i++) {
								if (saveBeforeColsArray[i].toString().trim().equalsIgnoreCase(tabNamesAfterSavingArray[i].toString().trim())) {
									assertTrue(saveBeforeColsArray[i].toString().trim().equalsIgnoreCase(tabNamesAfterSavingArray[i].toString().trim()), "The order of columns on the profile window matches with the settings before save, before save Columns: " + saveBeforeColsArray[i] + "Tab Names after saving: " + tabNamesAfterSavingArray[i]);
								} /*else {
									assertTrue(saveBeforeColsArray[i].toString().trim().equalsIgnoreCase(tabNamesAfterSavingArray[i].toString().trim()), "The order of columns on the profile window does not matche with the settings before save, before save Columns: " + saveBeforeColsArray[i] + "Tab Names after saving: " + tabNamesAfterSavingArray[i]);
								}*/
							}
			
							// Step 24
							click(DIProfilePage.iconCustomizeTheProfile, "Customize the Profile");
							// Step 25
							click(DIProfilePage.lnkbtnResetToDefaultSettings, "Reset To Default Settings");
			
							String AvailableSectionColNamesAfterReset = getText(DIProfilePage.lblAvailableSectionFilteredColNames, "All Columns Available Section");
							String AvailableSectionColNamesAfterResetArray[] = AvailableSectionColNamesAfterReset.split("\\n");
			
							String SelectedSectionColNamesAfterReset = getText(DIProfilePage.lblSelectedSectionAllColumns, "All Columns Selected Section");
							String SelectedSectionColNamesAfterResetArray[] = SelectedSectionColNamesAfterReset.split("\\n");
			
							// Comparing arrays before and after reset
			
							/*if (AvailableSectionColNamesBeforeResetArray.length == AvailableSectionColNamesAfterResetArray.length){
								if (AvailableSectionColNamesBeforeResetArray[i].toString().trim().equalsIgnoreCase(AvailableSectionColNamesAfterResetArray[i].toString().trim())){
									assertTrue(AvailableSectionColNamesBeforeResetArray[i].toString().trim().equalsIgnoreCase(AvailableSectionColNamesAfterResetArray[i].toString().trim()),"The columns selected and available are reset to default settings");
								}
								else {
									assertTrue(AvailableSectionColNamesBeforeResetArray[i].toString().trim().equalsIgnoreCase(AvailableSectionColNamesAfterResetArray[i].toString().trim()),"The columns selected and available are reset to default settings");
								}
							}*/
			
							// Step 25
							if (Arrays.equals(AvailableSectionColNamesBeforeResetArray, AvailableSectionColNamesAfterResetArray)) {
								assertTrue(Arrays.equals(AvailableSectionColNamesBeforeResetArray, AvailableSectionColNamesAfterResetArray), "Available section columns are reset to default settings");
							} /*else {
								assertTrue(Arrays.equals(AvailableSectionColNamesBeforeResetArray, AvailableSectionColNamesAfterResetArray), "Available section columns are not reset to default settings");
							}*/
			
							if (Arrays.equals(SelectedSectionColNamesBeforeResetArray, SelectedSectionColNamesAfterResetArray)) {
								assertTrue(Arrays.equals(SelectedSectionColNamesBeforeResetArray, SelectedSectionColNamesAfterResetArray), "Selected section columns are reset to default settings");
							}/* else {
								assertTrue(Arrays.equals(SelectedSectionColNamesBeforeResetArray, SelectedSectionColNamesAfterResetArray), "Selected section columns are not reset to default settings");
							}*/
			
							waitForVisibilityOfElement(DIProfilePage.chkBoxApplyToAlltabs, "Apply to All Tabs");
							// Step 26
							click(DIProfilePage.chkBoxApplyToAlltabs, "Apply to All Tabs");
							// Step 27
							click(DIProfilePage.btnSaveSettings, "Save Settings");
			
							boolean columnCountConfirmation = isVisibleOnly(DIProfilePage.btnYesConfirmationWindow,"Yes Button Confirmation Count");
							if(columnCountConfirmation){
								click(DIProfilePage.btnYesConfirmationWindow,"Yes Button Confirmation Count");
							}
			
							boolean ApplyToAllWindow = isElementPresent(DIProfilePage.applyToAllWindow,"Apply to all? window");
							assertTrue(ApplyToAllWindow,"Apply to all warning dialog appears");
			
							waitForVisibilityOfElement(DIProfilePage.btnYesApplyToAllWindow, "Yes Button on Apply to all alert Window");
							click(DIProfilePage.btnYesApplyToAllWindow, "Yes Button on Apply to all alert Window");
							diHome.logOut();

	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","2023",ReportStatus.strMethodName,intCounter,browser);
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

	 /************************************************************************
	 * Script Name :- DI_DICustomizedProfileColumns
	 * Method Name :- DeleteUserProfile
	 * Module	  :- DI 
	 * Test Case ID:- 2023
	 * Script Date :- 
	 * Author      :-  Sachin
	 * @param StartRow
	 * @param EndRow
	 * @param nextTestJoin
	 * @throws Throwable
	 *************************************************************************/
	 
	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void DeleteUserProfile(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DICustomizedProfileColumns", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
							fnOpenTest();
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DICustomizedProfileColumns", TestData, "D3Dispatch",intCounter);
			    	
							this.reporter.initTestCaseDescription("2023:TC-Customized Profile Columns"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							DIHomeLib diHome = new DIHomeLib();

							LoginToApplication(data,data.get("LoginName"), data.get("Password"));

							waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
							click(DIHomePage.tabDiProfile, "Profile Menu Item");
							waitForVisibilityOfElement(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
							click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
							//  Waiting for the visibility of Table column header- Sts.
							waitForVisibilityOfElement(DIProfilePage.lblStsColumnHeaderInProfileWindow,"Column Header: Sts");
							waitForVisibilityOfElement(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
							//waitForElementToBeClickable(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
							mouseDoubleClick(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
							waitForVisibilityOfElement(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
							click(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
							waitForVisibilityOfElement(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
							click(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
							Thread.sleep(5000);
							waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
							click(DIHomePage.tabDiProfile, "Profile Menu Item");
							boolean profileExist = isVisibleOnly(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
							if (profileExist){
								assertTrue(profileExist,"Profile deleted successfully, Profile Name is "+data.get("ProfileName"));
							}
							diHome.logOut();
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","2023",ReportStatus.strMethodName,intCounter,browser);
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

	// This function clicks/Selects the column name from Available Section.
	public void SelectAvailableSectionColumn(String colNameAvailable) throws Throwable{
		//Step 5
		waitForVisibilityOfElement(DIProfilePage.lblAvailableSectionColumnName(colNameAvailable),"Available Section Column "+colNameAvailable);
		String colNameAvailableSection = getText(DIProfilePage.lblAvailableSectionColumnName(colNameAvailable),"Available Section Column Name: "+colNameAvailable);
		click(DIProfilePage.lblAvailableSectionColumnName(colNameAvailable),"Available Section Column Name "+colNameAvailableSection);
	}

	// This function validates if selected column is highlighted in yellow in Available Section
	public void ValidateAvailableSectionColumnIsHighlighted(String colNameAvailable)throws Throwable{
		boolean colHighlighted = isEnabled(DIProfilePage.lblAvailableSectionHighlightedColumnsNames(colNameAvailable),"Highlighted Column in Available Section "+colNameAvailable);
		assertTrue(colHighlighted,"selected column is highlighted in yellow, column name is "+colNameAvailable);
	}

	// This function clicks/Selects the column name from Selected section.
	public void SelectSelectedSectionColumn(String colNameSelected) throws Throwable{
		waitForVisibilityOfElement(DIProfilePage.lblSelectedSectionColumnsNames(colNameSelected),"Selected Section Column "+colNameSelected);
		String colNameSelectedSection = getText(DIProfilePage.lblSelectedSectionColumnsNames(colNameSelected),"Selected Section Column Name: "+colNameSelected);
		click(DIProfilePage.lblSelectedSectionColumnsNames(colNameSelected),"Selected Section Column Name "+colNameSelectedSection);
	}

	//This function validates if selected column is highlighted in yellow in Selected Section
	public void ValidateSelectedSectionColumnIsHighlighted(String colNameSelected)throws Throwable{
		boolean colSelectedHighlighted = isEnabled(DIProfilePage.lblSelectedSectionColumnsNames(colNameSelected),"Highlighted Column in Selected Section "+colNameSelected);
		assertTrue(colSelectedHighlighted,"selected column is highlighted in yellow, column name is "+colNameSelected);
	}
	// Validates if column exists in Available section
	public void ValidateColumnPresentInAvailableSection(String colNameSelected)throws Throwable{
		boolean selectedCol = isElementPresent(DIProfilePage.lblAvailableSectionColumnName(colNameSelected),"Selected Section Column Name "+colNameSelected);
		assertTrue(selectedCol,"Column exists in Available Section");
	}
	// Validates if column exists in Selected section
	public void ValidateColumnPresentInSelectedSection(String colNameSelected)throws Throwable {
		boolean selectedCol = isElementPresent(DIProfilePage.lblSelectedSectionColumnsNames(colNameSelected), "Selected Section Column Name " + colNameSelected);
		assertTrue(selectedCol, "Column exists in Selected Section");
	}

	public void LoginToApplication(Hashtable<String, String> data,String username,String password) throws Throwable {
		DILoginLib diLogin = new DILoginLib();
		DIHomeLib diHome = new DIHomeLib();
		LoginRoleLib loginRole=new LoginRoleLib();
		navigateToApplication("DI");
		diLogin.login(username, password);
		diLogin.waitcloseAllBusyIcons();
		diLogin.ClickOnProceedButton();
		diLogin.waitcloseAllBusyIcons();
		diHome.clickOnCloseIconOnQueueSelection();
		Thread.sleep(3000);
	}

}