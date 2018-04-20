package com.aaa.rspweb.lib;

import com.aaa.rspweb.pages.RSPManageUserPage;
import com.aaa.rspweb.pages.RSPUserDetailsPage;

import java.util.List;

import org.openqa.selenium.WebElement;

public class RSPManageUserLib extends RSPCommonLib{

	/**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropdownSelectShop
     * description :: click on select shop from dropdown
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnDropdownSelectShop() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.drpdwmSelectShop,60);
        click(RSPManageUserPage.drpdwmSelectShop,"Click on select shop");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectShopOrClubOrRoleFromDropdown
     * description :: select shopOrClub role
     * date :: 
     * author :: Jagadish Pola
     */
    public String clickAndSelectShopOrClubOrRoleFromDropdown(String dropdownValue) throws Throwable {
        clickOnDropdownSelectShop();
        dynamicWaitByLocator(RSPManageUserPage.selectValueFromDropdown(dropdownValue),60);
        selectByValue(RSPManageUserPage.selectValueFromDropdown(dropdownValue),dropdownValue,"Select value from dropdown");
        return dropdownValue;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectShopsToDisplay
     * description :: click on shop to display
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnSelectShopsToDisplay() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.btnSelectShop,60);
        click(RSPManageUserPage.btnSelectShop,"Click on select shop");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterValueIntoFindShops
     * description :: enter shop name to find out the shop
     * date :: 
     * author :: Jagadish Pola
     */
    public void enterValueIntoFindShops(String shopName) throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.txtFindShops,60);
        type(RSPManageUserPage.txtFindShops,shopName,"Search for shop");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTotalNumberOfShopsSelected
     * description :: returns total number of shops selected
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalNumberOfShopsSelected() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblTotalNumberOfShopsSelected,60);
        return getText(RSPManageUserPage.lblTotalNumberOfShopsSelected,"Total shops selected");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTotalNumberOfShops
     * description :: returns total number of shops
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalNumberOfShops() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblTotalShops,60);
        return getText(RSPManageUserPage.lblTotalShops,"Total shops");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnUnselectAllLink
     * description :: click on unselect all shops link
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnUnselectAllLink() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lnkUnselectAll,60);
        click(RSPManageUserPage.lnkUnselectAll,"Click on unselect all shops link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCheckboxToUnselectAShop
     * description :: click on checkbox to unselect a shop
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCheckboxToUnselectAShop() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.chkboxShopSelected,60);
        click(RSPManageUserPage.chkboxShopSelected,"Click on checkbox to unselect a shop");
    }

    /**
     * param :: List
     * return ::void
     * throws :: throwable
     * methodName :: getNamesOfShopsSelected
     * description :: returns all shops selected
     * date :: 
     * author :: Jagadish Pola
     */
    public List getNamesOfShopsSelected() throws Throwable {
        List totalShopsSelected=getNamesFromSelectOptions(RSPManageUserPage.lblSelectedShop,"Selected shops");
        return totalShopsSelected;
    }

    /**
     * param :: List
     * return ::void
     * throws :: throwable
     * methodName :: getAllShopsInList
     * description :: returns all sh inops list
     * date :: 
     * author :: Jagadish Pola
     */
    public List getAllShopsInList() throws Throwable {
        List totalShops=getNamesFromSelectOptions(RSPManageUserPage.lblAllShops,"Total shops");
        return totalShops;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCheckboxToSelectAShop
     * description :: click on select shop checkbox
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCheckboxToSelectAShop() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.chkboxAllShops,60);
        click(RSPManageUserPage.chkboxAllShops,"Click on checkbox to select a shop");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectAllLink
     * description :: clicks on select all users link
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnSelectAllLink() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lnkSelectAll,60);
        click(RSPManageUserPage.lnkSelectAll,"Click on select all link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRefreshButton
     * description :: clicks on refresh button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnRefreshButton() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.btnRefresh,60);
        click(RSPManageUserPage.btnRefresh,"Click on refresh button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTotalUsers
     * description :: clicks on total users
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnTotalUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxTotalUsers,60);
        click(RSPManageUserPage.lblboxTotalUsers,"Click on total user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getTotalUsers
     * description :: gets total number of users
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxTotalUsers,60);
        return getText(RSPManageUserPage.lblboxTotalUsers,"Get total user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyTotalUsersSelected
     * description :: verifies totalusers selected or not
     * date :: 
     * author :: Jagadish Pola
     */
    public String verifyTotalUsersSelected() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxTotalUsers,60);
        return getCssValue(RSPManageUserPage.lblboxTotalUsers,"background-color");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEnabledUsers
     * description :: clicks on enabled users
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnEnabledUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxEnabledUsers,60);
        click(RSPManageUserPage.lblboxEnabledUsers,"Click on enable user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getTotalNumberOfEnabledUsers
     * description :: returns total number of enabled users
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalNumberOfEnabledUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxEnabledUsers,60);
        return getText(RSPManageUserPage.lblboxEnabledUsers,"Get total number of enable user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyEnableUsersSelected
     * description :: verifies enable users are selected
     * date :: 
     * author :: Jagadish Pola
     */
    public String verifyEnableUsersSelected() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxEnabledUsers,60);
        return getCssValue(RSPManageUserPage.lblboxEnabledUsers,"background-color");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLockedUsers
     * description :: clicks on locked users
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnLockedUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxLockedUsers,60);
        click(RSPManageUserPage.lblboxLockedUsers,"Click on locked user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getTotalNumberOfLockedUsers
     * description :: returns total number of locked users
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalNumberOfLockedUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxLockedUsers,60);
        return getText(RSPManageUserPage.lblboxLockedUsers,"Get total number of locked user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyLockedUsersSelected
     * description :: verifies locked users are selected
     * date :: 
     * author :: Jagadish Pola
     */
    public String verifyLockedUsersSelected() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxLockedUsers,60);
        return getCssValue(RSPManageUserPage.lblboxLockedUsers,"background-color");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnActiveToday
     * description :: clicks on active today
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnActiveToday() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxActiveToday,60);
        click(RSPManageUserPage.lblboxActiveToday,"Click on active today");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getTotalNumberOfActiveTodayUsers
     * description :: returns total number of Active today users
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalNumberOfActiveTodayUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxActiveToday,60);
        return getText(RSPManageUserPage.lblboxActiveToday,"Get total number of active today user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyActiveTodaySelected
     * description :: verifies active todey button is selected or not
     * date :: 
     * author :: Jagadish Pola
     */
    public String verifyActiveTodaySelected() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxActiveToday,60);
        return getCssValue(RSPManageUserPage.lblboxActiveToday,"background-color");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnIdle
     * description :: clicks on IDLE button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnIdle() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxIdel,60);
        click(RSPManageUserPage.lblboxIdel,"Click on Idle");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getTotalNumberOfIdleUsers
     * description :: returns total number of idle users
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTotalNumberOfIdleUsers() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxIdel,60);
        return getText(RSPManageUserPage.lblboxIdel,"Get total number of idel user's");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: verifyIdelIsSelected
     * description :: verifies idel is selected or not
     * date :: 
     * author :: Jagadish Pola
     */
    public String verifyIdelIsSelected() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.lblboxIdel,60);
        return getCssValue(RSPManageUserPage.lblboxIdel,"background-color");
    }

    /**
     * param :: List
     * return ::void
     * throws :: throwable
     * methodName :: getTableHeaderInRSPManageUser
     * description :: return table headers in RSPManageUser
     * date :: 
     * author :: Jagadish Pola
     */
    //Headers
    public List getTableHeaderInRSPManageUser() throws Throwable {
        List tableHeaders=getTableDataByRow(RSPManageUserPage.tableHeadersInManageUser,"Table headers");
        return tableHeaders;
    }

    /**
     * param :: List
     * return ::void
     * throws :: throwable
     * methodName :: getTableDateInRSPManageUser
     * description :: gets the Table Data In RSPManageUser
     * date :: 
     * author :: Jagadish Pola
     */
    public List getTableDataInRSPManageUser() throws Throwable {
        List tableData=getTableDataByRow(RSPManageUserPage.tabledata,"Table data");
        return tableData;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNewUser
     * description :: clicks on new user button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnNewUser() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.btnNewUser,60);
        click(RSPManageUserPage.btnNewUser,"Click on new user");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHideOrShow
     * description :: clicks on hide or show button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnHideOrShow() throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.btnHideOrShowSummary,60);
        click(RSPManageUserPage.btnHideOrShowSummary,"Click on new user");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueIntoFilterByNameOrUserName
     * description :: helps to filter the shops based on name
     * date :: 
     * author :: Jagadish Pola
     */
    public void enterValueIntoFilterByNameOrUserName(String shopName) throws Throwable {
        dynamicWaitByLocator(RSPManageUserPage.txtFilterByNameOrUsername,60);
        type(RSPManageUserPage.txtFilterByNameOrUsername,shopName,"Search for shop");
    }
    
	public void validateLoginRecords()  throws Throwable{
		int numOfLogins=getElementsSize(RSPManageUserPage.loginRecords);
		if (numOfLogins<=20) {
			reporter.SuccessReport("Max number of login audits that can be displayed is 20", "The number of current login audits is "+numOfLogins);
		} else {
			reporter.failureReport("Max number of login audits that can be displayed is 20", "The number of current login audits is "+numOfLogins, driver);
		}
	}
	
	/**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueIntoFilterByNameOrUserName
     * description :: helps to filter the shops based on name
     * date :: 
     * author :: Jagadish Pola
     */
	public void clickOnUserProfile(String userName) throws Throwable {
		dynamicWaitByLocator(RSPManageUserPage.getUserProfile(userName), 60);
		click(RSPManageUserPage.getUserProfile(userName), "Click on user profile "+ userName);
	}
	

    
}