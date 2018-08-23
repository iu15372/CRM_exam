package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityPage extends ParentPage {
    WebDriverWait webDriverWait20;

    @FindBy(xpath = ".//*[@id='btnActivityClose']")
    private WebElement buttonActivityClose;

    @FindBy(xpath = ".//*[@id='page-title']/div[1]/button[1]")
    private WebElement buttonActivityCreate;

    @FindBy(xpath = ".//*[@id='btnEditActivity']")
    private WebElement buttonActivityEdit;

    @FindBy(xpath = ".//*[@key='EditEntity']")
    private WebElement buttonActivityContextMenu;

    @FindBy(xpath = "html/body/div[9]/ul/li[1]/div")
    private WebElement rightClickMenuEditEntity;

    public ActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/list");

    }

    /**
     * Click on button Close for Close Activity  (N time's)
     * @param nameOfActivity
     * @Metod deletingActivityWithName
     */
    public void deletingActivityWithName(String nameOfActivity) {
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        while (isActivityInList(nameOfActivity)) {
            clickOnActivity(nameOfActivity);
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*//td[text()='" + nameOfActivity + "']")));
            clickButtonActivityClose();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Activity with name " + nameOfActivity + " was deleted");
        }
    }

    /**
     * Click on button Close for Close Activity
     * @Metod clickButtonActivityClose
     */
    public void clickButtonActivityClose() {
        actionWithOurElement.clickOnElement(buttonActivityClose);
    }

    /**
     * Click to Activity in table
     * @param nameOfActivity
     * @Metod clickOnActivity
     */
    public void clickOnActivity(String nameOfActivity) {
        actionWithOurElement.clickOnElement(".//*[text()='" + nameOfActivity + "']");
    }

//    /**
//     * Click to Activity in table
//     * @param nameOfActivity
//     * @Metod clickIsEditActivity
//     */
//    public void clickIsEditActivity(String nameOfActivity) {
//        actionWithOurElement.clickOnElement(".//*//td[text()='" + nameOfActivity + "']");
//    }

    /**
     * there is a new Activity In List
     * @param nameOfActivity
     * @return
     * @Metod isActivityInList
     */
    private boolean isActivityInList(String nameOfActivity) {
        return actionWithOurElement.isElementInList(".//*[text()='" + nameOfActivity + "']");
    }

    /**
     * check if a new Activity has been Added
     *
     * @param nameOfActivity
     * @return
     * @Metod isNewActivityAdded
     */
    public boolean isNewActivityAdded(String nameOfActivity) {
        return actionWithOurElement.isElementInList(".//*[text()='" + nameOfActivity + "']");
    }

    /**
     * Click on button Create
     *
     * @Metod clickOnButtonCreate
     */
    public void clickOnButtonCreate() {
        actionWithOurElement.clickOnElement(buttonActivityCreate);
    }

    /**
     * Click on button Edit
     *
     * @Metod clickOnButtonEdit
     */
    public void clickOnButtonEdit() {
        actionWithOurElement.clickOnElement(buttonActivityEdit);
    }


    /**
     * right Click Menu  - Context menu
     *
     * @param nameOfActivity
     * @throws InterruptedException
     * @Metod rightClickMenu
     */
    public void rightClickMenu(String nameOfActivity) throws InterruptedException {
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        int second = 2;
        Thread.sleep(second * 1000);
        actionWithOurElement.rightClick(nameOfActivity);

        webDriverWait20.until(ExpectedConditions.elementToBeClickable(rightClickMenuEditEntity));
        actionWithOurElement.clickOnElement(rightClickMenuEditEntity);

    }
}
