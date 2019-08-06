package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class CategoriesPOM {
	private WebDriver driver; 
	private GenericMethods genericMethods;
	public CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
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
	@FindBy(xpath="//tr/td[contains(text(),'Finger Rings')]/parent::tr/td/input")
	private WebElement fingerrings;	
	public void clickFingerringsBtn() {
		/*
		 * genericMethods = new GenericMethods(driver);
		 * genericMethods.jsClick(this.fingerrings);
		 */
		this.fingerrings.click();
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
	}
	
	
	public boolean isDeleted() {
		boolean isDeleted = false;
		try {
			driver.switchTo().alert().accept();
			isDeleted = true;
		}catch(Exception e) {
			isDeleted=false;
			e.printStackTrace();
		}
		return isDeleted;
	}
}
