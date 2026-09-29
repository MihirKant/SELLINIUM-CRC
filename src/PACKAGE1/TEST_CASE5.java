package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE5 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/interaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement bookStoreCard = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Book Store Application']"))
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", bookStoreCard);
            js.executeScript("arguments[0].click();", bookStoreCard);

            WebElement loginMenu = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Login']"))
            );

            if (loginMenu.isDisplayed()) {
                System.out.println("Test Case 5 PASSED: Book Store Application opened successfully.");
            } else {
                System.out.println("Test Case 5 FAILED: Book Store Application page did not open.");
            }

        } catch (Exception e) {
            System.out.println("Test Case 5 FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}