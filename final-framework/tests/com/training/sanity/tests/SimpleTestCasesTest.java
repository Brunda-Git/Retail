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
	@Test
	public void SimpleTestCasesTest() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickcatLogBtn();
		homePagePOM.clickcategoriesBtn();
		homePagePOM.clickindianBtn();
		homePagePOM.clickdeleteBtn();
		screenShot.captureScreenShot("First");
	}

	//Test case - 2: delete Ear rings from categories
	@Test
	public void SimpleTestCases1Test() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickcatLogBtn();
		homePagePOM.clickcategoriesBtn();
		homePagePOM.clickearringsBtn();
		homePagePOM.clickdeleteBtn();
		screenShot.captureScreenShot("Second");
	}

	//test case - 3: Filter product name and price in Products 
	@Test
	public void SimpleTestCases2Test() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickcatLogBtn();
		homePagePOM.clickproductsBtn();
		homePagePOM.sendProductName("Integer vitae iaculis massa");
		homePagePOM.clickfilterBtn();
		homePagePOM.sendProductPrice("515");
		homePagePOM.clickfilterBtn();
		screenShot.captureScreenShot("Third");
	}
}

