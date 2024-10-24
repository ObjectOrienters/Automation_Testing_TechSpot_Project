package org.example.login;

import org.example.BaseTest;
import org.example.feed.post.Post;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest extends BaseTest {
    Post post = new Post(driver);
    @Test
    public void testLogin() {
        //post.addingLikeToPost();
        //WebElement bt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/button[1]"));
        //bt.click();
        //BaseTest.ClickElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/button[1]"));
    }
    @Test
    public void testLogin2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bt1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/button[1]")));
        bt1.click();

        WebElement bt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[3]/button[1]"));
        bt.click();
    }
}
