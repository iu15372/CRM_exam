package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPage extends ParentPage {

    @FindBy(xpath = ".//*[@id='btnActivityClose']")
    private WebElement buttonActivityClose;

    @FindBy(xpath = ".//*[@id='page-title']/div[1]/button[1]")
    private WebElement buttonActivityCreate;

    @FindBy(xpath = ".//*[@id='btnEditActivity']")
    private WebElement buttonActivityEdit;

    @FindBy(xpath = ".//*[@key='EditEntity']")
    private WebElement buttonActivityContextMenu;

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
    public void clickContextMenu(){
        actionWithOurElement.clickOnElement(buttonActivityContextMenu);
    }
    public void clickButtonActivityClose() {
        actionWithOurElement.clickOnElement(buttonActivityClose);
    }

    public void clickOnActivity(String nameOfActivity) {
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

    public void clickOnButtonEdit() {
        actionWithOurElement.clickOnElement(buttonActivityEdit);

    }
    public void clickIsEditActivity (String nameOfActivity){
        actionWithOurElement.clickOnElement(".//*//td[text()='"+nameOfActivity+"']");
    }
}
