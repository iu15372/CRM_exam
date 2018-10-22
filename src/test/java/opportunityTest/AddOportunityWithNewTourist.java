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
        logger.info(leadInfoPhone+time+ " was inputted into element");

        webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='LeadInfo_ContactSexId']/option[2]")));  // wait
        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_ContactSexId']/option[2]")).click();  // выбор Пол*
        logger.info("Пол выбран" + " isDisplayed and click");

        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_ContactSourceId']/option[2]")).click();  // выбор Источник запроса*
        logger.info("Источник запроса - выбран" + " isDisplayed and click");

        webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='btn-ok']"))); // wait
        webDriver.findElement(By.xpath(".//*[@class='btn-ok']")).click();  // нажатие на кнопку "Ок"
        logger.info("submit-but" + " was click");


        // Delete tourist param - firstName
        webDriver.get("https://crm.poehalisnami.ua/tourist/list");
        logger.info("baseUrl");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait
        webDriver.findElement(By.xpath(".//*[text()='NewTourist']")).click();
        logger.info("NewTourist click");
        webDriver.findElement(By.xpath(".//*[@id='btnContactDelete']")).click();
        logger.info("Delete  click");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait
        logger.info(webDriver.getTitle());

        webDriver.findElement(By.xpath(".//*[@id='submit-but']/input[@value='Да']")).click();  // это не аллерт!!! (подтверждение удаления туриста)
        logger.info("Delete  OK");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='loading ui-state-default ui-state-active']"))));  // wait

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }



}


