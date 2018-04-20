package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPShopSettingsPage {
    public static By btnSwitchOnOrOffInAllowEmailAndPhoneNotifications=By.xpath("//*[text()='Allow Email and Phone Notifications:']/../../../div[2]/div");
    public static By txtShopEmailReplyAddress=By.xpath("//*[text()='Shop Email Reply Address:']/../../..//input");
    public static By txtShopEmailReplyAddressTickMark=By.xpath("//*[text()='Shop Email Reply Address:']/../../../div[2]//span//span");
    public static By drpdwnSelectShop=By.xpath("//*[text()='Shop:']/../..//select");
    public static By drpdwnShopValueSelect;
    public static By lnkViewShopDetails=By.xpath("//*[text()='View Shop Details']/..");
    public static By actveTabShopSettings=By.xpath("//li[@class='active']//*[@title='Shop Settings']");

    public static By selectShopFromDropdown(String shopId)
    {
        String xpath="//*[text()='Shop:']/../..//*[contains(text(),'"+shopId+"')]";
        drpdwnShopValueSelect=By.xpath(xpath);
        return drpdwnShopValueSelect;
    }
}
