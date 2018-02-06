package com.tekskills.erp_portal.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase
{
	public WebDriver driver;
	public File f1;
	public FileInputStream fileIS;
	public static Properties Repository = new Properties();
	public static final String testDataExcelFileName = "TestData.xlsx";
	
	public void init() throws IOException
	{
		loadPropetiesFile();
		getBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	// Loading the properties file
	public void loadPropetiesFile() throws IOException
	{
		f1 = new File(System.getProperty("user.dir") + "//src/test//java//com//tekskills//erp_portal//config//config.properties");
		fileIS = new FileInputStream(f1);
		Repository.load(fileIS);
	}
	
	public WebDriver getBrowser(String browser)
	{
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equals("ie") || browser.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}
	
	public void waitFor(int sec) throws InterruptedException
	{
		Thread.sleep(sec*1000);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
