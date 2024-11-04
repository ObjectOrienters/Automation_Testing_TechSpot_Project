package object_orienters.techspot_test.post;

import org.openqa.selenium.By;

public class PostLocators {
    //ADD POST
    public static final By OUTER_POST_DEV = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div");
    public static final By TEXT_AREA = By.xpath("//textarea[contains(@id, 'post-text')]");
    public static final By ADD_POST_BUTTON = By.id("add-post");
    public static final By POST_ADDED_SUCCESS_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Post created.')]");

    //ADD COMMENT
    public static final By COMMENT_BUTTON = By.cssSelector("#root > div > div > div:nth-child(2) > div > div > div:nth-child(2) > div.chakra-card__footer.css-uzajvp > button:nth-child(2)");
    public static final By COMMENT_FIELD = By.id("comment-field");
    public static final By ADD_COMMENT_BUTTON = By.id("submit-button");
    public static final By COMMENT_SUCCESS_TOAST = By.xpath("//div[@data-status='success']//div[contains(text(),'Comment Added.')]");

}
