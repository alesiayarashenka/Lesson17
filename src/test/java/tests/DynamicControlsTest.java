package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class DynamicControlsTest {

    public static final By REMOVE_BUTTON = By.xpath("//*[text()='Remove']");
    public static final By ENABLE_BUTTON = By.xpath("//*[text()='Enable']");
    public static final By MESSAGE_ITEM = By.xpath("//*[@id='message']");
    public static final By CHECKBOX = By.xpath("//input[@type = 'checkbox']");
    public static final By TEXT_FIELD = By.xpath("//input[@type = 'text']");

    @Test
    public void clickElementCheckTextOnAlert() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(REMOVE_BUTTON).click();
        fluent.until(webDriver -> driver.findElement(MESSAGE_ITEM));
        wait.until(ExpectedConditions.textToBe(MESSAGE_ITEM, "It's gone!"));
        List<WebElement> checkboxItem = driver.findElements(CHECKBOX);
        softAssert.assertTrue(checkboxItem.isEmpty());
        softAssert.assertFalse(driver.findElement(TEXT_FIELD).isEnabled());
        driver.findElement(ENABLE_BUTTON).click();
        fluent.until(webDriver -> driver.findElement(MESSAGE_ITEM));
        wait.until(ExpectedConditions.textToBe(MESSAGE_ITEM, "It's enabled!"));
        softAssert.assertTrue(driver.findElement(TEXT_FIELD).isEnabled());
        softAssert.assertAll();
        driver.quit();
    }
}
