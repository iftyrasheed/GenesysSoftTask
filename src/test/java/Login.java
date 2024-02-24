import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends BaseClass{


    // login
    @Test (priority = 0)
    public void login() throws InterruptedException {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ar.ifty.corp@gmail.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("PAss##123");
        driver.findElement(By.id("send2")).click();
    }
}
