package com.aaa.rspweb.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.rspweb.pages.RSPProfilePage;

public class RSPProfileLib extends RSPCommonLib {

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAccountDetails
     * description :: click on account details
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnAccountDetails() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnAccountDetails,60);
        click(RSPProfilePage.btnAccountDetails,"Account details");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnGeneralSettings
     * description :: clicks on general settings
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnGeneralSettings() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnGeneralSettings,60);
        click(RSPProfilePage.btnGeneralSettings,"General settings");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMobilePhoneNumber
     * description :: clicks on mobile phone number
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnMobilePhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnMobilePhoneNumbers,60);
        click(RSPProfilePage.btnMobilePhoneNumbers,"Mobile phone number");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNotification
     * description :: clicks on button notifications
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnNotification() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnNotifications,60);
        click(RSPProfilePage.btnNotifications,"Notification");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getName
     * description :: returns name
     * date :: 
     * author :: Jagadish Pola
     */
    public String getName() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lblName,60);
        return getText(RSPProfilePage.lblName,"Name");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getEmail
     * description :: returns email
     * date :: 
     * author :: Jagadish Pola
     */

    public String getEmail() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lblEmail,60);
        return getText(RSPProfilePage.lblEmail,"Email");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getUserName
     * description :: returns user name
     * date :: 
     * author :: Jagadish Pola
     */

    public String getUserName() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lblUserName,60);
        return getText(RSPProfilePage.lblUserName,"User name");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPhoneNumber
     * description :: returns phone number
     * date :: 
     * author :: Jagadish Pola
     */

    public String getPhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lblPhoneNumber,60);
        return getText(RSPProfilePage.lblPhoneNumber,"Phone number");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkChangePassword
     * description :: clicks on link change password
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnLinkChangePassword() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lnkChangePassword,60);
        click(RSPProfilePage.lnkChangePassword,"Change password");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAudioAlert
     * description :: clicks on audio alert
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnAudioAlert() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnAudioAlerts,60);
        click(RSPProfilePage.btnAudioAlerts,"Audio alert");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyAudioAlertIsOnOrOff
     * description :: verifies audio alert is on or off
     * date :: 
     * author :: Jagadish Pola
     */

    public String verifyAudioAlertIsOnOrOff() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnAudioAlerts,60);
        return getAttributeByClass(RSPProfilePage.btnAudioAlerts,"Audio alert");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getAddAndVerifyMobileNumberIfNoNumberFound
     * description :: returns mobile number
     * date :: 
     * author :: Jagadish Pola
     */

    public String getAddAndVerifyMobileNumberIfNoNumberFound() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lblAddAndVerifyMobileNumber,60);
        return getText(RSPProfilePage.lblAddAndVerifyMobileNumber,"Add and verify phone number");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkTearmsAndConditions
     * description :: clicks on link terms and conditions
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnLinkTearmsAndConditions() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.lnkTearmsAndConditions,60);
        click(RSPProfilePage.lnkTearmsAndConditions,"Tearms and Conditions");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddNewPhoneNumber
     * description :: clicks on link add new phone number
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnAddNewPhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnAddNewPhoneNumber,60);
        click(RSPProfilePage.btnAddNewPhoneNumber,"Add new phone number");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddButtonInModalWindow
     * description :: clicks on button add in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnAddButtonInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnAddInAddNewPhoneNumberModelWindow,60);
        click(RSPProfilePage.btnAddInAddNewPhoneNumberModelWindow,"Add phone number");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnTextOnOrOffInNotification
     * description :: clicks on Button to on or off
     * date :: 
     * author :: Jagadish Pola
     */

    /*
    parameter value should be like:: Inbound Tow-In
     */

    public void ClickOnTextOnOrOffInNotification(String rowName) throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.clickOnTextOnOrOffInNotification(rowName),60);
        click(RSPProfilePage.clickOnTextOnOrOffInNotification(rowName),"Text on or off notification");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTextOnOrOffInNotification
     * description ::verifyies text notification button is on or not
     * date :: 
     * author :: Jagadish Pola
     */

    /*
    parameter value should be like:: Inbound Tow-In
     */

    public String verifyTextOnOrOffInNotification(String rowName) throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.clickOnTextOnOrOffInNotification(rowName),60);
        return getAttributeByClass(RSPProfilePage.clickOnTextOnOrOffInNotification(rowName),"Text on or off notification");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnEmailOnOrOffInNotification
     * description :: clicks on email notification on or to off
     * date :: 
     * author :: Jagadish Pola
     */

    /*
    parameter value should be like:: Inbound Tow-In
     */

    public void ClickOnEmailOnOrOffInNotification(String rowName) throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.clickOnEmailOnOrOffInNotification(rowName),60);
        click(RSPProfilePage.clickOnEmailOnOrOffInNotification(rowName),"Text on or off notification");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmailOnOrOffInNotification
     * description :: verify email notification is on or off
     * date :: 
     * author :: Jagadish Pola
     */

    /*
    parameter value should be like:: Inbound Tow-In
     */

    public String verifyEmailOnOrOffInNotification(String rowName) throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.clickOnEmailOnOrOffInNotification(rowName),60);
        return getAttributeByClass(RSPProfilePage.clickOnEmailOnOrOffInNotification(rowName),"Text on or off notification");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownStartTime
     * description :: clicks on drop down start time
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownStartTime() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.drpdwnOnlySendNotificationBetweenStartTime,60);
        click(RSPProfilePage.drpdwnOnlySendNotificationBetweenStartTime,"Start Time");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownEndTime
     * description :: clicks on drop down end time
     * date ::
     * author :: Jagadish Pola
     */

    public void clickOnDropdownEndTime() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.drpdwnOnlySendNotificationBetweenEndTime,60);
        click(RSPProfilePage.drpdwnOnlySendNotificationBetweenEndTime,"End Time");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectStartTime
     * description :: selects the start tim from drop down
     * date :: 
     * author :: Jagadish Pola
     */

    /*
   parameter value shoulb be like::"12:00 AM"
    */

    public void selectStartTime(String time) throws Throwable {
        clickOnDropdownStartTime();
        dynamicWaitByLocator(RSPProfilePage.selectStartTime(time),60);
        selectByValue(RSPProfilePage.selectStartTime(time),time,"Start Time");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectEndTime
     * description :: selects the end tme from drop down
     * date :: 
     * author :: Jagadish Pola
     */

    /*
    parameter value shoulb be like::"12:00 AM"
     */

    public void selectEndTime(String time) throws Throwable {
        clickOnDropdownEndTime();
        dynamicWaitByLocator(RSPProfilePage.selectEndTime(time),60);
        selectByValue(RSPProfilePage.selectEndTime(time),time,"End Time");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddNewException
     * description :: clicks on add new exception
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnAddNewException() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.btnAddNewException,60);
        click(RSPProfilePage.btnAddNewException,"Add new exception");
    }
    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: clickCheckbox
     * description :: clicks on checkbox
     * date :: 
     * author :: Jagadish Pola
     */


    public void clickCheckbox(int rowNumber) throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.clickCheckbox(rowNumber),60);
        click(RSPProfilePage.clickCheckbox(rowNumber),"Click on check box");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownSelectDay
     * description :: clicks on drop down select day
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownSelectDay() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.drpdwnselectday,60);
        click(RSPProfilePage.drpdwnselectday,"Click on select day dropdown");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectDay
     * description :: selects day from drop down
     * date :: 
     * author :: Jagadish Pola
     */
    /*
    parameter value shoulb be like::"Sunday"
    rownumber=starts from "1";
     */
    public void selectDay(String day,int rowNumber) throws Throwable {
        clickOnDropdownSelectDay();
        dynamicWaitByLocator(RSPProfilePage.selectDay(day,rowNumber));
        selectByValue(RSPProfilePage.selectDay(day,rowNumber),day,"Select day");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickAllDay
     * description :: clicks on all days
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickAllDay(int rowNumber) throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.clickAllDay(rowNumber),60);
        click(RSPProfilePage.clickAllDay(rowNumber),"Click on all day");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownFromTimeInAllDay
     * description :: clicks on drop down start time in all day
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDropdownFromTimeInAllDay() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.drpdwnFromTimeInAllDay,60);
        click(RSPProfilePage.drpdwnFromTimeInAllDay,"Click on select from time in all day");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownToTimeInAllDay
     * description :: clicks on drop down end time in all day
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnDropdownToTimeInAllDay() throws Throwable {
        dynamicWaitByLocator(RSPProfilePage.drpdwnToTimeInAllDay,60);
        click(RSPProfilePage.drpdwnToTimeInAllDay,"Click on select to time in all day");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectFromTimeInAllDay
     * description :: selects start time in all day
     * date :: 
     * author :: Jagadish Pola
     */
    /*
    parameter value should be like::"12:00 AM"
     */

    public void selectFromTimeInAllDay(String time) throws Throwable {
        clickOnDropdownFromTimeInAllDay();
        dynamicWaitByLocator(RSPProfilePage.selectFromTimeInAllDay(time),60);
        click(RSPProfilePage.selectFromTimeInAllDay(time),"Select from time in all day");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectToTimeInAllDay
     * description :: selects end time in drop down
     * date :: 
     * author :: Jagadish Pola
     */
    public void selectToTimeInAllDay(String time) throws Throwable {
        clickOnDropdownFromTimeInAllDay();
        dynamicWaitByLocator(RSPProfilePage.selectToTimeInAllDay(time),60);
        click(RSPProfilePage.selectToTimeInAllDay(time),"Select to time in all day");
    }

    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSendNotification
     * description :: clicks on send notification
     * date :: 
     * author :: Jagadish Pola
     */
    /*
    rownumber=starts from "1";
     */
    public void clickOnSendNotification(int rowNumber) throws Throwable {
        clickOnDropdownFromTimeInAllDay();
        dynamicWaitByLocator(RSPProfilePage.clickSendNotification(rowNumber),60);
        click(RSPProfilePage.clickSendNotification(rowNumber),"Click send notification");
    }
    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDoNotDistrub
     * description :: clicks on do not distrub
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDoNotDistrub(int rowNumber) throws Throwable {
        clickOnDropdownFromTimeInAllDay();
        dynamicWaitByLocator(RSPProfilePage.clickDoNotDistrub(rowNumber),60);
        click(RSPProfilePage.clickDoNotDistrub(rowNumber),"Do not distrub buton");
    }
    /**
     * param :: int
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDeleteIcon
     * description :: clicks on delete icon
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnDeleteIcon(int rowNumber) throws Throwable {
        clickOnDropdownFromTimeInAllDay();
        dynamicWaitByLocator(RSPProfilePage.clickDeleteIcon(rowNumber),60);
        click(RSPProfilePage.clickDeleteIcon(rowNumber),"Delete icon");
    }

}
