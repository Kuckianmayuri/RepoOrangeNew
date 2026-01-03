package com.crm.genericUtility;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility futil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	@BeforeClass
	public void launchBrowser() throws Exception {
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashedMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);

		driver.get(futil.readDataFromProperty("url"));
		wUtil.waitForPageLoad(driver);
	}

	@BeforeMethod
	public void login() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(futil.readDataFromProperty("username"), futil.readDataFromProperty("password"));
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
