package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest {

    public static final By BOX_ITEM = By.id("hot-spot");

    @Test
    public void clickElementCheckTextOnAlert() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        actions.contextClick(driver.findElement(BOX_ITEM)).build().perform();
        String alertText = driver.switchTo().alert().getText().trim();
        Assert.assertEquals(alertText, "You selected a context menu");
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
