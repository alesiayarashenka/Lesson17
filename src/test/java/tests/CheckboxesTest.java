package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {

    @Test
    public void firstCheckboxChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//input[@type = 'checkbox'][1]"));
        Assert.assertFalse(firstCheckbox.isSelected(), "Test passed. First checkbox is unchecked.");
        boolean firstCheckboxUnchecked = firstCheckbox.isSelected();
        firstCheckbox.click();
        boolean firstCheckboxChecked = firstCheckbox.isSelected();
        Assert.assertNotEquals(firstCheckboxUnchecked,firstCheckboxChecked);
        driver.quit();
    }

    @Test
    public void secondCheckboxUnchecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement secondCheckbox = driver.findElement(By.xpath("//input[@type = 'checkbox'][2]"));
        Assert.assertTrue(secondCheckbox.isSelected(), "Test passed. Second checkbox is checked.");
        boolean firstCheckboxUnchecked = secondCheckbox.isSelected();
        secondCheckbox.click();
        boolean firstCheckboxChecked = secondCheckbox.isSelected();
        Assert.assertNotEquals(firstCheckboxUnchecked,firstCheckboxChecked);
        driver.quit();
    }
}
