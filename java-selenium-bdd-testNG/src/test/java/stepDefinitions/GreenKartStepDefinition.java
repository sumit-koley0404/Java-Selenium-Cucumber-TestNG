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

public class GreenKartStepDefinition {

	public WebDriver driver;
	public String landingPagePN;
	public String offersPagePN;
	@Given("User is on Landing Page")
	public void user_is_on_landing_page() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	
	@When("User Searched with ShortName {string} and Extracted ActualName Of the Product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String shortName) {
	    //Search with the shortName Tom in the searhBox
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		//Wait for Tomato Product to be visible
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//h4[text()='Tomato - 1 Kg']")));
		//Extracted Tomato Text from the product 
		 landingPagePN = driver.findElement(By.xpath("//h4[text()='Tomato - 1 Kg']")).
				getText().split("-")[0].trim();
		//Print The Extracted Product
		System.out.println(landingPagePN);
		
	}
	
	
	@Then("User Searched for Same ShortName {string} in offers page")
	public void user_searched_for_same_short_name_in_offers_page(String shortName) {
		//Click on the Top Deals button
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		//**Child Window Handling**
		//take all window Handles in one set 
		Set<String> windowHandles = driver.getWindowHandles();
		//using iterator window handles can be iterated 
		Iterator<String> windowId = windowHandles.iterator();
		//assigning values of windows 
		String parantWindow = windowId.next();
		String childWindow = windowId.next();
		//Switch the windows using switchTo method
		driver.switchTo().window(childWindow);
		
		//wait for Search Box Locator to be visible in the child Window 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
		//Search with the product name 
		searchBox.sendKeys(shortName);
		WebElement productContainer  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Tomato']")));
		//Extracted Text from the offers page Product
		offersPagePN = productContainer.getText();
		System.out.println(offersPagePN);
		
		
		
		
		
	}
	
	@Then("Verify the existance of the product")
	public void verify_the_existance_of_the_product() {
		//Verify both product name
		Assert.assertEquals(landingPagePN, offersPagePN);
		//Close the Driver
		driver.close();
	}

}
