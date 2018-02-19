package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xalan.xsltc.compiler.util.StringType;
public class ReadLibrary
{
 public static XSSFWorkbook wb;
 public static XSSFSheet sheet;
 public static  XSSFCell cell;
 public static String result;
 public ReadLibrary(String filepath) 
 {	
	 try 
	 {
		 
		 File source=new File(filepath); 
		 FileInputStream fis=new FileInputStream(source);
		 wb=new XSSFWorkbook(fis);	 
	} 
	 catch (Exception e)
	{
		System.out.println("Exception is generated in the program===>>>"+e.getMessage());
		
	}
	 	
}

 public static String setCellValue(int sheetnumber,int row,int column)
 {
		sheet=wb.getSheetAt(sheetnumber);
	
	if(sheet.getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
	{
		long i=(long)sheet.getRow(row).getCell(column).getNumericCellValue();
		//result=sheet.getRow(row).getCell(column).getStringCellValue();
		result=String.valueOf(i);
		
	}
	else if(sheet.getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_STRING)
	{
		 result=sheet.getRow(row).getCell(column).getStringCellValue();
		// System.out.println(result);
		
	}
	
	else if(sheet.getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_BLANK)
	{
		sheet.getRow(row).getCell(column).setCellValue("");
		 result=sheet.getRow(row).getCell(column).getStringCellValue();
		// System.out.println(result);
		
	}
	return result;
 }
 
}
