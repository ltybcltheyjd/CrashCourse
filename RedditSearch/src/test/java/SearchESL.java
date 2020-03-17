import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class SearchESL {
    private final String url = "https://www.reddit.com/";
    private final String query = "esl";
    private final By searchR = By.name("q");
    private final By searchESL = By.className("_3JYXhJlwZCvjZTBplEncbq");

    static ChromeOptions options;
    static WebDriver driver;
    static WebDriverWait wait;

    @Test
    public void verifySearch(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        //Dismiss notifications
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 3);

        driver.manage().window().maximize();

        // Reddit search
        driver.get(url);
        wait.until(d-> d.findElement(searchR).isDisplayed());
        driver.findElement(searchR).sendKeys(query);
        driver.findElement(searchR).sendKeys(Keys.ENTER);

        //First link in the search results
        wait.until(ExpectedConditions.elementToBeClickable(searchESL)).click();

        //Verification
        Assert.assertTrue(driver.getCurrentUrl().contains(query));

        driver.quit();
    }
}
