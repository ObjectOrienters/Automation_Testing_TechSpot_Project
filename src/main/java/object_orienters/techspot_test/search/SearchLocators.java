package object_orienters.techspot_test.search;

import org.openqa.selenium.By;

public class SearchLocators {

    public static final By SEARCH_BAR = By.xpath("//*[@id=\"root\"]/div/header/header/div/div[2]/div[1]/div/div/input");
    public static final By SEARCH_BAR2 = By.id("inner-search-text-field");
    public static final By AVATAR = By.id("profile-component-search");
    public static final By MAIN_DIV = By.xpath("/html/body/div[3]/div[3]/div");
    public static final By FOLLOW_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div[2]/button[2]");
    public static final By FOLLOW_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Following Yousef2003.')]");
    public static final By UNFOLLOW_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Unfollowed Yousef2003.')]");












}
