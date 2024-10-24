package org.example.home;

import org.example.BaseTest;
import org.example.login.LoginLocators;
import org.example.login.LoginPage;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class HomePageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }
    @Test
    public void testLogout() {
        Map<String, String> credentials = CsvReader.readSpecificUser(Constants.CSV_FILE_PATH, LoginLocators.USER1);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        homePage.clickOnLogoutButton();
        waitUrl(Constants.LANDING_URL);
        WebElement SuccessToast = waitVisibilityOfElementLocated(HomeLocators.LOGOUT_SUCCESS_TOAST);
        Assertions.assertTrue(SuccessToast.isDisplayed(), HomeLocators.TOAST_SUCCESS_DOESNT_DISPLAYED);
    }
}
