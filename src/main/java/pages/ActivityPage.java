package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPage extends ParentPage {

    @FindBy(xpath = ".//*[@id='btnActivityClose']")
    private WebElement ButtonActivityClose;

    @FindBy(name = "add_action")
    private WebElement buttonActivityCreate;


    public ActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/list");
    }

    public void deletingActivityWithName(String nameOfActivity) {
        while (isActivityInList(nameOfActivity)) {
            clickOnActivity(nameOfActivity);
            clickButtonActivityClose();
            logger.info("Activity with name " + nameOfActivity + " was deleted");
        }
    }

    private void clickButtonActivityClose() {
        actionWithOurElement.clickOnElement(ButtonActivityClose);
    }

    private void clickOnActivity(String nameOfActivity) {
        actionWithOurElement.clickOnElement(".//*[text()='" + nameOfActivity + "']");
    }

    private boolean isActivityInList(String nameOfActivity) {
        return actionWithOurElement.isElementInList(".//*[text()='" + nameOfActivity + "']");
    }
    public boolean isNewActivityAdded(String nameOfActivity) {
        return actionWithOurElement.isElementInList(".//*[text()='" + nameOfActivity + "']");
    }

    public void clickOnButtonCreate() {
        actionWithOurElement.clickOnElement(buttonActivityCreate);

    }
}
