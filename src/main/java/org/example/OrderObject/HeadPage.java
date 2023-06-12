package org.example.OrderObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HeadPage {
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/"; //Страница
    private final static By ORDER_BUTTON_HEAD = By.className("Button_Button__ra12g"); //Кнопка заказать в шапке страницы
    private final static By ORDER_BUTTON_CENTR = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"); //Кнопка Заказать в центре страницы
    private final static By ORDER_BUTTON_STATUS = By.className("Header_Link__1TAG7"); //Кнопка статус заказа
    private final static By BUTTON_GO = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button");//Кнопка GO
    private final static By INPUT_NUMBER_ORDER = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/div/input");//Поле Введите номер заказа
    private final static By COOKS_BUTTON = By.id("rcc-confirm-button");//Кнопка принять Куки
    private final static By IMPORTANT = By.className("Home_SubHeader__zwi_E"); //Надпись Вопросы о важном
    private final static By yandexLogo = By.className("Header_LogoYandex__3TSOI"); //Логотип Яндекс
    private final static By notFound = By.xpath("/html/body/div/div/div[2]/div[2]/img[@alt='Not found']");
    private final static By scooterLogo = By.className("Header_LogoScooter__3lsAR");//Логотип самоката
    //Блок вопросов
    private final static By QUESTIONS_BLOCKS_0 = By.id("accordion__heading-0"); //Вопрос 1 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_1 = By.id("accordion__heading-1");//Вопрос 2 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_2 = By.id("accordion__heading-2");//Вопрос 3 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_3 = By.id("accordion__heading-3");//Вопрос 4 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_4 = By.id("accordion__heading-4");//Вопрос 5 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_5 = By.id("accordion__heading-5");//Вопрос 6 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_6 = By.id("accordion__heading-6");//Вопрос 7 блока Вопросы о важном
    private final static By QUESTIONS_BLOCKS_7 = By.id("accordion__heading-7");//Вопрос 8 блока Вопросы о важном
    //Блок ответов
    private final static By RESPONSE_TEXT_0 = By.id("accordion__panel-0");//Ответ 1 блока Вопросы о важном
    private final static By RESPONSE_TEXT_1 = By.id("accordion__panel-1");//Ответ 2 блока Вопросы о важном
    private final static By RESPONSE_TEXT_2 = By.id("accordion__panel-2");//Ответ 3 блока Вопросы о важном
    private final static By RESPONSE_TEXT_3 = By.id("accordion__panel-3");//Ответ 4 блока Вопросы о важном
    private final static By RESPONSE_TEXT_4 = By.id("accordion__panel-4");//Ответ 5 блока Вопросы о важном
    private final static By RESPONSE_TEXT_5 = By.id("accordion__panel-5");//Ответ 6 блока Вопросы о важном
    private final static By RESPONSE_TEXT_6 = By.id("accordion__panel-6");//Ответ 7 блока Вопросы о важном
    private final static By RESPONSE_TEXT_7 = By.id("accordion__panel-7");//Ответ 8 блока Вопросы о важном
    private static WebDriver driver;

    public HeadPage(WebDriver driver) {
        HeadPage.driver = driver;
    }

    public static void scrollDownTwo() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ORDER_BUTTON_CENTR));
    }

    public static void clickHeadOrderButton() {
        driver.findElement(ORDER_BUTTON_HEAD).click();
    }

    public static void clickCentrOrderButton() {
        driver.findElement(ORDER_BUTTON_CENTR).click();
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void scrollDownOne() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(IMPORTANT));
    }

    public void clickOrderStatusButton() {
        driver.findElement(ORDER_BUTTON_STATUS).click();
    }

    public void clickCookButton() {
        driver.findElement(COOKS_BUTTON).click();
    }
    //Клики на вопросы

    public void clickElement0() {
        driver.findElement(QUESTIONS_BLOCKS_0).click();
    }

    public void clickElement1() {
        driver.findElement(QUESTIONS_BLOCKS_1).click();
    }

    public void clickElement2() {
        driver.findElement(QUESTIONS_BLOCKS_2).click();
    }

    public void clickElement3() {
        driver.findElement(QUESTIONS_BLOCKS_3).click();
    }

    public void clickElement4() {
        driver.findElement(QUESTIONS_BLOCKS_4).click();
    }

    public void clickElement5() {
        driver.findElement(QUESTIONS_BLOCKS_5).click();
    }

    public void clickElement6() {
        driver.findElement(QUESTIONS_BLOCKS_6).click();
    }

    public void clickElement7() {
        driver.findElement(QUESTIONS_BLOCKS_7).click();
    }

    //Клики на ответы
    public String getText0() {
        return driver.findElement(RESPONSE_TEXT_0).getText();
    }

    public String getText1() {
        return driver.findElement(RESPONSE_TEXT_1).getText();
    }

    public String getText2() {
        return driver.findElement(RESPONSE_TEXT_2).getText();
    }

    public String getText3() {
        return driver.findElement(RESPONSE_TEXT_3).getText();
    }

    public String getText4() {
        return driver.findElement(RESPONSE_TEXT_4).getText();
    }

    public String getText5() {
        return driver.findElement(RESPONSE_TEXT_5).getText();
    }

    public String getText6() {
        return driver.findElement(RESPONSE_TEXT_6).getText();
    }

    public String getText7() {
        return driver.findElement(RESPONSE_TEXT_7).getText();
    }

    public void setYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void inputOrderStatus(String text) {
        driver.findElement(INPUT_NUMBER_ORDER).sendKeys(text);
    }

    public void clickOrderStatus() {
        driver.findElement(INPUT_NUMBER_ORDER).click();
    }

    public void clickGo() {
        driver.findElement(BUTTON_GO).click();
    }

    public String getNotFound() {
        return driver.findElement(notFound).getText();
    }

    public void setNotFound(String numberOrder) {
        clickOrderStatus();
        inputOrderStatus(numberOrder);
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }
}