package sprint.Utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSetup{
    static WebDriver driver;

    public static WebDriver invokeBrowser(String browserName) {

        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--disable-notifications");
                co.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver(co);
            } else {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}