import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsPractice {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void DoubleClick() {
        actions.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
        WebElement successText = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertEquals("You have done a double click",successText.getText(),"'You have done a double click' You have done a double click");

    }

    @Test
    void RightClick() {
        actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        WebElement successText = driver.findElement(By.id("rightClickMessage"));
        Assert.assertEquals("You have done a right click",successText.getText(),"'You have done a right click' You have done a double click");

    }

    @Test
    void ClickClick() {
        actions.click(driver.findElement(By.id("2UUlD"))).perform();
        WebElement successText = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals("You have done a dynamic click",successText.getText(),"'You have done a dynamic click' You have done a dynamic click");

    }
}
