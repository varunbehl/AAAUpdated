package com.aaa.rspweb.pages;
import org.openqa.selenium.By;

public class RSPCreateUserDetailsPage {

    public static By btnEnabled=By.xpath("//*[text()='Enabled']");
    public static By btnDisabled=By.xpath("//*[text()='Disabled']");
    public static By txtUserName=By.xpath("//*[text()='Username']/..//input");
    public static By drpdwnSelectRole=By.xpath("//*[text()='Role']/..//select");
    public static By selectRole;
    public static By drpdwnSelectClubDisabled=By.xpath("//*[text()='Club']/..//select[@disabled]");
    public static By drpdwnSelectClub;
    public static By selectClub;
    public static By btnChooseShops=By.xpath("//*[text()='Choose Shops']/..");


    /*
    parameter value--Shop User,e.t.c...
     */
    public static By selectRoleFromDropdown(String role)
    {
        String xpath="//*[text()='Role']/..//select/*[text()='"+role+"']";
        selectRole=By.xpath(xpath);
        return selectRole;
    }

    /*
    parameter value--981 - Quality Assurance,e.t.c...
     */
    public static By selectClubFromDropdown(String Club)
    {
        String xpath="//*[text()='Club']/..//select/*[text()='"+Club+"']";
        selectClub=By.xpath(xpath);
        return selectClub;
    }
}

