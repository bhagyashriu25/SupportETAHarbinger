package com.ETA.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ETA.base.Base;
import com.ETA.pages.DirectToPatientPage;

import com.ETA.pages.LoginPage;
import com.ETA.pages.listeners;

@Listeners(listeners.class)
public class LoginPageTest extends Base {
	LoginPage loginPage;
	DirectToPatientPage directToPatientPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initializer();
		loginPage=new LoginPage();
		
		directToPatientPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		
		
	}

	
	
	@Test 
	public void AuthenticationSuccessWhenProvidingCorrectCredentialsTest() 
	{
	
		
		Assert.assertTrue(driver.getCurrentUrl().endsWith("/direct-to-patient"));
		System.out.println("Login successfully to ETA application");
		
	}
	
	@Test
	public void AuthenticationFailWhenProvidingInCorrectCredentialsTest() 
	{ 
	   
	//	Assert.assertEquals(prop.getProperty("username"), "");
		
		//String exp="";
		//Assert.assertTrue(prop.getProperty("username").equals(exp), "Incorrect username or password");
		
		String validation = "Incorrect username or password";
		WebElement error = driver.findElement(By.xpath("//p[@class='noshow']"));
		String msg= error.getText();
			System.out.println("test "+ msg);
				
		//Assert.assertEquals(msg, validation );
		
				
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
