package org.com.appium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileSystems;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.asynchttpclient.netty.channel.DefaultChannelPool.PoolLeaseStrategy;
import org.com.appium.android.CartPageElements;
import org.com.appium.android.HomePageElements;
import org.com.appium.android.ProductsPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;



public class HomePageTestCases extends Baseclass {

	
	

	
 
 @Test(dataProvider = "getdata")
public void Validate_Homepage_ToastText(HashMap<String,String> 	inputdata  ) throws InterruptedException, IOException {
	
		System.out.println("Validate_Homepage_ToastText() running");

	 
		Thread.sleep(3000);
	
	OnHomePage.	SelectCountry(inputdata.get("Country"));
  
	OnHomePage.	SelectGender(inputdata.get("Gender"));
	
	OnHomePage.Click_LetsShop_Button();
	Thread.sleep(1500);
	 
	String actualtoasttext= OnHomePage.GetToastText();
	 
 
 
	System.out.println("End");
}
	

 
	public void  EndtoEndHappyPathTest()   throws InterruptedException, IOException
	{
	    
 	HomePageElements OnHomePage  = new HomePageElements( super.driver);
		
		Thread.sleep(3000);
		
		OnHomePage.	SelectCountry("Algeria");
	 
		OnHomePage .InsertName("Rushi");
	 

		OnHomePage.	SelectGender("female");
			
 
		ProductsPageElements Products_Page=	OnHomePage. Click_LetsShop_Button();
 
		Products_Page.select_product( );
		 

 Thread.sleep(3000);


 
 CartPageElements cartPage =   Products_Page .Click_Cart_Btn(driver    );
 
	
 Thread.sleep(2000);  
	  
   cartPage.getCartItemsTotal();
	  
	 
 
 cartPage.Click_checkBox();
 Thread.sleep(5000);
 System.out.println("get ready");


  	

 cartPage.LongPress_btnProceed(5);
 Thread.sleep(5000);
	Set<String>erEs=	driver.getContextHandles();
 for (String t : erEs) {
	 System.out.println(t );
}
 Thread.sleep(2000);
 driver.context("WEBVIEW_com.androidsample.generalstore");
 Thread.sleep(2000);
 driver.get("https://www.youtube.com");
 Thread.sleep(2000);
 
 driver.context("NATIVE_APP");
 Thread.sleep(2000);
 cartPage.navigateBack();
 System.out.println("navigateBack" );
 Thread.sleep(2000);
 cartPage.navigateBack( );
 System.out.println("navigateBack2" );
	}

	 
	  
// @Test(dataProvider = "getdata")
	public void ValidateProductsPageToastText(HashMap<String,String> 	inputData) throws InterruptedException   

	{

			Thread.sleep(3000);
		 
 
		
		OnHomePage.	SelectCountry(inputData.get("Country"));
	 
		OnHomePage .	InsertName(inputData.get("Name"));
	 

		OnHomePage.	SelectGender(inputData.get("Gender"));
			
 
		ProductsPageElements Products_Page=	OnHomePage. Click_LetsShop_Button();
		Thread.sleep(3000);
		Products_Page.Click_Cart_Btn(driver);
 
		Products_Page.select_product();
		Thread.sleep(3000);
		CartPageElements CartPage =	Products_Page.Click_Cart_Btn(driver);
		Thread.sleep(3000);
		CartPage.getCartItemsTotal();
 
		Set<String> mycontexthandles=	driver.getContextHandles();
		
		for (String handle : mycontexthandles) 
		{
			System.out.println(handle);
		}
		CartPage.submitOrder();
		

		
		Thread.sleep(8000);
 
		 
 
		}
	 
	 
@BeforeMethod
 	public void loadSplashScreen() throws InterruptedException

 {
		
		Thread.sleep(3000);
		System.out.println("Loading Splash Screen/Activity");
			Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
			driver .startActivity(activity);
 

 }
	
	
	  @DataProvider 
	  
	  public Object[][] getdata() throws IOException 
	  {  
		  List<HashMap<String,String>>	data= getJsonData( FileSystems.getDefault().getPath("").toAbsolutePath()+ "//src//test//java//testData//HompageData.json"  );
		
		  return new Object [] [] { 	{	 data.get(0) }   } ; 
		  
	  }


 

}
