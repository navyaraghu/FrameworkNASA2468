package propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/java/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		long time=Long.parseLong(p.getProperty("timeouts"));
		System.out.println(url+"\t"+time);

	}

}
