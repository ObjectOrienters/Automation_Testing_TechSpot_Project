package org.example.trends;

import org.example.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrendPage extends BasePage {
    public TrendPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnTrend(By element){
        clickElement(element);

    }
}
