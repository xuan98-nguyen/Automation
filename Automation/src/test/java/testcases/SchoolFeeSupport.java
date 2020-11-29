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

public class SchoolFeeSupport extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='Thêm mới yêu cầu hỗ trợ học phí']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@role='presentation']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testCase01CreateSchoolFeeSupportWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        driver.findElement(By.xpath("(//label[@color='primary']/span)[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[10]/div/*[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='none presentation']//button")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Quý");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường Quý không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Họ tên người lao động");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[1]")).getText(),
                "Trường Họ tên người lao động không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số hộ chiếu");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[2]")).getText(),
                "Trường Số hộ chiếu không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Loại đối tượng");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[3]")).getText(),
                "Trường Loại đối tượng không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Nước đến làm việc");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[4]")).getText(),
                "Trường Nước đến làm việc không được bỏ trống.");
    }

    @Test
    public void testCase02CreateSchoolFeeSupportSuccess() throws InterruptedException {
        ReportListener.reportLog("Thêm mới yêu cầu yêu cầu hỗ trợ học phí");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//label[@color='primary']/span)[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[10]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập họ và tên: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("Nguyễn Thị Xuân");

        ReportListener.reportLog("Chọn ngày sinh: 10/10/2017");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2017']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        String soHoChieu = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số hộ chiếu:" + soHoChieu);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(soHoChieu);

        ReportListener.reportLog("Chọn đối tượng: Người lao động là con thương binh, liệt sĩ và người có công hưởng chế độ chính sách ưu đãi");
        driver.findElement(By.xpath("(//input)[7]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Người lao động là con thương binh, liệt sĩ và người có công hưởng chế độ chính sách ưu đãi')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn nước đến làm việc: Vương quốc Campuchia");
        driver.findElement(By.xpath("(//input)[9]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Vương quốc Campuchia')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

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
