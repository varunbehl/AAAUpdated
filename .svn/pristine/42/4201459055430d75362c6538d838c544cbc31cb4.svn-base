

package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.*;
import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TC_DISPPManageTechnicians extends ActionEngine {

  
    /************************************************************************
    * Script Name :- TC_DISPPManageTechnicians
    * Method Name :-
    * Module	  :- DI
    * Test Case ID:- 2054
    * Script Date :- 
    * Author      :- Sachin
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    *************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void SPPManageTechnicians(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SPPManageTechnicians", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
						fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SPPManageTechnicians", TestData, "D3Dispatch",intCounter);
		                this.reporter.initTestCaseDescription("2054:TC_DISPPManageTechnicians"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");

						DIHomeLib diHome = new DIHomeLib();
						DIManageTechniciansLib managetechnicians = new DIManageTechniciansLib();

						// Logging into the application
						LoginToDIApplication(data);

						//Step 2
						diHome.clickOnAppliationListInMenu();
						managetechnicians.clickOnManageTechnicians();
						boolean bManagetechNiciansWindow  = managetechnicians.verifyManageTechniciansWindowExists();
						assertTrue(bManagetechNiciansWindow,"The Manage Technician screen is in view");

						// Deleting the technician if not deleted in Previous run
						String strLoginNam = getText(DIManageTechniciansPage.selectLoginNameFromTable(data.get("Login")),"Login Name in Search Table").trim();
						if(strLoginNam.equalsIgnoreCase(data.get("Login"))){
								click(DIManageTechniciansPage.selectLoginNameFromTable(data.get("Login")),"Login Name in Search Table");
								managetechnicians.clickOnDelete();
								// Clicking on Yes button on Delete
								managetechnicians.clickOnYesButtonOnChangesWillBeLostWidnow();
						}

						//  Getting the Facility and Driver ID of the first Technician  and deleting that technician and using the same Faicility and driver id to create new technician

						String strDriverIDFcility = managetechnicians.getFacilityAndDriverIDFromFirstRow();
                        String[] arrFirstSplit = strDriverIDFcility.split("/");
						String strFacilityID = arrFirstSplit[0].substring(arrFirstSplit[0].length()-4);

						// If there is no facility/Technician available in Manage technician search table the use then facility from excel sheet
						if (strFacilityID == ""){
							strFacilityID = data.get("FacilityID");
						}

						String strDriverID  = arrFirstSplit[1];
						// If there is no Driver/Technician available in Manage technician search table then use the facility from excel sheet
						if (strDriverID == ""){
							strFacilityID = data.get("DriverID");
						}

						if( strFacilityID != "") {
							managetechnicians.SelectFirstRowManageTechniciansSearchTable();
							managetechnicians.clickOnDelete();
							managetechnicians.clickOnYesButtonOnChangesWillBeLostWidnow();
						}

						//Step 3
						// Clicking on Down arrow button
						managetechnicians.clickOnDownArrowButton();
						Thread.sleep(5000);

						// Validating The list of only the SPMG facilities should show which for this test case is facility 5140, 5145 & 5001

						List<WebElement> elements = driver.findElements(DIManageTechniciansPage.lstFacilities);
						for(int i = 0; i <= elements.size() - 1; i++){
							if (data.get("AllFacilities").contains(elements.get(i).getText())){
								assertTrue(true,"Expected Facility "+elements.get(i).getText()+" exists in facility drop down field");
							} else{
								assertTrue(false,"Expected Facility "+elements.get(i).getText()+" does not exists in facility drop down field");
							}
						}

						// Step 4 - Clicking on New Button
						managetechnicians.clickOnNewButton();
						Thread.sleep(3000);

						// Validating Login Text field exists
						boolean bLogin = managetechnicians.verifyLoginTextBoxExists();
					 	assertTrue(bLogin,"Technician section displays Login field");

						// Validating First Name Text field exists
						boolean bFirstName = managetechnicians.verifyFirstNameTextBoxExists();
						assertTrue(bFirstName,"Technician section displays First name field");

						// Validating Last Name Text field exists
						boolean bLastName = managetechnicians.verifyLastNameTextBoxExists();
						assertTrue(bLastName,"Technician section displays Last name field");

						// Validating Email Text field exists
						boolean bEmail = managetechnicians.verifyEmailTextBoxExists();
						assertTrue(bEmail,"Technician section displays Email field");

						// Validating Role Drop Down field exists
						boolean bRole = managetechnicians.verifyPhoneTypeFieldExists();
						assertTrue(bRole,"Technician section displays Role Drop Down field");

						// Validating Tech Assist User field exists
						boolean bTEchAssistUser = managetechnicians.verifyTechAssistUserCheckBoxFieldExists();
						assertTrue(bTEchAssistUser,"Technician section displays Tech Assist User check box field");

						// Validating Phone Number field exists
						boolean bPhoneNUmber = managetechnicians.verifyPhoneNumberFieldExists();
						assertTrue(bPhoneNUmber,"Technician section displays Phone Number field");

						// Validating Extension field exists
						boolean bExtension = managetechnicians.verifyExtensionFieldExists();
						assertTrue(bExtension,"Technician section displays Ext: field");

						// Validating Type Drop Down field exists
						boolean bType = managetechnicians.verifyRoleDropDownFieldExists();
						assertTrue(bType,"Technician section displays Type Drop down field");

						// Validating Technician Photo field exists
						boolean bTechnicianPhoto = managetechnicians.verifyTechnicianPhotoFieldExists();
						assertTrue(bTechnicianPhoto,"Technician section displays Technician field");

						// Validating Technician Comments field exists
						boolean bTechnicianComments = managetechnicians.verifyTechnicialCommentsFieldExists();
						assertTrue(bTechnicianComments,"Technician section displays Technician Comments field");

						// Step 5
						// Entering Data in Login text box
						managetechnicians.enterLogin(data.get("Login"));

						// Validating Login data is entered successfully
						String strLogin = managetechnicians.getLoginText();
						assertTrue(strLogin.equalsIgnoreCase(data.get("Login")),"Login field displays data that was entered, expected data is "+data.get("Login")+" Actual data is "+strLogin);

						// Entering Data in First Name text box
						managetechnicians.enterFirstName(data.get("FirstName"));

						// Validating First Name data is entered successfully
						String strFirstName = managetechnicians.getFirstNameText();
						assertTrue(strFirstName.equalsIgnoreCase(data.get("FirstName")),"First Name field displays data that was entered, expected data is "+data.get("FirstName")+" actual data is "+strFirstName);

						// Entering Data in Last Name text box
						managetechnicians.enterLastName(data.get("LastName"));

						// Validating Last Name data is entered successfully
						String strLastName = managetechnicians.getLastNameText();
						assertTrue(strLastName.equalsIgnoreCase(data.get("LastName")),"Last Name field displays data that was entered, expected data is "+data.get("LastName")+" actual data is "+strLastName);

						// Entering Role
						managetechnicians.enterRole(data.get("Role"));

						// Entering Data in Email text box
						managetechnicians.enterEmail(data.get("Email"));

						// Validating Email data is entered successfully
						String strEmail = managetechnicians.getEmailText();
						assertTrue(strEmail.equalsIgnoreCase(data.get("Email")),"Email field displays data that was entered, expected data is "+data.get("Email")+" actual data is "+strEmail);

						// Clicking on techAssist User check box
						managetechnicians.clickOnTechAssistUserCheckBox();


						// Validating CheckBox field is clicked
						boolean isSelected = isCheckBoxSelected(DIManageTechniciansPage.chkBoxtechAssistUser);
						assertTrue(isSelected = true ,"Checked box is in checked mode");

						// Validating selected Role Option
						String roleName = managetechnicians.getSelectedRoleOption();
						assertTrue(roleName.equalsIgnoreCase(data.get("Role")),"Role field displays data that was selected, expected data is "+data.get("Role")+" actual data is "+roleName);

						// Entering Data in Number text box
						managetechnicians.enterNumber(data.get("PhoneNumber"));

						// Validating Number data is entered successfully
						String strNumber = managetechnicians.getNumberText();
						assertTrue(strNumber.equalsIgnoreCase(data.get("PhoneNumber")),"Number field displays data that was entered, expected data is "+data.get("PhoneNumber")+" actual data is "+strNumber);

						// Entering Data in Extension text box
						managetechnicians.enterEntension(data.get("Extension"));

						// Validating Extension data is entered successfully
						String strExtension = managetechnicians.getExtensionNumber();
						assertTrue(strExtension.equalsIgnoreCase(data.get("Extension")),"Extension field displays data that was entered, expected data is "+data.get("Extension")+" actual data is "+strExtension);

						//Entering Type
						managetechnicians.enterType(data.get("Type"));

						// Entering Data in technical Comments text box
						managetechnicians.enterTechnicalComments(data.get("TechnicalCommnets"));

						// Validating technical Comments data is entered successfully
						String strTechnicalComments = managetechnicians.getTechnicalComments();
						assertTrue(strTechnicalComments.equalsIgnoreCase(data.get("TechnicalCommnets")),"Technical comments text area field displays data that was entered, expected data is "+data.get("TechnicalCommnets")+" actual data is "+strTechnicalComments);

						// Validating selected Type Option
						String typeName = managetechnicians.getSelectedTypeOption();
						assertTrue(typeName.equalsIgnoreCase(data.get("Type")),"Type field displays data that was selected, expected data is "+data.get("Type")+" actual data is "+typeName);

						// Step 6
						// Clicking On Save button
						managetechnicians.clickOnSaveButton();


						//Validating error mesage
						String errorMessage = managetechnicians.getErrorContent();
						assertTrue(errorMessage.equalsIgnoreCase(data.get("ErrorMessage")),"The Facility Assignment tab should be in view displaying a required info message, expected message is "+data.get("ErrorMessage")+" actual message is "+errorMessage);

						// Step 7
						//Click on Facilities Drop Down
						Thread.sleep(5000);
						managetechnicians.clickOnDownArrowFacilities();

						// Validating Only the facilities that are part of the SPMG should show on the list
						List<WebElement> lstFacilityAssignmentTab = driver.findElements(DIManageTechniciansPage.lstFacilityListFacilityAssignmentTab);
						for(int i = 0; i <= lstFacilityAssignmentTab.size() - 1; i++){
							if (data.get("AllFacilities").contains(lstFacilityAssignmentTab.get(i).getText())){
								assertTrue(true,"Expected Facility "+lstFacilityAssignmentTab.get(i).getText()+" exists in facility drop down field in facility assignment tab");
							} else{
								assertTrue(false,"Expected Facility "+lstFacilityAssignmentTab.get(i).getText()+" does not exists in facility drop down field in facility assignment tab");
							}
						}

						Thread.sleep(5000);

						// Step 8
						managetechnicians.selectFacilityDropDownOptions("Facility",strFacilityID);


						// Step 10
						// Click on Down Arrow - DriverID

						Thread.sleep((3000));
						managetechnicians.clickOnDownArrowDriver();
						Thread.sleep(2000);
						managetechnicians.selectDriverDropDownOptions("Driver",strDriverID);
						Thread.sleep(2000);
						managetechnicians.clickOnFacilityAssignmentTab();

						// Stpe 11
						//Click on Add button
						managetechnicians.clickOnAdd();

						// Validating The driver and facility are displayed on the Facilities Assigned section

						String strFacilityDriver = managetechnicians.getFacilitiesDriverAssignedText();
						String[] arrFacilityDriver = new String[2];
						arrFacilityDriver = strFacilityDriver.split("/");

						// Validating Facility ID on Facilities Assigned Area

						assertTrue(strFacilityID.equalsIgnoreCase(arrFacilityDriver[0].trim()),"Facility is displayed on Facilities Assigned section expected facility id is "+strFacilityID+" Actual facility id is "+arrFacilityDriver[0]);

						String[] arrDriverPart = arrFacilityDriver[1].split(":");

						String driverID = arrDriverPart[1].trim();

						// Validating Driver ID on Facilities Assigned Area

						//assertTrue(data.get("DriverID").equalsIgnoreCase(driverID),"Driver ID is displayed on Facilities Assigned section expected driver id is"+data.get("DriverID")+" Actual driver id is "+driverID);
						assertTrue(strDriverID.equalsIgnoreCase(driverID),"Driver ID is displayed on Facilities Assigned section expected driver id is "+strDriverID+" Actual driver id is "+driverID);

						// Step 12
						//Clicking on close ICON on Facilities Assigned Text Area
						managetechnicians.clickOnCloseIconOnfacilitiesAssigned();

						// Get text from No Facilities assigned Label
						String strNoFacilitiesAssigned = managetechnicians.getTextFromNoFacilitiesAssigned();

						// Validating No facilities are assigned
						assertTrue(strNoFacilitiesAssigned.equalsIgnoreCase("No facilities assigned."),"The driver and facility are removed");

						// Step 13 -- Adding Facility and Driver and clicking on Save Button
						Thread.sleep(5000);

						managetechnicians.clickOnDownArrowFacilities();
						Thread.sleep(2000);
						managetechnicians.selectFacilityDropDownOptions("Facility",strFacilityID);
						Thread.sleep(2000);
						managetechnicians.clickOnFacilitiesAssignedSection();
						Thread.sleep(5000);

						//Selecting Driver ID from Driver drop down
						managetechnicians.clickOnDownArrowDriver();
						Thread.sleep(2000);
						managetechnicians.selectDriverDropDownOptions("Driver",strDriverID);
						Thread.sleep(2000);
						managetechnicians.clickOnFacilitiesAssignedSection();

						//Click on Add button
						managetechnicians.clickOnAdd();
						//Click on Save Button
						managetechnicians.clickOnSaveButton();

						// Validating confirmation save message should have been displayed.

						waitForVisibilityOfElement(DIManageTechniciansPage.notificationConfirmationMessage,"Confirmation save message  ");
						boolean  notification = isVisible(DIManageTechniciansPage.notificationConfirmationMessage,"Confirmation save message  ");
						assertTrue(notification,"A confirmation save message have been displayed.");

						// Step 14 ---
						// Selecting Technician Name
						managetechnicians.clickTechnicianFromManageTechnicianSearchTable(data.get("Login"));
						Thread.sleep(2000);

						//  Validating all the entered details are refelected correctly or not

						// Validating Login data is entered successfully
						strLogin = managetechnicians.getLoginText();
						assertTrue(strLogin.equalsIgnoreCase(data.get("Login")),"Login field displays data that was entered, expected data is "+data.get("Login")+" Actual data is "+strLogin);


						// Validating First Name data is entered successfully
						strFirstName = managetechnicians.getFirstNameText();
						assertTrue(strFirstName.equalsIgnoreCase(data.get("FirstName")),"First Name field displays data that was entered, expected data is "+data.get("FirstName")+" actual data is "+strFirstName);

						// Validating Last Name data is entered successfully
						strLastName = managetechnicians.getLastNameText();
						assertTrue(strLastName.equalsIgnoreCase(data.get("LastName")),"Last Name field displays data that was entered, expected data is "+data.get("LastName")+" actual data is "+strLastName);

						// Validating Email data is entered successfully
						 strEmail = managetechnicians.getEmailText();
						assertTrue(strEmail.equalsIgnoreCase(data.get("Email")),"Email field displays data that was entered, expected data is "+data.get("Email")+" actual data is "+strEmail);

						// Validating selected Role Option
						roleName = managetechnicians.getSelectedRoleOption();
						assertTrue(roleName.equalsIgnoreCase(data.get("Role")),"Role field displays data that was selected, expected data is "+data.get("Role")+" actual data is "+roleName);

						// Validating CheckBox field is clicked
						isSelected = isCheckBoxSelected(DIManageTechniciansPage.chkBoxtechAssistUser);
						assertTrue(isSelected = true ,"Checked box is in checked mode");

						// Validating Number data is entered successfully
						strNumber = managetechnicians.getNumberText();
						assertTrue(strNumber.equalsIgnoreCase(data.get("PhoneNumber")),"Number field displays data that was entered, expected data is "+data.get("PhoneNumber")+" actual data is "+strNumber);

						// Validating Extension data is entered successfully
						strExtension = managetechnicians.getExtensionNumber();
						assertTrue(strExtension.equalsIgnoreCase(data.get("Extension")),"Extension field displays data that was entered, expected data is "+data.get("Extension")+" actual data is "+strExtension);

						// Validating technical Comments data is entered successfully
						strTechnicalComments = managetechnicians.getTechnicalComments();
						assertTrue(strTechnicalComments.equalsIgnoreCase(data.get("TechnicalCommnets")),"Technical comments text area field displays data that was entered, expected data is "+data.get("TechnicalCommnets")+" actual data is "+strTechnicalComments);

						// Validating selected Type Option
						typeName = managetechnicians.getSelectedTypeOption();
						assertTrue(typeName.equalsIgnoreCase(data.get("Type")),"Type field displays data that was selected, expected data is "+data.get("Type")+" actual data is "+typeName);


						// Clicking on Facility Assignment Tab
						managetechnicians.clickOnFacilityAssignmentTab();
						Thread.sleep(1000);

						// Validating The driver and facility are displayed on the Facilities Assigned section

						 strFacilityDriver = managetechnicians.getFacilitiesDriverAssignedText();
						 arrFacilityDriver = strFacilityDriver.split("/");

						// Validating Facility ID on Facilities Assigned Area
						//assertTrue(data.get("FacilityID").equalsIgnoreCase(arrFacilityDriver[0].trim()),"Facility is displayed on Facilities Assigned section expected facility id is"+data.get("FacilityID")+" Actual driver id is "+arrFacilityDriver[0]);
						assertTrue(strFacilityID.equalsIgnoreCase(arrFacilityDriver[0].trim()),"Facility is displayed on Facilities Assigned section expected facility id is"+strFacilityID+" Actual driver id is "+arrFacilityDriver[0]);
						arrDriverPart = arrFacilityDriver[1].split(":");

						driverID = arrDriverPart[1].trim();

						// Validating Driver ID on Facilities Assigned Area

						assertTrue(strDriverID.equalsIgnoreCase(driverID),"Driver ID is displayed on Facilities Assigned section expected driver id is"+strDriverID+" Actual driver id is "+driverID);

						// Step 15

						// Clicking on Tab User Information
						managetechnicians.clickOnUserInformationTab();

						managetechnicians.clickOnResetPassword();

						waitForVisibilityOfElement(DIManageTechniciansPage.notificationConfirmationMessage,"Confirmation save message  ");

						notification = isVisible(DIManageTechniciansPage.notificationConfirmationMessage,"Confirmation save message  ");

						// Validating message
						assertTrue(notification,"An email confirmation message should have been displayed");

						// Step 16 ---Click the New button and add a driver with the same driver ID
						managetechnicians.clickOnNewButton();
						Thread.sleep(3000);

						managetechnicians.enterLogin(data.get("Login"));

						managetechnicians.clickOnSaveButton();

						//Click on Add button

						// Verifying if confirmation pop up window exists
						boolean bConfirmTechnicalOverWrite = managetechnicians.isConfirmTechnicalOverWriteExist();
						assertTrue(bConfirmTechnicalOverWrite,"Confirm Technician Overwrite Dialog displays");

						// Verifying conformation Pop Up message
						String strConfirmTechnicalOverWriteMessage = managetechnicians.getTextConfirmTechnicalOverWrite();
						assertTrue(strConfirmTechnicalOverWriteMessage.equalsIgnoreCase(data.get("TechnicalOverWriteMessage")),"Confirm Technician Overwrite Dialog comes up displaying a message, expected message "+data.get("TechnicalOverWriteMessage")+" actual message"+strConfirmTechnicalOverWriteMessage);

						// Step 17
						// Clicking on No Button
						managetechnicians.clickOnNoButtonConfirmTechnicalOverWrite();

						// Validating if Confirm Technical OverWrite Dialog is closed
						bConfirmTechnicalOverWrite = managetechnicians.isConfirmTechnicalOverWriteExist();
						assertTrue(bConfirmTechnicalOverWrite,"Confirm Technician Overwrite Dialog is closed");

						// Step 18

						// Entering Technician Name
						//managetechnicians.enterTechnicianLoginName(data.get("OldLogin"));
						Thread.sleep(2000);

						// Click on entered Login Name in List
						//managetechnicians.clickOnFirstLoginNameInList();
						managetechnicians.clickTechnicianFromManageTechnicianSearchTable(data.get("Login"));

						// Validating Changes will be lost PopUp window exists
						boolean bChangesLostWinodw = managetechnicians.isChangesWillbeLostWindowExist();
						assertTrue(bChangesLostWinodw,"Changes will be lost windows displays");

						//  Validating message in Changes will be lost Pop Up window

						String strChangesWillBeLostMessage = managetechnicians.getTextChangesWillBeLost();
						strChangesWillBeLostMessage = strChangesWillBeLostMessage.replace("?","");
						assertTrue(strChangesWillBeLostMessage.equalsIgnoreCase(data.get("ChangesWIllBeLostMessage")),"Changes will be lost Dialog comes up displaying a message, expected message "+data.get("ChangesWIllBeLostMessage")+" actual message"+strChangesWillBeLostMessage);

						// Step 19
						// Clicking on Yes button
						managetechnicians.clickOnYesButtonOnChangesWillBeLostWidnow();


						//  Validating Changes will be lost window is Closed
						boolean bChangesWIllBeLostPopUpWindow = managetechnicians.isConfirmTechnicalOverWriteExist();
						assertTrue(bChangesWIllBeLostPopUpWindow,"Changes will be lost Dialog is closed");

						// Validating Previously added window is in view

						String strLoginName = managetechnicians.getLoginText();
						assertTrue(strLoginName.equalsIgnoreCase(data.get("Login")),"Previously added technician should be in view");

						// Step 20
						// CLicking on Delete Button
						managetechnicians.clickOnDelete();

						// Verifying if confirmation pop up window exists
						boolean bConfirmTechnicalDelete = managetechnicians.isConfirmTechnicalOverWriteExist();
						assertTrue(bConfirmTechnicalDelete,"Confirm Technician Delete Dialog displays");

						// Verifying conformation Pop Up message
						String strConfirmDeleteMessage = managetechnicians.getTextConfirmTechnicalOverWrite();
						assertTrue(strConfirmDeleteMessage.equalsIgnoreCase(data.get("DeleteMessage")),"The Confirm Technician Delete dialog comes up displaying a message, expected message "+data.get("DeleteMessage")+" actual message"+strConfirmDeleteMessage);

						// Clicking on Yes button on Delete
						managetechnicians.clickOnYesButtonOnChangesWillBeLostWidnow();

						// Step 21

						// Validating Technician is Deleted
						managetechnicians.enterTechnicianLoginName(data.get("Login"));
						Thread.sleep(10000);
						strLoginNam = getText(DIManageTechniciansPage.selectLoginNameFromTable(data.get("Login")),"Login Name in Search Table").trim();
						assertTrue(strLoginNam =="","Technician is deleted, technician name is "+data.get("Login"));
						diHome.logOut();
    			}
    			catch(Exception e)
    			{
					ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description",e.getMessage());

				}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2054",ReportStatus.strMethodName,intCounter,browser);
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


    public void LoginToDIApplication(Hashtable<String, String> data) throws Throwable {

        DILoginLib diLogin = new DILoginLib();
        DIHomeLib diHome = new DIHomeLib();
        LoginRoleLib loginRole=new LoginRoleLib();
        navigateToApplication("DI");
        diLogin.login(data.get("SPPDILoginName"), data.get("SPPDIPassword"));
        diLogin.waitcloseAllBusyIcons();
        diHome.closeFacilityWindow();
    }




}