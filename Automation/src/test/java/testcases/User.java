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

public class User extends AbstractTest {
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
        driver.findElement(By.xpath("//span[text()='Quản trị hệ thống']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Người dùng']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thêm mới']")).click();
    }

    @Test
    public void testCase01CreateAccountWithAllEmptyFields() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống các trường");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_name-helper-text']")).getText(),
                "Trường tài khoản không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tên đầy đủ");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_full_name-helper-text']")).getText(),
                "Trường tên đầy đủ không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_pasword-helper-text']")).getText(),
                "Trường mật khẩu không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_phone-helper-text']")).getText(),
                "Trường số điện thoại không được bỏ trống.");

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Nhóm quyền");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_role-helper-text']")).getText(),
                "Trường Nhóm quyền không được bỏ trống.");
    }

    @Test
    public void testCase02CreateAccountWithEmptyUserName() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập trường tên tài khoản là null");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_name-helper-text']")).getText(),
                "Trường tài khoản không được bỏ trống.");
    }

    @Test
    public void testCase03CreateAccountWithUserNameIsSpace() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập trường tên tài khoản là các space");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tài khoản là các space");
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("      ");

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_name-helper-text']")).getText(),
                "Trường tài khoản không được bỏ trống.");
    }

    @Test
    public void testCase04CreateAccountWithUserNameBelow5Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập trường tên tài khoản dưới 5 kí tự");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tài khoản có 4 kí tự là xuan");
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("xuan");

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_name-helper-text']")).getText(),
                "Trường tài khoản phải có tối thiểu 5 ký tự.");
    }

    @Test
    public void testCase05CreateAccountWithUserNameMore30Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập trường tên tài khoản trên 30 kí tự");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tài khoản có 31 kí tự là xuanntttttttttttttttttttttttttt");
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("xuanntttttttttttttttttttttttttt");

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_name-helper-text']")).getText(),
                "Trường tài khoản không được lớn hơn 30 ký tự.");
    }

    @Test
    public void testCase06CreateAccountWithUserNameExist() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập tên tài khoản đã có trong CSDL");
        driver.navigate().refresh();

        ReportListener.reportLog("Nhập tài khoản là: hieund");
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("hieund");

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tài khoản");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_name-helper-text']")).getText(),
                "Trường tài khoản đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase07CreateAccountWithEmptyFullName() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập trường tên đầy đủ là null");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tên đầy đủ");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_full_name-helper-text']")).getText(),
                "Trường tên đầy đủ không được bỏ trống.");
    }

    @Test
    public void testCase08CreateAccountWithFullNameMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập trường tên đầy đủ lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ có 256 kí tự: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường tên đầy đủ");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_full_name-helper-text']")).getText(),
                "Trường tên đầy đủ không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase09CreateAccountWithInvalidFormatEmail() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập email không đúng định dạng");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường email");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_email-helper-text']")).getText(),
                "Trường địa chỉ email phải là một địa chỉ email hợp lệ.Trường địa chỉ email có định dạng không hợp lệ.");
    }

    @Test
    public void testCase10CreateAccountWithExistEmail() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập email đã tồn tại trong cơ sở dữ liệu ");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        ReportListener.reportLog("Nhập email là: congv920@gmail.com");
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("congv920@gmail.com");

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường email");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_email-helper-text']")).getText(),
                "Trường địa chỉ email đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase11CreateAccountWithEmailMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập email lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        ReportListener.reportLog("Nhập email là: aa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com");
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("aa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com");

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường email");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_email-helper-text']")).getText(),
                "Trường địa chỉ email không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase12CreateAccountWithEmptyPhone() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không nhập trường số điện thoại");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_phone-helper-text']")).getText(),
                "Trường số điện thoại không được bỏ trống.");
    }

    @Test
    public void testCase13CreateAccountWithPhoneMore20Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số điện thoại lớn hơn 20 số");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        ReportListener.reportLog("Nhập số điện thoại là: 0905123123123123123123");
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys("0905123123123123123123");

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_phone-helper-text']")).getText(),
                "Trường số điện thoại có định dạng không hợp lệ.Trường số điện thoại không được lớn hơn 20 ký tự.");
    }

    @Test
    public void testCase14CreateAccountWithPhoneIsNotNumber() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số điện thoại là chữ");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        ReportListener.reportLog("Nhập số điện thoại là: aaaaaaaa");
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys("aaaaaaaa");

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_phone-helper-text']")).getText(),
                "Trường số điện thoại có định dạng không hợp lệ.");
    }

    @Test
    public void testCase15CreateAccountWithExistPhone() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập số điện thoại đã có trong CSDL");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        ReportListener.reportLog("Nhập số điện thoại là: 0935123123");
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys("0935123123");

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường số điện thoại");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_phone-helper-text']")).getText(),
                "Trường số điện thoại đã có trong cơ sở dữ liệu.");
    }

    @Test
    public void testCase16CreateAccountWithEmptyPassword() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra bỏ trống mật khẩu");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_pasword-helper-text']")).getText(),
                "Trường mật khẩu không được bỏ trống.");
    }

    @Test
    public void testCase17CreateAccountPasswordLess6Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập mật khẩu nhỏ hơn 6 kí tự");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Ab@1");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Ab@1");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_pasword-helper-text']")).getText(),
                "Trường mật khẩu phải có tối thiểu 6 ký tự.");
    }

    @Test
    public void testCase18CreateAccountPasswordMore255Char() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập mật khẩu lớn hơn 255 kí tự");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAb@1");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAb@1");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_pasword-helper-text']")).getText(),
                "Trường mật khẩu không được lớn hơn 255 ký tự.");
    }

    @Test
    public void testCase19CreateAccountWrongFormatPassword() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra nhập mật khẩu không đúng định dạng");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: abc123");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("abc123");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_pasword-helper-text']")).getText(),
                "Trường mật khẩu có định dạng không hợp lệ.");
    }

    @Test
    public void testCase20CreateAccountWithoutSelectUserGroup() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn nhóm người dùng");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);


        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message lỗi tại trường Nhóm quyền");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='user_role-helper-text']")).getText(),
                "Trường Nhóm quyền không được bỏ trống.");
    }

    @Test
    public void testCase22CreateAccountWithoutSelectDepartment() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn phòng ban");
        driver.navigate().refresh();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo tạo thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(),
                "Tạo thành công");
    }

    @Test
    public void testCase23CreateAccountSuccessWithoutSelectPosition() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra không chọn chức vụ");
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thêm mới']")).click();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
        Thread.sleep(2000);

        ReportListener.reportLog("Kiểm tra xuất hiện message thông báo tạo thành công");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(),
                "Tạo thành công");
    }

    @Test
    public void testCase24CreateAccountSuccess() throws InterruptedException {
        ReportListener.reportLog("Kiểm tra tạo người dùng thành công");
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Thêm mới']")).click();

        String userName = "xuannt" + randomNumber();
        ReportListener.reportLog("Nhập tài khoản là: " + userName);
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);

        ReportListener.reportLog("Nhập tên đầy đủ là: test98");
        driver.findElement(By.xpath("//input[@id='user_full_name']")).sendKeys("test98");

        String email = "xuannt" + randomNumber() + "@solashi.com";
        ReportListener.reportLog("Nhập email là: " + email);
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);

        ReportListener.reportLog("Chọn phòng ban là: Ban quản trị");
        driver.findElement(By.xpath("//input[@id='user_department']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Ban quản trị')]")).click();

        ReportListener.reportLog("Nhập mật khẩu là: Xu@n1998");
        driver.findElement(By.xpath("//input[@id='user_pasword']")).sendKeys("Xu@n1998");

        String phone = "0" + randomNumber();
        ReportListener.reportLog("Nhập số điện thoại là: " + phone);
        driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys(phone);

        ReportListener.reportLog("Chọn chức vụ là: Quản lý");
        driver.findElement(By.xpath("//input[@id='user_job_title']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản lý')]")).click();

        ReportListener.reportLog("Chọn nhóm người dùng là: Quản trị viên");
        driver.findElement(By.xpath("//input[@id='user_role']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='presentation']//*[contains(text() ,'Quản trị viên')]")).click();

        ReportListener.reportLog("Click vào nút Thêm tài khoản");
        driver.findElement(By.xpath("//span[text()='Thêm tài khoản']")).click();
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
