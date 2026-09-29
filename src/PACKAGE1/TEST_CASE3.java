package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/interaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement selectableOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Selectable']"))
            );

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectableOption);
            
            selectableOption.click();

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("selectable")) {
                System.out.println("Test Case 3 PASSED: Selectable page opened successfully.");
            } else {
                System.out.println("Test Case 3 FAILED: Selectable page did not open.");
            }

        } catch (Exception e) {
            System.out.println("Test Case 3 FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}