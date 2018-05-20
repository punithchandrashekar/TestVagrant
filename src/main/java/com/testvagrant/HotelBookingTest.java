package com.testvagrant;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.PageFactory.HotelBooking_PageFactory;
import com.utils.CreateDrivers;
import com.utils.ResusableFunctions;

public class HotelBookingTest extends CreateDrivers {

	@Test
	public void shouldBeAbleToSearchForHotels() throws IOException {
		// ** Creating an object of Hotel Booking Page Factory Class to access
		// the Webelements
		HotelBooking_PageFactory hotelBooking_PageFactory = new HotelBooking_PageFactory(driver);
		driver.get("https://www.cleartrip.com/");
		hotelBooking_PageFactory.hotelLink.click();
		hotelBooking_PageFactory.localityTextBox.sendKeys("Indiranagar, Bangalore");
		hotelBooking_PageFactory.lowestPriceSection.click();
		ResusableFunctions.saveScreenshot("1_DetailsEntered", driver);
		new Select(hotelBooking_PageFactory.travellerSelection).selectByVisibleText("1 room, 2 adults");
		hotelBooking_PageFactory.searchButton.click();
		System.out.println("Search Button is clicked after entering inputs");
		ResusableFunctions.saveScreenshot("2_SearchResults", driver);
	}

}
