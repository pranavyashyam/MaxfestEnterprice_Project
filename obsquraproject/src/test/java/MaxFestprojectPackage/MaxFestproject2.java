package MaxFestprojectPackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import ExcelreadTestdata.TestdataExcel;
import Extendreports.ExtentTestManager;
import WaitUtility.WaitUtility;
import commonUtility.PropertyFileReader;
import pomproject.POMaddbrand;
import pomproject.POMaddcategory;
import pomproject.POMaddproduct;
import pomproject.POMaddunit;
import pomproject.POMalert;
import pomproject.POMsearchcategory;
import pomproject.POMsearchunit;
import pomproject.Pomlogin;
import pomproject.Searchbrand;
import webDriverUtilty.BrowserUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class MaxFestproject2 extends ExtentTestManager {
	public WebDriver driver;
	Pomlogin login;
	POMalert alert;
	POMaddunit unit;
	POMsearchunit search_unit;
	POMaddbrand brand;
	Searchbrand search_brand;
	POMaddcategory category;
	POMsearchcategory search_category;
	POMaddproduct add_pro;
	TestdataExcel objLogin;
	WaitUtility wait;
	PropertyFileReader objPropertyFileReader;
	@Test(priority = 1, dataProvider = "data-provider", groups = { "functional" }, enabled = true)

	public void Invalidlogin(String value, String value1) throws IOException, InterruptedException {

		wait = new WaitUtility(driver);
		login = new Pomlogin(driver);
		login.username(value);
		login.password(value1);
		login.clickInvalidLoginBtn();
		String expectedmsg = login.getinvalidMsg();
		String errormsg = "These credentials do not match our records.";
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(errormsg, expectedmsg);
		objassert.assertAll();
		System.out.println("expected msg and error msg are same");
		wait.Normalwait(2000);
		test.log(Status.PASS, "Test to validate invalid login ");

	}

	@Test(priority = 2, groups = { "functional" }, enabled = true)

	public void Login() throws IOException, InterruptedException {
		objLogin = new TestdataExcel();
		wait = new WaitUtility(driver);
        String usernme = TestdataExcel.readStringData(1, 0);
		String pswd = TestdataExcel.readIntegerData(1, 1);
		System.out.println(usernme);
		System.out.println(pswd);
		login = new Pomlogin(driver);
		login.username(usernme);
		login.password(pswd);
		wait.Normalwait(7000);
		login.clickLoginBtn();
		wait.Normalwait(9000);
		String urlActual = login.getUrl();
		System.out.println(urlActual);
		String urlExpected = "https://qalegend.com/billing/public/home";
		Assert.assertEquals(urlActual, urlExpected);
		System.out.println("Passed :login to actal url");
		login.Screenshot();
		test.log(Status.PASS, "Test to validate valid login");
	}

	@Test(priority = 3, groups = { "functional" })
	public void alerttour() throws InterruptedException {
		alert = new POMalert(driver);
		Thread.sleep(3000);
		alert.clickBtn();
		test.log(Status.PASS, "Test to validate alert button functionality");
	}
	@Test(priority = 4, enabled = false, groups = { "functional" })
	public void clickBrand() throws InterruptedException, IOException {
		objPropertyFileReader = new PropertyFileReader();
		wait = new WaitUtility(driver);
		brand = new POMaddbrand(driver);
		brand.clickbrand();
		brand.clickbrand1();
		wait.Normalwait(2000);
		brand.brandName(objPropertyFileReader.readConfigFile("brand_data"));
		brand.brandDesc(objPropertyFileReader.readConfigFile("brand_Desc"));
		brand.brandSave();
		test.log(Status.PASS, "Test to validate add brands ");
	}

	@Test(priority = 5, enabled = false, groups = { "functional" })
	public void SearchBrand() throws InterruptedException, IOException {
		objPropertyFileReader = new PropertyFileReader();
		wait = new WaitUtility(driver);
		search_brand = new Searchbrand(driver);
		wait.Normalwait(7000);
		search_brand.usernameSendKeys(objPropertyFileReader.readConfigFile("brand_data"));
		wait.Normalwait(7000);
		String brand_data = objPropertyFileReader.readConfigFile("brand_data");
		String data = brand.getTablevalue(objPropertyFileReader.readConfigFile("brand_data"));
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(brand_data, data);
		objassert.assertAll();
		System.out.println("brand data found");
		test.log(Status.PASS, "Test to search brands functionality");
	}

	@BeforeTest(alwaysRun=true) 
	   @Parameters({"Browser","Url"}) 
	   public void beforeTest(String Browser,String Url) { 
	  // String Browser = "Chrome"; 
	 		//String url = "https://selenium.qabible.in/index.php"; 
	 		//Prerequisites 
	 		BrowserUtility objutil = new BrowserUtility(); 
	 		objutil.launchBrowser(Browser, Url); 
	        driver =objutil.baseDriver(); 
	   } 
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		driver.close();
}
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "A23456" } };
	}

}
