package org.example.OrderObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage {
    final static By ORDER_BUTTON_CENTERS = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]"); //Кнопка Заказать в центре страницы
    private final static By inputName = By.xpath(".//input[@placeholder='* Имя']");//Поле Имя
    private final static By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");//Поле Фамилия
    private final static By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");//Поле Адрес
    private final static By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");//Поле Метро
    private final static By inputTelephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");//Поле Телефон
    private final static By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");//Поле когда привезти самокат
    private final static By inputRent = By.className("Dropdown-control");//Поле Срок аренды
    private final static By selectCountRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");//Выпадающий список поля Срок аренды
    private final static By selectOrderColour = By.className("Order_Title__3EKne"); //Надпись блока Цвет самоката
    private final static By inputColour = By.id("black");//Чек-бокс Черный жемчуг
    private final static By inputColour2 = By.id("grey");//Серая безысходность
    private final static By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");//Поле комментарий
    private final static By ORDER_BUTTON_HEADS = By.className("Button_Button__ra12g"); //Кнопка Заказать в шапке страницы
    private final static By BUTTON_NEXT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    private final static By ORDER_BUTTON_YES = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");//Кнопка Да
    private final static By FINAL_ORDER_STATUS = By.className("Order_ModalHeader__3FDaJ");//Надпись Заказ оформлен
    private final static By FINAL_ORDER_STATUS_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка Посмотреть статус
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String text) {
        driver.findElement(inputName).sendKeys(text);
    }

    public void inputLastName(String text) {
        driver.findElement(inputLastName).sendKeys(text);
    }

    public void inputOrderAddress(String text) {
        driver.findElement(inputAddress).sendKeys(text);
    }

    public void inputOrderMetro(int n) {
        driver.findElement(inputMetro).click();
        for (int i = 0; i < n; i++) {
            driver.findElement(inputMetro).sendKeys(Keys.DOWN);
        }
        driver.findElement(inputMetro).sendKeys(Keys.ENTER);
    }

    public void inputOrderTelephone(String text) {
        driver.findElement(inputTelephone).sendKeys(text);
    }

    public void clickButtonHead() {
        driver.findElement(ORDER_BUTTON_HEADS).click();
    }

    public void inputFirstOrderPage(String name, String lastName, String address, String telephone) {
        inputName(name);
        inputLastName(lastName);
        inputOrderAddress(address);
        inputOrderMetro(3);
        inputOrderTelephone(telephone);
        clickButtonNext();
    }

    public String inputSecondOrderPage(String comment) {
        inputDates();
        inputOrderCountDate();
        inputOrderColour();
        inputComments(comment);
        clickButtonComplete();
        clickButtonCompleteYes();
        return checkFinal();
    }

    public Object inputThirdOrderPage(String comment) {
        inputDatesTwo();
        inputOrderCountDate();
        inputOrderColour();
        inputComments(comment);
        clickButtonComplete();
        clickButtonCompleteYes();
        return checkFinal();
    }

    public void inputDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный формат даты
        String date = LocalDate.now().plusDays(3).format(formatter); // получаем текущую дату, прибавляем к ней 3 дня
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(inputDate).sendKeys(Keys.ENTER);
    }

    public void inputDatesTwo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный формат даты
        String date = LocalDate.now().plusDays(10).format(formatter); // получаем текущую дату, прибавляем к ней 10 дня
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(inputDate).sendKeys(Keys.ENTER);
    }

    public void inputOrderCountDate() {
        driver.findElement(inputRent).click();
        driver.findElement(selectCountRent).click();
    }

    public void inputOrderColour() {
        driver.findElement(inputColour).click();
    }

    public void inputComments(String text) {
        driver.findElement(inputComment).sendKeys(text);
    }

    public void clickButtonNext() {
        driver.findElement(BUTTON_NEXT).click();
    }

    public void clickButtonComplete() {
        driver.findElement(ORDER_BUTTON_CENTERS).click();
    }

    public void clickButtonCompleteYes() {
        driver.findElement(ORDER_BUTTON_YES).click();
    }


    public String checkFinal() {
        if (driver.findElement(FINAL_ORDER_STATUS).isSelected()) {
            System.out.println(driver.findElement(FINAL_ORDER_STATUS).getText());
            return driver.findElement(FINAL_ORDER_STATUS).getText();
        } else {
            System.out.println("Кнопка Да: не активна");
            return "Кнопка ДА: не активна";
        }


    }
}
