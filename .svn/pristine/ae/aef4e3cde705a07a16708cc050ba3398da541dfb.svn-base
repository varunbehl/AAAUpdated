package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_RSPOrderArchive extends RSPCommonLib{

    /*********************************************************************************
     * *******************************************************************************
     * *************************STEPS SKIPPED(Discussed on 17/Apr/2018)******************************************
     * Step 7:No longer valid, these fields are not required
     * Step 8
     * *************************Test data is from TestData(Sheet:-RSPWeb,Column name:-RSPOrderArchive)******************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

    RSPLoginLib login=new RSPLoginLib();
    RSPHomeLib home=new RSPHomeLib();
    RSPOrderDetailsArrivedLib orderArrived=new RSPOrderDetailsArrivedLib();
    RSPNewOrderLib newOrder=new RSPNewOrderLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void RSPOrderArchive(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "RSPOrderArchive", TestData, "RSPWeb");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPOrderArchive", TestData, "RSPWeb", intCounter);
                    this.reporter.initTestCaseDescription("RSP Order Archive" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //Navigating to RSP
                    navigateToApplication("RSP");
                    //Step 1: Login as Shop User
                    login.loginToRSP(data.get("LoginName"), data.get("Password"));
                    //Verifies status modal window appers if found clicks on "Yes set my status to priority services"
                    home.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
                    //Setting priority status to priority service if failed to set hrough modal window
                    home.verifyingAndSettingPriorityStatus(data.get("PriorityToSelect"));
                    //Clioks on new order button
                    home.clickOnNewOrder();
                    //Clickng on create new order
                    newOrder.clickOnCreateNewOrder();
                    //Step 2:User should be able to enter a cost of the repair
                    //Entering cost of repair(**For verification we are entering alphanumeric value from excel)
                    orderArrived.enterInvoiceTotal(data.get("InvoiceTotal"));
                    //Step 2:Verify you can enter numeric data
                    String invoiceTotal=orderArrived.getInvoiceTotal();
                    assertTrue(invoiceTotal.replace(".","").matches("[0-9]+"),"Invoice total accepts only numerics and value is::"+invoiceTotal);
                    //User should be able to enter the discount amount
                    //Entering Discount amount(**For verification we are entering alphanumeric value from excel)
                    orderArrived.enterAAAMemberDiscount(data.get("EnterDiscount"));
                    //Getting dicount amount
                    String AAADiscount=orderArrived.getAAAMemberDiscount();
                    //Step 3:Verify you can enter numeric data
                    assertTrue(AAADiscount.replace(".","").matches("[0-9]+"),"AAA discount accepts only numerics and value is::"+AAADiscount);
                    //Getting total amount
                    String totalAmountAfterDiscount=orderArrived.getTotalAmountAfterDiscount();
                    //Step 4:Verify total cost is automatically populated
                    assertTrue((!totalAmountAfterDiscount.equals(" "))&&(!totalAmountAfterDiscount.equals(""))&&
                            (!totalAmountAfterDiscount.equals(null))&&(!totalAmountAfterDiscount.equals("-")),"Total amount after discount is automatiacally populated::"+totalAmountAfterDiscount);
                    //Clearing invoice total
                    orderArrived.clearInvoiceTotal();
                    //Clearing AAA Member discount
                    orderArrived.clearAAAMemberDiscount();
                    //Step 5:Entering AAA member discount prior to Invoice total
                    orderArrived.enterAAAMemberDiscount(data.get("EnterDiscount"));
                    //Step 5:Verify the warning appears
                    assertTrue(orderArrived.verifyWarningMessegeIfDiscountEnteredWithEmptyInvoiceTotal(),"Warning messege appered if discount amount entered before cost of repair");
                    //Step 5:Verifying we can save the order or not
                    assertTrue(orderArrived.verifySaveButtonEnable(),"Save button is visible we can save the order");
                    //Clearing invoice total
                    orderArrived.clearInvoiceTotal();
                    //Clearing AAA member discount
                    orderArrived.clearAAAMemberDiscount();
                    //Entering Invoice total
                    orderArrived.enterInvoiceTotal(data.get("InvoiceTotal"));
                    //Step 6:Entering AAA Member discount exceeds more than limit
                    orderArrived.enterAAAMemberDiscount(data.get("EnterDiscountExceedsLimit"));
                    //Step 6:Verify the confirmation message appears
                    assertTrue(orderArrived.verifyConfirmationMessegeIfTotalLimitExceedsTheLimit(),"Warning messege appered if discount amount exceeds the limit");
                    //Clearing invoice total
                    /*orderArrived.clearInvoiceTotal();
                    //Entering invoice total
                    orderArrived.enterInvoiceTotal(data.get("MaxLimitOfInvoiceTotalWithDecimals"));
                    //Step 8:getting invoice total
                    invoiceTotal=orderArrived.getInvoiceTotal();
                    //Step 8:Verify you can only enter $xxxx.xx
                    assertTrue(invoiceTotal.replace(".","").length()==7,"enter max limit as $xxxx.xx entered value is::"+invoiceTotal);*/
                    home.clickOnSignOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Failed due to",e.getMessage(),driver);
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("RSP","1849",ReportStatus.strMethodName,intCounter,browser);
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
