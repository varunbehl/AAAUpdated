package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CRLocationsLib;
import com.aaa.web.lib.CRMemberSearchLib;
import com.aaa.web.lib.CommonDb;
import com.aaa.web.lib.CommonLib;
import com.aaa.web.lib.LoginLib;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRLocations extends CRLocationsLib {
    public static String streetAddress;
    public static String narthCrossStreet;
    public static String southCrossStreet;
    public static String city;
    public static String state;
    public static String zipCode;
    public static String latitude;
    public static String longitude;
    public static String landMark;


    LoginLib login = new LoginLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CommonLib commonLib=new CommonLib();
    CRMemberSearchLib member = new CRMemberSearchLib();
    CRHomeLib home = new CRHomeLib();
    CRLocationsLib location = new CRLocationsLib();
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyLocationsTab(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyLocationsTab", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyLocationsTab", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1601 :CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigatetoLocationsTab(data);
		                verifyLocations(data);		                
		                home.leavecall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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

  
    public void verifyLocations(Hashtable<String, String> data) throws Throwable {
    	switch (data.get("Validation").toLowerCase()){
    	case "addresslookup":
    		location.verifyAddressLookup(data.get("AddressLookup"));
    		break;
    	case "crossstreet":
    		location.verifyCrossStreetAddress(data.get("AddressLookup"), data.get("FirstCrossStreet"), data.get("SecondCrossStreet"));
    		break;
    	case "highway":
    		location.verifyHighwayAddress(data.get("AddressLookup"), data.get("FirstCrossStreet"));
    		break;
    	case "latlong":
    		location.verifyLatLongAddress(data.get("latitude"), data.get("longitude"), data.get("FirstCrossStreet"), data.get("SecondCrossStreet"), data.get("AddressLookup"));           
    		break;
    	case "specialcharacters":
    		location.verifySpecialCharactersAddress(data.get("AddressLookup"), data.get("FirstCrossStreet"), data.get("SecondCrossStreet"), data.get("VerifyAddress"));
    		break;
    	case "pointsofinterest":
    		location.verifyPointsOfInterest(data.get("AddressLookup"),data.get("VerifyAddress"));
    		break;
    	case "landmark":
    		location.verifyLandmarkAddress(data.get("AddressLookup"), data.get("VerifyAddress"), data.get("AdditionalAddress"));
    		//location.getPickOupPointsFromdropDown();
    		break;
    	case "manualentryaddress":
    		location.enterBreakDownLocationManually(data.get("AddressLookup"));
    		break;
    	case "manualentrycrossstreet" :
    		location.verifyManualEntryCrossStreet(data.get("FirstCrossStreet"), data.get("SecondCrossStreet"), data.get("AddressLookup"));
    		break;
    	case "manualentrylandmark":
    		location.verifyManualEntryLandMark(data.get("AdditionalAddress"), data.get("AddressLookup"));
    		break;
    	case "cityalias":
    		location.verifyCityAlias(data.get("AddressLookup"), data.get("VerifyAddress"));
    	    break;
    	case "knownlocations":
    		//commonLib.crMemberSearchTab(data.get("Member"),data.get("MemberNumber"),data.get("dbServer"),data.get("dbqueryFileName"), data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"));
    		member.clickOnMemberTab();
    		member.memberSearchTextBox(data.get("MemberNumber"));
    		member.memberNumClick();
    		location.clickOnLocationTab();
    		location.verifyKnownLocations(data.get("AdditionalAddress"), data.get("AddressLookup"), data.get("FirstCrossStreet"));
    		break;
    	default:
    		break;
    	}
    }    
    public void navigatetoLocationsTab(Hashtable<String, String> data) throws Throwable {
        //navigateToApplication("CR");
        Thread.sleep(2000);
        commonLib.callReceivingLogin(data.get("CRLoginName"), data.get("CRPassword"),data.get("LoginRoleCallReceiving"),"");
        //commonLib.crMemberSearchTab(data.get("Member"),data.get("MemberNumber"),data.get("dbServer"),data.get("dbqueryFileName"), data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"));
        location.clickOnLocationTab();
    }
}