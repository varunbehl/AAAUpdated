package com.aaa.web.script;


import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMessages extends ActionEngine {

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
    public void diMessages(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIMessages", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMessages", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1603:DIMessages" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib loginRole = new LoginRoleLib();


                    navigateToApplication("DI");
                    login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                    diHome.clickMessagePopUpOnDispatchHomepage();
                    String mainWinHandle = driver.getWindowHandle();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();

                    //verify message window can be popped out
                    assertTrue(diHome.verifyPopOutInMessagePopUpWindow(), "Message window opened and can be popped out");
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(2000);
                    driver.switchTo().window(mainWinHandle);
                    Thread.sleep(3000);

                    //select new message tab
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //open address book
                    diHome.clickOnAddressBookTab();
                    //verify list of users
                    boolean listOfusers = diHome.verifyListOfUsersOnAddressBook();
                    assertTrue(listOfusers, "List of Users Are Displayed");
                    //verify user button highlighted
                    boolean userButton = diHome.verifyUserButtonIsHighligted();
                    assertTrue(userButton, "User button is Highlighted");
                    diHome.selectCallTakerUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    diHome.clickOnSendButtonOnMessagePopup();
                    //verify message field turns into red error
                    boolean Error = diHome.verifyMessageTextFieldturnsRed();
                    assertTrue(Error, "Message field turns into red");
                    String countbefore = diHome.getCharacterslimitCount();

                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    String countAfter = diHome.getCharacterslimitCount();
                    int count = Integer.parseInt(countbefore) - data.get("Message").length();
                    String countLimit = Integer.toString(count);
                    //message window displays an indication showing a limit of characters
                    assertTrue(countAfter.equalsIgnoreCase(countLimit), "Verified message window displays an indication showing limit of characters");
                    diHome.clickOnSendButtonOnMessagePopup();
                    //verify new message window closed and message window in focus
                    boolean messageWindow = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindow, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);


                    diHome.clickOnNewMessageTab();
                    Thread.sleep(5000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //sending message to a d3 dispatch user
                    diHome.selectDispatchUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    Thread.sleep(20000);
                    //verify message sent and viewed by d3 dispatch user
                    String message = diHome.verifyMessageSentAndViewedByRecipient();
                    assertTrue(message.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
                    Thread.sleep(3000);


                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //sending message to a d3 call receiving user
                    diHome.selectCallTakerUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    openURLInNewWindow("https://qaautoap1.national.aaa.com:8443/D3Calls/login.jsp");
                    switchToWindow();
                    login.login(data.get("CrLoginName"), data.get("CrPassword"));
                    Thread.sleep(5000);
                    click(DIHomePage.lnkMessagePopup, "Message popup link");
                    //verify message sent and viewed by d3 call receiving user
                    String crMessage = diHome.verifyMessageSentAndViewedByRecipient();
                    assertTrue(crMessage.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    home.verifyandClickLogout();
                    acceptAlert();
                    acceptAlert();
                    closeWindow();
                    switchToWindow();
                    Thread.sleep(3000);


                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //click on Groups radio button
                    diHome.clickOnGropsRadioButtonOnMessagePopup();
                    //verifying list of Group users
                    boolean listOfgroups = diHome.verifyListOfUsersOnAddressBook();
                    assertTrue(listOfgroups, "List of Groups Are Displayed");
                    //select a group that has expanded option and select that user
                    diHome.clickOnExpandOptionFromGroup();
                    String groupselected = diHome.selectGroupFromExpandedOptionsOnMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //verifying group expanded selected user is added to recipient
                    assertTrue(diHome.verifyGroupAddedToRecipient().equalsIgnoreCase(groupselected), "user added to recipient");
                    diHome.removeRecipientFormMessagePopUp();
                    diHome.clickOnAddressBookTab();
                    //select a user from a group that don't expand
                    String recipientSelectedFromGroup = diHome.selectGroupFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //verify the group that don't expand is added
                    assertTrue(diHome.verifyGroupAddedToRecipient().equalsIgnoreCase(recipientSelectedFromGroup), "Group added to recipient");
                    //type message and send
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    boolean messagetab = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    //verifying new message window closes and message window is in focus
                    assertTrue(messagetab, "New Message Window Closed And Message Window In Focus");

                    //Replying to messages
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    diHome.selectDispatchUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    diHome.clickOnAddressBookTab();
                    //entering a message here
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    assertTrue(diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus(), "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(30000);
                    //clicking on reply button
                    diHome.clickOnCheckForReplyingMessage();
                    diHome.clickOnreplybuttonOnMessagePopup();
                    //replying to the previous message
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    Thread.sleep(20000);
                    //verifying for the message content which is replied
                    assertTrue(diHome.verifyMessageSentAndViewedByRecipient().equalsIgnoreCase(data.get("Message")), "Able to reply for a message");
                    Thread.sleep(20000);
                    //Acknowledging the messages
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    //verifying messages are no longer available
                    boolean noMessages = diHome.verifyNoMessagesOnMessagePopup();
                    assertTrue(noMessages, "No messages are Available");
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1603", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

    /*  ***********************************************************************
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
    public void diMessagesOnPoppedoutWindow(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIMessages", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIMessages", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("1603:DIMessages" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib loginRole = new LoginRoleLib();

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
                    //verify message window can be popped out
                    assertTrue(diHome.verifyPopOutInMessagePopUpWindow(), "Message window opened and can be popped out");

                    //select new message tab
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    //open address book
                    diHome.clickOnAddressBookTab();
                    //verify list of users
                    boolean listOfusers = diHome.verifyListOfUsersOnAddressBook();
                    assertTrue(listOfusers, "List of Users Are Displayed");
                    //verify user button highlighted
                    boolean userButton = diHome.verifyUserButtonIsHighligted();
                    assertTrue(userButton, "User button is Highlighted");
                    diHome.selectCallTakerUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    diHome.clickOnSendButtonOnMessagePopup();
                    //verify message field turns into red error
                    boolean Error = diHome.verifyMessageTextFieldturnsRed();
                    assertTrue(Error, "Message field turns into red");
                    String countbefore = diHome.getCharacterslimitCount();

                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    String countAfter = diHome.getCharacterslimitCount();
                    int count = Integer.parseInt(countbefore) - data.get("Message").length();
                    String countLimit = Integer.toString(count);
                    //message window displays an indication showing a limit of characters
                    assertTrue(countAfter.equalsIgnoreCase(countLimit), "Verified message window displays an indication showing limit of characters");
                    diHome.clickOnSendButtonOnMessagePopup();
                    //verify new message window closed and message window in focus
                    boolean messageWindow = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    assertTrue(messageWindow, "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(3000);


                    diHome.clickOnNewMessageTab();
                    Thread.sleep(5000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //sending message to a d3 dispatch user
                    diHome.selectDispatchUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    Thread.sleep(20000);
                    //verify message sent and viewed by d3 dispatch user
                    String message = diHome.verifyMessageSentAndViewedByRecipient();
                    assertTrue(message.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
                    Thread.sleep(3000);


                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //sending message to a d3 call receiving user
                    diHome.selectCallTakerUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(2000);
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(8000);
                    switchToWindow();
                    openURLInNewWindow("https://qaautoap1.national.aaa.com:8443/D3Calls/login.jsp");
                    switchToWindow();
                    login.login(data.get("CrLoginName"), data.get("CrPassword"));
                    Thread.sleep(5000);
                    click(DIHomePage.lnkMessagePopup, "Message popup link");
                    String crMessage = diHome.verifyMessageSentAndViewedByRecipient();
                    assertTrue(crMessage.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    home.verifyandClickLogout();
                    acceptAlert();
                    acceptAlert();
                    closeWindow();
                    switchToWindow();
                    Thread.sleep(3000);
                    diHome.popOutAndPopInMessagePopUpWindow();
                    Thread.sleep(5000);
                    switchToWindow();
                    Thread.sleep(3000);
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //click on Groups radio button
                    diHome.clickOnGropsRadioButtonOnMessagePopup();
                    //verifying list of Group users
                    boolean listOfgroups = diHome.verifyListOfUsersOnAddressBook();
                    assertTrue(listOfgroups, "List of Groups Are Displayed");
                    //select a group that has expanded option and select that user
                    diHome.clickOnExpandOptionFromGroup();
                    String groupselected = diHome.selectGroupFromExpandedOptionsOnMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //verifying group expanded selected user is added to recipient
                    assertTrue(diHome.verifyGroupAddedToRecipient().equalsIgnoreCase(groupselected), "user added to recipient");
                    diHome.removeRecipientFormMessagePopUp();
                    diHome.clickOnAddressBookTab();
                    //select a user from a group that don't expand
                    String recipientSelectedFromGroup = diHome.selectGroupFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    Thread.sleep(3000);
                    //verify the group that don't expand is added
                    assertTrue(diHome.verifyGroupAddedToRecipient().equalsIgnoreCase(recipientSelectedFromGroup), "Group added to recipient");
                    //type message and send
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    boolean messagetab = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
                    //verifying new message window closes and message window is in focus
                    assertTrue(messagetab, "New Message Window Closed And Message Window In Focus");

                    //Replying to messages
                    diHome.clickOnNewMessageTab();
                    Thread.sleep(3000);
                    diHome.clickOnAddressBookTab();
                    diHome.selectDispatchUserFromMessagePopup();
                    diHome.clickOnAddRecipientButtonOnMessagePopup();
                    diHome.clickOnAddressBookTab();
                    //entering a message here
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    assertTrue(diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus(), "New Message Window Closed And Message Window In Focus");
                    Thread.sleep(30000);
                    //clicking on reply button
                    diHome.clickOnCheckForReplyingMessage();
                    diHome.clickOnreplybuttonOnMessagePopup();
                    //replying to the previous message
                    diHome.enterMessageInMessageTextBox(data.get("Message"));
                    diHome.clickOnSendButtonOnMessagePopup();
                    Thread.sleep(20000);
                    //verifying for the message content which is replied
                    assertTrue(diHome.verifyMessageSentAndViewedByRecipient().equalsIgnoreCase(data.get("Message")), "Able to reply for a message");
                    Thread.sleep(20000);
                    //Acknowledging the messages
                    diHome.clearAllMessagesInMessagepopup();
                    home.allErrorAlerts();
                    boolean noMessages = diHome.verifyNoMessagesOnMessagePopup();
                    assertTrue(noMessages, "No messages are Available");
                    diHome.popOutAndPopInMessagePopUpWindow();
                    driver.switchTo().window(mainWinHandle);
                    diHome.logOut();
                    acceptAlert();
                    acceptAlert();
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1603", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }
}


