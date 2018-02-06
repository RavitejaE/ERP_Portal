package com.tekskills.erp_portal.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tekskills.erp_portal.pageLibrary.AddLeaves;
import com.tekskills.erp_portal.pageLibrary.Signin;
import com.tekskills.erp_portal.testBase.TestBase;

public class TC002_AddLeaves extends TestBase
{
	Signin signin;
	AddLeaves addLeave;
	
	String leaveT = "Casual leave";
	//String leaveDt = "31";
	String leaveDy = "1";
	String cmts = "This is Test data";
	String registeredusername = "Raviteja.E";
	String registeredpassword = "asdASD123";
	
	@BeforeClass
	public void setUP() throws IOException
	{
		init();
	}
	
	@Test
	public void addUserLeaves() throws InterruptedException
	{
		signin = new Signin(driver);
		addLeave = new AddLeaves(driver);
		signin.enterDataToSignin(registeredusername, registeredpassword);
		waitFor(2);
		signin.clickLinkDashboard();
		waitFor(1);
		signin.clickLinkLeavesPermissions();
		waitFor(2);
		addLeave.testAddLeaves(leaveT, /*leaveDt,*/ leaveDy, cmts);
		addLeave.clickBtnSubmit();
		boolean isSuccess = addLeave.verifyLeaveMsg();
		if (isSuccess) {
			Assert.assertTrue(true, "Leaves Requested Successfully!!");
		}
		else {
			Assert.assertTrue(false, "Leaves Requested Successfully!!");
		}
	}
	
	@AfterClass
	public void quitBrowser()
	{
		closeBrowser();
	}
}