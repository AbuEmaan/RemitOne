package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class SetSourceCoversionRatesPage {
	
	WebDriver wbDriver;
	
	// initialise the page elements when the class is instantiated
	public SetSourceCoversionRatesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
		this.wbDriver= driver;
	}
	
		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies")
	public WebElement linkCountriesandcurrencies;

	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies-sourceConversionRates")
	public WebElement linkSourceConverstionrate;
	
	@FindBy(how = How.XPATH, using = "//a[text()='New Source Country']")
	public WebElement linkAddCountry;
	
	@FindBy(how = How.NAME, using = "new_sett2EUR")
	public WebElement eurochangeRate;
	
	@FindBy(how = How.NAME, using = "new_sett2USD")
	public WebElement usdExchangeRate;;
	

	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setSourceConversionRates(String euroRate , String usdRate) throws InterruptedException
	{
		
		linkSettings.click();
		linkCountriesandcurrencies.click();
		linkSourceConverstionrate.click();
		
		
		eurochangeRate.sendKeys(euroRate);
		wbDriver.findElements(By.xpath("//input[@class='input-button']")).get(0).click();
		
		
		usdExchangeRate.sendKeys(usdRate);
		wbDriver.findElements(By.xpath("//input[@class='input-button']")).get(1).click();
		
	
		if(!textSuccessMsg.getText().toLowerCase().contains("rate updated successfully"))
		{
			
			Assert.fail("Source Rate was not updated successfully");
			
			
			
		}
		

		
	}
	
}


	

