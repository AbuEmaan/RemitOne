package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class AddSourceCountryPage {
	
	// initialise the page elements when the class is instantiated
	public AddSourceCountryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
	}
	
		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies")
	public WebElement linkCountriesandcurrencies;

	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies-sourceCountries")
	public WebElement linkSourceCountry;
	
	@FindBy(how = How.XPATH, using = "//a[text()='New Source Country']")
	public WebElement linkAddCountry;
	
	@FindBy(how = How.ID, using = "country_selector")
	public WebElement ddCountrySelector;
	
	@FindBy(how = How.ID, using = "currency_select")
	public WebElement ddCurrencySelector;
	
	@FindBy(how = How.ID, using = "wallet_transfer_enabled")
	public WebElement ddWalletEnabledSelector;
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-button']")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setSourceCountry(String country, String currency, String walletEnabled) throws InterruptedException
	{
		
		linkSettings.click();
		linkCountriesandcurrencies.click();
		linkSourceCountry.click();
		
		linkAddCountry.click();
		
		
		Select ddCountry = new Select(ddCountrySelector);
		ddCountry.selectByVisibleText(country);
		
		Select ddCurrency= new Select(ddCurrencySelector);
		ddCurrency.selectByVisibleText(currency);
		
		
		Select ddwalletEnabled= new Select(ddWalletEnabledSelector);
		ddwalletEnabled.selectByVisibleText(walletEnabled);
		
		
		
		btnSubmit.click();
		
		if(!textSuccessMsg.getText().contains("added successfully"))
		{
			
			Assert.fail("Source Country was not added successfully");
			
			
			//Assert.fail("dfre");
			
		}
		
	
		
	}
	
}


	
