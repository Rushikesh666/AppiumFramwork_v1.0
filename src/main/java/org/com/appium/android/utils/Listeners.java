package org.com.appium.android.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Listeners     implements ITestListener {
	 
 

	AndroidDriver driver;
 
 



	ExtentTest test;
	ExtentReports Extent = ExtentReporterNG.getReporterObject();

	@Override
	public void onTestStart(ITestResult result) {

		test = Extent.createTest(result.getMethod().getMethodName());
 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is passed here..!");
 
		 try {
			driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  try {
			  test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().  getMethodName(),driver ),null );
			  
		  } 
		  
		  catch ( Exception e1) {
		  
		  e1.printStackTrace(); }
		 
		
 
	}

	public   String getScreenshotPath(String testCaseName ,AndroidDriver driver) throws IOException {
		 
	File sourceFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String destinationFile= 	System.getProperty("user.dir") + "//reports/"+testCaseName+".png";
	
	FileUtils.copyFile(sourceFile,new File( destinationFile));
	
	return destinationFile;
	}
 
	

	@Override
	public void onTestFailure(ITestResult result) {
 test.fail(result.getThrowable());
  
 
 
 
 
 
 
 
	 
	}

	
	@Override
	public void onFinish(ITestContext context) {
		Extent.flush();
 
	}
}
