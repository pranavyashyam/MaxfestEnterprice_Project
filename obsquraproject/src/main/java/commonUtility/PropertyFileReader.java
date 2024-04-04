package commonUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	static String configpath="\\src\\main\\resources\\configs\\config.properties";
	public static void main(String args[]) {
		readConfigFile("actual_data");
	}

	public static String readConfigFile(String propertyvalue) {
		
		Properties prop = new Properties();	
		try
		
		{
			String projectpath=System.getProperty("user.dir");
			
		FileInputStream input=new FileInputStream(projectpath+configpath);
		prop.load(input);
	
		//System.out.println(prop.getProperty("actual_data"));
		
		}catch (IOException e) {
		
			
			e.printStackTrace();
		}
		return prop.getProperty(propertyvalue);
}}