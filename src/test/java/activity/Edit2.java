package activity;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import parentTest.ParentTest;

public class Edit2 extends ParentTest {
    final String nameOfActivity = "edit_21_08_2018";

    Actions actions;


    @Test
    public void EditNewActivity() throws InterruptedException {
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
        int second = 2;
        Thread.sleep(second*1000);
        rightClick(webDriver.findElement(By.xpath(".//*//td[text()='" + nameOfActivity + "']")));
        Thread.sleep(second*1000);
        WebElement element1Edit = webDriver.findElement(By.xpath(".//*[@id='UserActionList_EditEntity_636703755560221601']/div/nobr"));
        element1Edit.click();
        editActivityPage.enterActivityInfoDescription(" edit");
        editActivityPage.clickButtonActivitySave();
        activityPage.cheekCurrentUrl();


        checkAC("New Activity wasn't added",
                activityPage.isNewActivityAdded(nameOfActivity+" edit"),
                true);
    }

    public void rightClick(WebElement element) {
        try {
            Actions actions = new Actions(webDriver);
            actions.contextClick(element);
            actions.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }

}
