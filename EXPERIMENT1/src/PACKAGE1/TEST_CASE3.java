package PACKAGE1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TEST_CASE3{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");

        driver.findElement(By.xpath("//h5[text()='Forms']")).click();
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();

        driver.findElement(By.id("firstName")).sendKeys("Mihir");
        driver.findElement(By.id("lastName")).sendKeys("Kant");
        driver.findElement(By.id("userEmail")).sendKeys("mihir.kant@example.com");
        
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");
        driver.findElement(By.id("currentAddress")).sendKeys("Ghaziabad, Uttar Pradesh");

        js.executeScript("window.scrollBy(0, 800)");
        
     
        org.openqa.selenium.WebElement submitButton = driver.findElement(By.id("submit"));

        
        js.executeScript("arguments[0].click();", submitButton);
        
        System.out.println("Test Case Passed!");
        
        driver.quit();
    }
}