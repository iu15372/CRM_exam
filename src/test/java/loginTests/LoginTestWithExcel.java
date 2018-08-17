package loginTests;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithExcel extends ParentTest {


    /**
     * @author Tabel Anastasia
     * @Test validLogIn  - тест на валидный логин/пароль
     */
    @Test
    public void validLogIn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");

        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login_Men").toString());
        loginPage.enterPass(dataForValidLogin.get("pass_Men").toString());
        loginPage.clickOnSubmitButton();

        checkAC("Url is not valid", webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(), true);
        checkAC("Login box is  presen", loginPage.isLoginForm(), false);
    }
    /**
     * @author Tabel Anastasia
     * Test unValidLogIn  - тест на Не валидный логин/пароль
     */
    @Test
    public void unValidLogIn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"unValidLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnSubmitButton();

        checkAC("User-Name is  present", homePage.isUserNamePresent(), false);
        checkAC("Url is not correct", webDriver.getCurrentUrl() ==
                "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f", false);



    }
}
