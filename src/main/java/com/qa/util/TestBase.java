package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 
 * 
 * This class defines to collect data from properties
 * then Open the Browser, maximize browser, delete all cookies from browser, put url in browser
 * and some common reusable methods
 * 
 * 
 *
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\main\\java\\com\\" + "qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	/*
	 * 
	 * Here to Open Browser Maximize Window Delete All Cookies Implicitewait
	 * Pageload Time Out
	 */
	public static void initialization() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver = new ChromeDriver();
		}

		else if (browsername.equals("FF")) {

			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriver"));
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	/*
	 * 
	 * explicit wait
	 * 
	 */
	public static void ExpliciteWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * 
	 * Click on Webelement
	 * 
	 * 
	 */
	public static void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		;
	}

	/*
	 * 
	 * 
	 * Implicite Wait
	 * 
	 * 
	 */
	public static void Wait() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	/*
	 * 
	 * 
	 * Scroll the Page
	 * 
	 * 
	 * 
	 */
	public static void ScrollPage() throws Exception {

		JavascriptExecutor sc = (JavascriptExecutor) driver;
		sc.executeScript("window.scrollBy(0,2000)", "");
	}

	/*
	 * 
	 * Enter Tab and Click on Enter
	 * 
	 * 
	 */
	public static void Tab() {
		Actions act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.RETURN).build().perform();
	}

	/*
	 * 
	 * Close Current Browser
	 * 
	 */
	public static void CloseBrowser() {
		driver.close();
	}

	/*
	 * 
	 * Quit all Browsers
	 * 
	 * 
	 */
	public static void CloseAllBrowser() {
		driver.quit();
	}

}
