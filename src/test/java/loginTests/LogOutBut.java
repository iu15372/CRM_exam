package loginTests;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LogOutBut extends ParentTest {

    /**
     * @author Tabel Anastasia
     * @Test LogOut тест на проверку корректрости Выход из системы CRM
     * @throws IOException
     */

    @Test
    public void LogOut() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");

        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login_Men").toString());
        loginPage.enterPass(dataForValidLogin.get("pass_Men").toString());
        loginPage.clickOnSubmitButton();
        homePage.cheekCurrentUrl();
        homePage.clickOnlogOutButton();
        loginPage.cheekCurrentUrl();


        checkAC("Url is not valid", webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(), false);
        checkAC("Login box is  presen", loginPage.isLoginForm(), true);
    }
}
