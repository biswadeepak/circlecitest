package com.qa.pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.stepDefinations.Bookflight;
import com.qa.util.TestBase;

import io.qameta.allure.Step;

/**
 * This class is to define all the locators used in the flight page
 *
 */
public class FlightsPage extends TestBase {

	WebDriver driver;
	Bookflight bookflight;

	// Initializing Page Object
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Factory-OR
	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement fromCityMumbai;

	@FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input")
	public WebElement enterMumbai;

	@FindBy(xpath = "//p[contains(text(),'Mumbai, India')]")
	public WebElement selectMumbai;

	@FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween']/div/input	")
	public WebElement enterDelhi;

	@FindBy(xpath = "//div[@class='calc60']/p[text()='New Delhi, India']")
	public WebElement selectDelhi;

	@FindBy(xpath = "//div[@class='DayPicker-Day DayPicker-Day--selected']")
	public WebElement selectDate;

	@FindBy(xpath = "//p[contains(text(),'Flights from ')]")
	public WebElement verifyFlightSearch;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	public WebElement searchFlightBtn;

	@FindBy(xpath = "//div[@class='filterWrapper']/div[3]/div/label[1]/div/span[2]/span")
	public WebElement nonStopFlights;

	@FindBy(xpath = "//div[@class='filterWrapper']/div[5]/div/div/div[2]/span")
	public WebElement Mumbai6_12;

	@FindBy(xpath = "//div[@id='premEcon']/div/div[1]/div[1]/div[2]/div[4]/div/button")
	public WebElement PricesBtn;

	@FindBy(xpath = "//div[@id='premEcon']/div/div[1]/div[3]/div/div[2]/div/div[3]/button")
	public WebElement bookNowBtn;

	@FindBy(xpath = "((//div[@class='insRadioSection appendBottom8 '])[1]//span)[1]")
	public WebElement secureRadioBtn;

	@FindBy(xpath = "//button[contains(text(),'+ ADD NEW ADULT')]")
	public WebElement AddNewAdultLink;

	@FindBy(xpath = "//input[@placeholder='First & Middle Name']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastName;

	@FindBy(xpath = "//div[@class='adultItem']/div/div/label[1]")
	public WebElement selectGender;

	@FindBy(xpath = "//div[@id='Mobile No']/div/input")
	public WebElement EnterMobNo;

	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement EnterEmailid;

	@FindBy(xpath = "//div[@class='makeFlex hrtlCenter spaceBetween appendTop15']/button")
	public WebElement FinalContinue;

	@FindBy(xpath = "//button[contains(text(),'CONFIRM')]")
	public WebElement reviewConfirm;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/p[1]")
	public WebElement getPrice;

	@FindBy(xpath = "//p[@class='fareRow']/span[2]")
	public WebElement totalAmount;

	@FindBy(xpath = "//p[@class='fareRow']/span[2]")
	public WebElement reviewAmount;

	@FindBy(xpath = "//button[text()='Yes, Please']")
	public WebElement yespop;
	
	@FindBy(xpath = "//span[text()='I agree to the ']")
	public WebElement secureRadioBtn1;
	
	@FindBy(id = "review-continue")
	public WebElement reviewContinueBtn;
	
	@FindBy(xpath = "//label[@tabindex=0]")
	public WebElement gender;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement finalContinueBtn2;
	
	@FindBy(xpath = "//a[@class='fli_primary_btn btn marR10']")
	public WebElement finalConfirmBtn2;
	
	@FindBy(xpath = "//a[@id='ancillary-secondary']")
	public WebElement skipPaymentLink;
	
	@FindBy(xpath = "//a[@class='btn fli_secondry_btn text-uppercase']")
	public WebElement continueAnywayBtn;


	// Actions

	/*
	 * 
	 * Here Select the Mumbai Location
	 * 
	 */
	@Step("Select From As Mumbai location from drop down")
	public void select_Mumbai() throws Exception {
		fromCityMumbai.click();
		ExpliciteWait(enterMumbai);
		enterMumbai.sendKeys(prop.getProperty("loc1"));
		Wait();
		selectMumbai.click();
	}

	/*
	 * 
	 * Here Select the Delhi Location
	 * 
	 */
	@Step("Select To As Delhi location from drop down")
	public void select_Delhi() throws Exception {
		
		ExpliciteWait(enterDelhi);
		enterDelhi.sendKeys(prop.getProperty("loc2"));
		ExpliciteWait(selectDelhi);
		selectDelhi.click();

	}

	/*
	 * 
	 * Here Select the tomorrow Date
	 * 
	 */
	@Step("Select tomorrow date from calender")
	public void select_Date() {
		Wait();
		selectDate.click();
	}

	/*
	 * 
	 * Here Search the flights
	 * 
	 */
	@Step("Click on Search button to search flights")
	public void searchFlights() throws InterruptedException {

		Wait();
		searchFlightBtn.click();
		Wait();

	}

	/*
	 * 
	 * Here select the NonStop Check Box from Mumbai Option
	 * 
	 */
	@Step("Check Non-Stop check box from mumbai")
	public void CheckOnNonStop() throws InterruptedException {
		ExpliciteWait(nonStopFlights);
		nonStopFlights.click();
	}

	/*
	 * 
	 * Here select the 6AM-12PM in Deparature from Mumbai option
	 * 
	 * 
	 */
	@Step("Select Mumbai 6AM-12PM")
	public void Mumbai6_12() {
		ExpliciteWait(Mumbai6_12);
		Mumbai6_12.click();
	}
	
	//Verify Flight Page
	@Step("Verify flights from Mumbai to Delhi for tomorrow")
	public boolean verifySearchFlightPage() throws InterruptedException {
		ExpliciteWait(verifyFlightSearch);
		return verifyFlightSearch.isDisplayed();
	}

	/*
	 * 
	 * Here Search the flight and Click on View Prices button for lowest flight
	 * price
	 * 
	 */
	
	@Step("Click on Lowest price button of lowest flight price")
	public void ClickOnFlightPrice() {

		PricesBtn.click();
	}

	/*
	 * 
	 * Click on View Prices Button
	 * 
	 * 
	 */
	
	@Step("Book flight clicking on Book Now button")
	public void BookFlight() {

		bookNowBtn.click();

	}
	
	/*
	 * 
	 * 
	 * Switch to another window
	 * 
	 * 
	 * */

	@Step("Another Page will open for Booking flight")
	public void switchTabs(int no) {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(no));
	}

