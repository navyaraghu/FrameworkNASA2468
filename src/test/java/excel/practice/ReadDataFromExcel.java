package excel.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException 
	{
		//Step1: convert physical file to java readable object
		FileInputStream fis=new FileInputStream("./src/test/java/resources/TestScript.xlsx");
		
		//Step 2: open the excel workbook
		//import workbook from org.apache.poi.ss.usermodel
		//the below statements throws encrypttedDocumentException and IOException
		Workbook wb=WorkbookFactory.create(fis);
		
		//step 3: get control over particular sheet
		Sheet s=wb.getSheet("Sheet1");
		
		//Step 4: get control over specific row
		Row r=s.getRow(0);
		
		//step 5: get control over cell
		Cell c=r.getCell(1);
		
		//step 6: Fetch data from cell
		System.out.println(c.getStringCellValue());
		
		//step 7: close workbook
		
		wb.close();

	}

}
