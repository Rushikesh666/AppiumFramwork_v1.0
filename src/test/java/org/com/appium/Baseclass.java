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
	public  void    BasTestMethod() throws InterruptedException, Exception

	{
	 
	 Properties prop= new Properties();
	 
 FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//res//prop.properties");
	 
	 prop.load(fis);
		
	UiAutomator2Options option =new UiAutomator2Options();
	
 
	String IPADDRESS= prop.getProperty("ipAddress");

	String port= prop.getProperty("port");
	
	
	
	option.setDeviceName("pixel2");
	
	//URL url = new URL( "http://127.0.0.1:4723" );
	URL urlnew = new URL(IPADDRESS+":"+port);
	
	option.setApp(System.getProperty("user.dir") +"//src//main//java//res//General-Store.apk");
	
	option.setChromedriverExecutable(System.getProperty("user.dir") +"//src//main//java//res//chromedriver.exe");
	
	 driver= new AndroidDriver(urlnew, option);
	 
  OnHomePage= new HomePageElements(driver);
  
	System.out.println("BasTestMethod() running");
	
		Thread.sleep(5000);
 
}
	
	
	
	public static List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException
	{
		//	System.getProperty("user.dir")+"//src//test//java//testData//HompageData.json"
		String jsonContent=FileUtils.readFileToString(new File( 	jsonFilePath),StandardCharsets.UTF_8);

		ObjectMapper mapper=new ObjectMapper();

		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){	});

		return data;

		}
	
	
	
	
}
