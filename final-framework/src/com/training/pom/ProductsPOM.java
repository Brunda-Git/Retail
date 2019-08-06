package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPOM {
	private WebDriver driver; 
	public ProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[contains(@id,'input-name')]")
	private WebElement productName; 	
	public void sendProductName(String productName) {
		this.productName.sendKeys(productName);
	}	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement productPrice;	
	public void sendProductPrice(String productPrice) {
		this.productPrice.sendKeys(productPrice);
	}	
	@FindBy(id="button-filter")
	private WebElement filter;	
	public void clickFilterBtn() {
		this.filter.click();
	}

	@FindBy(xpath="//div/a/i[@class='fa fa-plus']")	
	private WebElement addnewicon;
	public void clickAddnewiconBtn() {
		this.addnewicon.click();
	}

	@FindBy(xpath="//*[@id=\"input-name1\"]")
	private WebElement productName1; 	
	public void sendProductName1(String productName1) {
		this.productName1.sendKeys(productName1);
	}

	@FindBy(xpath="//*[@id=\"input-meta-title1\"]")
	private WebElement metaTagTitle; 	
	public void sendMetaTagTitle(String metaTagTitle) {
		this.metaTagTitle.sendKeys(metaTagTitle);
	}

	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
	private WebElement data;
	public void clickDataBtn() {
		this.data.click();
	}
	
	@FindBy(xpath="//*[@id=\"input-model\"]")
	private WebElement model;
	public void sendModel(String model) {
		this.model.sendKeys(model);
	}

	@FindBy(xpath="//*[@id=\"input-price\"]")
	private WebElement price;
	public void sendPrice(String price) {
		this.price.sendKeys(price);
	}

	@FindBy(xpath="//*[@id=\"input-quantity\"]")
	private WebElement quantity;
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}


	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
	private WebElement links;
	public void clickLinksBtn() {
		this.links.click();
	}

	@FindBy(xpath="//*[@id=\"input-category\"]")
	private WebElement categories;
	public void clickCategoriesBtn() {
		this.categories.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-product\"]/div/table/tbody/tr[1]/td[8]/a/i")
	private WebElement edit;
	public void clickEditBtn() {
		this.edit.click();
	}
	
	@FindBy(xpath="//div/button/i[@class='fa fa-save']")
	private WebElement save;
	public void clcikSaveBtn() {
		this.save.click();
	}
	
	public boolean isFiltered() {
		boolean isFiltered = true;
		try {
			driver.switchTo().alert().accept();
			isFiltered  = false;
		}catch(Exception e) {
			isFiltered=true;
			e.printStackTrace();
		}
		return isFiltered;
	}
	
	public boolean isSaved() {
		boolean isSaved = true;
		try {
			driver.switchTo().alert().accept();
			isSaved  = false;
		}catch(Exception e) {
			isSaved=true;
			e.printStackTrace();
		}
		return isSaved;
	}


}
