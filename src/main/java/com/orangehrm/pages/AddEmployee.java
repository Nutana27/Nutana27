package com.orangehrm.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.orangehrm.utility.Helper;

public class AddEmployee {

	WebDriver driver;
	public String firstname, lastname;
	
	
	public AddEmployee(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By hoverPimMenu= By.id("menu_pim_viewPimModule");
	
	By linkAddEmp= By.id("menu_pim_addEmployee");
	
	By txtAddEmpFirstname= By.id("firstName");
	
	By txtAddEmpLastname=By.id("lastName");
	
	By profilePicAddEmp=By.id("photofile");
	
	By chkAddEmp =By.id("chkLogin");
	
	By txtAddEmpUsername=By.id("user_name");
	
	By txtAddEmpPwd=By.id("user_password");
	
	By txtAddEmpcmfPwd=By.id("re_password");
	
	By btnAddEmpSave=By.id("btnSave");
	
	By drpDownAddEmp=By.id("status");
	

	public void addEmployeeDetails(String fname, String lname, String uname, String pwd, String cmfpwd, String status) {
		
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(hoverPimMenu)).build().perform();
		
		driver.findElement(linkAddEmp).click();
		
		
		 firstname=fname + new Faker().number().randomDigit();
		 
		 driver.findElement(txtAddEmpFirstname).sendKeys(firstname);
		
		lastname=lname;
				driver.findElement(txtAddEmpLastname).sendKeys(lastname);
		
		String img = System.getProperty("user.dir");
		driver.findElement(profilePicAddEmp).sendKeys(img +"/images/flower1.jpg");
		
		driver.findElement(chkAddEmp).click();
		
		driver.findElement(txtAddEmpUsername).sendKeys(uname);
		driver.findElement(txtAddEmpPwd).sendKeys(pwd);
		driver.findElement(txtAddEmpcmfPwd).sendKeys(cmfpwd);
		Helper.selectDropDown(driver.findElement(drpDownAddEmp), status);
		
		driver.findElement(btnAddEmpSave).click();
		
	}


}
