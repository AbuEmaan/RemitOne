package PageObjects.ARM;

import org.openqa.selenium.chrome.*;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class AddCollectionPointPage {
	
	
	WebDriver wbDriver;
	// initialise the page elements when the class is instantiated
	public AddCollectionPointPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
		this.wbDriver=driver;
	}
	
		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-deliveryEntities")
	public WebElement linkDeliveryEntities;

	@FindBy(how = How.ID, using = "menu-settings-deliveryEntities-collectionPoints")
	public WebElement linkCollectionPoint;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add New Collection Point']")
	public WebElement linkAddCollectionPoint;
	
	
	@FindBy(how = How.NAME, using = "bank")
	public WebElement inputBank;
	
	@FindBy(how = How.NAME, using = "name")
	public WebElement inputCPName;
	
	@FindBy(how = How.NAME, using = "code")
	public WebElement inputCPCode;
	
	@FindBy(how = How.NAME, using = "address")
	public WebElement inputCPaddress;
	
	@FindBy(how = How.NAME, using = "city")
	public WebElement inputCPCity;
	
	@FindBy(how = How.NAME, using = "state")
	public WebElement inputCPState;
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setCollectionPoint(String CPName, String CPBankName, String CPCode,  String CPAddress, String CPCity, String CPState ) throws InterruptedException
	{
		
		linkSettings.click();
		linkDeliveryEntities.click();
		linkCollectionPoint.click();
		linkAddCollectionPoint.click();

		inputCPName.sendKeys(CPName);
		
		CPBankName = "test bank";		
		selectValueFromDropDown("bank", CPBankName);
		
		inputCPCode.sendKeys(CPCode);
		
		inputCPaddress.sendKeys(CPAddress);
		inputCPState.sendKeys(CPCity);
		inputCPCity.sendKeys(CPState);
		
		
		
		
		btnSubmit.click();
		
		if(!textSuccessMsg.getText().contains("New Collection Point Pubali Bank created successfully."))
		{
			Assert.fail("Collection Point  was not added successfully");
			
		}
		
	
		
	}
	
	
	public void selectValueFromDropDown(String id, String valueToSelect)
	{
		
		
		List<WebElement> options = this.wbDriver.findElements(By.xpath("//select[@name ='"+id+"']/option"));

		for (WebElement option : options) {
			System.out.println(option.getText());
		    if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
		        option.click();
		        break;
		    }
		}
	}
	
}


	
