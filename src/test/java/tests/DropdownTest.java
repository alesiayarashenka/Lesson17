package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownTest {

    @Test
    public void ElementsCheckingForDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> list = select.getOptions();
        for(WebElement listOptions: list){
            listOptions.isDisplayed();
        }
       dropdown.click();
       WebElement firsOption = dropdown.findElement(By.xpath("//*[@id = 'dropdown']//*[@value =1]"));
       firsOption.click();
       firsOption.isSelected();
       dropdown.click();
       WebElement secondOption = dropdown.findElement(By.xpath("//*[@id = 'dropdown']//*[@value =2]"));
       secondOption.click();
       secondOption.isSelected();
       driver.quit();
    }
}
