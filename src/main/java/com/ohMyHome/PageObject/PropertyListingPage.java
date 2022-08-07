package com.ohMyHome.PageObject;

import java.util.HashMap;
import com.ohMyHome.Library.AppLibrary;



public class PropertyListingPage {

	AppLibrary appLibrary;

	public String listingFoundText = "xpath:-://span[text()='listings found']";
	public String listingCountText = "xpath:-://span[text()='listings found']/preceding-sibling::span";
	public String noPropertyFoundText = "xpath:-://p[text()='No properties found.']";
	public String noPropertyFoundImage = "xpath:-://p[text()='No properties found.']/preceding-sibling::img";
	public String noPropertyFoundSubText1 = "xpath:-://p[text()='Sorry about that! Please try using']";
	public String noPropertyFoundSubText2 = "xpath:-://p[text()='broader search terms or filters.']";


	public PropertyListingPage(AppLibrary appLibrary)
	{
		this.appLibrary = appLibrary;
	}

	/**
	 * This method is verifying the UI element on Property Listing page
	 * @param testData
	 * @throws Exception
	 */
	public void verifySearchResult(HashMap<String, String> testData) throws Exception
	{
		appLibrary.getCurrentDriverInstance().getCurrentUrl().contains("listing-results");

		if(testData.get("countOfListing").equalsIgnoreCase("npf"))
		{
			appLibrary.verifyElement(noPropertyFoundText, true, 0);
			appLibrary.verifyElement(noPropertyFoundImage, true, 0);
			appLibrary.verifyElement(noPropertyFoundSubText1, true, 0);
			appLibrary.verifyElement(noPropertyFoundSubText2, true, 0);

		}else
		{
			appLibrary.verifyElement(listingFoundText, true, 0);
			appLibrary.findElement(listingCountText).getText().equalsIgnoreCase(testData.get("countOfListing"));
		}

	}


}
