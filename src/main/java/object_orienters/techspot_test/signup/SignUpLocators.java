package object_orienters.techspot_test.signup;

import org.openqa.selenium.By;

public class SignUpLocators {

    public static final By SIGNUP_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/button[2]");
    public static final By USERNAME_FIELD = By.cssSelector("#root > div > div.css-bt3lm1 > div > form > div.chakra-stack.css-1811skr > input:nth-child(1)");
    public static final By NAME_FIELD = By.cssSelector("#root > div > div.css-bt3lm1 > div > form > div.chakra-stack.css-1811skr > input:nth-child(2)");
    public static final By EMAIL_FIELD = By.cssSelector("#root > div > div.css-bt3lm1 > div > form > div.chakra-stack.css-1811skr > input:nth-child(3)");
    public static final By PASSWORD_FIELD = By.cssSelector("#root > div > div.css-bt3lm1 > div > form > div.chakra-stack.css-1811skr > input:nth-child(4)");
    public static final By SIGNUP_BUTTON2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div/form/div[2]/button[1]");
}
