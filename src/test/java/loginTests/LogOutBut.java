package loginTests;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LogOutBut extends ParentTest {

    /**
     * @throws IOException
     * @author Tabel Anastasia
     * @Test LogOut тест на проверку корректрости Выхода из системы CRM
     */

    @Test
    public void LogOut() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");

        loginPage.userValidLogInExcel("login_R.O", "pass_R.O");
        homePage.cheekCurrentUrl();
        homePage.clickOnlogOutButton();
        loginPage.cheekCurrentUrl();

        checkAC("Url is not valid", webDriver.getCurrentUrl() == "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f", false);
        checkAC("User-Name is not  present", homePage.isUserNamePresent(), false);
        checkAC("Login box is  presen", loginPage.isLoginForm(), true);
    }
}
