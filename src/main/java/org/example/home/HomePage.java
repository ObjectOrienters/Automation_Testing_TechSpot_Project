package org.example.home;

import org.example.login.LoginPage;
import org.example.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private LoginPage loginPage;
    public HomePage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }
    public void clickOnLogoutButton(){
        clickElement(HomeLocators.LOGOUT_BUTTON);



    }
}
