package com.qa.dialers.testfiles;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.allurelistener.TestAllureListener;
import com.qa.baseclass.Baseclass;
import com.qa.dialers.dialermode.DialerModeMain;
import com.qa.dialers.dialermode.ListUpload;
import com.qa.dialers.loginpage.Loginpage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ TestAllureListener.class })
public class DialerModeTest extends Baseclass {
	Loginpage loginpage;
	DialerModeMain main;
	ListUpload upload;

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("url"));
		main = new DialerModeMain();
		upload = new ListUpload();

	}

	@Test(priority = 1)
	@Description("DL-41 - Check switching between Flow Dialer & Agent Assisted Dialer & AI Flow Dialer & AI Parallel Dialer")
	@Story("DL-41 - Check switching all the 4 Dialer mode")
	@Severity(SeverityLevel.CRITICAL)
	public void SwitchingDialerMode() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		main.switchingDialerMode();

	}

	@Test(priority = 2)
	@Description("DL-43 - Check # of Records in the List and Check # of Records Unchecked")
	@Story("DL-43 - Verify the current list statistics")
	@Severity(SeverityLevel.MINOR)
	public void CurrentListStatistics() throws InterruptedException {
		Thread.sleep(5000);
	//	upload.Listupload();
		main.statistics();
	}

	@Test(priority = 3)
	@Description("DL-44 - Auto Open CRM Enabled or not and validating the Report Name(s)")
	@Story("DL-44 - Verify the settings summary that is matched with the original settings that is done")
	@Severity(SeverityLevel.NORMAL)
	public void settingssummary() throws InterruptedException {
		upload.Listupload();
		main.settingsSummary();
	}

	
	@Test(priority = 4)
	@Description("DL-45 - Delete Existing Lists in My Session and Cancel button in Delete Existing List is working or not")
	@Story("DL-45 - Verify the Delete Existing Records works")
	@Severity(SeverityLevel.MINOR)
	public void DeleteExistingLists() throws InterruptedException, AWTException {
		main.deleteExistingLists();
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
