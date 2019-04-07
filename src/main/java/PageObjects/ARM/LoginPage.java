package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import TestContext.TestContext;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
public class LoginPage {
	
	
	private WebDriver driver;
	private TestContext testContext;
	// initialise the page elemnts when the class is instantiated
	public LoginPage(WebDriver driver, TestContext context)
	{
		PageFactory.initElements(driver,  this);
		this.driver = driver;
		testContext = context;
	}
	
	
	@FindBy(how = How.ID, using = "u_field")
	public WebElement txtbx_username;
	
	@FindBy(how = How.ID, using = "p_field")
	public WebElement txtbx_Password;
	
	@FindBy(how = How.NAME, using = "Submit")
	public WebElement btn_login;
	

	// Logout
	@FindBy(how = How.ID, using = "logoutButton")
	public WebElement btn_logout;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	
	public void loginadmin(String username, String password) throws InterruptedException
	{
		
		txtbx_username.sendKeys(username);
		txtbx_Password.sendKeys(password);
		btn_login.click();
		
		if(driver.findElements(By.name("skip")).size()!=0)
			driver.findElement(By.name("skip")).click();
				
	}
	
	public void logout()  
	{
		
		btn_logout.click();
		
		if (!textSuccessMsg.getText().contains("Thank you - you have successfully logged out of the system.")) {

			Assert.fail("processing bank was not added successfully");

		}
		
	}
	
}
