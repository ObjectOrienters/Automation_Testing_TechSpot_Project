package org.example.signUp;

import org.example.BaseTest;
import org.example.signup.SignUpPage;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class SignUpPageTest extends BaseTest {

    SignUpPage signUpPage;

    @BeforeEach
    public void initPageObjects() {
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void testCreateNewUser() {
        Map<String, String> map = CsvReader.readCSVFile(Constants.REGISTER_CSV_FILE_PATH);
        String username = map.get("username");
        String name = map.get("name");
        String email = map.get("email");
        String password = map.get("password");
        signUpPage.createNewAccount(username, name, email, password);
        waitUrl(Constants.LOGIN_URL);
        assertEquals(Constants.LOGIN_URL, driver.getCurrentUrl());
    }
}
