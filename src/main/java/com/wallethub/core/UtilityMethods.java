package com.wallethub.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.utils.Log;
import com.wallethub.utils.Reports;

public class UtilityMethods {

	WebDriver driver;

	public UtilityMethods(WebDriver driver) {
		this.driver = driver;
	};

	/**
	 * Gets the data from the properties file
	 * 
	 * @param Key.
	 */
	public static String getPropFileData(String key) {
		String filePath = System.getProperty("user.dir") + "/src/main/java/com/wallethub/config/credentials.properties";
		FileInputStream file;
		Properties prop;
		String value = "";
		try {
			file = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(file);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	};

	/**
	 * Wait for specified time until the element is displayed
	 * 
	 * @param WebElement.
	 */
	public void waitTillElementVisibility(WebElement element) {
		WebDriverWait waitDriver = new WebDriverWait(driver, 15);
		waitDriver.until(ExpectedConditions.visibilityOf(element));
	};

	/**
	 * Set the text into the text field
	 * 
	 * @param WebElement
	 * @param text       - text to be entered
	 */
	public void setText(WebElement Element, String text) {
		Log.info("Setting text");
		try {
			waitTillElementVisibility(Element);
			Element.sendKeys(text);
			Log.info("Pass:" + text + " is entered");
			Reports.setMethodMessage("Pass:" + text + " is entered");
		} catch (Exception e) {
			Log.info("Fail:Unable to set text: " + text);
			Reports.setMethodMessage("Fail:Unable to set text: " + text);
			e.printStackTrace();
		}
	};

	/**
	 * Perform click on the specified webelement
	 * 
	 * @param WebElement
	 * @param name       - name of the web element
	 */
	public void click(WebElement Element, String name) {
		Log.info("Clicking on " + name);
		try {
			Element.click();
			Log.info("Pass: " + name + " :is clicked");
			Reports.setMethodMessage("Pass: " + name + " :is clicked");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on " + name);
			Reports.setMethodMessage("Fail:Could not Click on " + name);
		}
	};

	/**
	 * Perform mouse hover on the specified web element
	 * 
	 * @param WebElement
	 * @param elementName - name of the web element
	 */
	public void mouseHover(WebElement element, String elementName) {
		Log.info("Hovering mouse on " + elementName);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Log.info("Pass: Mouse hover on " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fail: Mouse hover on " + elementName);
		}
	};

	/**
	 * Generates random string of given size
	 * 
	 * @param size - size of string to be generated
	 */
	public String generateRandomString(int size) {
		Log.info("Generating random string of " + size + " characters");
		String randomStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
		String value = "";
		try {
			StringBuilder sb = new StringBuilder(size);

			for (int i = 0; i < size; i++) {
				int index = (int) (randomStr.length() * Math.random());
				sb.append(randomStr.charAt(index));
			}
			value = sb.toString();
			Log.info("Pass: Random string generated is-" + value);
		} catch (Exception e) {
			Log.info("Fail: Couldn't generate random string");
			e.printStackTrace();
		}
		return value;
	};

	/**
	 * Navigate to a specified URL
	 * 
	 * @param url
	 */
	public void navigateToUrl(String url) {
		driver.get(url);
	};

	/**
	 * Performs click on the specified web element using Actions class
	 * 
	 * @param WebElement
	 * 
	 * @param name       - name of the web element
	 */
	public void clickUsingActions(WebElement Element, String name) {
		Log.info("Clicking using Actions on:" + name);
		Reports.setMethodMessage("Clicking using Actions on:" + name);
		try {
			WebElement element = Element;
			Actions action = new Actions(driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			action.moveToElement(element).click().perform();
			Log.info("Pass:" + name + " is clicked");
			Reports.setMethodMessage("Pass:" + name + " is clicked");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on:" + name);
			Reports.setMethodMessage("Fail:Could not Click on:" + name);
		}
	}

}
