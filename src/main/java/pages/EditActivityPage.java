package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditActivityPage extends ParentPage {

    @FindBy(xpath = ".//*[@id='left-nav']/a[1]")
    private WebElement menyActivity;

    @FindBy(xpath = ".//*[@id='btnActivitySave']")
    private WebElement buttonActivitySave;

    @FindBy(xpath = ".//*[@id='btnActivitySaveAndClose']")
    private WebElement buttonActivitySaveAndClose;

    @FindBy(xpath = ".//*[@id='ActivityInfo_Description']")
    private WebElement enterActivityInfoDescription;

    public EditActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/edit/");
    }

    /**
     * @Metod clickOnMenuActivity - for clicking on Menu Activity
     */
    public void clickOnMenuActivity() {
        actionWithOurElement.clickOnElement(menyActivity);
    }

    /**
     * @Metod clickButtonActivitySave - for clicking on Button Activity Save
     */
    public void clickButtonActivitySave() {
        actionWithOurElement.clickOnElement(buttonActivitySave);
    }

    /**
     * @Metod clickButtonActivitySaveAndClose - for clicking on Button Save And Close Activity
     */
    public void clickButtonActivitySaveAndClose() {
        actionWithOurElement.clickOnElement(buttonActivitySaveAndClose);
    }

    /**
     * @Metod enterActivityInfoDescription - enter a description for Activity
     */
    public void enterActivityInfoDescription(String nameOfSpare) {
        actionWithOurElement.enterTextToElement(enterActivityInfoDescription, nameOfSpare);
    }
}
