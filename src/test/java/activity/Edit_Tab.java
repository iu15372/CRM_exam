package activity;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentTest.ParentTest;

public class Edit_Tab extends ParentTest {

    final String nameOfActivity = "test_21_08_2018";

    @Test
    public void addNewActivity() throws InterruptedException {
        loginPage.userValidLogIn("МенеджерМенеджер", "111");
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
        activityPage.clickOnActivity(nameOfActivity);
        Thread.sleep(3000);
       // String parentHandle = webDriver.getWindowHandle();
       // activityPage.clickOnButtonEdit();

//        for(String childHandle : webDriver.getWindowHandles()){
//            if (!childHandle.equals(parentHandle)){
//                webDriver.switchTo().window(childHandle);
//            }
//        }

        //editActivityPage.cheekCurrentUrl();
       // webDriver.switchTo().window(parentHandle);

//        activityPage.cheekCurrentUrl();
//        activityPage.clickIsEditActivity(nameOfActivity);
//        checkAC("New Activity wasn't added",
//                activityPage.isNewActivityAdded(nameOfActivity),
//                true);
    }
}
