package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TouristPage extends ParentPage {
    WebDriverWait webDriverWait20;


    public TouristPage(WebDriver webDriver) {
        super(webDriver, "/tourist/list");
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

}
