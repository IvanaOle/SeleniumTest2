package Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThereAndBackAgain {

    private String Base_Url = "http://localhost:8888/tabulka.php";
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(Base_Url);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testScroll(){
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,200)");
        }
    }

    @Test
    public void testScrollToEnd(){
        System.out.println(js.executeScript("return document.body.scrollHeight"));
        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        System.out.println(bodyHeight);
        js.executeScript("window.scrollBy(0," + bodyHeight+ ")");
    }

    @Test
    public void testScrollPartially(){
        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        long arr[]={bodyHeight/5,bodyHeight/5*2,bodyHeight/5*3,bodyHeight/5*4,bodyHeight};
        for (long anArr : arr) {
            System.out.println(anArr);
            js.executeScript("window.scrollBy(0," + anArr + ")");
        }

    }

    @After
    public void tearDown(){

    }

}
