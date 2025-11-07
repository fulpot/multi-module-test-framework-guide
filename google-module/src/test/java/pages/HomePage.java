package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css="div[class='FPdoLc lJ9FBc'] input[value='Google Search']")
    public WebElement googleSearchButton;

    @FindBy(xpath="//div[text()='Accept all']")
    public WebElement acceptAllPrivacy;
}
