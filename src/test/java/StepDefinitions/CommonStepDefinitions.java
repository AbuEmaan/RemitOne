package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Helpers.HelperFunctions;
import Helpers.TestRun;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import TestContext.TestContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.cucumber.listener.Reporter;
import com.cucumber.listener.ExtentProperties;

public class CommonStepDefinitions {
	WebDriver driver;
	WebDriverManager webDriverManager;
	TestContext testContext;
	enums.TestData TestData;
	TestRun reporter;
	private HelperFunctions helper = new HelperFunctions();

	
	public CommonStepDefinitions(TestContext context) {

		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();

	}

	@Before
	public void setup() {

		System.out.println("===========================================================================");
		System.out.println("============================== TEST STARTED  ===============================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("==== DIR : " + System.getProperty("user.dir"));
		
		//testContext.scenarioContext.setContext(TestData.TestName, "First Test");

	}

	@After
	public void TearDown() throws Throwable {

		String testRunName = TestRun.getTestRunName();

		System.out.println("===========================================================================");
		System.out.println("========================= TEST FINISHED STATUS ============================");
		System.out.println("===========================================================================");
		System.out.println("==== TEST RUN: " + testRunName);
		System.out.println("=== Test Run data: " + testContext.scenarioContext.getContext(TestData.TestName));

		helper.addfullScreenCaptureToExtentReport(driver);

		Reporter.addScenarioLog("<b>TEST:</b> ");

		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

	}

}
