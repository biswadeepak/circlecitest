package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * This class is to define all the locators used in the hotels page
 *
 */


public class HotelsPage extends TestBase{
	
	HomePage homepage;
	
	//Page Factory-OR
	
	
	@FindBy(xpath = "//div[@class='chHeaderContainer']/nav/ul/li[2]/a")
	public WebElement hotelsLink;
	
	@FindBy(id = "city")
	public WebElement selectLocations;
	
	@FindBy(xpath = "//div[@class='hsw_autocomplePopup locus autoSuggestPlugin ']/div/input")
	public WebElement EnterMumbai;
	
	@FindBy(xpath = "//p[contains(text(),'Mumbai, Maharashtra, India')]")
	public WebElement selectMumbai;
	
	@FindBy(xpath = "//button[@id='hsw_search_button']")
	public WebElement searchHotels;
	
	
	@FindBy(xpath = "//div[@id='seoH1DontRemoveContainer']/p[contains(text(),'Hotels, Villas, Apartments and more in Mumbai')]")
	public WebElement verifyhotels;
	
	
	
	
	//Initializing Page Object
			public HotelsPage(){
				PageFactory.initElements(driver,this);
			}
			
	//Actions
			
			/*
			 * 
			 * 
			 * Here Cliking On Hotels tab after Opening the Browser
			 * 
			 * 
			 * 
			 * */
			
			@Severity(SeverityLevel.NORMAL)
		    @Description("Click on Hotels Link")
		    @Story("Story Name : Verify Hotels in Mumbai")
			
			public HotelsPage ClickOnHotelsPage(){
				homepage = new HomePage(driver);
				hotelsLink.click();
				return new HotelsPage();
			}
			
			/*
			 * 
			 * Select Location
			 * 
			 * */
			
			@Severity(SeverityLevel.NORMAL)
		    @Description("Click on Drop down box")
		    @Story("Story Name : Verify Hotels in Mumbai")
			public void SelectLoc(){
				selectLocations.click();
				
			}
			
			/*
			 * 
			 * 
			 * Here Enter the Mumbai and Click on Search Button
			 * 
			 * 
			 * */
			
			@Severity(SeverityLevel.NORMAL)
		    @Description("Enter Mumbai and Select Mumbai")
		    @Story("Story Name : Verify Hotels in Mumbai")
			public void SelectLocAsMumbai(){
				Wait();
				EnterMumbai.sendKeys(prop.getProperty("loc1"));
				ExpliciteWait(selectMumbai);
				selectMumbai.click();
				ExpliciteWait(selectLocations);
				selectLocations.click();
				ExpliciteWait(selectMumbai);
				selectMumbai.click();
				ExpliciteWait(searchHotels);
				searchHotels.click();	
				
			}
			
				
}
