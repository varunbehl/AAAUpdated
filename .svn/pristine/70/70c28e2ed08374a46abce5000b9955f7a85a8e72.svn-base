package com.aaa.web.lib;
import java.util.ArrayList;
import java.util.List;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.DIProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.Keys.NUMPAD8;

public class DIProfileLib extends ActionEngine {
    List<WebElement> commentList = new ArrayList<WebElement>();
    List<WebElement> truckList = new ArrayList<WebElement>();

    List<WebElement> AvailabelSectionColumnNames = null;


    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectPriority
     * description :: To select priority from ID on Profile Window
     * date :: 29-12-2017
     * author ::madhukar
     */
    public void selectPriority(String priority) throws Throwable {
        mouseClick(DIProfilePage.drpdwnPriority, "Select priority");
        selectByValue(DIProfilePage.drpdwnPriority, priority, "Select priority");
        click(DIProfilePage.lblPriority,"Status Label");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectOrder
     * description :: select Order on profile Window
     * date :: NA
     * author ::Cigniti
     */
    public void selectOrder(String order) throws Throwable {
        mouseClick(DIProfilePage.drpdwnOrder, "Select order");
        selectByVisibleText(DIProfilePage.drpdwnOrder, order, "Select order");
        click(DIProfilePage.lblOrder,"Order Label");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: VerifyColumnsMatchingTextAreFilteredDownInAvailabelSection
     * description :: Verify Columns Matching Text Are Filtered Down In Availabel Section
     * date :: NA
     * author ::Cigniti
     */
    public void VerifyColumnsMatchingTextAreFilteredDownInAvailabelSection(String filteredtext) throws Throwable {

        String AvailabelSectionColumnNames = getText(DIProfilePage.lblAvailableSectionFilteredColNames, "Available Section Columns Names");

        if (AvailabelSectionColumnNames != null) {
            //for (int i = 0; i <= AvailabelSectionColumnNames.size() - 1; i++) {

                //String ColumNames = AvailabelSectionColumnNames.get(0).getText().toString();
                String colNamesAfterSplit[] = AvailabelSectionColumnNames.split("\\n");
                for (int i = 0; i <= colNamesAfterSplit.length - 1; i++) {

                    /*if (colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase())){
                        assertTrue(colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase()),"Columns matching the text is filtered down, Filtered Text is "+filteredtext+" Column Name is "+colNamesAfterSplit[i]);
                    }
                    else {
                        assertTrue(colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase()),"Columns matching the text is not filtered down, Filtered Text is "+filteredtext+" Column Name is "+colNamesAfterSplit[i]);
                    }*/
                	assertTrue(colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase()),"Columns matching the text is filtered down, Filtered Text is "+filteredtext+" Column Name is "+colNamesAfterSplit[i]);
                }
        }

    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: rightClickOnCallIdOnProfileWindow
     * description :: right Click On CallId On Profile Window
     * date :: 12-02-2018
     * author ::Cigniti
     */
    public void rightClickOnCallIdOnProfileWindow(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.statusOnPfofile(callIDAndDate),"Right Click On CallId On Profile Tab");
        dynamicWaitByLocator(DIProfilePage.statusOnPfofile(callIDAndDate),60);
        WebElement callidElement = driver.findElement(DIProfilePage.statusOnPfofile(callIDAndDate));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", callidElement);
        rightClick(DIProfilePage.statusOnPfofile(callIDAndDate),"Right Click On CallId On Profile Tab");
        Thread.sleep(5000);
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddToFavorites
     * description :: click On Add To Favorites On Profile Window
     * date :: 12-02-2018
     * author ::Cigniti
     */
    public void clickOnAddToFavorites(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Add To Favorites ");
        click(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Add To Favorites ");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getRGNFromProfileWindow(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.getRGNFromProfileWindow(callIDAndDate),"Get RGN Fro Profile");
        String rgn = getText(DIProfilePage.getRGNFromProfileWindow(callIDAndDate),"Get RGN Fro Profile");
        return rgn;
    }
    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveFromFavorites
     * description ::click On Remove From Favorites On Profile Window
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void clickOnRemoveFromFavorites(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Remove From Favorites ");
        click(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Remove From Favorites");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: setFavoriteCallFromStatus
     * description ::set Favorite Call From Status On Profile Window
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void setFavoriteCallFromStatus(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"Select Favorite call From Status");
        click(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"Select Favorite call From Status ");
    }
    /**
     * param ::String
     * return ::String
     * throws :: throwable
     * methodName :: getFavoriteStatusFromProfile
     * description :: get Favorite Status From Profile
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getFavoriteStatusFromProfile(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"get Favorite Call status From Profile Window");
        String starStatus = getAttributeByClass(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"get Favorite Call status From Profile Window ");
        return starStatus;
    }
    /**
     * param ::String, String
     * return ::void
     * throws :: throwable
     * methodName :: mouseHoverOnToComments
     * description :: mouseHover On To Comments On Profile Window
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void mouseHoverOnToComments(String callIDAndDate,String comments)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.mouseHoverToCommentsInContextMenu(callIDAndDate,comments),"Click On Comments ");
        mouseHover(DIProfilePage.mouseHoverToCommentsInContextMenu(callIDAndDate,comments),"Click On Comments ");
        Thread.sleep(3000);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: mouseHoverOntoAutoComment
     * description ::mouseHover On to Auto Comment On Profile Window
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void mouseHoverOntoAutoComment()throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.lblAutocomment,"Auto Comment ");
        mouseHover(DIProfilePage.lblAutocomment,"Auto Comment ");
        Thread.sleep(3000);
    }
    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void selectComment(String autoComment)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectAutoComment(autoComment),"Auto Comment ");
        click(DIProfilePage.selectAutoComment(autoComment),"Auto Comment ");
    }
    /**
     * param ::
     * return ::List<String>
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public List<String> getCommentsListFromProfile()throws  Throwable{
        List<String> commentsList = new ArrayList<>();

        waitForVisibilityOfElement(DIProfilePage.listOfComments,"Comments List In Profile");
        commentList = getWebElementList(DIProfilePage.listOfComments,"get Comments List From Profile");
        if(commentList!=null){
            for(int i=0;i<commentList.size();i++){
                String comments = commentList.get(i).getText();
                commentsList.add(comments);
            }
        }
        return commentsList;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnViewHiddenTabsDownArrow
     * description ::
     * date :: 15-Feb-2018
     * author ::Sachin
     */
    public void  ClickOnViewHiddenTabsDownArrow()throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.btnVIewHiddenProfile,"View Hidden Tabs");
        click(DIProfilePage.btnVIewHiddenProfile,"View Hidden Tabs");
    }
    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: SelectHiddenTabNames
     * description :: Select Hidden Tab Names on Profile Window
     * date :: N/A
     * author ::Cigniti
     */
    public void  SelectHiddenTabNames(String TabNames)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.lblHiddenTabNamesInDropDown(TabNames),""+TabNames);
        click(DIProfilePage.lblHiddenTabNamesInDropDown(TabNames),""+TabNames);
    }
    /**
     * param ::String, String
     * return ::Boolean
     * throws :: throwable
     * methodName :: IsCallIdExistOnProfileTabs
     * description :: IsCallId Exist On Profile Tabs on Profile Window
     * date :: N/A
     * author ::Cigniti
     */
    public boolean IsCallIdExistOnProfileTabs(String CallId, String Date) throws  Throwable {
        boolean callIDinCallBackProfiletab = isVisibleOnly(DIProfilePage.txtCallidOnProfileWindow(CallId,Date),"CallId On profile tab "+CallId);
        return callIDinCallBackProfiletab;
    }
    /**
     * param ::String, String
     * return ::Boolean
     * throws :: throwable
     * methodName :: IsPhoneIconExistForCallOnProfileWindow
     * description :: IsPhone Icon Exist For Call On Profile Window
     * date :: N/A
     * author ::Cigniti
     */
    public boolean IsPhoneIconExistForCallOnProfileWindow(String CallId, String Date) throws  Throwable {
        boolean phoneIcon = isVisible(DIProfilePage.iconPhoneProfileWIndow(CallId,Date),"Phone Icon on Profile Window");
        return phoneIcon;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: CLoseProfileWindow
     * description :: CLose Profile Window
     * date :: N/A
     * author ::Cigniti
     */
    public  void CLoseProfileWindow() throws Throwable {
        waitForVisibilityOfElement(DIProfilePage.iconCloseTheProfile,"Icon Close Profile Window");
        click(DIProfilePage.iconCloseTheProfile,"Icon Close Profile Window");
    }


    /* *
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondETAOnTabOnPlusIcon
     * description :: To select BeyondETA in Plus Icon On Profile Tab In MCD
     * date :: 19-Mar-2018
     * author :: Madhukar
     */
    public void selectBeyondETAOnTabOnPlusIcon() throws Throwable {
        click(DIProfilePage.linkTabPlusButton, "Click on Plus Button");
        boolean BeyondETAPlusIcon = isVisibleOnly(DIProfilePage.lnkBeyondETAUnderAddMenuIcon, "BeyondETA");
        if (BeyondETAPlusIcon) {
            click(DIProfilePage.lnkBeyondETAUnderAddMenuIcon, "BeyondETA");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondETAOnHiddenTab
     * description ::To select BeyondETA in Hidden Tab On Profile Tab In MCD
     * date :: 19-Mar-2018
     * author :: Madhukar
     */
    public void selectBeyondETAOnHiddenTab() throws Throwable {
        click(DIProfilePage.drpdwnHiddenTabs, "Click on Hidden Button");
        boolean BeyondETAHiddenIcon = isVisibleOnly(DIProfilePage.lnkBeyondETAUnderHiddenTab, "BeyondETA");
        if (BeyondETAHiddenIcon) {
            click(DIProfilePage.lnkBeyondETAUnderHiddenTab, "BeyondETA");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectBeyondETAOnProfileTab
     * description ::To select BeyondETA On Profile Tab In MCD
     * date :: 19-Mar-2018
     * author :: Madhukar
     */
    public void selectBeyondETAOnProfileTab() throws Throwable {
        boolean BeyondETAProfileTab = isVisibleOnly(DIProfilePage.lnkBeyondETAUnderProfileTab, "BeyondETA");
        if (BeyondETAProfileTab) {
            click(DIProfilePage.lnkBeyondETAUnderProfileTab, "BeyondETA");
        }
    }

    /* *
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: BeyondETA
     * description ::To select RedFlag Calls On Profile Tab In MCD
     * date :: 19-Mar-2018
     * author :: Madhukar
     */
    public void BeyondETA() throws Throwable
    {
        selectBeyondETAOnTabOnPlusIcon();
        selectBeyondETAOnHiddenTab();
        selectBeyondETAOnProfileTab();
    }

    /**
     * methodName :: getStatusForCallIDOnProfileBeyondETA
     * description ::To get current status on Beyond ETA  Profile  In MCD for a CallID
     * @param callID
     * @param callDate
     * @return
     * @throws Throwable
     * date :: 19-Mar-2018
     * author :: Madhukar
     */
     public String getStatusForCallIDOnProfileBeyondETA(String callID,String callDate)throws Throwable {

        waitForInVisibilityOfElement(DIProfilePage.getStatusForCallIdOnProfileBeyondETA(callID,callDate),"Status for a callID");
        String status=getText(DIProfilePage.getStatusForCallIdOnProfileBeyondETA(callID,callDate),"Status for a callID");
        return status;
    }

    /**
     * methodName :: verifyCallOutIconOnProfileWindow
     * description ::To verify CallOut Icon On Profile Window
     * @param callID
     * @param callDate
     * @return
     * @throws Throwable
     * date :: 29-Mar-2018
     * author :: Madhukar
     */
    public boolean verifyCallOutIconOnProfileWindow(String callID,String callDate)throws Throwable {

        waitForVisibilityOfElement(DIProfilePage.callOutIconOnProfileWIndow(callID,callDate),"Phone Icon");
        boolean phoneIcon=isVisibleOnly(DIProfilePage.callOutIconOnProfileWIndow(callID,callDate),"Phone Icon");
        return phoneIcon;
    }


    public void selectCallStatus(String callId,String callStatus)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.mouseHoverToContextMenu(callId,callStatus),"Select call Status");
        mouseHover(DIProfilePage.mouseHoverToContextMenu(callId,callStatus),"Select call Status");
    }
    public void rightClickOnCallIdHavingOLStatus()throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.lblOLStatus,"OL Staus Of callID");
        dynamicWaitByLocator(DIProfilePage.lblOLStatus,60);
        rightClick(DIProfilePage.lblOLStatus,"OL Staus Of callID");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectFromContextMenu
     * description :: input need be tile to perform to perform mouse over on context menu
     * date :: N/A
     * author ::Jagadish
     */

    public void selectFromContextMenu(String callIDAndDate,String title)throws Throwable{
        dynamicWaitByLocator(DIProfilePage.selectFromContextMenu(callIDAndDate,title),60);
        mouseHover(DIProfilePage.selectFromContextMenu(callIDAndDate,title),"Mouse hover and Select "+title);
    }
    /**
     * *********Not Working*********
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: rightClickOnCallIdUsingCallId
     * description :: input need to be ETA Time displayed at ETA Contextmenu(3rd) to select time
     * date :: N/A
     * author ::Jagadish
     */

    public void clickOnContextMenuItem(String name) throws Throwable {
        dynamicWaitByLocator(DIProfilePage.clickOnETATime(name),60);
        mouseHover(DIProfilePage.clickOnETATime(name),"Right Click On CallId On Profile Tab");
        mouseClick(DIProfilePage.clickOnETATime(name),"Right Click On CallId On Profile Tab");
    }


    /**
     * methodName :: getStatusForCallIDOnAllCallsTab
     * description ::To get current status on All Calls Tab
     * @param callID
     * @param callDate
     * @return
     * @throws Throwable
     * date :: 3-Apr-2018
     * author :: Sachin
     */
    public String getStatusForCallIDOnAllCallsTab(String callID,String callDate)throws Throwable {
        waitForVisibilityOfElement(DIProfilePage.getCallIDStatusFromAllCallsTab(callID,callDate),"CallId Status");
        String status=getText(DIProfilePage.getCallIDStatusFromAllCallsTab(callID,callDate),"CallId Status").trim();
        return status;
    }

    /**
     * methodName :: clickOnArrowPopTheProfile
     * description ::This function clicks on the Up arrow nd Down arrow-Pop the profile up into a seperate browser window
     * @return
     * @throws Throwable
     * date :: 4-Apr-2018
     * author :: Sachin
     */
    public void clickOnArrowPopTheProfile()throws Throwable {
        waitForVisibilityOfElement(DIProfilePage.upDownArrowPopTheProfile,"Arrow - Pop the Profile");
        click(DIProfilePage.upDownArrowPopTheProfile,"Arrow - Pop the Profile");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectFromContextMenu
     * description :: To select menu Item after RightClick On callID
     * date :: N/A
     * author ::Lakshmi
     */
    public void selectFromContextMenu(String title)throws Throwable{
        dynamicWaitByLocator(DIProfilePage.selectFromContextMenu(title),60);
        mouseHover(DIProfilePage.selectFromContextMenu(title),"Right Click On CallId On Profile Tab");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectOverrideWithmenuItem
     * description :: To select OverrideWith menuItem On callID
     * date :: N/A
     * author ::Lakshmi
     */
    public void selectOverrideWithmenuItem()throws Throwable {
        boolean overRideOptionFlag = isVisibleOnly(DIProfilePage.lnkTextOverrideWithOnContextMenu, "Mouse Hover To Override With menu Item");
        if (overRideOptionFlag) {
            mouseHover(DIProfilePage.lnkTextOverrideWithOnContextMenu, "Mouse Hover To Override With menu Item");
            mouseClick(DIProfilePage.lnkTextOverrideWithOnContextMenu, "Select Override With menu Item");
        }
    }

    /**
     * methodName :: clickOnStsArrowButton
     * description ::To click on sts arrow button after resetting to default
     * @return
     * @throws Throwable
     * date :: 05-Apr-2018
     * author :: Madhukar
     */
    public void clickOnStsArrowButton()throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.btnStsArrow,"Sts Arrow button");
        click(DIProfilePage.btnStsArrow,"Sts Arrow button");
    }
    /**
     * methodName :: clickOnDateArrowButton
     * description ::To click on Date arrow button after resetting to default
     * @return
     * @throws Throwable
     * date :: 05-Apr-2018
     * author :: Madhukar
     */
    public void clickOnDateArrowButton()throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.btnDateArrow,"Date Arrow button");
        click(DIProfilePage.btnDateArrow,"Date Arrow button");
    }
    /**
     * methodName :: clickOnIDArrowButton
     * description ::To click on ID arrow button after resetting to default
     * @return
     * @throws Throwable
     * date :: 05-Apr-2018
     * author :: Madhukar
     */
    public void clickOnIDArrowButton()throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.btnIDArrow,"ID Arrow button");
        click(DIProfilePage.btnIDArrow,"ID Arrow button");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectACallOnProfileTab
     * description :: To select A CallOn ProfileTab
     * date :: N/A
     * author ::Lakshmi
     */
    public void selectACallOnProfileTab(String callIdAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.statusOnPfofile(callIdAndDate),"Select a call On profile window");
        dynamicWaitByLocator(DIProfilePage.statusOnPfofile(callIdAndDate),60);
        WebElement callidElement = driver.findElement(DIProfilePage.statusOnPfofile(callIdAndDate));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", callidElement);
        click(DIProfilePage.statusOnPfofile(callIdAndDate),"Click On CallId On Profile Tab");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsInAddCommentsWindow
     * description :: To enter Comments In AddCommentsWindow
     * date :: N/A
     * author ::Lakshmi
     */
    public void enterCommentsInAddCommentsWindow(String comments)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.txtCommentsToTextArea,"Enter comments In to text area");
        type(DIProfilePage.txtCommentsToTextArea,comments,"Enter comments In to text area");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonToSaveComments
     * description :: To click On SaveButton To Save Comments
     * date :: N/A
     * author ::Lakshmi
     */
    public void clickOnSaveButtonToSaveComments()throws Throwable{
       /* dynamicWaitByLocator(DIProfilePage.btnSaveForAddComments,60);
        *//*click(DIProfilePage.btnSaveForAddComments,"Add comments save button");
        mouseJSDoubleClick(DIProfilePage.btnSaveForAddComments,"Add comments save button");*/
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");

        String combineKeys2 = Keys.chord(Keys.ENTER);
        sendKeys(combineKeys2, "ENTER");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectMultipleCalls
     * description :: To select MultipleCalls On prifile tab
     * date :: N/A
     * author ::Lakshmi
     */
    public void selectMultipleCalls(String callIdAndDate,String secondCallIdAnddate )throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.statusOnPfofile(callIdAndDate),"Select a call On profile window");
        dynamicWaitByLocator(DIProfilePage.statusOnPfofile(callIdAndDate),60);
        WebElement callidElement = driver.findElement(DIProfilePage.statusOnPfofile(callIdAndDate));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", callidElement);
        click(DIProfilePage.statusOnPfofile(callIdAndDate),"Click On CallId On Profile Tab");
        //WebElement callIdAnddate = findWebElement(DIProfilePage.statusOnPfofile(callIdAndDate),"Find the callIDAndDate");
        WebElement secondCallIdAndDate = findWebElement(DIProfilePage.statusOnPfofile(secondCallIdAnddate),"Find the callIDAndDate");
                    Actions actions = new Actions(driver);
        actions.click(callidElement).keyDown(Keys.CONTROL)
                .click(secondCallIdAndDate).keyUp(Keys.CONTROL).build().perform();

    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: getETAWindowNameOnProfileTab
     * description :: To get ETA Window Name On prifile tab
     * date :: N/A
     * author ::Lakshmi
     */
    public String getETAWindowNameOnProfileTab()throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.lblEtaWindowName,"ETA Window Name");
        String etawindowName = getText(DIProfilePage.lblEtaWindowName,"ETA Window Name");
        return etawindowName;
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterETAHoursOnETAUpdateWindow
     * description :: To enter ETA Hours On ETA Update Window
     * date :: N/A
     * author ::Lakshmi
     */
    public void enterETAHoursOnETAUpdateWindow(String etaHour)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.txtETAHoursOnUpdateETAwindow,"Enter ETA Hours");
        type(DIProfilePage.txtETAHoursOnUpdateETAwindow,etaHour,"Enter ETA Hours");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName ::  enterETAMinutesOnETAUpdateWindow
     * description :: To enter ETA Minutes On ETA Update Window
     * date :: N/A
     * author ::Lakshmi
     */
    public void enterETAMinutesOnETAUpdateWindow(String etaMinutes)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.txtETAMinsOnUpdateETAwindow,"Enter ETA Minutes");
        type(DIProfilePage.txtETAMinsOnUpdateETAwindow,etaMinutes,"Enter ETA Minutes");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName ::  clickOnContinueButtonOnETAUpdateWindow
     * description :: To click On Continue Button On ETAUpdate Window
     * date :: N/A
     * author ::Lakshmi
     */
    public void clickOnContinueButtonOnETAUpdateWindow()throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.btnContinueOnETAUpdateWindow,"Continue button on ETA update Window");
        click(DIProfilePage.btnContinueOnETAUpdateWindow,"Continue button on ETA update Window");
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName ::  clickOnContinueButtonOnETAUpdateWindow
     * description :: To click On Continue Button On ETAUpdate Window
     * date :: N/A
     * author ::Lakshmi
     */
    public void pressNumericKeyOnCallID(String callIdAndDate)throws  Throwable{
        //waitForVisibilityOfElement(DIProfilePage.statusOnPfofile(callIdAndDate),"Select a call On profile window");
        dynamicWaitByLocator(DIProfilePage.statusOnPfofile(callIdAndDate),60);
        WebElement callidElement = driver.findElement(DIProfilePage.statusOnPfofile(callIdAndDate));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", callidElement);
        click(DIProfilePage.statusOnPfofile(callIdAndDate),"Click On CallId On Profile Tab");
        //WebElement callIdAnddate = findWebElement(DIProfilePage.statusOnPfofile(callIdAndDate),"Find the callIDAndDate");
        String select =  Keys.chord(Keys.SHIFT,NUMPAD8);
       /* Actions act = new Actions(driver);
        driver.key_down(Keys.SHIFT).build().perform();
        *//*callidElement.sendKeys(NUMPAD8);
        act.keyUp(Keys.SHIFT).build().perform();*/
        callidElement.sendKeys(select);

    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName ::  getTruckLoadList
     * description :: To get all trucks LoadList
     * date :: N/A
     * author ::Lakshmi
     */
    public List<String> getTruckLoadList(String secondCallIdAnddate)throws Throwable{
        List<String> listOfTrucks = new ArrayList<>();
        truckList = getWebElementList(DIProfilePage.getTruckList(secondCallIdAnddate),"All trucks On profile wimdow");
        for(int i=0;i<truckList.size();i++){
            String trucks = truckList.get(i).getText();
            listOfTrucks.add(trucks);
        }
        return listOfTrucks;
    }
    /**
     *
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName ::  selectTruckOnProfileWindow
     * description :: To select Truck On ProfileWindow
     * date :: N/A
     * author ::Lakshmi
     */
    public void selectTruckOnProfileWindow(String secondCallIdAnddate)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectTruck(secondCallIdAnddate),"Select truck ID on profile window");
        click(DIProfilePage.selectTruck(secondCallIdAnddate),"Select truck ID on profile window");
    }

}

