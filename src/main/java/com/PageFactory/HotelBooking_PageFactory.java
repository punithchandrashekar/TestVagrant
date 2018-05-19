package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBooking_PageFactory {
	private WebDriver driver;
	public WebElement element;

	public HotelBooking_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(linkText = "Hotels")
	public WebElement hotelLink;

	@FindBy(id = "Tags")
	public WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	public WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	public WebElement travellerSelection;
}
