package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.*;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_RSPUpdateOrCompleteOrder extends RSPCommonLib {

    /*********************************************************************************
     * *******************************************************************************
     * *************************STEPS SKIPPED(Discussed on 06/04/2018)******************************************
     * Step 5:Enter in a 20 digit special characters repair order number
     * *************************Test data is from TestData(Sheet:-RSPWeb,Column name:-updateOrCompleteOrder)******************************************
     * ********************************************************************************
     * ********************************************************************************
     * ********************************************************************************
     */

        RSPLoginLib login=new RSPLoginLib();
        RSPHomeLib home=new RSPHomeLib();
        RSPOrderDetailsLib orderDetails=new RSPOrderDetailsLib();
        RSPOrderDetailsArrivedLib orderArrived=new RSPOrderDetailsArrivedLib();
        Hashtable<String, String> callData=new Hashtable<>();
        RSPNewOrderLib newOrder=new RSPNewOrderLib();


        @Parameters({"StartRow","EndRow","nextTestJoin"})
        @Test()
        public void updateOrCompleteOrder(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
            try
            {
                int intStartRow=StartRow;
                int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "updateOrCompleteOrder", TestData, "RSPWeb");
                for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
                {
                    try {
                        fnOpenTest();
                        ReportStatus.fnDefaultReportStatus();
                        ReportControl.intRowCount = intCounter;
                        Hashtable<String, String> data = TestUtil.getDataByRowNo("updateOrCompleteOrder", TestData, "RSPWeb", intCounter);
                        this.reporter.initTestCaseDescription("RSP Update Or Complete Order" + " From Iteration " + StartRow + " to " + EndRow);
                        reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                        //Step 1:Save call with an AAR TD
                        callData = createCall(data.get("CRLoginName"),data.get("CRPassword"),data.get("BreakdownAddress"),data.get("Vehiclemodel"),
                                data.get("PacesetterCode"),data.get("TowDestination"),data.get("TowPassengers"),data.get("Member"),data.get("Membersearch"),data.get("dbServer")
                                ,data.get("dbqueryFileName"),data.get("colomnName"),data.get("PhoneNumber"),data.get("primaryphonenum1"),data.get("callType"),data.get("facilityId"));
                        String callId=callData.get("callId");
                        String callCreatedDate=callData.get("callDate");
                        assertTrue(!callId.equals("") && !callId.equals(null), "Call saved sucessful");
                        if (!callId.equals("") && !callId.equals(null)) {
                        //Step 1: put the call in TW status
                        String changingCallStatusToTow = changeCallToTow(data.get("DILoginName"),data.get("DIPassword"),data.get("role"), callId,callCreatedDate);
                        assertTrue(changingCallStatusToTow.contains("TW"), "<b>Call is tow status</b>");
                        }
                        //Navigating to RSP
                        navigateToApplication("RSP");
                        //Logging into application
                        login.loginToRSP(data.get("RSPLoginName"), data.get("RSPPassword"));
                        //Verifies status modal window appers if found clicks on "Yes set my status to priority services"
                        home.verifyAndClickOnLinkYesSetMyStatusToPriorityService();
                        //Setting priority status to priority service if failed to set hrough modal window
                        home.verifyingAndSettingPriorityStatus(data.get("PriorityToSelect"));
                        //Step 1: verifying call is saved successfully
                        if (!callId.equals("") && !callId.equals(null)) {
                            //Step 1:verifying assigned to your AAR shop
                            //Searching a call
                            assertTrue(home.searchingACall(callId, callCreatedDate), "Successfully found the call in assigned AAR shop");
                            //Clicks on callid
                            home.clickOnCallId(callId, callCreatedDate);
                            //Step 2:in RSP set the calls status Arrived (Shop User, Shop Admin)
                            //Clicking on arrived
                            orderDetails.clickOnArrived();
                            //Clicking on vehicle arrived in modal window
                            orderDetails.clickOnVehicleArrived();
                            //Step 2:Verify the call is in arrived status(Changed call status verification for arrived to In-Progress as per application work flow)
                            String callStatusInRSP = orderArrived.getStatus();
                            assertTrue(callStatusInRSP.replaceAll(" ", "").equalsIgnoreCase("InProgress"), "Call status is In-Progress");
                            //Step 3:Select your call and enter in a repair order number, for a tow in this is the only required field
                            orderArrived.enterRepairOrderNumber(data.get("RepairOrderNumber"));
                            //Step 3:Verify you are able to complete the order.
                            assertTrue(!orderArrived.verifyCompleteButtonIsDisableOrEnable(), "Complete button is enable to complete the call after entering repair order number::" + data.get("RepairOrderNumber"));
                            //Clearing repair order number
                            orderArrived.clearRepairOrderNumber();
                            //Step 4:Enter in a 20 digit alphanumeric repair order number
                            orderArrived.enterRepairOrderNumber(data.get("AlphaNumericRepairOrderNumber"));
                            //Step 4:Verify you are able to complete the order
                            assertTrue(!orderArrived.verifyCompleteButtonIsDisableOrEnable(),"Complete button is enable to complete the call after entering repair order number::"+data.get("AlphaNumericRepairOrderNumber"));
                            //Clicks on close button in order details page
                            orderDetails.clickOnCloseButton();
                            //clicking on discard changes in order details page
                            orderArrived.verifyAndClickOnDiscardChanges();
                        }
                            //Clicks on new order button
                            home.clickOnNewOrder();
                            //Clicks on walk-in
                            newOrder.clickOnWalkin();
                            String walkIn=newOrder.verifyWalkInIsActiveOrNot();
                            //Verifying walk-in is selected or not
                            assertTrue(walkIn.toLowerCase().contains(data.get("VerificationValue").toLowerCase()),"Walk-In is selected");
                            //clicks on create new order button
                            newOrder.clickOnCreateNewOrder();
                            //Step 6: verifying first name is mandatory
                            assertTrue(orderArrived.verifyFirstNameIsMandatory(),"verifying first name is mandatory");
                            //Step 6: verifying last name is mandatory
                            assertTrue(orderArrived.verifyLastNameIsMandatory(),"verifying last name is mandatory");
                            //Step 6: verifying phone number is mandatory
                            assertTrue(orderArrived.verifyPhoneNumberIsMandatory(),"verifying phone number is mandatory");
                            //Step 6: verifying repair order number is mandatory
                            assertTrue(orderArrived.verifyRepairOrderNumberIsMandatory(),"verifying repair order number is mandatory");
                            //Filling out hte values.
                            orderArrived.enterFirstName(data.get("RSPFirstName"));
                            orderArrived.enterLastName(data.get("RSPLastName"));
                            orderArrived.enterPhoneNumber(data.get("RSPPhoneNumber"));
                            orderArrived.enterRepairOrderNumber(data.get("RepairOrderNumber"));
                            //verifing can we complete the order after entering first namer,last name,phone number,repair order number
                            assertTrue(!orderArrived.verifyCompleteButtonIsDisableOrEnable(),"Complete button is enable to complete the call after filling first name::"+data.get("RSPFirstName")+",last name::"+data.get("RSPLastName")+",phone number::"+data.get("RSPPhoneNumber")+" and repair order number::"+data.get("RepairOrderNumber"));
                            //Clicks on close button
                            orderDetails.clickOnCloseButton();
                            //clicking on discard changes in order details page
                            orderArrived.verifyAndClickOnDiscardChanges();
                            if(orderDetails.verifyCloseButton()) {
                                orderDetails.clickOnCloseButton();
                            }
                            //Step 7:Find an existing order and edit a few fields then submit as complete
                            int totalNumberOfRecords=home.verifyRecordsAreAvailable();
                            assertTrue(totalNumberOfRecords>1,"Records found to select exixting call");
                            if(totalNumberOfRecords>1)
                            {
                                for(int existingCallRow=0;existingCallRow<totalNumberOfRecords;existingCallRow++)
                                {
                                    //Selecting an existing call without complete status and call created
                                    if(!home.verifyCallStatus(existingCallRow).toLowerCase().equals("complete")&&!home.verifyingCallId(callId, callCreatedDate))
                                    {
                                        //clicking on existing call
                                        home.clickOnExistingCall(existingCallRow);
                                        //verifying arrived button is visible or not
                                        if(orderDetails.verifyArrivedButton())
                                        {
                                            //clicks on arrived button
                                            orderDetails.clickOnArrived();
                                            //clicks on vehicle arrived button in modal window
                                            orderDetails.clickOnVehicleArrived();
                                        }
                                        //Getting first name
                                        String firstName=orderArrived.getFirstName().replaceAll(" ","").toString();
                                        //Getting last name
                                        String lastName=orderArrived.getLastName().replaceAll(" ","").toString();
                                        //Getting phone number
                                        String phoneNumber=orderArrived.getPhoneNumber().replaceAll(" ","").toString();
                                        //As repair order number is mandatory to complete the order
                                        orderArrived.clearRepairOrderNumber();
                                        //entering repair order number to complete the order
                                        orderArrived.enterRepairOrderNumber(data.get("RepairOrderNumber"));
                                        //Step 7:If first name is empty enters first name else edits the first name
                                        if(firstName.equals("")&&firstName.equals(null)) {
                                            orderArrived.enterFirstName("RSPFirstName");
                                        }
                                        else
                                        {
                                            orderArrived.enterFirstName(firstName.substring(0,firstName.length()-2));
                                        }
                                        //Step 7:If last name is empty enters last name else edits the last name
                                        if(lastName.equals("")&&lastName.equals(null)) {
                                            orderArrived.enterLastName("RSPLastName");
                                        }
                                        else
                                        {
                                            orderArrived.enterLastName(lastName.substring(0,lastName.length()-2));
                                        }
                                        //Step 7:If phone name is empty enters phone name else edits the phone name
                                        if(phoneNumber.equals("")&&phoneNumber.equals(null)) {
                                            orderArrived.enterPhoneNumber(data.get("RSPPhoneNumber"));
                                        }
                                        else
                                        {
                                            orderArrived.enterPhoneNumber(phoneNumber.substring(0,phoneNumber.length()-2));
                                        }
                                        //Getting last updated time
                                        String timeCreated=orderArrived.getTimeCreated();
                                        //Getting first name
                                        firstName=orderArrived.getFirstName();
                                        //Getting last name
                                        lastName=orderArrived.getLastName();
                                        //Clicks on complete button
                                        orderArrived.clickOnCompleteButton();
                                        //click on complete button on modal window
                                        orderArrived.clickOnCompleteOrderInModalWindow();
                                        orderArrived.clickOnYesInModalWindow();
                                        //Searching for a call
                                        for(int pageNumber=2;pageNumber>0;pageNumber++)
                                        {
                                            //finds the call in home page
                                            if(home.findOrderInHomePage(firstName,lastName,timeCreated))
                                            {
                                                //Step 7:Verify the order is completed.
                                               assertTrue(home.getStatusOfParticularCall(firstName,lastName,timeCreated).replaceAll(" ","").toLowerCase().equals("complete"),"Order has been completed sucessfully");
                                                home.clickOnAriaLabelFirstPage();
                                               break;
                                            }
                                            else if(!home.clickOnNextPageNumber(pageNumber))
                                            {
                                                reporter.failureReport("Finding a call","Order edited has not been found");
                                                home.clickOnAriaLabelFirstPage();
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    }
                                }
                             //Uncomment it if you want to create a new call with same test data
                            //createCall(data);
                            //searching a created call
                            home.searchingACall(callId, callCreatedDate);
                            //Step 8:Enter in a new call.
                            home.clickOnCallId(callId, callCreatedDate);
                            //clearing repair order number
                            orderArrived.clearRepairOrderNumber();
                            //Entering repair order number as it is mandatory field
                            orderArrived.enterRepairOrderNumber(data.get("RepairOrderNumber"));
                            //Step 8:Entering service category
                            orderArrived.selectServiceCategory(data.get("ServiceCategory"));
                            //Step 8:Entering service-sub category
                            orderArrived.selectServiceSubCategory(data.get("ServiceSubCategory"));
                            //Clicks on comment button
                            orderDetails.clickOnComment();
                            //Enters comment in comment tab
                            orderDetails.setTextInCommentModelWindow(data.get("Comments"));
                            //Clicking on add comment in modal window
                            orderDetails.clickOnAddCommentsButtonInCommentsModalWindow();
                            //Step 8:Verify you are able to complete the order with the new information.
                            assertTrue(!orderArrived.verifyCompleteButtonIsDisableOrEnable(),"Complete button is enable to complete the repair order::");
                            //Clicks on signout button
                            home.clickOnSignOut();
                    }
                    catch(Exception e)
                    {
                        reporter.failureReport("Failed due to",e.getMessage(),driver);
                        ReportStatus.blnStatus=false;

                    }
                    ReportControl.fnEnableJoin();
                    ReportStatus.fnUpdateResultStatus("RSP","1842",ReportStatus.strMethodName,intCounter,browser);
                    fnCloseTest();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                reporter.failureReport("Failed due to",e.getMessage(),driver);
                throw new RuntimeException(e);
            }
            ReportControl.fnNextTestJoin(nextTestJoin);
        }
    }
