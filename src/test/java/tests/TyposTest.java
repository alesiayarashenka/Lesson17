package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TyposTest {

    @Test
    public void orthographyCheckingForTypos() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/typos");
        String actualTextTypos = driver.findElement(By.xpath("//p[2]")).getText();
        String expectedTextTypos = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(expectedTextTypos,actualTextTypos);
        driver.quit();
    }
}
