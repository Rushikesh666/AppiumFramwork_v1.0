package org.com.appium.android.utils;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	public static ExtentReports getReporterObject() {

		ExtentSparkReporter 	reporter	 =		 new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//reports.html");

		reporter.config().setReportName("Appium report name : REPORT NAME");

		reporter.config().setDocumentTitle("REPORT DOC TITLE IS : New report APPIUM" );

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester ", "ankita"); 

		return extent;

	}
}
