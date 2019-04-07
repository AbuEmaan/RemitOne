package testRunner;

import java.io.File;

import java.io.IOException;

import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.junit.AfterClass;

import org.junit.BeforeClass;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import com.cucumber.listener.ExtentProperties;

import Helpers.TestRun;

import managers.FileReaderManager;
import managers.WebDriverManager;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features", glue = {"StepDefinitions"},

		plugin = { "pretty", "html:target/cucumber", "usage:src/test/resources/usage.json",

				"json:src/test/resources/cucumber.json", "rerun:rerun.txt",
				"com.cucumber.listener.ExtentCucumberFormatter:" },

		monochrome = true,
//tags = {"@FullRegression"}
//tags = {"@ARMAdmin"}
tags = { "@Test" }

)

public class TestRunner {

	private static String testRunName = "";

	@BeforeClass
	public static void SetupExtentReport() throws IOException {

		// webDriverManager = new WebDriverManager();
		// driver = webDriverManager.getDriver();

		TestRun.setTestRunName();

		testRunName = TestRun.getTestRunName();

		// Create screen shot dir if it does not exist

		String source = System.getProperty("user.dir") + "\\ScreenShots";

		File srcDir = new File(source);

		if (!srcDir.exists())

			srcDir.mkdir();

		// Set the report path based on generated testName

		Properties prop = FileReaderManager.getInstance().getConfigReader().getProperties();

		String localTestResultsPath = prop.getProperty("localTestResultsPath");

		String pathToReport = System.getProperty("user.dir") + "\\" + localTestResultsPath + "\\" + testRunName

				+ "\\RemitOne_" + testRunName + "_report.html";

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;

		extentProperties.setReportPath(pathToReport);

	}

	@AfterClass

	public static void writeExtentReport() throws IOException, InterruptedException {

		testRunName = TestRun.getTestRunName();

		Reporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));

		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));

		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");

		Reporter.setSystemInfo("Selenium", "3.7.0");

		Reporter.setSystemInfo("Maven", "3.5.2");

		Reporter.setSystemInfo("Java Version", "1.8.0_151");

		// driver.manage().deleteAllCookies();
		// driver.close();
		// driver.quit();

		// Source Extent DIR

		String source = System.getProperty("user.dir") + "\\ScreenShots";

		File srcDir = new File(source);

		// Set the report path based on generated testName

		Properties prop = FileReaderManager.getInstance().getConfigReader().getProperties();

		String localTestResultsPath = prop.getProperty("localTestResultsPath");

		// Test Run folder path

		String testRunFolder = System.getProperty("user.dir") + "\\" + localTestResultsPath + "\\" + testRunName;

		File testRunDir = new File(testRunFolder);

		try {

			// move extent dir

			FileUtils.moveDirectoryToDirectory(srcDir, testRunDir, false);

		} catch (IOException e) {

			// e.printStackTrace();

		}

		if (srcDir.exists())

			srcDir.delete();

	}

}
