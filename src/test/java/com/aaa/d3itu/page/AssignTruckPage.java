package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class AssignTruckPage {

    public static By assignTruckP;
    public static By assignTruckW;
    public static By assignTruckX;
    public static By assignTruck;


    static {
        assignTruckP=By.xpath("//android.view.View[contains(@content-desc,'5145/P')]");
        assignTruckW=By.xpath("//android.view.View[contains@content-desc,'5145/W']");
        assignTruckX=By.xpath("//android.view.View[contains@content-desc,'5145/X']");
        
    }
    public static By lnkAssignTruck(String facilityAndTruck) {
        String xpath = "//android.view.View[contains(@text,'"+facilityAndTruck+"')]";
        assignTruck = By.xpath(xpath);
        return assignTruck;
    }
    
}
