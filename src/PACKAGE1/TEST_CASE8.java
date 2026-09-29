package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE8 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/profile");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Verify element on the Profile page (e.g., Not Logged In label or Login link)
            WebElement notLoggedInLabel = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Currently you are not logged in')] | //a[text()='login']"))
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", notLoggedInLabel);

            String currentUrl = driver.getCurrentUrl().toLowerCase();
            if (currentUrl.contains("profile")) {
                System.out.println("Test Case 8 PASSED: Profile page opened successfully.");
            } else {
                System.out.println("Test Case 8 FAILED: Profile page did not open.");
            }

        } catch (Exception e) {
            System.out.println("Test Case 8 FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}