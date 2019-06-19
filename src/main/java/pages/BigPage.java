package pages;

import org.openqa.selenium.By;

import testbase.BasePage;

public class BigPage extends BasePage {

	By pageText = By.cssSelector("div.et_pb_text_inner>h2");
	By searchBox = By.cssSelector("#s");
	By searchButton = By.cssSelector("#searchsubmit");

	public String verifyPageText() {
		return(driver.findElement(pageText).getText());
	}
	
	public void checkSearchBox()
	{
		driver.findElement(searchBox).sendKeys("mobile");
		driver.findElement(searchButton).click();
		
	}
	
}