package pages;

import io.qameta.allure.Step;
import libs.ExcelDriver;
import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Map;


/**
 * @author Tabel Anastasia
 * LoginPage - начальная страница (для входа)
 */

public class LoginPage extends ParentPage {
    HomePage homePage;

    @FindBy(name = "Login")
    private WebElement userNameImput;

    @FindBy(name = "Password")
    private WebElement passwordImput;

    @FindBy(xpath = ".//*[@id='signin_submit']")
    private WebElement submitButton;

    @FindBy(xpath = ".//*[@id='loginform']")
    private WebElement isLoginForm;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/User/Login?ReturnUrl=%2f");
        homePage = new HomePage(webDriver);
    }

    /**
     * @Metod openPage - метод для открытия и проверки начальной страницы
     */
    @Step
    public void openPage() {
        try {
            webDriver.get(baseUrl + "/User/Login?ReturnUrl=%2f");
            cheekCurrentUrl();
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open LoginPage" + " " + e);
            Assert.fail("Can not open LoginPage");
        }
    }

    /**
     * @param login
     * @Metod enterLogin -method for input "login"
     */
    @Step
    public void enterLogin(String login) {
        actionWithOurElement.enterTextToElement(userNameImput, login);
    }

    /**
     * @param pass
     * @Metod enterPass - method for input "pass"
     */
    @Step
    public void enterPass(String pass) {
        actionWithOurElement.enterTextToElement(passwordImput, pass);
    }

    /**
     * @Metod clickOnSubmitButton - method for click on  "submitButton"
     */
    @Step
    public void clickOnSubmitButton() {
        actionWithOurElement.clickOnElement(submitButton);
    }

    /**
     * @return
     * @Metod isLoginForm - method for  form validation "loginform"
     */
    @Step
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
     * @Metod userValidLogIn -  to verify valid input "login" и "passWord"
     */
    @Step
    public void userValidLogIn(String login, String passWord) {
        openPage();
        enterLogin(login);
        enterPass(passWord);
        clickOnSubmitButton();
        homePage.cheekCurrentUrl();
    }

    /**
     * @param login
     * @param pass
     * @throws IOException login_R.O,pass_R.O  - руководитель офиса
     *                     login_Men,pass_Men  - менеджер
     */
    @Step
    public void userValidLogInExcel(String login, String pass) throws IOException {
        Utils utils = new Utils();
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        openPage();
        enterLogin(dataForValidLogin.get(login).toString());
        enterPass(dataForValidLogin.get(pass).toString());
        clickOnSubmitButton();
    }


}