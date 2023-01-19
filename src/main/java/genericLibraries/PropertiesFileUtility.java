package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods related to actions performed properties file
 * @author DELL
 *
 */
public class PropertiesFileUtility {

	
	
	private Properties property;
	/**
	 * this method is used to initialize properties file
	 * @param path
	 * @return
	 */
	public void propertyFileInitialization(String path) 
	{
		FileInputStream fis=null;
		try {
		 fis=new FileInputStream(path);
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
			
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	/**
	 * this method is used to fetch the data from properties file
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key){
		return property.getProperty(key);
	}
	/**
	 * this method is used to change properties file
	 * @param value
	 * @param key
	 * @param path
	 * @param message 
	 */
	public void modifyPropertiesFile(String value, String key, String path, String message) {
		property.put(key, value);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			property.store(fos, message);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
