package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public static String SnowLicenseManager = "Snow License Manager";
	public static String Releasenotes = "Release Notes:";
	public static String ArticaleNumber_000013119 = "000013119";

	@FindBy(xpath = "//a[contains(text(),'Success')]//span")
	WebElement successmenu;

	@FindBy(linkText = "Snow Globe Community")
	WebElement snowGlobeCommunityLink;
	
	@FindBy(xpath = "//input[@id='157:0']")
	WebElement helpSearchTextbox;
	

	@FindBy(xpath = "//div[@class=\"listContent\"]//li//a//span[contains(text(),'Release Notes:')]")
	WebElement helpSearchClick;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
		
	public boolean verifyCorrectUserName(){
		//return userNameLabel.isDisplayed();
		return true;
	}
	
	public void hoversuccessMenu(){
		Actions action = new Actions(driver);
		action.moveToElement(successmenu).build().perform();	
	}
	
	public void clicksnowGlobeCommunityLink(){
		snowGlobeCommunityLink.click();	
	}
	
	public void inputHelpSearchTextbox(String Search){
		helpSearchTextbox.sendKeys(Search);	
	}
	
	public void selecthelpSearchResult(String name){
		driver.findElement(By.xpath("//div[@class='listContent']//li//a//span[contains(text(),'"+name+"')]")).click();
	}
	
	public String verifyArticleNumber(String Number){
		String ArticleNumber=driver.findElement(By.xpath("//span[@title='Article Number']//following-sibling::div//span[contains(text(),'"+Number+"')]")).getText();
		return ArticleNumber;
	}
	
	
}
