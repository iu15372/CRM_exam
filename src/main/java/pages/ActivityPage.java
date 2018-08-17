package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPage extends ParentPage {

    @FindBy(xpath = ".//*[@id='btnActivityClose']")
    private WebElement buttonActivityClose;

    @FindBy(xpath = ".//*[@id='page-title']/div[1]/button[1]")
    private WebElement buttonActivityCreate;


    public ActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/list");

        }

    public void deletingActivityWithName(String nameOfActivity) {
        while (isActivityInList(nameOfActivity)) {
            clickOnActivity(nameOfActivity);
            clickButtonActivityClose();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Activity with name " + nameOfActivity + " was deleted");
        }
    }

    private void clickButtonActivityClose() {
        actionWithOurElement.clickOnElement(buttonActivityClose);
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
