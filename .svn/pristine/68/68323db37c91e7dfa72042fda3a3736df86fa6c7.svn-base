package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_RSPNewTowIn extends RSPCommonLib {

    /*********************************************************************************
     * *******************************************************************************
     * *************************STEPS SKIPPED(Discussed on 3/30/2018 5:57 AM)******************************************
     * Step 2:Select Tow-in, then click in the membership field. Swipe a valid membership card
     * Step 3:Click on the Create Order button
     * Step 4:Add another Repair Order
     * *************************Test data is from TestData(Sheet:-RSPWeb,Column name=RSPNewTowIn)******************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

    RSPLoginLib login=new RSPLoginLib();
    RSPHomeLib home=new RSPHomeLib();
    RSPOrderDetailsLib order=new RSPOrderDetailsLib();
    RSPOrderDetailsArrivedLib orderArrived=new RSPOrderDetailsArrivedLib();
    RSPOrderDetailsLib orderDetails=new RSPOrderDetailsLib();
    RSPNewOrderLib newOrder=new RSPNewOrderLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void newTowIn(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "RSPNewTowIn", TestData, "RSPWeb");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPNewTowIn", TestData, "RSPWeb", intCounter);
                    this.reporter.initTestCaseDescription("RSP New Tow-In" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    navigateToApplication("RSP");
                    //Step 1: Login as Shop User, Shop Admin
                    login.loginToRSP(data.get("LoginName"), data.get("Password"));
                    //Verifies status modal window appers if found clicks on "Yes set my status to priority services"
                    home.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
                    //Setting priority status to priority service if failed to set hrough modal window
                    home.verifyingAndSettingPriorityStatus(data.get("PriorityToSelect"));
                    //Clioks on new order button
                    home.clickOnNewOrder();
                    //Step 2: Verify the new repair order window appears
                    assertTrue(home.verifyNewRepairOrderWindow(),"<b>New repair order window is visible</b>");
                    //Selecting Tow-In
                    newOrder.clickOnTowIn();
                    //Step 2: Verify tow-in is selected or not
                    assertTrue(newOrder.verifyTowInIsActiveOrNot().toLowerCase().contains(data.get("VerificationValue").toLowerCase()),"Tow-In is selected");
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
                            //if alert window is visible in new order clicks on no
                            newOrder.clickOnLinkNoInNewOrderWindow();
                        }
                        //Step 5 and 6(Validation): Verify the member information is populated
                        if (newOrder.verifyMemberShipVerifiedLabel()) {
                            //verifyies member name,member number,phone number.
                            String memberName=newOrder.getMemberName();
                            String memberNumber=newOrder.getMemberNumber();
                            String phoneNumber=newOrder.getPhoneNumber();
                            assertTrue((!memberName.equals("") && !memberNumber.equals("") &&
                                    !phoneNumber.equals("")), "Member details pre populated");
                            orderArrived.clickOnCancelButtonInModelWindow();
                        }

                    }
                    /**************Enter in information for the following fields:First Name,Last Name,Phone Number*******************************/
                    else if(data.get("Scenario").replaceAll(" ","").equalsIgnoreCase("CreateNewOrder"))
                    {
                        //clicking on create order button
                        newOrder.clickOnCreateNewOrder();
                        //Step 7(Validation): Verify the order details page
                        assertTrue(orderArrived.verifyOrderDetailsTabIsActive().equalsIgnoreCase("active"),"Order details page appears");
                        //Step 8:Enter in information for following fields
                        //entering phone number
                        orderArrived.enterPhoneNumber(data.get("PhoneNumber"));
                        //entering first name
                        orderArrived.enterFirstName(data.get("FirstName"));
                        //entering last name
                        orderArrived.enterLastName(data.get("LastName"));
                        //click on save button
                        orderArrived.ClickOnSaveButton();
                        //Step 8:Verifying details saved successful through success notification
                        String detailsSavedSuccessfullyNotificationText=verifyingandGettingNotificationText();
                        //Step 8:Verifying details saved successful through success notification
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
                ReportStatus.fnUpdateResultStatus("RSP","1845",ReportStatus.strMethodName,intCounter,browser);
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
