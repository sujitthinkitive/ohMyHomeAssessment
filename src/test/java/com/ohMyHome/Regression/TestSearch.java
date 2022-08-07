package com.ohMyHome.Regression;

import java.io.File;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ohMyHome.Library.AppLibrary;
import com.ohMyHome.Library.TestBase;
import com.ohMyHome.PageObject.BuyPage;
import com.ohMyHome.PageObject.HomePage;
import com.ohMyHome.PageObject.PropertyListingPage;



public class TestSearch extends TestBase{


	@DataProvider(name = "searchData")
	public String[][] getSignUpValidationData() throws Exception
	{
		String[][] data = appLibrary.readExcel("Resources"+File.separator+"SearchTestData.xls", 0);
		return data;
	}


	@BeforeClass
	public void setUp()
	{
		appLibrary = new AppLibrary("SignUpValidationTest");
	}

	@Test(dataProvider = "searchData")
	public void testSearchOnBuyPage(String testCaseId, String searchText, String propertyType, String budgetMin,
			String budgetMax, String roomsBedRoom, String roomsBathRoom, String countOfListing, String executionIndicator) throws Exception
	{
		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("testCaseId", testCaseId);
		testData.put("searchText", searchText);
		testData.put("propertyType", propertyType);
		testData.put("budgetMin", budgetMin);
		testData.put("budgetMax", budgetMax);
		testData.put("roomsBedRoom", roomsBedRoom);
		testData.put("roomsBathRoom", roomsBathRoom);
		testData.put("countOfListing", countOfListing);
		testData.put("executionIndicator", executionIndicator);

		appLibrary.getDriverInstance();
		appLibrary.launchApp();//launching the application in browser
		HomePage homePage = new HomePage(appLibrary);
		homePage.verifyTabs();//verifying the navigation tabs on home page
		homePage.clickOnTab("buy");//clicking on Buy tab
		BuyPage buy = new BuyPage(appLibrary);
		buy.verifySearchElementOnBuyPage();//verifying the search feature UI elements on Buy page
		buy.searchProperty(testData); //doing the search with test data
		new PropertyListingPage(appLibrary).verifySearchResult(testData); //verifying the search result on listing page

	}



}
