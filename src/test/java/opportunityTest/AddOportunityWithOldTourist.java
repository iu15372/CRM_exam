package opportunityTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AddOportunityWithOldTourist {
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;


    private WebDriver webDriver;
    private String baseUrl;
    protected static ConfigProperties configProperties
            = ConfigFactory.create(ConfigProperties.class);

    String browser = System.getProperty("browser");

    final String firstNamey = "NewTouristt";
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


        /**
         *  поиск клиентa
         */

        webDriver.get("https://crm.poehalisnami.ua/tourist/list");  // open page "Список клиентов"
        logger.info(webDriver.getTitle());
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@key='btnDown']")));// wait
        webDriver.findElement(By.xpath(".//*[@key='btnDown']")).click();  //  расскрытие поиска
        logger.info("click to btnDown");
        webDriver.findElement(By.xpath(".//*[@placeholder='Имя']")).sendKeys(firstNamey);//ввод Имени* в поиск
        logger.info("sendKeys " + firstNamey);
        webDriver.findElement(By.xpath(".//*[@class='lupa']")).click();    //клик по Лупе
        logger.info("click to  lupa");
       // webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
         webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class=\"ui-jqgrid-btable ui-common-table\"]//tr[2]")));

        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(By.xpath(".//*[@class=\"ui-jqgrid-btable ui-common-table\"]//tr[2]")));  // вызов меню правой кнопки
        actions.build().perform();
        logger.info("click on 1-st  in table " + firstNamey);


        webDriver.findElement(By.xpath("html/body/div[9]/ul/li[1]/div")).click();  // выбор из меню правой кнопки "Редактировать туриста"
        logger.info("click RС and open new tab " + webDriver.getTitle());
        /**
         *  Этап "Выявление потребностей"
         */
        webDriver.findElement(By.xpath(".//*[@id='btnContactsCreateOpportunityNew']")).click(); // Create new  Opportunity
        logger.info("Open popup-modal Выявление потребностей");

        webDriver.findElement(By.xpath(".//*[@id='LeadInfo_ContactSourceId']/option[2]")).click();  // выбор Источник запроса*
        logger.info("Источник запроса - выбран");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        webDriver.findElement(By.xpath(".//*[@class='btn-ok']")).click();  // нажатие на кнопку "Ок"
        logger.info("OK was click and close  popup-modal 'Выявление потребностей' ");
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        /**
         *  Этап "Побдор Тура"
         */

        webDriver.findElement(By.xpath(".//*[@id='tab_opportunity']//*[@data-stage-state='2']")).click();
        logger.info("Подбор тура click");

        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        webDriver.findElement(By.xpath(".//*[@id='hotelClassList']/div/div[2]/div[1]/label/span[1]/i")).click();  // click on checkbox "Любой отель*"
        logger.info("checkbox \"Любой Отель\" click");

        webDriver.findElement(By.xpath(".//*[@id='live-search-start']")).click();
        logger.info("button Найти тур click");

        webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='live-search-data-result']/div[1]/div[1]/div[2]")));  // wait
        webDriver.findElement(By.xpath(".//*[@id='live-search-data-result']/div[1]/div[1]/div[2]")).click();
        logger.info("click on 1-st hotel");

        webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='live-search-data-result']/div[1]//div[2]//table[@class='live-search-details']//tr[2]//td//a[2]")));  // wait
        webDriver.findElement(By.xpath(".//*[@id='live-search-data-result']/div[1]//div[2]//table[@class='live-search-details']//tr[2]//td//a[2]")).click();
        logger.info("Оформить click");

        webDriver.findElement(By.xpath(".//*[@id='xtend-modal-container-ok']")).click();
        logger.info("Подтверждение действия click  OK");
        webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='communication-loader-show']"))));// wait
        /**
         *  Этап "Подписание договора"
         */
        if ( !webDriver.findElement(By.xpath("//input[contains(@id, 'StageData_IsAgreementReady')]")).isSelected() )
        {
            webDriver.findElement(By.xpath("//input[contains(@id, 'StageData_IsAgreementReady')]")).isSelected();
        }


       // webDriver.findElement(By.xpath("//input[contains(@id, 'StageData_IsAgreementReady')]")).isSelected();


        //webDriver.findElement(By.xpath(".//*[text()='Договор подписан']")).click(); //click on checkbox Договор подписан
        logger.info("checkbox \"Договор подписан\" checked ");

        webDriver.findElement(By.xpath(".//*[@id='OpportunityInfo_Prepayment']")).sendKeys("100");  // input "Сумма предоплаты"
        logger.info("\"Сумма предоплаты\" = 100 ");

        webDriver.findElement(By.xpath(".//*[@id='btnOk']")).click();  // этап "Подписание договора" пройден
        logger.info("click on btn \"OK\" in \'Подписание договора\' ");


    }

    @After


    public void tearDown() {
        webDriver.quit();
    }
}
