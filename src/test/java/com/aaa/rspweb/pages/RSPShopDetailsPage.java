package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPShopDetailsPage {

    public static By btnEnabled=By.xpath("//*[text()='Enabled:']/../div");
    public static By lblPhoneNumber=By.xpath("//*[@title='Phone Number']/../div[2]");
    public static By lblFaxNumber=By.xpath("//*[@title='Fax Number']/../div[2]");
    public static By lblWebsite=By.xpath("//*[@title='Website']/../div[2]");
    public static By lblEmailAddress=By.xpath("//*[@title='Email Address']/../div[2]");
    public static By lblLanguagesSpoken=By.xpath("//*[@title='Languages Spoken']/../div[2]");
    public static By lblLocation=By.xpath("//*[text()='Location']/../../../..");
    public static By lblTimezone=By.xpath("//*[contains(text(),'Timezone:')]");
    public static By lblOperatingHoursDetailsServicesAndCapacity;


    public static By everydayOpenHours(String day)
    {
        String xpath="//*[text()='"+day+"']/../div[2]";
        lblOperatingHoursDetailsServicesAndCapacity=By.xpath(xpath);
        return lblOperatingHoursDetailsServicesAndCapacity;
    }
}
