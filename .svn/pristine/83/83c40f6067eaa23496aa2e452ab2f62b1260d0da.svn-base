package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import com.aaa.web.page.CRServicePage;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRCreditCard extends LoginLib {
    public static String autoSpotId = null;
    CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib CRServiceLib = new CRServiceLib();

    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyCreditCard(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyCreditCard", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyCreditCard", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1606:TC-Credit Card"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //navigate and login to CR
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                //Enter membership number using db
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                //enter breakdown location
						crLocationsLib.clickOnLocationTab();
						crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
						crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
		                //enter problem type
		                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType1"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                CRServiceLib.clickOnServiceTab();
		                autoSpotId = CRServiceLib.validateFacilityAutospotID();
		                //click on credit card
		                CRServiceLib.clickOnCreditCard();
		                //verify the credit card icon in call ribbon
		                String creditCardIconInCallRibbon = CRServiceLib.verifyCreditCardInCallRibbon();
		                assertTrue(creditCardIconInCallRibbon != null, "<b>Credit Card icon is displayed in the call ribbon</b>"+creditCardIconInCallRibbon);
						//click on call ribbon
		                CRServiceLib.clickOnCreditCardInCallRibbion();
		                //switch to credit card frame
						switchToWindow();
						Thread.sleep(2000);
						//verify Credit Card Payment option is added to the current call menu.
						String creditCardPaymentOptionAdded = CRServiceLib.verifyCreditCardPaymentOption();
						assertTrue(creditCardPaymentOptionAdded != null, "<b>Credit Card Payment option is added to the current call menu</b>"+creditCardPaymentOptionAdded);
						//Verify  Credit Card payment dialog-- Billing Info tab selected-- is displayed.
						switchToFrame(CRServicePage.creditCardFrame);
						Thread.sleep(2000);
						String billingTabVisibility = CRServiceLib.verifyBillingTab();
						assertTrue(billingTabVisibility != null, "<b>Credit Card payment dialog-- Billing Info tab selected-- is displayed:</b>"+billingTabVisibility);
						//clcik on membership data to use the details
						CRServiceLib.clickOnUseMemberDataOnCreditcardTab();
						Thread.sleep(3000);
						//enter amount
						CRServiceLib.enterAmountOnBillingInfoPage(data.get("Amount"));
						//click on continue
						CRServiceLib.clickOnContinueButtonInCreditcardTab();
						//Verify that the user is moved over to the Credit Card Info tab
						String creditTabVisibility = CRServiceLib.verifyCreditCardInfoTab();
						assertTrue(creditTabVisibility != null, "<b>User is moved over to the Credit Card Info tab:</b>"+creditTabVisibility);
						//enter card details
						CRServiceLib.enterCreditCardNumberOnCrediCardInfoPage(data.get("CCNumber"));
						CRServiceLib.enterCVCOnCrediCardInfoPage(data.get("CVC"));
						CRServiceLib.selectMonthOnCreditCardInfoPage(data.get("CCMonth"));
						CRServiceLib.selectYearOnCreditCardInfoPage(data.get("CCYear"));
						CRServiceLib.clickOnContinueButtonInCreditcardInfoPage();
						Thread.sleep(4000);
						//Verify that the Transaction Information tab is displayed
						String transactionTabVisibility = CRServiceLib.verifyTransactionInfoTab();
						assertTrue(transactionTabVisibility != null, "<b>Transaction Information tab is displayed:</b>"+transactionTabVisibility);
						//capture card info
						String creditCardNumber =CRServiceLib.getCreditCard();
						Thread.sleep(7000);
						comeOutFromFrame();
						//Verify that Transaction History section displays this card information
						String transactionHistory = CRServiceLib.getTransactionHistoryInfo();
						String cardDetailsInTransactionHistory = CRServiceLib.getCreditCardInTransactionHistory();
						assertTrue(cardDetailsInTransactionHistory.equalsIgnoreCase(creditCardNumber), "<b>Expected::" + creditCardNumber + "::Value and Actual value::" + cardDetailsInTransactionHistory + "::are matched::"+"<b> Transaction History section displays this card information:</b>");
						CRServiceLib.clickOnCloseButtonInCreditcard();
						switchToWindow();
						Thread.sleep(12000);
						crHomeLib.saveButton();
						//Verify that the call is saved without any errors
						String callIDSaved=CRServiceLib.getCallId();
						assertTrue(!callIDSaved.equalsIgnoreCase(null), "<b>Call is saved successfully</b>");
						CRServiceLib.closeCallWindow();
						crHomeLib.logout();
				}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
    			ReportStatus.fnUpdateResultStatus("CR","1606",ReportStatus.strMethodName,intCounter,browser);
				//To close the browser after each iteration
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
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void verifyCreditCardWithVoidedCardTransaction(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
		{
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyCreditCard", TestData, "D3CallRecieving");
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyCreditCard", TestData, "D3CallRecieving",intCounter);

					this.reporter.initTestCaseDescription("1606:TC-Credit Card"+ " From Iteration " + StartRow + " to " + EndRow );
					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
					//navigate and login to CR
					navigateToApplication("CR");
					login(data.get("LoginName"), data.get("Password"));
					Thread.sleep(5000);
					crMemberSearchLib.clickOnPartialCallCloseButton();
					crHomeLib.messageDialogBoxClose();
					Thread.sleep(5000);
					//Enter membership number using db
					String Member = "";
					if (data.get("Member").equals("db")){
						//fetch member details from db
						//generating a random number everytime to fetch a new record everytime
						int rownum = IntRandomNumberGenerator(50,1000);
						//member from db
						Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
						System.out.println("member : "+Member);
					}
					else
					{
						Member = data.get("Membersearch");
					}
					crHomeLib.memberSearchTextBox(Member);
					crMemberSearchLib.memberNumClick();
					crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
					//enter breakdown location
					crLocationsLib.clickOnLocationTab();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
					crVehicleTriageLib.clickOnVehicleTriageTab();
					crVehicleTriageLib.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
					//enter problem type
					crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType1"));
					Thread.sleep(2000);
					crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					crVehicleTriageLib.validateSelectedPaceSetterCode();
					crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
					CRServiceLib.clickOnServiceTab();
					autoSpotId = CRServiceLib.validateFacilityAutospotID();
					//click on credit card
					CRServiceLib.clickOnCreditCard();
					//verify the credit card icon in call ribbon
					String creditCardIconInCallRibbon = CRServiceLib.verifyCreditCardInCallRibbon();
					assertTrue(creditCardIconInCallRibbon != null, "<b>Credit Card icon is displayed in the call ribbon</b>"+creditCardIconInCallRibbon);
					//click on call ribbon
					CRServiceLib.clickOnCreditCardInCallRibbion();
					//switch to credit card frame
					switchToWindow();
					Thread.sleep(2000);
					//verify Credit Card Payment option is added to the current call menu.
					String creditCardPaymentOptionAdded = CRServiceLib.verifyCreditCardPaymentOption();
					assertTrue(creditCardPaymentOptionAdded != null, "<b>Credit Card Payment option is added to the current call menu</b>"+creditCardPaymentOptionAdded);
					//Verify  Credit Card payment dialog-- Billing Info tab selected-- is displayed.
					switchToFrame(CRServicePage.creditCardFrame);
					Thread.sleep(2000);
					String billingTabVisibility = CRServiceLib.verifyBillingTab();
					assertTrue(billingTabVisibility != null, "<b>Credit Card payment dialog-- Billing Info tab selected-- is displayed:</b>"+billingTabVisibility);
					//clcik on membership data to use the details
					CRServiceLib.clickOnUseMemberDataOnCreditcardTab();
					Thread.sleep(3000);
					//enter amount
					CRServiceLib.enterAmountOnBillingInfoPage(data.get("Amount"));
					//click on continue
					CRServiceLib.clickOnContinueButtonInCreditcardTab();
					//Verify that the user is moved over to the Credit Card Info tab
					String creditTabVisibility = CRServiceLib.verifyCreditCardInfoTab();
					assertTrue(creditTabVisibility != null, "<b>User is moved over to the Credit Card Info tab:</b>"+creditTabVisibility);
					//enter card details
					CRServiceLib.enterCreditCardNumberOnCrediCardInfoPage(data.get("CCNumber"));
					CRServiceLib.enterCVCOnCrediCardInfoPage(data.get("CVC"));
					CRServiceLib.selectMonthOnCreditCardInfoPage(data.get("CCMonth"));
					CRServiceLib.selectYearOnCreditCardInfoPage(data.get("CCYear"));
					CRServiceLib.clickOnContinueButtonInCreditcardInfoPage();
					Thread.sleep(4000);
					//Verify that the Transaction Information tab is displayed
					String transactionTabVisibility = CRServiceLib.verifyTransactionInfoTab();
					assertTrue(transactionTabVisibility != null, "<b>Transaction Information tab is displayed:</b>"+transactionTabVisibility);
					//capture card info
					String creditCardNumber =CRServiceLib.getCreditCard();

					CRServiceLib.clickOnVoidAuthorization();
					Thread.sleep(60000);
					CRServiceLib.processingInvisibility();
					boolean status =CRServiceLib.getAuthorizedPaymentStatus();
					assertTrue(!status, "<b>Status changes from Authorized to Voided</b>");
					Thread.sleep(7000);
					comeOutFromFrame();

					//Verify that Transaction History section displays this card information
					String transactionHistory = CRServiceLib.getTransactionHistoryInfo();
					String cardDetailsInTransactionHistory = CRServiceLib.getCreditCardInTransactionHistory();
					assertTrue(cardDetailsInTransactionHistory.equalsIgnoreCase(creditCardNumber), "<b>Expected::" + creditCardNumber + "::Value and Actual value::" + cardDetailsInTransactionHistory + "::are matched::"+"<b> Transaction History section displays this card information:</b>");

					CRServiceLib.clickOnCloseButtonInCreditcard();
					switchToWindow();
					crHomeLib.saveButton();
					//Verify that the call is saved without any errors
					String callIDSaved=CRServiceLib.getCallId();
					assertTrue(!callIDSaved.equalsIgnoreCase(null), "<b>Call is saved successfully</b>");
					CRServiceLib.closeCallWindow();
					crHomeLib.logout();


				}
				catch(Exception e)
				{
					ReportStatus.blnStatus=false;
				}
				ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
				ReportStatus.fnUpdateResultStatus("CR","1606",ReportStatus.strMethodName,intCounter,browser);
				//To close the browser after each iteration
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

