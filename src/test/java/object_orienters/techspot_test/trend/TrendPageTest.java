package object_orienters.techspot_test.trend;

import junit.framework.Assert;
import object_orienters.techspot_test.BaseTest;
import object_orienters.techspot_test.trends.TrendPage;
import object_orienters.techspot_test.trends.TrendsLocators;
import object_orienters.techspot_test.login.LoginPage;
import object_orienters.techspot_test.utilities.Constants;
import object_orienters.techspot_test.utilities.CsvReader;
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
