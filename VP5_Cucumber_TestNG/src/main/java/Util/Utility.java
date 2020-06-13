package Util;
import java.io.FileInputStream;
import java.util.Properties;
public class Utility extends TestBase {
//Letest VP 13 JUne 2020 2
// if you do not want static method then you need to ini these files in test base class like  below & 
	//load file on test base page
	//	public static Properties config = new Properties(); // reading property file
	//public static Properties OR = new Properties();
	
	
	
	public static Object fetchpropertyvalue(String key) throws Exception
	{
		//System.out.println("inside fetchpropertyvalue method");
		//FileInputStream class have a constructor which accept file path so hen we create a object of that class and 
		//pass the file path as premeter then constructor will run
	//	FileInputStream file =new FileInputStream("./Config/Config.properties");
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\Config\\Config.properties");

		//FileInputStream file=new FileInputStream("E:\\2 Selenium\\Z Eclipse new Java\\JAVA OOPS Concept\\src\\config_files\\config1.properties");
		//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\config_files\\config1.properties");
		// benifit of user.dir= if migrating this code to another system then some one else use thsi code then System.getProperty("user.dir") will give you the current location of your propeject 
		Properties property=new Properties();
		property.load(file);
		return property.get(key);
	}
	
	public static String fetchlocatorvalue(String key) throws Exception
	{
		//FileInputStream file =new FileInputStream("./Config/Elements.properties");
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\Config\\Elements.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key).toString();
	}
	
	
}
