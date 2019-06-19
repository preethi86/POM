package tests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BigPage;
import pages.HomePage;
import testbase.BasePage;
import utilities.TestUtil;

public class HomePageTest {

	HomePage hp;

	@Test(priority = 1)
	public void checkForHomePageTest() {
		hp = new HomePage();
		String actualString = hp.verifyPage();
		Assert.assertEquals(actualString, "Automation Practice");
		hp.goToBigPage().checkSearchBox();
		// String actualStringBP = bp.verifyPageText();
		// Assert.assertEquals(actualStringBP, "Skills Improved:");
		BasePage.menu.goToCourses();
	}

	@Test(priority = 2, dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void fillInFormsTest(Hashtable<String, String> table) {
		hp.goToForms().fillForms(table.get("Name"), table.get("Message"));
	}

}
