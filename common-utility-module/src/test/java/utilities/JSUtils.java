package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class JSUtils {
    /**
    JAVASCRIPT EXECUTOR METHODS
    @param element
    scrolls into that element
    */
    public static void JSscrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
    scroll all the way down
     */
    public static void JSscrollAllTheWayDown() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /**
    scroll all the way up
     */
    public static void JSscrollAllTheWayUp() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    /**
    @param element
    clicks on that element
     */
    //    EXPLICITLY WAIT FOR ELEMENT TO BE VISIBLE, SCROLL INTO THE ELEMENT, THEN CLICK BY JS
    public static void JSclickWithTimeout(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(element, 5));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
   @param idOfElement id of teh WebElement that we want to locate
   locating element using javascript executor and returns that WebElement
    */
    public WebElement JSlocateElements(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        return ((WebElement) js.executeScript("return document.getElementById('" + idOfElement + "')"));
    }

    /**
    @param1 inputElement
    @param2 text
    type the string in that web element
     */
    public static void JSsetValueBy(WebElement inputElement, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", inputElement);
    }

    /**
     @param idOfElement
     */
    public static String JSgetValueBy(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);
        return value;
    }
}

