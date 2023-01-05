package com.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class Baseclass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public Baseclass() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public WebDriver initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
		
		//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		    WebDriverManager.chromedriver().setup();      //Instead of .setup use .create is used to avoid the next line and driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
	//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}


		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));

		tdriver.set(driver);
		return getDriver();
	}
	
	public WebDriver initializationCP() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		

	

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("Baseappurl"));

		tdriver.set(driver);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	@Attachment
	public String appendToResult(String text) {
		return text;
	}

	
	public static void explicitWait(WebDriver driver, int timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public static void explicitWaitAlert(WebDriver driver, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void jsExecutor_ClickElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void selectClassByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectClassByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	

	public static void explicitWait_Clickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void elementClickable(WebElement element) {
		WebElement scanEle = new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
		Actions action = new Actions(driver);
		action.moveToElement(scanEle).click().build().perform();
	}

	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

}
