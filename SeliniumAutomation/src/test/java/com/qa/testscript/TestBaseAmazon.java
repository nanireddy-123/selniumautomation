package com.qa.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;


public class TestBaseAmazon {
	WebDriver driver;
	
	AmazonPages amazonPage;

	
	@Parameters({"Browser","Url"})

	@BeforeClass
	public void setUp(String Browser, String Url) {
		
		if(Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nanireddy\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\nanireddy\\Desktop\\drivers\\edgedriver_win64 (1");

		}
		driver.manage().window().maximize();
		amazonPage = new AmazonPages(driver);
		driver.get(Url);
		
}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}