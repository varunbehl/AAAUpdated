package com.aaa.web.lib;

import static org.testng.Assert.assertTrue;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRLocationsPage;

import org.apache.pdfbox.util.operator.Concatenate;
import org.apache.xml.utils.ThreadControllerWrapper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class CRLocationsLib extends ActionEngine {
    List<WebElement> tableColumnData = null;
    List<WebElement> tableCommentTypeCol = null;
    List<WebElement> tableCommentStatus = null;
    List<WebElement> tableCommentTimeStamp = null;
    List<WebElement> tableCommentUser = null;
    List<WebElement> tableCommentLocation = null;

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: locationFieldsVerification
     * description :: To Verify All Mandatory Fields on Location Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void locationFieldsVerification() throws Throwable {
        verifyBreakDownCity();
        verifyBreakDownState();
        verifyStreetAddress();
        verifyBreakDownLocationCode();

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearAndSaveLocationDetails
     * description :: To Clear and Save All mandatory Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearAndSaveLocationDetails(String enterBreakdownAddress, String enterBreakdownCityLocation, String enterBreakdownState, String enterBreakdownLocationCode) throws Throwable {
        clearLocationMandatoryFields();
        enterAndSaveLocationMandatoryFields(enterBreakdownAddress, enterBreakdownCityLocation, enterBreakdownState, enterBreakdownLocationCode);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchBreakDownLocation
     * description :: To Search BreakDown Location By clicking on Existing Location Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void searchBreakDownLocation(String enterBreakdownLocationCode) throws Throwable {
        clickOnLocationTab();
        clickOnExistingBreakDwnLoc();
        enterBrkDownLocCode(enterBreakdownLocationCode);
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyStreetAddress
     * description :: To Verify StreetAddress as Mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyStreetAddress() throws Throwable {
        boolean flagstreetadd = isVisibleOnly(CRLocationsPage.txtStreetAddress_required, "Street Address");
            assertTrue(flagstreetadd, "Street Address is Mandatory Field");
        return flagstreetadd;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyBreakDownCity
     * description :: To Verify Breakdown City as Mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyBreakDownCity() throws Throwable {
        boolean flagLocCity = isVisibleOnly(CRLocationsPage.txtLocCity_required, "City");
            assertTrue(flagLocCity, " <b>Location  City is Mandatory Field </b>");
            return flagLocCity;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownState
     * description :: To Verify Breakdown State as Mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyBreakDownState() throws Throwable {
        boolean flagLocState = isVisibleOnly(CRLocationsPage.txtLocState_required, "State");
            assertTrue(flagLocState, "<b>Location  State is Mandatory Field</b>");
            return flagLocState;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyBreakDownLocationCode
     * description :: To Verify BreakDown LocationCode as Mandatory Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyBreakDownLocationCode() throws Throwable {
        boolean flagLocCode = isVisibleOnly(CRLocationsPage.txtLocCode_required, "Location Code");
            assertTrue(flagLocCode, "<b>Location  Location Code is Mandatory Field</b>");
            return flagLocCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationTab
     * description :: To click On Location Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnLocationTab() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.locationTab, "Location Tab");
        click(CRLocationsPage.locationTab, "Location Tab");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To clear Location Mandatory Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearLocationMandatoryFields() throws Throwable {
        //clickonmanualEntryLink("location");
        clearData(CRLocationsPage.txtStreetAddress);
        clearData(CRLocationsPage.txtLocCity);
        clearData(CRLocationsPage.txtLocState);
        clearData(CRLocationsPage.txtLocCode);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAndSaveLocationMandatoryFields
     * description :: To Enter all Mandatory Fields on Location for saving
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterAndSaveLocationMandatoryFields(String enterBreakdownAddress, String enterBreakdownCityLocation, String enterBreakdownState, String enterBreakdownLocationCode) throws Throwable {
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterBKDownStreetAddress(enterBreakdownAddress);
        enterBKDownCityLocation(enterBreakdownCityLocation);
        enterBKDownState(enterBreakdownState);
        enterBKDownLocCode(enterBreakdownLocationCode);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBKDownStreetAddress
     * description :: To enter BKDownStreet Address
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownStreetAddress(String enterBreakdownAddress) throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.txtStreetAddressInput, "BKDownStreetAddress");
        click(CRLocationsPage.txtStreetAddressInput, "BKDownStreetAddress");
        clearData(CRLocationsPage.txtStreetAddressInput);
        type(CRLocationsPage.txtStreetAddressInput, enterBreakdownAddress, "BKDownStreetAddress");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBKDownCityLocation
     * description :: To enter BKDownCity Location Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownCityLocation(String enterBreakdownCityLocation) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocCity, "BKDownCityLocation");
        click(CRLocationsPage.txtLocCity, "BKDownCityLocation");
        //clearData(CRLocationsPage.txtLocCity);
        type(CRLocationsPage.txtLocCity, enterBreakdownCityLocation, "BKDownCityLocation");
        click(CRLocationsPage.txtStreetInputAddress, "BKDownCityLocation");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBKDownState
     * description :: To enter BKDown State Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownState(String enterBreakdownState) throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRLocationsPage.txtLocState, "BKDownState");
        click(CRLocationsPage.txtLocState, "BKDownState");
        //clearData(CRLocationsPage.txtLocState);
        //selectByVisibleText(CRLocationsPage.txtLocState, enterBreakdownState, "BKDownState");
        type(CRLocationsPage.txtLocState, enterBreakdownState, "BKDownState");
        click(CRLocationsPage.txtStreetInputAddress, "BKDownCityLocation");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBKDownLocCode
     * description :: To enter BKDownLoc Code
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownLocCode(String enterBreakdownLocationCode) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocCode, "BKDownLocCode");
        Thread.sleep(3000);
        clearData(CRLocationsPage.txtLocCode);
        type(CRLocationsPage.txtLocCode, enterBreakdownLocationCode, "BKDownCode");
        Thread.sleep(3000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle Script Errors and Alerts
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling on Location Tab
        boolean flagErrorAlertOk = isVisibleOnly(CRLocationsPage.errorAlertOK, "Error Alert OK button");
        //assertTrue(flagErrorAlertOk, "Error Alert OK button");
        if (flagErrorAlertOk) {
            click(CRLocationsPage.errorAlertOK, "Error Alert OK Button");
        }
        boolean scripterrorflag = isVisibleOnly(CRLocationsPage.scriptError, "Script Error OKAY button");
        if (scripterrorflag) {
            JSClick(CRLocationsPage.scriptError, "Script error Okay button");
        }
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: breakdownLocTabSel
     *  * description :: To click on Location Tab
     *  * date :: 05-Dec-2017
     *  * author ::Lakshmi Prasanna
     *  
     */
    public void breakdownLocTabSel() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.locationTab, "Locations tab");
        click(CRLocationsPage.locationTab, "Locations tab");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterLocationDetails
     *  * description :: To search BreakDown Address in Two ways.click on existing link OR Search the address by omni search bar.
     *  * date :: 05-Dec-2017
     *  * author ::Lakshmi Prasanna
     *  
     */
    public void enterLocationDetails(String enterBreakdownLocationCode, String enterBreakdownLocationSearch) throws Throwable {
        if (isElementPresent(CRLocationsPage.linkBrkDownLocAddr, "breakdown loacation address")) {
            clickonBrkdownLocLink();
            brkdownLocationCode(enterBreakdownLocationCode);
        } else {
            enterTxtinBrkDowLocSrch(enterBreakdownLocationSearch);
            brkDowLocSrchBtn();
            brkdowLocAddrLink();
            brkdownLocationCode(enterBreakdownLocationCode);

        }
    }

    /**
     *  * param ::
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickonBrkdownLocLink
     *  * description :: To click on already available breakdown location link
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void clickonBrkdownLocLink() throws Throwable {


        isElementPresent(CRLocationsPage.linkBrkDownLocAddr, "breakdown loacation address");
        waitForVisibilityOfElement(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
        click(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkdownLocationCode
     *  * description :: To enter Location Code
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void brkdownLocationCode(String enterBreakdownLocationCode) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownLocationCode, "Breakdownlocation code");
        type(CRLocationsPage.dropBoxBrkDownLocationCode, enterBreakdownLocationCode, "Breakdownlocationcode");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterTxtinBrkDowLocSrch
     *  * description :: To enter breakdown location address manually
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */


    public void enterTxtinBrkDowLocSrch(String enterBreakdownLocationSearch) throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.txtBrkDowLocSrch, "Breakdown location search");
        click(CRLocationsPage.txtBrkDowLocSrch, "Location search box");
        type(CRLocationsPage.txtBrkDowLocSrch, enterBreakdownLocationSearch, "Breakdownlocaddress");

        click(CRLocationsPage.labelSearchingInfo, "Click");
        mouseClick(CRLocationsPage.txtBrkDowLocSrch, "Breakdownlocaddress");
    }

    /**
     *  * param ::
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkDowLocSrchBtn
     *  * description :: To click On Search Button
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void brkDowLocSrchBtn() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.btnBrkDowLocSrch, "Breakdown location search button");
        click(CRLocationsPage.btnBrkDowLocSrch, "Breakdown location search");
    }

    /**
     *  * param ::
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkdowLocAddrLink
     *  * description :: To click On  BreakDown Location Link
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void brkdowLocAddrLink() throws Throwable {
        //waitForInVisibilityOfElement(CRLocationsPage.linkBrkDowSrchAddress, "Link brkdown address search");
        click(CRLocationsPage.linkBrkDowSrchAddress, "Link brkdown address search");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExistingBreakDwnLoc
     * description :: To click On Existing BreakDown Location Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnExistingBreakDwnLoc() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
        click(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBrkDownLocCode
     * description :: To enter BreakDown Location Code
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterBrkDownLocCode(String enterBreakdownLocationCode) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownLocationCode, "Breakdownlocation code");
        type(CRLocationsPage.dropBoxBrkDownLocationCode, enterBreakdownLocationCode, "Breakdownlocationcode");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLinkInLocation
     * description :: To Click on Manual Entry Link On Location Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnManualEntryLinkInLocation() throws Throwable {
        click(CRLocationsPage.linkManualEntryOnLocationTab, "ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallComments
     * description :: To enter call comments in comments text field
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void enterCallComments(String callComments) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtCallComments, "Call comments");
        type(CRLocationsPage.txtCallComments, callComments, "Call comments entered");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallCommentsAddButton
     * description :: Click on call comments add button
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnCallCommentsAddButton() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.btnCallsAdd, "Call comments Add button");
        click(CRLocationsPage.btnCallsAdd, "Call comments Add button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallCommentsButton
     * description :: To click On CallComments Button
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnCallCommentsButton() throws Throwable {
        click(CRLocationsPage.btnViewComments, "Call comments View button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickIconMessageWindowClose
     * description :: To click On Icon-Close On MessageWindow
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickIconMessageWindowClose() throws Throwable {
        click(CRLocationsPage.iconMessageWindowClose, "Icon window close");
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnSecondKownBrkDowLocation
     * description :: To Click On Second known existing link
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean clickOnSecondKownBrkDowLocation() throws Throwable {
        boolean location = isVisibleOnly(CRLocationsPage.linkSecondknownBrkDowLocAddr, "Second Known break down Location");
        assertTrue(location, "Second Known break down Location is available");
        if (location) {
            click(CRLocationsPage.linkSecondknownBrkDowLocAddr, "Second Known break down Location");
        }
        return location;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearLocationButton
     * description :: To click on Clear Location Button
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnClearLocationButton() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.btnClearLocation, "Clear Location Button");
        click(CRLocationsPage.btnClearLocation, "Clicking on Clear Location Button");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: acceptAddressDifferenceAlert
     * description ::To accept Address Difference Alert
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean acceptAddressDifferenceAlert() throws Throwable {

        Thread.sleep(2000);
        boolean btnAlertSaveYes = isVisibleOnly(CRLocationsPage.btnAlertSaveYes, "Click on Yes to use the Address");
        if (btnAlertSaveYes) {
            //waitForVisibilityOfElement(CRLocationsPage.btnAlertSaveYes, "Click on Yes to use the Address");
            click(CRLocationsPage.btnAlertSaveYes, "Click on Yes to use the Address");
        } 
        return btnAlertSaveYes;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationResultsLink
     * description ::To click On Location Results Link for Row selection
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnLocationResultsLink() throws Throwable {
        isVisibleOnly(CRLocationsPage.lnkRowSelectionInLocationResults, "Select the link on Location Results");
        waitForVisibilityOfElement(CRLocationsPage.lnkRowSelectionInLocationResults, "Select the link on Location Results");
        click(CRLocationsPage.lnkRowSelectionInLocationResults, "Click on Location Results link");
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyBreakDownStreetValue
     * description ::To Verify the Break Down Street Name is Matched Or Not with Search value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyBreakDownStreetValue() throws Throwable {
        String bkDownStreetAddress = getBKDownStreetAddress();
        boolean streetValue = !bkDownStreetAddress.isEmpty();
        assertTrue(streetValue, "Verified the street Address with returned Value & Street Address is populated     " + bkDownStreetAddress);
        return streetValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getBKDownStreetAddress
     * description :: To get BKDown Street Address
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public String getBKDownStreetAddress() throws Throwable {
        String streetAddress = getAttributeByValue(CRLocationsPage.txtStreetAddressInput, "Street Address");

        return streetAddress;

    }
    /**
     * param
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyFirstCrossStreetFieldValue
     * description ::To verify first Cross Street Field Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyFirstCrossStreetFieldValue() throws Throwable {
        String firstCrossStreet = getFirstCrossStreetsValue();
        boolean crossStreetValue = !firstCrossStreet.isEmpty();
        assertTrue(crossStreetValue, "Verified the firstCross street with returned Value & firstCross Street is populated       " + firstCrossStreet);
        return crossStreetValue;
    }
    /**
     * param
     * return ::String
     * throws :: throwable
     * methodName :: getFirstCrossStreetsValue
     * description ::To get first CrossStreets Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getFirstCrossStreetsValue() throws Throwable {
        //String northcrossStreet = String.valueOf(CRLocationsPage.txtNarthCrossstreet);
        String firstCrossStreetValue = getAttributeByValue(CRLocationsPage.txtFirstCrossstreet, "first Cross Street");
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(firstCrossStreetValue);
        return firstCrossStreetValue;

    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifySecondCrossStreetFieldValue
     * description ::To verify Second Cross Street Field Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifySecondCrossStreetFieldValue() throws Throwable {
        String secondCrossStreet = getSecondCrossStreetsValue();
        boolean crossStreetValue = !secondCrossStreet.isEmpty();
        assertTrue(crossStreetValue, "Verified the Second Cross street with returned Value & Second Cross Street is Populated      " + secondCrossStreet);
        return crossStreetValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getSecondCrossStreetsValue
     * description ::To get Second Cross Streets Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getSecondCrossStreetsValue() throws Throwable {
        //String southCrossStreet = String.valueOf(CRLocationsPage.txtSouthCrossstreet);
        String secondCrossStreetValue = getAttributeByValue(CRLocationsPage.txtSecondCrossstreet, "Second Cross Street");
        return secondCrossStreetValue;

    }

    /**
     * paran ::String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLatitude
     * description ::To enter Latitude Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void enterLatitude(String latitude) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLatitude, "Latitude");
        type(CRLocationsPage.txtLatitude, latitude, "Enter Latitude value");
    }

    /**
     * paran ::String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLongitude
     * description ::To enter Longitude Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void enterLongitude(String longitude) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLongitude, "Longitude");
        type(CRLocationsPage.txtLongitude, longitude, "Enter Longitude value");
    }

    /**
     * param::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVerifyItButton
     * description ::To click On VerifyIt Button,For validate address in Locations
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnVerifyItButton() throws Throwable {
        isVisibleOnly(CRLocationsPage.btnVerifyIt, "VerifyIt Button");
        waitForVisibilityOfElement(CRLocationsPage.btnVerifyIt, "VerifyIt Button");
        click(CRLocationsPage.btnVerifyIt, "Click on VerifyIt Button");
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCityField
     * description ::To verify city Field Name
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyCityField() throws Throwable {

        String city = getCityValue();
        boolean cityValue = !city.isEmpty();
        assertTrue(cityValue, "Verified the City Field Name with returned Value & City Name is populated       " + city);
        return cityValue;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCityValue
     * description ::To get City Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getCityValue() throws Throwable {
        //String cityLocator = String.valueOf(CRLocationsPage.txtLocCity);
        String cityValue = getAttributeByValue(CRLocationsPage.txtLocCity, "City");
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(cityValue);
        cityValue = StandardCharsets.UTF_8.decode(byteBuffer).toString();
        return cityValue;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyStateField
     * description ::To verify StateField
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyStateField() throws Throwable {
        String state = getStateValue();
        boolean stateValue = !state.isEmpty();
        assertTrue(stateValue, "Verified the State Field Name with returned Value & State Name is populated     " + state);
        return stateValue;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLatitudeField
     * description :: To verify Latitude Field
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public boolean verifyLatitudeField() throws Throwable {
        String latitude = getLatitudeValue();
        boolean latitudeValue = !latitude.isEmpty();
        assertTrue(latitudeValue, "Latitude is Populated      " + latitude);
        return latitudeValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getLatitudeValue
     * description :: Retriving the latitude value from field
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getLatitudeValue() throws Throwable {

        String latitudeValue = getAttributeByValue(CRLocationsPage.txtLatitude, "Latitude Field Value");
        return latitudeValue;

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getStateValue
     * description ::To get State Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getStateValue() throws Throwable {
        String stateValue = getAttributeByValue(CRLocationsPage.txtLocState, "State Field Value");
        return stateValue;
    }

    /**
     * param ::String inputs
     * return ::int
     * throws :: throwable
     * methodName :: verifySpecialCharactersWithResults
     * description ::To verify Special Characters With populated Results
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public int verifySpecialCharactersWithResults(String specialCharacters) throws Throwable {
        String specialCharactersString = getText(CRLocationsPage.txtspecialCharacters, "Special Characters String");
        int specialCharactersMatch = specialCharacters.compareTo(specialCharactersString);
        assertTrue(specialCharactersMatch != 0, "Results returned with exact match and Also special characters are displayed properly");
        return specialCharactersMatch;
    }

    /**
     * param ::
     * return ::int
     * throws :: throwable
     * methodName :: getNumberOfResultsRecordsInResultsGrid
     * description ::To get Number Of Records In ResultsGrid
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public int getNumberOfRecordsInResultsGrid() throws Throwable {
        int resultsList = getElementsSize(CRLocationsPage.recardListInResultsGrid);
        if (resultsList>0) {
        	String resutInfo = null;
            List<WebElement> Address = getWebElementList(CRLocationsPage.recardListInResultsGrid,"Address Retrieved ");
            for(WebElement trElement : Address) {
	        	resutInfo = trElement.getText();
	        	if (!resutInfo.isEmpty()){
	        		reporter.SuccessReport("fetch Data from Table", "fetched Data from Table:"+resutInfo);
	        	}
        		else{
        			reporter.failureReport("fetch Data from Table", "Unable to fetch Data from Table");
        		}	
        	}
        }        
        assertTrue(resultsList != 0, "Found the results with Point of Interest,Number of records are " + resultsList);
       
       
        return resultsList;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLandMarkField
     * description ::To verify LandMarkField is populated with POI(Point of Interest) name
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyLandMarkField() throws Throwable {
        boolean landMrk;
        String landMark = getLandMarkField();
        boolean landMarkValue = !landMark.isEmpty();
        assertTrue(landMarkValue, "Verified the LandMark Field Name with returned Value & LandMark Field is populated");
        landMrk = true;

        return landMrk;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getLandMarkField
     * description ::To getLand Mark Field Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getLandMarkField() throws Throwable {
        String landMarkValue = getAttributeByValue(CRLocationsPage.txtLandMark, "LandMark Field Value");
        return landMarkValue;
    }

    /**
     * param ::
     * return ::int
     * throws :: throwable
     * methodName :: getNumberOfRecordsWithWildCardSearch
     * description ::To get Number OfRecords WithWild CardSearch
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public int getNumberOfRecordsWithWildCardSearch() throws Throwable {
        int resultsList = getElementsSize(CRLocationsPage.recardListInResultsGrid);
        assertTrue(resultsList != 0, "Found the results For WildCard search" + resultsList);
        return resultsList;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddressLinkAfterLongitudeAndLatitudeVerification
     * description ::To click On Address Link After Longitude And Latitude Verification
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnAddressLinkAfterLongitudeAndLatitudeVerification() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.lnkForAddressVerificationByLatitudeOrLongitude, "Address Link");
        click(CRLocationsPage.lnkForAddressVerificationByLatitudeOrLongitude, "Click on AddressLink");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: addressVerificationBasedOnLongitudeAndLatitude
     * description :: This is for address Verification Based On Longitude And Latitude
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void addressVerificationBasedOnLongitudeAndLatitude(String latitude, String longitude) throws Throwable {
        enterLatitude(latitude);
        enterLongitude(longitude);
        clickOnVerifyItButton();

    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getLogitudeValue
     * description :: Retriving the Logitude value from field
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getLongitudeValue() throws Throwable {

        String longitudeValue = getAttributeByValue(CRLocationsPage.txtLongitude, "longitude locator");
        return longitudeValue;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 29-Dec-2017
     * author :: Sachin
     */

    public void validateComentsInCommentPopUp(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Column data");
        if (tableColumnData != null) {
            boolean commentDoesNotExist = true;
            // looping through all the comments in Comments window and coming out if the expected comment is found.
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                //assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in Comment PopUp window");
                if (existsVal) {
                    assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in Comment PopUp window");
                    commentDoesNotExist = false;
                    break;
                }
            }
            if (commentDoesNotExist) {
                assertTrue(false, "Comments entered not displayed in Comment PopUp window");
            }
        }
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getZipCodeValue
     * description ::To get Zip Code Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getZipCodeValue() throws Throwable {
        String zipCodeValue = getAttributeByValue(CRLocationsPage.txtZipCode, "Zip Code ");
        return zipCodeValue;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyZipCodeField
     * description ::To verify Zip Code Field
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyZipCodeField() throws Throwable {
        String zipCode = getZipCodeValue();
        boolean zipCodeValue = !zipCode.isEmpty();
        assertTrue(zipCodeValue, "Verified the Zip Code with returned Value & Zip Code is populated");
        return zipCodeValue;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyAddressVerifiedBtn
     * description ::To verify "AddressVerified" Button
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyAddressVerifiedBtn() throws Throwable {
        boolean addressVerified = isVisibleOnly(CRLocationsPage.addressVerifiedBtn, "Langitude/Latitude Verified On The Screen");
        assertTrue(addressVerified, "Langitude/Latitude Verified On The Screen");
        return addressVerified;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: pickPointFieldVerification
     * description ::To Verify pick Point Field
     * date :: 02-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public boolean veryfyPickUpPoints() throws Throwable {

        String pickupPoint = getPickOupPointsFromdropDown();
        boolean pickUpPointsValue = !pickupPoint.isEmpty();
        assertTrue(pickUpPointsValue, "Verified the pick up points & PickUp Points are populated in the drop down");
        return pickUpPointsValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPickOupPointsFromdroupDown
     * description ::To get PickOup Points From droupDown
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getPickOupPointsFromdropDown() throws Throwable {

        String pickUpPointsValue = getAttributeByValue(CRLocationsPage.txtBoxPickUpPoint, "Pick Up Points ");
        return pickUpPointsValue;

    }

    /**
     * param ::String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLandMarkFieldForPointOfInterest
     * description ::To verify Land MarkField For PointOfInterest
     * date :: 02-Jan-2018
     * author :: Lakshmi Prasanna
     */


    public boolean verifyLandMarkFieldForPointOfInterest(String pointOfInterest) throws Throwable {
        String landMark = getLandMarkField();
        boolean landMarkValue = !landMark.isEmpty();
        assertTrue(landMarkValue, "Land Mark is Populated ,populated Land Mark is    " + landMark);
        return landMarkValue;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLongitude
     * description :: To verify Longitude
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public boolean verifyLongitude() throws Throwable {
        String longitude = getLongitudeValue();
        boolean longitudeValue = !longitude.isEmpty();
        assertTrue(longitudeValue, "Longitude  is Populated         " + longitude);
        return longitudeValue;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyBlockRange
     * description :: To verify BlockRange is populated or not
     * date :: 3-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public boolean verifyBlockRange() throws Throwable {
        String blockRange = getBlockDetails();
        boolean blockRangeNullCheck = !blockRange.isEmpty();
        assertTrue(blockRangeNullCheck, "Block Range OR Street Number is Populated   " + blockRange);
        return blockRangeNullCheck;
    }

    /**
     * param :: S
     * return ::String
     * throws :: throwable
     * methodName :: getBlockRange
     * description :: To get Block Range
     * date :: 2-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public String getBlockDetails() throws Throwable {
        String blockDetails = getAttributeByValue(CRLocationsPage.txtStreetNumber, "Block Range ");
        return blockDetails;
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: varifyCommentBoxExists
     * description :: This method validates the comments box exists or not
     * date :: 3-Jan-2017
     * author :: Sachin
     */

    public boolean verifyCommentBoxExists() throws Throwable {

        boolean commentBox = isVisibleOnly(CRLocationsPage.txtCallComments, "Comment Box");
        assertTrue(commentBox, "Comments Box exists");
        return commentBox;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCallComments
     * description :: To get Call Comments
     * date :: 3-Jan-2018
     * author :: Sachin
     */
    public String getCallComments() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtCallComments, "Call comments");
        String comments = getText(CRLocationsPage.txtCallComments, "Call comments");
        return comments;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: validateCommentsErrorMessage
     * description :: This function validates if error message is displayed or not
     * date :: 3-Jan-2018
     * author :: Sachin
     */
    public boolean validateCommentsErrorMessage(String expComments, String actComments) throws Throwable {
        boolean value = expComments.equalsIgnoreCase(actComments);
        assertTrue(value, "Error messsage not displays:");
        return value;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCommentsCountFromCommentsButton
     * description :: To get Comments Count From Comments Button
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getCommentsCountFromCommentsButton() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.btnComments, "Comments Button");
        String commentsCount = getText(CRLocationsPage.btnComments, "Comments Button");
        return commentsCount;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: VerifyCallReceivesPacesetterCode
     * description :: This function validates comments before and after adding Comments
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void VerifyCallReceivesPacesetterCode(String initialValue, String finalValue) throws Throwable {
    	assertTrue(initialValue != finalValue, "Call receives a pacesetter code");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNonMandatoryFieldsInLocations
     * description :: enterNonMandatoryFieldsInLocations
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterNonMandatoryFieldsInLocations(String landMark, String firstStreetAddress, String NorthCrossStreet, String SouthCrossStreet, String zipCode) throws Throwable {
        click(CRLocationsPage.txtStreetNumber, "First Street Address ");
        type(CRLocationsPage.txtStreetNumber, firstStreetAddress, "First Street Address");
        click(CRLocationsPage.txtFirstCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtFirstCrossstreet, NorthCrossStreet, "North Cross Steet");
        click(CRLocationsPage.txtSecondCrossstreet, "South Cross Street");
        type(CRLocationsPage.txtSecondCrossstreet, SouthCrossStreet, "South Cross Steet");
        click(CRLocationsPage.txtZipCode, "Zip Code");
        type(CRLocationsPage.txtZipCode, zipCode, "Zip Code");
        click(CRLocationsPage.txtLandMark, "LandMark");
        type(CRLocationsPage.txtLandMark, landMark, "Land Mark");
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickOnLocationCodeDropDown
     *  * description :: To click On Location CodeDropDown
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Chandra
     *  
     */
    public void clickOnLocationCodeDropDown() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.lnkClickOnLocationCode, "Click On Location DropDown");
        click(CRLocationsPage.lnkClickOnLocationCode, "Click on Location Code Dropdown");
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickOnCallBox
     *  * description :: To click On CallBox
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Chandra
     *  
     */
    public void clickOnCallBox() throws Throwable {
        click(CRLocationsPage.txtCallBox, "Tabbed out");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterBlockRange
     *  * description :: To enter Street Number(BlockRange)
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Lakshmi Prasanna
     *  
     */
    public void enterBlockRange(String streetNumber) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtStreetNumber, "StreetNumber");
        click(CRLocationsPage.txtStreetNumber, "StreetNumber");
        type(CRLocationsPage.txtStreetNumber, streetNumber, "StreetNumber");
    }
    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterSouthCrossStreetValue
     *  * description :: To enter SouthCross Street Value
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Lakshmi Prasanna
     *  
     */
    public void enterSouthCrossStreetValue(String southCrossStreet) throws Throwable {
        type(CRLocationsPage.txtSecondCrossstreet, southCrossStreet, "South Cross Street");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterZipCode
     * description :: To Enter ZipCode
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterZipCode(String zipCode) throws Throwable {
        String zipcode = getText(CRLocationsPage.txtZipCode,"Zip Code Value");
        if (zipcode.isEmpty()){
            type(CRLocationsPage.txtZipCode, zipCode, "Zip Code");
        }

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNorthCrossstreetValue
     * description :: To enter North Crossstreet Value
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterNorthCrossstreetValue(String northCrossStreet) throws Throwable {
        click(CRLocationsPage.txtFirstCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtFirstCrossstreet, northCrossStreet, "North Cross Street");

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectBreakDownLocationandCode
     * description :: To select BreakDownLocationCode
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void selectBreakDownLocationandCode(String breakDownLocationCode) throws Throwable {
        clickonBrkdownLocLink();
        brkdownLocationCode(breakDownLocationCode);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBreakDownLocationandCode
     * description :: To enter BreakDownLocation details and LocationCode
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterBreakDownLocationandCode(String breakDownAddress, String breakDownLocationCode) throws Throwable {
        enterTxtinBrkDowLocSrch(breakDownAddress);
        brkDowLocSrchBtn();
        brkdowLocAddrLink();
        brkdownLocationCode(breakDownLocationCode);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getLocationCode
     * description :: To get Location Code
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getLocationCode() throws Throwable {
        String locationCode = getAttributeByValue(CRLocationsPage.dropBoxBrkDownLocationCode, "LocationCode");
        return locationCode;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCrossStreetInLocations
     * description :: To enter CrossStreet In Locations
     * date :: 17-Jan-2018
     * author :: Abhiram
     */
    public void enterCrossStreetInLocations(String NorthCrossStreet, String SouthCrossStreet) throws Throwable {

        click(CRLocationsPage.txtFirstCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtFirstCrossstreet, NorthCrossStreet, "North Cross Steet");
        click(CRLocationsPage.txtSecondCrossstreet, "South Cross Street");
        type(CRLocationsPage.txtSecondCrossstreet, SouthCrossStreet, "South Cross Steet");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLandmarkInLocations
     * description :: To enter Landmark In Locations
     * date :: 17-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterLandmarkInLocations(String landMark) throws Throwable {

        click(CRLocationsPage.txtLandMark, "LandMark");
        type(CRLocationsPage.txtLandMark, landMark, "Land Mark");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnlocationNameLink
     * description :: getText And Click On locationNameLink
     * retrivedTime :: 16-Jan-2017
     * author :: Ravi
     */
    public void getTextAndClickOnlocationNameLink() throws Throwable {
        getText(CRLocationsPage.locationNameLink, "get text of location");
        click(CRLocationsPage.locationNameLink, "get text of location");
    }

    /**
     *  param :: NA
     *  return ::boolean
     *  throws :: throwable
     *  methodName :: verifyLocationAvailable
     *  description :: To verify Location Availability
     *  retrivedTime :: 16-Jan-2017
     *  author :: Abhiram
     */
    public boolean verifyLocationAvailable() throws Throwable {
        boolean locationAvailable = isVisibleOnly(CRLocationsPage.linkBrkDownLocAddr, "Existing Address are Not Visible");
        return locationAvailable;

    }

    /**
     *  param :: NA
     *  return ::void
     *  throws :: throwable
     *  methodName :: clickOnCityCodeDropDown
     *  description ::To click On City Code DropDown
     *  retrivedTime :: 19-Jan-2017
     *  author :: Abhiram
     */
    public void clickOnCityCodeDropDown() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownCityCode, "Click On state DropDown");
        click(CRLocationsPage.dropBoxBrkDownCityCode, "Click on state Code Dropdown");

    }

    /**
     * * param :: String inputs
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterStreetAddressNumber
     * * description :: To enter Street AddressNumber
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterStreetAddressNumber(String streetNumber) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtStreetNumber, "StreetNumber");
        type(CRLocationsPage.txtStreetNumber, streetNumber, "Successfully Enter StreetNumber");
    }

    /**
     *  param :: NA
     *  return ::void
     *  throws :: throwable
     *  methodName :: enterStreetAddress
     *  description ::To enter StreetAddress
     *  retrivedTime :: 20-Jan-2018
     *  author :: Abhiram 
     */
    public void enterStreetAddress(String streetAddress) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtStreetAddressInput, "Street Address");
        type(CRLocationsPage.txtStreetAddressInput, streetAddress, "Successfully Enter Street Address");
    }

    /**
     *  param :: NA
     *  return ::void
     *  throws :: throwable
     *  methodName :: enterNorthCrossStreet
     *  description ::To enter NorthCrossStreet
     *  retrivedTime :: 20-Jan-2018
     *  author :: Abhiram 
     */
    public void enterNorthCrossStreet(String NorthCrossStreet) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtFirstCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtFirstCrossstreet, NorthCrossStreet, "Successfully Enter North Cross Street");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterSouthCrossStreet
     * * description ::To enter SouthCrossStreet
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterSouthCrossStreet(String SouthCrossStreet) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtSecondCrossstreet, "South Cross Street");
        type(CRLocationsPage.txtSecondCrossstreet, SouthCrossStreet, "Successfully Enter South Cross Street");
    }


    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationCity
     * * description :: TO enter LocationCity
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationCity(String locationCity) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocCity, "Location City");
        type(CRLocationsPage.txtLocCity, locationCity, "Successfully Enter Location City");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationState
     * * description ::TO enter LocationState
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationState(String locationState) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocState, "Location State");
        type(CRLocationsPage.txtLocState, locationState, "Successfully Enter Location State");
    }

    /**
     *  param :: String inputs
     *  return ::void
     *  throws :: throwable
     *  methodName :: enterLocationZip
     *  description ::TO enter Location Zip
     *  retrivedTime :: 20-Jan-2018
     *  author :: Abhiram 
     */
    public void enterLocationZip(String locationZip) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtZipCode, "Location Zip");
        type(CRLocationsPage.txtZipCode, locationZip, "Successfully Enter Location Zip");
    }

    /**
     * * param :: String inputs
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationLandmark
     * * description ::To enter Location Landmark
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationLandmark(String locationLandmark) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLandMark, "Location Landmark");
        type(CRLocationsPage.txtLandMark, locationLandmark, "Successfully Enter Location Landmark");
    }

    /**
     *  param :: NA
     *  return ::void
     *  throws :: throwable
     *  methodName :: clickOnStateCodeDropDown
     *  description ::To click On StateCode DropDown
     *  retrivedTime :: 20-Jan-2018
     *  author :: Abhiram
     */
    public void clickOnStateCodeDropDown() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownStateCode, "Click On state DropDown");
        click(CRLocationsPage.dropBoxBrkDownStateCode, "Click on state Code Dropdown");

    }

    /**
     * param :: S
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAtlantaExistingBreakDwnLoc
     * description ::To click On AtlantaExisting BreakDwnLoc
     * date :: 20-Jan-2018
     * author :: Lakshmi Prasanna
     */

    public void clickOnAtlantaExistingBreakDwnLoc() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Click on Atlanta Breakdown Location");
        click(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Click on Atlanta Breakdown Location");
    }

    /**
     * * param :: NA
     * * return ::boolean
     * * throws :: throwable
     * * methodName :: verifyAtlantaLocationAvailable
     * * description :: To verify AtlantaLocation Available OR Not
     * * retrivedTime :: 16-Jan-2017
     * * author :: Abhiram
     */
    public boolean verifyAtlantaLocationAvailable() throws Throwable {

        boolean atlantaLocationAvailable = isVisibleOnly(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Existing Atlanta Address are Not Visible");
        return atlantaLocationAvailable;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsTypeInCommentWindow
     * description :: This method validates the comments  In Comments Window
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public void validateComentsTypeInCommentWindow(String comments, String ColumnType) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Type");
        tableCommentTypeCol = getWebElementList(CRLocationsPage.lblCommentTypeCommentWindow, "Comments Type");
        String commentType = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentType = tableCommentTypeCol.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    boolean existsValType = commentType.equalsIgnoreCase(ColumnType);
                    assertTrue(commentType.equalsIgnoreCase(ColumnType), "Expected comment type is " + ColumnType + "Actual comment type is "+commentType);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments has type" + commentType);
            }
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsNotAvailableInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 21-Dec-2017
     * author :: Sachin
     */

    public void validateComentsNotAvailableInCommentPopUp(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Column data");
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                //assertTrue(existsVal, "Comments entered displayed in Comment PopUp window");
                if (existsVal) {
                    assertTrue(existsVal, "Comments entered displayed in Comment PopUp window");
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(flow, "Hidden comments " + comments + " not displayed in Comment PopUp window after changing the Status to Hidden.");
            }
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsStatusInCommentWindow
     * description :: This method validates the comments status in Comments Window
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public void validateComentsStatusInCommentWindow(String comments, String ColumnStatus) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentStatus = getWebElementList(CRLocationsPage.lblStatusCommentWindow, "Comments Status");
        String commentStatus = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentStatus = tableCommentStatus.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    boolean existsValType = commentStatus.equalsIgnoreCase(ColumnStatus);
                    assertTrue(ColumnStatus.equalsIgnoreCase(commentStatus), "Expected Status is " + ColumnStatus + " Actual status is"+commentStatus );
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Expected Status is " + ColumnStatus + " Actual status is"+commentStatus );
            }
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsDateTimeCommentWindow
     * description :: This method validates the Coments DateTime In CommentWindow
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void validateComentsDateTimeCommentWindow(String comments, String ColumnTimeStamp) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentTimeStamp = getWebElementList(CRLocationsPage.lblDateTimeCommentWindow, "Comments Date Time");
        String commentTimeStamp = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentTimeStamp = tableCommentTimeStamp.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    boolean existsValType = commentTimeStamp.equalsIgnoreCase(commentTimeStamp);
                    assertTrue(ColumnTimeStamp.equalsIgnoreCase(commentTimeStamp), "Expected Date Time is " + ColumnTimeStamp + " Actual Date Time is "+commentTimeStamp);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments has Date Time" + ColumnTimeStamp);
            }
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsUserCommentWindow
     * description :: This method validate User Coments In CommentWindow
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void validateComentsUserCommentWindow(String comments, String ColumnUser) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentUser = getWebElementList(CRLocationsPage.lblUserCommentWindow, "Comments User");
        String commentUser = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentUser = tableCommentUser.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    String commentUser1 = commentUser.replaceAll("[^\\w\\d\\s]", " ");
                    String ColumnUser1 = ColumnUser.replaceAll("[^\\w\\d\\s]", " ");
                    assertTrue((commentUser1.equalsIgnoreCase(ColumnUser1)),"Expected User Name is " + ColumnUser + " Actual user name is "+ColumnUser1);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(flow, "Comments has User" + commentUser);
            }
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateLocationCommentWindow
     * description :: This method validats the LocationCommentWindow
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void validateLocationCommentWindow(String comments, String ColumnLocation) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentLocation = getWebElementList(CRLocationsPage.lblLocationCommentWindow, "Comments Location");
        String commentLocation = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentLocation = tableCommentLocation.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    assertTrue(ColumnLocation.equalsIgnoreCase(commentLocation), "Expected Location is " + ColumnLocation + " Actual location is "+commentLocation);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(flow, "Expected Location is " + ColumnLocation + " Actual location is "+commentLocation);
            }
        }
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: GetComentTypeFromommentWindow
     * description :: To Get ComentType From CommentWindow
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public String GetComentTypeFromommentWindow(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments");
        tableCommentTypeCol = getWebElementList(CRLocationsPage.lblCommentTypeCommentWindow, "Comments Type");
        String commentType = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    commentType = tableCommentTypeCol.get(i).getText().toString().trim();
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments not available in comment window " + comments);
            }
        }
        return commentType;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: GetDateTimeFromCommentWindow
     * description :: To Get Date Time From CommentWindow
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public String GetDateTimeFromCommentWindow(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentTimeStamp = getWebElementList(CRLocationsPage.lblDateTimeCommentWindow, "Comments Date Time");
        String commentTimeStamp = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    commentTimeStamp = tableCommentTimeStamp.get(i).getText().toString().trim();
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments not available in comment window" + comments);
            }
        }
        return commentTimeStamp;
    }

    /**
     * param :: String inputs
     * return ::boolean
     * throws :: throwable
     * methodName :: validateComentsTypeInCommentWindow
     * description :: This method validate ComentsType In CommentWindow
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public boolean validateComentsTypeInCommentWindow(String ColumnType) throws Throwable {
        tableCommentTypeCol = getWebElementList(CRLocationsPage.lblCommentTypeCommentWindow, "Comments Type");
        String commentType;
        boolean TypeVal = false;
        if (tableCommentTypeCol != null) {
            boolean flow = true;
            for (int i = 0; i <= tableCommentTypeCol.size() - 1; i++) {

                commentType = tableCommentTypeCol.get(i).getText().toString().trim();

                boolean typeExist = commentType.equalsIgnoreCase(ColumnType);
                if (typeExist) {
                    TypeVal = true;
                    break;
                }
            }
        }
        return TypeVal;
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryAndEnterLocationDetails
     * description ::To click On ManualEntry And Enter LocationDetails
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void clickOnManualEntryAndEnterLocationDetails(String LandMark, String Address, String crossStreet, String secondCrossStreet , String Zip, String StreetAddress, String City, String State, String LocationCode) throws Throwable {
    	clickOnManualEntryLinkInLocation();
        enterNonMandatoryFieldsInLocations(LandMark, Address, crossStreet, secondCrossStreet, Zip);
        enterAndSaveLocationMandatoryFields(StreetAddress, City, State, LocationCode);
        enterBKDownLocCode(LocationCode);
        Thread.sleep(2000);
        clickOnLocationCodeDropDown();
        Thread.sleep(5000);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: breakdownSearchAndBreakdownType
     * description ::To breakdownSearch And to enter BreakdownType
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void breakdownSearchAndBreakdownType(String BreakdownSearch, String BreakdownType, String crossStreet, String secondCrossStreet, String LandMark, String Address) throws Throwable {
        //breakdownLocTabSel();
        if(((BreakdownSearch.equalsIgnoreCase("Existing Address")) && (BreakdownType.equalsIgnoreCase("Cross st")))||
                ((BreakdownSearch.equalsIgnoreCase("Existing Address")) && (BreakdownType.equalsIgnoreCase("Landmark")))||
                ((BreakdownSearch.equalsIgnoreCase("Existing Address")) && (BreakdownType.equalsIgnoreCase("Full Address"))))
        {
            String AddressBreakDown[] = Address.split("#");
            //Check for location Available
            boolean noAddressAvailable = verifyLocationAvailable();
            //Check for Atlanta location Available
            boolean noAtlantaLocationAvailable = verifyAtlantaLocationAvailable();
            if(noAddressAvailable && noAtlantaLocationAvailable )
            {
                clickOnAtlantaExistingBreakDwnLoc();
                String northCrossStreetValue = getFirstCrossStreetsValue();
                if(northCrossStreetValue.isEmpty())
                {
                    enterNorthCrossStreet(crossStreet);
                }
                String southCrossStreetValue = getSecondCrossStreetsValue();
                if(southCrossStreetValue.isEmpty())
                {
                    enterSouthCrossStreet(secondCrossStreet);
                }
                String landmarkValue = getLandMarkField();
                if(landmarkValue.isEmpty())
                {
                    enterLocationLandmark(LandMark);
                }
                String locationCodeValue = getLocationCode();
                if(locationCodeValue.isEmpty())
                {
                    enterBKDownLocCode(AddressBreakDown[5]);
                }
               boolean locationVerified = verifyCompleteCheckLocation();
                if(!locationVerified)
                {
                    enterBreakDownLocationManually(Address);
            }
            }
            else
            {
                enterBreakDownLocationManually(Address);

            }
        }

        else if(((BreakdownSearch.equalsIgnoreCase("Manual")) && (BreakdownType.equalsIgnoreCase("Full Address"))) ||
                ((BreakdownSearch.equalsIgnoreCase("Manual")) && (BreakdownType.equalsIgnoreCase("Cross st")))||
                ((BreakdownSearch.equalsIgnoreCase("Manual")) && (BreakdownType.equalsIgnoreCase("Landmark"))))
        {
            enterBreakDownLocationManually(Address);
        }

        else if(((BreakdownSearch.equalsIgnoreCase("Omnibar")) && (BreakdownType.equalsIgnoreCase("Full Address"))) ||
                ((BreakdownSearch.equalsIgnoreCase("Omnibar")) && (BreakdownType.equalsIgnoreCase("Cross st")))||
                ((BreakdownSearch.equalsIgnoreCase("Omnibar")) && (BreakdownType.equalsIgnoreCase("Landmark"))))
        {
            enterBreakDownAddressOmniBarSearch(Address);

        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetNumber
     * description ::To enter StreetNumber
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void enterStreetNumber(String StreetNumber) throws Throwable {
    	click(CRLocationsPage.txtStreetNumber, "Street NUmber ");
        type(CRLocationsPage.txtStreetNumber, StreetNumber, "Street Number");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBreakDownAddressOmniBarSearch
     * description ::To search BreakDownAddress from OmniBar Search
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void enterBreakDownAddressOmniBarSearch(String OmniBarAddress) throws Throwable {
    	String OmniAddress[] = OmniBarAddress.split("#");
    	
    	enterTxtinBrkDowLocSrch(OmniAddress[0]);
        brkDowLocSrchBtn();
        Thread.sleep(5000);
        getNumberOfRecordsInResultsGrid();
        clickOnLocationResultsLink();
        acceptAddressDifferenceAlert();
        verifyAddressVerifiedBtn();
        String locationCodeValue = getLocationCode();
        if(locationCodeValue.isEmpty())
        {
            enterBKDownLocCode(OmniAddress[1]);
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBreakDownLocationMandatoryFields
     * description ::To enter BreakDownLocation MandatoryFields
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void enterBreakDownLocationMandatoryFields(String Address) throws Throwable {
    	String AddressVal[] =  Address.split("#");
    	
    	Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterStreetNumber(AddressVal[0]);
        enterBKDownStreetAddress(AddressVal[1]);
        enterBKDownCityLocation(AddressVal[2]);
        enterBKDownState(AddressVal[3]);
        enterZipCode(AddressVal[4]);
        verifyAddressVerifiedBtn();
        enterBKDownLocCode(AddressVal[5]);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterBreakDownLocationManually
     * description ::To enter BreakDownLocation Manually
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public void enterBreakDownLocationManually(String Address) throws Throwable {
    	clickOnManualEntryLinkInLocation();
    	enterBreakDownLocationMandatoryFields(Address);
    }
/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCompleteCheckLocation
     * description ::To verify Complete CheckLocation
     * date :: 20-Jan -2018
     * author :: Sachin
     */
    public boolean verifyCompleteCheckLocation()  throws Throwable {
        boolean locationVerified=false;
        if (!(isVisibleOnly(CRLocationsPage.verifyLocationsCompleteCheck, "Location Complete Check"))) {
            reporter.failureReport("Verify Location Complete Check" , "All Mandatory Fields are not entered", driver);
        }
        else
        {
            locationVerified = true;
    }
        return locationVerified;
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: GetComentsFromCommentWindow
     * description :: This method gets the comments from first row of comment window
     * date :: 16-Feb -2018
     * author :: Sachin
     */

    public String GetComentsFromCommentWindow() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtCommentsCol, "Comments");
        String comment = getText(CRLocationsPage.txtCommentsCol, "Comments Type");
        return comment;
    }

    public String getDateTimeInCommoentsPopupForFirstRecord() throws Throwable{
        String firstRowDateTimeAfterStateChange = getText(CRLocationsPage.selectDateTimeInCommentsPopup, "New Message Date Time");
    return firstRowDateTimeAfterStateChange;
    }
    public String getDateTimeInCommoentsPopupForSecondRecord() throws Throwable {
        String secondRowDateTimeAfterStateChange = getText(CRLocationsPage.selectDateTimeInCommentsPopupEvenRow, "Old Message DateTIme");
        return secondRowDateTimeAfterStateChange;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyLatitudeLongitude
     * description :: This method verifies the latitude and longitude
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyLatitudeLongitude(String Latitude, String Longitude) throws Throwable {
    	String latLongVerify = "";
    	boolean latitudeVerify = Latitude.equalsIgnoreCase(getLatitudeValue());
    	boolean longitudeVerify = Longitude.equalsIgnoreCase(getLongitudeValue());
    	//assertTrue(Latitude.equalsIgnoreCase(getLatitudeValue()), "Verified latitue value :"+getLatitudeValue());
    	//assertTrue(Longitude.equalsIgnoreCase(getLongitudeValue()),"Verified latitue value :"+getLongitudeValue());
    	if (latitudeVerify && longitudeVerify ) {
    		latLongVerify = "verified"; 
    		reporter.SuccessReport("verify Latitude and Longitude", "Latitude and Longitude are verified. Latitude :"+getLatitudeValue() + "Longitude : "+getLongitudeValue());
    	}else{
    		latLongVerify = "Latitude and Longitude are different";
    		reporter.failureReport("verify Latitude and Longitude", "Latitude and Longitude are not same. Latitude :"+getLatitudeValue() + "Longitude : "+getLongitudeValue());
    	}    	
    	return latLongVerify;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyLatitudeLongitude
     * description :: This method verifies the latitude and longitude
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyLatitudeLongitudeisPopulated() throws Throwable {
    	String latLongVerify = "";
    	boolean latitudeVerify = (!getLatitudeValue().isEmpty());
    	boolean longitudeVerify = (!getLongitudeValue().isEmpty());
    	//assertTrue(Latitude.equalsIgnoreCase(getLatitudeValue()), "Verified latitue value :"+getLatitudeValue());
    	//assertTrue(Longitude.equalsIgnoreCase(getLongitudeValue()),"Verified latitue value :"+getLongitudeValue());
    	if (latitudeVerify && longitudeVerify ) {
    		latLongVerify = "verified"; 
    		reporter.SuccessReport("verify Latitude and Longitude", "Latitude and Longitude are verified. Latitude :"+getLatitudeValue() + "Longitude : "+getLongitudeValue());
    	}else{
    		latLongVerify = "Latitude and Longitude are different";
    		reporter.failureReport("verify Latitude and Longitude", "Latitude and Longitude are not same. Latitude :"+getLatitudeValue() + "Longitude : "+getLongitudeValue());
    	}    	
    	return latLongVerify;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyStreetDetails
     * description :: This method verifies the entered street address with  address returned from server
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyStreetDetails(String Address) throws Throwable {
    	String streetVerify = "";
    	String enteredStreet = "";
    	//Splitting the address into street, city, state and breaklocation code
    	String inputStreetDet[] = Address.split(",");
    	//splitting street into block and street details
    	String blockDetails[] = inputStreetDet[0].split(" ");
    	//creating only street address removing block number
    	for (int j = 1; j < blockDetails.length; j++ ){
    		enteredStreet = enteredStreet + " " + blockDetails[j];
    	}
    	boolean verifyBlock = blockDetails[0].equalsIgnoreCase(getBlockDetails());
    	assertTrue(blockDetails[0].equalsIgnoreCase(getBlockDetails()),"verify block details:"+getBlockDetails());
    	// updating street name to changes formed by google
    	String newStreetName = updateStreetName(enteredStreet);
    	String streetRet = getBKDownStreetAddress();
    	boolean verifyStreet = newStreetName.equalsIgnoreCase(streetRet);
    	assertTrue(newStreetName.equalsIgnoreCase(streetRet), "verify Street Details:"+getBKDownStreetAddress());
    	if (verifyBlock && verifyStreet) {
    		streetVerify = "verified";
    		reporter.SuccessReport("verify Block and Street Details", "Block and Street are verified. Block :"+getBlockDetails() + "StreetAddress : "+getBKDownStreetAddress());
    	}else{
    		reporter.failureReport("verify Block and Street Details", "Block and Street are not same. Block :"+getBlockDetails() + "StreetAddress : "+getBKDownStreetAddress());
    	}	
    	return streetVerify;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: updateStreetName
     * description :: This method updates the entered street name to compare with the address returned from server
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String updateStreetName(String streetName) throws Throwable {
    	String newStreet = "";
    	String streetBreak[] = streetName.split(" ");
    	for (int i =0;i<streetBreak.length;i++) {
    		switch (streetBreak[i]) {
    		case "drive" : 
    			streetBreak[i] = "DR";
    			break;
    		case "street":
    			streetBreak[i] = "ST";
    			break;
    		case "avenue":
    			streetBreak[i] = "AVE";
    			break;
    		default :     			
    			break;
    		} 
    		newStreet = newStreet + " " + streetBreak[i];
    	}
    	
    	
    	return newStreet.toUpperCase().trim();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyCity
     * description :: This method verifies the entered city address with  address returned from server
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyCity(String Address) throws Throwable{
    	String verifyCity = "";
    	String inputCityDet[] = Address.split(",");
    	String enteredCity = inputCityDet[1].trim();
    	boolean verifycity = enteredCity.equalsIgnoreCase(getCityValue());
    	//assertTrue(enteredCity.equalsIgnoreCase(getCityValue().trim()), "verify City");
    	if (verifycity) {
    		verifyCity= "verified";	
    		reporter.SuccessReport("verify City", "City is verified :"+getCityValue().trim());
    	}else{
    		reporter.failureReport("verify City", "City is different :"+getCityValue().trim());
    	}
    	return verifyCity;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyState
     * description :: This method verifies the entered state address with  address returned from server
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyState(String Address) throws Throwable{
    	String verifyState = "";
    	String inputStateDet[] = Address.split(",");
    	String inputStateCodeDet[] = inputStateDet[2].split("#");
    	String enteredState = inputStateCodeDet[0].trim();    	
    	boolean verifystate = enteredState.equalsIgnoreCase(getStateValue());
    	//assertTrue(enteredState.equalsIgnoreCase(getStateValue().trim()),"verify state");
    	if (verifystate) {
    		verifyState= "verified";	
    		reporter.SuccessReport("verify State", "State is verified :"+getStateValue().trim());
    	}else{
    		reporter.failureReport("verify State", "State is different :"+getStateValue().trim());	
    	}    		
    	return verifyState;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyFirstCrossStreet
     * description :: This method verifies the first cross street address that is returned from server
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyFirstCrossStreet(String CrossStreet) throws Throwable {
    	String verifyFirstStreet = "";
    	if (!CrossStreet.isEmpty()) {    		
        	boolean verifyfirststreet = CrossStreet.equalsIgnoreCase(getFirstCrossStreetsValue().trim());
        	if (verifyfirststreet) {
        		verifyFirstStreet= "verified";	
        		reporter.SuccessReport("verify North Cross Street", "North Cross Street is verified :"+getFirstCrossStreetsValue().trim());
        	}else{
        		reporter.failureReport("verify North Cross Street", "North Cross Street is not verified :"+getFirstCrossStreetsValue().trim());
        	}
    	}
    	
    	return verifyFirstStreet;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifySecondCrossStreet
     * description :: This method verifies the second cross street address that is returned from server
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifySecondCrossStreet(String CrossStreet) throws Throwable {
    	String verifySecondCrossStreet = "";
    	if (!CrossStreet.isEmpty()) {    		
        	boolean verifySecondstreet = CrossStreet.equalsIgnoreCase(getSecondCrossStreetsValue());
        	if (verifySecondstreet) {
        		verifySecondCrossStreet= "verified";	
        		reporter.SuccessReport("verify Second Cross Street", "Second Cross Street is verified :"+getSecondCrossStreetsValue().trim());
        	}else{
        		reporter.failureReport("verify Second Cross Street", "Second Cross Street is not verified :"+getSecondCrossStreetsValue().trim());
        	}
    	}
    	
    	return verifySecondCrossStreet;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyDropdownsinPickupPoint
     * description :: This method verifies the dropdowns in pickup point 
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public String verifyDropdownsinPickupPoint() throws Throwable{
    	String pickupPointDropdown = "";
    	click(CRLocationsPage.viewOptionsinPickupPoint,"PickupPoint Drop down");
    	waitForVisibilityOfElement(CRLocationsPage.pickupPointMenu, "Pickup Point Menu");
    	List<WebElement> ListofElements = getWebElementList(CRLocationsPage.pickupPointMenu, "Pickup Point Menu");
    	if (ListofElements.size()>0){
    		for (WebElement element : ListofElements) {
    			reporter.SuccessReport("verify Pick up Point List of Elements", "Pick up Point List of elements:"+element.getText());
    		}    		
    	}else{
    		reporter.failureReport("verify Pick up Point List of Elements", "Pick up Point List of elements is not retrieved");
    	}
    	//pickupPointDropdown = getAttributeByValue(CRLocationsPage.pickupPointMenu, "Pickup Point Menu");
    	return pickupPointDropdown;
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyandClickonHomeDestination
     * description :: This method verifies and clicks on Home Destination Icon displayed in Locations Tab
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public boolean verifyandClickonHomeDestination() throws Throwable {
    	boolean homeDestination = false;
    	waitForVisibilityOfElement(CRLocationsPage.homeDestIcon, "Home Destination Icon");
    	if (isElementPresent(CRLocationsPage.homeDestIcon, "Home Destination Icon")){
    		click(CRLocationsPage.homeDestIcon, "Home Destination Icon");
    		homeDestination = true;
    	}
    	return homeDestination;
    }
    
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyandClickonRecentDestination
     * description :: This method verifies and clicks on Recent Destination Icon displayed in Locations Tab
     * date :: 08-March -2018
     * author :: Sri Harish Mukthavi
     */
    public boolean verifyandClickonRecentDestination() throws Throwable {
    	boolean recentDestination = false;
    	waitForVisibilityOfElement(CRLocationsPage.RecentDestIcon, "Recent Destination Icon");
    	if(isElementPresent(CRLocationsPage.RecentDestIcon, "Recent Destination Icon")){	
    		click(CRLocationsPage.RecentDestIcon, "Recent Destination Icon");
    		recentDestination = true;
    	}
    	return recentDestination;
    }
    
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyAddressLookup
     * description :: This method verifies the details populated while doing address lookup
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyAddressLookup(String addressLookup) throws Throwable {
    	enterBreakDownAddressOmniBarSearch(addressLookup);
		verifyStreetDetails(addressLookup);
		verifyCity(addressLookup);
		verifyState(addressLookup);
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyCrossStreetAddress
     * description :: This method verifies the details of cross streets populated while doing address lookup
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyCrossStreetAddress(String addressLookup, String firstCrossStreet, String secondCrossStreet ) throws Throwable {
    	enterBreakDownAddressOmniBarSearch(addressLookup);
		verifyFirstCrossStreet(firstCrossStreet);
		verifySecondCrossStreet(secondCrossStreet);
		verifyCity(addressLookup);
		verifyState(addressLookup);
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyHighwayAddress
     * description :: This method verifies the details of Highway address populated while doing address lookup
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyHighwayAddress(String Address, String FirstCrossStreet) throws Throwable {
    	enterBreakDownAddressOmniBarSearch(Address);
		verifyFirstCrossStreet(FirstCrossStreet);
		verifyCity(Address);
		verifyState(Address);
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyLatLongAddress
     * description :: This method verifies the latitude, longitude, address details after doing manual entry of latitude and longitude
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyLatLongAddress(String latitude, String longitude, String firstCrossStreet, String secondCrossStreet, String Address) throws Throwable {
    	clickOnManualEntryLinkInLocation();
        clickOnClearLocationButton();            
        enterLatitude(latitude);
        enterLongitude(longitude);
        clickOnVerifyItButton();
        clickOnAddressLinkAfterLongitudeAndLatitudeVerification();
        verifyFirstCrossStreet(firstCrossStreet);
        verifySecondCrossStreet(secondCrossStreet);
        verifyCity(Address);
		verifyState(Address);
		verifyLatitudeLongitude(latitude, longitude);  
    } 
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifySpecialCharactersAddress
     * description :: This method verifies the  address details after doing omnibar search with special characters
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifySpecialCharactersAddress(String Address, String firstCrossStreet, String secondCrossStreet, String verifyAddress) throws Throwable {
    	enterBreakDownAddressOmniBarSearch(Address);
		verifyStreetDetails(verifyAddress);
		verifyFirstCrossStreet(firstCrossStreet);
		verifySecondCrossStreet(secondCrossStreet);
		verifyCity(verifyAddress);
		verifyState(verifyAddress);
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyPointsOfInterest
     * description :: This method verifies the  points of interest details after doing omnibar search
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyPointsOfInterest(String Address,String verifyAddress) throws Throwable {
    	enterBreakDownAddressOmniBarSearch(Address);
		verifyLandMarkFieldForPointOfInterest(verifyAddress);
		verifyLatitudeLongitudeisPopulated();
    } 
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyLandmarkAddress
     * description :: This method verifies the  Landmark details after doing omnibar search
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyLandmarkAddress(String Address, String VerifyAddress, String AdditionalAddress) throws Throwable{
    	enterBreakDownAddressOmniBarSearch(Address);
		verifyLandMarkFieldForPointOfInterest(VerifyAddress);
		verifyStreetDetails(AdditionalAddress);
		verifyCity(AdditionalAddress);
		verifyState(AdditionalAddress);
		verifyDropdownsinPickupPoint();
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyManualEntryCrossStreet
     * description :: This method verifies the  manual entry for cross street functionality
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyManualEntryCrossStreet(String firstCrossStreet, String secondCrossStreet, String Address) throws Throwable {
    	clickOnManualEntryLinkInLocation();
		enterCrossStreetInLocations(firstCrossStreet, secondCrossStreet);
		enterBreakDownLocationMandatoryFields(Address);
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyManualEntryLandMark
     * description :: This method verifies the  manual entry for Landmark functionality
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyManualEntryLandMark(String AdditionalAddress, String Address) throws Throwable {
    	clickOnManualEntryLinkInLocation();
		enterLandmarkInLocations(AdditionalAddress);
		enterBreakDownLocationMandatoryFields(Address);
		verifyLatitudeLongitudeisPopulated();
    }
    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyCityAlias
     * description :: This method verifies the  City Alias functionality
     * date :: 09-March -2018
     * author :: Sri Harish Mukthavi
     */
    public void verifyCityAlias(String Address, String VerifyAddress) throws Throwable {
    	enterTxtinBrkDowLocSrch(Address);
		brkDowLocSrchBtn();
        Thread.sleep(5000);
        getNumberOfRecordsInResultsGrid();
        clickOnLocationResultsLink();
        acceptAddressDifferenceAlert();
		verifyCity(VerifyAddress);
		verifyState(VerifyAddress);
    }
    
    public void verifyKnownLocations(String AddittionalAddress, String Address, String firstCrossStreet) throws Throwable {
    	boolean iconPresent = false;
    	if (AddittionalAddress.equalsIgnoreCase("home")) {
			if (verifyandClickonHomeDestination())
				iconPresent = true;
		}else
		{
			if(verifyandClickonRecentDestination())
				iconPresent = true;
		}
    	if (iconPresent) {
    		verifyStreetDetails(Address);    		
    		verifyCity(Address);
    		verifyState(Address);
    		verifyFirstCrossStreet(firstCrossStreet);
    		verifyLatitudeLongitudeisPopulated();
    		verifyAddressVerifiedBtn();	
    	}else{
    		reporter.failureReport("Verify Known Locations", "Member Doesnt Have Known Locations");
    	}
		
    }

    public void ClickOnFirstItemInDropDown(String Name) throws Throwable {
        //waitForVisibilityOfElement(CRLocationsPage.txtCommentsCol, "Comments");
        waitForVisibilityOfElement(CRLocationsPage.ddnFirstItemSelection(Name),""+Name);
        click(CRLocationsPage.ddnFirstItemSelection(Name),""+Name);
    }


}
