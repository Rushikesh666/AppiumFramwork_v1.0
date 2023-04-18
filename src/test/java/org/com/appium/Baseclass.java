package org.com.appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.com.appium.android.HomePageElements;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;



	public class Baseclass {
	
	  HomePageElements OnHomePage;
	public  static   AndroidDriver driver;
	
	
	
	@BeforeClass
	public  void    BaseTestMethod() throws InterruptedException, Exception

	{
	 
	 	Properties prop= new Properties();
					 
	 	
		/*         Providing the path of Properties File 			*/
					 	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//res//prop.properties");
					 
					 	prop.load(fis);
						
					 	
						/*     Extracting IP ADDRESS and  Port number provided under Properties File 	and passing it into   Class URL : Uniform ResourceLocator	as 	URL url = new URL( "http://127.0.0.1:4723" ); 	*/
					
					 	String IPADDRESS= prop.getProperty("ipAddress");
				
						 
						String port= prop.getProperty("port");
				
						
						URL urlnew = new URL(IPADDRESS+":"+port);
					 
						/*         Creating  capabilities object  which holds  Android and for Hybrid App	Information	*/
						
						UiAutomator2Options option =new UiAutomator2Options();
	 
						
						option.setDeviceName("pixel2"); // Device Name as pixel2
						 
						option.setApp(System.getProperty("user.dir") +"//src//main//java//res//General-Store.apk"); 								// providing Android App location path
						
						option.setChromedriverExecutable(System.getProperty("user.dir") +"//src//main//java//res//chromedriver.exe");		// providing Chrome Browser location path
						
						 driver= new AndroidDriver(urlnew, option); // Invoking Android App
						 
						 	OnHomePage= new HomePageElements(driver); // Creating Home Page Object 
						 	System.out.println("Invoking Android App");
						
						
							Thread.sleep(5000);
 
}
	
	
	
	public static List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException
	{

		/*      Utiliy to read Json data and to provide to required Test Cases 	*/
		
		
		
		//	System.getProperty("user.dir")+"//src//test//java//testData//HompageData.json"
		String jsonContent=FileUtils.readFileToString(new File( 	jsonFilePath),StandardCharsets.UTF_8);

		ObjectMapper mapper=new ObjectMapper();

		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){	});

		return data;

		}
	
	
	
	
}
