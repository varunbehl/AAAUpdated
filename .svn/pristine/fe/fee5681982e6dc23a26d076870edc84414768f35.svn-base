package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPVehicleInspectionPage {

    public static By lnkLeftLayout;
    public static By btnPrint = By.xpath("//*[@id='prompt-inspection-form']//button[1]");
    public static By btnMessege = By.xpath("//*[@id='prompt-inspection-form']//button[2]");
    public static By btnResetValues = By.xpath("//*[text()='Reset Values']/..");
    public static By btnSaveInspectionDisabled = By.xpath("//*[@class='btn btn-success'][@disabled]");
    public static By imgSymbolsWithSingleRow;
    public static By imgSymbolWithMultipleRows;
    public static By btnCancelInInspection=By.xpath("//*[text()='Cancel']/..");
    public static By btnSaveInspectionEnabled=By.xpath("//*[text()='Save Inspection']/..");
    public static By valuePercentage;
    public static By txtEnterEmailInEmailInspectionWindow=By.xpath("//*[@id='email-input']");
    public static By btnSendInEmailInspectionWindow=By.xpath("//*[text()=' Send']/..");
    public static By lblPleaseEnterValidEmailInEmailInspectionWindow=By.xpath("//*[@id='email-input']/../../../span");
    public static By errorWindowInVehicleInspection=By.xpath("//*[@class='notification notification-error notification-visible']");

    /*
    parameter value is like:-General Inspection
     */
    public static By leftFrameLinks(String linkName) {
        String xpath = "//*[text()='" + linkName + "']/../..";
        lnkLeftLayout = By.xpath(xpath);
        return lnkLeftLayout;
    }

    /*
    parameter value is like:-row name(Horn)
    symbol name-->N/A==>NA,Green smile==>perfect,Orange smile==>good,red==>bad
     */

    public static By imgSingleRow(String rowName, String symbolName) {
        String xpath;

        switch (symbolName) {
            case "NA":
                xpath = "//*[text()='" + rowName + "']/../../td[4]";
                imgSymbolsWithSingleRow = By.xpath(xpath);
                break;

            case "perfect":
                xpath = "//*[text()='" + rowName + "']/../../td[5]";
                imgSymbolsWithSingleRow = By.xpath(xpath);
                break;

            case "good":
                xpath = "//*[text()='" + rowName + "']/../../td[6]";
                imgSymbolsWithSingleRow = By.xpath(xpath);
                break;

            case "bad":
                xpath = "//*[text()='" + rowName + "']/../../td[7]";
                imgSymbolsWithSingleRow = By.xpath(xpath);
                break;
        }
        return imgSymbolsWithSingleRow;
    }

    /*
    parameter value is like:-row name(left,right,level,pump,e.t.c..)
    symbol name-->N/A==>NA,Green smile==>perfect,Orange smile==>good,red==>bad
     */

    public static By imgMultipleRows(String rowValue,String symbolName)
    {
        String xpath;

        switch(symbolName) {
            case "NA":
                xpath = "//*[text()='"+rowValue+"']/.././td[4]}";
                imgSymbolWithMultipleRows = By.xpath(xpath);
                break;

            case "perfect":
                xpath = "//*[text()='"+rowValue+"']/.././td[5]}";
                imgSymbolWithMultipleRows = By.xpath(xpath);
                break;

            case "good":
                xpath = "//*[text()='"+rowValue+"']/.././td[6]}";
                imgSymbolWithMultipleRows = By.xpath(xpath);
                break;

            case "bad":
                xpath = "//*[text()='"+rowValue+"']/.././td[7]}";
                imgSymbolWithMultipleRows = By.xpath(xpath);
                break;
        }
        return imgSymbolWithMultipleRows;
    }


    /*
    parameter value is like:-General Inspection
     */
    public static By leftAlignmentLinksPercentage(String linkName) {
        String xpath = "//*[text()='"+linkName+"']//span";
        valuePercentage = By.xpath(xpath);
        return valuePercentage;
    }
}

