package com.testvagrant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CreateDrivers;
import java.util.List;

public class FlightBookingTest extends CreateDrivers {

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		driver.get("https://www.cleartrip.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OneWay")));
		driver.findElement(By.id("OneWay")).click();
		driver.findElement(By.id("FromTag")).clear();
		driver.findElement(By.id("FromTag")).sendKeys("Bangalore");

		// wait for the auto complete options to appear for the origin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		driver.findElement(By.id("ToTag")).clear();
		driver.findElement(By.id("ToTag")).sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

		// all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();
		// verify that result appears for the provided journey search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("searchSummary")));
		Assert.assertTrue(resusableFunctions.isElementPresent(By.className("searchSummary")));
		System.out.println("Search Results are displayed");

	}
//** Wait until is better to use, than thread.sleep
	/*private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}
*/


}
