package BussinessLogic;
import static Utils.BrowserLibrary.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Generic_functions 
{
	static int x=0;
	public static By by;
	public static WebElement element;
	public static ArrayList <String>arraylist;
	public static List<WebElement>list,list1;
	public static WebElement web,web1;
	public static String actual=null;
	public static WebDriverWait wait=new WebDriverWait(driver,10);
	public static Robot robot;
	
	public static By getlocator(String locator,String path)
	{
		if("id".equalsIgnoreCase(locator))
		{
			x=1;
		}if("xpath".equalsIgnoreCase(locator))
		{
			x=2;
		}
		if("name".equalsIgnoreCase(locator))
		{
			x=3;
		}
		if("css".equalsIgnoreCase(locator))
		{
			x=4;
		}
		if("linkText".equalsIgnoreCase(locator))
		{
			x=5;
		}
		
		if("PartialLinkText".equalsIgnoreCase(locator))
		{
			x=6;
		}
		switch (x) 
		{
			case 1:
				by = By.id(path);
				break;
			case 2:
				by = By.xpath(path);
				break;
			case 3:
				by = By.name(path);
				break;
			case 4:
				by = By.cssSelector(path);
				break;
			case 5:
				by = By.linkText(path);
				break;
			case 6:
				by = By.partialLinkText(path);
				break;
			default:
				by = null;
				break;
		}
		
		return by;
	}
		
		
public static void click_On_Link(String locatorType, String value) throws Exception 
{
	try 
	{
		By locator;
		locator = getlocator(locatorType, value);
		WebElement element = driver.findElement(locator);
		element.click();
		driver.manage().timeouts().setScriptTimeout(15,TimeUnit.SECONDS);
	} catch (NoSuchElementException e) 
	{
		System.err.format("No Element Found to enter text" + e);
	}
}


public static void click_On_Button(String locatorType, String value) 
{
	try 
	{
		By locator;
		locator = getlocator(locatorType, value);
		WebElement element = driver.findElement(locator);
		element.click();
	} 
	catch (NoSuchElementException e) 
	{
		System.err.format("No Element Found to perform click" + e);
	}
}

public static ArrayList getList(By by)
{
	int i;
	list1=driver.findElements(by);
	arraylist=new ArrayList<String>();
	for(i=0;i<list1.size();i++)
	{
		arraylist.add(list1.get(i).getText());
	}
	return arraylist;
}

public static String dropDown(By by,String expected) throws Exception
{
	list1.clear();
	web=driver.findElement(by);
	Select select=new Select(web);
	list1=select.getOptions();
	for(int i=0;i<list1.size();i++)
	{
		web1=list1.get(i);
		actual=list1.get(i).getText();
		if(actual.equalsIgnoreCase(expected))
		{
			Thread.sleep(2000);
			web1.click();
			break;
		}
		
	}
	Thread.sleep(1000);
	return actual; 
}
public static String checkbox(By by,String expected)
{
	list1.clear();
	 list1=driver.findElements(by);
	for(int i=0;i<list1.size();i++)
	{
		WebElement we=list1.get(i);
		actual=we.getAttribute("value");
		if(actual.equalsIgnoreCase(expected))
		{
			we.click();
			break;
		}
	}
	return actual;
}
public static String radio(By by,String expected) throws Exception
{
	list1.clear();
	list1=driver.findElements(by);
	for(int i=0;i<list1.size();i++)
	{
		WebElement we=list1.get(i);
		actual=we.getAttribute("value");
		Thread.sleep(2000);
		if(actual.equalsIgnoreCase(expected))
		{
			we.click();
			break;
		}
	}
	return actual;
}
public static void enterText(By by,String textToWriiten)
{
	driver.findElement(by).sendKeys(textToWriiten);
}

public static void fileUpload(String filename) throws Exception
{
	System.out.println(filename);
	StringSelection ss=new StringSelection(filename);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	robot=new Robot();
	robot.setAutoDelay(2000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.setAutoDelay(2000);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	robot.setAutoDelay(2000);
	robot.setAutoDelay(2000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);	
}


}
