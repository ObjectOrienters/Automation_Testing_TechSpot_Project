package object_orienters.techspot_test.home;

import object_orienters.techspot_test.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnLogoutButton(){
        clickElement(HomeLocators.LOGOUT_BUTTON);



    }
}
