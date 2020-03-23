package webDriver.factory;

import config.Configuration;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

    public WebDriver createWebDriver(DriverType driverType){
        WebDriver driver;
        switch (driverType){
            case CHROME:
                driver = createChromeDriver();
                break;
            case IE:
                driver = createIEDriver();
                break;
            case OPERA:
                driver = createOperaDriver();
                break;
            case FIREFOX:
                driver = createFireFoxDriver();
                break;
            case MICROSOFTEDGE:
                driver = createMirosoftEdge();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        return driver;
    }

    protected WebDriver createMirosoftEdge() {
        System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    protected WebDriver createFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    protected WebDriver createOperaDriver(){
        System.setProperty("webdriver.opera.driver", "driver\\operadriver.exe");
        WebDriver driver = new OperaDriver();
        return driver;
    }

    protected WebDriver createIEDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        capabilities.setCapability("initialBrowserUrl", Configuration.url);
        System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        return driver;
    }

    protected WebDriver createChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
