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

public class SortableDataTablesTest {

    @Test
    public void getValueFromTableExample1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement tableCellInfo1 = driver.findElement(By.xpath("//table[@id='table1']//tr[3]//td[3]"));
        String email1 = tableCellInfo1.getText();
        Assert.assertEquals(email1,"jdoe@hotmail.com");
        WebElement tableCellInfo2 = driver.findElement(By.xpath("//table[@id='table1']//tr[2]//td[2]"));
        String firstName = tableCellInfo2.getText();
        Assert.assertEquals(firstName,"Frank");
        WebElement tableCellInfo3 = driver.findElement(By.xpath("//table[@id='table1']//tr[4]//td[5]"));
        String webSite = tableCellInfo3.getText();
        Assert.assertEquals(webSite,"http://www.timconway.com");
        driver.quit();
    }

    @Test
    public void getValueFromTableExample2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement tableCellInfo1 = driver.findElement(By.xpath("//table[@id='table2']//tr[1]//td[1]"));
        String lastName = tableCellInfo1.getText();
        Assert.assertEquals(lastName,"Smith");
        WebElement tableCellInfo2 = driver.findElement(By.xpath("//table[@id='table2']//tr[2]//td[4]"));
        String due = tableCellInfo2.getText();
        Assert.assertEquals(due,"$51.00");
        WebElement tableCellInfo3 = driver.findElement(By.xpath("//table[@id='table2']//tr[4]//td[6]"));
        String action = tableCellInfo3.getText();
        Assert.assertEquals(action,"edit delete");
        driver.quit();
    }
}