	/*
	 * 
	 * 
	 * Enter the customer details in Complete Your Booking Page
	 * 
	 * 
	 */

	@Step("Complete Page or Review Page will Open to enter Cutomer details")
	public void CustomerDetails() throws Throwable {
		try {
			switchTabs(1);
			ExpliciteWait(secureRadioBtn);
			click(secureRadioBtn);
			Thread.sleep(10000);
			click(AddNewAdultLink);
			Wait();
			firstName.sendKeys(prop.getProperty("firstname"));
			Wait();
			lastName.sendKeys(prop.getProperty("lastname"));
			Wait();
			selectGender.click();
			Wait();
			EnterMobNo.sendKeys(prop.getProperty("mob"));
			Wait();
			EnterEmailid.sendKeys(prop.getProperty("email"));

			Wait();

			Tab();

			Wait();
			reviewConfirm.click();

			Wait();
			
			click(yespop);
		} catch (Exception e) {
			
			try {
			ExpliciteWait(secureRadioBtn1);
			click(secureRadioBtn1);
			
			Thread.sleep(10000);
			click(reviewContinueBtn);
			
			
			
			ExpliciteWait(firstName);
			firstName.sendKeys(prop.getProperty("firstname"));
			ExpliciteWait(lastName);
			lastName.sendKeys(prop.getProperty("lastname"));
			ExpliciteWait(gender);
			click(gender);
			ExpliciteWait(EnterMobNo);
			EnterMobNo.sendKeys(prop.getProperty("mob"));
			ExpliciteWait(EnterEmailid);
			EnterEmailid.sendKeys(prop.getProperty("email"));
			ExpliciteWait(finalContinueBtn2);
			click(finalContinueBtn2);
			ExpliciteWait(finalConfirmBtn2);
			click(finalConfirmBtn2);
			ExpliciteWait(skipPaymentLink);
			click(skipPaymentLink);
			ExpliciteWait(continueAnywayBtn);
			click(continueAnywayBtn);
			}
			catch(Exception ex) {
				
			}
		}
	
	}

}
