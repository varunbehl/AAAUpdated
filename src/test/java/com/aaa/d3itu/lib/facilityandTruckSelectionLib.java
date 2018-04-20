package com.aaa.d3itu.lib;
import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LaunchPage;
import com.aaa.d3itu.page.LoginPage;
import com.aaa.d3itu.page.facilityandTruckSelectionPage;

public class facilityandTruckSelectionLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
		
	}
	
	public String getFacility() throws Throwable {
		//Thread.sleep(25000);
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
		waitForVisibilityOfElement(facilityandTruckSelectionPage.facilityDetails, "Facility Details");
		String retFacility = "";
		retFacility = getText(facilityandTruckSelectionPage.facilityDetails, "Facility Details");
		//Thread.sleep(25000);
		return retFacility;

	}
	
	public void clickContinueButton() throws Throwable {
		waitForVisibilityOfElement(facilityandTruckSelectionPage.continueButton, "click on Continue Button");
		click(facilityandTruckSelectionPage.continueButton, "click on Continue Button");
		//type(LaunchPage.environment, environment, "Environment");		
	}
	
	public void selectTruckID(String Truck) throws Throwable {
		Thread.sleep(2000);
		click(facilityandTruckSelectionPage.facilityDetails,"Facility Details");
		//String text = getText(facilityandTruckSelectionPage.truckP,"Facility Details");
		//click(facilityandTruckSelectionPage.truckP,"Facility Details");
		Thread.sleep(2000);
		click(facilityandTruckSelectionPage.selectTruck(Truck), "Select Truck : "+ Truck);
		//click(facilityandTruckSelectionPage.selectTruck(Truck), "Select Truck : "+ Truck);
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
		Thread.sleep(2000);
	}
	
	
	public void selectFacilityandContinue(String Truck) throws Throwable {
		if (!(getFacility().equalsIgnoreCase(Truck))){
			selectTruckID(Truck);			
		}		
		clickContinueButton();
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
       // Thread.sleep(20000);
	}
}
