package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRTowDestinationPage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;




public class CRTowDestinationLib extends ActionEngine {
    List<WebElement> allRepairShops = null;


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowPassengers
     * description :: verifyTowPassengers
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public boolean verifyTowPassengers() throws Throwable {
        boolean flagtowPassengers = isVisibleOnly(CRTowDestinationPage.txtNumberOfTowPassengers, "TowPassengers");
        assertTrue(flagtowPassengers, "TowPassengers is Mandatory Field");


        return flagtowPassengers;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on TowDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clearAndSaveTowDestinationDetails(String numberOfTowPassengers) throws Throwable{
        clearTowMadatoryFields();
        saveTowDetails(numberOfTowPassengers);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on TowDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearTowMadatoryFields()throws Throwable {
        clearData(CRTowDestinationPage.txtNumberOfTowPassengers);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: saveTowDetails
     * description :: To save TowDetails
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void saveTowDetails(String numberOfTowPassengers) throws Throwable {
        enterTowDestinationMandatoryFields(numberOfTowPassengers);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTowDestinationMandatoryFields
     * description :: To Enter all mandatory Fields on Tow
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterTowDestinationMandatoryFields(String numberOfTowPassengers) throws Throwable {
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterTowPassengers(numberOfTowPassengers);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTowPassengers
     * description :: To enter Tow Passengers on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterTowPassengers(String numberOfTowPassengers) throws  Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRTowDestinationPage.txtNumberOfTowPassengers,"TowPassengers");
        click(CRTowDestinationPage.txtNumberOfTowPassengers, "TowPassengers");
        clearData(CRTowDestinationPage.txtNumberOfTowPassengers);
        type(CRTowDestinationPage.txtNumberOfTowPassengers, numberOfTowPassengers, "TowPassengers");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowDestinationTab
     * description :: To clickOnTowDestinationTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnTowDestinationTab() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.towDestinationTab,"Towdestination Tab");
        click(CRTowDestinationPage.towDestinationTab, "Towdestination Tab");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle error and alert
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling on Tow Tab
        boolean flagErrorAlert = isVisibleOnly(CRTowDestinationPage.errorAlertOK, "Error Alert OK button");
        if(flagErrorAlert) {
            click(CRTowDestinationPage.errorAlertOK, "Error Alert OK Button");
        }
        boolean flagScriptError=isVisibleOnly(CRTowDestinationPage.scriptError, "Script Error OKAY button");
        if(flagScriptError){
            click(CRTowDestinationPage.scriptError, "Script Error OKAY Button");
        }
        boolean flagConforOkButton=isVisibleOnly(CRTowDestinationPage.btnAlertSaveYes, "Confirmation okay button");
        if(flagConforOkButton) {
            click(CRTowDestinationPage.btnAlertSaveYes, "Confirmation Okay button");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: towLocation
     * description :: To Click on TowDestination Tab and Handle Alert and Enter TowPassengers
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void towLocation(String towPassengers) throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.towDestinationTab,"Tow tab");
        click(CRTowDestinationPage.towDestinationTab,"Tow tab");
        waitForVisibilityOfElement(CRTowDestinationPage.btnDialogOkBtn,"Tow ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn,"Tow ok button");
        waitForVisibilityOfElement(CRTowDestinationPage.linkTowLocation,"Tow location link");
        click(CRTowDestinationPage.linkTowLocation,"Tow location link");
        waitForVisibilityOfElement(CRTowDestinationPage.txtTowPassenger,"Tow passengers");
        type(CRTowDestinationPage.txtTowPassenger,towPassengers,"pacesetter code manual entry");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLinkOnTowDestination
     * description :: click on ManualEntryLink
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnManualEntryLinkOnTowDestination() throws  Throwable{
        Thread.sleep(2000);
        click(CRTowDestinationPage.linkManualEntryLinkOnTowDestination,"ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTowLocationName
     * description :: enterTowLocationName
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterTowLocationName(String towLocation) throws Throwable {
        type(CRTowDestinationPage.txtTowLocationName,towLocation,"Location address");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFirstCrossStreet
     * description :: enterFirstCrossStreet
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterFirstCrossStreet(String firstCrossStreet) throws Throwable {
        type(CRTowDestinationPage.txtTowCrossStreetInput,firstCrossStreet,"First Cross Street address");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondCrossStreet
     * description :: enterSecondCrossStreet
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterSecondCrossStreet(String secondCrossStreet) throws Throwable {
        type(CRTowDestinationPage.txtTowSecondCrossStreetInput,secondCrossStreet,"Second Cross Street address");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityCodeInTow
     * description :: enterCityCodeInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterCityCodeInTow(String city) throws Throwable {
    	Thread.sleep(2000);
        type(CRTowDestinationPage.txtTowCity,city,"City in Tow Destination");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStateInTow
     * description :: enterStateInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterStateInTow(String state) throws Throwable {
    	Thread.sleep(2000);
        type(CRTowDestinationPage.txtTowState,state,"State in Tow Destination");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInTow
     * description :: enterLandMarkInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterLandMarkInTow(String landMark) throws Throwable {
        type(CRTowDestinationPage.txtTowLandMark,landMark,"LandMark in Tow Destination");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLogitudeValueInTow
     * description :: getLogitudeValueInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public String getLogitudeValueInTow() throws Throwable {
        String logitude = getAttributeByValue(CRTowDestinationPage.txtLogitude, "Logitude");
        return logitude;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExistingTowDetinationLink
     * description :: clickOnExistingTowDetinationLink
     * date :: 11-Jan-2018
     * author :: Abhiram
     */

    public void clickOnExistingTowDetinationLink() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.linkTowLocation,"Tow location link");
        click(CRTowDestinationPage.linkTowLocation,"Tow location link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAARTowDetinationLink
     * description :: clickOnAARTowDetinationLink
     * date :: 11-Jan-2018
     * author :: Abhiram
     */

    public void clickOnAARTowDetinationLink() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.linkAARInTowDestination,"AAR link");
        click(CRTowDestinationPage.linkAARInTowDestination,"AAR link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForBasicLevellessThan5Miles
     * description :: To verify Tow Miles For Basic Level lessThan 5 Miles
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public double verifyTowMilesForBasicLevellessThan5Miles(String allowedMilsForBasedOnLevel) throws Throwable {
        double noOfMileFromResult=0.0;
        Thread.sleep(2000);
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                String MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                int noOfAllowedMilesForBasicMemberInteger = Integer.parseInt(allowedMilsForBasedOnLevel);
                noOfMileFromResult = Double.parseDouble(MileFromResult);
                //Below code is used to click On Results Location Link that is less Than 5 Miles
                if (noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger) {
                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i + 1), "Location Link");
                    Thread.sleep(3000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        return noOfMileFromResult;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: mouseHoverTowMileDetailsOnTowDestination
     * description :: Tool tip for tow Mile Details
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */

    public void mouseHoverTowMileDetailsOnTowDestination()throws  Throwable{
        Thread.sleep(3000);
        mouseHover(CRTowDestinationPage.towMilesDetailsToolTip,"Tow Miles Details ToolTip");
        Thread.sleep(3000);

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEstimatedTowMilesFromToolTip
     * description :: To verify Estimated tow miles from Tool Tip
     * date :: 18-01-2018
     * author :: Lakshmi Prasanna
     */
    public String verifyEstimatedTowMilesFromToolTip() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.lblEstimatedTowMilesInTowToolTip, "Estimated Tow miles");
        mouseHoverTowMileDetailsOnTowDestination();
        Thread.sleep(3000);
        String towMileagesDetail = getText(CRTowDestinationPage.lblToolTipTowMilageDetails, "Tow Milage details");
        Thread.sleep(3000);
        String estimatedTowMileslabel = getText(CRTowDestinationPage.lblEstimatedTowMilesInTowToolTip, "Estimated Tow miles Label");
        Thread.sleep(3000);
        String estimatedTowMilesValue = getText(CRTowDestinationPage.lblEstimatedTowMilesValuesInTowToolTip, "Estimated Tow miles Value");
        boolean estimatedMiles = estimatedTowMileslabel != null;
        assertTrue(estimatedMiles, "Verified the " + estimatedTowMileslabel + " On  " + towMileagesDetail + "  And Estimated Tow Miles are  " + estimatedTowMilesValue);
        return estimatedTowMilesValue;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEntitledMilesFromToolTip
     * description :: To verify Entitled Miles from Tool Tip
     * date :: 18-01-2018
     * author :: Lakshmi Prasanna
     */
    public void verifyEntitledMilesFromToolTip() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.lblEntitleMilesInTowToolTip, "Entitle Miles");
        mouseHoverTowMileDetailsOnTowDestination();
        Thread.sleep(3000);
        String towMileagesDetail = getText(CRTowDestinationPage.lblToolTipTowMilageDetails, "Tow Milage details");
        Thread.sleep(3000);
        String entitleMileslabel = getText(CRTowDestinationPage.lblEntitleMilesInTowToolTip, "Entitle Miles Label");
        Thread.sleep(3000);
        String entitleMilesValue = getText(CRTowDestinationPage.lblEntitleMilesValuesInTowToolTip, "Entitle Miles Value");
        boolean entitleMiles = entitleMileslabel != null;
        assertTrue(entitleMiles, "Verified the " + entitleMileslabel + " On  " + towMileagesDetail + "  And Entitle Miles are  " + entitleMilesValue);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEstimatedOverMilesFromToolTip
     * description :: To verify EstimateOver Miles from Tool Tip
     * date :: 18-01-2018
     * author :: Lakshmi Prasanna
     */
    public String verifyEstimatedOverMilesFromToolTip() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.lblEstimatedOverMilesInTowToolTip, "Estimated OverMiles");
        mouseHoverTowMileDetailsOnTowDestination();
        Thread.sleep(3000);
        String towMileagesDetail = getText(CRTowDestinationPage.lblToolTipTowMilageDetails, "Tow Milage details");
        Thread.sleep(3000);
        String estimatedOverMileslabel = getText(CRTowDestinationPage.lblEstimatedOverMilesInTowToolTip, "Estimated OverMiles Label");
        Thread.sleep(3000);
        String estimatedOverMilesValue = getText(CRTowDestinationPage.lblEstimatedOverMilesValuesInTowToolTip, "Estimated OverMiles Value");
        boolean estimatedOverMiles = estimatedOverMileslabel != null;
        assertTrue(estimatedOverMiles, "Verified the " + estimatedOverMileslabel + " On  " + towMileagesDetail + "  And Estimated Over Miles are  " + estimatedOverMilesValue);
        return estimatedOverMilesValue;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterExistingTowDestAddr
     * description :: Click on existing tow detination link and enter tow passengers
     * date :: 22-02-2018
     * author :: Abhiram
     */
    public void enterExistingTowDestAddr(String towPassengers) throws Throwable {
        clickOnExistingTowDetinationLink();
        enterTowPassengers(towPassengers);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterFullAddress
     * description :: enter all fields on tow detination page
     * date :: 22-02-2018
     * author :: Abhiram
     */
    public void enterFullAddress(String locationAddress, String crossStreet, String secondCrossStreet, String city, String state, String landMark, String towPassengers) throws Throwable {
        enterTowLocationName(locationAddress);
        enterFirstCrossStreet(crossStreet);
        enterSecondCrossStreet(secondCrossStreet);
        enterCityCodeInTow(city);
        enterStateInTow(state);
        enterLandMarkInTow(landMark);
        Thread.sleep(2000);
        getLatitudeValueInTow();
        getLogitudeValueInTow();
        enterTowPassengers(towPassengers);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectAARandEnterPassengerDetails
     * description :: Click on existing AAR Tow Destination Link and enter tow passengers
     * date :: 22-02-2018
     * author :: Abhiram
     */
    public void selectAARandEnterPassengerDetails(String towPassengers) throws Throwable {
        clickOnAARTowDetinationLink();
        enterTowPassengers(towPassengers);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowDestinationTab
     * description ::
     * date :: 12-Jan-2018
     * author :: Nidhi
     */
    public boolean verifyTowDestinationTab() throws Throwable {
        boolean value = isVisibleOnly(CRTowDestinationPage.towDestinationTab, "Tow Destination Tab");
        return value;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: alertForTowMilesOffer
     * description :: alert For Tow Miles Offer
     * date :: 03-01-2018
     * author :: Lakshmi Prasanna
     */
    public void alertForTowMilesOffer() throws Throwable {
        Thread.sleep(1000);
        boolean towOffer = isVisibleOnly(CRTowDestinationPage.btnAlertForTowOffer, "Alert For Tow offer");
        if (towOffer) {
            click(CRTowDestinationPage.btnAlertForTowOffer, "Alert For Tow offer");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnShowCriteriaCollapseButton
     * description :: To click On Show Criteria Collapse Button
     * date :: 03-01-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnShowCriteriaCollapseButton()throws  Throwable{
        click(CRTowDestinationPage.btnShowCrireria,"Show Criteria");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterMilesToSearchRepairShopWithInRange
     * description :: To enter Miles To Search RepairShop WithInRange
     * date :: 03-01-2018
     * author :: Lakshmi Prasanna
     */
    public void enterMilesToSearchRepairShopWithInRange(String searchMiles)throws Throwable{
        Thread.sleep(2000);
        type(CRTowDestinationPage.txtSearchMilesWithInRange,searchMiles,"Miles to Search with in Range");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButtonOnTow
     * description :: Click on Search button on Tow Destination tab
     * date :: 23-Feb-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnSearchButtonOnTow()throws  Throwable{
        click(CRTowDestinationPage.btnTowSearchButton,"Search button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForSpecifedLevel
     * description :: To verify Tow Miles For SpecifedLevel
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public double verifyTowMilesBasedOnLevel(String allowedMilesForBasedOnLevel) throws Throwable {
        String MileFromResult = null;
        boolean flagMiles = false;
        double noOfMileFromResult=0.0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    Actions action = new Actions(driver);
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i + 1), "Miles NA link");
                    Thread.sleep(4000);
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(4000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                }
                int noOfAllowedMilesForBasicMemberInteger = Integer.parseInt(allowedMilesForBasedOnLevel);
                noOfMileFromResult = Double.parseDouble(MileFromResult);
                if (noOfMileFromResult >= noOfAllowedMilesForBasicMemberInteger) {
                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i + 1), "Location Link");
                    Thread.sleep(2000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(4000);
                    break;
                }
            }
        }
        return noOfMileFromResult;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForPlusMemberApproximately50Miles
     * description :: To verify TowMiles For PlusMember Approximately 50Miles
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public double verifyTowMilesForPlusMemberApproximately50Miles(String aboveSpecifiedMiles, String belowSpecifiedMiles) throws Throwable {
        boolean milesFlag = false;
        double noOfMileFromResult = 0.0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "<b>No Tow Destinations Available in Table</b>");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                String MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    Actions action = new Actions(driver);
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i + 1), "Miles NA link");
                    Thread.sleep(3000);
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(3000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                }
                double aboveSpecifiedMilesDouble = Double.parseDouble(aboveSpecifiedMiles);
                double belowSpecifiedMilesDouble = Double.parseDouble(belowSpecifiedMiles);
                noOfMileFromResult = Double.parseDouble(MileFromResult);
                //Verifing the tow Miles are around 50 miles
                if (aboveSpecifiedMilesDouble <= noOfMileFromResult && belowSpecifiedMilesDouble >= noOfMileFromResult) {
                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i + 1), "Location Link");
                    String location = locationLink.getText();
                    //milesFlag = (aboveSpecifiedMilesDouble <= noOfMileFromResult && belowSpecifiedMilesDouble >= noOfMileFromResult);
                    // assertTrue(milesFlag, "<b>Tow destination that is approximately 50 miles from the breakdown location & destination miles : </b>" + noOfMileFromResult + " <b> And Tow Location is   </b>" + location);
                    Thread.sleep(2000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(1000);
                    break;
                }
            }
        }
        return noOfMileFromResult;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForMembersInBetweenTheMileRange
     * description :: To verify TowMiles For Members InBetween TheMileRange
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public double verifyTowMilesForMembersInBetweenTheMileRange(String aboveSpecifiedMiles, String belowSpecifiedMiles) throws Throwable {
        String MileFromResult = null;
        double noOfMileFromResult = 0.0;
        boolean flagMiles = false;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "<b>No Tow Destinations Available in Table</b>");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    Actions action = new Actions(driver);
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i + 1), "Miles NA link");
                    Thread.sleep(4000);
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(4000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                }
                double aboveSpecifiedMilesInt = Double.parseDouble(aboveSpecifiedMiles);
                double belowSpecifiedMilesInt = Double.parseDouble(belowSpecifiedMiles);
                noOfMileFromResult = Double.parseDouble(MileFromResult);
                //Verifing and click on tee tow results link that is Inbetween specified range
                if (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult) {
                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i + 1), "Location Link");
                    String location = locationLink.getText();
                    flagMiles = (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult);
                    assertTrue(flagMiles, "<b> Tow Location Name matching with results Is  :</b>" + location);
                    Thread.sleep(3000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(3000);
                    break;
                }
            }
        }
        return noOfMileFromResult;
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: popupNotificationForRSPreferalPinnedToUnpinned
     * description :: popup Notification For RSPreferal Pinned To Unpinned
     * date :: 17-Jan-2018
     * author :: Abhiram
     */
    public void popupNotificationForRSPreferalPinnedToUnpinned()throws  Throwable{
        waitForInVisibilityOfElement(CRTowDestinationPage.popupNotificationForRSPreferalPinnedToUnpinned,"RSP Notification Pinned to Unpinned");
        click(CRTowDestinationPage.popupNotificationForRSPreferalPinnedToUnpinned,"RSP Notification Pinned to Unpinned");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: popupNotificationForRSPreferalGetTitle
     * description :: get title of RSP Referal Notification popup
     * date :: 17-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String popupNotificationForRSPreferalGetTitle() throws Throwable {
        String popUpNotification = getText(CRTowDestinationPage.popupNotificationForRSPreferalGetTitle, "RSP Referal Status.");
        return popUpNotification;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: popupNotificationForRSPreferalUnPinned
     * description :: popup Notification For RSPreferal UnPinned
     * date :: 17-Jan-2018
     * author :: Abhiram
     */
    public void popupNotificationForRSPreferalUnPinned()throws  Throwable{
        waitForInVisibilityOfElement(CRTowDestinationPage.popupNotificationForRSPreferalUnPinned,"RSP Notification Unpinned");
        click(CRTowDestinationPage.popupNotificationForRSPreferalUnPinned,"RSP Notification Unpinned");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRVType
     * description :: click On RV Type
     * date :: 18-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnRVType()throws  Throwable{
        click(CRTowDestinationPage.chkBoxRVType,"Select Rv Type");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAutoSearchCriteriaInTowDestinationTab
     * description ::getAutoSearchCriteriaInTowDestinationTab
     * date :: 18-Jan-2018
     * author :: Chandra
     */
    public String getAutoSearchCriteriaInTowDestinationTab() throws Throwable {
        Thread.sleep(2000);
        String address = getText(CRTowDestinationPage.lblAutoSearchResults, "Search address");
        return address;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowDestinationResultsList
     * description :: verifyTowDestinationResultsList
     * date :: 18-01-2018
     * author :: Chandra
     */
    public int verifyTowDestinationResultsList() throws Throwable {

        int towDestinationResultsCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            towDestinationResultsCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Tow Destination:: '" + towDestinationResults + "'");
            }
        }
        return towDestinationResultsCount;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnReferalIcon
     * description :: clickOnReferalIcon
     * date :: 18-01-2018
     * author :: Chandra
     */
    public void clickOnReferalIcon() throws Throwable {
        boolean referalIcon=isVisibleOnly(CRTowDestinationPage.iconReferal,"Referal icon in Tow Destination ");
        assertTrue(referalIcon,"Referal icon");
        click(CRTowDestinationPage.iconReferal,"Referal icon in Tow Destination ");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLatLongValue
     * description :: clickOnReferalIcon
     * date :: 18-01-2018
     * author :: Chandra
     */
    public String getLatLongValue() throws Throwable {
        String latlong=getText(CRTowDestinationPage.lblLatLog,"Latitude and Logitude values");
        return latlong;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDisatanceInTow
     * description :: getDisatanceInTow
     * date :: 18-01-2018
     * author :: Chandra
     */
    public boolean getDisatanceInTow(String allowedMilesForBasedOnLevel) throws Throwable {
        String MileFromResult = null;
        boolean milesFlag=false;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 1; i < allRepairShops.size(); i++) {
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    Actions action = new Actions(driver);
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i), "Miles NA link");
                    Thread.sleep(3000);
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(3000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                }
                Thread.sleep(1000);
                double noOfAllowedMilesForBasicMemberInteger = Double.parseDouble(allowedMilesForBasedOnLevel);
                double noOfMileFromResult = Double.parseDouble(MileFromResult);
                if (noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger) {
                    assertTrue(noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger, "Tow destination is  less Than  " + noOfAllowedMilesForBasicMemberInteger + " miles from the breakdown location & destination miles : " + noOfMileFromResult);
                    milesFlag=true;
                }
            }
        }
        return milesFlag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleValueInTowSearch
     * description :: getVehicleValueInTowSearch
     * date :: 18-01-2018
     * author :: Chandra
     */
    public String getVehicleValueInTowSearch() throws Throwable {
        String getValue = getAttributeByValue(CRTowDestinationPage.txtVehicleValueInTowScreen,"Vehicle Value in Tow Destination Search criteria");
        return getValue;
    }
    /* param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleValueInTowSearch
     * description :: getVehicleValueInTowSearch
     * date :: 18-01-2018
     * author :: Chandra
     */
    public Boolean compareTwoValues(String getValue,String inputValue) throws Throwable {
        boolean comparedValues = getValue.equalsIgnoreCase(inputValue);
        assertTrue(comparedValues,"'"+getValue+"' and' "+inputValue+"' Both are same' ");
        return comparedValues;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInVehicle
     * description :: getVehicleValueInTowSearch
     * date :: 18-01-2018
     * author :: Chandra
     */
    public void enterValueInVehicle(String MakeValue) throws Throwable {
        click(CRTowDestinationPage.txtOpenTime,"Time");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        sendKeys(combineKeys3, "Tab");
        clearData(CRTowDestinationPage.txtVehicleValueInTowScreen);
        type(CRTowDestinationPage.txtVehicleValueInTowScreen,MakeValue,"Vehicle Make");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInDate
     * description :: enterValueInDate
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void enterValueInDate(String date) throws Throwable {
        type(CRTowDestinationPage.txtOpenOnDate,date,"Date Value");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDateValue
     * description :: getDateValue
     * date :: 19-01-2018
     * author :: Chandra
     */
    public String getDateValue() throws Throwable {
        String Date = getAttributeByValue(CRTowDestinationPage.txtOpenOnDate,"Date Value");
        return Date;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInDate
     * description :: enterValueInDate
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void enterValueInTime(String time) throws Throwable {
        type(CRTowDestinationPage.txtOpenTime,time,"Time Value");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTRCCheckBox
     * description :: clickOnTRCCheckBox
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnTRCCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxTRC,"Check box TRC");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTRCStatus
     * description :: verifyTRCStatus
     * date :: 19-01-2018
     * author :: Chandra
     */
    public int verifyTRCStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconTRC, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }
        }
        return TRCCount;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOpenOnCheckBox
     * description :: clickOnOpenOnCheckBox
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnOpenOnCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxOpenOn,"Check box Open On Date");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAARnCheckBox
     * description :: clickOnAARnCheckBox
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnAARnCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxAAR,"Check box AAR");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAutoGlass
     * description :: clickOnAutoGlass
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnAutoGlass() throws Throwable {

        click(CRTowDestinationPage.chkBoxAutoGlass,"Check box AutoGlass");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairShopVerificationCloseButton
     * description :: click On RepairShop Verification CloseButton
     * date :: 19-01-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnRepairShopVerificationCloseButton()throws  Throwable {
        boolean closebutton = isVisibleOnly(CRTowDestinationPage.btnRepairShopVerificationCloseButton, "Click On Cancel Button");
        if (closebutton) {
            Thread.sleep(2000);
            click(CRTowDestinationPage.btnRepairShopVerificationCloseButton, "Click On Cancel Button");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextFromAlertOnTowDestinationMiles
     * description :: get Text From AlertOn Tow DestinationMiles
     * date :: 19-01-2018
     * author :: Lakshmi Prasanna
     */
    public void getTextFromAlertOnTowDestinationMiles()throws  Throwable{
        boolean repairshopvisibility=isVisibleOnly(CRTowDestinationPage.txtFromAlertRegardingTowDestination,"Text From Alert RepairShop Verification");
        if(repairshopvisibility) {
            String repairShopMessage = getText(CRTowDestinationPage.txtFromAlertRegardingTowDestination, "Text From Alert RepairShop Verification");
            assertTrue(repairshopvisibility,"repairShopMessage");
        }
    }

    /**
     *  * param :: NA
     *  * return ::boolean
     *  * throws :: throwable
     *  * methodName :: verifyAddressAvailableInTowDestination
     *  * description ::
     *  * retrivedTime :: 22-Jan-2018
     *  * author :: Abhiram
     *
     */
    public boolean verifyAddressAvailableInTowDestination()throws  Throwable{
        boolean towDestinationAddressAvailable = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Existing Address are Not Visible in Tow Destination Page");
        return towDestinationAddressAvailable;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCollisinCheckBox
     * description :: clickOnCollisinCheckBox
     * date :: 23-01-2018
     * author :: Chandra
     */
    public void clickOnCollisinCheckBox() throws Throwable {
        click(CRTowDestinationPage.chkBoxCollision,"Check box AAR");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAARStatus
     * description :: verifyAARStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyAARStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }

    public void clickOnRepairShopCheckboxOnTow()throws  Throwable{
        click(CRTowDestinationPage.chkBoxRepairShop,"Repair shop Checkbox");
    }

    public void clickOnRVCheckboxOnTow()throws  Throwable{
        click(CRTowDestinationPage.chkBoxRV,"Repair shop Checkbox");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAutoGlassStatus
     * description :: verifyAutoGlassStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyAutoGlassStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }
        }
        return TRCCount;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCollisionStatus
     * description :: verifyCollisionStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyCollisionStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }
        }
        return TRCCount;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyRVStatus
     * description :: verifyRVStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyRVStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }
    
    public void rspReferal(String RSPReferral) throws Throwable{

        if (RSPReferral.equalsIgnoreCase("Yes")) {
            popupNotificationForRSPreferalUnPinned();
            popupNotificationForRSPreferalGetTitle();
            popupNotificationForRSPreferalPinnedToUnpinned();
        }
    }
    
    public void clickOnManualEntryAndEnterTowDestDetails(String TDLocationAddress, String TDcrossStreet, String TDsecondCrossStreet, String TDCity, String TDState, String TDLandMark, String Towpassengers ) throws Throwable {
    	clickOnManualEntryLinkOnTowDestination();
        enterTowLocationName(TDLocationAddress);
        enterFirstCrossStreet(TDcrossStreet);
        enterSecondCrossStreet(TDsecondCrossStreet);
        enterCityCodeInTow(TDCity);
        enterStateInTow(TDState);
        enterLandMarkInTow(TDLandMark);
        enterTowPassengers(Towpassengers);
    }
    
    public void enterTowDestinationAddress(String WillThisCallBeATow, String TowDestination, String RSPReferral , String TowAddress) throws Throwable {
        handleScriptError();
        if(WillThisCallBeATow.equalsIgnoreCase("Yes")) {
            boolean towDestinationTabAvailability = verifyTowDestinationTabAvailablity();
            if (towDestinationTabAvailability) {
                clickOnTowDestinationTab();
                handleScriptError();
                String TowAddressVal[] = TowAddress.split("#");
                switch (TowDestination) {
                    case "Existing":
                        boolean noAddressLocationAvailable = verifyAddressAvailableInTowDestination();
                        if (noAddressLocationAvailable) {
                            enterTowDestinationLocationFields(TowAddress);
                        } else {
                            enterExistingTowDestAddr(TowAddressVal[9]);
                        }
                        break;
                    case "Full Address":
                        enterTowDestinationLocationFields(TowAddress);
                        break;
                    case "AAR":
                        if (RSPReferral.equalsIgnoreCase("Yes")) {
                            popupNotificationForRSPreferalGetTitle();
                        }
                        boolean noLocationAvailable = verifyAddressAvailableInTowDestination();
                        if (noLocationAvailable) {
                            enterTowDestinationLocationFields(TowAddress);
                        } else {
                            clickOnAARTowDetinationLink();
                            enterTowPassengers(TowAddressVal[9]);
                        }
                        break;
                    default:
                        break;
                }
                verifyCompleteCheckTowDestination();
            }
        }
    }

    public void verifyCompleteCheckTowDestination()  throws Throwable {
        if (!(isVisibleOnly(CRTowDestinationPage.verifyTowDestinationCompleteCheck, "Tow Destination Complete Check"))) {
            reporter.failureReport("Verify Tow Destination Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }

    public boolean verifyTowDestinationTabAvailablity()throws Throwable{
        boolean towTabVerification = isVisibleOnly(CRTowDestinationPage.towDestinationTab,"Tow Destination Tab");
        return towTabVerification;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: handleScriptErrorInVehicleTriagePage
     * description ::
     * date :: 18-Dec-2017
     * author :: chandra
     */
    public void handleScriptError() throws Throwable {
        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            //assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            //assertTrue(errorIconAvailablility, "Error icon available on error popup");
            if (errorIconAvailablility) {
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            }
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");
        }
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetAddressNo
     * description ::
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public void enterStreetAddressNo(String StreetAddressNo) throws Throwable {
        type(CRTowDestinationPage.txtTowStreetAddressNo,StreetAddressNo,"Street Address Number");
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetAddressName
     * description ::
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public void enterStreetAddressName(String StreetAddressName) throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.txtTowStreetAddressName,"Street Address Name");
        type(CRTowDestinationPage.txtTowStreetAddressName,StreetAddressName,"Street Address Name");
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetAddressName
     * description ::
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public void enterZIP(String ZIP) throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.txtTowZIP,"ZIP");
        type(CRTowDestinationPage.txtTowZIP,ZIP,"ZIP");
    }

    public void enterTowDestinationLocationFields(String TowAddress) throws Throwable {
        String TowAddressVal[] =  TowAddress.split("#");
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        clickOnManualEntryLinkOnTowDestination();
        enterTowLocationName(TowAddressVal[0]);
        enterStreetAddressNo(TowAddressVal[1]);
        enterStreetAddressName(TowAddressVal[2]);
        enterFirstCrossStreet(TowAddressVal[3]);
        enterSecondCrossStreet(TowAddressVal[4]);
        enterCityCodeInTow(TowAddressVal[5]);
        enterStateInTow(TowAddressVal[6]);
        enterZIP(TowAddressVal[7]);
        enterLandMarkInTow(TowAddressVal[8]);
        enterTowPassengers(TowAddressVal[9]);
    }
    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: printAllTowDestinationResults
     * description :: To print all results Link Names On Tow
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public boolean printAllTowDestinationResults() throws Throwable {
        boolean resultsAvailableFlag=false;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 0; i < allRepairShops.size(); i++) {
                String MileFromResult = getText(CRTowDestinationPage.getMilesList(i + 1), "Miles From results");
                WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i + 1), "Location Link");
                //Getting text From Location Link
                String locationName = locationLink.getText();
                assertTrue(locationName != null, "Tow destination Result Link Name  :: " + locationName + "  : Miles " + MileFromResult);

            }

            resultsAvailableFlag=true;
        }
        return resultsAvailableFlag;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: addressVerificationWithLatitudeAndLongitude
     * description ::
     * date :: 18-01-2018
     * author :: Chandra
     */
    public String addressVerificationWithLatitudeAndLongitude() throws Throwable {
        String addressVerification = getText(CRTowDestinationPage.lblLatLog, "Latitude and Logitude values");
        return addressVerification;
    }
    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: verifyTickIconOnTowDest
     * description ::
     * date :: 19-03-2018
     * author ::Nidhi
     */
    public boolean verifyTickIconOnTowDest() throws Throwable {
        Thread.sleep(4000);
        boolean tickIcon = isVisibleOnly(CRTowDestinationPage.iconGreenTickIconOnTowDest, "Green Tick Icon visible");
        return tickIcon;
    }

    public boolean verifyMilesOnTowBasedOnSearchCriteria(String searchMiles) throws Throwable {
        String MileFromResult = null;
        boolean resultsAvailableFlag=false;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 1; i <= allRepairShops.size(); i++) {
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    Actions action = new Actions(driver);
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i), "Miles NA link");
                    Thread.sleep(3000);
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(3000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                }
                double miles = Double.parseDouble(MileFromResult);
                double searchMilesInt = Double.parseDouble(searchMiles);
                //Searching for greater than 20 Miles
                if (searchMilesInt < miles) {
                    resultsAvailableFlag = true;
                    break;
                }
            }
        }
        return resultsAvailableFlag;
    }
    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enetrServiceProvider
     * description ::To enter service provider
     * date :: 22-03-2018
     * author ::Lakshmi
     */
    public void enetrServiceProvider(String serviceProvider)throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.serviceProviderName,"Service Provider");
        type(CRTowDestinationPage.serviceProviderName,serviceProvider,"Service Provider");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearLocation
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void clickOnClearLocation()throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.btnClearLocation,"Clear Location Button");
        click(CRTowDestinationPage.btnClearLocation,"Clear Location Button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnverifyItButton
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void clickOnverifyItButton()throws  Throwable{
        boolean addressVerified = isVisibleOnly(CRTowDestinationPage.btnVerifyIt,"Verify It Button");
        if (addressVerified) {
            click(CRTowDestinationPage.btnVerifyIt,"Verify It Button");
        }

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddressVerificationLinkInRowSelection
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void clickOnAddressVerificationLinkInRowSelection()throws Throwable{
        boolean isAddressDiffAvailable = isVisibleOnly(CRTowDestinationPage.lnkAddressVerificationInRowSelection," address link In addressVerification Window");
        if(isAddressDiffAvailable) {
            click(CRTowDestinationPage.lnkAddressVerificationInRowSelection, "Clink on address link In addressVerification Window");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressVerifiedTextFromButton
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public String getAddressVerifiedTextFromButton()throws Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.txtButtonVerified,"text ob Verified button");
        String textVerifiesFromButton = getText(CRTowDestinationPage.txtButtonVerified,"text ob Verified button");
        return textVerifiesFromButton;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressInOmniSearchBar
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void enterAddressInOmniSearchBar(String address)throws  Throwable{
        type(CRTowDestinationPage.txtOmniSearchBar,address,"Enter address In Omnisearch bar");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOmniSearchButton
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void clickOnOmniSearchButton()throws  Throwable{
        click(CRTowDestinationPage.btnOmniSearch,"Click On search Button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickPreviouslyUsedTowDestination
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void clickPreviouslyUsedTowDestination()throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.lnkPreviouslyUsedTow,"Previously Used Tow Destination");
        click(CRTowDestinationPage.lnkPreviouslyUsedTow,"Click On Previously Used Tow Destination");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressFromPreviouslyUsedTowDestination
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public String getAddressFromPreviouslyUsedTowDestination()throws Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.lnkPreviouslyUsedTow,"Previously Used Tow Destination");
        String previuslyUsedTowAddress = getText(CRTowDestinationPage.lnkPreviouslyUsedTow,"Click On Previously Used Tow Destination");
        return previuslyUsedTowAddress;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: removeTheServiceProvider
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public void removeTheServiceProvider()throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.lnkCloseTheServiceProvider,"Close the service provider");
        click(CRTowDestinationPage.lnkCloseTheServiceProvider,"Close The Service Provider");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLatitudeValueInTow
     * description :: getLatitudeValueInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public String getLatitudeValueInTow() throws Throwable {
        String latitude = getAttributeByValue(CRTowDestinationPage.txtlatitude, "Latitude");
        return latitude;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStreetNumber
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public String getStreetNumber()throws  Throwable{
        String streetNumber = getAttributeByValue(CRTowDestinationPage.txtTowStreetAddressNo,"Street Number");
        return streetNumber;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStreetName
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public String getStreetName()throws  Throwable{
        String streetName =getAttributeByValue(CRTowDestinationPage.txtTowStreetAddressName,"Street Name");
        return streetName;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCityName
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public String getCityName()throws  Throwable{
        String cityName = getAttributeByValue(CRTowDestinationPage.txtTowCity,"City Name");
        return cityName;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStateName
     * description ::
     * date :: 03-01-2018
     * author :: Lakshmi
     */
    public String getStateName()throws  Throwable{
        String stateName = getAttributeByValue(CRTowDestinationPage.txtTowState,"State Name");
        return stateName;
    }

    /**
     * param :: String
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTowDestinationIsAvailable
     * description :: pass the tow destination to verify tow destination is available or not
     * date :: 02-Apr-2018
     * author :: Jagadish Pola
     */
    public boolean verifyTowDestinationIsAvailable(String towDestination)throws  Throwable{
        dynamicWaitByLocator(CRTowDestinationPage.selectTowDestination(towDestination),30);
        return isVisibleOnly(CRTowDestinationPage.selectTowDestination(towDestination),"Tow destination");
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowDestination
     * description :: pass the tow destination to click on tow
     * date :: 02-Apr-2018
     * author :: Jagadish Pola
     */
    public void clickOnTowDestination(String towDestination)throws  Throwable{
        dynamicWaitByLocator(CRTowDestinationPage.selectTowDestination(towDestination),30);
        scroll(CRTowDestinationPage.selectTowDestination(towDestination),"Tow destination");
        click(CRTowDestinationPage.selectTowDestination(towDestination),"Click on tow destination");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndSelectTowDestinationFromSearchResults
     * description :: pass the tow destination top verify and click on tow destination
     * date :: 02-Apr-2018
     * author :: Jagadish Pola
     */
    public void verifyAndSelectTowDestinationFromSearchResults(String towDestination)throws  Throwable{
        if(verifyTowDestinationIsAvailable(towDestination))
        {
            clickOnTowDestination(towDestination);
        }
        else
        {
            reporter.failureReport("Tow destination","Tow destination is not visible",driver);
        }
    }

    /**
     * param :: String
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTowDestinationPriorityService
     * description :: Verifyies tow destination pririty service letter "R" is filled with color or not
     * date :: 05-Apr-2018
     * author :: Jagadish Pola
     */

    public boolean verifyTowDestinationPriorityService(String towDestination) throws Throwable {
        dynamicWaitByLocator(CRTowDestinationPage.verifyTowDestinationPriorityService(towDestination),60);
        return isVisibleOnly(CRTowDestinationPage.verifyTowDestinationPriorityService(towDestination),"Tow destination priority service");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTowDestinationPriority
     * description :: verifyies tow destination priority service letter "R" is filled with color or not
     * date :: 06-Apr-2018
     * author :: Jagadish Pola
     */

    public boolean verifyTowDestinationPriority() throws Throwable {
        dynamicWaitByLocator(CRTowDestinationPage.getIconTowDestinationPriorityServiceForSelectedShop,60);
        return isVisible(CRTowDestinationPage.getIconTowDestinationPriorityServiceForSelectedShop,"Tow destination priority service for selected shop");
    }

    /**
     * param ::
     * return ::List
     * throws :: throwable
     * methodName :: totalNumberOfNonAARTowDestinationNamesToSelect
     * description :: Total tow destinations with non aar in search results names.
     * date :: 17-Apr-2018
     * author :: Jagadish Pola
     */

    public List totalNumberOfNonAARTowDestinationNamesToSelect() throws Throwable {
        dynamicWaitByLocator(CRTowDestinationPage.getTotalNumberOfSearchResults,60);
        List<WebElement> totalNumberOfTowDestination=getWebElementList(CRTowDestinationPage.getTotalNumberOfSearchResults,"Search results");
        List<String> nonAARTowDestinations=new ArrayList<>();
        for(WebElement towDestinations : totalNumberOfTowDestination)
        {
            if(!towDestinations.toString().toLowerCase().contains("aar"))
            {
                nonAARTowDestinations.add(towDestinations.toString());
            }
        }
        return nonAARTowDestinations;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectingNonAARTowDestination
     * description :: Selecting non aar tow destination.
     * date :: 17-Apr-2018
     * author :: Jagadish Pola
     */

    public void selectingNonAARTowDestination() throws Throwable {
        String nonAARTowDestination=totalNumberOfNonAARTowDestinationNamesToSelect().get(1).toString();
        verifyAndSelectTowDestinationFromSearchResults(nonAARTowDestination);
    }

}



