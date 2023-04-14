package org.com.appium.android;

import java.util.ArrayList;
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
	  
	  
	  
		public void getproductPrice_Items(List <String > AllproductsFromProductPAge) {
			List <String > AllproductsList=new ArrayList<>();
	
			
			

		 
			
			for(int i =0;	i<productName.size() 	; i++)
				
			{
				AllproductsList.add(  productName.get(i).getText());
				
				
				
			}
			
			
			
		for(int i =0;	i<AllproductsFromProductPAge.size() 	; i++)
				
			{
			 
			for(int j =0;	j<AllproductsList.size() 	; j++)
				
			{
		
	 
				if(AllproductsFromProductPAge.get(i).equals(AllproductsList.get(j)) )
				{
					System.out.println(" product  From Product PAge"+AllproductsFromProductPAge.get(i)+" Matches -->" +"product  From Cart PAge"+ AllproductsList.get(j));
					
				}
				
				
			}
			}
			
			
			 
		}
	
	
	
	
	
	
	

}
