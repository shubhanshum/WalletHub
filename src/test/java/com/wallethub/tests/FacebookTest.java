package com.wallethub.tests;

import org.testng.annotations.Test;

import com.wallethub.core.UtilityMethods;
import com.wallethub.core.Validation;
import com.wallethub.facebook.pageobjects.HomePage;
import com.wallethub.facebook.pageobjects.LoginPage;
import com.wallethub.utils.Log;
import com.wallethub.utils.Reports;

public class FacebookTest extends BaseTest{
	
	LoginPage objLogin;
	HomePage objHome;
	
	@Test
	public void facebookPostTest() {
		Reports.setTestName(this.getClass().getSimpleName());
		Log.startTestCase(this.getClass().getSimpleName());
		objLogin=new LoginPage(driver);
		objHome=new HomePage(driver);
		String username=UtilityMethods.getPropFileData("facebookUserName");
		String password=UtilityMethods.getPropFileData("facebookPassword");
		objLogin.login(username, password);
		objHome.createPost();
		Validation.isElementDisplayed(objHome.getLikElement(), "Like button");
		
	};
}
