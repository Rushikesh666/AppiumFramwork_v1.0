package org.com.appium.android;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.com.appium.android.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageElements extends AndroidActions   {
	
	 
	
 	AndroidDriver driver;
	public HomePageElements(AndroidDriver driver)
	{
 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	
	}
	
 
		 /*-----------------------------------------------------------------------------------------------------------------------------*/

	  @FindBy(id = "com.androidsample.generalstore:id/nameField") 
	  private  WebElement Name_text;
	  
	
	 public void InsertName(String name) 
	
	 {
		
	 Name_text.sendKeys(name);
		
	 }
	 
	 /*-----------------------------------------------------------------------------------------------------------------------------*/
	 
	  @FindBy(id = "com.androidsample.generalstore:id/radioFemale") 
	  private  WebElement radio_btn_female;
	 
	  
	  @FindBy(id = "com.androidsample.generalstore:id/radiomale") 
	  private  WebElement radio_btn_male;
	 
	 public void SelectGender(String gender ) 
	 {
		
		
		if( gender.contains("female"))
		{
			radio_btn_female.click();
			
		}
	 }

	 
	 /*-----------------------------------------------------------------------------------------------------------------------------*/
	  
	  @FindBy(id = "com.androidsample.generalstore:id/btnLetsShop") 
	  private  WebElement btnLetsShop;
	  
	 
	 public ProductsPageElements Click_LetsShop_Button( ) 
	 {
		
		 btnLetsShop.click();
	//	 Products_Page_Elements 		Products_Page_Elements = new Products_Page_Elements(driver);
		 return 	 new ProductsPageElements(driver);  
		 
		
	 }
	
	 
	 /*-----------------------------------------------------------------------------------------------------------------------------*/
	 
	  @FindBy(id = "com.androidsample.generalstore:id/spinnerCountry") 
	  private  WebElement dropdown;
	
	  
	  
 
	  
	  public void dropdownclick( )
		 {
			 
		  dropdown.click();
			  

		 }
	  
	  
	  
	  
	  public void SelectCountry(String country_text )
	 {		dropdownclick();
		  scrolltilltext( country_text);
		 
	//	  driver.findElement(AppiumBy.xpath("")).click();  //android.widget.TextView[@text='country_text']
			
	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+country_text+"']")).click();
		 
	 }

 

 
	 
	 
	 
}
