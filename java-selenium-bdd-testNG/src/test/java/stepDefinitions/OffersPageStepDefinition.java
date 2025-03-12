package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class OffersPageStepDefinition {

	public String offersPagePN;
	TestContextSetup testContextSetup;
	public OffersPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Then("User Searched for Same ShortName {string} in offers page")
	public void user_searched_for_same_short_name_in_offers_page(String shortName) {
		
		switchToOffersPage();
		//wait for Search Box Locator to be visible in the child Window 
		WebDriverWait wait = new WebDriverWait(testContextSetup.driver,Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
		//Search with the product name 
		searchBox.sendKeys(shortName);
		WebElement productContainer  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Tomato']")));
		//Extracted Text from the offers page Product
		offersPagePN = productContainer.getText();
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
