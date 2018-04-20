package com.aaa.web.lib;

import com.aaa.e2e.script.CR_DI;
import com.aaa.mobile.lib.HomeLib;
import com.aaa.web.page.CRAPDPage;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.LoginPage;

import com.aaa.web.page.LoginRolePage;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class CommonLib extends LoginLib {
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];
    //Declarations
    CRLocationsLib crLocationsLib =new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRSearchCallsLib crSearchCallsLib = new CRSearchCallsLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRTowDestinationLib crTowDestinationLib = new CRTowDestinationLib();
    DILoginLib diLoginLib=new DILoginLib();
    LoginRoleLib loginRoleLib = new LoginRoleLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHomeLib = new DIHomeLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DIHomePage diHomePage = new DIHomePage();

    public void callReceivingLogin(String UserName, String Password, String LoginRole, String Role) throws Throwable {
        navigateToApplication("CR");
        crHomeLib.verifyandClickLogout();
        //Thread.sleep(3000);
        switch (LoginRole) {
            case "CR":
               // Thread.sleep(2000);
                login(UserName,Password);
                break;
            case "DI":
                //Thread.sleep(2000);
                login(UserName,Password);
                loginRoleLib.roleSelection(Role);
                Thread.sleep(4000);
                loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
                //autodi1	auto123!! DI-Dispatcher
                break;
            case "AD":
                login(UserName,Password);
                loginRoleLib.roleSelection(Role);
                loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
                //autoad1	auto123!!  AD-Administrator
                break;
            default:
                break;
        }
        crMemberSearchLib.clickOnPartialCallCloseButton();
        crHomeLib.messageDialogBoxClose();
    }

    public void callReceivingLogin(String UserName, String Password) throws Throwable {
        callReceivingLogin(UserName,Password,"CR","");
    }

    //*** Supporting Main Methods
    public void crMemberSearchTab(String Member, String MemberSearch, String dbServer, String dbqueryFileName, String colomnName, String PhoneNumber, String Primaryphonenum1 ) throws Throwable
    {
        crMemberSearchLib.enterMembershipDetails(Member,MemberSearch, dbServer,dbqueryFileName, colomnName, PhoneNumber,Primaryphonenum1);
        crMemberSearchLib.verifyCompleteCheckMember();
    }
    public void crLocationsTab(String BreakdownSearch,String BreakdownType,String crossStreet,String secondCrossStreet,String LandMark,String Address) throws Throwable
    {
        crLocationsLib.breakdownLocTabSel();
        crLocationsLib.errorAlertHandlingBeforeEnterMandatoryFields();
        crLocationsLib.breakdownSearchAndBreakdownType(BreakdownSearch, BreakdownType, crossStreet, secondCrossStreet, LandMark, Address);
        crLocationsLib.verifyCompleteCheckLocation();
    }
    public void crVehicleTriageTab(String VehicleSearch, String VehicleDetails,String vehicleType, String ProblemTriage, String ProblemType) throws Throwable
    {
        crVehicleTriageLib.clickOnVehicleTriageTab();
        crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
        crVehicleTriageLib.enterVehicleDetails(VehicleSearch,VehicleDetails);
        //crVehicleTriageLib.enterVehicleType(vehicleType);
        //tabout();
        crHomeLib.messageDialogBoxClose();
        crVehicleTriageLib.problemTriage(ProblemTriage,ProblemType);
        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
        crVehicleTriageLib.scriptErrorHandle();
        crHomeLib.allErrorAlerts();
        crVehicleTriageLib.verifyCompleteCheckVehicleTriage();
    }
    public void crTowDestinationTab(String WillThisCallBeATow, String TowDestination, String RSPReferral , String TowAddress) throws Throwable
    {
        crTowDestinationLib.enterTowDestinationAddress(WillThisCallBeATow,TowDestination,RSPReferral,TowAddress);

    }


    public void callReceivingLogout() throws Throwable
    {
        crHomeLib.logout();
        CloseLogoutAlert();

    }

    /****************************************************** DISPATCH ******************************************************/
    public void dispatchLogin(String UserName, String Password, String LoginRole, String Role) throws Throwable {
        diHomeLib.logOut();
    	switch (LoginRole) {
            case "DI":
                diLoginLib.login(UserName,Password);
                loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
                diLoginLib.waitcloseAllBusyIcons();
                //diHomeLib.clickOnCloseIconOnQueueSelection();
                selectAllQueues();
                break;
            case "AD":
                diLoginLib.login(UserName,Password);
                Thread.sleep(4000);
                loginRoleLib.roleSelection(Role);
                waitcloseAllBusyIcons();
                //diHomeLib.clickOnCloseIconOnQueueSelection();
                selectAllQueues();
                break;
            default:
                diLoginLib.login(UserName,Password);
                diLoginLib.waitcloseAllBusyIcons();
                diHomeLib.clickOnCloseIconOnFacilityPTA();
                break;
        }
    }

    public void dispatchlogout(String CallFlow) throws Throwable
    {
        boolean errorCreditCardMessage=dimcdLib.verifyE250ErrorMessageAvailablity();
        if(errorCreditCardMessage) {
            dimcdLib.getE250ErrorMessage();
            reporter.failureReport("Credit Card Error","Unable to Clear Call due to Credit Card popup.",driver);
            dimcdLib.clickOnE250OKButton();
        }
        dimcdLib.closeErrorAlertOKButton();
        dimcdLib.clickOnMCDCloseWindow();
        if (CallFlow.equalsIgnoreCase("Truckload"))
        {
            diHomeLib.clickonCloseInTruckLoad();
        }
        dimcdLib.closeErrorAlertOKButton();
        diHomeLib.logOut();
        CloseLogoutAlert();
    }

    public String[] completeCall(String CompleteCall) throws Throwable {
        switch (CompleteCall) {

            case "Save":
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                callIDCreated = crServiceLib.getCallId();
                spotIDCreated = crServiceLib.getSpotFacilityId();
                callDateCreated=crServiceLib.getCallDate();
                crServiceLib.closeCall();
                break;
            case "Cancel":
                crHomeLib.cancelButton();
                //below function will click on Yes on confirmation window
                crHomeLib.allErrorAlerts();
                break;
            default:
                break;
        }
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;
        return callandfacilityId;
    }

    public void crServiceTab(String priority,String priorityRequired,String appointment,String hold,String redFlag,String policy,String policyValue,String Callback,String CallBackMinutes,String CallBackReqType,String Spot,String ResoptFacilityID,String ManualSoptFacilityID,String ManualSoptFacilityIDNew,String specialequipement,String CompleteCall)throws Throwable
    //crServiceTab(data.get( "Priority"),data.get("PriorityRequired"),
    // data.get("Appointment"),data.get( "Hold"),data.get( "RedFlag"),
    // data.get( "Policy"),data.get( "PolicyValue"),data.get( "CallBack"),
    // data.get( "CallBackMinutes"),data.get( "CallBackReqType"),
    // data.get("Spot"),data.get("ResoptFacilityID"),
    // data.get("ManualSoptFacilityID"),data.get("ManualSoptFacilityIDNew"),
    // data.get("specialequipement"),data.get( "CompleteCall"));
    {

        crServiceLib.clickOnServiceTab();
        crServiceLib.enterpriority(priority,priorityRequired);
        crServiceLib.enterAppointment(appointment,hold);
        crServiceLib.clickRedFlag(redFlag);
        crServiceLib.enterPolicy(policy,policyValue);
        crServiceLib.callBack(Callback,CallBackMinutes,CallBackReqType);
        crServiceLib.spot(Spot,ResoptFacilityID,ManualSoptFacilityID,ManualSoptFacilityIDNew);
        crServiceLib.enterSpecialEquipement(specialequipement);
        completeCall(CompleteCall);
        callReceivingLogout();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: crCallCreation
     * description :: This is used to create a new call with desired combination of data
     * Parameters: CRLoginName: autocr1, CRPassword: auto123!!, LoginRoleCallReceiving: CR or DI or AD
     *             role: Admin|| dispatch ..., Member: DB or memberNumber, Membersearch: memberNumber if DB returns null values,
     *             dbServer: d3cr, dbqueryFileName: retrieveBasicMember.sql (This will be changed based upon the member type),
     *             colomnName: MBR_ID_16, PhoneNumber: Existing, Primaryphonenum1: 4074449999,  VehicleSearch: Exisiting|Manual|Year Make Model|
     *             VehicleDetails: if VehicleSearch is either Manual | YEar pass the required vehicle details, ProblemTriage: Flat Tire etc..
     *             ProblemType:, WillThisCallBeATow: Yes or No, TowDestination: Full address or AAR or Existing, RSPReferral: RSP Referal notification,
     *             TowAddress: Enter address if it is manual, OmniBarAddress: Location deatails
     *
     * date :: 05-Nov-2017
     * author ::
     */



public void crCallCreation(String CRLoginName,String CRPassword,String LoginRoleCallReceiving,String role,String Member,String Membersearch,String dbServer,String dbqueryFileName,String colomnName,String PhoneNumber,String Primaryphonenum1,
                           String VehicleSearch,String VehicleDetails,String ProblemTriage,String ProblemType,String vehicleType,
                           String WillThisCallBeATow,String TowDestination,String RSPReferral,String TowAddress,String OmniBarAddress) throws Throwable{
        Thread.sleep(3000);
   callReceivingLogin(CRLoginName,CRPassword,LoginRoleCallReceiving,role);
   crMemberSearchTab(Member,Membersearch,dbServer,dbqueryFileName, colomnName,PhoneNumber,Primaryphonenum1);
   crLocationsLib.breakdownLocTabSel();
   crLocationsLib.enterBreakDownAddressOmniBarSearch(OmniBarAddress);
   crVehicleTriageTab(VehicleSearch,VehicleDetails, ProblemTriage,ProblemType,vehicleType);
   crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
   crHomeLib.allErrorAlerts();
   crTowDestinationTab(WillThisCallBeATow,TowDestination,RSPReferral,TowAddress);
    }


public void CloseLogoutAlert()  throws Throwable{
	boolean exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
	int counter = 0;
	while (!exist){
		acceptAlert();
		Thread.sleep(5000);
		exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
		if (exist){
			break;
		}
		if(counter > 10){
			break;
		}
		counter = counter + 1;
	}
}


public void accessMCDWindowForSPPandDI(String LoginNameForDI,String PasswordForDI,String sppUser,String startDate,String endDate,
                                       String status,String callID) throws Throwable{
    navigateToApplication("DI");
    login(LoginNameForDI, PasswordForDI);
    if(!sppUser.equalsIgnoreCase("Yes")) {
        loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
        diLoginLib.waitcloseAllBusyIcons();
        diHomeLib.clickOnCloseIconOnQueueSelection();
    }else {
        diLoginLib.waitcloseAllBusyIcons();
        diHomeLib.closeFacilityWindow();
    }
    diHomeLib.clickOnSearchCallsLink();

//entering values in searchcalls
    diSearchCalls.enterStartDate(startDate);
    diSearchCalls.enterEndDate(endDate);
    diSearchCalls.clickAndEnterCallIDInfo(callID);
    diSearchCalls.enterValueInStatusTextBonInSearchCalls(status);
    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
    diSearchCalls.selectSPStatusRowInSearchCallDispatch();

}

    public void tabout() throws Throwable
	{
		Thread.sleep(3000);
	    String combineKeys3 = Keys.chord(Keys.TAB);
	    sendKeys(combineKeys3, "Tab");
	}

	public void releaseAppointmentCall(String aptCall, String callID, String reason,String FacilityDetails) throws Throwable{
		if (!aptCall.equalsIgnoreCase("No") && (!callID.isEmpty())) {
			//click on search call
			crSearchCallsLib.clickOnSearchCalls();
			//search with call ID
			crSearchCallsLib.enterCallIdOnSearchCallsWindow(callID);
			crSearchCallsLib.clickonSearchinSearchCalls();
			//select record
			crSearchCallsLib.clickOnCallIDLink();
			Thread.sleep(8000);
            //yes confirmation
            crHomeLib.ClickOnYesButtonOnConfirmationWindow();
            crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			//crHomeLib.ClickOnYesButtonOnConfirmationWindow();
			Thread.sleep(3000);
			crHomeLib.messageDialogBoxClose();
			//click on service Tab
			crServiceLib.clickOnServiceTab();
			//click on release
			crServiceLib.clickOnReleaseButton();
			Thread.sleep(5000);
            crHomeLib.ClickOnYesButtonOnConfirmationWindow();
			crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			crHomeLib.messageDialogBoxClose();
			//click on save
            crHomeLib.ClickOnYesButtonOnConfirmationWindow();
			//crHomeLib.saveButton();
            crHomeLib.ClickOnYesButtonOnConfirmationWindow();
			crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			crHomeLib.ClickOnYesButtonOnConfirmationWindow();
			//Status Update
			crServiceLib.enterUpdateReasonForStatus(reason);
			tabout();
			Thread.sleep(3000);
			crServiceLib.clickOnUpadteButton();


			Thread.sleep(4000);
            boolean errorMessage268=crServiceLib.verifyE268ErrorMessageAvailablity();
            if(errorMessage268) {
                crServiceLib.getE268ErrorMessage();
                crServiceLib.clickOnE268OKButton();
                Thread.sleep(2000);
                crServiceLib.enterManualSpotDetails(FacilityDetails); //data.get("ManualSoptFacilityID")
                crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
                crHomeLib.saveButton();
                crHomeLib.ClickOnYesButtonOnConfirmationWindow();
                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                //Status Update
                crServiceLib.enterUpdateReasonForStatus(reason);
                tabout();
                Thread.sleep(3000);
                crServiceLib.clickOnUpadteButton();
            }

			//close call
			crServiceLib.closeCall();
			crHomeLib.allErrorAlertsNoButton();
		}

	}
    public void loginToDIAndClickOnSearchCalls(String diUserName, String diPassword, String sppYesNo) throws Throwable {
        navigateToApplication("DI");
        diLoginLib.login(diUserName, diPassword);
        if (sppYesNo.equalsIgnoreCase("Yes")) {
            Thread.sleep(5000);
            diLoginLib.waitcloseAllBusyIcons();
            diHomeLib.clickOnCloseIconOnFacilityPTA();
        } else {
            Thread.sleep(5000);
            loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
            diLoginLib.waitcloseAllBusyIcons();
            diHomeLib.clickOnCloseIconOnQueueSelection();

        }

        diHomeLib.clickOnSearchCallsInDispatch();
        Thread.sleep(2000);
    }

    public void selectAllQueues() throws Throwable
    {
        diHomeLib.clickOnRemoveAll();
        //Spot Tab
        diHomeLib.clickOnSpotTab();
        diHomeLib.clickOnSelectAllLinkOnSpotQueueWindow();
        diHomeLib.clickOnAddButtonOnQueueWindow();
        //Dispatch Tab
        diHomeLib.clickOnDispatchTab();
        diHomeLib.clickOnSelectAllLinkOnQueueWindow();
        diHomeLib.clickOnAddButtonOnQueueWindow();
        //Favourite Tab
        diHomeLib.clickOnFavoritesInQueSelection();
        diHomeLib.clickOnSelectAllLinkOnFavouriteQueueWindow();
        diHomeLib.clickOnAddButtonOnQueueWindow();
        Thread.sleep(3000);
        diHomeLib.clickOnContinueQueuesInDispatch();
        Thread.sleep(8000);
    }

    public void resetProfileSettings() throws Throwable
    {
        diHomeLib.clickOnGearIconOfProfileWindow();

        diHomeLib.clickOnResetDefaultSettingOnProfileTab();

        dragAndDrop(diHomePage.lnkStsOnProfileWindow, diHomePage.lnkZoneProfileWindow, "Drag and drop");
        diHomeLib.clickOnRemoveAllOnProfileTab();

        diHomeLib.enterFilterInProfileWindow("ID"); //ID //data.get("FilterId")
        diHomeLib.clickOnIDOnProfileTab();
        diHomeLib.clickOnAddOnProfileTab();

        clearData(diHomePage.txtFilterInProfileWindow);
        diHomeLib.enterFilterInProfileWindow("Date"); //Date  //data.get("FilterDate")
        diHomeLib.clickOnDateOnProfileTab();
        diHomeLib.clickOnAddOnProfileTab();

        diHomeLib.clickOnArrowButtonOfDate();
        diHomeLib.selectPriority("1"); //1 //data.get("DatePriorityOrder")
        diHomeLib.selectOrder("Descending"); //Descending  //data.get("DescendingOrder")
        diHomeLib.clickOnSaveButtonOfIDAndDateOnProfileWindow();

        diHomeLib.clickOnArrowButtonOfID();
        diHomeLib.selectPriority("2"); //2 //data.get("IDPriorityOrder")
        diHomeLib.selectOrder("Descending"); //Descending //data.get("DescendingOrder")
        diHomeLib.clickOnSaveButtonOfIDAndDateOnProfileWindow();

        diHomeLib.clickOnSaveSettingsButtonOfProfileWindow();

        crHomeLib.allErrorAlerts();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCurrentDate
     * description ::
     * Parameters:
     * date :: 05-Nov-2017
     * author ::
     */
    public String getCurrentDate(){
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate=sdf.format(date);
        return currentdate;
    }


    public String getPreviousDate(String curDate)throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return format.format(calendar.getTime());
    }
    public String getNextDay(String curDate)throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }

    public void clickOnProceedBtnForDispatchSPPLogin() throws Throwable {
        //click on proceed login button
        boolean proceedButton=isVisibleOnly(LoginRolePage.btnProceedLogin, "Proceed to Login");
        if(proceedButton){
            loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
            waitcloseAllBusyIcons();
            diHomeLib.clickOnCloseIconOnQueueSelection();
        } else {
            //For autodi4 user donot have proceed button but it will have Queue selection window
            diHomeLib.clickOnCloseIconOnQueueSelection();
            waitcloseAllBusyIcons();
            diHomeLib.closeFacilityWindow();
        }
    }
    public String createCallWithManualPacesetterAndManualSpot(String CRLoginName,String Password,String Member,String dbServer,String dbqueryFileName,
                                                            String colomnName,String Membersearch,String OmniBarAddress, String VehicleSearch,String VehicleDetails,
                                                            String vehicleType,String ProblemTriage, String ProblemType,String WillThisCallBeATow,
                                                            String TowDestination,String RSPReferral,String TowAddress,String facilityNumber)throws Throwable {
        /*data.get("CRLoginName"), data.get("Password"),data.get("Member"),data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"),
        data.get("Membersearch"),data.get("dbqueryFileName"),data.get("OmniBarAddress"),data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"),
                                data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"),data.get("facilityNumber")*/

        navigateToApplication("CR");
        login(CRLoginName, Password);
        waitcloseAllBusyIcons();
        //home.messageDialogBoxClose();
         Member = "";
        if (Member.equals("db")) {
            //fetch member details from db
            //generating a random number everytime to fetch a new record everytime
            int rownum = IntRandomNumberGenerator(50, 1000);
            //member from db
            Member = CommonDb.selectRandomMemberFromDB(dbServer, dbqueryFileName, colomnName, rownum);
            System.out.println("member : " + Member);
        } else {
            Member = Membersearch;
        }

					/* String OmniBarAddress, String VehicleSearch,String VehicleDetails,String vehicleType,String ProblemTriage, String ProblemType,String WillThisCallBeATow,
					String TowDestination,String RSPReferral,String TowAddress,String facilityNumber
					if(data.get("Member").equals("db")&&Member==""){
                        Member = data.get("Membersearch");

                    }*/
        boolean visibilityOfMessageBox = crHomeLib.verifyMessageDialogBoxClose();
        if (visibilityOfMessageBox) {
            crHomeLib.closeMessageDialogBoxClose();
        }
        if (Member.isEmpty()) {
            crHomeLib.logout();
            assertTrue(Member.isEmpty(), dbqueryFileName + " ::Query not return Member number");
        } else {
            crHomeLib.memberSearchTextBox(Member);
            crMemberSearchLib.memberNumClick();
            crLocationsLib.breakdownLocTabSel();
            crLocationsLib.enterBreakDownAddressOmniBarSearch(OmniBarAddress);
            crVehicleTriageTab(VehicleSearch, VehicleDetails, vehicleType, ProblemTriage, ProblemType);
            crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
            crHomeLib.allErrorAlerts();

            crHomeLib.clickOnCallSummaryButton();
            crHomeLib.getTroubleCodeValueFromCallDetailsPopup();
            crHomeLib.closeCallSummaryPopupWindow();

            crTowDestinationTab(WillThisCallBeATow,TowDestination,RSPReferral,TowAddress);
            crServiceLib.clickOnServiceTab();
            crServiceLib.enterManualSpotDetails(facilityNumber);
            crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
            crHomeLib.saveButton();
            /*crHomeLib.allErrorAlerts();
            String CreatedCallID = crServiceLib.getCallId();
            crServiceLib.closeCall();
            crHomeLib.logout();*/
        }
        return Member;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: waitcloseAllNotifications
     * description ::
     * date :: 16-Apr-2018
     * author :: Chandrasekhar Dendukuri
     */

    public void waitcloseAllNotifications() throws Throwable {
        int iCounter = 0, loading;
        boolean status = true;
        do {
            iCounter++;
            loading = getElementsSize(CRAPDPage.notifications);
            if (loading == 0) {
                status = true;
                break;
            } else {
                status = false;
            }
            if (iCounter > 400) {
                status = false;
                break;
            }
        }
        while (iCounter <= 400);
        if (status) {
            LOG.info("All spinners are closed");
        } else {
            LOG.info("All spinners are not closed");
        }
    }

}
