package com.wallethub.facebook.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.core.UtilityMethods;

public class HomePage {

	WebDriver driver;
	UtilityMethods utilsMethods;

	@FindBy(xpath ="//div[@role='button']//span[contains(@style,'webkit-box-orient')]")
	WebElement statusTextbox;
	
	@FindBy(xpath ="//div[contains(@aria-label,'mind')]")
	WebElement createPostTextbox;
	
	@FindBy(xpath ="//div[@aria-label='Post']")
	WebElement postButton;
	
	@FindBy(xpath ="//div[@aria-label='Like']")
	WebElement likeButton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	};
	
	//Method to create a post
	public void createPost() {
		utilsMethods=new UtilityMethods(driver);
		utilsMethods.click(statusTextbox, "Status text box");
		String textString=utilsMethods.generateRandomString(5);
		//Facebook doesn't allow posting same text. So concatenating Hello World with random string
		utilsMethods.setText(createPostTextbox, "Hello World "+textString);
		utilsMethods.waitTillElementVisibility(postButton);
		utilsMethods.click(postButton, "Post button");
	};
	
	public WebElement getLikElement() {
		utilsMethods.waitTillElementVisibility(likeButton);
		return likeButton;
	}
};
