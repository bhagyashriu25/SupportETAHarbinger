package com.ETA.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ETA.base.Base;
import com.ETA.pages.CreateOrderPage;
import com.ETA.pages.DirectToPatientPage;
import com.ETA.pages.LoginPage;

public class CreateOrderPagePractice extends Base{
	
	LoginPage loginPage;
	DirectToPatientPage directToPatientPage;
	CreateOrderPage createOrderPage;

	@BeforeMethod
	public void setUp() throws Exception
	{
		initializer();
		loginPage=new LoginPage();
		createOrderPage=new CreateOrderPage();
		directToPatientPage=new DirectToPatientPage();
		directToPatientPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(10000);
		createOrderPage=directToPatientPage.VerifyAddNewBtn();
		
		Thread.sleep(10000);
		
		
		
	}
	/*@Test
	public void sheetdata() throws IOException
	{
	List<String> Create_Order_Data= createOrderPage.getData(prop.getProperty("Create_Order"));
	System.out.println(Create_Order_Data.get(0));
	System.out.println(Create_Order_Data.get(1));
	
	
	
	}*/
	@Test
	public void verifyReturnToDTPLinkTest()
	{
		directToPatientPage=createOrderPage.clickReturnToDTPLink();
	    System.out.println("Clicked on Return to Direct To Patient Link");
	}
	
	@Test
	public void VerifyPatientUIDValidatnMsgTest() throws Exception
	{
	//	createOrderPage.CreateOrderFunctionality();
		
		Assert.assertEquals(createOrderPage.patientUIDDropdownValdnMsg(), "Please select a patientUID");
	}
	@Test 
	public void ClickOnAddNewBtn() throws IOException, InterruptedException
	{
				
		//createOrderPage.CreateOrderFunctionality();
		System.out.println("Clicked on Next button Successfully");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
