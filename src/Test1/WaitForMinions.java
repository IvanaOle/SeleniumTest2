package Test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForMinions {

    String Base_Url = "http://localhost:8888/playground2-master/minions.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(Base_Url);
    }

    @Test
    public void waitForMinions(){
        int numberOfMinions = (int)(Math.random() * 50 + 1); //cannot contain 0?
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(Integer.toString(numberOfMinions));
        driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
        new WebDriverWait(driver,10)
                .withMessage("Timeout waiting for number of minions to be random")
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"),numberOfMinions));
        driver.findElement(By.xpath("//div[@class='minions']//img"));

        Assert.assertEquals(numberOfMinions,driver.findElements(By.xpath("//div[@class='minions']//img")).size());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }


}
