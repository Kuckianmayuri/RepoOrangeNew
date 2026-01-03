package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By pimMenu = By.xpath("//span[text()='PIM']");
	By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
	By addBtn = By.xpath("//button[normalize-space()='Add']");

	public void clickPIM() {
		driver.findElement(pimMenu).click();
	}

	public void clickAddEmployeeTab() {
		driver.findElement(addEmployeeTab).click();
	}
	
	public void clickAddEmployeeBtn() {
		driver.findElement(addBtn).click();
	}
	
}
