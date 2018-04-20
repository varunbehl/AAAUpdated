package com.aaa.rspweb.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.rspweb.pages.RSPShopSettingsPage;

public class RSPShopSettingsLib extends ActionEngine{


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSwitchOnOrOffInAllowEmailAndPhoneNotifications
     * description :: To click on swich to enable/disable notification through phone/email
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickSwitchOnOrOffInAllowEmailAndPhoneNotifications() throws Throwable {
        dynamicWaitByLocator(RSPShopSettingsPage.btnSwitchOnOrOffInAllowEmailAndPhoneNotifications,60);
        click(RSPShopSettingsPage.btnSwitchOnOrOffInAllowEmailAndPhoneNotifications,"Click on switch on or off notification");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getShopEmailReplyAddress
     * description :: To the shop's email address
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public String getShopEmailReplyAddress() throws Throwable {
        dynamicWaitByLocator(RSPShopSettingsPage.txtShopEmailReplyAddress,60);
        return getText(RSPShopSettingsPage.txtShopEmailReplyAddress,"Shop email reply address");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getShopEmailReplyAddressTickMark
     * description :: Tick mark which verifies the email id is valid or not.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean getShopEmailReplyAddressTickMark() throws Throwable {
        dynamicWaitByLocator(RSPShopSettingsPage.txtShopEmailReplyAddressTickMark,60);
        return isVisible(RSPShopSettingsPage.txtShopEmailReplyAddressTickMark,"Shop email reply address tick mark");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickDropdownSelectShop
     * description :: To click on the dropdown select shop
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */

    public void clickDropdownSelectShop() throws Throwable {
        dynamicWaitByLocator(RSPShopSettingsPage.drpdwnSelectShop,60);
        click(RSPShopSettingsPage.drpdwnSelectShop,"Click on drop down select shop");
    }

    /**
     * param :: shopId
     * return ::void
     * throws :: throwable
     * methodName :: selectShopFromDropdown
     * description :: To select a shop from dropdown.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param value :: eg:- shopId(083116,e.t.c....)
     */
    public void selectShopFromDropdown(String shopId) throws Throwable {
        dynamicWaitByLocator(RSPShopSettingsPage.selectShopFromDropdown(shopId),60);
        mouseHover(RSPShopSettingsPage.selectShopFromDropdown(shopId),"Select shop");
        click(RSPShopSettingsPage.selectShopFromDropdown(shopId),"Select shop");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkViewShopDetails
     * description :: To click on link view shop details
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */

    public void clickOnLinkViewShopDetails() throws Throwable {
        dynamicWaitByLocator(RSPShopSettingsPage.lnkViewShopDetails,60);
        click(RSPShopSettingsPage.lnkViewShopDetails,"Click on view shop details");
    }
}
