package org.example.profile;

import org.openqa.selenium.By;

public class ProfileLocators {
    public static final By profileAvatar = By.cssSelector("#root > div > header > header > div > div:nth-child(2) > span > img");
    public static final By followersTab = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div[1]/div[3]/p[2]");
}
