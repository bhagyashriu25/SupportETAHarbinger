package com.ETA.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ETA.base.Base;
import com.ETA.pages.CreateOrderPage;
import com.ETA.pages.DirectToPatientPage;
import com.ETA.pages.LoginPage;

public class DirectToPatientPageTest extends Base{
	LoginPage loginPage;
	DirectToPatientPage directToPatientPage;
	CreateOrderPage createOrderPage;

	@BeforeMethod
	public void setUp() throws Exception
	{
		initializer();
		loginPage=new LoginPage();
		
		directToPatientPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(10000);
		
	}

	@Test 
	public void ValidateDirectToPatientTest() 
	{
	
		directToPatientPage.VerifyDirectToPatientPage();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("/direct-to-patient"));
		System.out.println("Direct to Patient Page is displayed");
		
	}
	
	@Test 
	public void VerifyCreateOrderPage() throws InterruptedException
	{
		createOrderPage=directToPatientPage.VerifyAddNewBtn();
		
		
	//	Assert.assertTrue(isAddNewBtnPresent());
		System.out.println("Clicks on Add New button");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
