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

public class RequestDocument extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='Thêm mới yêu cầu hỗ trợ tài liệu']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']")).click();
    }

    @Test
    public void testCase01CreateRequestDocumentWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
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

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Tên tài liệu");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[1]")).getText(),
                "Trường Tên tài liệu không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số tồn đầu kỳ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[2]")).getText(),
                "Trường Số tồn đầu kỳ không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số nhận trong kỳ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[3]")).getText(),
                "Trường Số nhận trong kỳ không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số đề nghị cấp cho kỳ sau");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[4]")).getText(),
                "Trường Số đề nghị cấp cho kỳ sau không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số đã cấp cho người lao động trong kỳ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[5]")).getText(),
                "Trường Số đã cấp cho người lao động trong kỳ không được bỏ trống.");
    }

    @Test
    public void testCase02CreateRequestDocumentWithEmptyName() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập k nhập tên tài liệu ");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        String number1 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số tồn đầu kỳ: " + number1);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys(number1);
        Thread.sleep(1000);

        String number2 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số nhận trong kỳ: " + number2);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(number2);
        Thread.sleep(1000);

        String number3 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đề nghị cấp cho kỳ sau: " + number3);
        driver.findElement(By.xpath("(//input)[7]")).sendKeys(number3);
        Thread.sleep(1000);

        String number4 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đã cấp cho người lao động trong kỳ: " + number4);
        driver.findElement(By.xpath("(//input)[8]")).sendKeys(number4);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='none presentation']//button")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Tên tài liệu");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[1]")).getText(),
                "Trường Tên tài liệu không được bỏ trống.");
    }

    @Test
    public void testCase03CreateRequestDocumentWithNameMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập tên tài liệu lớn hơn 255 kí tự");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập tên tài liệu: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Thread.sleep(1000);

        String number1 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số tồn đầu kỳ: " + number1);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys(number1);
        Thread.sleep(1000);

        String number2 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số nhận trong kỳ: " + number2);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(number2);
        Thread.sleep(1000);

        String number3 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đề nghị cấp cho kỳ sau: " + number3);
        driver.findElement(By.xpath("(//input)[7]")).sendKeys(number3);
        Thread.sleep(1000);

        String number4 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đã cấp cho người lao động trong kỳ: " + number4);
        driver.findElement(By.xpath("(//input)[8]")).sendKeys(number4);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='none presentation']//button")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Tên tài liệu");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[1]")).getText(),
                "Trường Tên tài liệu không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase04CreateRequestDocumentWithEmptyNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số tồn đầu kỳ là null");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập tên tài liệu: Sách Giáo Khoa");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("Sách Giáo Khoa");
        Thread.sleep(1000);

        String number2 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số nhận trong kỳ: " + number2);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(number2);
        Thread.sleep(1000);

        String number3 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đề nghị cấp cho kỳ sau: " + number3);
        driver.findElement(By.xpath("(//input)[7]")).sendKeys(number3);
        Thread.sleep(1000);

        String number4 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đã cấp cho người lao động trong kỳ: " + number4);
        driver.findElement(By.xpath("(//input)[8]")).sendKeys(number4);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số tồn đầu kỳ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[2]")).getText(),
                "Trường Số tồn đầu kỳ không được bỏ trống.");
    }

    @Test
    public void testCase05CreateRequestDocumentWithEmptyGiveNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số nhận trong kỳ là null");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập tên tài liệu: Sách Giáo Khoa");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("Sách Giáo Khoa");
        Thread.sleep(1000);

        String number1 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số tồn đầu kỳ: " + number1);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys(number1);
        Thread.sleep(1000);

        String number3 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đề nghị cấp cho kỳ sau: " + number3);
        driver.findElement(By.xpath("(//input)[7]")).sendKeys(number3);
        Thread.sleep(1000);

        String number4 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đã cấp cho người lao động trong kỳ: " + number4);
        driver.findElement(By.xpath("(//input)[8]")).sendKeys(number4);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số nhận trong kỳ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[3]")).getText(),
                "Trường Số nhận trong kỳ không được bỏ trống.");
    }

    @Test
    public void testCase06CreateRequestDocumentWithEmptyRequestNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số đề nghị cấp cho kỳ sau là null");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập tên tài liệu: Sách Giáo Khoa");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("Sách Giáo Khoa");
        Thread.sleep(1000);

        String number1 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số tồn đầu kỳ: " + number1);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys(number1);
        Thread.sleep(1000);

        String number2 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số nhận trong kỳ: " + number2);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(number2);
        Thread.sleep(1000);

        String number4 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đã cấp cho người lao động trong kỳ: " + number4);
        driver.findElement(By.xpath("(//input)[8]")).sendKeys(number4);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số đề nghị cấp cho kỳ sau");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[4]")).getText(),
                "Trường Số đề nghị cấp cho kỳ sau không được bỏ trống.");
    }

    @Test
    public void testCase07CreateRequestDocumentWithEmptyEmployeeNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số đã cấp cho người lao động trong kỳ là null");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập tên tài liệu: Sách Giáo Khoa");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("Sách Giáo Khoa");
        Thread.sleep(1000);

        String number1 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số tồn đầu kỳ: " + number1);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys(number1);
        Thread.sleep(1000);

        String number2 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số nhận trong kỳ: " + number2);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(number2);
        Thread.sleep(1000);

        String number3 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đề nghị cấp cho kỳ sau: " + number3);
        driver.findElement(By.xpath("(//input)[7]")).sendKeys(number3);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Xác nhận']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại Trường Số đã cấp cho người lao động trong kỳ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[@style='color: red; font-size: 12px;'])[5]")).getText(),
                "Trường Số đã cấp cho người lao động trong kỳ không được bỏ trống.");
    }

    @Test
    public void testCaseCreateRequestDocumentSuccess() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra tạo hỗ trợ tài liệu thành công");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm danh sách hỗ trợ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[7]/div/*[1]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Quý: Quý 1");
        driver.findElement(By.xpath("//label[text()='Quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Nhập tên tài liệu: Sách Giáo Khoa");
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("Sách Giáo Khoa");
        Thread.sleep(1000);

        String number1 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số tồn đầu kỳ: " + number1);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys(number1);
        Thread.sleep(1000);

        String number2 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số nhận trong kỳ: " + number2);
        driver.findElement(By.xpath("(//input)[6]")).sendKeys(number2);
        Thread.sleep(1000);

        String number3 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đề nghị cấp cho kỳ sau: " + number3);
        driver.findElement(By.xpath("(//input)[7]")).sendKeys(number3);
        Thread.sleep(1000);

        String number4 = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số đã cấp cho người lao động trong kỳ: " + number4);
        driver.findElement(By.xpath("(//input)[8]")).sendKeys(number4);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi danh sách hỗ trợ']")).click();
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
