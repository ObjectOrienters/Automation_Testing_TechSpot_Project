package org.example.post;

import org.example.utilities.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Post extends BasePage {
    public Post(WebDriver driver) {
        super(driver);
    }


    public void addNewComment(String comment) {
        this.clickElement(PostLocators.COMMENT_BUTTON);

        this.enterText(PostLocators.COMMENT_FIELD, comment);
        this.clickElement(PostLocators.ADD_COMMENT_BUTTON);
    }

    public void addNewPost(String content) {
        this.clickElement(PostLocators.OUTER_POST_DEV);
        //this.enterText(PostLocators.TEXT_AREA, content);
        this.clickElement(PostLocators.ADD_POST_BUTTON);
    }

}
