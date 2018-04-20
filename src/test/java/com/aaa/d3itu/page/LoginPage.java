package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class LoginPage {
	public static By userName;
	public static By password;
	public static By login;
	public static By error;
	public static By errorDialogText;
	public static By errorDialogOkBtn;

	static {

		userName =By.xpath("//android.widget.EditText[@text='Username:']");
		password =By.xpath("//android.widget.EditText[@text='Password:']");
		login = By.xpath("(//android.view.View[@text='Login'])[2]");
		error = By.id("com.aaa.d3itu:id/ErrorDialog");
		errorDialogText = By.id("com.aaa.d3itu:id/ErrorDialogText");
		errorDialogOkBtn = By.id("com.aaa.d3itu:id/ErrorDialogOkButton");
	}
}





