package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By serachBox = By.xpath("//input[@type='search']");
	By productName = By.xpath("//td[text()='Tomato']");
	
	public void searchItems(String name)
	{
		driver.findElement(serachBox).sendKeys(name);
	}
	public String getSearchedText()
	{
		return driver.findElement(productName).getText();
	} 
	

}
