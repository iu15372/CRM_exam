package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTouristPage extends ParentPage {
    WebDriverWait webDriverWait20;

    @FindBy(xpath = ".//*[@id='submit-but']/input[3]")
    private WebElement buttonNoActiveClose;


    public CreateTouristPage(WebDriver webDriver) {
        super(webDriver, "/tourist/create?oo=1&nw");
        webDriverWait20 = new WebDriverWait(webDriver, 20);

    }

    @Step
    public void clickButtonActivityClose() {
        String paretnHandle = webDriver.getWindowHandle();
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));
        actionWithOurElement.clickOnElement(buttonNoActiveClose);
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
            logger.info("Focus switched to new Tab - " + webDriver.getTitle());
        }
    }
}
