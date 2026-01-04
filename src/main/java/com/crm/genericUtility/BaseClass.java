package com.crm.genericUtility;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

public class BaseClass {
	public static ThreadLocal<String> browserName = new ThreadLocal<>();
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility futil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(String browser) throws Exception {
		browserName.set(browser);
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashedMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		driver.get(futil.readDataFromProperty("url"));
		wUtil.waitForPageLoad(driver);

	}

	@BeforeMethod(alwaysRun = true)
	public void login() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(futil.readDataFromProperty("username"), futil.readDataFromProperty("password"));
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
