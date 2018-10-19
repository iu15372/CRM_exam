package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import libs.Utils;

public class CreateActivityPage extends ParentPage{

    @FindBy(xpath = ".//*[@id='btnActivitySave']")
    private WebElement buttenActivitySave;

    @FindBy(xpath = ".//*[@id='ActivityInfo_Description']")
    private WebElement spareActivityInfoDescription;

    @FindBy(xpath=".//*[@id='left-nav']/a[1]")
    private WebElement menyActivity;

    @FindBy(xpath=".//*[@id='ActivityInfo_DateBegin']")
    private WebElement activityDateBegin;

    public CreateActivityPage(WebDriver webDriver) {
        super(webDriver, "/activity/create");
    }

    /**
     * @Metod clickButtonActivitySave - for clicking on Button Activity Save
     */
    public void clickButtonActivitySave() {
        actionWithOurElement.clickOnElement(buttenActivitySave);
    }

    /**
     * @Metod enterActivityInfoDescription - enter a description for Activity
     * @param nameOfSpare
     */
    public void enterActivityInfoDescription(String nameOfSpare) {
        actionWithOurElement.enterTextToElement(spareActivityInfoDescription, nameOfSpare);
    }

    /**
     * @Metod clickOnMenuActivity - for clicking on Menu Activity
     */
    public void clickOnMenuActivity() {
        actionWithOurElement.clickOnElement(menyActivity);
    }

    /**
     * @Metod clickOnDateBegin - enter a DateBegin for Activity
     *
     */
    public void clickOnDateBegin (){
        actionWithOurElement.clearDate(activityDateBegin);


    }


}
