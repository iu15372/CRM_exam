package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Tabel Anastasia
 * @ActionWithOurElement - класс с действиями со всеми Элементами
 * @Metod enterTextToElement - метод для ввода текста
 * @Metod clickOnElement - метод для клика по WebElement/xPathLocator
 * @Metod isElementDisplay - метод проверки показывается ли элемент
 * @printErrorAndStopTes - метод для вывода ошибки и остановки теста
 * @isElementInList - метод для поиска в списке нужного поля
 * @selectValueInDD - метод для выбора элемента из DD
 */
public class ActionWithOurElement {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;

    public ActionWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(String xPathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplay(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is display - > " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display - > false");
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Connot work with element " + e);
        Assert.fail("Connot work with element " + e);
    }

    public boolean isElementInList(String xPathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xPathLocator));
            if (webElementList.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);  //он сразу выберит нужный элемент
            logger.info(value + " was select in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

}
