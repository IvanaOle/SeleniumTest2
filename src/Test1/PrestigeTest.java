package Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestigeTest {
    private String Base_Url = "http://localhost:8888/prestige.php";

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(Base_Url);
    }

    @Test
    public void Prestige(){
        driver.findElement(By.xpath("//div/img")).click(); //XPath
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div/img")));
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/img")));

        //driver.findElement(By.cssSelector("div.hat img")).click(); //CSS selector

    }

    @After
    public void tearDown(){
        driver.quit();

    }

}
