package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class OrdersPOM {
		private WebDriver driver; 
		private GenericMethods genericMethods;
		public OrdersPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//td[text()='Brunda KJ']/following-sibling::td//i[@class='fa fa-eye']")
		private WebElement vieworder;	
		public void clickVieworderBtn() {
			this.vieworder.click();
		}
		@FindBy(xpath="//td[text()='Brunda KJ']/following-sibling::td//i[@class='fa fa-pencil']")
		private WebElement editorder;
		public void clickEditorderBtn() {
			this.editorder.click();
		}
		@FindBy(id="button-customer")
		private WebElement continueCustomer;
		//genericMethods = new GenericMethods(driver);
		//genericMethods.scrollToView(continue1);
		public void clickContinuecustomerBtn() {
			genericMethods = new GenericMethods(driver);
			genericMethods.scrollToView(this.continueCustomer);
			this.continueCustomer.click();
		}
		@FindBy(xpath="//*[@id=\"button-invoice\"]")
		private WebElement generateInvoice;	
		public void clickGenerateinvoiceBtn() {
			this.generateInvoice.click();
		}
		@FindBy(id="cart")
		private WebElement remove;	
		public void clickRemoveBtn() {
			this.remove.click();
		}
		
		@FindBy(xpath="//*[@id=\"button-product-add\"]")
		private WebElement addproduct;	
		public void clickAddproductBtn() {
		this.addproduct.click();	
		}
		@FindBy(xpath="//*[@id=\"button-cart\"]")
		private WebElement continueCart;
		public void clickContinuecartBtn() {
			this.continueCart.click();
		}
		@FindBy(xpath="//*[@id=\"button-payment-address\"]")
		private WebElement continueAddress;
		public void clickContinueaddressBtn() {
			this.continueAddress.click();
		}
		@FindBy(xpath="//*[@id=\"button-save\"]")
		private WebElement save;
		public void clcikSaveBtn() {
			this.save.click();
		}
		@FindBy(id="input-product")
		private WebElement chooseProduct; 	
		public void sendChooseproduct(String chooseProduct) {
			this.chooseProduct.sendKeys(chooseProduct);
		}
		@FindBy(id="input-quantity")
		private WebElement quantity; 	
		public void sendQuantity(String quantity) {
			this.quantity.clear();
			this.quantity.sendKeys(quantity);
		}
		public boolean isGenerated() {
			boolean isGenerated = true;
			try {
				driver.switchTo().alert().accept();
				isGenerated = false;
			}catch(Exception e) {
				isGenerated=true;
				e.printStackTrace();
			}
			return isGenerated;
			
		}
//		
//		public boolean isModified() {
//			boolean isModified = false;
//			try {
//				//driver.switchTo().alert().accept();
//				isModified = true;
//			}catch(Exception e) {
//				isModified=false;
//				e.printStackTrace();
//			}
//			return isModified;
//			
//		}
}
