package PageObjects.ARM;

import org.openqa.selenium.chrome.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import Helpers.HelperFunctions;
import Helpers.HelperFunctions.*;





public class AddBeneficiaryPage {
	
	WebDriver wbdriver;
	// initialise the page elements when the class is instantiated
	public AddBeneficiaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
	}
	
	HelperFunctions helper = new HelperFunctions();
	
	
	//*[@id="menu-members"]
	@FindBy(how = How.XPATH, using = "//li[@id='menu-members' and @class='dropdown-parent']")
	public WebElement linkMembers;
	
	@FindBy(how = How.ID, using = "menu-members-addBenef")
	public WebElement linkAddBeneficiary;
	
	@FindBy(how = How.ID, using = "benef_fname")
	public WebElement inputFname;
	
	@FindBy(how = How.ID, using = "benef_lname")
	public WebElement inputLname;
		
	@FindBy(how = How.NAME, using = "benef_address1")
	public WebElement inputAddress1;
	
	@FindBy(how = How.NAME, using = "benef_city")
	public WebElement inputcity;
	
	@FindBy(how = How.NAME, using = "benef_address2")
	public WebElement inputAddress2;
	
	@FindBy(how = How.NAME, using = "benef_state")
	public WebElement inputState;
	
	@FindBy(how = How.NAME, using = "benef_city")
	public WebElement inputcity2;
	
	@FindBy(how = How.NAME, using = "benef_tel")
	public WebElement inputTel;
	
	@FindBy(how = How.NAME, using = "benef_mobile")
	public WebElement inputMobile;
	
	@FindBy(how = How.NAME, using = "benef_email")
	public WebElement inputEmail;
	
	@FindBy(how = How.NAME, using = "member_id")
	public WebElement inputMemberId;
	
	@FindBy(how = How.NAME, using = "benef_id_type")
	public WebElement inputId_type;
	
	@FindBy(how = How.NAME, using = "benef_id_details")
	public WebElement inputId_Details;
	
	@FindBy(how = How.NAME, using = "benef_card_number")
	public WebElement inputCardNumber;
	
	@FindBy(how = How.LINK_TEXT, using = "Find Bank & Branch")
	public WebElement inputFindBank;
			
	
	
	
	@FindBy(how = How.NAME, using = "id1_scan1")
	public WebElement inputIDScans;

	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	
	public void addBeneficiary(String fname, String lname,String gender, String dob, String address1, String postcode,String nationality, String telephone,String mobile,String email,String address2,String idType,String idTypeDetails, String idexpiryDate) throws InterruptedException, AWTException
	{
		
		linkMembers.click();
		linkAddBeneficiary.click();
		
		inputFname.sendKeys(fname);
		inputLname.sendKeys(lname);

		
		WebElement Nationality = wbdriver.findElement(By.name("nationality"));
		
		Select ddNationality = new Select(Nationality);
		ddNationality.selectByVisibleText(nationality);
		
	/*
		inputAddress1.sendKeys(address1);
		inputPostcode.sendKeys(postcode);
	
		WebElement Gender = wbdriver.findElement(By.name("gender"));
		
		Select ddGender = new Select(Gender);
		ddGender.selectByVisibleText(gender);
		
		
		inputTelephone.sendKeys(telephone);
		inputMobile.sendKeys(mobile);
		inputEmail.sendKeys(email);
		inputAddress2.sendKeys(address2);		
		
		WebElement IDType = wbdriver.findElement(By.name("id1_type"));
		
		Select ddIDType = new Select(IDType);
		ddIDType.selectByVisibleText(idType);
		
		inputIDTypeDetails.sendKeys(idTypeDetails);
		
		inputExpiry.sendKeys(idexpiryDate);
		
		
		inputIDScans.click();

		helper.uploadFile("uploadFile.PNG");
		
		
		btnSubmit.click();
		

		
		if(!textSuccessMsg.getText().contains("added successfully"))
		{
			
			Assert.fail("Remitter was not added successfully");
			
			
		
			
		}
		
		*/
	
		
	}
	
	
	
	
	
	
	
}


	

