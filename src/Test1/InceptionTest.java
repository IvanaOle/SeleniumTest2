package Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InceptionTest {
    private WebDriver driver;
    private String Base_Url = "http://localhost:8888/inception.php";
    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(Base_Url);
        driver.manage().window().maximize();
    }

    @Test
    public void testDeeper() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.id("letsGoDeeper")).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.getWindowHandles();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.xpath("//div/input[1]")).sendKeys("Hladny som");

        //upravit do for cyklu
        driver.findElement(By.id("letsGoDeeper")).click();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.xpath("//div/input[1]")).sendKeys("Aj smadny som");

        driver.close();
        Thread.sleep(3);
        driver.switchTo().window(parentWindow);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
