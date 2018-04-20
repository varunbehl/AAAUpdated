package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e002222 on 09-02-2018.
 */
public class DITruckLoadDeafultViewLib extends ActionEngine {


    public List<WebElement> allFacility;
    List<WebElement> facilityList = new ArrayList<WebElement>();
    public String facilityFromList;
    Boolean FacilityFlag;
    List<WebElement> commentsList = new ArrayList<WebElement>();
    public List<WebElement> allTruckIds,allCrossIcons;
    public String callIdFromList;
    Boolean truckIDFlag;
    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyCommentColmnOnDefaultTruckLoad
     * description :: verify Comment Colmn On Default Truck Load
     * date :: 06-feb-2018
     * author ::Varun
     */
    public Boolean verifyCommentColmnOnDefaultTruckLoad() throws Throwable
    {

        Boolean verifyCommentCol=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblCommentColmnOnDefaultTruckLoad, "Comment Column in Truck default view");
        return verifyCommentCol;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: rightClickActiveDriverOnDefaultTruckLoad
     * description ::right Click on Active Driver On Default Truck Load Page
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void rightClickActiveDriverOnDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.activeTruckRowOnDefaultTruckLoad, "Active truck driver");
        rightClick(DITruckLoadDefaultViewPage.activeTruckRowOnDefaultTruckLoad, "Right click on active truck driver");
        Thread.sleep(5000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverOnDefaultTruckLoad
     * description ::mouse Hover On Driver Option Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void mouseHoverOnDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnDriverOption, "Driver option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnDriverOption, "Driver option");
        Thread.sleep(3000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickSetDriverCommentDefaultTruckLoad
     * description ::click Set Driver Comment on Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void clickSetDriverCommentDefaultTruckLoad() throws Throwable
    {

        //mouseHover(DITruckLoadDefaultViewPage.lblSetDriverComment, "Set Driver comments");
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblSetDriverComment, "Set Driver comments");
        click(DITruckLoadDefaultViewPage.lblSetDriverComment, "Set Driver comments");
        Thread.sleep(5000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: typeDrivercomment
     * description ::type Driver comment on Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void typeDrivercomment(String comment) throws Throwable
    {



        type(DITruckLoadDefaultViewPage.txtCommentField, comment, "Enter driver Comment");
        Thread.sleep(5000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickDrivercommentSaveBtn
     * description :: click Driver comment Save Btn on Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void clickDrivercommentSaveBtn() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.btnSaveDriverCommentWindow, "Save Button");
        click(DITruckLoadDefaultViewPage.btnSaveDriverCommentWindow, "Save Button");
        Thread.sleep(5000);
    }
    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyDrivercommentIcon
     * description :: verify Driver comment Icon on Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public Boolean verifyDrivercommentIcon() throws Throwable
    {


        Boolean verifyCommentIcon=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.iconDriverComment, "Comment Icon");
        return verifyCommentIcon;

    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyDrivercommentTxt
     * description ::verify Driver comment under comment column on Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public String verifyDrivercommentTxt() throws Throwable
    {


        String driverComment=getText(DITruckLoadDefaultViewPage.txtCommentAdded, "Comment added");
        return driverComment;

    }

    /**
     * param ::
     * return :: String
     * throws :: throwable
     * methodName :: verifyCommentIconHoverTxt
     * description ::verify Comment Icon Hover Txt on Default Truck Load
     * date :: 12-feb-2018
     * author ::Varun
     */
    public String verifyCommentIconHoverTxt() throws Throwable
    {


        String IconHoverComment=getAttributeValue(DITruckLoadDefaultViewPage.iconDriverComment, "title");
        return IconHoverComment;

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickClearDriverCommentDefaultTruckLoad
     * description ::click Clear Driver Comment on Default TruckLoad
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void clickClearDriverCommentDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblClearDriverComment, "Clear Driver comments");
        click(DITruckLoadDefaultViewPage.lblClearDriverComment, "Clear Driver comments");
        Thread.sleep(10000);
    }

    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyNoDrivercommentIcon
     * description ::verify No Driver comment Icon is there on Default Truck Load after clearing the comment
     * date :: 12-feb-2018
     * author ::Varun
     */
    public Boolean verifyNoDrivercommentIcon() throws Throwable
    {


        Boolean verifyNoCommentIcon=waitForInVisibilityOfElement(DITruckLoadDefaultViewPage.iconDriverComment, "Comment Icon");
        return verifyNoCommentIcon;

    }





    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyActiveTruckOnDefaultTruckLoad
     * description ::verify Active Truck On Default Truck Load
     * date :: 13-feb-2018
     * author ::Varun
     */
    public Boolean verifyActiveTruckOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyActiveTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.activeTruckRowOnDefaultTruckLoad, "Verify Active trucks");
        return verifyActiveTruck;


    }
    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyInActiveTruckOnDefaultTruckLoad
     * description ::verify InActive Truck On DefaultTruckLoad
     * date :: 13-feb-2018
     * author ::Varun
     */
    public Boolean verifyInActiveTruckOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyInActiveTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inActiveTruckRowOnDefaultTruckLoad, "Verify InActive trucks");
        return verifyInActiveTruck;


    }





    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickActiveBtnOnDefaultTruckLoad
     * description ::click Active Btn On DefaultTruckLoad
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void clickActiveBtnOnDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.btnActive, "Active Button");
        click(DITruckLoadDefaultViewPage.btnActive, "Active Button");
        Thread.sleep(5000);

    }

    /**
     * param ::
     * return :: Boolean
     * throws :: throwable
     * methodName :: verifyAllActiveTrucksOnDefaultTruckLoad
     * description ::verify All Active Trucks On Default Truck Load
     * date :: 13-feb-2018
     * author ::Varun
     */
    public Boolean verifyAllActiveTrucksOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyActiveTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.AllActiveTruckRowOnDefaultTruckLoad, "All active trucks");
        return verifyActiveTruck;


    }

    /**
     * param :: String
     * return ::
     * throws :: throwable
     * methodName :: rightClickActiveSpecificTruckOnDefaultTruckLoad
     * description ::right Click on Specific Active Truck ID On Default Truck Load
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void rightClickActiveSpecificTruckOnDefaultTruckLoad(String TRUCKID) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.ActiveTruckID(TRUCKID), "Active truck driver");
        rightClick(DITruckLoadDefaultViewPage.ActiveTruckID(TRUCKID), "Right click on active truck driver");
        Thread.sleep(5000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickSetTruckToInactive
     * description ::click Set Truck To Inactive On Default Truck Load Page
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void clickSetTruckToInactive() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblSetTruckInactive, "Set truck to inactive");
        click(DITruckLoadDefaultViewPage.lblSetTruckInactive, "Set truck to inactive");
        Thread.sleep(5000);

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickSetTruckToActive
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void clickSetTruckToActive() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblSetTruckActive, "Set truck to Active");
        click(DITruckLoadDefaultViewPage.lblSetTruckActive, "Set truck to Active");
        Thread.sleep(5000);

    }

    /**
     * param :: String
     * return ::
     * throws :: throwable
     * methodName :: rightClickInActiveSpecificTruckOnDefaultTruckLoad
     * description ::click Set Truck To Active On Default Truck Load Page
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void rightClickInActiveSpecificTruckOnDefaultTruckLoad(String TRUCKID) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.InActiveTruckID(TRUCKID), "In active truck driver");
        rightClick(DITruckLoadDefaultViewPage.InActiveTruckID(TRUCKID), "Right click on In active truck driver");
        Thread.sleep(5000);
    }


    /**
     * param :: String
     * return :: Boolean
     * throws :: throwable
     * methodName :: verifyIconChangeToInactive
     * description ::verify Icon Change To Inactive on default truck view page
     * date :: 14-feb-2018
     * author ::Varun
     */
    public Boolean verifyIconChangeToInactive(String TRUCKID) throws Throwable
    {


        Boolean verifyIconToInactive=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyInActiveIconOfTruckID(TRUCKID), "Active status change to Inactive");
        return verifyIconToInactive;

    }
    /**
     * param :: String
     * return :: Boolean
     * throws :: throwable
     * methodName :: verifyIconChangeToActive
     * description ::verify Icon Change To Active on default truck view page
     * date :: 14-feb-2018
     * author ::Varun
     */
    public Boolean verifyIconChangeToActive(String TRUCKID) throws Throwable
    {


        Boolean verifyIconToActive=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyActiveIconOfTruckID(TRUCKID), "In Active status change to Active");
        return verifyIconToActive;

    }

    /**
     * param :: String
     * return ::
     * throws :: throwable
     * methodName :: clickOnFacilityOnDefaultTruck
     * description ::click On Facility On Default Truck page
     * date ::
     * author ::Cigniti
     */
    public void clickOnFacilityOnDefaultTruck(String facility)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
        click(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
    }
    /**
     * param :: String
     * return ::
     * throws :: throwable
     * methodName :: rightClickOnCallIDOnTruckLoad
     * description ::Right click On Call ID On Default Truck Load page
     * date ::
     * author ::Cigniti
     */
    public void rightClickOnCallIDOnTruckLoad(String CallIdAndDate)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectCallIDOnTruckLoad(CallIdAndDate),"Right Click On Call Id in truck Load");
        rightClick(DITruckLoadDefaultViewPage.selectCallIDOnTruckLoad(CallIdAndDate),"Right Click On Call Id in truck Load");
        Thread.sleep(5000);
    }

    /**
     * param :: String
     * return :: String
     * throws :: throwable
     * methodName :: getTextFromLinkRemoveFavoriteCall
     * description ::get Text From Link Remove Favorite Call
     * date ::
     * author ::Cigniti
     */
    public String getTextFromLinkRemoveFavoriteCall(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkRemoveCallFavorite(callIDAndDate),"Text From Remove From Favorite Link");
        String textRemoveFavorite = getText(DITruckLoadDefaultViewPage.lnkRemoveCallFavorite(callIDAndDate),"Text From Remove From Favorite Link");
        return textRemoveFavorite;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyandGetAllCallsCounter
     * description ::verify and Get All Calls Counter on default truck view page
     * date :: 14-feb-2018
     * author ::Varun
     */
    public String verifyandGetAllCallsCounter() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.txtAllCallsCounter, "All call counter");
        String allCallsCounter=getText(DITruckLoadDefaultViewPage.txtAllCallsCounter,"All calls counter");
        return allCallsCounter;

    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyandGetUnassignedCallsCounter
     * description ::verify and Get Unassigned Calls Counter on default truck view page
     * date :: 14-feb-2018
     * author ::Varun
     */
    public String verifyandGetUnassignedCallsCounter() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.txtUnassignedCallsCounter, "Unassigned call counter");
        String unassignedCounter=getText(DITruckLoadDefaultViewPage.txtUnassignedCallsCounter,"Unassigned calls counter");
        return unassignedCounter;

    }


    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickUnassignedCallsGrid
     * description ::click Unassigned Calls Grid on default truck view page
     * date :: 14-feb-2018
     * author ::Varun
     */
    public void clickUnassignedCallsGrid() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblUnassignedCallsGid, "Unassigned call grid");
        click(DITruckLoadDefaultViewPage.lblUnassignedCallsGid, "Unassigned call grid");


    }

    //NIdhi
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckAtoInactive
     * description ::set TruckID A to Inactive on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void setTruckAtoInactive() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckA, "Truck A");
        rightClick(DITruckLoadDefaultViewPage.truckA,"Click on truck A");
        verifyTruckAAndsettoInactive();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckAsettoInactive
     * description ::verify Truck A And set to Inactive on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckAAndsettoInactive() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.setToInActive, "Truck A"))
        {
            click(DITruckLoadDefaultViewPage.setToInActive,"Truck set to Inactive");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckAtoInactive
     * description ::set TruckID B to Active on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void setTruckBtoActive() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
        verifyTruckBAndsettoActive();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoActive
     * description ::verify Truck B And set to Active on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBAndsettoActive() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.setToActive, "Truck B"))
        {
            click(DITruckLoadDefaultViewPage.setToActive,"Truck set to Active");
        }
    }
   /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckAsettoActive
     * description ::verify Truck set to Active on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void verifyTrucksettoActive() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.setToInActive, "Truck A"))
        {
            reporter.SuccessReport("Successfully changed from ","Active to Inactive automatically");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckAsettoActive
     * description ::click On Truck ID B on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void clickOnTruckB() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        Thread.sleep(3000);
        click(DITruckLoadDefaultViewPage.truckB, "Truck B");
        Thread.sleep(3000);

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getUpdatedStatus
     * description ::get Updated Status on default truck view page
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void getUpdatedStatus() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callStatus, "Call");
        click(DITruckLoadDefaultViewPage.truckB, "Truck B");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckBToOutOfVehicle
     * description ::set Truck B To Out Of Vehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void setTruckBToOutOfVehicle() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
        verifyTruckBAndsettoOutOfVehicle();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckBToAddComment
     * description ::click On Truck B To Add Comment on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void clickOnTruckBToAddComment() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckBToInVehicle
     * description ::set Truck B To In Vehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void setTruckBToInVehicle() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
        verifyTruckBAndsettoInVehicle();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoInVehicle
     * description ::verify Truck B And set to InVehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBAndsettoInVehicle() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        Thread.sleep(3000);
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inVehicle, "out of vehicle"))
        {
            click(DITruckLoadDefaultViewPage.inVehicle,"out of vehicle");
            Thread.sleep(2000);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoOutOfVehicle
     * description ::verify Truck B And set to OutOfVehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBAndsettoOutOfVehicle() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        Thread.sleep(3000);
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.outOfVehicle, "out of vehicle"))
        {
            click(DITruckLoadDefaultViewPage.outOfVehicle,"out of vehicle");
            Thread.sleep(2000);
            click(DITruckLoadDefaultViewPage.btnSaveOnOutOfVehiclePopup,"out of vehicle");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBStatusOutOfVehicle
     * description ::verify Truck B Status Out Of Vehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBStatusOutOfVehicle() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.outOfVehicleStatus, "vehicle status")) {

            reporter.SuccessReport("The driver status for truck B should have automatically changed from ","In-vehicle to Out-of-Vehicle");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBStatusInVehicle
     * description ::verify Truck B Status InVehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBStatusInVehicle() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inVehicleStatus, "vehicle status")) {

            reporter.SuccessReport("The driver status for truck B should have automatically changed from ","Out-of-Vehicle  to In-Vehicle");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDriverComment
     * description ::verify Driver Comment on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyDriverComment() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon")) {

            reporter.SuccessReport("The comment icon successfully","appeared on the driver ");
            mouseHover(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon");
            Thread.sleep(2000);
            getText(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDriverCommentClear
     * description ::verify Driver Comment Clear on default truck view page
     * date :: 20-feb-2018
     * author ::Nidhi
     */
    public void verifyDriverCommentClear() throws Throwable {
        if (!isVisibleOnly(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon")) {

            reporter.SuccessReport("The comment icon successfully","removed for  the driver ");
        }
    }

    /**
     * param :: String, String
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyCallIdOnTruckDefaultViewPage
     * description :: verify CallId On Truck Default View Page
     * date :: 15-feb-2018
     * author ::Varun
     */
    public Boolean verifyCallIdOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{
        Boolean callDisplayOnTruckDefault=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        return callDisplayOnTruckDefault;
    }
    /**
     * param ::String, String
     * return ::void
     * throws :: throwable
     * methodName :: rightClickCallIdOnTruckDefaultViewPage
     * description ::right Click on CallId On Truck Default View Page
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void rightClickCallIdOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{

        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        rightClick(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate), "CallId On Truck default view page");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverOnCallStatusDefaultTruckLoad
     * description ::mouseHover On Call Status on Default Truck Load
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void mouseHoverOnCallStatusDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkCallStatus, "Call status");
        mouseHover(DITruckLoadDefaultViewPage.lnkCallStatus, "Call status");
        Thread.sleep(2000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverOnAssignStatusDefaultTruckLoad
     * description :: mouse Hover On Assign Status Default Truck Load
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void mouseHoverOnAssignStatusDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnlAssignCallStatus, "Assign Call status");
        mouseHover(DITruckLoadDefaultViewPage.lnlAssignCallStatus, "Assign Call status");
        Thread.sleep(2000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnAssignStatusTruckDefaultTruckLoad
     * description :: click On Assign Status on Truck Default Truck Load
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void clickOnAssignStatusTruckDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkOfFirstTruck, "Select truck");
        click(DITruckLoadDefaultViewPage.lnkOfFirstTruck, "Select truck");
        Thread.sleep(2000);
    }

    /**
     * param ::String, String
     * return :: String
     * throws :: throwable
     * methodName :: getTruckIDOfCallIDDefaultTruckLoad
     * description ::get Truck ID Of CallID Default Truck Load page
     * date :: 15-feb-2018
     * author ::Varun
     */
    public String getTruckIDOfCallIDDefaultTruckLoad(String callID, String calldate) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckIDFromCallDefaultView(callID, calldate), "Truck ID");
        String truckID=getText(DITruckLoadDefaultViewPage.truckIDFromCallDefaultView(callID, calldate), "Truck ID");
        Thread.sleep(2000);
        return truckID;
    }

    /**
     * param ::String
     * return ::
     * throws :: throwable
     * methodName :: clickTruckIDOfCallID
     * description ::click on Specific Truck ID Of CallID section for filtering the calls below of default truck view page
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void clickTruckIDOfCallID(String truckID) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckIDOnTruckView(truckID), "Truck ID");
        click(DITruckLoadDefaultViewPage.truckIDOnTruckView(truckID), "Truck ID");
                Thread.sleep(2000);

    }
    /**
     * param :: String
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverToCommentsOnTruckLoad
     * description :: mouse Hover To Comments On Truck Load
     * date ::
     * author ::Cigniti
     */
    public void mouseHoverToCommentsOnTruckLoad(String callIdAndDate)throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkCommentsInTruckLoadContextMenu(callIdAndDate),"Comments In truck Load Context Menu");
        mouseHover(DITruckLoadDefaultViewPage.lnkCommentsInTruckLoadContextMenu(callIdAndDate),"Move Mouse To Comments In truck Load Context Menu");
        Thread.sleep(3000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverOntoAutoComment
     * description :: mouse Hover On to Auto Comment
     * date ::
     * author ::Cigniti
     */
    public void mouseHoverOntoAutoComment()throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblAutocomment,"Auto Comments In truck Load Context Menu");
        mouseHover(DITruckLoadDefaultViewPage.lblAutocomment,"Move Mouse To Auto Comments In truck Load Context Menu");
        Thread.sleep(3000);
    }

    /**
     * param :: String
     * return ::
     * throws :: throwable
     * methodName :: selectComment
     * description :: select Comment
     * date ::
     * author ::Cigniti
     */
    public void selectComment(String autoComment)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectAutoComment(autoComment),"Auto Comment ");
        click(DITruckLoadDefaultViewPage.selectAutoComment(autoComment),"Auto Comment ");
    }
    /**
     * param ::
     * return :: List<String>
     * throws :: throwable
     * methodName :: getCommentsListFromTruckLoad
     * description :: get Comments List From Truck Load
     * date ::
     * author ::Cigniti
     */
    public List<String> getCommentsListFromTruckLoad()throws  Throwable{
        List<String> commentList = new ArrayList<>();
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.listOfComments,"Comments List In Truck Load");
        commentsList = getWebElementList(DITruckLoadDefaultViewPage.listOfComments,"get Comments List From TruckLoad");
        if(commentsList!=null){
            for(int i=0;i<commentsList.size();i++){
                String comments = commentsList.get(i).getText();
                commentList.add(comments);
            }
        }
        return commentList;
    }





    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: verifyAllTruckIDsOfCalls
     * description ::verify All TruckIDs Of Calls after filtering with specific Truck ID
     * date :: 10-feb-2018
     * Updated date :: 29-Jan-2018
     * author ::Varun
     */
    public void verifyAllTruckIDsOfCalls(String TruckID) throws Throwable {
        boolean verifySearchResults = !isVisibleOnly(DITruckLoadDefaultViewPage.listOfTruckIDs, "Truck IDs in Truck calls window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found");
        }
        else{
            allTruckIds = getWebElementList(DITruckLoadDefaultViewPage.listOfTruckIDs, "Truck IDs in Truck calls window");

            for (int i = 0; i < allTruckIds.size(); i++) {
                callIdFromList = allTruckIds.get(i).getText();
                //String callIdFromExcel = TruckID;
                if (callIdFromList.contains(TruckID)) {
                    truckIDFlag=true;

                }
                else {
                    truckIDFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(truckIDFlag, "Call Id " + TruckID + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param :: String, String
     * return ::void
     * throws :: throwable
     * methodName :: clickCallIdOnTruckDefaultViewPage
     * description :: click CallId On Truck Default View Page
     * date :: 18-feb-2018
     * author ::Varun
     */
    public void clickCallIdOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{

        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        click(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSPPdefaultTruckView
     * description ::click default TruckView page after login with SPP user
     * date :: 18-feb-2018
     * author ::Varun
     */
    public void clickSPPdefaultTruckView()throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.sppTruckDefaultView,"Default truckload");
        click(DITruckLoadDefaultViewPage.sppTruckDefaultView,"Default truckload");
    }


    /**
     * param ::String, String
     * return ::void
     * throws :: throwable
     * methodName :: doubleClickOnCallIdOnTruckWindow
     * description ::double Click On specific CallId OnTruckWindow
     * date :: 18-feb-2018
     * author ::Varun
     */

    public void doubleClickOnCallIdOnTruckWindow(String callID, String calldate)throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"Click On CallId Truck Calls");
        mouseJSDoubleClick(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"Click On CallId On Tuck calls");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: DbClickOnFacilityOnDefaultTruck
     * description :: DbClick On Facility On Default Truck view page
     * date :: 18-feb-2018
     * author ::Sachin
     */
    public void DbClickOnFacilityOnDefaultTruck(String facility)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
        mouseDoubleClick(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
        Thread.sleep(3000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickAllCrossIconOfCallIdofFacilityWindow
     * description :: click All Cross Icons Of CallId of Facility Window on default truck view page
     * date :: 19-feb-2018
     * author ::Varun
     */

    public void clickAllCrossIconOfCallIdofFacilityWindow()throws Throwable{
        boolean verifySearchResults = isVisibleOnly(DITruckLoadDefaultViewPage.facilityCrossIcon, "Facility cross Icon");
        if (verifySearchResults) {
            allCrossIcons=getWebElementList(DITruckLoadDefaultViewPage.facilityCrossIcon, "Facility cross Icon");

            for (int i = 0; i < allCrossIcons.size(); i++) {

                click(DITruckLoadDefaultViewPage.facilityCrossIcon, "Click all cross facility icons");

            }
        }



    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickLayersOnRightPane
     * description :: click Layers On Right Pane of MCD window
     * date :: 20-feb-2018
     * author ::Varun
     */
    public void clickLayersOnRightPane()throws Throwable{
        boolean verifySearchResults = isVisibleOnly(DITruckLoadDefaultViewPage.layersPane, "Layers Pane on right side");
        if (verifySearchResults) {
            click(DITruckLoadDefaultViewPage.layersPane, "Click all cross facility icons");
        }

        Thread.sleep(3000);

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutModeInTruckLoadDefaultViewWindow
     * description :: This function clicks on Popped Out Mode in Truckload Default View window
     * date :: 2-Mar-2018
     * author ::Sachin
     */

public void clickOnPoppedOutModeInTruckLoadDefaultViewWindow()throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Truckload Default View Popped Out Mode");
        click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView, "Truckload Default View Popped Out Mode");
    }



    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyNoInActiveTruckOnDefaultTruckLoad
     * description ::verify No InActive Truck On DefaultTruckLoad
     * date :: 29-mar-2018
     * author ::Varun
     */
    public Boolean verifyNoInActiveTruckOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyInActiveTruck= isVisibleOnly(DITruckLoadDefaultViewPage.inActiveTruckRowOnDefaultTruckLoad, "Verify InActive trucks");

        return verifyInActiveTruck;


    }

    




    /**
     * param ::String facilityValue
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifySelectedFaciltyData
     * description ::verify if teh selected facility label displayed on op
     * date :: 29-mar-2018
     * author ::Varun
     */
    public String verifyAndgetTextSelectedFaciltyData(String facilityValue) throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyFaciltyDisplayed(facilityValue), "Verify Selected facility");
        String getFacilityText=getText(DITruckLoadDefaultViewPage.verifyFaciltyDisplayed(facilityValue), "Get value of selected facility");
        return getFacilityText;


    }

    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyNoInActiveTruckOnDefaultTruckLoad
     * description ::verify No InActive Truck On DefaultTruckLoad
     * date :: 120-mar-2018
     * author ::Varun
     */
    public String GetCallIDStatus(String CallID, String Date) throws Throwable
    {
        String  callStatus = getText(DITruckLoadDefaultViewPage.lblCallIdStatusInTruckCallsTable(CallID,Date),"CallId Status ").trim();
        return callStatus;
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnViewAllCalls
     * description :: This function clicks on View All calls
     * date :: 4-Apr-2018
     * author ::Sachin
     */

    public void clickOnViewAllCalls()throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblViewAllCalls, "View All Calls");
        click(DITruckLoadDefaultViewPage.lblViewAllCalls, "View All Calls");
    }

    /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnViewUnassignedCalls
     * description :: This function clicks on Unassigned Calls
     * date :: 4-Apr-2018
     * author ::Sachin
     */

    public void clickOnUnassignedCalls()throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblViewUnAssignedCalls, "Unassigned Calls");
        click(DITruckLoadDefaultViewPage.lblViewUnAssignedCalls, "Unassigned Calls");
    }

    /**
     * param ::String facilityValue
     * return ::Void
     * throws :: throwable
     * methodName :: Selectfacility
     * description ::select the facility
     * date :: 3 March-mar-2018
     * author ::Varun
     */
    public void Selectfacility(String facilityValue) throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectsssFacility(facilityValue), "Verify Selected facility");
        click(DITruckLoadDefaultViewPage.selectsssFacility(facilityValue), "Select facility");


    }
    /**
     * param ::
     * return ::int
     * throws :: throwable
     * methodName :: verifyAllfacilityDisplayed
     * description ::verify all the facilities are displayed
     * date :: 3 March-mar-2018
     * author ::Varun
     */
    public int verifyAllfacilityDisplayed() throws Throwable
    {
        //waitForInVisibilityOfElement(DITruckLoadDefaultViewPage.allfacilityDisplayedInTruckloadDefaultWindow, "Verify Selected facility");
        int allfacilityCount=getElementsSize(DITruckLoadDefaultViewPage.allfacilityDisplayedInTruckloadDefaultWindow);
        return allfacilityCount;

    }

    /**
     * param ::String facilityValue
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyremovedfacilityOnTruckLoadPage
     * description ::verify the removed queue should not be there in facility on truck defaul view page
     * date :: 3 March-2018
     * author ::Varun
     */
    public Boolean verifyremovedfacilityOnTruckLoadPage(String facilityValue) throws Throwable
    {
        Boolean verifyfacily= isVisibleOnly(DITruckLoadDefaultViewPage.selectsssFacility(facilityValue), "Verify Selected facility");
        return verifyfacily;


    }
    /**
     * param ::String facilityValue
     * return ::string
     * throws :: throwable
     * methodName :: getHeadingLabelTxtOfSelectedFaciltyData(String facilityValue) throws Throwable

     * description ::GetText of facility in heading on truck load page
     * date :: 4 March-2018
     * author ::Varun
     */
    public String getHeadingLabelTxtOfSelectedFaciltyData() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.txtTitleOfTruckCalls, "Verify Selected facility in heading");
        String getFacilityText=getText(DITruckLoadDefaultViewPage.txtTitleOfTruckCalls, "Get value of selected facility in heading");
        return getFacilityText;

   



    }
 /**
     * param :: NA
     * return ::NA
     * throws :: throwable
     * methodName :: clickOnViewUnassignedCalls
     * description :: This function clicks on Unassigned Calls
     * date :: 4-Apr-2018
     * author ::Sachin
     */

    public void clickOnCloseIcon()throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.iconClose, "Close Icon");
        click(DITruckLoadDefaultViewPage.iconClose, "Close Icon");
    }


    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyOutOfVehicleTruckOnDefaultTruckLoad
     * description ::verify out of vehicle Truck On Default Truck Load
     * date :: 05-apr-2018
     * author ::Nidhi
     */
    public Boolean verifyOutOfVehicleTruckOnDefaultTruckLoad(String TRUCKID) throws Throwable
    {
        Boolean verifyOVTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyOutOfVehicleIconOfTruckID(TRUCKID), "Verify out of vehicle trucks");
        return verifyOVTruck;


    }
    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyInVehicleTruckOnDefaultTruckLoad
     * description ::verify IN vehicle Truck On Default Truck Load
     * date :: 05-apr-2018
     * author ::Nidhi
     */
    public Boolean verifyInVehicleTruckOnDefaultTruckLoad(String TRUCKID) throws Throwable
    {
        Boolean verifyINTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyInVehicleIconOfTruckID(TRUCKID), "Verify in vehicle trucks");
        return verifyINTruck;


    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoInVehicle
     * description ::verify Truck B And set to InVehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void setTruckToInVehicle() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        Thread.sleep(3000);
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inVehicle, "out of vehicle"))
        {
            click(DITruckLoadDefaultViewPage.inVehicle,"out of vehicle");
            Thread.sleep(2000);
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoOutOfVehicle
     * description ::verify Truck B And set to OutOfVehicle on default truck view page
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void setTruckToOutOfVehicle() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        Thread.sleep(3000);
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.outOfVehicle, "out of vehicle"))
        {
            click(DITruckLoadDefaultViewPage.outOfVehicle,"out of vehicle");
            Thread.sleep(2000);
            click(DITruckLoadDefaultViewPage.btnSaveOnOutOfVehiclePopup,"out of vehicle");
        }
    }
    /**
     * param ::List<String>
     * return ::Boolean
     * throws :: throwable
     * methodName :: getFacilitiesListRelatedToSPMG
     * description ::To get Facilities List RelatedTo SPMG
     * date :: 06-April-2018
     * author ::Lakshmi
     */
    public List<String> getFacilitiesListRelatedToSPMG() throws Throwable
    {
        List<String> facilitiesList = new ArrayList<>();
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.allfacilityDisplayedInTruckloadDefaultWindow, "Facilities In truck Load");
        facilityList = getWebElementList(DITruckLoadDefaultViewPage.allfacilityDisplayedInTruckloadDefaultWindow,"getFacility list");
        for(int i=0;i<facilityList.size();i++){
            String facility = facilityList.get(i).getText();
            facilitiesList.add(facility);
        }

        return facilitiesList;

    }
    /**
     * param ::String callID, String calldate
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyNoCallIdDisplayedOnTruckDefaultViewPage
     * description ::verify No call id is there on Default Truck Load
     * date :: 5 march-2018
     * author ::Varun
     */
    public Boolean verifyNoCallIdDisplayedOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{
        Boolean callDisplayOnTruckDefault=isVisibleOnly(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        return callDisplayOnTruckDefault;
    }

    /**
     * param ::String callID, String calldate
     * return ::Boolean
     * throws :: throwable
     * methodName :: clickOnPopInButton
     * description ::To click On PopIn button On truck Load
     * date :: 5 march-2018
     * author ::Varun
     */
    public void clickOnPopInButton()throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.iconMinimizeTruckloadDefaultWindow,"PopIn The truck Load Window");
        click(DITruckLoadDefaultViewPage.iconMinimizeTruckloadDefaultWindow,"PopIn The truck Load Window");
    }
    public String  getMessageWindowName()throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblMessage,"Message window name");
        String messageWindowName = getText(DITruckLoadDefaultViewPage.lblMessage,"Message window name");
        return messageWindowName;
    }
    public String getTruckIDOnRecipientField()throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lbltruckIDOnRecipientfield,"Truck Id On recipient Field");
        String facilityAndTruckId = getText(DITruckLoadDefaultViewPage.lbltruckIDOnRecipientfield,"Truck Id On recipient Field");
        String truckId = facilityAndTruckId.substring(5,6);
        return truckId;
    }

}
