package org.example.login;

import org.openqa.selenium.By;

public class LoginLocators {
    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/button[1]");
    public static final By LOGIN_BUTTON2 = By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[3]/button[1]");
    public static final By USERNAME_FILED = By.cssSelector("#root > div > div.css-bt3lm1 > div > form > div.chakra-stack.css-1811skr > input:nth-child(1)");
    public static final By PASSWORD_FIELD = By.cssSelector("#root > div > div.css-bt3lm1 > div > form > div.chakra-stack.css-1811skr > input:nth-child(2)");
    public static final By LOGIN_ERROR_TOAST = By.xpath("//div[@data-status='error']//div[contains(text(),'Login Error')]");
    public static final String TOAST_ERROR_ISNT_DISPLAYED = "The error toast message is not displayed!";

}
