package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Hashtable;


public class TC_CRRentalCarBookings extends DILoginLib {
    public static String callID;
    public static int totalnumberOfSpecialEquipment;


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: crAPD
     * description ::
     * date :: 11-04-2018
     * author :: Chandu Dendukuri
     */

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void crRentalCar(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crRentalCar", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("crRentalCar", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1939: CR Rental Car Bookings " + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + " and this validation is for  "  +data.get("ValidationFor")+" and pacesetter Code is  "+data.get("ProblemType")+"  **************");
					CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CommonLib common = new CommonLib();
					CRSearchCallsLib searchcall=new CRSearchCallsLib();
					CRRentalCarLib rental=new CRRentalCarLib();

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
						reporter.failureReport("Member number", data.get("dbqueryFileName") + " ::Query not return Member number");
					} else {
                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        locations.getLatitudeValue();
                        locations.getLongitudeValue();
                        searchcall.clickOnCurrentCallsDropDown();
                        rental.selectRentalCar();
                        waitcloseAllBusyIcons();
                        boolean visibilityOfPickUplocation=rental.availablityOfPickupLocation();
                        if(visibilityOfPickUplocation) {
                                    rental.clickOnPickUpLocationLink();
                                    //rental.getMilsAndCompareSorting();
                                    rental.getMilesValuesFromPickupLocation();
                                    rental.clickOnShowDetailsLink();
                                    //Validating Phone number ad Hoirs of operations details
                                    rental.getPhoneNumberLabelFromPickUpLocation();
                                    rental.getHoursOfOperationsDetailsFromPickUpLocation();
                                    rental.clickOnVehicleDetailsHeader();
                                    //Get and Compare vehicle Types with expected values
                                    rental.validateVehicleTypes();
                                    //Verify pickup date time
                                    rental.getPickupDateTime();
                                    rental.clickOnPickupArrow();
                                    //Enter Date and Time
                                    String currentDate = common.getCurrentDate();
                                    String date=common.getNextDay(currentDate);
                                    rental.enterPickupDate(date);
                                    common.tabout();
                                    rental.enterPickupTime(data.get("time"));
                                    common.tabout();
                                    rental.getDropOfDateTime();
                                    rental.clickOnDropOfOption();
                                    boolean autoCheckBox=rental.verifyAutoSelectedDropOfCheckBox();
                                    assertTrue(autoCheckBox,"Check box is auto selected");
                                    rental.clickOnAutoSelectedDropOfCheckBoxToDeselect();
                                    boolean autoCheckBoxSelected=rental.availablityOfDateInDropOfDateField();
                                    assertTrue(autoCheckBoxSelected,"Deselected CheckBox without errors");
                                    rental.enterDateInDropOfDateField(date);
                                    common.tabout();
                                    rental.enterTimeInDropOfTimeField(data.get("time"));
                                    common.tabout();
                                    rental.clickOnDOPoint();
                                    boolean autoSelected=rental.verifyDefaultSelectionOfSameAsPickupLocation();
                                    assertTrue(autoSelected,"Same as Pickup location check box is selected by default");
                                    rental.clickOnDOPoint();
                                    Thread.sleep(2000);
                                    rental.clickOnGoldMemberIcon();
                                    rental.enterGoldMember(Member);
                                    rental.clickOnGoldMemberIcon();
                                    rental.getReservicationDetails();
                                    reporter.failureReport("Alert icon","Alert Icon is not available to view the warning messages",driver);
                                    reporter.failureReport("Place Reservation Button","Place Reservation Button is not available",driver);

                                    boolean thriftyTab=rental.availablityOfThriftyTab();
                                    if(thriftyTab) {
                                        reporter.failureReport("Thrifty Tab", "Thrifty Tab is not clickable'",driver);
                                    }
                                    boolean dollarTab=rental.availablityOfDollarTab();
                                    if(dollarTab) {
                                        reporter.failureReport("Dollar Tab", "Dollar Tab is not clickable'",driver);
                                    }
                                    rental.clickOnCloseButtonToCloseRentACarWIndow();

                                    common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"));
                                    vehicle.handleScriptErrorInVehicleTriagePage();
                                    home.allErrorAlerts();

                                    home.clickOnCallSummaryButton();
                                    home.getTroubleCodeValueFromCallDetailsPopup();
                                    home.closeCallSummaryPopupWindow();

                                    common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                                    //services.clickOnServiceTab();
                                    home.saveButton();
                                    home.allErrorAlerts();
                                    callID = services.getCallId();
                                    services.closeCall();
                                    home.logout();
                                    reporter.SuccessReport("Call Created number : ","<b>**************::  "+ intCounter+" Call(s) Created **************</b>");

                        }else {
                            reporter.failureReport("Rent a Car Page availablity", "Rent a Car Page is not Opened",driver);
                            home.logout();
                        }

					}
				}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
					reporter.failureReport("Execption Occured","Execption Occured",driver);
					reporter.warningReport("Error Description"," "+e.toString());

				}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1939 ",ReportStatus.strMethodName,intCounter,browser);
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