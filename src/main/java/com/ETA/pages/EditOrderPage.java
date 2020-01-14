package com.ETA.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ETA.base.Base;

public class EditOrderPage extends Base {
	
	
	@FindBy(xpath= "//div[contains(@class,'')]//select")
	WebElement AddItem;
	
	public EditOrderPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void GenerateLabel()
	{
		Select item=new Select(AddItem);
		List<WebElement> options=item.getAllSelectedOptions();
		
		System.out.println(options);
	}
	
}
