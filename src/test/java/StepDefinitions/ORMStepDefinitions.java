package StepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Helpers.HelperFunctions;
import Helpers.TestRun;
import PageObjects.ARM.AddDeliveryBankBranchPage;
import PageObjects.ARM.AddMemberBeneficiaryPage;
import PageObjects.ARM.ORM.AddBeneficiaryPage;
import PageObjects.ARM.ORM.ProfilePage;
import PageObjects.ARM.ORM.QuickRegistrationPage;
import PageObjects.ARM.ORM.SendMoneyProcessPage;
import TestContext.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class ORMStepDefinitions {

	WebDriver driver;

	WebDriverManager webDriverManager;

	TestContext testContext;

	TestRun reporter;

	ProfilePage profilePage;
	AddBeneficiaryPage addBeneficiaryPage;
	SendMoneyProcessPage sendMoneyProcessPage;
	AddDeliveryBankBranchPage addDeliveryBankBranchPage;
	AddMemberBeneficiaryPage addMemberBeneficiaryPage;
	QuickRegistrationPage quickRegistrationPage;

	private HelperFunctions helper = new HelperFunctions();

	public ORMStepDefinitions(TestContext context) {

		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		
		quickRegistrationPage = testContext.getPageObjectManager().getQuickRegistrationPage(context);
		profilePage = testContext.getPageObjectManager().getProfilePage(context);
		addBeneficiaryPage = testContext.getPageObjectManager().getAddBeneficiaryPage(context);
		sendMoneyProcessPage= testContext.getPageObjectManager().getSendMoneyProcessPage(context);
		addDeliveryBankBranchPage = testContext.getPageObjectManager().getAddDeliveryBankBranchPage(context);
		addMemberBeneficiaryPage = testContext.getPageObjectManager().getAddMemberBeneficiaryPage(context);
		
	}

	@When("^user completes the registration form and submits$")
	public void user_completes_the_registration_form_on_the_ORM_site(DataTable registrationDetails) throws Throwable {

		List<List<String>> data = registrationDetails.raw();
		quickRegistrationPage.qucikRegistration(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2),
				data.get(0).get(3), data.get(0).get(4), data.get(0).get(5), data.get(0).get(6));
	}

	@When("^the user clicks the logout link$")
	public void the_user_clicks_the_logout_link() throws Throwable {

		helper.hoverOverObject(By.xpath("//span[contains(@class,'username')]"), driver);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@class='icon-key']")).click();

	}

	@Then("^The logout message is displayed$")
	public void the_logout_message_is_displayed() throws Throwable {

		System.out.println("logout message tb done");
	}

	@Then("^user logs in with his credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logs_in_with_his_credentials(String username, String password) throws Throwable {

		driver = webDriverManager.getDriver();
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

		helper.hoverOverObject(By.xpath("//span[contains(@class,'username')]"), driver);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@class='icon-user']")).click();
	}

	@When("^users edits the profile$")
	public void users_edits_the_profile(DataTable profileDetails) throws Throwable {

		List<List<String>> data = profileDetails.raw();
		profilePage.editProfile(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3),
				data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7), data.get(0).get(8),
				data.get(0).get(9), data.get(0).get(10));

	}

	@When("^user adds beneficiary$")
	public void user_adds_beneficiary(DataTable beneficiaryDetails) throws Throwable {
		List<List<String>> data = beneficiaryDetails.raw();
		
		addBeneficiaryPage.addBeneficiary(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2),
				data.get(0).get(3), data.get(0).get(4), data.get(0).get(5), data.get(0).get(6), data.get(0).get(7),
				data.get(0).get(8), data.get(0).get(9), data.get(0).get(10), data.get(0).get(11), data.get(0).get(12),
				data.get(0).get(13), data.get(0).get(14), data.get(0).get(15), data.get(0).get(16));

	}

	@When("^user changes language to \"([^\"]*)\"$")
	public void user_changes_language_to(String language) throws Throwable {

		helper.hoverOverObject(By.xpath("//img[@class='flag-img']"), driver);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'Thai')]")).click();

		// driver.findElement(By.xpath("//a[text()='"+language+"']")).click();
	}

	@Then("^language changed message is displayed$")
	public void language_changed_message_is_displayed() throws Throwable {

		System.out.println("language is changed needs to be displayed");
		// driver.findElement(By.xpath("//span[@class='Enlish']")).click();
	}

	@When("^user clicks the \"([^\"]*)\" link$")
	public void user_clicks_the_link(String link) throws Throwable {

		driver.findElement(By.linkText(link)).click();
	}

	@Then("^the user is displayed with the following message \"([^\"]*)\"$")
	public void the_user_is_displayed_with_the_following_message(String messageDisplayed) throws Throwable {

		if (!driver.getPageSource().contains(messageDisplayed)) {

			Assert.fail("The Message '" + messageDisplayed + "' was not displayed");

		}

	}

	@Then("^user selects the beneficairy named \"([^\"]*)\" and clicks next$")
	public void user_selects_the_beneficairy_named_and_clicks_next(String beneficiaryName) throws Throwable {
		sendMoneyProcessPage.selectBeneficiary(beneficiaryName);
	}

	@Then("^user then selects account type \"([^\"]*)\" and clicks next$")
	public void user_then_selects_account_type_and_clicks_next(String transferType) throws Throwable {
		sendMoneyProcessPage.selectAccountType(transferType);
	}

	@Then("^user then selects the transfer details \"([^\"]*)\" and clicks next$")
	public void user_then_selects_the_transfer_details_and_clicks_next(String state) throws Throwable {
		sendMoneyProcessPage.selectTransferDetails(state);
	}

}
