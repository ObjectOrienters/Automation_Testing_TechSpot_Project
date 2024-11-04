package object_orienters.techspot_test.profile;

import object_orienters.techspot_test.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public void goToProfilePage(By profile){
        clickElement(profile);
    }
    public void goToFollowingTab(){
        clickElement(ProfileLocators.followersTab);

    }
}
