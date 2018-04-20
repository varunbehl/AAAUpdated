package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPOrderDetailsArrivedPage {
    public static By btnOpenComboBoxForYear=By.xpath("//*[text()='Year']/..//*[@title='open combobox']");
    public static By btnOpenComboBoxForMake=By.xpath("//*[text()='Make']/..//*[@title='open combobox']");
    public static By btnOpenComboBoxForModel=By.xpath("//*[text()='Model']/..//*[@title='open combobox']");
    public static By btnOpenComboBoxForTrim=By.xpath("//*[text()='Trim']/..//*[@title='open combobox']");
    public static By btnInfo=By.xpath("//*[@title='Info']");;
    public static By btnCustomer=By.xpath("//*[@title='Customer']");;
    public static By btnVehicle=By.xpath("//*[@title='Vehicle']");;
    public static By btnRepairService=By.xpath("//*[@title='Repair Service']");
    public static By btnRepairCost=By.xpath("//*[@title='Repair Cost']");
    public static By btnHistory=By.xpath("//*[@title='History']");
    public static By lblOrderDetails=By.xpath("//*[@title='Order Details']/../..");
    public static By btnComplete=By.xpath("//*[text()='Complete']/..");
    public static By btnSave=By.xpath("//*[text()='Save']/..");
    public static By btnCompleteDisable=By.xpath("//*[text()='Complete']/../..//button[@disabled]");

    //info frame layout
    public static By lblAAAClub=By.xpath("//*[text()='AAA Club:']/../div[1]");
    public static By lblAAAClubValue=By.xpath("//*[text()='AAA Club:']/../div[2]");
    public static By lblAssignedShop=By.xpath("//*[text()='AAA Club:']/../div[3]");
    public static By lblAssignedShopValue=By.xpath("//*[text()='AAA Club:']/../div[4]");
    public static By lblStatus=By.xpath("//*[text()='Status:']/../div[2]/span");
    public static By lblTimeCreated=By.xpath("//*[text()='Status:']/../div[4]");
    public static By lblType=By.xpath("//*[text()='Type:']/../div[2]");
    public static By lblLastUpdated=By.xpath("//*[text()='Type:']/../div[4]");
    public static By lblSVO=By.xpath("//*[text()='SVO #:']/../div[2]");

    //Customer Layout

    public static By drpdnYear;
    public static By drpdwnLincenseState;
    public static By txtMemberNumber = By.xpath("//*[text()='Member Number']/..//input[1]");
    public static By btnSearchAndValid=By.xpath("//*[text()='Member Number']/../..//span[1]/span");
    public static By txtPhoneNumber=By.xpath("//*[text()='Phone Number']/..//input");
    public static By lnkOtherNumbers=By.xpath("//*[text()='Phone Number']/..//button/span");
    public static By txtEmail=By.xpath("//*[text()='Email']/..//input");
    public static By txtFirstName=By.xpath("//*[text()='First Name']/..//input");
    public static By txtLastName=By.xpath("//*[text()='Last Name']/..//input");

    //Vehicle Layout
    public static By drpdwnVehicleMake;
    public static By drpdwnVehicleModel;
    public static By drpdwnTrim;
    public static By txtVIN=By.xpath("//*[text()='VIN']/..//input");
    public static By btnVINSearchAndValid=By.xpath("//*[text()='VIN']/..//button/..");
    public static By txtYear=By.xpath("//*[text()='Year']/..//input");
    public static By txtVehicleMake=By.xpath("//*[text()='Make']/..//input");
    public static By txtVehicleModel=By.xpath("//*[text()='Model']/..//input");
    public static By txtTrim=By.xpath("//*[text()='Trim']/..//input");
    public static By sltLicenceState=By.xpath("//*[text()='License State']/..//select");
    public static By txtColor=By.xpath("//*[text()='Color']/..//input");
    public static By txtOdometer=By.xpath("//*[text()='Odometer']/..//input");
    public static By txtLicenseNumber=By.xpath("//*[text()='License Number']/..//input");
    public static By btnEditInspection=By.xpath("//*[@title='Click to edit inspection form']");
    public static By btnMessege=By.xpath("//*[@title='Click to edit inspection form']/../button[2]");
    public static By btnPrint=By.xpath("//*[@title='Click to edit inspection form']/../button[3]");

    //Service Provider Layout
    public static By drpdwnServiceCategory;
    public static By drpdwnServiceSubCategory;
    public static By clkServiceDropdown=By.xpath("//*[text()='Service Category']/..//select");
    public static By clkServiceSubCategoryDropdown=By.xpath("//*[text()='Service Sub-Category']/..//select");
    public static By lblAAAProblenCode=By.xpath("//*[text()='AAA Problem Code:']/../div[2]/div");
    public static By lblResolutionCode=By.xpath("//*[text()='Resolution Code:']/../div[2]/div");
    public static By txtRepairOrderNumber=By.xpath("//*[text()='Repair Order Number']/..//input");
    public static By btnBatteryService=By.xpath("//*[text()='Battery Service:']/../div[2]/div");
    public static By txtRepairNotes=By.xpath("//*[text()='Repair Notes:']/..//textarea");

    //Repair Cost Layout
    public static By txtInvoiceTotal=By.xpath("//*[text()='Invoice Total (Before Discounts)']/..//input");
    public static By txtAAAMemberDiscount=By.xpath("//*[text()='AAA Member Discount']/..//input");
    public static By txtVoucherCode=By.xpath("//*[text()='Voucher Code:']/..//input");
    public static By btnVoucherCodeValidate=By.xpath("//*[text()='Voucher Code:']/..//button");
    public static By txtVoucherDiscount=By.xpath("//*[text()='Voucher Discount:']/..//input");
    public static By lblTotalAfterDiscount=By.xpath("//*[text()='Total (After Discounts):']/..//div[2]");
    public static By lblWarningMessegeIfDiscountAmountExceedsLimit=By.xpath("//*[text()='Discount exceeds the max allowed 20%, limit $100.']/..//div[1]");
    public static By lblWarningMessegeIfDiscountEnterWithEmptyInvoiceTotal=By.xpath("//*[text()='You have entered a discount, but no service subtotal.']/..//div[1]");

    //Top frame Layout
    public static By lnkDiscardChanges=By.xpath("//*[text()='Discard Changes']/..");
    public static By lnkMemberDeclineService=By.xpath("//*[@title='Member Decline Service']/..");
    public static By lnkVehicleInspection=By.xpath("//*[@title='Vehicle Inspection']/..");
    public static By lnkExtendRepairService=By.xpath("//*[@title='Extend Repair Order']/..");

    //Membership verified
    public static By lblMemberNumbr=By.xpath("//*[text()=' Membership Verified']/../../div/div[1]/div[1]/span[2]");
    public static By lblMemberName=By.xpath("//*[text()=' Membership Verified']/../../div/div[1]/div[2]/span[2]");
    public static By lblMemberPhoneNumber=By.xpath("//*[text()=' Membership Verified']/../../div/div[1]/div[3]/span[2]");
    public static By btnCancel=By.xpath("//*[text()='Cancel']");
    public static By btnApply=By.xpath("//*[text()='Apply']");

    //Other PhoneNumber
    public static By lblOtherPhoneNumber=By.xpath("//*[text()='Other Phone Numbers']/..//ul/li[1]/span");
    public static By btnOk=By.xpath("//*[text()='OK']");

    //exclamation triangle e.t.c...
    public static By imgExclamationTriangle;
    public static By imgCheckCircle;
    public static By warningBox=By.xpath("//*[@class='notification notification-warning notification-visible']");
    public static By btnInvalid=By.xpath("//*[text()='Invalid']/..");

    //menuDropdown
    public static By btnMemberDeclineServiceInModelWindow=By.xpath("//*[text()='Decline Service']");
    public static By btnComplteOrderInModelWindow=By.xpath("//*[text()='Complete Order']");
    public static By btnYesInModelWindow=By.xpath("//*[text()='Yes']");
    public static By btnNoInModelWindow=By.xpath("//*[text()='No']");

    //Mandatory fields
    public static By txtRepairOrderNumberIsMandatory=By.xpath("//*[text()='Repair Order Number']/..//*[@required]");
    public static By txtPhoneNumberIsMandatory=By.xpath("//*[text()='Phone Number']/..//input[@required]");
    public static By txtFirstNameMandatory=By.xpath("//*[text()='First Name']/..//input[@required]");
    public static By txtLastNameMandatory=By.xpath("//*[text()='Last Name']/..//input[@required]");
    public static By btnDiscardChangesInModelWindow=By.xpath("//button[text()='Discard Changes']");

    public static By selectYearFromDropdown(String year)
    {
        String xpath="//*[text()='Year']/..//*[text()='"+year+"']";
        drpdnYear=By.xpath(xpath);
        return drpdnYear;
    }

    /*parameter name should be the option value
    eg:- format "AL - Alabama"
     */
    public static By selectLicenseState(String stateName)
    {
        String xpath="//*[text()='License State']/..//*[text()='"+stateName+"']";
        drpdwnLincenseState=By.xpath(xpath);
        return drpdwnLincenseState;
    }

    /*parameter name should be the option value
      eg:- Automatic Transmission

     */
    public static By selectServiceCategory(String serviceCategory)
    {
        String xpath="//*[text()='Service Category']/..//*[text()='"+serviceCategory+"']";
        drpdwnServiceCategory=By.xpath(xpath);
        return drpdwnServiceCategory;
    }


    /*parameter name should be the option value
      ************It is disbale state if value found please provide the example here in above format****************************

     */
    public static By selectServiceSubCategory(String serviceSubCategory)
    {
        String xpath="//*[text()='Service Sub-Category']/..//*[text()='"+serviceSubCategory+"']";
        drpdwnServiceSubCategory=By.xpath(xpath);
        return drpdwnServiceSubCategory;
    }

    /*parameter name should be the option value
      eg:- Ford

     */

    public static By selectVehicleMake(String vehicleMake)
    {
        String xpath="//*[text()='Make']/..//*[text()='"+vehicleMake+"']";
        drpdwnVehicleMake=By.xpath(xpath);
        return drpdwnVehicleMake;
    }

    /*parameter name should be the option value
      eg:- TAURUS X

     */
    public static By selectVehicleModel(String vehicleModel)
    {
        String xpath="//*[text()='Model']/..//*[text()='"+vehicleModel+"']";
        drpdwnVehicleModel=By.xpath(xpath);
        return drpdwnVehicleModel;
    }

    /*parameter name should be the option value
     ************It is disbale state if value found please provide the example here in above format****************************

     */
    public static By selectVehicleTrim(String trim)
    {
        String xpath="//*[text()='trim']/..//*[text()='"+trim+"']";
        drpdwnTrim=By.xpath(xpath);
        return drpdwnTrim;
    }


    /*parameter value should be
      eg:- Year,Make,Model,e.t.c..

     */
    public static By verifingExclamationTriangle(String verificationField)
    {
        String xpath="//*[text()='"+verificationField+"']/..//*[@class='fa fa-exclamation-triangle']";
        imgExclamationTriangle=By.xpath(xpath);
        return imgExclamationTriangle;
    }
    /*parameter value should be
      eg:- Year,Make,Model,e.t.c..

     */
    public static By verifingCheckCirale(String verificationField)
    {
        String xpath="//*[text()='"+verificationField+"']/..//*[@class='fa fa-check-circle']";
        imgCheckCircle=By.xpath(xpath);
        return imgCheckCircle;
    }
}