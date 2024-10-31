package org.example.trend;

import junit.framework.Assert;
import org.example.BaseTest;
import org.example.trends.TrendPage;
import org.example.trends.TrendsLocators;
import org.example.login.LoginPage;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TrendPageTest extends BaseTest {
    LoginPage loginPage;
    TrendPage trendPage;

    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
        trendPage = new TrendPage(driver);
    }
    @Test
    public void testGoToTrendSpringPage_Success() {
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        trendPage.clickOnTrend(TrendsLocators.TREND_SPRING_SELECTOR);
        waitUrl(Constants.TREND_SPRING_URL);
        Assert.assertEquals(Constants.TREND_SPRING_URL, driver.getCurrentUrl());

    }
}
