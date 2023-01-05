package com.qa.dialers.dialermode;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.baseclass.Baseclass;

public class ListUpload extends Baseclass {

	@FindBy(xpath = "(//a[contains(text(),'My Lists')])[1]")
	WebElement myLists;

	@FindBy(xpath = "//button[text()='Add Lists']")
	WebElement addLists;

	@FindBy(xpath = "//a[text()='Add from CSV']")
	WebElement addFromCsv;

	@FindBy(xpath = "//button[contains(text(),'Add Lists')]")
	WebElement addlists;

	@FindBy(xpath = "//a[contains(text(),'Add from CSV')]")
	WebElement addfromcsv;

	@FindBy(id = "uploader")
	WebElement fileUpload;

	@FindBy(id = "uploadnextbtn_0")
	WebElement next;

	@FindBy(id = "calleridmode")
	WebElement callerId;

	@FindBy(id = "timezonecst")
	WebElement cst;

	@FindBy(id = "timezoneest")
	WebElement est;

	@FindBy(id = "timezonemst")
	WebElement mst;

	@FindBy(id = "timezonepst")
	WebElement pst;

	@FindBy(id = "country_code_prefixed")
	WebElement international;

	@FindBy(id = "uploadnextbtn_1")
	WebElement next1;

	@FindBy(id = "uploadnextbtn_2")
	WebElement next2;

	@FindBy(id = "uploadnextbtn_3")
	WebElement next3;

	@FindBy(xpath = "//div[contains(@id,'uploadclose_btn')]")
	WebElement close;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement Ok;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OK;

	@FindBy(id = "listnamesearch")
	WebElement search;

	@FindBy(id = "searchlistbtn")
	WebElement searchBtn;

	@FindBy(id = "beginDialingSessionButton")
	WebElement beginDialing;

	@FindBy(id = "btnContinueToSession")
	WebElement continue1;

	@FindBy(xpath = "(//td[contains(@class,'my-list-checkbox')]//input)[1]")
	WebElement list;
	
	@FindBy(xpath = "(//button[text()='close'])[2]")
	WebElement alert;
	
	@FindBy(xpath = "//a[text()='Parking Lot']")
	WebElement parkingLot;

	@FindBy(xpath = "//a[text()='Administration']")
	WebElement administration;

	@FindBy(xpath = "//input[@id='select_all_parking_lot_records']")
	WebElement selectAll;

	@FindBy(xpath = "//div[@onclick='deleteSelectedParkingLotRecords()']")
	WebElement deleteRecords;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement oK;
	
	@FindBy(xpath = "//img[@id='checkall']")
	WebElement checkAll;

	@FindBy(xpath = "//div[@id='checkAllDiv']")
	WebElement checkAllYes;
	
	@FindBy(xpath = "//div[@id='no_parking_lot_records_list']")
	WebElement noRecords;
	
	@FindBy(xpath = "//a[text()='My Session']")
	WebElement mySession;

	public ListUpload() {
		PageFactory.initElements(driver, this);
	}

	public void Listupload() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'My Lists')])[1]")));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(myLists).click().build().perform();
		Thread.sleep(5000);
		action.moveToElement(addlists).click().build().perform();
		Thread.sleep(2000);
		action.moveToElement(addfromcsv).click().build().perform();
		Thread.sleep(2000);
		fileUpload.sendKeys(System.getProperty("user.dir") + "\\Dialers List.csv");
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() != 0) {
			OK.click();
		} 
		Thread.sleep(3000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, 250)");
		action.moveToElement(next).click().build().perform();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//span[text()='Alert']")).size() != 0) {
			alert.click();
		}
		Thread.sleep(3000);
		WebElement dropdown = callerId;
		dropdown.click();
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Random");
		Thread.sleep(2000);
		est.click();
		cst.click();
		mst.click();
		pst.click();

		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("scroll(0, 250)");
		action.moveToElement(next1).click().build().perform();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Ok')]")).size() != 0) {
			Ok.click();
			JavascriptExecutor jse8 = (JavascriptExecutor) driver;
			jse8.executeScript("scroll(0, 250)");
			action.moveToElement(next1).click().build().perform();
		} 

		Thread.sleep(2000);
		JavascriptExecutor jse9 = (JavascriptExecutor) driver;
		jse9.executeScript("scroll(0, 250)");
		boolean t = driver.findElement(By.id("uploadnextbtn_2")).isDisplayed();
		if (t) {
		JavascriptExecutor jse10 = (JavascriptExecutor) driver;
		jse10.executeScript("scroll(0, 250)");
		action.moveToElement(next2).click().build().perform();
		Thread.sleep(6000);
		}
		Thread.sleep(2000);
		Thread.sleep(2000);
		action.moveToElement(next3).click().build().perform();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Ok')]")).size() != 0) {
			Ok.click();
		}

		Thread.sleep(3000);
		action.moveToElement(close).click().build().perform();
		Thread.sleep(5000);

		// List Uploading to My Session
		search.sendKeys(prop.getProperty("listname"));
		action.moveToElement(searchBtn).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(list).click().build().perform();
		action.moveToElement(beginDialing).click().build().perform();
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//b)[last()]")));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnContinueToSession")));
		action.moveToElement(continue1).click().build().perform();
		Thread.sleep(10000);
		
		//Deleting Parking Lot records in Administration
		action.moveToElement(administration).click().build().perform();
		Thread.sleep(5000);
		action.moveToElement(parkingLot).click().build().perform();
		Thread.sleep(3000);

		if (noRecords.isDisplayed()) {
			Thread.sleep(2000);

		} else {
			action.moveToElement(selectAll).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(deleteRecords).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(3000);
		}
		
		if (noRecords.isDisplayed()) {
			Thread.sleep(2000);

		} else {
			action.moveToElement(selectAll).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(deleteRecords).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(3000);
		}
		
		if (noRecords.isDisplayed()) {
			Thread.sleep(2000);

		} else {
			action.moveToElement(selectAll).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(deleteRecords).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(2000);
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(3000);
		}
		
		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(5000);
		
		// Removing all the Do Not Call prospects from the Do Not Call
				checkAll.click();
				Thread.sleep(3000);
				action.moveToElement(checkAllYes).click().build().perform();
				Thread.sleep(5000);
	}

}
