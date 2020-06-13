package files;

import java.beans.FeatureDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfile {	
	public static void main(String[] args) throws IOException {
		Propertyfile obj=new Propertyfile();
		System.out.println(obj.fetchpropvaluemethod("name"));
		System.out.println(obj.fetchpropvaluemethod("url"));
		System.out.println(System.getProperty("user.dir"));
	}
	
	public Object fetchpropvaluemethod(String key) throws IOException
	{
//FileInputStream file=new FileInputStream("E:\\2 Selenium\\Z Eclipse new Java\\JAVA OOPS Concept\\src\\config_files\\config1.properties");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\config_files\\config1.properties");
// benifit of user.dir= if migrating this code to another system then some one else use this code then 
//System.getProperty("user.dir") will give you the current location of your propeject 
		Properties prop=new Properties();
		prop.load(file);
//		System.out.println(prop.getProperty("url"));
//		System.out.println(prop.getProperty("name"));
		return prop.getProperty(key);
	}

}
