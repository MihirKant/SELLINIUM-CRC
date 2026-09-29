package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE6 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement loginHeader = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Login in Book Store'] | //button[@id='login']"))
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", loginHeader);

            String currentUrl = driver.getCurrentUrl().toLowerCase();
            if (currentUrl.contains("login")) {
                System.out.println("Test Case 6 PASSED: Login page loaded successfully.");
            } else {
                System.out.println("Test Case 6 FAILED: Login page did not open.");
            }

        } catch (Exception e) {
            System.out.println("Test Case 6 FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}