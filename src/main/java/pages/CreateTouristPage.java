package pages;

import org.openqa.selenium.WebDriver;

public class CreateTouristPage extends ParentPage {


    public CreateTouristPage(WebDriver webDriver) {
        super(webDriver, "/tourist/create?oo=1&nw");
    }
}
