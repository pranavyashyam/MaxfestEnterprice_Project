package pomproject;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMaddunit {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMaddunit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}

	@FindBy(xpath = "//*[@id=\"tour_step5_menu\"]")
	public WebElement product;
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[8]/a/span")
	public WebElement unit;
	@FindBy(xpath = "//button[@class=\"btn btn-block btn-primary btn-modal\"]")
	public WebElement addunit;
	@FindBy(xpath = "//*[@id=\"actual_name\"]")
	public WebElement name;
	@FindBy(xpath = "//*[@id=\"short_name\"]")
	public WebElement shortname;
	@FindBy(xpath = "//*[@id=\"allow_decimal\"]")
	public WebElement dropdown;
	@FindBy(xpath = "//*[@id=\"unit_add_form\"]/div[3]/button[1]")
	public WebElement save;

/*	public void clickunit() {

		action.click(product);

	}*/

	public void clickBtn1() {
	  driver.get("https://qalegend.com/billing/public/units");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10000)); 
		wait.until(ExpectedConditions.elementToBeClickable(unit));
		action.click(unit);
		action.click(addunit);

	}
	public void clickBtn1_fix() {
		driver.get("https://qalegend.com/billing/public/units");
		/*try {
			driver.findElement(By.xpath("//button[@class=\\\"btn btn-block btn-primary btn-modal\\")).click();
		}catch(NoSuchElementException ex) {
			System.out.println("NoSuchElementException has been handled");
		}*/
		//action.click(unit);
		action.click(addunit);

	}

	

	public void usernameSendKeys(String value) {

		action.sendkeys(name, value);

	}

	public void usernameSendKeys1(String value) {

		action.sendkeys(shortname, value);

	}
	 public void unitSave() {
			// TODO Auto-generated method stub
			action.click(save);
		}

	public void DropdownselectByIndex(int value) {
		action.DropdownselectByIndex(dropdown, value);
	}

	public void Javascriptclick() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",product);
		
	}

}