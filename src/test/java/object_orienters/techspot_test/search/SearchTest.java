package object_orienters.techspot_test.search;

import object_orienters.techspot_test.BaseTest;
import object_orienters.techspot_test.login.LoginPage;
import object_orienters.techspot_test.utilities.Constants;
import object_orienters.techspot_test.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class SearchTest extends BaseTest {

    LoginPage loginPage;
    Search search;
    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
        search = new Search(driver);
    }

    @Test
    public void searchForUser() {
        Map<String, String> map = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = map.get("username");
        String password = map.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        String usernameToSearch = CsvReader.readCSVFile(Constants.SEARCH_CSV_FILE_PATH).get("username");
        search.searchForUser(usernameToSearch);
        boolean follow = false;
        try {
            follow = waitVisibilityOfElementLocated(SearchLocators.FOLLOW_TOAST).isDisplayed();
        } catch (TimeoutException e) {}

        boolean unfollow = false;
        try {
            unfollow = waitVisibilityOfElementLocated(SearchLocators.UNFOLLOW_TOAST).isDisplayed();
        } catch (TimeoutException e) {}

        assertTrue(follow || unfollow);
    }
}
