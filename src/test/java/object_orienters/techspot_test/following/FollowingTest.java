package object_orienters.techspot_test.following;

import object_orienters.techspot_test.BaseTest;
import object_orienters.techspot_test.login.LoginPage;
import object_orienters.techspot_test.suggestions.Following;
import object_orienters.techspot_test.suggestions.FollowingLocators;
import object_orienters.techspot_test.utilities.Constants;
import object_orienters.techspot_test.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FollowingTest extends BaseTest {
    LoginPage loginPage;
    Following following;

    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
        following = new Following(driver);

    }

    @Test
    public void addFollowingFromSuggestions() {
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        String text = following.getFollowButtonText();
        following.followUser();
        boolean follow = false;
        try {
            follow = waitVisibilityOfElementLocated(FollowingLocators.FOLLOW_TOAST).isDisplayed();
        } catch (TimeoutException e) {}

        boolean unfollow = false;
        try {
            unfollow = waitVisibilityOfElementLocated(FollowingLocators.UNFOLLOW_TOAST).isDisplayed();
        } catch (TimeoutException e) {}

        assertTrue(follow || unfollow);

    }

}
