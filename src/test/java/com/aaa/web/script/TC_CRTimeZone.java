package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by E001133 on 27-11-2017.
 */
public class TC_CRTimeZone extends DILoginLib {
        String callID;
        String pstTimeZone;
        String newZone;
	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithValidUserNameAndInvalidPassword
     * description :: valdUsernamewithInvalidPassword
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void crTimeZone(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTimeZoneVerification", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    				fnOpenTest();
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTimeZoneVerification", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1937: CR Time Zone"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                DIMCDLib dimcdLib = new DIMCDLib();
		                login(data.get("CRLoginName"),data.get("Password"));
		                waitcloseAllBusyIcons();
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
		                member.memberNumClick();
		                locations.breakdownLocTabSel();
		                locations.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));

		                //Creating Call comments with GA State
		                locations.enterCallComments(data.get("CallComments"));
		                locations.clickOnCallCommentsAddButton();
                        locations.clickOnCallCommentsButton();
                        String firstRowDateTime = locations.getDateTimeInCommoentsPopupForFirstRecord();
                        locations.clickIconMessageWindowClose();

                        //Changing the address to a new state with different timezone
                        locations.clickOnManualEntryLinkInLocation();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("NewBreakdownaddress"));
                        locations.acceptAddressDifferenceAlert();
                        locations.clickOnCallCommentsButton();
                        String firstRowDateTimeAfterStateChange = locations.getDateTimeInCommoentsPopupForFirstRecord();

                        //Changing the date fromat from 12hrs to 24hrs foramt and comparing the difference between 2 times
                        String dateFormat = "yyyy-MM-dd HH:mm:ss";
                        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
                        Date d1 = format.parse(firstRowDateTime);
                        Date d2 = format.parse(firstRowDateTimeAfterStateChange);
                        long diff1 = d2.getTime() - d1.getTime();
                        long hurDiff = diff1 / (60 * 60 * 1000);

                        //3 hrs diffrence between GA and CA states hence validating diffence with 3 hrs
                        // The above time differenc is passed from Data sheet
                        String diffrencet=data.get("difference");
                        int difTime=Integer.parseInt(diffrencet);
                        assertTrue(hurDiff==difTime,"<b>Time Stamps are changed by changing the State and the time difference between State1 and State2  is -3</b>");
                        locations.clickIconMessageWindowClose();

                        //Creating another comment with new state
                        locations.enterCallComments(data.get("CallComments"));
                        locations.clickOnCallCommentsAddButton();
                        locations.clickOnCallCommentsButton();
                        String secondRowDateTimeAfterStateChange = locations.getDateTimeInCommoentsPopupForSecondRecord();

                        //Converting date into 24hrs format
                        Date d3 = format.parse(secondRowDateTimeAfterStateChange);
                        long diff2 = d2.getTime() - d3.getTime();
                        long hurDiffForSecondRecord = diff2 / (60 * 60);

                        //Validating if the new comments are added with new timezone
                        assertTrue(hurDiffForSecondRecord==0,"<b>New comments dispayes with new time zone</b>");
                        locations.clickIconMessageWindowClose();

                        //Entering all requred values to create a call
                        crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.vehicletriageTabsel();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
		                crVehicleTriageLib.clickOnTheVehicleSearchIcon();
		                crVehicleTriageLib.clickOnTheVehicleSearch();
		                crVehicleTriageLib.vehicleColor(VehicleDet[1]);
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
                        boolean visibilityofError = services.verifyE225ErrorOkButton();
                        if(visibilityofError){
                            services.getErrorMessageOnE225ErrorPopup();
                            services.clickOnE225ErrorOkButton();
                        }
		                crHomeLib.saveButton();
		                waitcloseAllBusyIcons();

		                //getting PST call created date and Call id
		                String callCreatedDate=services.getPTACallDateAfterCallSave();

		                callID=services.getCallId();
		                services.closeCallWindow();
		                diHome.logOut();
		                navigateToApplication("DI");
		                login(data.get("DILoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                diHome.enterCallIDInfo(callID);
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                //getting the PST time and comparing with call created date
		                pstTimeZone=diHome.getPTACallCreatedDate();

                    //Chaning the 12hrs format to 24hrs format
                    if(callCreatedDate.contains("PM"))
                    {
                        String time[] = callCreatedDate.split(" ");
                        Calendar now = Calendar.getInstance();
                        String timeOnly[] = time[1].split(":");
                        int hours = Integer.parseInt(timeOnly[0]);
                        int hhTime = hours + 12;
                        String callCreatedDateTime = time[0] + " " + hhTime + ":" + timeOnly[1] + ":" + timeOnly[2];
                        assertTrue(callCreatedDateTime.contains(pstTimeZone),"<b>Call Created date:: "+callCreatedDate+" and MCD window time::  "+pstTimeZone+" matched</b>");

                    }else
                    {
                        assertTrue(callCreatedDate.contains(pstTimeZone),"<b>Call Created date:: "+callCreatedDate+" and MCD window time::  "+pstTimeZone+" matched</b>");
                    }
		                dimcdLib.closeTheOpendCallInMCD();
		                diHome.logOut();
		                System.out.println("Test completed");
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

}
