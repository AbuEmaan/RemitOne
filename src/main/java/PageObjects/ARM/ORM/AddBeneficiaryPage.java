package PageObjects.ARM.ORM;

import org.openqa.selenium.chrome.*;
import java.awt.AWTException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Helpers.HelperFunctions;

public class AddBeneficiaryPage {
	
	WebDriver wbdriver;
	HelperFunctions helper = new HelperFunctions();
	
	// initialise the page elements when the class is instantiated
	public AddBeneficiaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
	}
	
	
	@FindBy(how = How.ID, using = "addBeneficiary")
	public WebElement btnAddBeneficiary;
	
	
	@FindBy(how = How.ID, using = "benef_fname")
	public WebElement inputFName;
	
	@FindBy(how = How.ID, using = "benef_lname")
	public WebElement inputLName;
	
	@FindBy(how = How.ID, using = "benef_address1")
	public WebElement inputBenefAddress1;

	@FindBy(how = How.ID, using = "benef_address2")
	public WebElement inputBenefAddress2;
	
	@FindBy(how = How.ID, using = "benef_city")
	public WebElement inputBenefCity;
	
	@FindBy(how = How.ID, using = "benef_state")
	public WebElement inputBenefState;
	
	@FindBy(how = How.ID, using = "benef_postcode")
	public WebElement inputPostcode;
	
	@FindBy(how = How.ID, using = "benef_tel")
	public WebElement inputBenefTelephone;
	
	@FindBy(how = How.ID, using = "benef_mobile")
	public WebElement inputBenefMobile;
	
	@FindBy(how = How.ID, using = "benef_email")
	public WebElement inputBenefEmail;
	
	@FindBy(how = How.ID, using = "benef_id_type")
	public WebElement ddIDType;
	
	
	@FindBy(how = How.ID, using = "benef_id_details")
	public WebElement inputBenefIDDetails;
	
	@FindBy(how = How.ID, using = "benef_ac")
	public WebElement inputAccount;
	
	
	@FindBy(how = How.ID, using = "benef_homedelivery_notes")
	public WebElement inputHomeDeliveryNotes;
	
	@FindBy(how = How.ID, using = "benef_card_number")
	public WebElement inputBenefCardNumber;
	
	@FindBy(how = How.ID, using = "benef_mobiletransfer_number")
	public WebElement inputBenefMobileTransferNumber;		
			
	@FindBy(how = How.NAME, using = "SaveBeneficiary")
	public WebElement btnSave;
	
	

	

	
	
	public void addBeneficiary(String fname, String lname, String address1, String address2, String city,String state, String postcode, String country, String telephone, String mobile, String email, String IDType, String identityDetails, String accNo, String deliveryNotes, String cardNumber, String mobileTransNumber) throws InterruptedException, AWTException
	{
		
		
	
		Thread.sleep(2000);
		
		btnAddBeneficiary.click();
		
		helper.scrollDown("400",wbdriver);
		
		inputFName.sendKeys(fname);
		inputLName.sendKeys(lname);
		inputBenefAddress1.sendKeys(address1);
		inputBenefAddress2.sendKeys(address2);
		inputBenefCity.sendKeys(city);
		inputBenefState.sendKeys(state);
		
		helper.scrollDown("400",wbdriver);
		inputPostcode.sendKeys(postcode);
		
		helper.selectValueFromDropDown("country_id", country, wbdriver);
		
		
		inputBenefTelephone.sendKeys(telephone);
		inputBenefMobile.sendKeys(mobile);
		inputBenefEmail.sendKeys(email);
		
		helper.scrollDown("450",wbdriver);
		
		// set the ID Type
		helper.selectValueFromDropDown("benef_id_type", IDType, wbdriver);
		
		inputBenefIDDetails.sendKeys(identityDetails);
		
		helper.scrollDown("500",wbdriver);
		
		inputAccount.sendKeys(accNo);
		inputHomeDeliveryNotes.sendKeys(deliveryNotes);
		inputBenefCardNumber.sendKeys(cardNumber);
		inputBenefMobileTransferNumber.sendKeys(mobileTransNumber);
		btnSave.click();
		
		
		
	}
	
}


	





