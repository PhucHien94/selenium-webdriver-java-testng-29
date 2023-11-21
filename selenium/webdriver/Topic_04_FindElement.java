package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_04_FindElement {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
    }
    
    @Test
    public void TC_01() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login");

        // Click vào MyAccount ở footer
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    }

    @Test
     public void TC_02() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login");

        // Click vào Mobile ở header
        driver.findElement(By.xpath("//div[@id='header-nav']//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//button[@title='Add to Cart'][1]")).click();

        String successMessageText = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
        // Expected message : IPhone was added to your shopping cart.
        // Assert kết quả
        Assert.assertEquals(successMessageText,"IPhone was added to your shopping cart.");
     }

    @Test
    public void TC_03() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[starts-with(text(),'Digital')]")).click();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
