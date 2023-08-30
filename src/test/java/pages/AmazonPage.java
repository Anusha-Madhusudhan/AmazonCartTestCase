/**
 * 
 */
package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WaitUtills;

/**
 * 
 */
public class AmazonPage {
	
	public AmazonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='a-column a-span6 a-span-last a-text-right']//a")
	WebElement tryDiffText;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;
	
    @FindBy(xpath = "//span[contains(@id,'amazons-choice-label')]")
	WebElement amazonChoice;
    
    @FindBy(xpath = "//h1[@id='title']//span")
    WebElement expectedText;
    
    
    @FindBy(xpath = "//span[@class='a-button-inner']//input[@id='add-to-cart-button']")
    WebElement addToCart;
    
    
    @FindBy(xpath = "//div[@class='a-popover-wrapper']//button")
    WebElement close;
    
    @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    WebElement cart;
    
    @FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
    WebElement cartProduct;
    
    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement actualText;

	public void clickTryDiffText() {
		
		try {
			
			if(tryDiffText.isDisplayed()) {
				tryDiffText.click();
			}
			
		}catch(Exception e) {
			System.out.println("Blocker is not present");
		}
		
	}

	public void eneterSearchText() {
		
		if(searchBox.isDisplayed()) {
			searchBox.clear();
			searchBox.sendKeys("kindle");
		}else {
			System.out.println("Search box is not displayed");
		}
		
	}

	public void clickSearchBtn() {
		if(searchBtn.isDisplayed()) {
			searchBtn.click();
		}else {
			System.out.println("Search button is not displayed");
		}
		
	}

	public void clickAmazonChoice() {
		if(amazonChoice.isDisplayed()) {
			amazonChoice.click();
			
		}else {
			System.out.println("Amazon choice is not displayed");
		}
		
	}

	public String getExpectedText() {
		
		String sExpectedText=null;
		if(expectedText.isDisplayed()) {
			sExpectedText=expectedText.getText();
		}else {
			System.out.println("expected text is not displayed");
		}
		
		return sExpectedText;
	}

	public void clickAddToCart(WebDriver driver) {
		
		if(addToCart.isDisplayed()) {
			
			if(WaitUtills.waitForElementToBeClickable(driver, addToCart)) {
			addToCart.click();
			}
		}else {
			System.out.println("addToCart is not displayed");
		}
		
	}

	public void clickClose(WebDriver driver) {
		try {
        if(close.isDisplayed()) {
			
			if(WaitUtills.waitForElementToBeClickable(driver, close)) {
				close.click();
			}
		}else {
			System.out.println("close btn is not displayed");
		}}catch(Exception e) {
			System.out.println("No pop up window");
		}
	}

	public void clickCart(WebDriver driver) {
      if(cart.isDisplayed()) {
			
			if(WaitUtills.waitForElementToBeClickable(driver, cart)) {
				cart.click();
			}
		}else {
			System.out.println("cart btn is not displayed");
		}
	}

	public void clickCartProduct(WebDriver driver) {
        if(cartProduct.isDisplayed()) {
			
			if(WaitUtills.waitForElementToBeClickable(driver, cartProduct)) {
				cartProduct.click();
			}
		}else {
			System.out.println("cart product is not displayed");
		}
		
		
	}

	public boolean verifyCartProduct(WebDriver driver,String expectedText2) {
		boolean isProductAddedToCart=false;
		if(WaitUtills.waitForWindows(driver, 2)) {
			Set<String> windoHanles=driver.getWindowHandles();
			List<String> windowHandleList=new ArrayList<String>(windoHanles);
			String parentWindowHandle=windowHandleList.get(0);
			String childWindowHandle=windowHandleList.get(1);
			driver.switchTo().window(childWindowHandle);
			if(actualText.isDisplayed()) {
				if(actualText.getText().equals(expectedText2)) {
					isProductAddedToCart=true;
					driver.switchTo().window(parentWindowHandle);
				}
			}else {
				System.out.println("cart product text is not displayed");
			}
		}
		return isProductAddedToCart;
	}
    
    
    
    
    
    
    
    
    
}
