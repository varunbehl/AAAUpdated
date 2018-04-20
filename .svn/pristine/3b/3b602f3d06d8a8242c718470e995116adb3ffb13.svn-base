package com.aaa.web.script;


import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMessagingFacilityAndTruck extends ActionEngine {

    /************************************************************************
     * Script Name :-
     * Method Name :-
     * Module	  :- DI
     * Test Case ID:-
     * Script Date :-
     * Author      :-
     * @param StartRow
     * @param EndRow
     * @param nextTestJoin
     * @throws Throwable
     *************************************************************************/
    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void diMessagingFacilityAndTruck(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "diMessagingFacilityAndTruck", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("diMessagingFacilityAndTruck", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1755:DIMessagingFacilityAndTruck" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib loginRole = new LoginRoleLib();

                    //From D3 Dispatch

                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    //Click on the New Message tab
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //Click the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    //verify list of users
                    boolean listOfusers = diHome.verifyListOfUsersOnAddressBook();
                    assertTrue(listOfusers, "List of Users Are Displayed");
                    //User filter button is toggled
                    boolean userButton = diHome.verifyUserButtonIsHighligted();
                    assertTrue(userButton, "User button is Highlighted");
                    //select the SPP user
                    diHome.selectSPPUserFromMessagePopup();
                    //Click the Add Recipients button
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    // Close the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    boolean receptSttaus = diHome.verifyRecepientIsAdded(data.get("RecepientSPP"));
                    assertTrue(receptSttaus, "");
                    //Type any message under the free form text field
                    diHome.enterMessageInMessageTextBox(data.get("Message1"));
                    //Click the Send button
                    diHome.clickOnSendButtonOnMessagePopup();
                    //The Messages tab should be in focus
                    boolean messageWindow = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindow, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();


                    //From D3 SPP Dispatch
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForSPP"), data.get("PasswordForSPP"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnFacilityPTA();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    boolean msgRecevied = diHome.verifyMessageReceviedByUser(data.get("Message1"));
                    assertTrue(msgRecevied, "Message have been received by the SPP user");
                    diHome.clickOnreplybuttonOnMessagePopup();
                    diHome.enterMessageInMessageTextBox(data.get("Message2"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    //The Messages tab should be in focus
                    boolean messageWindowForMsg2 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg2, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //From D3 Dispatch,
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    boolean msgRecevied1 = diHome.verifyMessageReceviedByUser(data.get("Message2"));
                    assertTrue(msgRecevied1, "Message have been received by the Dispatch user");
                    diHome.clickOnreplybuttonOnMessagePopup();
                    diHome.enterMessageInMessageTextBox(data.get("Message3"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    //The Messages tab should be in focus
                    boolean messageWindowForMsg3 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg3, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //From D3 SPP Dispatch,
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForSPP"), data.get("PasswordForSPP"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnFacilityPTA();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    boolean msgRecevied2 = diHome.verifyMessageReceviedByUser(data.get("Message3"));
                    assertTrue(msgRecevied2, "Message have been received by the SPP user");
                    //The Messages tab should be in focus
                    boolean messageWindowForMsg = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //Click the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    diHome.clickOnTruckTab();
                    diHome.enterFacilityInFacilityText(data.get("facility"));
                    Thread.sleep(5000);
                    diHome.ClickOnPlusIconOnFacilityInMessagePopup();
                    diHome.clickOnTruckUserInMessagePopup(data.get("Truck"));
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    // Close the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    boolean receptSttaus1 = diHome.verifyRecepientIsAdded(data.get("recepientitu"));
                    assertTrue(receptSttaus1, "");
                    diHome.enterMessageInMessageTextBox(data.get("Message4"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    boolean messageWindowForMsg4 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg4, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();


                    //verification is not done here as step belongs to Itu.It will be done as part of ITU.


                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //Click the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    diHome.clickOnTruckTab();
                    diHome.enterFacilityInFacilityText(data.get("facility"));
                    Thread.sleep(3000);
                    diHome.clickOnFacilityInMessagePopup(data.get("facility"));
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    // Close the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    boolean receptSttaus2 = diHome.verifyRecepientIsAdded(data.get("recepientitu2"));
                    assertTrue(receptSttaus2, "");
                    diHome.enterMessageInMessageTextBox(data.get("Message4"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    boolean messageWindowForMsg5 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg5, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //verification is not done here as step belongs to Itu.It will be done as part of ITU.


                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1755", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void diMessagingFacilityAndTruckInPopedOut(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "diMessagingFacilityAndTruck", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("diMessagingFacilityAndTruck", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1755:DIMessagingFacilityAndTruck" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib loginRole = new LoginRoleLib();

                    //From D3 Dispatch

                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    String mainWinHandle = driver.getWindowHandle();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    //Click on the New Message tab
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //Click the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    //verify list of users
                    boolean listOfusers = diHome.verifyListOfUsersOnAddressBook();
                    assertTrue(listOfusers, "List of Users Are Displayed");
                    //User filter button is toggled
                    boolean userButton = diHome.verifyUserButtonIsHighligted();
                    assertTrue(userButton, "User button is Highlighted");
                    //select the SPP user
                    diHome.selectSPPUserFromMessagePopup();
                    //Click the Add Recipients button
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    // Close the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    boolean receptSttaus = diHome.verifyRecepientIsAdded(data.get("RecepientSPP"));
                    assertTrue(receptSttaus, "");
                    //Type any message under the free form text field
                    diHome.enterMessageInMessageTextBox(data.get("Message1"));
                    //Click the Send button
                    diHome.clickOnSendButtonOnMessagePopup();
                    //The Messages tab should be in focus
                    boolean messageWindow = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindow, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();


                    //From D3 SPP Dispatch
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForSPP"), data.get("PasswordForSPP"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnFacilityPTA();
                    String mainWinHandle1 = driver.getWindowHandle();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    boolean msgRecevied = diHome.verifyMessageReceviedByUser(data.get("Message1"));
                    assertTrue(msgRecevied, "Message have been received by the SPP user");
                    diHome.clickOnreplybuttonOnMessagePopup();
                    diHome.enterMessageInMessageTextBox(data.get("Message2"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    //The Messages tab should be in focus
                    boolean messageWindowForMsg2 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg2, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle1);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //From D3 Dispatch,
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    String mainWinHandle2 = driver.getWindowHandle();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    boolean msgRecevied1 = diHome.verifyMessageReceviedByUser(data.get("Message2"));
                    assertTrue(msgRecevied1, "Message have been received by the Dispatch user");
                    diHome.clickOnreplybuttonOnMessagePopup();
                    diHome.enterMessageInMessageTextBox(data.get("Message3"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    //The Messages tab should be in focus
                    boolean messageWindowForMsg3 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg3, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle2);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //From D3 SPP Dispatch,
                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForSPP"), data.get("PasswordForSPP"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnFacilityPTA();
                    String mainWinHandle3 = driver.getWindowHandle();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    boolean msgRecevied2 = diHome.verifyMessageReceviedByUser(data.get("Message3"));
                    assertTrue(msgRecevied2, "Message have been received by the SPP user");
                    //The Messages tab should be in focus
                    boolean messageWindowForMsg = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle3);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    String mainWinHandle4 = driver.getWindowHandle();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //Click the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    diHome.clickOnTruckTab();
                    diHome.enterFacilityInFacilityText(data.get("facility"));
                    Thread.sleep(5000);
                    diHome.ClickOnPlusIconOnFacilityInMessagePopup();
                    diHome.clickOnTruckUserInMessagePopup(data.get("Truck"));
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    // Close the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    boolean receptSttaus1 = diHome.verifyRecepientIsAdded(data.get("recepientitu"));
                    assertTrue(receptSttaus1, "");
                    diHome.enterMessageInMessageTextBox(data.get("Message4"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    boolean messageWindowForMsg4 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg4, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle4);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();


                    //verify itu c


                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    String mainWinHandle5 = driver.getWindowHandle();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //Click the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    diHome.clickOnTruckTab();
                    diHome.enterFacilityInFacilityText(data.get("facility"));
                    Thread.sleep(3000);
                    diHome.clickOnFacilityInMessagePopup(data.get("facility"));
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    // Close the Address Book slide out
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    boolean receptSttaus2 = diHome.verifyRecepientIsAdded(data.get("recepientitu2"));
                    assertTrue(receptSttaus2, "");
                    diHome.enterMessageInMessageTextBox(data.get("Message4"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    boolean messageWindowForMsg5 = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindowForMsg5, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle5);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();

                    //itu verify


                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1755", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }


}

