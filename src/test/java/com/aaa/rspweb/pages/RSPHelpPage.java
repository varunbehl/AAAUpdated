package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPHelpPage {

    public static By lnksLeftframe;
    public static By lblSectionHeadersNamesSameAsLeftFrameLinks;
    //Creating a new repair order
    public static By btnWalkin;
    public static By btnTowin;

    //Creating a test repair order
    public static By btnCreateNewOrder;

    //Editing a repair order
    public static By lblInProgress;
    public static By lblInProgressInSecondLine;

    //Vehicle Arrival
    public static By lblReferred;
    public static By lblInBound;
    public static By lblNotArrived;

    //Feedback
    public static By drpdwnClickCategory=By.xpath("//*[text()='Category']/..//select");
    public static By drpdwnSelectCategory;
    public static By txtareaFeedBack=By.xpath("//*[@placeholder='Enter your feedback here']");
    public static By lblTotalCharacetersRemaining=By.xpath("//*[text()=' characters remaining)']");
    public static By btnClickOnSend=By.xpath("//*[@class='fa fa-send']/../..");
    public static By btnSendDisabled=By.xpath("//*[@class='fa fa-send']/.././/*[@class='fa fa-send']/../../[@disable]");


    static
    {
        btnWalkin=By.xpath("//*[text()='Walk-In']/..");
        btnTowin=By.xpath("//*[text()='Tow-In']/..");
        btnCreateNewOrder=By.xpath("//*[text()='Click here to Create Test Order']/..");
        lblInProgress=By.xpath("//*[text()='Only repair orders that are ']/../li[1]/span");
        lblInProgressInSecondLine=By.xpath("//*[text()='Only repair orders that are ']/../li[2]/span");

        lblReferred=By.xpath("//*[text()='Only repair orders in ']/../li[2]/span[1]");
        lblInBound=By.xpath("//*[text()='Only repair orders in ']/../li[2]/span[2]");
        lblNotArrived=By.xpath("//*[text()='Only repair orders in ']/../li[2]/span[2]");

    }

     //Selecting lnks from leftframe
    //names are 1.Contact AAA Club,2.Creating a New Repair Order,3.Creating a Test Repair Order
    //4.Editing a Repair Order,5.Vehicle Arrival,6.Repair Order Statuses,7.Icons,8.Feedback
    public static By lnksLeftFrame(String lnkName) {
        String xpath = "//*[@class='nav nav-stacked']//*[text()='" + lnkName + "']";
        lnksLeftframe = By.xpath(xpath);
        return lnksLeftframe;
    }

    public static By verifySectionHeadersSameAsLeftPanelLinks(String name)
    {
        String xpath="//*[text()='"+name+"']/..";
        return lblSectionHeadersNamesSameAsLeftFrameLinks=By.xpath(xpath);
    }

    public static By selectCategoryFromDropdown(String CategoryName)
    {
        String xpath="//*[text()='Category']/..//*[text()='"+CategoryName+"']";
        return drpdwnSelectCategory=By.xpath(xpath);
    }
}
