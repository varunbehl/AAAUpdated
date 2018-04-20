package com.aaa.rspweb.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.rspweb.pages.RSPVehicleInspectionPage;

public class RSPVehicleInspectionLib extends ActionEngine {

    RSPCommonLib commonLib=new RSPCommonLib();

    /**
     * param ::linkName
     * return ::void
     * throws :: throwable
     * methodName :: getPercentegeOnLinks
     * description :: To get the percentage on the links.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: linkName(General Inspection,Lights,Lubricants/Fluids,Battery............)
     */

    public String getPercentegeOnLinks(String linkName) throws Throwable {
    dynamicWaitByLocator(RSPVehicleInspectionPage.leftAlignmentLinksPercentage(linkName),60);
    return getText(RSPVehicleInspectionPage.leftAlignmentLinksPercentage(linkName),"Percentage on "+linkName);
    }

    /**
     * param :: linkName
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLeftFrameLinks
     * description :: To click on a left frame button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: linkName(General Inspection,Lights,Lubricants/Fluids,Battery............)
     */

    public void clickOnLeftFrameLinks(String linkName) throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.leftFrameLinks(linkName),60);
        click(RSPVehicleInspectionPage.leftFrameLinks(linkName),linkName);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPrintButton
     * description :: To click on print button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnPrintButton() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnPrint,60);
        click(RSPVehicleInspectionPage.btnPrint,"Print button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMessegeButton
     * description :: To click on messege button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnMessegeButton() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnMessege,60);
        click(RSPVehicleInspectionPage.btnMessege,"Messege button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnResetButton
     * description :: To click on reset button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnResetButton() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnResetValues,60);
        click(RSPVehicleInspectionPage.btnResetValues,"Reset button");
    }
    /**
     * param :: action
     * return :: boolean
     * throws :: throwable
     * methodName :: clickORVerifyInspectionButton
     * description :: To verify button is disabled and to click on button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: action(click,disable,verifydisableandclick)
     */

    public boolean verifyInspectionButtonDisable() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnSaveInspectionDisabled,60);
        return isVisible(RSPVehicleInspectionPage.btnSaveInspectionDisabled,"Save inspection button disable");
    }

    /**
     * param :: action
     * return :: boolean
     * throws :: throwable
     * methodName :: clickORVerifyInspectionButton
     * description :: To verify button is disabled and to click on button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: action(click,disable,verifydisableandclick)
     */

    public void clickOnSaveInspection() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnSaveInspectionEnabled,60);
        click(RSPVehicleInspectionPage.btnSaveInspectionEnabled,"Save Inspection");
    }

    /**
     * param :: rowName,symbolName,action
     * return ::void
     * throws :: throwable
     * methodName :: clickORVerifyImgSymbolsWithMultipleRowsInSingleRow
     * description :: This method is used to verify/click the symbol in vehicle inspection page
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: Eg:-row name(Horn),symbolName-->N/A==>NA,Green smile==>perfect,Orange smile==>good,red==>bad(NA,Green,perfect,good,bad are values)
     *                     action(click/getcss)
     */

    public void clickImgSymbolsWithSingleRow(String rowName, String symbolName) throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.imgSingleRow(rowName,symbolName),60);
        click(RSPVehicleInspectionPage.imgSingleRow(rowName,symbolName),"Smiley images");
    }


    /**
     * param :: rowName,symbolName,action
     * return ::void
     * throws :: throwable
     * methodName :: clickORVerifyImgSymbolsWithMultipleRowsInSingleRow
     * description :: This method is used to verify/click the symbol in vehicle inspection page
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: Eg:-row name(Horn),symbolName-->N/A==>NA,Green smile==>perfect,Orange smile==>good,red==>bad(NA,Green,perfect,good,bad are values)
     *                     action(click/getcss)
     */

    public void verifyImgSymbolsWithSingleRowIsSelected(String rowName, String symbolName) throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.imgSingleRow(rowName,symbolName),60);
        getCssValue(RSPVehicleInspectionPage.imgSingleRow(rowName,symbolName),"color");
    }

    /**
     * param :: rowName,symbolName,action
     * return ::void
     * throws :: throwable
     * methodName :: clickORVerifyImgSymbolsWithMultipleRowsInSingleRow
     * description :: This method is used to verify/click the symbol in vehicle inspection page
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: Eg:-row name(left,right,level,pump,e.t.c..),symbolName-->N/A==>NA,Green smile==>perfect,Orange smile==>good,red==>bad(NA,Green,perfect,good,bad are values)
     *                     action(click/getcss)
     */

    public void clickImgSymbolsWithMultipleRowsInSingleRow(String rowName, String symbolName) throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.imgMultipleRows(rowName,symbolName),60);
        click(RSPVehicleInspectionPage.imgMultipleRows(rowName,symbolName),"Smiley images");
    }

    /**
     * param :: rowName,symbolName,action
     * return ::void
     * throws :: throwable
     * methodName :: clickORVerifyImgSymbolsWithMultipleRowsInSingleRow
     * description :: This method is used to verify/click the symbol in vehicle inspection page
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     * param values :: Eg:-row name(left,right,level,pump,e.t.c..),symbolName-->N/A==>NA,Green smile==>perfect,Orange smile==>good,red==>bad(NA,Green,perfect,good,bad are values)
     *                     action(click/getcss)
     */

    public void verifyImgSymbolsWithMultipleRowsInSingleRowIsSelected(String rowName, String symbolName) throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.imgMultipleRows(rowName,symbolName),60);
        getCssValue(RSPVehicleInspectionPage.imgMultipleRows(rowName,symbolName),"color");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelButton
     * description :: To click on cancel button
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */

    public void clickOnCancelButton() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnCancelInInspection,60);
        click(RSPVehicleInspectionPage.btnCancelInInspection,"Cancel button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSendEmailButton
     * description :: To click on send email.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnSendEmailButton() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.btnSendInEmailInspectionWindow,60);
        click(RSPVehicleInspectionPage.btnSendInEmailInspectionWindow,"Send email button");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyErrorWindow
     * description :: To verify error window is visible or not.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean verifyErrorWindow() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.errorWindowInVehicleInspection,60);
        return isVisible(RSPVehicleInspectionPage.errorWindowInVehicleInspection,"Error window");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyValidEmailIdMessege
     * description :: To verify the Email id error messege is visible or not.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean verifyValidEmailIdMessege() throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.lblPleaseEnterValidEmailInEmailInspectionWindow,60);
        return isVisible(RSPVehicleInspectionPage.lblPleaseEnterValidEmailInEmailInspectionWindow,"Please enter valid email id");
    }

    /**
     * param ::emailId
     * return ::void
     * throws :: throwable
     * methodName :: enterEmailId
     * description :: To enter email.
     * date :: 13-Mar-2018
     * author :: Jagadish Pola
     */

    public void enterEmailId(String emailId) throws Throwable {
        dynamicWaitByLocator(RSPVehicleInspectionPage.txtEnterEmailInEmailInspectionWindow,60);
        type(RSPVehicleInspectionPage.txtEnterEmailInEmailInspectionWindow,emailId,"Enter email id");
    }
}
