package com.wallethub.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.core.UtilityMethods;

public class LandingPage {

	WebDriver driver;
	UtilityMethods utilsMethods;
	
	@FindBy(xpath ="//a[contains(@href,'test-insurance-company')]")
	WebElement testInsuranceTab;

	@FindBy(xpath ="//span[text()='Reviews'][@class='nav-txt']")
	WebElement reviewTab;
	
	@FindBy(css ="div.review-action>review-star>div.rating-box-wrapper>svg")
	List<WebElement> stars;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	};
	
	public void selectStar(int starIndex) {
		utilsMethods=new UtilityMethods(driver);
		utilsMethods.waitTillElementVisibility(testInsuranceTab);
		utilsMethods.click(testInsuranceTab, "Test Insurance tab");
		utilsMethods.waitTillElementVisibility(reviewTab);
		utilsMethods.click(reviewTab, "Review tab");
		//int starsLength=stars.size();
		for (WebElement star:stars) {
			utilsMethods.mouseHover(star, "star");
		};
		utilsMethods.click(stars.get(starIndex-1), starIndex+"th star");
	};
}
