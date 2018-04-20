package com.aaa.web.lib;

import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by E001133 on 27-11-2017.
 */
public class CRMemberSearchLib extends LoginLib {
    List<WebElement> callList = null;
    List<WebElement> numberList = null;
    public static String numFromList;

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberCol
     * description :: Getting member number coloum values to compare the results with expected value
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberNumberCol(String memberSearch) throws Throwable {

        String memNum = getText(CRMemberSearchPage.lblMemberNumberColumnValue, "Member number");//Getting the First product
        assertTrue(memNum.contains(memberSearch), memNum + " Given details Search Results are same");
        return memNum;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberCol
     * description :: To click on member number
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberNumClick() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        click(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        Thread.sleep(3000);
        boolean alertCloseVisibility = isVisibleOnly(CRMemberSearchPage.alertClose, "Close Alert");
        if (alertCloseVisibility) {
            mouseDoubleClick(CRMemberSearchPage.alertClose, "Close Alert");
        }
        boolean scriptErrorAvailablity = isVisibleOnly(CRMemberSearchPage.scriptError, "Script Error OKAY button");
        if (scriptErrorAvailablity) {
            click(CRMemberSearchPage.scriptError, "Script error Okay button");
        }


    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblMemberNameColumnValue
     * description :: To get Member name
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public String memberNameCol(String memberSearch) throws Throwable {

        String name = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");//Getting the First product
        assertTrue(name.contains(memberSearch), name + " Given details Search Results are same");
        return name;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: membernameaddressCol
     * description :: Member nameaddress
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void membernameaddressCol(String memberSearch) throws Throwable {

        String name1 = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");//Getting the First product
        String address = getText(CRMemberSearchPage.lblMemberAddressColumnValue, "Address");
        String inputvalues[] = memberSearch.split(", ");
        String nameInput = inputvalues[0].toUpperCase();
        String addressInput = inputvalues[1];
        String nameaddress = name1.concat(address);
        assertTrue(nameaddress.contains(nameInput), nameInput + " :is found in results ");
        assertTrue(nameaddress.contains(addressInput), addressInput + " :is found in results ");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberEmailCol
     * description :: Member Email Col
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberEmailCol(String membersearch) throws Throwable {
        String email = getText(CRMemberSearchPage.lblMemberContactColumnValue, "Email");//Getting the First product
        assertTrue(email.contains(membersearch), email + " Given details Search Results are same");
        return email;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberPhoneCol
     * description :: Member Name Search
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberPhoneCol(String memberSearch) throws Throwable {
        String phone = getText(CRMemberSearchPage.lblMemberContactColumnValue, "Phone");//Getting the First product
        assertTrue(phone.contains(memberSearch), phone + " :is found in results ");
        return phone;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: CurrentCallClose
     * description :: Member Name Search
     * date :: 05-Dec-2017
     * author :: chandu
     */
    //This should be used to handle current calls popup after clicking on the member number details
    public void currentCallClose() throws Throwable {
        Thread.sleep(3000);
        boolean flagCurrentCallClose = isVisibleOnly(CRMemberSearchPage.iconcurrentcallClose, "Current call close");
        if (flagCurrentCallClose) {
            click(CRMemberSearchPage.iconcurrentcallClose, "Current call popup closed");
        }
        boolean flagScriptError = isVisibleOnly(CRMemberSearchPage.scriptError, "Script Error OKAY button");
        if (flagScriptError) {
            click(CRMemberSearchPage.scriptError, "Script error Okay button");
        } else {
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");
        }


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberDetailsVerification
     * description :: memberDetailsVerification
     * date :: 30-Nov-2017
     * author :: chandu
     */
    public String memberFirstNameVerification() throws Throwable {

        String FirstName = getText(CRMemberSearchPage.lblMemberFirstName, "Member First Name");
        assertTrue(FirstName != null, FirstName + " :is the Member First Name");

        return FirstName;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberDetailsVerification
     * description :: memberDetailsVerification
     * date :: 30-Nov-2017
     * author :: chandu
     */
    public String memberLastNameVerification() throws Throwable {

        String lastName = getText(CRMemberSearchPage.lblMemberLastName, "Member Last Name");
        assertTrue(lastName != null, lastName + " :is the Member Last Name");
        return lastName;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberVerification
     * description :: memberNumberVerification
     * date :: 30-Nov-2017
     * author :: chandu
     */
    public String memberNumberVerification() throws Throwable {

        String memberNumber = getText(CRMemberSearchPage.lblMemberNumberTxt, "Member number");
        assertTrue(memberNumber != null, memberNumber + " :is the Member number");
        return memberNumber;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberZipVerification
     * description :: memberZipVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberZipVerification() throws Throwable {

        String zip = getText(CRMemberSearchPage.lblMemberZipCode, "Member zip");
        assertTrue(zip != null, zip + " :is the Member zip");
        return zip;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberCityVerification
     * description :: memberCityVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberCityVerification() throws Throwable {

        String city = getText(CRMemberSearchPage.lblMemberCity, "Member City");
        assertTrue(city != null, city + " :is the Member City");
        return city;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberStateVerification
     * description :: memberStateVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberStateVerification() throws Throwable {

        String state = getText(CRMemberSearchPage.lblMemberState, "Member State");
        assertTrue(state != null, state + " :is the Member State");
        return state;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberSinceVerification
     * description :: memberSinceVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberSinceVerification() throws Throwable {

        String since = getText(CRMemberSearchPage.lblMemberSince, "Member Since");
        assertTrue(since != null, since + " :is the Member Since");
        return since;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberLevelVerification
     * description :: memberLevelVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberLevelVerification() throws Throwable {
        String level = getText(CRMemberSearchPage.lblMemberLevel, "Member level");
        assertTrue(level != null, "<b>" + level + " :is the Member Level");
        return level;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberTypeVerification
     * description :: memberTypeVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberTypeVerification() throws Throwable {

        String type = getText(CRMemberSearchPage.lblMemberType, "Member type");
        assertTrue(type != null, type + " :is the Member type");
        return type;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberExpirationVerification
     * description :: memberExpirationVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberExpirationVerification() throws Throwable {

        String expiration = getText(CRMemberSearchPage.lblMemberExpiration, "Member Expiration");
        assertTrue(expiration != null, expiration + " :is the Member Expiration");
        return expiration;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberStatusVerification
     * description :: memberStatusVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberStatusVerification() throws Throwable {

        String status = getText(CRMemberSearchPage.lblMemberStatus, "Member Status");
        assertTrue(status != null, status + " :is the Member Status");
        return status;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberEmailVerification
     * description :: memberEmailVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberEmailVerification() throws Throwable {

        String email = getAttributeValue(CRMemberSearchPage.txtMemberEmailId, "Member email");
        assertTrue(email != null, email + " :is the Member email");
        return email;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorNotification
     * description :: checkingFor error notification
     * date :: 11-Dec-2017
     * author :: Chandrasekhar
     */
    public boolean errorNotificationPresence() throws Throwable {


        boolean errorNotification = isVisibleOnly(CRMemberSearchPage.errorNotification, "Error Notification");
        assertTrue(errorNotification, "Error Notification appeared");
        return errorNotification;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName ::emptySearchResults
     * description ::This method is to get no record available for member search
     * date :: 11-Dec-2017
     * author :: Chandrasekhar
     */
    public String emptySearchResults() throws Throwable {
        Thread.sleep(3000);
        String results = getText(CRMemberSearchPage.emptyResults, "Empty Search Results");
        boolean emptySearchResult = isVisibleOnly(CRMemberSearchPage.emptyResults, "Empty Search Results");
        assertTrue(emptySearchResult, results + "Details not found");
        return results;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberPhoneVerification
     * description :: memberPhoneVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberPhoneVerification() throws Throwable {

        String phone = getAttributeValue(CRMemberSearchPage.txtMemberPhone, "Member Phone");
        assertTrue(phone != null, phone + " :is the Member Phone");
        return phone;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: waitcloseAllBusyIconsResults
     * description :: Application loading wait for memberseatch results
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public void waitcloseAllBusyIconsResults() throws Throwable {
        int iCounter = 0, loading;
        boolean status = true;
        do {
            iCounter++;
            loading = getElementsSize(CRMemberSearchPage.iconResultLoadingSpinner);
            if (loading == 0) {
                status = true;
                break;
            } else {
                status = false;
                LOG.info("iCounter appearStatus " + iCounter);
            }
            if (iCounter > 1000) {
                status = false;
                break;
            }
        }
        while (iCounter <= 1000);
        if (status) {
            LOG.info("All spinners are closed");
        } else {
            LOG.info("All spinners are not closed");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memFieldsVerification
     * description :: To Verify All mandatory Fields on member Page
     * date :: 29-Nov-2017
     * author :: chandu
     */

    public void memFieldsVerification() throws Throwable {
        //Verifing the each required field with class name in xpath contains -- class='******-required'
        verifyClubCode();
        verifyCity();
        verifyaddressline1();
        verifyState();
        verifyZip();
        verifyMemberexpiration();
        verifyFirstName();
        verifyLastName();
        verifyMemberlevel();
        verifyMemberNumber();
        verifyMemberPrimPhone();
        verifyMemberStatus();

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: cleanAndSaveMemberDetails()
     * description :: To clean and enter the member details manually
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public void cleanAndSaveMemberDetails(String firstName, String lastName, String address, String city, String state, String zipCode, String email, String phoneNumber, String phoneType, String memberNumber, String memberLevel, String expiration, String status) throws Throwable {
        clearMemberMandatoryFields();
        enterMemberMandatoryFields(firstName, lastName, address, city, state, zipCode, email, phoneNumber, phoneType, memberNumber, memberLevel, expiration, status);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyClubCode()
     * description :: To verify the club code
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public String verifyClubCode() throws Throwable {
        boolean flagclubcode = isVisibleOnly(CRMemberSearchPage.clubCode, "clubCode");
        assertTrue(flagclubcode, "<b>clubCode is verified and it is a mandatory field </b>");
        String clubCode = getText(CRMemberSearchPage.clubCode, "Retrieved Club code is ");
        return clubCode;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyFirstName()
     * description :: To verify the FirstName after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyFirstName() throws Throwable {
        boolean flagFName = isVisibleOnly(CRMemberSearchPage.txtFirstName, "First Name");
        assertTrue(flagFName, "<b>First Name is Mandatory Field</b>");
        return flagFName;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyLastName()
     * description :: To verify the LastName after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyLastName() throws Throwable {
        boolean flagLName = isVisibleOnly(CRMemberSearchPage.txtLastName, "Last Name");
        assertTrue(flagLName, "<b>Last Name is Mandatory Field</b>");
        return flagLName;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyaddressline1()
     * description :: To verify the addressline1 after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyaddressline1() throws Throwable {
        boolean flagAddress = isVisibleOnly(CRMemberSearchPage.txtAddressLine1, "Address");
        assertTrue(flagAddress, "<b>Address is Mandatory Field</b>");
        return flagAddress;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyaddressline2()
     * description :: To verify the addressline2 after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyaddressline2() throws Throwable {
        boolean flagAddress = isVisibleOnly(CRMemberSearchPage.txtAddressLine2, "Address2");

        assertTrue(flagAddress, "<b>Address2 is Mandatory Field</b>");
        return flagAddress;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCity()
     * description :: To verify the City after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyCity() throws Throwable {
        boolean flagCity = isVisibleOnly(CRMemberSearchPage.txtCity, "City");

        assertTrue(flagCity, "<b>City is Mandatory Field</b>");
        return flagCity;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberSience()
     * description :: To verify the member since after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberSience() throws Throwable {
        boolean flagCity = isVisibleOnly(CRMemberSearchPage.txtMbrSince, "Member Sience");

        assertTrue(flagCity, "<b>MemberSience is Mandatory Field</b>");
        return flagCity;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberState()
     * description :: To verify the State after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyState() throws Throwable {
        boolean flagState = isVisibleOnly(CRMemberSearchPage.txtState, "State");

        assertTrue(flagState, "<b>State is Mandatory Field</b>");
        return flagState;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyZip()
     * description :: To verify the Zip after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyZip() throws Throwable {
        boolean flagzip = isVisibleOnly(CRMemberSearchPage.txtZip, "ZipCode");

        assertTrue(flagzip, "<b>ZipCode is Mandatory Field</b>");
        return flagzip;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberNumber()
     * description :: To verify the MemberNumber after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberNumber() throws Throwable {
        boolean Membernumber = isVisibleOnly(CRMemberSearchPage.txtMemberNumber, "Membernumber");

        assertTrue(Membernumber, "<b>Membernumber is Mandatory Field</b>");
        return Membernumber;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberlevel()
     * description :: To verify the Memberlevel after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberlevel() throws Throwable {
        boolean flagMemberlevel = isVisibleOnly(CRMemberSearchPage.txtMemberLevel, "Memberlevel");

        assertTrue(flagMemberlevel, "<b>Memberlevel is Mandatory Field</b>");
        return flagMemberlevel;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberexpiration()
     * description :: To verify the Memberexpiration after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberexpiration() throws Throwable {
        boolean flagexpiration = isVisibleOnly(CRMemberSearchPage.txtMemberExpiration, "Memberexpiration");

        assertTrue(flagexpiration, "<b>Memberexpiration is Mandatory Field</b>");
        return flagexpiration;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberStatus()
     * description :: To verify the MemberStatus after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberStatus() throws Throwable {
        boolean flagstatus = isVisibleOnly(CRMemberSearchPage.txtMemberStatus, "status");

        assertTrue(flagstatus, "<b>status is Mandatory Field</b>");
        return flagstatus;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberPrimPhone()
     * description :: To verify the MemberPrimPhone after clicking on manual entry link
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberPrimPhone() throws Throwable {
        boolean flagph = isVisibleOnly(CRMemberSearchPage.txtPhone_NumberFirstRow, "txtphone_number");

        assertTrue(flagph, "<b>txtphone_number is Mandatory Field</b>");
        return flagph;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberPhone1()
     * description :: To verify the MemberPhone1
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberPhone1() throws Throwable {
        boolean txtphone_number1 = isVisibleOnly(CRMemberSearchPage.txtPhone_NumberSecondRow, "txtphone_number1");

        assertTrue(txtphone_number1, "<b>txtphone_number1 is Mandatory Field</b>");
        return txtphone_number1;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberPhone2()
     * description :: To verify the MemberPhone2
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberPhone2() throws Throwable {
        boolean txtphone_number2 = isVisibleOnly(CRMemberSearchPage.txtPhone_NumberThirdRow, "txtphone_number2");

        assertTrue(txtphone_number2, "txtphone_number2 is Mandatory Field");
        return txtphone_number2;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberPhoneType()
     * description :: To verify the MemberPhoneType
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyMemberPhoneType() throws Throwable {
        boolean phoneType = isVisibleOnly(CRMemberSearchPage.txtPhoneType, "phoneType");

        assertTrue(phoneType, "<b>phoneType is Mandatory Field</b>");
        return phoneType;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPrimaryPhoneRadioButton()
     * description :: To verify the PrimaryPhoneRadioButton
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public boolean verifyPrimaryPhoneRadioButton() throws Throwable {
        boolean phoneRadiobtn = isVisibleOnly(CRMemberSearchPage.rbutnprimary_phone, "Primary Phone Radio Button Is a Mandatory Field");

        assertTrue(phoneRadiobtn, "Primary Phone Radio Button Is a Mandatory Field");
        return phoneRadiobtn;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearMemMandatoryFields
     * description :: To Clear all mandatory Fields on memberTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearMemberMandatoryFields() throws Throwable {
        clearData(CRMemberSearchPage.txtFirstName);
        clearData(CRMemberSearchPage.txtLastName);
        clearData(CRMemberSearchPage.txtAddressLine1);
        clearData(CRMemberSearchPage.txtCity);
        clearData(CRMemberSearchPage.txtState);
        clearData(CRMemberSearchPage.txtZip);
        clearData(CRMemberSearchPage.txtMemberNumber);
        clearData(CRMemberSearchPage.txtMemberLevel);
        clearData(CRMemberSearchPage.txtMemberExpiration);
        clearData(CRMemberSearchPage.txtMemberStatus);
        clearData(CRMemberSearchPage.txtPhone_NumberFirstRow);

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberMandatoryFields
     * description :: To Enter all mandatory Fields on member
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterMemberMandatoryFields(String firstName, String lastName, String address, String city, String state, String zipCode, String email, String phoneNumber, String phoneType, String memberNumber, String memberLevel, String expiration, String status) throws Throwable {
        //Method to handile errors and Alerts
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddressLine(address);
        enterCity(city);
        enterState(state);
        enterZip(zipCode);
        enterEmail(email);
        enterPhoneNumber(phoneNumber);
        selectType(phoneType);
        clickPrimRadioBtnRowOne();
        enterMemberNumber(memberNumber);
        enterMemberLevel(memberLevel);
        enterExpiration(expiration);
        enterStatus(status);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFirstName
     * description :: To Enter FirstName
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterFirstName(String firstName) throws Throwable {
        clearData(CRMemberSearchPage.txtFirstName);
        type(CRMemberSearchPage.txtFirstName, firstName, "First Name");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLastName
     * description :: To Enter LastName
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterLastName(String lastName) throws Throwable {
        clearData(CRMemberSearchPage.txtLastName);
        type(CRMemberSearchPage.txtLastName, lastName, "Last Name");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressLine
     * description :: To Enter AddressLine
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterAddressLine(String address) throws Throwable {
        clearData(CRMemberSearchPage.txtAddressLine1);
        type(CRMemberSearchPage.txtAddressLine1, address, "Address");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCity
     * description :: To Enter City
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterCity(String city) throws Throwable {
        Thread.sleep(2000);
        clearData(CRMemberSearchPage.txtCity);
        type(CRMemberSearchPage.txtCity, city, "City");
        click(CRMemberSearchPage.txthonorific, "City");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterState
     * description :: To Enter State
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterState(String state) throws Throwable {
        clearData(CRMemberSearchPage.txtState);
        click(CRMemberSearchPage.txtState, "State");
        type(CRMemberSearchPage.txtState, state, "State");
        click(CRMemberSearchPage.txthonorific, "State");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterState
     * description :: To Enter Zip
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterZip(String zipCode) throws Throwable {
        clearData(CRMemberSearchPage.txtZip);
        type(CRMemberSearchPage.txtZip, zipCode, "Zip Code");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEmail
     * description :: To Enter Email
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterEmail(String email) throws Throwable {
        clearData(CRMemberSearchPage.txtEmail);
        type(CRMemberSearchPage.txtEmail, email, "Email");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPhoneNumber
     * description :: To Enter PhoneNumber
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterPhoneNumber(String phoneNumber) throws Throwable {
        clearData(CRMemberSearchPage.txtPhone_NumberFirstRow);
        click(CRMemberSearchPage.txtPhone_NumberFirstRow, "PhoneNumber");
        type(CRMemberSearchPage.txtPhone_NumberFirstRow, phoneNumber, "PhoneNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectType
     * description :: To select phone type
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectType(String phoneType) throws Throwable {
        click(CRMemberSearchPage.txtPhoneType, "Type");
        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneType, "PhoneType");
        selectByVisibleText(CRMemberSearchPage.txtPhoneType, phoneType, "PhoneType");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickPrimRadioBtnRowOne
     * date :: 29-Nov-2017
     * author :: madhukar
     * Description:This method is used to click on row One prim radioButton
     *
     * @throws Throwable
     */
    public void clickPrimRadioBtnRowOne() throws Throwable {
        click(CRMemberSearchPage.radiodbtnPrimRowOne, "primary_phoneRadioButton ");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumber
     * description :: To enter member number
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterMemberNumber(String memberNumber) throws Throwable {
        clearData(CRMemberSearchPage.txtMemberNumber);
        type(CRMemberSearchPage.txtMemberNumber, memberNumber, "MemberNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberLevel
     * description :: To enter member Level
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterMemberLevel(String memberLevel) throws Throwable {
        clearData(CRMemberSearchPage.txtMemberLevel);
        type(CRMemberSearchPage.txtMemberLevel, memberLevel, "MemberLevel");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterExpiration
     * description :: To enter member Expiration
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterExpiration(String expiration) throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.txtMemberExpiration, "Expiration");
        clearData(CRMemberSearchPage.txtMemberExpiration);
        type(CRMemberSearchPage.txtMemberExpiration, expiration, "Expiration");
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        click(CRMemberSearchPage.txtType, "Type");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStatus
     * description :: To enter member Status
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterStatus(String status) throws Throwable {
        clearData(CRMemberSearchPage.txtMemberStatus);
        waitForVisibilityOfElement(CRMemberSearchPage.txtMemberStatus, "Status");
        type(CRMemberSearchPage.txtMemberStatus, status, "Status");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle Errors and Alerts Before enter Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling IN Member Page
        boolean flagErrorAlertOkButton = isVisibleOnly(CRMemberSearchPage.errorAlertOK, "Error Alert OK button");

        if (flagErrorAlertOkButton) {
            click(CRMemberSearchPage.errorAlertOK, "Error Alert OK Button");

        }
        boolean flagCRMembersearchpageScriptError = isVisibleOnly(CRMemberSearchPage.scriptError, "CRMembersearchpag.scriptError");
        if (flagCRMembersearchpageScriptError) {
            JSClick(CRMemberSearchPage.scriptError, "Script error Okay button");
        }
        boolean flagConfirmationokaybutton = isVisibleOnly(CRMemberSearchPage.btnAlertSaveYes, "Confirmation okay button");
        if (flagConfirmationokaybutton) {
            click(CRMemberSearchPage.btnAlertSaveYes, "Confirmation Okay button");
        }

        Boolean flagErrornotification = isVisibleOnly(CRMemberSearchPage.errorNotifications, "Error notification");
        if (flagErrornotification) {
            click(CRMemberSearchPage.errorNotifications, "Error notification");
        }
        boolean expirationErrorMessage = isVisibleOnly(CRMemberSearchPage.errorAlertOK, "Expiration Date Allert");
        if (expirationErrorMessage) {
            click(CRMemberSearchPage.errorAlertOK, "expirationErrorMessage");
        }

        boolean flagErrorOkButton = isVisibleOnly(CRMemberSearchPage.alertUndefinedError, "Error notification");
        if (flagErrorOkButton) {
            click(CRMemberSearchPage.alertUndefinedError, "Error notification");
        } else {
            String combineKeys3 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys3, "SPACE");
        }


    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContinfo_Enterprimphonenum
     *  * description :: To enter member primphone
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */
    public void enterMemberContactInfoPrimaryPhoneNumber(String Primaryphonenum) throws Throwable {
        Thread.sleep(3000);

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhone_NumberFirstRow, "Primary phone number textbox");
        type(CRMemberSearchPage.txtPhone_NumberFirstRow, Primaryphonenum, "Primary phone number textbox");
        Thread.sleep(3000);
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContinfo_Enterprimphonetype
     *  * description :: To enter member primphone type
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void membContInfoEnterPrimPhoneTypeCellular() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneType, "Phonenumber type");
        selectByVisibleText(CRMemberSearchPage.txtPhoneType, "Cellular", "Phone number type");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContinfo_Selectprimphrdbtn
     *  * description :: To select member prim phone radio button
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void membContinfoSelectprimphrdbtn() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiodbtnPrimRowOne, "Primay phone radio button");
        click(CRMemberSearchPage.radiodbtnPrimRowOne, "Primary phone radio button");

    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: tempDelete
     * Description:This method will check DEL checkbox,clicks on AddPhone button,enters new phone number,
     * selects phonetype,check prim checkbox and check the temp checkBox.
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void tempDelete(String phoneNumber) throws Throwable {
        clickDelCheckBoxRowTwo();
        clickAddPhoneBtn();
        //To get count of Phone Numbers
        String phonenumber = enterPhoneNumer();
        type(CRMemberSearchPage.enterPhoneNumber(phonenumber), phoneNumber, "Enter Phone Number");
        selectByVisibleText(CRMemberSearchPage.selectPhoneType(phonenumber), "Business", "Select Phonenumber type");
        click(CRMemberSearchPage.clickPrimRadiobutton(phonenumber), "Click On prim Radio Button");
        click(CRMemberSearchPage.selectTempDeleteChkBox(phonenumber), "Select Temp Checkbox Button");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickDelCheckBoxRowTwo
     * Date:27-02-2018
     * Description:To click on Row two del checkBox on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void clickDelCheckBoxRowTwo() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.chkBoxDelCheckBoxSecondRow, "Del CheckBox");
        click(CRMemberSearchPage.chkBoxDelCheckBoxSecondRow, "Del CheckBox");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickAddPhoneBtn
     * Date:27-02-2018
     * Description:To click on AddPhone Button on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void clickAddPhoneBtn() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.addPhoneButton, "Add Phone");
        click(CRMemberSearchPage.addPhoneButton, "Add Phone");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterRandomSecondaryPhoneNumberinThirdRow
     * Date:27-02-2018
     * Description:To enter random member's phone number in Row Three on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void enterRandomSecondaryPhoneNumberinThirdRow() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.addPhoneNumberTextThirdRow, "Phone Number TextBox");
        click(CRMemberSearchPage.addPhoneNumberTextThirdRow, "Phone Number TextBox");
        clearData(CRMemberSearchPage.addPhoneNumberTextThirdRow);
        click(CRMemberSearchPage.addPhoneNumberTextThirdRow, "Phone Number TextBox");
        type(CRMemberSearchPage.addPhoneNumberTextThirdRow, "4115" + generateRandomNumber(6), "PhoneNumber");
    }

    /**
     * return ::void
     * methodName :: enterRandomPrimaryPhoneNumberinFirstRow
     * Date:27-02-2018
     * Description:To enter random member's phone number in Row One on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void enterRandomPrimaryPhoneNumberinFirstRow() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.addPhoneNumberTextFirstRow, "Phone Number TextBox");
        type(CRMemberSearchPage.addPhoneNumberTextFirstRow, "4115" + generateRandomNumber(6), "PhoneNumber");
    }

    /**
     * return ::void
     * methodName :: enterRandomPrimaryPhoneNumberinFirstRow
     * Date:27-02-2018
     * Description:To click on row three phoneType Dropdown on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void selectPhoneTypeinRowThree() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.dropDownPhoneTypeRowThree, "Phone Number type");
        selectByVisibleText(CRMemberSearchPage.dropDownPhoneTypeRowThree, "Business", "Phonenumber type");
    }

    /**
     * return ::void
     * methodName :: ClickPrimRadioBtnInRowThree
     * Date:27-02-2018
     * Description:To click on row three prim Radio button on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void ClickPrimRadioBtnInRowThree() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiobtnPrimInRowThree, "Phone Number type");
        click(CRMemberSearchPage.radiobtnPrimInRowThree, "prim Radio Button");
    }

    /**
     * return ::void
     * methodName :: clickTempCheckBoxinThirdRow
     * Date:27-02-2018
     * Description:To click on row three temp checkBox on MemberContactInformation
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void clickTempCheckBoxinThirdRow() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.chkBoxTempCheckBoxRowThree, "Phone Number type");
        click(CRMemberSearchPage.chkBoxTempCheckBoxRowThree, "Temp CheckBox");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberCol
     * description :: To check member contactInfo is not null
     * date :: 05-Dec-2017
     * author :: Madhukar
     */
    public void memberNumberColNullValueCheck() throws Throwable {

        String memNum = getText(CRMemberSearchPage.lblMemberNumberColumnValue, "Member number");
        assertTrue(memNum != null, "Contact information is not null");
    }

    /**
     * return ::void
     * methodName :: clickOnMemberIdForHistoryCallSave
     * Date:27-02-2018
     * Description:This method is used only to click on MemberId link for HistoryCallSave and handle the popup.
     * author:Madhukar
     *
     * @throws Throwable
     */
    public void clickOnMemberIdForHistoryCallSave() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.linkMemberId, "Member Id");
        click(CRMemberSearchPage.linkMemberId, "Member Id");
        handlePopup();
    }

    /**
     * return ::void
     * methodName :: handlePopup
     * Date:27-02-2018
     * author:Madhukar
     *
     * @throws Throwable Description:This method is used to handle the popup
     */
    public void handlePopup() throws Throwable {
        if (isVisible(CRMemberSearchPage.alertClose, "PopUp Window Cancel")) {
            click(CRMemberSearchPage.alertClose, "PopUp Window Cancel");
        }
    }

    /**
     * param::String
     * return ::void
     * methodName :: memberSrchPageMandDetails
     * Date:27-02-2018
     * author:Madhukar
     *
     * @throws Throwable Description:To fill member page mandatory details
     */
    public void memberSrchPageMandDetails(String Primaryphonenum) throws Throwable {
        memberNumClick();
        currentCallClose();
        enterMemberContactInfoPrimaryPhoneNumber(Primaryphonenum);
        membContInfoEnterPrimPhoneTypeCellular();
        membContinfoSelectprimphrdbtn();
    }

    /**
     * return ::String
     * methodName :: labelMemberShipNumberInMemberDetailsSection
     * Description:This method verify whether MemberShipNumber is visible and to retrieve the MemberShip Number.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberShipNumberInMemberDetailsSection() throws Throwable {
        String membershipNumber = null;
        boolean visibilityOfMemberNumberLabel = isVisibleOnly(CRMemberSearchPage.lblMemberShipNumber, "Member Number label");
       assertTrue(visibilityOfMemberNumberLabel,"Member Ship Number is available in member details Section");
        if (visibilityOfMemberNumberLabel) {
            membershipNumber = getText(CRMemberSearchPage.lblMemberShipNumber, "Member number value from member number details section");
        }
        return membershipNumber;
    }

    /**
     * return ::String
     * methodName :: labelMemberSinceInMemberDetailsSection
     * Description:This method verify whether Member Since is visible and to retrieve the Member Since value.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberSinceInMemberDetailsSection() throws Throwable {
        String memberSince = null;
        boolean visibilityOfMemberSinceLabel = isVisibleOnly(CRMemberSearchPage.lblMemberSince, "Member Since label");
        assertTrue(visibilityOfMemberSinceLabel, "Member since value is available in member details Section");
        if (visibilityOfMemberSinceLabel) {
            memberSince = getText(CRMemberSearchPage.lblMemberSince, "Member since value from member number details section");
        }
        return memberSince;
    }

    /**
     * return ::String
     * Description:This method verify whether Member Level is visible and to retrieve the Member Level.
     * methodName :: labelMemberLevelInMemberDetailsSection
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberLevelInMemberDetailsSection() throws Throwable {
        String memberLevel = null;
        boolean visibilityOfMemberLevelLabel = isVisibleOnly(CRMemberSearchPage.lblMemberLevel, "Member Level label");
        assertTrue(visibilityOfMemberLevelLabel, "Member Level value is available in member details Section");
        if (visibilityOfMemberLevelLabel) {
            memberLevel = getText(CRMemberSearchPage.lblMemberLevel, "Member level value from member number details section");
        }
        return memberLevel;
    }

    /**
     * return ::String
     * Description:This method verify whether Member Type is visible and to retrieve the Member Type.
     * methodName :: labelMemberTypeInMemberDetailsSection
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberTypeInMemberDetailsSection() throws Throwable {
        String memberType = null;
        boolean visibilityOfMemberTypeLabel = isVisibleOnly(CRMemberSearchPage.lblMemberType, "Member Type label");
        assertTrue(visibilityOfMemberTypeLabel, "Member Type value is available in member details Section");
        if (visibilityOfMemberTypeLabel) {
            memberType = getText(CRMemberSearchPage.lblMemberType, "Member Type value from member number details section");
        }
        return memberType;
    }

    /**
     * return ::String
     * methodName :: labelMemberExpirationInMemberDetailsSection
     * Description:This method verify whether Member Expiration date is visible and to retrieve the Member Expiration date.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberExpirationInMemberDetailsSection() throws Throwable {
        String memberExpiration = null;
        boolean visibilityOfMemberExpirationLabel = isVisibleOnly(CRMemberSearchPage.lblMemberExpiration, "Member Expiration label");
        assertTrue(visibilityOfMemberExpirationLabel, "Member Expiration value is available in member details Section");
        if (visibilityOfMemberExpirationLabel) {
            memberExpiration = getText(CRMemberSearchPage.lblMemberExpiration, "Member Expiration value from member number details section");
        }
        return memberExpiration;
    }

    /**
     * return ::String
     * methodName :: labelMemberStatusInMemberDetailsSection
     * Description:This method verify whether Member status is visible and to retrieve the Member Status Details.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberStatusInMemberDetailsSection() throws Throwable {
        String memberStatus = null;
        boolean visibilityOfMemberStatusLabel = isVisibleOnly(CRMemberSearchPage.lblMemberStatus, "Member Status label");
        assertTrue(visibilityOfMemberStatusLabel, "Member Status value is available in member details Section");
        if (visibilityOfMemberStatusLabel) {
            memberStatus = getText(CRMemberSearchPage.lblMemberStatus, "Member Status value from member number details section");
        }
        return memberStatus;
    }

    /**
     * return ::String
     * methodName :: memberCallsAllowedInMemberDetailsSection
     * Description:This method verify whether Calls Allowed is visible and to retrieve the No.of Calls Allowed.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberCallsAllowedInMemberDetailsSection() throws Throwable {
        String callsAllowed = null;
        boolean visibilityOfCallsAllowed = isVisibleOnly(CRMemberSearchPage.memberCallsAllowed, "Calls Allowed");
        assertTrue(visibilityOfCallsAllowed, "Calls Allowed is available in member details Section");
        if (visibilityOfCallsAllowed) {
            callsAllowed = getText(CRMemberSearchPage.memberCallsAllowed, "Calls Allowed value from member number details section");
        }
        return callsAllowed;
    }

    /**
     * return ::String
     * methodName :: memberCallsRemainingInMemberDetailsSection
     * Description:This method verify whether Calls Remaining is visible and to retrieve the no.of calls remaining.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberCallsRemainingInMemberDetailsSection() throws Throwable {
        String callsRemaining = null;
        boolean visibilityOfCallsRemaining = isVisibleOnly(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining");
        assertTrue(visibilityOfCallsRemaining, "Calls Remaining is available in member details Section");
        if (visibilityOfCallsRemaining) {
            callsRemaining = getText(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining value from member number details section");
        }
        return callsRemaining;
    }

    /**
     * return ::String
     * methodName :: memberCallsUsedInMemberDetailsSection
     * Description:This method verify whether Calls Used is visible and to retrieve the no.of Calls used.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberCallsUsedInMemberDetailsSection() throws Throwable {
        String callsUsed = null;
        boolean visibilityOfCallsUsed = isVisibleOnly(CRMemberSearchPage.memberCallsUsed, "Calls Used");
        assertTrue(visibilityOfCallsUsed, "Calls Used is available in member details Section");
        if (visibilityOfCallsUsed) {
            callsUsed = getText(CRMemberSearchPage.memberCallsUsed, "Calls Used value from member number details section");
        }
        return callsUsed;
    }

    /**
     * return ::String
     * methodName :: memberCurrentCallsInMemberDetailsSection
     * Description:This method verify whether CurrentCalls  is visible and to retrieve the no.of CurrentCalls.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberCurrentCallsInMemberDetailsSection() throws Throwable {
        String currentCalls = null;
        boolean visibilityOfCurrentCalls = isVisibleOnly(CRMemberSearchPage.memberCurrentCalls, " Current Calls");
        if (visibilityOfCurrentCalls) {
            currentCalls = getText(CRMemberSearchPage.memberCurrentCalls, "Current Calls value from member number details section");
        }
        return currentCalls;
    }

    /**
     * return ::String
     * methodName :: memberChargeableCallsInMemberDetailsSection
     * Description:This method verify whether ChargeableCalls is visible and to retrieve the no.of ChargeableCalls.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberChargeableCallsInMemberDetailsSection() throws Throwable {
        String chargeableCalls = null;
        boolean visibilityOfChargeableCalls = isVisibleOnly(CRMemberSearchPage.memberChargeableCalls, " Chargeable Calls");
        assertTrue(visibilityOfChargeableCalls, "Chargeable Calls is available in member details Section");
        if (visibilityOfChargeableCalls) {
            chargeableCalls = getText(CRMemberSearchPage.memberChargeableCalls, "Chargeable Calls value from member number details section");
        }
        return chargeableCalls;
    }

    /**
     * return ::String
     * methodName :: labelMemberFirstNameInMemberDetailsSection
     * Description:This method verify whether MemberFirstName is visible and to retrieve the MemberFirstName.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberFirstNameInMemberDetailsSection() throws Throwable {
        String memberFirstName = null;
        boolean visibilityOfMemberNameLabel = isVisibleOnly(CRMemberSearchPage.lblMemberFirstName, "Member FirstName label");
        assertTrue(visibilityOfMemberNameLabel, "Member FirstName is available in member details Section");
        if (visibilityOfMemberNameLabel) {
            memberFirstName = getText(CRMemberSearchPage.lblMemberFirstName, "FirstName value from member number details section");
        }
        return memberFirstName;
    }

    /**
     * return ::String
     * methodName :: labelMemberLastNameInMemberDetailsSection
     * Description:This method verify whether MemberLastName is visible and to retrieve the MemberLastName.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberLastNameInMemberDetailsSection() throws Throwable {
        String memberLastName = null;
        boolean visibilityOfMemberLastNameLabel = isVisibleOnly(CRMemberSearchPage.lblMemberLastName, "Member LastName label");
        assertTrue(visibilityOfMemberLastNameLabel, "Member LastName is available in member details Section");
        if (visibilityOfMemberLastNameLabel) {
            memberLastName = getText(CRMemberSearchPage.lblMemberLastName, "Member LastName value from member number details section");
        }
        return memberLastName;
    }

    /**
     * return ::String
     * methodName :: labelMemberZipCodeInMemberDetailsSection
     * Description:This method verify whether Member ZipCode is visible and to retrieve the Member Zipcode.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberZipCodeInMemberDetailsSection() throws Throwable {
        String memberZipcode = null;
        boolean visibilityOfZipCodeLabel = isVisibleOnly(CRMemberSearchPage.lblMemberZipCode, "Member Zipcode label");
        assertTrue(visibilityOfZipCodeLabel, "Member Zipcode is available in member details Section");
        if (visibilityOfZipCodeLabel) {
            memberZipcode = getText(CRMemberSearchPage.lblMemberZipCode, "Member Zipcode value from member number details section");
        }
        return memberZipcode;
    }

    /**
     * return ::String
     * methodName :: labelMemberStateInMemberDetailsSection
     * Description:This method verify whether Member state is visible and to retrieve the Member's state.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberStateInMemberDetailsSection() throws Throwable {
        String state = null;
        boolean visibilityOfStateLabel = isVisibleOnly(CRMemberSearchPage.lblMemberState, "Member State label");
        assertTrue(visibilityOfStateLabel, "Member State is available in member details Section");
        if (visibilityOfStateLabel) {
            state = getText(CRMemberSearchPage.lblMemberState, "Member State value from member number details section");
        }
        return state;

    }

    /**
     * return ::String
     * methodName :: labelMemberCityInMemberDetailsSection
     * Description:This method verify whether Member's City is visible and to retrieve the Member's City.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberCityInMemberDetailsSection() throws Throwable {
        String city = null;
        boolean visibilityOfCityLabel = isVisibleOnly(CRMemberSearchPage.lblMemberCity, "Member City label");
        assertTrue(visibilityOfCityLabel, "Member City is available in member details Section");
        if (visibilityOfCityLabel) {
            city = getText(CRMemberSearchPage.lblMemberCity, "Member City value from member number details section");
        }
        return city;
    }

    /**
     * return ::String
     * methodName :: memberNumber
     * Description:This method is used to verify whether member Number is visible or not and to get member number details
     * after searching in the omni search bar.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberNumber() throws Throwable {
        String memberNumber = null;
        boolean visibilityOfMemberNumber = isVisibleOnly(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        assertTrue(visibilityOfMemberNumber, "Member Number is available");
        if (visibilityOfMemberNumber) {
            memberNumber = getText(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number value");
        }
        return memberNumber;

    }

    /**
     * return ::String
     * methodName :: memberName
     * Description:This method is used to verify whether member Name is visible or not and to get member number details
     * after searching in the omni search bar.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberName() throws Throwable {
        Thread.sleep(5000);
        String memberName = null;
        boolean visibilityOfMemberName = isVisibleOnly(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");
        assertTrue(visibilityOfMemberName, "Member Name is available");
        if (visibilityOfMemberName) {
            memberName = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name value");
        }
        return memberName;
    }

    /**
     * return ::String
     * methodName :: memberAddress
     * Description:This method is used to verify whether member Address is visible or not and to get member number details
     * after searching in the omni search bar.
     * Date:15-12-2017
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public String memberAddress() throws Throwable {
        String memberAddress = null;
        boolean visibilityOfMemberAddress = isVisibleOnly(CRMemberSearchPage.lblMemberAddressColumnValue, "Member Address");
        assertTrue(visibilityOfMemberAddress, "Member Address is available");
        if (visibilityOfMemberAddress) {
            memberAddress = getText(CRMemberSearchPage.lblMemberAddressColumnValue, "Member Address value");
        }
        return memberAddress;
    }

    /**
     * return ::String
     * methodName :: memberContactInfo
     * Description:This method is used to verify whether MemberContactInfo is visible or not and to get member number details
     * after searching in the omni search bar.
     * Date:15-12-2017
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public String memberContactInfo() throws Throwable {
        String memberContactInfo = null;
        boolean visibilityOfMemberContactInfo = isVisibleOnly(CRMemberSearchPage.lblMemberAddressColumnValue, "Member ContactInfo");
        assertTrue(visibilityOfMemberContactInfo, "Member ContactInfo is available");
        if (visibilityOfMemberContactInfo) {
            memberContactInfo = getText(CRMemberSearchPage.lblMemberAddressColumnValue, "Member ContactInfo value");
        }
        return memberContactInfo;
    }

    /**
     * return ::Void
     * methodName :: enterTextInScratchPad
     * Description:This method is used to enter text in ScratchPad
     * Date:15-12-2017
     *
     * @param text
     * @throws Throwable
     * @author :Madhukar
     */
    public String enterTextInScratchPad(String text) throws Throwable {
        type(CRMemberSearchPage.txtScratchPad, text, "ScratchPad");
        return text;

    }

    /**
     * return ::Void
     * methodName :: clickOnChangeOfAddressRadioBtn
     * Description:This method is used to click on change of Address Radio Button to edit the address manually.
     * Date:15-12-2017
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public void clickOnChangeOfAddressRadioBtn() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiobtnChangeOfAddress, "Change Of address");
        click(CRMemberSearchPage.radiobtnChangeOfAddress, "Change Of address");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLinkInMember
     * description :: To click on manual entry click on member search page
     * date :: 18-December-2017
     * author :: chandu
     */
    public void clickOnManualEntryLinkInMember() throws Throwable {
        boolean manualEntryLinkVerification = isVisible(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
        assertTrue(manualEntryLinkVerification, "ManualEntry Link is Present");
        waitForVisibilityOfElement(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
        click(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
    }

    /**
     * return ::void
     * methodName :: verifyScratchPad
     * Description:This method is used to verify whether scratch pad is visible or not.
     * date :: 18-December-2017
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public void verifyScratchPad() throws Throwable {
        click(CRMemberSearchPage.iconScratchPad, "Scratch Pad Icon");
        boolean visibilityOfSctatchPad = isVisibleOnly(CRMemberSearchPage.txtScratchPad, "Scratch Pad");
        assertTrue(visibilityOfSctatchPad, "ScratchPad is visible ");
        if (visibilityOfSctatchPad) {
            String text = getAttributeByValue(CRMemberSearchPage.txtScratchPad, "Scratch Pad");
            assertTrue(text.isEmpty(), "Scratch Pad is empty");
        }
    }

    /**
     * return ::void
     * methodName :: currentCallRecord
     * Description:To get current calls from the list on member search page.
     * date :: 18-December-2017
     *
     * @param callid
     * @throws Throwable
     * @author: lakshmi
     */
    public void currentCallRecord(String callid) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.listOfCallsID, "CallId in Profile");
        callList = getWebElementList(CRMemberSearchPage.listOfCallsID, "CallId in Profile");
        if (callList != null) {
            System.out.println(callList.size());
            for (int i = 0; i <= callList.size(); i++) {
                String callIdFromList = callList.get(i).getText();
                assertTrue(callid.equals(callIdFromList), "Created Call Record present");
            }
        }
    }

    /**
     * return ::void
     * methodName :: enterDataInClubCode
     * Description:To enter the data in club code on member search page
     * date :: 18-12-2017
     * author :: Madhukar
     *
     * @param clubCode
     * @throws Throwable
     */
    public void enterDataInClubCode(String clubCode) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.btnClubCodeSearch, "Club Code Button");
        click(CRMemberSearchPage.btnClubCodeSearch, "Club Code Button");
        click(CRMemberSearchPage.txtClubCode, "Enter Club Code");
        clearData(CRMemberSearchPage.txtClubCode);
        type(CRMemberSearchPage.txtClubCode, clubCode, "Enter Club Code");
        String combineKeys = Keys.chord(Keys.TAB);
        sendKeys(combineKeys, "Tab");
    }

    /**
     * return ::boolean
     * methodName :: verifyWildCardForLastName
     * Description:This method is used to verify the wild card for the names which are searched in omni search bar.
     * author :: Madhukar
     * date :: 18-12-2017
     *
     * @throws Throwable
     */
    public boolean verifyWildCardForLastName() throws Throwable {
        boolean wildCard = false;
        boolean visibilityOfMemberName = isVisibleOnly(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");
        if (visibilityOfMemberName) {
            assertTrue(visibilityOfMemberName, "Member Name is available");
            String memberName = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name value");
            wildCard = memberName.contains(",");
            assertTrue(wildCard, "wildcard is visible");

        } else {
            assertFalse(visibilityOfMemberName, "wildcard is not visible");
        }
        return wildCard;
    }

    /**
     * return ::String
     * methodName :: getCurrentCallsForMember
     * Description:This method is used to get current calls for a member.
     * date :: 01-03-2018
     *
     * @throws Throwable
     * @author: lakshmi
     */
    public String getCurrentCallsForMember() throws Throwable {
        String currentCalls = null;
        boolean visibilityOfCurrentCalls = isVisibleOnly(CRMemberSearchPage.memberCurrentCalls, " Current Calls");
        assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
        if (visibilityOfCurrentCalls) {
            currentCalls = getText(CRMemberSearchPage.memberCurrentCalls, "Current Calls value from member number details section");
        }
        return currentCalls;
    }

    /**
     * return ::boolean
     * methodName :: verifyNumberOfCalls
     * Description:This verify no.of calls for a member after leaving the call.
     *
     * @param numcalls1
     * @param numCalls2
     * @throws Throwable
     * @throws Throwable
     * @author :Lakshmi
     * date :: 19-Dec-2017
     */
    public boolean verifyNumberOfCalls(String numcalls1, String numCalls2) throws Throwable {
        boolean numberOfCalls = numcalls1.equals(numCalls2);
        assertTrue(numberOfCalls, "Call was Saved In to the live call System");
        return numberOfCalls;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationTab
     * description :: To click on member tab on member search page
     * date :: 19-Dec-2017
     * author :: Abhiram Vajrapu
     */
    public void clickOnMemberTab() throws Throwable {
        Thread.sleep(6000);
        waitForVisibilityOfElement(CRMemberSearchPage.memberTab, "Member Tab");
        click(CRMemberSearchPage.memberTab, "Member Tab");
    }

    /**
     * return ::String
     * methodName :: verifyClubCodeForCdxmember
     * Description:This method is to verify club code is updated automatically for a cdx member .
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @param
     * @throws Throwable
     */
    public String verifyClubCodeForCdxmember() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.clubCode, "clubCode");
        String clubCode = getText(CRMemberSearchPage.clubCode, "clubCode");
        return clubCode;
    }

    /**
     * return ::boolean
     * methodName :: verifyListOfMembernames
     * Description:This method is used to verify list of members available for any search criteria.
     * author :: Madhukar
     * date :: 01-03-2018
     *
     * @throws Throwable
     */
    public boolean verifyListOfMembernames() throws Throwable {
        boolean listOfMembers = isVisibleOnly(CRMemberSearchPage.listOfLastNames, "List of member names");
        assertTrue(listOfMembers, "All members with the entered details are returned");
        return listOfMembers;
    }

    /**
     * return ::String
     * methodName :: getPhoneNumber
     * Description:Get phone Number for verification .
     * author :: Madhukar
     * date :: 01-03-2018
     *
     * @return
     * @throws Throwable
     */
    public String getPhoneNumber() throws Throwable {
        String phoneNumber = getText(CRMemberSearchPage.txtPhone_NumberFirstRow, "PhoneNumber");
        return phoneNumber;
    }

    /**
     * return ::void
     * methodName :: memberCurrentCalls
     * Description:This method verify whether CurrentCalls  is visible and to retrieve the no.of CurrentCalls.
     *
     * @throws Throwable
     * @author :Abhiram
     * date :: 20-Dec-2017
     */
    public void memberCurrentCalls() throws Throwable {
        boolean visibilityOfCurrentCalls = isVisibleOnly(CRMemberSearchPage.memberCurrentCalls, " Current Calls");
        assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
        if (visibilityOfCurrentCalls) {
            String currentCalls = getText(CRMemberSearchPage.memberCurrentCalls, "Current Calls value from member number details section");
            int result = Integer.parseInt(currentCalls);
            boolean callCountresult = result != 1;
            assertTrue(callCountresult, "Call count is verified and not matched to 1");
        }
    }

    /**
     * return ::void
     * methodName :: closeSearchCallsWindow
     * Description:This method is used to close the search calls window
     *
     * @throws Throwable
     * @author :Abhiram
     * date :: 20-Dec-2017
     */
    public void closeSearchCallsWindow() throws Throwable {
        boolean closeCallWindow = isVisibleOnly(CRMemberSearchPage.iconSearchCallClose, "Close search call window");
        assertTrue(closeCallWindow, "Close call window appeared");
        if (closeCallWindow) {
            Thread.sleep(1000);
            click(CRMemberSearchPage.iconSearchCallClose, "Close search call window");
        }
    }

    /**
     * return ::void
     * methodName :: verifyTheCreatedCall
     * Description:This method is used to verify the created call
     *
     * @param callId
     * @throws Throwable
     * @author :Abhiram
     * date :: 20-Dec-2017
     */
    public boolean verifyTheCreatedCallOnceMemberLoads(String callId) throws Throwable {
        boolean callLoadCheckingFlag = false;
        List<WebElement> callsList = getWebElementList(CRMemberSearchPage.listOfLoadedCalls, "Get List Of calls once Member Loads");
        for (int i = 0; i < callsList.size(); i++) {
            String loadedCallId = callsList.get(i).getText();
            if (loadedCallId.contains(callId))
                callLoadCheckingFlag = true;
        }
        return callLoadCheckingFlag;
    }

    /**
     * return ::void
     * methodName :: verifyManualEntryLink
     * Description:This method is used to verify the manual entry link on member search page
     *
     * @throws Throwable
     * @author :Abhiram
     * date :: 20-Dec-2017
     */
    public boolean verifyManualEntryLink() throws Throwable {
        boolean manualEntryLink = isVisible(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
        //assertTrue(manualEntryLink, "ManualEntry Link is Present");
        return manualEntryLink;
    }

    /**
     * return ::boolean
     * methodName :: veryfyCallCountForMemberAsEntitleMent
     * Description:: This method is used to verify call count for member
     *
     * @param callsAllowedBeforeMemberCall
     * @param callsAllowedAfterMemberCall
     * @throws Throwable
     */
    public boolean veryfyCallCountForMemberAsEntitleMent(String callsAllowedBeforeMemberCall, String callsAllowedAfterMemberCall) throws Throwable {
        boolean entitlementCountFlag = false;
        int entitlementCountBeforeCall = Integer.parseInt(callsAllowedBeforeMemberCall);
        int entitlementCountAfterCall = Integer.parseInt(callsAllowedAfterMemberCall);
        //verifing the entitlement count incresed or not
        if (entitlementCountBeforeCall > entitlementCountAfterCall)
            entitlementCountFlag = true;
        return entitlementCountFlag;

    }

    /**
     * return ::void
     * methodName :: clickOnPartialCallCloseButton
     * Description:: This method is used to click on partial call close button
     * Date:: 01-03-2018
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public void clickOnPartialCallCloseButton() throws Throwable {
        boolean partialCall = isVisibleOnly(CRMemberSearchPage.partialCall, "Partial Call Close Icon");
        if (partialCall) {
            click(CRMemberSearchPage.closeIconOnPartialCall, "Partial Call close icon");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickPrimRadioBtnSecondRow
     * description ::To click on prim radio button
     * date :: 11-01-2018
     * author :: Lakshmi prasanna
     */
    public void clickPrimRadioBtnSecondRow() throws Throwable {
        click(CRMemberSearchPage.radiodbtnPrimRowTwo, "primary_phoneRadioButton ");
    }

    /**
     * return ::int
     * Description:This method verify whether Calls Remaining is visible and to retrieve the no.of calls remaining.
     * methodName :: CallsRemainingInMemberDetailsSection
     *
     * @throws Throwable
     * @author :Varun
     * date :: 11-Jan-2018
     */

    public int CallsRemainingInMemberDetailsSection() throws Throwable {

        String callsRemaining = getText(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining value from member number details section");
        int RemainingCalls = Integer.parseInt(callsRemaining);
        System.out.println(RemainingCalls);

        return RemainingCalls;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberSearchTextBox
     * description :: enter data in Member Search textBox
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void memberSearchTextBox(String Membersearch) throws Throwable {
        click(CRHomePage.txtSearchMemberText, "Member Search box");
        type(CRHomePage.txtSearchMemberText, Membersearch, "Search Value");
        Thread.sleep(2000);
        System.out.println("Wrong" + Membersearch);
        click(CRHomePage.btnSearchButton, "Search Button");
    }

    /**
     * return ::void
     * methodName :: enterMemberDetails
     * description :: enter member mandatory fields on member search page
     * author :: Madhukar
     * date :: 01-03-2018
     *
     * @param Member
     * @param PrimaryPhone
     * @throws Throwable
     */
    public void enterMemberDetails(String Member, String PrimaryPhone) throws Throwable {
        memberSearchTextBox(Member);
        //search and close alert member
        memberNumClick();
        membershipRenewAlertYes();
        //Enter primary phone number
        enterMemberContactInfoPrimaryPhoneNumberRandomly(PrimaryPhone);
        //enter prime phone type cellular
        membContInfoEnterPrimPhoneTypeCellular();
        //enter prime phone radio button
        clickPrimRadioBtnRowOne();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondaryPhoneType
     * description :: enter enter Secondary PhoneType
     * date :: 12-jan-18
     * author :: Lakshmi Prasanna
     */
    public void enterSecondaryPhoneType(String phoneType) throws Throwable {
        type(CRMemberSearchPage.txtSecondaryPhoneType, phoneType, "Secondary Phone Type");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: membershipRenewAlertYes
     * description :: accept membership renew
     * date :: 12-Jan-2018
     * author :: Varun
     */

    public void membershipRenewAlertYes() throws Throwable {
        if (isVisibleOnly(CRMemberSearchPage.btnMembershipRenewYes, "Yes")) {
            click(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: membershipRenewAlertNo
     * description :: decline membership renew
     * date :: 12-Dec-2017
     * author :: Varun
     */

    public void membershipRenewAlertNo() throws Throwable {
        if (isVisibleOnly(CRMemberSearchPage.btnMembershipRenewNo, "NO")) {
            click(CRMemberSearchPage.btnMembershipRenewNo, "No");
        }
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: ClickPrimRadioBtnInRowTwo
     * Description:To click on row two prim Radio button on MemberContactInformation
     * author :: Madhukar
     * date :: 01-03-2018
     *
     * @throws Throwable
     */
    public void ClickPrimRadioBtnInRowTwo() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiobtnPrimInRowTwo, "Phone Number type");
        click(CRMemberSearchPage.radiobtnPrimInRowTwo, "prim Radio Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getConfirmationPopup
     * description :: to get text from confirmation question dialog
     * date :: 16-Jan-2018
     * author :: Nidhi
     */

    public String getConfirmationPopup() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.confirmationDialogQuestion, "Dialog Question");
        String value = getText(CRMemberSearchPage.confirmationDialogQuestion, "Dialog Question");
        getText(CRMemberSearchPage.btnYesOnConfirmationDialogQuestion, "Dialog Question");
        getText(CRMemberSearchPage.btnNoOnConfirmationDialogQuestion, "Dialog Question");
        return value;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: checkOnSmsCheckBox
     * description :: To click on sms check box
     * date :: 16-Jan-2018
     * author :: Nidhi
     */

    public void checkOnSmsCheckBox() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.chkBoxSms, "check");
        click(CRMemberSearchPage.chkBoxSms, "check on SMS");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyLongTowAllowed
     * description ::
     * date :: 17-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public void verifyLongTowAllowed(String longTowAllowed) throws Throwable {
        Thread.sleep(2000);
        String longTowallowedValue = getText(CRMemberSearchPage.txtLongTowAllowedValue, "Long Tow Allowed");
        assertTrue((longTowallowedValue.equalsIgnoreCase(longTowAllowed)), "Verified the ALLOW_LONG_TOW parameter and ALLOW_LONG_TOW is set to  " + longTowallowedValue);

    }

    /**
     * return ::void
     * methodName :: mandatoryFieldsForRAPCall
     * Description:This method is used to enetr mandatory details for a RAP call
     * date :: 01-March-2018
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void mandatoryFieldsForRAPCall(String firstName, String lastName, long ran, String paymentCode) throws Throwable {
        type(CRMemberSearchPage.txtFirstName, firstName, "First Name");
        type(CRMemberSearchPage.txtLastName, lastName, "Last Name");
        String numberAsString = new Long(ran).toString();
        type(CRMemberSearchPage.txtRapCallNumber, numberAsString, "Rap call number");
        type(CRMemberSearchPage.txtRapPaymentResponsibilityCode, paymentCode, "Payment Responsibility Code");


    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClubClodeSuggestedOption
     * description :: To click on club code sugested option for a RAP call
     * date :: 16-Jan-2018
     * author :: Nidhi
     */

    public void clickOnClubClodeSuggestedOption() throws Throwable {

        click(CRMemberSearchPage.clubCodeSelectionForRAPCall, "Club code selection");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterRAPonMemberTab
     * description :: enter enter Secondary PhoneType
     * date :: 17-jan-18
     * author :: Varun
     */
    public void enterRAPonMemberTab(String RAPNumber) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.txtRapCallNumber, "RAP number");
        type(CRMemberSearchPage.txtRapCallNumber, RAPNumber, "RAP number");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondPhoneNumber
     * description :: enter enter Secondary PhoneType
     * date :: 17-jan-18
     * author :: Varun
     */

    public void enterSecondPhoneNumber(String secondPhoneNumber) throws Throwable {
        clearData(CRMemberSearchPage.txtPhone_NumberSecondRow);
        click(CRMemberSearchPage.txtPhone_NumberSecondRow, "Second Phone Number");
        type(CRMemberSearchPage.txtPhone_NumberSecondRow, secondPhoneNumber, "Second Phone Number");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyIsRapWorkFlowSet
     * description :: To verify work flow for a RAP call
     * date :: 17-jan-18
     * author :: Chandu
     */
    public boolean verifyIsRapWorkFlowSet() throws Throwable {
        boolean workFlow = isVisibleOnly(CRMemberSearchPage.lnkRapEntitlements, "RapEntitlements in RAP WorkFlow");
        return workFlow;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPhoneNumberFirstRecord
     * description :: getPhoneNumberFirstRecord
     * date :: 22-Jan-18
     * author :: Abhiram
     */
    public String getPhoneNumberFirstRecord() throws Throwable {
        String phoneNumber = getAttributeByValue(CRMemberSearchPage.txtPhoneNumberFirstRecord, "Phone Number");
        return phoneNumber;

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPhoneTypeFirstRecord
     * description :: getPhoneTypeFirstRecord
     * date :: 22-Jan-18
     * author :: Abhiram
     */
    public String getPhoneTypeFirstRecord() throws Throwable {
        String phoneType = getAttributeByValue(CRMemberSearchPage.txtPhoneTypeFirstRecord, "Phone Type");
        return phoneType;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: currentCallCloseForfacilityWithDuplicate
     * description :: This method is specific to duplicating call with facility
     * date :: 22-Dec-2017
     * author :: Varun
     */
    public void currentCallCloseForfacilityWithDuplicate() throws Throwable {
        boolean flagCurrentCallClose = isVisibleOnly(CRMemberSearchPage.iconcurrentcallClose, "Current call close");
        if (flagCurrentCallClose) {
            click(CRMemberSearchPage.iconcurrentcallClose, "Current call popup closed");
        } /*else {
            assertTrue(flagCurrentCallClose, "Current call popup Visible");
        }*/
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: confirmationAlert
     * description :: confirmationAlert
     * date :: 29-Jan-2018
     * author :: Varun
     */

    public void confirmationAlert() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
        click(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
    }

    public void enterMembershipDetails(String Member, String Membersearch, String dbServer, String dbqueryFileName, String colomnName, String PhoneNumber, String Primaryphonenum1) throws Throwable {

        //home.verifyandClickLogout();
        if (Member.equals("db")) {
            //fetch member details from db
            //generating a random number everytime to fetch a new record everytime
            int rownum = IntRandomNumberGenerator(10,100);
            //int rownum = 3;
            //member from db
            Member = CommonDb.selectRandomMemberFromDB(dbServer, dbqueryFileName, colomnName, rownum);
            System.out.println("member : " + Member);
        }

        if (Member == null) {
            reporter.failureReport("<b>Checking for Member Number</b>", "Memeber Number is null",driver);
            throw new Exception("DB returned null Memeber Number");
            //Member = Membersearch;
        }
        //enter Member Details
        //enter phone number
        if (PhoneNumber.equalsIgnoreCase("Existing")) {
            memberSearchTextBox(Member);
            membershipRenewAlertYes();
            //search and close alert member
            memberNumClick();
            membershipRenewAlertYes();
            if (getPhoneNumberFirstRecord().isEmpty()) {
                enterMemberContactNumberPrimaryPhoneNumberRandomly(Primaryphonenum1);
            }
            if (getPhoneTypeFirstRecord().isEmpty()) {

                membContInfoSelectPrimPhoneTypeCellular();
            }
            membershipRenewAlertYes();
            clickPrimRadioBtnRow();
        } else {
            enterMemberDetails(Member, Primaryphonenum1);
        }
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberContactInfoPrimaryPhoneNumberRandomly
     * description :: To enter member primary phone number randomly
     * date :: 01-03-2018
     * author :: Madhukar
     */

    public void enterMemberContactInfoPrimaryPhoneNumberRandomly(String Primaryphonenum) throws Throwable {
        Thread.sleep(3000);

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhone_NumberFirstRow, "Primary phone number textbox");
        type(CRMemberSearchPage.txtPhone_NumberFirstRow, Primaryphonenum + generateRandomNumber(7), "Primary phone number textbox");
        Thread.sleep(3000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCompleteCheckMember
     * description :: To check whether all the mandatory details on member search page are filled
     * date :: 29-Jan-2018
     * author :: Varun
     */

    public void verifyCompleteCheckMember() throws Throwable {
        if (!(isVisibleOnly(CRMemberSearchPage.verifyMemberCompleteCheck, "Member Complete Check"))) {
            reporter.failureReport("Verify Member Complete Check", "All Mandatory Fields are not entered", driver);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPhoneNumberFromCallerInfo
     * description :: This method is used to get phone number from caller info
     * date :: 29-Jan-2018
     * author :: Varun
     */

    public String getPhoneNumberFromCallerInfo() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.linkCallSummaryIconOnMemberspage, "Call Summary icon");
        String phoneString1 = getText(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(8, 11);
        String phoneString2 = getText(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(13, 16);
        String phoneString3 = getText(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(17, 21);

        String phoneNumber = phoneString1 + phoneString2 + phoneString3;
        return phoneNumber;
    }

    /**
     * return ::void
     * methodName :: clickPrimRadioBtnRow
     * Description:This method is used to click on row One prim radioButton
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public void clickPrimRadioBtnRow() throws Throwable {
        click(CRMemberSearchPage.radiodbtnPrimRow, "primary_phoneRadioButton ");
    }


    /**
     * return ::String
     * methodName :: verifyCdxAuthorizationLevel
     * Description:This method is to get the CDXAuthorizationLevel Of a CDXMember
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public String verifyCdxAuthorizationLevel() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.lblCdxAuthorizationLevel, "CdxAuthorizationLevel");
        String AuthorizationLevel = getText(CRMemberSearchPage.lblCdxAuthorizationLevel, "CdxAuthorizationLevel");
        return AuthorizationLevel;
    }

    /**
     * return ::String
     * methodName :: verifyCdxAuthorizationMessage
     * Description:This method is to get the CdxAuthorizationMessage Of a CDXMember
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public String verifyCdxAuthorizationMessage() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.lblCdxAuthorizationMessage, "CdxAuthorizationMessage");
        String AuthorizationMessage = getText(CRMemberSearchPage.lblCdxAuthorizationMessage, "CdxAuthorizationMessage");
        return AuthorizationMessage;
    }

    /**
     * return ::String
     * methodName :: verifyCdxAuthorizationCode
     * Description:This method is to get the CdxAuthorizationCode Of a CDXMember
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public Boolean verifyCdxAuthorizationCode() throws Throwable {
        boolean authorizationCode=isVisibleOnly(CRMemberSearchPage.lblCdxAuthorizationCode, "CdxAuthorizationCode");
        String AuthorizationCode = getText(CRMemberSearchPage.lblCdxAuthorizationCode, "CdxAuthorizationCode");
        return authorizationCode;
    }

    /**
     * return ::String
     * methodName :: verifyCdxMotorCycleCoverage
     * Description:This method is to get the CdxMotorCycleCoverage Of a CDXMember
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public String verifyCdxMotorCycleCoverage() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.lblCdxMotorCycleCoverage, "CdxMotorCycleCoverage");
        String MotorCycleCoverag = getText(CRMemberSearchPage.lblCdxMotorCycleCoverage, "CdxMotorCycleCoverage");
        return MotorCycleCoverag;
    }

    /**
     * return ::void
     * methodName :: verifyErrorMessageForUnavailableService
     * Description:This method is to  verify Error Message For Unavailable Service Of a CDXMember
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public boolean verifyErrorMessageForUnavailableService() throws Throwable {
        Thread.sleep(15000);
        boolean errorPopup=isVisibleOnly(CRMemberSearchPage.errorServiceUnavailable, "ServiceUnavailable");
        Thread.sleep(15000);
        String error = getText(CRMemberSearchPage.errorServiceUnavailable, "ServiceUnavailable");
        return errorPopup;

    }

    /**
     * return ::void
     * methodName :: verifyErrorMessageForCDXUnavailableService
     * Description:This method is to  verify Error Message For CDXUnavailable Service Of a CDXMember
     * date :: 01-03-2018
     * author :: Madhukar
     *
     * @throws Throwable
     */
    public Boolean verifyErrorMessageForCDXUnavailableService() throws Throwable {
        boolean error=isVisibleOnly(CRMemberSearchPage.errorCDXServiceUnavailable, "ServiceUnavailable");
        getText(CRMemberSearchPage.errorCDXServiceUnavailable, "ServiceUnavailable");
        return error;
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: selectPhoneType
     * description :: To select PhoneType in Member Tab
     * date :: 12-jan-18
     * author :: Lakshmi Prasanna
     */
    public String selectPhoneType(String phoneType) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneType, "Phonenumber type");
        selectByVisibleText(CRMemberSearchPage.txtPhoneType, phoneType, "Phone number type");
        Select select = new Select(driver.findElement(CRMemberSearchPage.txtPhoneType));
        WebElement phoneTypeOption = select.getFirstSelectedOption();
        String pType = phoneTypeOption.getText();
        return pType;
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyManualEntryFields
     * description :: To verify ManualEntery Fields in MemberSearch
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyManualEntryFields() throws Throwable {
        boolean verificationFlag = true;
        if (!verifyMemberNameLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyAddressLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyAddress2LabelOnManualEntry())
            verificationFlag = false;
        if (!verifyCityLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyStateLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyZipLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyMembershipNumberLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyMemberSinceLabelOnManualEntry())
            verificationFlag = false;
        //verifyMemberJoinDateOnManualEntry();
        if (!verifyLevelLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyTypeLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyExpirationLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyStatusLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyEmailLabelOnManualEntry())
            verificationFlag = false;
        if (!verifyPhoneInformationLabelOnManualEntry())
            verificationFlag = false;

        return verificationFlag;
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyMemberNameLabelOnManualEntry
     * description :: To verify Member Name Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyMemberNameLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblMemberNameOnManualEntry, "<b>Member Name label on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyAddressLabelOnManualEntry
     * description :: To verify Address Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyAddressLabelOnManualEntry() throws Throwable {

        return isVisible(CRMemberSearchPage.lblAddressOnManualEntry, "<b>Address label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyAddress2LabelOnManualEntry
     * description :: To verify Address2 Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyAddress2LabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblAddress2OnManualEntry, "<b>Address2 label Name on Manual Entry</b>");

    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCityLabelOnManualEntry
     * description :: To verify City Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyCityLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblCityOnManualEntry, "<b>City label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyStateLabelOnManualEntry
     * description :: To verify State Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyStateLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblStateOnManualEntry, "<b>State label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyZipLabelOnManualEntry
     * description :: To verify Zip Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyZipLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblZipOnManualEntry, "<b>Zip label Name on Manual Entry</b>");

    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyMembershipNumberLabelOnManualEntry
     * description :: To verify Membership Number Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyMembershipNumberLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblMemberShipNumberOnManualEntry, "<b>MemberShip Number label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyMemberSinceLabelOnManualEntry
     * description :: To verify Member Since Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyMemberSinceLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblMemberSinceOnManualEntry, "<b>MemberSince  label Name on Manual Entry</b>");

    }

    /* public  void verifyMemberJoinDateOnManualEntry()throws Throwable {
     }*/

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyLevelLabelOnManualEntry
     * description :: To verify Level Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyLevelLabelOnManualEntry() throws Throwable {

        return isVisible(CRMemberSearchPage.lblLevelOnManualEntry, "<b>Level  label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTypeLabelOnManualEntry
     * description :: To verify Type Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyTypeLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblTypeOnManualEntry, "<b>Type  label Name on Manual Entry</b>");

    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyExpirationLabelOnManualEntry
     * description :: To verify Expiration Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyExpirationLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblExpirationOnManualEntry, "<b>Expiration  label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyStatusLabelOnManualEntry
     * description :: To verify Status Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyStatusLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblStatusOnManualEntry, "<b>Status  label Name on Manual Entry</b>");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyEmailLabelOnManualEntry
     * description :: To verify Email Label On ManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyEmailLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblEmailOnManualEntry, "<b>Email  label Name on Manual Entry</b>");

    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyPhoneInformationLabelOnManualEntry
     * description :: To verify Phone Information Label OnManualEntry
     * date :: 03-08-18
     * author :: Lakshmi Prasanna
     */
    public boolean verifyPhoneInformationLabelOnManualEntry() throws Throwable {
        return isVisible(CRMemberSearchPage.lblPhoneInformationOnManualEntry, "<b>PhoneInformation  label Name on Manual Entry</b>");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: ClickonMemberNumberToLoadTheCall
     * description :: To Click on Member Number To Load The Call
     * date :: 03-08-2018
     * author :: Lakshmi Prasanna
     */
    public void ClickonMemberNumberLink() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        click(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallIdToLoadTheCall
     * description :: To click On CallId To Load The Call
     * date :: 03-08-2018
     * author :: Lakshmi Prasanna
     */
    public void closeTheLoadedCall() throws Throwable {
        boolean alertCloseVisibility = isVisibleOnly(CRMemberSearchPage.alertClose, "Close Alert");
        if (alertCloseVisibility) {
            mouseDoubleClick(CRMemberSearchPage.alertClose, "Close Alert");
        }
        boolean scriptErrorAvailablity = isVisibleOnly(CRMemberSearchPage.scriptError, "Script Error OKAY button");
        if (scriptErrorAvailablity) {
            click(CRMemberSearchPage.scriptError, "Script error Okay button");
        }
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: getPhoneNumberValue
     * description :: To get phone number value in Member Tab
     * date :: 07/03/2018
     * author :: Abhiram
     */
    public String getPhoneNumberValue() throws Throwable {
        String phonenumber = getAttributeByValue(CRMemberSearchPage.txtPhone_NumberFirstRow, "PhoneNumber");
        return phonenumber;
    }

    /**
     * return ::void
     * methodName :: verifyLiveCallIDInMemberTab
     * Description:This method is to  verify Live call
     * date :: 07-03-2018
     * author :: Nidhi
     *
     * @throws Throwable
     */
    public boolean verifyInVisibilityOfCallIDInMemberTab() throws Throwable {
        //List<WebElement> callId = getWebElementList(CRMemberSearchPage.txtLiveCall, "Live call ID");
        boolean callidInvisibilityflag = waitForInVisibilityOfElement(CRMemberSearchPage.txtLiveCall, "Live call ID");
        return callidInvisibilityflag;
    }

    /**
     * return ::void
     * methodName :: verifyTheCreatedCall
     * Description:This method is used to verify the created call
     *
     * @param
     * @throws Throwable
     * @author :Abhiram
     * date :: 20-Dec-2017
     */
    public String verifyTheCreatedCall() throws Throwable {
        try {
            String callIdAndDateFromCurrentCallWindow = getText(CRMemberSearchPage.linkCallID, "Callid from current Calls");
            callIdAndDateFromCurrentCallWindow.split("\n");
            String splitStr[] = callIdAndDateFromCurrentCallWindow.split("\\n");
            String calliddetails = splitStr[1];
            String callIdValue[] = calliddetails.split("#");
            String splitedCallIDValue = callIdValue[1];
            //boolean verifyCallIds = callId.equals(splitedCallIDValue);
            //assertTrue(verifyCallIds, "Call created with member who is not present in Database");
            return splitedCallIDValue;
        } catch (Exception e) {
            return "NO CALLS FOUND";
        }
    }

    /**
     * return ::boolean
     * methodName :: veryfyCallCountForMember
     * Description:: This method is used to verify call count for member
     *
     * @param callsAllowedBeforeMemberCall
     * @param callsAllowedAfterMemberCall
     * @throws Throwable
     */
    public boolean veryfyCallCountForMember(String callsAllowedBeforeMemberCall, String callsAllowedAfterMemberCall) throws Throwable {
        boolean callcount = callsAllowedBeforeMemberCall.equals(callsAllowedAfterMemberCall);
        assertTrue(callcount, "call was Not counted against the member as an entitlement ");
        return callcount;

    }

    /**
     * return ::void
     * methodName :: verifyLiveCallIDInMemberTab
     * Description:This method is to  verify Live call
     * date :: 07-03-2018
     * author :: Nidhi
     *
     * @throws Throwable
     */
    public String verifyLiveCallIDInMemberTab() throws Throwable {
        dynamicWait(CRMemberSearchPage.txtLiveCall);
        String callId = getText(CRMemberSearchPage.txtLiveCall, "Live call ID");
        return callId;
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getCurrentAllPhoneNumbers
     * description ::
     * date :: 09-Mar-2018
     * author :: Abhiram
     */
    public void verifyPhoneNumberDeleted(String existingPhnNumber, String newPhoneNumber) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneNumber, "All Phone Numbers for Member Number");
        numberList = getWebElementList(CRMemberSearchPage.txtPhoneNumber, "All Phone Numbers for Member Number");
        if (numberList != null) {
            System.out.println(numberList.size());
            for (int i = 0; i < numberList.size(); i++) {
                numFromList = numberList.get(i).getAttribute("value");
                assertFalse(existingPhnNumber.equals(numFromList) || newPhoneNumber.equals(numFromList), "<b>Phone Number Entered :: " + existingPhnNumber + "and verified number is deleted from the  Member Contact Information List ::" + numFromList);
            }
        }
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getCurrentAllPhoneNumbers
     * description ::
     * date :: 09-Mar-2018
     * author :: Abhiram
     */
    public String enterPhoneNumer() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneNumber, "All Phone Numbers for Member Number");
        numberList = getWebElementList(CRMemberSearchPage.txtPhoneNumber, "All Phone Numbers for Member Number");
        String number = Integer.toString(numberList.size());
        return number;
    }
    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: verifyEditedPhoneNumberSavesInCallsList
     *  * description :: To verify Edited PhoneNumber SavesIn CallsList
     *  * date :: 19-Mar-2017
     *  * author ::Lakshmi
     *  
     */
    public boolean verifyEditedPhoneNumberSavesInCallsList(String editedPhoneNumber) throws Throwable {
        boolean phoneNumberFlag = true;

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneNumber, "All Phone Numbers for Member Number");
        numberList = getWebElementList(CRMemberSearchPage.txtPhoneNumber, "All Phone Numbers for Member Number");
        if (numberList != null) {
            System.out.println(numberList.size());
            for (int i = 0; i < numberList.size(); i++) {
                String numFromList = numberList.get(i).getAttribute("value");
                String num1 = numFromList.substring(1,4);
                String num2 = numFromList.substring(6,9);
                String num3 = numFromList.substring(10,14);
                String phoneNemuber = num1+num2+num3;

                if (phoneNemuber.equals(editedPhoneNumber)) {
                    phoneNumberFlag = false;
                }
            }
        }
        return phoneNumberFlag;
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContInfoSelectPrimPhoneTypeCellular
     *  * description :: To enter member primphone type
     *  * date :: 19-Mar-2017
     *  * author ::Abhiram
     *  
     */

    public void membContInfoSelectPrimPhoneTypeCellular() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneTypeFirstRecord, "Phonenumber type");
        selectByVisibleText(CRMemberSearchPage.txtPhoneTypeFirstRecord, "Cellular", "Phone number type");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberContactNumberPrimaryPhoneNumberRandomly
     * description :: To enter member primary phone number randomly
     * date :: 19-Mar-2018
     * author :: Abhiram
     */

    public void enterMemberContactNumberPrimaryPhoneNumberRandomly(String Primaryphonenum) throws Throwable {
        Thread.sleep(3000);

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhone_NumberSecondRow, "Primary phone number textbox");
        type(CRMemberSearchPage.txtPhone_NumberSecondRow, Primaryphonenum + generateRandomNumber(7), "Primary phone number textbox");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPhoneTypeandPhoneNumber
     * description :: To enter member primary phone number randomly
     * date :: 20-Mar-2018
     * author :: NIHDI
     */

    public void verifyPhoneTypeandPhoneNumber(String Primaryphonenum1) throws Throwable {
        if (getPhoneNumberFirstRecord().isEmpty()) {
            enterMemberContactNumberPrimaryPhoneNumberRandomly(Primaryphonenum1);
        }
        if (getPhoneTypeFirstRecord().isEmpty()) {

            membContInfoSelectPrimPhoneTypeCellular();
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberEmailCol
     * description :: To verify list of email
     * date :: 20-Mar-2018
     * author :: NIHDI
     */
    public void verifyMemberEmailCol(String membersearch) throws Throwable {
        Thread.sleep(2000);
        List<WebElement> allEmail = getWebElementList(CRMemberSearchPage.lblMemberContactColumnValue, "Email List");
        for (int i = 0; i < 8; i++) {

            String allEmailItems = allEmail.get(i).getText();
            Thread.sleep(2000);
            String allEmailItemsSplit[] = allEmailItems.split("\n");
            if (allEmailItemsSplit[1].equalsIgnoreCase(membersearch)) {
                assertTrue(true, "Given details Search Results are same" + allEmailItemsSplit[1]);
            }
        }

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberPhoneCol
     * description :: To verify list of phone
     * date :: 20-Mar-2018
     * author :: NIHDI
     */
    public void verifyMemberPhoneCol(String membersearch) throws Throwable {
        Thread.sleep(2000);
        List<WebElement> allPhone = getWebElementList(CRMemberSearchPage.lblMemberContactColumnValue, "Phone List");
        for (int i = 0; i < 8; i++) {

            String allPhoneItems = allPhone.get(i).getText();
            Thread.sleep(2000);
            String allPhoneItemsSplit[] = allPhoneItems.split("\n");

            if (allPhoneItemsSplit[0].equalsIgnoreCase(membersearch)) {
                assertTrue(true, "Given details Search Results are same" + allPhoneItemsSplit[0]);
            }
        }

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextFromScratchPad
     * description :: to get text from scratch pad
     * date :: 23-Mar-2018
     * author :: Madhukar
     * @return
     * @throws Throwable
     */
    public String getTextFromScratchPad() throws Throwable {

        String txtFromScratchPad = getAttributeByValue(CRMemberSearchPage.txtScratchPad, "Scratch Pad Area");
        return txtFromScratchPad;

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdInMemberSearch
     * description ::to get call id from the member search page after loading a call
     * date :: 31-Jan-2017
     * author ::Madhukar
     */
    public String getCallIdInMemberSearch() throws Throwable {
        getText(CRMemberSearchPage.lblDateInMemberPage, "call id and time");
        String callIdAndDate = getText(CRMemberSearchPage.lblDateInMemberPage, "Getting CallID From Member Tab");
        String splitStr[] = callIdAndDate.split(",");
        return splitStr[0].trim();
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: visibilityOfProcessSpinner
     * description ::
     * date :: 18-Apr-2018
     * author ::
     */
    public boolean visibilityOfProcessSpinner() throws Throwable {
        return isVisibleOnly(CRMemberSearchPage.iconResultLoadingSpinner,"Procesing SPinner");
    }
}
