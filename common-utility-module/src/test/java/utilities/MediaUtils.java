package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaUtils {
    /**
    This method captures screenshot of the entire page
   */
    public static void takeScreenshotOfTheEntirePage() throws IOException {
        File image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + now + "image.png";
        FileUtils.copyFile(image, new File(path));
    }

    /**
    This method captures screenshot of specific elements
    this method accepts an elements and saves the screenshot of that element in the test-output folder
     */
    public static void takeScreenshotOfThisElement(WebElement element) throws IOException {
        File image = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/ElementScreenshot/" + now + "image.png";
        FileUtils.copyFile(image, new File(path));
    }

    /**
    This method captures the image and returns the path of that image
    RETURN TYPE : static String
    return new File(path).getAbsolutePath();
     */
    public static String takeScreenshotOfTheEntirePageAsString() throws IOException {
        File image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
        String path = System.getProperty("user.dir") + "/test-output/Reports/Screenshots/" + now + "image.png";
        FileUtils.copyFile(image, new File(path));
        return new File(path).getAbsolutePath();
    }

}
