package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class facilityandTruckSelectionPage {
    public static By truckP;
    public static By truckW;
    public static By truckX;
    public static By continueButton;
    public static By facilityDetails;
    public static By selectTruck;
    public static By facilityAndTruckSelectionHeader;
    
   

    static {
        truckP = By.xpath("//android.view.View[@text='P']");
        truckW = By.xpath("//android.view.View[@text='W']");
        truckX = By.xpath("//android.view.View[@text='X']");
        continueButton = By.xpath("//android.view.View[@text='Continue']");
        facilityDetails = By.className("android.widget.Spinner");
        facilityAndTruckSelectionHeader=By.xpath("//android.view.View[@text='Facility and Truck Selection']");
    }
    
    public static By selectTruck(String Truck) {
    	String xpath  = "//android.view.View[@text='"+Truck+"']";
    	selectTruck = By.xpath(xpath);
    	return selectTruck;
    			
    }
}





