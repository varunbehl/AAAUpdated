package com.aaa.web.page;

import org.openqa.selenium.By;

public class CRServicePage {
    public static By serviceTab;
    public static By btnAlertSaveYes;
    public static By txtFacilityField;
    public static By btnSave;
    public static By saveFailureError;
    public static By callId;
    public static By alertUndefinedError;
    public static By txtSpotFacilityLabel;
    public static By txtSpotFacilityAddress;
    public static By closeCallButton;
    public static By tabService;
    public static By btnSavecall;
    public static By saveClearHistoryCallwindow;
    public static By txtHistoryCallDate;
    public static By txtFacility;
    public static By txtTruckID;
    public static By txtDriverNum;
    public static By txtClearingCode;
    public static By txtPacesetter;
    public static By calendarDropDown;
    public static By errorContent;
    public static By txtCallType;
    public static By btnGaragePaymentInfo;
    public static By popupGaragePaymentInfoWindow;
    public static By btnGaragePaymentInfoWindowClose;
    public static By btnSaveHistoryCallSaveCall;
    public static By btnCallStatus;
    public static By btnRemainInCall;
    public static By disabledHistoryCallDateField;
    public static By disabledFacilityField;
    public static By disabledTruckIDField;
    public static By disabledClearingCodeField;
    public static By disabledPacesetterField;
    public  static By btnCalendarNextMonth;
    public  static By btnAppointment;
    public  static By txtAppointmentDate;
    public  static By txtAppointmentTime;
    public  static By btnClearSpotting;
    public  static By btnHold;
    public  static By btnRelease;
    public static By manualEntryLink;
    public static By leaveCallMessage;
    public static By txtPolicy;
    public static By btnPrefer;
    public static By btnContinueOnPreferFacility;
    public static By callStatusRetrived;
    public static By btnAppointmentRelease;
    public static By btnAppointmentLeaveButton;
    public static By timeStampInCallStatus;
    public static By dateColumn;
    public static By btnSpStatusUpadte;
    public static By txtCallStatusUpdate;
    public static By btnUpdate;
    public static By txtSpecialEquipement;
    public static By btnClose;
    public static By btnRedFlagOnServiceTab;
    public static By lblFacilityType;
    public static By txtPriority;
    public static By txtHold;
    public static By autoPopulatedFacility;
    public static By btnAvoid;
    public static By btnSpot;
    public static By txtSpotManualEntry;
    public static By lblInactiveFacilityErrorMessage;
    public static By btnCash;
    public static By cashFlagIcon;
    public static By chkBoxCallBack;
    public static By txtCallBackMinutes;
    public static By txtCallBackRequestType;
    public static By lblSuperOverridePTAValue;
    public static By lblManualOverridePTAValue;
    public static By lblSpotFacility;
    public static By lblPTAValueOnCallConfirmation;
    public static By txtErrorMsg;
    public static By btnCreditCard;
    public static By iconCreditCard;
    public static By txtResonValue;
    public static By txtStatusValue;
    public static By txtUsernameValue;
    public static By txtRoleValue;
    public static By txtStatusUpdate;
    public static By lblCallStatusUpdateTitle;
    public static By txtResonForStatus;
    public static By txtCommentsInStatusUpdate;
    public static By lblStatus;
    public static By lblResonForStatus;
    public static By lblComments;
    public static By btnUpdateEnabled;
    public static By lblSpStatus;
    public static By lblCallStatus;
    public static By btnCancel;
    public static By dropDownBoxOnPolicy;
    public static By dropDownBoxOnPolicyOnServiceTab;
    public static By dropDownBoxOnPriority;
    public static By dropDownBoxOnCallBackRequestMinutes;
    public static By dropDownBoxOnCallBackRequestType;
    public static By btnUpdateButton;
    public static By lblFacilityError;
    public static By lblStatusUpdateValue;
    public static By lblReasonValue;
    public static By lblFacilityVlue;
    public static By lblStatusValueInCallStatus;
    public static By lblAuditCodeInCallStatusUpdate;
    public static By btnUpdateBbuttonCallStatusUpdateWindow;
    public static By dropDownBoxOnHoldReason;
    public static By holdIcon;
    public static By dropDownBoxArrowOnStatusUpdate;
    public static By dropDownFirstElementInReasonUpdate;
    public static By lblCancel;
    public static By getTxtPolicy;
    public static By dateInCallInformationWindow;
    public static By CalendarErrorText;
    public static By workFlowLoadedtext;
    public static By txtInCallStatusButton;
    public static By verifyServiceCompleteCheck;
    public static By lblDate;
    public static By txtUpdateCode;
    public static By txtReasonCode;
    public static By txtFacilityTruck;
    public static By errorOkOnHistoryCallSave;
    public static By lblCallDate;
    public static By lblPTACallCreatedDate;
    public static By btnErrorE225OkayButton;
    public static By lblE225ErrorMessage;
    public static By lblFacilityIdInServices;
    public static By getTxtCallPTAValue;
    public static By btnSelectedCashButton;
    public static By lnkUseMemberShipDataOnBillingInfoInCreditCardTab;
    public static By txtAmountOnBillingInfoInCreditCardTab;
    public static By btnContinueOnBillingInfoInCreditCardTab;
    public static By txtCreditCardNumberOnCreditCardInfoInCreditCardTab;
    public static By txtCVCNumberOnCreditCardInfoInCreditCardTab;
    public static By btnContinueOnCreditCardInfoInCreditCardTab;
    public static By drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab;
    public static By drpdwnExpirationYearOnCreditCardInfoInCreditCardTab;
    public static By btnCloseOnCreditCard; 
    public static By creditCardFrame;
    public static By errorMsgForRequiredField;
    public static By errorMsgForPacesetterCodeEntry;
    public static By iconRedFlagOnServiceTab;
    public static By creditCardOrderID;
    public static By txtEndOfScript;
    public static By tabBillingInfo;
    public static By tabCreditCardInfo;
    public static By tabTransactionInfo;
    public static By transactionHistorySection;
    public static By creditCardPaymentOption;
    public static By btnVoidAuthorization;
    public static By txtCreditCard;
    public static By txtOrderNumber;
    public static By txtTransactionID;
    public static By txtAuthorizationCode;
    public static By creditCardInTransactioHistory;
    public static By txtProcessing;
    public static By txtAuthorizedPaymentStatus;
    public static By btnE268ErrorPopUpErrorOkayButton;
    public static By lblE268ErrorMessage;
    public static By lblPTAvalue;




