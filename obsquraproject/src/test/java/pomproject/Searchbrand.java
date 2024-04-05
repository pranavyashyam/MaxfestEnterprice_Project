package pomproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class Searchbrand {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public Searchbrand(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}
	@FindBy(xpath = "//*[@id=\"brands_table_filter\"]/label/input")
	public WebElement searchbrands;
	public void usernameSendKeys(String value) {

		action.sendkeys(searchbrands,value);

	}
	
	
	
	
	
	
}
