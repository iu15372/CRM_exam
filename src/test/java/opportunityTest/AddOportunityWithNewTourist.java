package opportunityTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;

public class AddOportunityWithNewTourist extends ParentTest {

    /**
     * @throws IOException
     * @userValidLogInExcel(_,_)
     * "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     */
     @Test
    public void addNewOportunityWithNewTourist() throws IOException {
        //loginPage.userValidLogInExcel("login_Men", "pass_Men");
        loginPage.userValidLogInExcel("login_R.O", "pass_R.O");
        homePage.cheekCurrentUrl();
        homePage.clickOnMenuOpportunity();
       // opportunitystagePage.cheekCurrentUrl();
       // String paretnHandle = webDriver.getWindowHandle();  -- ДОДЕЛАТЬ!!!
        opportunitystagePage.clickOnButtonCreate();
        editActivityPage.cheekCurrentUrl();
    }

  //  @After

}
