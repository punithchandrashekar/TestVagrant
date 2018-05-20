package com.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.sun.jna.Platform;

public class CreateDrivers {

	public WebDriver driver;
	public WebDriverWait wait;
	public ResusableFunctions resusableFunctions;
	public static String className;
	public static String methodName;

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		resusableFunctions = new ResusableFunctions(driver);

	}

	/** Run before each Method **/
	@BeforeMethod
	public void captureClassName(Method method) {
		className = getClass().getSimpleName();
		methodName = method.getName();
	}

	/** Run after each Method, check if the method failed and captures screenshot **/
	@AfterMethod
	public void closeApp(ITestResult result, Method method) throws IOException {
		String currentDir = System.getProperty("user.dir");
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println(methodName+" failed, captured screenshot");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(currentDir + "\\Screenshots\\" + className + "\\" + methodName + "\\"
					+ methodName + " failed.png"));

		}
	}

	// ** Runs after each class. To quit the drivers before running the
	// test case
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
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
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
