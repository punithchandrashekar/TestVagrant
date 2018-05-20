package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ResusableFunctions {
	public WebDriver driver;

	public ResusableFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	// ** To Capture Screenshots during Test
	public static void saveScreenshot(String fileName,WebDriver driver) throws IOException {
		File imagePath = new File(System.getProperty("user.dir") + "\\Screenshots\\");
		File createClassFolder = new File(
				imagePath + "\\" + CreateDrivers.className + "\\" + CreateDrivers.methodName + "\\");
		String createClassFolder1 = createClassFolder.toString();
		boolean flag = createClassFolder.mkdir();
		if (flag == true) {
			FileUtils.cleanDirectory(new File(createClassFolder1));
			createClassFolder.mkdir();
		}

		try {

			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File(createClassFolder + "\\" + fileName + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
