package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

import managers.PageObjectManager;
import managers.FileReaderManager;
import PageObjects.ARM.AddAgentTellerPage;
import PageObjects.ARM.AddCollectionPointPage;
import PageObjects.ARM.AddDeliveryBankPage;
import PageObjects.ARM.AddDestinationCountryPage;
import PageObjects.ARM.AddProcessingBankPage;
import PageObjects.ARM.AddRemitterPage;
import PageObjects.ARM.AddSourceCountryPage;
import PageObjects.ARM.HomePage;
import PageObjects.ARM.LoginPage;
import PageObjects.ARM.PreferencesPage;
import PageObjects.ARM.AddAgentPage;
import PageObjects.ARM.SetDestinationConversionRate;
import PageObjects.ARM.SetSourceCoversionRatesPage;
import PageObjects.ARM.ORM.QuickRegistrationPage;
import PageObjects.ARM.ORM.ProfilePage;
import PageObjects.ARM.ORM.AddBeneficiaryPage;


import managers.WebDriverManager;
import Helpers.HelperFunctions;



public class RemitOneStepDefinitions {
	WebDriver driver;
	LoginPage loginPage;
	AddSourceCountryPage addSourceCountryPage;
	HomePage homePage;
	AddDestinationCountryPage addDestinationCountryPage;
	PreferencesPage preferencesPage;
	SetSourceCoversionRatesPage setSourceCoversionRatesPage;
	SetDestinationConversionRate setDestinationConversionRate;
	AddDeliveryBankPage addDeliveryBankPage;
	AddCollectionPointPage addCollectionPointPage;
	AddProcessingBankPage addProcessingBankPage;
	AddAgentTellerPage addAgentTellerPage;
	QuickRegistrationPage quickRegistrationPage;
	AddAgentPage addAgentPage;
	AddRemitterPage addRemitterPage;
	ProfilePage profilePage;
	AddBeneficiaryPage addBeneficiaryPage;

	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	

	HelperFunctions helper = new HelperFunctions();

	@Before
	public void setup() {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
	}

	@Given("^user is on the \"([^\"]*)\" landing page$")
	public void user_is_on_the_landing_page(String site) throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage(site);
		
