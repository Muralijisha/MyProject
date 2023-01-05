package com.qa.dialers.testfiles;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.allurelistener.TestAllureListener;
import com.qa.baseclass.Baseclass;
import com.qa.dialers.scheduler.ListUpload;
import com.qa.dialers.loginpage.Loginpage;
import com.qa.dialers.scheduler.SchedulerMain;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ TestAllureListener.class })
public class SchedulerTest extends Baseclass {
	Loginpage loginpage;
	SchedulerMain main1;
	ListUpload upload;

	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("url"));
		main1 = new SchedulerMain();
		upload = new ListUpload();
	}

	@Test
	@Step("Note: 1. Before Run this Test please check Scheduler is enabled in your Login"
			+ "2. Please Run this Test 5 min before the Schedule End Time")
	@Description("Check Scheduler is working or not")
	@Story("Scheduler check")
	@Severity(SeverityLevel.CRITICAL)
	public void SchedulerCheck() throws InterruptedException, AWTException {
		upload.Listupload();
		main1.schedulerCheck();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Allure.addAttachment(result.getName(),
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}
		driver.quit();
	}
}
