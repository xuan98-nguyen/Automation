package actions.commons;

import actions.page.HomePage;
import actions.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static HomePage getHomePageObject(WebDriver driver) {
        return new HomePage(driver);
    }

    public static LoginPage getLoginPageObject(WebDriver driver) {
        return new LoginPage(driver);
    }
}
