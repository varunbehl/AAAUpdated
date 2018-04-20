package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIMCDPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DICreditCard extends DILoginLib {
    public static String callID;
    public static String callDateCreated;
    public static String callIDAndDateCombined;

    @Parameters({"StartRow", "EndRow", "nextTestJoin"})
    @Test()
    public void diCreditCard(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DICreditCard", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DICreditCard", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1988: DI Credit Card" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRTowDestinationLib towdestination = new CRTowDestinationLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DIProfileLib diProfileLib = new DIProfileLib();
                    CommonLib common = new CommonLib();


                    navigateToApplication("CR");
                    home.verifyandClickLogout();
                    login.login(data.get("LoginName"), data.get("Password"));
                    home.verifyHomeScreen();
                    home.messageDialogBoxClose();
                    String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("MemberNumber");
                    }
                    home.memberSearchTextBox(Member);
                    memeber.memberNumClick();


                    //enter prime phone type cellular
                    memeber.membContInfoEnterPrimPhoneTypeCellular();
                    //enter prime phone radio button
                    memeber.clickPrimRadioBtnRowOne();
                    memeber.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("Primaryphonenum1"));
                    //Enter breakdown location
                    locations.clickOnLocationTab();
                    locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
                    vehicle.clickOnVehicleTriageTab();

                    //Enter vehicle details and pacesetter code
                    vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
                    Thread.sleep(2000);
                    vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    towdestination.clickOnTowDestinationTab();

                    //Enter Tow destination
                    towdestination.enterTowDestinationLocationFields(data.get("TowAddress"));
                    service.clickOnServiceTab();

                    //Enter facility
                    service.enterManualSpotDetails(data.get("facilityNumber"));
                    towdestination.errorAlertHandlingBeforeEnterMandatoryFields();

                    //save call
                    home.saveButton();
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    //getCallIDAndDate();
                    callID = service.getCallId();
                    callDateCreated = service.getCallDate();
                    service.closeCall();
                    home.logout();
                    acceptAlert();
                    acceptAlert();

                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID);

                    diMCD.clickOnCreditCardButtonOnMCDWindow();
                    switchToFrame(DIMCDPage.creditCardFrame);
                    //Enter credit card details
                    diMCD.clickOnUseMemberDataOnCreditcardTab();
                    diMCD.enterAmountOnBillingInfoPage(data.get("Amount"));
                    diMCD.clickOnContinueButtonInCreditcardTab();
                    //verify user is moved to credit card info Tab
                    assertTrue(diMCD.verifyCreditCardInfoTab(), "User is moved to Credit Card info Tab");
                    diMCD.enterCreditCardNumberOnCrediCardInfoPage(data.get("CreditCardNumber"));
                    diMCD.selectMonthOnCreditCardInfoPage(data.get("Month"));
                    diMCD.selectYearOnCreditCardInfoPage(data.get("Year"));
                    diMCD.enterCVCOnCrediCardInfoPage(data.get("CVC"));
                    diMCD.clickOnContinueButtonInCreditcardInfoPage();

                    //verify whether card is valid or invalid
                    //Here code will fail Invalid cards
                    if (diMCD.VerifyInvalidCreditCardDetailsForPayment()) {
                        reporter.failureReport("Card Details", "Card details found are Invalid");
                        comeOutFromFrame();
                        diMCD.clickOnCloseButtonInCreditcard();
                        diMCD.clickOnMCDCloseWindow();
                        diHome.logOut();
                        acceptAlert();
                        acceptAlert();
                    } else {
                        //Verify user is moved to Transaction Info Tab
                        assertTrue(diMCD.verifyTransactionInfoTab(), "User is moved to Transaction Info Tab");
                        comeOutFromFrame();
                        String last4digitsOfCard = data.get("CreditCardNumber").substring(12, 16);
                        //verify Transaction History displayed card information
                        assertTrue(diMCD.getCreditCardInTransactionHistory().contains(last4digitsOfCard), "Transaction History displayed card information");
                        assertTrue(diMCD.VerifyTransactionTypeOnTransactionHistory(), "TransactionType is Displayed");
                        assertTrue(diMCD.VerifyTransactionRoutingIdOnTransactionHistory(), "TransactionRoutingId is Displayed");
                        assertTrue(diMCD.VerifyTransactionAmountOnTransactionHistory(), "TransactionAmount is Displayed ");
                        assertTrue(diMCD.VerifyTransactionCodeOnTransactionHistory(), "TransactionCode is Displayed");
                        diMCD.clickOnCloseButtonInCreditcard();
                        diMCD.clickOnMCDCloseWindow();
                        diHome.logOut();
                        acceptAlert();
                        acceptAlert();
                        System.out.println("Test completed");
                    }
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1988", ReportStatus.strMethodName, intCounter, browser);
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
    public void diSavingVoidedCreditCard(int StartRow, String EndRow, boolean nextTestJoin) throws Throwable {
        try {
            int intStartRow = StartRow;
            int intEndRow = ReportControl.fnGetEndRowCunt(EndRow, "DIVoidedCreditCard", TestData, "D3Dispatch");
            for (int intCounter = intStartRow; intCounter <= intEndRow; intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIVoidedCreditCard", TestData, "D3Dispatch", intCounter);
                    this.reporter.initTestCaseDescription("1988: DI Credit Card" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    DIHomeLib diHome = new DIHomeLib();
                    DIMCDLib diMCD = new DIMCDLib();
                    DILoginLib diLogin = new DILoginLib();
                    LoginLib login = new LoginLib();
                    CRHomeLib home = new CRHomeLib();
                    CRMemberSearchLib memeber = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRTowDestinationLib towdestination = new CRTowDestinationLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib service = new CRServiceLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DIProfileLib diProfileLib = new DIProfileLib();
                    CommonLib common = new CommonLib();


                    navigateToApplication("CR");
                    home.verifyandClickLogout();
                    login.login(data.get("LoginName"), data.get("Password"));
                    home.verifyHomeScreen();
                    home.messageDialogBoxClose();
                    String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("MemberNumber");
                    }
                    home.memberSearchTextBox(Member);
                    memeber.memberNumClick();


                    //enter prime phone type cellular
                    memeber.membContInfoEnterPrimPhoneTypeCellular();
                    //enter prime phone radio button
                    memeber.clickPrimRadioBtnRowOne();
                    memeber.enterMemberContactInfoPrimaryPhoneNumberRandomly(data.get("Primaryphonenum1"));
                    //Enter breakdown location
                    locations.clickOnLocationTab();
                    locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
                    vehicle.clickOnVehicleTriageTab();

                    //Enter vehicle details and pacesetter code
                    vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
                    vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
                    Thread.sleep(2000);
                    vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
                    vehicle.handleScriptErrorInVehicleTriagePage();
                    towdestination.clickOnTowDestinationTab();

                    //Enter Tow destination
                    towdestination.enterTowDestinationLocationFields(data.get("TowAddress"));
                    service.clickOnServiceTab();

                    //Enter facility
                    service.enterManualSpotDetails(data.get("facilityNumber"));
                    towdestination.errorAlertHandlingBeforeEnterMandatoryFields();

                    //save call
                    home.saveButton();
                    home.waitCloseAllBusyIconsResults();
                    Thread.sleep(3000);
                    //getCallIDAndDate();
                    callID = service.getCallId();
                    callDateCreated = service.getCallDate();
                    service.closeCall();
                    home.logout();
                    acceptAlert();
                    acceptAlert();

                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsInDispatch();

                    //Search for a call ID  in Search call window
                    diHome.searchAndSelectCallIDInDI(callID);

                    diMCD.clickOnCreditCardButtonOnMCDWindow();
                    switchToFrame(DIMCDPage.creditCardFrame);
                    diMCD.clickOnUseMemberDataOnCreditcardTab();
                    //Enter credit card details
                    diMCD.enterAmountOnBillingInfoPage(data.get("Amount"));
                    diMCD.clickOnContinueButtonInCreditcardTab();
                    //verify user is moved to credit card info tab
                    assertTrue(diMCD.verifyCreditCardInfoTab(), "User is moved to Credit Card info Tab");
                    diMCD.enterCreditCardNumberOnCrediCardInfoPage(data.get("CreditCardNumber"));
                    diMCD.selectMonthOnCreditCardInfoPage(data.get("Month"));
                    diMCD.selectYearOnCreditCardInfoPage(data.get("Year"));
                    diMCD.enterCVCOnCrediCardInfoPage(data.get("CVC"));
                    diMCD.clickOnContinueButtonInCreditcardInfoPage();
                    //verify whether card is valid or invalid
                    //Here code will fail Invalid cards
                    if (diMCD.VerifyInvalidCreditCardDetailsForPayment()) {
                        reporter.failureReport("Card Details", "Card details found are Invalid");
                        comeOutFromFrame();
                        diMCD.clickOnCloseButtonInCreditcard();
                        diMCD.clickOnMCDCloseWindow();
                        diHome.logOut();
                        acceptAlert();
                        acceptAlert();
                    } else {
                        //verify User is moved to Transaction Info Tab
                        assertTrue(diMCD.verifyTransactionInfoTab(), "User is moved to Transaction Info Tab");
                        //click on void Authorization button
                        diMCD.clickOnVoidAuthorization();
                        Thread.sleep(5000);
                        //After clicking on void Authorization button no page is displayed .so,we are failing this step
                        Boolean processing = isVisibleOnly(DIMCDPage.lblProcessing, "processing");
                        if (processing) {
                            reporter.failureReport("Status from Authorized to Voided", "Status not changed from Authorized to Voided");
                        }
                        comeOutFromFrame();
                        diMCD.clickOnCloseButtonInCreditcard();
                        diMCD.clickOnMCDCloseWindow();
                        diHome.logOut();
                        acceptAlert();
                        acceptAlert();
                        System.out.println("Test completed");
                    }
                } catch (Exception e) {
                    ReportStatus.blnStatus = false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("DI", "1988", ReportStatus.strMethodName, intCounter, browser);
                fnCloseTest();

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }


}
