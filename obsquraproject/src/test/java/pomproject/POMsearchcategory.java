package pomproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMsearchcategory {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMsearchcategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}
	@FindBy(xpath = "//*[@id=\"category_table_filter\"]/label/input")
	public WebElement searchcategory;
	public void usernameSendKeys(String xyz) {

		action.sendkeys(searchcategory, xyz);

	}
	public String getTablevalue(String readConfigFile) {
		WebElement tabledata=driver.findElement(By.xpath("//table[@id='category_table']//tbody/tr[1]/td[1]"));// TODO Auto-generated method stub
		String data=tabledata.getText();
		return data;	// TODO Auto-generated method stub
		
	}
	
	
	
}

