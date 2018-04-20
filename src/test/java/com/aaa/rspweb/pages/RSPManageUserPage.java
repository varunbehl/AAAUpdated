package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPManageUserPage {

    public static By drpdwmSelectShop=By.xpath("//select/*[text()='Shop']/..");
    public static By drpdwnSelect;
    public static By btnSelectShop=By.xpath("//*[text()='All']/..");
    public static By txtFindShops=By.xpath("//*[@placeholder='Find shops...']");
    public static By lblTotalNumberOfShopsSelected=By.xpath("//*[text()='Selected']/..//span[1]");
    public static By lnkUnselectAll=By.xpath("//*[text()='Selected']/..//span[2]");
    public static By chkboxShopSelected=By.xpath("//*[text()='Selected']/..//ul//span[1]");
    public static By lblSelectedShop=By.xpath("//*[text()='Selected']/..//ul//li");
    public static By lblAllShops=By.xpath("//*[text()='All Shops']/..//ul//li");
    public static By chkboxAllShops=By.xpath("//*[text()='All Shops']/..//ul//li/span[1]");
    public static By lnkSelectAll=By.xpath("//*[text()='Select All']");
    public static By btnRefresh=By.xpath("//*[text()='Refresh']/..");
    public static By lblboxTotalUsers=By.xpath("//*[text()='Total Users']/..");
    public static By lblboxEnabledUsers=By.xpath("//*[text()='Enabled Users']/..");
    public static By lblboxLockedUsers=By.xpath("//*[text()='Locked Users']/..");
    public static By lblboxActiveToday=By.xpath("//*[text()='Active Today']/..");
    public static By lblboxIdel=By.xpath("//*[text()='Idle']/..");
    public static By tableHeadersInManageUser=By.xpath("//*[@title='Username']/../th");
    public static By tabledata=By.xpath("//*[@id='table-body-Users']/tr/td");
    public static By btnNewUser=By.xpath("//*[text()='New User']/..");
    public static By txtFilterByNameOrUsername=By.xpath("//*[@placeholder='Filter by name or username']");
    public static By btnHideOrShowSummary=By.xpath("//*[text()=' Summary']");
    public static By lblTotalShops=By.xpath("//*[text()='All Shops']/..//span[1]");
    public static By lblLastLoginTime=By.xpath("//tbody[@id='table-body-Logins']//tr[1]/td[1]");
    public static By lblLastLogoutTime=By.xpath("//tbody[@id='table-body-Logins']//tr[1]/td[2]");
    public static By loginRecords=By.xpath("//tbody[@id='table-body-Users']//tr");
 
   
    
	private static By lblUserProfile;



    public static By selectValueFromDropdown(String name)
    {
        String xpath="//select/*[text()='"+name+"']";
        drpdwnSelect=By.xpath(xpath);
        return drpdwnSelect;
    }
    
    
    public static By getUserProfile(String userName){
    	lblUserProfile=By.xpath("//td[@title='"+userName+"']");
		return lblUserProfile;
    	
    }
    
}
