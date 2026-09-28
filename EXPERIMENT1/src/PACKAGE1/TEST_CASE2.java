package PACKAGE1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TEST_CASE2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");

        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();

        driver.findElement(By.id("userName")).sendKeys("John Doe");
        driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("currentAddress")).sendKeys("123 Main Street, City");
        driver.findElement(By.id("permanentAddress")).sendKeys("456 Permanent Ave, City");

        js.executeScript("window.scrollBy(0, 500)");
        
        driver.findElement(By.id("submit")).click();
        
        System.out.println("Test Case 2 Passed!");
        
        driver.quit();
    }
}