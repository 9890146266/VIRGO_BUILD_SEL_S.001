package testInnovationTask;
import java.util.ArrayList;
import java.util.List;
import screenshot.Utility;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static Utils.BrowserLibrary.*;
import static org.testng.Assert.assertEquals;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import BussinessLogic.Generic_functions;
import Utils.BrowserLibrary;
import Utils.ReadLibrary;
import config.*;
public class TestApp 
{
	public static ExtentReports report;
	public static JavascriptExecutor js;
	public static ExtentTest logger;
	public static ArrayList al=null;
	public static ReadLibrary read=null;
	public static BrowserLibrary library=null;
	public static String locatorType,locatorValue,browsername,actual,expected;
	public static By by;
	@BeforeSuite
	public void setup()
	{
		al=new ArrayList<>();
		library=new BrowserLibrary();
		read=new ReadLibrary("D:\\VIRGO\\src\\dataengine\\virgo.xlsx");
		System.out.println("All required setup for this project is done");
	}
	@Test(priority=0)
	public void TC00_browserLoad() 
	{
		browsername=ReadLibrary.setCellValue(0, 1, 5);
		System.out.println("Application is open on "+browsername);
		driver=library.browserload(browsername);
		driver.get("http://toolsqa.com/automation-practice-form/");	
	}
	@Test(priority=1)
	public void TC01_navigationCheck()
	{
		locatorType=ReadLibrary.setCellValue(0, 4, 3);
		locatorValue=ReadLibrary.setCellValue(0, 4, 4);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		al=Generic_functions.getList(by);
		System.out.println("NAVIGATION COMMANDS==>>");
		System.out.println(al);
	}
	@Test(priority=2)
	public void TC02_selectAustralia() throws Exception
	{
		locatorType=ReadLibrary.setCellValue(0, 8, 3);
		locatorValue=ReadLibrary.setCellValue(0, 8, 4);
		expected=ReadLibrary.setCellValue(0, 8, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		actual=Generic_functions.dropDown(by,expected);
		assertEquals(actual, expected);
		
	}
	@Test(priority=3)
	public void TC03_selectNavigationCommands() throws Exception 
	{
		locatorType=ReadLibrary.setCellValue(0, 12, 3);
		locatorValue=ReadLibrary.setCellValue(0, 12, 4);
		expected=ReadLibrary.setCellValue(0, 12, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		actual=Generic_functions.dropDown(by,expected);
		assertEquals(actual, expected);
	} 
	@Test(priority=5)
	public static void TC05_selectGender() throws Exception
	{
		locatorType=ReadLibrary.setCellValue(0, 21, 3);
		locatorValue=ReadLibrary.setCellValue(0, 21, 4);
		expected=ReadLibrary.setCellValue(0, 21, 5);
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500);");
		by=Generic_functions.getlocator(locatorType, locatorValue);
		actual=Generic_functions.radio(by,expected);
		assertEquals(actual, expected);
	}
	@Test(priority=6)
	public void TC06_enterFirstName()
	{
		locatorType=ReadLibrary.setCellValue(0, 26, 3);
		locatorValue=ReadLibrary.setCellValue(0, 26, 4);
		expected=ReadLibrary.setCellValue(0, 26, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		Generic_functions.enterText(by, expected);
	}
	@Test(priority=7)
	public void TC07_enterLastName()
	{
		locatorType=ReadLibrary.setCellValue(0, 30, 3);
		locatorValue=ReadLibrary.setCellValue(0, 30, 4);
		expected=ReadLibrary.setCellValue(0, 30, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		Generic_functions.enterText(by, expected);
	}
	@Test(priority=8)
	public void TC08_yearsOfExperience() throws Exception
	{
		locatorType=ReadLibrary.setCellValue(0, 34, 3);
		locatorValue=ReadLibrary.setCellValue(0, 34, 4);
		expected=ReadLibrary.setCellValue(0, 34, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		actual=Generic_functions.radio(by,expected);
		assertEquals(actual, expected);
	}
	@Test(priority=9)
	public void TC09_enterLastName()
	{
		locatorType=ReadLibrary.setCellValue(0, 38, 3);
		locatorValue=ReadLibrary.setCellValue(0, 38, 4);
		expected=ReadLibrary.setCellValue(0, 38, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		Generic_functions.enterText(by, expected);
	}
	
	@Test(priority=10)
	public void TC10_selectProfession() throws Exception   
	{
		locatorType=ReadLibrary.setCellValue(0, 16, 3);
		locatorValue=ReadLibrary.setCellValue(0, 16, 4);
		expected=ReadLibrary.setCellValue(0, 16, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		Generic_functions.checkbox(by, expected);
		expected=ReadLibrary.setCellValue(0, 17, 5);
		Thread.sleep(1000);
		actual=Generic_functions.checkbox(by, expected);
		Assert.assertEquals(actual, expected);;
	}
	
	@Test(priority=11)
	public void TC11_selectIDE_webdriver() throws Exception   
	{
		locatorType=ReadLibrary.setCellValue(0, 42, 3);
		locatorValue=ReadLibrary.setCellValue(0, 42, 4);
		expected=ReadLibrary.setCellValue(0, 42, 5);
		by=Generic_functions.getlocator(locatorType, locatorValue);
		Generic_functions.checkbox(by, expected);
		expected=ReadLibrary.setCellValue(0, 43, 5);
		Thread.sleep(1000);
		actual=Generic_functions.checkbox(by, expected);
		Assert.assertEquals(actual, expected);;
	}
	
	@Test(priority=12)
	public void TC12_localFileUpload() throws Exception   
	{
		locatorType=ReadLibrary.setCellValue(0, 47, 3);
		locatorValue=ReadLibrary.setCellValue(0, 47, 4);
		Generic_functions.click_On_Button(locatorType,locatorValue);
		expected=ReadLibrary.setCellValue(0, 47, 5);
		Generic_functions.fileUpload(expected);
		
	}
	
	@Test(priority=13)
	public void TC13_downloadFile() throws Exception 
	{
		locatorType=ReadLibrary.setCellValue(0, 52, 3);
		locatorValue=ReadLibrary.setCellValue(0, 52, 4);
		Generic_functions.click_On_Link(locatorType,locatorValue);	
		
	}
	
	@AfterSuite
	public void exit() throws Exception
	{
		Thread.sleep(25000);
		driver.quit();
	}
	
	




	
}

