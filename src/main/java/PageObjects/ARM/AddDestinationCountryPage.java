package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Helpers.HelperFunctions;




public class AddDestinationCountryPage {
	
	
	private WebDriver wbdriver;
	private TestContext testContext;
	HelperFunctions helper = new HelperFunctions();
	// initialise the page elements when the class is instantiated
	public AddDestinationCountryPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		testContext = context;
		wbdriver = driver;
		
		
	}
	
	


		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies")
	public WebElement linkCountriesandcurrencies;

	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies-destinationCountries")
	public WebElement linkSourceCountry;
	
	@FindBy(how = How.XPATH, using = "//a[text()='New Destination Country']")
	public WebElement linkAddCountry;
	
	@FindBy(how = How.ID, using = "country_selector")
	public WebElement ddCountrySelector;
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-button']")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setDestinationCountry(String country) throws InterruptedException
	{
		
		linkSettings.click();
		linkCountriesandcurrencies.click();
		linkSourceCountry.click();
		
		linkAddCountry.click();
				
		// set the country
		helper.selectValueFromDropDown("country_selector", country,wbdriver);
	
		
		btnSubmit.click();
		
		Thread.sleep(2000);
		
		System.out.println(textSuccessMsg.getText());
		
		if(!textSuccessMsg.getText().toLowerCase().contains("added successfully."))
		{
			
			Assert.fail("Destination Country was not added successfully");
			
			
			
		}
		
	
		
	}
	
	
	
	
	
	
}


	
