package PageObjects.ARM;

import org.openqa.selenium.chrome.*;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class AddAgentPage {
	
	private WebDriver wbdriver;
	// initialise the page elements when the class is instantiated
	public AddAgentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		
	}
	
		
	@FindBy(how = How.XPATH, using = "(//li[@id='menu-agents'])[2]")
	public WebElement linkAgents;
	
	@FindBy(how = How.XPATH, using = "//a[text()='List Agents']")
	public WebElement linkListAgent;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add Agent']")
	public WebElement linkaddAgent;
	
			
	@FindBy(how = How.ID, using = "agency_name")
	public WebElement inputAgencyName;
	
	@FindBy(how = How.NAME, using = "fname")
	public WebElement inputfname;
	
	@FindBy(how = How.NAME, using = "lname")
	public WebElement inputlname;
	
	@FindBy(how = How.NAME, using = "email")
	public WebElement inputemail;
	
	@FindBy(how = How.CLASS_NAME, using = "new_username_show")
	public WebElement inputUsername;
	
	@FindBy(how = How.CLASS_NAME, using = "new_password_show")
	public WebElement inputPassword;
	
	
	@FindBy(how = How.NAME, using = "address1")
	public WebElement inputAddress1;
	
	@FindBy(how = How.NAME, using = "town")
	public WebElement inputTown;
	
	@FindBy(how = How.NAME, using = "address2")
	public WebElement inputAddress2;
	
	@FindBy(how = How.NAME, using = "postcode")
	public WebElement inputPostcode;
	
	@FindBy(how = How.ID, using = "input_tel")
	public WebElement inputTelephone;
	
	@FindBy(how = How.ID, using = "msb_license_name")
	public WebElement inputmsb_license_name;
	
	@FindBy(how = How.ID, using = "application_dealt_by")
	public WebElement inputApplicationDealtBy;
	
	
	@FindBy(how = How.ID, using = "application_checked_by")
	public WebElement inputApplicationCheckedBy;
		
	@FindBy(how = How.ID, using = "application_approved_by")
	public WebElement inputApplicationApprovedBy;
			
	
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-button']")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void addAgent(String agencyName, String fname, String lname, String username, String password, String country, String address1, String town, String address2, String postcode, String email, String telephone, String licenceName, String applicationDealtBy, String applicationCheckedBy, String applicationApprovedBy ) throws InterruptedException
	{
		
		linkAgents.click();
		linkListAgent.click();
		linkaddAgent.click();
		
		
		inputAgencyName.sendKeys(agencyName);
		inputfname.sendKeys(fname);
		inputlname.sendKeys(lname);
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		
		//inputCountry.sendKeys(country);
		
		// set the country
		selectValueFromDropDown("country_id", country);
			
		
		inputAddress1.sendKeys(address1);
		inputTown.sendKeys(town);
		inputAddress2.sendKeys(address2);
		inputPostcode.sendKeys(postcode);
		inputemail.sendKeys(email);
		inputTelephone.sendKeys(telephone);
		inputmsb_license_name.sendKeys(licenceName);
		inputApplicationDealtBy.sendKeys(applicationDealtBy);
		inputApplicationCheckedBy.sendKeys(applicationCheckedBy);
		inputApplicationApprovedBy.sendKeys(applicationApprovedBy);
		
		
		
		
		btnSubmit.click();
		
		if(!textSuccessMsg.getText().contains("Agent Added Successfully"))
		{
			
			Assert.fail("Agent was not added successfully");
			
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


	
