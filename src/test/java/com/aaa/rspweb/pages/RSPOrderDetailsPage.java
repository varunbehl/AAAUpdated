package com.aaa.rspweb.pages;

import org.openqa.selenium.By;

public class RSPOrderDetailsPage {

    public static By lblVehicleName;
    public static By lblMemberName;
    public static By lblStatus;
    public static By btnClose;
    public static By btnOrderActionsDropDown;
    public static By lnkOpenASupportTicket;
    public static By btnArrived;
    public static By btnNotArrived;
    public static By btnContactCustomer;
    public static By btnComment;

    //checkbox verification can be done based on color
    public static By chkBoxContactCustomer;
    public static By lblTowArrivedOrNotInfo;

    //Order Details
    public static By lblAssignedWorkShopDetails;
    public static By lblCustomerDetails;
    public static By lblContactPhoneNumber;
    public static By lblVehicleInfo;
    public static By lblVehicleProblem;

    //History of Repair Order
    public static By lblTimeOfOrderHistory;
    public static By lblRepairOrder;
    public static By lblRepairOrderAutoShopAD1;
    public static By lblContactedCustomerTime;
    public static By lblETAUpdate;
    public static By lblStatusFirstAssigned;
    public static By lblCallReferredTime;
    public static By lblContactedCustomer;
    public static By lblContactedCustomerAutoShopAD1;
    public static By lblCommented;
    public static By lblCommentedTime;
    public static By lblCommentedAutoShopAD1;
    public static By lblNotArrivedInHistory;
    public static By lblNotArrivedTimeInHistory;

    //Support Ticket,Contacted Customer tab and Comments Tab
    public static By txtSubjectInSupportTicketCommentsContactedCustomerAndComment;//----->we can use in comments,arrived,tickets,contacted customer,vehicle not arrived sections
    public static By txtAreaDescribeYourProblemHereInSupportTicket;
    public static By btnCancelInSupportTicketCommentsContactedCustomerAndComments;//----->we can use in comments,arrived,tickets,contacted customer,vehiclke not arrived sections
    public static By btnOkInSupportTicket;
    public static By txtInCommentModalWindow;
    public static By btnSubmitInContactedCustomer;
    public static By btnAddCommetnsInCommentsTab;
    public static By btnVehicleArrived;
    public static By btnVehicleNotArrived;


    /*Remaining locators we need to write after starting application

     */
    static
    {
        lblVehicleName=By.xpath("//*[@class='row'][1]/./div/span[1]");
        lblMemberName=By.xpath("//*[@class='row'][1]/./div/span[2]");
        lblStatus=By.xpath("//*[text()='Close']/../../..//*[@aria-describedby]");
        //btnClose=By.xpath("//*[text()='Close']/../..");
        btnClose=By.xpath("//*[text()='Close']//span[@class='fa fa-times-circle']");
        btnOrderActionsDropDown=By.xpath("//*[@id='OrderActions-dropdown']");
        lnkOpenASupportTicket=By.xpath("//*[@title='Open a Support Ticket']/..");
        btnArrived=By.xpath("//*[@id='OrderActions-dropdown']/../..//*[text()='Arrived']/..");
        btnNotArrived=By.xpath("//*[@id='OrderActions-dropdown']/../..//*[text()='Not Arrived']/..");
        btnContactCustomer=By.xpath("//*[@id='OrderActions-dropdown']/../..//*[text()='Contacted Customer']");
        btnComment=By.xpath("//*[@id='OrderActions-dropdown']/../..//*[text()='Comment']/..");
        lblTowArrivedOrNotInfo=By.xpath("//*[@title='Assigned Repair Shop']/../../div[1]");
        lblAssignedWorkShopDetails=By.xpath("//*[@title='Assigned Repair Shop']");
        lblCustomerDetails=By.xpath("//*[@title='Customer']");
        lblContactPhoneNumber=By.xpath("//*[@title='Contact Phone Number']");
        lblVehicleInfo=By.xpath("//*[@title='Vehicle']");
        lblVehicleProblem=By.xpath("//*[@title='Vehicle Problem']");
        lblTimeOfOrderHistory=By.xpath("//*[@title='Repair order first viewed.']/../../../div[1]/div/span");
        lblRepairOrder=By.xpath("//*[@title='Repair order first viewed.']");
        lblRepairOrderAutoShopAD1=By.xpath("//*[@title='Repair order first viewed.']/../div[1]");
        lblETAUpdate=By.xpath("//*[@title='ERS_UPDATE']");
        lblStatusFirstAssigned=By.xpath("//*[@title='ERS_UPDATE']/../span");
        lblCallReferredTime=By.xpath("//*[@title='ERS_UPDATE']/../../../div[1]//span");
        txtSubjectInSupportTicketCommentsContactedCustomerAndComment=By.xpath("//*[@type='text']");
        txtAreaDescribeYourProblemHereInSupportTicket=By.xpath("//*[@placeholder='Describe your problem here.']");
        btnCancelInSupportTicketCommentsContactedCustomerAndComments=By.xpath("//*[text()='Cancel']");
        btnOkInSupportTicket=By.xpath("//*[text()='OK']");
        btnSubmitInContactedCustomer=By.xpath("//*[text()='Submit']");
        lblContactedCustomerTime=By.xpath("//*[@title='Customer contacted.']/../../../div[1]/div/span");
        lblContactedCustomer=By.xpath("//*[@title='Customer contacted.']");
        lblContactedCustomerAutoShopAD1=By.xpath("//*[@title='Customer contacted.']/../div[1]");
        btnAddCommetnsInCommentsTab=By.xpath("//*[text()='Add Comment']");
        chkBoxContactCustomer=By.xpath("//*[@id='OrderActions-dropdown']/../..//*[text()='Contacted Customer']/span");
        btnVehicleArrived=By.xpath("//*[text()='Vehicle Arrived']");
        btnVehicleNotArrived=By.xpath("//*[text()='Vehicle Not Arrived']");
        lblNotArrivedInHistory=By.xpath("//*[@title='AUTOSHOPAD1']/../span");
        lblNotArrivedTimeInHistory=By.xpath("//*[@title='AUTOSHOPAD1']/../span/../../../div[1]/div/span");
        txtInCommentModalWindow=By.xpath("//*[@class='sweet-alert ']//*[@type='text']");
    }

    //Method is used to retrive the comments from history

    public static By commentedHistory(String comment)
    {
        String xpath="//*[@title='"+comment+"']/../div[1]";
        lblCommented=By.xpath(xpath);
        return lblCommented;
    }

    public static By commentedTime(String comment)
    {
        String xpath="//*[@title='"+comment+"']/../..//div[1]/div/span";
        lblCommentedTime=By.xpath(xpath);
        return lblCommentedTime;
    }

    public static By commentedAutoShopAd1(String comment)
    {
        String xpath="//*[@title='"+comment+"']/../div[1]";
        lblCommentedAutoShopAD1=By.xpath(xpath);
        return lblCommentedAutoShopAD1;
    }

}
