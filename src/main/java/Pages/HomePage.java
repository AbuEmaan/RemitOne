package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import TestContext.TestContext;
 
public class HomePage {
	private WebDriver driver;
	private TestContext testContext;
	ConfigFileReader configFileReader;
	
	public  HomePage(WebDriver driver, TestContext context) {
		PageFactory.initElements(driver,  this);
		this.driver = driver;
		testContext = context;
		configFileReader= new ConfigFileReader();
	}
	

	public void navigateTo_HomePage(String site) {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl(site));
	}
}

