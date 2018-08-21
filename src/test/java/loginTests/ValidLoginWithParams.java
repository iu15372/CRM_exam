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
 * Тест с параметризированными данными ч/з Exel
 */
public class ValidLoginWithParams extends ParentTest {
    String login, pass;

    public ValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    /**
     * блок который будет генерить разные параметры (набор данных)
     */
    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"МенеджерМенеджер","111"},
                {"тестировщик", "111"}
        });
    }

    /**
     * Test validLogin  - тест на валидный login/pass
     */
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Url is not correct",webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(),true);
        checkAC("Login box is  presen", loginPage.isLoginForm(),false);
    }

}
