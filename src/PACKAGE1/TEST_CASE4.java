package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE4 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/interaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement resizableOption = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Resizable']"))
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", resizableOption);
            js.executeScript("arguments[0].click();", resizableOption);

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("resizable")) {
                System.out.println("Test Case 4 PASSED: Resizable page opened successfully.");
            } else {
                System.out.println("Test Case 4 FAILED: Resizable page did not open.");
            }

        } catch (Exception e) {
            System.out.println("Test Case 4 FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}