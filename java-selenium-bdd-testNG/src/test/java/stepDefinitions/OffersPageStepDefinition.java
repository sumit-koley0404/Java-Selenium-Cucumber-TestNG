package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.Then;

import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {

	public String offersPagePN;
	TestContextSetup testContextSetup;
	public OffersPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Then("User Searched for Same ShortName {string} in offers page")
	public void user_searched_for_same_short_name_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		Thread.sleep(2000);
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.searchItems(shortName);
		offersPagePN = offersPage.getSearchedText();
		System.out.println(offersPagePN);
	}
	public void switchToOffersPage()
	{
		        //**Child Window Handling**
				//take all window Handles in one set 
				Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
				//using iterator window handles can be iterated 
				Iterator<String> windowId = windowHandles.iterator();
				//assigning values of windows 
				String parantWindow = windowId.next();
				String childWindow = windowId.next();
				//Switch the windows using switchTo method
				testContextSetup.driver.switchTo().window(childWindow);
	}
	
	@Then("Verify the existance of the product")
	public void verify_the_existance_of_the_product() {
		//Verify both product name
		Assert.assertEquals( offersPagePN,testContextSetup.landingPagePN);
		//Close the Driver
		testContextSetup.driver.quit();
	}

}
