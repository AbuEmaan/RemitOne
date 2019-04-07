package StepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Helpers.HelperFunctions;
import Pages.AddAgentPage;
import Pages.AddAgentTellerPage;
import Pages.AddBeneficiaryPage;
import Pages.AddCollectionPointPage;
import Pages.AddDeliveryBankBranchPage;
import Pages.AddDeliveryBankPage;
import Pages.AddDestinationCountryPage;
import Pages.AddMemberBeneficiaryPage;
import Pages.AddProcessingBankPage;
import Pages.AddRemitterPage;
import Pages.AddSourceCountryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PreferencesPage;
import Pages.ProfilePage;
import Pages.QuickRegistrationPage;
import Pages.SendMoneyProcessPage;
import Pages.SetDestinationConversionRate;
import Pages.SetSourceCoversionRatesPage;
import TestContext.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.TestData;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class ARMStepDefinitions {
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
	SendMoneyProcessPage sendMoneyProcessPage;
	AddDeliveryBankBranchPage addDeliveryBankBranchPage;
	AddMemberBeneficiaryPage addMemberBeneficiaryPage;

	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;

	HelperFunctions helper = new HelperFunctions();

	public ARMStepDefinitions(TestContext context) {

		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		loginPage = testContext.getPageObjectManager().getLoginPage(context);
		addSourceCountryPage = testContext.getPageObjectManager().getAddSourceCountryPage(context);
		homePage = testContext.getPageObjectManager().getHomePage(context);
		addDestinationCountryPage = testContext.getPageObjectManager().getAddDestinationCountryPage(context);
		preferencesPage = testContext.getPageObjectManager().getPreferencesPage(context);
		setSourceCoversionRatesPage = testContext.getPageObjectManager().getSetSourceConversionRatesPage(context);
		setDestinationConversionRate = testContext.getPageObjectManager().getSetDestinationConversionRatesPage(context);
		addDeliveryBankPage = testContext.getPageObjectManager().getAddDeliveryBankPage(context);
		addCollectionPointPage = testContext.getPageObjectManager().getAddCollectionPointPage(context);
		addProcessingBankPage = testContext.getPageObjectManager().getAddProcessingBankPage(context);
		addAgentTellerPage = testContext.getPageObjectManager().getaddAgentTellerPage(context);
		quickRegistrationPage = testContext.getPageObjectManager().getQuickRegistrationPage(context);
		addAgentPage = testContext.getPageObjectManager().getAddAgentPage(context);
		addRemitterPage = testContext.getPageObjectManager().getAddRemitterPage(context);
		profilePage = testContext.getPageObjectManager().getProfilePage(context);
		addBeneficiaryPage = testContext.getPageObjectManager().getAddBeneficiaryPage(context);
		sendMoneyProcessPage = testContext.getPageObjectManager().getSendMoneyProcessPage(context);
		addDeliveryBankBranchPage = testContext.getPageObjectManager().getAddDeliveryBankBranchPage(context);
		addMemberBeneficiaryPage = testContext.getPageObjectManager().getAddMemberBeneficiaryPage(context);
	}

	// ********** Step ***********

	@Given("^user is on the \"([^\"]*)\" landing page$")
	public void user_is_on_the_landing_page(String site) throws Throwable {

		homePage.navigateTo_HomePage(site);

		// close the cookie button
		if (driver.findElements(By.linkText("Close")).size() != 0)
			driver.findElement(By.linkText("Close")).click();
	}

	// ********** Step ***********
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {

		loginPage.loginadmin(username, password);

	}

	// ********** Step ***********
	@Then("^user clicks the logout link$")
	public void user_clicks_the_logout_link() throws Throwable {

		loginPage.logout();
	}

	// ********** Step ***********
	@Then("^the \"([^\"]*)\" page is displayed$")
	public void the_page_is_displayed(String pageHeader) throws Throwable {

		driver.findElement(By.xpath("//h1[contains(text(), '" + pageHeader + "')]")).isDisplayed();

	}

	// ********** Step ***********
	@When("^the User clicks the \"([^\"]*)\" link$")
	public void the_User_clicks_the_link(String navigationLink) throws Throwable {

		driver.findElement(By.xpath("//a[contains(text(), '" + navigationLink + "')]")).click();
	}

	// ********** Step ***********
	@When("^user changes password by entering the old password \"([^\"]*)\" and the new password \"([^\"]*)\" and confirmed new password \"([^\"]*)\" and clicks continue$")
	public void user_changes_password(String oldPWD, String newPWD, String confirmedPWD) throws Throwable {

		preferencesPage.changePassword(oldPWD, newPWD, confirmedPWD);

	}

	// ********** Step ***********
	@Then("^the user adds the source country as \"([^\"]*)\" and currency as \"([^\"]*)\" and WalletEnabled is set to \"([^\"]*)\"$")
	public void the_user_adds_the_source_country_as_and_currency_as_and_WalletEnabled_is_set_to(String country,
			String currency, String walletEnabled) throws Throwable {

		addSourceCountryPage.setSourceCountry(country, currency, walletEnabled);
	}

	// ********** Step ***********
	@Then("^the user adds the destination country as \"([^\"]*)\"$")
	public void the_user_adds_the_destination_country_as(String country) throws Throwable {

		addDestinationCountryPage.setDestinationCountry(country);
	}

	// ********** Step ***********
	@Then("^the user adds source destination rates for euro \"([^\"]*)\" and usd \"([^\"]*)\"$")
	public void the_user_adds_source_destination_rates_for_euro_and_usd(String euroRate, String usdRate)
			throws Throwable {

		setSourceCoversionRatesPage.setSourceConversionRates(euroRate, usdRate);
	}

	// ********** Step ***********
	@Then("^user adds a deliver bank \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_deliver_bank(String name, String code, String address, String city, String state)
			throws Throwable {

		addDeliveryBankPage.setDeliveryBank(name, code, address, city, state);
	}

	// ********** Step ***********
	@Then("^the user adds additional currency \"([^\"]*)\" for the  country \"([^\"]*)\"$")
	public void the_user_adds_additional_currency_for_the_country(String currencyCountry, String country)
			throws Throwable {
		driver.findElement(By.id("menu-settings")).click();
		driver.findElement(By.id("menu-settings-countriesCurrencies")).click();
		driver.findElement(By.id("menu-settings-countriesCurrencies-destinationCountries")).click();

		driver.findElement(By.xpath("//*[text()='" + country + "']")).click();
		driver.findElement(By.name("go_edit")).click();
		helper.selectValueFromDropDown("country_selector2", currencyCountry, driver);
		driver.findElement(By.xpath("//a[text()='Add New Currency']")).click();

		Thread.sleep(2000);
		String txt = driver.switchTo().alert().getText();

		Assert.assertTrue(txt.contains("added successfully"));
		driver.switchTo().alert().accept();
	}

	// ********** Step ***********
	@Then("^the user sets buy rate one \"([^\"]*)\" and buy rate two \"([^\"]*)\"$")
	public void the_user_sets_buy_rate_one_and_buy_rate_two(String rate1, String rate2) throws Throwable {
		driver.findElement(By.id("menu-procBanks")).click();
		driver.findElement(By.id("menu-procBanks-setBuyRates")).click();

		driver.findElement(By.xpath("(//input[@name='new_rate'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@name='new_rate'])[1]")).sendKeys(rate1);
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

		driver.findElement(By.xpath("(//input[@name='new_rate'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='new_rate'])[2]")).sendKeys(rate2);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

		String textSuccessMsg = driver.findElement(By.id("success-message")).getText();

		if (!textSuccessMsg.contains("Rate updated successfully")) {

			Assert.fail("Rate was not was not updated successfully");

		}

	}

	// ********** Step ***********
	@Then("^the user sets commission slabs \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_sets_commission_slabs(String amount, String commFixed, String commPerc, String slabIndex)
			throws Throwable {

		driver.findElement(By.id("menu-fees")).click();
		driver.findElement(By.id("menu-fees-setCommissionSlabs")).click();

		driver.findElement(By.xpath("//a[text()='New']")).click();

		driver.findElement(By.name("datanew[1][slab_amount]")).sendKeys(amount);
		driver.findElement(By.name("datanew[1][commission_fixed]")).sendKeys(commFixed);
		driver.findElement(By.name("datanew[1][commission_percentage]")).sendKeys(commPerc);
		driver.findElement(By.xpath("//*[@name='operation']")).click();

		String textSuccessMsg = driver.findElement(By.id("ajaxSuccessMessage")).getText();

		if (!textSuccessMsg.contains("Commission Slabs updated successfully")) {

			Assert.fail("Commission Slabs was not  updated successfully");

		}

	}

	// ********** Step ***********
	@Then("^link agent to teller first name is  \"([^\"]*)\"  and last name \"([^\"]*)\" and username \"([^\"]*)\" and password is \"([^\"]*)\"$")
	public void link_agent_to_teller(String fname, String lname, String username, String password) throws Throwable {

		driver.findElement(By.xpath("(//*[@id='menu-agents'])[2]")).click();

		driver.findElement(By.id("menu-agents-new")).click();

		driver.findElement(By.name("fname")).sendKeys(fname);
		driver.findElement(By.name("lname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@class='username_show']")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("submit")).click();

		String textSuccessMsg = driver.findElement(By.id("success-message")).getText();

		if (!textSuccessMsg.contains("New Agent Teller User bankagentteller created successfully")) {

			Assert.fail("New Agent Teller User bankagentteller not created successfully");

		}

	}

	// ********** Step ***********
	@Then("^add agent credit \"([^\"]*)\"$")
	public void add_agent_credit(String deposit) throws Throwable {

		driver.findElement(By.id("menu-accounting")).click();
		driver.findElement(By.id("menu-accounting-agentCredits")).click();
		driver.findElement(By.xpath("//a[text()='Add/Deduct Credit']")).click();

		driver.findElement(By.name("add_deposit")).clear();
		driver.findElement(By.name("add_deposit")).sendKeys(deposit);
		driver.findElement(By.name("update")).click();

		String textSuccessMsg = driver.findElement(By.id("success-message")).getText();

		if (!textSuccessMsg.contains("Credit Details Updated Successfully")) {

			Assert.fail("Credit Details not updated successfully");

		}

	}

	// ********** Step ***********
	@Then("^user adds sell rates \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_adds_sell_rates_and_for(String hqAgentAmount, String nonHQAgentAmount, String slabIndex)
			throws Throwable {

		driver.findElement(By.id("menu-fees")).click();
		driver.findElement(By.id("menu-fees-setSellRatesAdmin")).click();

		for (WebElement wb : driver.findElements(By.xpath("//input[@type='text']"))) {
			if (wb.isDisplayed())
				wb.clear();
		}

		driver.findElement(By.xpath("(//input[@name='collection_rate[]'])[" + slabIndex + "]")).sendKeys(hqAgentAmount);

		driver.findElement(By.xpath("(//input[@name='hq_collection_rate[]'])[" + slabIndex + "]"))
				.sendKeys(nonHQAgentAmount);

		driver.findElement(By.xpath("(//input[@name='transfer_rate[]'])[" + slabIndex + "]")).sendKeys(hqAgentAmount);
		driver.findElement(By.xpath("(//input[@name='hq_transfer_rate[]'])[" + slabIndex + "]"))
				.sendKeys(nonHQAgentAmount);

		driver.findElement(By.xpath("(//input[@name='card_rate[]'])[" + slabIndex + "]")).sendKeys(hqAgentAmount);
		driver.findElement(By.xpath("(//input[@name='hq_card_rate[]'])[" + slabIndex + "]")).sendKeys(nonHQAgentAmount);

		driver.findElement(By.xpath("(//input[@name='homedelivery_rate[]'])[" + slabIndex + "]"))
				.sendKeys(hqAgentAmount);
		driver.findElement(By.xpath("(//input[@name='hq_homedelivery_rate[]'])[" + slabIndex + "]"))
				.sendKeys(nonHQAgentAmount);

		driver.findElement(By.xpath("(//input[@name='utilitybill_rate[]'])[" + slabIndex + "]"))
				.sendKeys(hqAgentAmount);
		driver.findElement(By.xpath("(//input[@name='hq_utilitybill_rate[]'])[" + slabIndex + "]"))
				.sendKeys(nonHQAgentAmount);

		driver.findElement(By.xpath("(//input[@name='mobiletransfer_rate[]'])[" + slabIndex + "]"))
				.sendKeys(hqAgentAmount);
		driver.findElement(By.xpath("(//input[@name='hq_mobiletransfer_rate[]'])[" + slabIndex + "]"))
				.sendKeys(nonHQAgentAmount);

		driver.findElement(By.name("submit")).click();

		String textSuccessMsg = driver.findElement(By.id("success-message")).getText();

		if (!textSuccessMsg.contains("Rates updated successfully")) {

			Assert.fail("Rates not  updated successfully");

		}

	}

	// ********** Step ***********
	@Then("^add bank credit \"([^\"]*)\" and \"([^\"]*)\"$")
	public void add_bank_credit_and(String bankName, String deposit) throws Throwable {

		driver.findElement(By.id("menu-accounting")).click();
		driver.findElement(By.id("menu-accounting-bankCredit")).click();
		driver.findElement(By.xpath("//a[text()='" + bankName + "']")).click();

		driver.findElement(By.name("add_deposit")).clear();
		driver.findElement(By.name("add_deposit")).sendKeys(deposit);
		driver.findElement(By.name("update")).click();

		String textSuccessMsg = driver.findElement(By.id("success-message")).getText();

		if (!textSuccessMsg.contains("Credit Details Updated Successfully")) {

			Assert.fail("Credit Details not updated successfully");

		}

	}

	// ********** Step ***********
	@Then("^the user sets compliance limits$")
	public void the_user_sets_compliance_limits() throws Throwable {
		driver.findElement(By.id("menu-settings")).click();
		driver.findElement(By.id("menu-settings-compliance")).click();
		driver.findElement(By.id("menu-settings-compliance-limits")).click();

		driver.findElement(By.name("membercompliance_GBP")).clear();
		driver.findElement(By.name("membercompliance_GBP")).sendKeys("999");

		driver.findElement(By.name("membercompliance_EUR")).clear();
		driver.findElement(By.name("membercompliance_EUR")).sendKeys("999");

		driver.findElement(By.name("membercompliance_USD")).clear();
		driver.findElement(By.name("membercompliance_USD")).sendKeys("999");

		driver.findElement(By.name("compliance_GBP")).clear();
		driver.findElement(By.name("compliance_GBP")).sendKeys("999");

		driver.findElement(By.name("compliance_EUR")).clear();
		driver.findElement(By.name("compliance_EUR")).sendKeys("999");

		driver.findElement(By.name("compliance_USD")).clear();
		driver.findElement(By.name("compliance_USD")).sendKeys("999");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	// ********** Step ***********
	@Then("^user adds a deliver bank branch  \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_deliver_bank_branch(String name, String code, String deliveryBank, String city,
			String state) throws Throwable {

		addDeliveryBankBranchPage.setDeliveryBankBranch(name, code, deliveryBank, city, state);
	}

	// ********** Step ***********
	@Then("^user adds a collection point \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_collection_point(String CPName, String CPBankName, String CPCode, String CPAddress,
			String CPCity, String CPState) throws Throwable {

		addCollectionPointPage.setCollectionPoint(CPName, CPBankName, CPCode, CPAddress, CPCity, CPState);
	}

	// ********** Step ***********
	@Then("^the user adds  destination rates \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_adds_destination_conversion_rates(String firstRate, String secRate, String thirdRate)
			throws Throwable {

		setDestinationConversionRate.setDestinationConversionRates(firstRate, secRate, thirdRate);
	}

	// ********** Step ***********
	@Then("^user adds a processing  bank \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_adds_a_processing_bank(String firstName, String lastName, String userName, String password,
			String fullBankName, String bankName, String bankCode, String bankAddress, String town, String bankCountry,
			String email, String bankSuperID) throws Throwable {

		addProcessingBankPage.setProcessingBank(firstName, lastName, userName, password, fullBankName, bankName,
				bankCode, bankAddress, town, bankCountry, email, bankSuperID);
	}

	// ********** Step ***********
	@Then("^user adds a teller agent \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_add_teller_agent(String firstName, String lastName, String email, String userName, String password)
			throws Throwable {

		addAgentTellerPage.addTellerAgent(firstName, lastName, email, userName, password);
	}

	// ********** Step ***********
	@Then("^user adds an agent$")
	public void user_adds_an_agent(DataTable agentDetails) throws Throwable {

		List<List<String>> data = agentDetails.raw();

		addAgentPage.addAgent(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3),
				data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8),
				data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12), data.get(0).get(13),
				data.get(0).get(14), data.get(0).get(15));

	}

	// ********** Step ***********
	@Then("^user adds a remitter$")
	public void user_adds_a_remitter(DataTable remitterDetails) throws Throwable {

		List<List<String>> data = remitterDetails.raw();

		addRemitterPage.addRemitter(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3),
				data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8),
				data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12), data.get(0).get(13),
				data.get(0).get(14), data.get(0).get(15), data.get(0).get(16), data.get(0).get(17));

	}

	// ********** Step ***********
	@Then("^user adds a member beneficiary$")
	public void user_adds_a_member_beneficiary(DataTable remitterDetails) throws Throwable {

		List<List<String>> data = remitterDetails.raw();

		addMemberBeneficiaryPage.addMemberBeneficiary(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2),
				data.get(0).get(3), data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7),
				data.get(0).get(8), data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12),
				data.get(0).get(13), data.get(0).get(14), data.get(0).get(15), data.get(0).get(16), data.get(0).get(17),
				data.get(0).get(18), data.get(0).get(19), data.get(0).get(20), data.get(0).get(21));

	}

	// ********** Step ***********
	// WS user setup
	@Then("^set webservice user \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void set_webservice_user_and_and(String wsusername, String wspassword, String wsassociateduser)
			throws Throwable {

		driver.findElement(By.id("menu-settings")).click();
		driver.findElement(By.id("menu-settings-webServiceUsers")).click();

		driver.findElement(By.xpath("//span[text()='Add Web Service User']")).click();

		driver.findElement(By.id("ws_username")).sendKeys(wsusername);

		driver.findElement(By.id("ws_password")).sendKeys(wspassword);

		int index = 0;

		if (wsassociateduser.toLowerCase().contains("admin"))
			index = 1;

		if (wsassociateduser.toLowerCase().contains("bobby"))
			index = 2;

		if (wsassociateduser.toLowerCase().contains("bank"))
			index = 3;

		// set the associated user
		helper.selectValueOptGroupList("associated_user_selector", wsassociateduser, driver, index);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	// ********** Step ***********
	@When("^user  the create a money \"([^\"]*)\" by \"([^\"]*)\" for  \"([^\"]*)\" for the \"([^\"]*)\"$")
	public void user_the_create_a_money_by_for_for_the(String transferType, String remitter, String beneficiary,
			String amount) throws Throwable {

		driver.findElement(By.id("menu-transactions")).click();
		driver.findElement(By.id("menu-transactions-startNew")).click();

		WebElement transType = driver.findElement(By.name("trans_type"));
		Select DDtransType = new Select(transType);
		DDtransType.selectByVisibleText(transferType);

		driver.findElement(By.id("remitter_keyword_search")).click();
		driver.findElement(By.id("remitter_keyword_search")).sendKeys(remitter.substring(0, 1));
		driver.findElement(By.id("remitter_keyword_search")).sendKeys(remitter.substring(1, 2));
		driver.findElement(By.id("remitter_keyword_search")).sendKeys(remitter.substring(2, 3));

		helper.waitForElementToBecomeVisible(driver, By.xpath("//a[@class='ui-corner-all ui-state-focus']"));
		driver.findElement(By.xpath("//a[@class='ui-corner-all ui-state-focus']")).click();

		helper.setLastestWindow(driver);
		driver.findElement(By.id("cboxClose")).click();

		helper.setLastestWindow(driver);
		helper.waitForElementToBecomeVisible(driver, By.id("beneficiary_keyword_search"));
		driver.findElement(By.id("beneficiary_keyword_search")).click();
		driver.findElement(By.id("beneficiary_keyword_search")).sendKeys(beneficiary.substring(0, 1));
		driver.findElement(By.id("beneficiary_keyword_search")).sendKeys(beneficiary.substring(1, 2));
		driver.findElement(By.id("beneficiary_keyword_search")).sendKeys(beneficiary.substring(2, 3));

		helper.waitForElementToBecomeVisible(driver, By.xpath("//a[@class='ui-corner-all ui-state-focus']"));
		driver.findElement(By.xpath("//a[@class='ui-corner-all ui-state-focus']")).click();

		driver.findElement(By.id("sourceAmountField")).sendKeys(amount);

		// driver.findElement(By.id("destinationAmountField")).sendKeys(amount);

		Thread.sleep(1000);
		helper.addfullScreenCaptureToExtentReport(driver);
		driver.findElement(By.id("Submit")).click();
		helper.addfullScreenCaptureToExtentReport(driver);

		helper.scrollDown("400", driver);
		helper.waitForElementToBecomeVisible(driver, By.id("compliance_confirmation"));

		driver.findElement(By.id("compliance_confirmation")).click();

		driver.findElement(By.id("Create")).click();

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);
			break;
		}

		helper.addfullScreenCaptureToExtentReport(driver);
		helper.waitForElementToBecomeVisible(driver, By.id("success-message"));

		if (!driver.findElement(By.id("success-message")).getText().contains("Added Successfully")) {

			Assert.fail("Transaction not added successfully");

		} else {

			String a = driver.findElement(By.id("success-message")).getText();
			String ref = a.substring(12, a.indexOf("Added") - 1);

			driver.findElement(By.id("menu-transactions")).click();
			driver.findElement(By.id("menu-transactions-live")).click();
			helper.addfullScreenCaptureToExtentReport(driver);
			driver.findElement(By.xpath("//*[contains(text(),'" + ref + "')]")).click();
			testContext.scenarioContext.setContext(TestData.TransactionRef, ref);

		}

	}

}