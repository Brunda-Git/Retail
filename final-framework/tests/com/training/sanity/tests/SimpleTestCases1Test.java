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

public class SimpleTestCases1Test {

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

	@Test
	public void SimpleTestCases1Test() {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		screenShot.captureScreenShot("First");
		homePagePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Second");
		homePagePOM.clickcatLogBtn();
		screenShot.captureScreenShot("Third");
		homePagePOM.clickcategoriesBtn();
		screenShot.captureScreenShot("Forth");
		homePagePOM.clickearringsBtn();
		screenShot.captureScreenShot("Fifth");
		homePagePOM.clickdeleteBtn();
		screenShot.captureScreenShot("Sixth");

	}
}