package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.genericUtility.WebDriverUtility;

public class LoginPage {
	WebDriver driver;
	WebDriverUtility wUtil = new WebDriverUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type ='submit']");

	public void login(String user, String passWd) {
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(passWd);
		driver.findElement(loginBtn).click();
	}
}
