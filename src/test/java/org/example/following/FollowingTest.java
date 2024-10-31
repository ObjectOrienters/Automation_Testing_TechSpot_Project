package org.example.following;

import org.example.BaseTest;
import org.example.login.LoginPage;
import org.example.suggestions.Following;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

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
        if(text.equals("Following")){
            assertEquals(following.getFollowButtonText(), "Unfollow");
        } else {
            assertEquals(following.getFollowButtonText(), "Follow");
        }
    }

}
