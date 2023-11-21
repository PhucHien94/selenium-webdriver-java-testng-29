package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_03_Relative_Locator {
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
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    
    @Test
    public void TC_01_Relative1() {
        // Login button
        By loginButton = By.cssSelector("button.login-button");
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        // Remember Me Checkbox
        By rememberMeCheckboxBy = By.id("RememberMe");
        // Forget password link
        WebElement forgotPasswordLink = driver.findElement(By.cssSelector("span.forgot-password"));
        // Password textbox
        By passwordTextboxBy = By.id("Password");


        //RelativeLocator.with(By.tagName("label")).above(loginButtonElement);

        // Rememberme text - GUI (location, position)
        WebElement rememberMeTextElement = driver.findElement(
                RelativeLocator.with(By.tagName("label"))
                        .above(loginButton)
                        .toRightOf(rememberMeCheckboxBy)
                        .toLeftOf(forgotPasswordLink)
                        .near(forgotPasswordLink)
                        .below(passwordTextboxBy)
        );

        System.out.print(rememberMeTextElement.getText());
    }

    @Test
     public void TC_02_Relative2() {
        // nhiều element có tag name là "a"
        List< WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println(allLinks.size());
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
