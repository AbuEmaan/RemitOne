package Helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import java.util.Properties;
import java.util.Date;
import java.util.IllegalFormatException;

import managers.FileReaderManager;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.InputStream;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Map;

import java.util.Properties;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import javax.tools.JavaFileObject;

import org.apache.commons.io.FileUtils;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.logging.LogEntries;

import org.openqa.selenium.logging.LogEntry;

import org.openqa.selenium.logging.LogType;

import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;

import gherkin.deps.com.google.gson.JsonObject;

import com.cucumber.listener.Reporter;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import com.google.gson.JsonParser;

public class HelperFunctions {

	public void setLastestWindow(WebDriver driver) {

		Set<String> allwindow = driver.getWindowHandles();
		for (String eachwindow : allwindow) {

			System.out.println(eachwindow);
			//driver.switchTo().window(eachwindow);

		}

	}

	public static void waitForElementToBecomeVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForElementToBecomeVisible(WebDriver driver, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	/**
	 * 
	 * @desc Get the last window opened and in focus
	 * 
	 * @param driver
	 * 
	 */

	public static void getLatestWindowFocused(WebDriver driver) {

		String mostRecentWindowHandle = "";

		for (String winHandle : driver.getWindowHandles()) {

			mostRecentWindowHandle = winHandle;

			System.out.println("Window Id: " + winHandle);

		}

		driver.switchTo().window(mostRecentWindowHandle);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.focus();");

		js = null;

	}

	public void uploadFile(String fileName) throws AWTException, InterruptedException {

		String path = FileReaderManager.getInstance().getConfigReader().getImageFilePath();

		String fullPath = path + fileName;
		System.out.println("full path1: " + fullPath);

		fullPath = "C:\\RemitOneImage\\uploadFile.PNG";

		System.out.println("full path2: " + fullPath);

		StringSelection ss = new StringSelection(fullPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);

	}

	public void WriteNumericCode(String code, String fileName) {
		try {
			FileWriter writer = new FileWriter("src\\test\\resources\\NumericKey.txt", false);
			writer.write(code);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @desc Clear input box and enter value
	 * 
	 * @param element and value to populate
	 * 
	 * @return N/A
	 * 
	 */

	public void enterValue(WebElement element, String value) {

		element.clear();

		int stringLength = element.getAttribute("value").length();

		if (stringLength > 0) {

			for (int i = 0; i < stringLength; i++) {

				element.sendKeys(Keys.BACK_SPACE);

			}

		}

		element.sendKeys(value);

		String insertedValue = element.getAttribute("value");

		if (!(insertedValue.equalsIgnoreCase(value))) {

			element.clear();

			for (int i = 0; i < value.length(); i++) {

				char c = value.charAt(i);

				String s = new StringBuilder().append(c).toString();

				element.sendKeys(s);

			}

		}

		element.sendKeys(Keys.TAB);

	}

	public String ReadNumericCode(String fileName) {

		String NumericKey = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src\\test\\resources\\NumericKey.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				NumericKey = line;
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return NumericKey;

	}

	public void hoverOverObject(By locator, WebDriver driver) {
		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	public void scrollDown(String yAxelPixelCount, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + yAxelPixelCount + ")");
	}

	public void selectValueFromDropDown(String id, String valueToSelect, WebDriver driver) {

		List<WebElement> options = driver.findElements(By.xpath("//select[@id ='" + id + "']/option"));

		for (WebElement option : options) {
			// System.out.println(option.getText());
			if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
				option.click();
				break;
			}
		}
	}

	public void selectValueOptGroupList(String id, String valueToSelect, WebDriver driver, int index) {

		List<WebElement> options = driver
				.findElements(By.xpath("//select[@id='" + id + "']/optgroup[" + index + "]/option"));

		for (WebElement option : options) {
			System.out.println(option.getText());
			if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
				option.click();
				break;
			}
		}
	}

	public final static String getDateTime()

	{

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_S");

		df.setTimeZone(TimeZone.getTimeZone("GMT"));

		return df.format(new Date());

	}

	public final static String getDate()

	{

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		df.setTimeZone(TimeZone.getTimeZone("GMT"));

		return df.format(new Date());

	}

	public static String getProperty(String propertyName)

	{

		Properties prop = FileReaderManager.getInstance().getConfigReader().getProperties();

		return prop.getProperty(propertyName);

	}

	public void addfullScreenCaptureToExtentReport(final WebDriver driver)

			throws IllegalFormatException {

		try {

			Properties prop = FileReaderManager.getInstance().getConfigReader().getProperties();

			String localTestResultsPath = prop.getProperty("localTestResultsPath");

			JavascriptExecutor jexec = (JavascriptExecutor) driver;

			jexec.executeScript("window.scrollTo(0,0)"); // will scroll to (0,0)

			Boolean isScrollBarPresent =  (Boolean) jexec.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
			Long scrollHeight = (Long) jexec.executeScript("return document.documentElement.scrollHeight");
			Long clientHeight = (Long) jexec.executeScript("return document.documentElement.clientHeight");

			int fileIndex = 1;

			String pathToScreenShot = "";

			if (driver instanceof WebDriver) {

				if (isScrollBarPresent) {

					int screenShotCount = 1;

					while (scrollHeight > 0) {

						pathToScreenShot = returnScreencapturePath(driver);

						// Always screen shot the page

						if (screenShotCount == 1) {

							// Add to extent reports

							Reporter.addScreenCaptureFromPath(pathToScreenShot);

						}

						jexec.executeScript("window.scrollTo(0," + clientHeight * fileIndex++ + ")");

						scrollHeight = scrollHeight - clientHeight;

						// if the page needs to be scrolled then screen shot

						// again

						if (scrollHeight > 100) {

							pathToScreenShot = returnScreencapturePath(driver);

							// Add to extent reports

							Reporter.addScreenCaptureFromPath(pathToScreenShot);

						}

						screenShotCount++;

					}

				}

				else {

					// On error pages there may not be an scroll bar present

					pathToScreenShot = returnScreencapturePath(driver);

					// Add to extent reports

					Reporter.addScreenCaptureFromPath(pathToScreenShot);

				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @desc takes a screen shot and returns it's path
	 * 
	 * @param driver
	 * 
	 * @param testContext
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * 
	 */

	public String returnScreencapturePath(WebDriver driver) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// String testSnapShotDir = (String)
		// testContext.scenarioContext.getContext(TestData.TestSnapShotDir);

		File Dest = new File("ScreenShots\\" + System.currentTimeMillis() + ".png");

		String errflpath = Dest.getPath();

		FileUtils.copyFile(scrFile, Dest);

		return errflpath;

	}



	public void addCurrentScreenCaptureWOScrolling(final WebDriver driver)

			throws IllegalFormatException {

		try {

			Properties prop = FileReaderManager.getInstance().getConfigReader().getProperties();

			String localTestResultsPath = prop.getProperty("localTestResultsPath");

			// String testName = (String)
			// context.scenarioContext.getContext(TestData.TestName);

			String pathToScreenShot = "";

			if (driver instanceof WebDriver) {

				pathToScreenShot = returnScreencapturePath(driver);

				// take screen shot the page

				// Add to extent reports

				Reporter.addScreenCaptureFromPath(pathToScreenShot);

				// Add to word doc

				// addToWordDoc(localTestResultsPath + "\\" + TestRun.getTestRunName(),
				// testName, pathToScreenShot);

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
