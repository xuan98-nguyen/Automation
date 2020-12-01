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

    @Test
    public void testCase02CreateBusinessWithEmptyName() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống tên doanh nghiệp");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tên giao dịch là: test giao dịch");
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys("test giao dịch");

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();


        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên doanh nghiệp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::p")).getText(),
                "Trường tên doanh nghiệp không được bỏ trống.");
    }

    @Test
    public void testCase03CreateBusinessWithNameMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập tên doanh nghiệp lớn hơn 255 kí tự");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập Tên doanh nghiệp là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Nhập tên giao dịch là: test giao dịch");
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys("test giao dịch");

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();


        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên doanh nghiệp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::p")).getText(),
                "Trường tên doanh nghiệp không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase04CreateBusinessWithEmptyExchange() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống tên giao dịch ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();


        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên giao dịch");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::p")).getText(),
                "Trường tên giao dịch không được bỏ trống.");
    }

    @Test
    public void testCase05CreateBusinessWithExchangeMore255Char() throws InterruptedException {
        ReportListener.reportLog("kiểm tra nhập tên giao dịch lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        ReportListener.reportLog("Nhập tên giao dịch là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();


        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên giao dịch");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::p")).getText(),
                "Trường tên giao dịch không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase06CreateBusinessWithEmptyBusinessKind() throws InterruptedException {
        ReportListener.reportLog("kiểm tra không chọn loại hình doanh nghiệp ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Loại doanh nghiệp");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::p")).getText(),
                "Trường loại hình doanh nghiệp không được bỏ trống.");
    }

    @Test
    public void testCase07CreateBusinessWithEmptyPhone() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không nhập số điện thoại ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::p")).getText(),
                "Trường số điện thoại không được bỏ trống.");
    }

    @Test
    public void testCase08CreateBusinessWithPhoneMore20Char() throws InterruptedException {
        ReportListener.reportLog("kiểm tra nhập số điện thoại lớn hơn 10 số");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        ReportListener.reportLog("Nhập số điện thoại là: 01234567891234542129432");
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys("01234567891234542129432");

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::p")).getText(),
                "Trường số điện thoại có định dạng không hợp lệ.Trường số điện thoại không được lớn hơn 20 ký tự.");
    }

    @Test
    public void testCase09CreateBusinessWithExistPhone() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhấp số điện thoại đã có trong CSDL");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        ReportListener.reportLog("Nhập số điện thoại là: 0125639874");
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys("0125639874");

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::p")).getText(),
                "Trường số điện thoại đã có trong cơ sở dữ liệu.");
    }

     @Test
    public void testCase10CreateBusinessWithEmptyEmail() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống email");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::p")).getText(),
                "Trường địa chỉ email không được bỏ trống.");
    }

    @Test
    public void testCase11CreateBusinessWithEmailMore255Char() throws InterruptedException {
        ReportListener.reportLog("kiểm tra nhập email lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Nhập email là: abc@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys("abc@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::p")).getText(),
                "Trường địa chỉ email không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase12CreateBusinessWithEmailWrongFormat() throws InterruptedException {
        ReportListener.reportLog("kiểm ra nhập email không đúng định dạng ̣");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Nhập email là: abc");
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys("abc");

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::p")).getText(),
                "Trường địa chỉ email phải là một địa chỉ email hợp lệ.");
    }

    @Test
    public void testCase13CreateBusinessWithExistEmail() throws InterruptedException {
        ReportListener.reportLog("kiểm tra nhập email lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        ReportListener.reportLog("Nhập email là: vietnamese@gmail.com");
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys("vietnamese@gmail.com");

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::p")).getText(),
                "Trường địa chỉ email đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase14CreateBusinessWithEmptyCity() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn tỉnh thành");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tỉnh thành");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::p")).getText(),
                "Trường Tỉnh/ Thành phố không được bỏ trống.");
    }

    @Test
    public void testCase15CreateBusinessWithEmptyDistrict() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn quận huyện");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Quận huyện");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::p")).getText(),
                "Trường Quận/ Huyện không được bỏ trống.");
    }

    @Test
    public void testCase16CreateBusinessWithEmptyWard() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn phường xã");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

        ReportListener.reportLog("Chọn Tỉnh thành là: Hồ Chí Minh");
        driver.findElement(By.xpath("//label[text()='Tỉnh thành']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Hồ Chí Minh')]")).click();

        ReportListener.reportLog("Chọn Quận huyện là: Quận 1");
        driver.findElement(By.xpath("//label[text()='Quận huyện']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quận 1')]")).click();

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Phường xã");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Phường xã']/following-sibling::p")).getText(),
                "Trường Phường/ Xã không được bỏ trống.");
    }

    @Test
    public void testCase17CreateBusinessWithEmptyAddress() throws InterruptedException {
        ReportListener.reportLog("kiểm tra bỏ trống địa chỉ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ cụ thể");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::p")).getText(),
                "Trường địa chỉ chi tiết không được bỏ trống.");
    }

    @Test
    public void testCase18CreateBusinessWithAddressMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập địa chỉ lớn hơn 255 kí tự ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Địa chỉ cụ thể");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::p")).getText(),
                "Trường địa chỉ chi tiết không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase19CreateBusinessWithEmptyRegistDay() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn ngày đăng ký chứng chỉ ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Ngày đăng ký chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/parent::div/following-sibling::p")).getText(),
                "Trường ngày đăng ký chứng chỉ không được bỏ trống.");
    }

    @Test
    public void testCase20CreateBusinessWithEmptyPublishDay() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn ngày cấp chứng chỉ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Ngày cấp chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/parent::div/following-sibling::p")).getText(),
                "Trường ngày cấp chứng chỉ không được bỏ trống.");
    }

    @Test
    public void testCase21CreateBusinessWithEmptyCertNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không nhập số chứng chỉ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::p")).getText(),
                "Trường chứng chỉ số không được bỏ trống.");
    }

    @Test
    public void testCase22CreateBusinessWithExistCertNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhấp số chứng chỉ đã có trong CSDL ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Nhập số chứng chỉ là: no.225698");
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys("no.225698");

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::p")).getText(),
                "Trường chứng chỉ số đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase23CreateBusinessWithCertNumberMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số chứng chỉ lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Nhập số chứng chỉ là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số chứng chỉ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::p")).getText(),
                "Trường chứng chỉ số không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase24CreateBusinessWithEmptyPIC() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn cán bộ phụ trách ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Cán bộ phụ trách");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::p")).getText(),
                "Trường người phụ trách không được bỏ trống.");
    }

    @Test
    public void testCase25CreateBusinessWithEmptySettlementIncome() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập không nhập dư nợ quyết toán theo thu nhập ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo thu nhập");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo khu vực không được bỏ trống.");
    }

    @Test
    public void testCase26CreateBusinessWithNegativeSettlementIncome() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập dư nợ quyết toán theo thu nhập là số âm");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: -1");
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys("-1");

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo thu nhập");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo khu vực phải tối thiểu là 0.");
    }

     @Test
    public void testCase27CreateBusinessWithEmptySettlementEmployee() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập không nhập dư nợ quyết toán theo người lao động ");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo người lao động");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo người lao động không được bỏ trống.");
    }

     @Test
    public void testCase28CreateBusinessWithNegativeSettlementEmployee() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập dư nợ quyết toán theo người lao động là số âm");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: -1");
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys("-1");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Dư nợ quyết toán theo người lao động");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::p")).getText(),
                "Trường Dư nợ quyết toán theo người lao động phải tối thiểu là 0.");
    }

    @Test
    public void testCase29CreateBusinessWithUsernameMore30Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập tên tài khoản lớn hơn 30 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Tên tài khoản là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::div/input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::p")).getText(),
                "Trường tên tài khoản không được lớn hơn 30 ký tự.");
    }

    @Test
    public void testCase30CreateBusinessWithExistUsername() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập tên tài khoản đã tồn tại");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Tên tài khoản là: company");
        driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::div/input")).sendKeys("company");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Tên tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::p")).getText(),
                "Trường tên tài khoản đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase31CreateBusinessWithEmptyPassword() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập không nhập mật khẩu");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Tên tài khoản là: company1234");
        driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::div/input")).sendKeys("company");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::p")).getText(),
                "Trường mật khẩu không được bỏ trống.");
    }

    @Test
    public void testCase32CreateBusinessWithPasswordLess6Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập mật khẩu nhỏ hơn 6 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Tên tài khoản là: company1234");
        driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::div/input")).sendKeys("company");

        ReportListener.reportLog("Nhập Mật khẩu là: 1@aB5");
        driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::div/input")).sendKeys("1@aB5");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Mật Khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::p")).getText(),
                "Trường mật khẩu phải có tối thiểu 6 ký tự.");
    }

    @Test
    public void testCase33CreateBusinessWithPasswordMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập mật khẩu lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Tên tài khoản là: company1234");
        driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::div/input")).sendKeys("company");

        ReportListener.reportLog("Nhập Mật khẩu là: 1@aB5aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::div/input")).sendKeys("1@aB5aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Mật Khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::p")).getText(),
                "Trường mật khẩu không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase34CreateBusinessWithPasswordWrongFormat() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập mật khẩu không đúng định dạng");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Tên tài khoản là: company1234");
        driver.findElement(By.xpath("//label[text()='Tên tài khoản *']/following-sibling::div/input")).sendKeys("company");

        ReportListener.reportLog("Nhập Mật khẩu là: 1111111");
        driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::div/input")).sendKeys("1111111");

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Mật Khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Mật khẩu *']/following-sibling::p")).getText(),
                "Trường mật khẩu có định dạng không hợp lệ.");
    }

     @Test
    public void testCaseCreateBusinessSuccess() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra tạo doanh nghiệp thành công");
        driver.navigate().refresh();

        String ten = "Doanh nghiệp" + randomNumber();
        ReportListener.reportLog("Nhập Tên doanh nghiệp là: " + ten);
        driver.findElement(By.xpath("//label[text()='Tên doanh nghiệp']/following-sibling::div/input")).sendKeys(ten);

        String tengiaodich = "Giao dịch" + randomNumber();
        ReportListener.reportLog("Nhập tên giao dịch là: " + tengiaodich);
        driver.findElement(By.xpath("//label[text()='Tên giao dịch']/following-sibling::div/input")).sendKeys(tengiaodich);

        ReportListener.reportLog("Chọn Loại doanh nghiệp là: Ban quản trị");
        driver.findElement(By.xpath("//label[text()='Loại doanh nghiệp *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Doanh nghiệp tư nhân')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//label[text()='Số điện thoại']/following-sibling::div/input")).sendKeys(phone);

        String email = "doanhnghiep" + randomNumber() + "@gmail.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//label[text()='Địa chỉ email']/following-sibling::div/input")).sendKeys(email);

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

        ReportListener.reportLog("Nhập Địa chỉ cụ thể là: 30 phạm văn đồng");
        driver.findElement(By.xpath("//label[text()='Địa chỉ cụ thể']/following-sibling::div/input")).sendKeys("30 phạm văn đồng");

        ReportListener.reportLog("Chọn Ngày đăng ký chứng chỉ là: 15/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày đăng ký chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        ReportListener.reportLog("Chọn Ngày cấp chứng chỉ là: 16/11/2020");
        driver.findElement(By.xpath("//label[text()='Ngày cấp chứng chỉ *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();

        String sochungchi = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập số chứng chỉ là: " + sochungchi);
        driver.findElement(By.xpath("//label[text()='Số chứng chỉ']/following-sibling::div/input")).sendKeys(sochungchi);

        ReportListener.reportLog("Chọn Cán bộ phụ trách là: Vu Duy");
        driver.findElement(By.xpath("//label[text()='Cán bộ phụ trách *']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Vu Duy')]")).click();

        String duno = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Dư nợ quyết toán theo thu nhập là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo thu nhập']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Nhập Dư nợ quyết toán theo người lao động là: " + duno);
        driver.findElement(By.xpath("//label[text()='Dư nợ quyết toán theo người lao động']/following-sibling::div/input")).sendKeys(duno);

        ReportListener.reportLog("Bấm vào nút Thêm Mới");
        driver.findElement(By.xpath("//span[text()=' thêm mới']")).click();
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
