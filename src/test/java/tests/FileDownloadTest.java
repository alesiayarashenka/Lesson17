package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class FileDownloadTest {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        String downloadFolder = Paths.get("/src/test/resources").toAbsolutePath().toString();
        chromePrefs.put("download.default_directory", downloadFolder);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='linkedin.pdf']")).click();
        Thread.sleep(500);
        File downloadFile = new File(downloadFolder +"/linkedin.pdf");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) webDriver -> downloadFile.exists());
        Assert.assertTrue(downloadFile.exists(), "Downloaded file is not found");
        downloadFile.delete();
        driver.quit();

    }
}

