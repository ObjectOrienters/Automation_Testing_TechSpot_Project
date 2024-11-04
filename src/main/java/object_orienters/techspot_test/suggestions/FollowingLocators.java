package object_orienters.techspot_test.suggestions;

import org.openqa.selenium.By;

public class FollowingLocators {

    public static final By FOLLOW_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div/div[1]/div/div[2]/div/div/button[2]");
    public static final By FOLLOW_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Following Nader.')]");
    public static final By UNFOLLOW_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Unfollowed Nader.')]");
}
