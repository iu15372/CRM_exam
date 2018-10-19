package activity;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ParentPage;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Set;

public class EditActivityNewTab extends ParentTest {
    final String nameOfActivity = "editActivityTestDateNewTab";
    final String valueSearchTypeDD = "2";

    WebDriverWait webDriverWait20;

    @Test
    public void editActivityNewTab() throws IOException {
        loginPage.userValidLogInExcel("login_R.O", "pass_R.O");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuActivity();
        activityPage.cheekCurrentUrl();
        activityPage.deletingActivityWithName(nameOfActivity, valueSearchTypeDD);
        activityPage.deletingActivityWithName(nameOfActivity + " edit",valueSearchTypeDD);
        activityPage.clickOnButtonCreate();
        createActivityPage.cheekCurrentUrl();
        createActivityPage.enterActivityInfoDescription(nameOfActivity);
        createActivityPage.clickOnDateBegin();
        createActivityPage.clickButtonActivitySave();
        editActivityPage.clickOnMenuActivity();
        activityPage.selectSearchTypeDD("2");
        activityPage.clickOnActivity(nameOfActivity);
        String paretnHandle = webDriver.getWindowHandle();
        activityPage.clickOnButtonEdit();

        editActivityPage.enterActivityInfoDescription(" edit");
        editActivityPage.clickButtonActivitySaveAndClose();
        webDriver.switchTo().window(paretnHandle);
        activityPage.cheekCurrentUrl();

        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity + " edit"),
                true);
    }

    @After
    public void deletingNewActivityw() {
        activityPage.deletingActivityWithName(nameOfActivity + " edit", valueSearchTypeDD);

    }
}
