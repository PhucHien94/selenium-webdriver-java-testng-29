package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//Re-test the first comment of Mei 1
public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("web-driver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("web-driver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_01_ID() {
        // Tìm element có id là FirstName
        driver.findElement(By.id("FirstName")).sendKeys("this is first name");
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("LastName")).sendKeys("this is LastName");
    }

    @Test
    public void TC_04_TagName() {
        // tìm nhiều element có cùng tag name
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("Blog"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // chỉ cần lấy 1 phần content để tìm link text, độ chính xác không cao
        driver.findElement(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_Css() {
        // CSS với ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // CSS với Class
        driver.findElement(By.cssSelector("div[class='header-logo']"));
        driver.findElement(By.cssSelector("div.header-logo"));
        driver.findElement(By.cssSelector(".header-logo"));

        // CSS với Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // CSS với Tag Name
        driver.findElement(By.cssSelector("input"));

        // CSS với link
        driver.findElement(By.cssSelector("a[href='/news']"));

        // CSS với partial link
        // lấy giữa
        driver.findElement(By.cssSelector("a[href*='e']"));
        // lấy đầu
        driver.findElement(By.cssSelector("a[href^='/n']"));
        // lấy đuôi
        driver.findElement(By.cssSelector("a[href$='s']"));
    }

    @Test
    public void TC_08_xPath() {
        // CSS với ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // CSS với Class
        driver.findElement(By.xpath("//div[@class='header-logo']"));

        // CSS với Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // CSS với Tag Name
        driver.findElement(By.xpath("//input"));

        // CSS với link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        // CSS với partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
    //    driver.quit();
    }
}