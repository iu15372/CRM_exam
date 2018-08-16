package activity;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewActivity extends ParentTest {
    final String nameOfActivity = "test_16_08_2018";

    @Test
    public void addNewActivity() {
        loginPage.userValidLogIn("МенеджерМенеджер", "111");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity);
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickButtonActivitySave();
        createActivityPage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity),
                true);

    }
    @After
    public void deletingNewActivity(){
       activityPage.deletingActivityWithName(nameOfActivity);
    }


}