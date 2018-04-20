package com.aaa.rspweb.lib;

import com.aaa.rspweb.pages.RSPOrderDetailsPage;

public class RSPOrderDetailsLib extends RSPCommonLib {

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleName
     * description ::returns vehicle name
     * date :: 
     * author :: Jagadish Pola
     */
    public String getVehicleName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblVehicleName,60);
        return getText(RSPOrderDetailsPage.lblVehicleName,"Vehicle name");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getMemberName
     * description ::returns member name
     * date :: 
     * author :: Jagadish Pola
     */

    public String getMemberName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblMemberName,60);
        return getText(RSPOrderDetailsPage.lblMemberName,"Member name");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getStatus
     * description ::returns status
     * date :: 
     * author :: Jagadish Pola
     */
    public String getStatus() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblStatus,60);
        Thread.sleep(2000);
        return getText(RSPOrderDetailsPage.lblStatus,"Status");
    }
    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifingCloseButton
     * description :: verifies close button is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifingCloseButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnClose,60);
        return isVisibleOnly(RSPOrderDetailsPage.btnClose,"close button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButton
     * description :: clicks on close button
     * date :: 
     * author :: Jagadish Pola
     */
    public void clickOnCloseButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnClose,60);
        click(RSPOrderDetailsPage.btnClose,"Close button");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCloseButton
     * description :: Verifyies close button is available or not
     * date ::
     * author :: Jagadish Pola
     */
    public boolean verifyCloseButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnClose,30);
        return isVisibleOnly(RSPOrderDetailsPage.btnClose,"Close button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOrderActionDropdown
     * description :: clicks on order action dropdown
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnOrderActionDropdown() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnOrderActionsDropDown,60);
        click(RSPOrderDetailsPage.btnOrderActionsDropDown,"Order action button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLinkOpenSupportTicket
     * description :: clicks on link open support ticket
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnLinkOpenSupportTicket() throws Throwable {
        clickOnOrderActionDropdown();
        dynamicWaitByLocator(RSPOrderDetailsPage.lnkOpenASupportTicket,60);
        click(RSPOrderDetailsPage.lnkOpenASupportTicket,"Open support ticket");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnArrived
     * description :: click on arrived
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnArrived() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnArrived,60);
        click(RSPOrderDetailsPage.btnArrived,"Arrived button");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyArrivedButton
     * description :: verifies arrived button is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyArrivedButton() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnArrived,60);
        return isVisibleOnly(RSPOrderDetailsPage.btnArrived,"Arrived button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNotArrived
     * description :: click on not arrived button
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnNotArrived() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnNotArrived,60);
        click(RSPOrderDetailsPage.btnNotArrived,"Not arrived button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContactCustomer
     * description :: click on contact customer
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnContactCustomer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnContactCustomer,60);
        click(RSPOrderDetailsPage.btnContactCustomer,"Contact customer button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnComment
     * description :: clicks on comment
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnComment() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnComment,60);
        click(RSPOrderDetailsPage.btnComment,"Comment button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTowInformation
     * description :: returns tow information
     * date :: 
     * author :: Jagadish Pola
     */
    public String getTowInformation() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblTowArrivedOrNotInfo,60);
        return getText(RSPOrderDetailsPage.lblTowArrivedOrNotInfo,"Tow information");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCustomerName
     * description :: returns customer name
     * date :: 
     * author :: Jagadish Pola
     */

    public String getCustomerName() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblCustomerDetails,60);
        return getText(RSPOrderDetailsPage.lblCustomerDetails,"Customer name");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPhoneNumber
     * description :: returns phone number
     * date :: 
     * author :: Jagadish Pola
     */

    public String getPhoneNumber() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblContactPhoneNumber,60);
        return getText(RSPOrderDetailsPage.lblContactPhoneNumber,"Phone number");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleInformation
     * description :: returns vehiclle information
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVehicleInformation() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblVehicleInfo,60);
        return getText(RSPOrderDetailsPage.lblVehicleInfo,"Vehicle Information");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getVehicleProblem
     * description :: returns vehicle problem
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVehicleProblem() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblVehicleProblem,60);
        return getText(RSPOrderDetailsPage.lblVehicleProblem,"Vehicle problem");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTimeOfOrder
     * description ::returns time of order
     * date :: 
     * author :: Jagadish Pola
     */

    public String getTimeOfOrder() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblTimeOfOrderHistory,60);
        return getText(RSPOrderDetailsPage.lblTimeOfOrderHistory,"Order time");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyTimeOfOrder
     * description :: verifyies time of order is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyTimeOfOrder() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblTimeOfOrderHistory,60);
        return isVisible(RSPOrderDetailsPage.lblTimeOfOrderHistory,"Order time");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: GetRepairOrderFirstViewedTime
     * description :: returns time of order first viewed time
     * date :: 
     * author :: Jagadish Pola
     */

    public String GetRepairOrderFirstViewedTime() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblRepairOrder,60);
        return getText(RSPOrderDetailsPage.lblRepairOrder,"Repair order first viewed");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRepairOrderFirstViewedTime
     * description :: verifies repair order first viewed is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyRepairOrderFirstViewedTime(String action) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblRepairOrder,60);
        return isVisible(RSPOrderDetailsPage.lblRepairOrder,"Repair order first viewed");
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCallRefferedTime
     * description :: returns call referred time
     * date :: 
     * author :: Jagadish Pola
     */

    public String getCallRefferedTime() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblCallReferredTime,60);
        return getText(RSPOrderDetailsPage.lblCallReferredTime,"Call reffered time");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyCallRefferedTime
     * description :: verifyies call reffered time is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyCallRefferedTime() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblCallReferredTime,60);
        return isVisible(RSPOrderDetailsPage.lblCallReferredTime,"Call reffered time");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTextInModelWindow
     * description :: enters text into modal window
     * date :: 
     * author :: Jagadish Pola
     */
    //we can use in arrived,tickets,contacted customer,vehicle not arrived sections

    public void setTextInModelWindow(String text) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.txtSubjectInSupportTicketCommentsContactedCustomerAndComment,60);
        type(RSPOrderDetailsPage.txtSubjectInSupportTicketCommentsContactedCustomerAndComment,text,"Text passed");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTextInCommentModelWindow
     * description :: enters text into comment modal window
     * date ::
     * author :: Jagadish Pola
     */
    //we can use in comments,arrived,tickets,contacted customer,vehicle not arrived sections

    public void setTextInCommentModelWindow(String text) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.txtInCommentModalWindow,60);
        type(RSPOrderDetailsPage.txtInCommentModalWindow,text,"Text passed in comment window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTextInModelWindowDescribeYourProblem
     * description :: enters text into modalwinow for describe your problem
     * date :: 
     * author :: Jagadish Pola
     */

    public void setTextInModalWindowDescribeYourProblem(String text) throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.txtAreaDescribeYourProblemHereInSupportTicket,60);
        type(RSPOrderDetailsPage.txtAreaDescribeYourProblemHereInSupportTicket,text,"Describe problem");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOkInModalWindow
     * description :: click on ok in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnOkInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnOkInSupportTicket,60);
        click(RSPOrderDetailsPage.btnOkInSupportTicket,"Ok button in model window");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSubmitButtonInModalWindow
     * description :: clicks on submit button in modal window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnSubmitButtonInModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnSubmitInContactedCustomer,60);
        click(RSPOrderDetailsPage.btnSubmitInContactedCustomer,"Submit button in model window");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getContactedCustomerTime
     * description :: returns contacted customer time
     * date :: 
     * author :: Jagadish Pola
     */

    public String getContactedCustomerTime() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblContactedCustomerTime,60);
        return getText(RSPOrderDetailsPage.lblContactedCustomerTime,"Contacted customer time");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyContactedCustomerTime
     * description :: customer contacted time is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyContactedCustomerTime() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblContactedCustomerTime,60);
        return isVisible(RSPOrderDetailsPage.lblContactedCustomerTime,"Contacted customer time");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getContactedCustomer
     * description :: returns contacted customer information
     * date :: 
     * author :: Jagadish Pola
     */

    public String getContactedCustomer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblContactedCustomer,60);
        return getText(RSPOrderDetailsPage.lblContactedCustomer,"Contacted customer");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyContactedCustomer
     * description :: verifyies contacted customer is visible or not
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyContactedCustomer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblContactedCustomer,60);
        return isVisible(RSPOrderDetailsPage.lblContactedCustomer,"Contacted customer");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddCommentsButtonInCommentsModalWindow
     * description ::clicks on add comments button in model window
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnAddCommentsButtonInCommentsModalWindow() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnAddCommetnsInCommentsTab,60);
        click(RSPOrderDetailsPage.btnAddCommetnsInCommentsTab,"Add comments");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCheckBoxToUnselectForContactCustomer
     * description :: click on checkbox in contacted customer
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnCheckBoxToUnselectForContactCustomer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.chkBoxContactCustomer,60);
        click(RSPOrderDetailsPage.chkBoxContactCustomer,"Check box in contact customer");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyCheckBoxIsSelectedOrContactCustomer
     * description :: verifyies checkbox is selected or not in contacted customer
     * date :: 
     * author :: Jagadish Pola
     */

    public String verifyCheckBoxIsSelectedOrContactCustomer() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnContactCustomer,60);
        return getCssValue(RSPOrderDetailsPage.btnContactCustomer,"color");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicleArrived
     * description ::clicks on vehicle arrived
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnVehicleArrived() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.btnVehicleArrived,60);
        click(RSPOrderDetailsPage.btnVehicleArrived,"Vehicle arrived");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicleNotArrived
     * description :: clicks on vehicle not arrived
     * date :: 
     * author :: Jagadish Pola
     */

    public void clickOnVehicleNotArrived() throws Throwable {
        isVisibleOnly(RSPOrderDetailsPage.btnVehicleNotArrived,"Vehicle not arrived");
         click(RSPOrderDetailsPage.btnVehicleNotArrived,"Vehicle not arrived");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAssign
     * description ::
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVehicleNotArrivedInHistory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblNotArrivedInHistory,60);
        return getText(RSPOrderDetailsPage.lblNotArrivedInHistory,"Vehicle not arrived in history");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAssign
     * description ::
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyVehicleNotArrivedInHistory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblNotArrivedInHistory,60);
        return isVisible(RSPOrderDetailsPage.lblNotArrivedInHistory,"Vehicle not arrived in history");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAssign
     * description ::
     * date :: 
     * author :: Jagadish Pola
     */

    public String getVehicleNotArrivedTimeInHistory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblNotArrivedTimeInHistory,60);
        return getText(RSPOrderDetailsPage.lblNotArrivedTimeInHistory,"Vehicle not arrived time in history");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyVehicleNotArrivedTimeInHistory
     * description :: verifyies vehicle not arrived in history
     * date :: 
     * author :: Jagadish Pola
     */

    public boolean verifyVehicleNotArrivedTimeInHistory() throws Throwable {
        dynamicWaitByLocator(RSPOrderDetailsPage.lblNotArrivedTimeInHistory,60);
        return isVisible(RSPOrderDetailsPage.lblNotArrivedTimeInHistory,"Vehicle not arrived time in history");
    }

}
