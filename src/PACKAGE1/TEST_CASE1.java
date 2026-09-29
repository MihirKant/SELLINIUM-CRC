package PACKAGE1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TEST_CASE1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement interactionsCard = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Interactions']"))
            );

            interactionsCard.click();

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("interaction")) {
                System.out.println("Test Case PASSED: Interactions page opened successfully.");
            } else {
                System.out.println("Test Case FAILED: Page URL did not match expected path.");
            }

        } catch (Exception e) {
            System.out.println("Test Case FAILED with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}