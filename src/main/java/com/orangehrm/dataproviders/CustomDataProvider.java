package com.orangehrm.dataproviders;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	
	@DataProvider(name="Login")
	public static Object[][] getLoginData(){
		return ExcelUtility.getDataFromSheet("Login");
	}
	
	@DataProvider(name="AddEmp")
	public static Object[][] getAddEmployee(){
		return ExcelUtility.getDataFromSheet("Employee");
	}
}
