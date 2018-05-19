package com.testvagrant;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CreateDrivers;

public class SignInTest extends CreateDrivers {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		driver.get("https://www.cleartrip.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your trips")));
		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();
		//** Switch to frame
		driver.switchTo().frame("modal_window");
		driver.findElement(By.id("signInButton")).click();
		String errors1 = driver.findElement(By.id("errors1")).getText();
		System.out.println(errors1);
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}

}
