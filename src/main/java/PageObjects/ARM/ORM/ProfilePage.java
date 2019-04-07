package PageObjects.ARM.ORM;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Helpers.HelperFunctions;




public class ProfilePage {
	
	private WebDriver wbdriver;
	private TestContext testContext;
	HelperFunctions helper = new HelperFunctions();
	// initialise the page elements when the class is instantiated
	public ProfilePage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		testContext = context;
	}
	
	
	
	@FindBy(how = How.NAME, using = "Edit")
	public WebElement btnEdit;
	
	
	@FindBy(how = How.ID, using = "nationality")
	public WebElement ddNationality;
	
	@FindBy(how = How.ID, using = "gender")
	public WebElement ddGender;
	
	@FindBy(how = How.ID, using = "address1")
	public WebElement inputAddress1;

	@FindBy(how = How.ID, using = "address2")
	public WebElement inputAddress2;
	
	@FindBy(how = How.ID, using = "city")
	public WebElement inputCity;
	
	@FindBy(how = How.ID, using = "state")
	public WebElement inputState;
	
	@FindBy(how = How.ID, using = "postcode")
	public WebElement inputPostcode;
	
	@FindBy(how = How.ID, using = "telephone")
	public WebElement inputTelephone;
	
	@FindBy(how = How.ID, using = "id1_type")
	public WebElement ddIDType;
	
	
	@FindBy(how = How.ID, using = "id1_details")
	public WebElement btnIDDetails;
	
	@FindBy(how = How.ID, using = "id1_expiry")
	public WebElement btnExpiry;
	
	
	@FindBy(how = How.ID, using = "id1_scan1")
	public WebElement btnFileUpload;
	
	
	@FindBy(how = How.ID, using = "submit")
	public WebElement btnSave;
	
	
	
	

	
	
	public void editProfile(String nationality, String gender, String address1, String address2, String city,String state, String postcode, String telephone, String IDType, String identityDetails, String expityDate) throws InterruptedException, AWTException
	{
		
		
		helper.scrollDown("800",wbdriver);
		
		btnEdit.click();
		
		// set the country
		helper.selectValueFromDropDown("nationality", nationality, wbdriver);
		
		// set the gender
		helper.selectValueFromDropDown("gender", gender, wbdriver);
			
		inputAddress1.clear();
		inputAddress1.sendKeys(address1);
		
		inputAddress2.clear();
		inputAddress2.sendKeys(address2);
		
		inputCity.clear();
		inputCity.sendKeys(city);

		inputState.clear();
		inputState.sendKeys(state);
		
		inputPostcode.clear();
		inputPostcode.sendKeys(postcode);
		
		inputTelephone.clear();
		inputTelephone.sendKeys(telephone);
		
		helper.scrollDown("450",wbdriver);
		
		
		// set the ID Tye
		helper.selectValueFromDropDown("id1_type", IDType, wbdriver);
		
		btnIDDetails.clear();
		btnIDDetails.sendKeys(identityDetails);

		btnExpiry.clear();
		btnExpiry.sendKeys(expityDate);
		
		helper.scrollDown("300",wbdriver);
		
		// upload the image
		btnFileUpload.click();
		helper.uploadFile("upload.png");
		
		Thread.sleep(2000);
		
		btnSave.click();
		
		
		
		
	
	}
	
}


	

