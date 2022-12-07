import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsIntro {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
    @Test
    void rightClickAction(){
        actions.contextClick(driver.findElement(By.tagName("h3"))).perform();
    }

    @Test
    void hoverOverTest(){
        WebElement user1 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(user1).perform();
        WebElement viewProfile1 = driver.findElement(By.cssSelector("a[href='/users/1']"));
        Assert.assertTrue(viewProfile1.isEnabled());
        Assert.assertTrue(viewProfile1.isDisplayed());
    }
}
