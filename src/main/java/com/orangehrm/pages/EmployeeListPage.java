package com.orangehrm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage {

	
	WebDriver driver;
	public String profileNameDetails;
	
	public EmployeeListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By hoverPimMenu= By.id("menu_pim_viewPimModule");
	
	By lnkEmployeelist=By.id("menu_pim_viewEmployeeList");
	
	By txtEmpName=By.name("empsearch[employee_name][empName]");
	
	By btnSearch= By.id("searchBtn");
	
	By tableRow= By.xpath("//table[@id='resultTable']//tr");
	
	By chkbox=By.name("chkSelectRow[]");
	
	By btndelete= By.id("btnDelete");
	
	By dialogDeleteBtn= By.id("dialogDeleteBtn");
	
	By deleteMsg =By.id("//*[contains(text(),'Successfully Deleted') and @class]");
	
	
	By profilePicName= By.xpath("//div[@id='profile-pic']//h1");
	
	By chkGender= By.id("personal_optGender_2");
	
	By btnEdit= By.id("btnSave");
	
	By successMsg =By.xpath("//*[contains(text(),'Successfully Saved') and @class]");
	
	
	By welcomeTab=By.xpath("//a[@id='welcome']");
	
	By logout=By.xpath("//a[text()='Logout']");
	
	
	public void profileName() {
	//	profileNameDetails=driver.findElement(profilePicName).getText();
	}
	public void VerifyPersonalDetails() {
		profileNameDetails=driver.findElement(profilePicName).getText();
		System.out.println("LOG-INFO: Profile Name " + profileNameDetails);
		driver.findElement(btnEdit).click();
		driver.findElement(chkGender).click();
		driver.findElement(btnEdit).click();
	}
	public void searchEmployeelist() throws Exception {
		
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(hoverPimMenu)).build().perform();
		
		driver.findElement(lnkEmployeelist).click();
		
		driver.findElement(txtEmpName).sendKeys(profileNameDetails);
		
		driver.findElement(btnSearch).click();
		
		Thread.sleep(2000);
		
		List<WebElement> rows=driver.findElements(tableRow);
		 
		for (int i=1;i<rows.size(); i++)
		{
			driver.findElement(chkbox).click();
			driver.findElement(btndelete).click();
			driver.findElement(dialogDeleteBtn).click();
			isDeleteMsgDisplayed();
		}	
		
	}
	public void logOutFromApplication()
	{
		driver.findElement(welcomeTab).click();
		driver.findElement(logout).click();
	
	}
	public boolean isSuccessMsgDisplay() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(successMsg)).isDisplayed();
	}

	public boolean isDeleteMsgDisplayed()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		return wait.until(ExpectedConditions.elementToBeClickable(deleteMsg)).isDisplayed();
	}
}
