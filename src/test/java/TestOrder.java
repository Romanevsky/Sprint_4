import ru.practicum.qascooter.HeadPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.practicum.qascooter.OrderPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestOrder {
    private final String name;
    private final String lastName;
    private final String street;
    private final String telephone;
    private final String comment;
    private WebDriver driver;

    public TestOrder(String name, String lastName, String street, String telephone, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.telephone = telephone;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Проверка полей: {0} {1} {2} {3} {4}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Роман", "Владимиров", "Первая", "79999999999", "пав"},
                {"Игорь", "Михалычев", "Улица-Сутулица", "78889990033", "парам-пам-пам"},
                {"gfdsf", "fdsfs", "fdsfsd", "7489348973429837d", "#$#$#///."} //Негативная проверка
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "Users\\valiulin.r\\WebDriver\\bin");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HeadPage headPage = new HeadPage(driver);
        headPage.open();
        headPage.clickCookButton();
    }

    @Test
    public void orderTests() {        //Тестирование формы заказа через кнопку Заказать в шапке страницы
        HeadPage headPage = new HeadPage(driver);
        headPage.clickHeadOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstOrderPage(name, lastName, street, telephone);
        assertEquals("Заказ оформлен", orderPage.inputSecondOrderPage(comment), orderPage.checkFinal());
    }

    @Test
    public void orderTestsTwo() {  //Тестирование формы заказа через кнопку Заказать в центре страницы
        HeadPage headPage = new HeadPage(driver);
        headPage.scrollDownTwo();
        HeadPage.clickCentrOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstOrderPage(name, lastName, street, telephone);
        assertEquals("Заказ оформлен", orderPage.inputThirdOrderPage(comment), orderPage.checkFinal());
    }

    @After
    public void theEnd() {
        driver.quit();
    }
}
