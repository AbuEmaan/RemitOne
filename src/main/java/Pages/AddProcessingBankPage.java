package Pages;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProcessingBankPage {

	private WebDriver wbdriver;
	private TestContext testContext;

	// initialise the page elements when the class is instantiated
	public AddProcessingBankPage(WebDriver driver, TestContext context) {
		PageFactory.initElements(driver, this);
		wbdriver = driver;
		testContext = context;
	}

	@FindBy(how = How.ID, using = "menu-procBanks")
	public WebElement linkProcessBanks;

	@FindBy(how = How.ID, using = "menu-procBanks-listBanks")
	public WebElement linkListProcessBank;

	@FindBy(how = How.XPATH, using = "//span[text()='Add Processing Bank']")
	public WebElement linkAddProcessingBank;
	
	
	@FindBy(how = How.NAME, using = "fname")
	public WebElement inputfname;

	@FindBy(how = How.NAME, using = "lname")
	public WebElement inputlname;

	@FindBy(how = How.CLASS_NAME, using = "new_username_show")
	public WebElement inputusername;
	
	@FindBy(how = How.CLASS_NAME, using = "new_password_show")
	public WebElement inputpassword;
	
	
	@FindBy(how = How.NAME, using = "full_bank_name")
	public WebElement inputfullbankName;

	@FindBy(how = How.NAME, using = "bank_name")
	public WebElement inputbankName;
	
	@FindBy(how = How.NAME, using = "bank_code")
	public WebElement inputbankCode;

	@FindBy(how = How.NAME, using = "address1")
	public WebElement inputBankAddress;
	
	@FindBy(how = How.NAME, using = "town")
	public WebElement inputBankTown;
	
	@FindBy(how = How.NAME, using = "email")
	public WebElement inputEmail;
	
	@FindBy(how = How.NAME, using = "parent_bank_super_id")
	public WebElement inputBankSuperID;
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btnSubmit;

	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;

	public void setProcessingBank( String fname, String lname, String username, String password, String fullBankName, String bankName, String bankCode, String bankAddress, String town, String bankCountry, String email, String bankSuperID)
			throws InterruptedException {

		linkProcessBanks.click();
		linkListProcessBank.click();
		linkAddProcessingBank.click();
		

		inputfname.sendKeys(fname);
		inputlname.sendKeys(lname);
		inputusername.sendKeys(username);
		inputpassword.sendKeys(password);
		inputfullbankName.sendKeys(fullBankName);
		
		
		
		inputbankName.sendKeys(bankName);
		inputbankCode.sendKeys(bankCode);
		inputBankAddress.sendKeys(bankAddress);
		inputBankTown.sendKeys(town);
		
		selectValueFromDropDown("country", bankCountry);

		inputEmail.sendKeys(email);
		inputBankSuperID.sendKeys(bankSuperID);
		
		
		btnSubmit.click();

		if (!textSuccessMsg.getText().contains("added successfully")) {

			Assert.fail("processing bank was not added successfully");

		}

	}

	public void selectValueFromDropDown(String id, String valueToSelect) {

		List<WebElement> options = this.wbdriver.findElements(By.xpath("//select[@id ='" + id + "']/option"));

		for (WebElement option : options) {
			System.out.println(option.getText());
			if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
				option.click();
				break;
			}
		}
	}

}
