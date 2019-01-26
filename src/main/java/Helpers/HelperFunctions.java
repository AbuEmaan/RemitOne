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
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import managers.FileReaderManager;

public class HelperFunctions {

	

	public void setLastestWindow(WebDriver driver)
	{
		
		Set<String> allwindow = driver.getWindowHandles();
		for(String eachwindow:allwindow)
		{

		System.out.println(eachwindow);
		driver.switchTo().window(eachwindow);

		}
		
	}
	
	
	
	
	public void uploadFile(String fileName) throws AWTException, InterruptedException
	{

		String path = FileReaderManager.getInstance().getConfigReader().getImageFilePath();
		
		
		String fullPath = path + fileName;
		System.out.println("full path1: "+ fullPath);
		
		
		fullPath = "C:\\RemitOneImage\\uploadFile.PNG";
		
		System.out.println("full path2: "+ fullPath);

	    StringSelection ss = new StringSelection(fullPath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	    //imitate mouse events like ENTER, CTRL+C, CTRL+V
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
	
	
	public void hoverOverObject(By locator, WebDriver driver)
	{
		WebElement ele = driver.findElement(locator);
	    Actions action = new Actions(driver);
	    action.moveToElement(ele).build().perform();
	}
	
	
	public void scrollDown(String yAxelPixelCount, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+yAxelPixelCount+")");
	}
	
	
	public void selectValueFromDropDown(String id, String valueToSelect,WebDriver driver)
	{
		
		
		List<WebElement> options = driver.findElements(By.xpath("//select[@id ='"+id+"']/option"));

		for (WebElement option : options) {
			System.out.println(option.getText());
		    if (option.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
		        option.click();
		        break;
		    }
		}
	}

	
}
