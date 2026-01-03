package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
	By addBtn = By.xpath("//button[normalize-space()='Add']");

	private By pimMenu = By.xpath("//span[text()='PIM']");
	private By profileIcon = By.xpath("//p[@class='oxd-userdropdown-name']");
	private By logoutLink = By.xpath("//a[text()='Logout']");

	public void clickPIM() {
		driver.findElement(pimMenu).click();
	}

	public void clickAddEmployeeTab() {
		driver.findElement(addEmployeeTab).click();
	}

	public void clickAddEmployeeBtn() {
		driver.findElement(addBtn).click();
	}

	public void logout() {
		driver.findElement(profileIcon).click();
		driver.findElement(logoutLink).click();
	}

}
