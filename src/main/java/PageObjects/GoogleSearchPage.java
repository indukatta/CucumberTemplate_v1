package PageObjects;

import helper.SeleniumHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends SeleniumHelper {

	public @FindBy(xpath="//input[@title='Search']")
	WebElement  btnSearch;
	
	
	public void searchKeyword(String keyword) {
		sendKeys(btnSearch, keyword);
		sendKeys(btnSearch, Keys.ENTER);
	}

	public String getTitle(){
		return driver.getTitle();
	}

}
