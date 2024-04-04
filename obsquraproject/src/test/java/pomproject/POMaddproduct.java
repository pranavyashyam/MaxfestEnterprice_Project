package pomproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.WaitUtility;
import webDriverUtilty.DriverAction;

public class POMaddproduct {
	WebDriver driver;
	WaitUtility wait;
	DriverAction action;

	public POMaddproduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverAction(driver);
	}

	@FindBy(xpath = "//a[@id=\"tour_step5_menu\"]//following::a[2]")
	
	public WebElement addProduct;
	@FindBy(xpath = "//input[@name=\"_token\"]//following::input[1]")
	public WebElement Productname;
	@FindBy(xpath = "//select[@name=\"unit_id\"]")
	public WebElement unitselect;
	@FindBy(xpath = "//select[@name=\"barcode_type\"]")
	public WebElement barcodetype;
	@FindBy(xpath = "//*[@id=\"alert_quantity\"]")
	public WebElement alertqty;
	@FindBy(xpath = "//*[@id=\"type\"]")
	public WebElement producttype;
	@FindBy(xpath = "//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
	public WebElement productsave;
	@FindBy (xpath="//*[@id=\"single_dpp\"]")
	public WebElement exctax;
	@FindBy (xpath="//*[@id=\"single_dpp_inc_tax\"]")
	public WebElement inctax;
	@FindBy (xpath="//*[@id=\"expiry_period\"]")
	public WebElement expires;
	@FindBy (xpath="//*[@id=\"expiry_period_type\"]")
	public WebElement expiresdropdown;

	public void clickpro() {
		// TODO Auto-generated method stub
		 driver.get("https://qalegend.com/billing/public/products/create");
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10000)); 
			wait.until(ExpectedConditions.elementToBeClickable(addProduct));
		action.click(addProduct);
	}
	
	public void proName(String Value) throws IOException {

		action.sendkeys(Productname, Value);

	}
	public void proName1(String Value) throws IOException {

		action.sendkeys(alertqty, Value);

	}
	public void proName2(String Value) throws IOException {

		action.sendkeys(exctax, Value);

	}
	public void proName3(String Value) throws IOException {

		action.sendkeys(inctax, Value);

	}
	public void proName4(String Value) throws IOException {

		action.sendkeys(expires, Value);

	}
	public void DropdownselectByIndex0(int value) {
		action.DropdownselectByIndex(expiresdropdown, value);
	}
	public void DropdownselectByIndex(int value) {
		action.DropdownselectByIndex(unitselect, value);
	}
	public void DropdownselectByIndex1(int value) {
		action.DropdownselectByIndex(barcodetype, value);
	}
	
	public void DropdownselectByIndex111(int value) {
		action.DropdownselectByIndex(producttype, value);
	}
	public void clicksave() {
		action.click(productsave);
	}

	public String getValue(String readConfigFile) {
		WebElement header=driver.findElement(By.xpath("/html/body/div[2]/div[1]/section[1]/h1/small"));// TODO Auto-generated method stub
		String data=header.getText();
		return data;	// TODO Auto-generated method stub
		
	}
	}

