package Pages;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
public class PreferencesPage {
	
	private WebDriver wbdriver;
	private TestContext testContext;
	// initialise the page elements when the class is instantiated
	public PreferencesPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		wbdriver = driver;
		testContext = context;
	}
	
		
	@FindBy(how = How.ID, using = "old_password")
	public WebElement txtbx_oldPwd;
	
	@FindBy(how = How.ID, using = "new_password")
	public WebElement txtbx_newPwd;
	
	@FindBy(how = How.ID, using = "new_password_confirm")
	public WebElement txtbx_confirmPwd;
	
	@FindBy(how = How.NAME, using = "submit")
	public WebElement btn_submit;
	
	
	
	
	public void changePassword(String oldPassword, String newPassword, String confirmNewPassword) throws InterruptedException
	{
		
		txtbx_oldPwd.sendKeys(oldPassword);
		txtbx_newPwd.sendKeys(newPassword);
		txtbx_confirmPwd.sendKeys(confirmNewPassword);
		
		btn_submit.click();
		
	
		
	}
	
}
