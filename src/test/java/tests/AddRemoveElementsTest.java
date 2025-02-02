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

public class AddRemoveElementsTest {

    @Test
    public void addDeleteElementsRemoveAndCheck() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementsButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementsButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        deleteButton.isDisplayed();
        addElementsButton.click();
        deleteButton.click();
        List<WebElement> deleteElemButton = driver.findElements(By.xpath("//button[text()='Delete']"));
        int deleteButtonElemSize = deleteElemButton.size();
        Assert.assertEquals(deleteButtonElemSize,1);
        driver.quit();
    }
}
