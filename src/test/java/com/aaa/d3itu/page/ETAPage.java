package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class ETAPage {

    public static By ETAMinutes;
    public static By btnSave;
    public static By btnclear;

    static {
        ETAMinutes=By.xpath("//android.view.View[@text='+5']");
        btnSave=By.xpath("//android.view.View[@text='Save']");
        btnclear= By.id("statusETTime-clear");

    }
}
