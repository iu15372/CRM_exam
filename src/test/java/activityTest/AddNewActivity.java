package activityTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;


import java.io.IOException;

public class AddNewActivity extends ParentTest {
    final String nameOfActivity = "addNewActivity";
    final String valueSearchTypeDD = "2";



    /**
     * @throws IOException
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     *  valueSearchTypeDD value="1" -На сегодня
     *                    value="2" -Будущие действия
     *                    value="4" -Закрытые действия
     *                    value="5" -Все по офису
     *                    value="6" -Просроченные по офису
     */
    @Test
    public void addNewActivity() throws IOException {
        //loginPage.userValidLogInExcel("login_Men", "pass_Men");
        loginPage.userValidLogInExcel("login_R.O", "pass_R.O");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity,valueSearchTypeDD);
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickOnDateBegin();
        createActivityPage.clickButtonActivitySave();
        editActivityPage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.selectSearchTypeDD(valueSearchTypeDD);

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity),
                true);
    }

    @After
    public void deletingNewActivity() {
        activityPage.deletingActivityWithName(nameOfActivity,valueSearchTypeDD);
    }


}
