package com.aaa.web.page;

import org.openqa.selenium.By;

public class CRFieldAuditPage {
	
	public static By lnkFieldAudit;
	public static By iconSortingNewValueColoumn;
	public static By lblFieldAuditrowResults;
	public static By btnFieldAuditClose;
	public static By lblFieldName;
	public static By lblOldValue;
	public static By lblNewValue;
	public static By lblChangedBy;
	public static By lblDate;


	static {
		lnkFieldAudit = By.id("app-menu-audit");
		iconSortingNewValueColoumn=By.cssSelector("th[class='sorting ui-state-default sorting_asc'][aria-label*='New value']");
		lblFieldAuditrowResults=By.id("field-audit-data");
		btnFieldAuditClose=By.id("field-audit-close");
		lblFieldName=By.cssSelector("table[id='field-audit-data']  tbody tr td:nth-child(1)");
		lblOldValue=By.cssSelector("table[id='field-audit-data']  tbody tr td:nth-child(2)");
		lblNewValue=By.cssSelector("table[id='field-audit-data']  tbody tr td:nth-child(3)");
		lblChangedBy=By.cssSelector("table[id='field-audit-data']  tbody tr td:nth-child(4)");
		lblDate=By.cssSelector("table[id='field-audit-data']  tbody tr td:nth-child(5)");
	}

}
