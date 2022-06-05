package com.wallethub.facebook.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.core.UtilityMethods;


public class LoginPage {
	
	 WebDriver driver;
	 UtilityMethods utilsMethods;

	@FindBy(id="email")
	WebElement emailTextbox;
	
	
	@FindBy(id="pass")
	WebElement passwordTextbox;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	};
	
	//Method to login into facebook
	public void login(String email, String password)  {
		utilsMethods=new UtilityMethods(driver);
		utilsMethods.setText(emailTextbox, email);
		utilsMethods.setText(passwordTextbox, password);
		utilsMethods.click(loginButton,"Login button");
	};
	
	
};
