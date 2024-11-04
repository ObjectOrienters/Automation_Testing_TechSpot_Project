package object_orienters.techspot_test.home;

import object_orienters.techspot_test.BaseTest;
import object_orienters.techspot_test.login.LoginPage;
import object_orienters.techspot_test.utilities.Constants;
import object_orienters.techspot_test.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        homePage.clickOnLogoutButton();
        waitUrl(Constants.LANDING_URL);
        WebElement SuccessToast = waitVisibilityOfElementLocated(HomeLocators.LOGOUT_SUCCESS_TOAST);
        assertTrue(SuccessToast.isDisplayed(), HomeLocators.TOAST_SUCCESS_DOESNT_DISPLAYED);
    }
}
