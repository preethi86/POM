package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pages.TopMenu;
import utilities.ExcelReader;
import utilities.ExtentManager;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties config;
	public static TopMenu menu;
	FileInputStream fis;
	static String Path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx";
	public static ExcelReader excel = new ExcelReader(Path);
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	public static Logger log = Logger.getLogger(BasePage.class);

	public BasePage() {
		
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			config = new Properties();
			try {
				config.load(fis);
			} catch (IOException e) {
				e.getMessage();
			}

			if (System.getenv("browser") != null && !(System.getenv("browser").isEmpty())) {
				
				browser = System.getenv("browser");
				
				
			} else {
				browser = config.getProperty("Browser");
			}
			config.setProperty("browser", browser);

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\executables\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				log.info("Opened Chrome");

			}

			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\executables\\geckodriver-v0.23.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();

			}

			driver.manage().window().maximize();
			driver.get(config.getProperty("BaseURL"));
			driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("ImplicitWait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 10);
			menu = new TopMenu(driver);

		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
