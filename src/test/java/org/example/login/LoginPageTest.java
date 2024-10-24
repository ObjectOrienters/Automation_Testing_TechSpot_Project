package org.example.login;

import junit.framework.Assert;
import org.example.BaseTest;
import org.example.utilities.CsvReader;
import org.example.utilities.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginToHomePage_Success() {
        Map<String, String> credentials = CsvReader.readSpecificUser(Constants.CSV_FILE_PATH, LoginLocators.USER1);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        Assert.assertEquals(Constants.HOME_URL, driver.getCurrentUrl());
    }
    @Test
    public void testLoginToHomePage_Fail() {
        Map<String, String> credentials = CsvReader.readSpecificUser(Constants.CSV_FILE_PATH, LoginLocators.USER2);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        WebElement errorToast = waitVisibilityOfElementLocated(LoginLocators.LOGIN_ERROR_TOAST);
        Assertions.assertTrue(errorToast.isDisplayed(), LoginLocators.TOAST_ERROR_DOESNT_DISPLAYED);


    }
}
