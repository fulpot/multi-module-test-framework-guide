package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//form//textarea")
    public WebElement searchBox;

    @FindBy(css="div[aria-label='Search by voice']")
    public WebElement searchByVoiceButton;

    @FindBy(css="div[aria-label='Search by image']")
    public WebElement searchByImageButton;

}
