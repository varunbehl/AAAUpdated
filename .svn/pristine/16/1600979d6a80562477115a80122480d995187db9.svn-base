package com.aaa.d3itu.page;

import org.openqa.selenium.By;

public class TowDestinationPage {

    public static By serviceTip;
    public static By chooseTowDestinationType;
    public static By lnkTowDestination;
    public static By btnContinue;
    public static By enterNameforDestination;
    public static By enterAddressForDestination;
    public static By enterCityForDestination;
    public static By selectStateforDestination;
    public static By clickOnState;
    public static By searchButton;
    public static By errorPopup;


    static {

        serviceTip = By.xpath("//android.view.View[contains(@text,'test tip')}");
        chooseTowDestinationType=By.id("select2-service-confirmation-select-destination-container");
        btnContinue = By.xpath("//android.view.View[contains(@content-desc='Continue')}");
        enterNameforDestination = By.xpath("//android.widget.EditText[contains(@text,'Name')}");
        enterAddressForDestination = By.xpath("//android.widget.EditText[contains(@text,'Address')}");
        enterCityForDestination = By.xpath("//android.widget.EditText[contains(@text,'City')}");
        selectStateforDestination = By.className("android.widget.Spinner");
        searchButton = By.xpath("//android.view.View[contains(@content-desc='Search')}");
        errorPopup = By.id("com.aaa.d3itu:id/ErrorDialogOkButton");
    }

    public static By lnkTowDestination(String towDestination) {
        String xpath = "//android.view.View[contains(@text,'"+towDestination+"')]";
        lnkTowDestination = By.xpath(xpath);
        return lnkTowDestination;
    }

    public static By clickOnState(String state) {
        String xpath = "//android.view.View[contains(@content-desc='"+state+"')]";
        clickOnState = By.xpath(xpath);
        return clickOnState;
    }

}
