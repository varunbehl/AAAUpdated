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


public class TC_DIMCDEditTowDestination extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;
    CRHomeLib home = new CRHomeLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib member = new CRMemberSearchLib();
    CRLocationsLib locations = new CRLocationsLib();
    //CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    //CRTowDestinationLib tow = new CRTowDestinationLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    CR_DI crDI = new CR_DI();
    DIMCDLib dimcd = new DIMCDLib();
    LoginRoleLib loginRole=new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    /************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI
    * Test Case ID:-
    * Script Date :-
    * Author      :-
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    *************************************************************************/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIMCDEditTowDestination(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDEditTowDestination", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					fnOpenTest();
    			        ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDEditTowDestination", TestData, "D3Dispatch",intCounter);

		                this.reporter.initTestCaseDescription("2037: TS-DI MCD Edit Tow Destination"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+" For User:: "+data.get("LoginNameForDI")+" ::and Search Type is:: "+data.get("searchType")+" ::For the module of:: "+ data.get("SearchModule")+ " and Search Type is:: "+data.get("searchBy")+"For following validation"+data.get("Validation")+"**************");

                    navigateToApplication("DI");
                    login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                    common.clickOnProceedBtnForDispatchSPPLogin();
                    diHome.clickOnSearchCallsLink();

//entering values in searchcalls
                    String currentDate=common.getCurrentDate();
                    String endDate=common.getNextDay(currentDate);
                    diSearchCalls.enterStartDate(data.get("startDate"));
                    diSearchCalls.enterEndDate(endDate);
                    diSearchCalls.enterValueInStatusTextBonInSearchCalls(data.get("status"));
                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                    diHome.clickOnCallDateOrIDLink();
                    dimcd.clickOnLocationsTabInMCDWindow();
                    boolean availablityOfEditLink=dimcd.VerifyAvailablityOfEditLinkInServicesTab();
                    if(availablityOfEditLink) {
                        dimcd.clickOnTowDestinationEditLinkInMCD();
                        dimcd.clickOnOtherLocation();
                        //Verifying all validation points with this method
                        towDestinationSearchCriteriaInMCD(data.get("SearchModule"), data.get("searchType"), data.get("addressSearch"), data.get("reasonForStatus"),
                                data.get("sppUser"), data.get("Validation"), data.get("searchBy"), data.get("streetName"),
                                data.get("streetNumber"), data.get("cityName"), data.get("state"), data.get("CrossStreet1"), data.get("CrossStreet2"),
                                data.get("towLocationName"), data.get("latitude"), data.get("longitude"), data.get("miles"));
                    }else{
                        reporter.failureReport("Edit Link","Edit link is not available");
                    }
                    if(member.visibilityOfProcessSpinner()){
                        fnCloseTest();
                    }else {
                        dimcd.clickOnMCDCloseWindow();
                        diHome.logOut();
                    }
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2037",ReportStatus.strMethodName,intCounter,browser);
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
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValuesManuallyInTowDestinationInMCD
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public void towDestinationSearchCriteriaInMCD(String searchModule,String SearchType,String addressSearch,String reasonForStatus,String sppUser,String Validation,String searchBy,String streetName,String streetNumber,String cityName,String state,String crossStreet1,String crossStreet2,String towLocationName,String latitude,String longitude,String miles) throws Throwable {
        switch (searchModule) { //Search module is used to validate Others tab or Manual or Repair facility tabs
            case "Others":
                switch (SearchType) {//SearchType is used to perform different types of SearchType like OminiSearch, Manual
                    case "OminiSearch":
                        reporter.SuccessReport("******Search Criteria of*******", Validation + " ***************Search*************");
                        dimcd.enterAddressInSearvicesInMCDWindow(addressSearch);
                        String addressVal[] = addressSearch.split(" ");
                        String address = addressVal[0];
                        dimcd.clickOnSearchButtonInServicesInMCDWindow();
                        boolean emptryRecords = dimcd.getEmptryRecordErrorMessageInTowDestinationInMCD();
                        if (emptryRecords == false) {

                            String results = dimcd.getLocationValueInTowDestinationResultsInMCDWindow();

                                if (!Validation.equals("reverse") && results.contains(address)){
                                    reporter.SuccessReport("Address Verification", "Entered address " + address + " Returned address " + results + " matched");


                            dimcd.clickOnLocationValueInTowDestinationResultsInMCDWindow();

                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();

                            boolean verified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(verified, "Address Verified");

                            String random = getRandomString(15);
                            String comments = dimcd.enterCommentsInTowDestinationTabInMCDWindow(random);
                            dimcd.enterStatusReasonsInTowDestionation(reasonForStatus);

                            dimcd.clickOnSumbitButton();
                            boolean errorAvailability = dimcd.ValidatedOnErrorOkayButtonInMCDWindow();
                            if (errorAvailability) {
                                dimcd.validateErrorMessage();
                                dimcd.clickOnErrorOkayButtonInMCDWindow();
                                assertFalse(errorAvailability, "Record Not saved");
                            } else {
                                String commentsFromCommentsSection = dimcd.getCommentsFromCommentsWindow(comments);
                                assertTrue(commentsFromCommentsSection.equalsIgnoreCase(comments), "<b>Both entered comments:: " + comments + " ::and Saved comments:: " + commentsFromCommentsSection + " ::are same</b>");

                                dimcd.clickOnStatusHistoryLinkOnMCDWindow();
                                dimcd.clickOnDateHeaderToSortDate();
                                dimcd.getStatusInHistoryStatusScreenInMCDWindow();
                            }
                        }else{
                                    if(Validation.equals("reverse")){
                                        reporter.failureReport("Verification for Reverse","Reverse condition is not returning values",driver);
                                    }else {
                                        reporter.failureReport("Verification of results", "Results are not matched", driver);
                                    }
                            }
                        } else {
                            reporter.failureReport("Results Not Found","Results Not found",driver);
                        }

                        break;
                    case "Manual":
                        dimcd.clickOnEnterAddressManuallyForOtherLocationInMCDWindow();



                        switch (searchBy) {//Search By is used to validate differnt types of Search criteria for manual search
                            case "address":
                                reporter.SuccessReport("******Search Criteria of*******", Validation + " ***************Search*************");
                                dimcd.enterValueInStreetNumberInMCDWindow(streetNumber);
                                dimcd.enterValueInStreetNameInMCDWindow(streetName);
                                dimcd.enterCityForOtherLocationInMCDWindow(cityName);
                                dimcd.enterValueInStateInMCDWindow(state);
                                break;
                            case "crossStreet1":
                                reporter.SuccessReport("******Search Criteria of*******", Validation + " ***************Search*************");
                                dimcd.enterValueInStreetNameInMCDWindow(streetName);
                                dimcd.enterCrossStreet1ForOtherLocationInMCDWindow(crossStreet1);
                                dimcd.enterCrossStreet2ForOtherLocationInMCDWindow(crossStreet2);
                                dimcd.enterCityForOtherLocationInMCDWindow(cityName);
                                dimcd.enterValueInStateInMCDWindow(state);
                                break;
                            case "POI":
                                reporter.SuccessReport("******Search Criteria of*******", Validation + " ***************Search*************");
                                dimcd.enterLocationNameInTowDestinationInMCDWindow(towLocationName);
                                dimcd.enterCityForOtherLocationInMCDWindow(cityName);
                                dimcd.enterValueInStateInMCDWindow(state);
                                break;
                            case "specialcharacter":
                                reporter.SuccessReport("******Search Criteria of*******", Validation + " ***************Search*************");
                                dimcd.enterValueInStreetNumberInMCDWindow(streetNumber);
                                dimcd.enterValueInStreetNameInMCDWindow(streetName);
                                dimcd.enterCityForOtherLocationInMCDWindow(cityName);
                                dimcd.enterValueInStateInMCDWindow(state);
                                break;
                            case "reverse":
                                dimcd.enterLatitudeInMCD(latitude);
                                dimcd.enterLongitudeInMCDWindow(longitude);
                                break;
                        }
                        dimcd.clickOnVerifyButtonInMemberHome();
                        boolean errorAvailabilityInManual = dimcd.ValidatedOnErrorOkayButtonInMCDWindow();
                        if(errorAvailabilityInManual){//IT will handle Error mesages if given address not return valies
                            String errorMessageForManualEntry=dimcd.getErrorMessageOnAlertInManualEntryInOthersTab();
                            reporter.failureReport("Address not verified","<b>Address Not Verified Because of:: "+errorMessageForManualEntry+"</b>",driver);

                            dimcd.clickOnErrorOkayButtonInMCDWindow();
                        }else {
                            boolean verified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(verified, "Address Verified");
                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();
                            String random = getRandomString(15);
                            String comments = dimcd.enterCommentsInTowDestinationTabInMCDWindow(random);
                            dimcd.enterStatusReasonsInTowDestionation(reasonForStatus);
                            dimcd.clickOnSumbitButton();
                            boolean errorAvailability = dimcd.ValidatedOnErrorOkayButtonInMCDWindow();
                            if (errorAvailability) {
                                String error=dimcd.validateErrorMessage();
                                reporter.failureReport("Recor not saved","Record not saved "+error,driver);
                                dimcd.clickOnErrorOkayButtonInMCDWindow();
                                assertFalse(errorAvailability, "Record Not saved");
                            } else {
                                //Validating the comments
                                String commentsFromCommentsSection=dimcd.getCommentsFromCommentsWindow(comments);
                                assertTrue(commentsFromCommentsSection.equalsIgnoreCase(comments),"<b>Both entered comments:: "+comments+" ::and Saved comments:: "+commentsFromCommentsSection+" ::are same</b>");
                                dimcd.clickOnStatusHistoryLinkOnMCDWindow();
                                dimcd.clickOnDateHeaderToSortDate();
                                dimcd.getStatusInHistoryStatusScreenInMCDWindow();
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            case "Member":
                dimcd.clickOnMemberHome();
                dimcd.clickOnVerifyButtonInMemberHome();
                dimcd.getValueOfLatitudeInMCD();
                dimcd.getValueOfLongitudeInMCD();
                boolean verified = dimcd.getAddressVerifiedInTowInMCD();
                assertTrue(verified, "Address Verified");

                String random = getRandomString(15);
                String comments = dimcd.enterCommentsInTowDestinationTabInMCDWindow(random);
                dimcd.enterStatusReasonsInTowDestionation(reasonForStatus);

                dimcd.clickOnSumbitButton();

                boolean errorAvailability = dimcd.ValidatedOnErrorOkayButtonInMCDWindow();

                if (errorAvailability) {
                    dimcd.validateErrorMessage();
                    //crHomeLib.getErrorMessageTextFromAlert();
                    dimcd.clickOnErrorOkayButtonInMCDWindow();
                    assertFalse(errorAvailability, "Record Not saved");
                } else {

                    String commentsFromCommentsSection=dimcd.getCommentsFromCommentsWindow(comments);
                    assertTrue(commentsFromCommentsSection.equalsIgnoreCase(comments),"<b>Both entered comments:: "+comments+" ::and Saved comments:: "+commentsFromCommentsSection+" ::are same</b>");

                    dimcd.clickOnStatusHistoryLinkOnMCDWindow();
                    dimcd.clickOnDateHeaderToSortDate();
                    dimcd.getStatusInHistoryStatusScreenInMCDWindow();
                }
                break;
            case "Repair":
                dimcd.clickOnRepairFacility();

                switch (searchBy) {//Search By is used to validate differnt types of search types in repair section
                    case "NoCriteria":
                        reporter.SuccessReport("******Search Criteria of*******", Validation + " ***************Search*************");

                        dimcd.clickOnShowSearchCriteriaLink();
                        String milesValue=dimcd.getValueOfMilesFromSearchCriteriaInRepairTab();
                        dimcd.clickOnSearchIcon();
                        /*dimcd.clickOnHideSearchCriteriaLink();*/
                        boolean emptryRecords = dimcd.getEmptryRecordErrorMessageInTowDestinationInMCD();
                        if (emptryRecords == false) {
                            dimcd.verifyTowMilesForBasicLevellessThanGivenMiles(milesValue);
                            dimcd.clickOnLocationValueInTowDestinationResultsInMCDWindow();
                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();
                            boolean addverified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(addverified, "Address Verified");

                        }else{
                            reporter.failureReport("No Records","No Records found",driver);
                        }

                        break;
                    case "twentyMiles":

                        dimcd.clickOnShowSearchCriteriaLink();
                        String enterMiles=dimcd.enterValueOfMilesFromSearchCriteriaInRepairTab(miles);
                        dimcd.clickOnHideSearchCriteriaLink();
                        dimcd.clickOnSearchIcon();
                        boolean emptryRecordsTwentyMiles = dimcd.getEmptryRecordErrorMessageInTowDestinationInMCD();
                        if (emptryRecordsTwentyMiles == false) {
                            dimcd.verifyTowMilesForBasicLevellessThanGivenMiles(enterMiles);
                            dimcd.clickOnLocationValueInTowDestinationResultsInMCDWindow();
                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();
                            boolean addverified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(addverified, "Address Verified");
                        }else{
                            reporter.failureReport("No Records","No Records found",driver);
                        }
                        break;
                    case "RepairFacility":

                        dimcd.enterAddressInSearvicesInMCDWindow(addressSearch);
                        dimcd.clickOnSearchButtonInServicesInMCDWindow();
                        boolean emptryRecord = dimcd.getEmptryRecordErrorMessageInTowDestinationInMCD();
                        if (emptryRecord == false) {
                            dimcd.verifyFacilityTypeInRepairFacilityTabInTowDestination(addressSearch);
                            dimcd.clickOnLocationValueInTowDestinationResultsInMCDWindow();
                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();
                            boolean addverified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(addverified, "Address Verified");
                        } else {
                            reporter.failureReport("No Records","No Records found",driver);
                        }
                        break;
                    case "TRC":
                        dimcd.clickOnShowSearchCriteriaLink();
                        dimcd.selectTRCCheckBox();
                        dimcd.clickOnSearchIcon();
                        boolean emptryRecordTRC = dimcd.getEmptryRecordErrorMessageInTowDestinationInMCD();
                        if (emptryRecordTRC == false) {
                            dimcd.verifyTRCRecordsInReapirFacilityResultsInTowDestionation();
                            dimcd.clickOnLocationValueInTowDestinationResultsInMCDWindow();
                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();
                            boolean addverified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(addverified, "Address Verified");
                        }else{
                            reporter.failureReport("No Records","No Records found",driver);
                        }
                        break;
                    case "AAR":
                        dimcd.clickOnShowSearchCriteriaLink();
                        dimcd.selectAARCheckBox();
                        dimcd.clickOnSearchIcon();
                        boolean emptryRecordAAR = dimcd.getEmptryRecordErrorMessageInTowDestinationInMCD();
                        if (emptryRecordAAR == false) {
                            dimcd.verifyAARRecordsInReapirFacilityResultsInTowDestionation();
                            dimcd.clickOnLocationValueInTowDestinationResultsInMCDWindow();
                            dimcd.getValueOfLatitudeInMCD();
                            dimcd.getValueOfLongitudeInMCD();
                            boolean addverified = dimcd.getAddressVerifiedInTowInMCD();
                            assertTrue(addverified, "Address Verified");
                        }else{
                            reporter.failureReport("No Records","No Records found",driver);
                        }
                        break;
                }

            default:
                break;
        }

    }
}
