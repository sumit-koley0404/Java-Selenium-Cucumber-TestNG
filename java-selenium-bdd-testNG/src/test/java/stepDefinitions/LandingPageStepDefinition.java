package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	TestContextSetup testContextSetup;
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup= testContextSetup;
	}
	public String offersPagePN;
	@Given("User is on Landing Page")
	public void user_is_on_landing_page() {
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.manage().window().maximize();
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	
	@When("User Searched with ShortName {string} and Extracted ActualName Of the Product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
	    //Search with the shortName Tom in the searhBox
		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.searchItems(shortName);
		//Wait for Tomato Product to be visible
		Thread.sleep(2000);
		//Extracted Tomato Text from the product 
		testContextSetup.landingPagePN = landingPage.getSearchedText().split("-")[0].trim();
		//Print The Extracted Product
		System.out.println(testContextSetup.landingPagePN);
		landingPage.topDealsButtonClick();	
	}
	
}
