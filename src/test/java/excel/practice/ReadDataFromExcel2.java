package excel.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/java/resources/TestScript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();//this method is use to get exact value what we saved in excel
		String data=wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		System.out.println(wb.getSheet("sheet1").getRow(3).getCell(0).getNumericCellValue());
		System.out.println(df.formatCellValue(wb.getSheet("sheet1").getRow(3).getCell(0)));
		//to get the exact value we 
		System.out.println(data);
		wb.close();

	}

}
