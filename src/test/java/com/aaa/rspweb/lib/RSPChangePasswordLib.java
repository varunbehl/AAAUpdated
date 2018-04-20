package com.aaa.rspweb.lib;

import com.aaa.rspweb.pages.RSPChangePasswordPage;
import java.util.List;

public class RSPChangePasswordLib extends RSPCommonLib{
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterOldPasswordInChangePassword
     * description ::To enter oldd password
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void enterOldPasswordInChangePassword(String oldPassword) throws Throwable {
        dynamicWaitByLocator(RSPChangePasswordPage.txtOldPassword,60);
        type(RSPChangePasswordPage.txtOldPassword,oldPassword,"Enter old password");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterNewPasswordInChangePassword
     * description ::To enter new password
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void enterNewPasswordInChangePassword(String newPassword) throws Throwable {
        dynamicWaitByLocator(RSPChangePasswordPage.txtNewPassword,60);
        type(RSPChangePasswordPage.txtNewPassword,newPassword,"Enter new password");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterConfirmNewPasswordInChangePassword
     * description :: to enter confirm password
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void enterConfirmNewPasswordInChangePassword(String confirmNewPassword) throws Throwable {
        dynamicWaitByLocator(RSPChangePasswordPage.txtConfirmNewPassword,60);
        type(RSPChangePasswordPage.txtConfirmNewPassword,confirmNewPassword,"Enter confirm new password password");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSubmitButton
     * description ::to click on submit button
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnSubmitButton() throws Throwable {
        dynamicWaitByLocator(RSPChangePasswordPage.btnSubmit,60);
        click(RSPChangePasswordPage.btnSubmit,"Submit button");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPasswordCriteria
     * description ::to get password criteria to change password
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public String getPasswordCriteria() throws Throwable {
        dynamicWaitByLocator(RSPChangePasswordPage.lblPasswordCriteria,60);
        String passwordCriteria=getText(RSPChangePasswordPage.lblPasswordCriteria,"Password criteria");
        return passwordCriteria;
    }
    /**
     * param ::
     * return ::List
     * throws :: throwable
     * methodName :: getPasswordCriteriaLineByLine
     * description ::to get password criteria line by line while changing password
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public List getPasswordCriteriaLineByLine() throws Throwable {
        dynamicWaitByLocator(RSPChangePasswordPage.lblSetPasswordCriteria,60);
        List passwordCriteriaForSettingNewPassword=getTableDataByRow(RSPChangePasswordPage.lblSetPasswordCriteria,"Password criteria");
        return passwordCriteriaForSettingNewPassword;
    }
}
