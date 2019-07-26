package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePagePOM = new HomePagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	//Test case 1 - delete INDIAN from categories
	@Test(priority=0)
	public void SimpleTestCasesTest1() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickCatlogBtn();
		homePagePOM.clickCategoriesBtn();
		homePagePOM.clickIndianBtn();
		homePagePOM.clickDeleteBtn();
		screenShot.captureScreenShot("First");
	}

	//Test case - 2: delete Ear rings from categories
	@Test(priority=1)
	public void SimpleTestCasesTest2() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickCatlogBtn(); 
		homePagePOM.clickCategoriesBtn();
		homePagePOM.clickEarringsBtn();
		homePagePOM.clickDeleteBtn();
		screenShot.captureScreenShot("Second");
	}

	//test case - 3: Filter product name and price in Products 
	@Test(priority=2)
	public void SimpleTestCasesTest3() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickCatlogBtn();
		homePagePOM.clickProductsBtn();
		homePagePOM.sendProductName("Integer vitae iaculis massa");
		homePagePOM.clickFilterBtn();
		homePagePOM.sendProductPrice("515");
		homePagePOM.clickFilterBtn();
		screenShot.captureScreenShot("Third");
	}
}

