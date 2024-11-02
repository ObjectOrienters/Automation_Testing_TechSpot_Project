package org.example.login;

import org.example.CrossBrowserBaseTest;
import org.example.utilities.CsvReader;
import org.example.utilities.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class LoginPageTest extends CrossBrowserBaseTest {
    LoginPage loginPage;

    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "safari"})
    public void testLoginToHomePage_Success(String browser) {
        setUp(browser);
        loginPage = new LoginPage(driver);
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        Assertions.assertEquals(Constants.HOME_URL, driver.getCurrentUrl());
    }
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "safari"})
    public void testLoginToHomePage_Fail(String browser) {
        setUp(browser);
        loginPage = new LoginPage(driver);
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_FAIL_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        WebElement errorToast = waitVisibilityOfElementLocated(LoginLocators.LOGIN_ERROR_TOAST);
        Assertions.assertTrue(errorToast.isDisplayed(), LoginLocators.TOAST_ERROR_ISNT_DISPLAYED);

    }
}
