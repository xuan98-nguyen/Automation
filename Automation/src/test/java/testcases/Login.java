package testcases;

import actions.commons.AbstractTest;
import actions.commons.PageGeneratorManager;
import actions.commons.reportconfig.ReportListener;
import actions.page.DashBoardPage;
import actions.page.HomePage;
import actions.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testdata.TestData;

public class Login extends AbstractTest {

    private WebDriver driver;
    private HomePage homePageObject;
    private LoginPage loginPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void goToHomePage(String browserName) {
        driver = getBrowser(browserName);
        homePageObject = PageGeneratorManager.getHomePageObject(driver);
    }

    @Test
    public void testCase01LoginWithNotExistAccount() {
        ReportListener.reportLog("Click to login link");
        loginPageObject = homePageObject.clickToLoginPage();

        ReportListener.reportLog("Login with user: " + TestData.INVALID_USER);
        loginPageObject.login(TestData.INVALID_USER, TestData.PASSWORD);

        ReportListener.reportLog("Verify display error message: " + TestData.ERROR_MESSAGE);
        loginPageObject.verifyLoginFailMessage(TestData.ERROR_MESSAGE);
    }

    @Test
    public void testCase02LoginWithEmptyAllFields() {
        ReportListener.reportLog("Login with empty all fields");
        loginPageObject.refreshPage(driver);
        loginPageObject.login(TestData.EMPTY, TestData.EMPTY);

        ReportListener.reportLog("Verify display empty user messages: " + TestData.EMPTY_USER_MESSAGE);
        loginPageObject.verifyEmptyUserMessge(TestData.EMPTY_USER_MESSAGE);

        ReportListener.reportLog("Verify display empty password messages: " + TestData.EMPTY_USER_MESSAGE);
        loginPageObject.verifyEmptyPasswordMessge(TestData.EMPTY_PASSWORD_MESSAGE);
    }

    @Test
    public void testCase03LoginWithEmptyUserField() {
        ReportListener.reportLog("Login with empty user field");
        loginPageObject.refreshPage(driver);
        loginPageObject.login(TestData.EMPTY, TestData.PASSWORD);

        ReportListener.reportLog("Verify display empty user messages: " + TestData.EMPTY_USER_MESSAGE);
        loginPageObject.verifyEmptyUserMessge(TestData.EMPTY_USER_MESSAGE);
    }

    @Test
    public void testCase04LoginWithEmptyPasswordField() {
        ReportListener.reportLog("Login with empty password field");
        loginPageObject.refreshPage(driver);
        loginPageObject.login(TestData.USER, TestData.EMPTY);

        ReportListener.reportLog("Verify display empty password messages: " + TestData.EMPTY_USER_MESSAGE);
        loginPageObject.verifyEmptyPasswordMessge(TestData.EMPTY_PASSWORD_MESSAGE);
    }

    @Test
    public void testCase05LoginWithWrongPassword() {
        ReportListener.reportLog("Login with user: " + TestData.USER);
        loginPageObject.refreshPage(driver);
        loginPageObject.login(TestData.USER, TestData.INVALID_PASSWORD);

        ReportListener.reportLog("Verify display error message: " + TestData.ERROR_MESSAGE);
        loginPageObject.verifyLoginFailMessage(TestData.ERROR_MESSAGE);
    }

    @Test
    public void testCase06LoginWithValidAccount() {
        ReportListener.reportLog("Login with user: " + TestData.USER);
        loginPageObject.refreshPage(driver);
        loginPageObject.login(TestData.USER, TestData.PASSWORD);

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.verifyTitle(TestData.DASHBOARD_TITLE);
    }

    @AfterClass
    public void afterClass() {
        //Quit browser
        driver.quit();
    }
}
