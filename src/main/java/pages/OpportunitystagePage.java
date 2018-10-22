package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpportunitystagePage extends ParentPage {
    WebDriverWait webDriverWait20;

    @FindBy(xpath = ".//*[@id='page-title']/div[1]/button[1]")
    private WebElement buttonOpportunityAdd;


    public OpportunitystagePage(WebDriver webDriver) {
        super(webDriver, "/opportunitystage/list");
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    @Step
    public void clickOnButtonCreate() {
       // String paretnHandle = webDriver.getWindowHandle();
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));
        actionWithOurElement.clickOnElement(buttonOpportunityAdd);
        for (String winHandle : webDriver.getWindowHandles()) {
        webDriver.switchTo().window(winHandle);
          logger.info("Focus switched to new Tab - " + webDriver.getTitle());
       }
    }
}
