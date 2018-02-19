package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xalan.xsltc.compiler.util.StringType;

public class WriteLibrary
{
 XSSFWorkbook wb;
 XSSFSheet sheet;
// XSSFCell cell;
 File source;
 FileInputStream fis;
FileOutputStream out;
public WriteLibrary(String filepath,int sheetnumber) 
{	
	 try 
	 {
		 
		 source=new File(filepath); 
		  fis=new FileInputStream(source);
		 wb=new XSSFWorkbook(fis);	
		 sheet=wb.getSheetAt(sheetnumber);
	} 
	 catch (Exception e)
	{
		System.out.println("Exception is generated in the program===>>>"+e.getMessage());
		
	}
	 	
}
 public void WRITE_IN_EXCEL(int row,int col,String result) 
 {	
	 
	try
	{
		sheet.getRow(row).createCell(col).setCellValue(result);
		out=new FileOutputStream(source);
		wb.write(out);
		System.out.println("Result written on Excelfile as a==>>"+result);
		
	} 
	catch (Exception e) 
	{
		System.out.println("Exception Generated In the Project====>>>"+e.getMessage());
	} 
		 	
}

 
 
}
