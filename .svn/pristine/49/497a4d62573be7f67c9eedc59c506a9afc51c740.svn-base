package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CommonDb;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_RSPNewWalkIn extends RSPCommonLib {


    /*********************************************************************************
     * *******************************************************************************
     * *************************STEPS SKIPPED(Discussed on 3/30/2018 5:57 AM)******************************************
     * Step 3:Select Walk-in, then click in the membership field. Swipe a valid membership card
     * Step 4:Click on the Create Order button(3,4 (as it needs a machine swipe i.e. out of scope for automation))
     * Step 5:Add another Repair Order(as it needs a machine swipe i.e. out of scope for automation)
     * *************************Test data is from TestData(Sheet:-RSPWeb,Column name:-RSPNewWalkIn)******************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

    RSPLoginLib login=new RSPLoginLib();
    RSPHomeLib home=new RSPHomeLib();
    RSPOrderDetailsLib order=new RSPOrderDetailsLib();
    RSPOrderDetailsArrivedLib orderArrived=new RSPOrderDetailsArrivedLib();
    RSPNewOrderLib newOrder=new RSPNewOrderLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void newWalkIn(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "RSPNewWalkIn", TestData, "RSPWeb");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPNewWalkIn", TestData, "RSPWeb", intCounter);
                    this.reporter.initTestCaseDescription("RSP New Walk-In" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    navigateToApplication("RSP");
                    //Step 1: Login as Shop User, Shop Admin
                    login.loginToRSP(data.get("LoginName"), data.get("Password"));
                    //Verifies status modal window appers if found clicks on "Yes set my status to priority services"
                    home.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
                    //Setting priority status to priority service if failed to set hrough modal window
                    home.verifyingAndSettingPriorityStatus(data.get("PriorityToSelect"));
                    //Clicks on new order button
                    home.clickOnNewOrder();
                    //Step 2: Verify the new repair order window appears
                    assertTrue(home.verifyNewRepairOrderWindow(),"<b>New repair order window is visible</b>");
                    //Clicking on Walk-In
                    newOrder.clickOnWalkin();
                    //Step 2: Verify walk-in is selected or not
                    String walkInIsActiveOrNot=newOrder.verifyWalkInIsActiveOrNot();
                    assertTrue(walkInIsActiveOrNot.toLowerCase().contains(data.get("VerificationValue").toLowerCase()),"Walk-In is selected");
                    //Step 6: Enter in a membership number manually
                    if(data.get("Scenario").equalsIgnoreCase("Validation")) {
                        //Entering member number manually
                        order.setTextInModelWindow(data.get("MemberNumber"));
                        //Step 6: then click the validate button
                        newOrder.clickOnValidateInNewOrderWindow();
                        //Step 6(Validation): Verify the member information is populated and is validated with no errors
                        assertTrue(!verificationOfErrorNotification(), "Member number validated with no error");
                        //verifying alert window
                        if (home.alertStatusReminder()) {
                            //clicks on No in new order alert window
                            newOrder.clickOnLinkNoInNewOrderWindow();
                        }
                        //Step 6(Validation): Verify the member information is populated
                        //verifyies member ship verified label,member name,member number,phone number.
                        if (newOrder.verifyMemberShipVerifiedLabel()) {
                            //verifyies member name,member number,phone number.
                            String memberName=newOrder.getMemberName();
                            String memberNumber=newOrder.getMemberNumber();
                            String phoneNumber=newOrder.getPhoneNumber();
                            assertTrue((!memberName.equals("") && !memberNumber.equals("") &&
                                    !phoneNumber.equals("")), "Member details pre populated");
                            //Clicks on cancel button
                            orderArrived.clickOnCancelButtonInModelWindow();
                        }

                    }
                    else if(data.get("Scenario").replaceAll(" ","").equalsIgnoreCase("CreateNewOrder"))
                    {
                        //clicking on create order button
                        newOrder.clickOnCreateNewOrder();
                        //Step 8(Validation): Verify the order details page appears
                        assertTrue(orderArrived.verifyOrderDetailsTabIsActive().equalsIgnoreCase("active"),"Order details page appears");
                        //Getting phone number from excel
                        String phoneNumber=data.get("PhoneNumber");
                        //Getting first name from exccel
                        String firstName=data.get("FirstName");
                        //Getting last name from excel
                        String lastName=data.get("LastName");
                        //Step 9:Enter in information for the following fields:First Name,Last Name,Phone Number
                        //entering phone number
                        orderArrived.enterPhoneNumber(phoneNumber);
                        //entering first name
                        orderArrived.enterFirstName(firstName);
                        //entering last name
                        orderArrived.enterLastName(lastName);
                        //click on save button
                        orderArrived.ClickOnSaveButton();
                        //Step 9:Verifying details saved successful through success notification
                        String detailsSavedSuccessfullyNotificationText=verifyingandGettingNotificationText();
                        //Step 9:Validating details saved successful through success notification
                        assertTrue(!detailsSavedSuccessfullyNotificationText.equals(null),"Details saved sucessfully "+detailsSavedSuccessfullyNotificationText);

                    }
                    home.clickOnSignOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Failed due to",e.getMessage(),driver);
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("RSP","1844",ReportStatus.strMethodName,intCounter,browser);
                fnCloseTest();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
}
