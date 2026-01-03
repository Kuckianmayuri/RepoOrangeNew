package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

	WebDriver driver;

	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
	}

	By empName = By.xpath("//input[@placeholder='Type for hints...']");
	By searchBtn = By.xpath("//button[@type='submit']");
	By record = By.xpath("//div[@class='oxd-table-body']");

	public boolean searchEmployee(String name) {
		driver.findElement(empName).sendKeys(name);
		driver.findElement(searchBtn).click();
		return driver.findElement(record).isDisplayed();
	}

}
