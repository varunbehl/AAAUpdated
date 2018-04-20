package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPProfilePage {

    public static By btnAccountDetails=By.xpath("//*[text()=' Account Details']/../..");
    public static By btnGeneralSettings=By.xpath("//*[text()=' General Settings']/../..");
    public static By btnMobilePhoneNumbers=By.xpath("//*[text()=' Mobile Phone Numbers']/../..");
    public static By btnNotifications=By.xpath("//*[text()=' Notifications']/../..");
    public static By lblName=By.xpath("//*[text()='Name:']/..//div[2]");
    public static By lblEmail=By.xpath("//*[text()='Email:']/..//div[2]/a");
    public static By lblUserName=By.xpath("//*[text()='Username:']/..//div[2]");
    public static By lblPhoneNumber=By.xpath("//*[text()='Phone Number:']/..//div[2]");
    public static By lnkChangePassword=By.xpath("//*[text()=' Change Password']");
    public static By btnAudioAlerts=By.xpath("//*[text()='Audio Alerts']/../div[2]/div");
    public static By lblAddAndVerifyMobileNumber=By.xpath("//*[text()=' for use with notifications.']");
    public static By lnkTearmsAndConditions=By.xpath("//*[text()='Terms & Conditions']");
    public static By btnAddNewPhoneNumber=By.xpath("//*[text()='Add New Mobile Number']/..");
    public static By btnAddInAddNewPhoneNumberModelWindow=By.xpath("//*[text()='Add']");
    public static By btnTextOnOrOffInNotifications;
    public static By btnEmailOnOrOffInNotifications;
    public static By drpdwnOnlySendNotificationBetweenStartTime=By.xpath("//*[text()='Only send notifications between']/.//select[1]");
    public static By drpdwnOnlySendNotificationBetweenEndTime=By.xpath("//*[text()='Only send notifications between']/.//select[2]");
    public static By drpdwnSelectStartTime;
    public static By drpdwnSelectEndTime;
    public static By btnAddNewException=By.xpath("//*[text()='Add New Exception']/..");
    public static By chkboxEnabled;
    public static By drpdwnselectday=By.xpath("//*[text()='Enabled']/../../../div[2]//select");
    public static By drpdwnSelectDay;
    public static By btnAllDay;
    public static By drpdwnFromTimeInAllDay=By.xpath("//*[text()='From:']/..//select");
    public static By drpdwnToTimeInAllDay=By.xpath("//*[text()='To: ']/..//select");
    public static By selectFromTimeInAllDay;
    public static By selectToTimeInAllDay;
    public static By btnSendNotification;
    public static By btnDoNotDistrub;
    public static By btnDeleteIcon;

    /*
    parameter value should be like:: Inbound Tow-In
     */
    public static By clickOnTextOnOrOffInNotification(String rowName)
    {
        String xpath="//*[text()='"+rowName+"']/..//*[@class='pull-right text-center'][1]/div";
        btnTextOnOrOffInNotifications=By.xpath(xpath);
        return btnTextOnOrOffInNotifications;
    }

    /*
   parameter value should be like:: Inbound Tow-In
    */
    public static By clickOnEmailOnOrOffInNotification(String rowName)
    {
        String xpath="//*[text()='"+rowName+"']/..//*[@class='pull-right text-center'][2]/div";
        btnEmailOnOrOffInNotifications=By.xpath(xpath);
        return btnEmailOnOrOffInNotifications;
    }
    /*
    parameter value shoulb be like::"12:00 AM"
     */

    public static By selectStartTime(String time)
    {
        String xpath="//*[text()='Only send notifications between']/.//div[1]//div//select[1]/*[text()='"+time+"']";
        drpdwnSelectStartTime=By.xpath(xpath);
        return drpdwnSelectStartTime;
    }

    /*
    parameter value shoulb be like::"12:00 AM"
     */

    public static By selectEndTime(String time)
    {
        String xpath="//*[text()='Only send notifications between']/.//div[2]//div//select[1]/*[text()='"+time+"']";
        drpdwnSelectEndTime=By.xpath(xpath);
        return drpdwnSelectEndTime;
    }

     /*
    parameter value shoulb be like::"Sunday"
    rownumber=starts from "1";
     */

    public static By selectDay(String day,int rowNumber)
    {
        rowNumber=rowNumber+1;
        String xpath="//*[text()='Exceptions']/../div["+rowNumber+"]//*[text()='"+day+"']";
        drpdwnSelectDay=By.xpath(xpath);
        return drpdwnSelectDay;
    }

     /*
    rownumber=starts from "1";
     */

    public static By clickAllDay(int rowNumber)
    {
        rowNumber=rowNumber+1;
        String xpath="//*[text()='Exceptions']/../div["+rowNumber+"]//*[text()='All Day']/../..";
        btnAllDay=By.xpath(xpath);
        return btnAllDay;
    }

    /*
    rownumber=starts from "1";
     */

    public static By clickSendNotification(int rowNumber)
    {
        rowNumber=rowNumber+1;
        String xpath="//*[text()='Exceptions']/../div["+rowNumber+"]//*[text()='Send Notifications']/../..";
        btnSendNotification=By.xpath(xpath);
        return btnSendNotification;
    }

    /*
    rownumber=starts from "1";
     */

    public static By clickDoNotDistrub(int rowNumber)
    {
        rowNumber=rowNumber+1;
        String xpath="//*[text()='Exceptions']/../div["+rowNumber+"]//*[text()='Do Not Disturb']/../..";
        btnDoNotDistrub=By.xpath(xpath);
        return btnDoNotDistrub;
    }

    /*
    rownumber=starts from "1";
     */

    public static By clickDeleteIcon(int rowNumber)
    {
        rowNumber=rowNumber+1;
        String xpath="//*[text()='Exceptions']/../div["+rowNumber+"]//*[@class='fa fa-trash']";
        btnDeleteIcon=By.xpath(xpath);
        return btnDeleteIcon;
    }

    /*
    parameter value shoulb be like::"12:00 AM"
     */

    public static By selectFromTimeInAllDay(String time)
    {
        String xpath="//*[text()='From:']/..//select/*[text()='"+time+"']";
        selectFromTimeInAllDay=By.xpath(xpath);
        return selectFromTimeInAllDay;
    }

    /*
    parameter value shoulb be like::"12:00 AM"
     */

    public static By selectToTimeInAllDay(String time)
    {
        String xpath="//*[text()='To: ']/..//select/*[text()='"+time+"']";
        selectToTimeInAllDay=By.xpath(xpath);
        return selectToTimeInAllDay;
    }

    /*
    parameter value shoulb be like::"12:00 AM"
     */

    public static By clickCheckbox(int rowNumber)
    {
        rowNumber=rowNumber+1;
        String xpath="//*[text()='Exceptions']/../div["+rowNumber+"]/..//div[2]//input";
        chkboxEnabled=By.xpath(xpath);
        return chkboxEnabled;
    }
}
