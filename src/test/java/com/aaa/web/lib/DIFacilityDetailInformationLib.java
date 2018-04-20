package com.aaa.web.lib;
import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.DIFacilityDetailInformationPage;
import com.aaa.web.page.DIHomePage;

public class DIFacilityDetailInformationLib extends ActionEngine{
    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: IsExistsFacilityDetailInformationScreen
     * description ::
     * date :: 17-feb-2018
     * author ::Sachin
     */
    public boolean IsExistsFacilityDetailInformationScreen()  throws Throwable
    {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.dialogFacilityInformationScreen, "Facility Information Details Screen");
        boolean bFacilityDetailInformationScreen = isVisible(DIFacilityDetailInformationPage.dialogFacilityInformationScreen, "Facility Information Details Screen");
        return bFacilityDetailInformationScreen;
    }


    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: IsExistsFacilityDetailInformationScreen
     * description ::
     * date :: 23-feb-2018
     * author ::Sachin
     */

    public void ClickOnCloseButton() throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnClose,"Close Button");
        click(DIFacilityDetailInformationPage.btnClose,"Close Button");
    }


    public String GetClassNameFromTextFieldsInDetailsTab(String FieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtDetailsTabTextFileds(FieldName), ""+FieldName);
        String claSSName = getAttributeByClass(DIFacilityDetailInformationPage.txtDetailsTabTextFileds(FieldName), ""+FieldName).trim();
        return claSSName;
    }

    public boolean IsPrimaryContactTextFieldExistsInDetailsTabSPPUser(String FieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtPrimaryContact, ""+FieldName);
        boolean bTextFiled = isVisible(DIFacilityDetailInformationPage.txtPrimaryContact, ""+FieldName);
        return bTextFiled;
    }

    public boolean IsPrimaryContactTextFieldExistsInDetailsTabDispatchUser(String FieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtPrimaryContactDispatchUser, ""+FieldName);
        boolean bTextFiled = isVisible(DIFacilityDetailInformationPage.txtPrimaryContactDispatchUser, ""+FieldName);
        return bTextFiled;
    }



    public boolean IsTextFieldExistsInDetailsTab(String FieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtDetailsTabTextFileds(FieldName), ""+FieldName);
        boolean bTextFiled = isVisible(DIFacilityDetailInformationPage.txtDetailsTabTextFileds(FieldName), ""+FieldName);
        return bTextFiled;
    }

    public boolean IsCheckBoxFieldExistsInDetailsTab(String chkBoxFieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.chkBoxDetailsTabCheckBoxField(chkBoxFieldName), ""+chkBoxFieldName);
        boolean bCheckBoxFiled = isVisible(DIFacilityDetailInformationPage.chkBoxDetailsTabCheckBoxField(chkBoxFieldName), ""+chkBoxFieldName);
        return bCheckBoxFiled;
    }

    public boolean IsCheckBoxFieldEnabledInDetailsTab(String chkBoxFieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.chkBoxDetailsTabCheckBoxField(chkBoxFieldName), ""+chkBoxFieldName);
        boolean bCheckBoxFiled = clickOnly(DIFacilityDetailInformationPage.chkBoxDetailsTabCheckBoxField(chkBoxFieldName), ""+chkBoxFieldName);
        return bCheckBoxFiled;
    }

    public String GetClassNameFromStatusTextFieldsInDetailsTab() throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtStatus, "Status Text Field");
        String claSSName = getAttributeByClass(DIFacilityDetailInformationPage.txtStatus,"Status Text Field");
        return claSSName;
    }

    public String GetClassNameFromDispatchTextFieldsInDetailsTab() throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtDispatchRegion, "Dispatch Region Text Field");
        String claSSName = getAttributeByClass(DIFacilityDetailInformationPage.txtDispatchRegion,"Dispatch Region Text Field");
        return claSSName;
    }

    public String GetClassNameFromPrimaryContactsTextFieldsInDetailsTab() throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtPrimaryContact, "Primary Contact Text Field");
        String claSSName = getAttributeByClass(DIFacilityDetailInformationPage.txtPrimaryContact,"Primary Contact Text Field");
        return claSSName;
    }

    /**
     * param :: String
     * return ::boolean
     * throws :: throwable
     * methodName :: IsTextFiledEditable
     * description ::
     * date :: 19-feb-2018
     * author ::Sachin
     */
    public boolean IsTextFiledEditable(String FieldName) throws Throwable{

        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtDetailsTabTextFileds(FieldName), ""+FieldName);
        boolean textFieldStatus = typeOnly(DIFacilityDetailInformationPage.txtDetailsTabTextFileds(FieldName),FieldName, ""+FieldName);
        return textFieldStatus;
    }

    public boolean IsPrimaryContactTextFiledEditable(String FieldName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtPrimaryContact, ""+FieldName);
        boolean textFieldStatus = typeOnly(DIFacilityDetailInformationPage.txtPrimaryContact,FieldName, "" + FieldName);
        return textFieldStatus;
    }

    public boolean IsCommentsTextFiledEditable(String FieldName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtComments, ""+FieldName);
        boolean textFieldStatus = typeOnly(DIFacilityDetailInformationPage.txtComments,FieldName, "" + FieldName);
        return textFieldStatus;
    }

    public boolean IsIDFiledEditable(String FieldName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.lblID, ""+FieldName);
        boolean textFieldStatus = clickOnly(DIFacilityDetailInformationPage.lblID,""+ FieldName);
        return textFieldStatus;
    }

    public boolean IsCommentsTextAreaFieldExistsInDetailsTab(String FieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtComments, ""+FieldName);
        boolean bTextFiled = isVisible(DIFacilityDetailInformationPage.txtComments, ""+FieldName);
        return bTextFiled;
    }

    public boolean IsIDFieldExistsInDetailsTab(String FieldName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.lblID, ""+FieldName);
        boolean bTextFiled = isVisible(DIFacilityDetailInformationPage.lblID, ""+FieldName);
        return bTextFiled;
    }

    public void SelectTabs(String TabName) throws Throwable{
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.tabNames(TabName), ""+TabName);
        click(DIFacilityDetailInformationPage.tabNames(TabName), ""+TabName);
    }

    public boolean IsFieldRepFieldInContactsTabEditable(String FieldName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtFieldRep, ""+FieldName);
        boolean textFieldStatus = typeOnly(DIFacilityDetailInformationPage.txtFieldRep,FieldName, "" + FieldName);
        return textFieldStatus;
    }

    public boolean IsButtonExistsInPTATab(String TabName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnsInPTAsTab(TabName), ""+TabName);
        boolean textFieldStatus = isVisible(DIFacilityDetailInformationPage.btnsInPTAsTab(TabName), "" + TabName);
        return textFieldStatus;
    }

    public void ClickButtonOnPTAsTab(String TabName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnsInPTAsTab(TabName), ""+TabName);
        click(DIFacilityDetailInformationPage.btnsInPTAsTab(TabName), "" + TabName);
    }

    public boolean VerifyFacilityWindowExist() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.closeFacilityWindow, "Facility Window");
        boolean bWindow = isVisible(DIHomePage.closeFacilityWindow, "Facility Window");
        return bWindow;
    }

    public boolean VerifyMinutesButtonExistInEditDefaultPTAWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtMinutesInEditDefaultPTA, "Minutes Text Field on Edit Default PTA window");
        boolean bMinutes = isVisible(DIFacilityDetailInformationPage.txtMinutesInEditDefaultPTA, "Minutes Text Field on Edit Default PTA window");
        return bMinutes;
    }

    public boolean VerifySaveButtonExistsInDefaultPTAWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnSaveInEditDefaultPTA, "Save Button on Edit Default PTA window");
        boolean bSave = isVisible(DIFacilityDetailInformationPage.btnSaveInEditDefaultPTA, "Save Button on Edit Default PTA window");
        return bSave;
    }

    public boolean VerifyCloseButtonExistsInDefaultPTAWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnCloseInEditDefaultPTA, "Close Button on Edit Default PTA window");
        boolean bClose = isVisible(DIFacilityDetailInformationPage.btnCloseInEditDefaultPTA, "Close Button on Edit Default PTA window");
        return bClose;
    }

    public void ClickOnTruckListButton() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnTruckList, "Truck List Button");
        click(DIFacilityDetailInformationPage.btnTruckList, "Truck List Button");
    }

    public boolean VerifyTruckListWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnCloseInTruckListWindow, "Truck List Window");
        boolean bTLWindow = isVisible(DIFacilityDetailInformationPage.btnCloseInTruckListWindow, "Truck List Window");
        return bTLWindow;
    }

    public void CloseTruckListWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnCloseInTruckListWindow, "Close Button");
        click(DIFacilityDetailInformationPage.btnCloseInTruckListWindow, "Close Button");
    }
    public void ClickOnViewTruckLoadButton() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnViewTruckLoad, "View Truck Load Button");
        click(DIFacilityDetailInformationPage.btnViewTruckLoad, "View Truck Load Button");
    }

    public boolean VerifyViewTruckLoadWindowExists() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.WindowViewTruckLoad, "TruckLoad Window");
        boolean bTLWindow = isVisible(DIFacilityDetailInformationPage.WindowViewTruckLoad, "TruckLoad Window");
        return bTLWindow;
    }

    public void CloseTruckLoadWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.iconCloseTruckLoadWindow, "Close Icon TruckLoad Window");
        click(DIFacilityDetailInformationPage.iconCloseTruckLoadWindow, "Close Icon TruckLoad Window");
    }

    public void ClickOnCloseButtonOnEditDefaultPTAWindow() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnCloseInEditDefaultPTA, "Close Button on Edit Default PTA window");
        click(DIFacilityDetailInformationPage.btnCloseInEditDefaultPTA, "Close Button on Edit Default PTA window");
    }

    public boolean ClickOnTelephoneTableCells(int RowNo,int ColNo) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.TelephonesTableInContactsTab(RowNo,ColNo), "Telephone Table in Contacts Tab");
        boolean bValue = clickOnly(DIFacilityDetailInformationPage.TelephonesTableInContactsTab(RowNo,ColNo), "Telephone Table in Contacts Tab");
        return bValue;
    }

    public boolean VerifyGridTableExistsInGridsTab() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.TableGridInGridsTab, "Grid Table");
        boolean bGridTable = isVisible(DIFacilityDetailInformationPage.TableGridInGridsTab, "Grid Table");
        return bGridTable;
    }

    public boolean VerifyViewGridsOnMapButtonExists() throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.btnViewGridOnMaps, "View Grids on Map");
        boolean bViewGrids = isVisible(DIFacilityDetailInformationPage.btnViewGridOnMaps, "View Grids on Map");
        return bViewGrids;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: IsPrimaryContactTextFiledEditableInDispatch
     * description :: This method validates if Primary Contact Text Field is editable in dispatch
     * date ::
     * author ::Sachin
     */

    public boolean IsPrimaryContactTextFiledEditableInDispatch(String FieldName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtPrimaryContactDispatch, ""+FieldName);
        boolean textFieldStatus = typeOnly(DIFacilityDetailInformationPage.txtPrimaryContactDispatch,FieldName, "" + FieldName);
        return textFieldStatus;
    }

    /**
     * param :: NA
     * return ::boolean
     * throws :: throwable
     * methodName :: IsPrimaryContactTextFiledEditableInSPPDispatch
     * description :: This method validates if Primary Contact Text Field is editable in SPP dispatch
     * date ::
     * author ::Sachin
     */

    public boolean IsPrimaryContactTextFiledEditableInSPPDispatch(String FieldName) throws Throwable {
        waitForVisibilityOfElement(DIFacilityDetailInformationPage.txtPrimaryContactSPPDispatch, ""+FieldName);
        boolean textFieldStatus = typeOnly(DIFacilityDetailInformationPage.txtPrimaryContactSPPDispatch,FieldName, "" + FieldName);
        return textFieldStatus;
    }



}
