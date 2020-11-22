package actions.page;

import actions.commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends AbstractPages {
    private WebDriver driver;
    public static final String USER_INPUT = "//input[@id='username']";
    public static final String PASSWORD_INPUT = "//input[@id='password']";
    public static final String LOGIN_BUTTON = "//button[@id='loginButton']";
    public static final String ERROR_MESSAGE = "//div[@class='MuiGrid-root']/span";
    public static final String EMPTY_USER_MESSAGE = "//p[@id='username-helper-text']";
    public static final String EMPTY_PASSWORD_MESSAGE = "//p[@id='password-helper-text']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String password) {
        waitToElementDisplayedByXpath(driver, USER_INPUT);
        sendKeyToElement(driver, USER_INPUT, user);
        sendKeyToElement(driver, PASSWORD_INPUT, password);
        clickToElement(driver, LOGIN_BUTTON);
        delay(3);
    }

    public void verifyLoginFailMessage(String errorMessage) {
        Assert.assertEquals(getTextElementByXpath(driver, ERROR_MESSAGE), errorMessage);
    }

    public void verifyEmptyUserMessge(String errorMessage) {
        Assert.assertEquals(getTextElementByXpath(driver, EMPTY_USER_MESSAGE), errorMessage);
    }

    public void verifyEmptyPasswordMessge(String errorMessage) {
        Assert.assertEquals(getTextElementByXpath(driver, EMPTY_PASSWORD_MESSAGE), errorMessage);
    }
}
