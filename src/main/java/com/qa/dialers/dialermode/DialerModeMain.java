package com.qa.dialers.dialermode;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.baseclass.Baseclass;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class DialerModeMain extends Baseclass {

	@FindBy(xpath = "//a[text()='My Session']")
	WebElement mySession;

	@FindBy(xpath = "//div[@id='currentdialingmode']")
	WebElement currentDialingMode;

	@FindBy(xpath = "//span[text()='Flow Dialer']")
	WebElement FD;

	@FindBy(xpath = "//span[text()='Agent Assisted Dialer']")
	WebElement AAD;

	@FindBy(xpath = "//span[contains(text(),'AI Flow Dialer')]")
	WebElement AIDSL;

	@FindBy(xpath = "//span[contains(text(),'AI Parallel Dialer')]")
	WebElement AIDML;

	@FindBy(id = "mysession_dialer_mode")
	WebElement dialerMode;

	@FindBy(xpath = "//div[@class='personal']")
	WebElement flow;

	@FindBy(xpath = "//div[@class='team']")
	WebElement agent;

	@FindBy(xpath = "//div[@class='aisl']")
	WebElement singleLine;

	@FindBy(xpath = "//div[@class='aiml']")
	WebElement multiLine;

	@FindBy(xpath = "(//a[contains(text(),'My Lists')])[1]")
	WebElement myLists;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement ok;

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

	@FindBy(id = "show_currentList_statistics")
	WebElement currentList;

	@FindBy(id = "CT_Totalrecords")
	WebElement totalProspects1;

	@FindBy(xpath = "(//b)[last()]")
	WebElement prospects;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement oK;

	@FindBy(xpath = "//img[@id='checkall']")
	WebElement checkAll;

	@FindBy(xpath = "//div[@id='checkAllDiv']")
	WebElement checkAllYes;

	@FindBy(xpath = "//img[@id='uncheckBoxId1']")
	WebElement checkBox1;

	@FindBy(xpath = "//img[@id='uncheckBoxId2']")
	WebElement checkBox2;

	@FindBy(xpath = "//img[@id='uncheckBoxId3']")
	WebElement checkBox3;

	@FindBy(xpath = "//img[@id='uncheckBoxId4']")
	WebElement checkBox4;

	@FindBy(xpath = "//button[@id='doNotCallForeverBtn']")
	WebElement doNotCallForever;

	@FindBy(xpath = "(//button[contains(text(),'OK')])[3]")
	WebElement doNotOk;

	@FindBy(id = "CT_Totalrecordsunchecked")
	WebElement unCheckCount;

	@FindBy(xpath = "//a[text()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//input[@id='open_sf_window']")
	WebElement autoOpen;

	@FindBy(xpath = "//div[@id='topsavebutton']")
	WebElement saveSettings;

	@FindBy(xpath = "//span[@id='settings_summary']")
	WebElement settingsSummary;

	@FindBy(xpath = "//li[contains(text(),'Enabled')]")
	WebElement enabled;

	@FindBy(xpath = "(//td[@class='my-list-listname'])[1]")
	WebElement listName;

	@FindBy(xpath = "(//li)[76]")
	WebElement listName1;

	@FindBy(xpath = "//a[contains(text(),' Delete Existing Records')]")
	WebElement deleteList;

	@FindBy(xpath = "//p[contains(text(),'No data available for dialing. Please upload.')]")
	WebElement noData;

	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[3]")
	WebElement Cancel;

	@FindBy(xpath = "//a[text()='Parking Lot']")
	WebElement parkingLot;

	@FindBy(xpath = "//a[text()='Administration']")
	WebElement administration;

	@FindBy(xpath = "//input[@id='select_all_parking_lot_records']")
	WebElement selectAll;

	@FindBy(xpath = "//div[@onclick='deleteSelectedParkingLotRecords()']")
	WebElement deleteRecords;

	@FindBy(xpath = "//div[@id='no_parking_lot_records_list']")
	WebElement noRecords;

//	@FindBys({ @FindBy(xpath = "(//tr[contains(@class,'whiterow')])[1]"), @FindBy(xpath = "(//td[@class='la'])[1]") })
	@FindBy(xpath = "//div[@id='phone1']")
	WebElement firstRow;

	@FindBy(xpath = "//tr[@id='drdt1_sf_report_name']//td[@class='value']")
	WebElement reportName;

	@FindBy(xpath = "//div[@id='customerdetails_window_save']")
	WebElement save;

	@FindBy(xpath = "//div[@class='control-sections settings-summary']//li[7]")
	WebElement dialerModeListnames;

	@FindBy(xpath = "(//button[contains(text(),'OK')])[3]")
	WebElement saveOK;

	@FindBy(xpath = "//p[contains(text(),'All contacts who are unchecked')]")
	WebElement warning;

	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to delete all records?')]")
	WebElement cancel;

	public DialerModeMain() {
		PageFactory.initElements(driver, this);
	}

	@Step("DL-40 - Check switching between Flow Dialer & Agent Assisted Dialer & AI Flow Dialer & AI Parallel Dialer")
	public void switchingDialerMode() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='My Session']")));

		Actions action = new Actions(driver);
		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(3000);

		/*
		 * List<WebElement> NewEvent =
		 * driver.findElements(By.xpath("//img[@title='Call / Do Not Call']"));
		 * System.out.println(NewEvent.size()); for (int i = 0; i < NewEvent.size()-
		 * NewEvent.size()/2;i++) { boolean displayed = NewEvent.get(i).isDisplayed();
		 * System.out.println(displayed); action.moveToElement(driver.findElement(By.
		 * xpath("//img[@title='Call / Do Not Call']"))).click().build() .perform(); }
		 */

		SoftAssert softAssertion = new SoftAssert();
		if (driver.findElements(By.xpath("//div[@class='personal']")).size() != 0) {
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AAD).click().build().perform();
			Thread.sleep(3000);
			String agent = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(agent, "team");
			String AAD = "Agent Assisted Dialer";
			Allure.addAttachment(AAD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Thread.sleep(3000);
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(FD).click().build().perform();
			Thread.sleep(3000);
			String flow = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(flow, "personal");
			String FD = "Flow Dialer";
			Allure.addAttachment(FD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Thread.sleep(3000);
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AIDSL).click().build().perform();
			Thread.sleep(3000);
			String singleLine = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(singleLine, "aisl");
			String AIFD = "AI Flow Dialer";
			Allure.addAttachment(AIFD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Thread.sleep(3000);
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AIDML).click().build().perform();
			Thread.sleep(3000);
			String multiLine = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(multiLine, "aiml");
			String AIPD = "AI Parallel Dialer";
			Allure.addAttachment(AIPD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			softAssertion.assertAll();
		} else {
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(FD).click().build().perform();
			Thread.sleep(3000);
			String flow = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(flow, "personal");

			String FD = "Flow Dialer";
			Allure.addAttachment(FD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Thread.sleep(3000);
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AAD).click().build().perform();
			Thread.sleep(3000);
			String agent = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(agent, "team");

			String AAD = "Agent Assisted Dialer";
			Allure.addAttachment(AAD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Thread.sleep(3000);
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AIDSL).click().build().perform();
			Thread.sleep(3000);
			String singleLine = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(singleLine, "aisl");

			String AIFD = "AI Flow Dialer";
			Allure.addAttachment(AIFD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Thread.sleep(3000);
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AIDML).click().build().perform();
			Thread.sleep(3000);
			String multiLine = currentDialingMode.getAttribute("class");
			softAssertion.assertEquals(multiLine, "aiml");

			String AIPD = "AI Parallel Dialer";
			Allure.addAttachment(AIPD,
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			softAssertion.assertAll();
		}

	}

	@Step("DL-43 - Check # of Records in the List and Check # of Records Unchecked")
	public void statistics() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='My Session']")));
		Actions action = new Actions(driver);
		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(5000);

		// Deleting all the Parking Lot prospects
		action.moveToElement(administration).click().build().perform();
		Thread.sleep(5000);
		action.moveToElement(parkingLot).click().build().perform();
		Thread.sleep(3000);

		if (driver.findElements(By.xpath("//div[@id='no_parking_lot_records_list']")).size() != 0) {
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

		// Importing List to My Session
		action.moveToElement(myLists).click().build().perform();
		Thread.sleep(3000);

		search.sendKeys(prop.getProperty("listname"));
		action.moveToElement(searchBtn).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(list).click().build().perform();
		action.moveToElement(beginDialing).click().build().perform();
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//b)[last()]")));
		String Prospectscount = prospects.getText();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnContinueToSession")));
		action.moveToElement(continue1).click().build().perform();
		Thread.sleep(5000);

		// Removing all the Do Not Call prospects from the Do Not Call
		checkAll.click();
		Thread.sleep(3000);
		action.moveToElement(checkAllYes).click().build().perform();
		Thread.sleep(5000);
		Thread.sleep(3000);

		// Moving half the list to parking Lot //img[@title='Call / Do Not Call']
		List<WebElement> NewEvent = driver.findElements(By.xpath("//img[@title='Call / Do Not Call']"));
		System.out.println(NewEvent.size());
		String beforePath = "(//img[@title='Call / Do Not Call'])[";
		String afterPath = "]";
		int doNotCallProspects = NewEvent.size() - NewEvent.size() / 2;
		for (int i = 1; i <= NewEvent.size() - NewEvent.size() / 2; i++) {
			// boolean displayed = NewEvent.get(i).isDisplayed();
			// System.out.println(displayed);
		//	NewEvent.get(i).click();
			action.moveToElement(driver.findElement(By.xpath(beforePath + i + afterPath))).click().build().perform();
		}
		System.out.println(doNotCallProspects);

		// Moving first 4 prospects to Do Not Call
		/*
		 * action.moveToElement(checkBox1).click().build().perform();
		 * action.moveToElement(checkBox2).click().build().perform();
		 * action.moveToElement(checkBox3).click().build().perform();
		 * action.moveToElement(checkBox4).click().build().perform();
		 */
		Thread.sleep(3000);
		action.moveToElement(doNotCallForever).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(doNotOk).click().build().perform();
		Thread.sleep(3000);
		mySession.click();
		Thread.sleep(3000);
		action.moveToElement(dialerMode).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(currentList).click().build().perform();
		Thread.sleep(5000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("scroll(0, 250)");
		Thread.sleep(2000);
		String text = totalProspects1.getText();

		Assert.assertTrue(Prospectscount.contains(text));
		// String uncheck = "4";
		Thread.sleep(2000);
		String count = unCheckCount.getText();
		Assert.assertEquals(count, 40);
		System.out.println("\n" + "Current List Statistics working perfectly" + "\n");

	}

	@Step("DL-44 - Verify the settings summary that is matched with the original settings that is done")
	public void settingsSummary() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='My Session']")));
		mySession.click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);

		// Enabling the Auto open CRM in settings
		action.moveToElement(settings).click().build().perform();
		Thread.sleep(5000);
		if (autoOpen.isSelected()) {
			action.moveToElement(saveSettings).click().build().perform();
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(5000);

		} else {
			action.moveToElement(autoOpen).click().build().perform();
			action.moveToElement(saveSettings).click().build().perform();
			action.moveToElement(oK).click().build().perform();
			Thread.sleep(5000);

		}

		// Validating the Report Name
		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(10000);
		action.moveToElement(firstRow).click().build().perform();
		Thread.sleep(3000);
		String Name = reportName.getText();
		Thread.sleep(3000);
		action.moveToElement(save).click().build().perform();
		Thread.sleep(2000);
		action.moveToElement(saveOK).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(dialerMode).click().build().perform();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)");
		action.moveToElement(settingsSummary).click().build().perform();
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, 250)");
		Thread.sleep(2000);

		String Listnames = dialerModeListnames.getText();
		System.out.println(Listnames);
		Assert.assertTrue(Listnames.contains(Name));
		Thread.sleep(3000);
		Assert.assertTrue(enabled.isDisplayed());
		System.out.println("\n" + "Settings Summary working properly");
		System.out.println("\n" + "List Names and Auto Open CRM Settings are updating Properly in Settings Summary");
		driver.navigate().refresh();
		action.moveToElement(settings).click().build().perform();
		Thread.sleep(5000);
		autoOpen.click();
		Thread.sleep(2000);
		action.moveToElement(saveSettings).click().build().perform();
		action.moveToElement(oK).click().build().perform();
		Thread.sleep(5000);

	}

	@Step("DL-45 - Delete Existing Lists in My Session and Cancel button in Delete Existing List is working or not")
	public void deleteExistingLists() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='My Session']")));
		Actions action = new Actions(driver);
		mySession.click();
		Thread.sleep(4000);
		action.moveToElement(dialerMode).click().build().perform();
		Thread.sleep(3000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, 250)");
		action.moveToElement(deleteList).click().build().perform();
		Thread.sleep(3000);

		// Checking Cancel button is working or not

		try {
			action.moveToElement(Cancel).click().build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.assertFalse(cancel.isDisplayed());
			System.out.println("Cancel Button is not working in Delete Existing Lists");
			Thread.sleep(2000);
		}
		driver.navigate().refresh();
		Thread.sleep(4000);
		mySession.click();
		action.moveToElement(dialerMode).click().build().perform();
		Thread.sleep(3000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("scroll(0, 250)");

		// Deleting the lists in My Session
		action.moveToElement(deleteList).click().build().perform();
		Thread.sleep(2000);
		action.moveToElement(doNotOk).click().build().perform();
		Thread.sleep(5000);
		Assert.assertTrue(noData.isDisplayed());
		String Delete = " - To Confirm List Deleted or Not";
		Allure.addAttachment(Delete,
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		System.out.println();
		System.out.println("Records Deleted Successfully" + "\n");

	}
}
