package com.wallethub.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.core.UtilityMethods;

public class InsuranceCompanyPage {

	WebDriver driver;
	UtilityMethods utilsMethods;
	
	@FindBy(css ="div.progress-indicator-container>ng-dropdown>div.second")
	WebElement policyDropdown;
	
	@FindBy(xpath ="//ul[contains(@class,'dropdown-list')]/li[text()='Health Insurance']")
	WebElement healthInsuranceOpt;
	
	@FindBy(xpath ="//textarea[contains(@class,'wrev-user-input')]")
	WebElement reviewTextbox;
	
	@FindBy(css ="div.sbn-action")
	WebElement submitButton;
	
	@FindBy(css ="div.brgm-user>span")
	WebElement userNameMenu;
	
	@FindBy(xpath ="//a[@href=/profile/68565950i]")
	WebElement profileTab;
	
	@FindBy(css ="h2.pr-rec-title")
	WebElement recommendationSubmittedText;
	
	public InsuranceCompanyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	};
	
	public void writeReviewAndSubmit(String policyOption) {
		utilsMethods=new UtilityMethods(driver);
		utilsMethods.waitTillElementVisibility(policyDropdown);
		utilsMethods.click(policyDropdown, "Policy dropdown");
		utilsMethods.waitTillElementVisibility(healthInsuranceOpt);
		//utilsMethods.click(healthInsuranceOpt, policyOption+" option");
		utilsMethods.clickUsingActions(healthInsuranceOpt, policyOption+" option");
		String text=utilsMethods.generateRandomString(200)+" "+utilsMethods.generateRandomString(4)+" "
		+utilsMethods.generateRandomString(4)+" "+utilsMethods.generateRandomString(4)+
		" "+utilsMethods.generateRandomString(4)+" "+utilsMethods.generateRandomString(4);
		utilsMethods.setText(reviewTextbox, text);
		utilsMethods.click(submitButton, "Submit button");
	};
	
	public void openProfile(String url) {
		utilsMethods=new UtilityMethods(driver);
		utilsMethods.waitTillElementVisibility(userNameMenu);
		utilsMethods.navigateToUrl(url);
	};
	
	public WebElement getRecomendationElement() {
		return recommendationSubmittedText;
	};
};
