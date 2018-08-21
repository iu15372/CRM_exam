package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditActivityPage extends ParentPage {

    @FindBy(xpath=".//*[@id='left-nav']/a[1]")
    private WebElement menyActivity;

    @FindBy(xpath=".//*[@id='btnActivitySave']")
    private WebElement buttenActivitySave;

    @FindBy(xpath=".//*[@id='btnActivitySaveAndClose']")
    private WebElement buttenActivitySaveAndClose;

    @FindBy(xpath = ".//*[@id='ActivityInfo_Description']")
    private WebElement enterActivityInfoDescription;

    public EditActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/edit/");
    }

    public void clickOnMenuActivity() {
        actionWithOurElement.clickOnElement(menyActivity);

    }
    public void clickButtonActivitySave() {
        actionWithOurElement.clickOnElement(buttenActivitySave);
    }
    public void clickButtonActivitySaveAndClose() {
        actionWithOurElement.clickOnElement(buttenActivitySaveAndClose);
    }

    public void enterActivityInfoDescription(String nameOfSpare) {
        actionWithOurElement.enterTextToElement(enterActivityInfoDescription, nameOfSpare);
    }
}
