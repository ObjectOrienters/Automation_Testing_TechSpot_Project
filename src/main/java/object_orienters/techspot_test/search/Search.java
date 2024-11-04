package object_orienters.techspot_test.search;

import object_orienters.techspot_test.utilities.BasePage;
import org.openqa.selenium.WebDriver;


public class Search extends BasePage {


    public Search(WebDriver driver) {
        super(driver);
    }

    public void searchForUser(String username){
        this.clickElement(SearchLocators.SEARCH_BAR);
        this.enterText(SearchLocators.SEARCH_BAR2,username);
        this.clickElement(SearchLocators.AVATAR);
        this.clickElement(SearchLocators.MAIN_DIV);
        this.clickElement(SearchLocators.FOLLOW_BUTTON);
    }

}
