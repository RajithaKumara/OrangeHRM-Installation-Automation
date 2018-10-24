package orangeHrm;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;

//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import managers.FileReaderManager;
import pageObjects.Installer;

public class RunHeadless {

	
		public static void main(String[] args) throws IOException 
		{
			//Driver Headless mode 
//			System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigFileReader().getDriverPath());  
//			
//			ChromeOptions options = new ChromeOptions(); 
//			
//			options.addArguments("--headless", "--disable-gpu", "--window-size=1920x1080","--ignore-certificate-errors");  
//			
//			WebDriver driver = new ChromeDriver(options);  
			
			//Trigger UI automation
			
			System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigFileReader().getDriverPath());

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless","--ignore-certificate-errors");  
			
			WebDriver driver = new ChromeDriver(options); 
			
			Installer newInstaller = new Installer(driver);
			
			try
			{
				
				newInstaller.installationSteps();			
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				// Take a screenshot of the current page
				   
		           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			       FileUtils.copyFile(screenshot, new File(FileReaderManager.getInstance().getConfigFileReader().getSaveScreenShotPath()));
				
			       driver.quit();
			}
			
			
			
	
		      
	
		      
		        
		  }

	}
