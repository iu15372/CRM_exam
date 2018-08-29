package activity;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;


public class EditActivityTest extends ParentTest {
    final String nameOfActivity = "editActivityTestDate";
    final String dateOfActivity = " 06092018";
    final String valueSearchTypeDD = "2";


    /**
     * @throws IOException
     * @throws InterruptedException
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     * dateOfActivity  - ставить дату в формате 8 цифр (ддммгггг),  !!! Дата больше текущей
     *       valueSearchTypeDD value="1" -На сегодня
     *                         value="2" -Будущие действия
     *                         value="4" -Закрытые действия
     *                         value="5" -Все по офису
     *                         value="6" -Просроченные по офису
     */

    @Test
    public void editActivityTestDate() throws IOException, InterruptedException {
        loginPage.userValidLogInExcel("login_Men", "pass_Men");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity,valueSearchTypeDD);
        activityPage.deletingActivityWithName(nameOfActivity + " edit",valueSearchTypeDD);
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickOnDateBegin(dateOfActivity);
        createActivityPage.clickButtonActivitySave();
        editActivityPage.clickOnMenuActivity();
        activityPage.selectSearchTypeDD(valueSearchTypeDD);
        activityPage.cheekCurrentUrl();
        activityPage.rightClickMenu(nameOfActivity);
        editActivityPage.enterActivityInfoDescription(" edit");
        editActivityPage.clickButtonActivitySave();
        activityPage.cheekCurrentUrl();
        activityPage.selectSearchTypeDD(valueSearchTypeDD);

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity + " edit"),
                true);
    }

    @After
    public void deletingNewActivityw() {
        activityPage.deletingActivityWithName(nameOfActivity + " edit",valueSearchTypeDD);

    }
}


