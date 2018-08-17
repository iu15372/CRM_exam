package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditActivityPage extends ParentPage {

    @FindBy(xpath=".//*[@id='left-nav']/a[1]")
    private WebElement menyActivity;

    @FindBy(xpath=".//*[@id='btnActivitySave']")
    private WebElement buttenActivitySave;


    public EditActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/edit/");
    }

    public void clickOnMenuActivity() {
        actionWithOurElement.clickOnElement(menyActivity);

    }
    public void clickButtonActivitySave() {
        actionWithOurElement.clickOnElement(buttenActivitySave);
    }
}
