package com.ohMyHome.PageObject;

import com.ohMyHome.Library.AppLibrary;

public class HomePage {
	AppLibrary appLibrary;

	public String buy = "xpath:-://a[text()='Buy a Property']";
	public String sell = "xpath:-://a[text()='Sell a Property']";
	public String rent = "xpath:-://a[text()='Rent a Property']";
	public String renovation = "xpath:-://a[text()='Renovation Services']";

	public HomePage (AppLibrary appLibrary)
	{
		this.appLibrary = appLibrary;
	}
	/**
	 * This method is verifying the links on Home page
	 * @throws Exception
	 */
	public void verifyTabs() throws Exception
	{
		appLibrary.scroll(buy);
		appLibrary.verifyElement(buy, true, 2);
		appLibrary.verifyElement(sell, true, 2);
		appLibrary.verifyElement(rent, true, 2);
		appLibrary.verifyElement(renovation, true, 2);

	}
	
	/**
	 * This method clicks on link based on provided parameter value
	 * @param tabName
	 * @throws Exception
	 */
	public void clickOnTab(String tabName) throws Exception
	{
		appLibrary.scrollTop();
		switch (tabName.toLowerCase())
		{
		case "buy": 
		{
			appLibrary.scroll(buy);
			appLibrary.clickElement(buy);
			break;
		}
		case "rent": 
		{
			appLibrary.scroll(rent);
			appLibrary.clickElement(rent);
			break;
		}
		case "sell": 
		{
			appLibrary.scroll(sell);
			appLibrary.clickElement(sell);
			break;
		}
		case "renovation": 
		{
			appLibrary.scroll(renovation);
			appLibrary.clickElement(renovation);
			break;
		}
		
		default:
		{
			throw new Exception("Please provide correct tab name");
		}

		}

	}


}
