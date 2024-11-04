package object_orienters.techspot_test.signUp;

import object_orienters.techspot_test.BaseTest;
import object_orienters.techspot_test.signup.SignUpPage;
import object_orienters.techspot_test.utilities.Constants;
import object_orienters.techspot_test.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static object_orienters.techspot_test.utilities.RandomDataGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpPageTest extends BaseTest {

    SignUpPage signUpPage;

    @BeforeEach
    public void initPageObjects() {
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void testCreateNewUser() {
        String randomUsername = "user" + getRandomString(7);
        String randomEmail = getRandomEmail();
        String filePath = Constants.REGISTER_CSV_FILE_PATH;
        writeDataToCSV(filePath, randomUsername, randomEmail);


        Map<String, String> map = CsvReader.readCSVFile(filePath);
        String username = map.get("username");
        String name = map.get("name");
        String email = map.get("email");
        String password = map.get("password");
        signUpPage.createNewAccount(username, name, email, password);
        waitUrl(Constants.LOGIN_URL);
        assertEquals(Constants.LOGIN_URL, driver.getCurrentUrl());
    }
}
