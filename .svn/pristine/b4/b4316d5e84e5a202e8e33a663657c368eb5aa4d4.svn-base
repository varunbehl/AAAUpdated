package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDEditServiceTabAdditionalInfo extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void MCDEditServiceTabAdditionalInfo(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MCDEditServiceTabAdditionalInfo", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("MCDEditServiceTabAdditionalInfo", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("2046: DI MCD Edit Service Tab Additional Info " + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib role = new LoginRoleLib();
                    DIHomeLib diHome = new DIHomeLib();
                    CRHomeLib crHomeLib = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
                    CRServiceLib services = new CRServiceLib();
                    CRTowDestinationLib tow = new CRTowDestinationLib();
                    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
                    CR_DI crDI = new CR_DI();
                    DIMCDLib dimcd = new DIMCDLib();
                    LoginRoleLib loginRole = new LoginRoleLib();
                    DILoginLib diLogin = new DILoginLib();
                    CommonLib common = new CommonLib();

                    navigateToApplication("CR");
                    login(data.get("CRLoginName"), data.get("Password"));
                    waitcloseAllBusyIcons();
                    //home.messageDialogBoxClose();
                    String Member = "";
                    if (data.get("Member").equals("db")) {
                        //fetch member details from db
                        //generating a random number everytime to fetch a new record everytime
                        int rownum = IntRandomNumberGenerator(50, 1000);
                        //member from db
                        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
                        System.out.println("member : " + Member);
                    } else {
                        Member = data.get("Membersearch");
                    }

					/*
					if(data.get("Member").equals("db")&&Member==""){
                        Member = data.get("Membersearch");
                    }*/
                    boolean visibilityOfMessageBox = home.verifyMessageDialogBoxClose();
                    if (visibilityOfMessageBox == true) {
                        home.closeMessageDialogBoxClose();
                    }
                    if (Member == null) {
                        home.logout();
                        assertTrue(Member == null, data.get("dbqueryFileName") + " ::Query not return Member number");
                    } else {

                        //Creating a new Call
                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        locations.getLatitudeValue();
                        locations.getLongitudeValue();
                        common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();

                        home.clickOnCallSummaryButton();
                        String TroubleCode = home.getTroubleCodeValueFromCallDetailsPopup();
                        home.closeCallSummaryPopupWindow();

                        common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        services.clickOnServiceTab();
                        services.enterManualSpotDetails(data.get("facilityNumber"));
                        vehicle.handleScriptErrorInVehicleTriagePage();
                        services.enterSpecialEquipement(data.get("specialequipement"));
                        home.saveButton();
                        home.allErrorAlerts();
                        callID = services.getCallId();
                        services.closeCall();
                        home.logout();


                        navigateToApplication("DI");
                        login(data.get("LoginNameForDI"), data.get("Password"));
                        common.clickOnProceedBtnForDispatchSPPLogin();

                        diLogin.waitcloseAllBusyIcons();

                        diHome.clickOnSearchCallsLink();
                        String currentDate=common.getCurrentDate();
                        String startDate=common.getPreviousDate(currentDate);
                        diHome.enterStartDateOnSearchCallsWindow(startDate);
                        diHome.searchAndSelectCallIDInDI(callID);
                        dimcd.clickOnServiceTabInMCDWindow();
                        boolean availablityOfEditLink=dimcd.verifyAdditionalInfoLinkInMCDServiceTab();
                        if(availablityOfEditLink) {
                            dimcd.clickOnAdditionalInfoLinkInMCDServiceTab();
                            //Adding Another Special Equipment Info from MCD WIndow
                            dimcd.enterSpecialEquipmentInMCDServiceTab(data.get("specialEqupementInMCD"));
                            dimcd.clickOnSaveButtonInSpecialEquiptmentSection();
                            dimcd.getStatusUpdateValueInMCDWindow();
                            dimcd.enterReasonForStatus(data.get("reasonForStatus"));
                            //Entering Comments while updating special equipments
                            String random = getRandomString(15);
                            String comments = dimcd.enterCommentsInUpdateCallStatus(random);
                            dimcd.clickOnUpdateButtonInUpdateStatus();
                            crHomeLib.getErrorMessageTextFromAlert();
                            //comparing comments between entered comments and saved comments
                            String commentsFromCommentsSection = dimcd.getCommentsFromCommentsWindow(comments);
                            assertTrue(commentsFromCommentsSection.equalsIgnoreCase(comments), "<b>Both entered comments:: " + comments + " ::and Saved comments:: " + commentsFromCommentsSection + " ::are same</b>");
                            //Validating Status in hisotry link
                            dimcd.clickOnStatusHistoryLinkOnMCDWindow();
                            dimcd.clickOnDateHeaderToSortDate();
                            dimcd.getStatusInHistoryStatusScreenInMCDWindow();
                            dimcd.clickOnMCDCloseWindow();
                            diHome.logOut();
                        }
                        else{
                            reporter.failureReport("<b>Edit Link Visiblility ","<b>This user is not having edit functiaonlity to edit the fields",driver);
                            dimcd.clickOnMCDCloseWindow();
                            diHome.logOut();
                        }
                        System.out.println("Test completed");
                    }
                    diHome.logOut();
                }
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2046",ReportStatus.strMethodName,intCounter,browser);
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
