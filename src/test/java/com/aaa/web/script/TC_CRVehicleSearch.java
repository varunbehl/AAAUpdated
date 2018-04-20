package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRVehicleTriagePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRVehicleSearch extends ActionEngine {
    public static String vehicleValue;
    public static String vehicleValueExcel;
    public static String trimValue;
    public static String trimValueexcel;
    public static String tagValue;
    public static String colorValueexcel;
    public static String colorValue;
    public static String tagValueexcel;
    public static String stateValue;
    public static String stateValueexcel;
    public static String flatValue;
    public static String flatValueexcel;
    public static String noteValue;
    public static String noteValueexcel;
    public static String typeValue;
    public static String yearValue;
    public static String yearValueexcel;
    public static String makeValue;
    public static String makeValueexcel;
    public static String modelValue;
    public static String modelValueexcel;
    public static String subTypeValue;
    public static String subTypeValueexcel;
    public static String engineValue;
    public static String engineValueexcel;
    public static String commentValue;
    public static String commentValueExcel;
    public static String callID;
    public static String vehicleYearValue;
    public static String vehicleModeValue;
    public static String vehicle;


  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CRVehicleSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRVehicleSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					   //Open the browser in each iteration
					    fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CRVehicleSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1610:TC-Vehicle Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                Thread.sleep(5000);

					    //Object Creations
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                DILoginLib diLoginLib = new DILoginLib();

					    //Login to D3 call receving
					    navigateToApplication("CR");
		                login.login(data.get("LoginName"),data.get("Password"));
		                crHomeLib.messageDialogBoxClose();

					    //Getting member from DB based on the input
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

					    //Searching Member number
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

					    //Entering the breakdown location
		                crLocationsLib.clickOnLocationTab();

					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
		                //crLocationsLib.clickOnSecondKownBrkDowLocation();

					    //Vehicle details and traige
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.enterVehicleSearch(data.get("VehicleDetails"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnTheVehicleSearchIcon();

		                //getting text value from vehicleSearch
					    vehicleValue=crVehicleTriageLib.getVehcileSearchDetails();

					    //getting text value from year and model after click on search icon
		                vehicleYearValue = crVehicleTriageLib.getYearValueFromGridAfterClickOnSearchIcon();
		                vehicleModeValue = crVehicleTriageLib.getMakeAndModelValueFromGridAfterClickOnSearchIcon();

		                //adding the values of year and model
		                vehicle = vehicleYearValue+" "+vehicleModeValue;

		                //Compare the vehicle details value
		                boolean vehicleSearchValue = vehicleValue.equalsIgnoreCase(vehicle);
		                assertTrue(vehicleSearchValue,"Expected::" +vehicleValue+  "::Value and Actual value::" +vehicle+ "::are matched");

		                //Spliting the value to compare the grid value
						String VehicleMakeandModelValue[]=vehicleModeValue.split(" ");
		                crVehicleTriageLib.clickOnTheVehicleSearch();

		                //Capturing the grid value of make and model to compare
						String makePopulatedValue=crVehicleTriageLib.getMakeValue();
						assertTrue(makePopulatedValue.equalsIgnoreCase(VehicleMakeandModelValue[0]),"Make Value information populated" + "::are matched");
						String modelPopulatedValue=crVehicleTriageLib.getModelValue();
						assertTrue(modelPopulatedValue.equalsIgnoreCase(VehicleMakeandModelValue[1]),"Model Value information populated" +"::are matched");

						//Enter the Trim value as given,and compare it matches
		                crVehicleTriageLib.enterTrim(data.get("Trim"));
		                trimValue=crVehicleTriageLib.getTrimValue();
		                trimValueexcel=data.get("Trim");
		                boolean trimSearchvalue = trimValue.equalsIgnoreCase(trimValueexcel);
		                assertTrue(trimSearchvalue,"Expected::" +trimValue+  "::Value and Actual value::" +trimValueexcel+ "::are matched");

					    //Enter the Color value as given,and compare it matches
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                //For Color not required
		                colorValue=crVehicleTriageLib.getColorValue();
		                colorValueexcel=data.get("Color");
		                boolean colorSearchValue = colorValue.equalsIgnoreCase(colorValueexcel);
		                assertTrue(colorSearchValue,"Expected::" +colorValue+  "::Value and Actual value::" +colorValueexcel+ "::are matched");

					    //Enter the Tag value as given,and compare it matches
		                crVehicleTriageLib.enterTag(data.get("Tag"));
		                tagValue=crVehicleTriageLib.getTagValue();
		                tagValueexcel=data.get("Tag");
		                boolean tagSearchValue = tagValue.equalsIgnoreCase(tagValueexcel);
		                assertTrue(tagSearchValue,"Expected::" +tagValue+  "::Value and Actual value::" +tagValueexcel+ "::are matched");

					    //Enter the State value as given,and compare it matches
		                crVehicleTriageLib.enterState(data.get("State"));
		                stateValue=crVehicleTriageLib.getStateValue();
		                stateValueexcel=data.get("State");
		                boolean stateSearchValue = stateValue.equalsIgnoreCase(stateValueexcel);
		                assertTrue(stateSearchValue,"Expected::" +stateValue+  "::Value and Actual value::" +stateValueexcel+ "::are matched");

					    //Enter the Flat value as given,and compare it matches
		                crVehicleTriageLib.enterFlat(data.get("Flat"));
		                flatValue=crVehicleTriageLib.getFlatValue();
		                flatValueexcel=data.get("Flat");
		                boolean flatSearchvalue = flatValue.equalsIgnoreCase(flatValueexcel);
		                assertTrue(flatSearchvalue,"Expected::" +flatValue+  "::Value and Actual value::" +flatValueexcel+ "::are matched");

					    //Enter the Note value as given,and compare it matches
		                crVehicleTriageLib.enterNote(data.get("Note"));
		                noteValue=crVehicleTriageLib.getNoteValue();
		                noteValueexcel=data.get("Note");
		                boolean noteSearchvalue = noteValue.equalsIgnoreCase(noteValueexcel);
		                assertTrue(noteSearchvalue,"Expected::" +noteValue+  "::Value and Actual value::" +noteValueexcel+ "::are matched");

		                //Click on clear all the fields
		                crVehicleTriageLib.clickOnClearAllFileds();

					    //Verify all the fields clear except for the Type field
		                trimValue=crVehicleTriageLib.getTrimValue();
		                boolean trimValueEmpty = trimValue.isEmpty();
		                assertTrue(trimValueEmpty,"Trim value Cleared Successfully");

						colorValue=crVehicleTriageLib.getColorValue();
						boolean colorValueEmpty = colorValue.isEmpty();
						assertTrue(colorValueEmpty,"Color value Cleared Successfully");

		                tagValue=crVehicleTriageLib.getTagValue();
		                boolean tagValueEmpty = tagValue.isEmpty();
		                assertTrue(tagValueEmpty,"Tag value Cleared Successfully");

		                stateValue=crVehicleTriageLib.getStateValue();
		                boolean stateValeEmpty = stateValue.isEmpty();
		                assertTrue(stateValeEmpty,"State value Cleared Successfully");

		                flatValue=crVehicleTriageLib.getFlatValue();
		                boolean flatValueEmpty = flatValue.isEmpty();
		                assertTrue(flatValueEmpty,"Flat value Cleared Successfully");

		                noteValue=crVehicleTriageLib.getNoteValue();
		                boolean noteValueEmpty = noteValue.isEmpty();
		                assertTrue(noteValueEmpty,"Note value Cleared Successfully");

		                typeValue=crVehicleTriageLib.getTypeValue();
		                boolean typeValueEmpty = !typeValue.isEmpty();
		                assertTrue(typeValueEmpty, "Type value Should not Cleared");

		                //enter type value and Verify the More Info tab appears
		                crVehicleTriageLib.enterVehicleType(data.get("Type"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                crVehicleTriageLib.getMoreInfoTab();

		                //enter the year,make,model details and Verify the year make model appears
		                crVehicleTriageLib.enterVehicleYear(data.get("Year"));
		                crVehicleTriageLib.enterVehicleMake(data.get("Make"));
		                crVehicleTriageLib.enterVehicleModel(data.get("Model"));
		                crVehicleTriageLib.clickOnTheModelSearchFromDropDown();
		                yearValue=crVehicleTriageLib.getYearValue();
		                yearValueexcel=data.get("Year");
		                boolean yearSearchValue = yearValue.equalsIgnoreCase(yearValueexcel);
		                assertTrue(yearSearchValue,"Expected:: "+yearValueexcel+ " ::Value and Actual value:: "+yearValue+" ::are matched");
		                makeValue=crVehicleTriageLib.getMakeValue();
		                makeValueexcel=data.get("Make");
		                boolean makeSearchValue = makeValue.equalsIgnoreCase(makeValueexcel);
		                assertTrue(makeSearchValue,"Expected::" +makeValue+  "::Value and Actual value::" +makeValueexcel+ "::are matched");
		                modelValue=crVehicleTriageLib.getModelValue();
		                modelValueexcel=data.get("Model");
		                boolean modelSearchValue = modelValue.equalsIgnoreCase(modelValueexcel);
		                assertTrue(modelSearchValue,"Expected::" +modelValue+  "::Value and Actual value::" +modelValueexcel+ "::are matched");
		                crVehicleTriageLib.clickOnMoreInfoTab();

		                //enter the subtype,engine and comment deatils,Verify your information appears
		                crVehicleTriageLib.enterSubTypeOnMoreInfoTab(data.get("SubType"));
		                crVehicleTriageLib.enterEngineTypeOnMoreInfoTab(data.get("Engine"));
		                crVehicleTriageLib.enterCommentOnMoreInfoTab(data.get("Comment"));
		                subTypeValue=crVehicleTriageLib.getMoreInfoTabSubType();
		                subTypeValueexcel=data.get("SubType");
		                boolean subTypeSearchValue = subTypeValue.equalsIgnoreCase(subTypeValueexcel);
		                assertTrue(subTypeSearchValue,"Expected::" +subTypeValue+  "::Value and Actual value::" +subTypeValueexcel+ "::are matched");
		                engineValue=crVehicleTriageLib.getMoreInfoTabEngine();
		                engineValueexcel=data.get("Engine");
		                boolean engineSearchValue= engineValue.equalsIgnoreCase(engineValue);
		                assertTrue(engineSearchValue,"Expected::" +engineValue+  "::Value and Actual value::" +engineValueexcel+ "::are matched");
		                commentValue=crVehicleTriageLib.getMoreInfoTabComment();
		                commentValueExcel=data.get("Comment");
		                boolean commentSearchValue = commentValue.equalsIgnoreCase(commentValueExcel);
		                assertTrue(commentSearchValue,"Expected::" +commentValue+  "::Value and Actual value::" +commentValueExcel+ "::are matched");

		                //click on leave button
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();

		                //Start a new call and enter a membernumber
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();

					    //Entering the breakdown location
						crLocationsLib.clickOnLocationTab();
					crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						//crLocationsLib.clickOnSecondKownBrkDowLocation();;

		                //Verify the Vehicle/Triage section appears
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.verifyVehicleTraigeTabExists();
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                clearData(CRVehicleTriagePage.txtVehicleType);
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.getMoreInfoTab();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                crVehicleTriageLib.clickOnMoreInfoTab();

		                //enter the length,height,weight,class details and Verify the information can be saved
		                crVehicleTriageLib.enterLegnthOnMoreInfoTab(data.get("Length"));
		                crVehicleTriageLib.enterHeightOnMoreInfoTab(data.get("Height"));
		                crVehicleTriageLib.enterWeightOnMoreInfoTab(data.get("Weight"));
		                crVehicleTriageLib.enterClassOnMoreInfoTab(data.get("Class"));
		                crVehicleTriageLib.clickOnTheClassSearchFromDropDown();
		                //Select PaceSetterCode
		                crVehicleTriageLib.selectPaceSetterCodeforKeyIssue();
		                //crHomeLib.saveButton();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		               /*crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();*/
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                services.getCallId();
		                callID = services.getCallId();
		                boolean callIDValueNotNull = callID!=null;
		                assertTrue(callIDValueNotNull,"Vehcicle Information saved Successfully.");
		                services.closeCall();

		                //Load the membership with prioi information
		                crMemberSearchLib.clickOnMemberTab();
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.clickOnVehicleTriageTab();

					    //Example: 2012 COUNTRY COACH M AFFINITY (BLACK)
		                crVehicleTriageLib.verifyVehiclePriorKnownVehicleExists();
		                String vehicleDetails=crVehicleTriageLib.getVehicleText();
		                String vehicleInformation[] = (vehicleDetails.split(" "));
		                int arrLen = vehicleInformation.length;
		                String year=(vehicleInformation[0]);

		                //sometimes the make is having multiple words like COUNTRY COACH M
		                String make="";
						for(int makel=1; makel<arrLen-2; makel++)
		                	make=make+" "+vehicleInformation[makel];

		                //Make is last but 1 when we split by SPACE
		                String model=(vehicleInformation[arrLen-2]);

		                reporter.SuccessReport("<b>Reading values from App", "Year:"+year+"; Make:"+make+"; Model:"+model+"</b>");
		                crVehicleTriageLib.selectExistingVehicle();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();

		                //Verify all the information is auto-populated with the known vehicle information
		                yearValue=crVehicleTriageLib.getYearValue();
		                assertTrue(yearValue.equalsIgnoreCase(year),"Year Value information populated" +year);
		                makeValue=(crVehicleTriageLib.getMakeValue());
		                assertTrue(makeValue.equalsIgnoreCase(make.trim()),"Make Value information populated" +make);
		                modelValue=crVehicleTriageLib.getModelValue();
		                assertTrue(modelValue.equalsIgnoreCase(model),"Model Value information populated" +model);
		                crVehicleTriageLib.scriptErrorHandle();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.logout();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.scriptErrorHandle();
		                System.out.println("Test Completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();

				//updating google sheet. Will be used in Zephyr integration. Currently the code will not do anything as the function is commented.
    			ReportStatus.fnUpdateResultStatus("CR","1610",ReportStatus.strMethodName,intCounter,browser);

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
