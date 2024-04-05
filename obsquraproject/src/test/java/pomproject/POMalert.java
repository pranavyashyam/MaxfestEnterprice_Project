package pomproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMalert {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMalert(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}
	@FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
	public WebElement Endtour;
	 
	 public void clickBtn() {
			
		 action.click(Endtour);
		
	}
	 
	} 
