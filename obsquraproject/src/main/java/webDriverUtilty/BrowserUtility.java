package webDriverUtilty;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class BrowserUtility {
	private  WebDriver driver;

	public void launchBrowser(String Browser,String url) {

		//String Browser = "Chrome";
		//String url = "https://selenium.qabible.in/index.php";
		switch (Browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);

	}

	public void closeBrowser() {
		driver.close();
	}

	public WebDriver baseDriver() {
		return this.driver;
	}
	 //screenshot// create a method in browser utility class
	public void Screenshot() throws IOException 
 	{ 
		Calendar cal=Calendar.getInstance();
		java.util.Date time=cal.getTime();
		String timestamp=time.toString().replace(":","" ).replace("","");
		System.out.println(time);
		System.out.println(timestamp);
		TakesScreenshot scrShot =((TakesScreenshot)driver); 
  
 	       //Call getScreenshotAs method to create image file 
  
 	               File SrcFile=scrShot.getScreenshotAs(OutputType.FILE); 
  
 	           //Move image file to new destination 
  
 	               File DestFile=new File("C:\\Users\\syamr\\OneDrive\\Desktop\\nandu\\selnium\\.metadata\\obsquraproject\\src\\main\\resources\\Screenshot\\test"+timestamp+".jpg"); 
  
 	               //Copy file at destination 
  
 	               Files.copy(SrcFile, DestFile); 
 	} 
 }


// public void launchBrowser(String Browser,String url) {
// "https://selenium.qabible.in/index.php"
// if(Browser.equals("Chrome"))
// WebDriver driver=null;

// }

