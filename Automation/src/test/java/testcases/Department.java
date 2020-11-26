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

public class Department extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='Thông tin sở LĐ-TB-XH']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thêm mới']")).click();
    }

    @Test
    public void testCase01CreateDepartmentWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên sở");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::p")).getText(),
                "Trường Tên sở không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số Điện Thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::p")).getText(),
                "Trường Số điện thoại không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::p")).getText(),
                "Trường Địa chỉ mail không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tỉnh thành");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::p")).getText(),
                "Trường Tỉnh/Thành phố không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Quận huyện");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::p")).getText(),
                "Trường Quân/Huyện không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Phường xã");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::p")).getText(),
                "Trường Phường/xã không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ cụ thể");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::p")).getText(),
                "Trường Địa chỉ cụ thể không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo người lao động");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo người lao động không được bỏ trống.");
    }

    @Test
    public void testCase02CreateDepartmentWithEmptyName() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống tên sở LĐ");
        driver.navigate().refresh();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên sở");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::p")).getText(),
                "Trường Tên sở không được bỏ trống.");
    }

    @Test
    public void testCase03CreateDepartmentWithNameIsSpace() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập tên sở LĐ là các space");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tên sở là các space");
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys("    ");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên sở");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::p")).getText(),
                "Trường Tên sở không được bỏ trống.");
    }

    @Test
    public void testCase03CreateDepartmentWithNameMore255Char() throws InterruptedException {
        ReportListener.reportLog("kiểm tra nhập tên sở Lao Động lớn hơn 255 kí tự ");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tên sở là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên sở");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::p")).getText(),
                "Trường Tên sở không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase04CreateDepartmentWithEmptyPhone() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không nhập số điện thoại");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số Điện Thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::p")).getText(),
                "Trường Số điện thoại không được bỏ trống.");
    }

    @Test
    public void testCase05CreateDepartmentWithPhoneMore20Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số điện thoại lớn hơn 20 số");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "0111111111111111111111";
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số Điện Thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::p")).getText(),
                "Trường Số điện thoại có định dạng không hợp lệ.Trường Số điện thoại không được lớn hơn 20 ký tự.");
    }

    @Test
    public void testCase06CreateDepartmentWithExistPhone() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhấp số điện thoại đã có trong CSDL");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "09123123123";
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số Điện Thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::p")).getText(),
                "Trường Số điện thoại đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase07CreateDepartmentWithEmptyEmail() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống email");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::p")).getText(),
                "Trường Địa chỉ mail không được bỏ trống.");
    }

    @Test
    public void testCase08CreateDepartmentWithEmailIsSpace() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập email là các space");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Nhập email là các space");
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys("     ");

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::p")).getText(),
                "Trường Địa chỉ mail không được bỏ trống.");
    }

    @Test
    public void testCase09CreateDepartmentWithEmailMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập email lớn hơn 255 kí tự ");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Nhập email là a@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys("a@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::p")).getText(),
                "Trường Địa chỉ mail không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase10CreateDepartmentWithEmailIsWrongFormat() throws InterruptedException {
        ReportListener.reportLog("Kiểm ra nhập email không đúng định dạng ");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Nhập email là abc123.com");
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys("abc123.com");

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::p")).getText(),
                "Trường Địa chỉ mail phải là một địa chỉ email hợp lệ.");
    }

    @Test
    public void testCase11CreateDepartmentSuccess() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra tạo sở Lao Động thành công");
        driver.navigate().refresh();

        String name = "Sở Lao Động " + randomNumber();
        ReportListener.reportLog("Nhập tên sở là: " + name);
        driver.findElement(By.xpath("//label[text()='Tên']/following-sibling::div/input")).sendKeys(name);

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[contains(text(), 'Số Điện Thoại')]/following-sibling::div/input")).sendKeys(phone);

        String email = "solaodong" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Chọn Phường xã là: Phường Bến Nghé");
        driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Phường Bến Nghé')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa Chỉ']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()='Thêm ']")).click();
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
        //Quit browser
        driver.quit();
    }
}
