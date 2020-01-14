package com.ETA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ETA.base.Base;


public class LoginPage extends Base {
	
	@FindBy(xpath= "//input[@id='username']")
	WebElement username;
	
	
	@FindBy(xpath= "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='signin-button']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	public DirectToPatientPage login(String un, String pwd) throws Exception  {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginBtn.submit();
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", loginBtn);

		return new DirectToPatientPage();
	}
	
	 
}
