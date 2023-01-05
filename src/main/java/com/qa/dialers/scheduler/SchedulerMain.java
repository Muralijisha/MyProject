package com.qa.dialers.scheduler;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.qa.allurelistener.TestAllureListener;
import com.qa.baseclass.Baseclass;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class SchedulerMain extends Baseclass {

	@FindBy(xpath = "//a[text()='Scheduler']")
	WebElement scheduler;

	@FindBy(xpath = "//div[@id='scnosession']")
	WebElement noSchedule;

	@FindBy(xpath = "//div[text()=\"Day\"]")
	WebElement day;

	@FindBy(xpath = "//div[contains(@class,\"dhx_scale_holder_now \")]")
	WebElement schedule;

	@FindBy(xpath = "(//select)[2]")
	WebElement fromTime;

	@FindBy(xpath = "(//select)[3]")
	WebElement toTime;

	@FindBy(xpath = "//div[text()='Save']")
	WebElement save;

	@FindBy(xpath = "//a[text()='My Session']")
	WebElement mySession;

	@FindBy(id = "mysession_dialer_mode")
	WebElement dialerMode;

	@FindBy(xpath = "//span[text()='Agent Assisted Dialer']")
	WebElement AAD;

	@FindBy(xpath = "//li[@id='callme']")
	WebElement callMe;

	@FindBy(xpath = "//input[@id='numberToCall']")
	WebElement numberToCall;

	@FindBy(xpath = "//input[@id='coutrycodeprefixed']")
	WebElement checkBox;

	@FindBy(xpath = "//div[contains(text(),'Call Now')]")
	WebElement callNow;

	@FindBy(xpath = "//div[@id='sessionstartbutton']")
	WebElement startSession;

	@FindBy(xpath = "//div[@id='setSessionFromBegin']")
	WebElement fromBeginning;

	@FindBy(xpath = "//div[@id='submit_button']")
	WebElement beginDialing;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement ok;

	@FindBy(xpath = "//input[@id='timeZoneCst']")
	WebElement cst;

	@FindBy(xpath = "//input[@id='timeZoneEst']")
	WebElement est;

	@FindBy(xpath = "//input[@id='timeZoneMst']")
	WebElement mst;

	@FindBy(xpath = "//input[@id='timeZonePst']")
	WebElement pst;

	@FindBy(xpath = "//textarea[@id='dialingInstructions']")
	WebElement dialingInstruction;

	@FindBy(xpath = "//div[@id='hangup']")
	WebElement hangUp;

	@FindBy(xpath = "//select[@id='completed_activity_screencall_disposition']")
	WebElement callResult;

	@FindBy(xpath = "(//span[contains(text(),'Close')])[2]")
	WebElement close;

	@FindBy(xpath = "//div[@id='sessionstartbutton']")
	WebElement resumeDialing;

	@FindBy(xpath = "//div[@id='sccontinuesession']")
	WebElement graceTimePopup;

	@FindBy(xpath = "//span[@id='gracetime']")
	WebElement graceTime;

	@FindBy(xpath = "(//div[text()='Continue'])[1]")
	WebElement continueGraceTime;

	@FindBy(xpath = "//div[@id='scsessioncompletedmsg']")
	WebElement completedGraceTime;

	@FindBy(xpath = "//div[@id='sccheckavail']")
	WebElement checkForAvailability;

	@FindBy(xpath = "//div[@id='scsessioncompletedmsg']")
	WebElement extended30Min;

	@FindBy(xpath = "//div[@id='sccontinue']")
	WebElement continue30MinGrace;

	@FindBy(xpath = "//div[@id='scnosession']//div[@class='btn btn-danger rounded-0 ml-1']")
	WebElement close1;

	@FindBy(xpath="//a[text()='Settings']")
	WebElement settings;

	@FindBy(xpath="//input[@id='open_sf_window']")
	WebElement openCRM;

	@FindBy(xpath="//input[@id='open_linkedin_window']")
	WebElement openLinkedin;

	@FindBy(xpath="//div[@id='topsavebutton']")
	WebElement saveSettings;

	@FindBy(xpath="//button[text()='OK']")
	WebElement saveSettingsOk;


	public SchedulerMain() {
		PageFactory.initElements(driver, this);
	}

	SoftAssert softAssertion = new SoftAssert();

	@Step
	@Story("Scheduler Smoke Test")
	public void schedulerCheck() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Scheduler']")));
		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(3000);

		// to Connect the Phone Bridge
		if (driver.findElements(By.xpath("//div[@class='team']")).size() != 0) {
			action.moveToElement(callMe).click().build().perform();
			numberToCall.clear();
			numberToCall.sendKeys(prop.getProperty("phoneNumber"));
			Thread.sleep(2000);
			if (checkBox.isSelected()) {
				action.moveToElement(callNow).click().build().perform();
			} else {
				action.moveToElement(checkBox).click().build().perform();
				action.moveToElement(callNow).click().build().perform();
			}

		} else {
			action.moveToElement(dialerMode).click().build().perform();
			action.moveToElement(AAD).click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(callMe).click().build().perform();
			numberToCall.clear();
			numberToCall.sendKeys(prop.getProperty("phoneNumber"));
			Thread.sleep(2000);
			if (checkBox.isSelected()) {
				action.moveToElement(callNow).click().build().perform();
			} else {
				action.moveToElement(checkBox).click().build().perform();
				action.moveToElement(callNow).click().build().perform();
			}

		}

		// To check Phone Bridge is connected or not
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statusico-light-go']")));

		// Starting Session
		action.moveToElement(startSession).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(fromBeginning).click().build().perform();
		Thread.sleep(2000);
		if (!est.isSelected()) {
			est.click();
		}
		if (!cst.isSelected()) {
			cst.click();
		}
		if (!mst.isSelected()) {
			mst.click();
		}
		if (!pst.isSelected()) {
			pst.click();
		}
		Thread.sleep(2000);
		dialingInstruction.clear();
		Thread.sleep(2000);
		dialingInstruction.sendKeys("Please Transfer all the answered and IVR calls");
		Thread.sleep(2000);
		action.moveToElement(beginDialing).click().build().perform();
		Thread.sleep(3000);
		try {
			if (driver.findElements(By.xpath("//button[contains(text(),'Ok')]")).size() != 0) {
				ok.click();
			}
			Thread.sleep(4000);

			// There is a stale element which is used twice, so using the try catch to catch
			// the exception
			try {
				ok.click();
			} catch (StaleElementReferenceException e) {
				ok.click();
			}
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		// Validating if we scheduled or not
		try {
			if (noSchedule.isDisplayed()) {
				String noscheduler = noSchedule.getText();

				assertEquals(true, noscheduler.contains("You do not have any scheduled sessions today."));
				//You do not have any scheduled sessions today.

			} 
		}catch(Exception e) {
			Assert.fail("Content of No Schedule is mismached and Failed"); 
		}
		close1.click();
		Thread.sleep(3000);


		Thread.sleep(3000);

		// Schedule for the current time
		action.moveToElement(scheduler).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(day).click().build().perform();
		Thread.sleep(3000);
		action.doubleClick(schedule).perform();

		// Getting Schedule From Time and To Time
		LocalDateTime now = LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		if (minute < 30) {
			String fromtime = "0" + hour + ":00 AM";
			String totime = "0" + hour + ":30 AM";
			System.out.println(fromtime);
			System.out.println(totime);

			WebElement dropdown = fromTime;
			dropdown.click();
			Select drop = new Select(dropdown);
			drop.selectByVisibleText(fromtime);
			Thread.sleep(2000);

			WebElement dropdown1 = toTime;
			dropdown1.click();
			Select drop1 = new Select(dropdown1);
			drop1.selectByVisibleText(totime);
			Thread.sleep(2000);
			action.moveToElement(save).click().build().perform();
			Thread.sleep(3000);

		} else {
			String fromtime = "0" + hour + ":30 AM";
			String totime = "0" + (hour + 1) + ":00 AM";
			System.out.println(fromtime);
			System.out.println(totime);

			WebElement dropdown = fromTime;
			dropdown.click();
			Select drop = new Select(dropdown);
			drop.selectByVisibleText(fromtime);

			Thread.sleep(2000);

			WebElement dropdown1 = toTime;
			dropdown1.click();
			Select drop1 = new Select(dropdown1);
			drop1.selectByVisibleText(totime);
			Thread.sleep(2000);
			action.moveToElement(save).click().build().perform();
			Thread.sleep(3000);

		}

		//		String fromtime = prop.getProperty("from");
		//		String totime = prop.getProperty("to");

		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(3000);
		settings.click();
		Thread.sleep(2000);
		if(openCRM.isSelected()) {
			openCRM.click();
		}else {
			Thread.sleep(1000);
		}
		if(openLinkedin.isSelected()) {
			openLinkedin.click();
		}else {
			Thread.sleep(1000);
		}
		action.moveToElement(saveSettings).click().build().perform();
		Thread.sleep(2000);
		action.moveToElement(saveSettingsOk).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(mySession).click().build().perform();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statusico-light-go']")));
		action.moveToElement(startSession).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(fromBeginning).click().build().perform();
		Thread.sleep(2000);
		if (!est.isSelected()) {
			est.click();
		}
		if (!cst.isSelected()) {
			cst.click();
		}
		if (!mst.isSelected()) {
			mst.click();
		}
		if (!pst.isSelected()) {
			pst.click();
		}
		Thread.sleep(2000);
		dialingInstruction.clear();
		Thread.sleep(2000);
		dialingInstruction.sendKeys("Please Transfer all the answered and IVR calls");
		Thread.sleep(2000);
		action.moveToElement(beginDialing).click().build().perform();
		Thread.sleep(3000);
		try {
			if (driver.findElements(By.xpath("//button[contains(text(),'Ok')]")).size() != 0) {
				ok.click();
			}
			Thread.sleep(5000);

			// There is a stale element which is used twice, so using the try catch to catch
			// the exception
			try {
				ok.click();
			} catch (StaleElementReferenceException e) {
				ok.click();
			}
		} catch (Exception e) {
		}
		Thread.sleep(3000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialerwindow")));
		Thread.sleep(2000);
		action.moveToElement(hangUp).click().build().perform();
		Thread.sleep(2000);
		Select drop2 = new Select(callResult);
		drop2.selectByVisibleText("Meeting Scheduled");
		Thread.sleep(5000);
		int minutenow = now.getMinute();
		if (minutenow < 30) {
			int waitTime = 30 - minutenow;
			int timeToSleep = waitTime * 60;
			Thread.sleep(timeToSleep * 1000);
		} else {
			int waitTime = 60 - minutenow;
			int timeToSleep = waitTime * 60;
			Thread.sleep(timeToSleep * 1000);
		}
		
		

		action.moveToElement(close).click().build().perform();
		Thread.sleep(5000);
		action.moveToElement(resumeDialing).click().build().perform();
		Thread.sleep(10000);

		// To check Grace period
		graceTimePopup.isDisplayed();
		String grace = graceTime.getText();
		try {
		Assert.assertEquals(grace, "5");
		}
		catch(Exception e) {
			Assert.fail("Grace Time count mismached");
		}
		action.moveToElement(continueGraceTime).click().build().perform();
		Thread.sleep(2000);
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialerwindow")));
		action.moveToElement(hangUp).click().build().perform();
		Thread.sleep(2000);
		Select drop3 = new Select(callResult);
		drop3.selectByVisibleText("Meeting Scheduled");
		Thread.sleep(300000);
		action.moveToElement(close).click().build().perform();
		Thread.sleep(5000);
		action.moveToElement(resumeDialing).click().build().perform();
		Thread.sleep(5000);

		// Extending Grace time to 30 min
		completedGraceTime.isDisplayed();
		String grace1 = completedGraceTime.getText();
		Assert.assertTrue(grace1.contains("Your session has gone past the scheduled time."));
		Thread.sleep(3000);
		action.moveToElement(checkForAvailability).click().build().perform();
		Thread.sleep(3000);
		String extend = extended30Min.getText();

		// check session is extended or not
		Assert.assertTrue(extend.contains("Your schedule is extended for"));
		Thread.sleep(3000);
		action.moveToElement(continue30MinGrace).click().build().perform();
		Thread.sleep(3000);
		System.out.println("Continue clicked");
		Thread.sleep(5000);

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialerwindow")));
		action.moveToElement(hangUp).click().build().perform();
		Thread.sleep(2000);
		Select drop4 = new Select(callResult);
		drop4.selectByVisibleText("Meeting Scheduled");
		Thread.sleep(2000);
		action.moveToElement(close).click().build().perform();
		Thread.sleep(5000);

		softAssertion.assertAll();

	}
}