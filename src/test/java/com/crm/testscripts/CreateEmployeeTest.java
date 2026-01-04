package com.crm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.objectRepository.AddEmployeePage;
import com.crm.objectRepository.EmployeeListPage;
import com.crm.objectRepository.HomePage;

@Listeners(listeners.Listener.class)
public class CreateEmployeeTest extends BaseClass {

	@Test(priority = 1, groups = {"smoke"}, invocationCount = 2)
	public void addEmployeeUsingAddButton() throws Exception {
		ExcelUtility eUtil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();

		String fn = eUtil.readDataFromExcel("Employee", 1, 0) + jUtil.getRandomNumber();
		String ln = eUtil.readDataFromExcel("Employee", 1, 1);

		// Navigate to PIM → Employee List
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		hp.clickAddEmployeeBtn();

		// Add employee using Add button
		AddEmployeePage add = new AddEmployeePage(driver);
		add.addEmployee(fn, ln);

		// Verify employee added
		hp.clickPIM();
		EmployeeListPage list = new EmployeeListPage(driver);
		Assert.assertTrue(list.searchEmployee(fn));
	}

	@Test(groups = "regression", dependsOnMethods = "addEmployeeUsingAddButton")
	public void addEmployeeFromEmployeeTab() throws Exception {
		ExcelUtility eUtil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();

		String fn = eUtil.readDataFromExcel("Employee", 1, 0) + jUtil.getRandomNumber();
		String ln = eUtil.readDataFromExcel("Employee", 1, 1);

		// Navigate to PIM → Employee List
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		hp.clickAddEmployeeTab();

		// Add employee from Add Employee tab
		AddEmployeePage add = new AddEmployeePage(driver);
		add.addEmployee(fn, ln);

		// Verify employee added
		hp.clickPIM();
		EmployeeListPage list = new EmployeeListPage(driver);
		Assert.assertTrue(list.searchEmployee(fn));
	}
}
