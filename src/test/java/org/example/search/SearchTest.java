package org.example.search;

import org.example.BaseTest;
import org.example.login.LoginPage;
import org.example.post.PostLocators;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

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
