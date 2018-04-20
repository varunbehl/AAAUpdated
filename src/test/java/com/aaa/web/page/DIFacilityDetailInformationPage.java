package com.aaa.web.page;
import org.openqa.selenium.By;


public class DIFacilityDetailInformationPage {
    public static By dialogFacilityInformationScreen;
    public static By btnClose;
    public static By txtName;
    public static By txtPrimaryContact;
    public static By txtAddress;
    public static By txtCityStateZip;
    public static By txtStatus;
    public static By txtDispatchRegion;
    public static By txtComments;
    public static By chkBoxAllowOnLocation;
    public static By chkBoxAutoFax;
    public static By chkBoxAutoBid;
    public static By lblID;
    public static By txtDetailsTabTextFileds;
    public static By chkBoxDetailsTabCheckBoxField;
    public static By tabNames;
    public static By txtFieldRep;
    public static By btnsInPTAsTab;
    public static By txtMinutesInEditDefaultPTA;
    public static By btnSaveInEditDefaultPTA;
    public static By btnCloseInEditDefaultPTA;
    public static By btnTruckList;
    public static By btnCloseInTruckListWindow;
    public static By btnViewTruckLoad;
    public static By WindowViewTruckLoad;
    public static By iconCloseTruckLoadWindow;
    public static By TelephonesTableInContactsTab;
    public static By TableGridInGridsTab;
    public static By btnViewGridOnMaps;
    public static By txtPrimaryContactDispatchUser;
    public static By txtPrimaryContactDispatch;
    public static By txtPrimaryContactSPPDispatch;
    public static By lblSPPLogin;

    static {

        dialogFacilityInformationScreen = By.xpath("//span[text()='Facility Detail Information']/../..");
        btnClose  = By.id("details_Close");
        txtName =By.xpath("//input[@id='facility-detail-name']");
        txtPrimaryContact = By.xpath("//input[@id='facility-detail-contact-alt']");
        txtAddress = By.xpath("//input[@id='facility-detail-address']");
        txtCityStateZip =By.xpath("//input[@id='facility-detail-city']");
        txtStatus = By.xpath("//input[@id='facility-detail-status']");
        txtDispatchRegion =By.xpath("//input[@id='facility-detail-dispatch-region']");
        txtComments =By.xpath("//textarea[@id='facility-detail-comments']");
        chkBoxAllowOnLocation = By.xpath("//input[@id='facility-detail-auto-fax']");
        chkBoxAutoFax = By.xpath("//input[@id='facility-detail-auto-fax']");
        chkBoxAutoBid = By.xpath("//input[@id='facility-detail-auto-bid']");
        lblID = By.xpath("//span[@id='facility-detail-id']");
        txtFieldRep = By.xpath("//input[@id='facility-detail-rep']");
        txtMinutesInEditDefaultPTA =By.xpath("//input[@id='default-pta-minutes']");
        btnSaveInEditDefaultPTA = By.id("edit-default-pta-save");
        btnCloseInEditDefaultPTA = By.id("edit-default-pta-close");
        btnTruckList = By.xpath("//button[@id='facility-detail-truck-list']");
        btnCloseInTruckListWindow = By.id("truck-list-close-btn");
        btnViewTruckLoad = By.id("facility-detail-truck-load");
        WindowViewTruckLoad = By.xpath("//div[@id='truckload-panel']");
        iconCloseTruckLoadWindow = By.xpath("//div[@class='truck-panel-btns']//a[@class='d3ui-panel-btn d3ui-panel-close-btn']");
        TableGridInGridsTab = By.xpath("//div[@id='facility-detail-grids-data-container']//table[@id='facility-detail-grid-data']");
        btnViewGridOnMaps = By.id("facility-detail-view-grid-button");
        txtPrimaryContactDispatchUser = By.xpath("//input[@id='facility-detail-contact']");
        txtPrimaryContactDispatch = By.xpath("//input[@id='facility-detail-contact']");
        txtPrimaryContactSPPDispatch = By.xpath("//input[@id='facility-detail-contact-alt']");
        lblSPPLogin = By.id("facility-detail-facility-status");
    }

    public static By txtDetailsTabTextFileds(String FieldName){
        String xpath = "//div[@id='facilitydetails-tab-details']//table[@class='facility-detail-content']//label[text()='"+FieldName+"']/..//following-sibling::td/input";
        txtDetailsTabTextFileds=By.xpath(xpath);
        return txtDetailsTabTextFileds;
    }

    public static By chkBoxDetailsTabCheckBoxField(String FieldName){
        String xpath = "//label[contains(text(),'"+FieldName+"')]//preceding-sibling::input";
        chkBoxDetailsTabCheckBoxField=By.xpath(xpath);
        return chkBoxDetailsTabCheckBoxField;
    }

    public static By tabNames(String TabName){
        String xpath = "//a[contains(text(),'"+TabName+"')]";
        tabNames=By.xpath(xpath);
        return tabNames;
    }

    public static By btnsInPTAsTab(String ButtonName){
        String xpath = "//span[text()='"+ButtonName+"']/..";
        btnsInPTAsTab=By.xpath(xpath);
        return btnsInPTAsTab;
    }

    public static By TelephonesTableInContactsTab(int RowNo, int ColNo){
        String xpath = "//table[@id='facility-detail-phones-table']//tr[@id="+RowNo+"]/td["+ColNo+"]";
        System.out.println(xpath);
        TelephonesTableInContactsTab=By.xpath(xpath);
        return TelephonesTableInContactsTab;
    }

}

