package org.example.login;

import org.example.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginToHomePage(String username, String password){
            ClickElement(LoginLocators.LOGIN_BUTTON);
            EnterText(LoginLocators.USERNAME_FILED, username);
            EnterText(LoginLocators.PASSWORD_FIELD, password);
            ClickElement(LoginLocators.LOGIN_BUTTON2);


    }
}
