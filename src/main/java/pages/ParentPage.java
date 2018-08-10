package pages;

import libs.ActionWithOurElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tabel Anastasia
 * @ParentPage - родительский класс для все страниц
 */
public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "https://crm.poehalisnami.ua/User/Login?ReturnUrl=%2f";
    ActionWithOurElement actionWithOurElement;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionWithOurElement = new ActionWithOurElement(webDriver);
    }

    /**
     * @getCurrentUrl - метод который возвращает адресс страницы
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * @cheekCurrentUrl - метод который будет сравнивать известный Url с  тем что нужен
     */
    public void cheekCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expect ", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Cannot work with Url ");
            Assert.fail("Cannot work with Url ");
        }
    }

}
