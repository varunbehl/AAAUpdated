package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.*;
import org.openqa.selenium.Keys;

import javax.xml.ws.Service;

public class SPPServiceTicketLib extends ActionEngine {



    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectAPPAplicationMenuItem
     * description :: selectAPPAplicationMenuItem
     * date :: 6-Mar-2018
     * author :: Varun
     */
    public void selectApplicationMenuItem() throws Throwable {
        mouseClick(DIHomePage.lnkApplicationMenu, "Application Menu");

    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectServiceTicketsUnderAPPAplicationMenuItem
     * description :: select Service Tickets Under Aplication MenuItem
     * date :: 6-Mar-2018
     * author :: Varun
     */
    public void selectServiceTicketsUnderAPPAplicationMenuItem() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lnkServicetTickets, "Service Tickets");
        click(SPPServiceTicketPage.lnkServicetTickets, "Service Tickets");
    }
    /**
     * param ::String Membersearch
     * return ::String
     * throws :: throwable
     * methodName :: enterMembershipNumber
     * description :: enter Membership Number where member having entitlements remaining from DB
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterMembershipNumber(String Membersearch) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtMemberShipNumber, "MemberShip Number");
        type(SPPServiceTicketPage.txtMemberShipNumber, Membersearch, "MemberShip Number");
        return Membersearch;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickVerifyMemberBtn
     * description :: clickVerifyMemberBtn
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickVerifyMemberBtn() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnVerifyMember, "verify member button");
        click(SPPServiceTicketPage.btnVerifyMember, "verify member button");
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetMemberNamePopulate
     * description :: verifyAndGetMemberNamePopulate under members tab for members first name
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetMemberNamePopulate() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtMemberFirstName, "Member FirstName");
        String fname = getAttributeByValue(SPPServiceTicketPage.txtMemberFirstName, "Member firstName");
        return fname;
    }


    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetClubCodePopulate
     * description :: verifyAndGetClubCode Populate under members tab for Club code
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetClubCodePopulate() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtClubCode, "ClubCode");
        String ClbCode = getAttributeByValue(SPPServiceTicketPage.txtClubCode, "ClubCode");
        return ClbCode;
    }

    /**
     * param ::String ServiceTicket
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTicketNumber
     * description :: enterServiceTicketnumber
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTicketNumber(String ServiceTicket) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtServiceTicketNumber, "Ticket Number");
        type(SPPServiceTicketPage.txtServiceTicketNumber, ServiceTicket, "Ticket Number");

        return ServiceTicket;
    }
    public String getTicketValue() throws Throwable {

        String ticketValue=getAttributeByValue(SPPServiceTicketPage.txtServiceTicketNumber, "Ticket number value");

        return ticketValue;
    }



    /**
     * param ::String Membersearch
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceCallDate
     * description :: enterServiceCallDate
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceCallDate(String ServiceCallDate) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtCallDate, "Service Call Date");
        type(SPPServiceTicketPage.txtCallDate, ServiceCallDate, "Service Call Date");
        return ServiceCallDate;
    }
    public String getServiceCallDateValue() throws Throwable {

        String ServiceCallDateValue=getAttributeByValue(SPPServiceTicketPage.txtCallDate, "Service Call Date value");

        return ServiceCallDateValue;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickVehicleTab
     * description :: click Vehicle Tab
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickVehicleTab() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.vehicleTab, "vehicle Tab");
        click(SPPServiceTicketPage.vehicleTab, "vehicle Tab");
    }
    /**
     * param ::String VehicleYear
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceVehicleYear
     * description :: enterServiceVehicleYear
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceVehicleYear(String VehicleYear) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtVehicleYear, "Service VehicleYear");
        type(SPPServiceTicketPage.txtVehicleYear, VehicleYear, "Service VehicleYear");
        return VehicleYear;
    }

    public String getServiceVehicleYear() throws Throwable {

        String ServiceVehicleYearValue=getAttributeByValue(SPPServiceTicketPage.txtVehicleYear, "Service vehicle year value");

        return ServiceVehicleYearValue;
    }
    /**
     * param ::String VehicleMake
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceVehicleMake
     * description :: enterServiceVehicleMake
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceVehicleMake(String VehicleMake) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtVehicleMake, "Service VehicleMake");
        type(SPPServiceTicketPage.txtVehicleMake, VehicleMake, "Service VehicleMake");
        return VehicleMake;
    }

    public String getServiceVehicleMake() throws Throwable {

        String ServiceVehiclemakeValue=getAttributeByValue(SPPServiceTicketPage.txtVehicleMake, "Service vehicle make value");

        return ServiceVehiclemakeValue;
    }

    /**
     * param ::String VehicleModel
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceVehicleModel
     * description :: enterServiceVehicleModel
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceVehicleModel(String VehicleModel) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtVehicleModel, "Service VehicleModel");
        type(SPPServiceTicketPage.txtVehicleModel, VehicleModel, "Service VehicleModel");
        return VehicleModel;
    }
    public String getServiceVehicleModel() throws Throwable {

        String ServiceVehicleModelValue=getAttributeByValue(SPPServiceTicketPage.txtVehicleModel, "Service Vehicle model value");

        return ServiceVehicleModelValue;
    }
    /**
     * param ::String VehicleTag
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceVehicleTag
     * description :: enterServiceVehicleTag
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceVehicleTag(String VehicleTag) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtVehicleTag, "Service VehicleTag");
        type(SPPServiceTicketPage.txtVehicleTag, VehicleTag, "Service VehicleTag");
        return VehicleTag;
    }
    public String getServiceVehicleTag() throws Throwable {

        String ServiceVehicleTagValue=getAttributeByValue(SPPServiceTicketPage.txtVehicleTag, "Service vehicle tag value");

        return ServiceVehicleTagValue;
    }
    /**
     * param ::String VehicleState
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceVehicleState
     * description :: enterServiceVehicleState
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceVehicleState(String VehicleState) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtVehicleState, "Service VehicleState");
        type(SPPServiceTicketPage.txtVehicleState, VehicleState, "Service VehicleState");
        return VehicleState;
    }

    public String getServiceVehicleState() throws Throwable {

        String ServiceVehicleState=getAttributeByValue(SPPServiceTicketPage.txtVehicleState, "Service vehicle state value");

        return ServiceVehicleState;
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickBreakdownTab
     * description :: click Breakdown Tab
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickBreakdownTab() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnBreakdownTab, "Breakdown Tab");
        click(SPPServiceTicketPage.btnBreakdownTab, "Breakdown Tab");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterTxtinServiceBrkDowLocSrch
     *  * description :: To enter breakdown location address manually
     *  * date :: 07-march-2018
     *  * author ::Varun
     *  
     */


    public void enterTxtinServiceBrkDowLocSrch(String enterBreakdownLocationSearch) throws Throwable {

        waitForVisibilityOfElement(SPPServiceTicketPage.txtBreakdownLocSearchField, "Breakdown location search");
        //click(CRLocationsPage.txtBrkDowLocSrch, "Location search box");
        type(SPPServiceTicketPage.txtBreakdownLocSearchField, enterBreakdownLocationSearch, "Breakdownlocaddress");

        click(SPPServiceTicketPage.btnLocationSearch, "Click search");
        Thread.sleep(5000);
        mouseClick(SPPServiceTicketPage.lnkLocationResultsBreakdownTab, "Breakdownlocaddress");
    }

    /**
     * param ::NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyAddressVerifiedIndicator
     * description :: verifyAddressVerifiedIndicator
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public Boolean verifyAddressVerifiedIndicator() throws Throwable {
        boolean addverify=waitForVisibilityOfElement(SPPServiceTicketPage.lblBreakdownTabAddressVerified, " Verify Tow Address verified indicator");
        return addverify;
    }


    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterTxtinServiceTowLocSrch
     *  * description :: To enter tow tab location address manually
     *  * date :: 07-march-2018
     *  * author ::Varun
     *  
     */


    public void enterTxtinServiceTowLocSrch(String enterBreakdownLocationSearch) throws Throwable {

        waitForVisibilityOfElement(SPPServiceTicketPage.txtTowLocSearchField, "Tow location search");
        //click(CRLocationsPage.txtBrkDowLocSrch, "Location search box");
        type(SPPServiceTicketPage.txtTowLocSearchField, enterBreakdownLocationSearch, "Tow location search");

        click(SPPServiceTicketPage.btnTowLocationSearch, "Click search");
        mouseClick(SPPServiceTicketPage.lnkLocationResultsTowTab, "Tow location address");
    }

    /**
     * param ::String Location
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTowLocation
     * description :: enterServiceTowLocation
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTowLocation(String Location) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.towLocationField, "Service Tow location field");
        type(SPPServiceTicketPage.towLocationField, Location, "Service Tow location field");
        return Location;
    }

    /**
     * param ::NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyTowAddressVerifiedIndicator
     * description :: verifyTowAddressVerifiedIndicator
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public Boolean verifyTowAddressVerifiedIndicator() throws Throwable {
        boolean addverify=waitForVisibilityOfElement(SPPServiceTicketPage.lblTowTabAddressVerified, " Tow Address verified indicator");
        return addverify;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickServicesTab
     * description :: click Services Tab
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickServicesTab() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnServiceTab, "Services Tab");
        click(SPPServiceTicketPage.btnServiceTab, "Services Tab");
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyNGetMileageTowCost
     * description :: verifyNGetMileageTowCost
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String verifyNGetMileageTowCost() throws Throwable {
        String mileageTowCost=getText(SPPServiceTicketPage.lblMileageTowCost, " Mileage Tow cost");
        return mileageTowCost;
    }


    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyNGetTowMileage
     * description :: verifyNGetTowMileage
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String verifyNGetTowMileage() throws Throwable {
        String mileageTow=getText(SPPServiceTicketPage.lblTowMileage, "Tow Mileage  ");
        return mileageTow;
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyNGetTowMileage
     * description :: verifyNGetTowMileage
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String verifyNGetMileageEnrouteCost() throws Throwable {
        String mileagEnCost=getText(SPPServiceTicketPage.lblmileageEnrouteCost, "Enroute Mileage Cost");
        return mileagEnCost;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyNGetMileageEnroute
     * description :: verifyNGetMileageEnroute
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String verifyNGetMileageEnroute() throws Throwable {
        String mileagEn=getText(SPPServiceTicketPage.lblEnrouteMileage, "Enroute Mileage ");
        return mileagEn;
    }
    /**
     * param ::String TimeReceived
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTimeReceived
     * description :: enterServiceTimeReceived
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTimeReceived(String TimeReceived) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtTimeRecieved, "Service TimeReceived");
        type(SPPServiceTicketPage.txtTimeRecieved, TimeReceived, "Service TimeReceived");
        return TimeReceived;
    }
    public String getServiceTimeRecieved() throws Throwable {

        String ServiceTimeRecieved=getAttributeByValue(SPPServiceTicketPage.txtTimeRecieved, "Service Time recieved value");

        return ServiceTimeRecieved;
    }
    /**
     * param ::String TimeOnLocaion
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTimeOnLocaion
     * description :: enterServiceTimeOnLocaion
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTimeOnLocaion(String TimeOnLocaion) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtTimeOnLocation, "Service Time OnLocaion");
        type(SPPServiceTicketPage.txtTimeOnLocation, TimeOnLocaion, "Service Time OnLocaion");
        return TimeOnLocaion;
    }
    public String getServiceTimeOnLocaion() throws Throwable {

        String ServiceTimeOnLocaion=getAttributeByValue(SPPServiceTicketPage.txtTimeOnLocation, "Service Time OnLocaion value");

        return ServiceTimeOnLocaion;
    }
    /**
     * param ::String TimeCleared
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTimeCleared
     * description :: enterServiceTimeCleared
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTimeCleared(String TimeCleared) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtTimeCleared, "Service Time Cleared");
        type(SPPServiceTicketPage.txtTimeCleared, TimeCleared, "Service Time Cleared");
        return TimeCleared;
    }

    public String getServiceTimeCleared() throws Throwable {

        String ServiceTimeCleared=getAttributeByValue(SPPServiceTicketPage.txtTimeCleared, "Service Time Cleared value");

        return ServiceTimeCleared;
    }

    /**
     * param ::String Facility
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceFacility
     * description :: enterServiceFacility
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceFacility(String Facility) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtFacility, "Service Facility");
        type(SPPServiceTicketPage.txtFacility, Facility, "Service Facility");
        return Facility;
    }

    public String getServiceFacility() throws Throwable {

        String ServiceFacility=getAttributeByValue(SPPServiceTicketPage.txtFacility, "Service Facility value");

        return ServiceFacility;
    }
    /**
     * param ::String PaceSetterCode1
     * return ::String
     * throws :: throwable
     * methodName :: enterServicePaceSetterCode1
     * description :: enterServicePaceSetterCode1
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServicePaceSetterCode1(String PaceSetterCode1) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtPacesetterCode, "Service PaceSetterCode1");
        type(SPPServiceTicketPage.txtPacesetterCode, PaceSetterCode1, "Service PaceSetterCode1");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
        //mouseClick(CRVehicleTriagePage.selcManualPacesetterCodeBattery, "Select manual pacesettercode");
        return PaceSetterCode1;
    }
    public String getServicePaceSetterCode1() throws Throwable {

        String ServicePaceSetterCode1=getAttributeByValue(SPPServiceTicketPage.txtPacesetterCode, "Service PacesetterCode value");

        return ServicePaceSetterCode1;
    }
    /**
     * param ::String ClearingCode
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceClearingCode
     * description :: enterServiceClearingCode
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceClearingCode(String ClearingCode) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtClearingCode, "Service ClearingCode");
        type(SPPServiceTicketPage.txtClearingCode, ClearingCode, "Service ClearingCode");
        return ClearingCode;
    }
    public String getServiceClearingCode() throws Throwable {

        String ServiceClearingCode=getAttributeByValue(SPPServiceTicketPage.txtClearingCode, "Service Clearing Code value");

        return ServiceClearingCode;
    }
    /**
     * param ::String TLCReason
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTLCReason
     * description :: enterServiceTLCReason
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTLCReason(String TLCReason) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtTLCReason, "Service TLCReason");
        type(SPPServiceTicketPage.txtTLCReason, TLCReason, "Service TLCReason");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
        return TLCReason;
    }
    public String getServiceTLCReason() throws Throwable {

        String ServiceTLCReason=getAttributeByValue(SPPServiceTicketPage.txtTLCReason, "Service TLCReason value");

        return ServiceTLCReason;
    }
    /**
     * param ::String TroubleCode1
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTroubleCode1
     * description :: enterServiceTroubleCode1
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceTroubleCode1(String TroubleCode1) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtTroubleCode1, "Service TLCTroubleCode1Reason");
        type(SPPServiceTicketPage.txtTroubleCode1, TroubleCode1, "Service TroubleCode1");
        return TroubleCode1;
    }

    public String getServiceTroubleCode1() throws Throwable {

        String ServiceTroubleCode1=getAttributeByValue(SPPServiceTicketPage.txtTroubleCode1, "Service TroubleCode1 value");

        return ServiceTroubleCode1;
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickAddComment
     * description :: clickAddComment
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickAddComment() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnAddComments, "Add Comment");
        click(SPPServiceTicketPage.btnAddComments, "Add Comment");
    }
    /**
     * param ::String comments
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceComments
     * description :: enterServiceComments
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String enterServiceComments(String comments) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.txtComments, "Service comments");
        type(SPPServiceTicketPage.txtComments, comments, "Service comments");
        return comments;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyAndClickAddCommentSaveBtn
     * description :: verifyAndClickAddCommentSaveBtn
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void verifyAndClickAddCommentSaveBtn() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnCommnetsSave, "Add comment Dialog Box is present");
        click(SPPServiceTicketPage.btnCommnetsSave, "Save");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickServiceSaveBtn
     * description :: clickServiceSaveBtn
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickServiceSaveBtn() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnServiceSave, "Service Save Button");
        click(SPPServiceTicketPage.btnServiceSave, "Service Save Button");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyConfMsgAndClickYes
     * description :: verifyConfMsgAndClickYes
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void verifyConfMsgAndClickYes() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.msgServiceSaveConfirmationMsg, "comments save confirmation message");
        click(SPPServiceTicketPage.btnServiceCnfmYesBtn, "Yes");
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyConfMsgAfterClickingYesAndClickContinue
     * description :: verifyConfMsgAfterClickingYesAndClickContinue
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void verifyConfMsgAfterClickingYesAndClickContinue() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.msgServiceTicketSavedConfMsg, "Msg Confirmation after clicking yes");
        click(SPPServiceTicketPage.btnCommnetsContinue, "Continue");
    }

    /**
     * param ::NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyServiceTicketWindowIsInView
     * description :: verifyServiceTicketWindowIsInView
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public Boolean verifyServiceTicketWindowIsInView() throws Throwable {
        boolean serviceTicketView=waitForVisibilityOfElement(SPPServiceTicketPage.serviceTicketsWindow, "Service Ticket Window");
        Thread.sleep(3000);
        return serviceTicketView;
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyServiceTicketHeaderServiceID
     * description :: verifyServiceTicketHeaderServiceID
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String verifyServiceTicketHeaderServiceID() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceID, "Service Ticket Service ID on header");
        String serviceFacility=getText(SPPServiceTicketPage.lblServiceID, "Service Ticket Service ID on header");
        return serviceFacility;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyServiceTicketHeaderCost
     * description :: verifyServiceTicketHeaderCost
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String verifyServiceTicketHeaderCost() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceTotalCost, "Service Ticket Total cost on header");
        String serviceCost=getText(SPPServiceTicketPage.lblServiceTotalCost, "Service Ticket Total cost on header");
        return serviceCost;
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyServiceTicketHeaderCallId
     * description :: verifyServiceTicketHeaderCallId
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String verifyServiceTicketHeaderCallId() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceFacilityCallId, "Service Ticket Call Id on header");
        String serviceCallID=getText(SPPServiceTicketPage.lblServiceFacilityCallId, "Service Ticket Call Id on header");
        return serviceCallID;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyServiceTicketHeaderFacility
     * description :: verifyServiceTicketHeaderFacility
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String verifyServiceTicketHeaderFacility() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceFacility, "Service Ticket Facility on header");
        String serviceFacility=getText(SPPServiceTicketPage.lblServiceFacility, "Service Ticket facility on header");
        return serviceFacility;
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyServiceTicketHeaderStatus
     * description :: verifyServiceTicketHeaderStatus
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String verifyServiceTicketHeaderStatus() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceIDStatus, "Service Ticket Status on header");
        String serviceStatus=getText(SPPServiceTicketPage.lblServiceIDStatus, "Service Ticket Status on header");
        return serviceStatus;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyServiceMemberFirstNameIsNotEditable
     * description :: verifyServiceMemberFirstNameIsNotEditable
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String verifyServiceMemberFirstNameIsNotEditable(String memname) throws Throwable {

        String aftername=enterMembershipNumber(memname);
        return aftername;




        /*waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceIDStatus, "Service Ticket Status on header");
        String serviceStatus=getText(SPPServiceTicketPage.lblServiceIDStatus, "Service Ticket Status on header");
        return serviceStatus;*/
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickPaymentBtn
     * description :: clickPaymentBtn
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public void clickPaymentBtn() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnServicePaymentBtn, "Payment");
        click(SPPServiceTicketPage.btnServicePaymentBtn, "Payment");
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: VerifyServiceTotalMileage
     * description :: VerifyServiceTotalMileage
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String VerifyServiceTotalMileage() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblTotalMileage, "Verify Total Mileage");
        String totMileage=getText(SPPServiceTicketPage.lblTotalMileage, "Total Mileage");
        return totMileage;

    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: VerifyServiceCharge
     * description :: VerifyServiceCharge
     * date :: 7-Mar-2018
     * author :: Varun
     */
    public String VerifyServiceCharge() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblServiceCharge, " verify Service Charge");
        String serviecCharge=getAttributeByValue(SPPServiceTicketPage.lblServiceCharge, "Service Charge");
        return serviecCharge;

    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickPaymentCloseBtn
     * description :: clickPaymentCloseBtn
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public void clickPaymentCloseBtn() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnPaymentCloseBtn, "Close");
        click(SPPServiceTicketPage.btnPaymentCloseBtn, "Close");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickPrint
     * description :: clickPrint
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public void clickPrint() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnPrint, "Print");
        click(SPPServiceTicketPage.btnPrint, "Print");
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyPreviewPrintBtn
     * description :: verifyPreviewPrintBtn
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public Boolean verifyPreviewPrintBtn() throws Throwable {
        boolean previewPrint=waitForVisibilityOfElement(SPPServiceTicketPage.btnPrintPreviewPrintBtn, "Print preview Print");
        return previewPrint;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickServiceWindowCrossIcon
     * description :: clickServiceWindowCrossIcon
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public void clickServiceWindowCrossIcon() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.iconServiceWindowCrossIcon, "Service window cross icon");
        click(SPPServiceTicketPage.iconServiceWindowCrossIcon, "Service window cross icon");
    }
    /**
     * param ::String ticketnumber
     * return ::String
     * throws :: throwable
     * methodName :: enterServiceTicketNymberForSearch
     * description :: enterServiceTicketNymberForSearch
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String enterServiceTicketNymberForSearch(String ticketnumber) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.fieldTicketSearch, "Service Ticket number");
        type(SPPServiceTicketPage.fieldTicketSearch, ticketnumber,"Service Ticket number");
        return ticketnumber;
    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickServiceSearchFindBtn
     * description :: clickServiceSearchFindBtn
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public void clickServiceSearchFindBtn() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnServiceFindBtn, "Find");
        click(SPPServiceTicketPage.btnServiceFindBtn, "Find");
    }
    /**
     * param ::String tickNumber
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyServiceTicketOnSearching
     * description :: verifyServiceTicketOnSearching
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public Boolean verifyServiceTicketOnSearching(String tickNumber) throws Throwable {
        boolean searchedTicket=waitForVisibilityOfElement(SPPServiceTicketPage.getServiceTicketFromResult(tickNumber), "<b>verify searched ticket number");
        return searchedTicket;

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickTowTab
     * description :: clickTowTab
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public void clickTowTab() throws Throwable {
        click(SPPServiceTicketPage.towTab, "Tow Tab");

    }
    /**
     * param ::String Location
     * return ::String
     * throws :: throwable
     * methodName :: enterLocationFieldInTowLocation
     * description :: enterLocationFieldInTowLocation
     * date :: 9-Mar-2018
     * author :: Varun
     */
    public String enterLocationFieldInTowLocation(String Location) throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.towLocationFieldBelow, "location field");
        type(SPPServiceTicketPage.towLocationFieldBelow, Location, "location field");
        Thread.sleep(3000);
        return Location;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickTowTabVerifyItBtn
     * description :: clickTowTabVerifyItBtn
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public void clickTowTabVerifyItBtn() throws Throwable {

        click(SPPServiceTicketPage.lblTowTabAddressVerified, " Address verified lable");
        waitForVisibilityOfElement(SPPServiceTicketPage.btnTowVerifyIt, "Verify it");
        click(SPPServiceTicketPage.btnTowVerifyIt, "Verify It");
        Thread.sleep(5000);

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickServiceNewButton
     * description :: clickServiceNewButton
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public void clickServiceNewButton() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.btnServiceNew, "New");
        click(SPPServiceTicketPage.btnServiceNew, "New");


    }


    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetMemberNameInPreview
     * description :: verify And Get Member Name In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetMemberNameInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblMembernamePreview, "Preview Member name");
        String fname = getText(SPPServiceTicketPage.lblMembernamePreview, "Preview Member name");
        return fname;
    }


    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetBreakdownLocInPreview
     * description :: verifyAndGetBreakdownLoc In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetBreakdownLocInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblBreakDownLocPreview, "Preview Breakdown Location");
        String brkDwnLoc = getText(SPPServiceTicketPage.lblBreakDownLocPreview, "Preview Breakdown Location");
        return brkDwnLoc;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetLocLocInPreview
     * description :: verifyAndGetLocLocInPreview In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetTowLocInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblTowLocationPreview, "Preview Tow Location");
        String TowLoc = getText(SPPServiceTicketPage.lblTowLocationPreview, "Preview Tow Location");
        return TowLoc;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetVehicleYearInPreview
     * description :: verifyAndGetVehicleYearInPreview In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetVehicleYearInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblVehicleYearPreview, "Preview Vehicle Year");
        String vehicleYr = getText(SPPServiceTicketPage.lblVehicleYearPreview, "Preview Vehicle year");
        return vehicleYr;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetVehicleMakeInPreview
     * description :: verifyAndGetVehicleMakeInPreview In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetVehicleMakeInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblVehiclemakePreview, "Preview Vehicle Make");
        String vehiclemake = getText(SPPServiceTicketPage.lblVehiclemakePreview, "Preview Vehicle Make");
        return vehiclemake;
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetVehicleModelInPreview
     * description :: verifyAndGetVehicleModelInPreview In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetVehicleModelInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblVehiclemodelPreview, "Preview Vehicle Model");
        String vehicleModel = getText(SPPServiceTicketPage.lblVehiclemodelPreview, "Preview Vehicle Model");
        return vehicleModel;
    }

    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetOnLocInPreview
     * description :: verifyAndGetOnLocInPreview In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetOnLocInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblOnLocationPreview, "Preview On location");
        String onLoc = getText(SPPServiceTicketPage.lblOnLocationPreview, "Preview On Location");
        return onLoc;
    }
    /**
     * param ::NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyAndGetTotalCostInPreview
     * description :: verifyAndGetTotalCostInPreview In Preview on clicking print button from service page
     * date :: 10-Mar-2018
     * author :: Varun
     */
    public String verifyAndGetTotalCostInPreview() throws Throwable {
        waitForVisibilityOfElement(SPPServiceTicketPage.lblTotalCostPreview, "Preview total Cost");
        String totalCost = getText(SPPServiceTicketPage.lblTotalCostPreview, "Preview Total Cost");
        return totalCost;
    }

    /**
     * param ::NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyMemberNoCallsMsgAndClickOkBtn
     * description :: verifyAndGetverifyMemberNoCallsMsgAndClickOkBtn when member is not having calls remaining
     * date :: 12-Mar-2018
     * author :: Varun
     */
    public Boolean verifyMemberNoCallsMsg() throws Throwable {
        boolean noMoreCallsRemMsg=isVisibleOnly(SPPServiceTicketPage.alertMsgNoMoreRemainingCalls, "Member having no more calls remaing alert box");
Thread.sleep(3000);
        return noMoreCallsRemMsg;
    }
    /**
     * param ::NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyMemberNoCallsMsgAndClickOkBtn
     * description :: verifyMemberNoCallsMsgAndClickOkBtn when member is not having calls remaining
     * date :: 12-Mar-2018
     * author :: Varun
     */
    public void verifyMemberNoCallsMsgAndClickOkBtn() throws Throwable {
       click(SPPServiceTicketPage.alertMsgNoMoreRemainingCallsOKBtn,"OK");

    }
    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDiscardBtn
     * description :: clickDiscardBtn when member is not having calls remaining
     * date :: 12-Mar-2018
     * author :: Varun
     */
    public void clickDiscardBtn() throws Throwable {
        click(SPPServiceTicketPage.btnDiscard,"Discard");
        Thread.sleep(3000);
    }

    /**
     * param ::NA
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyDuplicateServiceScreen
     * description :: verifyDuplicateServiceScreen when clicked on service saved button
     * date :: 12-Mar-2018
     * author :: Varun
     */
    public Boolean verifyDuplicateServiceScreen() throws Throwable {
        boolean dupServiceScreen=isVisibleOnly(SPPServiceTicketPage.serviceDuplicateScreen, "Duplicate service screen");
        Thread.sleep(3000);
        return dupServiceScreen;
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: clickDiscardYesBtn
     * description :: clickDiscardBtn when member is not having calls remaining
     * date :: 12-Mar-2018
     * author :: Varun
     */
    public void clickDiscardYesBtn() throws Throwable {
        click(SPPServiceTicketPage.discardAlertMsgYesBtn,"Discard");
        Thread.sleep(3000);
    }
}
