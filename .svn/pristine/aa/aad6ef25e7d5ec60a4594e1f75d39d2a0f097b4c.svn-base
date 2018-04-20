package com.aaa.rspweb.lib;

import com.aaa.rspweb.pages.RSPNewOrderPage;

public class RSPNewOrderLib extends RSPCommonLib{

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyModelWindow
     * description :: verifying modal window is visible or not pass the model window name
     * date :: 
     * author :: Jagadish Pola
     */
    public boolean verifyModalWindow(String name) throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.modelWindow,60);
        return isVisibleOnly(RSPNewOrderPage.modelWindow,name+" window is appering");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCreateNewOrder
     * description :: click on create new order
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCreateNewOrder() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnCreateOrderInNewOrderWindow,60);
        click(RSPNewOrderPage.btnCreateOrderInNewOrderWindow,"Create new order");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnValidateInNewOrderWindow
     * description :: click on validate button in new order model window by verifying button is available or not
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnValidateInNewOrderWindow() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnValidate,60);
        if(!verifyValidateButton()) {
            click(RSPNewOrderPage.btnValidate, "Validate button");
        }
        else
        {
            reporter.failureReport("Validating member number","Member number cannot be validated please enter 16 digit member number",driver);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyValidateButton
     * description :: verifies validate button is available or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyValidateButton() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnValidateDisable,10);
        return isVisibleOnly(RSPNewOrderPage.btnValidateDisable,"Verifying valid button disabled or not");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkNoInNewOrderWindow
     * description :: click on link no in new order modal window
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnLinkNoInNewOrderWindow() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.lnkNoInNewOrder,60);
        click(RSPNewOrderPage.lnkNoInNewOrder,"No button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnYesOpenItInNewOrderWindow
     * description :: click on yes open it in new order modal window
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnYesOpenItInNewOrderWindow() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnYesOpenItInNewOrder,60);
        click(RSPNewOrderPage.btnYesOpenItInNewOrder,"Yes open it button");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyWalkInIsActiveOrNot
     * description :: returns text active if walkin is selected in madal window
     * date :: 
     * author :: Jagadish Pola
     */

    public String verifyWalkInIsActiveOrNot() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnWalkIn, 60);
        return getAttributeValue(RSPNewOrderPage.btnWalkIn,"class");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnWalkin
     * description :: clicks on walk in
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnWalkin() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnWalkIn, 60);
        click(RSPNewOrderPage.btnWalkIn, "Walk-In");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyTowInIsActiveOrNot
     * description :: returns text active if towin is selected in madal window
     * date :: 
     * author :: Jagadish Pola
     */
    public String verifyTowInIsActiveOrNot() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnTowIn, 60);
        return getAttributeByClass(RSPNewOrderPage.btnTowIn,"Tow-In");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowIn
     * description :: clicks on tow in
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnTowIn() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnTowIn,60);
        click(RSPNewOrderPage.btnTowIn, "Tow-In");

    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyMemberShipVerifiedLabel
     * description :: verifyies member ship verifyed label is visible or not after clicking validate in new order window
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyMemberShipVerifiedLabel() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.lblMemberShipVerified,30);
        return isVisibleOnly(RSPNewOrderPage.lblMemberShipVerified,"Membership verified");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTickIcon
     * description :: verifyies member ship verifyed TickIcon is visible or not after clicking validate in new order window
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyTickIcon() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.iconTickMarkForMemberVerification,30);
        return isVisible(RSPNewOrderPage.iconTickMarkForMemberVerification,"Membership verified tick mark icon");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getMemberShipVerified
     * description :: returns member ship verified text
     * date :: 
     * author :: Jagadish Pola
     */

    public String getMemberShipVerified() throws Throwable {
        if(verifyMemberShipVerifiedLabel()) {
            return getText(RSPNewOrderPage.lblMemberShipVerified, "Membership verified");
        }
        return "";
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getMemberNumber
     * description :: returns member number if available after clicking on validate button
     * date :: 
     * author :: Jagadish Pola
     */

    public String getMemberNumber() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.lblMemberNumber,30);
        return getText(RSPNewOrderPage.lblMemberNumber,"Member number");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getMemberName
     * description :: returns member name if available after clicking on validate button
     * date :: 
     * author :: Jagadish Pola
     */

    public String getMemberName() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.lblMemberName,30);
        return getText(RSPNewOrderPage.lblMemberName,"Member name");
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPhoneNumber
     * description :: returns phone number if available after clicking on validate button
     * date :: 
     * author :: Jagadish Pola
     */

    public String getPhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.lblPhoneNumber,30);
        return getText(RSPNewOrderPage.lblPhoneNumber,"Phone number");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnYesCreateOrderInModalWindow
     * description :: Click on yes create order button in modal window
     * date :: 12-Apr-2018
     * author :: Jagadish Pola
     */

    public void clickOnYesCreateOrderInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPNewOrderPage.btnYesCreateNewOrder,60);
        click(RSPNewOrderPage.btnYesCreateNewOrder,"Yes create new order");
    }
}

