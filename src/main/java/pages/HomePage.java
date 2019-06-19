package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import testbase.BasePage;

public class HomePage extends BasePage {

	By pageCheckText = By.cssSelector("div.header-content>h1.et_pb_module_header");
	By bigPage = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(1)>a");
	By landPage = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(2)>a");
	By pricePage = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(3)>a");
	By forms = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(4)>a");
	By application = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(5)>a");
	By login = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(6)>a");
	By interaction = By.cssSelector("div.et_pb_text_inner ul>li:nth-child(7)>a");

	public String verifyPage() {

		return (driver.findElement(pageCheckText).getText());

	}

	public BigPage goToBigPage() {

		driver.findElement(bigPage).click();
		return new BigPage();

	}

	public void goToLandingPage() {

		driver.findElement(landPage).click();
	}

	public void goToPricePage() {

		driver.findElement(pricePage).click();
	}

	public FillInFormsPage goToForms() {

		driver.navigate().to("https://www.ultimateqa.com/automation/");
		driver.findElement(forms).click();

		System.out.println("clicked on fill in forms");
		return new FillInFormsPage();
	}

	public void goToApplication() {

		driver.findElement(application).click();
	}

	public void goToLogin() {

		driver.findElement(login).click();
	}

	public void goToInteraction() {

		driver.findElement(interaction).click();
	}

}
