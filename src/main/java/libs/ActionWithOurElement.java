package libs;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    @Step
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
    @Step
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
    @Step
    public void clickOnElement(String xPathLocator) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathLocator)));
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
            logger.info("Element was clicked ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * @param webElement
     * @return
     * @Metod isElementDisplay - метод проверки показывается ли Вєб-элемент
     */
    @Step
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
    @Step
    private void printErrorAndStopTest(Exception e) {
        logger.error("Connot work with element " + e);
        Assert.fail("Connot work with element " + e);
    }

    /**
     * @param xPathLocator
     * @return
     * @Metod isElementInList - метод для поиска в списке нужного поля
     */
    @Step
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
    @Step
    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOf(dropDownElement));
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
    @Step
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

    /**
     * @param webElement
     * @Metod rightClick  for click right button to String
     */
    @Step
    public void rightClick(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            Actions actions = new Actions(webDriver);
            actions.contextClick(webElement);
            actions.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + webElement + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + webElement + " was not clickable "
                    + e.getStackTrace());
        }
    }

    /**
     * @param nameString
     * @Metod rightClick  for click right button to String
     */
    @Step
    public void rightClick(String nameString) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*//td[text()='" + nameString + "']")));
            Actions actions = new Actions(webDriver);
            actions.contextClick(webDriver.findElement(By.xpath(".//*//td[text()='" + nameString + "']")));
            actions.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + nameString + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + nameString + " was not clickable "
                    + e.getStackTrace());
        }
    }

    /**
     * @Metod clearDate  - manual change date
     * @param webElement
     * @param text
     */
    @Step
    public void clearDate(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element Date");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }




}
