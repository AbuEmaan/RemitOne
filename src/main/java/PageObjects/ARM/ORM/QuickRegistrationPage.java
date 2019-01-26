package PageObjects.ARM.ORM;

import org.openqa.selenium.chrome.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Helpers.HelperFunctions;



public class QuickRegistrationPage {
	
	WebDriver wbdriver;
	HelperFunctions helper = new HelperFunctions();
	
	
	// initialise the page elements when the class is instantiated
	public QuickRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
	}
	
	
	
	@FindBy(how = How.LINK_TEXT, using = "United Kingdom")
	public WebElement linkCountry;
	
	@FindBy(how = How.ID, using = "email")
	public WebElement inputEmail;
	
	@FindBy(how = How.ID, using = "password")
	public WebElement inputPassword;

	@FindBy(how = How.ID, using = "verify_password")
	public WebElement inputVerifyPassword;
	
	@FindBy(how = How.ID, using = "fname")
	public WebElement inputFname;
	
	@FindBy(how = How.ID, using = "lname")
	public WebElement inputLname;
	
	@FindBy(how = How.ID, using = "dob")
	public WebElement inputdob;
	
	@FindBy(how = How.ID, using = "mobile")
	public WebElement inputMobile;
	
	@FindBy(how = How.ID, using = "toc")
	public WebElement cbxTOC;
	
	
	@FindBy(how = How.ID, using = "submit")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "registration-button")
	public WebElement btnRegistration;
	
	
	
	public void qucikRegistration(String email, String password, String verifyPassword, String fName, String lName,String dob, String mobile) throws InterruptedException
	{
		
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		inputVerifyPassword.sendKeys(verifyPassword);
		
		inputFname.sendKeys(fName);
		inputLname.sendKeys(lName);
		inputdob.sendKeys(dob);
		inputMobile.sendKeys(mobile);
		
		cbxTOC.click();
		
		btnSubmit.click();
		
		Thread.sleep(3000);
		
		helper.scrollDown("350",wbdriver);
		
		btnRegistration.click();
		
		
		
		
		
		
		
		
		/*
		
		if(!textSuccessMsg.getText().contains("added successfully"))
		{
			
			Assert.fail("Source Country was not added successfully");
			
			
			//Assert.fail("dfre");
			
		}
		
	*/
		
	}
	
}


	
