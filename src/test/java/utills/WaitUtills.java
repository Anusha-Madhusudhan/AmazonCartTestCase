/**
 * 
 */
package utills;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 */
public class WaitUtills {
	
	public static boolean waitForElementToBeClickable(WebDriver driver,WebElement ele) {
		boolean isElementClickable=false;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			isElementClickable=true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return isElementClickable;
	}
	
	
	public static boolean waitForElementToBeVisible(WebDriver driver,WebElement ele) {
		boolean isElementVisible=false;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			isElementVisible=true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return isElementVisible;
	}
	
	public static boolean waitForWindows(WebDriver driver,int iWindowsCount) {
		boolean isNumOfWindowsPresent=false;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(iWindowsCount));
			isNumOfWindowsPresent=true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return isNumOfWindowsPresent;
	}

}
