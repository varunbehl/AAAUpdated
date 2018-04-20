package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class PacesetterResolutionPage {
    public static By towProblemKeys;
    public static By txttow;
    public static By txtTires;
    public static By tiresProblemKeys;
    public static By noServiceProblemKeys;
    public static By txtNoService;
    public static By batteryProblemKeys;
    public static By txtBattery;
    public static By fuelProblemKeys;
    public static By txtFuel;
    public static By extricationProblemKeys;
    public static By txtExtrication;
    public static By keysProblemKeys;
    public static By txtKeys;
    public static By miscellaneousProblemKeys;
    public static By txtMiscellaneous;
    public static By lnkProblemTypesDescription;






    static {
        towProblemKeys=By.xpath("//android.view.View[contains(@text,'Overheated')]");
        txttow=By.xpath("//android.view.View[contains(@text,'Tow')]");
        txtTires=By.xpath("//android.view.View[contains(@text,'Tires')]");
        tiresProblemKeys=By.xpath("//android.view.View[contains(@text,'Air-Up Tire Only')]");
        noServiceProblemKeys=By.xpath("//android.view.View[contains(@text,'NSR - No Car And No Member')]");
        txtNoService=By.xpath("//android.view.View[contains(@text,'No Service')]");
        txtBattery=By.xpath("//android.view.View[contains(@text,'Battery')]");
        batteryProblemKeys=By.xpath("//android.view.View[contains(@text,'Jump Start')]");
        txtFuel=By.xpath("//android.view.View[contains(@text,'Fuel')]");
        fuelProblemKeys=By.xpath("//android.view.View[contains(@text,'Fuel Delivery - Gasoline')]");
        txtExtrication=By.xpath("//android.view.View[contains(@text,'Extrication')]");
        extricationProblemKeys=By.xpath("//android.view.View[contains(@text,'Extrication Only')]");
        txtKeys=By.xpath("//android.view.View[contains(@text,'Keys')]");
        keysProblemKeys=By.xpath("//android.view.View[contains(@text,'Unlock Vehicle')]");
        txtMiscellaneous=By.xpath("//android.view.View[contains@text,'Miscellaneous')]");
        miscellaneousProblemKeys=By.xpath("//android.view.View[contains(@text,'Top-Up Coolant Only')]");


    }
    
    public static By lnkProblemTypesDescription(String problemtypeDescription) {
        String xpath = "//android.view.View[contains(@text,'"+problemtypeDescription+"')]";
        lnkProblemTypesDescription = By.xpath(xpath);
        return lnkProblemTypesDescription;
    }
}
