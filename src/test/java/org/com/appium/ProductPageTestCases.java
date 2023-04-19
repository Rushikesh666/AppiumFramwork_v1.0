package org.com.appium;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.com.appium.android.CartPageElements;
import org.com.appium.android.HomePageElements;
import org.com.appium.android.ProductsPageElements;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

import org.testng.annotations.Test;

public class ProductPageTestCases  extends Baseclass {

	/*      'Product Page Test Cases Class' contains all Homepage related  Test Cases only 	*/
	
	@Test (dataProvider = "getProductPageData",priority = 2)
	public void ValidateUserIsOnProductPage(HashMap<String,String> 	inputdata  ) throws InterruptedException, IOException {
		Thread.sleep(4000);
		OnHomePage.InsertName(inputdata.get("Name"));
	
		OnHomePage.	SelectCountry(inputdata.get("Country"));
  
		OnHomePage.	SelectGender(inputdata.get("Gender"));
	
		ProductsPageElements productPage = OnHomePage.Click_LetsShop_Button();
	
	Thread.sleep(1500);
	
 
				String ActualProductPageTitle	=	productPage.getProductPageTitle();
							
					String ExpectedProductPageTitle	= inputdata.get("ExpectedProductPageTitle") ;
		
						Assert.assertEquals(ActualProductPageTitle, ExpectedProductPageTitle);
					  
							System.out.println(ActualProductPageTitle+" is displayed as Actual Text");
				
								System.out.println("Test Case Passed..! Validated User Is On Product Page as ActualProductPageTitle matches with ExpectedProductPageTitle	");
								System.out.println("priority = 2");
}
	

 
	public void  EndtoEndHappyPathTest(HashMap<String,String> 	inputdata )   throws InterruptedException, IOException
	{
	    
 	HomePageElements OnHomePage  = new HomePageElements( super.driver); 
		
		Thread.sleep(3000);
		
 
	 
		OnHomePage .InsertName("Rushi");
	 

		OnHomePage.	SelectCountry(inputdata.get("Country"));
		  
		OnHomePage.	SelectGender(inputdata.get("Gender"));
			
 
		ProductsPageElements Products_Page=	OnHomePage. Click_LetsShop_Button();
 
		
		
	
 Thread.sleep(5000);

  List <String >addProductToCart= Products_Page.addProductToCart();
 
 CartPageElements cartpage=  Products_Page .Click_Cart_Btn(       );
 
   Thread.sleep(4000); 
 
   
   Thread.sleep(4000); 
   cartpage.getproductPrice_Items(addProductToCart  );
   
   
   
   
   
 
/*
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
	 
	 
	 
	 
	 
	 
	 */
 
 
  	

	}

	 
	  

 @Test (dataProvider = "getProductPageData",priority = 1)
	public void ValidateAddToCartFunctionality(HashMap<String,String> 	inputdata  ) throws InterruptedException, IOException {
		 
		/* Validate Add To Cart Functionality works as expected  */
		Thread.sleep(4000);
		
		OnHomePage.InsertName(inputdata.get("Name"));
	
		OnHomePage.	SelectCountry(inputdata.get("Country"));
  
		OnHomePage.	SelectGender(inputdata.get("Gender"));
	
		ProductsPageElements productPage = OnHomePage.Click_LetsShop_Button();
	
	Thread.sleep(1500);
	
 
 
	productPage.addProductToCart();		
								
	System.out.println("priority =1");				
								
 
}
	
	 
 @Test(dataProvider = "getProductPageData",priority = 0)
public void ValidateUserNavigatetoCartPage(HashMap<String,String> 	inputdata ) throws InterruptedException
{
	Thread.sleep(4000);
	
	OnHomePage.InsertName(inputdata.get("Name"));

	OnHomePage.	SelectCountry(inputdata.get("Country"));

	OnHomePage.	SelectGender(inputdata.get("Gender"));

	ProductsPageElements productPage = OnHomePage.Click_LetsShop_Button();

Thread.sleep(1500);



productPage.addProductToCart();		
							
productPage.Click_Cart_Btn( );
System.out.println("priority = 0");

}
	 
@BeforeMethod
	public void loadsSplashScreen() throws InterruptedException

{
	
		Thread.sleep(3000);
		System.out.println("Loading Splash Screen/Activity" );
			Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
			driver .startActivity(activity);
 

}
 
	
	
	  @DataProvider 
	  
	  public Object[][] getProductPageData() throws IOException 
	  {  
		  List<HashMap<String,String>>	data= getJsonData( FileSystems.getDefault().getPath("").toAbsolutePath()+ "//src//test//java//testData//ProductPageData.json"  );
		
		  return new Object [] [] { 	{	 data.get(0) }   ,{	 data.get(1) } } ; 
		  
	  }
	
 
}
