import org.testng.annotations.Test;
import pageObject.GooglePage;
import pageObject.SoftServePage;

public class SoftServeTest extends BaseUITest {
    private GooglePage googlePage;
    private SoftServePage softservePage;

    @Test
    public void searchTest() {
        googlePage = new GooglePage(webDriverManager.get());
        softservePage = new SoftServePage(webDriverManager.get());

        String query = "SoftServe";
        String expectedTitle = "SoftServe: Home";

        googlePage.enterSearchQuery(query);
        googlePage.verifyThatResultHasWord(expectedTitle);
        googlePage.enterFirstLink();
        softservePage.verifyThatResult();
    }
}
