package com.aaa.web.lib;


import com.aaa.web.page.*;
import com.aaa.accelerators.ActionEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class DIManageTechniciansLib extends ActionEngine {

    List<WebElement> facilitiesList = null;

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFacilities
     * description ::This function clicks on Facilities in Application List
     * date :: 29-Mar-2018
     * author :: Sachin
     */
    public void clickOnManageTechnicians() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.lblmanageTechnicians, "Facilities");
        click(DIManageTechniciansPage.lblmanageTechnicians, "Facilities");
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyManageTechniciansWindowExists
     * description ::This function verifies if Manage Technicians window is opened or not
     * date :: 29-Mar-2018
     * author :: Sachin
     */
    public boolean verifyManageTechniciansWindowExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.manageTechniciansWindow, "Manage Technicians");
        boolean bManageTechniciansWindow = isVisible(DIManageTechniciansPage.manageTechniciansWindow, "Manage Technician");
        return bManageTechniciansWindow;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnDownArrowButton
     * description ::This function clicks on Down Arrow button
     * date :: 29-Mar-2018
     * author :: Sachin
     */
    public void clickOnDownArrowButton() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnDownArrow, "DownArrow Button");
        click(DIManageTechniciansPage.btnDownArrow, "DownArrow Button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDownArrowButton
     * description ::This function clicks on Down Arrow button
     * date :: 29-Mar-2018
     * author :: Sachin
     */
    public void clickOnNewButton() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnNew, "New Button");
        click(DIManageTechniciansPage.btnNew, "New Button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getFacilities
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 29-Mar-2018
     * author :: Sachin
     */

    public void validateFacilities(String FacilityNameExpected) throws Throwable {
        String arrAllFacility=" ";
        String expFacilityName = FacilityNameExpected.replaceAll(":", "");

        List<WebElement> facilitiesList = getWebElementList(DIManageTechniciansPage.lstFacilities, "Facilities List");

        if (facilitiesList != null) {

            boolean facilityName = true;
            // looping through all the Facilities in Facilities Drop Down
            for (int i = 0; i <= facilitiesList.size() - 1; i++) {
                String FacilityNameActual = facilitiesList.get(i).getText().toString().trim();
                String actFacilityName = FacilityNameActual.replaceAll(":", "");
                if (expFacilityName.equalsIgnoreCase(actFacilityName)){
                    assertTrue(true,"Expected Facility "+FacilityNameExpected+ " exists in list of facilities "+facilitiesList);
                    facilityName = false;
                    break;
                }
            }
            if(facilityName){
                assertTrue(false,"Expected Facility "+FacilityNameExpected+ " does not exists in list of facilities");
            }
        } else{
                assertTrue(false,"Facilities not displayed in facilities drop down list");
        }
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLoginTextBoxExists
     * description ::This function verifies if Login text box exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyLoginTextBoxExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtLogin, "Login Text Box");
        boolean bLoginTextBox = isVisible(DIManageTechniciansPage.txtLogin, "Login Text Box");
        return bLoginTextBox;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyFirstNameTextBoxExists
     * description ::This function verifies if First Name text box exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyFirstNameTextBoxExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtFirstName, "First Name Text Box");
        boolean bFirstTextBox = isVisible(DIManageTechniciansPage.txtFirstName, "First Name Text Box");
        return bFirstTextBox;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLastNameTextBoxExists
     * description ::This function verifies if Last Name text box exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyLastNameTextBoxExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtLastName, "Last Name Text Box");
        boolean bLastTextBox = isVisible(DIManageTechniciansPage.txtLastName, "Last Name Text Box");
        return bLastTextBox;
    }


    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyEmailTextBoxExists
     * description ::This function verifies if Email text box exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyEmailTextBoxExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtEmail, "Email Text Box");
        boolean bEmail = isVisible(DIManageTechniciansPage.txtEmail, "Email Text Box");
        return bEmail;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRoleDropDownFieldExists
     * description ::This function verifies if Role drop down field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyRoleDropDownFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.ddnRole, "Role Drop Down");
        boolean bRole = isVisible(DIManageTechniciansPage.ddnRole, "Role Drop Down");
        return bRole;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTechAssistUserCheckBoxFieldExists
     * description ::This function verifies if Tech Assist CheckBox field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyTechAssistUserCheckBoxFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.chkBoxtechAssistUser, "Tech Assist CheckBox");
        boolean bTechAssist = isVisible(DIManageTechniciansPage.chkBoxtechAssistUser, "Tech Assist CheckBox");
        return bTechAssist;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTechnicalCommentsFieldExists
     * description ::This function verifies if Technical Comments field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyTechnicalCommentsFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txTechnicalComments, "Technical Comments");
        boolean bTechnicalComments = isVisible(DIManageTechniciansPage.txTechnicalComments, "Technical Comments");
        return bTechnicalComments;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyPhoneNumberFieldExists
     * description ::This function verifies if Phone Number field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyPhoneNumberFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtPhoneNumber, "Phone Number");
        boolean bPhoneNumber = isVisible(DIManageTechniciansPage.txtPhoneNumber, "Phone Number");
        return bPhoneNumber;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyExtensionFieldExists
     * description ::This function verifies if Extension field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyExtensionFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtPhoneExtension, "Ext:");
        boolean bExtension = isVisible(DIManageTechniciansPage.txtPhoneExtension, "Ext:");
        return bExtension;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyPhoneTypeFieldExists
     * description ::This function verifies if Phone Type field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyPhoneTypeFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.ddnPhoneType, "Type");
        boolean bPhoneType = isVisible(DIManageTechniciansPage.ddnPhoneType, "Type");
        return bPhoneType;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTechnicalPhotoFieldExists
     * description ::This function verifies if Technical Photo field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyTechnicianPhotoFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.iconTchnicalPhoto, "Technical Photo");
        boolean bTechnicalPhoto = isVisible(DIManageTechniciansPage.iconTchnicalPhoto, "Technical Photo");
        return bTechnicalPhoto;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTechnicialCommentsFieldExists
     * description ::This function verifies if Technical comments field exists
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public boolean verifyTechnicialCommentsFieldExists() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txTechnicalComments, "Technical Comments");
        boolean bTechnicalPhoto = isVisible(DIManageTechniciansPage.txTechnicalComments, "Technical Comments");
        return bTechnicalPhoto;
    }


    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterLogin
     * description ::This function enters Login data
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void enterLogin(String Login) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtLogin, "Login");
        type(DIManageTechniciansPage.txtLogin,Login,"Login");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getLoginText
     * description ::This function returns data entered in Login textbox
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public String getLoginText() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtLogin, "Login");
        String strLogin = getAttributeByValue(DIManageTechniciansPage.txtLogin, "Login").trim();
        return  strLogin;
    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterLogin
     * description ::This function enters First Name
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void enterFirstName(String FirstName) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtFirstName, "First Name");
        type(DIManageTechniciansPage.txtFirstName,FirstName,"First Name");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFirstNameText
     * description ::This function returns data entered in First Name textbox
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public String getFirstNameText() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtFirstName, "First Name");
        String strFirstName = getAttributeByValue(DIManageTechniciansPage.txtFirstName, "First Name").trim();
        return  strFirstName;
    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterLogin
     * description ::This function enters data in Last Name text field
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void enterLastName(String LastName) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtLastName, "Last Name");
        type(DIManageTechniciansPage.txtLastName,LastName,"Last Name");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFirstNameText
     * description ::This function returns data entered in Last Name textbox
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public String getLastNameText() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtLastName, "Last Name");
        String strLasttName = getAttributeByValue(DIManageTechniciansPage.txtLastName, "Last Name").trim();
        return  strLasttName;
    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterLogin
     * description ::This function enters data in Email text field
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void enterEmail(String Email) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtEmail, "Email");
        type(DIManageTechniciansPage.txtEmail,Email,"Email");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFirstNameText
     * description ::This function returns data entered in Email textbox
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public String getEmailText() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtEmail, "Email");
        String strEmail = getAttributeByValue(DIManageTechniciansPage.txtEmail, "Email").trim();
        return  strEmail;
    }

     /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnDownArrowRole
     * description ::This function Clicks on Role down arrow
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void clickOnDownArrowRole() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.DownArrowRole,"Down Arrow Role");
        click(DIManageTechniciansPage.DownArrowRole,"Down Arrow Role");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: selectRoleOptions
     * description ::This function selects options from the role drop down
     * date :: 30-Mar-2018
     * author :: Sachin
     */
  /*  public void selectRoleOptions(String RoleOption) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.selectDropDownOptions(RoleOption),"Role option selected is "+RoleOption);
        click(DIManageTechniciansPage.selectDropDownOptions(RoleOption),"Role option selected is "+RoleOption);
    }*/

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getSelectedRoleOption
     * description ::This function gets the selected role name
     * date :: 30-Mar-2018
     * author :: Sachin
     */

    public String getSelectedRoleOption() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtRole, "Role Text Field");
        String strRoleOption = getAttributeByValue(DIManageTechniciansPage.txtRole, "Role Text Field");
        return strRoleOption;
    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterNUmber
     * description ::This function enters data in Number text field
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void enterNumber(String Number) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtPhoneNumber, "Number");
        type(DIManageTechniciansPage.txtPhoneNumber,Number,"Number");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFirstNameText
     * description ::This function returns data entered in Number textbox
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public String getNumberText() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtPhoneNumber, "Number");
        String strNumber = getAttributeByValue(DIManageTechniciansPage.txtPhoneNumber, "Number").trim();
        return  strNumber;
    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterNUmber
     * description ::This function enters data in Extension text field
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void enterEntension(String Extension) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtPhoneExtension, "Extension");
        type(DIManageTechniciansPage.txtPhoneExtension,Extension,"Extension");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFirstNameText
     * description ::This function returns data entered in Extension textbox
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public String getExtensionNumber() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtPhoneExtension, "Extension");
        String strExtension = getAttributeByValue(DIManageTechniciansPage.txtPhoneExtension, "Extension").trim();
        return  strExtension;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnDownArrowType
     * description ::This function Clicks on Type down arrow
     * date :: 30-Mar-2018
     * author :: Sachin
     */
    public void clickOnDownArrowType() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.downArrowType,"Down Arrow Type");
        click(DIManageTechniciansPage.downArrowType,"Down Arrow Type");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: selectTypeOptions
     * description ::This function selects options from the Type drop down
     * date :: 30-Mar-2018
     * author :: Sachin
     */
   /* public void selectTypeOptions(String TypeOption) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.selectDropDownOptions(TypeOption),"Type option selected is "+TypeOption);
        click(DIManageTechniciansPage.selectDropDownOptions(TypeOption),"Type option selected is "+TypeOption);
    }*/

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getSelectedTypeOption
     * description ::This function gets the selected Type name
     * date :: 30-Mar-2018
     * author :: Sachin
     */

    public String getSelectedTypeOption() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtType, "Type Text Field");
        String strTypeOption = getAttributeByValue(DIManageTechniciansPage.txtType, "Type Text Field");
        return strTypeOption;
    }



    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterNUmber
     * description ::This function enters data in Technical Comments text area field
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void enterTechnicalComments(String Comments) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txTechnicalComments, "Technical Comments");
        type(DIManageTechniciansPage.txTechnicalComments,Comments,"Technical Comments");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getTechnicalComments
     * description ::This function returns data entered in Technical Comments text area textbox
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public String getTechnicalComments() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txTechnicalComments, "Technical Comments");
        String strExtension = getAttributeByValue(DIManageTechniciansPage.txTechnicalComments, "Technical Comments").trim();
        return  strExtension;
    }


    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnSaveButton
     * description ::This function clicks on Save Button
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void clickOnSaveButton() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnSave, "Save");
       click(DIManageTechniciansPage.btnSave, "Save");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getErrorContent
     * description ::This function returns the text from error message
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public String getErrorContent() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtErrorContent, "Error Message");
        String errorMessage = getText(DIManageTechniciansPage.txtErrorContent, "Error Message");
        return errorMessage;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnDownArrowFacilities
     * description ::This function clicks on Down Arrow -Facilities
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void clickOnDownArrowFacilities() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.DownArrowFacilities, "Down Arrow Facilities");
        click(DIManageTechniciansPage.DownArrowFacilities, "Down Arrow Facilities");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnDownArrowDriver
     * description ::This function clicks on Down Arrow -Driver ID
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void clickOnDownArrowDriver() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.DownArrowDriverID, "Down Arrow DriverID");
        click(DIManageTechniciansPage.DownArrowDriverID, "Down Arrow DriverID");
    }

    /**
     * param :: String,String
     * return ::NA
     * throws :: throwable
     * methodName :: selectRoleOptions
     * description ::This function selects options from the role drop down
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void selectFacilityDropDownOptions(String DropDownName, String Option) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.selectFacilityDropDownOptions(Option),DropDownName+" option selected is "+Option);
        click(DIManageTechniciansPage.selectFacilityDropDownOptions(Option),DropDownName+" option selected is "+Option);
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnAdd
     * description ::This function clicks on Add button
     * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void clickOnAdd() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnAdd,"Add");
        click(DIManageTechniciansPage.btnAdd,"Add");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnCloseIconOnfacilitiesAssigned
     * description ::This function clicks on Close Icon
     * * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void clickOnCloseIconOnfacilitiesAssigned() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.iconClose,"Close Icon");
        click(DIManageTechniciansPage.iconClose,"Close Icon");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnTechAssistUserCheckBox
     * description ::This function clicks on check box techAssistUser
     * * date :: 31-Mar-2018
     * author :: Sachin
     */
    public void clickOnTechAssistUserCheckBox() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.chkBoxtechAssistUser,"Tech Assist User Check Box");
        click(DIManageTechniciansPage.chkBoxtechAssistUser,"Tech Assist User Check Box");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getTextFromNoFacilitiesAssigned
     * description ::This function gets the text from No Facilities assigned Text
     * * date :: 1-Apr-2018
     * author :: Sachin
     */
    public String getTextFromNoFacilitiesAssigned() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.lblNoFacilitiesAssigned,"No Facilities Assigned");
        String strNoFacilitiesAssigned = getText(DIManageTechniciansPage.lblNoFacilitiesAssigned,"No Facilities Assigned").trim();
        return strNoFacilitiesAssigned;
    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterFacilitiesOnFacilityAssignmentTab
     * description ::This function enters text on Facilities dropdown/text
     * * date :: 1-Apr-2018
     * author :: Sachin
     */
    public void enterFacilitiesOnFacilityAssignmentTab(String Facilities) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtFacilitiesOnFacilitiesAsignment,"Facilities Drop Down on Facility assignment tab");
        type(DIManageTechniciansPage.txtFacilitiesOnFacilitiesAsignment,Facilities,"Facilities Drop Down on Facility assignment tab");

    }

    /**
     * param :: String
     * return ::NA
     * throws :: throwable
     * methodName :: enterDriverIDOnFacilityAssignmentTab
     * description ::This function enters text on Driver dropdown/text
     * * date :: 1-Apr-2018
     * author :: Sachin
     */
    public void enterDriverIDOnFacilityAssignmentTab(String DriverID) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtDriverOnFacilitiesAssignment,"Driver Drop down Down on Facility Assignment tab");
        type(DIManageTechniciansPage.txtDriverOnFacilitiesAssignment,DriverID,"Driver Drop down Down on Facility Assignment tab");

    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: isYesButtonExistOnConfirmPopUp
     * description ::This function cehcks for the availability of Confirmation pop up window
     * * date :: 1-Apr-2018
     * author :: Sachin
     */
    public boolean isYesButtonExistOnConfirmPopUp() throws Throwable {
       boolean bYesButton =  isVisibleOnly(DIManageTechniciansPage.btnYesConfirmationPopUp,"Yes Button on Confirm PopUp ");
       return bYesButton;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: isYesButtonExistOnConfirmPopUp
     * description ::This function cehcks for the availability of Confirmation pop up window
     * * date :: 1-Apr-2018
     * author :: Sachin
     */
    public void clickOnYesButon() throws Throwable {
        boolean bYesButton =  click(DIManageTechniciansPage.btnYesConfirmationPopUp,"Yes Button on Confirm PopUp ");
    }
    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFacilitiesDriverAssignedText
     * description ::This function returns Facilities and Drivers assigned from the Facilities Assigned text area text box
     * * date :: 6-Apr-2018
     * author :: Sachin
     */
    public String getFacilitiesDriverAssignedText() throws Throwable {
        String strFacilityDriver =  getText(DIManageTechniciansPage.txtFacilitiesAssigned,"Facilities Assigned: ");
        return strFacilityDriver;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterRole
     * description ::This function enters Role in role field
     * * date :: 6-Apr-2018
     * author :: Sachin
     */
    public void enterRole(String Role) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtRole,"Role");
        type(DIManageTechniciansPage.txtRole,Role,"Role");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterType
     * description ::This function enters Type in role field
     * * date :: 6-Apr-2018
     * author :: Sachin
     */
    public void enterType(String Type) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtType,"Type");
        type(DIManageTechniciansPage.txtType,Type,"Type");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnResetPassword
     * description ::This function clicks on Reset Password button
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public void clickOnResetPassword() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnReSetPassword,"Reset Password");
        click(DIManageTechniciansPage.btnReSetPassword,"Reset Password");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnFacilityAssignmentTab
     * description ::This function clicks on Facility Assigment Tab
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public void clickOnFacilityAssignmentTab() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.tabFacilityAssignment,"Facility Assignment Tab");
        click(DIManageTechniciansPage.tabFacilityAssignment,"Facility Assignment Tab");
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: isConfirmTechnicalOverWriteExist
     * description ::This function validated if Confirm Technical OverWrite popup window exists
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public boolean isConfirmTechnicalOverWriteExist() throws Throwable {
        //waitForVisibilityOfElement(DIManageTechniciansPage.PopUpConfirmTechnicalOverWrite,"Confirm Technical OverWrite Pop Up window");
        boolean bPopUp = isElementNotPresent(DIManageTechniciansPage.PopUpConfirmTechnicalOverWrite,"Confirm Technical OverWrite Pop Up window");
        return  bPopUp;
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getTextConfirmTechnicalOverWrite
     * description ::This function returns the confirmation message
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public String getTextConfirmTechnicalOverWrite() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.popUpMessageConfirmTechnicalOverWrite,"Confirm Technical OverWrite message");
        String strMessage = getText(DIManageTechniciansPage.popUpMessageConfirmTechnicalOverWrite,"Confirm Technical OverWrite message").trim();
        return  strMessage;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnNoButtonConfirmTechnicalOverWrite
     * description ::This function clicks on No button on COnfirm Technical OverWrite pop up window
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public void clickOnNoButtonConfirmTechnicalOverWrite() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnNoConfirmTechnicalOverWritePopUp,"No Button Confirm Technical OverWrite PopUp Window");
        click(DIManageTechniciansPage.btnNoConfirmTechnicalOverWritePopUp,"No Button Confirm Technical OverWrite PopUp Window");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterRole
     * description ::This function enters Role in role field
     * * date :: 6-Apr-2018
     * author :: Sachin
     */
    public void enterTechnicianLoginName(String technicianName) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtManageTechnicianInputField,"Manage technicians Input");
        type(DIManageTechniciansPage.txtManageTechnicianInputField,technicianName,"Manage technicians Input");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnFirstLoginNameInList
     * description ::This function clicks on first Login Name in List
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public void clickOnFirstLoginNameInList() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.txtFirstLoginNameInList,"Click on First Login Name in List");
        click(DIManageTechniciansPage.txtFirstLoginNameInList,"Click on First Login Name in List");
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: isChangesWillbeLostWindowExist
     * description ::This function validated if Changes will be lost popup window exists
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public boolean isChangesWillbeLostWindowExist() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.popUpWindowChangesWillBeLost,"Changes will be lost Pop Up window");
        boolean bPopUp = isVisible(DIManageTechniciansPage.popUpWindowChangesWillBeLost,"Changes will be lost Pop Up window");
        return  bPopUp;
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getTextChangesWillBeLost
     * description ::This function returns the  message from Changes will be lost pop up window
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public String getTextChangesWillBeLost() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.lblMessageChangesWillBeLostWindow,"Confirm Technical OverWrite message");
        String strMessage = getText(DIManageTechniciansPage.lblMessageChangesWillBeLostWindow,"Confirm Technical OverWrite message");
        return  strMessage;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnYesButtonOnChangesWillBeLostWidnow
     * description ::This function clicks on yes button on Changes will be lost pop ip window
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public void clickOnYesButtonOnChangesWillBeLostWidnow() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnYesChangesWillBeLostPopUpWindow,"Yes Button on Changes will be lost window");
        click(DIManageTechniciansPage.btnYesChangesWillBeLostPopUpWindow,"Yes Button on Changes will be lost window");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnDelete
     * description ::This function clicks on Delete button on User Information
     * * date :: 9-Apr-2018
     * author :: Sachin
     */
    public void clickOnDelete() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.btnDelete,"Delete");
        click(DIManageTechniciansPage.btnDelete,"Delete");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnUserInformationTab
     * description ::This function clicks on User Information tab
     * * date :: 10-Apr-2018
     * author :: Sachin
     */
    public void clickOnUserInformationTab() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.tabUserInformation,"User Information Tab");
        click(DIManageTechniciansPage.tabUserInformation,"User Information Tab");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: getTextManageTechnicianSearchTable
     * description ::This function gets the login name of first technician from search table
     * * date :: 10-Apr-2018
     * author :: Sachin
     */
    public boolean isManageTechnicianExistsInSearchTable() throws Throwable {
        boolean strName = isVisibleOnly(DIManageTechniciansPage.txtFirstLoginNameInList,"Technician in Manage Technician Search table");
        return strName;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickLoginNameFromManageTechnicianSearchTable
     * description ::This function gets the login name of first technician from search table
     * * date :: 10-Apr-2018
     * author :: Sachin
     */
    public void clickTechnicianFromManageTechnicianSearchTable(String LoginName) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.selectTechnicianName(LoginName),"Login Name "+LoginName);
        click(DIManageTechniciansPage.selectTechnicianName(LoginName),"Login Name "+LoginName);
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getFacilityAndDriverIDFromFirstRow
     * description ::This function returns the  facility and driver id form the first row of manage technician search table
     * * date :: 12-Apr-2018
     * author :: Sachin
     */
    public String getFacilityAndDriverIDFromFirstRow() throws Throwable {
        String strMessage = getText(DIManageTechniciansPage.lblFacilityAndDriverId,"Driver ID and Facility First row Manage technician table");
        return  strMessage;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickLoginNameFromManageTechnicianSearchTable
     * description ::This function gets the login name from Manage technisian Table
     * * date :: 13-Apr-2018
     * author :: Sachin
     */
    public void clickLoginNameFromManageTechnicianSearchTable(String LoginName) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.selectLoginNameFromTable(LoginName),"Login Name "+LoginName);
        click(DIManageTechniciansPage.selectLoginNameFromTable(LoginName),"Login Name "+LoginName);
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: SelectFirstRowManageTechniciansSearchTable
     * description ::This function Selects the first technician in Manage technician Saerch table
     * * date :: 13-Apr-2018
     * author :: Sachin
     */
    public void SelectFirstRowManageTechniciansSearchTable() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.firstRowManageTechnicianSearchTable,"First Row Manage Technician Search Table");
        click(DIManageTechniciansPage.firstRowManageTechnicianSearchTable,"First Row Manage Technician Search Table");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnFacilitiesAssignedSection
     * description ::This function clicks on Facilites Assigned Section
     * * date :: 13-Apr-2018
     * author :: Sachin
     */
    public void clickOnFacilitiesAssignedSection() throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.lstFacilitiesAssignedSection,"Facilities Assigned Section");
        click(DIManageTechniciansPage.lstFacilitiesAssignedSection,"Facilities Assigned Section");
    }

    /**
     * param :: String,String
     * return ::NA
     * throws :: throwable
     * methodName :: selectRoleOptions
     * description ::This function selects options from the Driver drop down in Facilities Assignment Tab
     * date :: 13-APR-2018
     * author :: Sachin
     */
    public void selectDriverDropDownOptions(String DropDownName, String Option) throws Throwable {
        waitForVisibilityOfElement(DIManageTechniciansPage.selectDriverDropDownOptions(Option),DropDownName+" option selected is "+Option);
        click(DIManageTechniciansPage.selectDriverDropDownOptions(Option),DropDownName+" option selected is "+Option);
    }

}
