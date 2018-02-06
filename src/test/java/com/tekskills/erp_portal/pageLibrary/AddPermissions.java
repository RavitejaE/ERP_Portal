package com.tekskills.erp_portal.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddPermissions
{
	WebDriver driver;
	
	By permissionDate = By.xpath("//*[@id='permdate']");
	By permissionComments = By.xpath("//*[@id='textArea']");
	
	public AddPermissions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectPermissionDate(String pdate) throws InterruptedException
	{
		driver.findElement(permissionDate).click();
		Thread.sleep(2000);
		while(driver.findElement(permissionDate).getText().matches("March") == false)
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();			
		}
		driver.findElement(By.linkText("31")).click();
	}
	
	public void enterPermissionComments(String pcomments)
	{
		driver.findElement(permissionComments).sendKeys(pcomments);
	}
	
	public void addPermissions(String permDate, String permComments) throws InterruptedException
	{
		selectPermissionDate(permDate);
		enterPermissionComments(permComments);		
	}
	
}
