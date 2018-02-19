package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Accessproperty 
{
public static Properties properties;

		public Accessproperty()
		{
			try 
			{
				File file=new File(" mentioned property file path");
				FileInputStream fis=new FileInputStream(file);
				 properties=new Properties();
				 properties.load(fis);
			} 
			catch (Exception e)
			{
				System.out.println("Exception generated"+e.getMessage());
			}
			
		}
       
       public  String URL()
       { 
    	  
    	   String url=properties.getProperty("URL");
    	   return url;
       }
       public String browserselect()
       { 
    	   properties=new Properties();
    	   String element=properties.getProperty(" add your property file stored variable name");
    	   return element;
       }
}
