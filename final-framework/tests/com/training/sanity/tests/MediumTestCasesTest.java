package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CategoriesPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.OrdersPOM;
import com.training.pom.ProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private DashBoardPOM dashBoardPOM;  
	private CategoriesPOM categoriesPOM;
	private OrdersPOM ordersPOM;
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
		ordersPOM = new OrdersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	//Test case 1 - delete Ear rings and finger rings from categories
	@Test(enabled=false)
	public void mediumTestCasesRTTC_044Test() {
		try {
			dashBoardPOM.sendUserName("admin");
			dashBoardPOM.sendPassword("admin@123");
			dashBoardPOM.clickLoginBtn(); 
			//1. Click on Catelog icon
			dashBoardPOM.clickCatlogBtn(); 
			//2. Click on Products link, here we don't find item details in products link.. so I am choosing categories link
			dashBoardPOM.clickCategoriesBtn();
			//3. Click on Check box of the product to delete
			categoriesPOM.clickEarringsBtn();
			//4. Click on Check box of the product to delete
			categoriesPOM.clickFingerringsBtn();
			//5. Click on Delete Icon
			categoriesPOM.clickDeleteBtn();
			//6. click on Ok button of window
			boolean isDeleted = categoriesPOM.isDeleted();
			Assert.assertTrue(isDeleted);
			screenShot.captureScreenShot("RTTC_044 screenshot");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test	
	public void mediumTestCasesRTTC_045Test() {
		try {
			dashBoardPOM.sendUserName("admin");
			dashBoardPOM.sendPassword("admin@123");
			dashBoardPOM.clickLoginBtn();
			//1.click on sales icon
			dashBoardPOM.clickCatlogBtn();
			dashBoardPOM.clickSalesBtn();
			//2.click on orders link
			dashBoardPOM.clickordersBtn();
			//3. Click on View icon beside the ordered product
			ordersPOM.clickVieworderBtn();
			//4. click on Generate icon of invoice tab
			ordersPOM.clickGenerateinvoiceBtn();
			//Compare expected and actual results
			boolean isGenerated = ordersPOM.isGenerated();
			Assert.assertTrue(isGenerated);
			screenShot.captureScreenShot("RTTC_045 screenshot");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled=false)
	public void mediumTestCasesRTTC_043Test() {
		try {
			dashBoardPOM.sendUserName("admin");
			dashBoardPOM.sendPassword("admin@123");
			dashBoardPOM.clickLoginBtn();
			//1. click on Catelog icon
			dashBoardPOM.clickCatlogBtn();
			//2. Click on products link
			dashBoardPOM.clickProductsBtn();
			//3. Click on Edit icon of the product
		    productsPOM.clickEditBtn();
		    //4. Click on Data tab
		    productsPOM.clickDataBtn();
            //5. Clear data from Quantity textbox
			//7. Enter valid credentials in Quantity textbox
			productsPOM.sendQuantity("45");
			//7. Keep default values in Links, Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab
			//11. Click on Save button
			productsPOM.clcikSaveBtn();
			boolean isSaved = productsPOM.isSaved();
			Assert.assertTrue(isSaved);
			screenShot.captureScreenShot("RTTC_043 screenshot");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//This Test Case is not assigned to me, but I have automated this for my practi
	@Test(enabled=false)
	public void mediumTestCasesRTTC_046Test() {
		try {
			dashBoardPOM.sendUserName("admin");
			dashBoardPOM.sendPassword("admin@123");
			dashBoardPOM.clickLoginBtn();
			//1. click on Sales icon
			dashBoardPOM.clickCatlogBtn();
			dashBoardPOM.clickSalesBtn();
			//2. Click on Orders link
			dashBoardPOM.clickordersBtn();
			//3. Click on Edit icon of the order placed by the customer
			ordersPOM.clickEditorderBtn();
			//4. Click on Continue button
			//genericMethods.switchToView(driver);
			ordersPOM.clickContinuecustomerBtn();
			//5. click on Remove icon beside the product placed
			ordersPOM.clickRemoveBtn();
			//6. Enter valid credentials in Choose Product textbox
			ordersPOM.sendChooseproduct("Lorem ipsum dolor sit amet");
			//7. Enter valid credentials in Quantity textbox
			ordersPOM.sendQuantity("2");
			//8. Click on Add product button
			ordersPOM.clickAddproductBtn();
			//9. click on continue button
			ordersPOM.clickContinuecartBtn();
			//10. click on continue button
			ordersPOM.clickContinueaddressBtn();
			//11. Click on Save button
			ordersPOM.clcikSaveBtn();
			boolean isSaved = productsPOM.isSaved();
			Assert.assertTrue(isSaved);
			screenShot.captureScreenShot("RTTC_046 screenshot");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}