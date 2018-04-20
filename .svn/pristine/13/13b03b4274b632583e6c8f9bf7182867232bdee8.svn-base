package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_RSPCardSwipeCDXLookUp extends RSPCommonLib {
    /*********************************************************************************
     * *******************************************************************************
     * *************************STEPS SKIPPED(Discussed on 3/30/2018 5:57 AM)******************************************
     * Step 1:Swipe a valid membership card
     * Step 2:Swipe an expired membership card
     * Step 3:Swipe a cancelled membership card
     * Step 4:Swipe a pending membership card
     * Step 5:If possible swipe the different membership types: Plus/RV/Prem, etc
     * Step 6:Swipe a (test)credit card(1,2,3,4,5,6 (as it needs a machine swipe i.e. out of scope for automation))
     * *************************Test data is from TestData(Sheet:-RSPWeb,Column name:-RSPNewWalkIn)******************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

    RSPLoginLib login = new RSPLoginLib();
    RSPHomeLib home = new RSPHomeLib();
    RSPOrderDetailsLib order = new RSPOrderDetailsLib();
    RSPOrderDetailsArrivedLib orderArrived = new RSPOrderDetailsArrivedLib();
    RSPNewOrderLib newOrder = new RSPNewOrderLib();

    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void CDXLookUp(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "CDXLookUp", TestData, "RSPWeb");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("CDXLookUp", TestData, "RSPWeb", intCounter);
                    this.reporter.initTestCaseDescription("RSP Card Swipe Or CDX LookUp" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //Navigating to RSP
                    navigateToApplication("RSP");
                    //logging to application
                    login.loginToRSP(data.get("LoginName"), data.get("Password"));
                    //Verifies status modal window appers if found clicks on "Yes set my status to priority services"
                    home.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
                    //Setting priority status to priority service if failed to set hrough modal window
                    home.verifyingAndSettingPriorityStatus(data.get("PriorityToSelect"));
                    //Clicks on new order button
                    home.clickOnNewOrder();
                    //Clicking on Walk-In
                    newOrder.clickOnWalkin();
                    //Verify walk-in is selected or not
                    String walkInIsActiveOrNot = newOrder.verifyWalkInIsActiveOrNot();
                    assertTrue(walkInIsActiveOrNot.toLowerCase().contains(data.get("VerificationValue").toLowerCase()), "Walk-In is selected");
                    //Step 7,8,9,10: Enter in a 16 digit membership number
                    //Entering member number manually
                    order.setTextInModelWindow(data.get("MemberNumber"));
                    reporter.SuccessReport("<b>Action performed</b>","<b>Validating member number</b>");
                        //Step 7,8,9: then click the validate button
                        newOrder.clickOnValidateInNewOrderWindow();
                        //verifying alert window
                        if (home.alertStatusReminder()) {
                            //clicks on No in new order alert window
                            newOrder.clickOnLinkNoInNewOrderWindow();
                        }
                        //Step 7,8,9: then click the validate button
                        assertTrue(newOrder.verifyMemberShipVerifiedLabel(),"Member ship verified successfully for::"+data.get("MemberType"));
                        //Getting member details
                        if (newOrder.verifyMemberShipVerifiedLabel()) {
                            //verifyies member name,member number,phone number.
                            String memberName=newOrder.getMemberName();
                            String memberNumber=newOrder.getMemberNumber();
                            String phoneNumber=newOrder.getPhoneNumber();
                            assertTrue((!memberName.equals("") && !memberNumber.equals("") &&
                                    !phoneNumber.equals("")), "Member details returned are member name::"+memberName+"member number::"+memberNumber+"phone number::"+phoneNumber);

                            reporter.SuccessReport("<b>Action performed</b>","<b>Creating Order</b>");
                            //Step 10:Create a walk-in transaction for the above steps
                            newOrder.clickOnCreateNewOrder();
                            //verifying alert window
                            if (home.alertStatusReminder()) {
                                //Clicking on yes create new order button in modal window
                                newOrder.clickOnYesCreateOrderInModalWindow();
                            }
                            //Step 10:If the membership validation is successful, verify a status of incomplete or in progress is displayed
                            String status=orderArrived.getStatus().toLowerCase().replaceAll(" ","");
                            assertTrue(status.equals("inprogress")|status.equals("incomplete"),"Walk -in transaction created successfully and status is::"+status);
                    }
                    home.clickOnSignOut();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                    reporter.failureReport("Failed due to", e.getMessage(), driver);
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("RSP", "1843", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
}
