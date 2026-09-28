package PACKAGE1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TEST_CASE1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://demoqa.com/");
        String firstTab = driver.getWindowHandle();
        
        driver.findElement(By.xpath("//img[@alt='Selenium Online Training'] | //*[normalize-space()='JOIN NOW']")).click();

        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(firstTab)) {
                driver.switchTo().window(tab);
            }
        }

        driver.findElement(By.xpath("//a[contains(text(), 'HOME') or contains(text(), 'Home')]")).click();
        
        driver.quit();
    }
}