package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class NotificationMessagesTest {

    @Test
    public void clickAtButtonCheckedNotification() {
        List<String> listExpectedNotifications = List.of("\n" +
                "            Action successful\n" +
                "            ",
        "\n" +
                "            Action unsuccesful, please try again\n" +
                "            ");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/notification_message']"));
        clickHere.click();
        driver.manage().timeouts().equals(driver.findElement(By.xpath("//div[@id='flash']")).isDisplayed());
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        listExpectedNotifications.contains(actualText);
        driver.quit();
    }
}