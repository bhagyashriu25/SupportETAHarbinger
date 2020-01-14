package com.ETA.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.ETA.util.Xls_Reader;


public class CreateOrderPageTest extends Base{

	LoginPage loginPage;
	TestUtil testUtil;
	DirectToPatientPage directToPatientPage;
	CreateOrderPage createOrderPage;
	//Xls_Reader reader;
	String sheetName = "CreateOrder";
//	int rowCount;
	@BeforeMethod
	public void setUp() throws Exception
	{
		initializer();
		testUtil = new TestUtil();
		loginPage=new LoginPage();
		//createOrderPage=new CreateOrderPage();
		//directToPatientPage=new DirectToPatientPage();
		directToPatientPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(10000);
		createOrderPage=directToPatientPage.VerifyAddNewBtn();
		
	    Thread.sleep(10000);
		
		// reader = new Xls_Reader(prop.getProperty("Create_Order_Sheet_Path"));
		//sheetName = prop.getProperty("Create_Prder_Sheet_Name");
		
		// rowCount = reader.getRowCount(sheetName);
		 
		
	}
	/*@Test
	public void sheetdata() throws IOException
	{
	List<String> Create_Order_Data= createOrderPage.getData(prop.getProperty("Create_Order"));
	System.out.println(Create_Order_Data.get(0));
	System.out.println(Create_Order_Data.get(1));
	
	
	
	}*/
	/*@Test
	public void verifyReturnToDTPLinkTest()
	{
		directToPatientPage=createOrderPage.clickReturnToDTPLink();
	    System.out.println("Clicked on Return to Direct To Patient Link");
	}*/
/*	@DataProvider
	public void getETATestData(){
		for(int rowNum=2; rowNum<=rowCount; rowNum++)
		{
			
		String OrderType= reader.getCellData(sheetName, "OrderType", rowNum);
		String PatientSite = reader.getCellData(sheetName, "PatientSite", rowNum);
		String PatientUID= reader.getCellData(sheetName, "PatientUID", rowNum);
		
		//Object data[][] = TestUtil.getTestData(sheetName);
		
		}
	}
	*/

	/*	@Test
	public void VerifyPatientUIDValidatnMsgTest() throws Exception
	{
		createOrderPage.CreateOrderFunctionality(null, null, null);
		
		Assert.assertEquals(createOrderPage.patientUIDDropdownValdnMsg(), "Please select a patientUID");
	}*/
	/*@Test 
	public void ClickOnAddNewBtn() throws IOException, InterruptedException
	{
				
		createOrderPage.CreateOrderFunctionality();
		System.out.println("Clicked on Next button Successfully");
	}
	*/

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

	/*	@Test
	public void VerifyPatientUIDValidatnMsgTest() throws Exception
	{
		createOrderPage.CreateOrderFunctionality(null, null, null);
		
		Assert.assertEquals(createOrderPage.patientUIDDropdownValdnMsg(), "Please select a patientUID");
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
