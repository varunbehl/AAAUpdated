package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

public class TC_RSPRecordSorting extends RSPCommonLib {

    /*********************************************************************************
     * *******************************************************************************
     * *************************STEPS SKIPPED(Discussed on 3/30/2018 5:57 AM)******************************************
     * Step 2:The application behaviour is broken and so we can skip automating the step “Sort By Status”
     * Step 3:Saves calls from different days and test the sorting for the Time Order Created column
     * Step 4:Save orders with alpha numeric SVO numbers(We can't edit the fields)
     * *************************As per discussion if empty records found for the particular column we are failing that step.
     * *************************Test data is from TestData(Sheet:-RSPWeb,Column name:-RSPRecordSorting)******************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

    RSPLoginLib login=new RSPLoginLib();
    RSPHomeLib home=new RSPHomeLib();
    List headerValues;
    List webPageHeaderValues;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void recordSorting(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "RSPRecordSorting", TestData, "RSPWeb");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPRecordSorting", TestData, "RSPWeb", intCounter);
                    this.reporter.initTestCaseDescription("RSP Record Sorting" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    //Navigating to RSP
                    navigateToApplication("RSP");
                    //Step 1:Login to RSP and go to the main page (Shop User, Shop Admin)
                    login.loginToRSP(data.get("LoginName"), data.get("Password"));
                    //verifying alert box if found clicks on "Yes Set My Status To Priority Service"
                    home.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
                    //Setting priority status to priority service if failed to set hrough modal window
                    home.verifyingAndSettingPriorityStatus(data.get("PriorityToSelect"));
                    if(data.get("Scenario").equalsIgnoreCase("tableHeader")) {
                     //Verify you see the following columns:Time Order Created,Customer Name,Year,Make,Model,SVO#,Type,Status
                        //Reading column names from excel
                        headerValues = splitTheStringBasedOnComma(data.get("VerifingTableHeaders"));
                        //Reading column names from application
                        webPageHeaderValues = home.getTableHeaderInRSPHome();
                        //Step 1: Comparing all the column headers are found or not
                        assertTrue(recordsSortingAndComparision(headerValues, webPageHeaderValues),"<b>Table headers verification</b>");
                    }
                    if(data.get("Scenario").equalsIgnoreCase("tableSorting")) {
                        for(int sortingOrders=0;sortingOrders<2;sortingOrders++) {
                            //Step 2:Click on each of the columns so each column sorts ascending and descending
                            String sortingColumn=data.get("SortingOrderForColumn");
                            home.clickOnColumn(sortingColumn);
                            //Getting records from application
                            List records = home.getDataRecords(sortingColumn);
                            //Step 2:Verify each of the columns sorts ascending or descending
                            String sortingOrder=home.verifyingSortingOrder(records, sortingColumn);
                            assertTrue((sortingOrder.equalsIgnoreCase("decending order"))||(sortingOrder.equalsIgnoreCase("ascending order")),"Records are in::"+sortingOrder);
                        }
                    }
                    home.clickOnSignOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                    reporter.failureReport("Failed due to",e.getMessage(),driver);
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("RSP","1846",ReportStatus.strMethodName,intCounter,browser);
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
