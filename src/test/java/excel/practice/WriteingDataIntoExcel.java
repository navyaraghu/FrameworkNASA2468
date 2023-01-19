package excel.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteingDataIntoExcel {

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/java/resources/TestScript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row r=sh.getRow(3);
		Cell c=r.createCell(1);
		c.setCellValue("hi");
		
		//Saves data into excel file
		FileOutputStream fos= new FileOutputStream("./src/test/java/resources/TestScript.xlsx");
		wb.write(fos);
		wb.close();

	}

}
