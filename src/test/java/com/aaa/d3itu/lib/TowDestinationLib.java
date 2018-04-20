package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.ServicesPage;
import com.aaa.d3itu.page.TowDestinationPage;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;
import org.testng.ITestContext;

public class TowDestinationLib  extends ActionEngineMobile {

    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void selecttip() throws Throwable
    {
            click(TowDestinationPage.serviceTip,"Service Tip");
    }

    public void selectTowDestination(String towDestination, String address) throws  Throwable
    {
        if(!towDestination.isEmpty())
        {
            click(TowDestinationPage.lnkTowDestination(towDestination),"Tow Destination To be selected");
            switch (towDestination){
            case "AAR Facility":
                type(TowDestinationPage.enterNameforDestination,address,"Enter Name");
                click(TowDestinationPage.searchButton,"Click On Search Button");
                boolean errorpopup = isVisibleOnly(TowDestinationPage.errorPopup,"Error Poup");
                if(errorpopup)
                {
                    click(TowDestinationPage.errorPopup,"Error Poup");
                    reporter.failureReport("Error Message","Unable to fetch facilities",appiumDriver);
                    throw new Exception("No Facility are returned ");
                }
                break;
             case "Other":
                 String addressDet[] = address.split("#");
                 type(TowDestinationPage.enterNameforDestination,addressDet[0],"Enter Name");
                 type(TowDestinationPage.enterAddressForDestination,addressDet[1],"Enter Name");
                 type(TowDestinationPage.enterCityForDestination,addressDet[2],"Enter Name");
                 click(TowDestinationPage.selectStateforDestination,"click on State Spinner");
                 scrollAndClick(TowDestinationPage.clickOnState(addressDet[3]));
                 break;
                default:
                break;
            }
        }
    }

    public void clickOnContinueButton() throws Throwable
    {
        if(isVisibleOnly(TowDestinationPage.btnContinue,"Continue Button"))
        {
            click(TowDestinationPage.btnContinue,"Continue Button");
        }
    }

    public void selectTipAndTowDestination(String towDestination, String Address) throws Throwable
    {
        if(isVisibleOnly(TowDestinationPage.serviceTip,"Service TIP")) {
            selecttip();
            selectTowDestination(towDestination,Address);
            clickOnContinueButton();
        }
    }
}
