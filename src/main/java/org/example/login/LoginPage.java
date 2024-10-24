package org.example.login;

import org.example.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginToHomePage(String username, String password){
            clickElement(LoginLocators.LOGIN_BUTTON);
            enterText(LoginLocators.USERNAME_FILED, username);
            enterText(LoginLocators.PASSWORD_FIELD, password);
            clickElement(LoginLocators.LOGIN_BUTTON2);


    }
}
