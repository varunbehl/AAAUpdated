package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRSaveERSCallFullService extends ActionEngine {
    LoginLib login = new LoginLib();
    CRMemberSearchLib member = new CRMemberSearchLib();
    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
    CRLocationsLib location = new CRLocationsLib();
    CRTowDestinationLib towdestination = new CRTowDestinationLib();
    CRHomeLib home = new CRHomeLib();
    CRServiceLib service = new CRServiceLib();

    //Common Method For creating the call.All test Scripts are calling this method
    public void saveERSCallFullService(Hashtable<String, String> data)throws  Throwable{
        navigateToApplication("CR");
        login.login(data.get("LoginName"),data.get("Password"));
        member.clickOnPartialCallCloseButton();
        home.messageDialogBoxClose();
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
        home.memberSearchTextBox(Member);
        //home.memberSearchTextBox(data.get("Membersearch"));
        member.memberNumClick();
        Thread.sleep(2000);
        member.currentCallClose();
        home.waitCloseAllBusyIconsResults();
        member.clickPrimRadioBtnSecondRow();
        //Location Field
        location.clickOnLocationTab();
        Thread.sleep(2000);
		String combineKeys1 = Keys.chord(Keys.HOME);
		sendKeys(combineKeys1, "HOME");
		location.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));

        //Verification of Location Fields - BreakDownLocation Street and Location Code
        String streetAddressValue=location.getBKDownStreetAddress();
        boolean streetAddress = streetAddressValue != null;
        assertTrue(streetAddress,"<b>Verified the Street Address That is entered in Breakdown Location & entered StreetAddress is    -</b>"+streetAddressValue);
		Thread.sleep(2000);
        String locationCodeValue=location.getLocationCode();
        boolean locationCode=locationCodeValue != null;
        Thread.sleep(1000);
        assertTrue(locationCode,"<b>Verified the Location Code that is entered in Breakdown Location & entered LocationCode is    -<b>"+locationCodeValue);


        //Enter Vehicle Details and Problem code
        vehicle.clickOnVehicleTriageTab();
        vehicle.Entervehicleinfomanually(data.get("Vehicle"));
        vehicle.clickOnTheVehicleSearchIcon();
        home.waitCloseAllBusyIconsResults();
        vehicle.clickOnTheVehicleSearch();
        Thread.sleep(1000);
        vehicle.enterVehicleColor(data.get("Color"));
        //Enter Proble type
        vehicle.clickonProblemTypeButton(data.get("ProblemType"));
        Thread.sleep(3000);
		home.messageDialogBoxClose();
        Thread.sleep(2000);
        vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
        towdestination.alertForTowMilesOffer();
        vehicle.scriptErrorHandle();
        home.waitCloseAllBusyIconsResults();
        towdestination.clickOnTowDestinationTab();
        Thread.sleep(2000);
        vehicle.handleScriptErrorInVehicleTriagePage();
        Thread.sleep(2000);

    }

	//Basic member less Than 5 miles
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallForBasicMemberLessThan5Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForBasicLessThan5Miles", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForBasicLessThan5Miles", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                //To Print All TowResults Link Names
		                boolean resultsAvailableFlag = towdestination.printAllTowDestinationResults();
					    String expectedBasicMemberMiles = data.get("BasicMemberMiles");
					    double expectedTowMiles = Double.parseDouble(expectedBasicMemberMiles);
		                double actualTowMilesFromresults=towdestination.verifyTowMilesForBasicLevellessThan5Miles(expectedBasicMemberMiles);
					    assertTrue(actualTowMilesFromresults <= expectedTowMiles, "<b>Tow destination is  " + expectedBasicMemberMiles + " miles less than  from the breakdown location & destination miles are:  </b>" + actualTowMilesFromresults);

					    //Verifing the EstimatedTow Miles,EntitledMiles and EstimatedOver Miles From ToolTip.
		                if(resultsAvailableFlag) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    String towMilesFromToolTip = towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							towdestination.verifyEstimatedOverMilesFromToolTip();
		                    double estimatedTowMiles = Double.parseDouble(towMilesFromToolTip);
		                    //To verify Tow Miles from Tool Tip and from results Link
		                    assertTrue(actualTowMilesFromresults == estimatedTowMiles,"<b>Verified the estimatedTowMiles on ToolTip and Tow results, :Miles are   </b>"+actualTowMilesFromresults);

		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(!resultsAvailableFlag, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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



//2Basic member Greater Than 5 miles
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallForBasicMemberGreaterThan5Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
           //4299811247566105
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForBasicGreateThan5Miles", TestData, "D3CallRecieving");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        				fnOpenTest();
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForBasicGreateThan5Miles", TestData, "D3CallRecieving",intCounter);
        	
			                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                //Calling Common Function to enter mandatory fields InOrder to save the call
			                saveERSCallFullService(data);
			
			                //towdestination.alertForTowMilesOffer();
			                home.waitCloseAllBusyIconsResults();
			                towdestination.clickOnShowCriteriaCollapseButton();
			                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
			                towdestination.clickOnSearchButtonOnTow();
			                vehicle.handleScriptErrorInVehicleTriagePage();
			                home.waitCloseAllBusyIconsResults();
						   boolean resultsAvailableFlag = towdestination.printAllTowDestinationResults();
						   String expectedbasicMemberMiles = data.get("BasicMemberMiles");
						   int noOfAllowedMilesForBasicMemberInteger = Integer.parseInt(expectedbasicMemberMiles);
			                double milesFromResultsLink = towdestination.verifyTowMilesBasedOnLevel(expectedbasicMemberMiles);
						   assertTrue(milesFromResultsLink >= noOfAllowedMilesForBasicMemberInteger, "<b>Tow destination is  Greater Than  " + noOfAllowedMilesForBasicMemberInteger + " miles from the breakdown location & destination miles are : </b>" + milesFromResultsLink);
						   //If the Tow is having Tow Miles Results
			                if(resultsAvailableFlag) {
								String combineKeys1 = Keys.chord(Keys.HOME);
								sendKeys(combineKeys1, "HOME");
			                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
								String towMilesFromToolTip = towdestination.verifyEstimatedTowMilesFromToolTip();
								towdestination.verifyEntitledMilesFromToolTip();
								towdestination.verifyEstimatedOverMilesFromToolTip();
								double estimatedTowMiles = Double.parseDouble(towMilesFromToolTip);
								//To verify Tow Miles from Tool Tip and from results Link
								assertTrue(milesFromResultsLink == estimatedTowMiles,"<b>Verified the estimatedTowMiles on ToolTip and Tow results, :Miles are   </b>"+milesFromResultsLink);
			                    towdestination.enterTowPassengers(data.get("TowPassengers"));
			                }
			                //If Tow is Having No Results in Specified Range
			                else{
			                    towdestination.clickOnManualEntryLinkOnTowDestination();
			                    towdestination.enterTowPassengers(data.get("TowPassengers"));
			                    assertTrue(!resultsAvailableFlag, "<b>No Tow destinations are available in Specified Range</b>");
			                }
			                home.saveButton();
			                home.allErrorAlerts();
			                Thread.sleep(2000);
			                home.waitCloseAllBusyIconsResults();
			                service.getCallId();
			                service.closeCallWindow();
			                home.logout();

        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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

//3 plus Member approximately 50 miles
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPlusMemberApproximately50Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
              //4299811247566105
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPlusMemberHaving50Miles", TestData, "D3CallRecieving");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        				fnOpenTest();
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPlusMemberHaving50Miles", TestData, "D3CallRecieving",intCounter);
        	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                towdestination.printAllTowDestinationResults();
						String milesStartRange = data.get("PlusMemberMilesStartRange");
						String milesEndRange = data.get("PlusMemberMilesEndRange");
						double aboveSpecifiedMilesDouble = Double.parseDouble(milesStartRange);
						double belowSpecifiedMilesDouble = Double.parseDouble(milesEndRange);
		                double noOfMileFromResult=towdestination.verifyTowMilesForPlusMemberApproximately50Miles(milesStartRange,milesEndRange);
						boolean flagMiles =(aboveSpecifiedMilesDouble <= noOfMileFromResult && belowSpecifiedMilesDouble >= noOfMileFromResult);
						assertTrue(flagMiles, "<b>Tow destination that is approximately 50 miles from the breakdown location & destination miles : </b>" + noOfMileFromResult);
		                //If Tow Is having results
		                if(flagMiles) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                   	String  towdestinationMiles= towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							towdestination.verifyEstimatedOverMilesFromToolTip();
		                  	 double estimatedTowMiles = Double.parseDouble(towdestinationMiles);
							assertTrue(noOfMileFromResult == estimatedTowMiles,"<b>Verified the estimatedTowMiles on ToolTip and Tow results, :Miles are   </b>"+noOfMileFromResult);

		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                	//If tow is not having no results
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();

        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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
 //4Plus Member miles Between 80 To 100
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPlusMemberBetween80To100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
             //4299811247566105
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPlusBetwween80To100Miles", TestData, "D3CallRecieving");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        				fnOpenTest();
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPlusBetwween80To100Miles", TestData, "D3CallRecieving",intCounter);
        	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                //To print all results Link names on Tow
						towdestination.printAllTowDestinationResults();
						String milesStartRange = data.get("PlusMemberMilesStartRange");
						String milesEndRange = data.get("PlusMemberMilesEndRange");
						double aboveSpecifiedMilesInt = Double.parseDouble(milesStartRange);
						double belowSpecifiedMilesInt = Double.parseDouble(milesEndRange);
		                double noOfMileFromResult=towdestination.verifyTowMilesForMembersInBetweenTheMileRange(milesStartRange,milesEndRange);
						boolean flagMiles = (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult);
						assertTrue(flagMiles, "<b>Tow destination is approximately between </b>" + aboveSpecifiedMilesInt + "<b> And </b>" + belowSpecifiedMilesInt + "<b> & destination miles  are: </b>" + noOfMileFromResult);
		                //If tow is having results
		                if(flagMiles) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
							Thread.sleep(3000);
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
							String  towdestinationMiles= towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							towdestination.verifyEstimatedOverMilesFromToolTip();
							double estimatedTowMiles = Double.parseDouble(towdestinationMiles);
							assertTrue(noOfMileFromResult == estimatedTowMiles,"<b>Verified the estimatedTowMiles on ToolTip and Tow results, :Miles are   </b>"+noOfMileFromResult);

		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		            //verifyTowMilesForPlusMemberBetween80To100
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();
        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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

    //5Premier Member, greaterThan 100 Miles and Allow Long Tow Parameter set to "Y"
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierMemberGreaterThan100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierMemberGreaterThan100", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierMemberGreaterThan100", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
					boolean resultsAvailableFlag = towdestination.printAllTowDestinationResults();
					String premireMemberMiles = data.get("PremireMemberMiles");
					int noOfAllowedMilesForpremireMemberMiles= Integer.parseInt(premireMemberMiles);
					double milesFromResultsLink = towdestination.verifyTowMilesBasedOnLevel(premireMemberMiles);
					assertTrue(milesFromResultsLink >= noOfAllowedMilesForpremireMemberMiles, "<b>Tow destination is  Greater Than  " + noOfAllowedMilesForpremireMemberMiles + " miles from the breakdown location & destination miles are : </b>" + milesFromResultsLink);
		                if(resultsAvailableFlag) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
							String towMilesFromToolTip = towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							towdestination.verifyEstimatedOverMilesFromToolTip();
							double towMilesFromTowResults = Double.parseDouble(towMilesFromToolTip);
							//To verify Tow Miles from Tool Tip and from results Link
							assertTrue(milesFromResultsLink == towMilesFromTowResults,"<b>Verified the miles on ToolTip and Tow results, :Miles are   </b>"+milesFromResultsLink);

		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(!resultsAvailableFlag, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.waitCloseAllBusyIconsResults();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.verifyLongTowAllowed(data.get("AllowLongTow"));
		                home.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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

    //6Premier Tow Miles Between 180 To 200
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierMemBetween180To200Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierMemBetween180To200", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierMemBetween180To200", TestData, "D3CallRecieving",intCounter);
    		            this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                //To Print all Results Link Names on Tow
						towdestination.printAllTowDestinationResults();
					String milesStartRange = data.get("PremierMemberMilesStartRange");
					String milesEndRange = data.get("PremierMemberMilesEndRange");
					double aboveSpecifiedMilesInt = Double.parseDouble(milesStartRange);
					double belowSpecifiedMilesInt = Double.parseDouble(milesEndRange);
					double noOfMileFromResult=towdestination.verifyTowMilesForMembersInBetweenTheMileRange(milesStartRange,milesEndRange);
					boolean flagMiles = (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult);
					assertTrue(flagMiles, "<b>Tow destination is approximately between </b>" + aboveSpecifiedMilesInt + "<b> And </b>" + belowSpecifiedMilesInt + "<b> & destination miles  are: </b>" + noOfMileFromResult);
		                //If tow have  ResultsLinks
		                if(flagMiles) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
							String towMilesFromToolTip = towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							towdestination.verifyEstimatedOverMilesFromToolTip();
							double towMilesFromTowResults = Double.parseDouble(towMilesFromToolTip);
							//To verify Tow Miles from Tool Tip and from results Link
							assertTrue(noOfMileFromResult == towMilesFromTowResults,"<b>Verified the miles on ToolTip and Tow results, :Miles are   <b>"+noOfMileFromResult);

		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                	//If Tow have no results
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.waitCloseAllBusyIconsResults();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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

    // 7 Plus RV -- RV Capable  servicing a RV < 100



	@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPlusRvMemberLessThan100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallPlusRVMember", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallPlusRVMember", TestData, "D3CallRecieving",intCounter);
    					this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnRVType();
		                Thread.sleep(1000);
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                //To print all Results Link Names
						boolean resultsAvailableFlag = towdestination.printAllTowDestinationResults();
						String expectedPlusRvMemberMiles = data.get("PlusMemberMiles");
						double expectedTowMiles = Double.parseDouble(expectedPlusRvMemberMiles);
						double actualTowMilesFromresults=towdestination.verifyTowMilesForBasicLevellessThan5Miles(expectedPlusRvMemberMiles);
						assertTrue(actualTowMilesFromresults <= expectedTowMiles, "<b>Tow destination is  " + expectedPlusRvMemberMiles + " miles less than  from the breakdown location & destination miles are:  </b>" + actualTowMilesFromresults);
		                if(resultsAvailableFlag) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
							String towMilesFromToolTip = towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							String estimatedOverMiles = towdestination.verifyEstimatedOverMilesFromToolTip();
							double towMilesFromTowResults = Double.parseDouble(towMilesFromToolTip);
							//To verify Tow Miles from Tool Tip and from results Link
							assertTrue(actualTowMilesFromresults == towMilesFromTowResults,"<b>Verified the miles on ToolTip and Tow results, :Miles are   <b>"+actualTowMilesFromresults);

		                    boolean estimatedMiles = estimatedOverMiles != null;
		                    assertTrue(estimatedMiles, "<b>Tow destination is RV capable</b>");
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(!resultsAvailableFlag, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();
    					}
    	    			catch(Exception e)
    	    			{
    	    				ReportStatus.blnStatus=false;
    	    			}
    	    			ReportControl.fnEnableJoin();
    	    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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

    //8Premier Rv ,Greater Than 100,
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierRVMemberGreaterThan100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierRVMemberGreaterThan100", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierRVMemberGreaterThan100", TestData, "D3CallRecieving",intCounter);
    	                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnRVType();
		                Thread.sleep(1000);
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                //To print all results Link Names
					boolean resultsAvailableFlag = towdestination.printAllTowDestinationResults();
					String premireMemberMiles = data.get("PremireMemberMiles");
					int noOfAllowedMilesForpremireMemberMiles= Integer.parseInt(premireMemberMiles);
					double milesFromResultsLink = towdestination.verifyTowMilesBasedOnLevel(premireMemberMiles);
					assertTrue(milesFromResultsLink >= noOfAllowedMilesForpremireMemberMiles, "<b>Tow destination is  Greater Than  " + noOfAllowedMilesForpremireMemberMiles + " miles from the breakdown location & destination miles are : </b>" + milesFromResultsLink);

		                if(resultsAvailableFlag) {
		                    towdestination.getTextFromAlertOnTowDestinationMiles();
		                    towdestination.clickOnRepairShopVerificationCloseButton();
		                    vehicle.handleScriptErrorInVehicleTriagePage();
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
							String towMilesFromToolTip = towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							String estimatedOverMiles = towdestination.verifyEstimatedOverMilesFromToolTip();
							double towMilesFromTowResults = Double.parseDouble(towMilesFromToolTip);
							//To verify Tow Miles from Tool Tip and from results Link
							assertTrue(milesFromResultsLink == towMilesFromTowResults,"<b>Verified the miles on ToolTip and Tow results, :Miles are   </b>"+milesFromResultsLink);
		                    boolean estimatedMiles = estimatedOverMiles != null;
		                    assertTrue(estimatedMiles, "<b>Tow destination is RV capable</b>");
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    towdestination.getTextFromAlertOnTowDestinationMiles();
		                    towdestination.clickOnRepairShopVerificationCloseButton();
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(!resultsAvailableFlag, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.waitCloseAllBusyIconsResults();
		                service.getCallId();
		                service.closeCallWindow();
		                home.waitCloseAllBusyIconsResults();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.verifyLongTowAllowed(data.get("AllowLongTow"));
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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
    //Premier Rv ,Miles Between 180 To 200,//Pending RV Capable
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierRVMemBetween180To200(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierRVMemBetween180To200", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierRVMemBetween180To200", TestData, "D3CallRecieving",intCounter);
    	                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnRVType();
		                Thread.sleep(1000);
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
						towdestination.printAllTowDestinationResults();
						String milesStartRange = data.get("PremierMemberMilesStartRange");
						String milesEndRange = data.get("PremierMemberMilesEndRange");
						double aboveSpecifiedMilesInt = Double.parseDouble(milesStartRange);
						double belowSpecifiedMilesInt = Double.parseDouble(milesEndRange);
		                double noOfMileFromResult=towdestination.verifyTowMilesForMembersInBetweenTheMileRange(milesStartRange,milesEndRange);
						boolean flagMiles = (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult);
						assertTrue(flagMiles, "<b>Tow destination is approximately between </b>" + aboveSpecifiedMilesInt + "<b> And </b>" + belowSpecifiedMilesInt + "<b> & destination miles  are: </b>" + noOfMileFromResult);
		                if(flagMiles) {
							String combineKeys1 = Keys.chord(Keys.HOME);
							sendKeys(combineKeys1, "HOME");
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
							String  towdestinationMiles= towdestination.verifyEstimatedTowMilesFromToolTip();
							towdestination.verifyEntitledMilesFromToolTip();
							String estimatedOverMiles = towdestination.verifyEstimatedOverMilesFromToolTip();
							double estimatedTowMiles = Double.parseDouble(towdestinationMiles);
							assertTrue(noOfMileFromResult == estimatedTowMiles,"<b>Verified the estimatedTowMiles on ToolTip and Tow results, :Miles are   </b>"+noOfMileFromResult);

		                    boolean estimatedMiles = estimatedOverMiles != null;
		                    assertTrue(estimatedMiles, "<b>Tow destination is RV capable</b>");
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "<b>No Tow destinations are available in Specified Range</b>");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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
