package Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlurTest {
    private String Base_Url = "http://localhost:8888/waitforit.php";
    private WebDriver driver;

    @Before

    public void setUp(){
    driver = new FirefoxDriver();
    driver.get(Base_Url);
    }

    @Test
    public void testBlur(){
    driver.findElement(By.id("waitForBlur")).sendKeys("somarinyvpisujem");
        ((JavascriptExecutor)driver).executeScript("arguments[0].blur()",driver.findElement(By.id("waitForBlur")));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForBlur")),"value","blured!"));
    }

    @Test
    public void testClick(){
    ((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.id("startWaitForText")));

    }

    @After
    public void tearDown(){
    }

}
