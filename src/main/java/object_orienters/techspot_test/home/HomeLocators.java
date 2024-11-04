package object_orienters.techspot_test.home;

import org.openqa.selenium.By;

public class HomeLocators {
    public static final By LOGOUT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/header/div/div[2]/button");
    public static final By LOGOUT_SUCCESS_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Logout Success')]");
    public static final String TOAST_SUCCESS_DOESNT_DISPLAYED = "The success toast message is not displayed!";
}
