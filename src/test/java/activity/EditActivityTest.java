package activity;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;


public class EditActivityTest extends ParentTest {
    final String nameOfActivity = "test2";
    final String dateOfActivity = "30082018";  // формат даты(будущие)

    /**
     * @throws IOException
     * @throws InterruptedException
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     */

    @Test
    public void editActivityTestDate() throws IOException, InterruptedException {
        loginPage.userValidLogInExcel("login_R.O", "pass_R.O");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity);
        activityPage.deletingActivityWithName(nameOfActivity + " edit");
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickOnDateBegin(dateOfActivity);
        createActivityPage.clickButtonActivitySave();
        editActivityPage.clickOnMenuActivity();
        activityPage.selectSearchTypeDD("2");
        activityPage.cheekCurrentUrl();
        activityPage.rightClickMenu(nameOfActivity);
        editActivityPage.enterActivityInfoDescription(" edit");
        editActivityPage.clickButtonActivitySave();
        activityPage.cheekCurrentUrl();

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity + " edit"),
                false);
    }

    @After
    public void deletingNewActivityw() {
        activityPage.deletingActivityWithName(nameOfActivity + " edit");

    }
}


