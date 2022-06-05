package com.wallethub.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.core.UtilityMethods;

public class LoginPage {

	WebDriver driver;
	UtilityMethods utilsMethods;
	
	@FindBy(xpath ="//a[contains(@ng-click,'login')]")
	WebElement loginTab;
	
	@FindBy(name ="em")
	WebElement emailtextbox;
	
	@FindBy(name ="pw1")
	WebElement pwdTextbox;
	
	@FindBy(xpath ="//button[contains(@data-hm-tap,'doSubmit')]")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	};
	
	public void login(String email,String pwd) {
		utilsMethods=new UtilityMethods(driver);
		//utilsMethods.navigateToUrl(url);
		utilsMethods.waitTillElementVisibility(loginTab);
		utilsMethods.click(loginTab, "Login tab");
		utilsMethods.setText(emailtextbox, email);
		utilsMethods.setText(pwdTextbox, pwd);
		utilsMethods.click(loginButton, "Login button");
	}
}
