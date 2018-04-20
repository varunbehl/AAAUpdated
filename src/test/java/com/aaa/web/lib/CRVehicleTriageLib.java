package com.aaa.web.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRServicePage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.openqa.selenium.Keys;



public class CRVehicleTriageLib extends ActionEngine {
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: vehicleFieldVerification
     * description ::
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void vehicleFieldVerification() throws Throwable {
        verifyVehicleType();
        verifyVehicleYear();
        verifyVehicleMake();
        verifyVehicleModel();
        verifyVehicleColor();

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleType
     * description :: To verify VehicleType Field as mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleType() throws Throwable {
        boolean flagvtype = isVisibleOnly(CRVehicleTriagePage.txtVehicleType_required, "Vehicle Type");
            assertTrue(flagvtype, "<b>Vehicle Type is Mandatory Field</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleYear
     * description :: To verify verifyVehicleYear Field as mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleYear() throws Throwable {
        boolean flagvyear = isVisibleOnly(CRVehicleTriagePage.txtVehicleYear_required, "Vehicle Year");
            assertTrue(flagvyear, "<b> Vehicle Year is Mandatory Field </b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleMake
     * description :: To verify verifyVehicleMake Field as mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleMake() throws Throwable {
        boolean flagvmake = isVisibleOnly(CRVehicleTriagePage.txtVehicleMake_required, "Make");
            assertTrue(flagvmake, "<b>Make is Mandatory Field</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleModel
     * description :: To verify verifyVehicleModel Field as mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleModel() throws Throwable {
        boolean flagvmodel = isVisibleOnly(CRVehicleTriagePage.txtVehicleModel_required, "Model");
            assertTrue(flagvmodel, "<b>Model is Mandatory Field</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleColor
     * description :: To verify verifyVehicleColor Field as mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleColor() throws Throwable {
        boolean flagvColor = isVisibleOnly(CRVehicleTriagePage.txtVehicleColor_required, "Color");
            assertTrue(flagvColor, "<b>Color is Mandatory Field</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyPacesetterCode
     * description :: To verify verifyPacesetterCode Field as mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyPacesetterCode() throws Throwable {
        boolean flagvPacesetterCode = isVisibleOnly(CRVehicleTriagePage.txtPaceSetterCode, "PacesetterCode");
            assertTrue(flagvPacesetterCode, "<b>PacesetterCode is Mandatory Field</b>");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: cleanAndSaveVehicleDetails
     * description :: To clear and Save Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void cleanAndSaveVehicleDetails(String VehicleType, String VehicleYear, String VehicleMake, String VehicleModel, String VehicleColor, String pageSettercode) throws Throwable {
        clearVehicleMandatoryFields();
        enterandSaveVehicleMandatoryFields(VehicleType, VehicleYear, VehicleMake, VehicleModel, VehicleColor, pageSettercode);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearVehicleMandatoryFields
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearVehicleMandatoryFields() throws Throwable {
        click(CRVehicleTriagePage.vehicleTriageTab, "vehicle/TriageTab");
        clearData(CRVehicleTriagePage.txtVehicleType);
        clearData(CRVehicleTriagePage.txtVehicleYear);
        clearData(CRVehicleTriagePage.txtVehicleMake);
        clearData(CRVehicleTriagePage.txtVehicleModel);
        clearData(CRVehicleTriagePage.txtVehicleColor);

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterandSaveVehicleMandatoryFields
     * description :: To enter  Vehicle MandatoryFields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterandSaveVehicleMandatoryFields(String VehicleType, String VehicleYear, String VehicleMake, String VehicleModel, String VehicleColor, String paceSettercode) throws Throwable {
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterVehicleType(VehicleType);
        Thread.sleep(1000);
        enterVehicleYear(VehicleYear);
        Thread.sleep(1000);
        enterVehicleMake(VehicleMake);
        Thread.sleep(1000);
        enterVehicleModel(VehicleModel);
        Thread.sleep(1000);
        enterVehicleColor(VehicleColor);
        Thread.sleep(1000);
        selectpaceSettercode(paceSettercode);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleType
     * description :: To enter VehicleType
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleType(String VehicleType) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleType);
        type(CRVehicleTriagePage.txtVehicleType, VehicleType, "VehicleType");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleYear
     * description :: To enter VehicleYear
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleYear(String VehicleYear) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleYear);
        type(CRVehicleTriagePage.txtVehicleYear, VehicleYear, "VehicleYear");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleMake
     * description :: To enter VehicleMake
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleMake(String VehicleMake) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleMake);
        Thread.sleep(2000);
        click(CRVehicleTriagePage.txtVehicleMake,"Make Field");
        type(CRVehicleTriagePage.txtVehicleMake, VehicleMake, "VehicleMake");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleModel
     * description :: To enter VehicleModel
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleModel(String VehicleModel) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleModel);
        type(CRVehicleTriagePage.txtVehicleModel, VehicleModel, "VehicleModel");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleColor
     * description :: To enter VehicleColor
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleColor(String VehicleColor) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleColor);
        type(CRVehicleTriagePage.txtVehicleColor, VehicleColor, "VehicleColor");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectpageSettercode
     * description :: To select paceSettercode
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectpaceSettercode(String paceSettercode) throws Throwable {
        click(CRVehicleTriagePage.txtPacesetterCode, "pageSettercode");
        type(CRVehicleTriagePage.txtPacesetterCode, paceSettercode, "pageSettercode");
        mouseDoubleClick(CRVehicleTriagePage.doubleClickPaceCode, "Double click on pageSettercode");
        //Script Error
        Thread.sleep(2000);

        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");

        if (flagScriptErrorOkButton) {

            click(CRVehicleTriagePage.scriptError, "Script error Okay button");

        } else {

            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            if (errorIconAvailablility) {
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            }

            String combineKeys3 = Keys.chord(Keys.TAB);

            sendKeys(combineKeys3, "Tab");

            String combineKeys2 = Keys.chord(Keys.SPACE);

            sendKeys(combineKeys2, "SPACE");


        }
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicleTriageTab
     * description :: To click On VehicleTriageTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnVehicleTriageTab() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.vehicleTriageTab, "Vehicle Tab");
        click(CRVehicleTriagePage.vehicleTriageTab, "Vehicle Tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle errors
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        boolean flagscriprErr = isVisibleOnly(CRVehicleTriagePage.errorAlertOK, "Error Alert OK button");
        if (flagscriprErr) {
            mouseDoubleClick(CRVehicleTriagePage.errorAlertOK, "Error Alert OK Button");
        }
        boolean flagScriptErrorAlert = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorAlert) {
        	mouseDoubleClick(CRVehicleTriagePage.scriptError, "Script error Okay button");
        }
        boolean flagConformButtonOk = isVisibleOnly(CRVehicleTriagePage.btnAlertSaveYes, "Confirmation okay button");
        if (flagConformButtonOk) {
        	mouseDoubleClick(CRVehicleTriagePage.btnAlertSaveYes, "Confirmation Okay button");
        }
        boolean messageCloseIcon = isVisibleOnly(CRHomePage.iconMsgClose, "Message Alert Close");
        if (messageCloseIcon) {
            //assertTrue(messageCloseIcon, "Message Dialog window appeared ");
            click(CRHomePage.iconMsgClose, "Message Alert Close");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: vehicletriageTabsel
     * description :: To click on Vehicel triage Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void vehicletriageTabsel() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.vehicleTriageTab, "Vehicle triage tab");
        click(CRVehicleTriagePage.vehicleTriageTab, "Vehicle tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Vehicleinfolink
     * description :: To click on existing vehicel link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void Vehicleinfolink() throws Throwable {
        isVisible(CRVehicleTriagePage.linkVehicleModel, "vehicle model");
        waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");
        click(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Vehicletype
     * description :: To Vehicletype
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void Vehicletype(String Vehicletype) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.dropboxVehicleType, "Vehicle type");
        type(CRVehicleTriagePage.dropboxVehicleType, Vehicletype, "Vehicle Type");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Entervehicleinfomanually
     * description :: To enter vehicle info in omnisearch bar
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void Entervehicleinfomanually(String Vehiclemodel) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleSrch, "Vehicle model search");
        type(CRVehicleTriagePage.txtVehicleSrch, Vehiclemodel, "Vechile model search");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickVehicleSearchButton
     * description :: To click On vehicle Search button
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickVehicleSearchButton() throws Throwable {
    	Thread.sleep(3000);
    	waitForVisibilityOfElement(CRVehicleTriagePage.btnVehicleSrch, "Vehicle search button");
        click(CRVehicleTriagePage.btnVehicleSrch, "Vehicle search button");
        mouseDoubleClick(CRVehicleTriagePage.btnVehicleSrch, "Vehicle search button");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: availableVehicleaftersrch
     * description :: To click on existing Vehicel link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void availableVehicleaftersrch() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkAvailbleVehicleModel, "Avilable vehicle models after search");
        dynamicWait(CRVehicleTriagePage.linkAvailbleVehicleModel);
        click(CRVehicleTriagePage.linkAvailbleVehicleModel, "Available vehicle model");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: vehicleColor
     * description :: To vehicleColor
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void vehicleColor(String Vehiclecolor) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.dropboxVehicleColor, "Vehiclecolor");
        clearData(CRVehicleTriagePage.txtVehicleColor);
        type(CRVehicleTriagePage.dropboxVehicleColor, Vehiclecolor, "Vehicle color");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: pacesetterCodegeneration_Keysissue
     * description :: To select key related pacesetter code
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void pacesetterCodegeneration_Keysissue() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description");
        click(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description radio button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validatePaceSetterCode
     * description :: To validate selected PaceSetterCode
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void validatePaceSetterCode(String Pacesettercode) throws Throwable {

        if (isElementPresent(CRVehicleTriagePage.txtPaceSetterCode, "Pacesetter code text")) {

            String labelPaceSetter = getText(CRVehicleTriagePage.txtPaceSetterCode, "Pacesetter code text");
            assertTrue(labelPaceSetter.contains(Pacesettercode), "Expected pacesetter code :" + Pacesettercode);
        } else {
            waitForVisibilityOfElement(CRVehicleTriagePage.linkPacesetterCodeCancel, "Pacesetter code cancel link");
            click(CRVehicleTriagePage.linkPacesetterCodeCancel, "Pacesetter code cancel link");

        }


    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: enterVehicleDetails
     * �* description :: To enter VehicleDetails based on condition
     * �* date :: 05-Dec-2017
     * �* author ::Lakshmi Prasanna
     * �
     */
    public void enterVehicleDetails(String Vehicletype, String Vehiclecolor, String Vehiclemodel) throws Throwable {
        vehicletriageTabsel();
        if (isElementPresent(CRVehicleTriagePage.linkVehicleModel, "vehicle model")) {

            Vehicleinfolink();
            Vehicletype(Vehicletype);
            vehicleColor(Vehiclecolor);
        } else {
            Entervehicleinfomanually(Vehiclemodel);
            clickVehicleSearchButton();
            availableVehicleaftersrch();
            vehicleColor(Vehiclecolor);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectVehicleModel
     * description :: select vehicle model
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectVehicleModel() throws Throwable {
        clickOnVehicleTriageTab();
        selectExistingVehicleModel();
        generatePacesetterCode();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clicOnVehicletriageTab
     * description :: To clic On VehicletriageTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clicOnVehicletriageTab() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.tabVehicletriage, "Vehicle triage tab");
        click(CRVehicleTriagePage.tabVehicletriage, "Vehicle tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectExistingVehicleModel
     * description :: To select Existing VehicleModel
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectExistingVehicleModel() throws Throwable {
        clickOnVehicleTriageTab();
        waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");
        click(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: generatePacesetterCode
     * description :: To generate PacesetterCode for key related issue
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void generatePacesetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description");
        click(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description radio button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectJumpStartFromBattery
     * description :: To select battery related pacesetter code
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectJumpStartFromBattery() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkBattery, "Battery link");
        click(CRVehicleTriagePage.linkBattery, "Battery link");
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnBatteryIssue, "Key issue description");
        isElementPresent(CRVehicleTriagePage.batteryProblem, "Battery Problem Description");
        click(CRVehicleTriagePage.rdBtnBatteryIssue, "Key issue description radio button");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPacesetterCodeBattery
     * description :: To enter battery related pacesetter code
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterPacesetterCodeBattery(String Pacesettercode) throws Throwable {
        isElementPresent(CRVehicleTriagePage.batteryProblem, "Battery Problem Description");
        waitForVisibilityOfElement(CRVehicleTriagePage.txtPacesetterCodeManual, "Pacesetter code manual entry");
        type(CRVehicleTriagePage.txtPacesetterCodeManual, Pacesettercode, "Pacesetter code manual");
        waitForVisibilityOfElement(CRVehicleTriagePage.selcManualPacesetterCodeBattery, "Select manual pacesettercode");
        mouseClick(CRVehicleTriagePage.selcManualPacesetterCodeBattery, "Select manual pacesettercode");
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: manualPacesetterCodekey
     * description :: To enter pacesetter code manually
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void manualPacesetterCodekey(String Pacesettercode) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.txtPacesetterCodeManual, "Pacesetter code manual entry");
        type(CRVehicleTriagePage.txtPacesetterCodeManual, Pacesettercode, "Pacesetter code manual");
        waitForVisibilityOfElement(CRVehicleTriagePage.selcManualPacesetterCodekey, "Select manual pacesettercode");
        mouseClick(CRVehicleTriagePage.selcManualPacesetterCodekey, "Select manual pacesettercode");
        if(isVisibleOnly(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button"))
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validatePacesetterCode
     * description :: To validate PacesetterCode
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void validatePacesetterCode(String Pacesettercode) throws Throwable {
        //String PaceSetterCode = getText(CRVehicletriagepage.selectPacesettercode, "get Pacesetter code");
        assertTextMatching(CRVehicleTriagePage.selectPacesetterCode, Pacesettercode, "validate pace setter code");
    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: manpacecodeTow_enterpacesettcode
     * �* description :: To enter tow related pacesetter code manually
     * �* date :: 05-Dec-2017
     * �* author ::Parameswar Yenduri
     * �
     */

    public void manpacecodeTow_enterpacesettcode(String Pacesettercode) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.txtPacesetterCodeManual, "Pacesetter code manual entry");
        type(CRVehicleTriagePage.txtPacesetterCodeManual, Pacesettercode, "pacesetter code manual entry");
        waitForVisibilityOfElement(CRVehicleTriagePage.selcManualPacesetterCodeTow, "Select manual pacesettercode with Tow");
        mouseClick(CRVehicleTriagePage.selcManualPacesetterCodeTow, "Select manual pacesettercode with Tow");
    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: manupacecodeTow_btn
     * �* description :: To handle popup -- Dialog box OkBtn,
     * �* date :: 05-Dec-2017
     * �* author ::Parameswar Yenduri
     * �
     */

    public void manupacecodeTow_btn() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectvehicle
     * description :: To select vehicle by selecting existing vehiclelink
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectvehicle() throws Throwable {

        clicOnVehicletriageTab();
        selectExistingVehicleModel();
        generatePacesetterCode();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectExistingVehicleLink
     * description :: To click On existing vehicleLink, to enter vehicle type, vehicle color
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectExistingVehicleLink(String Vehicletype, String Vehiclecolor) throws Throwable {

        Vehicleinfolink();
        Vehicletype(Vehicletype);
        vehicleColor(Vehiclecolor);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNewVechiledeatils
     * description :: To enter vehicle details by Omni search
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterNewVechiledeatils(String Vehiclemodel, String Vehiclecolor) throws Throwable {
        Entervehicleinfomanually(Vehiclemodel);
        clickVehicleSearchButton();
        availableVehicleaftersrch();
        vehicleColor(Vehiclecolor);
    }

    /**
     *  param ::
     *  return ::void
     *  throws :: throwable
     *  methodName :: selectPaceSetterCode
     *  description :: To selectPaceSetterCode related to keyloc issue
     *  date :: 05-Dec-2017
     *  author ::Lakshmi Prasanna
     *
     */
    public void selectPaceSetterCode() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        Thread.sleep(5000);
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description");
        click(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description radio button");
        Thread.sleep(5000);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLinkOnVehicle
     * description :: To click on ManualEntry link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnManualEntryLinkOnVehicle() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkManualEntryLinkOnVehicleTriage, "ManualEntry Link");
        click(CRVehicleTriagePage.linkManualEntryLinkOnVehicleTriage, "ManualEntry Link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFuel
     * description ::To click Fuel option In Triage
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFuel() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnFuel, "Fuel");
        click(CRVehicleTriagePage.btnFuel, "Fuel");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOutOfGas
     * description ::To click On OutOfGas radio button Under Fuel option
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnOutOfGas() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnOutOfGas, "Out Of Gas");
        click(CRVehicleTriagePage.rbtnOutOfGas, "Out Of Gas");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTire
     * description ::To click On FlatTire
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTire() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnFlatTire, "Flat Tire");
        click(CRVehicleTriagePage.btnFlatTire, "Flat Tire");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTireFrontSide
     * description ::To click On FlatTire FrontSide radio button
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTireFrontSide() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnDriverFrontSide, "Flat Tire Front Side");
        click(CRVehicleTriagePage.rbtnDriverFrontSide, "Flat Tire Front Side");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTireSpareTireYes
     * description ::To click On FlatTire SpareTire Yes radio button
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTireSpareTireYes() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnClickYesOnSpareTire, "Spare Tire Yes");
        click(CRVehicleTriagePage.rbtnClickYesOnSpareTire, "Spare Tire Yes");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTireLockingLugNuts
     * description ::To click On FlatTire Locking LugNuts radio button
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTireLockingLugNuts() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnClickOnLockingLugNuts, "Locking Lug Nuts");
        click(CRVehicleTriagePage.rbtnClickOnLockingLugNuts, "Locking Lug Nuts");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectExistingVehicle
     * description ::To select Existing Vehicle
     * date :: 18-Dec-2017
     * author ::
     */
    public void selectExistingVehicle() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.selectVehicle, "Vehicle model");
        click(CRVehicleTriagePage.selectVehicle, "Vehicle model");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: handleScriptErrorInVehicleTriagePage
     * description :: To handle script alerts
     * date :: 18-Dec-2017
     * author ::
     */
    public void handleScriptErrorInVehicleTriagePage() throws Throwable {

        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            //assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            if (errorIconAvailablility) {
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            }
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
            //waitForVisibilityOfElement(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");

        }
    }
    /**
     * param:: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLeftLightOnRadioBtnOfBattery
     * description :: click on Left LightOn Radio Button
     * date :: 18-Dec-2017
     * author ::Nidhi
     */
    public void clickOnLeftLightOnRadioBtnOfBattery() throws Throwable {
        boolean leftLightLiteOnradioBtn = isVisibleOnly(CRVehicleTriagePage.radioBtnLeftLightOnBattery, "LeftLightOn RadioBtn");
        if (leftLightLiteOnradioBtn) {
            click(CRVehicleTriagePage.radioBtnLeftLightOnBattery, "Click On LeftLightOn RadioBtn");
        }else{
            assertTrue(!leftLightLiteOnradioBtn,"LeftLightOn RadioBtn is not visible");
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validatePaceSetterInSummaryPopUpWindow
     * description :: This Function is used to validate selected pace setter code is displayed in Call Summary POpUp window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validatePaceSetterInSummaryPopUpWindow(String pacesetter) throws Throwable {
        //waitForVisibilityOfElement(CRVehicleTriagePage.selectVehicle, "Vehicle model");
        String strSummaryPopUpPaceSetterCode = getText(CRVehicleTriagePage.lblPacesetterCodesInSummaryPopUp,"Call Summary Pop Up Pacesetter Code");
        assertTrue(pacesetter.equalsIgnoreCase(strSummaryPopUpPaceSetterCode), "Selected Pacesetter Codes is displayed Call Summary popup window");

    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateQuestionDisplayedInTriageSection
     * description :: This Function validates if Question fires off and displays to the user in Triage Section
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateQuestionDisplayedInTriageSection(String Question) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblTriageQuestion,"Triage Question");
        String strTriageQuestion = getText(CRVehicleTriagePage.lblTriageQuestion,"Triage Question").trim();
        assertTrue(Question.equalsIgnoreCase(strTriageQuestion), "<b>Question fires off and displays to the user<b>");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateNoPacesetterCodeAssigned
     * description :: This Function validates that No pacesetter code is assigned
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateNoPacesetterCodeAssigned(String pagesetterinfo) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblPaceSetterNotSelected,"Triage Question");
        String strPaceSetterInfo = getText(CRVehicleTriagePage.lblPaceSetterNotSelected,"Triage Question");
        assertTrue(strPaceSetterInfo.equalsIgnoreCase(pagesetterinfo), "No pacesetter code assigned");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::lblSelectedPaceSetterCodes
     * description ::get text for label pace setter codes
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void lblSelectedPaceSetterCodes() throws Throwable {
        boolean visibilityOfSelectedPaceSetterCodes = isVisibleOnly(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, " Label Pacesetter Codes");
        assertTrue(visibilityOfSelectedPaceSetterCodes, "Pace Setter Codes is available");
        if (visibilityOfSelectedPaceSetterCodes) {
            String paceSetterCodes = getText(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, "Pace Setter Codes is available");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallSummary
     * description ::To click On CallSummary
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnCallSummary() throws Throwable {
        click(CRVehicleTriagePage.btnCallSummary, "Call Summary Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryPaceSetterCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public String lblCallSummaryPaceSetterCodes() throws Throwable {
        boolean visibilityOfSummaryPaceSetterCodes = isVisibleOnly(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, " Label Pacesetter Codes");
        assertTrue(visibilityOfSummaryPaceSetterCodes, "Summary Call Window.");

        String summaryPaceSetterCodes = getText(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, "Pace Setter Codes is available in Summary Window");
        assertTrue(visibilityOfSummaryPaceSetterCodes, "Pace Setter Codes is available in Summary Window");
        return summaryPaceSetterCodes;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleSearch
     * description ::To enter Vehicle details in omni search bar to search
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterVehicleSearch(String vehicleSearch) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleSearch,"Vehicle Search");
        type(CRVehicleTriagePage.txtVehicleSearch,vehicleSearch, "Vehicle Search");

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehcileSearchDetails
     * description ::To get entered vehicle details from omni searchBar
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getVehcileSearchDetails() throws Throwable {
        //String vehicleSearchDetailsLocator = String.valueOf(CRVehicleTriagePage.txtVehicleSearch);
        String vehicleSearchDetails = getAttributeByValue(CRVehicleTriagePage.txtVehicleSearch,"Vehicle Search");
        return vehicleSearchDetails;

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheVehicleSearch
     * description ::To click On TheVehicleSearch link
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheVehicleSearch() throws Throwable {
        click(CRVehicleTriagePage.lnkVehicleSearch, "Vehicle link search");
    }



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTrim
     * description ::To enter Trim value
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterTrim(String trim) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleTrim,"Vehicle trim");
        type(CRVehicleTriagePage.txtVehicleTrim,trim, "Vehicle trim");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTrimValue
     * description ::To get Trim value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTrimValue() throws Throwable {
        //String trimlocator = String.valueOf(CRVehicleTriagePage.txtVehicleTrim);
        String trim = getAttributeByValue(CRVehicleTriagePage.txtVehicleTrim,"Vehicle Trim");
        return trim;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTag
     * description ::To enter Tab value
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterTag(String tag) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleTag,"Vehicle tag");
        type(CRVehicleTriagePage.txtVehicleTag,tag, "Vehicle tag");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTagValue
     * description ::To get Tag Field Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTagValue() throws Throwable {
        //String taglocator = String.valueOf(CRVehicleTriagePage.txtVehicleTag);
        String tag = getAttributeByValue(CRVehicleTriagePage.txtVehicleTag,"Vehicle Tag");
        return tag;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterState
     * description ::To enter State Field Value
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterState(String state) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleState,"Vehicle state");
        type(CRVehicleTriagePage.txtVehicleState,state, "Vehicle state");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStateValue
     * description ::To get State Field value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getStateValue() throws Throwable {
        //String statelocator = String.valueOf(CRVehicleTriagePage.txtVehicleState);
        String state = getAttributeByValue(CRVehicleTriagePage.txtVehicleState,"Vehicle State");
        return state;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFlat
     * description ::To enter Flat Field Value
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterFlat(String flat) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleFlat,"Vehicle flat");
        type(CRVehicleTriagePage.txtVehicleFlat,flat, "Vehicle flat");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFlatValue
     * description ::To get Flat Field value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getFlatValue() throws Throwable {
        //String flatlocator = String.valueOf(CRVehicleTriagePage.txtVehicleFlat);
        String flat = getAttributeByValue(CRVehicleTriagePage.txtVehicleFlat,"Vehicle Flat");
        return flat;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNote
     * description ::To enterNote Field value
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterNote(String note) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleNote,"Vehicle note");
        type(CRVehicleTriagePage.txtVehicleNote,note, "Vehicle note");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getNoteValue
     * description ::To get Field Node Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getNoteValue() throws Throwable {

        String note = getAttributeByValue(CRVehicleTriagePage.txtVehicleNote,"Vehicle Note");
        return note;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMoreInfoTab
     * description ::To click On MoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnMoreInfoTab() throws Throwable {
        click(CRVehicleTriagePage.btnMoreinfoTab, "click on more info tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSubTypeOnMoreInfoTab
     * description ::To enter SubType OnMoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterSubTypeOnMoreInfoTab(String subType) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabSubType,"More Info Tab subType");
        type(CRVehicleTriagePage.txtMoreInfoTabSubType,subType, "More Info Tab subType");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEngineTypeOnMoreInfoTab
     * description ::To enter EngineType OnMoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterEngineTypeOnMoreInfoTab(String engineType) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabEngineType,"More Info Tab engineType");
        type(CRVehicleTriagePage.txtMoreInfoTabEngineType,engineType, "More Info Tab engineType");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentOnMoreInfoTab
     * description ::To enter Comment OnMoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCommentOnMoreInfoTab(String comment) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabComment,"More Info Tab comment");
        type(CRVehicleTriagePage.txtMoreInfoTabComment,comment, "More Info Tab comment");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLegnthOnMoreInfoTab
     * description ::To enter Legnth On MoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterLegnthOnMoreInfoTab(String length) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabLength,"More Info Tab length");
        type(CRVehicleTriagePage.txtMoreInfoTabLength,length, "More Info Tab length");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterHeightOnMoreInfoTab
     * description ::To enter Height OnMoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterHeightOnMoreInfoTab(String height) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabHeight,"More Info Tab height");
        type(CRVehicleTriagePage.txtMoreInfoTabHeight,height, "More Info Tab height");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterWeightOnMoreInfoTab
     * description ::To enter Weight On MoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterWeightOnMoreInfoTab(String weight) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabWeight,"More Info Tab weight");
        type(CRVehicleTriagePage.txtMoreInfoTabWeight,weight, "More Info Tab weight");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClassOnMoreInfoTab
     * description ::To enter Class OnMoreInfo Tab
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterClassOnMoreInfoTab(String Class) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabClass,"More Info Tab Class");
        type(CRVehicleTriagePage.txtMoreInfoTabClass,Class, "More Info Tab Class");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryPaceSetterCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void vehicleLinkTextAfterFilter() throws Throwable {
        boolean visibilityOfVehicleName = isVisibleOnly(CRVehicleTriagePage.lnkVehicleSearch, " Label Pacesetter Codes");
        assertTrue(visibilityOfVehicleName, "Pace Setter Codes is available in Summary Window");
        if (visibilityOfVehicleName) {
            String vehicleName = getText(CRVehicleTriagePage.lnkVehicleSearch, "Pace Setter Codes is available in Summary Window");
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheVehicleSearchIcon
     * description ::To click On TheVehicleSearch Button
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheVehicleSearchIcon() throws Throwable {
        String combineKeys3 = Keys.chord(Keys.ENTER);
        sendKeys(combineKeys3, "ENTER");
        //Below commented code will work on Chrome browser version 58 and 63
        /*
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
        String combineKeys2 = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys2, "SPACE");
        Thread.sleep(3000);
        mouseClick(CRVehicleTriagePage.lnkVehicleSearchIcon, "Vehicle link search Icon");*/
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearAllFileds
     * description ::To click On ClearAllFileds
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnClearAllFileds() throws Throwable {
        click(CRVehicleTriagePage.lnkClearAllFIelds, "Clear All Fields");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheTypeSearchFromDropDown
     * description ::To click OnThe TypeSearch From DropDown
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheTypeSearchFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.lnkVehicleTypeSearchFromDropDown, "Vehicle Type search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheModelSearchFromDropDown
     * description ::To click On The ModelSearch From DropDown
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheModelSearchFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.linVehicleModelSearchFromDropDown, "Vehicle Model search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheModelSearchFromDropDown
     * description ::To click On The ClassSearch From DropDown
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheClassSearchFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.lnkClassFromMoreInfoTabFromDropDown, "Class search from More Info Tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTypeValue
     * description ::To get Type Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTypeValue() throws Throwable {
        //String typelocator = String.valueOf(CRVehicleTriagePage.txtVehicleType);
        String type = getAttributeByValue(CRVehicleTriagePage.txtVehicleType,"Vehicle Type");
        return type;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTab
     * description ::To verify the availability on MoreInfo Tab
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public boolean getMoreInfoTab() throws Throwable {
        boolean visibilityOfMoreInfoTab = isVisibleOnly(CRVehicleTriagePage.btnMoreinfoTab, " More Info Tab");
        /*if (visibilityOfMoreInfoTab) {
            assertTrue(visibilityOfMoreInfoTab, "More Info Tab exists");
        } else {
            assertFalse(visibilityOfMoreInfoTab, "More Info Tab Not Appears");
        }*/
        assertTrue(visibilityOfMoreInfoTab, "More Info Tab exists");
        return visibilityOfMoreInfoTab;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getYearValue
     * description ::To get Year Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getYearValue() throws Throwable {
        //String yearlocator = String.valueOf(CRVehicleTriagePage.txtVehicleYear);
        String year = getAttributeByValue(CRVehicleTriagePage.txtVehicleYear,"Vehicle Year");
        return year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMakeValue
     * description ::To get Make Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMakeValue() throws Throwable {
        //String makelocator = String.valueOf(CRVehicleTriagePage.txtVehicleMake);
        String make = getAttributeByValue(CRVehicleTriagePage.txtVehicleMake,"Vehicle Make");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getModelValue
     * description ::To get Model Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getModelValue() throws Throwable {
        //String modellocator = String.valueOf(CRVehicleTriagePage.txtVehicleModel);
        String model = getAttributeByValue(CRVehicleTriagePage.txtVehicleModel,"Vehicle Model");
        return model;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTypeSubType
     * description ::To get MoreInfo TabSubType
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMoreInfoTabSubType() throws Throwable {
        //String subTypelocator = String.valueOf(CRVehicleTriagePage.txtMoreInfoTabSubType);
        String subType = getAttributeByValue(CRVehicleTriagePage.txtMoreInfoTabSubType,"More Info Tab Sub-Type");
        return subType;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTypeEngine
     * description ::To get MoreInfo Tab Engine
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMoreInfoTabEngine() throws Throwable {
        //String enginelocator = String.valueOf(CRVehicleTriagePage.txtMoreInfoTabEngineType);
        String engine = getAttributeByValue(CRVehicleTriagePage.txtMoreInfoTabEngineType,"More Info Tab Engine");
        return engine;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTypeComment
     * description ::To get MoreInfo Tab Comment
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMoreInfoTabComment() throws Throwable {
        //String commentlocator = String.valueOf(CRVehicleTriagePage.txtMoreInfoTabComment);
        String comment = getAttributeByValue(CRVehicleTriagePage.txtMoreInfoTabComment,"More Info Tab Comment");
        return comment;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleTraigeTabExists
     * description ::To verify VehicleTraige Tab Existance
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehicleTraigeTabExists() throws Throwable {
        boolean visibilityOfVehicleTriageTab = isVisibleOnly(CRVehicleTriagePage.txtVehicleSearch,"Vehicle Search Box is Exists Under Vehcile Triage Tab");
        assertTrue(visibilityOfVehicleTriageTab, "Vehicle/Triage section appeared");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehiclePriorKnownVehicleExists
     * description ::To verify Prior Known Vehicle in Vehicle Triage Tab
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehiclePriorKnownVehicleExists() throws Throwable {
        boolean visibilityOfVehiclePriorKnownVehicle = isVisibleOnly(CRVehicleTriagePage.linkVehicleModel,"Prior Known Vehicle in Vehicle Triage Tab");
        assertTrue(visibilityOfVehiclePriorKnownVehicle, "Prior Known Vehicles are appeared");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click on Air Only Option in Flat Tyre Section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnFlatTyreInAirOnlyOption() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnAirOnly,"Air Only");
        click(CRVehicleTriagePage.rbtnAirOnly, "Air Only");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click close icon in Selected Pacesetter code section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickCloseIconInSelectedPaceSetterCodeSection() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.iconCloseSelectedPaceSetterCode,"Close Icon Selected Pacesetter Code Section");
        click(CRVehicleTriagePage.iconCloseSelectedPaceSetterCode, "Close Icon Selected Pacesetter Code Section");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyIconBeginTriageHere
     * description :: This function validates if Icon Begin Triage is present or not
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void verifyIconBeginTriageHere() throws  Throwable{
        boolean flagTriageIcon = isVisibleOnly(CRVehicleTriagePage.iconBeginTriageHere, "Icon Begin Triage Here");
        assertTrue(flagTriageIcon, "The call no longer has that pacesetter code, Icon Begin Triage is Displayed");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectPaceSetterCodeforKeyIssue
     * description ::To select PaceSetter Code for KeyIssue
     * date :: 01-Jan-2018
     * author :: Abhiram
     */
    public void selectPaceSetterCodeforKeyIssue() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        Thread.sleep(5000);
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnCarStyleInKeys, "Car lock Key Issue");
        click(CRVehicleTriagePage.rbtnCarStyleInKeys, "Car lock Key Issue radio button");
        Thread.sleep(5000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClassOnMoreInfoTab
     * description ::To enter PaceSetterCode
     * date :: 02-Jan-2017
     * author ::Abhiram
     */
    public void enterPaceSetterCode(String paceSetterCode) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtSelectedPaceSetterCodes,"Selected Pacesetter codes");
        type(CRVehicleTriagePage.txtSelectedPaceSetterCodes,paceSetterCode, "Selected Pacesetter codes");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheSelectedPaceSetterCodeFromDropDown
     * description ::To click On The Selected PaceSetterCode From DropDown
     * date :: 02-Jan-2017
     * author ::Abhiram
     */
    public void clickOnTheSelectedPaceSetterCodeFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.lnkSelectedPacesetterCodeFromDropDown, "Selected Pacesetter Code search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseCallSummary
     * description ::To click On CloseCallSummary
     * date :: 02-Jan-2017
     * author ::Abhiram
     */
    public void clickOnCloseCallSummary() throws Throwable {
        if(isVisibleOnly(CRVehicleTriagePage.iconCloseCallSummary, "Close Call Summar"))
        {
            click(CRVehicleTriagePage.iconCloseCallSummary, "Close Call Summary");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: scriptErrorHandle
     * description ::To handle script Alerts
     * date :: 02-Jan-2017
     * author ::Chandra
     */
    public void scriptErrorHandle() throws Throwable{

        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            if (errorIconAvailablility) {
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            }
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");
        }
    }
   

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click on Air Only Option in Flat Tyre Section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnAirOnlyOptionInFlatTyreType() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnAirOnly,"Air Only");
        click(CRVehicleTriagePage.rbtnAirOnly, "Air Only");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallSummaryIcon
     * description :: This Function is used to click on Call Summary Icon
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnCallSummaryIcon() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.iconCallSummary,"Call Summary");
        click(CRVehicleTriagePage.iconCallSummary, "Call Summary");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click on Air Only Option in Flat Tyre Section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnOptionOneTyreChangeDriverSideFrontInFlatTyreType() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnOneTyreChangeDriverSideFront,"One Tyre Change-Driver Side Frony ");
        click(CRVehicleTriagePage.rbtnOneTyreChangeDriverSideFront, "One Tyre Change-Driver Side Frony");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnUnsureRbtnInOptionInFlatTyreType
     * description :: This Function is used to click on Unsure Radio Button for question Do you have a usable spare tyre in Flat tyre type
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnUnsureRbtnInOptionInFlatTyreType() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnUnsure,"Air Only");
        click(CRVehicleTriagePage.rbtnUnsure, "Air Only");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: closeCallSummaryWindow
     * description :: This Function is used close Call Summary Pop Up Window
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void closeCallSummaryPopUpWindow() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.iconCloseCallSummaryPopUpWindow,"Close Icon in Call Summary Call Summary Pop Up Window");
        click(CRVehicleTriagePage.iconCloseCallSummaryPopUpWindow, "Close Icon in Call Summary Call Summary Pop Up Window");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTow
     * description ::To click on tow option
     * date :: 3-Jan-2018
     * author :: Chandra
     */
    public void clickOnTow() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnTow,"Tow Button");
        click(CRVehicleTriagePage.btnTow, "Tow Button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBrakeFailurOnTow
     * description ::To click On brakeFailure radio button On Tow
     * date :: 3-Jan-2018
     * author :: Chandra
     */
    public void clickOnBrakeFailurOnTow() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnBreakFailureOnTOWProblem,"Brake Failure");
        click(CRVehicleTriagePage.rbtnBreakFailureOnTOWProblem, "Brake Failure");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateSelectedPaceSetterCode
     * description :: This Function validates if selected page setter code is displayed in Selected Pacesetter section or not
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public String validateSelectedPaceSetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        String strSelectedPaceSetterCodes = getText(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        assertTrue(strSelectedPaceSetterCodes != "", "Selected Pacesetter Codes is displayed, Name:"+strSelectedPaceSetterCodes);
        return strSelectedPaceSetterCodes;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreNeedsAirRadioButton
     * description :: This Function is used to click on Radio Button Flat Tyre Needs Air
     * date :: 3-Jan-2018
     * author :: Sachin
     */
    public void clickOnFlatTyreNeedsAirRadioButton() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnFlatTyreNeedsAir,"Flat tyre needs air");
        click(CRVehicleTriagePage.rbtnFlatTyreNeedsAir, "Flat tyre needs air");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCodeNUmberFromSelectedPaceSetterCode
     * description :: This Function is used get the code from selected pacesetter code
     * date :: 2-Jan-2018
     * author :: Sachin
     */
    public String getCodeNumberFromSelectedPaceSetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Code");
        String pacesettercode = getText(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Code");
        String code = pacesettercode.substring(0,4);
        return code;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBatteryButton
     * description :: To click On battery option
     * date :: 2-Jan-2018
     * author :: Sachin
     */
    public void clickOnBatteryButton() throws Throwable {

        click(CRVehicleTriagePage.btnBattery,"Battery Button");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnJumpStartRadioButton
     * description :: To click on JumpStartRadioButton
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnJumpStartRadioButton() throws Throwable {

        click(CRVehicleTriagePage.rdBtnBatteryIssue,"Battery Jump Start");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnKeysButton
     * description :: To click On Keys option
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnKeysButton() throws Throwable {

        click(CRVehicleTriagePage.btnKeys,"Keys Button");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnKeysButton
     * description :: To KeysLocked RadioButton
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnKeysLockedRadioButton() throws Throwable {

        click(CRVehicleTriagePage.rdBtnKeysissue,"Lockout Pacesetter");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickonProblemTypeButton
     * description :: To click On problem Type Button(This is a generic method to select all types of problems in Triage section)
     * date :: 4-Jan-2018
     * author :: Sachin
     */
    public void clickonProblemTypeButton(String problemtype) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnProblemTypes(problemtype),""+problemtype);
        click(CRVehicleTriagePage.btnProblemTypes(problemtype), ""+problemtype);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickonProblemTypeOptions
     * description :: This is a generic method to select all radio buttons depending on Problem Type in Triage section
     * date :: 4-Jan-2018
     * author :: Sachin
     */
    public void clickonProblemTypeOptions(String problemtypeoption) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnProblemTypesOptions(problemtypeoption),""+problemtypeoption);
        click(CRVehicleTriagePage.rbtnProblemTypesOptions(problemtypeoption), ""+problemtypeoption);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBreakDownForRVType
     * description :: To click On BreakDown For RVType
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnBreakDownForRVType() throws Throwable {

        click(CRVehicleTriagePage.rbthBreakDownFailureForRVValue,"Lockout Pacesetter");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterTag
     * description ::To click Tag
     * date :: 5 JAN 2018
     * author ::Abhiram
     */
    public void clickTag() throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleTag,"Vehicle tag");
        click(CRVehicleTriagePage.txtVehicleTag,"Vehicle tag");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleModelandColor
     * description ::To enter VehicleModel and Color
     * date :: 5 JAN 2018
     * author ::Abhiram
     */
    public void enterVehicleModelandColor(String vehicleModel, String vehicleColor) throws Throwable {
    	Entervehicleinfomanually(vehicleModel);
        clickVehicleSearchButton();
        availableVehicleaftersrch();
        vehicleColor(vehicleColor);
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleTypeandColor
     * description ::To enter VehicleType and Color
     * date :: 5 JAN 2018
     * author ::Abhiram
     */
    public void enterVehicleTypeandColor(String vehicleType, String vehicleColor) throws Throwable {
    	Vehicleinfolink();
        Vehicletype(vehicleType);
        enterVehicleColor(vehicleColor);
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterAndValidatePacesetterCode
     * description ::To enter And Validate PacesetterCode
     * date :: 5 JAN 2018
     * author ::Abhiram
     */
    public void enterAndValidatePacesetterCode(String pacesetterCode) throws Throwable {
    	enterPacesetterCodeBattery(pacesetterCode );
        //validate pacesettercode
        validatePacesetterCode(pacesetterCode );
    	
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleColor
     * description ::To get VehicleColor
     * date :: 19 JAN 2018
     * author ::Lakshmi Prasanna
     */
    public String getVehicleColor()throws  Throwable{
        String color = getAttributeByValue(CRVehicleTriagePage.dropboxVehicleColor,"Vehicle Color");
        return color;
    }


    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: verifyVehicleAvailable
     *  * description ::To verify availability of Vehicles
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public boolean verifyVehicleAvailable()throws  Throwable{
        boolean vehicleAvailable = isVisibleOnly(CRVehicleTriagePage.linkVehicleModel, "Existing Vehicles are Not Visible");
        return vehicleAvailable;

    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterProblemTypeManually
     *  * description ::To enter Problem TypeManually
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public void enterProblemTypeManually(String ProblemType) throws Throwable {
    	enterPaceSetterCode(ProblemType);
        clickOnTheSelectedPaceSetterCodeFromDropDown();
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
    	
    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterSingleProblemType
     *  * description ::To enter ProblemType based on the availability
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public void enterSingleProblemType(String ProblemType, String ProblemTypeOption1) throws Throwable {
    	clickonProblemTypeButton(ProblemType);
        Thread.sleep(3000);
        clickonProblemTypeOptions(ProblemTypeOption1);
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
    	
    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterDoubleProblemType
     *  * description ::To enter ProblemType based on the availability
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public void enterDoubleProblemType(String ProblemType, String ProblemTypeOption1, String ProblemTypeOption2) throws Throwable {
    	clickonProblemTypeButton(ProblemType);
        Thread.sleep(3000);
        clickonProblemTypeOptions(ProblemTypeOption1);
        Thread.sleep(2000);
        clickonProblemTypeOptions(ProblemTypeOption2);
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
    	
    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterTripleProblemType
     *  * description ::To enter ProblemType based on the availability
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
	public void enterTripleProblemType(String ProblemType, String ProblemTypeOption1, String ProblemTypeOption2, String ProblemTypeOption3 ) throws Throwable {
		clickonProblemTypeButton(ProblemType);
        Thread.sleep(3000);
        clickonProblemTypeOptions(ProblemTypeOption1);
        Thread.sleep(2000);
        clickonProblemTypeOptions(ProblemTypeOption2);
        Thread.sleep(2000);
        clickonProblemTypeOptions(ProblemTypeOption3);
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
		
	}
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: problemTriage
     *  * description ::This method is used to enter pacesetter code manually or by passing the parameters to "selectProblem()"
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public void problemTriage( String ProblemTriage, String ProblemType) throws Throwable {
        if(ProblemTriage.equalsIgnoreCase("Manual")) {
            enterPaceSetterCodeManually(ProblemType);
        }
        else {
            selectProblem(ProblemType);
        }
    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: inputVehicleColor
     *  * description ::To enter VehicleColor
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
	 public void inputVehicleColor(String VehicleColor) throws Throwable {
	        clearData(CRVehicleTriagePage.txtVehicleColor);
	        enterVehicleColor(VehicleColor);
	        Thread.sleep(3000);
	    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: vehicleType
     *  * description ::To enter vehicleType
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
	 public void vehicleType(String VehicleType) throws Throwable {
         if((VehicleType.equalsIgnoreCase("MC")) ||
            (VehicleType.equalsIgnoreCase("PS")) ||
            (VehicleType.equalsIgnoreCase("RV")) ||
            (VehicleType.equalsIgnoreCase("TR")))
         {
             clearData(CRVehicleTriagePage.txtVehicleType);
             enterVehicleType(VehicleType);
             clickOnTheTypeSearchFromDropDown();
             Thread.sleep(3000);
         }
	 }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickonManualEntryandEnterYearMakeModel
     *  * description ::To click on Manual Entry and Enter Year, Make, Model
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
	 public void clickonManualEntryandEnterYearMakeModel(String EnterYear, String EnterMake, String EnterModel) throws Throwable {
		 clickOnManualEntryLinkOnVehicle();
         Thread.sleep(1000);
		 enterVehicleYear(EnterYear);
         Thread.sleep(2000);
         enterVehicleMake(EnterMake);
         enterVehicleModel(EnterModel);
	 }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: vehicleSearch
     *  * description ::To do vehicle In three ways.1)By clicking on existing link, 2)by entering vehicel info manually, 3)entering vehicel info from Omni search bar
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public void vehicleSearch(String VehicleSearch, String VehicleDetails ) throws Throwable {
        switch (VehicleSearch )
        {
            case "Existing" :
                String vehicle[] = VehicleDetails.split("#");
                boolean noVehicleLocationAvailable = verifyVehicleAvailable();
                boolean nopriorvehicle = verifyNoPriorvehicleAvailable();
                if(noVehicleLocationAvailable && (!nopriorvehicle))
                {
                	Thread.sleep(3000);
                    selectExistingVehicleModel();
                    String type = getTypeValue();
                    if(!type.contains("PS"))
                    {
                        clickOnManualEntryLinkOnVehicle();
                        enterVehicleDetailsManually(VehicleDetails);
                    }
                    /*String make = getMakeValue();
                    if(make.isEmpty())
                    {
                        enterVehicleMake(vehicle[2]);
                    }
                    String model = getModelValue();
                    if(model.isEmpty())
                    {
                        enterVehicleModel(vehicle[3]);
                    }
                    String year = getYearValue();
                    if(year.isEmpty())
                    {
                        enterVehicleYear(vehicle[1]);
                    }*/
                    String color = getColorValue();
                    if(color.isEmpty())
                    {
                        enterVehicleColor(vehicle[4]);
                    }
                }
                else
                {
                    enterVehicleDetailsManually(VehicleDetails);
                }
                break;
            case "Manual" :
                enterVehicleDetailsManually(VehicleDetails);
                break;
            case "Year Make Model" :
                String VehicleDet[] = VehicleDetails.split("#");
                enterVehicleSearch(VehicleDet[0]);
                clickOnTheVehicleSearchIcon();
                //clickOnTheVehicleSearch();

                availableVehicleaftersrch();
                vehicleColor(VehicleDet[1]);
                break;
            default :
                break;
        }
    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterVehicleDetails
     *  * description ::To enter Vehicle Details
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public void enterVehicleDetails(String VehicleSearch, String VehicleDetails ) throws Throwable {
        vehicleSearch(VehicleSearch,VehicleDetails);
    }
	 /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPaceSetterCodeManually
     * description :: enterPaceSetterCodeManually
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
    public void enterPaceSetterCodeManually(String paceSettercode) throws Throwable {
        click(CRVehicleTriagePage.txtPacesetterCode, "paceSettercode");
        type(CRVehicleTriagePage.txtPacesetterCode, paceSettercode, "paceSettercode");
        waitForVisibilityOfElement(CRVehicleTriagePage.doubleClickPaceCode, "Double Click on PaceSetterCode");
        mouseDoubleClick(CRVehicleTriagePage.doubleClickPaceCode, "Double click on paceSettercode");
        Thread.sleep(2000);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectProblem
     * description :: This method is used to split the problem type based on"#" and click On the problem type based on the value
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
	 public void selectProblem(String Problem) throws Throwable {
		String ProblemType[] = Problem.split("#");
		clickonProblemTypeButton(ProblemType[0]);
		errorAlertHandlingBeforeEnterMandatoryFields();
		if(ProblemType.length<=1)
        {
            reporter.failureReport("<b>Checking for select Problem Options</b>", "PaceSetter code is not updated with given options ",driver);
            throw new Exception("PaceSetter code is not updated with given options ");
        }
        Thread.sleep(3000);
        for (int i = 1; i < ProblemType.length; i++) {
        	clickonProblemTypeOptions(ProblemType[i]);
        	Thread.sleep(3000);
        }

        boolean cancelPacesetetrCodeAvailable = verifyCancelPacesetterCode();
        if(!cancelPacesetetrCodeAvailable)
        {
            reporter.failureReport("<b>Checking for select Problem Options</b>", "PaceSetter code is not updated with given options",driver);
            throw new Exception("PaceSetter code is not updated with given options ");
        }

	 }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleMandatoryFields
     * description :: This method is used to split the mandatory fields string  based on "#" and enter each field by spliting value
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
	 public void enterVehicleMandatoryFields(String VehicleDetails) throws Throwable {
	     String VehicleDet[] = VehicleDetails.split("#");
		 
		 errorAlertHandlingBeforeEnterMandatoryFields();
	        enterVehicleType(VehicleDet[0]);
	        tabout();
	        Thread.sleep(1000);
	        tabout();
	        errorAlertHandlingBeforeEnterMandatoryFields();
	        Thread.sleep(3000);
	        enterVehicleYear(VehicleDet[1]);
	        //tabout();
	        Thread.sleep(1000);
	        enterVehicleMake(VehicleDet[2]);
	        tabout();
	        Thread.sleep(1000);
	        enterVehicleModel(VehicleDet[3]);
	        tabout();
	        Thread.sleep(1000);
	        enterVehicleColor(VehicleDet[4]);
	        tabout();
	        Thread.sleep(1000);        
	 }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleDetailsManually
     * description :: To enter VehicleDetails Manually
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
	 public void enterVehicleDetailsManually(String VehicleDetails) throws Throwable {
		 clickOnManualEntryLinkOnVehicle();
		 enterVehicleMandatoryFields(VehicleDetails);
	 }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleDetailsinSearchBar
     * description :: To enter Vehicle Details from SearchBar
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
	 public void enterVehicleDetailsinSearchBar(String VehicleDetails) throws Throwable {
		 String VehicleDet[] = VehicleDetails.split("#");
		 enterVehicleSearch(VehicleDet[0]);
         clickOnTheVehicleSearchIcon();
         clickOnTheVehicleSearch();
         Thread.sleep(3000);
	     enterVehicleColor(VehicleDet[1]);
	 }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCompleteCheckVehicleTriage
     * description :: To verify Complete Check VehicleTriage
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
    public void verifyCompleteCheckVehicleTriage()  throws Throwable {
        if (!(isVisibleOnly(CRVehicleTriagePage.verifyVehicleTriageCompleteCheck, "Vehicle Triage Complete Check"))) {
            reporter.failureReport("Verify Vehicle Triage Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: getVehicleText
     *  * description ::To get Vehicle Text
     *  * retrivedTime :: 09-Feb-2018
     *  * author :: Abhiram
     *
     */
    public String getVehicleText()throws  Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleInformation, "Existing Vehicles Information");
        String vehicleAvailable = getText(CRVehicleTriagePage.linkVehicleInformation, "Existing Vehicles Information");
        return vehicleAvailable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getColorValue
     * description ::To get Color Value
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getColorValue() throws Throwable {
        String color = getAttributeByValue(CRVehicleTriagePage.txtVehicleColor,"Vehicle Color");
        return color;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTypeLabel
     * description ::To get TypeLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTypeLabel() throws Throwable {
        String Type = getText(CRVehicleTriagePage.lblType,"Verified Type Label");
        return Type;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getYearLabel
     * description ::To get YearLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getYearLabel() throws Throwable {
        String Year = getText(CRVehicleTriagePage.lblYear,"Verified Type Label");
        return Year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMakeLabel
     * description ::To get MakeLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMakeLabel() throws Throwable {
        String Make = getText(CRVehicleTriagePage.lblMake,"Verified Type Label");
        return Make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getModelLabel
     * description ::To get ModelLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getModelLabel() throws Throwable {
        String Model = getText(CRVehicleTriagePage.lblModel,"Verified Model Label");
        return Model;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTrimLabel
     * description ::To get get TrimLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTrimLabel() throws Throwable {
        String Trim = getText(CRVehicleTriagePage.lblTrim,"Verified Trim Label");
        return Trim;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getColorLabel
     * description ::To get ColorLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getColorLabel() throws Throwable {
        String Color = getText(CRVehicleTriagePage.lblColor,"Verified Color Label");
        return Color;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDrivelineLabel
     * description ::To get DrivelineLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getDrivelineLabel() throws Throwable {
        String Driveline = getText(CRVehicleTriagePage.lblDriveline,"Verified Driveline Label");
        return Driveline;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTagLabel
     * description ::To get TagLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTagLabel() throws Throwable {
        String Tag = getText(CRVehicleTriagePage.lblTag,"Verified Tag Label");
        return Tag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStateLabel
     * description ::To get StateLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getStateLabel() throws Throwable {
        String State = getText(CRVehicleTriagePage.lblState,"Verified State Label");
        return State;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFlatLabel
     * description ::To get FlatLabel
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getFlatLabel() throws Throwable {
        String Flat = getText(CRVehicleTriagePage.lblFlat,"Verified Flat Label");
        return Flat;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getNoteLable
     * description ::get NoteLable
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getNoteLable() throws Throwable {
        String Note = getText(CRVehicleTriagePage.lblNote,"Verified Note Label");
        return Note;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryTroubleCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public String lblCallSummaryTroubleCodes() throws Throwable {
        boolean visibilityOfSummaryTroubleCodes = isVisibleOnly(CRVehicleTriagePage.lblcallSummaryTroubleCodes, " Label Trouble Codes");
        assertTrue(visibilityOfSummaryTroubleCodes, "Summary Call Window.");

        String summaryTroubleCodes = getText(CRVehicleTriagePage.lblcallSummaryTroubleCodes, "Trouble Codes is available in Summary Window");
        assertTrue(visibilityOfSummaryTroubleCodes, "Trouble Codes is available in Summary Window");
        return summaryTroubleCodes;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRAPTabOnVehicleTriage
     * description ::To click On RAP Tab OnVehicleTriage
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnRAPTabOnVehicleTriage()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.lnkRAPTab,"RAP TAB");
        click(CRVehicleTriagePage.lnkRAPTab,"RAP TAB");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVINForRAPOnVehicleTriage
     * description ::To enter VIN For RAP On VehicleTriage
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterVINForRAPOnVehicleTriage(String vin)throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVinOnRAPtab,"VIN");
        type(CRVehicleTriagePage.txtVinOnRAPtab,vin,"Vin TextBox");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddButtonTriageSection
     * description ::To click On AddButton TriageSection
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnAddButtonTriageSection()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.btnAddTriageSection,"Add Button Triage Section");
        click(CRVehicleTriagePage.btnAddTriageSection,"Add Button Triage Section");
        Thread.sleep(5000);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextInvalidCommentProvided
     * description ::To get TextInvalidCommentProvided
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public String  getTextInvalidCommentProvided()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.lblInvalidTextProvided,"Invalid Comment Provided");
        String errorMessage  =getText(CRVehicleTriagePage.lblInvalidTextProvided,"Add Button Triage Section").trim();
        return errorMessage;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: EnterTextCommentTriageSection
     * description ::To enter comments In Triage section
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void  EnterTextCommentTriageSection(String comments)throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.txtTriageComment,"Comments in Triage Section");
        type(CRVehicleTriagePage.txtTriageComment,comments,"Comments in Triage Section");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateSelectedPaceSetterCode
     * description :: This Function validates if selected page setter code is displayed in Selected Pacesetter section or not
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public String GetSelectedPaceSetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        String strSelectedPaceSetterCodes = getText(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        return strSelectedPaceSetterCodes;
    }

    /**
     *  return ::void
     * throws :: throwable
     * methodName :: clickOnCommentButton
     * Description:To click on comment button
     * Date: 18-02-2018
     * @Author : Ravi
     * @throws Throwable
     */
    public void clickOnCommentButton()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.btnComment,"button comment");
        click(CRVehicleTriagePage.btnComment,"comment button");
        Thread.sleep(5000);
    }


    /**
     *  return ::void
     * throws :: throwable
     * methodName :: getDateAndTime
     * Description:To get Date And Time
     * Date: 18-02-2018
     * @Author : Ravi
     * @throws Throwable
     */
    public String getDateAndTime()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.lblDateTime,"date and time");
        String dateValue=getText(CRVehicleTriagePage.lblDateTime,"overridden date and time");
        Thread.sleep(3000);
        return dateValue;

    }


    /**
     *  return ::void
     * throws :: throwable
     * methodName :: getCommentedValue
     * Description:To get Commented Value
     * Date: 18-02-2018
     * @Author : Ravi
     * @throws Throwable
     */
    public void getCommentedValue()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.txtCommentedValue,"commented value");
        getText(CRVehicleTriagePage.txtCommentedValue,"commented value");
        Thread.sleep(5000);
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validatePacesetterSecondButton
     * description ::To validate Pacesetter SecondButton
     * date :: 20-02-2018
     * author :: Chandra
     */
    public boolean validatePacesetterSecondButton() throws Throwable {
        boolean secondPacesetterButton= isVisibleOnly(CRVehicleTriagePage.btnAddSecondPaceSetterCode,"Selected Pacesetter Codes");
        return secondPacesetterButton;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPacesetterSecondButton
     * description ::To click On Pacesetter SecondButton
     * date :: 20-02-2018
     * author :: Chandra
     */
    public void clickOnPacesetterSecondButton() throws Throwable {
        click(CRVehicleTriagePage.btnAddSecondPaceSetterCode,"Selected Pacesetter Codes");
    }

    /* *
        * param :: String inputs
        * return ::void
        * throws :: throwable
        * methodName :: clickOkNearByAddressError
        * description ::
        * date :: 20-feb-2018
        * author :: Nidhi
       */
    public void clickOkNearByAddressError() throws Throwable {
        Thread.sleep(3000);
        if(isVisibleOnly(CRVehicleTriagePage.btnOkOnNearByAddressError, "Error Ok"))
        {
            click(CRVehicleTriagePage.btnOkOnNearByAddressError, "Error Ok");
        }

    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: verifyNoPriorvehicleAvailable
     * * description :: checking for vehicles available or not
     * * retrivedTime :: 16-Jan-2017
     * * author :: Abhiram
     */
    public boolean verifyNoPriorvehicleAvailable() throws Throwable {
        boolean noPriorVehicles = isVisibleOnly(CRVehicleTriagePage.noPriorVehicles, "No Prior vehicle are not Available");
        return noPriorVehicles;

    }
    public void tabout() throws Throwable
	{
		Thread.sleep(3000);
	    String combineKeys3 = Keys.chord(Keys.TAB);
	    sendKeys(combineKeys3, "Tab");
	}

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getYearValueFromGridAfterClickOnSearchIcon
     * description ::
     * date :: 02-Mar-2018
     * author ::Abhiram
     */
    public String getYearValueFromGridAfterClickOnSearchIcon() throws Throwable {
        String yearValue = getText(CRVehicleTriagePage.lblYearInAfterClickOnSearchIocnInOmnibar, "Year Value is Available in Grid");
        return yearValue;
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getMakeAndModelValueFromGridAfterClickOnSearchIcon
     * description ::
     * date :: 02-Mar-2018
     * author ::Abhiram
     */
    public String getMakeAndModelValueFromGridAfterClickOnSearchIcon() throws Throwable {
        String makeAndModelValue = getText(CRVehicleTriagePage.lblMakeAndModelAterClickOnSearchIocnInOmnibar, "Make and Model Value is Available in Grid");
        return makeAndModelValue;
    }

    /**
     * * param :: NA
     * * return ::boolean
     * * throws :: throwable
     * * methodName :: verifyProgressBarAvailable
     * * description :: verifyProgressBarAvailable
     * * retrivedTime :: 06-Apr-2017
     * * author :: Abhiram
     */
    public boolean verifyCancelPacesetterCode() throws Throwable {

        boolean cancelPacesetetrCodeAvailable = isVisibleOnly(CRVehicleTriagePage.linkPacesetterCodeCancel, "Cancel X mark not available Bar");
        return cancelPacesetetrCodeAvailable;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: crCommonErrorHandler
     * description :: To handle script alerts
     * date :: 17-April-2018
     * author ::
     */
    public void crCommonErrorHandler() throws Throwable {

        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            //assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            if (errorIconAvailablility) {
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            }
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
            //waitForVisibilityOfElement(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");

        }
    }


}
