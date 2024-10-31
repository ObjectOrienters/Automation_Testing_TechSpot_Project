package org.example.profile;

import junit.framework.Assert;
import org.example.BaseTest;
import org.example.login.LoginLocators;
import org.example.login.LoginPage;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ProfilePageTest extends BaseTest {
    LoginPage loginPage;
    ProfilePage profilePage;
    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }
    @Test
    public void testFollowingTab(){
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        profilePage.goToProfilePage(ProfileLocators.profileAvatar);
        waitUrl(Constants.PROFILE_URL);
        profilePage.goToFollowingTab();
        waitUrl(Constants.FOLLOWERS_URL);
        Assert.assertEquals(Constants.FOLLOWERS_URL, driver.getCurrentUrl());
    }
}
