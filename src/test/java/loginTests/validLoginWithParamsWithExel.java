package loginTests;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Collection;

@RunWith(Parameterized.class)

/**
 * @author Tabel Anastasia
 * @param login
 * @param pass
 * Тест с параметризированными данными
 */
public class validLoginWithParamsWithExel extends ParentTest {
    String login, pass;

    public validLoginWithParamsWithExel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    /**
     * блок который будет генерить разные параметры (набор данных)
     */
    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "validLogOn").getData();
    }

    /**
     * Test validLogin  - тест на валидный login/pass
     */
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Url is not correct", webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(), true);
        checkAC("Login box is  presen", loginPage.isLoginForm(), false);
    }

}
