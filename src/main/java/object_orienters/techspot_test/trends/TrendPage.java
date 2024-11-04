package object_orienters.techspot_test.trends;

import object_orienters.techspot_test.utilities.BasePage;
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
