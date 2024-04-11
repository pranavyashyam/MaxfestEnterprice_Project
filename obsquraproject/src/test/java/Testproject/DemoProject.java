package Testproject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excelread.Excel;
import Extendreports.ExtentTestManager;
import commonUtility.PropertyFileReader;
import WaitUtility.WaitUtility;
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

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoProject extends ExtentTestManager {
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
	Excel objLogin;
	WaitUtility wait;
	PropertyFileReader objPropertyFileReader;

	private WebElement product;

	@Test(priority = 1, dataProvider = "data-provider", groups = { "functional" }, enabled = true)

	public void Invalidlogin(String value, String value1) throws IOException, InterruptedException {

		wait = new WaitUtility(driver);
		login = new Pomlogin(driver);
		login.username(value);
		login.password(value1);
		login.clickLoginBtn();
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
		objLogin = new Excel();
		wait = new WaitUtility(driver);
		
		String usernme = Excel.readStringData(1, 0);
		String pswd = Excel.readIntegerData(1, 1);
		System.out.println( usernme);
		System.out.println( pswd);
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
	public void alerttour() {
		alert = new POMalert(driver);
		alert.clickBtn();
		test.log(Status.PASS, "Test to validate alert button functionality");
	}

	@Test(priority = 4, enabled = true, groups = { "functional" })
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
	@Test(priority = 5, enabled = true, groups = { "functional" })
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

	@Test(priority = 6, enabled = true, groups = { "functional" })
	public void clickUnit() throws InterruptedException, IOException {
		objPropertyFileReader = new PropertyFileReader();
		wait = new WaitUtility(driver);
		unit = new POMaddunit(driver);
		unit.clickBtn1();
		wait.Normalwait(7000);
		unit.usernameSendKeys(objPropertyFileReader.readConfigFile("unit_data"));
		unit.usernameSendKeys1(objPropertyFileReader.readConfigFile("unit_Desc"));
		unit.DropdownselectByIndex(1);
		unit.unitSave();
		wait.Normalwait(3000);
		test.log(Status.PASS, "Test to validate add units functionality");
	}
	@Test(priority = 7, enabled = true, groups = { "functional" })
	public void SerachUnit() throws InterruptedException, IOException {
		objPropertyFileReader = new PropertyFileReader();
		wait = new WaitUtility(driver);
		search_unit = new POMsearchunit(driver);
		search_unit.usernameSendKeys(objPropertyFileReader.readConfigFile("unit_data"));
		wait.Normalwait(2000);
		String unit_data = objPropertyFileReader.readConfigFile("unit_data");
		String data = search_unit.getTablevalue(objPropertyFileReader.readConfigFile("unit_data"));
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(unit_data, data);
		objassert.assertAll();
		System.out.println(" unit data found");
		test.log(Status.PASS, "Test to validate search units functionality");
	}

	@Test(priority = 8, enabled = true, groups = { "functional" })
	public void clickCategories() throws InterruptedException, IOException {
		objPropertyFileReader = new PropertyFileReader();
		wait = new WaitUtility(driver);
		category = new POMaddcategory(driver);
		category.clickcategory();
		category.clickAddcategory();
		wait.Normalwait(2000);
		category.categoryName(objPropertyFileReader.readConfigFile("category_data"));
		category.categoryDesc(objPropertyFileReader.readConfigFile("category_Desc"));
		category.categorySave();
		wait.Normalwait(2000);
		test.log(Status.PASS, "Test to validate add category   functionality");

	}
	@Test(priority = 9, enabled = true, groups = { "functional" })
	public void SearchCategories() throws InterruptedException, IOException {
		objPropertyFileReader = new PropertyFileReader();
		wait = new WaitUtility(driver);
		search_category = new POMsearchcategory(driver);
		category.clickcategory();
		search_category.usernameSendKeys(objPropertyFileReader.readConfigFile("category_data"));
		wait.Normalwait(2000);
		String category_data = objPropertyFileReader.readConfigFile("category_data");
		String data = search_category.getTablevalue(objPropertyFileReader.readConfigFile("category_data"));
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(category_data, data);
		objassert.assertAll();
		System.out.println(" category data found");
		test.log(Status.PASS, "Test to validate search category  functionality");

	}

	@Test(priority = 10, enabled = true, groups = { "functional" })
	public void addproducts() throws InterruptedException, IOException {
		wait = new WaitUtility(driver);
		add_pro = new POMaddproduct(driver);
		// search_category=new POMsearchcategory(driver);
		wait.Normalwait(2000);
		add_pro.clickpro();
		add_pro.proName(objPropertyFileReader.readConfigFile("Product_data"));
		wait.Normalwait(2000);
		add_pro.DropdownselectByIndex(1);
		wait.Normalwait(2000);
		add_pro.DropdownselectByIndex(1);
		wait.Normalwait(2000);
		add_pro.DropdownselectByIndex(1);
		wait.Normalwait(2000);
		add_pro.proName1("2");
		wait.Normalwait(2000);
		add_pro.proName2("3");
		wait.Normalwait(2000);
		add_pro.proName3("3");
		wait.Normalwait(2000);
		add_pro.proName4("3");
		wait.Normalwait(2000);
		add_pro.DropdownselectByIndex(1);
		wait.Normalwait(2000);
		add_pro.clicksave();
		wait.Normalwait(2000);
		wait.Normalwait(2000);
		String addProduct_data = objPropertyFileReader.readConfigFile("addProduct_data");
		String data = add_pro.getValue("add product header found");
		SoftAssert objassert = new SoftAssert();
		objassert.assertEquals(addProduct_data, data);
		objassert.assertAll();
		System.out.println(" add product header found");
		test.log(Status.PASS, "Test to validate add products tab functionality");
	}

	@BeforeTest
	@Parameters({ "Browser", "Url" })
	public void beforeTest(String Browser, String Url) {
		BrowserUtility objutil = new BrowserUtility();
		objutil.launchBrowser(Browser, Url);
		driver = objutil.baseDriver();
		test = extent.createTest(" testcase for product creation ", "test to validate product");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "A23456" } };
	}

}