package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTest {

    public static final String PATH_TO_THE_FILE = System.getProperty("user.dir") + "/src/test/resources/1.jpg";
    public static final By SELECT_FILE = By.xpath("//input[@type='file']");
    public static final By UPLOAD_FILE_BUTTON = By.xpath("//input[@id='file-submit']");
    public static final By MESSAGE_FILE_UPLOADED = By.xpath("//div[@id='uploaded-files']");

    @Test
    public void fileUploadTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(SELECT_FILE).sendKeys(PATH_TO_THE_FILE);
        driver.findElement(UPLOAD_FILE_BUTTON).click();
        String fileName = wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_FILE_UPLOADED)).getText();
        Assert.assertEquals(fileName, "1.jpg");
        driver.quit();
    }
}
