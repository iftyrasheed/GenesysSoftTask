import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddCart extends BaseClass{

    // Adding a product into the cart

    @Test (priority = 1)
    public void addCart() throws InterruptedException {
        //scroll down
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1700)");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swatch-opt-1556']//div[@id" +
                "='option-label-size-143-item-168']")));



        // product selection

        driver.findElement(By.xpath("//div[@class='swatch-opt-1556']//div[@id='option-label-size-143-item-168']")).click();
        driver.findElement(By.xpath("//div[@class='swatch-opt-1556']//div[@id='option-label-color-93-item-57']")).click();


        // Adding to cart
        WebElement hoverable = driver.findElement(By.xpath("(//div[@class='actions-primary'])[1]"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='actions-primary'])[1]")));

        driver.findElement(By.xpath("(//div[@class='actions-primary'])[1]")).click();

        // scroll up
        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("window.scrollBy(0,-1700)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-bind='html: $parent" +
                ".prepareMessageForHtml" +
                "(message.text)']")));




        // Verification if the product is successfully added to the cart

        String successMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml" +
                "(message.text)']")).getText();
        Assert.assertEquals("You added Radiant Tee to your shopping cart.", successMessage);
    }
}
