package activity;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;

public class AddNewActivity extends ParentTest {
    final String nameOfActivity = "test1_31_08_2018";


    /**
     * @throws IOException
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     */
    @Test
    public void addNewActivity() throws IOException {
        loginPage.userValidLogInExcel("login_R.O", "pass_R.O");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity);
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickButtonActivitySave();
        editActivityPage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity),
                true);
    }

    @After
    public void deletingNewActivity() {
        activityPage.deletingActivityWithName(nameOfActivity);
    }


}
