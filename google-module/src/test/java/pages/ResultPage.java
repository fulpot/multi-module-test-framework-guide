package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {

    @FindBy(css="div[id='res'] div[id='search'] h3")
    public List<WebElement> resultHeaders;
}
