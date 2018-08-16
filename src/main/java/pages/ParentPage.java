package pages;

import libs.ActionWithOurElement;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
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

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;

    ActionWithOurElement actionWithOurElement;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionWithOurElement = new ActionWithOurElement(webDriver);
    }

    /**
     * @Metod getCurrentUrl - возвращение адресса текущей страницы
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * @Metod cheekCurrentUrl - будем сравнивать известный Url с  тем что нужен
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
