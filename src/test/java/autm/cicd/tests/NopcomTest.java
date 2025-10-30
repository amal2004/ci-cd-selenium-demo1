package autm.cicd.tests;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NopcomTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   
    }
    
 
    @Test
    public void verifyGoogleSearch() throws InterruptedException {
        driver.get("http://localhost:5000/");
        driver.findElement(By.id("small-searchterms")).sendKeys("Apple");
        driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Search"), "Title mismatch!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
