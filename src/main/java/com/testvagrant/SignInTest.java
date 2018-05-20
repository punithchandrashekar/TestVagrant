package com.testvagrant;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CreateDrivers;
import com.utils.ResusableFunctions;

public class SignInTest extends CreateDrivers {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws IOException {

		driver.get("https://www.cleartrip.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your trips")));
		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();
		ResusableFunctions.saveScreenshot("1_ClickSignIn", driver);
		// ** Switch to frame
		driver.switchTo().frame("modal_window");
		ResusableFunctions.saveScreenshot("2_iFrame", driver);
		driver.findElement(By.id("signInButton")).click();
		String errors1 = driver.findElement(By.id("errors1")).getText();
		System.out.println(errors1);
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		ResusableFunctions.saveScreenshot("3_SearchResults", driver);
	}

}
