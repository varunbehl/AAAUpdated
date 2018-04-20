package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIQueueSelection extends DILoginLib {
        String queueSecondValue;
        String queueFirstValue;
        String selectedFirstValue;
        String spotQueueFirstValue;
        String spotSelectedQueueFirstValue;
        int records;
        int recordsVerify;
        String queueFirstValueNotAdded;

	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithValidUserNameAndInvalidPassword
     * description :: valdUsernamewithInvalidPassword
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIQueueSelection(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIQueueSelection", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("DIQueueSelection", TestData, "D3Dispatch", intCounter);

                    this.reporter.initTestCaseDescription("2031-TS-DI Queue Selection" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");

                    CRHomeLib home = new CRHomeLib();
                    LoginRoleLib role = new LoginRoleLib();
                    DIHomeLib diHome = new DIHomeLib();
                    CRHomeLib crHomeLib = new CRHomeLib();
                    CRMemberSearchLib member = new CRMemberSearchLib();
                    CRLocationsLib locations = new CRLocationsLib();
                    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
                    CRServiceLib services = new CRServiceLib();
                    DIMCDLib dimcdLib = new DIMCDLib();

                    navigateToApplication("DI");
                    waitcloseAllBusyIcons();
                    login(data.get("DILoginName"), data.get("Password"));
                    boolean proccedButton = role.verifyVisibilityOProceedBtnInDispatchRoleLogin();
                    if (proccedButton)
                        {
                            role.clickOnProceedBtnInDispatchRoleLogin();
                        }
		                waitcloseAllBusyIcons();
		                //Verifying for DI Queue selection window
		                boolean queue= diHome.getQueueSelectionLable();
		                if(queue) {
                            assertTrue(queue, "<b>Queue selection popup appeared</b>");
                            //DISPATCH QUEUE
                            diHome.clickOnDispatchTab();
                            diHome.clickOnRemoveAll();
                            //Selecting and saving the first value name into string
                            queueFirstValue = diHome.getDispatchQueueFirstFieldValue();
                            //Clicking on the add button to move the value from Queue selection to Selection window
                            diHome.clickOnAddButtonOnQueueWindow();

                            //Searching the for the moved value in selected filter text box
                            diHome.enterValueInQueueFilterSelected(queueFirstValue);
                            selectedFirstValue = diHome.getQueueFieldFirstItemInSelected();
                            //Comparing both the values
                            diHome.compareDispatchAndSelectedValues(queueFirstValue, selectedFirstValue, "Dispatch", "Selected");

                            //Select the first value of selected item and clicking on the remove button to move back to Queue selection
                            diHome.getQueueFieldFirstItemInSelected();
                            diHome.clickOnRemoveButtonOnQueueWindow();
                            //Verifying the removed values is queue selection using filter search and comparing the same
                            diHome.enterValueInQueueFilterDispatch(selectedFirstValue);
                            diHome.compareDispatchAndSelectedValues(queueFirstValue, selectedFirstValue, "Selected", "Dispatch");
                            //Clicking on select all link to verify all highlighted values in queue selection
                            //SELECT ALL
                            diHome.clickOnSelectAllLinkOnQueueWindow();
                            diHome.getFieldItemHighlightStatusCount();
                            //adding all highligted values into selected section and checking for the empty records
                            diHome.clickOnAddButtonOnQueueWindow();
                            diHome.verifyEmptyRecordsInDispatch();
                            //clicking on the Remove all link to remove all the values from selected to Queue selection area and verifying the empty records in selected
                            //REMOVE ALL
                            diHome.clickOnRemoveAll();
                            diHome.verifyEmptyRecordsInSelected();
                            //Verifying the drag and drop functionality from dispatch queue to selected section
                            //DRAG AND DROP
                            diHome.verifyDragDropFunctionalityForDispatch();
                            diHome.clickOnContinueQueuesInDispatch();
                            waitcloseAllBusyIcons();
                            //clicking on the change set queue menu item from application dropdown
                            diHome.selectChangeSetQueueMenuItem();
                            //Clicking on the SPOT tab to repeat 2 - 10 steps

                            diHome.clickOnSpotTab();
                            spotQueueFirstValue = diHome.getSpotQueueFirstFieldValue();
                            diHome.clickOnAddButtonOnQueueWindow();
                            diHome.enterValueInSelectedFilterSpot(spotQueueFirstValue);
                            spotSelectedQueueFirstValue = diHome.getSpotSelectedQueueFirstFieldValue();
                            diHome.compareDispatchAndSelectedValues(spotQueueFirstValue, spotSelectedQueueFirstValue, "Spot", "Selected");
                            diHome.clickOnRemoveButtonOnQueueWindow();
                            diHome.enterValueInQueueFilterSpot(spotSelectedQueueFirstValue);
                            diHome.compareDispatchAndSelectedValues(spotQueueFirstValue, spotSelectedQueueFirstValue, "Selected", "Spot");
                            diHome.clickOnSelectAllLinkOnSpotQueueWindow();
                            diHome.getFieldItemHighlightStatusCountInSpot();
                            diHome.clickOnAddButtonOnQueueWindow();
                            diHome.verifyEmptyRecordsInSpotQueue();
                            diHome.clickOnRemoveAll();
                            diHome.verifyEmptyRecordsInSpotSelected();
                            diHome.verifyDragDropFunctionalityForSpot();

                            //selecting first 2 values in Queue selection under Dispatch TAB
                            diHome.clickOnDispatchTab();

                            diHome.getDispatchQueueFirstFieldValue();
                            diHome.getDispatchQueueSecondFieldValue();
                            //selecting first 2 values in Queue selection under Spot TAB
                            diHome.clickOnSpotTab();
                            diHome.getSpotQueueFirstFieldValue();

                            //click On Add button to add the selected values
                            diHome.clickOnAddButtonOnQueueWindow();

                            records = diHome.verifyRecordsCountInSpotSelected();
                            //click on continue button to save the changes

                            //CONTINUE BUTTON
                            diHome.clickOnContinueQueuesInDispatch();

                            //diHome.selectChangeSetQueueMenuItem();

                            diHome.selectChangeSetQueueMenuItem();
                            recordsVerify = diHome.verifyRecordsCountInSpotSelected();
                            diHome.compareSavedRecordsSize(records, recordsVerify);
                            waitcloseAllBusyIcons();
                            diHome.clickOnDispatchTab();
                            queueFirstValueNotAdded = diHome.getDispatchQueueFirstFieldValue();
                            diHome.clickOnCloseButtonOnQueueWindow();
                            //click on logout link to logout from the application
                            diHome.logOut();
                            //reLogin into the application
                            waitcloseAllBusyIcons();
                            login(data.get("DILoginName"), data.get("Password"));

                            if (proccedButton)
                            {
                                role.clickOnProceedBtnInDispatchRoleLogin();
                            }
                            waitcloseAllBusyIcons();
                            diHome.clickOnDispatchTab();
                            //CLOSE BUTTON
                            diHome.enterValueInQueueFilterSelected(queueFirstValueNotAdded);
                            diHome.verifyEmptyRecordsInSelected();
                            queueFirstValueNotAdded = diHome.getDispatchQueueFirstFieldValue();
                            diHome.clickOnCloseIconOnQueueSelection();

                            diHome.logOut();
                            waitcloseAllBusyIcons();
                            login(data.get("DILoginName"), data.get("Password"));
                            if (proccedButton)
                            {
                                role.clickOnProceedBtnInDispatchRoleLogin();
                            }
                            waitcloseAllBusyIcons();
                            diHome.clickOnDispatchTab();
                            diHome.enterValueInQueueFilterSelected(queueFirstValueNotAdded);
                            diHome.verifyEmptyRecordsInSelected();
                            queueFirstValueNotAdded = diHome.getDispatchQueueFirstFieldValue();
                            diHome.clickOnDispatchQueuePopup();
                            String combineKeys1 = Keys.chord(Keys.ESCAPE);
                            sendKeys(combineKeys1, "Esc");
                            diHome.clickOnCloseIconOnQueueSelection();
                            //DISPATCH QUEUE USER PROFILE
                            diHome.selectUserProfileMenuItem();
                            diHome.verifyUserProfilePopupWindow();
                            boolean tableListing=diHome.verifyUserProfileTableListing();
                            assertTrue(tableListing,"<b>Table listing available with all loaded queue</b>");
                            diHome.clickOnChangeEditQueueSelection();
                            diHome.clickOnCloseButtonOnQueueWindow();
                            crHomeLib.messageDialogBoxClose();
                            diHome.logOut();
                        }else{
		                    reporter.failureReport("DI Queue Selection window","Window not appeared");
                            diHome.logOut();
                        }
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2031",ReportStatus.strMethodName,intCounter,browser);
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
