package testcases;

import actions.commons.AbstractTest;
import actions.commons.reportconfig.ReportListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Approve extends AbstractTest {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() throws InterruptedException {
        driver = getBrowser();
        driver.get("http://dev.solashi.com:2896/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hieund");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111111");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testCase01ApproveSettlement() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra phê duyệt 1 quyết toán");
        driver.findElement(By.xpath("//span[text()='QUẢN LÝ QUYẾT TOÁN']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Click quyết toán chờ thẩm định");
        driver.findElement(By.xpath("//tbody/tr")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> settlementInforTab = driver.findElements(By.xpath("//span[text()='Thông tin quyết toán']"));
        if (settlementInforTab.size() > 0) {
            ReportListener.reportLog("Click thông tin quyết toán");
            settlementInforTab.get(0).click();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        ReportListener.reportLog("Click phê duyệt quyết toán");
        driver.findElement(By.xpath("//span[text()='Phê duyệt quyết toán']")).click();

        ReportListener.reportLog("Click xác nhận");
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo phê duyệt thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Phê duyệt thành công");
    }

    @Test
    public void testCase02ApproveDocument() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra phê duyệt 1 yêu cầu hỗ trợ tài liệu thành công");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='YÊU CẦU HỖ TRỢ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Click Hỗ trợ tài liệu");
        driver.findElement(By.xpath("//span[text()='Hỗ trợ tài liệu']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click yêu cầu chờ thẩm định");
        driver.findElement(By.xpath("//tbody/tr")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click phê duyệt yêu cầu");
        driver.findElement(By.xpath("//span[text()='Phê duyệt yêu cầu']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click xác nhận");
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo phê duyệt thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Cập nhật thành công");
    }

    @Test
    public void testCase03ApproveSchoolFee() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra phê duyệt 1 yêu cầu hỗ trợ học phí thành công");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='YÊU CẦU HỖ TRỢ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Click Hỗ trợ học phí");
        driver.findElement(By.xpath("//span[text()='Hỗ trợ học phí']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click yêu cầu chờ thẩm định");
        driver.findElement(By.xpath("//tbody/tr")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click phê duyệt yêu cầu");
        driver.findElement(By.xpath("//span[text()='Phê duyệt yêu cầu']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click xác nhận");
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo phê duyệt thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Cập nhật thành công");
    }

    @Test
    public void testCase04ApproveLaborSupport() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra phê duyệt 1 yêu cầu hỗ trợ rủi ro thành công");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='YÊU CẦU HỖ TRỢ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Click Hỗ trợ rủi ro");
        driver.findElement(By.xpath("//span[text()='Hỗ trợ rủi ro']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click yêu cầu chờ thẩm định");
        driver.findElement(By.xpath("//tbody/tr")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click phê duyệt yêu cầu");
        driver.findElement(By.xpath("//span[text()='Phê duyệt yêu cầu']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Click xác nhận");
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo phê duyệt thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Cập nhật thành công");
    }

    @AfterClass
    public void quitBrowser() {
        //Quit browser
        driver.quit();
    }
}
