package com.aaa.rspweb.lib;

import com.aaa.rspweb.pages.RSPOrderDetailsArrivedPage;

public class RSPOrderDetailsArrivedLib extends RSPCommonLib{

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownTrim
     * description :: to click trim dropdown
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownTrim() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnOpenComboBoxForTrim,60);
        click(RSPOrderDetailsArrivedPage.btnOpenComboBoxForTrim,"Successfully clicked on trim combo box");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownYear
     * description :: to click drop down year
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownYear() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnOpenComboBoxForYear,60);
        click(RSPOrderDetailsArrivedPage.btnOpenComboBoxForYear,"Successfully clicked on year combo box");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownMake
     * description :: to click dropdown make
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownMake() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnOpenComboBoxForMake,60);
        click(RSPOrderDetailsArrivedPage.btnOpenComboBoxForMake,"Successfully clicked on make combo box");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownModel
     * description ::to click dropdown model
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownModel() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnOpenComboBoxForModel,60);
        click(RSPOrderDetailsArrivedPage.btnOpenComboBoxForModel,"Successfully clicked on model combo box");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnInfo
     * description :: clicks on information tab in left frame
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnInfo() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnInfo,60);
        click(RSPOrderDetailsArrivedPage.btnInfo,"Click on Info");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCustomer
     * description ::clicks on customer tab in left frame
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnCustomer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnCustomer,60);
        click(RSPOrderDetailsArrivedPage.btnCustomer,"Click on customer");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicle
     * description :: clicks on vehicle tab in left frame
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnVehicle() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnVehicle,60);
        click(RSPOrderDetailsArrivedPage.btnVehicle,"Click on vehicle");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairService
     * description :: clicks on repair service tab in left frame
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnRepairService() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnRepairService,60);
        click(RSPOrderDetailsArrivedPage.btnRepairService,"Click on repair service");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairCost
     * description :: clicks on repair cost tab in left frame
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnRepairCost() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnRepairCost,60);
        click(RSPOrderDetailsArrivedPage.btnRepairCost,"Click on repair cost");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHistory
     * description :: clicks on history tab in left frame
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnHistory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnHistory,60);
        click(RSPOrderDetailsArrivedPage.btnHistory,"Click on history");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getAAAClubValue
     * description :: gets AAA club value
     * date :: 
     * author :: Jagadish Pola
     */

    //info frame layout
    public String getAAAClubValue() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblAAAClub,60);
        return getText(RSPOrderDetailsArrivedPage.lblAAAClub,"AAA club value::");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getAssignedShop
     * description :: gets Assigned shop value
     * date :: 
     * author :: Jagadish Pola
     */

    public String getAssignedShop() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblAssignedShop,60);
        return getText(RSPOrderDetailsArrivedPage.lblAssignedShop,"Assigned shop::");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getStatus
     * description :: gets status
     * date :: 
     * author :: Jagadish Pola
     */

    public String getStatus() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblStatus,60);
        Thread.sleep(1000);
        return getText(RSPOrderDetailsArrivedPage.lblStatus,"Status::");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTimeCreated
     * description :: returns time created
     * date :: 
     * author :: Jagadish Pola
     */

    public String getTimeCreated() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblTimeCreated,60);
        return getText(RSPOrderDetailsArrivedPage.lblTimeCreated,"Time created::");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getType
     * description :: returns type
     * date :: 
     * author :: Jagadish Pola
     */

    public String getType() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblType,60);
        return getText(RSPOrderDetailsArrivedPage.lblType,"Type::");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getLastUpdated
     * description :: returns Last updated time
     * date :: 
     * author :: Jagadish Pola
     */

    public String getLastUpdated() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblLastUpdated,60);
        return getText(RSPOrderDetailsArrivedPage.lblLastUpdated,"Last updated::");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getSVO
     * description :: returns SVO
     * date :: 
     * author :: Jagadish Pola
     */

    public String getSVO() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblSVO,60);
        return getText(RSPOrderDetailsArrivedPage.lblSVO,"SVO::");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getMemberNumber
     * description :: returns Member number
     * date :: 
     * author :: Jagadish Pola
     */

    //Customer Layout

    public String getMemberNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtMemberNumber,60);
       return getAttributeByValue(RSPOrderDetailsArrivedPage.txtMemberNumber,"Member number");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumber
     * description :: enters member number
     * date :: 
     * author :: Jagadish Pola
     */

    //Customer Layout

    public void enterMemberNumber(String memberNumber) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtMemberNumber,60);
        type(RSPOrderDetailsArrivedPage.txtMemberNumber,memberNumber,"Member number");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchOrValidButton
     * description :: clicks on search or valid button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnSearchOrValidButton() throws Throwable {
    dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnSearchAndValid,60);
    click(RSPOrderDetailsArrivedPage.btnSearchAndValid,"Search or valid button::");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPhoneNumber
     * description :: returns phone number
     * date :: 
     * author :: Jagadish Pola
     */

    public String getPhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtPhoneNumber,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtPhoneNumber,"<b>Phone number::</b>");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterPhoneNumber
     * description :: enters phone number
     * date :: 
     * author :: Jagadish Pola
     */

    //Customer Layout

    public void enterPhoneNumber(String phoneNumber) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtPhoneNumber,60);
        type(RSPOrderDetailsArrivedPage.txtPhoneNumber,phoneNumber,"Phone number");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkOtherNumbers
     * description :: clicks on other number link
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnLinkOtherNumbers() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkOtherNumbers,60);
        click(RSPOrderDetailsArrivedPage.lnkOtherNumbers,"OtherNumbers");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getEmail
     * description :: returns email
     * date :: 
     * author :: Jagadish Pola
     */

    public String getEmail() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtEmail,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtEmail,"Email");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterEmail
     * description :: enters email
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterEmail(String email) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtEmail,60);
        type(RSPOrderDetailsArrivedPage.txtEmail,email,"Email");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFirstName
     * description :: returns first name
     * date :: 
     * author :: Jagadish Pola
     */

    public String getFirstName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtFirstName,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtFirstName,"<b>First name::</b>");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterFirstName
     * description :: enters first name
     * date ::
     * author :: Jagadish Pola
     */

    public void enterFirstName(String firstName) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtFirstName,60);
        type(RSPOrderDetailsArrivedPage.txtFirstName,firstName,"First name ");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearFirstName
     * description :: clears first name
     * date ::
     * author :: Jagadish Pola
     */

    public void clearFirstName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtFirstName,60);
        clearData(RSPOrderDetailsArrivedPage.txtFirstName);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getLastName
     * description :: returns last name
     * date :: 
     * author :: Jagadish Pola
     */

    public String getLastName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtLastName,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtLastName,"<b>Last name::</b>");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearLastName
     * description :: clears last name
     * date ::
     * author :: Jagadish Pola
     */

    public void clearLastName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtLastName,60);
        clearData(RSPOrderDetailsArrivedPage.txtLastName);
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterLastName
     * description :: enters last name
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterLastName(String lastName) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtLastName,60);
        type(RSPOrderDetailsArrivedPage.txtLastName,lastName,"Last name ");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectLicenseStateFromDropdown
     * description :: selects licence state from dropdown
     * date :: 
     * author :: Jagadish Pola
     */


    /*parameter name should be the option value
    eg:- format "AL - Alabama"
     */
    public void selectLicenseStateFromDropdown(String licenseState) throws Throwable {
        click(RSPOrderDetailsArrivedPage.sltLicenceState,"Clicking on license state dropdown");
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectLicenseState(licenseState),60);
        mouseHover(RSPOrderDetailsArrivedPage.selectLicenseState(licenseState),"Licence state");
        click(RSPOrderDetailsArrivedPage.selectLicenseState(licenseState),"Licence state");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectVehicleTrimFromDropdown
     * description :: selects vehicle trim
     * date :: 
     * author :: Jagadish Pola
     */


    /*parameter name should be the option value
     ************It is disbale state if value found please provide the example here in above format****************************

     */

    public void selectVehicleTrimFromDropdown(String vehicleTrim) throws Throwable {
        clickOnDropdownTrim();
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectVehicleTrim(vehicleTrim),60);
        mouseHover(RSPOrderDetailsArrivedPage.selectVehicleTrim(vehicleTrim), "Vehicle trim");
        click(RSPOrderDetailsArrivedPage.selectVehicleTrim(vehicleTrim), "Vehicle trim");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleTrim
     * description :: returns vehicle trim
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVehicleTrim() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtTrim,60);
        return getText(RSPOrderDetailsArrivedPage.txtTrim, "Vehicle trim");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleTrim
     * description :: enters vehicel trim
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterVehicleTrim(String vehicleTrimText) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtTrim,60);
        type(RSPOrderDetailsArrivedPage.txtTrim, vehicleTrimText,"Vehicle trim");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getVIN
     * description :: returns VIN
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVIN() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVIN,60);
        return getText(RSPOrderDetailsArrivedPage.txtVIN,"VIN");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterVIN
     * description :: enter VIN
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterVIN(String textForVIN) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVIN,60);
        type(RSPOrderDetailsArrivedPage.txtVIN,textForVIN,"VIN");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVINSearchAndValid
     * description :: clicks on VIN search or valid button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnVINSearchAndValid() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnVINSearchAndValid,60);
        click(RSPOrderDetailsArrivedPage.btnVINSearchAndValid,"Button VIN search or valid");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectYear
     * description :: selects year from dropdown
     * date :: 
     * author :: Jagadish Pola
     */


    public void selectYear(String year) throws Throwable {
        clickOnDropdownYear();
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectYearFromDropdown(year),60);
        mouseHover(RSPOrderDetailsArrivedPage.selectYearFromDropdown(year),"Year");
        click(RSPOrderDetailsArrivedPage.selectYearFromDropdown(year),"Year");
        }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleYear
     * description :: returns vehicle year
     * date :: 
     * author :: Jagadish Pola
     */


    public String getVehicleYear() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtYear,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtYear,"Year");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterYear
     * description :: enter year
     * date :: 
     * author :: Jagadish Pola
     */

        public void enterYear(String year) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtYear,60);
        type(RSPOrderDetailsArrivedPage.txtYear,year,"Year");
        }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectVehicleMake
     * description :: select vehicle make from dropdown
     * date :: 
     * author :: Jagadish Pola
     */


    public void selectVehicleMake(String vehicleMake) throws Throwable {
            clickOnDropdownMake();
            dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectVehicleMake(vehicleMake),60);
            mouseHover(RSPOrderDetailsArrivedPage.selectVehicleMake(vehicleMake),"Vehicle make");
            click(RSPOrderDetailsArrivedPage.selectVehicleMake(vehicleMake),"Vehicle make");
        }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleMake
     * description :: returns vehicle make
     * date :: 
     * author :: Jagadish Pola
     */
    public String getVehicleMake() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVehicleMake,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtVehicleMake,"Vehicle make");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleMake
     * description :: enter vehicle make
     * date :: 
     * author :: Jagadish Pola
     */
    public void enterVehicleMake(String vehicleMake) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVehicleMake,60);
        type(RSPOrderDetailsArrivedPage.txtVehicleMake,vehicleMake,"Vehicle make");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectVehicleModel
     * description :: selects vehicle make from dropdown
     * date :: 
     * author :: Jagadish Pola
     */


    public void selectVehicleModel(String vehicleModel) throws Throwable {
        clickOnDropdownModel();
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectVehicleModel(vehicleModel),60);
        mouseHover(RSPOrderDetailsArrivedPage.selectVehicleModel(vehicleModel),"Vehicle model");
        click(RSPOrderDetailsArrivedPage.selectVehicleModel(vehicleModel),"Vehicle model");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleModel
     * description :: returns vehicle model
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVehicleModel() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVehicleModel,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtVehicleModel, "Vehicle model");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleModel
     * description :: enters vehicle model
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterVehicleModel(String vehicleModel) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVehicleModel,60);
        type(RSPOrderDetailsArrivedPage.txtVehicleModel,vehicleModel, "Vehicle model");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getColor
     * description :: returns vehicle color
     * date :: 
     * author :: Jagadish Pola
     */

    public String getColor() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtColor,60);
        return getText(RSPOrderDetailsArrivedPage.txtColor,"Color");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterColor
     * description :: enter vehicle color
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterColor(String color) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtColor,60);
        type(RSPOrderDetailsArrivedPage.txtColor,color,"Color");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getOdometer
     * description :: returns odometer
     * date :: 
     * author :: Jagadish Pola
     */

    public String getOdometer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtOdometer,60);
        return getText(RSPOrderDetailsArrivedPage.txtOdometer,"Odometer");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterOdometer
     * description :: type odometer
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterOdometer(String odometer) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtOdometer,60);
        type(RSPOrderDetailsArrivedPage.txtOdometer,odometer,"Odometer");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getLicenceNumber
     * description :: returns licence number
     * date :: 
     * author :: Jagadish Pola
     */

    public String getLicenceNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtLicenseNumber,60);
        return getText(RSPOrderDetailsArrivedPage.txtLicenseNumber,"Licence Number");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterLicenceNumber
     * description :: enters licence number
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterLicenceNumber(String licenceNumber) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtLicenseNumber,60);
        type(RSPOrderDetailsArrivedPage.txtLicenseNumber,licenceNumber,"Licence Number");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEditInspection
     * description :: clicks on edit inspection
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnEditInspection() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnEditInspection,60);
        click(RSPOrderDetailsArrivedPage.btnEditInspection,"Edit inspection");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMessege
     * description :: clicks on messege button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnMessege() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnMessege,60);
        click(RSPOrderDetailsArrivedPage.btnMessege,"Messege button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPrint
     * description :: clicks on print button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnPrint() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnPrint,60);
        click(RSPOrderDetailsArrivedPage.btnPrint,"Print button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: selectServiceCategory
     * description :: select service category
     * date :: 
     * author :: Jagadish Pola
     */
    //Service Provider Layout

    public void selectServiceCategory(String serviceCategory) throws Throwable {
        click(RSPOrderDetailsArrivedPage.clkServiceDropdown,"Click service dropdown");
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectServiceCategory(serviceCategory),60);
        mouseHover(RSPOrderDetailsArrivedPage.selectServiceCategory(serviceCategory),"Service category::"+serviceCategory);
        click(RSPOrderDetailsArrivedPage.selectServiceCategory(serviceCategory),"Service category::"+serviceCategory);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getServiceCategory
     * description :: gets service category
     * date :: 
     * author :: Jagadish Pola
     */

    public String getServiceCategory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.clkServiceDropdown,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.clkServiceDropdown, "Service category");
    }

        /**
         * param :: String
         * return ::void
         * throws :: throwable
         * methodName :: selectServiceSubCategory
         * description :: select service sub category
         * date :: 
         * author :: Jagadish Pola
         */

        public void selectServiceSubCategory(String serviceSubCategory) throws Throwable {
            click(RSPOrderDetailsArrivedPage.clkServiceSubCategoryDropdown,"Click service sub category dropdown");
            dynamicWaitByLocator(RSPOrderDetailsArrivedPage.selectServiceSubCategory(serviceSubCategory),60);
            mouseHover(RSPOrderDetailsArrivedPage.selectServiceSubCategory(serviceSubCategory),"Service sub category::"+serviceSubCategory);
            click(RSPOrderDetailsArrivedPage.selectServiceSubCategory(serviceSubCategory),"Service sub category::"+serviceSubCategory);
        }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getServiceSubCategory
     * description :: returns service sub category
     * date :: 
     * author :: Jagadish Pola
     */
    public String getServiceSubCategory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.clkServiceSubCategoryDropdown,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.clkServiceSubCategoryDropdown, "Service sub category");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getAAAProblemCode
     * description :: returns AAA Problem code
     * date :: 
     * author :: Jagadish Pola
     */
    public String getAAAProblemCode() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblAAAProblenCode,60);
        return getText(RSPOrderDetailsArrivedPage.lblAAAProblenCode,"AAA problen code");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getResolutionCode
     * description :: returns resolution code
     * date :: 
     * author :: Jagadish Pola
     */

    public String getResolutionCode() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblResolutionCode,60);
        return getText(RSPOrderDetailsArrivedPage.lblResolutionCode,"Resolution code");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getRepairOrderNumber
     * description :: returns repair order number
     * date :: 
     * author :: Jagadish Pola
     */

    public String getRepairOrderNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtRepairOrderNumber,60);
        return getText(RSPOrderDetailsArrivedPage.txtRepairOrderNumber,"Repair order number");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: enterRepairOrderNumber
     * description :: enters repair order number
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterRepairOrderNumber(String repairOrderNumber) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtRepairOrderNumber,60);
        type(RSPOrderDetailsArrivedPage.txtRepairOrderNumber,repairOrderNumber,"Repair order number");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearRepairOrderNumber
     * description :: clears repair order number
     * date :: 
     * author :: Jagadish Pola
     */

    public void clearRepairOrderNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtRepairOrderNumber,60);
        clearData(RSPOrderDetailsArrivedPage.txtRepairOrderNumber);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBatteryService
     * description :: clicks on battery services
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnBatteryService() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnBatteryService,60);
        click(RSPOrderDetailsArrivedPage.btnBatteryService,"Battery service button");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getRepairNotes
     * description :: returns repair notes
     * date :: 
     * author :: Jagadish Pola
     */

    public String getRepairNotes() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtRepairNotes,60);
        return getText(RSPOrderDetailsArrivedPage.txtRepairNotes,"Repair order number");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterRepairNotes
     * description :: enter repair notes
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterRepairNotes(String repairNotes) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtRepairNotes,60);
        type(RSPOrderDetailsArrivedPage.txtRepairNotes,repairNotes,"Repair order number");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getInvoiceTotal
     * description :: returns invoice total
     * date :: 
     * author :: Jagadish Pola
     */

    //Repair Cost Layout
    public String getInvoiceTotal() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtInvoiceTotal,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtInvoiceTotal,"Invoice total");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: enterInvoiceTotal
     * description :: enters invoice total
     * date :: 
     * author :: Jagadish Pola
     */

    //Repair Cost Layout
    public void enterInvoiceTotal(String invoiceTotal) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtInvoiceTotal,60);
        type(RSPOrderDetailsArrivedPage.txtInvoiceTotal,invoiceTotal,"Invoice total");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearInvoiceTotal
     * description :: clearing the invoice total
     * date :: 09-Apr-2018
     * author :: Jagadish Pola
     */

    public void clearInvoiceTotal() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtInvoiceTotal,60);
        clearData(RSPOrderDetailsArrivedPage.txtInvoiceTotal);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getAAAMemberDiscount
     * description :: returns AAA Memeber discount
     * date :: 
     * author :: Jagadish Pola
     */

    public String getAAAMemberDiscount() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtAAAMemberDiscount,60);
        return getAttributeByValue(RSPOrderDetailsArrivedPage.txtAAAMemberDiscount,"AAA member discount");
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterAAAMemberDiscount
     * description :: enters AAA member discount
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterAAAMemberDiscount(String enterAAMemberDiscount) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtAAAMemberDiscount,60);
        type(RSPOrderDetailsArrivedPage.txtAAAMemberDiscount,enterAAMemberDiscount,"AAA member discount");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearAAAMemberDiscount
     * description :: clearing AAA member discount
     * date :: 09-Apr-2018
     * author :: Jagadish Pola
     */

    public void clearAAAMemberDiscount() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtAAAMemberDiscount,60);
        clearData(RSPOrderDetailsArrivedPage.txtAAAMemberDiscount);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVoucherCode
     * description :: returns voucher code
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVoucherCode() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVoucherCode,60);
        return getText(RSPOrderDetailsArrivedPage.txtVoucherCode,"AAA member discount");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterVoucherCode
     * description :: enter voucher code
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterVoucherCode(String vouncherCode) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVoucherCode,60);
        type(RSPOrderDetailsArrivedPage.txtVoucherCode,vouncherCode,"AAA member discount");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVoucherCodeValidateButton
     * description :: click on validate vocher code
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnVoucherCodeValidateButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnVoucherCodeValidate,60);
        click(RSPOrderDetailsArrivedPage.btnVoucherCodeValidate,"Validate voucher");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVoucherDiscount
     * description :: returns voucher code
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVoucherDiscount() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVoucherDiscount,60);
        return getText(RSPOrderDetailsArrivedPage.txtVoucherDiscount,"AAA member discount");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: enterVoucherDiscount
     * description :: enter voucher discount
     * date :: 
     * author :: Jagadish Pola
     */

    public void enterVoucherDiscount(String voucherCode) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtVoucherDiscount,60);
        type(RSPOrderDetailsArrivedPage.txtVoucherDiscount,voucherCode,"AAA member discount");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMemberDeclineService
     * description :: clicks on member decline service
     * date :: 
     * author :: Jagadish Pola
     */


    //Top frame Layout

    public void clickOnMemberDeclineService() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkMemberDeclineService,60);
        click(RSPOrderDetailsArrivedPage.lnkMemberDeclineService,"Member decline services");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyingMemberDeclineService
     * description :: Verifying member decline service is visible or not
     * date ::
     * author :: Jagadish Pola
     */


    public boolean verifyingMemberDeclineService() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkMemberDeclineService,30);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.lnkMemberDeclineService,"Member decline services");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkDiscardChanges
     * description :: clicks on discard changes link
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnLinkDiscardChanges() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkDiscardChanges,60);
        click(RSPOrderDetailsArrivedPage.lnkDiscardChanges,"Discard changes");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicleInspection
     * description :: clicks on vehicle inspection
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnVehicleInspection() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkVehicleInspection,60);
        click(RSPOrderDetailsArrivedPage.lnkVehicleInspection,"Vehicle inspection");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExtendRepairOrder
     * description :: clicks on Extend repair service
     * date :: 16-APR-2018
     * author :: Jagadish Pola
     */

    public void clickOnExtendRepairOrder() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkExtendRepairService,60);
        click(RSPOrderDetailsArrivedPage.lnkExtendRepairService,"Extend repair service");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyExtendRepairOrderIsAvailableOrNotInDropdown
     * description :: Verifyies extend repair order is available in dropdown or not
     * date :: 16-APR-2018
     * author :: Jagadish Pola
     */

    public boolean verifyExtendRepairOrderIsAvailableOrNotInDropdown() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lnkExtendRepairService,60);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.lnkExtendRepairService,"Extend repair service");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelButtonInModelWindow
     * description :: To click on cancel button in modal window
     * date :: 
     * author :: Jagadish Pola
     */
    //Can be able to use in ever model window
    //----->we can use in comments,arrived,tickets,contacted customer,vehiclke not arrived sections
    public void clickOnCancelButtonInModelWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnCancel,60);
        click(RSPOrderDetailsArrivedPage.btnCancel,"Cancel button in model window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnApplyButtonInModelWindow
     * description :: clicks on apply button in modal window
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnApplyButtonInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnApply,60);
        click(RSPOrderDetailsArrivedPage.btnApply,"Cancel button in model window");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getOtherPhoneNumberModelWindow
     * description :: returns other phone number available from modal window
     * date :: 
     * author :: Jagadish Pola
     */
    public String getOtherPhoneNumberModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblOtherPhoneNumber,60);
        return getText(RSPOrderDetailsArrivedPage.lblOtherPhoneNumber,"Other phone number in model window");
    }



    //exclamation triangle e.t.c...

    /**
     * param :: String
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyExclamationTriangle
     * description :: verifyies exclamation triangle input need to be field name to verify
     * date :: 
     * author :: Jagadish Pola
     */
    /*parameter value should be
      eg:- Year,Make,Model,e.t.c..

     */

    public boolean verifyExclamationTriangle(String verificationField) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.verifingExclamationTriangle(verificationField),60);
        return isVisible(RSPOrderDetailsArrivedPage.verifingExclamationTriangle(verificationField),"Exclamation triangle");
    }

    /**
     * param :: String
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCheckCircle
     * description :: verifyies check circle triangle input need to be field name to verify
     * date ::
     * author :: Jagadish Pola
     */
    /*parameter value should be
      eg:- Year,Make,Model,e.t.c..

     */
    public boolean verifyCheckCircle(String verificationField) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.verifingCheckCirale(verificationField),60);
        return isVisible(RSPOrderDetailsArrivedPage.verifingCheckCirale(verificationField),"Check circle");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyWarningAlert
     * description :: verifies warning alert is visible or not
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean verifyWarningAlert() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.warningBox,60);
        return isVisible(RSPOrderDetailsArrivedPage.warningBox,"Warning alert");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnInvalidButton
     * description :: clicks on invalid button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnInvalidButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnInvalid,60);
        click(RSPOrderDetailsArrivedPage.btnInvalid,"Invalid button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDeclineServiceInModalWindow
     * description :: click on decline service in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDeclineServiceInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnMemberDeclineServiceInModelWindow,60);
        click(RSPOrderDetailsArrivedPage.btnMemberDeclineServiceInModelWindow,"Decline service button in model window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCompleteOrderInModalWindow
     * description :: click on complete order in modal window
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCompleteOrderInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnComplteOrderInModelWindow,60);
        click(RSPOrderDetailsArrivedPage.btnComplteOrderInModelWindow,"Complete order button in model window");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnYesInModalWindow
     * description :: click on yes in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnYesInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnYesInModelWindow,60);
        click(RSPOrderDetailsArrivedPage.btnYesInModelWindow,"Yes button in model window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoInModalWindow
     * description :: click on no in modal window
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnNoInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnNoInModelWindow,60);
        click(RSPOrderDetailsArrivedPage.btnNoInModelWindow,"No button in model window");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyOrderDetailsTabIsActive
     * description :: verifies order details tab is active or not
     * date :: 
     * author :: Jagadish Pola
     */

    public String verifyOrderDetailsTabIsActive() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblOrderDetails,60);
        return getAttributeByClass(RSPOrderDetailsArrivedPage.lblOrderDetails,"Order Details active");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButton
     * description :: clicks on save button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnSaveButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnSave,60);
        click(RSPOrderDetailsArrivedPage.btnSave,"Clicked on save button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifySaveButtonEnable
     * description :: verifies save button is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifySaveButtonEnable() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnSave,60);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.btnSave,"Verifying save button is enable");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnSaveButton
     * description :: verifies and click on save button
     * date :: 
     * author :: Jagadish Pola
     */

    public void ClickOnSaveButton() throws Throwable {
        if(verifySaveButtonEnable()) {
            clickOnSaveButton();
        }
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRepairOrderNumberIsMandatory
     * description :: verifyies repair order number is mandatory or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyRepairOrderNumberIsMandatory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtRepairOrderNumberIsMandatory,60);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.txtRepairOrderNumberIsMandatory,"Repair order number is mandatory");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyFirstNameIsMandatory
     * description :: verifyies first name is mandatory or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyFirstNameIsMandatory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtFirstNameMandatory,60);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.txtFirstNameMandatory,"First name is mandatory");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLastNameIsMandatory
     * description :: verifyies last name is mandatory or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyLastNameIsMandatory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtLastNameMandatory,60);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.txtLastNameMandatory,"Last name is mandatory");
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyPhoneNumberIsMandatory
     * description :: verifyies phone number is mandatory or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyPhoneNumberIsMandatory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtPhoneNumberIsMandatory,60);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.txtPhoneNumberIsMandatory,"Phone number is mandatory");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: clearPhoneNumber
     * description :: clears phone number
     * date ::
     * author :: Jagadish Pola
     */

    public void clearPhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.txtPhoneNumberIsMandatory,60);
        clearData(RSPOrderDetailsArrivedPage.txtPhoneNumberIsMandatory);
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCompleteButtonIsDisableOrEnable
     * description :: verifies complete button is enable or disable
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyCompleteButtonIsDisableOrEnable() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnCompleteDisable,40);
        return isVisibleOnly(RSPOrderDetailsArrivedPage.btnCompleteDisable,"Complete button is enable or disable");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCompleteButton
     * description :: click on complete button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnCompleteButton() throws Throwable {
        if(!verifyCompleteButtonIsDisableOrEnable()) {
            click(RSPOrderDetailsArrivedPage.btnComplete, "Complete button");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDiscardChangesInModalWindow
     * description :: clickck on discard changes in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDiscardChangesInModalWindow() throws Throwable {
       click(RSPOrderDetailsArrivedPage.btnDiscardChangesInModelWindow,"Discard changes");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyDiscardChangesButtonInModalWindow
     * description :: verifies discard changes in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyDiscardChangesButtonInModalWindow() throws Throwable {
        return isVisibleOnly(RSPOrderDetailsArrivedPage.btnDiscardChangesInModelWindow,"Discard changes");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndClickOnDiscardChanges
     * description :: verify and click on discard changes
     * date :: 
     * author :: Jagadish Pola
     */

    public void verifyAndClickOnDiscardChanges() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.btnDiscardChangesInModelWindow,20);
        if(verifyDiscardChangesButtonInModalWindow())
        {
            clickOnDiscardChangesInModalWindow();
        }
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTotalAmountAfterDiscount
     * description :: To get total amount after discount
     * date ::
     * author :: Jagadish Pola
     */

    public String getTotalAmountAfterDiscount() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblTotalAfterDiscount,60);
        return getText(RSPOrderDetailsArrivedPage.lblTotalAfterDiscount,"Total amount after discount");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyConfirmationMessegeIfTotalLimitExceedsTheLimit
     * description :: To get total amount after discount
     * date ::
     * author :: Jagadish Pola
     */

    public boolean verifyConfirmationMessegeIfTotalLimitExceedsTheLimit() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblWarningMessegeIfDiscountAmountExceedsLimit,60);
        return isVisible(RSPOrderDetailsArrivedPage.lblWarningMessegeIfDiscountAmountExceedsLimit,"Warning messege if total amount exceeds limit");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTotalAmountAfterDiscount
     * description :: To get total amount after discount
     * date ::
     * author :: Jagadish Pola
     */

    public boolean verifyWarningMessegeIfDiscountEnteredWithEmptyInvoiceTotal() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsArrivedPage.lblWarningMessegeIfDiscountEnterWithEmptyInvoiceTotal,60);
        return isVisible(RSPOrderDetailsArrivedPage.lblWarningMessegeIfDiscountEnterWithEmptyInvoiceTotal,"Warning messege if discount entered with empty invoice total");
    }

}