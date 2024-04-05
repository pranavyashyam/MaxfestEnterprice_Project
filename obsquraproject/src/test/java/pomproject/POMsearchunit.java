package pomproject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMsearchunit {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMsearchunit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}

	@FindBy(xpath = "//*[@id=\"unit_table_filter\"]/label/input")
	public WebElement SearchUnit;

	public void usernameSendKeys(String value) {

		action.sendkeys(SearchUnit, value);

	}

	public String getTablevalue(String readConfigFile) {
		WebElement tabledata=driver.findElement(By.xpath("//table[@id='unit_table']//tbody/tr[1]/td[1]"));// TODO Auto-generated method stub
		String data=tabledata.getText();
		return data;
	}

}
