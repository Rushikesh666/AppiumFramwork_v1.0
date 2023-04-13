package org.com.appium.android;

import java.util.List;

import org.com.appium.android.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPageElements extends 		AndroidActions {

	public CartPageElements(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	  @FindBy(id = "com.androidsample.generalstore:id/productName") 
	  private
	  List<WebElement> productName;
	  
	  
	  
		public void getproductPrice_Items() {

			System.out.println(productName.get(0).getText());

		}
	
	
	
	
	
	
	

}
