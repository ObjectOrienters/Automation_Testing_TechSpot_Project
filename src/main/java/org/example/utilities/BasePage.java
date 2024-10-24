package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(0));

    }
    public WebElement findElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void clickElement(By element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
    }


    public String getElementText(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element)).getText();
    }
    public void enterText(By element, String text) {
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        textElement.sendKeys(text);
    }
}
