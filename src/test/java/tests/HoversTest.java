package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HoversTest {

    @Test
    public void hoverFirstProfileTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement firstUserPhoto = driver.findElement(By.xpath("//*[@Class='figure'][1]"));
        action.moveToElement(firstUserPhoto).build().perform();
        WebElement firstUserInformation = driver.findElement(By.xpath("//*[contains(text(),'user1')]"));
        String firstUserName = firstUserInformation.getText();
        Assert.assertEquals(firstUserName, "name: user1");
        driver.findElement(By.xpath("//*[@href='/users/1']")).click();
        WebElement textNotFound = driver.findElement(By.xpath("//h1[text() = 'Not Found']"));
        Assert.assertTrue(textNotFound.isDisplayed());
        driver.quit();
    }

    @Test
    public void hoverSecondProfileTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement secondUserPhoto = driver.findElement(By.xpath("//*[@Class='figure'][2]"));
        action.moveToElement(secondUserPhoto).build().perform();
        WebElement secondUserInformation = driver.findElement(By.xpath("//*[contains(text(),'user2')]"));
        String firstUserName = secondUserInformation.getText();
        Assert.assertEquals(firstUserName, "name: user2");
        driver.findElement(By.xpath("//*[@href='/users/2']")).click();
        WebElement textNotFound = driver.findElement(By.xpath("//h1[text() = 'Not Found']"));
        Assert.assertTrue(textNotFound.isDisplayed());
        driver.quit();
    }

    @Test
    public void hoverThirdProfileTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement thirdUserPhoto = driver.findElement(By.xpath("//*[@Class='figure'][3]"));
        action.moveToElement(thirdUserPhoto).build().perform();
        WebElement thirdUserInformation = driver.findElement(By.xpath("//*[contains(text(),'user3')]"));
        String firstUserName = thirdUserInformation.getText();
        Assert.assertEquals(firstUserName, "name: user3");
        driver.findElement(By.xpath("//*[@href='/users/3']")).click();
        WebElement textNotFound = driver.findElement(By.xpath("//h1[text() = 'Not Found']"));
        Assert.assertTrue(textNotFound.isDisplayed());
        driver.quit();
    }
}
