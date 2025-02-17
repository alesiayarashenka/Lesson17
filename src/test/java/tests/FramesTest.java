package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {

    public static final By FRAME_BUTTON = By.linkText("iFrame");
    public static final By CLOSED_MESSAGE_BUTTON = By.xpath("//*[@class='tox-icon']");
    public static final By DEFAULT_TEXT_IN_FRAME = By.xpath("//body[@id='tinymce']/p");

    @Test
    public void openFrameCheckTextTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(FRAME_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSED_MESSAGE_BUTTON));
        driver.findElement(CLOSED_MESSAGE_BUTTON).click();
        driver.switchTo().frame("mce_0_ifr");
        String paragraphText = driver.findElement(DEFAULT_TEXT_IN_FRAME).getText();
        Assert.assertEquals(paragraphText, "Your content goes here.");
        driver.quit();
    }
}
