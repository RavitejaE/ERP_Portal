package com.tekskills.erp_portal.pageLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewLeaves
{
	WebDriver driver;
	
	By viewLeaveYear = By.xpath("//*[@id='year']");
	By viewLeaveMonth = By.xpath("//*[@id='leave_month']");
	By viewLeaveType = By.xpath("");
	By viewLeaveStatus = By.xpath("");
	By searchLeaves = By.xpath("//button[contains(text(),'SEARCH')]");
	
	public ViewLeaves(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectPermissionYear(String vPermYear) throws InterruptedException
	{
		driver.findElement(viewLeaveYear).click();
		Thread.sleep(2000);
		List<WebElement> vPeYears = driver.findElements(By.xpath("//*[@id='year']/option"));
		for (WebElement vPermissionYears : vPeYears) {
			if (vPermissionYears.getText().trim().equals(vPermYear)) {
				vPermissionYears.click();
			}
		}
	}
	
	public void selectPermissionMonth(String vPermMonth) throws InterruptedException
	{
		driver.findElement(viewLeaveMonth).click();
		Thread.sleep(2000);
		List<WebElement> vPeMonths = driver.findElements(By.xpath("//*[@id='leave_month']/option"));
		for (WebElement vPermissionMonths : vPeMonths) {
			if(vPermissionMonths.getText().trim().toLowerCase().equals(vPermMonth.toLowerCase()))
			{
				vPermissionMonths.click();
			}
		}
	}
	
	public void clickSearchLeave()
	{
		driver.findElement(searchLeaves).click();
	}
}