		// close the cookie button
		if(driver.findElement(By.linkText("Close")).isDisplayed())
			driver.findElement(By.linkText("Close")).click();
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = pageObjectManager.getLoginPage();
		loginPage.loginadmin(username, password);

	}

	@Then("^user clicks the logout link$")
	public void user_clicks_the_logout_link() throws Throwable {

		loginPage = pageObjectManager.getLoginPage();
		loginPage.logout();
	}

	@Then("^the \"([^\"]*)\" page is displayed$")
	public void the_page_is_displayed(String pageHeader) throws Throwable {

		driver.findElement(By.xpath("//h1[contains(text(), '" + pageHeader + "')]")).isDisplayed();

	}

	@When("^the User clicks the \"([^\"]*)\" link$")
	public void the_User_clicks_the_link(String navigationLink) throws Throwable {

		driver.findElement(By.xpath("//a[contains(text(), '" + navigationLink + "')]")).click();
	}

	@When("^user changes password by entering the old password \"([^\"]*)\" and the new password \"([^\"]*)\" and confirmed new password \"([^\"]*)\" and clicks continue$")
	public void user_changes_password(String oldPWD, String newPWD, String confirmedPWD) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		pageObjectManager = new PageObjectManager(driver);
		preferencesPage = pageObjectManager.getPreferencesPage();
		preferencesPage.changePassword(oldPWD, newPWD, confirmedPWD);

	}

	@Then("^the user adds the source country as \"([^\"]*)\" and currency as \"([^\"]*)\" and WalletEnabled is set to \"([^\"]*)\"$")
	public void the_user_adds_the_source_country_as_and_currency_as_and_WalletEnabled_is_set_to(String country,
			String currency, String walletEnabled) throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		addSourceCountryPage = pageObjectManager.getAddSourceCountryPage();
		addSourceCountryPage.setSourceCountry(country, currency, walletEnabled);
	}

	@Then("^the user adds the destination country as \"([^\"]*)\"$")
	public void the_user_adds_the_destination_country_as(String country) throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		addDestinationCountryPage = pageObjectManager.getAddDestinationCountryPage();
		addDestinationCountryPage.setDestinationCountry(country);
	}

	@Then("^the user adds source destination rates for euro \"([^\"]*)\" and usd \"([^\"]*)\"$")
	public void the_user_adds_source_destination_rates_for_euro_and_usd(String euroRate, String usdRate)
			throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		setSourceCoversionRatesPage = pageObjectManager.getSetSourceConversionRatesPage();
		setSourceCoversionRatesPage.setSourceConversionRates(euroRate, usdRate);
	}

	@Then("^user adds a deliver bank \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_deliver_bank(String name, String code, String address, String city, String state)
			throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		addDeliveryBankPage = pageObjectManager.getAddDeliveryBankPage();
		addDeliveryBankPage.setDeliveryBank(name, code, address, city, state);
	}

	@Then("^user adds a collection point \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_collection_point(String CPName, String CPCode, String CPBankName, String CPAddress,
			String CPCity, String CPState) throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		addCollectionPointPage = pageObjectManager.getAddCollectionPointPage();
		addCollectionPointPage.setCollectionPoint(CPName, CPCode, CPBankName, CPAddress, CPCity, CPState);
	}

	@Then("^the user adds  destination rates \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_adds_destination_conversion_rates(String firstRate, String secRate, String thirdRate)
			throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		setDestinationConversionRate = pageObjectManager.getSetDestinationConversionRatesPage();
		setDestinationConversionRate.setDestinationConversionRates(firstRate, secRate, thirdRate);
	}

	@Then("^user adds a processing  bank \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_processing_bank(String firstName, String lastName, String userName, String password,
			String fullBankName, String bankName, String bankCode, String bankAddress, String town, String bankCountry,
			String email, String bankSuperID) throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		addProcessingBankPage = pageObjectManager.getAddProcessingBankPage();
		addProcessingBankPage.setProcessingBank(firstName, lastName, userName, password, fullBankName, bankName,
				bankCode, bankAddress, town, bankCountry, email, bankSuperID);
	}

	@Then("^user adds a teller agent \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_add_teller_agent(String firstName, String lastName, String email, String userName, String password)
			throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		addAgentTellerPage = pageObjectManager.getaddAgentTellerPage();
		addAgentTellerPage.addTellerAgent(firstName, lastName, email, userName, password);
	}
	
	
	
	
	@Then("^user adds an agent$")
	public void user_adds_an_agent(DataTable agentDetails) throws Throwable {
		

			List<List<String>> data = agentDetails.raw();
			
			pageObjectManager = new PageObjectManager(driver);
			addAgentPage = pageObjectManager.getAddAgentPage();
			addAgentPage.addAgent(data.get(0).get(0),data.get(0).get(1),data.get(0).get(2),data.get(0).get(3),data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8), data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12), data.get(0).get(13),data.get(0).get(14),data.get(0).get(15));
			
				
		
		}
		
	
	
	
	@Then("^user adds a remitter$")
	public void user_adds_a_remitter(DataTable remitterDetails) throws Throwable {
		

			List<List<String>> data = remitterDetails.raw();
			
			pageObjectManager = new PageObjectManager(driver);
			addRemitterPage = pageObjectManager.getAddRemitterPage();
			addRemitterPage.addRemitter(data.get(0).get(0),data.get(0).get(1),data.get(0).get(2),data.get(0).get(3),data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8), data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12), data.get(0).get(13));
			
		
				
			
			
		
		}
	
	
	
	// ================================================================
	// ============================= ORM ==============================
	// ================================================================
	
	@When("^user completes the registration form and submits$")
	public void user_completes_the_registration_form_on_the_ORM_site(DataTable registrationDetails) throws Throwable {

		List<List<String>> data = registrationDetails.raw();
		
		pageObjectManager = new PageObjectManager(driver);
		quickRegistrationPage = pageObjectManager.getQuickRegistrationPage();
		quickRegistrationPage.qucikRegistration(data.get(0).get(0),data.get(0).get(1),data.get(0).get(2),data.get(0).get(3),data.get(0).get(4), data.get(0).get(5), data.get(0).get(6));
	}
	
	
	@When("^the user clicks the logout link$")
	public void the_user_clicks_the_logout_link() throws Throwable {
	  
		
		helper.hoverOverObject(By.xpath("//span[contains(@class,'username')]"),driver);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='icon-key']")).click();
		
	}
	
	

	@Then("^The logout message is displayed$")
	public void the_logout_message_is_displayed() throws Throwable {
   
		System.out.println("logout message tb done");
	}
	
	
	@Then("^user logs in with his credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logs_in_with_his_credentials(String username, String password) throws Throwable {
	   
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
	
	@Then("^the user is displayed a welcome message$")
	public void the_user_is_displayed_a_welcome_message() throws Throwable {
		
		System.out.println("login message tb done");
	}

	
	@When("^user clicks on the my profile link$")
	public void user_clicks_on_the_my_profile_link() throws Throwable {
	    
		helper.hoverOverObject(By.xpath("//span[contains(@class,'username')]"),driver);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='icon-user']")).click();
	}

	@When("^users edits the profile$")
	public void users_edits_the_profile(DataTable profileDetails) throws Throwable {
	   
		List<List<String>> data = profileDetails.raw();
		
		pageObjectManager = new PageObjectManager(driver);
		profilePage = pageObjectManager.getProfilePage();
		
		profilePage.editProfile(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3), data.get(0).get(4),data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8), data.get(0).get(9), data.get(0).get(10));
		
		
	}
	
	
	@When("^user adds beneficiary$")
	public void user_adds_beneficiary(DataTable beneficiaryDetails) throws Throwable {
		List<List<String>> data = beneficiaryDetails.raw();
		
		pageObjectManager = new PageObjectManager(driver);
		addBeneficiaryPage = pageObjectManager.getAddBeneficiaryPage();
		
		addBeneficiaryPage.addBeneficiary(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3), data.get(0).get(4),data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8), data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12), data.get(0).get(13), data.get(0).get(14), data.get(0).get(15), data.get(0).get(16));
		
		
		
	}

	
	
	

		@When("^user changes language to \"([^\"]*)\"$")
		public void user_changes_language_to(String language) throws Throwable {
			
			helper.hoverOverObject(By.xpath("//img[@class='flag-img']"),driver);
			
			 Thread.sleep(2000);
			
			 driver.findElement(By.xpath("//a[contains(text(),'Thai')]")).click();
			 
			 
			//driver.findElement(By.xpath("//a[text()='"+language+"']")).click();
		}

		@Then("^language changed message is displayed$")
		public void language_changed_message_is_displayed() throws Throwable {
		    
			System.out.println("language is changed needs to be displayed");
			//driver.findElement(By.xpath("//span[@class='Enlish']")).click();
		}
	
		
		

		@When("^user clicks the \"([^\"]*)\" link$")
		public void user_clicks_the_link(String link) throws Throwable {
	
			driver.findElement(By.linkText(link)).click();
		}

		
	

		@Then("^the user is displayed with the following message \"([^\"]*)\"$")
		public void the_user_is_displayed_with_the_following_message(String messageDisplayed) throws Throwable {
		   
		
			
			if(!driver.getPageSource().contains(messageDisplayed))
			{
				
				Assert.fail("The Message '"+ messageDisplayed+"' was not displayed");
			
			}
			
		}



		
	
	// ================================================================
	// ======================  WEBSERVICE =============================
	// ================================================================

	@When("^user click on webservice \"([^\"]*)\"$")
	public void user_click_on_webservice(String serviceName) throws Throwable {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[text()='" + serviceName + "']")); // a[text()='searchRemitter']
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.xpath("//a[text()='" + serviceName + "']")).click();

	}

	@Then("^user validates the search Remitter Agent web service$")
	public void user_validates_the_search_Remitter_Agent_web_service(DataTable remitterDetails) throws Throwable {

		List<List<String>> data = remitterDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));

		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));

		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));

		driver.findElement(By.name("remitter_id")).sendKeys(data.get(0).get(3));

		driver.findElement(By.name("firstname")).sendKeys(data.get(0).get(4));

		driver.findElement(By.name("lastname")).sendKeys(data.get(0).get(5));

		driver.findElement(By.name("city")).sendKeys(data.get(0).get(6));

		driver.findElement(By.name("email")).sendKeys(data.get(0).get(7));

		driver.findElement(By.name("remitter_type")).sendKeys(data.get(0).get(8));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {

			Assert.fail("The Webservice: search Remitter failed");
			System.out.println(driver.findElement(By.xpath("//message")).getText());

		} else {

			Assert.assertTrue(true);
		}

	}

	@Then("^user validates the create Remitter Agent web service$")
	public void user_validates_the_create_Remitter_Agent_web_service(DataTable remitterDetails) throws Throwable {

		
		
		List<List<String>> data = remitterDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));

		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));

		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));

		driver.findElement(By.name("firstname")).sendKeys(data.get(0).get(3));

		driver.findElement(By.name("lastname")).sendKeys(data.get(0).get(4));

		driver.findElement(By.name("nationality")).sendKeys(data.get(0).get(5));

		driver.findElement(By.name("type")).sendKeys(data.get(0).get(6));

		driver.findElement(By.name("status")).sendKeys(data.get(0).get(7));

		driver.findElement(By.name("address1")).sendKeys(data.get(0).get(8));
		driver.findElement(By.name("address2")).sendKeys(data.get(0).get(9));
		driver.findElement(By.name("city")).sendKeys(data.get(0).get(10));
		driver.findElement(By.name("postcode")).sendKeys(data.get(0).get(11));

		driver.findElement(By.name("email")).sendKeys(data.get(0).get(12));
		driver.findElement(By.name("telephone")).sendKeys(data.get(0).get(13));
		driver.findElement(By.name("mobile")).sendKeys(data.get(0).get(14));
		driver.findElement(By.name("dob")).sendKeys(data.get(0).get(15));

		driver.findElement(By.name("id_type")).sendKeys(data.get(0).get(16));
		driver.findElement(By.name("id_details")).sendKeys(data.get(0).get(17));
		driver.findElement(By.name("id_expiry")).sendKeys(data.get(0).get(18));
		driver.findElement(By.name("account_number")).sendKeys(data.get(0).get(19));

		driver.findElement(By.name("sort_code")).sendKeys(data.get(0).get(20));

		driver.findElement(By.name("id1_scan")).click();
	

	

		helper.uploadFile("uploadFile.PNG");
		
		

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create Remitter failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	@Then("^user validates the create Beneficiary Agent web service$")
	public void user_validates_the_create_Beneficiary_Agent_web_service(DataTable beneficiaryDetails) throws Throwable
	{
		
	List <List<String>> data = beneficiaryDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
		
		driver.findElement(By.name("name")).sendKeys(data.get(0).get(3));
		
		driver.findElement(By.name("address1")).sendKeys(data.get(0).get(4));
		
		driver.findElement(By.name("address2")).sendKeys(data.get(0).get(5));
		
		driver.findElement(By.name("city")).sendKeys(data.get(0).get(6));
		driver.findElement(By.name("state")).sendKeys(data.get(0).get(7));
		driver.findElement(By.name("postcode")).sendKeys(data.get(0).get(8));
		
		driver.findElement(By.name("country")).sendKeys(data.get(0).get(9));	
		driver.findElement(By.name("dob")).sendKeys(data.get(0).get(10));
		
		driver.findElement(By.name("telephone")).sendKeys(data.get(0).get(11));
		
		driver.findElement(By.name("id_type")).sendKeys(data.get(0).get(12));
		

		driver.findElement(By.name("id_details")).sendKeys(data.get(0).get(13));
		driver.findElement(By.name("card_number")).sendKeys(data.get(0).get(14));
		
		driver.findElement(By.name("account_number")).sendKeys(data.get(0).get(15));
		driver.findElement(By.name("bank")).sendKeys(data.get(0).get(16));
		driver.findElement(By.name("bank_branch")).sendKeys(data.get(0).get(17));
		driver.findElement(By.name("bank_branch_city")).sendKeys(data.get(0).get(18));
		
		
		driver.findElement(By.name("bank_branch_state")).sendKeys(data.get(0).get(19));
		driver.findElement(By.name("benef_bank_swift_code")).sendKeys(data.get(0).get(20));
		driver.findElement(By.name("remitter_id")).sendKeys(data.get(0).get(21));
		
		driver.findElement(By.id("id_scan")).click();
		

		

		helper.uploadFile("uploadFile.png");
		
		
		
		driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	@Then("^user validates the create Transaction Agent web service$")
	public void user_validates_the_create_Transaction_Agent_web_service(DataTable transactionDetails) throws Throwable
	{
		
	List <List<String>> data = transactionDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(3));
	driver.findElement(By.name("remitter_id")).sendKeys(data.get(0).get(4));
	driver.findElement(By.name("beneficiary_id")).sendKeys(data.get(0).get(5));
	driver.findElement(By.name("destination_country")).sendKeys(data.get(0).get(6));
	driver.findElement(By.name("trans_type")).sendKeys(data.get(0).get(7));
	driver.findElement(By.name("purpose")).sendKeys(data.get(0).get(8));
	driver.findElement(By.name("source_of_income")).sendKeys(data.get(0).get(9));
	driver.findElement(By.name("payment_method")).sendKeys(data.get(0).get(10));
	driver.findElement(By.name("service_level")).sendKeys(data.get(0).get(11));
	driver.findElement(By.name("amount_type")).sendKeys(data.get(0).get(12));
	driver.findElement(By.name("amount_to_send")).sendKeys(data.get(0).get(13));

		
		driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	
	@Then("^user validates the get sell rates web service$")
	public void user_validates_the_get_sell_rates_web_service(DataTable sellRatesDetails) throws Throwable
	{
		
	List <List<String>> data = sellRatesDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("source_country")).sendKeys(data.get(0).get(3));
	driver.findElement(By.name("destination_country")).sendKeys(data.get(0).get(4));
		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	
	
	@Then("^user validates the confirm transaction web service$")
	public void user_validates_the_confirm_transaction_web_service(DataTable confirmTransactionDetails) throws Throwable
	{
		
	List <List<String>> data = confirmTransactionDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("trans_session_id")).sendKeys(data.get(0).get(3));

		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}

	
	@Then("^user validates the get transaction detail web service$")
	public void user_validates_the_get_transaction_detail_web_service(DataTable TransactionDetails) throws Throwable
	{
		
	List <List<String>> data = TransactionDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("trans_ref")).sendKeys(data.get(0).get(3));

		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	
	@Then("^user validates the insert transaction detail web service$")
	public void user_validates_the_insert_transaction_web_service(DataTable TransactionDetails) throws Throwable
	{
		
	List <List<String>> data = TransactionDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("agent_trans_ref")).sendKeys(data.get(0).get(3));
	driver.findElement(By.name("trans_type")).sendKeys(data.get(0).get(4));
	driver.findElement(By.name("purpose")).sendKeys(data.get(0).get(5));
	driver.findElement(By.name("source_of_income")).sendKeys(data.get(0).get(6));
	driver.findElement(By.name("remitt_name")).sendKeys(data.get(0).get(7));
	driver.findElement(By.name("remitt_id_type")).sendKeys(data.get(0).get(8));
	driver.findElement(By.name("remitt_nationality")).sendKeys(data.get(0).get(9));
	driver.findElement(By.name("remitt_dob")).sendKeys(data.get(0).get(10));
	driver.findElement(By.name("remitt_addr")).sendKeys(data.get(0).get(11));
	driver.findElement(By.name("remitt_tel")).sendKeys(data.get(0).get(12));
	driver.findElement(By.name("remitt_id_details")).sendKeys(data.get(0).get(13));
	driver.findElement(By.name("benef_name")).sendKeys(data.get(0).get(14));
	driver.findElement(By.name("benef_address")).sendKeys(data.get(0).get(15));
	driver.findElement(By.name("benef_address2")).sendKeys(data.get(0).get(16));
	driver.findElement(By.name("benef_address")).sendKeys(data.get(0).get(17));
	driver.findElement(By.name("benef_city")).sendKeys(data.get(0).get(18));
	driver.findElement(By.name("benef_state")).sendKeys(data.get(0).get(19));
	driver.findElement(By.name("benef_postcode")).sendKeys(data.get(0).get(20));
	driver.findElement(By.name("benef_tel")).sendKeys(data.get(0).get(21));
	driver.findElement(By.name("benef_mobile")).sendKeys(data.get(0).get(22));
	driver.findElement(By.name("benef_id_type")).sendKeys(data.get(0).get(23));
	driver.findElement(By.name("benef_id_details")).sendKeys(data.get(0).get(24));
	driver.findElement(By.name("benef_ac")).sendKeys(data.get(0).get(25));
	driver.findElement(By.name("benef_bank")).sendKeys(data.get(0).get(26));
	driver.findElement(By.name("benef_bank_swift_code")).sendKeys(data.get(0).get(27));
	driver.findElement(By.name("benef_branch")).sendKeys(data.get(0).get(28));
	driver.findElement(By.name("benef_branch_code")).sendKeys(data.get(0).get(29));
	driver.findElement(By.name("payment_method")).sendKeys(data.get(0).get(30));
	driver.findElement(By.name("source_currency")).sendKeys(data.get(0).get(31));
	driver.findElement(By.name("source_amount")).sendKeys(data.get(0).get(32));
	driver.findElement(By.name("dest_currency")).sendKeys(data.get(0).get(33));
	driver.findElement(By.name("dest_amount")).sendKeys(data.get(0).get(34));
	driver.findElement(By.name("rate")).sendKeys(data.get(0).get(35));
	driver.findElement(By.name("commission")).sendKeys(data.get(0).get(36));
	driver.findElement(By.name("source_tax")).sendKeys(data.get(0).get(37));



		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	
	@Then("^user validates the get payout transaction bank web service$")
	public void user_validates_the_get_payout_transaction_bank_web_service(DataTable payoutBankDetails) throws Throwable
	{
		
	List <List<String>> data = payoutBankDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));


		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}

	
	
	@Then("^user validates the accept payout transaction web service$")
	public void user_validates_the_gaccept_payout_transaction_web_service(DataTable PayoutTransactionDetails) throws Throwable
	{
		
	List <List<String>> data = PayoutTransactionDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("trans_ref")).sendKeys(data.get(0).get(3));

		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	
	@Then("^user validates the process payout transaction web service$")
	public void user_validates_the_process_payout_transaction_web_service(DataTable ProcessPayoutTransactionDetails) throws Throwable
	{
		
	List <List<String>> data = ProcessPayoutTransactionDetails.raw();
	
	driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
	driver.findElement(By.name("trans_ref")).sendKeys(data.get(0).get(3));

		
	driver.findElement(By.name("submit")).click();
		
		
		
		if(driver.findElement(By.xpath("//status")).getText().contains("FAIL"))
		{
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");
		    
			
		}else {
			
			Assert.assertTrue(true);
		}
		
		
	}
	
	
	
	
	@When("^downloadSeerahFiles$")
	public void downloadseerahfiles() throws Throwable {
	    
		int countlink =73;
		String number="";
		
		for(int r=8; r<=11; r++) {
			
			if(r==1)
				driver.get("https://muslimcentral.com/series/yasir-qadhi-seerah/");
			else
				driver.get("https://muslimcentral.com/series/yasir-qadhi-seerah/page/"+r+"/");
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)");
			
			
			
			for(int i=0; i<10; i++)
			{
				
			
			if(countlink <10)
				number = "0" +Integer.toString(countlink);
			else
				number = Integer.toString(countlink);
			
			
			 //driver.findElement(By.xpath("//a[contains(@title,'Download Seerah "+number+"')]")).click();
			 driver.findElement(By.xpath("//a[contains(@title,'Download "+number+"')]")).click();
			js.executeScript("window.scrollBy(0,100)");
			
			
			 Thread.sleep(3000);
		
			
			 countlink++;
			}
		}
		
		
	}
	
	
	@After
	public void after() {
		// driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		// webDriverManager.closeDriver();
	}
}