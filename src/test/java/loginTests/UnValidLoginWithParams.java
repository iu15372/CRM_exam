package loginTests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
/**
 * @author Tabel Anastasia
 * @param login
 * @param pass
 * Тесты  с параметризированными данными
 */
public class UnValidLoginWithParams extends ParentTest{
    String login, pass;

    public UnValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    /**
     * блок который будет генерить разные параметры
     */
    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{   //Набор данных
                {"МенеджерМенеджер","123"},
                {"тестировщик", "123"}
        });
    }
    /**
     * Test inValidLogin  - тест на Не валидный login/pass
     */
    @Test
    public void inValidLogin() {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Url is not correct",webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(),false);

    }
}
