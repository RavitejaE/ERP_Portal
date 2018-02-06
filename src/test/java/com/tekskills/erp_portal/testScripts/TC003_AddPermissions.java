package com.tekskills.erp_portal.testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tekskills.erp_portal.pageLibrary.AddLeaves;
import com.tekskills.erp_portal.pageLibrary.Signin;
import com.tekskills.erp_portal.testBase.TestBase;

public class TC003_AddPermissions extends TestBase
{
	Signin signin;
	AddLeaves addLeaves;
	
	@BeforeClass
	public void setUP() throws IOException
	{
		init();
	}
	
	@Test
	public void addUserPermissions()
	{
		signin = new Signin(driver);
		addLeaves = new AddLeaves(driver);
	}
	
	@AfterClass
	public void quitBrowser()
	{
		closeBrowser();
	}
}
