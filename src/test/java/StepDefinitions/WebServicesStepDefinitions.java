package StepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Helpers.HelperFunctions;
import Pages.LoginPage;
import TestContext.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.TestData;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class WebServicesStepDefinitions {

	WebDriver driver;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	LoginPage loginPage;
	TestContext testContext;
	HelperFunctions helper = new HelperFunctions();

	public WebServicesStepDefinitions(TestContext context) {

		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}

	// ********** Step ***********
	@When("^user click on webservice \"([^\"]*)\"$")
	public void user_click_on_webservice(String serviceName) throws Throwable {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[text()='" + serviceName + "']")); // a[text()='searchRemitter']
		je.executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.xpath("//a[text()='" + serviceName + "']")).click();

	}

	// ********** Step ***********
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

	// ********** Step ***********
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

	// ********** Step ***********
	@Then("^user validates the create Beneficiary Agent web service$")
	public void user_validates_the_create_Beneficiary_Agent_web_service(DataTable beneficiaryDetails) throws Throwable {

		List<List<String>> data = beneficiaryDetails.raw();

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

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the create Transaction Agent web service$")
	public void user_validates_the_create_Transaction_Agent_web_service(DataTable transactionDetails) throws Throwable {

		List<List<String>> data = transactionDetails.raw();

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

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the get sell rates web service$")
	public void user_validates_the_get_sell_rates_web_service(DataTable sellRatesDetails) throws Throwable {

		List<List<String>> data = sellRatesDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("source_country")).sendKeys(data.get(0).get(3));
		driver.findElement(By.name("destination_country")).sendKeys(data.get(0).get(4));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the confirm transaction web service$")
	public void user_validates_the_confirm_transaction_web_service(DataTable confirmTransactionDetails)
			throws Throwable {

		List<List<String>> data = confirmTransactionDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("trans_session_id")).sendKeys(data.get(0).get(3));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the get transaction detail web service$")
	public void user_validates_the_get_transaction_detail_web_service(DataTable TransactionDetails) throws Throwable {

		List<List<String>> data = TransactionDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("trans_ref")).sendKeys(data.get(0).get(3));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the insert transaction detail web service$")
	public void user_validates_the_insert_transaction_web_service(DataTable TransactionDetails) throws Throwable {

		List<List<String>> data = TransactionDetails.raw();

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

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the get payout transaction bank web service$")
	public void user_validates_the_get_payout_transaction_bank_web_service(DataTable payoutBankDetails)
			throws Throwable {

		List<List<String>> data = payoutBankDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the accept payout transaction web service$")
	public void user_validates_the_gaccept_payout_transaction_web_service(DataTable PayoutTransactionDetails)
			throws Throwable {

		List<List<String>> data = PayoutTransactionDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("trans_ref")).sendKeys(data.get(0).get(3));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}

	// ********** Step ***********
	@Then("^user validates the process payout transaction web service$")
	public void user_validates_the_process_payout_transaction_web_service(DataTable ProcessPayoutTransactionDetails)
			throws Throwable {

		List<List<String>> data = ProcessPayoutTransactionDetails.raw();

		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("pin")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("trans_ref")).sendKeys(data.get(0).get(3));

		driver.findElement(By.name("submit")).click();

		if (driver.findElement(By.xpath("//status")).getText().contains("FAIL")) {
			System.out.println(driver.findElement(By.xpath("//message")).getText());
			Assert.fail("The Webservice: create beneficairy failed");

		} else {

			Assert.assertTrue(true);
		}

	}
}
