package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPOM {
	private WebDriver driver; 
	public DashBoardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-username")
	private WebElement userName; 	
	public void sendUserName(String userName) {
		this.userName.sendKeys(userName);
	}
	@FindBy(id="input-password")
	private WebElement password;	
	public void sendPassword(String password) { 
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
	@FindBy(xpath="//li[@id='menu-catalog']/ul/li/a[text()='Categories']")
	private WebElement categories;	
	public void clickCategoriesBtn() {
		this.categories.click();
	}
	@FindBy(xpath="//li[@id='menu-catalog']/ul/li/a[text()='Products']")
	private WebElement products;	
	public void clickProductsBtn() {
		this.products.click();
	}
	@FindBy(xpath="//li[@id='menu-sale']")
	private WebElement sales;	
	public void clickSalesBtn() {
		this.sales.click(); 
	}	
	@FindBy(xpath="//li[@id='menu-sale']/ul/li/a[text()='Orders']")
	private WebElement orders;
	public void clickordersBtn() {
		this.orders.click();
	}
}
