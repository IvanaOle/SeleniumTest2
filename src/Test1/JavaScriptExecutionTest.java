package Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class JavaScriptExecutionTest {
    private String Base_Url = "http://localhost:8888/playground2-master/tabulka.php";
    private WebDriver driver;

    @Before
    public void setUp() {
        driver=new FirefoxDriver();
        driver.get(Base_Url);
    }

    @Test
    public void testHighLight(){
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
        for (WebElement row : rows) {
            if (row.getText().contains("Florian")){
                highLight(row);
            }
            //System.out.println(row.getText());
        }
    }

    @After
    public void tearDown(){

    }
    private void highLight(WebElement row) {
        JavascriptExecutor js= ((JavascriptExecutor) driver); //inicializacia javascriptu
        js.executeScript("arguments[0].style.border='3px solid red'", row);
    }
}
