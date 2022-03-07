package com.orangehrm.Testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.dataproviders.CustomDataProvider;
import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.AddEmployee;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;
	
public class AddAndDeleteTest extends BaseClass {

	
	public WebDriver driver;
	
	@BeforeMethod
	public void setupDriver()
	{
		driver=getDriver();
	}
	
	@Test(priority=1,dataProvider="Login", dataProviderClass=CustomDataProvider.class)
	public void Login(String uname, String password) {
		
		LoginPage login= new LoginPage(driver);
		login.loginAsAdmin(uname, password);
		String logintitle= driver.getCurrentUrl();
		Assert.assertEquals(logintitle,"https://opensource-demo.orangehrmlive.com/index.php/dashboard", "URL Pattern did not match");
	}
	
	@Test(priority=2,dataProvider="AddEmp", dataProviderClass=CustomDataProvider.class)
	public void AddEmployee(String fname, String lname, String uname, String pwd, String cmfpwd, String status) throws Exception  {
		AddEmployee addemp=new AddEmployee(driver);
		addemp.addEmployeeDetails(fname, lname, uname, pwd, cmfpwd, status);
		
		EmployeeListPage emplist=new EmployeeListPage(driver);
		emplist.VerifyPersonalDetails();
		
		String actual =emplist.profileNameDetails;
		String expected =addemp.firstname +" "+ addemp.lastname;
		
		Assert.assertEquals(actual, expected,"Profile Name is not matched");
		boolean statusMsg= emplist.isSuccessMsgDisplay();
		Assert.assertTrue(statusMsg);
		
		emplist.searchEmployeelist();
		boolean deleteStatus= emplist.isDeleteMsgDisplayed();
		Assert.assertTrue(deleteStatus);
		
		emplist.logOutFromApplication();
	}
	
}
