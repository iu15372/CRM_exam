package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tabel Anastasia
 * Class HomePage  - Site's home page
 */
public class HomePage extends ParentPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = ".//*[@id='left-nav']/a[1]")
    private WebElement menyActivity;

    @FindBy(xpath = ".//*[@id='left-nav']/*[@href='/opportunitystage/list']")
    private WebElement menyOpportunity;

    @FindBy(xpath = ".//*[@id='user-name']/div/a")
    private WebElement logOutButton;



    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    /**
     * @Metod isUserNamePresent - method checks for the presence of  User-name
     */
    public boolean isUserNamePresent() {
        return actionWithOurElement.isElementDisplay(userName);
    }

    /**
     *  @Metod clickOnMenuActivity  -   for clicking on Menu Activity
     */
    public void clickOnMenuActivity() {
        actionWithOurElement.clickOnElement(menyActivity);
    }
    /**
     * @Metod clickOnMenuOpportunity  -   for clicking on Menu Opportunity
     */
    public void clickOnMenuOpportunity(){
        actionWithOurElement.clickOnElement(menyOpportunity);
    }

    /**
     *  @Metod  clickOnlogOutButton  - method for clicking the exit button
     */
    public void clickOnlogOutButton() {
        actionWithOurElement.clickOnElement(logOutButton);
    }
}
