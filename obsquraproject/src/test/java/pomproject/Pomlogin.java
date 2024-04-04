package pomproject;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

import commonUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class Pomlogin {

	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public Pomlogin(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}
	@FindBy(xpath = "//*[@id='username']")
	public WebElement username;
	@FindBy(xpath = "//*[@id='password']")
	public WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginbtn;

	public void clickLoginBtn() {

		action.click(loginbtn);

	}

	public void username(String Value) throws IOException {

		action.sendkeys(username, Value);

	}

	public void password(String Value) throws IOException {

		action.sendkeys(password, Value);

	}

	public String getinvalidMsg() {
		WebElement invalid = driver.findElement(By.xpath("//div[@class=\"form-group has-error\"]//span"));
		String message = invalid.getText();// TODO Auto-generated method stub
		return message;
	}



	public String getUrl() {
	
		String text = "https://qalegend.com/billing/public/home";
		return text;// TODO Auto-generated method stub
		
	}

	public void Screenshot() throws IOException {
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
  
 	               Files.copy(SrcFile, DestFile); // TODO Auto-generated method stub
		
	}

}