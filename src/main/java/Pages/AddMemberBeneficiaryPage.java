package Pages;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.HelperFunctions;





public class AddMemberBeneficiaryPage {
	
	private WebDriver wbdriver;
	private TestContext testContext;
	// initialise the page elements when the class is instantiated
	public AddMemberBeneficiaryPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		testContext = context;
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
	
	@FindBy(how = How.NAME, using = "benef_address2")
	public WebElement inputAddress2;
	
	@FindBy(how = How.NAME, using = "benef_city")
	public WebElement inputcity;
	
	@FindBy(how = How.NAME, using = "benef_email")
	public WebElement inputEmail;
	
	
	@FindBy(how = How.NAME, using = "member_id")
	public WebElement inputMemberId;
		
	@FindBy(how = How.NAME, using = "benef_id_type")
	public WebElement inputId_type;
	
	@FindBy(how = How.NAME, using = "benef_id_details")
	public WebElement inputId_Details;
	
	@FindBy(how = How.ID, using = "input_benef_mobiletransfer_number")
	public WebElement inputMobileTransferNumber;
	
	
	@FindBy(how = How.ID, using = "benef_mobile")
	public WebElement inputMobile;
	
	@FindBy(how = How.ID, using = "benef_tel")
	public WebElement inputTel;
	
	@FindBy(how = How.NAME, using = "benef_postcode")
	public WebElement inputPostcode;
	
	@FindBy(how = How.NAME, using = "benef_state")
	public WebElement inputState;

	
	@FindBy(how = How.NAME, using = "benef_card_number")
	public WebElement inputCardNumber;

	
	
	
	// find a collection point
	@FindBy(how = How.LINK_TEXT, using = "Find Collection Point")
	public WebElement linkFindCollectionPointk;
	
	
	@FindBy(how = How.LINK_TEXT, using = "Add to Form")
	public WebElement linkAddToForm;
	

	// add branch 1
	@FindBy(how = How.LINK_TEXT, using = "Find Bank & Branch")
	public WebElement linkFindBank;
	
	
	// add branch 2
	@FindBy(how = How.XPATH, using = "(//a[text()='Find Bank & Branch'])[2]")
	public WebElement inputFindBank2;
	
	
	// add branch 3
	@FindBy(how = How.XPATH, using = "(//a[text()='Find Bank & Branch'])[2]")
	public WebElement inputFindBank3;
	
	
	
	
	// sselect branch
	@FindBy(how = How.ID, using = "select2-chosen-4")
	public WebElement inputselectBank;
	
	
	
	//div[contains(text(),'Janata Bank')]
	// or National Bank
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public WebElement btnNext;
	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Select')]")
	public WebElement linkSelect;

	// Account Numbers
	@FindBy(how = How.NAME, using = "benef_ac")
	public WebElement inputAccNo1;
	
	@FindBy(how = How.NAME, using = "benef_ac2")
	public WebElement inputAccNo2;
	
	@FindBy(how = How.NAME, using = "benef_ac3")
	public WebElement inputAccNo3;
	
	
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	
	
	public void addMemberBeneficiary(String fname, String lname, String address1, String address2, String city, String email, String memberID, String idType, String idTypeDetails, String MobileTranferNumer, String mobile, String telephone, String postcode, String state, String cardNumber,String collectionPointState, String bank1, String bank2, String bank3, String accNo1, String accNo2, String accNo3) throws InterruptedException, AWTException
	{
		
		
		
		
		linkMembers.click();
		linkAddBeneficiary.click();
		
		inputFname.sendKeys(fname);
		inputLname.sendKeys(lname);
		
		inputAddress1.sendKeys(address1);
		inputAddress2.sendKeys(address2);
		
		inputcity.sendKeys(city);
		inputEmail.sendKeys(email);
		
		inputMemberId.sendKeys(memberID);

		
		inputId_type.sendKeys(idType);
		
		inputId_Details.sendKeys(idTypeDetails);
		
		inputMobileTransferNumber.sendKeys(MobileTranferNumer);
		inputMobile.sendKeys(mobile);
		inputTel.sendKeys(telephone);
		inputPostcode.sendKeys(postcode);
		
		inputState.sendKeys(state);
		
		inputCardNumber.sendKeys(cardNumber);
		
		// Add collection point
		linkFindCollectionPointk.click();
		
		helper.getLatestWindowFocused(wbdriver);
		
		WebElement WECollectionPointState = wbdriver.findElement(By.name("state"));
		
		Select DDcollectionPointState = new Select(WECollectionPointState);
		DDcollectionPointState.selectByVisibleText(collectionPointState);
		
		btnNext.click();
		
		linkAddToForm.click();
		
		helper.getLatestWindowFocused(wbdriver);
		
		// Add branch 1
		
		linkFindBank.click();
		helper.getLatestWindowFocused(wbdriver);
		
		waitForElementToBecomeVisible(wbdriver, inputselectBank);
		
		inputselectBank.click();
		
		wbdriver.findElement(By.xpath("//div[contains(text(),'"+bank1+"')]")).click();
		
		btnNext.click();
		linkSelect.click();
		
		
		
		helper.setLastestWindow(wbdriver);
		
		// Add branch 2
		
		linkFindBank.click();
		helper.getLatestWindowFocused(wbdriver);
		waitForElementToBecomeVisible(wbdriver, inputselectBank);
				
		inputselectBank.click();
				
		wbdriver.findElement(By.xpath("//div[contains(text(),'"+bank2+"')]")).click();
				
		btnNext.click();
		linkSelect.click();
		helper.setLastestWindow(wbdriver);
				
		// Add branch 3
				
		linkFindBank.click();
		helper.getLatestWindowFocused(wbdriver);
		waitForElementToBecomeVisible(wbdriver, inputselectBank);
				
		inputselectBank.click();
				
		wbdriver.findElement(By.xpath("//div[contains(text(),'"+bank3+"')]")).click();
				
		btnNext.click();
		linkSelect.click();
		
		helper.setLastestWindow(wbdriver);
		
		
		inputAccNo1.sendKeys(accNo1);
		inputAccNo2.sendKeys(accNo2);
		inputAccNo3.sendKeys(accNo3);
		
	
		
		btnSubmit.click();
		

		
		if(!textSuccessMsg.getText().contains("Beneficiary Successfully Added"))
		{
			
			Assert.fail("Beneficiary was not added successfully");
			
			
		
			
		}
		
	
	
		
	}
	
	
	private void waitForElementToBecomeVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
}


	

