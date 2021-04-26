package utils;

import java.util.concurrent.TimeUnit;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.BrowserConstants;
import stepDefinitions.GoogleSearchSteps;

public class DriverFactory {
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static GoogleSearchPage googleSearchPage;

	public WebDriver getWebdriver() {
		try {
		ReadConfigFile file = new ReadConfigFile();
		
		String browserName = file.getBrowser();
		System.out.println("-=-=-=-=-=-==--=-=-: "+browserName);
		System.out.println("driver-=-=-=-=-=-==--=-=-: "+driver);		
		switch (browserName) {

		case "chrome":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, BrowserConstants.Chrome_Driver_Path);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", BrowserConstants.FireFox_Driver_Path);
			driver = new FirefoxDriver();
			break;

		}
		}catch (Exception e) {
			System.out.println("Unable to lauch browser due to: "+e.toString());
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public WebDriverWait waitDriver() {
		return new WebDriverWait(driver, 30);
	}

}
