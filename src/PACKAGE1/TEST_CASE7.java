package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE7 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/books");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Verify search box or books table is present on the page
            WebElement searchBox = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("searchBox"))
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", searchBox);

            String currentUrl = driver.getCurrentUrl().toLowerCase();
            if (currentUrl.contains("books")) {
                System.out.println("Test Case 7 PASSED: Book Store page opened successfully.");
            } else {
                System.out.println("Test Case 7 FAILED: Book Store page did not open.");
            }

        } catch (Exception e) {
            System.out.println("Test Case 7 FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}