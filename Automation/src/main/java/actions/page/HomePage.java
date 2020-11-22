package actions.page;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPages {
    private WebDriver driver;
    public static final String LOGIN_LINK = "//a[text()='Đăng nhập']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickToLoginPage() {
        waitToElementClickable(driver, LOGIN_LINK);
        clickToElement(driver, LOGIN_LINK);
        return PageGeneratorManager.getLoginPageObject(driver);
    }
}
