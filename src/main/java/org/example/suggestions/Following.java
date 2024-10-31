package org.example.suggestions;

import org.example.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class Following extends BasePage {


    public Following(WebDriver driver) {
        super(driver);
    }

    public void followUser(){
        this.clickElement(FollowingLocators.FOLLOW_BUTTON);
    }
    public String getFollowButtonText(){
        return this.getElementText(FollowingLocators.FOLLOW_BUTTON);
    }
}
