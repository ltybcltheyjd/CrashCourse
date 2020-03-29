package pageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SoftServePage extends BasePage {

    @FindBy(className = "logo__image")
    public WebElement verifySearchSoftServe;

    String expectedURL = "www.softserveinc.com/en-us";

    public SoftServePage(WebDriver driver) {
        super(driver);
    }

    public void verifyThatResult() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(verifySearchSoftServe));
        boolean count = driver.getCurrentUrl().contains(expectedURL);
        Assertions.assertThat(count).isTrue();
    }
}
