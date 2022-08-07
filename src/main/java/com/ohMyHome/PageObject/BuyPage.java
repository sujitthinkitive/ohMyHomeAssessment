package com.ohMyHome.PageObject;

import java.util.HashMap;

import com.ohMyHome.Library.AppLibrary;

public class BuyPage {

	AppLibrary appLibrary;

	public String buyPageHeader = "xpath:-://h2[text()='Your home buying journey starts here']";
	public String searchInput = "id:-:mui-1";
	public String searchButton = "xpath:-://input[@id='mui-1']/..//*[local-name()='svg']";

	//Property Type Filter
	public String propertyTypeButton = "xpath:-://span//p[text()='Property Type']";
	public String propertyTypePopupCloseButton = "xpath:-://p[text()='Property Type' and contains(@class,'MuiTypography-Subtext2')]/../..//*[local-name()='svg']";
	//propertyType sub options
	public String propertyTypePopupTitle = "xpath:-://p[text()='Property Type' and contains(@class,'MuiTypography-Subtext2')]";
	public String hbdButton = "xpath:-://label[@id='undefined_hdb']";
	public String condoButton = "xpath:-://label[@id='undefined_condo']";
	public String landedButton = "xpath:-://label[@id='undefined_landed']";

	//Budget Filter
	public String budgetButton = "xpath:-://span//p[text()='Budget']";
	//budget sub option
	public String budgetPopupTitle = "xpath:-://p[text()='Price Range' and contains(@class,'MuiTypography-Subtext2')]";
	public String minimumText = "xpath:-://label[@id='undefined_min_label']";
	public String maximumText = "xpath:-://label[@id='undefined_max_label']";
	public String minimumDropdown = "xpath:-://div[@id='undefined_min_select']";
	public String maximumDropdown = "xpath:-://div[@id='undefined_max_select']";
	// generic locator for value selection
	// 200000, 300000, 400000, 500000
	public String minimumValueselection = "xpath:-://li[@id='undefined_min_{#var#}']";
	public String maximumValueselection = "xpath:-://li[@id='undefined_max_{#var#}']";
	public String toTextBudgetPopup = "xpath:-://span[text()='to']";
	public String budgetPopupCloseButton = "xpath:-://p[text()='Price Range']/../..//*[local-name()='svg']";


	//Rooms Filter
	public String roomsButton = "xpath:-://span[text()='Rooms']";
	public String roomsPopupTitle = "xpath:-://p[text()='Room Types']";
	public String roomsPopupCloseButton = "xpath:-:(//p[text()='Room Types']/../..//*[local-name()='svg'])[1]";
	public String roomTypeBedroomText = "xpath:-://label[text()='Bedroom']";
	public String roomTypeBathroomText = "xpath:-://label[text()='Bathroom']";
	public String roomTypeBedroomDropdown = "xpath:-://label[text()='Bedroom']//following-sibling::div";
	public String roomTypeBathroomDropdown = "xpath:-://label[text()='Bathroom']//following-sibling::div";
	public String selectNoOfBedroom = "//span[text()='{#var#}']/../following-sibling::span/input";
	public String selectNoOfBathroom = "//span[text()='{#var#}']/../following-sibling::span/input";
	public String escapeRoomTypeDropdown = "xpath:-://div[@id='menu-']";

	//Tabs
	public String buy = "xpath:-://a[contains(text(),'Buy')][contains(@class,'ohmyhome-mega-menu-buy')]";
	public String sell = "xpath:-://a[contains(text(),'Sell')][contains(@class,'ohmyhome-mega-menu-sell')]";
	public String rent = "xpath:-://a[contains(text(),'Rent')][contains(@class,'ohmyhome-mega-menu-rent')]";
	public String services = "xpath:-://a[contains(text(),'Services')][contains(@class,'ohmyhome-mega-menu-services')]";
	public String renovation = "xpath:-://a[contains(text(),'Renovation')][contains(@class,'ohmyhome-mega-menu-renovation')]";
	public String articles = "xpath:-://a[contains(text(),'Articles')][contains(@class,'ohmyhome-mega-menu-articles')]";


