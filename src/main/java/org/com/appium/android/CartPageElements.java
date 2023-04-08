package org.com.appium.android;

 

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.com.appium.android.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;

public class CartPageElements extends AndroidActions {
 
	private AndroidDriver driver;
	public CartPageElements(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		

	}
	
 



	
 
 	//		@AndroidBy(xpath   = "//android.widget.Button[@text='Visit to the website to complete purchase']") 
 	//			private			WebElement btnProceed;
	  
			@FindBy(id = "com.androidsample.generalstore:id/productImage")
			private List<WebElement> productImage_Items;

			@FindBy(id = "com.androidsample.generalstore:id/productPrice")
			private List<WebElement> productPrice_Items;
			@FindBy(className =  "android.widget.CheckBox")
			private  WebElement  CheckBox;
	

			@AndroidBy(xpath   = "//android.widget.Button[@id='com.androidsample.generalstore:id/btnProceed']") 
			private			WebElement btnProceed;


			 
	
   
			  
			  
public void Click_checkBox()
{ 
	CheckBox.click();
	
}

public void LongPress_btnProceed(    int durationInSeconds )
{ 
 
 
 LongPressGesture( ((WrapsElement) btnProceed).getWrappedElement(), durationInSeconds);
 
}


public void submitOrder(      ) throws InterruptedException
{ 
 
 
	LongPress_btnProceed(   5);
 
 
}

//WEBVIEW_com.androidsample.generalstore
 
 
public void SwitchToWebview(      ) throws InterruptedException
{ 
 
 
 driver.context("WEBVIEW_com.androidsample.generalstore");
 
 
}
public void SwitchToNativeView(      ) throws InterruptedException
{ 
 
 
 driver.context("NATIVE_APP");
 
 
}


public void NavigateBackFromWebview(    AndroidDriver driver  ) throws InterruptedException
{ 
 
	SwitchToNativeView();
	navigateBack();
	navigateBack();
 
}





	public void getCartItemsTotal (  ) {

		int productImage_Items_size = productImage_Items.size();
		 
		double total=0.0;
		for(int i=0; i<productPrice_Items.size();i++)
		{
		
			double	Tempprice=	 	Double.parseDouble( productPrice_Items.get(i).getText().substring(1));
			 	
			total=total+Tempprice;
			 	
		}
 
		 System.out.println(total);
		 
		  
	}

}
