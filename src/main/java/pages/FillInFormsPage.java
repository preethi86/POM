package pages;

import org.openqa.selenium.By;

import testbase.BasePage;

public class FillInFormsPage extends BasePage {
	
	By name = By.cssSelector("input#et_pb_contact_name_0");
	By message = By.cssSelector("textarea#et_pb_contact_message_0");
	By submit = By.cssSelector("button.et_pb_contact_submit.et_pb_button");
	
	public void fillForms(String fillname, String fillmessage)
	{
		driver.findElement(name).sendKeys(fillname);
		driver.findElement(message).sendKeys(fillmessage);
		driver.findElement(submit).click();
		
	}
	
	
	
	

}
