package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CategoriesPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.ProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@Test
public class SimpleTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private DashBoardPOM dashBoardPOM; 
	private CategoriesPOM categoriesPOM;
	private ProductsPOM productsPOM;
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
		dashBoardPOM = new DashBoardPOM(driver); 
		categoriesPOM = new CategoriesPOM(driver);
		productsPOM = new ProductsPOM(driver);
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
	public void simpleTestCaseRTTC_013Test() {
		try {
		dashBoardPOM.sendUserName("admin");
		dashBoardPOM.sendPassword("admin@123");
		dashBoardPOM.clickLoginBtn(); 
		dashBoardPOM.clickCatlogBtn();
		dashBoardPOM.clickCategoriesBtn();
		categoriesPOM.clickIndianBtn();
		categoriesPOM.clickDeleteBtn();
		boolean isDeleted = categoriesPOM.isDeleted();
		Assert.assertTrue(isDeleted);
		screenShot.captureScreenShot("RTTC_013");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Test case - 2: delete Ear rings from categories
	@Test
	public void simpleTestCaseRTTC_015Test() {
		try {
		dashBoardPOM.sendUserName("admin");
		dashBoardPOM.sendPassword("admin@123");
		dashBoardPOM.clickLoginBtn(); 
		dashBoardPOM.clickCatlogBtn(); 
		dashBoardPOM.clickCategoriesBtn();
		categoriesPOM.clickEarringsBtn();
		categoriesPOM.clickDeleteBtn();
		boolean isDeleted = categoriesPOM.isDeleted();
		Assert.assertTrue(isDeleted);
		screenShot.captureScreenShot("RTTC_015");
	} catch(Exception e) {
		e.printStackTrace();
	}
}

	//test case - 3: Filter product name and price in Products 
	@Test
	public void simpleTestCaseRTTC_014Test() {
		try {
		dashBoardPOM.sendUserName("admin");
		dashBoardPOM.sendPassword("admin@123");
		dashBoardPOM.clickLoginBtn(); 
		dashBoardPOM.clickCatlogBtn();
		dashBoardPOM.clickProductsBtn();
		productsPOM.sendProductName("Integer vitae iaculis massa");
		productsPOM.clickFilterBtn();
		productsPOM.sendProductPrice("515");
		productsPOM.clickFilterBtn();
		boolean isFiltered = productsPOM.isFiltered();
		Assert.assertTrue(isFiltered);
		screenShot.captureScreenShot("RTTC_014");
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
}

