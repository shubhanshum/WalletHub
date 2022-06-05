package com.wallethub.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wallethub.core.UtilityMethods;
import com.wallethub.core.Validation;
import com.wallethub.pageobjects.InsuranceCompanyPage;
import com.wallethub.pageobjects.LandingPage;
import com.wallethub.pageobjects.LoginPage;
import com.wallethub.utils.Log;
import com.wallethub.utils.Reports;

public class ReviewSubmissionTest extends BaseTest{

	LandingPage objLanding;
	InsuranceCompanyPage objInsurance;
	LoginPage objLogin;
	
	@Parameters("url")
	@Test
	public void submitReviewTest(String url) {
		Reports.setTestName(this.getClass().getSimpleName());
		Log.startTestCase(this.getClass().getSimpleName());
		objLanding=new LandingPage(driver);
		objInsurance=new InsuranceCompanyPage(driver);
		objLogin=new LoginPage(driver);
		String email=UtilityMethods.getPropFileData("wallethubUserName");
		String password=UtilityMethods.getPropFileData("walletHubPassword");
		objLanding.selectStar(4);
		objInsurance.writeReviewAndSubmit("Health Insurance");
		objLogin.login(email, password);
		objInsurance.openProfile(url);
		Validation.isElementDisplayed(objInsurance.getRecomendationElement(), "Recommendation submitted");
		
	};
}
