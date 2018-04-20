package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class ServicesPage {
    public static By btnSave;
    public static By crossOnTechAssistError;
    public static By AddService;
    public static By selectAdditionalServiceHeavyDuty;
    public static By Unit;
    public static By Cost;
    public static By done;
    public static By measureEA;
    public static By lnkAddService;
    public static By serviceTip;





    static {
        btnSave=By.xpath("//android.view.View[@text='Save']");
        crossOnTechAssistError=By.id("com.aaa.d3itu:id/NotificationInfoCloseButton");
        AddService = By.xpath("//android.view.View[@text='Add Service']");
        selectAdditionalServiceHeavyDuty = By.xpath("//android.view.View[contains(@text,'Heavy Duty Extra Time')}");
        Unit = By.xpath("//android.widget.EditText[@text='Unit (DL):']");
        Cost = By.xpath("//android.widget.EditText[@text='Cost:']");
        done = By.xpath("//android.view.View[@text='Done']");
        measureEA = By.xpath("//android.view.View[@text='Done']");
        serviceTip = By.xpath("//android.view.View[contains(@text,'test tip')}");
    }
    
    public static By lnkAddService(String AddService) {
        String xpath = "//android.view.View[contains(@text,'"+AddService+"')]";
        lnkAddService = By.xpath(xpath);
        return lnkAddService;
    }
}
