package testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features", glue = { "StepDefinitions" },

		plugin = { "pretty", "html:target/cucumber", "usage:src/test/resources/usage.json",
				"json:src/test/resources/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },

		monochrome = true, tags = { "@runMyFeature1" }

)

public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {
		
		String path = FileReaderManager.getInstance().getConfigReader().getReportXMLConfigFile();
		
		
		Reporter.loadXMLConfig(path);

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}

}
