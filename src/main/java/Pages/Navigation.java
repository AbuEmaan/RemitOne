package Pages;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class Navigation {
	
	// initialise the page elemnts when the class is instantiated
	public Navigation(WebDriver driver)
	{
		PageFactory.initElements(driver,  this);
	}
	
	/*public static String text ="Preferences";
	private   String usingTextForLink= "//a[contains(text(), '"+ text + "')]";
	
	@FindBy(how = How.XPATH, using = usingTextForLink)
	public WebElement link_anylink;
	
	@FindBy(how = How.ID, using = "p_field")
	public WebElement txtbx_Password;
	
	@FindBy(how = How.NAME, using = "Submit")
	public WebElement btn_login;
	
	/*@FindBy(how = How.ID, using = "test")
	public WebElement txtbx_City;
	
	@FindBy(how = How.ID, using = "test")
	public WebElement txtbx_Postcode;
	*/
	
	
	
	public void clickLink(String linkText) throws InterruptedException
	{
		
		
	}
	
}
