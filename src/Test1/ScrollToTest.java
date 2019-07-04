package Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollToTest {
    private String Base_Url = "http://localhost:8888/playground2-master/tabulka.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(Base_Url);
    }

    @Test
    public void scroll(){
      /*  WebElement lastRow = driver.findElement(By.xpath("//table/tbody//tr[last()]"));
        System.out.println(lastRow.getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",lastRow);*/

        WebElement lastRow = driver.findElement(By.xpath("//table/tbody//tr[5]"));
        System.out.println(lastRow.getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",lastRow);

    }
    @After
    public void tearDown() {

    }

}
