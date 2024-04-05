package pomproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMaddcategory {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMaddcategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[9]/a")
	public WebElement categories;
	@FindBy(xpath = "//button[@class=\"btn btn-block btn-primary btn-modal\"]")
	public WebElement addcategory;
	@FindBy(xpath = "//*[@id=\"name\"]")
	public WebElement categoryname;
	@FindBy(xpath = "//*[@id=\"short_code\"]")
	public WebElement categorycode;
	@FindBy(xpath = "//*[@id=\"category_add_form\"]/div[3]/button[1]")
	public WebElement categorysave;
	
	public void clickcategory() {
		// TODO Auto-generated method stub

		action.click(categories);	
	}
	public void clickAddcategory() {
		// TODO Auto-generated method stub

		action.click(addcategory);	
	}
	
	 public void categoryName(String Value)throws IOException   {
		 
		 
			action.sendkeys(categoryname, Value);
			
	}
	 public void categoryDesc(String Value)throws IOException   {
		 
		 
			action.sendkeys(categorycode, Value);
			
	}
	 public void categorySave() {
			// TODO Auto-generated method stub
			action.click(categorysave);
		}

	
}
