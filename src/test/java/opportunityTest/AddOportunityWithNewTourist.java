package opportunityTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class AddOportunityWithNewTourist {
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;

    private WebDriver webDriver;
    private String baseUrl;
    protected static ConfigProperties configProperties
            = ConfigFactory.create(ConfigProperties.class);

    String browser = System.getProperty("browser");

    final String firstNamey = "NewTourist";
    final String leadInfoPhone = "0351";


    @Before
    public void setUp() throws Exception {
        baseUrl = "https://crm.poehalisnami.ua";

        logger.info("Chrome will be started");
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Chrome is started");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriverWait20 = new WebDriverWait(webDriver, 20);


    }

    /**
     * @throws IOException
     * @userValidLogInExcel(_,_) "login_R.O","pass_R.O"  - руководитель офиса
     * "login_Men","pass_Men"  - менеджер
     */
    @Test
    public void addNewOportunityWithNewTourist() throws IOException {

        webDriver.get("https://crm.poehalisnami.ua/tourist/create?oo=1&nw");
        webDriver.findElement(By.xpath(".//*[@id='Login']")).sendKeys("тестировщик");
        webDriver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("111");
        webDriver.findElement(By.xpath(".//*[@id='signin_submit']")).click();

        webDriver.get("https://crm.poehalisnami.ua/tourist/create?oo=1&nw");
        // Этап "Выявление потребностей"
        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_FirstName']")).sendKeys(firstNamey);  // ввод Имени*


        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hhMMss");
        System.out.println("Текущие время: " + time);

        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_Phone']")).sendKeys(leadInfoPhone + time);  //ввод Телефон*
        logger.info(leadInfoPhone + time + " was inputted into element");

        webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='LeadInfo_ContactSexId']/option[2]")));  // wait
        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_ContactSexId']/option[2]")).click();  // выбор Пол*
        logger.info("Пол выбран");

        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_ContactSourceId']/option[2]")).click();  // выбор Источник запроса*
        logger.info("Источник запроса - выбран");


        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        webDriver.findElement(By.xpath(".//*[@class='btn-ok']")).click();  // нажатие на кнопку "Ок"
        logger.info("OK was click");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        logger.info(webDriver.getTitle());


        // Этап "Подбор тура"
        webDriver.findElement(By.xpath(".//*[@id='tab_opportunity']//*[@data-stage-state='2']")).click();
        logger.info("Подбор тура click");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        webDriver.findElement(By.xpath(".//*[@id='hotelClassList']/div/div[2]/div[1]/label/span[1]/i")).click();
        logger.info("isSelected Любой Отель click");

        webDriver.findElement(By.xpath(".//*[@id='live-search-start']")).click();
        logger.info("button Найти тур click");

        webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='live-search-data-result']/div[1]/div[1]/div[2]")));  // wait
        webDriver.findElement(By.xpath(".//*[@id='live-search-data-result']/div[1]/div[1]/div[2]")).click();
        logger.info("click on 1-st hotel");

        webDriver.findElement(By.xpath(".//*[@id='live-search-data-result']/div[1]//div[2]//table[@class='live-search-details']//tr[2]//td//a[2]")).click();
        logger.info("Оформить click");

        webDriver.findElement(By.xpath(".//*[@id='xtend-modal-container-ok']")).click();
        logger.info("Подтверждение действия click  OK");



        // Этап "Подписание договора"










//        // Delete tourist param - firstName
//        webDriver.get("https://crm.poehalisnami.ua/tourist/list");
//        logger.info("baseUrl open");
//
//        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait
//        webDriver.findElement(By.xpath(".//*[text()='" + firstNamey + "']")).click();
//        logger.info(firstNamey + " click");
//        webDriver.findElement(By.xpath(".//*[@id='btnContactDelete']")).click();
//        logger.info("Delete  click");
//
//        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait
//        logger.info(webDriver.getTitle());
//
//        webDriver.findElement(By.xpath(".//*[@id='submit-but']/input[@value='Да']")).click();  // это не аллерт!!! (подтверждение удаления туриста)
//        logger.info("Delete  OK");
//
//        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait

    }

    @After


    public void tearDown() {
        // Delete tourist param - firstName
        webDriver.get("https://crm.poehalisnami.ua/tourist/list");
        logger.info("baseUrl open");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait
        webDriver.findElement(By.xpath(".//*[text()='" + firstNamey + "']")).click();
        logger.info(firstNamey + " click");
        webDriver.findElement(By.xpath(".//*[@id='btnContactDelete']")).click();
        logger.info("Delete  click");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait
        logger.info(webDriver.getTitle());

        webDriver.findElement(By.xpath(".//*[@id='submit-but']/input[@value='Да']")).click();  // это не аллерт!!! (подтверждение удаления туриста)
        logger.info("Delete  OK");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait



        webDriver.quit();
    }


}


