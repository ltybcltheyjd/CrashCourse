import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchSoftserve {

    private final String url = "https://www.google.com.ua/";
    private final String query = "softserve";
    private final By searchG = By.name("q");
    private final By searchS = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/table/tbody/tr[1]/td[1]/div/span/h3/a");

    static WebDriver driver;

    @Test
    public void verifySearch(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();

        //Options
        driver.manage().window().maximize();
        driver.manage().notify();


        // Google search
        driver.get(url);
        driver.findElement(searchG).sendKeys(query);
        driver.findElement(searchG).sendKeys(Keys.ENTER);

        // ResultSearch
        String resultSearch = driver.findElement(searchS).getAttribute("href");
        Assert.assertTrue(resultSearch.equals("https://www.softserveinc.com/en-us"));

        driver.quit();

    }
}

