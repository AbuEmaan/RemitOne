package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddDeliveryBankBranchPage {
	
	private WebDriver wbdriver;
	private TestContext testContext;
	
	// initialise the page elements when the class is instantiated
	public AddDeliveryBankBranchPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		testContext = context;
	}
	
		
	@FindBy(how = How.ID, using = "menu-settings")
	public WebElement linkSettings;
	
	@FindBy(how = How.ID, using = "menu-settings-deliveryEntities")
	public WebElement linkDeliveryEntities;

	@FindBy(how = How.ID, using = "menu-settings-deliveryEntities-bankBranches")
	public WebElement linkDeliveryBank;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add New Branch']")
	public WebElement linkAddDeliveryBank;
	
	@FindBy(how = How.NAME, using = "branch:branch_code")
	public WebElement inputBankCode;
	
	@FindBy(how = How.NAME, using = "branch:name")
	public WebElement inputBankName;
			
	@FindBy(how = How.NAME, using = "branch:city")
	public WebElement inputBankCity;
	
	@FindBy(how = How.NAME, using = "branch:state")
	public WebElement inputBankState;
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void setDeliveryBankBranch( String branchName, String branchCode, String deliveryBankName, String branchCity, String branchState) throws InterruptedException
	{
		
		linkSettings.click();
		linkDeliveryEntities.click();
		linkDeliveryBank.click();
		linkAddDeliveryBank.click();

		inputBankName.sendKeys(branchName);
		inputBankCode.sendKeys(branchCode);
		inputBankState.sendKeys(branchCity);
		inputBankCity.sendKeys(branchState);
		
		selectValueFromDropDown("delivery_bank", deliveryBankName);
			
		btnSubmit.click();
		
		if(!textSuccessMsg.getText().contains("added successfully"))
		{
			
			Assert.fail("deliver bank branch was not added successfully");
			
		}
		
	}
	
	public void selectValueFromDropDown(String id, String valueToSelect)
	{
		
		List<WebElement> options = this.wbdriver.findElements(By.xpath("//select[@id ='"+id+"']/option"));

		for (WebElement option : options) {
			System.out.println(option.getText());
		    if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
		        option.click();
		        break;
		    }
		}
	}
	
}


	

