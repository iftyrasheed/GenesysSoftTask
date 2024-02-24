import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    WebDriver driver;
    @BeforeClass
    public void driver() {

        // opening browser
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to the website
        driver.navigate().to("https://magento.softwaretestingboard.com/");

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
