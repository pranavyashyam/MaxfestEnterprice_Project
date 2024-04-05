package pomproject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMaddbrand {
	static WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMaddbrand(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[10]/a/span")
	public WebElement brands;
	@FindBy(xpath = "//button[@class=\"btn btn-block btn-primary btn-modal\"]")
	public WebElement addbrands;
	@FindBy(xpath = "//*[@id=\"name\"]")
	public WebElement brandname;
	@FindBy(xpath = "//*[@id=\"description\"]")
	public WebElement branddesc;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement brandsave;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[1]")
	public WebElement brandUiHeader;
	
	
	

	public void clickbrand() {
		// TODO Auto-generated method stub

		action.click(brands);	
	}
	
	 public void brandName(String Value)throws IOException   {
		 
		 
			action.sendkeys(brandname, Value);
			
	}
	 public void brandDesc(String Value)throws IOException   {
		 
		 
			action.sendkeys(branddesc, Value);
			
	}
	public void clickbrand1() {
		// TODO Auto-generated method stub
		action.click(addbrands);
	}
	public void brandSave() {
		// TODO Auto-generated method stub
		action.click(brandsave);
	}
	public static String getbrandName() {
		WebElement Bname = driver.findElement(By.xpath("//input[@name=\"_token\"]//following::input[1]"));
		String message = Bname.getText();// TODO Auto-generated method stub
		return message;
	}

	public String getTablevalue(String readConfigFile) {
		WebElement tabledata=driver.findElement(By.xpath("//table[@id='brands_table']//tbody/tr[1]/td[1]"));// TODO Auto-generated method stub
		String data=tabledata.getText();
		return data;// TODO Auto-generated method stub
		
	}

	
	

	
}
