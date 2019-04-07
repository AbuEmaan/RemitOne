package Pages;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;
import java.awt.AWTException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Helpers.HelperFunctions;

public class SendMoneyProcessPage {
	
	private WebDriver wbdriver;
	private TestContext testContext;
	HelperFunctions helper = new HelperFunctions();
	
	// initialise the page elements when the class is instantiated
	public SendMoneyProcessPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		testContext = context;
	}
	
	
	
	// select beneficiary
	@FindBy(how = How.ID, using = "menu-send-money")
	public WebElement btnSendMoney;
	
	@FindBy(how = How.XPATH, using = "//legend[text()='Beneficiary']")
	public WebElement lblBeneficiaryPageTitle;

	@FindBy(how = How.ID, using = "step0Next")
	public WebElement btnNextOnBeneficiary;
	

	
	//Account type
	@FindBy(how = How.XPATH, using = "//legend[text()='Transfer Type')]")
	public WebElement lblAccountTransferPageTitle;

	
	@FindBy(how = How.ID, using = "step1Next")
	public WebElement btnNextOnAccountType;
	
	// Transfer details		
	@FindBy(how = How.XPATH, using = "//legend[contains(.,'Transfer Details')]")
	public WebElement lblTransferDetailsPageTitle;

	@FindBy(how = How.LINK_TEXT, using ="Find Collection Point")
	public WebElement linkFinColectionPoint;
	
	@FindBy(how = How.ID, using = "collectionpointfinder_ok_button")
	public WebElement btnCollectionPointFrinder;
	
	@FindBy(how = How.ID, using = "step2Next")
	public WebElement btnNextOnTransferDetails;

	
	
	// Select beneficiary
	
	public void selectBeneficiary(String beneficiaryName) 
	{
		
		System.out.println("in side func select benef");
		//btnSendMoney.click();
		//Thread.sleep(3000);
		lblBeneficiaryPageTitle.isDisplayed();
		
	
		wbdriver.findElement(By.xpath(".//label[contains(.,'"+ beneficiaryName +"')]"));
		
		helper.scrollDown("400",wbdriver);
		
		btnNextOnBeneficiary.click();

	}
	
	
	// Select account type
	
	public void selectAccountType(String transferType) 
	{
		
		
		lblAccountTransferPageTitle.isDisplayed();
		
		wbdriver.findElement(By.xpath("//label[text()='"+ transferType+"']"));
		
		helper.scrollDown("400",wbdriver);
		
		btnNextOnAccountType.click();

	}
	
	// Select Transfer details
	
	public void selectTransferDetails(String state) 
	{
		
		
		lblTransferDetailsPageTitle.isDisplayed();
		
		linkFinColectionPoint.click();
		
		helper.setLastestWindow(wbdriver);
		
		
		
		helper.selectValueFromDropDown("collection_point_finder_state", state, wbdriver);
		
		btnCollectionPointFrinder.click();
		helper.setLastestWindow(wbdriver);
		
		helper.scrollDown("400",wbdriver);
		
		btnNextOnAccountType.click();

	}
		
		
		

	
	
}


	






