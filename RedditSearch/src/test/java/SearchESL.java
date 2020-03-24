import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchESL {
    private final String url = "https://www.reddit.com/";
    private final String query = "esl";
    private final By Redditsearch = By.name("q");
    private final By searchESL = By.className("_3JYXhJlwZCvjZTBplEncbq");

    static ChromeOptions options;
    static WebDriver driver;
    static WebDriverWait wait;

    @Test
    public void verifySearch(){
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 3);

        driver.manage().window().maximize();

        driver.get(url);
        wait.until(d-> d.findElement(Redditsearch).isDisplayed());
        driver.findElement(Redditsearch).sendKeys(query);
        driver.findElement(Redditsearch).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(searchESL)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(query));

        driver.quit();
    }
}
