package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author Tabel Anastasia
 * LoginPage - начальная страница (для входа)
 */

public class LoginPage extends ParentPage {
    HomePage homePage;

    @FindBy(name = "Login")
    private WebElement userNaneImput;

    @FindBy(name = "Password")
    private WebElement passwordImput;

    @FindBy(xpath = ".//*[@id='signin_submit']")
    private WebElement submitButton;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/User/Login?ReturnUrl=%2f");
        homePage = new HomePage(webDriver);
    }

    /**
     * @Metod openPage - метод для открытия и проверки начальной страницы
     */
    public void openPage() {
        try {
            webDriver.get(baseUrl);
            cheekCurrentUrl();
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open LoginPage" + " " + e);
            Assert.fail("Can not open LoginPage");
        }
    }

    /**
     * @param login
     * @Metod enterLogin - метод для ввода данных "login"
     */
    public void enterLogin(String login) {
        actionWithOurElement.enterTextToElement(userNaneImput, login);
    }

    /**
     * @param pass
     * @Metod enterPass - метод для ввода данных "pass"
     */
    public void enterPass(String pass) {
        actionWithOurElement.enterTextToElement(passwordImput, pass);
    }

    /**
     * @Metod clickOnSubmitButton - метод для клика по кнопке "submitButton"
     */
    public void clickOnSubmitButton() {
        actionWithOurElement.clickOnElement(submitButton);

    }

    /**
     * @return
     * @Metod isLoginForm - метод для проверки наличия формы "loginform"
     */
    public boolean isLoginForm() {
        try {
            return webDriver
                    .findElement(By.xpath(".//*[@id='loginform']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param login    (ONLY Valid Login)
     * @param passWord (ONLY Valid Pass)
     * @Metod userValidLogIn для проверки валидного  ввода "login" и "passWord"
     */
    public void userValidLogIn(String login, String passWord) {
        openPage();
        enterLogin(login);
        enterPass(passWord);
        clickOnSubmitButton();
        homePage.cheekCurrentUrl();

    }


}