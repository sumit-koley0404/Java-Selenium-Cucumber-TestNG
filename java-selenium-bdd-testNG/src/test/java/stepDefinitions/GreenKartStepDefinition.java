package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinition {

	
	@Given("User is on Landing Page")
	public void user_is_on_landing_page() {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("User Searched with ShortName {string} and Extracted ActualName Of the Product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String string) {
	    System.out.println("***");
	}
	@Then("User Searched for Same ShortName in offers page to check if product exists")
	public void user_searched_for_same_short_name_in_offers_page_to_check_if_product_exists() {
		System.out.println("***");
	}

}
