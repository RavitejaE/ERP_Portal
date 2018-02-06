package com.tekskills.erp_portal.pageLibrary;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLeaves
{
	WebDriver driver;
	
	By leaveType = By.xpath("//select[@name='leave_type']");
	By leaveYear = By.xpath("//*[@id='leave_year']");
	By leaveMonth = By.xpath("//*[@name='leave_month']");
	//By leaveDate = By.xpath("//span[@class='ui-datepicker-month']");
	By leaveDays = By.xpath("//*[@id='no_ofdays']");
	By manager = By.xpath("//*[@id='select2-demoSelect-container']");
	By leaveComments = By.xpath("//*[@id='textArea']");
	By btnSubmit = By.xpath("//button[contains(text(),'Submit')]");
	By btnReset = By.xpath("//a[contains(text(),'Reset')]");
	
	public AddLeaves(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectLeaveType(String leave) throws InterruptedException
	{
		driver.findElement(leaveType).click();
		Thread.sleep(2000);
		List<WebElement> ltype = driver.findElements(By.xpath("//select[@name='leave_type']/option"));
		for (WebElement lvType : ltype) {
			if (lvType.getText().trim().toLowerCase().equals(leave.toLowerCase())) {
				lvType.click();
			}
		}
	}
	
	/*public void selectLeaveDate(String date) throws InterruptedException
	{
		driver.findElement(leaveDate).click();
		Thread.sleep(2000);
		while(driver.findElement(leaveDate).getText().matches("March") == false)
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();			
		}
		driver.findElement(By.linkText("31")).click();
	}*/
	
	public void leaveDays(String day)
	{
		driver.findElement(leaveDays).sendKeys(day);
	}
	
	public void selectManager(String mngr) throws InterruptedException
	{
		driver.findElement(manager).click();
		Thread.sleep(2000);
		List<WebElement> manager = driver.findElements(By.xpath("//*[@id='select2-demoSelect-container']/li"));
		for (WebElement mgr : manager) {
			if (mgr.getText().trim().equals(mngr)) {
				mgr.click();
			}
		}
	}
	
	public void enterComments(String comments)
	{
		driver.findElement(leaveComments).sendKeys(comments);
	}
	
	public void clickBtnSubmit()
	{
		driver.findElement(btnSubmit).click();
	}
	
	public void clickBtnReset()
	{
		driver.findElement(btnReset).click();
	}
	
	public boolean verifyLeaveMsg()
	{
		Alert amsg = driver.switchTo().alert();
		String msg = amsg.getText();
		if (msg.contains("Leaves Requested Successfully!!")) {
			amsg.accept();
			return true;
		}
		else {
			return false;
		}
	}
	
	public void testAddLeaves(String leaveT,/*String leaveDt,*/ String leaveDy, String cmts) throws InterruptedException
	{
		selectLeaveType(leaveT);
		//selectLeaveDate(leaveDt);
		leaveDays(leaveDy);
		enterComments(cmts);
	}

}