/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AmazonPage;

/**
 * 
 */
public class AmazonCartTestCase extends BaseTest {
	
	AmazonPage ap;
	
	@Test
	void amazonCartTest() {
		ap=new AmazonPage(driver);
		ap.clickTryDiffText();
		ap.eneterSearchText();
		ap.clickSearchBtn();
		ap.clickAmazonChoice();
		String expectedText=ap.getExpectedText();
		ap.clickAddToCart(driver);
		ap.clickClose(driver);
		ap.clickCart(driver);
		ap.clickCartProduct(driver);
	Assert.assertTrue(ap.verifyCartProduct(driver,expectedText));
		
		
	}

}
