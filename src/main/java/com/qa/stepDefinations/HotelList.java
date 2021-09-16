package com.qa.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import com.qa.pages.FlightsPage;
import com.qa.pages.HomePage;
import com.qa.pages.HotelsPage;
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
 * 
 * This class defines to Select From Mumbai as Location
 * Then Use Click on Search button
 * Verify the Hotels in Mumbai Location 
 * 
 * 
 *
 */
public class HotelList extends TestBase {

	HomePage homepage;
	FlightsPage flightspage;
	HotelsPage hotelspage;

	@Severity(SeverityLevel.NORMAL)
    @Description("Open Browser")
    @Story("Story Name : Verify Hotels in Mumbai")
	@Given("^User Open Browser$")
	public void user_Open_Browser() throws Throwable {
		TestBase.initialization();
		homepage = new HomePage(driver);
		flightspage = new FlightsPage(driver);
		hotelspage = new HotelsPage();
	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Clicking on Modal to do other action")
    @Story("Story Name : Verify Hotels in Mumbai")
	@When("^Click on Randoms place$")
	public void click_on_Randoms_place() throws Throwable {
		homepage.LoginPopUp();
	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Clicking on Hotels tab to see Hotels Page")
    @Story("Story Name : Verify Hotels in Mumbai")
	@And("^Click on Hotels Tab$")
	public void click_on_Hotels_Tab() throws Throwable {

		ExpliciteWait(hotelspage.hotelsLink);
		hotelspage.ClickOnHotelsPage();

	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Select location as Mumbai")
    @Story("Story Name : Verify Hotels in Mumbai")
	@And("^Select Mumbai from drop down$")
	public void select_Mumbai_from_drop_down() throws Throwable {

		ExpliciteWait(hotelspage.selectLocations);
		hotelspage.SelectLoc();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		hotelspage.SelectLocAsMumbai();

	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Verify the Mumbai Hotels")
    @Story("Story Name : Verify Hotels in Mumbai")
	@Then("^Verify the Hotels Page$")
	public void verify_the_Hotels_Page() throws Throwable {
		try {
			String atctualtxt = hotelspage.verifyhotels.getText();
			ExpliciteWait(hotelspage.verifyhotels);
			Assert.assertTrue(prop.getProperty("mumbaihotellist").equalsIgnoreCase(atctualtxt));
			}
			catch(Exception e) {
				
			}
		
	}

	@Severity(SeverityLevel.NORMAL)
    @Description("Close Browser")
    @Story("Story Name : Verify Hotels in Mumbai")
	@And("^Close the search hotels Browser$")
	public void close_the_search_hotels_Browser() throws Throwable {
		CloseBrowser();
	}

}
