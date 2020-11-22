package actions.page;

import actions.commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashBoardPage extends AbstractPages {

    private WebDriver driver;
    public static final String DASHBOARD_TITLE = "//header//b";

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyTitle(String dashboardTitle) {
        Assert.assertEquals(getTextElementByXpath(driver, DASHBOARD_TITLE), dashboardTitle);
    }
}
