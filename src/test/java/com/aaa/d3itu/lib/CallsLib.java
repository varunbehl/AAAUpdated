package com.aaa.d3itu.lib;

import static org.testng.Assert.assertTrue;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.ITestContext;

import com.aaa.d3itu.page.LoginPage;

public class CallsLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }
    


    public void clickOnAssignTruckAccept() throws Throwable {
        waitForVisibilityOfElement(CallsPage.assignTruckAccept, "click accept to assign truck ");
        click(CallsPage.assignTruckAccept, "click accept to assign truck");
    }

    public void getAssignStatus() throws Throwable {
    	if (isVisibleOnly(CallsPage.statusAS, "get assign status"))
        getText(CallsPage.statusAS, "Status is on assign state");
    }

    public void clickOnAssignCallToTruck() throws Throwable {
    	if (isVisibleOnly(CallsPage.assignCallToTruck, "click on assign call to truck"))
        click(CallsPage.assignCallToTruck, "click on assign call to truck");

    }


    public void getDispatchStatus() throws Throwable {
    	if (isVisibleOnly(CallsPage.statusDI, "get dispatch status"))
        getText(CallsPage.statusDI, "Status is on dispatch state");

    }

    public void clickOnNextStatus() throws Throwable {
        if(isVisibleOnly(CallsPage.nextStatus, "click on next status")) {
            click(CallsPage.nextStatus, "click on next status");
        }

    }

    public void getEnRouteStatus() throws Throwable {
        waitForVisibilityOfElement(CallsPage.statusER, "get enroute status");
        getText(CallsPage.statusER, "Status is on enroute state");

    }

    public void getOnLocationStatus() throws Throwable {
        waitForVisibilityOfElement(CallsPage.statusOL, "get on Location status");
        getText(CallsPage.statusOL, "Status is on Location state");

    }

    public void clickOkOnErrorPopup() throws Throwable {
        if(isVisibleOnly(CallsPage.errorPopup, "Error Popup"))
        {
            getText(CallsPage.errorPopupMsg, "Error Popup Msg");
            click(CallsPage.okOnErrorPopup, "Click on ok error popup");
        }
    }


    public void clickOnCall(String SearchValue) throws Throwable {
           waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
           // Thread.sleep(10000);
            Thread.sleep(4000);
            clickOkOnNewCallPopup();
            //click(CallsPage.clickonCall(SearchValue),"click on call : "+SearchValue);
            scrollAndClick(CallsPage.clickonCall(SearchValue));
            clickOkOnNewCallPopup();
            //String uiSelector = "new UiSelector().textMatches(\"" + SearchValue + "\")";
            //String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";

            //appiumDriver.scrollTo(command);
            //appiumDriver.scrollTo(SearchValue);
            //click(CallsPage.clickonCall(SearchValue),"click on call : "+SearchValue);
            
           /*if(isVisibleOnly(CallsPage.callAsSP, "click on call"))
           {
            click(CallsPage.callAsSP, "click on call");
           }
           else
           {
	            appiumDriver.scrollTo(SearchValue);
	            Thread.sleep(2000);
	            if (isVisibleOnly(CallsPage.callAsSP, "click on call")){
	            	click(CallsPage.callAsSP, "click on call");
	            }else{
	            	click(CallsPage.callasAS, "click on Assigned call");
	            }
            }*/
            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
           }

    public void clickOkOnNewCallPopup() throws Throwable {
      Thread.sleep(5000);
    	if(isVisibleOnly(CallsPage.btnOkOnNewCallPopup, "call")) {
    		getText(CallsPage.assignedCallPopup, "call");
            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            click(CallsPage.btnOkOnNewCallPopup, "click on ok");	
    	}
        
    }


    
    public void statusUpdateAsAssignment(String Assignmnet) throws Throwable {
        if (Assignmnet.equalsIgnoreCase("accept")) {
            clickOnAssignTruckAccept();
            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
        }else{
        	clickOnAssignTruckDecline();
        }
    }

    public void statusUpdateDI(String StatusUpdateDI) throws Throwable {
          waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (StatusUpdateDI.equalsIgnoreCase("DI")) {
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                getDispatchStatus();
                clickOkOnErrorPopup();
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

            }
        }



    public void statusUpdateER(String statusUpdateAsER) throws Throwable {
          waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsER.equalsIgnoreCase("ER")) {
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                getEnRouteStatus();
                clickOkOnErrorPopup();
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

            }
        }

    public void statusUpdateOL(String statusUpdateAsOL) throws Throwable {
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsOL.equalsIgnoreCase("OL")) {
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                getOnLocationStatus();
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

            }
        }

    public void statusUpdateTW(String statusUpdateAsTW) throws Throwable {
         waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsTW.equalsIgnoreCase("TW")) {
                boolean clstatus = verifyCLStatus();
                if(!clstatus) {
                    clickOnNextStatus();
                    waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                }
            }
        }

    public void statusUpdateCL(String statusUpdateAsCL) throws Throwable {
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsCL.equalsIgnoreCase("CL")) {
                clickOnNextStatus();
                
            }
        }
    public void clickOnAssignTruckDecline() throws Throwable {
        waitForVisibilityOfElement(CallsPage.assignTruckDecline, " Decline ");
        click(CallsPage.assignTruckDecline, "click Decline ");
    }
    public void waitforCallAlertPopup() throws Throwable {
    	waitForVisibilityOfElement(CallsPage.btnOkOnNewCallPopup, "call");
    }
    
    //Options on New Incoming Call
    public void selectAnOptionForNewCall(String oKorGoToCall) throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(CallsPage.btnOkOnNewCallPopup, "call");
      	if(isVisibleOnly(CallsPage.btnOkOnNewCallPopup, "call")) {
      		getText(CallsPage.assignedCallPopup, "call");
              waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
              if(oKorGoToCall.equalsIgnoreCase("ok")){
            	  click(CallsPage.btnOkOnNewCallPopup, "click on ok");	
              }
              else{
            	  click(CallsPage.btnGoToCallOnNewCallPopup, "GoToCall");	
              }
      	}
      }
    //Scroll Call into view from the assigned list
    public void scrollCallIntoView(String callID) throws Throwable {
        scrollIntoView(CallsPage.lblCallInTheAssignedList(callID));
    }
