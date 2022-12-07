import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ClicksPractice {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void clickTest() throws InterruptedException{
        List<WebElement> widgets = driver.findElements(By.cssSelector(".ui-panel-content.ui-widget-content"));
        for (int i=0;i< widgets.size();i++){
            Thread.sleep(1500);
            System.out.println(widgets.get(i).getText());
            switch (widgets.get(i).getText()){
                case "click":
                    actions.click(widgets.get(i)).perform();
                    break;
                case "doubleclick":
                    actions.doubleClick(widgets.get(i)).perform();
            }
        }

    }

}
