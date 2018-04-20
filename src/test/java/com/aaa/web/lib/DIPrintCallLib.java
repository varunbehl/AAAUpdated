package com.aaa.web.lib;


import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.DIPrintCallPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DIPrintCallLib extends ActionEngine {

	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMemberShipNumber
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

    public String getMemberShipNumber() throws Throwable {
    	String memberShipnumber = getText(DIPrintCallPage.lblMemberShipNumber,"MemberShip Number");
    	return memberShipnumber;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMemberContactName
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getMemberContactName() throws Throwable {
		String memberContactName = getText(DIPrintCallPage.lblMemberConatctName,"MemberShip Contact Name");
		return memberContactName;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMemberCityName
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getMemberCityName() throws Throwable {
		String memberContactCity = getText(DIPrintCallPage.lblMemberCityName,"MemberShip City Name");
		return memberContactCity;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMemberStateName
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getMemberStateName() throws Throwable {
		String memberContactState = getText(DIPrintCallPage.lblMemberStateName,"MemberShip State Name");
		return memberContactState;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMemberStateName
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getMemberLevel() throws Throwable {
		String memberlevel = getText(DIPrintCallPage.lblMemberLevle,"MemberShip Level");
		return memberlevel;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleYear
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getVehicleYear() throws Throwable {
		String year = getText(DIPrintCallPage.lblvehicleYear,"Vehicle year");
		return year;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleMake
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getVehicleMake() throws Throwable {
		String make = getText(DIPrintCallPage.lblvehicleMake,"Vehicle make");
		return make;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleModel
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getVehicleModel() throws Throwable {
		String model = getText(DIPrintCallPage.lblVehicleModel,"Vehicle model");
		return model;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleColor
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getVehicleColor() throws Throwable {
		String color = getText(DIPrintCallPage.lblVehicleColor,"Vehicle color");
		return color;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleType
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getVehicleType() throws Throwable {
		String type = getText(DIPrintCallPage.lblVehicleType,"Vehicle Type");
		return type;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getpacesetterCode
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getpacesetterCode() throws Throwable {
		String pacesetterCode = getText(DIPrintCallPage.lblPacesetterCode,"Pacesetter code");
		return pacesetterCode;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getpacesetterCode
	 * description ::
	 * date :: 26-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getTroubleCode() throws Throwable {
		String troubleCode = getText(DIPrintCallPage.lblTroubleCode,"Trouble code");
		return troubleCode;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getCallID
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getCallID() throws Throwable {
		String callID = getText(DIPrintCallPage.lblCallId,"Call id");
		return callID;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getCallID
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getCallDate() throws Throwable {
		String callDate = getText(DIPrintCallPage.lblCallDate,"Call Date");
		return callDate;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getCallID
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getClub() throws Throwable {
		String club = getText(DIPrintCallPage.lblClub,"Club");
		return club;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getPrintedOn
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getPrintedOn() throws Throwable {
		String printedOn = getText(DIPrintCallPage.lblPrintedOn,"PrintedOn");
		return printedOn;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getD3User
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getD3User() throws Throwable {
		String user = getText(DIPrintCallPage.lblD3User,"User");
		return user;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getStatus
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getStatus() throws Throwable {
		String status = getText(DIPrintCallPage.lblD3Satus,"Status");
		return status;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getExpiration
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getExpiration() throws Throwable {
		String exp = getText(DIPrintCallPage.lblExpiration,"expiration");
		return exp;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getAddress
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getAddress() throws Throwable {
		String add = getText(DIPrintCallPage.lblAddress,"Address");
		return add;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownLocation
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getBreakDownLocation() throws Throwable {
		String badd = getText(DIPrintCallPage.lblBreakDownLocation,"BreakDown location");
		return badd;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownLocation
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getBreakDownCity() throws Throwable {
		String bCity = getText(DIPrintCallPage.lblBreakDownCity,"BreakDown location City");
		return bCity;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownLocation
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getBreakDownPta() throws Throwable {
		String bPTA = getText(DIPrintCallPage.lblBreakDownPta,"BreakDown location PTA");
		return bPTA;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownState
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getBreakDownState() throws Throwable {
		String bState = getText(DIPrintCallPage.lblBreakDownState,"BreakDown location State");
		return bState;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownState
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getFacility() throws Throwable {
		String bFacility = getText(DIPrintCallPage.lblFacility,"Facility");
		return bFacility;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownState
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getDispatchRegion() throws Throwable {
		String bFacility = getText(DIPrintCallPage.lblDispatchRegion,"DispatchRegion");
		return bFacility;
	}
	/**
	 * return ::void
	 * throws :: throwable
	 * methodName :: getBreakDownState
	 * description ::
	 * date :: 27-Mar-2018
	 * author :: Chandrasekhar Dendukuri
	 */

	public String getTowDestionation() throws Throwable {
		String tow = getText(DIPrintCallPage.lblTowDestination,"TowDestionation");
		return tow;
	}

}
