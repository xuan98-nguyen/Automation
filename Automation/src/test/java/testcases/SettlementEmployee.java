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

public class SettlementEmployee extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='Thêm mới quyết toán theo người lao động nộp quỹ']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
    }

    @Test
    public void testCase01CreateSettlementEmployeeWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Kỳ quyết toán");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Kỳ quyết toán']/following-sibling::td//p")).getText(),
                "Trường kỳ quyết toán không được bỏ trống.");

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Họ và tên");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường tên người lao động không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số GCN đóng góp Quỹ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[4]")).getText(),
                "Trường Số GCN đóng góp quỹ không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số hộ chiếu (hoặc CMND)");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[5]")).getText(),
                "Trường số hộ chiếu (hoặc CMND) không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Thị trường");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[6]")).getText(),
                "Trường thị trường không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Ngày xuất cảnh dự kiến");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[7]")).getText(),
                "Trường ngày xuất cảnh dự kiến không được bỏ trống.");
    }

    @Test
    public void testCase02CreateSettlementEmployeeWithEmptyName() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập không nhập họ và tên");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Họ và tên");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường tên người lao động không được bỏ trống.");
    }

    @Test
    public void testCase03CreateSettlementEmployeeWithNameIsSpace() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập nhập họ tên là space");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là space");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("   ");
        Thread.sleep(1000);

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Họ và tên");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường tên người lao động không được bỏ trống.");
    }

    @Test
    public void testCase04CreateSettlementEmployeeWithEmptyGCN() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số GCN đóng góp vào quỹ = các null");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Nguyễn Thị Xuân");
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số GCN đóng góp Quỹ");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường Số GCN đóng góp quỹ không được bỏ trống.");
    }

    @Test
    public void testCase05CreateSettlementEmployeeWithEmptyId() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số hộ chiếu = null");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Nguyễn Thị Xuân");
        Thread.sleep(1000);

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Số hộ chiếu (hoặc CMND)");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường số hộ chiếu (hoặc CMND) không được bỏ trống.");
    }

    @Test
    public void testCase06CreateSettlementEmployeeWithEmptyMarket() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn thị trường ");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Nguyễn Thị Xuân");
        Thread.sleep(1000);

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Thị trường");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường thị trường không được bỏ trống.");
    }

    @Test
    public void testCase07CreateSettlementEmployeeWithEmptyDate() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn ngày dự kiến xuất cảnh");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Nguyễn Thị Xuân");
        Thread.sleep(1000);

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button/span[text()='Quay lại']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Ngày xuất cảnh dự kiến");
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[3]")).getText(),
                "Trường ngày xuất cảnh dự kiến không được bỏ trống.");
    }

    @Test
    public void testCase07CreateSettlementEmployeeWithEmptyQuarter() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn quý");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Nguyễn Thị Xuân");
        Thread.sleep(1000);

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Kỳ quyết toán");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Kỳ quyết toán']/following-sibling::td//p")).getText(),
                "Trường kỳ quyết toán không được bỏ trống.");
    }

    @Test
    public void testCase08CreateSettlementEmployeeSuccess() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập nhập họ tên là space");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[@title='Thêm người lao động']/button")).click();

        ReportListener.reportLog("Nhập Họ và tên là: Nguyễn Thị Xuân");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Nguyễn Thị Xuân");
        Thread.sleep(1000);

        String GCNNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số GCN đóng góp Quỹ: " + GCNNumber);
        driver.findElement(By.xpath("(//input)[3]")).sendKeys(GCNNumber);
        Thread.sleep(1000);

        String idNumber = String.valueOf(randomNumber());
        ReportListener.reportLog("Nhập Số hộ chiếu (hoặc CMND): " + idNumber);
        driver.findElement(By.xpath("(//input)[4]")).sendKeys(idNumber);
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Thị trường là: Cộng hòa Xã hội Chủ nghĩa Việt Nam");
        driver.findElement(By.xpath("(//input)[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Cộng hòa Xã hội Chủ nghĩa Việt Nam')]")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn ngày xuất cảnh dự kiến: 15/11/2020");
        driver.findElement(By.xpath("(//input)[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Th11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='2020']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Tiếp theo']")).click();
        Thread.sleep(1000);

        ReportListener.reportLog("Chọn Kỳ quyết toán: Quý 1");
        driver.findElement(By.xpath("//label[text()='Chọn quý']/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text(), 'Quý 1')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Gửi quyết toán']")).click();
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
