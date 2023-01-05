package com.qa.dialers.loginpage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.Baseclass;

import io.qameta.allure.Step;

public class Loginpage extends Baseclass {


	@FindBy(id = "btn_salesforce")
	WebElement signInWithSalesforce;

	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "btn_login")
	WebElement loginBtn;

	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	WebElement settingsTab;

	@FindBy(id = "remember_close")
	WebElement Closepopup;

	@FindBy(id = "remember_choice_form")
	WebElement Closepopuppage;

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Logged in with USERNAME: {0}, PASSWORD: {1}, URL: {2}")
	public void login(String UNAME, String PWD, String URL) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		username.sendKeys(UNAME);
		password.sendKeys(PWD);

		jsExecutor_ClickElement(loginBtn);
		Thread.sleep(5000);
	}

}
