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
 */
public class ActionWithOurElement {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;

    public ActionWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    /**
     * @param webElement
     * @param text
     * @Metod enterTextToElement - метод для ввода текста
     */
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

    /**
     * @param webElement
     * @Metod clickOnElement - метод для клика по WebElement
     */
    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * @param xPathLocator
     * @Metod clickOnElement - метод для клика по xPathLocator
     */
    public void clickOnElement(String xPathLocator) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * @param webElement
     * @return
     * @Metod isElementDisplay - метод проверки показывается ли Вєб-элемент
     */
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

    /**
     * @param e
     * @Metod printErrorAndStopTes - метод для вывода ошибки и остановки теста
     */
    private void printErrorAndStopTest(Exception e) {
        logger.error("Connot work with element " + e);
        Assert.fail("Connot work with element " + e);
    }

    /**
     * @param xPathLocator
     * @return
     * @Metod isElementInList - метод для поиска в списке нужного поля
     */
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

    /**
     * @param dropDownElement
     * @param value
     * @Metod selectValueInDD - выбора элемента из DD
     */
    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);  //он сразу выберит нужный элемент
            logger.info(value + " was select in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * @param webElement
     * @param neededState
     * @Metod setNeedeStateToCheckBox  - "check" or "uncheck"   CheckBox
     */
    public void setNeedeStateToCheckBox(WebElement webElement, String neededState) {
        if ("check".equals(neededState) || "uncheck".equals(neededState)) {
            if (webElement.isSelected() && "check".equals(neededState)) {   // webElement is check
                logger.info("CheckBox is olready checked");
            } else if (webElement.isSelected() && "uncheck".equals(neededState)) {// webElement isn`t check
                clickOnElement(webElement);
                logger.info("CheckBox is checked");
            } else if (webElement.isSelected() && "uncheck".equals(neededState)) {   // webElement is uncheck
                logger.info("CheckBox is olready uncheck");
            } else if (webElement.isSelected() && "check".equals(neededState)) {// webElement isn`t uncheck
                clickOnElement(webElement);
                logger.info("CheckBox is uncheck");
            }
        } else {
            logger.error(String.format("%s - is not expected state", neededState));
            Assert.fail(String.format("%s - is not expected state", neededState));
        }
    }


}
