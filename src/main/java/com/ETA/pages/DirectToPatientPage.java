package com.ETA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ETA.base.Base;

public class DirectToPatientPage extends Base {

	
	
	@FindBy(xpath= "//a[@class='subnav__item active']")
	WebElement directToPatientLink;
	
	
	@FindBy(xpath= "//button[@class='add-button']")
	WebElement AddNewBtn;
	
	public DirectToPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public DirectToPatientPage VerifyDirectToPatientPage ()
	{
		directToPatientLink.click();
		return new DirectToPatientPage();
	}
	
	public CreateOrderPage VerifyAddNewBtn() throws InterruptedException
	{
		
		AddNewBtn.click();
		Thread.sleep(10000);
		return new CreateOrderPage();

	}
	

	
}
