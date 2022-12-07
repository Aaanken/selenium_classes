import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectClassPractice {
        @Test
        void selectShirtByVisibleTextTest(){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
            WebElement shirtsSelect = driver.findElement(By.id("Shirts"));
            Select selectShirt = new Select(shirtsSelect);
            final String defaultShirt = "Blue Shirt";
            Assert.assertEquals(defaultShirt,selectShirt.getFirstSelectedOption().getText());
            final String yellowShirt = "Yellow Shirt";
            selectShirt.selectByVisibleText(yellowShirt);
            Assert.assertEquals(yellowShirt,selectShirt.getFirstSelectedOption().getText());
            final String redShirt = "Red Shirt";
            selectShirt.selectByVisibleText(redShirt);
            Assert.assertEquals(redShirt,selectShirt.getFirstSelectedOption().getText());
        }
        @Test
        void selectSkirtByIndexTest(){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
            WebElement skirtSelect = driver.findElement(By.id("Skirts"));
            Select selectSkirt = new Select(skirtSelect);
            final String defaultShirt = "Blue Skirt";
            Assert.assertEquals(defaultShirt,selectSkirt.getFirstSelectedOption().getText());
            final String yellowShirt = "Yellow Skirt";
            selectSkirt.selectByIndex(2);
            Assert.assertEquals(yellowShirt,selectSkirt.getFirstSelectedOption().getText());
            selectSkirt.selectByIndex(1);
            final String redSkirt = "Red Skirt";
            Assert.assertEquals(redSkirt,selectSkirt.getFirstSelectedOption().getText());
        }
        @Test
        void selectCountryByValueTest(){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///Users/anna/Desktop/TechtorialApp/TechtorialApp.html");
            WebElement country = driver.findElement(By.id("country"));
            Select countrySelect = new Select(country);
            final String defaultSelecton = "select country";
            Assert.assertEquals(defaultSelecton,countrySelect.getFirstSelectedOption().getText());
            countrySelect.selectByValue("ZW");
            final String expectedSelection = "Zimbabwe";
            Assert.assertEquals(expectedSelection,countrySelect.getFirstSelectedOption().getText());
            List<WebElement> allOptions = countrySelect.getOptions();
            Set<String> expectedOption = new HashSet<>();
            for (WebElement option: allOptions){
                expectedOption.add(option.getText());
            }
        Assert.assertEquals(allOptions.size(),expectedOption.size());
    }

}
