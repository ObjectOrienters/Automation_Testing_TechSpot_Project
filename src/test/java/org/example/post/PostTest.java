package org.example.post;

import org.example.BaseTest;
import org.example.login.LoginPage;
import org.example.utilities.Constants;
import org.example.utilities.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static junit.framework.Assert.assertTrue;

public class PostTest extends BaseTest {

    LoginPage loginPage;
    Post post;

    @BeforeEach
    public void initPageObjects() {
        loginPage = new LoginPage(driver);
        post = new Post(driver);
    }

    @Test
    public void addPost(){
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        post.addNewPost(CsvReader.readCSVFile(Constants.ADD_POST_CSV_FILE_PATH).get("content"));
        boolean isDisplayed = waitVisibilityOfElementLocated(PostLocators.POST_ADDED_SUCCESS_TOAST).isDisplayed();
        assertTrue(isDisplayed);
    }

    @Test
    public void addCommentToPost() {
        Map<String, String> credentials = CsvReader.readCSVFile(Constants.LOGIN_SUCCESS_CSV_FILE_PATH);
        String username = credentials.get("username");
        String password = credentials.get("password");
        loginPage.loginToHomePage(username, password);
        waitUrl(Constants.HOME_URL);
        post.addNewComment(CsvReader.readCSVFile(Constants.ADD_COMMENT_CSV_FILE_PATH).get("comment"));
        boolean isDisplayed = waitVisibilityOfElementLocated(PostLocators.COMMENT_SUCCESS_TOAST).isDisplayed();
        assertTrue(isDisplayed);
    }
}
