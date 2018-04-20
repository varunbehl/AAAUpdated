package com.aaa.web.lib;


import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRFieldAuditPage;
import com.aaa.web.page.CRRentalCarPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRRentalCarLib extends ActionEngine {

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectFieldAuditPage
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

    public void selectRentalCar() throws Throwable {
    	waitForVisibilityOfElement(CRRentalCarPage.lnkRentalCar,"Rental Car Link");
    	click(CRRentalCarPage.lnkRentalCar,"Rental Car Link");
    	Thread.sleep(2000);
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnNewValueSortingIcon
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public void clickOnPickUpLocationLink() throws Throwable {
		click(CRRentalCarPage.lnkPickUpLocation,"Rental Pickup Location ");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: availablityOfPickupLocation
	 * description ::
	 * date ::
	 * author :: Chandrasekhar Dendukuri
	 */
	public boolean availablityOfPickupLocation() throws Throwable{
		return isVisibleOnly(CRRentalCarPage.lnkPickUpLocation,"Rental Pickup Location ");

	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCloseButtonToCloseRentACarWIndow
	 * description ::
	 * date ::
	 * author :: Chandrasekhar Dendukuri
	 */
	public void clickOnCloseButtonToCloseRentACarWIndow() throws Throwable{
		click(CRRentalCarPage.iconCloseRentACarWindow,"Close Rent a Car window");

	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMilsAndCompareSorting
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public void getMilsAndCompareSorting() throws Throwable {
		List<WebElement> mile = null;

		mile = getWebElementList(CRRentalCarPage.lblPickUpMiles, "Miles");

		for (int i = 0; i < mile.size(); i++)
			{
				String miles = mile.get(i).getText();
				/*if(!newRecordValue.equals("")) {
					if (!oldRecordValue.equals(newRecordValue)) {
						reporter.SuccessReport("Update record status", "<b>Recrods are updated for :: " + fieldLableName+ " from " + oldRecordValue+ " " +
								" ::To:: "+newRecordValue+" ::and Changed By:: "+changedByValue+" ::On:: "+changedDate+ " </b>");
					} else {
						reporter.failureReport("Update record status", "<b>Recrods are not updated for :: " + fieldLableName+ " from " + oldRecordValue+ " " +
								" ::To:: "+newRecordValue+" ::and Changed By:: "+changedByValue+" ::On:: "+changedDate+ "</b>");
					}
				}else{
					reporter.SuccessReport("This is default Record", "<b>Record value :: " + fieldLableName + " And expected result is " + oldRecordValue + " ::and New values"+fieldLableName+ " </b>");
					*/
			}
		}

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCloseButtonToCloseRentACarWIndow
	 * description ::
	 * date ::
	 * author :: Chandrasekhar Dendukuri
	 */
	public void clickOnShowDetailsLink() throws Throwable{
		click(CRRentalCarPage.lnkShowDetails,"ShowDetails lin in Rent a Car window");

	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPhoneNumberLabelFromPickUpLocation
	 * description ::
	 * date ::
	 * author :: Chandrasekhar Dendukuri
	 */
	public String getPhoneNumberLabelFromPickUpLocation() throws Throwable{
		return getText(CRRentalCarPage.lblPhoneNumber,"Phone number in Rent a Car window");

	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPhoneNumberLabelFromPickUpLocation
	 * description ::
	 * date ::
	 * author :: Chandrasekhar Dendukuri
	 */
	public String getHoursOfOperationsDetailsFromPickUpLocation() throws Throwable{
		return getText(CRRentalCarPage.lblHoursOfOperation,"Hours of operation in Rent a Car window");

	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPhoneNumberLabelFromPickUpLocation
	 * description ::
	 * date ::
	 * author :: Chandrasekhar Dendukuri
	 */
	public void clickOnVehicleDetailsHeader() throws Throwable{
		click(CRRentalCarPage.lnkVehicleHeader,"Expand Vehicle Details");

	}
	/**
	 * param ::
	 * return ::void
	 * throws :: throwable
	 * methodName :: getRolesList
	 * description :: This is used to verify on proceed button
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean validateVehicleTypes() throws Throwable {
		String[] str;
		boolean vehicleType;
		vehicleType=false;
		List<WebElement> allRoles = getWebElementList(CRRentalCarPage.lblVehicleType, "List of Vehicle Types");
		//checking for null values from dropdown list

				//Storring all the roles which are available for Admin user into str there are expected
			str = new String[]{"Mini", "Economy", "Compact", "Mid-size","Standard","Full-size","Luxury"};

			List<String> strList = Arrays.asList(str);
			//Getting all the list from application these are actual values
			List<String> webList = new ArrayList<>();
			for (int i = 0; i < allRoles.size(); ++i) {
				webList.add(allRoles.get(i).getText());
			}
			//Comparing both actuals and Expected values
		vehicleType = strList.containsAll(webList);

			if(vehicleType){
				reporter.SuccessReport("Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same","Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same");
			}else {
				reporter.failureReport("Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same","Expected List " + strList + " ::and Actual List:: " + webList + " ::Both are same");
			}

			reporter.SuccessReport("Available types are:: ", "No Of vehicle types Available :: " + allRoles.size());
		return vehicleType;
	}

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getFieldAuditValues
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getMilesValuesFromPickupLocation() throws Throwable {
		return getAttributeByValue(CRRentalCarPage.lblPickUpMile,"miles");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPickupDateTime
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getPickupDateTime() throws Throwable {
		return getText(CRRentalCarPage.lblPickUp,"Pick up Date Time");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnPickupArrow
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public void clickOnPickupArrow() throws Throwable {
		click(CRRentalCarPage.lblPickUp,"Pick up ");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterPickupDate
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String enterPickupDate(String datePickup) throws Throwable {
		type(CRRentalCarPage.txtPickUpDate,datePickup,"Pick up date");
		return datePickup;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterPickupTime
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String enterPickupTime(String time) throws Throwable {
		type(CRRentalCarPage.txtPickUpTime,time,"Pick up time");
		return time;
	}
    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropOfOption
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnDropOfOption() throws Throwable {
        click(CRRentalCarPage.lnkDropOff,"Drop off");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getDropOfDateTime
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getDropOfDateTime() throws Throwable {
        return getText(CRRentalCarPage.lnkDropOff,"Drop off Date time");
    }
    /**
     * return ::
     * throws :: throwable
     * methodName :: verifyAutoSelectedDropOfCheckBox
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public boolean verifyAutoSelectedDropOfCheckBox() throws Throwable {
        return isVisibleOnly(CRRentalCarPage.chkBxDropOffAutoSelect,"Auto Selected check box");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAutoSelectedDropOfCheckBoxToDeselect
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnAutoSelectedDropOfCheckBoxToDeselect() throws Throwable {
        click(CRRentalCarPage.chkBxDropOffAutoSelect,"Auto Selected check box un checked");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterDateInDropOfDateField
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void enterDateInDropOfDateField(String date) throws Throwable {
        type(CRRentalCarPage.txtDropOfDate,date,"Drop Of Date");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterDateInDropOfDateField
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void enterTimeInDropOfTimeField(String time) throws Throwable {
        type(CRRentalCarPage.txtDropOfTime,time,"Drop Of time");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterDateInDropOfDateField
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public boolean availablityOfDateInDropOfDateField() throws Throwable {
        return isVisibleOnly(CRRentalCarPage.txtDropOfDate,"Drop Of Date");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDOPoint
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnDOPoint() throws Throwable {
        click(CRRentalCarPage.lnkDOPoint,"DO Point");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyDefaultSelectionOfSameAsPickupLocation
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */

    public boolean verifyDefaultSelectionOfSameAsPickupLocation() throws Throwable {
        return isVisibleOnly(CRRentalCarPage.chkBxSameAsPickUpAutoSelection,"Same as pickup location auto selected check box ");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnGoldMemberIcon
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnGoldMemberIcon() throws Throwable{
        click(CRRentalCarPage.lnlGoldMember,"Gold Member");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterGoldMember
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterGoldMember(String member) throws Throwable{
        type(CRRentalCarPage.txtGoldMember,member,"Gold Member entered successfully");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getReservicationDetails
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getReservicationDetails() throws Throwable{
        return getText(CRRentalCarPage.lblReservationSummaryInformation,"Reservation Summary details");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: availablityOfThriftyTab
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public boolean availablityOfThriftyTab() throws Throwable{
        return isVisibleOnly(CRRentalCarPage.btnDisabledThriftyTab,"Thrifty Tab");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: availablityOfDollarTab
     * description ::
     * date :: 29-Mar-2018
     * author :: Chandrasekhar Dendukuri
     */
    public boolean availablityOfDollarTab() throws Throwable{
        return isVisibleOnly(CRRentalCarPage.btnDisabledDollarTab,"Dollar Tab");
    }
}
