package com.wallethub.core;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.wallethub.utils.Log;
import com.wallethub.utils.Reports;


public class Validation {

	/**
	 * Asserts whether the specified element is displayed or not.
	 * If not displayed, mark test as failed and
	 * stop the execution of that test method
	 * 
	 * @param Element
	 * 
	 * @param name - name of web element
	 */
	public static void isElementDisplayed(WebElement Element,String name) {
		Log.info("Verifying Is Element Displayed:"+name);
		Reports.setMethodMessage("Verifying Is Element Displayed");
		boolean status=Element.isDisplayed();
		if (status==true) {
			Log.info("Pass:"+name+" is displayed");
			Reports.setMethodMessage("Pass:"+name+" is displayed");
		}
		else{
			Log.info("Fail:"+name+" is NOT displayed");
			Reports.setMethodMessage("Fail:"+name+" is NOT displayed");
			Assert.fail();
		}
	}
}
