/*
package com.aaa.web.script;

import com.aaa.e2e.script.CR_DI;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDEditBreakDownlocations extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;

    @DataProvider
    public Object[][] getTestDataFor_DIMCDEditBreakDownlocations() {
        return TestUtil.getData("DIMCDEditBreakDownlocations", TestData, "D3Dispatch");
    }

    @Test(dataProvider = "getTestDataFor_DIMCDEditBreakDownlocations")

    public void DIMCDEditBreakDownLocation(Hashtable<String, String> data) throws Throwable {

        try {

            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("2298: TS-DI MCD Edit Breakdown Location");

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
                LoginRoleLib loginRole = new LoginRoleLib();
                DILoginLib diLogin = new DILoginLib();
                CommonLib common = new CommonLib();

                navigateToApplication("DI");
                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
                    diLogin.waitcloseAllBusyIcons();
                    diHome.clickOnCloseIconOnQueueSelection();
                } else {
                    diLogin.waitcloseAllBusyIcons();
                    diHome.closeFacilityWindow();
                }
                diHome.clickOnSearchCallsLink();

//entering values in searchcalls
                diSearchCalls.enterStartDate(data.get("startDate"));
                diSearchCalls.enterEndDate(data.get("endDate"));
                diSearchCalls.enterValueInStatusTextBonInSearchCalls(data.get("status"));
                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
                diSearchCalls.selectSPStatusRowInSearchCallDispatch();
                dimcd.clickOnLocationsTabInMCDWindow();
                dimcd.clickOnBreakDownLocationsEditLinkInMCD();

                dimcd.enterAddressInSearvicesInMCDWindow(data.get("addressSearch"));
                dimcd.clickOnSearchButtonInServicesInMCDWindow();
                boolean emptryRecords = dimcd.getEmptryRecordErrorMessageInMCD();
                boolean recordsPanelNotFound = dimcd.verifySearchResultsGridAvailablity();
                boolean insufficetData = dimcd.validateInsufficientInformationError();
                if(insufficetData==false) {

                    if (emptryRecords == true || recordsPanelNotFound == true) {
                        String searchedAddress = dimcd.getAddressFromResults();
                        dimcd.clickOnTowDestinationAddressInResultsGrid();
                        dimcd.getValueOfStreetNumberInMCDWindow();
                        dimcd.getValueOfStreetNameInMCDWindow();
                        dimcd.getValueOfCityInMCD();
                        dimcd.getValueOfFirstCrossStreetInMCD();
                        dimcd.getValueOfSecondCrossStreetInMCD();
                        dimcd.getValueOfStateInMCD();
                        dimcd.getValueOfZipInMCD();
                        dimcd.getValueOfLandMarkInMCD();
                        dimcd.getValueOfLatitudeInMCD();
                        dimcd.getValueOfLongitudeInMCD();
                        if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
                            dimcd.getAddressVerifiedInMCD();
                        } else {
                            //dimcd.clickOnGetCoOrdinatesInMCD();
                            dimcd.getAddressVerifiedInMCD();
                        }
                        String random = getRandomString(15);
                        String comments = dimcd.enterCommentsInTowDestinationAndLocationsTabsInMCDWindow(random);
                        dimcd.enterUpdateReasonInMCD(data.get("reasonForStatus"));
 String reasonForStatus = dimcd.enterReasonForStatus(data.get("reasonForStatus"));
                String comments = dimcd.enterCommentsInUpdateCallStatus(data.get("comments"));



                        dimcd.clickOnSaveButtonInMCDWindow();
                        boolean errorAvailability = dimcd.verifyErrorMessageAvailability();
                        if (errorAvailability) {
                            dimcd.validateErrorMessage();
                            //crHomeLib.getErrorMessageTextFromAlert();
                            dimcd.clickOnErrorOkayButtonInMCDWindow();
                            assertFalse(errorAvailability, "Record Not saved");
                        } else {
                            //dimcd.closeBreakDownLocaitonTabInMCD();
                            if ((data.get("sppUser").equalsIgnoreCase("Yes"))) {
                                String latestComments = dimcd.getlblLatestCommentsInMCDWindow();
                                Boolean resultsForComments = latestComments.equalsIgnoreCase(comments);
                                assertTrue(resultsForComments, "Comments are saved in comments section");
                            } else {
                                String latestComments = dimcd.getSecondRowCommentsInCommentsSectionInMCDWindow();
                                Boolean resultsForComments = latestComments.equalsIgnoreCase(comments);

                                if (resultsForComments == false) {
                                    String latestCommentsFirstrow = dimcd.getlblLatestCommentsInMCDWindow();
                                    Boolean resultsForCommentsFirstRow = latestCommentsFirstrow.equalsIgnoreCase(comments);
                                    assertTrue(resultsForCommentsFirstRow, "Comments are saved in comments section");
                                }
                                assertTrue(resultsForComments, "Comments are saved in comments section");
                            }


                            dimcd.clickOnStatusHistoryLinkOnMCDWindow();
                            dimcd.clickOnDateHeaderToSortDate();
                            dimcd.getStatusInHistoryStatusScreenInMCDWindow();

                        }
                    } else {
                        assertTrue(emptryRecords || recordsPanelNotFound, " Records found");

                    }
                }else
                {
                    dimcd.getInsufficientInformationError();
                    assertTrue(insufficetData, " insufficent data entered");
                    dimcd.clickOn306ErrorOkayButton();
                }


                dimcd.clickOnMCDCloseWindow();
                diHome.logOut();

                System.out.println("Test completed");
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
*/
