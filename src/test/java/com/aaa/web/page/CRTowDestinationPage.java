package com.aaa.web.page;

import org.openqa.selenium.By;

public class CRTowDestinationPage {
    public static By towDestinationTab;
    public static By txtNumberOfTowPassengers;
    public static By txtPacesetterCode;
    public static By errorAlertOK;
    public static By scriptError;
    public static By btnAlertSaveYes;
    public static By errorNotifications;
    public static By btnSave;
    public static By saveFailureError;
    public static By btnDialogOkBtn;
    public static By linkTowLocation;
    public static By txtTowPassenger;
    public static By linkManualEntryLinkOnTowDestination;
    public static By txtTowLocationName;
    public static By txtTowCrossStreetInput;
    public static By txtTowSecondCrossStreetInput;
    public static By txtTowCity;
    public static By txtTowState;
    public static By txtTowLandMark;
    public static By txtlatitude;
    public static By txtLogitude;
    public static By linkAARInTowDestination;
    public static By towMilesDetailsToolTip;
    public static By repairShopMiles;
    public static By repairShopResultList;
	public static By btnAlertForTowOffer;
	public static By repairShopLocation;
	public static By btnShowCrireria;
	public static By txtSearchMilesWithInRange;
	public static By btnTowSearchButton;
	public static By popupNotificationForRSPreferalPinnedToUnpinned;
	public static By popupNotificationForRSPreferalGetTitle;
	public static By popupNotificationForRSPreferalUnPinned;
	public static By lblEstimatedTowMilesInTowToolTip;
	public static By lblEstimatedTowMilesValuesInTowToolTip;
	public static By lblEntitleMilesInTowToolTip;
	public static By lblEntitleMilesValuesInTowToolTip;
	public static By lblEstimatedOverMilesInTowToolTip;
	public static By lblEstimatedOverMilesValuesInTowToolTip;
	public static By lblToolTipTowMilageDetails;
	public static By chkBoxRVType;
	public static By lblLatLog;
	public static By lblAutoSearchResults;
	public static By iconOkSign;
	public static By iconReferal;
	public static By txtVehicleValueInTowScreen;
	public static By txtOpenOnDate;
	public static By txtOpenTime;
	public static By chkBoxTRC;
	public static By iconTRC;
	public static By chkBoxOpenOn;
	public static By chkBoxAAR;
	public static By chkBoxAutoGlass;
	public static By btnRepairShopVerificationCloseButton;
	public static By txtFromAlertRegardingTowDestination;
	public static By txtMessageNoDataAvailableForTowDestinations;
	public static By chkBoxCollision;
	public static By iconAAR;
	public static By chkBoxRepairShop;
	public static By chkBoxRV;
	public static By verifyTowDestinationCompleteCheck;
	public static By txtTowStreetAddressNo;
	public static By txtTowStreetAddressName;
	public static By txtTowZIP;
	public static By towPassengers_required;
	public static By iconGreenTickIconOnTowDest;
	public static By serviceProviderName;
	public static By btnClearLocation;
	public static By btnVerifyIt;
	public static By lnkAddressVerificationInRowSelection;
	public static By txtButtonVerified;
	public static By txtOmniSearchBar;
	public static By btnOmniSearch;
	public static By lnkPreviouslyUsedTow;
	public static By lnkCloseTheServiceProvider;
	public static By lnkTowDestinationFromSearchResults;
	public static By iconTowDestinationPriorityService;
	public static By getIconTowDestinationPriorityServiceForSelectedShop;
	public static By getTotalNumberOfSearchResults;


