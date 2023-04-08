package org.com.appium.android;

import java.util.List;

import org.com.appium.android.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public 		class 		ProductsPageElements 		extends 		AndroidActions {
	
	private AndroidDriver driver;
	
	public ProductsPageElements(AndroidDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
	}
	
	

@FindBy(id="com.androidsample.generalstore:id/productAddCart")
	List<WebElement> productAddCartbtn;


@FindBy(id="com.androidsample.generalstore:id/productName")
List<WebElement> productNameCount;
	
@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
 WebElement  CartIcon;

 

	public void select_product( ) throws InterruptedException
	
	{  Thread.sleep(2000);
		int count = productNameCount.size();


		 for(int i=0;i<count;i++)
			 
		 { 
				 productAddCartbtn.get(i).click();
				 Thread.sleep(2000);
		 }
		
		
	}
	public CartPageElements 		Click_Cart_Btn(AndroidDriver driver  )
	{	 
		CartIcon.click();
		return new CartPageElements(driver); 
	 
		
	}
	 
	
}
