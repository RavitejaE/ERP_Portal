package com.tekskills.erp_portal.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signin
{
	WebDriver driver;
	
	By regUser = By.xpath("//*[@id='username']");
	By regPassword = By.xpath("//*[@id='password']");
	By btnSignin = By.xpath("//button[contains(text(),'SIGN IN')]");
	// By btnSignin = By.xpath("/html/body/section[2]/div[2]/form/div[3]/button");
	By clickDashboard = By.xpath("//span[contains(text(), 'Dashboard')]");
	By clickLeavesPermissions = By.xpath("//a[contains(text(),'Leaves & Permissions')]");

	public Signin(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method will enter valid username
	 * @param registeredusername
	 */
	
	public void enterValidUsername(String registeredusername)
	{
		driver.findElement(regUser).sendKeys(registeredusername);
	}
	
	/**
	 * This method will enter valid password of the user
	 * @param registeredpassword
	 */
	
	public void enterValidPassword(String registeredpassword)
	{
		driver.findElement(regPassword).sendKeys(registeredpassword);
	}
	
	/**
	 * This method will click on signin button
	 */
	
	public void clickLogin()
	{
		driver.findElement(btnSignin).click();
	}
	
	/**
	 * This is method is used for login to the application
	 */
	
	public void logintoApplication()
	{
		enterValidUsername("Raviteja.E");
		enterValidPassword("asdASD123");
		clickLogin();
	}
	
	/**
	 * Click Dashboard
	 */
	
	public void clickLinkDashboard()
	{
		driver.findElement(clickDashboard).click();
	}
	
	public void clickLinkLeavesPermissions()
	{
		driver.findElement(clickLeavesPermissions).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("Clicked Leaves and Permissions");
	}
	
	public void enterDataToSignin(String registeredusername, String registeredpassword)
	{
		enterValidUsername(registeredusername);
		enterValidPassword(registeredpassword);
		clickLogin();
	}
}