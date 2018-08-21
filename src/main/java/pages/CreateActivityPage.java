package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateActivityPage extends ParentPage{

    @FindBy(xpath = ".//*[@id='btnActivitySave']")
    private WebElement buttenActivitySave;

    @FindBy(xpath = ".//*[@id='ActivityInfo_Description']")
    private WebElement spareActivityInfoDescription;

    @FindBy(xpath=".//*[@id='left-nav']/a[1]")
    private WebElement menyActivity;

    public CreateActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/create");
    }

    public void clickButtonActivitySave() {
        actionWithOurElement.clickOnElement(buttenActivitySave);
    }
    public void enterActivityInfoDescription(String nameOfSpare) {
        actionWithOurElement.enterTextToElement(spareActivityInfoDescription, nameOfSpare);
    }
    public void clickOnMenuActivity() {
        actionWithOurElement.clickOnElement(menyActivity);
    }
}
