package testcases;

import actions.commons.AbstractTest;
import actions.commons.reportconfig.ReportListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends AbstractTest {

    private WebDriver driver;

    @BeforeClass
    public void goToHomePage() {
        driver = getBrowser();
        driver.get("http://dev.solashi.com:2896/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase01LoginWithNotExistAccount() throws InterruptedException {
        ReportListener.reportLog("Click vào link Đăng nhập");
        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();

        ReportListener.reportLog("Đăng nhập với user sai");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("abc123456");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111111");

        ReportListener.reportLog("Click vào Đăng nhập");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        ReportListener.reportLog("Kiểm tra xuất hiện message đăng nhập lỗi");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='MuiGrid-root']/span")).getText(), "*Sai tài khoản hoặc mật khẩu");
    }

    @Test
    public void testCase02LoginWithEmptyAllFields() {
        ReportListener.reportLog("Đăng nhập với user và password để trống");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");

        ReportListener.reportLog("Click vào Đăng nhập");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        ReportListener.reportLog("Kiểm tra xuất hiện message yêu cầu nhập user");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='username-helper-text']")).getText(), "Tên đăng nhập là trường bắt buộc");

        ReportListener.reportLog("Kiểm tra xuất hiện message yêu cầu nhập password");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='password-helper-text']")).getText(), "Mật khẩu là trường bắt buộc");
    }

    @Test
    public void testCase03LoginWithEmptyUserField() {
        ReportListener.reportLog("Đăng nhập với user để trống");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111111");

        ReportListener.reportLog("Click vào Đăng nhập");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        ReportListener.reportLog("Kiểm tra xuất hiện message yêu cầu nhập user");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='username-helper-text']")).getText(), "Tên đăng nhập là trường bắt buộc");
    }

    @Test
    public void testCase04LoginWithEmptyPasswordField() {
        ReportListener.reportLog("Đăng nhập với password để trống");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hieund");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");

        ReportListener.reportLog("Click vào Đăng nhập");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        ReportListener.reportLog("Kiểm tra xuất hiện message yêu cầu nhập password");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='password-helper-text']")).getText(), "Mật khẩu là trường bắt buộc");
    }

    @Test
    public void testCase05LoginWithWrongPassword() throws InterruptedException {
        ReportListener.reportLog("Đăng nhập với password sai");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hieund");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("222222");

        ReportListener.reportLog("Click vào Đăng nhập");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        ReportListener.reportLog("Kiểm tra xuất hiện message đăng nhập lỗi");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='MuiGrid-root']/span")).getText(), "*Sai tài khoản hoặc mật khẩu");
    }

    @Test
    public void testCase06LoginWithValidAccount() {
        ReportListener.reportLog("Đăng nhập với user đúng");
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hieund");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111111");

        ReportListener.reportLog("Click vào Đăng nhập");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        ReportListener.reportLog("Kiểm tra màn hình dashboard hiển thị");
        Assert.assertEquals(driver.findElement(By.xpath("//header//b")).getText(), "PHẦN MỀM QUẢN LÝ QUỸ HỖ TRỢ VIỆC LÀM NƯỚC NGOÀI");
    }

    @AfterClass
    public void afterClass() {
        //Quit browser
        driver.quit();
    }
}