	public BuyPage(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
	}
	/**
	 * This method verifies the UI elements on Buy Page 
	 * @throws Exception
	 */
	public void verifySearchElementOnBuyPage() throws Exception
	{
		appLibrary.verifyElement(buyPageHeader, true, 0);
		appLibrary.verifyElement(buy, true, 0);
		appLibrary.verifyElement(sell, true, 0);
		appLibrary.verifyElement(rent, true, 0);
		appLibrary.verifyElement(services, true, 0);
		appLibrary.verifyElement(renovation, true, 0);
		appLibrary.verifyElement(articles, true, 0);
		appLibrary.verifyElement(searchInput, true, 0);
		appLibrary.verifyElement(searchButton, true, 0);
		appLibrary.verifyElement(propertyTypeButton, true, 0);
		appLibrary.clickElement(propertyTypeButton);
		appLibrary.verifyElement(propertyTypePopupTitle, true, 0);
		appLibrary.verifyElement(hbdButton, true, 0);
		appLibrary.verifyElement(condoButton, true, 0);
		appLibrary.verifyElement(landedButton, true, 0);
		appLibrary.verifyElement(propertyTypePopupCloseButton, true, 0);
		appLibrary.clickElement(propertyTypePopupCloseButton);
		appLibrary.verifyElement(budgetButton, true, 0);
		appLibrary.clickElement(budgetButton);
		appLibrary.verifyElement(budgetPopupTitle, true, 0);
		appLibrary.verifyElement(minimumText, true, 0);
		appLibrary.verifyElement(maximumText, true, 0);
		appLibrary.verifyElement(minimumDropdown, true, 0);
		appLibrary.verifyElement(maximumDropdown, true, 0);
		appLibrary.verifyElement(toTextBudgetPopup, true, 0);
		appLibrary.clickElement(budgetPopupCloseButton);
		appLibrary.verifyElement(roomsButton, true, 0);
		appLibrary.clickElement(roomsButton);
		appLibrary.verifyElement(roomsPopupTitle, true, 0);
		appLibrary.verifyElement(roomsPopupCloseButton, true, 0);
		appLibrary.verifyElement(roomTypeBedroomText, true, 0);
		appLibrary.verifyElement(roomTypeBathroomText, true, 0);
		appLibrary.verifyElement(roomTypeBedroomDropdown, true, 5);
		appLibrary.verifyElement(roomTypeBathroomDropdown, true, 5);
		appLibrary.clickElement(roomsPopupCloseButton);

	}
	/**
	 * This method enters the text in search bar on Buy Page
	 * @param searchText
	 * @throws Exception
	 */
	public void enterSearchText(String searchText) throws Exception
	{
		if(!searchText.equalsIgnoreCase("na"))
		{
			appLibrary.enterText(searchInput, searchText);
		}
		appLibrary.clickElement(buyPageHeader);
	}

	/**
	 * This method allows to select the property type filter on Buy Page
	 * @param propertyType
	 * @throws Exception
	 */
	public void selectPropertyType(String propertyType) throws Exception
	{
		String[] proprtyTypeFilters = propertyType.split(",");

		appLibrary.clickElement(propertyTypeButton);
		for(String propertyTypeFilter:proprtyTypeFilters)
		{
			if(!propertyTypeFilter.equalsIgnoreCase("na"))
			{
				switch (propertyTypeFilter.toLowerCase())
				{
				case "hdb":
				{

					appLibrary.clickElement(hbdButton);

					break;
				}
				case "condo":
				{
					appLibrary.clickElement(condoButton);
					break;
				}
				case "landed":
				{
					appLibrary.clickElement(landedButton);
					break;
				}
				default:
				{
					throw new Exception("Not such property type available");
				}
				}
			}
		}
		appLibrary.clickElement(propertyTypePopupCloseButton);


	}
	/**
	 * This method allows to select the Budget filter options on Buy Page
	 * @param budgetMin
	 * @param budgetMax
	 * @throws Exception
	 */
	public void selectBudget(String budgetMin, String budgetMax) throws Exception
	{
		appLibrary.clickElement(budgetButton);
		if(!budgetMin.equalsIgnoreCase("na"))
		{
			appLibrary.clickElement(minimumDropdown);
			appLibrary.clickElement(minimumValueselection.replace("{#var#}", budgetMin));
		}
		if(!budgetMax.equalsIgnoreCase("na"))
		{
			appLibrary.clickElement(maximumDropdown);
			appLibrary.clickElement(maximumValueselection.replace("{#var#}", budgetMax));
		}
		appLibrary.clickElement(budgetPopupCloseButton);
	}
	
	/**
	 * This method allows to select the Rooms filter options on Buy Page
	 * @param bedrooms
	 * @param bathrooms
	 * @throws Exception
	 */
	public void selectRooms(String bedrooms, String bathrooms) throws Exception
	{
		appLibrary.clickElement(roomsButton);
		if(!bedrooms.equalsIgnoreCase("na"))
		{
			appLibrary.clickElement(roomTypeBedroomDropdown);
			String[] bedroomCounts = bedrooms.split(",");
			for(String bedroom:bedroomCounts)
			{
				appLibrary.clickElement("xpath:-:"+selectNoOfBedroom.replace("{#var#}", bedroom));
			}
			appLibrary.clickElement(escapeRoomTypeDropdown);
		}
		if(!bathrooms.equalsIgnoreCase("na"))
		{
			appLibrary.clickElement(roomTypeBathroomDropdown);
			String[] bathroomCounts = bathrooms.split(",");
			for(String bathroom:bathroomCounts)
			{
				appLibrary.clickElement("xpath:-:"+selectNoOfBathroom.replace("{#var#}", bathroom));
			}
			appLibrary.clickElement(escapeRoomTypeDropdown);
		}
		appLibrary.clickElement(roomsPopupCloseButton);
	}

	/**
	 * This method clicks on search button on search bar on Buy page
	 * @throws Exception
	 */
	public void clickSearchButton() throws Exception
	{
		appLibrary.clickElement(searchButton);
	}

	/**
	 * This method call helper methods to set the search criteria
	 * @param testData
	 * @throws Exception
	 */
	public void searchProperty(HashMap<String, String> testData) throws Exception
	{
		enterSearchText(testData.get("searchText"));
		selectPropertyType(testData.get("propertyType"));
		selectBudget(testData.get("budgetMin"), testData.get("budgetMax"));
		selectRooms(testData.get("roomsBedRoom"), testData.get("roomsBathRoom"));
		clickSearchButton();
	}



}
