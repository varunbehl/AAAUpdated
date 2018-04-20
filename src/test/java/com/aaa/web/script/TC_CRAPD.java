package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.text.DecimalFormat;
import java.util.Hashtable;


public class TC_CRAPD extends DILoginLib {
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

    public void crAPD(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crAPD", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
					fnOpenTest();
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount = intCounter;
					Hashtable<String, String> data = TestUtil.getDataByRowNo("crAPD", TestData, "D3CallRecieving", intCounter);

					this.reporter.initTestCaseDescription("1956: CRAPD " + " From Iteration " + StartRow + " to " + EndRow);
					reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + " and this validation is for  "  +data.get("ValidationFor")+" and pacesetter Code is  "+data.get("ProblemType")+"  **************");
					CRHomeLib home = new CRHomeLib();
					CRMemberSearchLib member = new CRMemberSearchLib();
					CRLocationsLib locations = new CRLocationsLib();
					CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
					CRServiceLib services = new CRServiceLib();
					CommonLib common = new CommonLib();
					CRSearchCallsLib searchcall=new CRSearchCallsLib();
					CRAPDLib apd=new CRAPDLib();

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
						reporter.failureReport("Null returned by used Query" , data.get("dbqueryFileName") + " ::Query not return Member number");
					} else {
                        home.memberSearchTextBox(Member);
                        member.memberNumClick();
                        locations.breakdownLocTabSel();
                        locations.enterBreakDownAddressOmniBarSearch(data.get("OmniBarAddress"));
                        locations.getLatitudeValue();
                        locations.getLongitudeValue();
                        common.crVehicleTriageTab(data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("vehicleType"), data.get("ProblemTriage"), data.get("ProblemType"));
                        /*vehicle.handleScriptErrorInVehicleTriagePage();
                        home.allErrorAlerts();*/

                        common.crTowDestinationTab(data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"));
                        services.clickOnServiceTab();
                        //Verifying APD Greyedout Button
                        boolean disabledAPDButton=home.verifyAPDGrayButton();
                      	assertTrue(disabledAPDButton,"APD button is greyed out and not clickable");
                        home.saveButton();
                        home.allErrorAlerts();
                        callID = services.getCallId();
                        //Remain in call to update the call details to view the field audit
                        services.clickOnRemainInCall();
                        //Clicking on APD button
                        home.clickOnAPDButton();
                        boolean apdWindowAvailablity=apd.verifyAPDWindowAvailablity();
						if(apdWindowAvailablity)
                        {
							apd.getAPDWindowTitle();
							String calculatedDistance=apd.getCalculatedDistanceLable();
							reporter.SuccessReport("Availablity of Calculated Distance","Calculated Distance "+calculatedDistance);
							//To Location
							boolean locationLabel=apd.verifyToLocationLable();
							assertTrue(locationLabel,"Location Label is available");
							apd.getLblToLocation();
							String locationValue=apd.getToLocationValue();
							//Towed
							boolean availablityOfTowLable=apd.verifyTowedLabel();
							assertTrue(availablityOfTowLable,"Tow Label is available");
							apd.gettoTowedLabel();
							Thread.sleep(2000);
							String TowValue=apd.getToTowedValue();
							//Total
							boolean availablityOfTotalLabel = apd.verifyTotalLabel();
							assertTrue(availablityOfTotalLabel,"Total Lable is available");
							apd.gettoTotalLabel();
							String Total=apd.getTotalValue();

							//Validating DISTANCE Override Section
							boolean availablityOfDistanceOverRideLabel=apd.verifyDistanceOverRide();
							assertTrue(availablityOfDistanceOverRideLabel,"Distance OverRide Label is available");
							boolean availablityOfToScene=apd.verifyToScene();
							assertTrue(availablityOfToScene,"To Scene is available");
							boolean availablityOfToScenetextBox=apd.verifyToSceneTextField();
							assertTrue(availablityOfToScenetextBox,"to scene Text box is available ");
							boolean availablityOfPayableTowMilesLable=apd.verifyPayableTowMiles();
							assertTrue(availablityOfPayableTowMilesLable,"Payable Tow miles");
							boolean availablityOfPayableTowMilesTextBox=apd.verifyPayableTowMilesTetBox();
							assertTrue(availablityOfPayableTowMilesTextBox,"Payable Tow mules text box");
							boolean availablityOfMillageComments=apd.verifyMillageComments();
							assertTrue(availablityOfMillageComments,"Millage comments text box");
							//Validating Distance Section
							boolean availablityOfDistanceLavle=apd.verifyDistanceLabel();
							assertTrue(availablityOfDistanceLavle,"Distance lable is available");
							boolean availablityOfDistanceTo=apd.verifyDistanceToLabel();
							assertTrue(availablityOfDistanceTo,"Availablity Of Distance To");
							String DistanceToValue=apd.getDistanceToValue();
							boolean availablityOfTowDestination=apd.verifyFinalDistanceToLabel();
							assertTrue(availablityOfTowDestination,"Availability of Tow Destination ");
							String towDestinationValue=apd.getTowDestionataionValue();
							boolean AvailablityOfTotal=apd.verifyFinalTotal();
							assertTrue(AvailablityOfTotal,"Availablity Of Total Distance");
							String finalTotalDistance=apd.getFinalTotalDistanceValue();
							double FinalTotalvalue = Double.parseDouble(finalTotalDistance);
							DecimalFormat twoDecimal = new DecimalFormat("##.00");
							double totalValue = Double.parseDouble(Total);
							String toLocationTotal=twoDecimal.format(totalValue);
							String finalTotal=twoDecimal.format(FinalTotalvalue);
							double towValueFinal = Double.parseDouble(towDestinationValue);
							String towFinalValue=twoDecimal.format(towValueFinal);
							double towValueToLocation = Double.parseDouble(TowValue);
							String towToLocationValue=twoDecimal.format(towValueToLocation);
							//Calculated Distances & Distances Step 8,9,10,11 (
							assertTrue(finalTotal.equals(toLocationTotal),toLocationTotal+"Total value and final total distance is same"+finalTotal);
							assertTrue(DistanceToValue.equals(locationValue),locationValue+"Both Values are same"+DistanceToValue);
							assertTrue(towFinalValue.equals(towToLocationValue),locationValue+"Both Values are same"+DistanceToValue);
							//Step 12: Distance Override & Distances
							String DistanceToSceneValue=apd.enterToSceneInDistanceOverRideSection(data.get("toScene"));
							String getToScene=apd.getToSceeneValueInDistanceOverRideSection();
							//**********
							assertTrue(!getToScene.isEmpty(),"to Scene text field is editable");
							String miles=apd.enterPayableMilesInDistanceOverRideSection(data.get("miles"));
							String getPayableMiles=apd.getPayableMilesInDistanceOverRideSection();
							assertTrue(!getPayableMiles.isEmpty(),"Payable Miles is editable");
							String ran=getRandomString(10);
							apd.enterMillageCommentsInDistanceOverRideSection(ran);
							String millageComments=apd.getMillageCommentsInDistanceOverRideSection();
							assertTrue(!millageComments.isEmpty(),"Millage Comments are editable");
							String distanceTo=apd.getDistanceTOInDistanceSection();
							//Cpmaring Distance OverRIde distanceTo value and Distance Distance To Value
                            assertTrue(distanceTo.equals(DistanceToSceneValue),distanceTo+" ::Distanceover ride value is matched with distance value::  "+DistanceToSceneValue);
                            apd.enterDistanceTOInDistanceSection(data.get("distanceTo"));
							String distanceToo=apd.getDistanceTOInDistanceSection();
							assertTrue(!distanceToo.isEmpty(),"Millage Comments text box is editable");
							apd.getDistanceToValue();
							apd.enterTowInDistanceSection(data.get("tow"));
							String tow=apd.getTowInDistanceSection();
							assertTrue(!tow.isEmpty(),"Tow Distance is editable");
							apd.enterTotalInDistanceSection(data.get("total"));
							String total=apd.getTotalInDistanceSection();
							assertTrue(!total.isEmpty(),"Total text box is editable");
                            boolean availablityOfUnit=apd.availablityOfUnitsLable();
                            assertTrue(availablityOfUnit,"Units Fields are available");
                            boolean availablityOfService=apd.availablityOfServicesLable();
                            assertTrue(availablityOfService,"Service Fields are available");
                            boolean availablityOfUnitofMes=apd.availablityOfUnitOfMesurenemtnLable();
                            assertTrue(availablityOfUnitofMes,"Unit of measurement Fields are available");
                            boolean availablityOfCost=apd.availablityOfCostLable();
                            assertTrue(availablityOfCost,"Cost Fields are available");
                            boolean availablityOfCashCollected=apd.availablityOfCashCollectedLable();
                            assertTrue(availablityOfCashCollected,"CashCollected Fields are available");
                            boolean availablityOfDispatchApproval=apd.availablityOfDispatchApproval();
                            assertTrue(availablityOfDispatchApproval,"Dispatcher approval Fields are available");
                            //Get list of Services from drop down list
							apd.getListOfSerevicesDropdown();
							apd.enterServiceInServicesandChargersSection();
							apd.clickOnUnitOfMeasurement();
							String unit=apd.getUnitOfMeasurement();
							apd.enterValueInUnitTextField(data.get("unit"));
							boolean costField=apd.availabilityOfDisabledCostTextField();
							assertTrue(costField,"Cost Field is in readonly mode");
							apd.clickOnSaveButton();
							boolean availablityOfSavedToolTip=apd.verifySavedToolTip();
							assertTrue(availablityOfSavedToolTip,"Saved Tool Tip appeared");
							//Verifying SavedTool tip afterclicking on save button
							apd.getSavedToolTipMessage();
                            boolean availablityOfMemberLevel=apd.availablityOfMemberLevelIcon();
                            assertTrue(availablityOfMemberLevel,"Member Level Icon is available");
                            common.waitcloseAllNotifications();
                            apd.clickOnSaveCloseButton();
                            //Verifying Save tool tip message after clicking on SaveAndCLose Button
                            boolean savedMessage=apd.verifySavedToolTip();
                            assertTrue(!savedMessage,"Saved tooltip is not available");
							//Click on APDBUtton to verify close with out saving theedited values
                            home.clickOnAPDButton();
                            //Validating Saved information after Clicking on SaveClose Button
                            String getToSceneAfterSave=apd.getToSceeneValueInDistanceOverRideSection();

                            assertTrue(getToSceneAfterSave.equals(data.get("toScene")),getToSceneAfterSave+" ::Modified data is saved:: "+data.get("toScene"));
                            //Validating saved information by clicking on close button (With out save)
                            String toScenceValueForNotToSave=apd.enterToSceneInDistanceOverRideSection(data.get("miles"));
                            common.waitcloseAllNotifications();
                            apd.clickOnCloseButton();
                            home.allErrorAlerts();
                            home.clickOnAPDButton();
                            String getToSceneWithOutSave=apd.getToSceeneValueInDistanceOverRideSection();
                            assertTrue(!toScenceValueForNotToSave.equals(getToSceneWithOutSave),"Modified Data is not saved");
                            apd.clickOnCloseButton();
                            //Validating Member Number label
                            home.clickOnAPDButton();
                            boolean availablityOfMemberLevelSecondAP=apd.availablityOfMemberLevelIcon();
                            assertTrue(availablityOfMemberLevelSecondAP,"Member Level Icon is available");
                            apd.clickOnCloseButton();
                            home.logout();
						}else {
							reporter.failureReport("APD Windows not visible", "APD Window not visible", driver);
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
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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