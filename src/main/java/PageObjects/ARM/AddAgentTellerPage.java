package PageObjects.ARM;

import org.openqa.selenium.chrome.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class AddAgentTellerPage {
	
	// initialise the page elements when the class is instantiated
	public AddAgentTellerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
	}
	
		
	@FindBy(how = How.XPATH, using = "(//li[@id='menu-agents'])[2]")
	public WebElement linkAgents;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Agent Teller']")
	public WebElement linkaddAgent;
	
	@FindBy(how = How.NAME, using = "fname")
	public WebElement inputfname;
	
	@FindBy(how = How.NAME, using = "lname")
	public WebElement inputlname;
	
	@FindBy(how = How.NAME, using = "email")
	public WebElement inputemail;
	
	@FindBy(how = How.CLASS_NAME, using = "username_show")
	public WebElement inputUsername;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement inputPassword;
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-button']")
	public WebElement btnSubmit;
	
	@FindBy(how = How.ID, using = "success-message")
	public WebElement textSuccessMsg;
	
	
	public void addTellerAgent(String fname, String lname, String email, String username, String password) throws InterruptedException
	{
		
		linkAgents.click();
		linkaddAgent.click();
		
		inputfname.sendKeys(fname);
		inputlname.sendKeys(lname);
		inputemail.sendKeys(email);
		
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		
		
		btnSubmit.click();
		
		if(!textSuccessMsg.getText().contains("added successfully"))
		{
			
			Assert.fail("Source Country was not added successfully");
			
		}
		
	
		
	}
	
}


	
