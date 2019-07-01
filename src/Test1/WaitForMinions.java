package Test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys("10");
        driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
        driver.findElement(By.xpath("//div[@class='minions']//img"));
        //Assert.assertEquals(10,driver.findElement(By.xpath("//div[@class='minions']//img")).size());

    }

    @After
    public void tearDown(){
        //driver.quit();
    }


}
