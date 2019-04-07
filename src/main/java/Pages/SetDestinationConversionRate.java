package Pages;

import org.openqa.selenium.chrome.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import TestContext.TestContext;



public class SetDestinationConversionRate {
	
	private WebDriver wbDriver;
	private TestContext testContext;
	
	// initialise the page elements when the class is instantiated
	public SetDestinationConversionRate(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbDriver = driver;
		testContext = context;
	}
	
		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies")
	public WebElement linkCountriesandcurrencies;

	@FindBy(how = How.ID, using = "menu-settings-countriesCurrencies-destinationConversionRates")
	public WebElement linkDestinationConverstionrate;
	
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setDestinationConversionRates(String firstRate , String secondRate, String thirdRate) throws InterruptedException
	{
		
		linkSettings.click();
		linkCountriesandcurrencies.click();
		linkDestinationConverstionrate.click();
		
		
		wbDriver.findElement(By.xpath("(//input[@name='new_rate'])[1]")).sendKeys(firstRate);
		wbDriver.findElement(By.xpath("(//input[@class='input-button'])[1]")).click();
		
		if(!textSuccessMsg.getText().contains("Destination Currency Conversion Rate Updated Successfully"))
		{
			Assert.fail("Destination Rate was not updated successfully");
				
		}
		
		
		wbDriver.findElement(By.xpath("(//input[@name='new_rate'])[2]")).sendKeys(secondRate);
		wbDriver.findElement(By.xpath("(//input[@class='input-button'])[2]")).click();
		
		if(!textSuccessMsg.getText().contains("Destination Currency Conversion Rate Updated Successfully"))
		{
			Assert.fail("Destination Rate was not updated successfully");
				
		}
		
		wbDriver.findElement(By.xpath("(//input[@name='new_rate'])[3]")).sendKeys(thirdRate);
		wbDriver.findElement(By.xpath("(//input[@class='input-button'])[3]")).click();
		
		if(!textSuccessMsg.getText().contains("Destination Currency Conversion Rate Updated Successfully"))
		{
			Assert.fail("Destination Rate was not updated successfully");
				
		}
		

		
	}
	
}


	


