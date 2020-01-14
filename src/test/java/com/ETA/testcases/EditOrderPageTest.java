package com.ETA.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ETA.base.Base;
import com.ETA.pages.CreateOrderPage;
import com.ETA.pages.DirectToPatientPage;
import com.ETA.pages.LoginPage;
import com.ETA.util.TestUtil;

public class EditOrderPageTest extends Base{
	LoginPage loginPage;
	TestUtil testUtil;
	DirectToPatientPage directToPatientPage;
	CreateOrderPage createOrderPage;
	EditOrderPageTest editOrderPageTest;
	//Xls_Reader reader;
	String sheetName = "CreateOrder";
//	int rowCount;
	@BeforeMethod
	public void setUp() throws Exception
	{
		initializer();
		testUtil = new TestUtil();
		loginPage=new LoginPage();
	
		
		editOrderPageTest=new EditOrderPageTest();
		directToPatientPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(10000);
		createOrderPage=directToPatientPage.VerifyAddNewBtn();
		
		Thread.sleep(10000);
		
		 
	
	}


	@DataProvider
	public Object[][] getETATestData(){
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="getETATestData")
	public void ClickOnAddNewBtn(String OrderType,String PatientSite,String PatientUID) throws IOException, InterruptedException
	{
		createOrderPage.CreateOrderFunctionality(OrderType,PatientSite,PatientUID);
		if (PatientUID=="")
		{
		Assert.assertEquals(createOrderPage.patientUIDDropdownValdnMsg(), "Please select a patientUID");
		}
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}




}
