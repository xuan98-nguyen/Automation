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
