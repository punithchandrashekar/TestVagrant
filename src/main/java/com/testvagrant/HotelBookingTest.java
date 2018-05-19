package com.testvagrant;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.PageFactory.HotelBooking_PageFactory;
import com.utils.CreateDrivers;

public class HotelBookingTest extends CreateDrivers {

	@Test
	public void shouldBeAbleToSearchForHotels() {
		// ** Creating an object of Hotel Booking Page Factory Class to access
		// the Webelements
		HotelBooking_PageFactory hotelBooking_PageFactory = new HotelBooking_PageFactory(driver);
		driver.get("https://www.cleartrip.com/");
		hotelBooking_PageFactory.hotelLink.click();
		hotelBooking_PageFactory.localityTextBox.sendKeys("Indiranagar, Bangalore");
		new Select(hotelBooking_PageFactory.travellerSelection).selectByVisibleText("1 room, 2 adults");
		hotelBooking_PageFactory.searchButton.click();
		System.out.println("Search Button is clicked after entering inputs");
	}

}
