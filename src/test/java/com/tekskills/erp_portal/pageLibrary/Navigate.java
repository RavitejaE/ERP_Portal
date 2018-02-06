package com.tekskills.erp_portal.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigate
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D://sw//Jars//geckodriver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://eportal.tekskillsinc.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Raviteja.E");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("asdASD123");
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(), 'Dashboard')]")).click();
		Thread.sleep(3000);
		
		
		int count = driver.findElements(By.xpath("//div[@class='info']")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//div[@class='info']")).get(i).getAttribute("value");
			System.out.println(text);
			/*if(text.equals("NC TRACKER"))
			{
				driver.findElements(By.xpath("//input[@name='col-md-6']")).get(i).click();
			}*/
		}
	}
}