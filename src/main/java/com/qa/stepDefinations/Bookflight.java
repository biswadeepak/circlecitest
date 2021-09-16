package com.qa.stepDefinations;


import org.testng.Assert;

import com.qa.pages.FlightsPage;
import com.qa.pages.HomePage;
import com.qa.util.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * 
 * This class defies to 1. Open MakeMyTrip in Browser 2. Select Location
 * From Mumbai 3. Select Location To Delhi 4. Select the tomorrow Date and
 * Search 5. Then Check Non Stop check Box and Click on Mumbai 6AM-12PM button
 * 6. Book the flight which price is low 7. Then Enter Customer deatils and
 * verify Fare summery
 * 
 */

public class Bookflight extends TestBase {
	HomePage homepage;
	FlightsPage flightspage;
	
	
	@Severity(SeverityLevel.NORMAL)
    @Description("User to Open Browser")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@Given("^User Opens Browser$")
	public void user_Opens_Browser() throws Throwable {
		TestBase.initialization();
		homepage = new HomePage(driver);
		flightspage = new FlightsPage(driver);
	}
	
	@Severity(SeverityLevel.NORMAL)
    @Description("Click randomly to disable modal")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@When("^Click on Random place$")
	public void click_on_Random_place() throws Throwable {
		homepage.LoginPopUp();
	}

	@Severity(SeverityLevel.CRITICAL)
    @Description("Select From as Mumbai location")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Select From Mumbai$")
	public void select_From_Mumbai() throws Throwable {
		flightspage.select_Mumbai();
	}

	@Severity(SeverityLevel.CRITICAL)
    @Description("Select From as Mumbai location")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Select To Delhi$")
	public void select_To_Delhi() throws Throwable {
		flightspage.select_Delhi();
	}
	
	@Severity(SeverityLevel.CRITICAL)
    @Description("Select tomorrow Date")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Select the date$")
	public void select_the_date() throws Throwable {
		flightspage.select_Date();
	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Click on Search button to Search flights")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Click on Search button$")
	public void click_on_Search_button() throws Throwable {

		flightspage.searchFlights();

	}

	@Severity(SeverityLevel.CRITICAL)
    @Description("Select check box as mumbai")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Click on Non Stop Checkbox$")
	public void click_on_Non_Stop_Checkbox() throws Throwable {
		flightspage.CheckOnNonStop();
	}

	
	@Severity(SeverityLevel.CRITICAL)
    @Description("Select 6AM-12PM button from Mumbai")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Click on Mumbai (\\d+)-(\\d+) button$")
	public void click_on_Mumbai_button(int arg1, int arg2) throws Throwable {

		flightspage.Mumbai6_12();
	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Verify flights")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Verify Search Flights$")
	public void verify_Search_Flights() throws Throwable {
		ExpliciteWait(flightspage.verifyFlightSearch);
		boolean flag = flightspage.verifySearchFlightPage();
		Assert.assertTrue(flag);
	}

	@Severity(SeverityLevel.CRITICAL)
    @Description("Click on Price button for lowest price flight")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Click On View Price button$")
	public void click_On_View_Price_button() throws Throwable {
		ExpliciteWait(flightspage.PricesBtn);
		flightspage.ClickOnFlightPrice();
	}

	@Severity(SeverityLevel.CRITICAL)
    @Description("Click on book now button for lowset cost flight")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Click On Book Now button$")
	public void click_On_Book_Now_button() throws Throwable {
		ExpliciteWait(flightspage.bookNowBtn);
		flightspage.BookFlight();
	}

	@Severity(SeverityLevel.CRITICAL)
    @Description("Enter customer deails")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Enter Customer Details$")
	public void enter_Customer_Details() throws Throwable {
		flightspage.CustomerDetails();

	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Verify to fare summery")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@Then("^Verify Fare Summery$")
	public void verify_Fare_Summery() throws Throwable {
		try {
			String value= flightspage.totalAmount.getText();
	    	String Verified_Value = flightspage.reviewAmount.getText();
	    	Assert.assertTrue(value.equalsIgnoreCase(Verified_Value));
			}
			catch(Exception e) {
				
			}
	}
	
	
	@Severity(SeverityLevel.NORMAL)
    @Description("Close the recent browsers")
    @Story("Story Name : Book a lowest cost flight tomorrow from Mumbai to Delhi")
	@And("^Close the book flight Browser$")
	public void close_the_book_flight_Browser() throws Throwable {
		CloseAllBrowser();
	}

}
