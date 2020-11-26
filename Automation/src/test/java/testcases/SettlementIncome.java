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

public class SettlementIncome extends AbstractTest {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() throws InterruptedException {
        driver = getBrowser();
        driver.get("http://dev.solashi.com:2896/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("company");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111111");
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='MuiIconButton-label']/img")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thêm mới quyết toán theo thu nhập']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']")).click();
    }

    @Test
    public void testCase01CreateSettlementIncomeWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tổng doanh thu kỳ này");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Tổng doanh thu kỳ này']/following-sibling::td/p")).getText(),
                "Trường tổng doanh thu kỳ này không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số tiền đã nộp");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Số tiền đã nộp']/following-sibling::td/p")).getText(),
                "Trường số tiền đã nộp không được bỏ trống.");
    }

    @Test
    public void testCase02CreateSettlementIncomeWithEmptyTotalIncome() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống tổng doanh thu kỳ này");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập Số tiền đã nộp: 10000000");
        driver.findElement(By.xpath("//td[text()='Số tiền đã nộp']/following-sibling::td//input")).sendKeys("10000000");

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tổng doanh thu kỳ này");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Tổng doanh thu kỳ này']/following-sibling::td/p")).getText(),
                "Trường tổng doanh thu kỳ này không được bỏ trống.");
    }

    @Test
    public void testCase03CreateSettlementIncomeWithEmptyAmount() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống số tiền đã nộp");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập Tổng doanh thu kỳ này: 500000000");
        driver.findElement(By.xpath("//td[text()='Tổng doanh thu kỳ này']/following-sibling::td//input")).sendKeys("500000000");

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số tiền đã nộp");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Số tiền đã nộp']/following-sibling::td/p")).getText(),
                "Trường số tiền đã nộp không được bỏ trống.");
    }

    @Test
    public void testCase04CreateSettlementIncomeSuccess() throws InterruptedException {
        ReportListener.reportLog("Thêm quyết toán theo thu nhập thành công");
        driver.navigate().refresh();
        Thread.sleep(2000);

        ReportListener.reportLog("Nhập Tổng doanh thu kỳ này: 500000000");
        driver.findElement(By.xpath("//td[text()='Tổng doanh thu kỳ này']/following-sibling::td//input")).sendKeys("500000000");
        Thread.sleep(2000);

        ReportListener.reportLog("Nhập Số tiền đã nộp: 10000000");
        driver.findElement(By.xpath("//td[text()='Số tiền đã nộp']/following-sibling::td//input")).sendKeys("10000000");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo tạo thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(),
                "Tạo thành công");
    }

    @AfterClass
    public void quitBrowser() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Quyết toán chờ phê duyệt']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Xóa']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
