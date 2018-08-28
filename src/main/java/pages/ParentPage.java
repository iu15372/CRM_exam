package pages;

import io.qameta.allure.Step;
import libs.ActionWithOurElement;
import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tabel Anastasia
 * @ParentPage - parent class for all pages
 */
public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;

    ActionWithOurElement actionWithOurElement;
    Utils utils;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionWithOurElement = new ActionWithOurElement(webDriver);
        utils = new Utils();
    }

    /**
     * @Metod getCurrentUrl - return the address of the current page
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * @Metod cheekCurrentUrl - we compare the well-known Url with what is needed
     */
    @Step
    public void cheekCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expect ", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Cannot work with Url ");
            Assert.fail("Cannot work with Url ");
        }
    }

}