/*    public void validateCallStatus(String callID,String callStatus) throws Throwable {
        scrollIntoView(CallsPage.lblCallInTheAssignedList(callID));
        
    }*/
    public void validateCallStatus(String callID,String callStatus) throws Throwable{
    	String actualCallStatus=getText(CallsPage.lblCallStatus(callID), "Call Status ");
		if (actualCallStatus.toLowerCase().equalsIgnoreCase(callStatus.toLowerCase())) {
			reporter.SuccessReport("Validate the call status as "+callStatus , "The call status is validated : "+ actualCallStatus);
		} else {
			reporter.failureReport("Validate the call status as "+callStatus , "The displayed call status is : "+ actualCallStatus);
		}
    }


    public void clickOnCallStatus() throws Throwable {
        if(isVisibleOnly(CallsPage.callStatusOnlyActive, "click on Only Active")) {
            click(CallsPage.callStatusOnlyActive, "click on Only Active");
        }
        Thread.sleep(5000);
        if(isVisibleOnly(CallsPage.callStatusAllCalls, "click on All Calls")) {
            click(CallsPage.callStatusAllCalls, "click on All Calls");
        }
    }

    public void clickOnSortOrder() throws Throwable {
        if(isVisibleOnly(CallsPage.sortOrdeAscending, "click on Ascending")) {
            click(CallsPage.sortOrdeAscending, "click on Ascending");
        }
        Thread.sleep(5000);
        if(isVisibleOnly(CallsPage.sortOrdeDescending, "click on Descending")) {
            click(CallsPage.sortOrdeDescending, "click on Descending");
        }
    }

    public void clickOnOkButton() throws Throwable {
        if(isVisibleOnly(CallsPage.OKButton, "click on OK Button")) {
            click(CallsPage.OKButton, "click on OK Button");
        }
    }

    public void clickOnDeclineCallComment() throws Throwable {
        if(isVisibleOnly(CallsPage.DeclineCallComment, "click on Decline Call Comment")) {
            click(CallsPage.DeclineCallComment, "click on Decline Call Comment");
        }
    }

    public void clickOnAllFacilities() throws Throwable {
        if(isVisibleOnly(CallsPage.lblAllFacilities, "click on All facilities")) {
            click(CallsPage.lblAllFacilities, "click on All facilities");
        }
    }

    public void sortAllCallsInDescendingOrder() throws Throwable
    {
        clickOnAllFacilities();
        Thread.sleep(5000);
        clickOnCallStatus();
        clickOnSortOrder();
        Thread.sleep(2000);
        clickOnOkButton();
    }

    public boolean verifyCLStatus() throws Throwable
    {
        boolean CLStatusAvailable = isVisibleOnly(CallsPage.statusCL, "CL Status");
        return CLStatusAvailable;
    }

}

