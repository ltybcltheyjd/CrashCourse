package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverManager;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected WebDriverManager webDriverManager;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 2);
    }

}
