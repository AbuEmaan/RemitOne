package Pages;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class AddDeliveryBankPage {
	
	
	private WebDriver wbDriver;
	private TestContext testContext;
	
	// initialise the page elements when the class is instantiated
	public AddDeliveryBankPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbDriver = driver;
		testContext = context;
	}
	
		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-deliveryEntities")
	public WebElement linkDeliveryEntities;

	@FindBy(how = How.ID, using = "menu-settings-deliveryEntities-banks")
	public WebElement linkDeliveryBank;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add New Delivery Bank']")
	public WebElement linkAddDeliveryBank;
	
	@FindBy(how = How.NAME, using = "bank:bank_code")
	public WebElement inputBankCode;
	
	@FindBy(how = How.NAME, using = "bank:name")
	public WebElement inputBankName;
	
	@FindBy(how = How.NAME, using = "bank:address")
	public WebElement inputBankaddress;
	
	@FindBy(how = How.NAME, using = "country_id")
	public WebElement ddcountry;
	
	
	@FindBy(how = How.NAME, using = "bank:city")
	public WebElement inputBankCity;
	
	@FindBy(how = How.NAME, using = "bank:state")
	public WebElement inputBankState;
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setDeliveryBank( String bankName, String bankCode, String bankCountry, String bankCity, String bankState ) throws InterruptedException
	{
		
		linkSettings.click();
		linkDeliveryEntities.click();
		linkDeliveryBank.click();
		linkAddDeliveryBank.click();

		inputBankName.sendKeys(bankName);
		inputBankCode.sendKeys(bankCode);
		//inputBankaddress.sendKeys(bankAddress);
		inputBankState.sendKeys(bankCity);
		inputBankCity.sendKeys(bankState);
		
		
		
		selectValueFromDropDown("country_id", bankCountry);
		
		
		btnSubmit.click();
		
		if(!textSuccessMsg.getText().contains("added successfully"))
		{
			
			Assert.fail("deliver bank was not added successfully");
			
			
			//Assert.fail("dfre");
			
		}
		
	
		
	}
	
	public void selectValueFromDropDown(String id, String valueToSelect)
	{
		
		
		List<WebElement> options = this.wbDriver.findElements(By.xpath("//select[@id ='"+id+"']/option"));

		for (WebElement option : options) {
			System.out.println(option.getText());
		    if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
		        option.click();
		        break;
		    }
		}
	}
	
}


	
