package com.tekskills.erp_portal.pageLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewPermissions
{
	WebDriver driver;
	
	By permissionYear = By.xpath("//*[@id='year']");
	By permssionMonth = By.xpath("//*[@id='leave_month']");
	By permissionStatus = By.xpath("");
	By searchPermission = By.xpath("//button[contains(text(),'SEARCH')]");
	
	public ViewPermissions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectPermissionYear(String pYear) throws InterruptedException
	{
		driver.findElement(permissionYear).click();
		Thread.sleep(2000);
		List<WebElement> pYears = driver.findElements(By.xpath("//*[@id='year']/option"));
		for (WebElement permYears : pYears) {
			if (permYears.getText().trim().equals(pYears)) {
				permYears.click();
			}
		}
	}
	
	public void selectPermissionMonth(String pMonth) throws InterruptedException
	{
		driver.findElement(permssionMonth).click();
		Thread.sleep(2000);
		List<WebElement> pMonths = driver.findElements(By.xpath("//*[@id='leave_month']/option"));
		for (WebElement permMonths : pMonths) {
			if(permMonths.getText().trim().toLowerCase().equals(pMonth.toLowerCase()))
			{
				permMonths.click();
			}
		}
	}
	
	public void selectPermissionstatus(String pStatus) throws InterruptedException
	{
		driver.findElement(permissionStatus).click();
		Thread.sleep(2000);
		List<WebElement> pStat = driver.findElements(By.xpath("//*[@id='leave_month']/option"));
		for(WebElement permStat : pStat)
		{
			if (permStat.getText().toLowerCase().equals(pStatus.toLowerCase()))
			{
				permStat.click();
			}
		}
	}
	
	public void clickSearchPermission()
	{
		driver.findElement(searchPermission).click();
	}
}
