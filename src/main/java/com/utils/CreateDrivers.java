package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sun.jna.Platform;

public class CreateDrivers {

	public WebDriver driver;

	// ** Runs before each class. To initialize the drivers before running the
	// test case
	@BeforeClass
	public void setUp() {
		System.out.println("Creating Drivers");
		setDriverPath();
		// ** To disable the infobar displayed in the top right
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	@AfterClass
	public void cleanDrivers() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
			System.out.println("Cleaned up drivers");
		}
	}

	private void setDriverPath() {

		if (Platform.isMac()) {
			System.out.println("OS is Mac");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "chromedriver");
		}
		if (Platform.isWindows()) {
			System.out.println("OS is Windows");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		}
		if (Platform.isLinux()) {
			System.out.println("OS is Windows");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "chromedriver_linux");
		}
	}

}
