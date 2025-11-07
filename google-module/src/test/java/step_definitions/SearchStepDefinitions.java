package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ResultPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;


import static org.junit.jupiter.api.Assertions.*;

public class SearchStepDefinitions {

    private HomePage homePage = new HomePage();
    private ResultPage resultPage = new ResultPage();

    @Given("The user navigates to the website")
    public void the_user_navigates_to_the_website() {
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        homePage.acceptAllPrivacy.click();
    }
    @When("The user enters {string} in search box")
    public void the_user_enters_in_search_box(String thema) {
        homePage.searchBox.click();
        homePage.searchBox.sendKeys(thema);
    }
    @And("The user clicks Google Search button")
    public void the_user_clicks_google_search_button() {
       homePage.googleSearchButton.click();
        BrowserUtils.waitFor(2);
    }
    @Then("The user sees search results of {string}")
    public void the_user_sees_search_results_of(String thema) {
        var count = resultPage.resultHeaders.stream()
                .map(WebElement::getText)
                .filter(s -> !s.equalsIgnoreCase(thema))
                .count();

        assertTrue(count != 0);
    }

}
