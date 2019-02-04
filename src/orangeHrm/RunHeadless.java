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
			System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigFileReader().getDriverPath());

			ChromeOptions options = new ChromeOptions();
			if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowMaximized()) {
				options.addArguments("--headless");
			}
			if (FileReaderManager.getInstance().getConfigFileReader().getIgnoreCertificateErrors()) {
				options.addArguments("--ignore-certificate-errors");
			}
			options.addArguments("--window-size=" + FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize());
			
			options.addArguments("--whitelisted-ips", "--no-sandbox", "--disable-extensions");
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
