package com.aaa.rspweb.lib;

import com.aaa.rspweb.pages.RSPHelpPage;

public class RSPHelpLib extends RSPCommonLib {







    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLeftPanelLinks
     * description :: To click on a link available on left panel
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnLeftPanelLinks(String linkName) throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.lnksLeftFrame(linkName),60);
        click(RSPHelpPage.lnksLeftFrame(linkName),linkName);
    }

    /**
     * param :: String
     * return ::boolean
     * throws :: throwable
     * methodName :: verifySectionHeadersVisible
     * description :: To verify particular page link title is visible or not
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean verifySectionHeadersVisible(String headerName) throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.verifySectionHeadersSameAsLeftPanelLinks(headerName),60);
        return isVisibleOnly(RSPHelpPage.verifySectionHeadersSameAsLeftPanelLinks(headerName),"Section headers "+headerName);
    }

    /**
     * param :: String
     * return ::String
     * throws :: throwable
     * methodName :: headerName
     * description :: To get particular page link title
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public String getSectionHeaders(String headerName) throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.verifySectionHeadersSameAsLeftPanelLinks(headerName),60);
        return getText(RSPHelpPage.verifySectionHeadersSameAsLeftPanelLinks(headerName),"<b>Navigated to "+headerName+"</b>");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectCategory
     * description :: To click on select category before selecting value
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */

    public void clickOnSelectCategory() throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.drpdwnClickCategory,60);
        click(RSPHelpPage.drpdwnClickCategory,"Select category");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectCategory
     * description :: enter category name to select the category
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void selectCategory(String categoryName) throws Throwable {
        clickOnSelectCategory();
        dynamicWaitByLocator(RSPHelpPage.selectCategoryFromDropdown(categoryName),60);
        mouseHover(RSPHelpPage.selectCategoryFromDropdown(categoryName),"Select category from dropdown");
        click(RSPHelpPage.selectCategoryFromDropdown(categoryName),"Select category from dropdown");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: sendTextToFeedback
     * description ::To enter text in feed back
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void sendTextToFeedback(String text) throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.txtareaFeedBack,60);
        type(RSPHelpPage.txtareaFeedBack,text,"Feedback text area");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTotalCharactersLeft
     * description :: to get total characters left
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public String  getTotalCharactersLeft() throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.lblTotalCharacetersRemaining,60);
        return getText(RSPHelpPage.lblTotalCharacetersRemaining,"Total characters left");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSend
     * description :: to click on send button
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */

    public void clickOnSend() throws Throwable {
        dynamicWaitByLocator(RSPHelpPage.btnClickOnSend, 60);
        click(RSPHelpPage.btnClickOnSend, "Send button");
    }


}
