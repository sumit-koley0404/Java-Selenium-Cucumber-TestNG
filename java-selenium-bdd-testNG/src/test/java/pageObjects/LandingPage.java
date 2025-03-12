package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[text()='Tomato - 1 Kg']");
	By topDeals = By.xpath("//a[text()='Top Deals']");
	
	public void searchItems(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getSearchedText()
	{
		return driver.findElement(productName).getText();
	}
	public void topDealsButtonClick()
	{
		driver.findElement(topDeals).click();
	}

}
