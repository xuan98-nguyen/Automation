package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class AbstractTest {
    private WebDriver driver;


    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(Constants.URL);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
