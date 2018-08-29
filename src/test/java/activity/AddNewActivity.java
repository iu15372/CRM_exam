package activity;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;

public class AddNewActivity extends ParentTest {
    final String nameOfActivity = "addNewActivity";
    final String dateOfActivity = " 06092018";


    /**
     * @throws IOException
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     * dateOfActivity  - ставить дату в формате 8 цифр (ддммгггг),
     * !!! дата больше текущей
     */
    @Test
    public void addNewActivity() throws IOException {
        loginPage.userValidLogInExcel("login_Men", "pass_Men");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity);
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickOnDateBegin(dateOfActivity);
        createActivityPage.clickButtonActivitySave();
        editActivityPage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.selectSearchTypeDD("2");

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity),
                true);
    }

    @After
    public void deletingNewActivity() {
        activityPage.deletingActivityWithName(nameOfActivity);
    }


}
