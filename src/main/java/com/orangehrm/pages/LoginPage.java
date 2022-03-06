package com.orangehrm.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 public WebDriver driver;
	 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By txtUserName= By.id("txtUsername");
	By txtPwd=By.id("txtPassword");
	By btnLogin= By.id("btnLogin");

	public void loginAsAdmin(String uname, String password) {
		
		driver.findElement(txtUserName).sendKeys(uname);	
		driver.findElement(txtPwd).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
}