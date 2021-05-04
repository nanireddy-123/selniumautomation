package com.qa.testscript;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;
import com.qa.utility.ExcelUtility;

public class TC_Amazon extends TestBaseAmazon{

	
	@Test(dataProvider = "fetchData", priority = 1)
	public void login(String s1, String s2)
	{
		WebElement login = amazonPage.getsignin();
		login.click();
		
		amazonPage.getusername().sendKeys(s1);
		amazonPage.getcontinue().click();
		amazonPage.getpassword().sendKeys(s2);
		amazonPage.getlogin().click();
		
	}
	
	@Test(priority = 2 , dataProvider = "getData")
	public void buy(String i1) throws InterruptedException
	{
		WebElement searchbar = amazonPage.getsearchbar();
		amazonPage.getsearchbar().clear();
		searchbar.sendKeys(i1);
		amazonPage.getsearchbutton().click();
		
		amazonPage.getproduct().click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		amazonPage.getcart().click();
		driver.navigate().to("https://www.amazon.in/");
		amazonPage.viewcart().click();
		
		WebElement noofitems = driver.findElement(By.xpath("//*[@id=\"gutterCartViewForm\"]/div/div[1]/div[1]"));
		
		String total = noofitems.getText();
		
		Reporter.log(total,true);
	
				
		
		
	}
	
	@DataProvider
	 public Object[][] fetchData() throws IOException
	 {
	  String xlPath="C:\\Users\\nanireddy\\Desktop\\amazondata.xlsx";
	  String xlSheet="Sheet1";
	  int rowcount=ExcelUtility.getRowCount(xlPath, xlSheet);
	  int cellcount=ExcelUtility.getCellCount(xlPath, xlSheet, rowcount);
	  String [][] data=new String[rowcount][cellcount];
	  for(int i=1;i<=rowcount;i++)
	  {
	   for(int j=0;j<cellcount;j++)
	   {
	    data[i-1][j]=ExcelUtility.getCellData(xlPath, xlSheet, i, j);
	   }
	  }
	  
	  return data;
	 } 
	
	@DataProvider
	 public Object[][] getData() throws IOException
	 {
	  String xlPath="C:\\Users\\nanireddy\\Desktop\\amazondata.xlsx";
	  String xlSheet="Sheet2";
	  int rowcount=ExcelUtility.getRowCount(xlPath, xlSheet);
	  int cellcount=ExcelUtility.getCellCount(xlPath, xlSheet, rowcount);
	  String [][] data=new String[rowcount][cellcount];
	  for(int i=1;i<=rowcount;i++)
	  {
	   for(int j=0;j<cellcount;j++)
	   {
	    data[i-1][j]=ExcelUtility.getCellData(xlPath, xlSheet, i, j);
	   }
	  }
	  
	  return data;
	 } 
}
