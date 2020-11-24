package testcases;

import actions.commons.AbstractTest;
import actions.commons.reportconfig.ReportListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Business extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='THÔNG TIN DN, sở LĐ-TB-XH']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thông tin doanh nghiệp']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thêm mới']")).click();
    }

    @Test
    public void testCase01CreateBusinessWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường ");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên doanh nghiệp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::p")).getText(),
                "Trường tên doanh nghiệp không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên giao dịch");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::p")).getText(),
                "Trường tên giao dịch không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Loại doanh nghiệp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::p")).getText(),
                "Trường loại hình doanh nghiệp không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::p")).getText(),
                "Trường số điện thoại không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::p")).getText(),
                "Trường địa chỉ email không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tỉnh thành");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::p")).getText(),
                "Trường Tỉnh/ Thành phố không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Quận huyện");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::p")).getText(),
                "Trường Quận/ Huyện không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Phường xã");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::p")).getText(),
                "Trường Phường/ Xã không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ cụ thể");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::p")).getText(),
                "Trường địa chỉ chi tiết không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Ngày đăng ký chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/parent::div/following-sibling::p")).getText(),
                "Trường ngày đăng ký chứng chỉ không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Ngày cấp chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/parent::div/following-sibling::p")).getText(),
                "Trường ngày cấp chứng chỉ không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::p")).getText(),
                "Trường chứng chỉ số không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Cán bộ phụ trách");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::p")).getText(),
                "Trường người phụ trách không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo thu nhập");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo khu vực không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo người lao động");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo người lao động không được bỏ trống.");
    }

    /*
     * Random the number with 11 digits
     */
    public static long randomNumber() {
        Random r = new Random();
        return 100000000L + (long)(r.nextDouble() * 99999999L);
    }

    @AfterClass
    public void quitBrowser() {
        //Quit browser
        driver.quit();
    }
}
