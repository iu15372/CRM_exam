package activity;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;


public class EditActivityTest extends ParentTest {
    final String nameOfActivity = "test2";

    /**
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void editActivityTest() throws IOException, InterruptedException {
        loginPage.userValidLogInExcel("login_R.O","pass_R.O");
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
        activityPage.rightClickMenu(nameOfActivity);
        editActivityPage.enterActivityInfoDescription(" edit");
        editActivityPage.clickButtonActivitySave();
        activityPage.cheekCurrentUrl();
        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity+" edit"),
                true);
    }
    @After
    public void deletingNewActivity() {
        activityPage.deletingActivityWithName(nameOfActivity+" edit");
    }
}


