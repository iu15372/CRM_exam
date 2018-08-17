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
 * Тесты  с параметризированными данными c Excel
 */
public class UnValidLoginWithParamsWithExcel extends ParentTest {
    String login, pass;

    public UnValidLoginWithParamsWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    /**
     * блок который будет генерить разные параметры
     */


    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
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

        checkAC("Url is not correct", webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(), false);

    }
}
