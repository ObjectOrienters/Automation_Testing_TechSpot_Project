package org.example.signup;

import org.example.utilities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void createNewAccount(String username, String name, String email, String password) {
        this.clickElement(SignUpLocators.SIGNUP_BUTTON);
        this.enterText(SignUpLocators.USERNAME_FIELD, username);
        this.enterText(SignUpLocators.NAME_FIELD, name);
        this.enterText(SignUpLocators.EMAIL_FIELD, email);
        this.enterText(SignUpLocators.PASSWORD_FIELD, password);
        this.clickElement(SignUpLocators.SIGNUP_BUTTON2);
    }
}
