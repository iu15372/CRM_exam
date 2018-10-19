package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    /**
     * @author Tabel Anastasia
     * Test validLogIn  - тест на валидный логин/пароль
     */
    @Test
    public void validLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("МенеджерМенеджер");
        loginPage.enterPass("111");
        loginPage.clickOnSubmitButton();
        homePage.cheekCurrentUrl();

        checkAC("Url is not valid", webDriver.getCurrentUrl()==homePage.getCurrentUrl(), false);  /// как сделать проверку
        System.out.println(webDriver.getCurrentUrl() + " = " +  homePage.getCurrentUrl());

        checkAC("User-Name is not  present", homePage.isUserNamePresent(), true);
        checkAC("Login box is  presen", loginPage.isLoginForm(), false);
    }
    /**
     * @author Tabel Anastasia
     * Test unValidLogIn  - тест на Не валидный логин/пароль
     */
    @Test
    public void unValidLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("МенеджерМенеджер");
        loginPage.enterPass("123");
        loginPage.clickOnSubmitButton();

        checkAC("User-Name is  present", homePage.isUserNamePresent(), false);
        checkAC("Url is not correct", webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f", false);
        System.out.println(webDriver.getCurrentUrl());


    }
}
