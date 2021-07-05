package sprint.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import sprint.Utils.DriverSetup;
import sprint.Utils.FileIO;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseUI {
    public static WebDriver driver;
    public static Properties prop;


    public BaseUI() {
        prop = FileIO.initProperties();
    }

    public void invokeBrowser(String browser){
        driver = DriverSetup.invokeBrowser(prop.getProperty(browser));
    }

    /*** Opening URL ***/
    public void openURL(String wbsitekey) {
        driver.get(prop.getProperty(wbsitekey));

    }

    /*** CLOSE driver ***/
    public void quit() {
        driver.quit();
    }

    /*** Input data function ***/
    public void sendData(By locator, String key) {
        driver.findElement(locator).sendKeys(key);
    }

    /*** Get By locator using locator key ***/
    public static By getLocator(String locatorKey) {
        if (locatorKey.endsWith("_id")) {
            return By.id(prop.getProperty(locatorKey));
        }
        if (locatorKey.endsWith("_name")) {
            return (By.name(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_className")) {
            return (By.className(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_xpath")) {
            return (By.xpath(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_css")) {
            return (By.cssSelector(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_linkText")) {
            return (By.linkText(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_partialLinkText")) {
            return (By.partialLinkText(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_tagName")) {
            return (By.tagName(prop.getProperty(locatorKey)));
        }

        return null;
    }

    /************** Take screenshot ****************/
    public static void takeScreenShot(String filename) {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("Screenshots\\" + filename + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
