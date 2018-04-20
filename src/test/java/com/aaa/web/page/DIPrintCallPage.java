package com.aaa.web.page;

import org.openqa.selenium.By;

public class DIPrintCallPage {
	
	public static By lblMemberShipNumber;
	public static By lblMemberConatctName;
	public static By lblMemberCityName;
	public static By lblMemberStateName;
	public static By lblMemberLevle;
	public static By lblvehicleYear;
	public static By lblvehicleMake;
	public static By lblVehicleColor;
	public static By lblVehicleModel;
	public static By lblVehicleType;
	public static By lblPacesetterCode;
	public static By lblTroubleCode;
	public static By lblCallId;
    public static By lblCallDate;
    public static By lblClub;
    public static By lblPrintedOn;
    public static By lblD3User;
    public static By lblD3Satus;
    public static By lblExpiration;
    public static By lblAddress;
    public static By lblBreakDownLocation;
    public static By lblBreakDownCity;
    public static By lblBreakDownPta;
    public static By lblBreakDownState;
    public static By lblFacility;
    public static By lblDispatchRegion;
    public static By lblTowDestination;

	static {
		lblMemberShipNumber = By.id("mbrship-number");
		lblMemberConatctName = By.id("contact-name");
		lblMemberCityName = By.id("mbr-city");
		lblMemberStateName = By.id("mbr-state");
		lblMemberLevle= By.id("mbrship-plus");
		lblvehicleYear= By.id("vehicle-year");
		lblvehicleMake= By.id("vehicle-make");
		lblVehicleColor= By.id("vehicle-color");
		lblVehicleModel= By.id("vehicle-model");
		lblVehicleType= By.id("vehicle-type");
		lblPacesetterCode= By.id("pacesetter-code");
		lblTroubleCode= By.id("trouble-code");
		lblCallId= By.id("call-id");
		lblCallDate= By.id("call-date");
		lblClub= By.id("club");
		lblPrintedOn= By.id("print-date");
		lblD3User= By.id("user");
		lblD3Satus= By.id("mbrship-status");
		lblExpiration= By.id("mbrship-expires");
		lblAddress= By.id("mbr-address1");
		//breakdownInformation
		lblBreakDownLocation=By.id("breakdown-location");
		lblBreakDownCity=By.id("breakdown-city");
		lblBreakDownPta=By.id("pta");
		lblBreakDownState=By.id("breakdown-state");
		lblFacility=By.id("facility-id");
		lblDispatchRegion=By.id("dispatch-region");
		lblTowDestination=By.id("tow-dest");





	}

}
