package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class SearchAnItemStepDefinitions {

    private HomePage homePage = new HomePage();

    @Given("The user navigates to the website")
    public void the_user_navigates_to_the_website() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
    }
    @When("The user enters {string} in search box")
    public void the_user_enters_in_search_box(String item) {
        homePage.searchBox.sendKeys(item);
    }
    @And("The user clicks search button")
    public void the_user_clicks_search_button() {
        homePage.searchButton.click();
        BrowserUtils.waitFor(2);
    }
}
