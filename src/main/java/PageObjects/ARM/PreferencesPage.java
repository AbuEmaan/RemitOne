package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
public class PreferencesPage {
	
	// initialise the page elements when the class is instantiated
	public PreferencesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
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
