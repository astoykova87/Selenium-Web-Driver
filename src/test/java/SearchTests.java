import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchTests {

    public static WebDriver driver;

    @BeforeAll
    public static void beforeTest(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchInBing() {
        driver.get("https://www.bing.com");

        WebElement cookieButton = driver.findElement(By.id("bnp_btn_accept"));
        cookieButton.click();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Telerik Academy Alpha" + Keys.ENTER);

        WebElement firstResult = driver.findElement(By.cssSelector("li.b_algo h2 a"));
        String firstResultTitle = firstResult.getText();
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResultTitle);
    }

    @Test
    public void searchInGoogle() {
        driver.get("https://www.google.com");

        WebElement cookieButton = driver.findElement(By.id("L2AGLb"));
        cookieButton.click();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Telerik Academy Alpha" + Keys.ENTER);

        WebElement firstResult = driver.findElement(By.cssSelector("h3"));
        String firstResultTitle = firstResult.getText();
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResultTitle);
    }

    @AfterAll
    public static void afterTest(){
        driver.close();
    }
}
