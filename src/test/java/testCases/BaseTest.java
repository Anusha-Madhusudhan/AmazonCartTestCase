/**
 * 
 */
package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import constants.FileConstants;
import utills.FileUtills;

/**
 * 
 */
public class BaseTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setUp() {
		
		driver=getDriver(FileUtills.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILEPATH,"browser"));
				
		String url=FileUtills.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILEPATH,"URL");
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
	}
	
	
	
 private static WebDriver getDriver(String sBrowserName) {
      String brName=sBrowserName.toLowerCase();
		
		switch (brName) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "safari":
			return new SafariDriver();
			
		case "edge":
			return new EdgeDriver();
			

		default:
			System.out.println("Provide valid browser name");
			return null;
		}
	}
	
	
	
	@AfterClass
	void close() {
		driver.quit();
	}

}
