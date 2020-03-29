package Util;
import java.io.FileInputStream;
import java.util.Properties;
public class Utility extends TestBase {

// if you do not want static method then you need to ini these files in test base class like  below & 
	//load file on test base page
	//	public static Properties config = new Properties(); // reading property file
	//public static Properties OR = new Properties();
	
	
	
	public static Object fetchpropertyvalue(String key) throws Exception
	{
		//System.out.println("inside fetchpropertyvalue method");
		FileInputStream file =new FileInputStream("./Config/Config.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key);
	}
	
	public static String fetchlocatorvalue(String key) throws Exception
	{
		FileInputStream file =new FileInputStream("./Config/Elements.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key).toString();
	}
	
	
}
