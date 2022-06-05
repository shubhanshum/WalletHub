package com.wallethub.tests;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.wallethub.utils.Reports;

public class BaseTest {

	WebDriver driver;
	Reports reports;

	/**
	 * Use to launch chrome browser and navigate to the url.
	 * 
	 * @param URL.
	 */
	@Parameters("url")
	@BeforeClass
	public void setUp(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//BrowserDriverServers//chromedriver");
		driver = new ChromeDriver(options);
		driver.get(url);
		if (reports.extent == null) {
			Reports.setReport();
		}
		BasicConfigurator.configure();
		try {
			freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	};

	/**
	 * Gets the result after each test method
	 */
	@AfterMethod(alwaysRun = true)
	public void verifyingResult(ITestResult result) {
		Reports.getResult(result);
	};

	/**
	 * Closes the browser tab and flush the extent report
	 */
	@AfterClass
	public void tearDown() {
		driver.close();
		Reports.flush();
	};
}
