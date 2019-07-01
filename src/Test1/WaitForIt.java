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

public class WaitForIt {
    String Base_Url = "http://localhost:8888/playground2-master/waitforit.php";
    private  WebDriver driver;

    @Before
    public void setUp() {
        driver=new FirefoxDriver();
        driver.get(Base_Url);
    }

    @Test //first one
    public void witForInput() {
        driver.findElement(By.id("startWaitForText")).click();
        //Thread.sleep(5000);
        new WebDriverWait(driver,10).
                until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }

    @Test
    public void  ButIsEnabled(){
        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver,10);
        Assert.assertTrue(driver.findElement(By.id("startWaitForText")).isEnabled());
    }

    @Test //second one
    public void waitForClass(){
        driver.findElement(By.id("startWaitForProperty")).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeContains(By.id("waitForProperty"),"class","error"));

        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
