package com.aaa.web.lib;


import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRAPDPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CRAPDLib extends ActionEngine {

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyAPDWindowAvailablity
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

    public boolean verifyAPDWindowAvailablity() throws Throwable {
    	boolean availablityOFAPDWindow=isVisibleOnly(CRAPDPage.lblAPDWindow,"APD Window Opened and Garage Payment Information for Call modal appeared");
    	return availablityOFAPDWindow;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyAPDWindowAvailablity
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getAPDWindowTitle() throws Throwable {
		String title=getText(CRAPDPage.lblAPDWindow,"Garage Payment Information for Call modal appeared");
		return title;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCloseAPDWindow
	 * description ::
	 * date :: 12-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */
	public void clickOnCloseAPDWindow() throws Throwable{
		click(CRAPDPage.iconCloseAPDWindow,"APD Window Close icon");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getCalculatedDistanceLable
	 * description ::
	 * date :: 12-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */
	public String getCalculatedDistanceLable()throws Throwable{
		String calculatedDistance=getText(CRAPDPage.lblCalculatedDistance,"Calculated Distance");
		return calculatedDistance;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyToLocationLable
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyToLocationLable() throws Throwable {
		boolean availablityOFToLocation=isVisibleOnly(CRAPDPage.lblToLocation,"To Location Label");
		return availablityOFToLocation;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getToLocationValue
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getToLocationValue() throws Throwable {
		String toLocationValue=getAttributeByValue(CRAPDPage.txtToLocation,"To Location Value ");
		return toLocationValue;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getLblToLocation
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getLblToLocation() throws Throwable {
		String title=getText(CRAPDPage.lblToLocation,"To Location Label");
		return title;
	}

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyTowedLabel() throws Throwable {
		boolean availablityOFTowed=isVisibleOnly(CRAPDPage.lblTowed,"Label Towed");
		return availablityOFTowed;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getToTowedValue
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getToTowedValue() throws Throwable {
		String toTowedVal=getAttributeByValue(CRAPDPage.txtTowed,"To Towed Value");
		return toTowedVal;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTotalLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String gettoTotalLabel() throws Throwable {
		String totalLabel=getText(CRAPDPage.lblTotalMilage,"To Total Label");
		return totalLabel;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyTotalLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyTotalLabel() throws Throwable {
		boolean availablityOFTotal=isVisibleOnly(CRAPDPage.lblTotalMilage,"Total Milage");
		return availablityOFTotal;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTotalValue
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getTotalValue() throws Throwable {
		String toTowedValue=getAttributeByValue(CRAPDPage.txtTotalMilage,"Total Milage");
		return toTowedValue;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String gettoTowedLabel() throws Throwable {
		String towedLabel=getText(CRAPDPage.lblTowed,"To Towed Label");
		return towedLabel;
	}

	//-----
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyDistanceOverRide
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyDistanceOverRide() throws Throwable {
		boolean availablityOfDistanceOverRide=isVisibleOnly(CRAPDPage.lblDistanceOverride,"Distance Override");
		return availablityOfDistanceOverRide;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyToScene
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyToScene() throws Throwable {
		boolean availablityOfToScene=isVisibleOnly(CRAPDPage.lblMilesOnLocation,"To Scene");
		return availablityOfToScene;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyToScene
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyToSceneTextField() throws Throwable {
		boolean availablityOfToSceneTextBox=isVisibleOnly(CRAPDPage.txtMilesOnLocation,"To Scene Text box");
		return availablityOfToSceneTextBox;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPayableTowMiles
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyPayableTowMiles() throws Throwable {
		boolean payableTowMiles=isVisibleOnly(CRAPDPage.lblMilesOnDestionation,"Payable Tow Miles");
		return payableTowMiles;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPayableTowMiles
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyPayableTowMilesTetBox() throws Throwable {
		boolean payableTowMilesTextBox=isVisibleOnly(CRAPDPage.txtMilesOnDestionation,"Payable Tow miles Text fields ");
		return payableTowMilesTextBox;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyMillageComments() throws Throwable {
		boolean towedLabel=isVisibleOnly(CRAPDPage.txtMillageComment,"Millage comments");
		return towedLabel;
	}

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyDistanceLabel() throws Throwable {
		boolean distanceLabel=isVisibleOnly(CRAPDPage.lblDistanceFinal,"Distance Label");
		return distanceLabel;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyDistanceToLabel() throws Throwable {
		boolean distanceTO=isVisibleOnly(CRAPDPage.lblFinalToLocation,"Distance To");
		return distanceTO;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getDistanceToValue() throws Throwable {
		String distanceTO=getAttributeByValue(CRAPDPage.txtFinalToLocation,"Distance to text box is available and value is ");
		return distanceTO;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyFinalDistanceToLabel() throws Throwable {
		boolean towDestionation=isVisibleOnly(CRAPDPage.lblFinalTowed,"Towed");
		return towDestionation;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: gettoTowedLabel
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getTowDestionataionValue() throws Throwable {
		String towed=getAttributeByValue(CRAPDPage.txtFinalTowed,"Tow destination text box is available and value is ");
		return towed;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyFinalTotal
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public boolean verifyFinalTotal() throws Throwable {
		boolean finalTotal=isVisibleOnly(CRAPDPage.lblFinalTotalDistance,"Final Total distance lable");
		return finalTotal;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getFinalTotalDistanceValue
	 * description ::
	 * date :: 11-Apr-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getFinalTotalDistanceValue() throws Throwable {
		String totalValue=getAttributeByValue(CRAPDPage.txtFinalTotalDistance,"Total distance text box is available and value is ");
		return totalValue;
	}
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterToSceneInDistanceOverRideSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterToSceneInDistanceOverRideSection(String toScene) throws Throwable {
        type(CRAPDPage.txtMilesOnLocation,toScene,"Enter value in To Scene text field in Distance Over Ride section");
        return toScene;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getToSceeneValueInDistanceOverRideSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getToSceeneValueInDistanceOverRideSection() throws Throwable {
        return getAttributeByValue(CRAPDPage.txtMilesOnLocation,"Getting TosceneValue from Distance OverRideSection");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterPayableMilesInDistanceOverRideSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterPayableMilesInDistanceOverRideSection(String miles) throws Throwable {
        type(CRAPDPage.txtMilesOnDestionation,miles,"Enter value in miles text field in Distance Over Ride section");
        return miles;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getPayableMilesInDistanceOverRideSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getPayableMilesInDistanceOverRideSection() throws Throwable {
        return getAttributeByValue(CRAPDPage.txtMilesOnDestionation,"Getting Payable Miles from Distance OverRideSection");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterMillageCommentsInDistanceOverRideSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterMillageCommentsInDistanceOverRideSection(String comments) throws Throwable {
        type(CRAPDPage.txtMillageComment,comments,"Enter value in comments text field in Distance Over Ride section");
        return comments;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getMillageCommentsInDistanceOverRideSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getMillageCommentsInDistanceOverRideSection() throws Throwable {
        return getAttributeByValue(CRAPDPage.txtMillageComment,"Getting Comments from Distance OverRideSection");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterDistanceTOInDistanceSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterDistanceTOInDistanceSection(String distanceTo) throws Throwable {
        type(CRAPDPage.txtFinalToLocation,distanceTo,"Enter value in Distance To text field in Distance section");
        return distanceTo;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getDistanceTOInDistanceSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getDistanceTOInDistanceSection() throws Throwable {
        return getAttributeByValue(CRAPDPage.txtFinalToLocation,"Getting Distance To from Distance Section");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterTowInDistanceSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterTowInDistanceSection(String tow) throws Throwable {
        type(CRAPDPage.txtFinalTowed,tow,"Enter value in tow To text field in Distance section");
        return tow;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getTowInDistanceSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getTowInDistanceSection() throws Throwable {
        return getAttributeByValue(CRAPDPage.txtFinalTowed,"Getting tow value from Distance Section");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterTotalInDistanceSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterTotalInDistanceSection(String total) throws Throwable {
        type(CRAPDPage.txtFinalTotalDistance,total,"Enter value in Total text field in Distance section");
        return total;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getTotalInDistanceSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String getTotalInDistanceSection() throws Throwable {
        return getAttributeByValue(CRAPDPage.txtFinalTotalDistance,"Getting Total value from Distance Section");
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getListOfSerevicesDropdown
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void getListOfSerevicesDropdown() throws Throwable {
        if (isVisibleOnly(CRAPDPage.iconTriangleToOpenServicesList, "Service is visible")) {
            click(CRAPDPage.iconTriangleToOpenServicesList, "Open service Drop down");
            click(CRAPDPage.txtService, "Open service Drop down");

            Thread.sleep(2000);
            List<WebElement> servicesList = driver.findElements(CRAPDPage.drpServicesList);
            int totalCount = servicesList.size();
            //int counter = 1;
            if (totalCount > 1) {
                //this.reporter.SuccessReport("List of Service Items  ", "  Total Service Codes are :  " + totalCount);
                for (int i = 1; i < servicesList.size(); i++) {
                    String ServiceCode=servicesList.get(i).getText();
                   // this.reporter.SuccessReport("Services Code", "Service Code is " + servicesList.get(i).getText());
                    if(!ServiceCode.isEmpty()) {
                        this.reporter.SuccessReport("Services Code",  "Service Code is " + ServiceCode);
                        //counter++;
                    }
                    //Thread.sleep(1000);
                   /* if(servicesList.get(i).getText().isEmpty()){
                        reporter.failureReport("Service Code is not available","Service Code is not available",driver);
                    }*/
                }
            } else {
                this.reporter.SuccessReport("No list  found", +totalCount + "is Empty");
            }
        }
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceInServicesandChargersSection
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public String enterServiceInServicesandChargersSection() throws Throwable {
        //type(CRAPDPage.txtService,service,"Enter service in Service text field in Servie and Chargers section");
        click(CRAPDPage.txtService,"Select Service type");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        return getAttributeByValue(CRAPDPage.txtService,"Select Service type");

    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: getUnitOfMeasurement
     * description ::
     * date :: 13-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnUnitOfMeasurement() throws Throwable {
         click(CRAPDPage.lblUnitOfMeasurement,"Enter service in Service text field in Servie and Chargers section");
    }
    public String getUnitOfMeasurement() throws Throwable {
       return getAttributeByValue(CRAPDPage.lblUnitOfMeasurement,"Enter service in Service text field in Servie and Chargers section");
    }

    public String enterValueInUnitTextField(String unit) throws Throwable{
        type(CRAPDPage.txtUnit,unit,"Unit value");
        return unit;
    }
    public boolean availabilityOfDisabledCostTextField() throws Throwable{
        return isVisibleOnly(CRAPDPage.disabledCostField,"Cost Text box is disabled");
    }
    public void clickOnSaveButton() throws Throwable{
        click(CRAPDPage.btnSave,"Save button");
    }
    public boolean verifySavedToolTip() throws Throwable{
        return isVisibleOnly(CRAPDPage.lblSavedToolTip,"Availablity Of Saved message");
    }
    public String getSavedToolTipMessage() throws Throwable{
        return getText(CRAPDPage.lblSavedToolTip,"Saved Tool tip message");
    }
    public boolean availablityOfMemberLevelIcon() throws Throwable{
        return isVisibleOnly(CRAPDPage.iconMemberLeveel,"Member Level Icon");
    }
    public void clickOnSaveCloseButton() throws Throwable{
        click(CRAPDPage.btnSaveClose,"Save Close button");
    }
    public void clickOnCloseButton() throws Throwable{
        click(CRAPDPage.btnClose,"Close Button");
    }
    public boolean availablityOfUnitsLable()throws Throwable{
        return isVisibleOnly(CRAPDPage.lblUnits,"Units");
    }
    public boolean availablityOfServicesLable()throws Throwable{
        return isVisibleOnly(CRAPDPage.lblServices,"Services");
    }
    public boolean availablityOfUnitOfMesurenemtnLable()throws Throwable{
        return isVisibleOnly(CRAPDPage.lblMeasure,"Unit Of Mesurment");
    }
    public boolean availablityOfCostLable()throws Throwable{
        return isVisibleOnly(CRAPDPage.lblCost,"Cost");
    }
    public boolean availablityOfCashCollectedLable()throws Throwable{
        return isVisibleOnly(CRAPDPage.lblCashCollected,"Cash Collected");
    }
    public boolean availablityOfDispatchApproval()throws Throwable{
        return isVisibleOnly(CRAPDPage.icondispatchApproved,"Dispatch Approval");
    }
}
