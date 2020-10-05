package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.util.TestUtil;

public class SearchPageTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage=new HomePage();
	}
	
	@Test
	public void verifyArticleNumberTest(){
		homePage.hoversuccessMenu();
		testUtil.implicitWait(testUtil.SECONDS_20);
		homePage.clicksnowGlobeCommunityLink();
		testUtil.implicitWait(testUtil.SECONDS_20);
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Welcome to Snow Globe","Home page title not matched");
		homePage.inputHelpSearchTextbox(homePage.SnowLicenseManager);
		homePage.selecthelpSearchResult(homePage.Releasenotes);
		String ActualArticaleNumber=homePage.verifyArticleNumber(HomePage.ArticaleNumber_000013119);
		Assert.assertEquals(ActualArticaleNumber, "000013119","Articale Number not matched");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
}
