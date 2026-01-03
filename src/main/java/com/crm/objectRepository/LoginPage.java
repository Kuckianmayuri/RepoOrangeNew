package com.crm.objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type ='submit']");

	public void login(String user, String passWd) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(passWd);
		driver.findElement(loginBtn).click();
	}
}
