package testcases;

import actions.commons.AbstractTest;
import actions.commons.reportconfig.ReportListener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class LaborSupport extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='Thêm mới yêu cầu hỗ trợ rủi ro']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']")).click();
    }

    @Test
    public void testCase01CreateLaborSupportWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        driver.findElement(By.xpath("//span[text()='Gửi yêu cầu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='none presentation']//button")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Họ tên người lao động");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Họ tên người lao động']/following-sibling::p")).getText(),
                "Trường tên người lao động không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số hộ chiếu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số hộ chiếu']/following-sibling::p")).getText(),
                "Trường số hộ chiếu không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Nơi cấp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Nơi cấp']/following-sibling::p")).getText(),
                "Trường nơi cấp hộ chiếu không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Ngày cấp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Ngày cấp']/parent::div/following-sibling::p")).getText(),
                "Trường ngày cấp hộ chiếu không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Nước đến làm việc");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Nước đến làm việc']/following-sibling::p")).getText(),
                "Trường nước đến làm việc không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Từ ngày");
        Assert.assertEquals(driver.findElement(By.xpath("(//label[text()='Từ ngày']/parent::div/following-sibling::p)[1]")).getText(),
                "Trường ngày bắt đầu hợp đồng không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Đến ngày");
        Assert.assertEquals(driver.findElement(By.xpath("(//label[text()='Đến ngày']/parent::div/following-sibling::p)[1]")).getText(),
                "Trường ngày kết thúc hợp đồng không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Từ ngày");
        Assert.assertEquals(driver.findElement(By.xpath("(//label[text()='Từ ngày']/parent::div/following-sibling::p)[2]")).getText(),
                "Trường ngày bắt đầu làm việc không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Đến ngày");
        Assert.assertEquals(driver.findElement(By.xpath("(//label[text()='Đến ngày']/parent::div/following-sibling::p)[2]")).getText(),
                "Trường ngày kết thúc làm việc không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Họ tên tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Họ tên tài khoản']/following-sibling::p")).getText(),
                "Trường họ tên người nhận không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số tài khoản nhận");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số tài khoản nhận']/following-sibling::p")).getText(),
                "Trường account number không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số tài khoản nhận");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tại ngân hàng']/following-sibling::p")).getText(),
                "Trường tên ngân hàng không được bỏ trống.");

    }

    @Test
    public void testCase02CreateLaborSupportSuccess() throws InterruptedException {
        ReportListener.reportLog("Thêm mới yêu cầu hỗ trợ rủi ro thành công");
        driver.navigate().refresh();
        Thread.sleep(2000);

        ReportListener.reportLog("Nhập họ và tên: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("//label[text()='Họ tên người lao động']/following-sibling::div/input")).sendKeys("Nguyễn Thị Xuân");

        String soHoChieu = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số hộ chiếu: " + soHoChieu);
        driver.findElement(By.xpath("//label[text()='Số hộ chiếu']/following-sibling::div/input")).sendKeys(soHoChieu);

        ReportListener.reportLog("Nhập nơi cấp: Hà Nội");
        driver.findElement(By.xpath("//label[text()='Nơi cấp']/following-sibling::div/input")).sendKeys("Hà Nội");

        ReportListener.reportLog("Chọn ngày cấp: 10/10/2018");
        driver.findElement(By.xpath("//label[text()='Ngày cấp']/following-sibling::div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2018']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn nước đến làm việc: Cộng hòa Singapore");
        driver.findElement(By.xpath("//label[text()='Nước đến làm việc']/following-sibling::div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Cộng hòa Singapore')]")).click();

        ReportListener.reportLog("Chọn Thời hạn hợp đồng từ ngày: 04/04/2019");
        driver.findElement(By.xpath("(//label[text()='Từ ngày']/following-sibling::div/input)[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='4']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th04']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2019']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thời hạn hợp đồng đến ngày: 20/10/2020");
        driver.findElement(By.xpath("(//label[text()='Đến ngày']/following-sibling::div/input)[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thời gian làm việc ở nước ngoài từ ngày: 06/06/2019");
        driver.findElement(By.xpath("(//label[text()='Từ ngày']/following-sibling::div/input)[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='6']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th06']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2019']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thời gian làm việc ở nước ngoài đến ngày: 10/10/2020");
        driver.findElement(By.xpath("(//label[text()='Đến ngày']/following-sibling::div/input)[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Lý do hỗ trợ: Tai nạn lao động");
        driver.findElement(By.xpath("//span[text()='Tai nạn lao động']/preceding-sibling::span")).click();

        ReportListener.reportLog("Nhập số tiền hỗ trợ: 10000000");
        driver.findElement(By.xpath("//label[text()='Số tiền hỗ trợ']/following-sibling::div/input")).sendKeys("10000000");

        ReportListener.reportLog("Nhập Họ tên tài khoản: Nguyễn Văn A");
        driver.findElement(By.xpath("//label[text()='Họ tên tài khoản']/following-sibling::div/input")).sendKeys("Nguyễn Văn A");

        String soTK = "0" + randomNumber();
        ReportListener.reportLog("Nhập số tài khoản: " + soTK);
        driver.findElement(By.xpath("//label[text()='Số tài khoản nhận']/following-sibling::div/input")).sendKeys(soTK);

        ReportListener.reportLog("Nhập ngân hàng: Ngân hàng Agribank");
        driver.findElement(By.xpath("//label[text()='Tại ngân hàng']/following-sibling::div/input")).sendKeys("Ngân hàng Agribank");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//p[text()='Thêm mới yêu cầu hỗ trợ rủi ro']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi yêu cầu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo tạo thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(),
                "Tạo thành công");
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
        driver.quit();
    }
}
