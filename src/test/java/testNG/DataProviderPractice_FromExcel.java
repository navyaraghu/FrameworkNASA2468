package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice_FromExcel 
{

@Test(dataProvider="getData")
public void dataProvider(String username, String password)
{
		System.out.println("name= "+username+" password= "+password);
}
@DataProvider
public Object[][] getData() {
Object[][] obj=new Object[3][2];
FileInputStream fis=null;
DataFormatter df=null;
Workbook wb=null;
try {
	 fis=new FileInputStream("./src/test/java/resources/dataprovider.xlsx");
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	 wb=WorkbookFactory.create(fis);
} catch (EncryptedDocumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Sheet s=wb.getSheet("sheet1");
df=new DataFormatter();
for (int i = 0; i <=2; i++) 
{
	for (int j = 0; j <=1; j++) 
	{
		obj[i][j]=df.formatCellValue(s.getRow(i).getCell(j));
	}
}
try {
	wb.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return obj;

	
}

}

