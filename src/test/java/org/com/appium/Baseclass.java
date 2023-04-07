package org.com.appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

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
	public  void    BasTestMethod() throws MalformedURLException, InterruptedException

	{
		
	UiAutomator2Options option =new UiAutomator2Options();
	
	URL url = new URL("http://127.0.0.1:4723");
	
	option.setDeviceName("pixel2");
	
	option.setApp("C://Users//Rushikesh//eclipse-workspace//com.appium//src//main//java//res//General-Store.apk");
	option.setChromedriverExecutable("C://Users//Rushikesh//Pictures//appiumws1//chromedriver.exe");
	 driver= new AndroidDriver(url, option);
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
