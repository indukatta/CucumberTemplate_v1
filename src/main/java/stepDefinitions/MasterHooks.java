package stepDefinitions;

import PageObjects.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;


import helper.SeleniumHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {


	@Before()
	public void setUp(){
		driver = getWebdriver();
		wait = waitDriver();
//		automationPracPage = PageFactory.initElements(driver, AutomationPracticePageObjects.class);
//		ap_regPage = PageFactory.initElements(driver, AP_RegistrationPage.class);
		googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
	}

//	@Before("@airasia")
//	public void setUp_airAsia() {
//		driver = getWebdriver();
//		wait = waitDriver();
//		aa_HomePage = PageFactory.initElements(driver, AA_HomePageObjects.class);
//		aa_SearchPage = PageFactory.initElements(driver, AA_SearchResultsPage.class);
//		driver.get("https://www.airasia.com/en/home.page");
//	}
//
//	@Before("@travel")
//	public void setUp_NewTours() {
//		driver = getWebdriver();
//		wait = waitDriver();
//		newToursPage = PageFactory.initElements(driver, NewToursPageObjects.class);
//		driver.get("http://newtours.demoaut.com/");
//	}
//
//	@Before("@automationPractice")
//	public void setUp_automationPractice() {
//		driver = getWebdriver();
//		wait = waitDriver();
//		automationPracPage = PageFactory.initElements(driver, AutomationPracticePageObjects.class);
//		ap_regPage = PageFactory.initElements(driver, AP_RegistrationPage.class);
//		driver.get("http://automationpractice.com/index.php");
//	}

	@After()
	public void tearDown(Scenario scenario) {
		try {
			if (driver != null) {
				if (scenario.isFailed()) {
				//	scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png","Failed Screenshot");
					SeleniumHelper.captureScreenshot(scenario);
				}

				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("Method failed: tearDown(), Exception " + e.getMessage());
		}
	}

}
