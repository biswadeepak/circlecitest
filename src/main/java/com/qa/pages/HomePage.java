package com.qa.pages;

import org.openqa.selenium.WebDriver;

/**
 * This class is to define all the locators used in the home page
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class HomePage {

	WebDriver driver;

	// Initializing the Page Objects

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Factory-OR

	@FindBy(xpath = "//li[@data-cy='account']")
	public WebElement loginLink;

	@FindBy(id = "username")
	public WebElement mobno;

	@FindBy(xpath = "//button[@data-cy='continueBtn']")
	public WebElement continueBtn;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	public WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	public WebElement flightLink;

	@FindBy(xpath = "//li[@class='menu_Hotels']/a/span[1]")
	public WebElement hotelsLink;

	@FindBy(xpath = "//div[@data-cy='outsideModal']")
	public WebElement popUpElement;

	// Actions

	/*
	 * 
	 * Here to Click on Search button for flight Search
	 * 
	 * 
	 * 
	 */
	
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on Search button to see flights")
	public FlightsPage ClickOnFilgtsPage() {
		flightLink.click();

		return new FlightsPage(driver);

	}

	/*
	 * 
	 * 
	 * Here to Verify Hotels Page
	 * 
	 * 
	 */
	
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on Hotels to see hotels page")
	public HotelsPage verifyHotelsPage() {
		hotelsLink.click();

		return new HotelsPage();

	}

	/*
	 * 
	 * 
	 * Here to click randomly to close hidden Modal
	 * 
	 * 
	 */
	
	@Severity(SeverityLevel.CRITICAL)
    @Description("Click on Modal to do other actions")
	public void LoginPopUp() {

		popUpElement.click();
	}

}
