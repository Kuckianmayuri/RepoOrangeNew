package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
	WebDriver driver;

	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}

	
	By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By saveBtn = By.xpath("//button[@type='submit']");

	public void addEmployee(String fn, String ln) {
		driver.findElement(firstName).sendKeys(fn);
		driver.findElement(lastName).sendKeys(ln);
		driver.findElement(saveBtn).click();

	}
}
