package com.aaa.rspweb.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.dataDriver.ExcelFileReadWrite;
import com.aaa.rspweb.pages.RSPHomePage;
import com.aaa.web.lib.*;
import com.aaa.web.page.DISearchCallsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class RSPCommonLib extends ActionEngine {

    /**
     * param ::By,String
     * return ::List
     * throws :: throwable
     * methodName :: getTableDataByRowWithOutNullOrEmptyValues
     * description :: To get webelement values without null and empty
     * date :: 22-Mar-2018
     * author :: Jagadish Pola
     */
    //Headers
    public List getTableDataByRowWithOutNullOrEmptyValues(By locator, String locatorName) throws Throwable {
        List tableDataByRow = new ArrayList();
            List<WebElement> data = getWebElementList(locator, locatorName);
            if (data.size() >= 1) {
                int number = 1;
                reporter.SuccessReport("<b>Records found without empty and null values are</b>", "<b>Records found are::</b>");
                for (WebElement tableData : data) {
                    if (!tableData.getText().equals(null) && !tableData.getText().equals("") && !tableData.getText().equals("-")) {
                        tableDataByRow.add(tableData.getText());
                        reporter.SuccessReport("Record number::" + number, tableData.getText());
                    } else {
                        continue;
                    }
                    number++;
                }
            } else {
                reporter.failureReport("<b>No records found</b>", "Records size are::" + data.size(), driver);
            }
        return tableDataByRow;
    }

    /**
     * param :: By,String
     * return ::List
     * throws :: throwable
     * methodName :: getTableDataByRow
     * description :: To get webelement values with null and empty
     * date :: 22-Mar-2018
     * author :: Jagadish Pola
     */
    //Headers
    public List getTableDataByRow(By locator, String locatorName) throws Throwable {
        List tableDataByRow = new ArrayList();
            dynamicWaitByLocator(locator, 60);
            List<WebElement> data = getWebElementList(locator, locatorName);
            int number = 1;
            reporter.SuccessReport("<b>Records found are</b>", "<b>Records found in " + locatorName + "::</b>");
            for (WebElement tableData : data) {
                reporter.SuccessReport("Record number::" + number, tableData.getText());
                tableDataByRow.add(tableData.getText());
                number++;
            }
        return tableDataByRow;
    }

    /**
     * param :: By,String
     * return ::List
     * throws :: throwable
     * methodName :: getTableDataByRow
     * description :: To get webelement values with null and empty
     * date :: 22-Mar-2018
     * author :: Jagadish Pola
     */
    //Headers
    public List getTableDataByRowWithOutReport(By locator, String locatorName) throws Throwable {
        List tableDataByRow = new ArrayList();
            dynamicWaitByLocator(locator, 60);
            List<WebElement> data = getWebElementList(locator, locatorName);
            int number = 1;
            for (WebElement tableData : data) {
                tableDataByRow.add(tableData.getText());
                number++;
            }
        return tableDataByRow;
    }

    /**
     * param :: By,String
     * return :: List
     * throws :: throwable
     * methodName :: getNamesFromSelectOptions
     * description :: to get total available options available in select options.
     * date :: 23-Mar-2018
     * author :: Jagadish Pola
     */

    public List getNamesFromSelectOptions(By locator,String locatorName) throws Throwable {
        List totalOptionsAvailable = null;
            dynamicWaitByLocator(locator, 60);
            List<WebElement> optionNames = getWebElementList(locator, locatorName);
            for (WebElement totalOptions : optionNames) {
                totalOptionsAvailable.add(totalOptions.getText());
                reporter.SuccessReport("Available options are::", totalOptions.getText());
            }
        return totalOptionsAvailable;
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verificationOfWarningNotification
     * description :: verifying warning notification is found or not
     * date :: 23-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean verificationOfWarningNotification() throws Throwable {
        return isVisibleOnly(RSPHomePage.warningNotification,"Warning notification");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verificationOfSuccessNotification
     * description :: verifying success notification is found or not
     * date :: 23-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean verificationOfSuccessNotification() throws Throwable {
        return isVisibleOnly(RSPHomePage.successNotification,"Success notification");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verificationOfErrorNotification
     * description :: To veify the error notification is visible or not
     * date :: 23-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean verificationOfErrorNotification() throws Throwable {
        return isVisibleOnly(RSPHomePage.errorNotification,"Error notification");
    }


    /**
     * param :: stringToSplit
     * return ::List
     * throws :: throwable
     * methodName :: splitTheStringBasedOnComma
     * description :: To split string based on comma
     * date :: 23-Mar-2018
     * author :: Jagadish Pola
     */
    public List splitTheStringBasedOnComma(String stringToSplit) throws Throwable {
        String[] split=stringToSplit.split(",");
        return Arrays.asList(split);
    }

    /**
     * param :: list,list
     * return ::boolean
     * throws :: throwable
     * methodName :: recordsSortingAndComparision
     * description :: To compare two lists
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean recordsSortingAndComparision(List actualList,List expectedList) throws Throwable {
        boolean flag=false;
            Collections.sort(actualList);
            Collections.sort(expectedList);
            if (actualList.size() == expectedList.size()) {
                reporter.SuccessReport("Total number of records", "<b>Total number of records in actal list::" + actualList.size() + " is matched with expected list records::" + expectedList.size() + "</b>");
                for (int index = 0; index < actualList.size(); index++) {
                    if (actualList.get(index).toString().equalsIgnoreCase((expectedList.get(index)).toString())) {
                        flag = true;
                    } else {
                        reporter.failureReport("Mismatch data", "values are" + actualList.get(index) + " Not equals " + expectedList.get(index));
                        break;
                    }
                }
            } else {
                reporter.failureReport("<b>Total number of records</b>", "<b>Total number of records in actual list::" + actualList.size() + " mismatched with expected list of records:: " + expectedList.size() + "</b>", driver);
                flag=false;
            }
        return flag;
    }

    /**
     * param :: list
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRecordsAreInDecendingOrderForDate
     * description :: To verify records are in decending order for Date values
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean verifyRecordsAreInDecendingOrderForDate(List actualList) throws Throwable {
        boolean flag=true;
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                if (actualList.size() > 1) {
                    for (int index = 0; index < actualList.size() - 1; index++) {
                        String initialDate = actualList.get(index).toString().substring(0, 19);
                        String comparisionDate = actualList.get(index + 1).toString().substring(0, 19);
                        Date dateCompare = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(initialDate);
                        Date dateCompareTo = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(comparisionDate);
                        if (date.format(dateCompare).compareTo(date.format(dateCompareTo)) >= 0) {
                            flag = true;
                        } else {
                            flag = false;
                            reporter.failureReport("Date comparision in decending order", actualList.get(index).toString() + "before" + actualList.get(index + 1).toString());
                            break;
                        }
                    }
                }
            else{
                reporter.failureReport("Verify sorting order", "Atleast two records needed to verify sorting order but found::"+actualList.size());
                flag=false;
                }
        return flag;
    }

    /**
     * param :: list
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRecordsAreInAscendingOrderForDate
     * description :: To verify records are in ascending order for Date values
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean verifyRecordsAreInAscendingOrderForDate(List actualList) throws Throwable {
        boolean flag=true;
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            if (actualList.size() > 1) {
                for (int index = 0; index < actualList.size() - 1; index++) {
                    String initialDate = actualList.get(index).toString().substring(0, 19);
                    String comparisionDate = actualList.get(index + 1).toString().substring(0, 19);
                    Date dateCompare = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(initialDate);
                    Date dateCompareTo = new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(comparisionDate);
                    if (date.format(dateCompare).compareTo(date.format(dateCompareTo)) <= 0) {
                        flag = true;
                    } else {
                        flag = false;
                        reporter.failureReport("Date comparision in ascending order", actualList.get(index).toString() + "is after" + actualList.get(index + 1).toString());
                        break;
                    }
                }
            }
            else{
                reporter.failureReport("Verify sorting order", "Atleast two records needed to verify sorting order but found::"+actualList.size());
                flag=false;
            }

        return flag;
    }

    /**
     * param :: list
     * return ::boolean
     * throws :: throwable
     * methodName :: compareTwoStringsFromOneListInDecendingOrder
     * description :: To verify records are in decending order for String values
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean compareTwoStringsFromOneListInDecendingOrder(List actualList) throws Throwable
    {
        boolean flag=true;
            if (actualList.size() > 1) {
                for (int index = 0; index < actualList.size() - 1; index++) {
                        List sortList = new ArrayList();
                        sortList.add(actualList.get(index));
                        sortList.add(actualList.get(index + 1));
                        Collections.sort(sortList, Collections.reverseOrder());
                        for (int sortListIndex = 0; sortListIndex < sortList.size() - 1; sortListIndex++) {
                            if (!sortList.get(sortListIndex).toString().equalsIgnoreCase("No Customer") && !sortList.get(sortListIndex + 1).toString().equalsIgnoreCase("No Customer")) {
                                if (sortList.get(sortListIndex).toString().equals(actualList.get(index)) && sortList.get(sortListIndex + 1).toString().equals(actualList.get(index + 1))) {
                                    flag = true;
                                } else {
                                    flag = false;
                                    reporter.failureReport("Comparision in decending order", actualList.get(index).toString() + "is before" + actualList.get(index + 1).toString());
                                    break;
                                }
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }
                }
            else{
                reporter.failureReport("Verify sorting order", "Atleast two records needed to verify sorting order but found::"+actualList.size());
                flag=false;
            }
       return flag;
    }

    /**
     * param :: list
     * return ::boolean
     * throws :: throwable
     * methodName :: compareTwoStringsFromOneListInAscendingOrder
     * description :: To verify records are in ascending order for String values
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean compareTwoStringsFromOneListInAscendingOrder(List actualList) throws Throwable
    {
        boolean flag=true;
            if (actualList.size() > 1) {
                for (int index = 0; index < actualList.size() - 1; index++) {
                    if (!actualList.get(index).toString().equalsIgnoreCase("-") && !actualList.get(index + 1).toString().equalsIgnoreCase("-")
                            && !actualList.get(index).toString().equalsIgnoreCase("") && !actualList.get(index + 1).toString().equalsIgnoreCase("")
                            && !actualList.get(index).toString().equalsIgnoreCase(null) && !actualList.get(index + 1).toString().equalsIgnoreCase(null)) {
                        List sortList = new ArrayList();
                        sortList.add(actualList.get(index));
                        sortList.add(actualList.get(index + 1));
                        Collections.sort(sortList);
                        for (int sortListIndex = 0; sortListIndex < sortList.size() - 1; sortListIndex++) {
                            if (!(sortList.get(sortListIndex).toString().equalsIgnoreCase("No Customer")) && !(sortList.get(sortListIndex + 1).toString().equalsIgnoreCase("No Customer"))) {
                                if (sortList.get(sortListIndex).toString().equals(actualList.get(index)) && sortList.get(sortListIndex + 1).toString().equals(actualList.get(index + 1))) {
                                    flag = true;
                                } else {
                                    flag = false;
                                    reporter.failureReport("Comparision in ascending order", actualList.get(index).toString() + "is before" + actualList.get(index + 1).toString());
                                    break;
                                }
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }
                }
            }
            else{
                reporter.failureReport("Verify sorting order", "Atleast two records needed to verify sorting order but found::"+actualList.size());
                flag=false;
            }
        return flag;
    }

    /**
     * param :: list
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRecordsAreInDecendingOrderForIntegerField
     * description :: To verify records are in decending order for integer values
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean verifyRecordsAreInDecendingOrderForIntegerField(List actualList) throws Throwable {
        boolean flag=true;
            if (actualList.size() > 1) {
                for (int index = 0; index < actualList.size() - 1; index++) {
                    if (!actualList.get(index).toString().equalsIgnoreCase("-") && !actualList.get(index + 1).toString().equalsIgnoreCase("-")
                            && !actualList.get(index).toString().equalsIgnoreCase("") && !actualList.get(index + 1).toString().equalsIgnoreCase("")
                            && !actualList.get(index).toString().equalsIgnoreCase(null) && !actualList.get(index + 1).toString().equalsIgnoreCase(null)) {
                        if (Integer.parseInt(actualList.get(index).toString()) >= Integer.parseInt(actualList.get(index + 1).toString())) {
                            flag = true;
                        } else {
                            flag = false;
                            reporter.failureReport("Comparision in decending order", actualList.get(index).toString() + "created before" + actualList.get(index + 1).toString());
                            break;
                        }
                    }
                }
            }
            else{
                reporter.failureReport("Verify sorting order", "Atleast two records needed to verify sorting order but found::"+actualList.size());
                flag=false;
            }
        return flag;
    }

    /**
     * param :: list
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyRecordsAreInAscendingOrderForIntegerField
     * description :: To verify records are in ascending order for integer values
     * date :: 25-Mar-2018
     * author :: Jagadish Pola
     */
    public boolean verifyRecordsAreInAscendingOrderForIntegerField(List actualList) throws Throwable {
        boolean flag=true;
            if (actualList.size() > 1) {
                for (int index = 0; index < actualList.size() - 1; index++) {
                    if (!actualList.get(index).toString().equalsIgnoreCase("-") && !actualList.get(index + 1).toString().equalsIgnoreCase("-")
                            && !actualList.get(index).toString().equalsIgnoreCase("") && !actualList.get(index + 1).toString().equalsIgnoreCase("")
                            && !actualList.get(index).toString().equalsIgnoreCase(null) && !actualList.get(index + 1).toString().equalsIgnoreCase(null)) {
                        if (Integer.parseInt(actualList.get(index).toString()) <= Integer.parseInt(actualList.get(index + 1).toString())) {
                            flag = true;
                        } else {
                            flag = false;
                            reporter.failureReport("Comparision in ascending order", actualList.get(index).toString() + "created after" + actualList.get(index + 1).toString());
                            break;
                        }
                    }
                }
            }
            else{
                reporter.failureReport("Verify sorting order", "Atleast two records needed to verify sorting order but found::"+actualList.size());
                flag=false;
            }
        return flag;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyingandGettingNotificationText
     * description :: To verify the error/warning/success notifications are visible and returns text
     * date :: 28-Mar-2018
     * author :: Jagadish Pola
     */
    public String verifyingandGettingNotificationText() throws Throwable {
        if (verificationOfWarningNotification()) {
            String notification = getText(RSPHomePage.warningNotification, "Warning notification");
            reporter.SuccessReport("Waring notification", "Warning notification found and notification is::" + notification);
            return notification;
        }
        if (verificationOfSuccessNotification()) {
            String notification = getText(RSPHomePage.successNotification, "Success notification");
            reporter.SuccessReport("Success notification", "Success notification found and notification is::" + notification);
            return notification;
        }
        if (verificationOfErrorNotification()) {
            String notification = getText(RSPHomePage.errorNotification, "Error notification");
            reporter.SuccessReport("Error notification", "Error notification found and notification is::" + notification);
            return notification;
        } else {
            return "";
        }
    }


    /**
     * param :: Hashtable(CRLoginName,CRPassword,Member=db/Manual,MemberSearch=member number,Breakdown address,vehicle info,pacesetter code,Tow Destination,Tow Passengers)
     * return ::Hashtable
     * throws :: throwable
     * methodName :: createCall
     * description :: To create a call
     * date :: 01-Apr-2018
     * author ::
     * added by :: Jagadish Pola
     */
    //location should be:- parks lincoln of longwood
    //Tow problem as:- transmission/clutch
    //vehicle:- Ford fusion
    //shop name need to be:-AAR Park's Lincoln of Longwood

    public Hashtable<String, String> createCall(String loginName,String password,String breakdownAddress,String vehicleModel,String pacesetterCode,String towDestination,String towPassengers
                                                ,String member, String memberSearch, String dbServer, String dbqueryFileName, String colomnName, String phoneNumber, String primaryphonenum1,String callType,String facilityId) throws Throwable {
        String callId,callDate;
        LoginLib crLogin = new LoginLib();
        CRHomeLib crHomeLib = new CRHomeLib();
        CRLocationsLib crLocationsLib = new CRLocationsLib();
        CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
        CRServiceLib services = new CRServiceLib();
        CRTowDestinationLib towdestination = new CRTowDestinationLib();
        CRMemberSearchLib crmemeber = new CRMemberSearchLib();
        CommonLib common=new CommonLib();
        Hashtable<String, String> callData=new Hashtable<>();
        try {
            navigateToApplication("CR");
            crLogin.login(loginName,password);
            crHomeLib.messageDialogBoxClose();
            try {
                common.crMemberSearchTab(member, memberSearch, dbServer, dbqueryFileName, colomnName, phoneNumber, primaryphonenum1);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                crHomeLib.clearMemberSearchTextBox();
                String Member = memberSearch;
                crHomeLib.memberSearchTextBox(Member);
                crmemeber.memberNumClick();
                crmemeber.currentCallClose();
                crmemeber.ClickPrimRadioBtnInRowTwo();
            }

            //Entering the breakdown location
            crLocationsLib.clickOnLocationTab();
            crLocationsLib.enterBreakDownAddressOmniBarSearch(breakdownAddress);

            //Vehicle details and traige
            crVehicleTriageLib.clickOnVehicleTriageTab();
            crVehicleTriageLib.enterVehicleDetailsinSearchBar(vehicleModel);
            crVehicleTriageLib.enterPaceSetterCodeManually(pacesetterCode);
            crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
            crVehicleTriageLib.scriptErrorHandle();
            crHomeLib.allErrorAlerts();
            towdestination.clickOnTowDestinationTab();
            towdestination.errorAlertHandlingBeforeEnterMandatoryFields();
            acceptAlert();
            towdestination.verifyAndSelectTowDestinationFromSearchResults(towDestination);
            towdestination.enterTowDestinationMandatoryFields(towPassengers);
            if(callType.toLowerCase().equals("facility"))
            {
                services.clickOnServiceTab();
                services.enterFacility(facilityId);
            }
            else if(callType.toLowerCase().equals("appointment"))
            {
                services.clickOnAppointmentbutton();
                services.enterAppointmentDate(LocalDate.now().toString());
                services.enterAppointmentTime(LocalTime.now().toString());
            }
            crHomeLib.saveButton();
            crLogin.waitcloseAllBusyIconsResults();
            callId = services.getCallId();
            callDate = services.getCallDate();
            callData.put("callId",callId);
            callData.put("callDate",callDate);
            SimpleDateFormat date=new SimpleDateFormat("MM/dd/yyyy");
            Date dateOfCallSaved = new SimpleDateFormat("yyyy-MM-dd").parse(callDate);
            callDate=date.format(dateOfCallSaved);
            callData.put("callDate",callDate);
            Thread.sleep(5000);
            crHomeLib.allErrorAlerts();
            services.closeCallWindow();
            crHomeLib.logout();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return callData;
    }

    /**
     * param :: Hash table(DILoginName and DIPassword),String(Call Id)
     * return ::String
     * throws :: throwable
     * methodName :: changeCallToTow
     * description :: Making call to tow
     * date :: 01-Apr-2018
     * author ::
     * added by :: Jagadish Pola
     */
       public String changeCallToTow(String loginName,String password,String role,String callId,String date) throws Throwable {
        DILoginLib diLoginLib = new DILoginLib();
        LoginRoleLib loginRole = new LoginRoleLib();
        DIHomeLib diHome = new DIHomeLib();
        DIMCDLib dimcdLib = new DIMCDLib();
        navigateToApplication("DI");
        diLoginLib.login(loginName,password);
        loginRole.selectRoleInDispatch(role);
        loginRole.clickOnProceedBtnInDispatchRoleLogin();
        diLoginLib.waitcloseAllBusyIcons();
        diHome.clickOnCloseIconOnQueueSelection();
        diHome.clickOnSearchCallsInDispatch();
        //diHome.enterMemberNumberInfo(data.get("MemberNumber"));
        diHome.enterStartDate(date);
        diHome.enterEndDateOnSearchCallsWindow(date);
        diHome.enterCallIDInfo(callId);
        diHome.clickOnSearchInSearchCalls();
        diHome.clickOnCallDateOrIDLink();
        dimcdLib.clickOnAssign();
        dimcdLib.selectSecondFacilityOnAssignTabInMCD();
        dimcdLib.selectDispatch();
        dimcdLib.clickOnTW();
        Thread.sleep(1000);
        String callStatus=dimcdLib.getCallStatusOnMCDwindow();
        dimcdLib.clickOnMCDCloseWindow();
        diHome.logOut();
        acceptAlert();
        Thread.sleep(2000);
        acceptAlert();
        return callStatus;
    }
    /**
     * param :: String,String
     * return ::date
     * throws :: throwable
     * methodName :: getCurrentSystemTime
     * description :: Getting system current time
     * date ::
     * author ::
     */

   	public static String getCurrentSystemTime(String format,String timeZone){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		sdf.format(new Date()).toString();
		return sdf.format(new Date());
	}

    /**
     * param :: String,String,String,String.
     * return ::void
     * throws :: throwable
     * methodName :: changeTowDestinationFromD3Calls
     * description :: To change the tow destination
     * date :: 17-Apr-2018
     * author ::
     * added by :: Jagadish Pola
     */

	public void changeTowDestinationFromD3Calls(String loginName,String password,String callDate,String callId) throws Throwable
    {
        LoginLib crLogin = new LoginLib();
        CRHomeLib crHomeLib = new CRHomeLib();
        CRTowDestinationLib towdestination = new CRTowDestinationLib();
        CRSearchCallsLib searchCall=new CRSearchCallsLib();
        try {
            navigateToApplication("CR");
            crLogin.login(loginName,password);
            crHomeLib.messageDialogBoxClose();
            //clicks on search call dropdown and selects
            searchCall.clickOnSearchCallsAndSearchLink();
            //Enter start date in search call window
            searchCall.enterStartDateOnSearchCallsWindow(callDate);
            //Enter end date in search call window
            searchCall.enterEndDateOnSearchCallsWindow(callDate);
            //Entering callId in search call window
            searchCall.enterCallIdOnSearchCallsWindow(callId);
            //Clicking on search button in search call window
            searchCall.clickOnSearchBtnOnSearchCallsWindow();
            //Clicking on call
            searchCall.clickOnCallIDLink();
            //verifying member search button
            crLogin.waitcloseAllBusyIconsResults();
            //Clicking on tow destination tab
            towdestination.clickOnTowDestinationTab();
            //Clicking on search mode in tow destination
            towdestination.clickOnManualEntryLinkOnTowDestination();
            //Selecting non AAR tow
            towdestination.selectingNonAARTowDestination();
            crHomeLib.saveButton();
            crLogin.waitcloseAllBusyIconsResults();
            crHomeLib.logout();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * param :: String,String,String,String.
     * return ::void
     * throws :: throwable
     * methodName :: changeTowDestinationFromDIAndSPP
     * description :: To change the tow destination from di and spp.
     * date :: 17-Apr-2018
     * author ::
     * added by :: Jagadish Pola
     */

    public void changeTowDestinationFromDIAndSPP(String loginName,String password,String role,String startAndEndDate,String callId,String locationName,String streetNumber,String streetName,String city,String state,String comments) throws Throwable
    {
        DILoginLib diLoginLib = new DILoginLib();
        LoginRoleLib loginRole = new LoginRoleLib();
        DIHomeLib diHome = new DIHomeLib();
        DIMCDLib dimcdLib = new DIMCDLib();
        navigateToApplication("DI");
        diLoginLib.login(loginName,password);
        if(loginRole.verifyVisibilityOProceedBtnInDispatchRoleLogin()) {
            loginRole.selectRoleInDispatch(role);
            loginRole.clickOnProceedBtnInDispatchRoleLogin();
        }
        diLoginLib.waitcloseAllBusyIcons();
        diHome.clickOnCloseIconOnQueueSelection();
        diHome.clickOnSearchCallsInDispatch();
        diHome.enterStartDate(startAndEndDate);
        diHome.enterEndDateOnSearchCallsWindow(startAndEndDate);
        diHome.enterCallIDInfo(callId);
        diHome.clickOnSearchInSearchCalls();
        diHome.clickOnCallDateOrIDLink();
        dimcdLib.clickOnLocationsTabInMCDWindow();
        if(dimcdLib.VerifyAvailablityOfEditLinkInServicesTab()) {
            dimcdLib.clickOnTowDestinationEditLinkInMCD();
            if(!dimcdLib.verifyManualAddressEntryInServicesInMCDWindow()) {
                dimcdLib.clickOnRepairFacility();
                dimcdLib.clickOnOtherLocation();
                dimcdLib.clickOnManualAddressEntryInServicesInMCDWindow();
            }
            dimcdLib.enterLocationForOtherLocationInMCDWindow(locationName);
            dimcdLib.enterStreetNumberInMCD(streetNumber);
            dimcdLib.enterStreetNameInMCD(streetName);
            dimcdLib.enterCityForOtherLocationInMCDWindow(city);
            dimcdLib.enterValueInStateInMCDWindow(state);
            dimcdLib.enterCommentsInTowDestinationTabInMCDWindow(comments);
            dimcdLib.clickOnSubmitButton();

        }
        dimcdLib.clickOnMCDCloseWindow();
        diHome.logOut();
    }

}
