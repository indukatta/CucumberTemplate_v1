package stepDefinitions;

import helper.SeleniumHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

import java.util.List;

public class GoogleSearchSteps extends DriverFactory {
	Scenario sc;

	@Before
	public void beforeStep(Scenario scenario) {
		this.sc = scenario;
	}

	@Given("^I access Google website$")
	public void i_access_website() throws Throwable {
		sc.log("Adding scenario report steps...........");
		driver.get("https://www.google.com/");
		SeleniumHelper.captureScreenshot(sc);
		//sc.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "FailedScreenshot");
	}

	@When("^I search with OneFamily keyword$")
	public void i_search_onefamily_keyword() throws Throwable {
		googleSearchPage.searchKeyword("OneFamily");
	}

	@When("^I search with Cucumber keyword$")
	public void i_search_cucumber_keyword() throws Throwable {
		googleSearchPage.searchKeyword("Cucumber");
	}

	@Then("^the search results are displayed$")
	public void i_validate_that_results_displayed_successfully() throws Throwable {
		googleSearchPage.getTitle();
	}

}
