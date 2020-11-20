package testcases.com.nopcommerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	private WebDriver driver;

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://login.mailchimp.com/signup/");
  }

  @Test
  public void Test() throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys("ngngocthuong1987@gmail.com");
	  driver.findElement(By.id("new_username")).sendKeys("ngngocthuong123");

	  driver.findElement(By.id("new_password")).sendKeys("a");
	  Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
	  Assert.assertEquals(driver.findElement(By.id("create-account")).getAttribute("disabled"), "true");

	  driver.findElement(By.id("new_password")).clear();
	  driver.findElement(By.id("new_password")).sendKeys("1");
	  Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
	  Assert.assertEquals(driver.findElement(By.id("create-account")).getAttribute("disabled"), "true");

	  driver.findElement(By.id("new_password")).clear();
	  driver.findElement(By.id("new_password")).sendKeys("1aA#1234");
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@class='freddicon tick-circle']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),\"Your password is secure and you're all set!\")]")).isDisplayed());
	  Assert.assertEquals(driver.findElement(By.id("create-account")).getAttribute("disabled"), null);

	  driver.findElement(By.id("create-account")).click();
	  Thread.sleep(3000);
	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text() = 'Check your email']")).isDisplayed());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
