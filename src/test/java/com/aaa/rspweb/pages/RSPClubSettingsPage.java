package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPClubSettingsPage {
    public static By actveTabClubSettings=By.xpath("//li[@class='active']//*[@title='Club Settings']");
	private static By drpdwnClubValueSelect;

    public static By selectClubFromDropdown(String clubId)
    {
        String xpath="//*[text()='Club:']/../..//*[contains(text(),'"+clubId+"')]";
        drpdwnClubValueSelect=By.xpath(xpath);
        return drpdwnClubValueSelect;
    }
}
