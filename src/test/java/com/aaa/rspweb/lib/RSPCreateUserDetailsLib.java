package com.aaa.rspweb.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aaa.rspweb.pages.RSPCreateUserDetailsPage;

public class RSPCreateUserDetailsLib extends RSPCommonLib{

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEnableButton
     * description :: To click on enable button
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnEnableButton() throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.btnEnabled,60);
        click(RSPCreateUserDetailsPage.btnEnabled,"Button enabled");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDisableButton
     * description :: To click on disable button
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnDisableButton() throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.btnDisabled,60);
        click(RSPCreateUserDetailsPage.btnDisabled,"Button disable");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: enterUserName
     * description :: To enter the user name
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void enterUserName(String name) throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.txtUserName,60);
        type(RSPCreateUserDetailsPage.txtUserName,name,"User Name");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectRoleDropdown
     * description :: To click on select role drop down before selecting a value
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnSelectRoleDropdown() throws Throwable {
        clickOnSelectRoleDropdown();
        dynamicWaitByLocator(RSPCreateUserDetailsPage.drpdwnSelectRole,60);
        click(RSPCreateUserDetailsPage.drpdwnSelectRole,"Select role dropdown");
    }
    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectRoleFromDropdown
     * description :: pass the role name available in select dropdown to select the role
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void selectRoleFromDropdown(String roleName) throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.selectRoleFromDropdown(roleName),60);
        selectByValue(RSPCreateUserDetailsPage.selectRoleFromDropdown(roleName),roleName,"Select role from dropdown");
    }

    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifySelectClubDropdownIsDisable
     * description :: To verify select club drop down is disable or not
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */

    public boolean verifySelectClubDropdownIsDisableOrEnable() throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.drpdwnSelectClubDisabled,60);
        boolean flag=false;
        if(!isEnabled(RSPCreateUserDetailsPage.drpdwnSelectClubDisabled, "Dropdown select club disabled"))
        {
            flag=true;
        }
        return flag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectClubDropdown
     * description :: To click on select club drop down before selecting value
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    //Pass click as action if want to perform action

    public void clickOnSelectClubDropdown() throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.drpdwnSelectClubDisabled,60);
        click(RSPCreateUserDetailsPage.drpdwnSelectClubDisabled, "Click on select club dropdown");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: selectClubFromDropdown
     * description :: pass club values displayed in dropdown to select club from drop down
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void selectClubFromDropdown(String club) throws Throwable {
        clickOnSelectClubDropdown();
        dynamicWaitByLocator(RSPCreateUserDetailsPage.selectClubFromDropdown(club),60);
        selectByValue(RSPCreateUserDetailsPage.selectRoleFromDropdown(club),club,"Select club from dropdown");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnChooseShops
     * description :: to click on choose shop
     * date :: 11-Mar-2018
     * author :: Jagadish Pola
     */
    public void clickOnChooseShops() throws Throwable {
        dynamicWaitByLocator(RSPCreateUserDetailsPage.btnChooseShops, 60);
        click(RSPCreateUserDetailsPage.btnChooseShops, "Choose shops");
    }
    
    /**
   	 * @param string 
   	 * @throws Throwable 
   	 * 
   	 */
    public List<String> getAvailableUserRoles() throws Throwable{
    	WebElement selectElement = findWebElement(RSPCreateUserDetailsPage.drpdwnSelectRole,"UserRole Drop Down");
    	Select select = new Select(selectElement);
    	List<WebElement> allOptions = select.getOptions();
    	List<String> userRoles=new ArrayList<>();
    	for (WebElement value : allOptions)
    	{
    		userRoles.add(value.getText());
    	}
    	return userRoles;
    }
    
    /**
   	 * @param string 
   	 * @throws Throwable 
   	 * 
   	 */
    public List<String> getCreatableUserRoles(String loggedInUserType) throws Throwable{
    	List<String> userRoles=new ArrayList<>();
    	switch(loggedInUserType){
    	case "Super User":
    		userRoles = Arrays.asList("Super User","Club Admin", "Club User", "Shop Admin", "Shop User");;
    		break;
    	case "Club Admin":
    		userRoles = Arrays.asList("Club Admin", "Club User", "Shop Admin", "Shop User");;
    		break;
    	case "Club User":
    		userRoles = Arrays.asList("Shop Admin", "Shop User");;
    		break;
    	case "Shop Admin":
    		userRoles = Arrays.asList("Shop User");;
    		break;
    	default:
        		break;
    	}
    	return userRoles;
    }
    /**
	 * @param string 
	 * @throws Throwable 
	 * 
	 */
	public void validateCreatableUserRoles(String loggedInUserType) throws Throwable {
		//Get the logged in User
		//Get the list of users he can create - Expected
		List<String> creatableUserRoles=getCreatableUserRoles(loggedInUserType);
		creatableUserRoles.sort((d1,d2) -> d1.compareTo(d2));
		//Get the list of users visible in the dropdown - Actual
		List<String> avialbleUserRoles=getAvailableUserRoles();
		avialbleUserRoles.sort((d1,d2) -> d1.compareTo(d2));
		assertTrue(creatableUserRoles.size()==avialbleUserRoles.size(),"Expected Number of User Roles are displayed: "+avialbleUserRoles.size());
		for(int i=0;i<creatableUserRoles.size();i++){
			assertTrue(creatableUserRoles.get(i).trim().equals(avialbleUserRoles.get(i).trim()),"Expected UserRole :" + creatableUserRoles.get(i).trim()+ " and Actual UserRole :" + avialbleUserRoles.get(i).trim()+ " are found");
		}
	}
	
}
