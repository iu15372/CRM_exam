package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tabel Anastasia
 * Class HomePage  - главная страница сайта
 */
public class HomePage extends ParentPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "");
    }

    /**
     * @Metod isUserNamePresent - метод проверяет наличие User-name
     */
    public boolean isUserNamePresent() {
        return actionWithOurElement.isElementDisplay(userName);

    }
}