    static {
        btnContinueOnPreferFacility=By.cssSelector("div[id='generic-dialog'] +div div button");
        btnPrefer=By.cssSelector("div input[id='cs-facility-preference-preferred'] +label");
        txtSpotFacilityLabel=By.id("cs-spot-facility-label");
        txtSpotFacilityAddress=By.id("cs-spot-facility-address");
        serviceTab = By.id("tab-service");
        btnAlertSaveYes=By.id("confirmation-yes-btn");
        //txtFacilityField = By.cssSelector("input[id='cs-facility-preference-input'][class='d3ui-field ui-autocomplete-input d3ui-show']");
        txtFacilityField = By.id("cs-facility-preference-input");
        btnSave = By.id("save-call");
        saveFailureError = By.cssSelector("div[id*='error-dialog-'][class='error-dialog ui-dialog-content ui-widget-content']");
        //callid = By.xpath("//*[@id='left-column']/fieldset[1]/table/tbody/tr[1]/td[1]/span)");
        callId = By.xpath("//*[contains(@class,'field-input call-id ui-select-text')]");
        alertUndefinedError=By.cssSelector("span[id*='ui-dialog-title-error-dialog-'] +a span");
        closeCallButton=By.id("save-call-close-button");
        disabledHistoryCallDateField=By.cssSelector("input[id='history-call-date'][disabled='disabled']");
        disabledFacilityField=By.cssSelector("input[id='history-call-facility'][disabled='disabled']");
        disabledTruckIDField=By.cssSelector("input[id='history-call-truck-id'][disabled='disabled']");
        disabledClearingCodeField=By.cssSelector("input[id='history-call-reason-code'][disabled='disabled']");
        disabledPacesetterField=By.cssSelector("input[id='history-call-pacesetter'][disabled='disabled']");
        tabService=By.xpath("//*[@id=\"tab-service\"]/span");
        btnSavecall=By.id("save-call");
        /**These locators are for the  save/clear History call window **/
        saveClearHistoryCallwindow=By.id("ui-dialog-title-history-call-dialog");
        txtHistoryCallDate=By.id("history-call-date");
        txtFacility=By.id("history-call-facility");
        txtTruckID=By.id("history-call-truck-id");
        txtDriverNum=By.id("history-call-driver-num");
        txtClearingCode=By.id("history-call-reason-code");
        txtPacesetter=By.id("history-call-pacesetter");
        calendarDropDown=By.id("ui-datepicker-div");
        btnCalendarNextMonth=By.cssSelector(".ui-datepicker-next");
        errorContent=By.cssSelector(".formErrorContent");
        txtCallType=By.id("cs-call-type-list");
        btnGaragePaymentInfo=By.id("history-call-garage-payment-button");
        popupGaragePaymentInfoWindow=By.id("ui-dialog-title-apd-dialog");
        btnGaragePaymentInfoWindowClose=By.id("apd-save-close-btn");
        btnSaveHistoryCallSaveCall=By.cssSelector("#history-call-garage-payment-button+button");
        btnCallStatus=By.id("call-status-btn");
        btnRemainInCall=By.id("save-call-remain-button");
        btnAppointment=By.cssSelector("input[id='cs-appointment-chkbox']+label");
        txtAppointmentDate = By.id("cs-appointment-date");
        txtAppointmentTime = By.id("cs-appointment-time");
        btnClearSpotting = By.id("cs-clear-manualspot-btn");
        btnHold = By.cssSelector("input[id='cs-holdcall-chkbox']+label");
        btnRelease = By.id("release-call-label");
        manualEntryLink = By.id("vi-manual-toggle-link");
        leaveCallMessage=By.id("confirmation-dialog-question");
        callStatusRetrived=By.xpath("//table[@id='status-table']/tbody/tr[2]/td[2]/div[2]");
        btnAppointmentRelease=By.id("confirmation-yes-btn");
        btnAppointmentLeaveButton=By.id("confirmation-yes-btn");
        timeStampInCallStatus=By.xpath("//table[@id='status-table']/tbody/tr[2]/td[3]");
        dateColumn=By.id("jqgh_status-table_date");
        btnSpStatusUpadte=By.id("confirmation-yes-btn");
        txtCallStatusUpdate=By.id("csu-reason");
        btnUpdate=By.id("call-status-dialog-update");
        btnClose = By.xpath("//*[@id='ui-dialog-title-history-call-dialog']//..//span[contains(text(),'close')]");
        txtSpecialEquipement=By.id("cs-special-equipment");
        btnRedFlagOnServiceTab=By.xpath("//label[@id='red-flag-label']/span[1]");
        iconRedFlagOnServiceTab=By.xpath("//*[@id='d3calls-widget-redflag-flag']/span[1]");
        lblFacilityType=By.id("cs-spot-facility-type");
        txtPriority = By.xpath("//*[@id='cs-priority-list']");
        txtHold = By.xpath("//*[@id='cs-holdcall-reason-list']");
        autoPopulatedFacility=By.xpath("//*[contains(@class,'ui-corner-all')]");
        btnAvoid=By.xpath("//label[@for='cs-facility-preference-avoid']");
        btnSpot=By.id("cs-manualspot-btn");
        txtSpotManualEntry=By.id("cs-manualspot");
        lblInactiveFacilityErrorMessage=By.xpath("//*[contains(@id,'error-dialog')]/div[2]/div");
        btnCash= By.xpath("//input[@id='cs-calltype-cash-chkbox']/../label");
        cashFlagIcon=By.id("d3calls-widget-cash-flag");
        txtPolicy=By.xpath("//*[@id='cs-policy-group']/ul/li/input");
        chkBoxCallBack = By.xpath("//*[@id='cs-callback-chkbox']");
        txtCallBackMinutes = By.xpath("//*[@id='cs-callback-time-list']");
        txtCallBackRequestType = By.xpath("//*[@id='cs-callback-type-list']");
        lblSuperOverridePTAValue=By.id("cs-pta-override-value");
        lblManualOverridePTAValue=By.id("cs-pta-manual-value");
        lblSpotFacility = By.xpath("//*[contains(@class,'field-input facility-id')]");
        lblPTAValueOnCallConfirmation=By.xpath("//div[@id='left-column']//tbody//tr[3]/td[1]/span");
        txtErrorMsg=By.cssSelector("div[class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']+div[id*='error-dialog-'] div[class='d3ui-modal-icon d3ui-modal-icon-error']+div div");
        btnCreditCard=By.xpath("//*[@id='service-top-content']/div/div[2]/div[2]/label/span");
        iconCreditCard=By.xpath("//*[@id='d3calls-widget-creditcard-flag']/span[1]");
        txtResonValue=By.xpath("(//td[contains(@aria-describedby,'status-table_stsRsnCode')])[1]");
        txtStatusValue=By.xpath("//tr[@class='ui-widget-content jqgrow ui-row-ltr'] //div[contains(@title,'Received')][2]");
        txtUsernameValue=By.xpath("(//td[contains(@aria-describedby,'status-table_userId')])[1]");
        txtRoleValue=By.xpath("(//td[contains(@aria-describedby,'status-table_userRole')])[1]");
        txtStatusUpdate=By.id(".//*[@id='confirmation-dialog-question']");
        lblCallStatusUpdateTitle=By.xpath("//span[@id='ui-dialog-title-callstatus-panel']");
        txtResonForStatus=By.xpath(".//*[@id='csu-reason']");
        txtCommentsInStatusUpdate=By.xpath(".//*[@id='csu-comments']");
        lblStatus=By.xpath("//label [@for='csu-status'][text()='Status:']");
        lblResonForStatus=By.xpath("//label [@for='csu-reason'][text()='Reason For Status:']");
        lblComments=By.xpath("//label [@for='csu-comments'][text()='Comments']");
        btnUpdateEnabled=By.xpath("//button[@id='call-status-dialog-update'][@aria-disabled=\"true\"]");
        lblSpStatus=By.xpath(".//*[@id='csu-status'][@readonly='readonly']");
        lblCallStatus=By.xpath("//button[@id='call-status-btn']");
        btnCancel=By.id("call-status-dialog-cancel");
        dropDownBoxOnPolicy = By.xpath("//*[contains(@class, 'ui-corner-all')][contains(text(),'AF')]");
        dropDownBoxOnPriority = By.xpath("//*[contains(@class, 'ui-corner-all')][contains(text(),'P1 Safety')]");
        dropDownBoxOnCallBackRequestMinutes = By.xpath("//*[contains(@class, 'ui-corner-all')][contains(text(),'10')]");
        dropDownBoxOnCallBackRequestType = By.xpath("//*[contains(@class, 'ui-corner-all')][contains(text(),'TXT')]");
        dropDownBoxOnPolicyOnServiceTab=By.xpath("//ul[42]/li/a");
        btnUpdateButton=By.xpath(".//*[@id='call-status-dialog-update']");
        lblFacilityError=By.xpath("//div[contains(@class,'error')][text()='E225: No facility found for entered address, problem type, and vehicle type. Please edit the data or notify your supervisor of the issue.']");
        lblStatusUpdateValue=By.xpath("//tr[@class='ui-widget-content jqgrow ui-row-ltr'] //div[contains(@title,'Spotted')][2]");
        lblReasonValue=By.xpath("(//td[contains(@aria-describedby,'status-table_stsRsnCode')])[3]");
        lblFacilityVlue=By.xpath("(//td[contains(@aria-describedby,'status-table_facilTrk')])");
        lblAuditCodeInCallStatusUpdate=By.xpath("//input[@id='csu-status'][@title='Status']");
        lblStatusValueInCallStatus=By.xpath("//tr[@class='ui-widget-content jqgrow ui-row-ltr'] //div[contains(@title,'Spotted')][2]");
        btnUpdateBbuttonCallStatusUpdateWindow = By.id("call-status-dialog-update") ;
        dropDownBoxOnHoldReason=By.xpath("//*[contains(@class, 'ui-corner-all')][contains(text(),'MC')]");
        holdIcon=By.id("d3calls-widget-holdcall-flag");
        dropDownBoxArrowOnStatusUpdate=By.xpath("(//span[contains(@class,'ui-button-text')][text()='View Options'])[58]/../span[1]");
        dropDownFirstElementInReasonUpdate=By.xpath("(//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']/li/a)[last()-4]");
        lblCancel=By.xpath(".//*[@id='call-status-dialog-cancel']");
        getTxtPolicy=By.xpath("(//ul[@class='tagit ui-widget ui-widget-content ui-corner-all'])[2]");
        dateInCallInformationWindow=By.xpath("//*[contains(@class,'field-input call-date')]");
        CalendarErrorText=By.xpath("//*[contains(@class,'error-dialog ui-dialog-content ui-widget-content')][contains(@data-error,'E')]/div[2]/div");
        workFlowLoadedtext=By.id("workflow-loaded-text");
        txtInCallStatusButton=By.id("call-status-btn-code");
        verifyServiceCompleteCheck = By.xpath("//*[@id='tab-service']//i[@class='tab-icon-complete icon-ok-sign']");
        lblDate = By.xpath("//div[@id='jqgh_status-table_date']");
        txtUpdateCode=By.xpath("(//td[contains(@aria-describedby,'status-table_updStsCode')])[1]");
        txtReasonCode=By.xpath("(//td[contains(@aria-describedby,'status-table_stsRsnCode')])[1]");
        txtFacilityTruck=By.xpath("(//td[contains(@aria-describedby,'status-table_facilTrk')])[1]");
        errorOkOnHistoryCallSave=By.xpath("(//*[@class='ui-button-text'][contains(text(),'OK')])[2]");
        lblCallDate=By.xpath("//span[@class='field-input call-date']");
        lblPTACallCreatedDate=By.cssSelector("span[class='field-input promised-arrival-time']");
        btnErrorE225OkayButton=By.cssSelector("div[class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'] div[id*='error-dialog-'][data-error='E225.2']+div div button");
        lblE225ErrorMessage=By.cssSelector("div[class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'] div[id*='error-dialog-'][data-error='E225.2'] div div");
        lblFacilityIdInServices = By.id("assigned-facl");
        getTxtCallPTAValue=By.id("call-pta");
        btnSelectedCashButton=By.className("d3ui-fieldlabel ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-active");

        lnkUseMemberShipDataOnBillingInfoInCreditCardTab = By.xpath("//*[@id='cc-usememberdata']");
        txtAmountOnBillingInfoInCreditCardTab = By.id("total_amt");
        btnContinueOnBillingInfoInCreditCardTab = By.id("cc-button-step1-next");
        txtCreditCardNumberOnCreditCardInfoInCreditCardTab = By.id("PAN");
        txtCVCNumberOnCreditCardInfoInCreditCardTab = By.id("cv_data");
        btnContinueOnCreditCardInfoInCreditCardTab = By.id("payment-button");
        drpdwnExpirationMonthOnCreditCardInfoInCreditCardTab = By.id("cresecure_cc_expires_month");
        drpdwnExpirationYearOnCreditCardInfoInCreditCardTab = By.id("cresecure_cc_expires_year");
        btnCloseOnCreditCard = By.xpath("//*[contains(text(),'Transaction History')]//following::span[contains(text(),'Close')]"); 
        creditCardFrame = By.id("cc-tab-creditcardprocessing-iframe");
        errorMsgForRequiredField=By.xpath("//div[contains(text(),'This is required for this call')]");
        errorMsgForPacesetterCodeEntry=By.xpath("//div[contains(text(),'You need to provide a pacesetter code')]");
        
        creditCardOrderID = By.id("cc-transaction-orderid");
        txtEndOfScript= By.xpath("//*[@id='call-scripts-tabs-1']/div/p[1]");
        tabBillingInfo =By.xpath("//span[@class='cc-tab-item-title'][contains(text(),'Billing Info')]");
        tabCreditCardInfo =By.xpath(" //span[@class='cc-tab-item-title'][contains(text(),'Credit Card Info')]");
        tabTransactionInfo=By.xpath("//span[@class='cc-tab-item-title'][contains(text(),'Transaction Info')]");
        transactionHistorySection =By.xpath("//*[@id='cc-dialog-transactions-history-container']");
        creditCardPaymentOption=By.xpath("//*[@id='ui-dialog-title-cc-dialog'][contains(text(),'Credit Card Payment')]");
        creditCardInTransactioHistory=By.xpath("//span[@class='cc-transaction-card-num']");
        btnVoidAuthorization =By.xpath("//*[@id='cc-action-btn-void']");
        txtCreditCard= By.id("cc-transaction-card");
        txtOrderNumber=By.id("cc-transaction-ordernumber");
        txtTransactionID=By.id("cc-transaction-transactionid");
        txtAuthorizationCode=By.id("cc-transaction-authorizationcode");
        txtProcessing=By.xpath("//div[@id='cc-processing-container']//h1");
        txtAuthorizedPaymentStatus=By.xpath("//span[@id='cc-paymentstatus-type']");
        btnE268ErrorPopUpErrorOkayButton = By.cssSelector("div[class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'] div[data-error*='E268']+div button");
        lblE268ErrorMessage = By.cssSelector("div[class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'] div[data-error*='E268'] div div");
        lblPTAvalue=By.id("call-pta");


    }
}