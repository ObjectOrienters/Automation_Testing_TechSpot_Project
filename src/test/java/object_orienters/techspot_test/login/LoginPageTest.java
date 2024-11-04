package object_orienters.techspot_test.login;

import object_orienters.techspot_test.CrossBrowserBaseTest;
import object_orienters.techspot_test.utilities.CsvReader;
import object_orienters.techspot_test.utilities.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
public class LoginPageTest extends CrossBrowserBaseTest {
    LoginPage loginPage;

    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "edge"})
    public void testLoginToHomePage_Success(String browser) {
        setUp(browser);
        loginPage = new LoginPage(driver);
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        assertEquals(Constants.HOME_URL, driver.getCurrentUrl());
    }
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "edge"})
    public void testLoginToHomePage_Fail(String browser) {
        setUp(browser);
        loginPage = new LoginPage(driver);
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_FAIL_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        WebElement errorToast = waitVisibilityOfElementLocated(LoginLocators.LOGIN_ERROR_TOAST);
        assertTrue(errorToast.isDisplayed(), LoginLocators.TOAST_ERROR_ISNT_DISPLAYED);

    }
}
