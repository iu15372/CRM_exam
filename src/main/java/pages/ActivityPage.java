package pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = ".//*[@id='ObjectViewMode']")
    private WebElement typeOfViewModeActivityDD;

    @FindBy(xpath = ".//*[@name='s-in']")
    private WebElement searchInputActivity;

    @FindBy(xpath = ".//*[@id='page-title']/div[2]/input[2]")
    private WebElement serchLupa;

    public ActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/list");
        webDriverWait20 = new WebDriverWait(webDriver, 20);

    }

    /**
     * Click on button Close for Close Activity  (N time's)
     * @param nameOfActivity
     * @Metod deletingActivityWithName
     */
    public void deletingActivityWithName(String nameOfActivity) {
         selectSearchTypeDD("2");
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

    /**
     * @param value value="1" -На сегодня
     *              value="2" -Будущие действия
     *              value="4" -Закрытые действия
     *              value="5" -Все по офису
     *              value="6" -Просроченные по офису
     * @Metod for DD
     */
    public void selectSearchTypeDD(String value) {
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));
        actionWithOurElement.selectValueInDD(typeOfViewModeActivityDD, value);
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
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));
        actionWithOurElement.clickOnElement(".//*[text()='" + nameOfActivity + "']");
    }

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
     * @param nameOfActivity
     * @return
     * @Metod isNewActivityAdded
     */
    public boolean isNewActivityAdded(String nameOfActivity) {

        return actionWithOurElement.isElementInList(".//*[text()='" + nameOfActivity + "']");
    }

    /**
     * Click on button Create
     * @Metod clickOnButtonCreate - method for click on   Button Create Activity
     */
    @Step
    public void clickOnButtonCreate() {
        actionWithOurElement.clickOnElement(buttonActivityCreate);
    }

    /**
     * Click on button Edit
     * @Metod clickOnButtonEdit - method for click on   Button Edit Activity
     */
    @Step
    public void clickOnButtonEdit() {
        actionWithOurElement.clickOnElement(buttonActivityEdit);
    }


    /**
     * right Click Menu  - Context menu
     * @param nameOfActivity
     * @throws InterruptedException
     * @Metod rightClickMenu
     */
    @Step
    public void rightClickMenu(String nameOfActivity) throws InterruptedException {
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        webDriverWait20.until(ExpectedConditions.not
                (ExpectedConditions.elementToBeClickable(By.xpath
                        (".//*[@class='loading ui-state-default ui-state-active']"))));
        actionWithOurElement.rightClick(nameOfActivity);
        webDriverWait20.until(ExpectedConditions.elementToBeClickable(rightClickMenuEditEntity));
        actionWithOurElement.clickOnElement(rightClickMenuEditEntity);
    }


}

