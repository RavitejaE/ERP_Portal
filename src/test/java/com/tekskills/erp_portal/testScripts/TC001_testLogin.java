package com.tekskills.erp_portal.testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tekskills.erp_portal.pageLibrary.Signin;
import com.tekskills.erp_portal.testBase.TestBase;

public class TC001_testLogin extends TestBase
{
	Signin signin;
	
	@BeforeClass
	public void setUP() throws IOException
	{
		init();
	}
	
	@Test
	public void testLogin() throws Exception
	{
		signin = new Signin(driver);
		waitFor(3);
		signin.logintoApplication();
		waitFor(1);
		signin.clickLinkDashboard();
		waitFor(1);
		signin.clickLinkLeavesPermissions();
	}
	
	@AfterClass
	public void quitBrowser()
	{
		closeBrowser();
	}
}