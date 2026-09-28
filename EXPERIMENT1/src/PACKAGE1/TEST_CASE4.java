package PACKAGE1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TEST_CASE4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        
        WebElement menu = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        js.executeScript("arguments[0].click();", menu);

        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        js.executeScript("arguments[0].click();", yesRadio);

        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        js.executeScript("arguments[0].click();", impressiveRadio);

        WebElement noRadio = driver.findElement(By.id("noRadio"));
        js.executeScript("arguments[0].click();", noRadio);
        
        System.out.println("Test Case Passed!");
        driver.quit();
    }
}