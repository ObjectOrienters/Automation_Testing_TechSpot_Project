package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(0));

    }
    public static WebElement findElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void ClickElement(By element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
    }


    public static String getElementText(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element)).getText();
    }
}
