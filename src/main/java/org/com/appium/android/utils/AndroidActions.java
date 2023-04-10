package org.com.appium.android.utils;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auto.common.Visibility;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidActions {

	private AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;

	}

	public void scrolltilltext(String myText) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable (new UiSelector()) .scrollIntoView(text(\"" + myText + "\"));"));

	}

	public void Drag_Drop(WebElement drag_element) {

		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) drag_element).getId(), "endX", 650, "endY", 560, "speed", 200));

	}

	public void Scroll_till_end() {
		boolean canScrollmore = false;
		do {
			boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down",
							"percent", 3.0));

		} while (canScrollmore);

	}

	public void swipe_gesture(WebElement element_to_be_swiped, String direction) {

		assertEquals(element_to_be_swiped.getAttribute("focusable"), "true");

		// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element_to_be_swiped).getId(), "direction", direction, "percent", 0.5));

		assertEquals(element_to_be_swiped.getAttribute("focusable"), "false");

	}

	public void LongPressGesture(WebElement element_to_be_pressed_for_long, int forHowlong) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element_to_be_pressed_for_long).getId(), "duration", forHowlong));
	}

	public void navigateToHomePage() {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

	public String GetToastText() {
		return driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");

	}

	public void navigateBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}
	
	

	
	
	
	

}
