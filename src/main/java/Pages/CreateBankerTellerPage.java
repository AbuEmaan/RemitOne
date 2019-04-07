package Pages;

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
import TestContext.TestContext;




public class CreateBankerTellerPage {
	
	private WebDriver wbdriver;
	private TestContext testContext;
	// initialise the page elements when the class is instantiated
	public CreateBankerTellerPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		testContext = context;
	}
	
	HelperFunctions helper = new HelperFunctions();
	
	
	//*[@id="menu-members"]
	@FindBy(how = How.XPATH, using = "//li[@id='menu-members' and @class='dropdown-parent']")
	public WebElement linkMembers;
	
	@FindBy(how = How.ID, using = "menu-members-addRemitter")
	public WebElement linkAddRemitter;
	
	@FindBy(how = How.ID, using = "u_field")
	public WebElement inputUserField1;
	
	@FindBy(how = How.ID, using = "p_field")
	public WebElement inputPassword1;
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;
	      
		
	@FindBy(how = How.ID, using = "old_password")
	public WebElement inputOldPassword;
	
	@FindBy(how = How.ID, using = "new_password")
	public WebElement inputNewPassword;
	
	@FindBy(how = How.ID, using = "new_password_confirm")
	public WebElement inputConfirmNewPassword;
	
	@FindBy(how = How.ID, using = "menu-tellers-add")
	public WebElement linkTellersAdd;
			
			
	@FindBy(how = How.NAME, using = "fname")
	public WebElement inputfname;
	
	@FindBy(how = How.NAME, using = "lname")
	public WebElement inputlname;
	
	@FindBy(how = How.NAME, using = "username")
	public WebElement inputUsername;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement inputPassword;
	
			
				
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	
	public void createBankTeller(String fname, String lname,String gender, String dob, String address1, String postcode,String nationality, String telephone,String mobile,String email,String address2,String idType,String idTypeDetails, String idexpiryDate) throws InterruptedException, AWTException
	{
		
		linkMembers.click();
		linkAddRemitter.click();
		
		/*
		inputFname.sendKeys(fname);
		inputLname.sendKeys(lname);
		inputdob.sendKeys(dob);
		
		WebElement Nationality = wbdriver.findElement(By.name("nationality"));
		
		Select ddNationality = new Select(Nationality);
		ddNationality.selectByVisibleText(nationality);
		
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


	
