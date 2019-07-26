package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	private WebDriver driver; 
	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-username")
	private WebElement userName; 	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	@FindBy(id="input-password")
	private WebElement password;	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	@FindBy(xpath="//form/div/button[@class='btn btn-primary']")
	private WebElement loginBtn;	
	public void clickLoginBtn() {
		this.loginBtn.click();
	}	
	@FindBy(xpath="//li[@id='menu-catalog']")
	private WebElement catLog;	
	public void clickCatlogBtn() {
		this.catLog.click(); 
	}	
	@FindBy(xpath="//li[@id='menu-catalog']/ul/li/a[text()='Products']")
	private WebElement products;	
	public void clickProductsBtn() {
		this.products.click();
	}
	@FindBy(xpath="//li[@id='menu-catalog']/ul/li/a[text()='Categories']")
	private WebElement categories;	
	public void clickCategoriesBtn() {
		this.categories.click();
	}	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement productName; 	
	public void sendProductName(String productName) {
		this.productName.sendKeys(productName);
	}	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement productPrice;	
	public void sendProductPrice(String productPrice) {
		this.productPrice.sendKeys(productPrice);
	}	
	@FindBy(xpath="//tr/td[contains(text(),'INDIAN')]/parent::tr/td/input")
	private WebElement indian;	
	public void clickIndianBtn() {
		this.indian.click();
	}	
	@FindBy(xpath="//tr/td[contains(text(),'Ear rings')]/parent::tr/td/input")
	private WebElement earrings;	
	public void clickEarringsBtn() {
		this.earrings.click();
	}	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter;	
	public void clickFilterBtn() {
		this.filter.click();
	}	
	@FindBy(xpath="//div/button/i[@class='fa fa-trash-o']")
	private WebElement delete;	
	public void clickDeleteBtn() {
		this.delete.click();

		driver.switchTo().alert().accept();	
	}	 
}


