package com.aaa.web.lib;


import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRFieldAuditPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CRFieldAuditLib extends ActionEngine {

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectFieldAuditPage
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

    public void selectFieldAuditPage() throws Throwable {
    	waitForVisibilityOfElement(CRFieldAuditPage.lnkFieldAudit,"Field Audit Number");
    	click(CRFieldAuditPage.lnkFieldAudit,"Field Audit Number");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnNewValueSortingIcon
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public void clickOnNewValueSortingIcon() throws Throwable {
		waitForVisibilityOfElement(CRFieldAuditPage.iconSortingNewValueColoumn,"Sorting new value");
		click(CRFieldAuditPage.iconSortingNewValueColoumn,"Sorting new value");
		click(CRFieldAuditPage.iconSortingNewValueColoumn,"Sorting new value");
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getFieldAuditValues
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public void getFieldAuditValues() throws Throwable {
		waitForVisibilityOfElement(CRFieldAuditPage.lblFieldAuditrowResults,"Audit values");
		List<WebElement> newValue = null;
		List<WebElement> oldValue = null;
		List<WebElement> fieldName = null;
		List<WebElement> changedBy = null;
		List<WebElement> date = null;
		newValue = getWebElementList(CRFieldAuditPage.lblNewValue, "Audit Records count");
		oldValue=getWebElementList(CRFieldAuditPage.lblOldValue, "Old value");
		fieldName=getWebElementList(CRFieldAuditPage.lblFieldName, "field Name");
		changedBy=getWebElementList(CRFieldAuditPage.lblChangedBy, "Changed By");
		date=getWebElementList(CRFieldAuditPage.lblDate, "Date");

		for (int i = 0; i < newValue.size(); i++)
			{
				String fieldLableName = fieldName.get(i).getText();
				String oldRecordValue = oldValue.get(i).getText();
				String newRecordValue = newValue.get(i).getText();
				String changedByValue = changedBy.get(i).getText();
				String changedDate = date.get(i).getText();
				if(!newRecordValue.equals("")) {
					if (!oldRecordValue.equals(newRecordValue)) {
						reporter.SuccessReport("Update record status", "<b>Recrods are updated for :: " + fieldLableName+ " from " + oldRecordValue+ " " +
								" ::To:: "+newRecordValue+" ::and Changed By:: "+changedByValue+" ::On:: "+changedDate+ " </b>");
					} else {
						reporter.failureReport("Update record status", "<b>Recrods are not updated for :: " + fieldLableName+ " from " + oldRecordValue+ " " +
								" ::To:: "+newRecordValue+" ::and Changed By:: "+changedByValue+" ::On:: "+changedDate+ "</b>");
					}
				}else{
					reporter.SuccessReport("This is default Record", "<b>Record value :: " + fieldLableName + " And expected result is " + oldRecordValue + " ::and New values"+fieldLableName+ " </b>");
			}
		}

	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getFieldAuditValues
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public void clickOnCloseInFieldAudit() throws Throwable {
		boolean close=isVisibleOnly(CRFieldAuditPage.btnFieldAuditClose,"button close");
		if(close){
			click(CRFieldAuditPage.btnFieldAuditClose,"button close");
		}
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getFieldNameValueFromRecords
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getFieldNameValueFromRecords() throws Throwable {
		String fieldName=getText(CRFieldAuditPage.lblFieldName,"Field Name");
		return fieldName;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getOldValueFromRecords
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getOldValueFromRecords() throws Throwable {
		String oldValue=getText(CRFieldAuditPage.lblOldValue,"Field Old Value");
		return oldValue;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getOldValueFromRecords
	 * description ::
	 * date :: 29-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getNewValueFromRecords() throws Throwable {
		String newValue=getText(CRFieldAuditPage.lblNewValue,"Field new Value");
		return newValue;
	}
}