	static {
	    linkTowLocation=By.xpath("//*[@id=\"td-repair-shop-results\"]/tbody/tr[1]/td[3]/a");
	    txtTowPassenger=By.id("cs-passengers-tow");
	    btnDialogOkBtn=By.xpath("//*[@id=\"scripts-immediate-dialog-okayBtn\"]/span");
	    towDestinationTab = By.xpath("(//span[contains(@class,'tab-link')])[4]");
	    //txtNumberOfTowPassengers = By.cssSelector("input[id='cs-passengers-tow'][class='d3ui-field cs-passengers-tow d3ui-show']");
	    txtPacesetterCode = By.xpath("//div[@id='triage-trouble-code-container']/ul/li/input");
	    errorAlertOK =By.cssSelector("div[id*='error-dialog-'] + div div button span");
	    scriptError =By.id("scripts-immediate-dialog-okayBtn");
	    btnAlertSaveYes=By.id("confirmation-yes-btn");
	    errorNotifications=By.cssSelector("div[id*='d3-notification-']");
	    btnSave = By.id("save-call");
	    saveFailureError = By.cssSelector("div[id*='error-dialog-'][class='error-dialog ui-dialog-content ui-widget-content']");
	    linkManualEntryLinkOnTowDestination=By.id("loc-manual-toggle-link-3");
	    //towPassengers_required=By.cssSelector("input[id='cs-passengers-tow'][class='d3ui-field cs-passengers-tow d3ui-show d3ui-required']");
		txtNumberOfTowPassengers = By.id("cs-passengers-tow");
		txtTowLocationName =By.id("td-location-name-input");
		txtTowCrossStreetInput=By.id("td-cross-street-input");
		txtTowSecondCrossStreetInput=By.id("td-second-cross-street-input");
		txtTowCity=By.id("td-city-input");
		txtTowState=By.id("td-state-input");
		txtTowLandMark=By.id("td-landmark-input");
		txtlatitude=By.id("td-latitude-input");
		txtLogitude=By.id("td-longitude-input");
		linkAARInTowDestination = By.xpath("//*[@id='td-repair-shop-results']//*[contains(text(),'AAR')]");
		towMilesDetailsToolTip=By.id("d3calls-widget-mileage");
		repairShopResultList = By.xpath("//table[@id='td-repair-shop-results']/tbody/tr");
		towMilesDetailsToolTip=By.id("d3calls-widget-mileage");
		btnAlertForTowOffer=By.id("scripts-immediate-dialog-okayBtn");
		btnShowCrireria=By.id("td-criteria-toggle-text");
		txtSearchMilesWithInRange=By.id("td-repair-shop-proximity-miles-input");
		btnTowSearchButton=By.id("td-search-btn");
		popupNotificationForRSPreferalPinnedToUnpinned = By.className("d3ui-notification-pin icon-pushpin pinned");
		popupNotificationForRSPreferalGetTitle = By.className("d3ui-notification-title");
		popupNotificationForRSPreferalUnPinned = By.className("d3ui-notification-pin icon-pushpin");
		lblEstimatedTowMilesInTowToolTip=By.cssSelector("div[id='tooltip-helper'] div div div:nth-child(1) div:nth-child(1) span:nth-child(1)");
		lblEstimatedTowMilesValuesInTowToolTip=By.cssSelector("div[id='tooltip-helper'] div div div:nth-child(1) div:nth-child(1) span:nth-child(2)");
		lblEntitleMilesInTowToolTip=By.cssSelector("div[id='tooltip-helper'] div div div:nth-child(1) div:nth-child(3) span:nth-child(1)");
		lblEntitleMilesValuesInTowToolTip=By.cssSelector("div[id='tooltip-helper'] div div div:nth-child(1) div:nth-child(3) span:nth-child(2)");
		lblEstimatedOverMilesInTowToolTip=By.cssSelector("div[id='tooltip-helper'] div div div:nth-child(1) div:nth-child(5) span:nth-child(1)");
		lblEstimatedOverMilesValuesInTowToolTip=By.cssSelector("div[id='tooltip-helper'] div div div:nth-child(1) div:nth-child(5) span:nth-child(2)");
		lblToolTipTowMilageDetails=By.cssSelector("div[id='tooltip-helper'] div div[class='tooltip-helper-title d3ui-text-trim']");
		chkBoxRVType=By.id("td-repair-shop-search-rv-cbx");
		lblLatLog=By.cssSelector("div[class='repair-shop-lat-lon']");
		lblAutoSearchResults = By.id("td-search-criteria-summary-text");
		iconOkSign = By.cssSelector("div[id='tab-towdest'][class='tab pointer ui-corner-top d3ui-show tab-active completed']");
		iconReferal= By.cssSelector("a[class='referral-icon d3ui-icon d3ui-icon-referral']:nth-child(1)");
		txtVehicleValueInTowScreen= By.id("td-repair-shop-search-vehicle-make-input");
		txtOpenOnDate=By.id("td-repair-shop-search-date-input");
		txtOpenTime=By.id("td-repair-shop-search-time-input");
		chkBoxTRC=By.id("td-repair-shop-search-trc-cbx");
		iconTRC=By.className("d3ui-icon d3ui-icon-trc");
		chkBoxOpenOn=By.id("td-repair-shop-search-datetime-cbx");
		chkBoxAAR=By.id("td-repair-shop-search-aar-cbx");
		chkBoxAutoGlass=By.id("td-repair-shop-search-autoGlass-cbx");
		btnRepairShopVerificationCloseButton=By.cssSelector("div[id='verifying-tow-dest-results-dialog'] +div +div div button span");
		txtFromAlertRegardingTowDestination=By.id("locations-info-message-text-4-1");
		txtMessageNoDataAvailableForTowDestinations=By.xpath("//*[@id='td-repair-shop-results']//*[contains(text(),'No data available in table')]");
		chkBoxCollision= By.id("td-repair-shop-search-collision-cbx");
		iconAAR=By.xpath("//td[@class=' aar-nowrap-column'][2]/span[1]");
		chkBoxRepairShop=By.id("td-search-repair-shops-checkbox");
		chkBoxRV=By.id("td-repair-shop-search-rv-cbx");
		verifyTowDestinationCompleteCheck = By.xpath("//*[@id='tab-towdest']//i[@class='tab-icon-complete icon-ok-sign']");
		txtTowStreetAddressNo=By.xpath("//*[@id='td-number-input']");
		txtTowStreetAddressName=By.xpath("//*[@id='td-street-input']");
		txtTowZIP=By.xpath("//*[@id='td-zip-input']");
		iconGreenTickIconOnTowDest = By.xpath("//*[@id='tab-towdest']/div[1]/i[2]");
		serviceProviderName =By.xpath("//*[contains(text(),'Services Provided: ')]/..//input");
		btnClearLocation=By.xpath("(//span[contains(text(),'Clear Location')])[3]");
		btnVerifyIt =By.xpath("//button[contains(@id,'verify-address-3')]/./span[contains(text(),'Verify it')]");
		lnkAddressVerificationInRowSelection=By.xpath("//table[@id='verifying-results']//a[contains(@class,'loc-results-item-link row-selection')]");
		txtButtonVerified=By.id("address-verified-3");
		txtOmniSearchBar=By.id("td-search-input");
		btnOmniSearch=By.id("td-search-btn");
		lnkPreviouslyUsedTow=By.xpath("//div[@id='loc-known-addresses-container-towdest-workflow']//div[contains(@class,'location-item-descr')]");
		lnkCloseTheServiceProvider=By.xpath("//*[contains(text(),'Services Provided: ')]/..//a[contains(@class,'tagit-close')]");
		getIconTowDestinationPriorityServiceForSelectedShop=By.xpath("//*[@title='Priority Service Ready']");
		getTotalNumberOfSearchResults=By.xpath("//*[@id='td-repair-shop-results_wrapper']//tbody//td[3]//a");
	}
		public static By getMilesList(int i) {
			String milesList = "//*[@id='td-repair-shop-results']/tbody/tr["+i+"]/td[5]";
			repairShopMiles = By.xpath(milesList);
			return repairShopMiles;
		}

		public static By getLocationListOnTow(int i) {
			String milesList = "//*[@id='td-repair-shop-results']/tbody/tr["+i+"]/td[3]/a";
			repairShopLocation = By.xpath(milesList);
			return repairShopLocation;
		}

		public static By selectTowDestination(String towDestination)
		{
			String xpath="//*[@id='td-repair-shop-results']//*[text()='"+towDestination+"']";
			return lnkTowDestinationFromSearchResults=By.xpath(xpath);
		}

		public static By verifyTowDestinationPriorityService(String towDestination)
		{
			String xpath="//*[text()='"+towDestination+"']/../..//*[@title='Priority Service Ready']";
			return iconTowDestinationPriorityService=By.xpath(xpath);
		}

}