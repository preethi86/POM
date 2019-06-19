package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
	
	By ulitimateQA = By.cssSelector("div.logo_container>a:nth-child(2)>img");
	By course = By.cssSelector("ul#top-menu>li#menu-item-504>a");
	By seleResources = By.cssSelector("ul#top-menu>li#menu-item-6838>a");
	By autExercises = By.cssSelector("ul#top-menu>li#menu-item-587>a");
	By blog = By.cssSelector("ul#top-menu>li#menu-item-477>a");
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void goToUltimateQA()
	{
		driver.findElement(ulitimateQA).click();
	}
	
	public void goToCourses()
	{
		driver.findElement(course).click();
	}
	
	public void goToSeleniumResources()
	{
		driver.findElement(seleResources).click();
	}
	
	public void goToAutomationExcercises()
	{
		driver.findElement(autExercises).click();
	}
	public void goToBlog()
	{
		driver.findElement(blog).click();
	}
}
