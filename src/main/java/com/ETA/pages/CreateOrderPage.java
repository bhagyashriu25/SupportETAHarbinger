package com.ETA.pages;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ETA.base.Base;
import com.ETA.util.TestUtil;


public class CreateOrderPage extends Base {
	TestUtil testutil;
	String sheetName = "CreateOrder";
	
	List<String> Create_Order_Data;
	@FindBy(xpath= "//div[@name='type']//input[@class='search']")
	WebElement OrderTypeDropdown;

	
	@FindBy(xpath= "//div[@name='site']//input[@class='search']")
	WebElement PatientSiteDropdown;
	
	
	@FindBy(xpath= "//div[@name='patientUID']//input[@class='search']")
	WebElement PatientUIDDropdown;
	

	@FindBy(xpath= "//button[@class='ui primary button']")
	WebElement NextBtn;
	
	@FindBy(xpath="//div[@class='ui pointing above prompt label']")
	WebElement PatientUIDDropdownValdnMsg;
	
	@FindBy(xpath="//div[@class='backButton']")
	WebElement ReturnToDTPLink;
	
	
	public CreateOrderPage() {
		PageFactory.initElements(driver, this);
		
	}
	public DirectToPatientPage clickReturnToDTPLink(){
		ReturnToDTPLink.click();
		return new DirectToPatientPage();
	}
	public String patientUIDDropdownValdnMsg()
	{
		String msg=PatientUIDDropdownValdnMsg.getText();
		return msg;
	}
/*
	public void CreateOrderFunctionality() throws IOException, InterruptedException
	{
		 Create_Order_Data= this.getData(prop.getProperty("testCaseName"));
		 OrderTypeDropdown.sendKeys(Create_Order_Data.get(1));
			OrderTypeDropdown.sendKeys(Keys.ENTER);
			
			
			PatientSiteDropdown.sendKeys(Create_Order_Data.get(2));
			PatientSiteDropdown.sendKeys(Keys.ENTER);
			Thread.sleep(10000);
		
		switch(prop.getProperty("testCaseName")) 
		{
		     case "Create_Order_1":
			
			PatientUIDDropdown.sendKeys(Create_Order_Data.get(3));
			PatientUIDDropdown.sendKeys(Keys.ENTER);
			
			break;
			
		     case "Create_Order_2":
		    	 
		    	 break;
		    	 
		    	 
		}
	
		
		
		//Thread.sleep(10000);
		//NextBtn.click();
	}
	*/
	public EditOrderPage CreateOrderFunctionality(String OType, String PSite,String PUID ) throws IOException, InterruptedException
	{
		
		
		 OrderTypeDropdown.sendKeys(OType);
		 OrderTypeDropdown.sendKeys(Keys.ENTER);
			
			
		PatientSiteDropdown.sendKeys(PSite);
		PatientSiteDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		
		
		driver.findElement(By.xpath("//div[@name='patientUID']//i[@class='dropdown icon']")).click();
		//PatientUIDDropdown.sendKeys(PUID);
		//PatientUIDDropdown.click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@name='patientUID']//div//div//span"));
		for (WebElement option : options) {
		    if(PUID.equals(option.getText()))
		        option.click();   
		}
			
		driver.findElement(By.xpath("//div[@name='patientUID']//i[@class='dropdown icon']"));
		Thread.sleep(10000);
		NextBtn.submit();
		
		return new EditOrderPage();
	}

}
